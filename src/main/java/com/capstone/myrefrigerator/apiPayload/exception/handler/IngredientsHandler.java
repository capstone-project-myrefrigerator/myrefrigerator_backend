package com.capstone.myrefrigerator.apiPayload.exception.handler;

import com.capstone.myrefrigerator.apiPayload.code.BaseErrorCode;
import com.capstone.myrefrigerator.apiPayload.exception.GeneralException;

public class IngredientsHandler extends GeneralException {
    public IngredientsHandler(BaseErrorCode code) {
        super(code);
    }
}
