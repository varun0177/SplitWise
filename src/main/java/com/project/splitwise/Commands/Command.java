package com.project.splitwise.Commands;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface Command {
    boolean matches(String input);
    void execute(String input);
     default String getCommand(String input){
        return getTokens(input).get(0);
    }

    default List<String> getTokens(String input){

         return Arrays.stream(input.split(" ")).toList();
    }
}
