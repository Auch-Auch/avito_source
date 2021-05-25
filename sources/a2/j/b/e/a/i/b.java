package a2.j.b.e.a.i;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.ac;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
public final class b implements com.google.android.play.core.splitinstall.b {
    public final /* synthetic */ SplitInstallSessionState a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ ac d;

    public b(ac acVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.d = acVar;
        this.a = splitInstallSessionState;
        this.b = intent;
        this.c = context;
    }

    @Override // com.google.android.play.core.splitinstall.b
    public final void a() {
        ac acVar = this.d;
        acVar.g.post(new c(acVar, this.a, 5, 0));
    }

    @Override // com.google.android.play.core.splitinstall.b
    public final void b() {
        if (!this.b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.b.putExtra("triggered_from_app_after_verification", true);
            this.c.sendBroadcast(this.b);
            return;
        }
        this.d.a.b("Splits copied and verified more than once.", new Object[0]);
    }

    @Override // com.google.android.play.core.splitinstall.b
    public final void a(@SplitInstallErrorCode int i) {
        ac acVar = this.d;
        acVar.g.post(new c(acVar, this.a, 6, i));
    }
}
