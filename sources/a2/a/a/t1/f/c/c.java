package a2.a.a.t1.f.c;

import android.view.View;
import com.avito.android.payment.wallet.history.OrderViewHolder;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
public final class c implements View.OnClickListener {
    public final /* synthetic */ OrderViewHolder a;
    public final /* synthetic */ PaymentHistoryListElement.Order b;

    public c(OrderViewHolder orderViewHolder, PaymentHistoryListElement.Order order) {
        this.a = orderViewHolder;
        this.b = order;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.y.invoke(this.b);
    }
}
