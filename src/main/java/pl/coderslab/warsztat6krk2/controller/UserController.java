package pl.coderslab.warsztat6krk2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztat6krk2.entity.User;
import pl.coderslab.warsztat6krk2.model.UserDTO;
import pl.coderslab.warsztat6krk2.repository.UserRepository;

import javax.validation.Valid;
import javax.xml.ws.BindingType;
import javax.xml.ws.RespectBinding;

@Controller
@RequestMapping("/user")
@SessionAttributes({"loggedInUser"})
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute @Valid User user,
                               BindingResult bindingResult) {
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(Model model,
                            @ModelAttribute @Valid UserDTO user,
                            BindingResult bindingResult) {
        User u = userRepository.findOneByEmail(user.getEmail());
        if (u != null && u.isPasswordCorrect(user.getPassword())) {
            model.addAttribute("loggedInUser", u);
            return "redirect:/";
        }
        return "redirect:/login";
    }


}
