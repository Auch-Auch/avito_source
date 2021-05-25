package com.avito.android.shop.awards;

import android.app.Application;
import android.content.Intent;
import com.avito.android.ShopAwardsIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SellerVerification;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/shop/awards/ShopAwardsIntentFactoryImpl;", "Lcom/avito/android/ShopAwardsIntentFactory;", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "", "arrowBackNavigation", "Landroid/content/Intent;", "showAwardsIntent", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;Z)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopAwardsIntentFactoryImpl implements ShopAwardsIntentFactory {
    public final Application a;

    @Inject
    public ShopAwardsIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.ShopAwardsIntentFactory
    @NotNull
    public Intent showAwardsIntent(@NotNull SellerVerification.AwardsItem awardsItem, boolean z) {
        Intrinsics.checkNotNullParameter(awardsItem, "awards");
        return AwardsActivityKt.createAwardsActivityIntent(this.a, awardsItem, z);
    }
}
