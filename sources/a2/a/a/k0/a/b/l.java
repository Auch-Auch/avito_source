package a2.a.a.k0.a.b;

import android.view.View;
import androidx.lifecycle.Observer;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.util.AvitoSnackbar;
import kotlin.jvm.internal.Intrinsics;
public final class l<T> implements Observer<String> {
    public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

    public l(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        this.a = deliveryRdsStartOrderingFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        View view;
        String str2 = str;
        if (str2 != null && (view = this.a.getView()) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "this.view ?: return@Observer");
            AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, view, str2, 0, null, 0, null, null, 0, 0, 0, 1016, null).show();
        }
    }
}
