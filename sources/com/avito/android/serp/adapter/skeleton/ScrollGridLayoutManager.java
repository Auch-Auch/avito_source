package com.avito.android.serp.adapter.skeleton;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/adapter/skeleton/ScrollGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollVertically", "()Z", "R", "Z", "isScrollEnabled", "setScrollEnabled", "(Z)V", "Landroid/content/Context;", "context", "", "spanCount", "<init>", "(Landroid/content/Context;I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ScrollGridLayoutManager extends GridLayoutManager {
    public boolean R = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollGridLayoutManager(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.R && super.canScrollVertically();
    }

    public final boolean isScrollEnabled() {
        return this.R;
    }

    public final void setScrollEnabled(boolean z) {
        this.R = z;
    }
}
