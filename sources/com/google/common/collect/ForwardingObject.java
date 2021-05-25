package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
@GwtCompatible
public abstract class ForwardingObject {
    /* renamed from: delegate */
    public abstract Object mo147delegate();

    @Override // java.lang.Object
    public String toString() {
        return mo147delegate().toString();
    }
}
