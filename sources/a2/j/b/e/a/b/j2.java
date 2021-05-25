package a2.j.b.e.a.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.tasks.i;
public final class j2 extends ResultReceiver {
    public final /* synthetic */ i a;
    public final /* synthetic */ k2 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j2(k2 k2Var, Handler handler, i iVar) {
        super(handler);
        this.b = k2Var;
        this.a = iVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.a.a((i) -1);
            this.b.g.a = null;
        } else if (i != 2) {
            this.a.a((Exception) new AssetPackException(-100));
        } else {
            this.a.a((i) 0);
        }
    }
}
