package com.avito.android.advert_core.advert_badge_bar;

import android.view.View;
import com.avito.android.component.badge_bar.AdvertBadgeBar;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J-\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItemView;", "", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "badges", "", "preloadCount", "", "expandTitle", "", "setBadges", "(Ljava/util/List;ILjava/lang/String;)V", "orientation", "setOrientation", "(I)V", "Lkotlin/Function1;", "badgeClickListener", "setOnBadgeClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "expandButtonClickListener", "setExpandButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", PanelStateKt.PANEL_EXPANDED, "setExpanded", "(Z)V", "Lcom/avito/android/component/badge_bar/AdvertBadgeBar;", "s", "Lcom/avito/android/component/badge_bar/AdvertBadgeBar;", "advertBadgeBar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadgeBarItemViewImpl extends BaseViewHolder implements AdvertBadgeBarItemView {
    public final AdvertBadgeBar s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertBadgeBarItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (AdvertBadgeBar) view;
    }

    @Override // com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarItemView
    public void setBadges(@NotNull List<BadgeItem> list, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "badges");
        Intrinsics.checkNotNullParameter(str, "expandTitle");
        this.s.setItems(list, i, str);
    }

    @Override // com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarItemView
    public void setExpandButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "expandButtonClickListener");
        this.s.setExpandButtonClickListener(function0);
    }

    @Override // com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarItemView
    public void setExpanded(boolean z) {
        this.s.setExpanded(z);
    }

    @Override // com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarItemView
    public void setOnBadgeClickListener(@NotNull Function1<? super BadgeItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "badgeClickListener");
        this.s.setOnBadgeClickListener(function1);
    }

    @Override // com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarItemView
    public void setOrientation(int i) {
        this.s.setOrientation(i);
    }
}
