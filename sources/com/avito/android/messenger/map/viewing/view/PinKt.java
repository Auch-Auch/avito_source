package com.avito.android.messenger.map.viewing.view;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"messenger_release"}, k = 2, mv = {1, 4, 2})
public final class PinKt {
    public static final String access$asString(List list) {
        if (!(!list.isEmpty())) {
            return "";
        }
        StringBuilder sb = new StringBuilder((list.size() * 2) - 1);
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            sb.append((CharSequence) obj);
            if (i < list.size() - 1) {
                sb.append("\n");
            }
            i = i2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
