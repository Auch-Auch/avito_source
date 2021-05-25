package a2.a.a.s0.h0.a;

import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import io.reactivex.rxjava3.functions.Action;
public final class c implements Action {
    public final /* synthetic */ SubscriptionSettingsView a;

    public c(SubscriptionSettingsView subscriptionSettingsView) {
        this.a = subscriptionSettingsView;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.setNotificationLoading(false);
    }
}
