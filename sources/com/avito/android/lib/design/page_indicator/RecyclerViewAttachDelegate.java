package com.avito.android.lib.design.page_indicator;

import a2.g.r.g;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u000e\u001c\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\u0006\u0012\u0002\b\u00030 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\t\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/lib/design/page_indicator/RecyclerViewAttachDelegate;", "Lcom/avito/android/lib/design/page_indicator/AttachDelegate;", "Landroidx/recyclerview/widget/RecyclerView;", "view", "", "attachSelf", "(Landroidx/recyclerview/widget/RecyclerView;)V", "detachSelf", "()V", AuthSource.BOOKING_ORDER, "", "direction", AuthSource.SEND_ABUSE, "(I)V", "com/avito/android/lib/design/page_indicator/RecyclerViewAttachDelegate$adapterDataObserver$1", "f", "Lcom/avito/android/lib/design/page_indicator/RecyclerViewAttachDelegate$adapterDataObserver$1;", "adapterDataObserver", "I", "screenCenter", "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", g.a, "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "pageIndicator", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "com/avito/android/lib/design/page_indicator/RecyclerViewAttachDelegate$scrollListener$1", "e", "Lcom/avito/android/lib/design/page_indicator/RecyclerViewAttachDelegate$scrollListener$1;", "scrollListener", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "c", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Lcom/avito/android/lib/design/page_indicator/PageIndicator;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class RecyclerViewAttachDelegate implements AttachDelegate<RecyclerView> {
    public final int a;
    public RecyclerView b;
    public RecyclerView.Adapter<?> c;
    public LinearLayoutManager d;
    public final RecyclerViewAttachDelegate$scrollListener$1 e = new RecyclerViewAttachDelegate$scrollListener$1(this);
    public final RecyclerViewAttachDelegate$adapterDataObserver$1 f = new RecyclerViewAttachDelegate$adapterDataObserver$1(this);
    public final PageIndicator g;

    public RecyclerViewAttachDelegate(@NotNull PageIndicator pageIndicator) {
        Intrinsics.checkNotNullParameter(pageIndicator, "pageIndicator");
        this.g = pageIndicator;
        Resources resources = pageIndicator.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "pageIndicator.resources");
        this.a = resources.getDisplayMetrics().widthPixels / 2;
    }

    public final void a(int i) {
        LinearLayoutManager linearLayoutManager = this.d;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        LinearLayoutManager linearLayoutManager2 = this.d;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        int findLastVisibleItemPosition = (linearLayoutManager2.findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 < findLastVisibleItemPosition) {
                LinearLayoutManager linearLayoutManager3 = this.d;
                if (linearLayoutManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                }
                View childAt = linearLayoutManager3.getChildAt(i3);
                if (childAt == null) {
                    i4 = -1;
                    break;
                }
                Intrinsics.checkNotNullExpressionValue(childAt, "layoutManager.getChildAt… RecyclerView.NO_POSITION");
                int left = childAt.getLeft();
                int right = childAt.getRight();
                int abs = Math.abs(right - this.a) + Math.abs(left - this.a);
                if (i2 > abs) {
                    i4 = i3 + findFirstVisibleItemPosition;
                    i2 = abs;
                }
                i3++;
            } else {
                break;
            }
        }
        if (i4 != -1) {
            RecyclerView.Adapter<?> adapter = this.c;
            if (adapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            if (i4 < adapter.getItemCount()) {
                this.g.setSelectedPage$components_release(i4, i);
            }
        }
    }

    public final void b() {
        PageIndicator pageIndicator = this.g;
        RecyclerView.Adapter<?> adapter = this.c;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pageIndicator.setPageCount$components_release(adapter.getItemCount());
        a(0);
    }

    @Override // com.avito.android.lib.design.page_indicator.AttachDelegate
    public void detachSelf() {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.removeOnScrollListener(this.e);
        RecyclerView.Adapter<?> adapter = this.c;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter.unregisterAdapterDataObserver(this.f);
    }

    public void attachSelf(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "view");
        this.b = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.Adapter<?> adapter = recyclerView.getAdapter();
        if (adapter != null) {
            this.c = adapter;
            RecyclerView recyclerView2 = this.b;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                this.d = linearLayoutManager;
                b();
                RecyclerView recyclerView3 = this.b;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                recyclerView3.addOnScrollListener(this.e);
                RecyclerView.Adapter<?> adapter2 = this.c;
                if (adapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                adapter2.registerAdapterDataObserver(this.f);
                return;
            }
            throw new IllegalArgumentException("PageIndicator supports only LinearLayoutManager");
        }
        throw new IllegalArgumentException("RecyclerView's Adapter must be set for PageIndicator");
    }
}
