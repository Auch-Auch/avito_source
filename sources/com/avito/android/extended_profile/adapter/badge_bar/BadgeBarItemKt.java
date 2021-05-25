package com.avito.android.extended_profile.adapter.badge_bar;

import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.remote.model.ExtendedProfileBadgeBar;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadge;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadgeStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileBadgeBar;", "Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItem;", "toBadgeBarItem", "(Lcom/avito/android/remote/model/ExtendedProfileBadgeBar;)Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItem;", "extended-profile_release"}, k = 2, mv = {1, 4, 2})
public final class BadgeBarItemKt {
    @NotNull
    public static final BadgeBarItem toBadgeBarItem(@NotNull ExtendedProfileBadgeBar extendedProfileBadgeBar) {
        List list;
        UniversalImage icon;
        Intrinsics.checkNotNullParameter(extendedProfileBadgeBar, "$this$toBadgeBarItem");
        List<AdvertBadge> badges = extendedProfileBadgeBar.getBadges();
        if (badges != null) {
            list = new ArrayList(e.collectionSizeOrDefault(badges, 10));
            for (T t : badges) {
                String valueOf = String.valueOf(t.getId());
                int id = t.getId();
                String title = t.getTitle();
                String description = t.getDescription();
                if (description == null) {
                    description = "";
                }
                AdvertBadgeStyle style = t.getStyle();
                UniversalColor backgroundColor = style != null ? style.getBackgroundColor() : null;
                AdvertBadgeStyle style2 = t.getStyle();
                UniversalColor backgroundPressedColor = style2 != null ? style2.getBackgroundPressedColor() : null;
                AdvertBadgeStyle style3 = t.getStyle();
                UniversalColor fontColor = style3 != null ? style3.getFontColor() : null;
                AdvertBadgeStyle style4 = t.getStyle();
                list.add(new BadgeItem(valueOf, id, title, description, backgroundColor, backgroundPressedColor, fontColor, 1, 1, (style4 == null || (icon = style4.getIcon()) == null) ? null : icon.getImage(), t.getUri()));
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return new BadgeBarItem(null, null, list, 3, null);
    }
}
