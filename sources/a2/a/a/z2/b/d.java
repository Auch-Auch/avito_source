package a2.a.a.z2.b;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class d extends LinearLayoutManager {
    public int I;
    public boolean J;
    public int K;
    public Function1<? super Integer, Unit> L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(@Nullable RecyclerView.State state) {
        Function1<? super Integer, Unit> function1 = this.L;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.I));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(@Nullable Rect rect, int i, int i2) {
        Intrinsics.checkNotNull(rect);
        int paddingRight = getPaddingRight() + getPaddingLeft() + rect.width();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + rect.height();
        int chooseSize = RecyclerView.LayoutManager.chooseSize(i, paddingRight, getMinimumWidth());
        int chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, paddingBottom, getMinimumHeight());
        this.I = chooseSize2;
        if (this.J) {
            chooseSize2 = this.K;
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }
}
