package l6.q;

import android.os.Bundle;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
public class g implements Runnable {
    public final /* synthetic */ MediaSessionManager.RemoteUserInfo a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Bundle c;
    public final /* synthetic */ MediaBrowserServiceCompat.d d;

    public g(MediaBrowserServiceCompat.d dVar, MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
        this.d = dVar;
        this.a = remoteUserInfo;
        this.b = str;
        this.c = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < MediaBrowserServiceCompat.this.b.size(); i++) {
            MediaBrowserServiceCompat.b valueAt = MediaBrowserServiceCompat.this.b.valueAt(i);
            if (valueAt.b.equals(this.a)) {
                this.d.d(valueAt, this.b, this.c);
            }
        }
    }
}
