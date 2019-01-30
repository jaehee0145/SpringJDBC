package my.examples.springjdbc.controller;

import my.examples.springjdbc.dto.Board;
import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.UserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //  @RequestMapping(method=GET, path="/list") 와 같은 것
    @GetMapping("/list")
    public String main(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page, Model model) {
        List<User> users = userService.getUsers(page);
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/joinform")
    public String joinform() {
        return "joinform";
    }

    @PostMapping("/join")
    public String join(@RequestParam(name = "name") String name,
                       @RequestParam(name = "nickname") String nickname,
                       @RequestParam(name = "email") String email,
                       @RequestParam(name = "passwd1") String passwd1,
                       @RequestParam(name = "passwd2") String passwd2,
                       @RequestHeader(name = "Accept") String accept,
                       HttpSession session) {
        //값 검증
        Assert.hasLength(name, "이름을 입력하세요");
        if(name==null || name.length()<=1)
            throw new IllegalArgumentException("이름을 입력하세요.");

        //암호1, 2 일치 검사
        if(!passwd1.equals(passwd2))
            throw new IllegalArgumentException("암호가 일치하지 않아요.");

        //암호화
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodePasswd = passwordEncoder.encode(passwd1);

        User user = new User(name, nickname, email, encodePasswd);
        userService.addUser(user);
        return "redirect:/list";
    }

//    @GetMapping("/loginform")
//    public String loginform(){
//        return "loginform";
//    }

    @PostMapping("/login")
    public String login(@RequestParam (name = "email") String email,
                        @RequestParam(name = "passwd") String passwd,
                        HttpSession session){
        User user = userService.getUserByEmail(email);
        if(user !=null && user.getPasswd()!=null){
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            boolean matches = passwordEncoder.matches(passwd, user.getPasswd());
            if(matches){
                session.setAttribute("logininfo", user);
                System.out.println("암호가 맞아요");
            }else{
                System.out.println("암호가 틀렸어요");
            }
        }
        return "redirect:/board/list";
    }
}

