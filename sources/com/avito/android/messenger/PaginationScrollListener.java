package com.avito.android.messenger;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018¢\u0006\u0004\b\u001f\u0010 J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR*\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/PaginationScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", AuthSource.SEND_ABUSE, "()V", "Landroidx/recyclerview/widget/LinearLayoutManager;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "value", "Z", "getPaginationEnabled", "()Z", "setPaginationEnabled", "(Z)V", "paginationEnabled", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "paginationCallback", "c", "I", "paginationThreshold", "<init>", "(Landroidx/recyclerview/widget/LinearLayoutManager;ILkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PaginationScrollListener extends RecyclerView.OnScrollListener {
    public boolean a;
    public final LinearLayoutManager b;
    public final int c;
    public final Function0<Unit> d;

    public PaginationScrollListener(@NotNull LinearLayoutManager linearLayoutManager, int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(function0, "paginationCallback");
        this.b = linearLayoutManager;
        this.c = i;
        this.d = function0;
    }

    public final void a() {
        int itemCount;
        if (this.a && (itemCount = this.b.getItemCount()) > 0) {
            int childCount = this.b.getChildCount();
            int findFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition + childCount >= itemCount - this.c) {
                this.d.invoke();
            }
        }
    }

    public final boolean getPaginationEnabled() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        a();
    }

    public final void setPaginationEnabled(boolean z) {
        if (this.a != z) {
            this.a = z;
            a();
        }
    }
}
