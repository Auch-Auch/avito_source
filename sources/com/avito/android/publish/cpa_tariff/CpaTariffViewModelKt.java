package com.avito.android.publish.cpa_tariff;

import com.avito.android.remote.model.CpaPhone;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class CpaTariffViewModelKt {
    public static final String access$getPhoneWithoutPrefix(CpaPhone cpaPhone) {
        if (!m.startsWith$default(cpaPhone.getPhone(), "7", false, 2, null)) {
            return cpaPhone.getPhone();
        }
        String phone = cpaPhone.getPhone();
        Objects.requireNonNull(phone, "null cannot be cast to non-null type java.lang.String");
        String substring = phone.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }
}
