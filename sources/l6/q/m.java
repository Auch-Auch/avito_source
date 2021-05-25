package l6.q;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.media.MediaBrowserServiceCompat;
public class m implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Bundle e;
    public final /* synthetic */ MediaBrowserServiceCompat.h f;

    public m(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, int i, int i2, Bundle bundle) {
        this.f = hVar;
        this.a = iVar;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder a3 = ((MediaBrowserServiceCompat.j) this.a).a();
        MediaBrowserServiceCompat.this.b.remove(a3);
        MediaBrowserServiceCompat.b bVar = new MediaBrowserServiceCompat.b(this.b, this.c, this.d, this.e, this.a);
        MediaBrowserServiceCompat.this.b.put(a3, bVar);
        try {
            a3.linkToDeath(bVar, 0);
        } catch (RemoteException unused) {
        }
    }
}
