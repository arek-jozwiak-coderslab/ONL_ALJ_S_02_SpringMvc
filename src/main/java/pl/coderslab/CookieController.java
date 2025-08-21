package pl.coderslab;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

@RestController
public class CookieController {


     @GetMapping("/setcookie/{value1}/{value2}")
     public String setCookieWithParams(HttpServletResponse response,
                                       @PathVariable("value1") String value1,
                                       @PathVariable("value2") String value2){
         Cookie cookie = new Cookie("cookie1", value1);
         cookie.setPath("/");
         Cookie cookie2 = new Cookie("cookie2", value2);
         cookie2.setPath("/");
         response.addCookie(cookie);
         response.addCookie(cookie2);
         return "Cookie set!";
     }
        @GetMapping("/getcookies")
        public String getCookies(HttpServletRequest request,
                                 @CookieValue (value = "cookie2") String cookie2Value) {
            Cookie cookie1 = WebUtils.getCookie(request, "cookie1");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cookie1.getName()).append("=").append(cookie1.getValue());
            stringBuilder.append(cookie2Value);

            return stringBuilder.toString();
        }
}
