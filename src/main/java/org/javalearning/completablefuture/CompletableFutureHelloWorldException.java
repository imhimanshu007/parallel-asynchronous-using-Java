package org.javalearning.completablefuture;

import org.javalearning.service.HelloWorldService;
import org.javalearning.util.CommonUtil;
import org.javalearning.util.LoggerUtil;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureHelloWorldException {
    private final HelloWorldService helloWorldService;

    public CompletableFutureHelloWorldException(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public String helloWorld_3_async_calls_Handle(){

        CommonUtil.startTimer();

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(this.helloWorldService::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(this.helloWorldService::world);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtil.delay(1000);
            return " Third Completable Future Call";
        });

        String helloWorld = hello
                .handle((result, exception) -> { // this gets invoked for both success and failure
                    LoggerUtil.log("Result is " + result);
                    if(exception != null){
                        LoggerUtil.log("Exception is : " +exception.getMessage());
                        return "";
                    }
                    return result;
                })
                .thenCombine(world, (h,w) -> h + w)
                .handle((result, exception) -> { // this gets invoked for both success and failure
                    LoggerUtil.log("Result is " + result);
                    if(exception != null){
                        LoggerUtil.log("Exception after world is : " +exception.getMessage());
                        return "";
                    }
                    return result;
                })
                .thenCombine(completableFuture, (previous, current) -> previous + current)
                .thenApply(String::toUpperCase)
                .join();

        CommonUtil.timeTaken();

        return helloWorld;
    }

    public String helloWorld_3_async_calls_Exceptionally(){

        CommonUtil.startTimer();

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(this.helloWorldService::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(this.helloWorldService::world);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtil.delay(1000);
            return " Third Completable Future Call";
        });

        String helloWorld = hello
                .exceptionally(exception -> {
                        LoggerUtil.log("Exception is : " +exception.getMessage());
                        return "";
                })
                .thenCombine(world, (h,w) -> h + w)
                .exceptionally(exception -> {
                        LoggerUtil.log("Exception after world is : " +exception.getMessage());
                        return "";
                })
                .thenCombine(completableFuture, (previous, current) -> previous + current)
                .thenApply(String::toUpperCase)
                .join();

        CommonUtil.timeTaken();

        return helloWorld;
    }

    public String helloWorld_3_async_calls_whenComplete(){

        CommonUtil.startTimer();

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(this.helloWorldService::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(this.helloWorldService::world);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtil.delay(1000);
            return " Third Completable Future Call";
        });

        String helloWorld = hello
                .whenComplete((result, exception) -> { // this gets invoked for both success and failure
                    LoggerUtil.log("Result is " + result);
                    if(exception != null){
                        LoggerUtil.log("Exception is : " +exception.getMessage());
                    }
                })
                .thenCombine(world, (h,w) -> h + w)
                .whenComplete((result, exception) -> { // this gets invoked for both success and failure
                    LoggerUtil.log("Result is " + result);
                    if(exception != null){
                        LoggerUtil.log("Exception after world is : " +exception.getMessage());
                    }
                })
                .exceptionally(exception -> {
                    LoggerUtil.log("Exception is : " + exception.getMessage());
                    return "";
                })
                .thenCombine(completableFuture, (previous, current) -> previous + current)
                .thenApply(String::toUpperCase)
                .join();

        CommonUtil.timeTaken();

        return helloWorld;
    }
}
