package a2.a.a.a0.a.q.a;

import android.view.View;
import com.avito.android.cart.summary.konveyor.product.ProductItemViewHolder;
import com.avito.android.lib.design.picker.WheelData;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class a implements View.OnClickListener {
    public final /* synthetic */ ProductItemViewHolder.i a;
    public final /* synthetic */ ProductItemViewHolder.h b;

    public a(ProductItemViewHolder.i iVar, ProductItemViewHolder.h hVar) {
        this.a = iVar;
        this.b = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WheelData<?> firstWheelValue = this.b.s.getFirstWheelValue();
        Intrinsics.checkNotNull(firstWheelValue);
        Object key = firstWheelValue.getKey();
        Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) key).intValue();
        this.a.a.G.invoke(Integer.valueOf(intValue));
        this.b.close();
        if (intValue == 0) {
            ProductItemViewHolder.access$animateShowDeleteView(this.a.a);
            return;
        }
        ProductItemViewHolder.access$animateHideDeleteView(this.a.a);
        this.a.a.A.setValue(intValue);
    }
}
