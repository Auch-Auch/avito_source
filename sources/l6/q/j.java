package l6.q;

import android.os.Bundle;
import android.os.IBinder;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class j implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.i a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IBinder c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ MediaBrowserServiceCompat.h e;

    public j(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.i iVar, String str, IBinder iBinder, Bundle bundle) {
        this.e = hVar;
        this.a = iVar;
        this.b = str;
        this.c = iBinder;
        this.d = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.b.get(((MediaBrowserServiceCompat.j) this.a).a());
        if (bVar != null) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            String str = this.b;
            IBinder iBinder = this.c;
            Bundle bundle = this.d;
            Objects.requireNonNull(mediaBrowserServiceCompat);
            List<Pair<IBinder, Bundle>> list = bVar.e.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            for (Pair<IBinder, Bundle> pair : list) {
                if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                    return;
                }
            }
            list.add(new Pair<>(iBinder, bundle));
            bVar.e.put(str, list);
            mediaBrowserServiceCompat.a(str, bVar, bundle, null);
            mediaBrowserServiceCompat.c = bVar;
            mediaBrowserServiceCompat.onSubscribe(str, bundle);
            mediaBrowserServiceCompat.c = null;
        }
    }
}
