package l6.q;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
public class b extends MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> {
    public final /* synthetic */ ResultReceiver f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f = resultReceiver;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public void d(MediaBrowserCompat.MediaItem mediaItem) {
        MediaBrowserCompat.MediaItem mediaItem2 = mediaItem;
        if ((this.e & 2) != 0) {
            this.f.send(-1, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem2);
        this.f.send(0, bundle);
    }
}
