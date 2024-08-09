package com.project.splitwise.Commands;

import com.project.splitwise.controller.ExpenseController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SettleUpCommand implements Command{
    private ExpenseController expenseController;
    @Override
    public boolean matches(String input) {
        return getCommand(input).equals(Commands.SETTLE_UP_COMMAND);
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing settle command");
        List<String> tokens=getTokens(input);
    }
}
