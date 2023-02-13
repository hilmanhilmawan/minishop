package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.enums.ResponseCode;
import com.ecommerce.minishop.enums.ResponseMessage;
import com.ecommerce.minishop.enums.StatusCode;
import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.model.OrderDetail;
import com.ecommerce.minishop.model.OrderHeader;
import com.ecommerce.minishop.model.Produk;
import com.ecommerce.minishop.model.UserLogin;
import com.ecommerce.minishop.repository.ProdukRepository;
import com.ecommerce.minishop.repository.OrderDtlRepository;
import com.ecommerce.minishop.repository.OrderHdrRepository;
import com.ecommerce.minishop.request.CheckoutOrderRequest;
import com.ecommerce.minishop.request.PaymentOrderRequest;
import com.ecommerce.minishop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderHdrRepository orderHdrRepository;
    private final OrderDtlRepository orderDtlRepository;
    private final ProdukRepository produkRepository;

    @Override
    public CheckoutOrderRequest checkout(List<CheckoutOrderRequest> listCheckoutOrder) throws RecordNotFoundException {
        OrderHeader orderHeader = new OrderHeader();
        for (CheckoutOrderRequest orderRequest : listCheckoutOrder) {
            Optional<Produk> produkOptional = produkRepository.findByRefId(orderRequest.getProdukRefId());
            if (!produkOptional.isPresent()) {
                throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                        ResponseMessage.NOT_FOUND.getMessage());
            }
            Produk produk = produkOptional.get();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduk(produk);
            orderDetail.setHarga(orderRequest.getTotalHarga());
            orderDetail.setQty(orderRequest.getQty());
            orderHeader.addDtl(orderDetail);
        }

        UserLogin userLogin = new UserLogin();
        userLogin.setId(1L);
        orderHeader.setStatus(Integer.parseInt(StatusCode.DALAM_PROSES.getCode()));
        orderHeader.setUserLogin(userLogin);
        orderHeader.setPaymentType("COD");
        try {
            orderHdrRepository.save(orderHeader);
        } catch (Exception e) {
            throw new RecordNotFoundException(HttpStatus.BAD_REQUEST,
                    ResponseCode.BAD_REQUEST.getCode(), ResponseMessage.FAILED_TO_SAVE_DATA.getMessage());
        }
        return null;
    }

    @Override
    public void prosesPembayaran(PaymentOrderRequest paymentOrderRequest) throws RecordNotFoundException {
        Optional<OrderHeader> orderHeaderOptional = orderHdrRepository.findAllByRefId(paymentOrderRequest.getOrderHdrId());
        if (!orderHeaderOptional.isPresent()) {
            throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                    ResponseMessage.NOT_FOUND.getMessage());
        }

        OrderHeader orderHeader = orderHeaderOptional.get();
        orderHeader.setNama(paymentOrderRequest.getNama());
        orderHeader.setNohandPhone(paymentOrderRequest.getNohandPhone());
        orderHeader.setAlamat(paymentOrderRequest.getAlamat());
        orderHeader.setStatus(Integer.parseInt(StatusCode.MENUNGGU_PEMBAYARAN.getCode()));
        try {
            orderHdrRepository.save(orderHeader);
        } catch (Exception e) {
            throw new RecordNotFoundException(HttpStatus.BAD_REQUEST,
                    ResponseCode.BAD_REQUEST.getCode(), ResponseMessage.FAILED_TO_SAVE_DATA.getMessage());
        }
    }
}
