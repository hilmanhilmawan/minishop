package com.ecommerce.minishop.service;

import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.request.CheckoutOrderRequest;
import com.ecommerce.minishop.request.PaymentOrderRequest;

import java.util.List;

public interface OrderService {
    CheckoutOrderRequest checkout(List<CheckoutOrderRequest> listCheckoutOrder) throws RecordNotFoundException;
    void prosesPembayaran(PaymentOrderRequest paymentOrderRequest) throws RecordNotFoundException;
}
