package com.avito.android.item_visibility_tracker;

import android.graphics.Rect;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.data_source.DataSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\"J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00062\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H&¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/graphics/Rect;", "viewportInset", "", "subscribe", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/graphics/Rect;)V", "unsubscribe", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "updateViewportInset", "(IIII)V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "Lcom/avito/konveyor/data_source/DataSource;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "recyclerView", "", "forceRemove", "updateTrackingKeys", "(Landroidx/recyclerview/widget/RecyclerView;Z)V", "clear", "()V", "getViewportInset", "()Landroid/graphics/Rect;", "Item", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface ItemVisibilityTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void subscribe$default(ItemVisibilityTracker itemVisibilityTracker, RecyclerView recyclerView, Rect rect, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    rect = null;
                }
                itemVisibilityTracker.subscribe(recyclerView, rect);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
        }

        public static /* synthetic */ void updateViewportInset$default(ItemVisibilityTracker itemVisibilityTracker, int i, int i2, int i3, int i4, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    i = itemVisibilityTracker.getViewportInset().left;
                }
                if ((i5 & 2) != 0) {
                    i2 = itemVisibilityTracker.getViewportInset().top;
                }
                if ((i5 & 4) != 0) {
                    i3 = itemVisibilityTracker.getViewportInset().right;
                }
                if ((i5 & 8) != 0) {
                    i4 = itemVisibilityTracker.getViewportInset().bottom;
                }
                itemVisibilityTracker.updateViewportInset(i, i2, i3, i4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateViewportInset");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;", "", "", "getTrackId", "()J", "trackId", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Item {
        long getTrackId();
    }

    void clear();

    @NotNull
    Rect getViewportInset();

    void onDataSourceChanged(@NotNull DataSource<?> dataSource);

    @Nullable
    Bundle onSaveState();

    void subscribe(@NotNull RecyclerView recyclerView, @Nullable Rect rect);

    void unsubscribe(@NotNull RecyclerView recyclerView);

    void updateTrackingKeys(@NotNull RecyclerView recyclerView, boolean z);

    void updateViewportInset(int i, int i2, int i3, int i4);
}
