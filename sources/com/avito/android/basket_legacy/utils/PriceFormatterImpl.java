package com.avito.android.basket_legacy.utils;

import com.avito.android.remote.auth.AuthSource;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/avito/android/basket_legacy/utils/PriceFormatterImpl;", "Lcom/avito/android/basket_legacy/utils/PriceFormatter;", "", "value", "", "format", "(J)Ljava/lang/String;", "Ljava/text/DecimalFormat;", AuthSource.SEND_ABUSE, "Ljava/text/DecimalFormat;", "defaultFormatter", "Ljava/util/Locale;", "locale", "<init>", "(Ljava/util/Locale;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class PriceFormatterImpl implements PriceFormatter {
    public final DecimalFormat a;

    @Inject
    public PriceFormatterImpl(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        NumberFormat instance = DecimalFormat.getInstance(locale);
        Objects.requireNonNull(instance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) instance;
        decimalFormat.setGroupingSize(3);
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "decimalFormatSymbols");
        decimalFormatSymbols.setGroupingSeparator(Typography.nbsp);
        Unit unit = Unit.INSTANCE;
        this.a = decimalFormat;
    }

    @Override // com.avito.android.basket_legacy.utils.PriceFormatter
    @NotNull
    public String format(long j) {
        String format = this.a.format(j);
        Intrinsics.checkNotNullExpressionValue(format, "defaultFormatter.format(value)");
        return format;
    }
}
