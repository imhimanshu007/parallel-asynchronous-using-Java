package org.javalearning.completablefuture;

import org.javalearning.service.HelloWorldService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

class CompletableFutureHelloWorldTest {

    HelloWorldService helloWorldService = new HelloWorldService();
    CompletableFutureHelloWorld completableFutureHelloWorld = new CompletableFutureHelloWorld(helloWorldService);

    @Test
    void helloWorld() {

        //given

        //when
        CompletableFuture<String> completableFuture = completableFutureHelloWorld.helloWorld();

        //then
        completableFuture.thenAccept(s -> assertEquals("HELLO WORLD", s)).join();

    }

    @Test
    void helloWorld_withSize() {
        //given

        //when
        CompletableFuture<String> completableFuture = completableFutureHelloWorld.helloWorld_withSize();
        completableFuture.thenAccept(s -> assertEquals("11 - HELLO WORLD", s)).join();
    }

    @Test
    void helloWorld_multiple_async_calls(){
        String result = completableFutureHelloWorld.helloWorld_multiple_async_calls();
        assertEquals("HELLOWORLD", result);
    }
}