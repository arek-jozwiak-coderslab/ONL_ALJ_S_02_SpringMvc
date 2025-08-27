package pl.coderslab.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Integer add(Integer a, Integer b) {
        return a + b;
    }
    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }
}
