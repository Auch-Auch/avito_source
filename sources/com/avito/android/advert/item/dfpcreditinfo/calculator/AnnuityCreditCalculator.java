package com.avito.android.advert.item.dfpcreditinfo.calculator;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/calculator/AnnuityCreditCalculator;", "", "", "loanAmount", "", "percentYear", FirebaseAnalytics.Param.TERM, "calculatePayment", "(IDI)Ljava/lang/Integer;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AnnuityCreditCalculator {
    @Nullable
    Integer calculatePayment(int i, double d, int i2);
}
