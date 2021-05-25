package ru.avito.component.serp;

import android.content.Context;
import com.avito.android.lib.design.avito.R;
import com.avito.android.lib.expected.badge_bar.BadgeParams;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayoutsKt;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.remote.model.badge_bar.SerpBadgeStyle;
import com.avito.android.util.Collections;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "", "bindBadges", "(Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class BadgeBarsKt {
    public static final void bindBadges(@NotNull CompactFlexibleLayout compactFlexibleLayout, @Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        Intrinsics.checkNotNullParameter(compactFlexibleLayout, "$this$bindBadges");
        if (Collections.isNullOrEmpty(list)) {
            Views.hide(compactFlexibleLayout);
            return;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            String title = t.getTitle();
            Context context = compactFlexibleLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            SerpBadgeStyle style = t.getStyle();
            UniversalColor universalColor = null;
            int colorFrom = ContextsKt.getColorFrom(context, style != null ? style.getFontColor() : null, R.color.avito_constant_black);
            Context context2 = compactFlexibleLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            SerpBadgeStyle style2 = t.getStyle();
            if (style2 != null) {
                universalColor = style2.getBackgroundColor();
            }
            arrayList.add(new BadgeParams(title, colorFrom, ContextsKt.getColorFrom(context2, universalColor, R.color.avito_constant_white), t.getShouldShowOnboarding()));
        }
        Views.show(compactFlexibleLayout);
        CompactFlexibleLayoutsKt.setBadgeParams(compactFlexibleLayout, arrayList, badgeViewListener);
    }

    public static /* synthetic */ void bindBadges$default(CompactFlexibleLayout compactFlexibleLayout, List list, BadgeViewListener badgeViewListener, int i, Object obj) {
        if ((i & 2) != 0) {
            badgeViewListener = null;
        }
        bindBadges(compactFlexibleLayout, list, badgeViewListener);
    }
}
