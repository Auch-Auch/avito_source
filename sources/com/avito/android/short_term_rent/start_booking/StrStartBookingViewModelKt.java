package com.avito.android.short_term_rent.start_booking;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "", "", "from", "", "cutToEnd", "(Ljava/util/List;I)V", "short-term-rent_release"}, k = 2, mv = {1, 4, 2})
public final class StrStartBookingViewModelKt {
    public static final void cutToEnd(@NotNull List<? extends Object> list, int i) {
        Intrinsics.checkNotNullParameter(list, "$this$cutToEnd");
        Iterator<? extends Object> it = list.iterator();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            it.next();
            if (i2 >= i) {
                it.remove();
            }
        }
    }
}
