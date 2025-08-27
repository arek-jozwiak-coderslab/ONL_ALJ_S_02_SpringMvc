package pl.coderslab.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/add/{a}/{b}")
    public String add(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b) {
        return mathService.add(a, b).toString();
    }
}
