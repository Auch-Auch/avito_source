package a2.a.a.l0.a.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.design.widget.recommendation_graph.RecommendationWidget;
import com.avito.android.util.Views;
import java.util.Objects;
public final class d implements Runnable {
    public final /* synthetic */ RecommendationWidget a;
    public final /* synthetic */ float b;
    public final /* synthetic */ boolean c;

    public d(RecommendationWidget recommendationWidget, float f, boolean z) {
        this.a = recommendationWidget;
        this.b = f;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int measuredWidth = (this.a.e.getMeasuredWidth() - this.a.e.getPaddingLeft()) - this.a.e.getPaddingRight();
        int i = (int) (((float) measuredWidth) * this.b);
        int i2 = 0;
        if (i < 0) {
            i = 0;
        }
        if (i <= measuredWidth) {
            measuredWidth = i;
        }
        int paddingLeft = this.a.e.getPaddingLeft() + measuredWidth;
        boolean z = true;
        Views.setVisible(this.a.k, !this.c);
        ViewGroup.LayoutParams layoutParams = this.a.k.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).leftMargin = paddingLeft - (this.a.k.getMeasuredWidth() / 2);
        int measuredWidth2 = paddingLeft - (this.a.d.getMeasuredWidth() / 2);
        boolean z2 = measuredWidth2 < this.a.b.getRight();
        if (this.a.d.getWidth() + measuredWidth2 <= this.a.c.getLeft()) {
            z = false;
        }
        if (z2 || z) {
            RecommendationWidget.access$hideBorderLabels(this.a);
        }
        if (measuredWidth2 >= 0) {
            i2 = this.a.d.getWidth() + measuredWidth2 > this.a.a.getWidth() ? this.a.a.getWidth() - this.a.d.getWidth() : measuredWidth2;
        }
        ViewGroup.LayoutParams layoutParams2 = this.a.d.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.leftMargin = i2;
        this.a.d.setLayoutParams(layoutParams3);
        Views.show(this.a.d);
    }
}
