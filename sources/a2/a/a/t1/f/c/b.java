package a2.a.a.t1.f.c;

import android.view.View;
import com.avito.android.payment.wallet.history.OperationViewHolder;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
public final class b implements View.OnClickListener {
    public final /* synthetic */ OperationViewHolder a;
    public final /* synthetic */ PaymentHistoryListElement.Operation b;

    public b(OperationViewHolder operationViewHolder, PaymentHistoryListElement.Operation operation) {
        this.a = operationViewHolder;
        this.b = operation;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.y.invoke(this.b);
    }
}
