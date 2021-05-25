package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.advert.item.dfpcreditinfo.calculator.AnnuityCreditCalculator;
import com.avito.android.advert.item.dfpcreditinfo.calculator.DefaultAnnuityCreditCalculator;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.s.c;
import t6.y.k;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006JA\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0013J'\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0015J/\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditConverter;", "", "", "value", "", "convertToNumber", "(Ljava/lang/String;)Ljava/lang/Double;", "", "loan", "percentYear", "maxMonthlyPayment", "", "terms", "Lkotlin/Pair;", "rublesPerMonth", "(IDILjava/util/List;)Lkotlin/Pair;", "price", "initialFeePercent", FirebaseAnalytics.Param.TERM, "(IDDI)Ljava/lang/Integer;", "loanAmount", "(IDI)Ljava/lang/Integer;", "min", "max", "calcLoan", "(DIII)Ljava/lang/Integer;", "minValue", "maxValue", "limitValue", "(III)I", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/AnnuityCreditCalculator;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/AnnuityCreditCalculator;", "annuityCalculator", "<init>", "(Lcom/avito/android/advert/item/dfpcreditinfo/calculator/AnnuityCreditCalculator;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class DfpCreditConverter {
    public final AnnuityCreditCalculator a;

    public DfpCreditConverter() {
        this(null, 1, null);
    }

    public DfpCreditConverter(@NotNull AnnuityCreditCalculator annuityCreditCalculator) {
        Intrinsics.checkNotNullParameter(annuityCreditCalculator, "annuityCalculator");
        this.a = annuityCreditCalculator;
    }

    @Nullable
    public final Integer calcLoan(double d, int i, int i2, int i3) {
        Double d2;
        if (d < 0.0d || d > 100.0d || i <= 0) {
            d2 = null;
        } else {
            d2 = Double.valueOf(((100.0d - d) * ((double) i)) / 100.0d);
        }
        if (d2 != null) {
            return Integer.valueOf(limitValue(c.roundToInt(d2.doubleValue()), i2, i3));
        }
        return null;
    }

    @Nullable
    public final Double convertToNumber(@Nullable String str) {
        String replace$default;
        if (!(str == null || (replace$default = m.replace$default(str, ',', (char) FormatterType.defaultDecimalSeparator, false, 4, (Object) null)) == null)) {
            StringBuilder sb = new StringBuilder();
            int length = replace$default.length();
            for (int i = 0; i < length; i++) {
                char charAt = replace$default.charAt(i);
                if (Character.isDigit(charAt) || charAt == '.' || charAt == '-') {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
            if (sb2 != null) {
                return k.toDoubleOrNull(sb2);
            }
        }
        return null;
    }

    public final int limitValue(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Nullable
    public final Pair<Integer, Integer> rublesPerMonth(int i, double d, int i2, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "terms");
        Iterator<Integer> it = list.iterator();
        int i3 = 0;
        Integer num = null;
        while (it.hasNext() && (num = rublesPerMonth(i, d, (i3 = it.next().intValue()))) != null && num.intValue() >= i2) {
        }
        if (num != null) {
            return TuplesKt.to(Integer.valueOf(num.intValue()), Integer.valueOf(i3));
        }
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DfpCreditConverter(AnnuityCreditCalculator annuityCreditCalculator, int i, j jVar) {
        this((i & 1) != 0 ? new DefaultAnnuityCreditCalculator() : annuityCreditCalculator);
    }

    @Nullable
    public final Integer rublesPerMonth(int i, double d, double d2, int i2) {
        Integer calcLoan = calcLoan(d, i, 0, Integer.MAX_VALUE);
        if (calcLoan != null) {
            return rublesPerMonth(calcLoan.intValue(), d2, i2);
        }
        return null;
    }

    @Nullable
    public final Integer rublesPerMonth(int i, double d, int i2) {
        return this.a.calculatePayment(i, d, i2);
    }
}
