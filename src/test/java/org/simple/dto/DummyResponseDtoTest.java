package org.simple.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DummyResponseDtoTest {

    @Test
    public void 롬복_테스트() {
        //GIVEN
        String name = "test";
        int amount = 1000;

        //WHEN
        DummyResponseDto dto = new DummyResponseDto(name, amount);

        //THEN
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


    }

}