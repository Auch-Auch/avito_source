package l6.q;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
public class d extends MediaBrowserServiceCompat.Result<Bundle> {
    public final /* synthetic */ ResultReceiver f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f = resultReceiver;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public void b(Bundle bundle) {
        this.f.send(-1, bundle);
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public void c(Bundle bundle) {
        this.f.send(1, bundle);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public void d(Bundle bundle) {
        this.f.send(0, bundle);
    }
}
