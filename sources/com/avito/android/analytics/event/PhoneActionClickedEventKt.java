package com.avito.android.analytics.event;

import a2.b.a.a.a;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"profile_release"}, k = 2, mv = {1, 4, 2})
public final class PhoneActionClickedEventKt {
    public static final String access$convert(int i) {
        if (i == 0) {
            return PhoneActionStrings.REMOVE;
        }
        if (i == 1) {
            return PhoneActionStrings.VERIFY;
        }
        if (i == 2) {
            return PhoneActionStrings.SET_FOR_ALL;
        }
        throw new IllegalArgumentException(a.Q2("Action with id = ", i, " not found"));
    }
}
