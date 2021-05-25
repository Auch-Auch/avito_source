package ru.avito.component.serp;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001'B)\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lru/avito/component/serp/GalleryBadgeDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "onDecorationViewChanged", "()V", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lru/avito/component/serp/GalleryBadgeDecoration$DecorationGravity;", "d", "Lru/avito/component/serp/GalleryBadgeDecoration$DecorationGravity;", "gravity", "", "e", "I", "photoViewType", "Landroid/view/View;", "c", "Landroid/view/View;", "getDecorationView", "()Landroid/view/View;", "decorationView", "", "f", "Z", "stickyBadgesEnabled", AuthSource.BOOKING_ORDER, "isMeasured", "Landroid/graphics/Rect;", AuthSource.SEND_ABUSE, "Landroid/graphics/Rect;", "rect", "<init>", "(Landroid/view/View;Lru/avito/component/serp/GalleryBadgeDecoration$DecorationGravity;IZ)V", "DecorationGravity", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryBadgeDecoration extends RecyclerView.ItemDecoration {
    public final Rect a;
    public boolean b;
    @NotNull
    public final View c;
    public final DecorationGravity d;
    public final int e;
    public final boolean f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/avito/component/serp/GalleryBadgeDecoration$DecorationGravity;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public enum DecorationGravity {
        TOP,
        BOTTOM
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DecorationGravity.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GalleryBadgeDecoration(View view, DecorationGravity decorationGravity, int i, boolean z, int i2, j jVar) {
        this(view, (i2 & 2) != 0 ? DecorationGravity.TOP : decorationGravity, i, z);
    }

    @NotNull
    public final View getDecorationView() {
        return this.c;
    }

    public final void onDecorationViewChanged() {
        this.b = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition;
        View view;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int findLastVisiblePositionWithViewType = RecyclerViewsKt.findLastVisiblePositionWithViewType(recyclerView, this.e);
        if (findLastVisiblePositionWithViewType >= 0 && (findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(findLastVisiblePositionWithViewType)) != null && (view = findViewHolderForLayoutPosition.itemView) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "parent.findViewHolderFor…tion)?.itemView ?: return");
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            boolean z = false;
            int i = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
            int i2 = marginLayoutParams != null ? marginLayoutParams.rightMargin : 0;
            int i3 = marginLayoutParams != null ? marginLayoutParams.topMargin : 0;
            int i4 = marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0;
            if (!this.b) {
                View view2 = this.f ? view : recyclerView;
                this.c.measure(View.MeasureSpec.makeMeasureSpec((view2.getWidth() - i) - i2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((view2.getHeight() - i3) - i4, Integer.MIN_VALUE));
                View view3 = this.c;
                view3.layout(0, 0, view3.getMeasuredWidth(), this.c.getMeasuredHeight());
                this.b = true;
            }
            int paddingStart = i - recyclerView.getPaddingStart();
            int ordinal = this.d.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    i3 = (recyclerView.getHeight() - i4) - this.c.getHeight();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            recyclerView.getDecoratedBoundsWithMargins(view, this.a);
            float f2 = (float) this.a.left;
            float x = recyclerView.getX() + ((float) recyclerView.getPaddingStart());
            if (f2 < x && RecyclerViewsKt.nextViewType(recyclerView, findLastVisiblePositionWithViewType) != this.e) {
                z = true;
            }
            if (!this.f || !z) {
                f2 = x;
            }
            canvas.save();
            canvas.translate(f2 + ((float) paddingStart), (float) i3);
            this.c.draw(canvas);
            canvas.restore();
        }
    }

    public GalleryBadgeDecoration(@NotNull View view, @NotNull DecorationGravity decorationGravity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(view, "decorationView");
        Intrinsics.checkNotNullParameter(decorationGravity, "gravity");
        this.c = view;
        this.d = decorationGravity;
        this.e = i;
        this.f = z;
        this.a = new Rect();
    }
}
