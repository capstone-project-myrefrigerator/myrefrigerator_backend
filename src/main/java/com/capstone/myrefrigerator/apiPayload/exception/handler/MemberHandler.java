package com.capstone.myrefrigerator.apiPayload.exception.handler;

import com.capstone.myrefrigerator.apiPayload.code.BaseErrorCode;
import com.capstone.myrefrigerator.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
