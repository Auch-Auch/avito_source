package com.avito.android.advert.item.dfpcreditinfo.calculator;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/calculator/DefaultAnnuityCreditCalculator;", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/AnnuityCreditCalculator;", "", "loanAmount", "", "percentYear", FirebaseAnalytics.Param.TERM, "calculatePayment", "(IDI)Ljava/lang/Integer;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultAnnuityCreditCalculator implements AnnuityCreditCalculator {
    @Override // com.avito.android.advert.item.dfpcreditinfo.calculator.AnnuityCreditCalculator
    @Nullable
    public Integer calculatePayment(int i, double d, int i2) {
        if (i2 <= 0) {
            return null;
        }
        if (d > ((double) 0)) {
            double d2 = d / 1200.0d;
            double d3 = (double) 1;
            return Integer.valueOf((int) Math.ceil((((double) i) * d2) / (d3 - Math.pow(d2 + d3, (double) (-i2)))));
        } else if (d == 0.0d) {
            return Integer.valueOf((int) Math.ceil(((double) i) / ((double) i2)));
        } else {
            return null;
        }
    }
}
