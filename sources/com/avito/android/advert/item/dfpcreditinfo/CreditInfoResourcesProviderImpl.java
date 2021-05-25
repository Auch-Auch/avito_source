package com.avito.android.advert.item.dfpcreditinfo;

import android.content.res.Resources;
import com.avito.android.advert_details.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0005R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProviderImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "", "loan", "getCurrency", "(Ljava/lang/String;)Ljava/lang/String;", "payment", "getPayment", "percent", "getPercent", "", "years", "getTermYears", "(I)Ljava/lang/String;", "value", "getValueLimit", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CreditInfoResourcesProviderImpl implements CreditInfoResourcesProvider {
    public final Resources a;

    @Inject
    public CreditInfoResourcesProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider
    @NotNull
    public String getCurrency(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "loan");
        String string = this.a.getString(R.string.advert_details_credit_currency_format, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ormat,\n        loan\n    )");
        return string;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider
    @NotNull
    public String getPayment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "payment");
        String string = this.a.getString(R.string.advert_details_credit_monthly_payment_format, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …at,\n        payment\n    )");
        return string;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider
    @NotNull
    public String getPercent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "percent");
        String string = this.a.getString(R.string.advert_details_credit_percent_format, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …at,\n        percent\n    )");
        return string;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider
    @NotNull
    public String getTermYears(int i) {
        String quantityString = this.a.getQuantityString(R.plurals.years, i, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…rals.years, years, years)");
        return quantityString;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider
    @NotNull
    public String getValueLimit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return "До " + str + " ₽";
    }
}
