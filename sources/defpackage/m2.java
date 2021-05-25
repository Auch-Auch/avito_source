package defpackage;

import android.view.View;
import com.avito.android.subscriptions_settings.SubscriptionSettingsViewImpl;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: m2  reason: default package */
public final class m2 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public m2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((SubscriptionSettingsViewImpl) this.b).j.accept(Unit.INSTANCE);
        } else if (i == 1) {
            ((SubscriptionSettingsViewImpl) this.b).k.accept(Unit.INSTANCE);
        } else {
            throw null;
        }
    }
}
