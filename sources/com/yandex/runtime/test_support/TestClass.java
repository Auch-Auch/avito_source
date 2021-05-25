package com.yandex.runtime.test_support;
public class TestClass {
    public ReturnClass objectField = new ReturnClass();

    public class ReturnClass {
        public ReturnClass() {
        }
    }

    public int getIntValue() {
        return 42;
    }

    public Integer getObjectValue() {
        return new Integer(42);
    }

    public int throwException() throws NullPointerException {
        throw null;
    }
}
