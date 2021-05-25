package com.avito.android.serp.adapter.rich_snippets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemView;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemView;
import com.avito.android.ui_components.R;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b(\u0010)J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0019\u0010\u001e\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016¨\u0006*"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Canvas;", "c", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)Z", "", "d", "I", "dragIconTopOffset", "verticalPadding", "dragIconHeight", "f", "Z", "getWithDragIcon", "()Z", "withDragIcon", "Landroid/graphics/drawable/Drawable;", "e", "Lkotlin/Lazy;", AuthSource.SEND_ABUSE, "()Landroid/graphics/drawable/Drawable;", "dragDrawable", "horizontalPadding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class RichSnippetItemDecorator extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Lazy e;
    public final boolean f;

    public static final class a extends Lambda implements Function0<Drawable> {
        public final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.a = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Drawable invoke() {
            Drawable drawable = this.a.getDrawable(R.drawable.map_adverts_drag_icon);
            Intrinsics.checkNotNull(drawable);
            Intrinsics.checkNotNullExpressionValue(drawable, "context.getDrawable(ui_R….map_adverts_drag_icon)!!");
            return drawable;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RichSnippetItemDecorator(Context context, boolean z, int i, j jVar) {
        this(context, (i & 2) != 0 ? false : z);
    }

    public final Drawable a() {
        return (Drawable) this.e.getValue();
    }

    public final boolean b(RecyclerView recyclerView, View view) {
        if (view == null) {
            return false;
        }
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if ((childViewHolder instanceof AdvertRichItemView) || (childViewHolder instanceof AdvertRichJobItemView)) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a2.b.a.a.a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (b(recyclerView, view)) {
            int i = this.a;
            rect.left = -i;
            rect.right = -i;
            int indexOfChild = recyclerView.indexOfChild(view) - 1;
            int i2 = 0;
            if (indexOfChild >= 0 && !b(recyclerView, gridLayoutManager.getChildAt(indexOfChild))) {
                i2 = this.b;
            }
            rect.top = i2;
        }
        if (this.f && gridLayoutManager.getSpanSizeLookup().getSpanGroupIndex(childAdapterPosition, gridLayoutManager.getSpanCount()) == 0) {
            rect.top += this.c;
        }
    }

    public final boolean getWithDragIcon() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        View childAt;
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
        if (this.f && (childAt = recyclerView.getChildAt(0)) != null) {
            int right = ((recyclerView.getRight() - recyclerView.getLeft()) / 2) + recyclerView.getLeft();
            int intrinsicWidth = a().getIntrinsicWidth() / 2;
            int top = childAt.getTop() - (this.c - this.d);
            a().setBounds(right - intrinsicWidth, top, right + intrinsicWidth, a().getIntrinsicHeight() + top);
            a().draw(canvas);
        }
    }

    public RichSnippetItemDecorator(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f = z;
        this.a = context.getResources().getDimensionPixelSize(R.dimen.serp_horizontal_padding);
        this.b = context.getResources().getDimensionPixelSize(R.dimen.serp_vertical_padding);
        this.c = context.getResources().getDimensionPixelSize(R.dimen.rich_snippet_map_drag_icon_height);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.rich_snippet_map_drag_icon_top_offset);
        this.e = c.lazy(new a(context));
    }
}
