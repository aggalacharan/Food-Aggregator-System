package com.FoodCartService.demo.DTO;

import com.FoodCartService.demo.Model.Item;
import com.FoodCartService.demo.Model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodCartDTO {

    private Integer cartId;

    private Integer userId;

    private List<Item> items = new ArrayList<>();

}
