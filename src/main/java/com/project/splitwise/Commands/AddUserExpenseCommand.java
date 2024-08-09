package com.project.splitwise.Commands;

import com.project.splitwise.controller.ExpenseController;
import com.project.splitwise.dtos.CreateUserExperienceRequest;
import com.project.splitwise.models.ExpenseType;
import com.project.splitwise.models.UserExpense;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AddUserExpenseCommand implements Command{
    @Autowired
    private ExpenseController expenseController;
    @Override
    public boolean matches(String input) {
        String command=getCommand(input);
        if(!command.equals(Commands.ADD_USER_EXPERIENCE)){
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create expense command");
        List<String> tokens=getTokens(input);
        CreateUserExperienceRequest request=CreateUserExperienceRequest.builder()
                .expenseId(Long.valueOf(tokens.get(1)))
                .userId(Long.valueOf(tokens.get(2)))
                .amount(Double.valueOf(tokens.get(3)))
                .type(ExpenseType.valueOf(tokens.get(4)))
                .build();
        UserExpense expense=expenseController.addUserExpense(request);
        System.out.println("Created expense with id"+expense.getId());
    }
}
