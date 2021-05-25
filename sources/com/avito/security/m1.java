package com.avito.security;
public class m1 {
    public String a(i1 i1Var) {
        String obj = i1Var.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String a(k1 k1Var) {
        return a((i1) k1Var);
    }
}
