package ru.repp.den.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.repp.den.service.FizzBuzzService;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {

    @Autowired
    FizzBuzzService fizzBuzzService;

    @RequestMapping
    public String fizzBuzz(@RequestParam(name = "number", required = true) Long number) {
        return fizzBuzzService.play(number);
    }

    @RequestMapping("/multiple")
    public String fizzBuzzMultiple(@RequestParam(name = "numbers[]", required = true) Long[] numbers) {
        return fizzBuzzService.play(numbers);
    }

}
