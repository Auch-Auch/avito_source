package com.avito.android.short_term_rent.utils;

import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/short_term_rent/utils/ShadowScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "Landroid/widget/FrameLayout;", AuthSource.SEND_ABUSE, "Landroid/widget/FrameLayout;", "contentHolder", "<init>", "(Landroid/widget/FrameLayout;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class ShadowScrollListener extends RecyclerView.OnScrollListener {
    public final FrameLayout a;

    public ShadowScrollListener(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "contentHolder");
        this.a = frameLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (recyclerView.canScrollVertically(-1)) {
            FrameLayout frameLayout = this.a;
            frameLayout.setForeground(frameLayout.getContext().getDrawable(R.drawable.shadow_toolbar));
            return;
        }
        this.a.setForeground(null);
    }
}
