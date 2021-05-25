package ru.avito.component.shortcut_navigation_bar.adapter.skeleton;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/skeleton/ScrollLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "()Z", "I", "Z", "isScrollEnabled", "setScrollEnabled", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ScrollLinearLayoutManager extends LinearLayoutManager {
    public boolean I = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollLinearLayoutManager(@NotNull Context context) {
        super(context, 0, false);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.I && super.canScrollHorizontally();
    }

    public final boolean isScrollEnabled() {
        return this.I;
    }

    public final void setScrollEnabled(boolean z) {
        this.I = z;
    }
}
