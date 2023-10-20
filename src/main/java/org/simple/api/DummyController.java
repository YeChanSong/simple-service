package org.simple.api;

import org.simple.dto.DummyResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestController
public class DummyController {

    @GetMapping("/dummy")
    public String dummy() {
        return "dummy";
    }

    @GetMapping("/dummy/param")
    public DummyResponseDto dummyWithParam(
            @RequestParam("name") String name,
            @RequestParam("amount") int amount
    ) {
        return new DummyResponseDto(name, amount);
    }

}
