package com.avito.android.advert.consultation_form;

import com.avito.android.remote.model.Phone;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"advert-details_release"}, k = 2, mv = {1, 4, 2})
public final class ConsultationFormViewModelKt {
    public static final String access$getPhoneWithoutPrefix(Phone phone) {
        if (!m.startsWith$default(phone.getPhone(), "7", false, 2, null)) {
            return phone.getPhone();
        }
        String phone2 = phone.getPhone();
        Objects.requireNonNull(phone2, "null cannot be cast to non-null type java.lang.String");
        String substring = phone2.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }
}
