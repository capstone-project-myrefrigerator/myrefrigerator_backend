package com.capstone.myrefrigerator.apiPayload.exception.handler;

import com.capstone.myrefrigerator.apiPayload.code.BaseErrorCode;
import com.capstone.myrefrigerator.apiPayload.exception.GeneralException;

public class RecipeHandler extends GeneralException {

    public RecipeHandler(BaseErrorCode code) {
        super(code);
    }
}
