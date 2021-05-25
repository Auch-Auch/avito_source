package com.avito.android.safedeal.shared.item_decorations;

import a2.b.a.a.a;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/safedeal/shared/item_decorations/MarginItemDecorationAtPositions;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "I", "bottom", "d", "right", "c", ViewHierarchyConstants.DIMENSION_LEFT_KEY, AuthSource.SEND_ABUSE, "top", "", "e", "Ljava/util/Set;", "positions", "<init>", "(IIIILjava/util/Set;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class MarginItemDecorationAtPositions extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Set<Integer> e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarginItemDecorationAtPositions(int i, int i2, int i3, int i4, Set set, int i5, j jVar) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, set);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        if (this.e.contains(Integer.valueOf(recyclerView.getChildAdapterPosition(view)))) {
            rect.top = this.a;
            rect.left = this.c;
            rect.right = this.d;
            rect.bottom = this.b;
        }
    }

    public MarginItemDecorationAtPositions(int i, int i2, int i3, int i4, @NotNull Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "positions");
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = set;
    }
}
