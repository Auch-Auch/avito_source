package com.google.android.exoplayer2.offline;

import a2.j.b.b.x0.l;
import a2.j.b.b.x0.q;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
public abstract class DownloadService extends Service {
    public static final String ACTION_ADD_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final String ACTION_PAUSE_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final String ACTION_REMOVE_ALL_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final String ACTION_REMOVE_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    public static final String ACTION_RESUME_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final String ACTION_SET_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final String ACTION_SET_STOP_REASON = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_DOWNLOAD_REQUEST = "download_request";
    public static final String KEY_FOREGROUND = "foreground";
    public static final String KEY_REQUIREMENTS = "requirements";
    public static final String KEY_STOP_REASON = "stop_reason";
    public static final HashMap<Class<? extends DownloadService>, b> k = new HashMap<>();
    @Nullable
    public final c a;
    @Nullable
    public final String b;
    @StringRes
    public final int c;
    @StringRes
    public final int d;
    public DownloadManager e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public static final class b implements DownloadManager.Listener {
        public final Context a;
        public final DownloadManager b;
        public final boolean c;
        @Nullable
        public final Scheduler d;
        public final Class<? extends DownloadService> e;
        @Nullable
        public DownloadService f;

        public b(Context context, DownloadManager downloadManager, boolean z, Scheduler scheduler, Class cls, a aVar) {
            this.a = context;
            this.b = downloadManager;
            this.c = z;
            this.d = scheduler;
            this.e = cls;
            downloadManager.addListener(this);
            b();
        }

        public final void a() {
            if (this.c) {
                Util.startForegroundService(this.a, DownloadService.b(this.a, this.e, "com.google.android.exoplayer.downloadService.action.RESTART"));
                return;
            }
            try {
                this.a.startService(DownloadService.b(this.a, this.e, DownloadService.ACTION_INIT));
            } catch (IllegalStateException unused) {
                Log.w("DownloadService", "Failed to restart DownloadService (process is idle).");
            }
        }

        public final void b() {
            if (this.d != null) {
                if (this.b.isWaitingForRequirements()) {
                    String packageName = this.a.getPackageName();
                    if (!this.d.schedule(this.b.getRequirements(), packageName, "com.google.android.exoplayer.downloadService.action.RESTART")) {
                        Log.e("DownloadService", "Scheduling downloads failed.");
                        return;
                    }
                    return;
                }
                this.d.cancel();
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onDownloadChanged(DownloadManager downloadManager, Download download, @Nullable Exception exc) {
            DownloadService downloadService = this.f;
            boolean z = true;
            if (downloadService != null) {
                String str = DownloadService.ACTION_INIT;
                downloadService.onDownloadChanged(download);
                if (downloadService.a != null) {
                    if (DownloadService.d(download.state)) {
                        c cVar = downloadService.a;
                        cVar.d = true;
                        cVar.b();
                    } else {
                        downloadService.a.a();
                    }
                }
            }
            DownloadService downloadService2 = this.f;
            if (downloadService2 != null && !downloadService2.i) {
                z = false;
            }
            if (z && DownloadService.d(download.state)) {
                Log.w("DownloadService", "DownloadService wasn't running. Restarting.");
                a();
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onDownloadRemoved(DownloadManager downloadManager, Download download) {
            DownloadService downloadService = this.f;
            if (downloadService != null) {
                String str = DownloadService.ACTION_INIT;
                downloadService.onDownloadRemoved(download);
                c cVar = downloadService.a;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public /* synthetic */ void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z) {
            q.$default$onDownloadsPausedChanged(this, downloadManager, z);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public final void onIdle(DownloadManager downloadManager) {
            DownloadService downloadService = this.f;
            if (downloadService != null) {
                String str = DownloadService.ACTION_INIT;
                downloadService.f();
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onInitialized(DownloadManager downloadManager) {
            DownloadService downloadService = this.f;
            if (downloadService != null) {
                DownloadService.a(downloadService, downloadManager.getCurrentDownloads());
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public /* synthetic */ void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i) {
            q.$default$onRequirementsStateChanged(this, downloadManager, requirements, i);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z) {
            if (!z && !downloadManager.getDownloadsPaused()) {
                DownloadService downloadService = this.f;
                int i = 0;
                if (downloadService == null || downloadService.i) {
                    List<Download> currentDownloads = downloadManager.getCurrentDownloads();
                    while (true) {
                        if (i >= currentDownloads.size()) {
                            break;
                        } else if (currentDownloads.get(i).state == 0) {
                            a();
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            b();
        }
    }

    public final class c {
        public final int a;
        public final long b;
        public final Handler c = new Handler(Looper.getMainLooper());
        public boolean d;
        public boolean e;

        public c(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public void a() {
            if (this.e) {
                b();
            }
        }

        public final void b() {
            List<Download> currentDownloads = ((DownloadManager) Assertions.checkNotNull(DownloadService.this.e)).getCurrentDownloads();
            DownloadService downloadService = DownloadService.this;
            downloadService.startForeground(this.a, downloadService.getForegroundNotification(currentDownloads));
            this.e = true;
            if (this.d) {
                this.c.removeCallbacksAndMessages(null);
                this.c.postDelayed(new l(this), this.b);
            }
        }
    }

    public DownloadService(int i2) {
        this(i2, 1000);
    }

    public static void a(DownloadService downloadService, List list) {
        if (downloadService.a != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (d(((Download) list.get(i2)).state)) {
                    c cVar = downloadService.a;
                    cVar.d = true;
                    cVar.b();
                    return;
                }
            }
        }
    }

    public static Intent b(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        return buildAddDownloadIntent(context, cls, downloadRequest, 0, z);
    }

    public static Intent buildPauseDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return c(context, cls, ACTION_PAUSE_DOWNLOADS, z);
    }

    public static Intent buildRemoveAllDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return c(context, cls, ACTION_REMOVE_ALL_DOWNLOADS, z);
    }

    public static Intent buildRemoveDownloadIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return c(context, cls, ACTION_REMOVE_DOWNLOAD, z).putExtra(KEY_CONTENT_ID, str);
    }

    public static Intent buildResumeDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return c(context, cls, ACTION_RESUME_DOWNLOADS, z);
    }

    public static Intent buildSetRequirementsIntent(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        return c(context, cls, ACTION_SET_REQUIREMENTS, z).putExtra(KEY_REQUIREMENTS, requirements);
    }

    public static Intent buildSetStopReasonIntent(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i2, boolean z) {
        return c(context, cls, ACTION_SET_STOP_REASON, z).putExtra(KEY_CONTENT_ID, str).putExtra(KEY_STOP_REASON, i2);
    }

    public static Intent c(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return b(context, cls, str).putExtra(KEY_FOREGROUND, z);
    }

    public static boolean d(int i2) {
        return i2 == 2 || i2 == 5 || i2 == 7;
    }

    public static void e(Context context, Intent intent, boolean z) {
        if (z) {
            Util.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        e(context, buildAddDownloadIntent(context, cls, downloadRequest, z), z);
    }

    public static void sendPauseDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        e(context, buildPauseDownloadsIntent(context, cls, z), z);
    }

    public static void sendRemoveAllDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        e(context, buildRemoveAllDownloadsIntent(context, cls, z), z);
    }

    public static void sendRemoveDownload(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        e(context, buildRemoveDownloadIntent(context, cls, str, z), z);
    }

    public static void sendResumeDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        e(context, buildResumeDownloadsIntent(context, cls, z), z);
    }

    public static void sendSetRequirements(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        e(context, buildSetRequirementsIntent(context, cls, requirements, z), z);
    }

    public static void sendSetStopReason(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i2, boolean z) {
        e(context, buildSetStopReasonIntent(context, cls, str, i2, z), z);
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(b(context, cls, ACTION_INIT));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        Util.startForegroundService(context, c(context, cls, ACTION_INIT, true));
    }

    public final void f() {
        c cVar = this.a;
        if (cVar != null) {
            cVar.d = false;
            cVar.c.removeCallbacksAndMessages(null);
        }
        if (Util.SDK_INT >= 28 || !this.h) {
            this.i |= stopSelfResult(this.f);
            return;
        }
        stopSelf();
        this.i = true;
    }

    public abstract DownloadManager getDownloadManager();

    public abstract Notification getForegroundNotification(List<Download> list);

    @Nullable
    public abstract Scheduler getScheduler();

    public final void invalidateForegroundNotification() {
        c cVar = this.a;
        if (cVar != null && !this.j) {
            cVar.a();
        }
    }

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.HashMap<java.lang.Class<? extends com.google.android.exoplayer2.offline.DownloadService>, com.google.android.exoplayer2.offline.DownloadService$b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Service
    public void onCreate() {
        String str = this.b;
        if (str != null) {
            NotificationUtil.createNotificationChannel(this, str, this.c, this.d, 2);
        }
        Class<?> cls = getClass();
        HashMap<Class<? extends DownloadService>, b> hashMap = k;
        b bVar = (b) hashMap.get(cls);
        boolean z = true;
        if (bVar == null) {
            boolean z2 = this.a != null;
            Scheduler scheduler = z2 ? getScheduler() : null;
            DownloadManager downloadManager = getDownloadManager();
            this.e = downloadManager;
            downloadManager.resumeDownloads();
            bVar = new b(getApplicationContext(), this.e, z2, scheduler, cls, null);
            hashMap.put(cls, bVar);
        } else {
            this.e = bVar.b;
        }
        if (bVar.f != null) {
            z = false;
        }
        Assertions.checkState(z);
        bVar.f = this;
        if (bVar.b.isInitialized()) {
            Util.createHandlerForCurrentOrMainLooper().postAtFrontOfQueue(new Runnable(this) { // from class: a2.j.b.b.x0.k
                public final /* synthetic */ DownloadService b;

                {
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    DownloadService.a(this.b, DownloadService.b.this.b.getCurrentDownloads());
                }
            });
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        boolean z = true;
        this.j = true;
        b bVar = (b) Assertions.checkNotNull(k.get(getClass()));
        if (bVar.f != this) {
            z = false;
        }
        Assertions.checkState(z);
        bVar.f = null;
        if (bVar.d != null && !bVar.b.isWaitingForRequirements()) {
            bVar.d.cancel();
        }
        c cVar = this.a;
        if (cVar != null) {
            cVar.d = false;
            cVar.c.removeCallbacksAndMessages(null);
        }
    }

    @Deprecated
    public void onDownloadChanged(Download download) {
    }

    @Deprecated
    public void onDownloadRemoved(Download download) {
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        String str;
        c cVar;
        this.f = i3;
        this.h = false;
        String str2 = null;
        if (intent != null) {
            str2 = intent.getAction();
            str = intent.getStringExtra(KEY_CONTENT_ID);
            this.g |= intent.getBooleanExtra(KEY_FOREGROUND, false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(str2);
        } else {
            str = null;
        }
        if (str2 == null) {
            str2 = ACTION_INIT;
        }
        DownloadManager downloadManager = (DownloadManager) Assertions.checkNotNull(this.e);
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1931239035:
                if (str2.equals(ACTION_ADD_DOWNLOAD)) {
                    c2 = 0;
                    break;
                }
                break;
            case -932047176:
                if (str2.equals(ACTION_RESUME_DOWNLOADS)) {
                    c2 = 1;
                    break;
                }
                break;
            case -871181424:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.RESTART")) {
                    c2 = 2;
                    break;
                }
                break;
            case -650547439:
                if (str2.equals(ACTION_REMOVE_ALL_DOWNLOADS)) {
                    c2 = 3;
                    break;
                }
                break;
            case -119057172:
                if (str2.equals(ACTION_SET_REQUIREMENTS)) {
                    c2 = 4;
                    break;
                }
                break;
            case 191112771:
                if (str2.equals(ACTION_PAUSE_DOWNLOADS)) {
                    c2 = 5;
                    break;
                }
                break;
            case 671523141:
                if (str2.equals(ACTION_SET_STOP_REASON)) {
                    c2 = 6;
                    break;
                }
                break;
            case 1015676687:
                if (str2.equals(ACTION_INIT)) {
                    c2 = 7;
                    break;
                }
                break;
            case 1547520644:
                if (str2.equals(ACTION_REMOVE_DOWNLOAD)) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) Assertions.checkNotNull(intent)).getParcelableExtra(KEY_DOWNLOAD_REQUEST);
                if (downloadRequest != null) {
                    downloadManager.addDownload(downloadRequest, intent.getIntExtra(KEY_STOP_REASON, 0));
                    break;
                } else {
                    Log.e("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
            case 1:
                downloadManager.resumeDownloads();
                break;
            case 2:
            case 7:
                break;
            case 3:
                downloadManager.removeAllDownloads();
                break;
            case 4:
                Requirements requirements = (Requirements) ((Intent) Assertions.checkNotNull(intent)).getParcelableExtra(KEY_REQUIREMENTS);
                if (requirements != null) {
                    Scheduler scheduler = getScheduler();
                    if (scheduler != null) {
                        Requirements supportedRequirements = scheduler.getSupportedRequirements(requirements);
                        if (!supportedRequirements.equals(requirements)) {
                            StringBuilder L = a2.b.a.a.a.L("Ignoring requirements not supported by the Scheduler: ");
                            L.append(requirements.getRequirements() ^ supportedRequirements.getRequirements());
                            Log.w("DownloadService", L.toString());
                            requirements = supportedRequirements;
                        }
                    }
                    downloadManager.setRequirements(requirements);
                    break;
                } else {
                    Log.e("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
            case 5:
                downloadManager.pauseDownloads();
                break;
            case 6:
                if (((Intent) Assertions.checkNotNull(intent)).hasExtra(KEY_STOP_REASON)) {
                    downloadManager.setStopReason(str, intent.getIntExtra(KEY_STOP_REASON, 0));
                    break;
                } else {
                    Log.e("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                }
            case '\b':
                if (str != null) {
                    downloadManager.removeDownload(str);
                    break;
                } else {
                    Log.e("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
            default:
                Log.e("DownloadService", "Ignored unrecognized action: " + str2);
                break;
        }
        if (Util.SDK_INT >= 26 && this.g && (cVar = this.a) != null && !cVar.e) {
            cVar.b();
        }
        this.i = false;
        if (downloadManager.isIdle()) {
            f();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.h = true;
    }

    public DownloadService(int i2, long j2) {
        this(i2, j2, null, 0, 0);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i2, boolean z) {
        return c(context, cls, ACTION_ADD_DOWNLOAD, z).putExtra(KEY_DOWNLOAD_REQUEST, downloadRequest).putExtra(KEY_STOP_REASON, i2);
    }

    @Deprecated
    public DownloadService(int i2, long j2, @Nullable String str, @StringRes int i3) {
        this(i2, j2, str, i3, 0);
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i2, boolean z) {
        e(context, buildAddDownloadIntent(context, cls, downloadRequest, i2, z), z);
    }

    public DownloadService(int i2, long j2, @Nullable String str, @StringRes int i3, @StringRes int i4) {
        if (i2 == 0) {
            this.a = null;
            this.b = null;
            this.c = 0;
            this.d = 0;
            return;
        }
        this.a = new c(i2, j2);
        this.b = str;
        this.c = i3;
        this.d = i4;
    }
}
