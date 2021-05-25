package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.List;
import l6.q.t;
@RequiresApi(26)
public class MediaBrowserServiceCompatApi26 {
    public static Field a;

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23$ServiceCompatProxy {
        void onLoadChildren(String str, b bVar, Bundle bundle);
    }

    public static class a extends t {
        public a(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((ServiceCompatProxy) this.a).onLoadChildren(str, new b(result), bundle);
        }
    }

    public static class b {
        public MediaBrowserService.Result a;

        public b(MediaBrowserService.Result result) {
            this.a = result;
        }
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
    }
}
