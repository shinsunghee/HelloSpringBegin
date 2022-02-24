package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
            model.addAttribute("data","sdsdsd");
       return "hello";
    }

    @GetMapping("hello-mvc")
    public String hellMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template2"; //리턴명이 hello-mvc 접속 페이지로 들어올때 보여줄 html 페이지를 의미한다. --view resolver가 매핑해준다.
    }


    @GetMapping("hello-mvc2")
    @ResponseBody
    public String helloMvc2(@RequestParam("name2")String name2, Model model){

        return "hello"+name2;
    }
    @GetMapping("hello-mvc3")
    @ResponseBody
    public Hello helloMvc3(@RequestParam("name3")String name2, Model model){
        Hello hello = new Hello();
        hello.setName(name2);
        return hello; //객체를 그대로 리턴하면 데이터형식을 보여준다JSON으로

    }
    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
