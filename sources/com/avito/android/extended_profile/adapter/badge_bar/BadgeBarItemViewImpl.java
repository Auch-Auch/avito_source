package com.avito.android.extended_profile.adapter.badge_bar;

import android.view.View;
import com.avito.android.component.badge_bar.AdvertBadgeBar;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItemView;", "", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "badges", "", "setBadges", "(Ljava/util/List;)V", "Lcom/avito/android/component/badge_bar/AdvertBadgeBar;", "s", "Lcom/avito/android/component/badge_bar/AdvertBadgeBar;", "badgeBar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeBarItemViewImpl extends BaseViewHolder implements BadgeBarItemView {
    public final AdvertBadgeBar s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeBarItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (AdvertBadgeBar) view;
    }

    @Override // com.avito.android.extended_profile.adapter.badge_bar.BadgeBarItemView
    public void setBadges(@NotNull List<BadgeItem> list) {
        Intrinsics.checkNotNullParameter(list, "badges");
        AdvertBadgeBar.setItems$default(this.s, list, 0, null, 6, null);
    }
}
