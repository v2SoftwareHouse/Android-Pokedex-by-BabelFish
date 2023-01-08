package com.v2.babelfish.pokedex.feature.chainusecase.business

import com.nhaarman.mockitokotlin2.argThat
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GETBulbasaurUseCaseTest {
    private val param = null
    private lateinit var useCase: GETBulbasaurUseCase
    private lateinit var repo: ChainUseCaseRepository

    @Before
    fun setup() {
        repo = mock()
        useCase = Mockito.spy(GETBulbasaurUseCase(repo))
    }

    @Test
    fun `when allowed by guard, then call onSuccess function`() {
        useCase.process(param)
        verify(useCase, times(1)).onResult(argThat { this.isSuccess() })
    }

    @Test
    fun `when denied by guard, then call onGuardError function`() {
        val exception = RuntimeException()
        whenever(useCase.guard(eq(param))).thenThrow(exception)

        useCase.process(param)

        verify(useCase, times(1)).onResult(argThat { this.isError() })
    }

    @Test
    fun `when guard throws error, then call onError function`() {
        val exception = RuntimeException()
        whenever(useCase.guard(eq(param))).thenThrow(exception)

        useCase.process(param)

        verify(useCase, times(1)).onError(eq(exception))
        verify(useCase, times(0)).onResult(argThat { this.isSuccess() })
    }

    @Test
    fun `when execute throws error, then call onError function`() {
        val exception = RuntimeException()
        whenever(useCase.execute(eq(param))).thenThrow(exception)

        useCase.process(param)

        verify(useCase, times(1)).onError(eq(exception))
        verify(useCase, times(0)).onResult(argThat { this.isSuccess() })
    }
}