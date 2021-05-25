package com.avito.security;
public class g2 {
    public static <T> void a(Appendable appendable, T t, e1<? super T, ? extends CharSequence> e1Var) {
        T valueOf;
        j1.b(appendable, "$this$appendElement");
        if (e1Var != null) {
            t = (T) e1Var.a(t);
        } else {
            if (!(t != null ? t instanceof CharSequence : true)) {
                if (t instanceof Character) {
                    appendable.append(t.charValue());
                    return;
                }
                valueOf = String.valueOf(t);
                appendable.append(valueOf);
            }
        }
        valueOf = t;
        appendable.append(valueOf);
    }
}
