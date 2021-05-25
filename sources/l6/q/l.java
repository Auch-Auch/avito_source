package l6.q;

import a2.b.a.a.a;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
public class l implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ResultReceiver c;
    public final /* synthetic */ MediaBrowserServiceCompat.h d;

    public l(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, ResultReceiver resultReceiver) {
        this.d = hVar;
        this.a = iVar;
        this.b = str;
        this.c = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.b.get(((MediaBrowserServiceCompat.j) this.a).a());
        if (bVar != null) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            String str = this.b;
            b bVar2 = new b(mediaBrowserServiceCompat, str, this.c);
            mediaBrowserServiceCompat.c = bVar;
            mediaBrowserServiceCompat.onLoadItem(str, bVar2);
            mediaBrowserServiceCompat.c = null;
            if (!bVar2.a()) {
                throw new IllegalStateException(a.c3("onLoadItem must call detach() or sendResult() before returning for id=", str));
            }
        }
    }
}
