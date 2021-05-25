package l6.q;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy;
public class t extends r {
    public t(Context context, MediaBrowserServiceCompatApi23$ServiceCompatProxy mediaBrowserServiceCompatApi23$ServiceCompatProxy) {
        super(context, mediaBrowserServiceCompatApi23$ServiceCompatProxy);
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
        ((MediaBrowserServiceCompatApi23$ServiceCompatProxy) this.a).onLoadItem(str, new s<>(result));
    }
}
