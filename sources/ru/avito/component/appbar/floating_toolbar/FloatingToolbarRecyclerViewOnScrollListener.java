package ru.avito.component.appbar.floating_toolbar;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lru/avito/component/appbar/floating_toolbar/FloatingToolbarRecyclerViewOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lru/avito/component/appbar/floating_toolbar/ToolbarScrollManager;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "scrollX", "scrollY", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "showToolbar", "()V", "", "isScrolled", "()Z", AuthSource.SEND_ABUSE, "I", "verticalOffset", "Lru/avito/component/appbar/floating_toolbar/FloatingToolbar;", AuthSource.BOOKING_ORDER, "Lru/avito/component/appbar/floating_toolbar/FloatingToolbar;", "floatingToolbar", "Landroid/view/View;", "toolbarContainer", "toolbar", "shadow", "isConcealableShadow", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FloatingToolbarRecyclerViewOnScrollListener extends RecyclerView.OnScrollListener implements ToolbarScrollManager {
    public int a;
    public final FloatingToolbar b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatingToolbarRecyclerViewOnScrollListener(View view, View view2, View view3, boolean z, int i, j jVar) {
        this(view, view2, view3, (i & 8) != 0 ? true : z);
    }

    @Override // ru.avito.component.appbar.floating_toolbar.ToolbarScrollManager
    public boolean isScrolled() {
        return this.a != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (i == 0) {
            this.b.adjustToolbarVisibility();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        this.a = computeVerticalScrollOffset;
        this.b.onContentScroll(i2, computeVerticalScrollOffset);
    }

    @Override // ru.avito.component.appbar.floating_toolbar.ToolbarScrollManager
    public void showToolbar() {
        this.b.showToolbar();
    }

    public FloatingToolbarRecyclerViewOnScrollListener(@NotNull View view, @NotNull View view2, @NotNull View view3, boolean z) {
        Intrinsics.checkNotNullParameter(view, "toolbarContainer");
        Intrinsics.checkNotNullParameter(view2, "toolbar");
        Intrinsics.checkNotNullParameter(view3, "shadow");
        this.b = new FloatingToolbarImpl(view, view2, view3, z);
    }
}
