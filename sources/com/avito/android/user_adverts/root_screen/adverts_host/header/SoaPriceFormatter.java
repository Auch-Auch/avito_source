package com.avito.android.user_adverts.root_screen.adverts_host.header;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Formatter;
import java.math.RoundingMode;
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
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\u000b\u001a\u00020\u00068B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000e\u001a\u00020\u00068B@\u0002X\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/SoaPriceFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "format", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/text/Format;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getBillionFormatter", "()Ljava/text/Format;", "billionFormatter", AuthSource.SEND_ABUSE, "getDefaultFormatter", "defaultFormatter", "Ljava/util/Locale;", "locale", "<init>", "(Ljava/util/Locale;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SoaPriceFormatter implements Formatter<String> {
    public final Lazy a;
    public final Lazy b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<NumberFormat> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final NumberFormat invoke() {
            int i = this.a;
            if (i == 0) {
                NumberFormat instance = DecimalFormat.getInstance((Locale) this.b);
                if (instance instanceof DecimalFormat) {
                    DecimalFormat decimalFormat = (DecimalFormat) instance;
                    decimalFormat.setGroupingSize(3);
                    DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
                    Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "decimalFormatSymbols");
                    decimalFormatSymbols.setGroupingSeparator(Typography.nbsp);
                    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                    decimalFormat.applyPattern("#.#");
                }
                instance.setGroupingUsed(true);
                return instance;
            } else if (i == 1) {
                NumberFormat instance2 = DecimalFormat.getInstance((Locale) this.b);
                if (instance2 instanceof DecimalFormat) {
                    DecimalFormat decimalFormat2 = (DecimalFormat) instance2;
                    decimalFormat2.setGroupingSize(3);
                    DecimalFormatSymbols decimalFormatSymbols2 = decimalFormat2.getDecimalFormatSymbols();
                    Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols2, "decimalFormatSymbols");
                    decimalFormatSymbols2.setGroupingSeparator(Typography.nbsp);
                }
                instance2.setGroupingUsed(true);
                return instance2;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public SoaPriceFormatter(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.a = c.lazy(lazyThreadSafetyMode, (Function0) new a(1, locale));
        this.b = c.lazy(lazyThreadSafetyMode, (Function0) new a(0, locale));
    }

    @NotNull
    public String format(@Nullable String str) {
        if (str == null) {
            return "";
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            } else if (!Character.isDigit(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            double parseDouble = Double.parseDouble(str);
            if (parseDouble >= 1.0E9d) {
                str = ((Format) this.b.getValue()).format(Double.valueOf(((double) ((long) parseDouble)) / 1.0E9d)) + " млрд";
            } else {
                str = ((Format) this.a.getValue()).format(Double.valueOf(parseDouble));
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (rawDoubleValue >= ON…oubleValue)\n            }");
        }
        return str;
    }
}
