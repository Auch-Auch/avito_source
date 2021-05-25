package defpackage;

import android.view.View;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudDialog;
/* compiled from: java-style lambda group */
/* renamed from: x  reason: default package */
public final class x implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public x(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((AntiFraudDialog) this.b).getListener().onAcceptAntiFraudRule();
            ((AntiFraudDialog) this.b).dismiss();
        } else if (i == 1) {
            ((AntiFraudDialog) this.b).getListener().onShowMoreAntiFraudRule();
            ((AntiFraudDialog) this.b).dismiss();
        } else {
            throw null;
        }
    }
}
