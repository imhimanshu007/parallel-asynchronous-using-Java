package org.javalearning.parallestreams;

import org.javalearning.util.CommonUtil;
import org.javalearning.util.DataSet;
import org.javalearning.util.LoggerUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamsExample {

    public List<String> stringTransformWithStream(List<String> namesList){
        return namesList
                .stream()
                .map(this::transform)
                .collect(Collectors.toList());
    }

    public List<String> stringTransformWithParallelStream(List<String> nameList){
        return nameList.parallelStream()
                .map(this::transform)
                .collect(Collectors.toList());
    }

    public List<String> stringTransformWithSequentialAndParallel(List<String> namesList, boolean isParallel){
        Stream<String> namesStream = namesList.stream();

        if(isParallel)
            namesStream.parallel();

        return namesStream.map(this::transform).collect(Collectors.toList());

    }

    public List<String> string_toLowerCase(List<String> namesList){
        return namesList
                .parallelStream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    private String transform(String name) {
        CommonUtil.delay(500);
        return name.length() + " - " + name;
    }
    public static void main(String[] args) {

        CommonUtil.startTimer();
        List<String> namesList = DataSet.namesList();
        ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();

        List<String> resultList = parallelStreamsExample.stringTransformWithStream(namesList);
        List<String> resultList1 = parallelStreamsExample.stringTransformWithParallelStream(namesList);

        CommonUtil.timeTaken();

        LoggerUtil.log("resultList : " + resultList1);
    }
}
