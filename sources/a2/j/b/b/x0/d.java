package a2.j.b.b.x0;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final /* synthetic */ class d implements Handler.Callback {
    public final /* synthetic */ DownloadHelper.e a;

    public /* synthetic */ d(DownloadHelper.e eVar) {
        this.a = eVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        DownloadHelper.e eVar = this.a;
        boolean z = eVar.j;
        if (z) {
            return false;
        }
        int i = message.what;
        if (i == 0) {
            DownloadHelper downloadHelper = eVar.b;
            Assertions.checkNotNull(downloadHelper.j);
            Assertions.checkNotNull(downloadHelper.j.i);
            Assertions.checkNotNull(downloadHelper.j.h);
            int length = downloadHelper.j.i.length;
            int length2 = downloadHelper.d.length;
            int[] iArr = new int[2];
            iArr[1] = length2;
            iArr[0] = length;
            downloadHelper.m = (List[][]) Array.newInstance(List.class, iArr);
            int[] iArr2 = new int[2];
            iArr2[1] = length2;
            iArr2[0] = length;
            downloadHelper.n = (List[][]) Array.newInstance(List.class, iArr2);
            for (int i2 = 0; i2 < length; i2++) {
                for (int i3 = 0; i3 < length2; i3++) {
                    downloadHelper.m[i2][i3] = new ArrayList();
                    downloadHelper.n[i2][i3] = Collections.unmodifiableList(downloadHelper.m[i2][i3]);
                }
            }
            downloadHelper.k = new TrackGroupArray[length];
            downloadHelper.l = new MappingTrackSelector.MappedTrackInfo[length];
            for (int i4 = 0; i4 < length; i4++) {
                downloadHelper.k[i4] = downloadHelper.j.i[i4].getTrackGroups();
                downloadHelper.c.onSelectionActivated(downloadHelper.a(i4).info);
                downloadHelper.l[i4] = (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(downloadHelper.c.getCurrentMappedTrackInfo());
            }
            downloadHelper.h = true;
            ((Handler) Assertions.checkNotNull(downloadHelper.f)).post(new Runnable() { // from class: a2.j.b.b.x0.b
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadHelper downloadHelper2 = DownloadHelper.this;
                    ((DownloadHelper.Callback) Assertions.checkNotNull(downloadHelper2.i)).onPrepared(downloadHelper2);
                }
            });
        } else if (i != 1) {
            return false;
        } else {
            if (!z) {
                eVar.j = true;
                eVar.g.sendEmptyMessage(3);
            }
            DownloadHelper downloadHelper2 = eVar.b;
            ((Handler) Assertions.checkNotNull(downloadHelper2.f)).post(new Runnable((IOException) Util.castNonNull(message.obj)) { // from class: a2.j.b.b.x0.c
                public final /* synthetic */ IOException b;

                {
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    DownloadHelper downloadHelper3 = DownloadHelper.this;
                    ((DownloadHelper.Callback) Assertions.checkNotNull(downloadHelper3.i)).onPrepareError(downloadHelper3, this.b);
                }
            });
        }
        return true;
    }
}
