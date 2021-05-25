package com.avito.security;
public class l1 {
    private static final m1 a;

    static {
        m1 m1Var;
        try {
            m1Var = (m1) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            m1Var = null;
        }
        if (m1Var == null) {
            m1Var = new m1();
        }
        a = m1Var;
    }

    public static String a(k1 k1Var) {
        return a.a(k1Var);
    }
}
