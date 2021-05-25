package a2.a.a.i2.a.a;

import android.view.View;
import androidx.lifecycle.Observer;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<String> {
    public final /* synthetic */ DeliveryCourierOrderUpdateFragment a;

    public b(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        this.a = deliveryCourierOrderUpdateFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        String str2 = str;
        View view = this.a.getView();
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            Views.showSnackBar$default(view, str2, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        }
    }
}
