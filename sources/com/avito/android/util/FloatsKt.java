package com.avito.android.util;

import com.google.firebase.crashlytics.internal.common.IdManager;
import com.vk.sdk.api.VKApiConst;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\u001a-\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00010\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "", "pattern", "", "separator", "kotlin.jvm.PlatformType", "formatWithSeparator", "(FLjava/lang/String;C)Ljava/lang/String;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class FloatsKt {
    public static final String formatWithSeparator(float f, @NotNull String str, char c) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(c);
        Unit unit = Unit.INSTANCE;
        return new DecimalFormat(str, decimalFormatSymbols).format(Float.valueOf(f));
    }

    public static /* synthetic */ String formatWithSeparator$default(float f, String str, char c, int i, Object obj) {
        if ((i & 1) != 0) {
            str = IdManager.DEFAULT_VERSION_NAME;
        }
        if ((i & 2) != 0) {
            c = ',';
        }
        return formatWithSeparator(f, str, c);
    }
}
