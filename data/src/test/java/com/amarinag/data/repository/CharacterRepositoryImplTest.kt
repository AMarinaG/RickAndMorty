package com.amarinag.data.repository

import com.amarinag.data.source.CharacterRemoteDataSource
import com.amarinag.domain.AppDispatchers
import com.amarinag.sharedtest.mockCharacterMorty
import com.amarinag.sharedtest.mockCharacterRick
import com.amarinag.sharedtest.mockCharacters
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterRepositoryImplTest {
    private val testDispatcher = UnconfinedTestDispatcher()

    @MockK
    private lateinit var characterRemoteDataSource: CharacterRemoteDataSource
    private val appDispatchers: AppDispatchers =
        AppDispatchers(testDispatcher, testDispatcher, testDispatcher)
    private lateinit var characterRepository: CharacterRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        characterRepository = CharacterRepositoryImpl(appDispatchers, characterRemoteDataSource)
    }

    @Test
    fun `send getAll and received success`() = runTest {
        coEvery { characterRemoteDataSource.getCharacter() } returns Result.success(emptyList())

        val response = characterRepository.getAll()

        coVerify(exactly = 1) { characterRemoteDataSource.getCharacter() }

        assertThat(response.isSuccess).isTrue()
    }

    @Test
    fun `call getCharacterById and response success`() = runTest {
        coEvery { characterRemoteDataSource.getCharacterById(any()) } returns Result.success(
            mockCharacterRick
        )

        val response = characterRepository.getCharacterById(5)

        coVerify(exactly = 1) { characterRemoteDataSource.getCharacterById(any()) }

        assertThat(response.isSuccess).isTrue()
        assertThat(response.getOrNull()).isEqualTo(mockCharacterRick)
    }

    @Test
    fun findMatchCharacter() = runTest {
        coEvery { characterRemoteDataSource.getCharacter().getOrNull() } returns mockCharacters

        val response = characterRepository.findMatchCharacter(mockCharacterRick)

        coVerify(exactly = 1) { characterRemoteDataSource.getCharacter() }

        assertThat(response.isSuccess).isTrue()
        val responseMatched = response.getOrNull()
        assertThat(responseMatched).isNotNull()
        assertThat(responseMatched).isEqualTo(mockCharacterMorty)

    }
}