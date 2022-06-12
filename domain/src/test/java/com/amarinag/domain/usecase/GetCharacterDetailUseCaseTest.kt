package com.amarinag.domain.usecase

import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Character
import com.amarinag.data.repository.CharacterRepository
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
class GetCharacterDetailUseCaseTest {
    private val testDispatcher = UnconfinedTestDispatcher()

    @MockK
    private lateinit var characterRepository: CharacterRepository
    private val appDispatchers = AppDispatchers(testDispatcher, testDispatcher, testDispatcher)

    private lateinit var getCharacterDetailUseCase: GetCharacterDetailUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        getCharacterDetailUseCase = GetCharacterDetailUseCase(appDispatchers, characterRepository)
    }

    @Test
    fun `check that usecase call getCharacterById from Repository`() = runTest {
        val character = Character(
            1,
            "Rick",
            "species",
            "type",
            "imageUrl",
            "locationName",
            "locationUrl",
            emptyList()
        )
        coEvery { characterRepository.getCharacterById(any()) } returns Result.success(character)

        val response = getCharacterDetailUseCase.invoke(1)

        coVerify(exactly = 1) { characterRepository.getCharacterById(any()) }

        assertThat(response).isInstanceOf(Result::class.java)
        assertThat(response.isSuccess).isTrue()
        assertThat(response.getOrNull()).isEqualTo(character)
    }
}