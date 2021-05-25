package net.gotev.uploadservice;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.extensions.UploadTaskCreationParameters;
import net.gotev.uploadservice.extensions.WakeLockExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.observer.request.NotificationActionsObserver;
import net.gotev.uploadservice.observer.task.BroadcastEmitter;
import net.gotev.uploadservice.observer.task.TaskCompletionNotifier;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import v6.a.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b/\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0016\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\rJ\u000f\u0010\u001a\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0018\u00010\u001cR\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010!R#\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8B@\u0002X\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020*8B@\u0002X\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lnet/gotev/uploadservice/UploadService;", "Landroid/app/Service;", "", "uploadId", "Landroid/app/Notification;", "notification", "", "holdForegroundNotification", "(Ljava/lang/String;Landroid/app/Notification;)Z", "", "taskCompleted", "(Ljava/lang/String;)V", "onCreate", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "()I", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "Landroid/os/PowerManager$WakeLock;", "wakeLock", "Ljava/util/Timer;", "Ljava/util/Timer;", "idleTimer", "", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "c", "Lkotlin/Lazy;", "getTaskObservers", "()[Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "taskObservers", "Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "d", "getNotificationActionsObserver", "()Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "notificationActionsObserver", "<init>", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadService extends Service {
    public static final Companion Companion = new Companion(null);
    public static final String e = UploadService.class.getSimpleName();
    public static int f;
    public static final ConcurrentHashMap<String, UploadTask> g = new ConcurrentHashMap<>();
    public static volatile String h;
    public PowerManager.WakeLock a;
    public Timer b;
    public final Lazy c = t6.c.lazy(new h(this));
    public final Lazy d = t6.c.lazy(new f(this));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8F@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lnet/gotev/uploadservice/UploadService$Companion;", "", "", "uploadId", "", "stopUpload", "(Ljava/lang/String;)V", "stopAllUploads", "()V", "Landroid/content/Context;", "context", "", "forceStop", "stop", "(Landroid/content/Context;Z)Z", "", "getTaskList", "()Ljava/util/List;", "getTaskList$annotations", "taskList", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "getTAG$uploadservice_release", "()Ljava/lang/String;", "", "UPLOAD_NOTIFICATION_BASE_ID", "I", "foregroundUploadId", "notificationIncrementalId", "Ljava/util/concurrent/ConcurrentHashMap;", "Lnet/gotev/uploadservice/UploadTask;", "uploadTasksMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getTaskList$annotations() {
        }

        public static /* synthetic */ boolean stop$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.stop(context, z);
        }

        public final String getTAG$uploadservice_release() {
            return UploadService.e;
        }

        @NotNull
        public final synchronized List<String> getTaskList() {
            List<String> list;
            if (UploadService.g.isEmpty()) {
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                Enumeration keys = UploadService.g.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "uploadTasksMap.keys()");
                list = Collections.list(keys);
                Intrinsics.checkNotNullExpressionValue(list, "java.util.Collections.list(this)");
            }
            return list;
        }

        @JvmStatic
        @JvmOverloads
        public final boolean stop(@NotNull Context context) {
            return stop$default(this, context, false, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        public final synchronized boolean stop(@NotNull Context context, boolean z) {
            boolean z2;
            Intrinsics.checkNotNullParameter(context, "context");
            if (z) {
                stopAllUploads();
                z2 = context.stopService(new Intent(context, UploadService.class));
            } else {
                z2 = UploadService.g.isEmpty() && context.stopService(new Intent(context, UploadService.class));
            }
            return z2;
        }

        @JvmStatic
        public final synchronized void stopAllUploads() {
            for (Object obj : UploadService.g.keySet()) {
                UploadTask uploadTask = (UploadTask) UploadService.g.get(obj);
                if (uploadTask != null) {
                    uploadTask.cancel();
                }
            }
        }

        @JvmStatic
        public final synchronized void stopUpload(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "uploadId");
            UploadTask uploadTask = (UploadTask) UploadService.g.get(str);
            if (uploadTask != null) {
                uploadTask.cancel();
            }
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<String> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            int i = this.a;
            if (i == 0) {
                return "Stopping foreground execution";
            }
            if (i == 1) {
                return "UploadService destroyed";
            }
            throw null;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<String> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            int i = this.a;
            if (i == 0) {
                return "Starting UploadService. Debug info: " + UploadServiceConfig.INSTANCE;
            } else if (i == 1) {
                return "Preventing upload! An upload with the same ID is already in progress. Every upload must have unique ID. Please check your code and fix it!";
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class c extends Lambda implements Function0<String> {
        public static final c b = new c(0);
        public static final c c = new c(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            int i = this.a;
            if (i == 0) {
                return "now un-holded foreground notification";
            }
            if (i == 1) {
                return "All tasks completed, stopping foreground execution";
            }
            throw null;
        }
    }

    public static final class d extends Lambda implements Function0<String> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "Clearing idle timer";
        }
    }

    public static final class e extends Lambda implements Function0<String> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "now holds foreground notification";
        }
    }

    public static final class f extends Lambda implements Function0<NotificationActionsObserver> {
        public final /* synthetic */ UploadService a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(UploadService uploadService) {
            super(0);
            this.a = uploadService;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public NotificationActionsObserver invoke() {
            return UploadServiceConfig.getNotificationActionsObserverFactory().invoke(this.a);
        }
    }

    public static final class g extends Lambda implements Function0<String> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("Service will be shut down in ");
            L.append(UploadServiceConfig.getIdleTimeoutSeconds());
            L.append("s ");
            L.append("if no new tasks are received");
            return L.toString();
        }
    }

    public static final class h extends Lambda implements Function0<UploadTaskObserver[]> {
        public final /* synthetic */ UploadService a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(UploadService uploadService) {
            super(0);
            this.a = uploadService;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public UploadTaskObserver[] invoke() {
            return new UploadTaskObserver[]{new BroadcastEmitter(this.a), UploadServiceConfig.getNotificationHandlerFactory().invoke(this.a), new TaskCompletionNotifier(this.a)};
        }
    }

    @NotNull
    public static final synchronized List<String> getTaskList() {
        List<String> taskList;
        synchronized (UploadService.class) {
            taskList = Companion.getTaskList();
        }
        return taskList;
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean stop(@NotNull Context context) {
        return Companion.stop$default(Companion, context, false, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final synchronized boolean stop(@NotNull Context context, boolean z) {
        boolean stop;
        synchronized (UploadService.class) {
            stop = Companion.stop(context, z);
        }
        return stop;
    }

    @JvmStatic
    public static final synchronized void stopAllUploads() {
        synchronized (UploadService.class) {
            Companion.stopAllUploads();
        }
    }

    @JvmStatic
    public static final synchronized void stopUpload(@NotNull String str) {
        synchronized (UploadService.class) {
            Companion.stopUpload(str);
        }
    }

    public final synchronized void a() {
        Timer timer = this.b;
        if (timer != null) {
            String str = e;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.info(str, UploadServiceLogger.NA, d.a);
            timer.cancel();
        }
        this.b = null;
    }

    public final synchronized int b() {
        if (!g.isEmpty()) {
            return 1;
        }
        a();
        String str = e;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadServiceLogger.info(str, UploadServiceLogger.NA, g.a);
        Timer timer = new Timer(str + "IdleTimer");
        timer.schedule(new TimerTask(this) { // from class: net.gotev.uploadservice.UploadService$shutdownIfThereArentAnyActiveTasks$$inlined$apply$lambda$1
            public final /* synthetic */ UploadService a;

            {
                this.a = r1;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                String tAG$uploadservice_release = UploadService.Companion.getTAG$uploadservice_release();
                Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release, "TAG");
                UploadServiceLogger.info(tAG$uploadservice_release, UploadServiceLogger.NA, a.a);
                this.a.stopSelf();
            }
        }, (long) (UploadServiceConfig.getIdleTimeoutSeconds() * 1000));
        this.b = timer;
        return 2;
    }

    public final synchronized boolean holdForegroundNotification(@NotNull String str, @NotNull Notification notification) {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (!UploadServiceConfig.isForegroundService()) {
            return false;
        }
        if (h == null) {
            h = str;
            String str2 = e;
            Intrinsics.checkNotNullExpressionValue(str2, "TAG");
            UploadServiceLogger.debug(str2, str, e.a);
        }
        if (!Intrinsics.areEqual(str, h)) {
            return false;
        }
        startForeground(1234, notification);
        return true;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        PowerManager.WakeLock wakeLock = this.a;
        String str = e;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        this.a = WakeLockExtensionsKt.acquirePartialWakeLock(this, wakeLock, str);
        ((NotificationActionsObserver) this.d.getValue()).register();
        String defaultNotificationChannel = UploadServiceConfig.getDefaultNotificationChannel();
        Intrinsics.checkNotNull(defaultNotificationChannel);
        startForeground(1234, new NotificationCompat.Builder(this, defaultNotificationChannel).setSmallIcon(17301589).setOngoing(true).setGroup(UploadServiceConfig.getNamespace()).build());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ((NotificationActionsObserver) this.d.getValue()).unregister();
        Companion.stopAllUploads();
        if (UploadServiceConfig.isForegroundService()) {
            String str = e;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.debug(str, UploadServiceLogger.NA, a.b);
            stopForeground(true);
        }
        WakeLockExtensionsKt.safeRelease(this.a);
        g.clear();
        String str2 = e;
        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
        UploadServiceLogger.debug(str2, UploadServiceLogger.NA, a.c);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        String str = e;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadServiceLogger.debug(str, UploadServiceLogger.NA, b.b);
        UploadTaskCreationParameters uploadTaskCreationParameters = ContextExtensionsKt.getUploadTaskCreationParameters(intent);
        if (uploadTaskCreationParameters == null) {
            return b();
        }
        ConcurrentHashMap<String, UploadTask> concurrentHashMap = g;
        if (concurrentHashMap.containsKey(uploadTaskCreationParameters.getParams().getId())) {
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.error$default(str, uploadTaskCreationParameters.getParams().getId(), null, b.c, 4, null);
            return b();
        }
        int i3 = f + 2;
        f = i3;
        UploadTaskObserver[] uploadTaskObserverArr = (UploadTaskObserver[]) this.c.getValue();
        UploadTask uploadTask = ContextExtensionsKt.getUploadTask(this, uploadTaskCreationParameters, i3 + 1234, (UploadTaskObserver[]) Arrays.copyOf(uploadTaskObserverArr, uploadTaskObserverArr.length));
        if (uploadTask == null) {
            return b();
        }
        a();
        concurrentHashMap.put(uploadTask.getParams().getId(), uploadTask);
        UploadServiceConfig.getThreadPool().execute(uploadTask);
        return 1;
    }

    public final synchronized void taskCompleted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        ConcurrentHashMap<String, UploadTask> concurrentHashMap = g;
        UploadTask remove = concurrentHashMap.remove(str);
        if (UploadServiceConfig.isForegroundService() && remove != null && Intrinsics.areEqual(remove.getParams().getId(), h)) {
            String str2 = e;
            Intrinsics.checkNotNullExpressionValue(str2, "TAG");
            UploadServiceLogger.debug(str2, str, c.b);
            h = null;
        }
        if (UploadServiceConfig.isForegroundService() && concurrentHashMap.isEmpty()) {
            String str3 = e;
            Intrinsics.checkNotNullExpressionValue(str3, "TAG");
            UploadServiceLogger.debug(str3, UploadServiceLogger.NA, c.c);
            stopForeground(true);
            b();
        }
    }
}
