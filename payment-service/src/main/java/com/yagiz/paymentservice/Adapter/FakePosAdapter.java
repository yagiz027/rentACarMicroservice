package com.yagiz.paymentservice.adapter;

import java.util.Random;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.paymentservice.business.abstracts.PosService;

public class FakePosAdapter implements PosService {

    @Override
    public void pay() {
        boolean isSuccessfull = new Random().nextBoolean();
        if(!isSuccessfull)
            throw new BusinessException(Messages.Payment.PaymentIsFailed);
    }
    
}
