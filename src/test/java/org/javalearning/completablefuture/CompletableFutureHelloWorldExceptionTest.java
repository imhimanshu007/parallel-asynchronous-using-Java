package org.javalearning.completablefuture;

import org.javalearning.service.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CompletableFutureHelloWorldExceptionTest {

    @Mock
    HelloWorldService helloWorldService = mock(HelloWorldService.class);

    @InjectMocks
    CompletableFutureHelloWorldException completableFutureHelloWorldException;

    @Test
    void helloWorld_3_async_calls_Handle() {
        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        //when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Handle();

        //then
        assertEquals("WORLD THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_Handle_2() {
        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenThrow(new RuntimeException("Exception Occurred"));

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Handle();

        //then
        assertEquals(" THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_Handle_3() {
        //given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenThrow(new RuntimeException("Exception Occurred"));

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Handle();

        //then
        assertEquals(" THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_Handle_4() {
        //given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Handle();

        //then
        assertEquals("HELLOWORLD THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_Exceptionally(){
        //given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Exceptionally();

        //then
        assertEquals("HELLOWORLD THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_Exceptionally_1(){
        //given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Exceptionally();

        //then
        assertEquals("HELLOWORLD THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_Exceptionally_2(){
        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenThrow(new RuntimeException("Exception Occurred"));

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Exceptionally();

        //then
        assertEquals(" THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_Exceptionally_3(){
        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Exceptionally();

        //then
        assertEquals("WORLD THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_Exceptionally_4(){
        //given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenThrow(new RuntimeException("Exception Occurred"));

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_Exceptionally();

        //then
        assertEquals(" THIRD COMPLETABLE FUTURE CALL", result);
    }

    @Test
    void helloWorld_3_async_calls_whenComplete(){
        //given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_whenComplete();

        //then
        String expectedResult = "HELLOWORLD THIRD COMPLETABLE FUTURE CALL";
        assertEquals(expectedResult, result);
    }

    @Test
    void helloWorld_3_async_calls_whenComplete_1(){
        //given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Exception Occurred"));
        when(helloWorldService.world()).thenCallRealMethod();

        //when
        String result = completableFutureHelloWorldException.helloWorld_3_async_calls_whenComplete();

        //then
        String expectedResult = " THIRD COMPLETABLE FUTURE CALL";
        assertEquals(expectedResult, result);
    }


}