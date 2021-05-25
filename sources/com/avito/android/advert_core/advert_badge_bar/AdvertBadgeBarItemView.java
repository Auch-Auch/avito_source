package com.avito.android.advert_core.advert_badge_bar;

import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\t2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0017H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "badges", "", "preloadCount", "", "expandTitle", "", "setBadges", "(Ljava/util/List;ILjava/lang/String;)V", "", PanelStateKt.PANEL_EXPANDED, "setExpanded", "(Z)V", "orientation", "setOrientation", "(I)V", "Lkotlin/Function1;", "badgeClickListener", "setOnBadgeClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "expandButtonClickListener", "setExpandButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertBadgeBarItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertBadgeBarItemView advertBadgeBarItemView) {
            ItemView.DefaultImpls.onUnbind(advertBadgeBarItemView);
        }
    }

    void setBadges(@NotNull List<BadgeItem> list, int i, @NotNull String str);

    void setExpandButtonClickListener(@NotNull Function0<Unit> function0);

    void setExpanded(boolean z);

    void setOnBadgeClickListener(@NotNull Function1<? super BadgeItem, Unit> function1);

    void setOrientation(int i);
}
