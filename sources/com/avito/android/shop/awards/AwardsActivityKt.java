package com.avito.android.shop.awards;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.SellerVerification;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "", "arrowBackNavigation", "Landroid/content/Intent;", "createAwardsActivityIntent", "(Landroid/content/Context;Lcom/avito/android/remote/model/SellerVerification$AwardsItem;Z)Landroid/content/Intent;", "shop_release"}, k = 2, mv = {1, 4, 2})
public final class AwardsActivityKt {
    @NotNull
    public static final Intent createAwardsActivityIntent(@NotNull Context context, @NotNull SellerVerification.AwardsItem awardsItem, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(awardsItem, "awards");
        Intent intent = new Intent(context, AwardsActivity.class);
        intent.putExtra("awards", awardsItem);
        intent.putExtra("arrow_back_navigation", z);
        return intent;
    }

    public static /* synthetic */ Intent createAwardsActivityIntent$default(Context context, SellerVerification.AwardsItem awardsItem, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return createAwardsActivityIntent(context, awardsItem, z);
    }
}
