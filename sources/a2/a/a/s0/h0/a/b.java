package a2.a.a.s0.h0.a;

import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Disposable> {
    public final /* synthetic */ SubscriptionSettingsView a;

    public b(SubscriptionSettingsView subscriptionSettingsView) {
        this.a = subscriptionSettingsView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.setNotificationLoading(true);
    }
}
