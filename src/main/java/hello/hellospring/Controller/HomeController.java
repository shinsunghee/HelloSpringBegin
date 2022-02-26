package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    //index hmlt 페이지는 웰컴페이지였는데 컨르롤러로 다른 매핑된 화면이 있을경우 무신된다.
    //결국 이쪽으로 보이게된다.
    public String name() {
        return "home";
    }
}
