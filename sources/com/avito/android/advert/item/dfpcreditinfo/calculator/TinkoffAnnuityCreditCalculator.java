package com.avito.android.advert.item.dfpcreditinfo.calculator;

import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/calculator/TinkoffAnnuityCreditCalculator;", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/AnnuityCreditCalculator;", "", "loanAmount", "", "percentYear", FirebaseAnalytics.Param.TERM, "calculatePayment", "(IDI)Ljava/lang/Integer;", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "roundTo50", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class TinkoffAnnuityCreditCalculator implements AnnuityCreditCalculator {
    public final Function1<Double, Integer> a = a.a;

    public static final class a extends Lambda implements Function1<Double, Integer> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Integer invoke(Double d) {
            double doubleValue = d.doubleValue();
            double d2 = (double) 50;
            return Integer.valueOf((int) ((doubleValue - (doubleValue % d2)) + d2));
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.calculator.AnnuityCreditCalculator
    @Nullable
    public Integer calculatePayment(int i, double d, int i2) {
        if (i2 <= 0) {
            return null;
        }
        if (d > ((double) 0)) {
            double d2 = d / 1200.0d;
            double d3 = (double) 1;
            double d4 = d3 + d2;
            return this.a.invoke(Double.valueOf(((((double) i) * d2) * d4) / (d3 - Math.pow(d4, (double) (-i2)))));
        } else if (d == 0.0d) {
            return this.a.invoke(Double.valueOf(((double) i) / ((double) i2)));
        } else {
            return null;
        }
    }
}
