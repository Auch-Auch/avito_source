package com.avito.android.advert_core.advert;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.RdsAdvertItemView;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/avito/android/advert_core/advert/GridAfterHeaderItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "columnOffsetHalf", g.a, "columns", "c", "rowOffsetHalf", "d", "screenWidth", "", "f", "Ljava/util/List;", "headersPosition", AuthSource.BOOKING_ORDER, "paddingHalf", "", "e", "F", "screenWidthHalf", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Ljava/util/List;ILandroid/content/res/Resources;Lcom/avito/android/util/DeviceMetrics;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class GridAfterHeaderItemDecorator extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final List<Integer> f;
    public final int g;

    public GridAfterHeaderItemDecorator(@NotNull List<Integer> list, int i, @NotNull Resources resources, @NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(list, "headersPosition");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.f = list;
        this.g = i;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.rds_column_offset) / 2;
        this.a = dimensionPixelSize;
        this.b = resources.getDimensionPixelSize(R.dimen.content_horizontal_padding) - dimensionPixelSize;
        this.c = resources.getDimensionPixelSize(R.dimen.rds_grid_row_offset) / 2;
        this.d = deviceMetrics.getDisplayWidth();
        this.e = ((float) deviceMetrics.getDisplayWidth()) / ((float) 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildViewHolder(view) instanceof RdsAdvertItemView) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            List<Integer> list = this.f;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (next.intValue() < childAdapterPosition) {
                    i = 1;
                }
                if (i != 0) {
                    arrayList.add(next);
                }
            }
            Integer num = (Integer) CollectionsKt___CollectionsKt.max((Iterable<? extends Comparable>) arrayList);
            if (num != null) {
                i = num.intValue();
            }
            int i2 = this.g;
            int i3 = ((childAdapterPosition - i) - 1) % i2;
            float f2 = (float) this.d;
            float f3 = (float) i2;
            float f4 = (((float) i3) * f2) / f3;
            float f5 = this.e;
            float f6 = f5 - ((float) this.b);
            int i4 = ((int) ((((f4 - f5) / f5) * f6) + f5)) - ((int) f4);
            int i5 = this.a;
            rect.left = i4 + i5;
            float f7 = (f2 * ((float) (i3 + 1))) / f3;
            rect.right = (-((int) ((((f7 - f5) / f5) * f6) + f5))) + ((int) f7) + i5;
            int i6 = this.c;
            rect.top = i6;
            rect.bottom = i6;
        }
    }
}
