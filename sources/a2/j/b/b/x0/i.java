package a2.j.b.b.x0;

import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.util.Util;
import java.util.Comparator;
public final /* synthetic */ class i implements Comparator {
    public static final /* synthetic */ i a = new i();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = DownloadManager.c.m;
        return Util.compareLong(((Download) obj).startTimeMs, ((Download) obj2).startTimeMs);
    }
}
