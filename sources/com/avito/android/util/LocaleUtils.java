package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/util/LocaleUtils;", "", "Ljava/text/DecimalFormat;", "getDefaultNumberFormat", "()Ljava/text/DecimalFormat;", "Ljava/text/DateFormatSymbols;", AuthSource.SEND_ABUSE, "Ljava/text/DateFormatSymbols;", "getDATE_FORMAT_SYMBOLS", "()Ljava/text/DateFormatSymbols;", "DATE_FORMAT_SYMBOLS", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class LocaleUtils {
    @NotNull
    public static final LocaleUtils INSTANCE = new LocaleUtils();
    @NotNull
    public static final DateFormatSymbols a;

    static {
        DateFormatSymbols instance = DateFormatSymbols.getInstance(new Locale("ru"));
        Intrinsics.checkNotNullExpressionValue(instance, "DateFormatSymbols.getInstance(Locale(\"ru\"))");
        a = instance;
        instance.setMonths(new String[]{"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"});
    }

    @NotNull
    public final DateFormatSymbols getDATE_FORMAT_SYMBOLS() {
        return a;
    }

    @Deprecated(message = "Use an appropriate custom formatter")
    @NotNull
    public final DecimalFormat getDefaultNumberFormat() {
        NumberFormat instance = DecimalFormat.getInstance(new Locale("ru"));
        Objects.requireNonNull(instance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) instance;
        decimalFormat.setGroupingSize(3);
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "formatSymbols");
        decimalFormatSymbols.setGroupingSeparator(' ');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat;
    }
}
