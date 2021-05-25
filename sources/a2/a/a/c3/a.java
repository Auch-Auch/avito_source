package a2.a.a.c3;

import android.content.DialogInterface;
import com.avito.android.subscriptions_settings.SubscriptionSettingsViewImpl;
import kotlin.Unit;
public final class a implements DialogInterface.OnDismissListener {
    public final /* synthetic */ SubscriptionSettingsViewImpl a;

    public a(SubscriptionSettingsViewImpl subscriptionSettingsViewImpl) {
        this.a = subscriptionSettingsViewImpl;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.m = null;
        this.a.a();
        this.a.l.accept(Unit.INSTANCE);
    }
}
