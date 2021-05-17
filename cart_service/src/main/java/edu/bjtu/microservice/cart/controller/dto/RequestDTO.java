package edu.bjtu.microservice.cart.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor  @NoArgsConstructor
@Getter  @Setter
public class RequestDTO {

    private Long userId;
    private List<ItemDTO> items;

}