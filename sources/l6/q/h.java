package l6.q;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.media.MediaBrowserServiceCompat;
public class h implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Bundle e;
    public final /* synthetic */ MediaBrowserServiceCompat.h f;

    public h(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, int i, int i2, Bundle bundle) {
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
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.c = bVar;
        MediaBrowserServiceCompat.BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(this.b, this.d, this.e);
        bVar.f = onGetRoot;
        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat2.c = null;
        if (onGetRoot == null) {
            try {
                ((MediaBrowserServiceCompat.j) this.a).d(2, null);
            } catch (RemoteException unused) {
            }
        } else {
            try {
                mediaBrowserServiceCompat2.b.put(a3, bVar);
                a3.linkToDeath(bVar, 0);
                if (MediaBrowserServiceCompat.this.e != null) {
                    ((MediaBrowserServiceCompat.j) this.a).b(bVar.f.getRootId(), MediaBrowserServiceCompat.this.e, bVar.f.getExtras());
                }
            } catch (RemoteException unused2) {
                MediaBrowserServiceCompat.this.b.remove(a3);
            }
        }
    }
}
