package edu.bjtu.microservice.cart.service;

import edu.bjtu.microservice.cart.controller.dto.RequestDTO;
import edu.bjtu.microservice.cart.domain.Cart;
//import edu.bjtu.microservice.cart.domain.Item;
//import edu.bjtu.microservice.cart.domain.ProductOverview;
//import edu.bjtu.microservice.cart.domain.UserInfo;
//import lombok.AllArgsConstructor;
//import org.springframework.web.client.RestTemplate;
//import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;

@Service
//@AllArgsConstructor
public class ShoppingCartService {
    @Autowired
    private IntegrationService integrationService;


    public Cart purchase(Cart shoppingCart) {
        var uuid = UUID.randomUUID().toString();
        shoppingCart.setId(uuid);

        var user = integrationService.getRemoteUserInfo(shoppingCart.getUser().getId());
        shoppingCart.setUser(user);

        var items = integrationService.getRemoteProductItemsInfo(shoppingCart.getItems());
        shoppingCart.setItems(items);

        integrationService.submitToBilling(shoppingCart);
        integrationService.notifyToDelivery(shoppingCart);
        integrationService.askForUserReview(shoppingCart);

        return shoppingCart;
    }

    public Cart purchase2(RequestDTO requestDTO) {
        var uuid = UUID.randomUUID().toString();
        Cart shoppingCart = new Cart();
        shoppingCart.setId(uuid);

        var user = integrationService.getRemoteUserInfo(requestDTO.getUserId());
        shoppingCart.setUser(user);

        var items = integrationService.getRemoteProductItemsInfo1(requestDTO.getItems());
        shoppingCart.setItems(items);

        integrationService.submitToBilling(shoppingCart);
        integrationService.notifyToDelivery(shoppingCart);
        integrationService.askForUserReview(shoppingCart);

        return shoppingCart;
    }

}
