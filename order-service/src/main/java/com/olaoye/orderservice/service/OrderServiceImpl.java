package com.olaoye.orderservice.service;

import com.olaoye.orderservice.dto.OrderLineItemsDto;
import com.olaoye.orderservice.dto.OrderRequest;
import com.olaoye.orderservice.model.Order;
import com.olaoye.orderservice.model.OrderLineItems;
import com.olaoye.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void placeOrder (OrderRequest orderRequest){
        Order order = new Order();
       List<OrderLineItems>  orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
       order.setOrderNumber(UUID.randomUUID().toString().split("-")[0]);
       order.setOrderLineItemsList(orderLineItems);
       orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
