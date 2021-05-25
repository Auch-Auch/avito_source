package com.google.android.exoplayer2.offline;

import a2.j.b.b.x0.h;
import a2.j.b.b.x0.i;
import a2.j.b.b.x0.m;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
public final class DownloadManager {
    public static final int DEFAULT_MAX_PARALLEL_DOWNLOADS = 3;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    public static final Requirements DEFAULT_REQUIREMENTS = new Requirements(1);
    public final Context a;
    public final WritableDownloadIndex b;
    public final Handler c;
    public final c d;
    public final RequirementsWatcher.Listener e;
    public final CopyOnWriteArraySet<Listener> f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public List<Download> o;
    public RequirementsWatcher p;

    public interface Listener {
        void onDownloadChanged(DownloadManager downloadManager, Download download, @Nullable Exception exc);

        void onDownloadRemoved(DownloadManager downloadManager, Download download);

        void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z);

        void onIdle(DownloadManager downloadManager);

        void onInitialized(DownloadManager downloadManager);

        void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i);

        void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z);
    }

    public static final class b {
        public final Download a;
        public final boolean b;
        public final List<Download> c;
        @Nullable
        public final Exception d;

        public b(Download download, boolean z, List<Download> list, @Nullable Exception exc) {
            this.a = download;
            this.b = z;
            this.c = list;
            this.d = exc;
        }
    }

    public static final class c extends Handler {
        public static final /* synthetic */ int m = 0;
        public boolean a;
        public final HandlerThread b;
        public final WritableDownloadIndex c;
        public final DownloaderFactory d;
        public final Handler e;
        public final ArrayList<Download> f = new ArrayList<>();
        public final HashMap<String, d> g = new HashMap<>();
        public int h;
        public boolean i;
        public int j;
        public int k;
        public int l;

        public c(HandlerThread handlerThread, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory, Handler handler, int i2, int i3, boolean z) {
            super(handlerThread.getLooper());
            this.b = handlerThread;
            this.c = writableDownloadIndex;
            this.d = downloaderFactory;
            this.e = handler;
            this.j = i2;
            this.k = i3;
            this.i = z;
        }

        public static Download a(Download download, int i2) {
            return new Download(download.request, i2, download.startTimeMs, System.currentTimeMillis(), download.contentLength, 0, 0, download.a);
        }

        @Nullable
        public final Download b(String str, boolean z) {
            int c2 = c(str);
            if (c2 != -1) {
                return this.f.get(c2);
            }
            if (!z) {
                return null;
            }
            try {
                return this.c.getDownload(str);
            } catch (IOException e2) {
                Log.e("DownloadManager", "Failed to load download: " + str, e2);
                return null;
            }
        }

        public final int c(String str) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                if (this.f.get(i2).request.id.equals(str)) {
                    return i2;
                }
            }
            return -1;
        }

        public final Download d(Download download) {
            int i2 = download.state;
            boolean z = true;
            Assertions.checkState((i2 == 3 || i2 == 4) ? false : true);
            int c2 = c(download.request.id);
            if (c2 == -1) {
                this.f.add(download);
                Collections.sort(this.f, i.a);
            } else {
                if (download.startTimeMs == this.f.get(c2).startTimeMs) {
                    z = false;
                }
                this.f.set(c2, download);
                if (z) {
                    Collections.sort(this.f, i.a);
                }
            }
            try {
                this.c.putDownload(download);
            } catch (IOException e2) {
                Log.e("DownloadManager", "Failed to update index.", e2);
            }
            this.e.obtainMessage(2, new b(download, false, new ArrayList(this.f), null)).sendToTarget();
            return download;
        }

        public final Download e(Download download, int i2) {
            boolean z = true;
            if (i2 == 3 || i2 == 4 || i2 == 1) {
                z = false;
            }
            Assertions.checkState(z);
            Download a3 = a(download, i2);
            d(a3);
            return a3;
        }

        public final void f(Download download, int i2) {
            if (i2 == 0) {
                if (download.state == 1) {
                    e(download, 0);
                }
            } else if (i2 != download.stopReason) {
                int i3 = download.state;
                if (i3 == 0 || i3 == 2) {
                    i3 = 1;
                }
                d(new Download(download.request, i3, download.startTimeMs, System.currentTimeMillis(), download.contentLength, i2, 0, download.a));
            }
        }

        public final void g() {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                Download download = this.f.get(i3);
                d dVar = this.g.get(download.request.id);
                int i4 = download.state;
                boolean z = true;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 == 2) {
                            Assertions.checkNotNull(dVar);
                            Assertions.checkState(!dVar.d);
                            if (this.i || this.h != 0) {
                                z = false;
                            }
                            if (!z || i2 >= this.j) {
                                e(download, 0);
                                dVar.a(false);
                            }
                        } else if (i4 != 5 && i4 != 7) {
                            throw new IllegalStateException();
                        } else if (dVar == null) {
                            d dVar2 = new d(download.request, this.d.createDownloader(download.request), download.a, true, this.k, this, null);
                            this.g.put(download.request.id, dVar2);
                            dVar2.start();
                        } else if (!dVar.d) {
                            dVar.a(false);
                        }
                    } else if (dVar != null) {
                        Assertions.checkState(!dVar.d);
                        dVar.a(false);
                    }
                } else if (dVar != null) {
                    Assertions.checkState(!dVar.d);
                    dVar.a(false);
                } else {
                    if (this.i || this.h != 0) {
                        z = false;
                    }
                    if (!z || this.l >= this.j) {
                        dVar = null;
                    } else {
                        Download e2 = e(download, 2);
                        dVar = new d(e2.request, this.d.createDownloader(e2.request), e2.a, false, this.k, this, null);
                        this.g.put(e2.request.id, dVar);
                        int i5 = this.l;
                        this.l = i5 + 1;
                        if (i5 == 0) {
                            sendEmptyMessageDelayed(11, 5000);
                        }
                        dVar.start();
                    }
                }
                if (dVar != null && !dVar.d) {
                    i2++;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0201, code lost:
            r0.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0205, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x01fa, code lost:
            if (r4 != null) goto L_0x01fc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0200, code lost:
            r0 = move-exception;
         */
        @Override // android.os.Handler
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r25) {
            /*
            // Method dump skipped, instructions count: 990
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadManager.c.handleMessage(android.os.Message):void");
        }
    }

    public static class d extends Thread implements Downloader.ProgressListener {
        public final DownloadRequest a;
        public final Downloader b;
        public final DownloadProgress c;
        public final boolean d;
        public final int e;
        @Nullable
        public volatile c f;
        public volatile boolean g;
        @Nullable
        public Exception h;
        public long i = -1;

        public d(DownloadRequest downloadRequest, Downloader downloader, DownloadProgress downloadProgress, boolean z, int i2, c cVar, a aVar) {
            this.a = downloadRequest;
            this.b = downloader;
            this.c = downloadProgress;
            this.d = z;
            this.e = i2;
            this.f = cVar;
        }

        public void a(boolean z) {
            if (z) {
                this.f = null;
            }
            if (!this.g) {
                this.g = true;
                this.b.cancel();
                interrupt();
            }
        }

        @Override // com.google.android.exoplayer2.offline.Downloader.ProgressListener
        public void onProgress(long j, long j2, float f2) {
            this.c.bytesDownloaded = j2;
            this.c.percentDownloaded = f2;
            if (j != this.i) {
                this.i = j;
                c cVar = this.f;
                if (cVar != null) {
                    cVar.obtainMessage(10, (int) (j >> 32), (int) j, this).sendToTarget();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.d) {
                    this.b.remove();
                } else {
                    long j = -1;
                    int i2 = 0;
                    while (!this.g) {
                        try {
                            this.b.download(this);
                            break;
                        } catch (IOException e2) {
                            if (!this.g) {
                                long j2 = this.c.bytesDownloaded;
                                if (j2 != j) {
                                    j = j2;
                                    i2 = 0;
                                }
                                i2++;
                                if (i2 <= this.e) {
                                    Thread.sleep((long) Math.min((i2 - 1) * 1000, 5000));
                                } else {
                                    throw e2;
                                }
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e3) {
                this.h = e3;
            }
            c cVar = this.f;
            if (cVar != null) {
                cVar.obtainMessage(9, this).sendToTarget();
            }
        }
    }

    @Deprecated
    public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory) {
        this(context, databaseProvider, cache, factory, m.a);
    }

    public static Download a(Download download, DownloadRequest downloadRequest, int i2, long j2) {
        int i3 = download.state;
        return new Download(download.request.copyWithMergedRequest(downloadRequest), (i3 == 5 || i3 == 7) ? 7 : i2 != 0 ? 1 : 0, (i3 == 5 || download.isTerminalState()) ? j2 : download.startTimeMs, j2, -1, i2, 0);
    }

    public void addDownload(DownloadRequest downloadRequest) {
        addDownload(downloadRequest, 0);
    }

    public void addListener(Listener listener) {
        Assertions.checkNotNull(listener);
        this.f.add(listener);
    }

    public final void b() {
        Iterator<Listener> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().onWaitingForRequirementsChanged(this, this.n);
        }
    }

    public final void c(RequirementsWatcher requirementsWatcher, int i2) {
        Requirements requirements = requirementsWatcher.getRequirements();
        if (this.m != i2) {
            this.m = i2;
            this.g++;
            this.d.obtainMessage(2, i2, 0).sendToTarget();
        }
        boolean e2 = e();
        Iterator<Listener> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().onRequirementsStateChanged(this, requirements, i2);
        }
        if (e2) {
            b();
        }
    }

    public final void d(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.g++;
            this.d.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            boolean e2 = e();
            Iterator<Listener> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().onDownloadsPausedChanged(this, z);
            }
            if (e2) {
                b();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e() {
        /*
            r4 = this;
            boolean r0 = r4.j
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0024
            int r0 = r4.m
            if (r0 == 0) goto L_0x0024
            r0 = 0
        L_0x000b:
            java.util.List<com.google.android.exoplayer2.offline.Download> r3 = r4.o
            int r3 = r3.size()
            if (r0 >= r3) goto L_0x0024
            java.util.List<com.google.android.exoplayer2.offline.Download> r3 = r4.o
            java.lang.Object r3 = r3.get(r0)
            com.google.android.exoplayer2.offline.Download r3 = (com.google.android.exoplayer2.offline.Download) r3
            int r3 = r3.state
            if (r3 != 0) goto L_0x0021
            r0 = 1
            goto L_0x0025
        L_0x0021:
            int r0 = r0 + 1
            goto L_0x000b
        L_0x0024:
            r0 = 0
        L_0x0025:
            boolean r3 = r4.n
            if (r3 == r0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = 0
        L_0x002b:
            r4.n = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadManager.e():boolean");
    }

    public Looper getApplicationLooper() {
        return this.c.getLooper();
    }

    public List<Download> getCurrentDownloads() {
        return this.o;
    }

    public DownloadIndex getDownloadIndex() {
        return this.b;
    }

    public boolean getDownloadsPaused() {
        return this.j;
    }

    public int getMaxParallelDownloads() {
        return this.k;
    }

    public int getMinRetryCount() {
        return this.l;
    }

    public int getNotMetRequirements() {
        return this.m;
    }

    public Requirements getRequirements() {
        return this.p.getRequirements();
    }

    public boolean isIdle() {
        return this.h == 0 && this.g == 0;
    }

    public boolean isInitialized() {
        return this.i;
    }

    public boolean isWaitingForRequirements() {
        return this.n;
    }

    public void pauseDownloads() {
        d(true);
    }

    public void release() {
        synchronized (this.d) {
            c cVar = this.d;
            if (!cVar.a) {
                cVar.sendEmptyMessage(12);
                boolean z = false;
                while (true) {
                    c cVar2 = this.d;
                    if (cVar2.a) {
                        break;
                    }
                    try {
                        cVar2.wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
                this.c.removeCallbacksAndMessages(null);
                this.o = Collections.emptyList();
                this.g = 0;
                this.h = 0;
                this.i = false;
                this.m = 0;
                this.n = false;
            }
        }
    }

    public void removeAllDownloads() {
        this.g++;
        this.d.obtainMessage(8).sendToTarget();
    }

    public void removeDownload(String str) {
        this.g++;
        this.d.obtainMessage(7, str).sendToTarget();
    }

    public void removeListener(Listener listener) {
        this.f.remove(listener);
    }

    public void resumeDownloads() {
        d(false);
    }

    public void setMaxParallelDownloads(int i2) {
        Assertions.checkArgument(i2 > 0);
        if (this.k != i2) {
            this.k = i2;
            this.g++;
            this.d.obtainMessage(4, i2, 0).sendToTarget();
        }
    }

    public void setMinRetryCount(int i2) {
        Assertions.checkArgument(i2 >= 0);
        if (this.l != i2) {
            this.l = i2;
            this.g++;
            this.d.obtainMessage(5, i2, 0).sendToTarget();
        }
    }

    public void setRequirements(Requirements requirements) {
        if (!requirements.equals(this.p.getRequirements())) {
            this.p.stop();
            RequirementsWatcher requirementsWatcher = new RequirementsWatcher(this.a, this.e, requirements);
            this.p = requirementsWatcher;
            c(this.p, requirementsWatcher.start());
        }
    }

    public void setStopReason(@Nullable String str, int i2) {
        this.g++;
        this.d.obtainMessage(3, i2, 0, str).sendToTarget();
    }

    public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory, Executor executor) {
        this(context, new DefaultDownloadIndex(databaseProvider), new DefaultDownloaderFactory(new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(factory), executor));
    }

    public void addDownload(DownloadRequest downloadRequest, int i2) {
        this.g++;
        this.d.obtainMessage(6, i2, 0, downloadRequest).sendToTarget();
    }

    public DownloadManager(Context context, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory) {
        this.a = context.getApplicationContext();
        this.b = writableDownloadIndex;
        this.k = 3;
        this.l = 5;
        this.j = true;
        this.o = Collections.emptyList();
        this.f = new CopyOnWriteArraySet<>();
        Handler createHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper(new Handler.Callback() { // from class: a2.j.b.b.x0.j
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                DownloadManager downloadManager = DownloadManager.this;
                int i2 = DownloadManager.DEFAULT_MAX_PARALLEL_DOWNLOADS;
                Objects.requireNonNull(downloadManager);
                int i3 = message.what;
                if (i3 == 0) {
                    downloadManager.i = true;
                    downloadManager.o = Collections.unmodifiableList((List) message.obj);
                    boolean e2 = downloadManager.e();
                    Iterator<DownloadManager.Listener> it = downloadManager.f.iterator();
                    while (it.hasNext()) {
                        it.next().onInitialized(downloadManager);
                    }
                    if (e2) {
                        downloadManager.b();
                    }
                } else if (i3 == 1) {
                    int i4 = message.arg1;
                    int i5 = message.arg2;
                    downloadManager.g -= i4;
                    downloadManager.h = i5;
                    if (downloadManager.isIdle()) {
                        Iterator<DownloadManager.Listener> it2 = downloadManager.f.iterator();
                        while (it2.hasNext()) {
                            it2.next().onIdle(downloadManager);
                        }
                    }
                } else if (i3 == 2) {
                    DownloadManager.b bVar = (DownloadManager.b) message.obj;
                    downloadManager.o = Collections.unmodifiableList(bVar.c);
                    Download download = bVar.a;
                    boolean e3 = downloadManager.e();
                    if (bVar.b) {
                        Iterator<DownloadManager.Listener> it3 = downloadManager.f.iterator();
                        while (it3.hasNext()) {
                            it3.next().onDownloadRemoved(downloadManager, download);
                        }
                    } else {
                        Iterator<DownloadManager.Listener> it4 = downloadManager.f.iterator();
                        while (it4.hasNext()) {
                            it4.next().onDownloadChanged(downloadManager, download, bVar.d);
                        }
                    }
                    if (e3) {
                        downloadManager.b();
                    }
                } else {
                    throw new IllegalStateException();
                }
                return true;
            }
        });
        this.c = createHandlerForCurrentOrMainLooper;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        c cVar = new c(handlerThread, writableDownloadIndex, downloaderFactory, createHandlerForCurrentOrMainLooper, this.k, this.l, this.j);
        this.d = cVar;
        h hVar = new RequirementsWatcher.Listener() { // from class: a2.j.b.b.x0.h
            @Override // com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener
            public final void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i2) {
                DownloadManager downloadManager = DownloadManager.this;
                int i3 = DownloadManager.DEFAULT_MAX_PARALLEL_DOWNLOADS;
                downloadManager.c(requirementsWatcher, i2);
            }
        };
        this.e = hVar;
        RequirementsWatcher requirementsWatcher = new RequirementsWatcher(context, hVar, DEFAULT_REQUIREMENTS);
        this.p = requirementsWatcher;
        int start = requirementsWatcher.start();
        this.m = start;
        this.g = 1;
        cVar.obtainMessage(0, start, 0).sendToTarget();
    }
}
