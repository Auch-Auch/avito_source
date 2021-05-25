package com.google.android.exoplayer2.offline;

import a2.j.b.b.x0.o;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public final class ActionFileUpgradeUtil {

    public interface DownloadIdProvider {
        String getId(DownloadRequest downloadRequest);
    }

    /* JADX INFO: finally extract failed */
    @WorkerThread
    public static void upgradeAndDelete(File file, @Nullable DownloadIdProvider downloadIdProvider, DefaultDownloadIndex defaultDownloadIndex, boolean z, boolean z2) throws IOException {
        DownloadRequest[] downloadRequestArr;
        int i;
        int i2;
        long j;
        Download download;
        AtomicFile atomicFile = new AtomicFile(file);
        if (atomicFile.exists()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (!atomicFile.exists()) {
                    downloadRequestArr = new DownloadRequest[0];
                } else {
                    try {
                        InputStream openRead = atomicFile.openRead();
                        DataInputStream dataInputStream = new DataInputStream(openRead);
                        int readInt = dataInputStream.readInt();
                        if (readInt <= 0) {
                            int readInt2 = dataInputStream.readInt();
                            ArrayList arrayList = new ArrayList();
                            for (int i3 = 0; i3 < readInt2; i3++) {
                                try {
                                    arrayList.add(o.a(dataInputStream));
                                } catch (DownloadRequest.UnsupportedRequestException unused) {
                                }
                            }
                            Util.closeQuietly(openRead);
                            downloadRequestArr = (DownloadRequest[]) arrayList.toArray(new DownloadRequest[0]);
                        } else {
                            throw new IOException("Unsupported action file version: " + readInt);
                        }
                    } catch (Throwable th) {
                        Util.closeQuietly((Closeable) null);
                        throw th;
                    }
                }
                int length = downloadRequestArr.length;
                int i4 = 0;
                while (i4 < length) {
                    DownloadRequest downloadRequest = downloadRequestArr[i4];
                    if (downloadIdProvider != null) {
                        downloadRequest = downloadRequest.copyWithId(downloadIdProvider.getId(downloadRequest));
                    }
                    Download download2 = defaultDownloadIndex.getDownload(downloadRequest.id);
                    if (download2 != null) {
                        download = DownloadManager.a(download2, downloadRequest, download2.stopReason, currentTimeMillis);
                        i2 = length;
                        i = i4;
                        j = currentTimeMillis;
                    } else {
                        i2 = length;
                        i = i4;
                        j = currentTimeMillis;
                        download = new Download(downloadRequest, z2 ? 3 : 0, currentTimeMillis, currentTimeMillis, -1, 0, 0);
                    }
                    defaultDownloadIndex.putDownload(download);
                    i4 = i + 1;
                    currentTimeMillis = j;
                    length = i2;
                }
                atomicFile.delete();
            } catch (Throwable th2) {
                if (z) {
                    atomicFile.delete();
                }
                throw th2;
            }
        }
    }
}
