package ex.proj.skyline.saitonproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vladislav Domaniewski
 */

@RestController
@RequestMapping("/main")
public class StartController {

    @GetMapping("/vlad")
    public String getWordHello() {
        return "Hello!";
    }
}
