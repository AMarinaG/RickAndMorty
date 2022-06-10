package com.amarinag.domain.usecase

import com.amarinag.domain.AppDispatchers
import com.amarinag.domain.model.Character
import com.amarinag.domain.repository.CharacterRepository
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
class GetCharactersUseCaseTest {
    private val testDispatcher = UnconfinedTestDispatcher()

    @MockK
    private lateinit var characterRepository: CharacterRepository
    private val appDispatchers = AppDispatchers(testDispatcher, testDispatcher, testDispatcher)

    private lateinit var getCharactersUseCase: GetCharactersUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        getCharactersUseCase = GetCharactersUseCase(appDispatchers, characterRepository)
    }

    @Test
    fun `check that usecase call invoke getAll`() = runTest {
        coEvery { characterRepository.getAll() } returns Result.success(emptyList())

        getCharactersUseCase.invoke()

        coVerify(exactly = 1) { characterRepository.getAll() }
    }
}