package com.avito.android.shop.detailed.item;

import android.content.res.Resources;
import com.avito.android.public_profile.ui.SubscriptionsResourceProvider;
import com.avito.android.public_profile_stuff.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopSubscriptionsResourceProvider;", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "", "subscribe", "()Ljava/lang/String;", "unsubscribe", "notificationSettings", "notificationsEnabled", "notificationsDisabled", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSubscriptionsResourceProvider implements SubscriptionsResourceProvider {
    public final Resources a;

    @Inject
    public ShopSubscriptionsResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String notificationSettings() {
        String string = this.a.getString(R.string.notification_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(publ…ification_settings_title)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String notificationsDisabled() {
        String string = this.a.getString(R.string.public_profile_notifications_disabled);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(publ…e_notifications_disabled)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String notificationsEnabled() {
        String string = this.a.getString(R.string.public_profile_notifications_enabled);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(publ…le_notifications_enabled)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String subscribe() {
        String string = this.a.getString(R.string.public_profile_subscribe);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(publ…public_profile_subscribe)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String unsubscribe() {
        String string = this.a.getString(R.string.public_profile_unsubscribe);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(publ…blic_profile_unsubscribe)");
        return string;
    }
}
