package com.project.splitwise;

import com.project.splitwise.Commands.*;
import com.project.splitwise.dtos.CreateGroupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner {
    private Scanner scanner;
    private CommandExecutor commandExecutor;
    @Autowired
    public SplitwiseApplication(CommandExecutor commandExecutor, CreateGroupCommand command, CreateUserCommand command2, CreateExpenseCommand command3,AddUserExpenseCommand command4){
        this.scanner=new Scanner(System.in);
        this.commandExecutor=commandExecutor;
        this.commandExecutor.addCommand(command);
        this.commandExecutor.addCommand(command2);
        this.commandExecutor.addCommand(command3);
        this.commandExecutor.addCommand(command4);
    }
    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            System.out.println("Enter input :");
            String input=scanner.nextLine();
            commandExecutor.execute(input);
        }
    }
}
