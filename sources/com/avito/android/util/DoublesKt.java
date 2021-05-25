package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\f¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "", "toLongBits", "(D)J", "double", "", "sameAs", "(DD)Z", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class DoublesKt {
    public static final boolean sameAs(double d, double d2) {
        return Double.compare(d, d2) == 0;
    }

    public static final long toLongBits(double d) {
        return Double.doubleToLongBits(d);
    }
}
