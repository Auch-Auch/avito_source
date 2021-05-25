package l6.q;

import a2.b.a.a.a;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
public class p implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Bundle c;
    public final /* synthetic */ ResultReceiver d;
    public final /* synthetic */ MediaBrowserServiceCompat.h e;

    public p(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.e = hVar;
        this.a = iVar;
        this.b = str;
        this.c = bundle;
        this.d = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.b.get(((MediaBrowserServiceCompat.j) this.a).a());
        if (bVar == null) {
            StringBuilder L = a.L("sendCustomAction for callback that isn't registered action=");
            L.append(this.b);
            L.append(", extras=");
            L.append(this.c);
            L.toString();
            return;
        }
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        String str = this.b;
        Bundle bundle = this.c;
        d dVar = new d(mediaBrowserServiceCompat, str, this.d);
        mediaBrowserServiceCompat.c = bVar;
        mediaBrowserServiceCompat.onCustomAction(str, bundle, dVar);
        mediaBrowserServiceCompat.c = null;
        if (!dVar.a()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }
}
