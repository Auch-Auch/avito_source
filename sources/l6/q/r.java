package l6.q;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy;
import java.util.List;
public class r extends MediaBrowserService {
    public final MediaBrowserServiceCompatApi21$ServiceCompatProxy a;

    public r(Context context, MediaBrowserServiceCompatApi21$ServiceCompatProxy mediaBrowserServiceCompatApi21$ServiceCompatProxy) {
        attachBaseContext(context);
        this.a = mediaBrowserServiceCompatApi21$ServiceCompatProxy;
    }

    @Override // android.service.media.MediaBrowserService
    public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        q onGetRoot = this.a.onGetRoot(str, i, bundle == null ? null : new Bundle(bundle));
        if (onGetRoot == null) {
            return null;
        }
        return new MediaBrowserService.BrowserRoot(onGetRoot.a, onGetRoot.b);
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
        this.a.onLoadChildren(str, new s<>(result));
    }
}
