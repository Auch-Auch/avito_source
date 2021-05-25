package l6.q;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
public class n implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ MediaBrowserServiceCompat.h b;

    public n(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar) {
        this.b = hVar;
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder a3 = ((MediaBrowserServiceCompat.j) this.a).a();
        MediaBrowserServiceCompat.b remove = MediaBrowserServiceCompat.this.b.remove(a3);
        if (remove != null) {
            a3.unlinkToDeath(remove, 0);
        }
    }
}
