package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertPrice;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\u0006R\u001d\u0010\r\u001a\u00020\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/util/AdvertPriceFormatter;", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "value", "", "format", "(Lcom/avito/android/remote/model/AdvertPrice;)Ljava/lang/String;", "getRawValue", "Ljava/text/Format;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getPriceFormat", "()Ljava/text/Format;", "priceFormat", "Ljava/util/Locale;", "locale", "<init>", "(Ljava/util/Locale;)V", "favorite_release"}, k = 1, mv = {1, 4, 2})
public class AdvertPriceFormatter implements Formatter<AdvertPrice> {
    public final Lazy a;

    public static final class a extends Lambda implements Function0<NumberFormat> {
        public final /* synthetic */ Locale a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Locale locale) {
            super(0);
            this.a = locale;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public NumberFormat invoke() {
            NumberFormat instance = DecimalFormat.getInstance(this.a);
            if (instance instanceof DecimalFormat) {
                DecimalFormat decimalFormat = (DecimalFormat) instance;
                decimalFormat.setGroupingSize(3);
                DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
                Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "formatSymbols");
                decimalFormatSymbols.setGroupingSeparator(' ');
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            }
            instance.setGroupingUsed(true);
            return instance;
        }
    }

    @Inject
    public AdvertPriceFormatter(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.a = c.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new a(locale));
    }

    @Nullable
    public String getRawValue(@NotNull AdvertPrice advertPrice) {
        Intrinsics.checkNotNullParameter(advertPrice, "$this$getRawValue");
        return advertPrice.getValue();
    }

    @NotNull
    public String format(@Nullable AdvertPrice advertPrice) {
        String rawValue;
        boolean z;
        if (advertPrice == null || (rawValue = getRawValue(advertPrice)) == null) {
            return "";
        }
        boolean z2 = false;
        int i = 0;
        while (true) {
            try {
                if (i >= rawValue.length()) {
                    z = true;
                    break;
                } else if (!Character.isDigit(rawValue.charAt(i))) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            } catch (Exception unused) {
            }
        }
        if (z) {
            rawValue = ((Format) this.a.getValue()).format(Long.valueOf(Long.parseLong(rawValue)));
        }
        String metric = advertPrice.getMetric();
        if (metric == null || m.isBlank(metric)) {
            z2 = true;
        }
        if (z2) {
            Intrinsics.checkNotNullExpressionValue(rawValue, "formattedValue");
            return rawValue;
        }
        return rawValue + ' ' + advertPrice.getMetric();
    }
}
