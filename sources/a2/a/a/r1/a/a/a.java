package a2.a.a.r1.a.a;

import android.view.View;
import com.avito.android.orders.feature.host.OrdersViewImpl;
import kotlin.Unit;
public final class a implements View.OnClickListener {
    public final /* synthetic */ OrdersViewImpl a;

    public a(OrdersViewImpl ordersViewImpl) {
        this.a = ordersViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.e.accept(Unit.INSTANCE);
    }
}
