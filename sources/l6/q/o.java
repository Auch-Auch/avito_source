package l6.q;

import a2.b.a.a.a;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
public class o implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Bundle c;
    public final /* synthetic */ ResultReceiver d;
    public final /* synthetic */ MediaBrowserServiceCompat.h e;

    public o(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.e = hVar;
        this.a = iVar;
        this.b = str;
        this.c = bundle;
        this.d = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.b.get(((MediaBrowserServiceCompat.j) this.a).a());
        if (bVar != null) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            String str = this.b;
            Bundle bundle = this.c;
            c cVar = new c(mediaBrowserServiceCompat, str, this.d);
            mediaBrowserServiceCompat.c = bVar;
            mediaBrowserServiceCompat.onSearch(str, bundle, cVar);
            mediaBrowserServiceCompat.c = null;
            if (!cVar.a()) {
                throw new IllegalStateException(a.c3("onSearch must call detach() or sendResult() before returning for query=", str));
            }
        }
    }
}
