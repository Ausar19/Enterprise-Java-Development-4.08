package EnterpriseJavaDevelopment408.controllers;

import EnterpriseJavaDevelopment408.models.Role;
import EnterpriseJavaDevelopment408.models.User;
import EnterpriseJavaDevelopment408.repositories.RoleRepository;
import EnterpriseJavaDevelopment408.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/say-hi")
    public String sayHi() {
        return "Hi";
    }

    @PostMapping("/create-admin-user")
    public void createAdminUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        Role role = roleRepository.save(new Role("USER", user));
        Role role2 = roleRepository.save(new Role("ADMIN", user));


    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        Role role = roleRepository.save(new Role("USER", user));

    }

    @GetMapping("/user-area")
    public String showUserArea() {
        return "Welcome, you are in a user only area!";
    }

    @GetMapping("/user-admin-area")
    public String userAdminArea() {
        return "Admins only";
    }

    @PatchMapping("/modify-password")
    public void modifyPassword(@RequestParam String password, @AuthenticationPrincipal UserDetails userDetails) {


        User user = userRepository.findByUsername(userDetails.getUsername()).get();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

    }
}
