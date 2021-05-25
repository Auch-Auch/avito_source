package com.avito.android.advert.item.sellersubscription;

import android.content.res.Resources;
import com.avito.android.advert_details.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProviderImpl;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;", "", "subscribeButtonText", "()Ljava/lang/String;", "unsubscribeButtonText", "notificationsActivated", "notificationsDeactivated", "settingsText", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SellerSubscriptionResourceProviderImpl implements SellerSubscriptionResourceProvider {
    public final Resources a;

    @Inject
    public SellerSubscriptionResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProvider
    @NotNull
    public String notificationsActivated() {
        String string = this.a.getString(R.string.seller_subscription_notifications_activated);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_notifications_activated)");
        return string;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProvider
    @NotNull
    public String notificationsDeactivated() {
        String string = this.a.getString(R.string.seller_subscription_notifications_deactivated);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…otifications_deactivated)");
        return string;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProvider
    @NotNull
    public String settingsText() {
        String string = this.a.getString(R.string.seller_subscription_settings);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…er_subscription_settings)");
        return string;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProvider
    @NotNull
    public String subscribeButtonText() {
        String string = this.a.getString(R.string.seller_subscription_subscribe);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…r_subscription_subscribe)");
        return string;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProvider
    @NotNull
    public String unsubscribeButtonText() {
        String string = this.a.getString(R.string.seller_subscription_unsubscribe);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…subscription_unsubscribe)");
        return string;
    }
}
