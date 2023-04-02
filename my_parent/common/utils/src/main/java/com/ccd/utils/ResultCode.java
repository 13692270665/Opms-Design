package com.ccd.utils;

/**
 * @author :ccd
 * @date : 2023/2/27 21:50
 */
public enum ResultCode {
    SUCCESS(20000),ERROR(20001);

    private int value;
    ResultCode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
