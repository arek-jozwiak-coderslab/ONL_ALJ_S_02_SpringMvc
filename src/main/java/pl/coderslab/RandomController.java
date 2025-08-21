package pl.coderslab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomController {

    @GetMapping("/random/{max}")
    public String max(@PathVariable("max") int max) {
        int i = new Random().nextInt(max);
        return "Użytkownik podał wartość" + max + " Wylosowano liczbę: wylosowana liczba. " + i;
    }
}
