package pl.coderslab.validation;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleDtoController {

    @PostMapping
    SimpleDto newSimpleDto(@Valid @RequestBody SimpleDto simpleDto) {
        return simpleDto;
    }
}
