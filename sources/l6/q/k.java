package l6.q;

import android.os.Bundle;
import android.os.IBinder;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
public class k implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IBinder c;
    public final /* synthetic */ MediaBrowserServiceCompat.h d;

    public k(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, IBinder iBinder) {
        this.d = hVar;
        this.a = iVar;
        this.b = str;
        this.c = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.b.get(((MediaBrowserServiceCompat.j) this.a).a());
        if (bVar != null) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            String str = this.b;
            IBinder iBinder = this.c;
            Objects.requireNonNull(mediaBrowserServiceCompat);
            if (iBinder == null) {
                try {
                    if (bVar.e.remove(str) != null) {
                    }
                } catch (Throwable th) {
                    mediaBrowserServiceCompat.c = bVar;
                    mediaBrowserServiceCompat.onUnsubscribe(str);
                    mediaBrowserServiceCompat.c = null;
                    throw th;
                }
            } else {
                List<Pair<IBinder, Bundle>> list = bVar.e.get(str);
                if (list != null) {
                    Iterator<Pair<IBinder, Bundle>> it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == it.next().first) {
                            it.remove();
                        }
                    }
                    if (list.size() == 0) {
                        bVar.e.remove(str);
                    }
                }
            }
            mediaBrowserServiceCompat.c = bVar;
            mediaBrowserServiceCompat.onUnsubscribe(str);
            mediaBrowserServiceCompat.c = null;
        }
    }
}
