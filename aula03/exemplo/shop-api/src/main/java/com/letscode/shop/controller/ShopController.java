package com.letscode.shop.controller;

import com.letscode.shop.dto.ClientDTO;
import com.letscode.shop.dto.ProductDTO;
import com.letscode.shop.dto.ShopDTO;
import com.letscode.shop.service.ClientService;
import com.letscode.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private static List<ShopDTO> shops = new ArrayList<>();


    @PostMapping
    public ShopDTO newShop(@RequestBody ShopDTO shopDTO) {

        ClientDTO clientDTO = ClientService.getClient(shopDTO.getClient().getIdentifier());

        Float value = 0F;
        for (ProductDTO productDTO : shopDTO.getProducts()) {
            ProductDTO productDTO1 = ProductService.getProduct(productDTO.getIdentifier());
            value += productDTO1.getPrice();
        }
        shopDTO.setTotalValue(value);
        
        shops.add(shopDTO);
        return shopDTO;

    }

    @GetMapping
    public List<ShopDTO> listShop() {
        return shops;
    }

}
