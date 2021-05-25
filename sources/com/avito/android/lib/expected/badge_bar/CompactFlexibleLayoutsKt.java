package com.avito.android.lib.expected.badge_bar;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "", "Lcom/avito/android/lib/expected/badge_bar/BadgeParams;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "", "setBadgeParams", "(Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "components_release"}, k = 2, mv = {1, 4, 2})
public final class CompactFlexibleLayoutsKt {
    public static final void setBadgeParams(@NotNull CompactFlexibleLayout compactFlexibleLayout, @NotNull List<BadgeParams> list, @Nullable BadgeViewListener badgeViewListener) {
        Intrinsics.checkNotNullParameter(compactFlexibleLayout, "$this$setBadgeParams");
        Intrinsics.checkNotNullParameter(list, "badges");
        new BadgeBarChildrenHelper(compactFlexibleLayout).bindDataForChildren(list, badgeViewListener);
    }
}
