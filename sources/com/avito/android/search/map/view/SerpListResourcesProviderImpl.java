package com.avito.android.search.map.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Window;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.serp_core.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0007R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/search/map/view/SerpListResourcesProviderImpl;", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "getColumnsCount", "(Lcom/avito/android/remote/model/SerpDisplayType;)I", "()I", "", "canSwitchDisplayType", "()Z", "getColumnsCountForList", "hasShortcuts", "getSerpPaddingTop", "(Z)I", "serpSheet", "getBottomSheetPeekHeight", "getSearchBarHeight", "getShortcutsHeight", "", "getGradientOffset", "()F", "getMinHeightForPinAdverts", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Landroid/app/Activity;", AuthSource.SEND_ABUSE, "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;Landroid/content/res/Resources;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SerpListResourcesProviderImpl implements SerpListResourcesProvider {
    public final Activity a;
    public final Resources b;

    @Inject
    public SerpListResourcesProviderImpl(@NotNull Activity activity, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = activity;
        this.b = resources;
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public boolean canSwitchDisplayType() {
        return this.b.getBoolean(R.bool.can_switch_display_type);
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public int getBottomSheetPeekHeight(boolean z) {
        Rect rect = new Rect();
        Window window = this.a.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = rect.height() - this.b.getDimensionPixelSize(com.avito.android.bottom_navigation.R.dimen.bottom_nav_height);
        if (!z) {
            height -= getShortcutsHeight() + getSearchBarHeight();
        }
        int i = (int) (((float) height) * 0.5f);
        return z ? i + getSearchBarHeight() : i;
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public int getColumnsCount(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        if (!canSwitchDisplayType() || !serpDisplayType.isSingleColumn()) {
            return getColumnsCount();
        }
        return getColumnsCountForList();
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public int getColumnsCountForList() {
        return 1;
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public float getGradientOffset() {
        return ((float) 1) - (((float) (getSearchBarHeight() / 2)) / ((float) SerpListResourcesProvider.DefaultImpls.getBottomSheetPeekHeight$default(this, false, 1, null)));
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public int getMinHeightForPinAdverts() {
        return 4;
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public int getSearchBarHeight() {
        return this.b.getDimensionPixelSize(com.avito.android.search.map.R.dimen.search_map_search_bar_with_padding_height);
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public int getSerpPaddingTop(boolean z) {
        if (z) {
            return getShortcutsHeight();
        }
        return 0;
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public int getShortcutsHeight() {
        return this.b.getDimensionPixelSize(com.avito.android.search.map.R.dimen.search_map_shortcuts_height);
    }

    @Override // com.avito.android.search.map.view.SerpListResourcesProvider
    public int getColumnsCount() {
        return this.b.getInteger(com.avito.android.ui_components.R.integer.serp_columns);
    }
}
