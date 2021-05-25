package com.avito.android.ui.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/ui/adapter/GridLayoutAppendingHandler;", "Lcom/avito/android/ui/adapter/AppendingHandler;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapterDelegate", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "", VKApiConst.POSITION, "appendIfNeeded", "(I)V", "", "isAppendingViewPosition", "(I)Z", "getCount", "()I", "Lcom/avito/android/ui/adapter/GridPositionProvider;", "c", "Lcom/avito/android/ui/adapter/GridPositionProvider;", "gridPositionProvider", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "delegate", "Lcom/avito/android/ui/adapter/AppendingListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "<init>", "(Lcom/avito/android/ui/adapter/AppendingListener;Lcom/avito/android/ui/adapter/GridPositionProvider;)V", "appending-list_release"}, k = 1, mv = {1, 4, 2})
public final class GridLayoutAppendingHandler implements AppendingHandler {
    public RecyclerView.Adapter<?> a;
    public final AppendingListener b;
    public final GridPositionProvider c;

    public GridLayoutAppendingHandler(@NotNull AppendingListener appendingListener, @NotNull GridPositionProvider gridPositionProvider) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        Intrinsics.checkNotNullParameter(gridPositionProvider, "gridPositionProvider");
        this.b = appendingListener;
        this.c = gridPositionProvider;
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public void appendIfNeeded(int i) {
        if (this.b.canAppend()) {
            boolean z = true;
            if (this.c.getRowForPosition(i) != this.c.getRows() - 1) {
                z = false;
            }
            if (z) {
                this.b.onAppend();
            }
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public int getCount() {
        RecyclerView.Adapter<?> adapter = this.a;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        int itemCount = adapter.getItemCount();
        if (!this.b.canAppend() || itemCount <= 0) {
            return itemCount;
        }
        int i = 0;
        int rows = this.c.getRows() - 1;
        int i2 = itemCount - 1;
        while (i2 >= 0 && this.c.getRowForPosition(i2) == rows) {
            i++;
            i2--;
        }
        return (itemCount - i) + 1;
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public boolean isAppendingViewPosition(int i) {
        return this.b.canAppend() && i == getCount() - 1;
    }

    @Override // com.avito.android.ui.adapter.AppendingHandler
    public void setAdapterDelegate(@NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.a = adapter;
    }
}
