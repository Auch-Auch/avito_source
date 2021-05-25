package com.avito.android.brandspace.view;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/brandspace/view/BrandspaceView;", "Lcom/avito/android/util/architecture_components/auto_clear/LifecycleDestroyable;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "", "showLoading", "()V", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "showItems", "(Ljava/util/List;)V", "showItemsWithPostRefresh", "", "message", "showError", "(Ljava/lang/String;)V", "title", "showTitle", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "getItemVisibilityTracker", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceView extends LifecycleDestroyable, FavoriteAdvertsView {
    @NotNull
    ItemVisibilityTracker getItemVisibilityTracker();

    void showError(@NotNull String str);

    void showItems(@NotNull List<? extends BrandspaceItem> list);

    void showItemsWithPostRefresh(@NotNull List<? extends BrandspaceItem> list);

    void showLoading();

    void showTitle(@NotNull String str);
}
