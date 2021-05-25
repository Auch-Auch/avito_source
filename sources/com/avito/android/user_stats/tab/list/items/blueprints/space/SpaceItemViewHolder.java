package com.avito.android.user_stats.tab.list.items.blueprints.space;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/space/SpaceItemViewHolder;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/space/SpaceItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "setHeight", "(I)V", "Landroid/widget/FrameLayout;", "s", "Landroid/widget/FrameLayout;", "frameView", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "t", "Landroid/util/DisplayMetrics;", "displayMetrics", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class SpaceItemViewHolder extends BaseViewHolder implements SpaceItemView {
    public final FrameLayout s;
    public final DisplayMetrics t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpaceItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (FrameLayout) view;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.context.resources");
        this.t = resources.getDisplayMetrics();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SpaceItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceItemView
    public void setHeight(int i) {
        FrameLayout frameLayout = this.s;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = (int) TypedValue.applyDimension(1, (float) i, this.t);
        Unit unit = Unit.INSTANCE;
        frameLayout.setLayoutParams(layoutParams);
        this.s.requestLayout();
    }
}
