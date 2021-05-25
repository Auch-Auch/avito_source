package kotlin.time;

import com.avito.android.remote.auth.AuthSource;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\t\u001a\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013\"\"\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"", "decimals", "Ljava/text/DecimalFormat;", AuthSource.SEND_ABUSE, "(I)Ljava/text/DecimalFormat;", "", "value", "", "formatToExactDecimals", "(DI)Ljava/lang/String;", "formatUpToDecimals", "formatScientific", "(D)Ljava/lang/String;", "Ljava/lang/ThreadLocal;", "d", "Ljava/lang/ThreadLocal;", "scientificFormat", "Ljava/text/DecimalFormatSymbols;", AuthSource.BOOKING_ORDER, "Ljava/text/DecimalFormatSymbols;", "rootPositiveExpFormatSymbols", "rootNegativeExpFormatSymbols", "", "c", "[Ljava/lang/ThreadLocal;", "precisionFormats", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class FormatToDecimalsKt {
    public static final DecimalFormatSymbols a;
    public static final DecimalFormatSymbols b;
    public static final ThreadLocal<DecimalFormat>[] c;
    public static final ThreadLocal<DecimalFormat> d = new ThreadLocal<>();

    static {
        Locale locale = Locale.ROOT;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(locale);
        decimalFormatSymbols.setExponentSeparator("e");
        a = decimalFormatSymbols;
        DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols(locale);
        decimalFormatSymbols2.setExponentSeparator("e+");
        b = decimalFormatSymbols2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal<>();
        }
        c = threadLocalArr;
    }

    public static final DecimalFormat a(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0", a);
        if (i > 0) {
            decimalFormat.setMinimumFractionDigits(i);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @NotNull
    public static final String formatScientific(double d2) {
        ThreadLocal<DecimalFormat> threadLocal = d;
        DecimalFormat decimalFormat = threadLocal.get();
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("0E0", a);
            decimalFormat.setMinimumFractionDigits(2);
            threadLocal.set(decimalFormat);
        }
        DecimalFormat decimalFormat2 = decimalFormat;
        decimalFormat2.setDecimalFormatSymbols((d2 >= ((double) 1) || d2 <= ((double) -1)) ? b : a);
        String format = decimalFormat2.format(d2);
        Intrinsics.checkNotNullExpressionValue(format, "scientificFormat.getOrSe… }\n        .format(value)");
        return format;
    }

    @NotNull
    public static final String formatToExactDecimals(double d2, int i) {
        DecimalFormat decimalFormat;
        ThreadLocal<DecimalFormat>[] threadLocalArr = c;
        if (i < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i];
            DecimalFormat decimalFormat2 = threadLocal.get();
            if (decimalFormat2 == null) {
                decimalFormat2 = a(i);
                threadLocal.set(decimalFormat2);
            }
            decimalFormat = decimalFormat2;
        } else {
            decimalFormat = a(i);
        }
        String format = decimalFormat.format(d2);
        Intrinsics.checkNotNullExpressionValue(format, "format.format(value)");
        return format;
    }

    @NotNull
    public static final String formatUpToDecimals(double d2, int i) {
        DecimalFormat a3 = a(0);
        a3.setMaximumFractionDigits(i);
        String format = a3.format(d2);
        Intrinsics.checkNotNullExpressionValue(format, "createFormatForDecimals(… }\n        .format(value)");
        return format;
    }
}
