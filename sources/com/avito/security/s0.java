package com.avito.security;

import com.avito.android.lib.design.input.FormatterType;
import com.facebook.internal.NativeProtocol;
public final class s0 {
    public static final r0 a;

    static {
        r0 r0Var;
        Object newInstance;
        Object newInstance2;
        int a3 = a();
        if (a3 >= 65544) {
            try {
                Object newInstance3 = Class.forName("com.avito.security.v0").newInstance();
                j1.a(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance3 != null) {
                    try {
                        r0Var = (r0) newInstance3;
                        a = r0Var;
                    } catch (ClassCastException e) {
                        ClassLoader classLoader = newInstance3.getClass().getClassLoader();
                        ClassLoader classLoader2 = r0.class.getClassLoader();
                        Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
                        j1.a((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
            } catch (ClassNotFoundException unused) {
                try {
                    newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    j1.a(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance2 != null) {
                        r0Var = (r0) newInstance2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (ClassCastException e2) {
                ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                ClassLoader classLoader4 = r0.class.getClassLoader();
                Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e2);
                j1.a((Object) initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause2;
            }
        }
        if (a3 >= 65543) {
            try {
                Object newInstance4 = Class.forName("com.avito.security.u0").newInstance();
                j1.a(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance4 != null) {
                    try {
                        r0Var = (r0) newInstance4;
                        a = r0Var;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader6 = r0.class.getClassLoader();
                        Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e3);
                        j1.a((Object) initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause3;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
            } catch (ClassNotFoundException unused3) {
                try {
                    newInstance = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    j1.a(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance != null) {
                        r0Var = (r0) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused4) {
                }
            } catch (ClassCastException e4) {
                ClassLoader classLoader7 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader8 = r0.class.getClassLoader();
                Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e4);
                j1.a((Object) initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause4;
            }
        }
        r0Var = new r0();
        a = r0Var;
    }

    private static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        int i = p2.a((CharSequence) property, (char) FormatterType.defaultDecimalSeparator, 0, false, 6, (Object) null);
        if (i < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
        } else {
            int i2 = i + 1;
            int i3 = p2.a((CharSequence) property, (char) FormatterType.defaultDecimalSeparator, i2, false, 4, (Object) null);
            if (i3 < 0) {
                i3 = property.length();
            }
            String substring = property.substring(0, i);
            j1.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = property.substring(i2, i3);
            j1.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            try {
                return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
            } catch (NumberFormatException unused2) {
                return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
        }
    }
}
