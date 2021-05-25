package l6.q;

import android.os.Bundle;
import android.os.IBinder;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat;
public class f implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ MediaBrowserServiceCompat.d c;

    public f(MediaBrowserServiceCompat.d dVar, String str, Bundle bundle) {
        this.c = dVar;
        this.a = str;
        this.b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (IBinder iBinder : MediaBrowserServiceCompat.this.b.keySet()) {
            ArrayMap<IBinder, MediaBrowserServiceCompat.b> arrayMap = MediaBrowserServiceCompat.this.b;
            this.c.d(arrayMap.get(iBinder), this.a, this.b);
        }
    }
}
