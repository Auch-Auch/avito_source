package ru.sravni.android.bankproduct.utils.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DimenRes;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\r¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/utils/recycler/HeadDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "d", "I", "heightRes", AuthSource.BOOKING_ORDER, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "c", "headerRes", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class HeadDividerItemDecoration extends RecyclerView.ItemDecoration {
    public final View a;
    public final int b;
    public final int c;
    public final int d;

    public HeadDividerItemDecoration(@NotNull RecyclerView recyclerView, @LayoutRes int i, @DimenRes int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        this.c = i;
        this.d = i2;
        View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(i, (ViewGroup) recyclerView, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…headerRes, parent, false)");
        this.a = inflate;
        Context context = recyclerView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "parent.context");
        this.b = (int) context.getResources().getDimension(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "view");
            i += childAt.getHeight();
        }
        float bottom = ((float) recyclerView.getBottom()) - ((float) i);
        canvas.save();
        if (bottom <= 0.0f) {
            bottom = 0.0f;
        }
        canvas.translate(0.0f, bottom);
        this.a.layout(recyclerView.getLeft(), 0, recyclerView.getRight(), this.b);
        this.a.draw(canvas);
        canvas.restore();
    }
}
