package a2.a.a.c3;

import android.content.DialogInterface;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.subscriptions_settings.SubscriptionSettingsViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SubscriptionSettingsViewImpl.a a;
    public final /* synthetic */ DialogInterface b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SubscriptionSettingsViewImpl.a aVar, Dialog.Config config, DialogInterface dialogInterface) {
        super(0);
        this.a = aVar;
        this.b = dialogInterface;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.b.dismiss();
        this.a.b.invoke();
        return Unit.INSTANCE;
    }
}
