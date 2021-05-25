package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.z;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
public final class qk {
    @NonNull
    private final DecimalFormat a;

    public qk() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        decimalFormatSymbols.setGroupingSeparator(' ');
        this.a = new DecimalFormat("#,###,###", decimalFormatSymbols);
    }

    @NonNull
    public final String a(@NonNull String str) throws z {
        try {
            return this.a.format(Integer.valueOf(!TextUtils.isEmpty(str) ? str.replaceAll(" ", "") : str));
        } catch (NumberFormatException unused) {
            String.format("Could not parse review count value. Review Count value is %s", str);
            throw new z("Native Ad json has not required attributes");
        }
    }
}
