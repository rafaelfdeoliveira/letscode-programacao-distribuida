package com.letscode.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDTO {

    private String identifier;
    private ClientDTO client;
    private Float totalValue;

    private List<ProductDTO> products;

}
