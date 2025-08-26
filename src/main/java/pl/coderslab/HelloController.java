package pl.coderslab;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

@Controller
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(HttpServletRequest request) {
        
        Cookie c = WebUtils.getCookie(request, "cookie2");
        return "hello";
    }
}
