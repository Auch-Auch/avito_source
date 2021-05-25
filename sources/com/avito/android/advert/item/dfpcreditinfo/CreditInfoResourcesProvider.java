package com.avito.android.advert.item.dfpcreditinfo;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "", "", "loan", "getCurrency", "(Ljava/lang/String;)Ljava/lang/String;", "payment", "getPayment", "percent", "getPercent", "", "years", "getTermYears", "(I)Ljava/lang/String;", "value", "getValueLimit", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface CreditInfoResourcesProvider {
    @NotNull
    String getCurrency(@NotNull String str);

    @NotNull
    String getPayment(@NotNull String str);

    @NotNull
    String getPercent(@NotNull String str);

    @NotNull
    String getTermYears(int i);

    @NotNull
    String getValueLimit(@NotNull String str);
}
