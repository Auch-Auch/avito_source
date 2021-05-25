package a2.a.a.n;

import com.avito.android.autodeal_details.AutoDealDetailsJSEvents;
import com.avito.android.autodeal_details.AutoDealDetailsViewModelImpl;
import com.avito.android.autodeal_details.WebViewAction;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<AutoDealDetailsJSEvents> {
    public final /* synthetic */ AutoDealDetailsViewModelImpl a;

    public f(AutoDealDetailsViewModelImpl autoDealDetailsViewModelImpl) {
        this.a = autoDealDetailsViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(AutoDealDetailsJSEvents autoDealDetailsJSEvents) {
        AutoDealDetailsJSEvents autoDealDetailsJSEvents2 = autoDealDetailsJSEvents;
        if (autoDealDetailsJSEvents2 instanceof AutoDealDetailsJSEvents.CloseScreen) {
            this.a.getWebViewAction().setValue(new WebViewAction.CloseScreen());
        } else if (autoDealDetailsJSEvents2 instanceof AutoDealDetailsJSEvents.ShowToast) {
            this.a.getWebViewAction().setValue(new WebViewAction.ShowToast(((AutoDealDetailsJSEvents.ShowToast) autoDealDetailsJSEvents2).getText()));
        }
    }
}
