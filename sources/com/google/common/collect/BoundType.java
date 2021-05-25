package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
@GwtCompatible
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    /* access modifiers changed from: public */
    BoundType(boolean z) {
    }

    public static BoundType a(boolean z) {
        return z ? CLOSED : OPEN;
    }
}
