package edu.bjtu.microservice.cart.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import edu.bjtu.microservice.cart.domain.Item;

@AllArgsConstructor  @NoArgsConstructor
@Getter  @Setter
public class OrderDTO {

    private String id;
    private Long userId;
    private String userName;
    private String payState;
    private String payDate;
    private String deliverState;
    private String deliverDate;
    private List<Item> items;
    private BigDecimal totalPrice;

}