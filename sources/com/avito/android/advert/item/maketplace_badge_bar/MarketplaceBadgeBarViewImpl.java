package com.avito.android.advert.item.maketplace_badge_bar;

import android.content.Context;
import android.view.View;
import com.avito.android.lib.design.avito.R;
import com.avito.android.lib.expected.badge_bar.BadgeParams;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayoutsKt;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadge;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadgeStyle;
import com.avito.android.util.color.ContextsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/maketplace_badge_bar/MarketplaceBadgeBarViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/maketplace_badge_bar/MarketplaceBadgeBarView;", "", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadge;", "badges", "", "setBadges", "(Ljava/util/List;)V", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "s", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "advertBadgeBar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceBadgeBarViewImpl extends BaseViewHolder implements MarketplaceBadgeBarView {
    public final CompactFlexibleLayout s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceBadgeBarViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (CompactFlexibleLayout) view;
    }

    @Override // com.avito.android.advert.item.maketplace_badge_bar.MarketplaceBadgeBarView
    public void setBadges(@NotNull List<AdvertBadge> list) {
        Intrinsics.checkNotNullParameter(list, "badges");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            UniversalColor universalColor = null;
            if (it.hasNext()) {
                T next = it.next();
                String title = next.getTitle();
                Context context = this.s.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "advertBadgeBar.context");
                AdvertBadgeStyle style = next.getStyle();
                int colorFrom = ContextsKt.getColorFrom(context, style != null ? style.getFontColor() : null, R.color.avito_constant_black);
                Context context2 = this.s.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "advertBadgeBar.context");
                AdvertBadgeStyle style2 = next.getStyle();
                if (style2 != null) {
                    universalColor = style2.getBackgroundColor();
                }
                arrayList.add(new BadgeParams(title, colorFrom, ContextsKt.getColorFrom(context2, universalColor, R.color.avito_constant_white), false));
            } else {
                CompactFlexibleLayoutsKt.setBadgeParams(this.s, arrayList, null);
                return;
            }
        }
    }
}
