package a2.j.b.e.a.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.i;
public final class a extends ResultReceiver {
    public final /* synthetic */ i a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Handler handler, i iVar) {
        super(handler);
        this.a = iVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        i iVar;
        int i2 = 1;
        if (i == 1) {
            iVar = this.a;
            i2 = -1;
        } else if (i != 2) {
            iVar = this.a;
        } else {
            iVar = this.a;
            i2 = 0;
        }
        iVar.a((i) Integer.valueOf(i2));
    }
}
