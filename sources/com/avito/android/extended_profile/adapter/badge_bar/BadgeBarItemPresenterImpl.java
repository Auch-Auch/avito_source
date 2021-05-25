package com.avito.android.extended_profile.adapter.badge_bar;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItemPresenterImpl;", "Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItemPresenter;", "Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItemView;", "view", "Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItemView;Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeBarItemPresenterImpl implements BadgeBarItemPresenter {
    public final Consumer<ExtendedProfileItemAction> a;

    @Inject
    public BadgeBarItemPresenterImpl(@NotNull Consumer<ExtendedProfileItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull BadgeBarItemView badgeBarItemView, @NotNull BadgeBarItem badgeBarItem, int i) {
        Intrinsics.checkNotNullParameter(badgeBarItemView, "view");
        Intrinsics.checkNotNullParameter(badgeBarItem, "item");
        badgeBarItemView.setBadges(badgeBarItem.getBadges());
    }
}
