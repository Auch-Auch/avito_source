package l6.q;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
public class e implements Runnable {
    public final /* synthetic */ MediaSessionCompat.Token a;
    public final /* synthetic */ MediaBrowserServiceCompat.d b;

    public e(MediaBrowserServiceCompat.d dVar, MediaSessionCompat.Token token) {
        this.b = dVar;
        this.a = token;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.b.a.isEmpty()) {
            IMediaSession extraBinder = this.a.getExtraBinder();
            if (extraBinder != null) {
                for (Bundle bundle : this.b.a) {
                    BundleCompat.putBinder(bundle, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                }
            }
            this.b.a.clear();
        }
        ((MediaBrowserService) this.b.b).setSessionToken((MediaSession.Token) this.a.getToken());
    }
}
