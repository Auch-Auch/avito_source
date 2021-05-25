package com.avito.android.lib.design.promo_block.grouping;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/promo_block/grouping/EdgeMode;", "", "", "isRounded", "()Z", "<init>", "(Ljava/lang/String;I)V", "ROUNDED", "FLAT", "components_release"}, k = 1, mv = {1, 4, 2})
public enum EdgeMode {
    ROUNDED,
    FLAT;

    public final boolean isRounded() {
        return this == ROUNDED;
    }
}
