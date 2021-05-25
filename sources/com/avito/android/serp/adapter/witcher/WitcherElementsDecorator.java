package com.avito.android.serp.adapter.witcher;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0011¨\u0006("}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherElementsDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "()F", "", "I", "horizontalPadding", "c", "elementsCountForWitcher", "", "f", "Z", "isTablet", g.a, "F", "newImageHeight", AuthSource.BOOKING_ORDER, "displayWidth", "e", "diff", "d", "imageDefault", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/util/DeviceMetrics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherElementsDecorator extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final boolean f;
    public float g;

    public WitcherElementsDecorator(@NotNull Resources resources, @NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.serp_horizontal_padding);
        this.a = dimensionPixelSize;
        int displayWidth = deviceMetrics.getDisplayWidth();
        this.b = displayWidth;
        int integer = resources.getInteger(R.integer.serp_columns);
        this.c = integer;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.serp_card_image_height);
        this.d = dimensionPixelOffset;
        float n2 = ((float) dimensionPixelOffset) / ((float) a.n2(dimensionPixelSize, 2, displayWidth, integer));
        this.e = n2;
        this.f = resources.getBoolean(R.bool.is_tablet);
        this.g = a() * n2;
    }

    public final float a() {
        return ((float) (this.b - (this.a * 2))) / (((float) this.c) + 0.21f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        float f2 = this.f ? 0.7f : 0.85f;
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.text_content);
        view.getLayoutParams().width = (int) a();
        if (!(imageView == null || (layoutParams2 = imageView.getLayoutParams()) == null)) {
            layoutParams2.height = (int) this.g;
        }
        if (!(linearLayout == null || (layoutParams = linearLayout.getLayoutParams()) == null)) {
            layoutParams.height = (int) (((float) ((int) this.g)) * f2);
        }
        if (!this.f) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                Intrinsics.checkNotNullExpressionValue(adapter, "parent.adapter ?: return");
                if (childAdapterPosition == 0) {
                    Views.changeMargin$default(view, this.a, 0, 0, 0, 10, null);
                } else if (childAdapterPosition == adapter.getItemCount() - 1) {
                    Views.changeMargin$default(view, 0, 0, this.a, 0, 10, null);
                } else {
                    Views.changeMargin$default(view, 0, 0, 0, 0, 10, null);
                }
            }
        }
    }
}
