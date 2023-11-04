package lk.ijse.spring.controller;

import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.UserUtil;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseUtil getUser(@RequestParam String username, @RequestParam String password) {

        return new ResponseUtil("OK", "Successfully Loaded..!", userService.getUser(username, password));

    }

    @GetMapping
    public ResponseUtil getCurrentUserDetails() {
        System.out.println(UserUtil.currentUser);

        return new ResponseUtil("OK", "Successfully Loaded..!", UserUtil.currentUser);

    }
}
