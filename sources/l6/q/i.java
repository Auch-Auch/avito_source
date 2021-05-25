package l6.q;

import androidx.media.MediaBrowserServiceCompat;
public class i implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ MediaBrowserServiceCompat.h b;

    public i(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar) {
        this.b = hVar;
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b remove = MediaBrowserServiceCompat.this.b.remove(((MediaBrowserServiceCompat.j) this.a).a());
        if (remove != null) {
            ((MediaBrowserServiceCompat.j) remove.d).a().unlinkToDeath(remove, 0);
        }
    }
}
