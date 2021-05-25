package com.avito.android.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001&J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR'\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0016¨\u0006'"}, d2 = {"Lcom/avito/android/ui/VerticalListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/drawable/Drawable;", AuthSource.SEND_ABUSE, "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$State;)Landroid/graphics/drawable/Drawable;", "", "d", "I", "rightPadding", "", "e", "Z", "drawForLastItem", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getDividers", "()Ljava/util/Map;", "dividers", "Landroid/graphics/drawable/Drawable;", "defaultDivider", "c", "leftPadding", "Builder", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalListItemDecoration extends RecyclerView.ItemDecoration {
    public final Drawable a;
    @NotNull
    public final Map<Integer, Drawable> b;
    public final int c;
    public final int d;
    public final boolean e;

    public VerticalListItemDecoration(Drawable drawable, Map map, int i, int i2, boolean z, j jVar) {
        this.a = drawable;
        this.b = map;
        this.c = i;
        this.d = i2;
        this.e = z;
    }

    public final Drawable a(View view, RecyclerView.State state) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int viewAdapterPosition = ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
        if (!this.e && viewAdapterPosition == state.getItemCount() - 1) {
            return null;
        }
        if (this.b.containsKey(Integer.valueOf(viewAdapterPosition))) {
            return this.b.get(Integer.valueOf(viewAdapterPosition));
        }
        return this.a;
    }

    @NotNull
    public final Map<Integer, Drawable> getDividers() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        Drawable a3 = a(view, state);
        rect.set(0, 0, 0, a3 != null ? a3.getIntrinsicHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft() + this.c;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.d;
        int childCount = recyclerView.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = recyclerView.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "view");
                Drawable a3 = a(childAt, state);
                Drawable mutate = a3 != null ? a3.mutate() : null;
                if (mutate != null) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                    int translationY = (int) (childAt.getTranslationY() + ((float) (childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin)));
                    mutate.setAlpha((int) (childAt.getAlpha() * ((float) 255)));
                    mutate.setBounds(paddingLeft, translationY, width, mutate.getIntrinsicHeight() + translationY);
                    mutate.draw(canvas);
                }
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/ui/VerticalListItemDecoration$Builder;", "", "", FirebaseAnalytics.Param.INDEX, "disableDividerForItemAt", "(I)Lcom/avito/android/ui/VerticalListItemDecoration$Builder;", "Landroid/graphics/drawable/Drawable;", "divider", "setDividerForItemAt", "(ILandroid/graphics/drawable/Drawable;)Lcom/avito/android/ui/VerticalListItemDecoration$Builder;", "leftPadding", "rightPadding", "setPadding", "(II)Lcom/avito/android/ui/VerticalListItemDecoration$Builder;", "", "enabled", "drawForLastItem", "(Z)Lcom/avito/android/ui/VerticalListItemDecoration$Builder;", "Lcom/avito/android/ui/VerticalListItemDecoration;", "build", "()Lcom/avito/android/ui/VerticalListItemDecoration;", "c", "I", "d", "Z", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "dividers", AuthSource.BOOKING_ORDER, "e", "Landroid/graphics/drawable/Drawable;", "defaultDivider", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        public final Map<Integer, Drawable> a;
        public int b;
        public int c;
        public boolean d;
        public final Drawable e;

        public Builder() {
            this(null, 1, null);
        }

        public Builder(@Nullable Drawable drawable) {
            this.e = drawable;
            this.a = new LinkedHashMap();
            this.d = true;
        }

        @NotNull
        public final VerticalListItemDecoration build() {
            return new VerticalListItemDecoration(this.e, this.a, this.b, this.c, this.d, null);
        }

        @NotNull
        public final Builder disableDividerForItemAt(int i) {
            this.a.put(Integer.valueOf(i), null);
            return this;
        }

        @NotNull
        public final Builder drawForLastItem(boolean z) {
            this.d = z;
            return this;
        }

        @NotNull
        public final Builder setDividerForItemAt(int i, @Nullable Drawable drawable) {
            this.a.put(Integer.valueOf(i), drawable);
            return this;
        }

        @NotNull
        public final Builder setPadding(int i, int i2) {
            this.b = i;
            this.c = i2;
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(Drawable drawable, int i, j jVar) {
            this((i & 1) != 0 ? null : drawable);
        }
    }
}
