package unifor.com.B3TCH.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifor.com.B3TCH.Model.User;
import unifor.com.B3TCH.Model.Yield;
import unifor.com.B3TCH.Services.UserService;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable(value = "id") int id){
        Optional<User> userGet = userService.getUser(id);
        return ResponseEntity.ok(userGet);
    }
    @PostMapping()
    public ResponseEntity<User> singUp(@RequestBody User user) {
        User userPost = this.userService.singUp(user);
        return ResponseEntity.status(201).body(userPost);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id,@RequestBody String email,String password) {
        User u = this.userService.updateUser(id,email,password);
        return ResponseEntity.ok(u);
    }

    @PatchMapping("/{id}/yield")
    public ResponseEntity<Yield> updateTotalProfit(@PathVariable(value = "id") int id){
        Yield y = userService.updateTotalProfit(id);
        return ResponseEntity.ok(y);
    }
    @PatchMapping("/{id}/yield/{ticker}")
    public ResponseEntity<Yield> updateScripProfit(@PathVariable(value = "id") int id, @PathVariable(value = "ticker") String ticker){
        Yield y = userService.updateScripProfit(id,ticker);
        return ResponseEntity.ok(y);
    }

}
