package com.avito.android.profile.cards;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H'¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0010H'¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u0010H'¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "", "", "balance", "walletBalance", "(Ljava/lang/String;)Ljava/lang/String;", "shareMenuTitle", "()Ljava/lang/String;", "phoneRemovingMessage", "phoneRemovingButton", "phoneSetForAllItemsMessage", "phoneSetForAllItemsButton", "phoneRemoved", "phoneAttached", "phoneVerified", "phoneSetForAll", "", "shareMenuIcon", "()I", "menuTintColorAttr", "settingsMenuIcon", "settingsMenuTitle", "notificationMenuIcon", "unreadNotificationMenuIcon", "notificationMenuTitle", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface UserProfileResourceProvider {
    @AttrRes
    int menuTintColorAttr();

    @DrawableRes
    int notificationMenuIcon();

    @NotNull
    String notificationMenuTitle();

    @NotNull
    String phoneAttached();

    @NotNull
    String phoneRemoved();

    @NotNull
    String phoneRemovingButton();

    @NotNull
    String phoneRemovingMessage();

    @NotNull
    String phoneSetForAll();

    @NotNull
    String phoneSetForAllItemsButton();

    @NotNull
    String phoneSetForAllItemsMessage();

    @NotNull
    String phoneVerified();

    @DrawableRes
    int settingsMenuIcon();

    @NotNull
    String settingsMenuTitle();

    @DrawableRes
    int shareMenuIcon();

    @NotNull
    String shareMenuTitle();

    @DrawableRes
    int unreadNotificationMenuIcon();

    @NotNull
    String walletBalance(@NotNull String str);
}
