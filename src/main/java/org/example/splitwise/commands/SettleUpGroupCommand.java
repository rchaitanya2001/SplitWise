package org.example.splitwise.commands;



import org.example.splitwise.Controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettleUpGroupCommand implements Command {
    @Autowired
    private UserController userController;
    @Override
    public void execute(String input) {
        // u1 settleUpGroup g1
        String[] s = input.split(" ");
        Long groupId = Long.parseLong(s[2]);
        userController.settleUpGroup(groupId);
    }

    @Override
    public boolean matches(String input) {
        String[] s = input.split(" ");
        return s[1].equalsIgnoreCase("settleUpGroup");
    }
}