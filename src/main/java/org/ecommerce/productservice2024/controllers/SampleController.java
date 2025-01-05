package org.ecommerce.productservice2024.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this class will now be hosting a set of http api's like get,put,post,delete etc
@RestController
@RequestMapping("/say")
//if it's productController ->product(to deliver a parsel first we need to know the location
public class SampleController {
    //localhost:8080/say/hello
    @GetMapping("/hello/{name}/{times}")//to give path variable(parameter)
    //we can give multiple parameters also , if I want to times add one more pathvariable

    public String sayHello(@PathVariable("name") String name,
                           @PathVariable("times") int count){
        StringBuilder output=new StringBuilder();
        for (int i=0;i<count;i++){
            output.append("Hello " +name+ "....");
        }
        return output.toString();
        //return "my name is vidya";
    }
    //localhost:8080/say/bye
    @GetMapping("/bye")
    public String sayBye(){

        return "Bye";
    }
}
//localhost:our laptops local server
//port number->entry where someone is listening for your request
