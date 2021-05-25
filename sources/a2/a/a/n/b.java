package a2.a.a.n;

import androidx.lifecycle.Observer;
import com.avito.android.autodeal_details.AutoDealDetailsActivity;
import com.avito.android.autodeal_details.WebViewAction;
public final class b<T> implements Observer<WebViewAction> {
    public final /* synthetic */ AutoDealDetailsActivity a;

    public b(AutoDealDetailsActivity autoDealDetailsActivity) {
        this.a = autoDealDetailsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(WebViewAction webViewAction) {
        WebViewAction webViewAction2 = webViewAction;
        if (webViewAction2 instanceof WebViewAction.CloseScreen) {
            this.a.finish();
        } else if (webViewAction2 instanceof WebViewAction.ShowToast) {
            AutoDealDetailsActivity.access$showToast(this.a, ((WebViewAction.ShowToast) webViewAction2).getText());
        }
    }
}
