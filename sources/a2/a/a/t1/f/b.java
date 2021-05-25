package a2.a.a.t1.f;

import android.view.View;
import com.avito.android.payment.wallet.WalletPageActivity;
public final class b implements View.OnClickListener {
    public final /* synthetic */ WalletPageActivity.c a;

    public b(WalletPageActivity.c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a.startActivity(this.a.a.getActivityIntentFactory().operationsHistoryIntent());
    }
}
