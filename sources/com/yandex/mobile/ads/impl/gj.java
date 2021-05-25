package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.yandex.metrica.IIdentifierCallback;
import java.util.EnumMap;
import java.util.Map;
public final class gj {
    private static final Map<IIdentifierCallback.Reason, String> a;

    static {
        EnumMap enumMap = new EnumMap(IIdentifierCallback.Reason.class);
        a = enumMap;
        enumMap.put((EnumMap) IIdentifierCallback.Reason.NETWORK, (IIdentifierCallback.Reason) "Network error");
        enumMap.put((EnumMap) IIdentifierCallback.Reason.INVALID_RESPONSE, (IIdentifierCallback.Reason) "Invalid response");
        enumMap.put((EnumMap) IIdentifierCallback.Reason.UNKNOWN, (IIdentifierCallback.Reason) AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
    }

    @NonNull
    public static String a(@Nullable IIdentifierCallback.Reason reason) {
        String str = a.get(reason);
        return str != null ? str : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
