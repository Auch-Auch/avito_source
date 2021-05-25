package a2.j.b.e.a.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.play.core.internal.ak;
public final class g implements ServiceConnection {
    public final /* synthetic */ ak a;

    public /* synthetic */ g(ak akVar) {
        this.a = akVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.b.c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.a.c(new e(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.b.c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.a.c(new f(this));
    }
}
