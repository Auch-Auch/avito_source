package com.avito.android.brandspace.view.decorators;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.brandspace.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DeviceMetrics;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B5\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e\u0012\u0006\u0010%\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0016\u0010%\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0018¨\u0006,"}, d2 = {"Lcom/avito/android/brandspace/view/decorators/BrandspaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "", "shouldApply", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "", "d", "F", "screenWidthHalf", "", AuthSource.BOOKING_ORDER, "I", "paddingHalf", g.a, "rowOffsetHalf", AuthSource.SEND_ABUSE, "columnOffsetHalf", "", "e", "Ljava/util/List;", "headersPositions", "c", "screenWidth", "f", "columns", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Ljava/util/List;IILandroid/content/res/Resources;Lcom/avito/android/util/DeviceMetrics;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public abstract class BrandspaceItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    public final List<Integer> e;
    public final int f;
    public final int g;

    public BrandspaceItemDecoration(@NotNull List<Integer> list, int i, int i2, @NotNull Resources resources, @NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(list, "headersPositions");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.e = list;
        this.f = i;
        this.g = i2;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.brandspace_column_offset) / 2;
        this.a = dimensionPixelSize;
        this.b = resources.getDimensionPixelSize(R.dimen.brandspace_content_horizontal_padding) - dimensionPixelSize;
        this.c = deviceMetrics.getDisplayWidth();
        this.d = ((float) deviceMetrics.getDisplayWidth()) / ((float) 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        boolean z;
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        Intrinsics.checkNotNullExpressionValue(childViewHolder, "parent.getChildViewHolder(view)");
        if (shouldApply(childViewHolder)) {
            Integer valueOf = Integer.valueOf(recyclerView.getChildAdapterPosition(view));
            int i = 0;
            Integer num = null;
            if (!(valueOf.intValue() >= 0)) {
                valueOf = null;
            }
            if (valueOf == null) {
                Object tag = view.getTag();
                if (!(tag instanceof Integer)) {
                    tag = null;
                }
                valueOf = (Integer) tag;
            }
            int intValue = valueOf != null ? valueOf.intValue() : -1;
            List<Integer> list = this.e;
            ListIterator<Integer> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                Integer previous = listIterator.previous();
                if (previous.intValue() < intValue) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    num = previous;
                    break;
                }
            }
            Integer num2 = num;
            if (num2 != null) {
                i = num2.intValue();
            }
            int i2 = this.f;
            int i3 = ((intValue - i) - 1) % i2;
            float f2 = (float) this.c;
            float f3 = (float) i2;
            float f4 = (((float) i3) * f2) / f3;
            float f5 = this.d;
            float f6 = f5 - ((float) this.b);
            int i4 = ((int) ((((f4 - f5) / f5) * f6) + f5)) - ((int) f4);
            int i5 = this.a;
            rect.left = i4 + i5;
            float f7 = (f2 * ((float) (i3 + 1))) / f3;
            rect.right = (-((int) ((((f7 - f5) / f5) * f6) + f5))) + ((int) f7) + i5;
            int i6 = this.g;
            rect.top = i6;
            rect.bottom = i6;
        }
    }

    public abstract boolean shouldApply(@NotNull RecyclerView.ViewHolder viewHolder);
}
