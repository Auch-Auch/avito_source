package com.avito.android.lib.expected.badge_bar;

import android.content.Context;
import android.view.ViewGroup;
import com.avito.android.lib.util.ReuseChildrenHelper;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/BadgeBarChildrenHelper;", "Lcom/avito/android/lib/util/ReuseChildrenHelper;", "Lcom/avito/android/lib/expected/badge_bar/BadgeParams;", "Lcom/avito/android/lib/expected/badge_bar/BadgeView;", "createChild", "()Lcom/avito/android/lib/expected/badge_bar/BadgeView;", "view", "data", "", VKApiConst.POSITION, "", "bindData", "(Lcom/avito/android/lib/expected/badge_bar/BadgeView;Lcom/avito/android/lib/expected/badge_bar/BadgeParams;I)V", "", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindDataForChildren", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "container", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "<init>", "(Landroid/view/ViewGroup;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeBarChildrenHelper extends ReuseChildrenHelper<BadgeParams, BadgeView> {
    public BadgeViewListener a;
    public final ViewGroup b;

    public BadgeBarChildrenHelper(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.b = viewGroup;
    }

    public final void bindDataForChildren(@NotNull List<BadgeParams> list, @Nullable BadgeViewListener badgeViewListener) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.a = badgeViewListener;
        reuseChildrenView(this.b, list);
    }

    public void bindData(@NotNull BadgeView badgeView, @NotNull BadgeParams badgeParams, int i) {
        BadgeViewListener badgeViewListener;
        Intrinsics.checkNotNullParameter(badgeView, "view");
        Intrinsics.checkNotNullParameter(badgeParams, "data");
        badgeView.setBackgroundColor(badgeParams.getBackgroundColor());
        badgeView.setTextColor(badgeParams.getTextColor());
        badgeView.setText(badgeParams.getText());
        if (badgeParams.getShouldShowOnboarding() && (badgeViewListener = this.a) != null) {
            badgeViewListener.onBadgeDataBounded(badgeView);
        }
    }

    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    @NotNull
    public BadgeView createChild() {
        Context context = this.b.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        return new BadgeView(context, null, 0, 0, 14, null);
    }
}
