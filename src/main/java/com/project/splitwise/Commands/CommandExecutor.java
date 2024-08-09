package com.project.splitwise.Commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommandExecutor {
    public List<Command> commands=new ArrayList<>();
    public void addCommand(Command command){
        commands.add(command);
    }
    public void addCommands(List<Command> commands){
        commands.addAll(commands);
    }
    public void deleteCommand(Command command){
        commands.remove(command);
    }
    public void execute(String input){
        for(Command command: commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
        return;
    }
}
