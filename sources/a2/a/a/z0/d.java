package a2.a.a.z0;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.hints.HintsDialogFragment;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class d implements NestedScrollView.OnScrollChangeListener {
    public final /* synthetic */ HintsDialogFragment a;

    public d(HintsDialogFragment hintsDialogFragment) {
        this.a = hintsDialogFragment;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public final void onScrollChange(@NotNull NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(nestedScrollView, "<anonymous parameter 0>");
        if (this.a.h != null) {
            HintsDialogFragment.access$getDecoration$p(this.a).setVerticalScrollOffset(i2);
            if (this.a.m) {
                this.a.m = false;
                HintsDialogFragment.access$getDecoration$p(this.a).setVerticalScrollOffset(0);
                RecyclerView.Adapter adapter = HintsDialogFragment.access$getRecyclerView$p(this.a).getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                RecyclerView.LayoutManager layoutManager = HintsDialogFragment.access$getRecyclerView$p(this.a).getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.requestLayout();
                }
            }
        }
    }
}
