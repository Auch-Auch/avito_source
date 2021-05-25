package com.avito.android.profile.cards;

import android.content.res.Resources;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0007R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/profile/cards/UserProfileResourceProviderImpl;", "Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "", "balance", "walletBalance", "(Ljava/lang/String;)Ljava/lang/String;", "shareMenuTitle", "()Ljava/lang/String;", "phoneRemovingMessage", "phoneRemovingButton", "phoneSetForAllItemsMessage", "phoneSetForAllItemsButton", "phoneRemoved", "phoneAttached", "phoneVerified", "phoneSetForAll", "", "shareMenuIcon", "()I", "menuTintColorAttr", "settingsMenuIcon", "settingsMenuTitle", "notificationMenuIcon", "unreadNotificationMenuIcon", "notificationMenuTitle", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileResourceProviderImpl implements UserProfileResourceProvider {
    public final Resources a;

    public UserProfileResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    public int menuTintColorAttr() {
        return R.attr.blue;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    public int notificationMenuIcon() {
        return com.avito.android.profile.R.drawable.ic_up_notifications_24;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String notificationMenuTitle() {
        String string = this.a.getString(com.avito.android.profile.R.string.menu_notifications);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.menu_notifications)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String phoneAttached() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone_attached);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.phone_attached)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String phoneRemoved() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone_removed);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.phone_removed)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String phoneRemovingButton() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone_action_remove);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.phone_action_remove)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String phoneRemovingMessage() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone_removing_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…g.phone_removing_message)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String phoneSetForAll() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone_set_for_all);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.phone_set_for_all)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String phoneSetForAllItemsButton() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone_button_set_for_all);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…phone_button_set_for_all)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String phoneSetForAllItemsMessage() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone_set_for_all_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…hone_set_for_all_message)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String phoneVerified() {
        String string = this.a.getString(com.avito.android.profile.R.string.phone_verified);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.phone_verified)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    public int settingsMenuIcon() {
        return com.avito.android.profile.R.drawable.ic_up_settings_24;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String settingsMenuTitle() {
        String string = this.a.getString(com.avito.android.profile.R.string.menu_settings);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.menu_settings)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    public int shareMenuIcon() {
        return com.avito.android.ui_components.R.drawable.ic_share_24;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String shareMenuTitle() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.menu_share);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(publ…file_R.string.menu_share)");
        return string;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    public int unreadNotificationMenuIcon() {
        return com.avito.android.profile.R.drawable.ic_up_notifications_red_24;
    }

    @Override // com.avito.android.profile.cards.UserProfileResourceProvider
    @NotNull
    public String walletBalance(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "balance");
        String string = this.a.getString(com.avito.android.profile.R.string.wallet_balance, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….wallet_balance, balance)");
        return string;
    }
}
