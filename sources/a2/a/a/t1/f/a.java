package a2.a.a.t1.f;

import android.view.View;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.payment.wallet.WalletPageActivity;
public final class a implements View.OnClickListener {
    public final /* synthetic */ DeepLink a;
    public final /* synthetic */ WalletPageActivity.c b;

    public a(DeepLink deepLink, WalletPageActivity.c cVar) {
        this.a = deepLink;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.a.startActivityForResult(this.b.a.getDeepLinkIntentFactory().getIntent(this.a), 0);
    }
}
