package a2.j.b.b.z0;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import java.util.List;
/* compiled from: MediaSourceFactory */
public final /* synthetic */ class p {
    @Deprecated
    public static MediaSource $default$createMediaSource(MediaSourceFactory _this, Uri uri) {
        return _this.createMediaSource(MediaItem.fromUri(uri));
    }

    /* JADX WARN: Incorrect args count in method signature: (Ljava/util/List<Lcom/google/android/exoplayer2/offline/StreamKey;>;)Lcom/google/android/exoplayer2/source/MediaSourceFactory; */
    @Deprecated
    public static MediaSourceFactory $default$setStreamKeys(@Nullable MediaSourceFactory mediaSourceFactory, List list) {
        return mediaSourceFactory;
    }
}
