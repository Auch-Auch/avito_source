package com.avito.android.ui.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/ui/adapter/GridLayoutNoLoaderAppendingHandler;", "Lcom/avito/android/ui/adapter/AppendingHandler;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapterDelegate", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "", VKApiConst.POSITION, "appendIfNeeded", "(I)V", "", "isAppendingViewPosition", "(I)Z", "getCount", "()I", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "delegate", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "Lcom/avito/android/ui/adapter/AppendingListener;", "getAppendingListener", "()Lcom/avito/android/ui/adapter/AppendingListener;", "setAppendingListener", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "c", "Z", "prefetchEnabled", "Lcom/avito/android/ui/adapter/GridPositionProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/adapter/GridPositionProvider;", "gridPositionProvider", "<init>", "(Lcom/avito/android/ui/adapter/GridPositionProvider;Z)V", "appending-list_release"}, k = 1, mv = {1, 4, 2})
public final class GridLayoutNoLoaderAppendingHandler implements AppendingHandler {
    public RecyclerView.Adapter<?> a;
    public AppendingListener appendingListener;
    public final GridPositionProvider b;
    public final boolean c;

    public GridLayoutNoLoaderAppendingHandler(@NotNull GridPositionProvider gridPositionProvider, boolean z) {
        Intrinsics.checkNotNullParameter(gridPositionProvider, "gridPositionProvider");
        this.b = gridPositionProvider;
        this.c = z;
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public void appendIfNeeded(int i) {
        AppendingListener appendingListener2 = this.appendingListener;
        if (appendingListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appendingListener");
        }
        if (appendingListener2.canAppend()) {
            int rows = this.b.getRows();
            int rowForPosition = this.b.getRowForPosition(i);
            if (rowForPosition >= rows + -1 || (this.c && GridLayoutNoLoaderAppendingHandlerKt.isRowToPrefetch(this.b.getColumnsCount(), rows, rowForPosition))) {
                AppendingListener appendingListener3 = this.appendingListener;
                if (appendingListener3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appendingListener");
                }
                appendingListener3.onAppend();
            }
        }
    }

    @NotNull
    public final AppendingListener getAppendingListener() {
        AppendingListener appendingListener2 = this.appendingListener;
        if (appendingListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appendingListener");
        }
        return appendingListener2;
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public int getCount() {
        RecyclerView.Adapter<?> adapter = this.a;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return adapter.getItemCount();
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public boolean isAppendingViewPosition(int i) {
        return false;
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public void setAdapterDelegate(@NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.a = adapter;
    }

    public final void setAppendingListener(@NotNull AppendingListener appendingListener2) {
        Intrinsics.checkNotNullParameter(appendingListener2, "<set-?>");
        this.appendingListener = appendingListener2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GridLayoutNoLoaderAppendingHandler(GridPositionProvider gridPositionProvider, boolean z, int i, j jVar) {
        this(gridPositionProvider, (i & 2) != 0 ? false : z);
    }
}
