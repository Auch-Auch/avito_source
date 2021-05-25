package com.yandex.runtime.internal.test_support;
/* JADX WARN: Init of enum TWO can be incorrect */
/* JADX WARN: Init of enum FOUR can be incorrect */
/* JADX WARN: Init of enum EIGHT can be incorrect */
public enum TestBitfieldEnum {
    ONE(1),
    TWO(r0.value << 1),
    FOUR(r1.value << 1),
    EIGHT(r4.value << 1);
    
    public final int value;

    private TestBitfieldEnum(int i) {
        this.value = i;
    }
}
