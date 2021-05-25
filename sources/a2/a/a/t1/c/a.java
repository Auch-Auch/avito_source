package a2.a.a.t1.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.payment.lib.PaymentMethodsView;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Runnable {
    public final /* synthetic */ PaymentMethodsView.h a;

    public a(PaymentMethodsView.h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        T t = this.a.b.element;
        if (t != null) {
            int intValue = t.intValue();
            RecyclerView recyclerView = this.a.a.f;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                Intrinsics.checkNotNullExpressionValue(layoutManager, "recyclerView.layoutManager ?: return@post");
                View findViewByPosition = layoutManager.findViewByPosition(intValue);
                if (findViewByPosition != null) {
                    Intrinsics.checkNotNullExpressionValue(findViewByPosition, "layoutManager.findViewBy…(position) ?: return@post");
                    this.a.a.f.scrollBy(this.a.a.m.calculateDistanceToFinalSnap(layoutManager, findViewByPosition)[0], 0);
                }
            }
        }
    }
}
