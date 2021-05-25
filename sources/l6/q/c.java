package l6.q;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;
public class c extends MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> {
    public final /* synthetic */ ResultReceiver f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f = resultReceiver;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public void d(List<MediaBrowserCompat.MediaItem> list) {
        List<MediaBrowserCompat.MediaItem> list2 = list;
        if ((this.e & 4) != 0 || list2 == null) {
            this.f.send(-1, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list2.toArray(new MediaBrowserCompat.MediaItem[0]));
        this.f.send(0, bundle);
    }
}
