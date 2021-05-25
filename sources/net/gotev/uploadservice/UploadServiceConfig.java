package net.gotev.uploadservice;

import a2.g.r.g;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Names;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import net.gotev.uploadservice.data.RetryPolicyConfig;
import net.gotev.uploadservice.data.UploadNotificationAction;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadNotificationStatusConfig;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.HttpStack;
import net.gotev.uploadservice.network.hurl.HurlStack;
import net.gotev.uploadservice.observer.request.NotificationActionsObserver;
import net.gotev.uploadservice.observer.task.NotificationHandler;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;
import net.gotev.uploadservice.placeholders.DefaultPlaceholdersProcessor;
import net.gotev.uploadservice.placeholders.Placeholder;
import net.gotev.uploadservice.placeholders.PlaceholdersProcessor;
import net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler;
import net.gotev.uploadservice.schemehandlers.FileSchemeHandler;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.y.f;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\n\b\u0002¢\u0006\u0005\b\u0001\u0010\u001bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R.\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00048F@BX\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u0015R(\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b#\u0010\u001b\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"RX\u00102\u001a2\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0%8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b+\u0010,\u0012\u0004\b1\u0010\u001b\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00107\u001a\u0002038F@\u0007X\u0004¢\u0006\f\u0012\u0004\b6\u0010\u001b\u001a\u0004\b4\u00105R4\u0010B\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:088\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b;\u0010<\u0012\u0004\bA\u0010\u001b\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010E\u001a\u0002038F@\u0007X\u0004¢\u0006\f\u0012\u0004\bD\u0010\u001b\u001a\u0004\bC\u00105R(\u0010N\u001a\u00020F8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bG\u0010H\u0012\u0004\bM\u0010\u001b\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR(\u0010W\u001a\u00020O8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bP\u0010Q\u0012\u0004\bV\u0010\u001b\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR(\u0010`\u001a\u00020X8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bY\u0010Z\u0012\u0004\b_\u0010\u001b\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R4\u0010f\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020a088\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bb\u0010<\u0012\u0004\be\u0010\u001b\u001a\u0004\bc\u0010>\"\u0004\bd\u0010@R(\u0010i\u001a\u00020\u00068F@\u0006X\u000e¢\u0006\u0018\n\u0004\bg\u0010h\u0012\u0004\bm\u0010\u001b\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001c\u0010p\u001a\u00020\u00048F@\u0007X\u0004¢\u0006\f\u0012\u0004\bo\u0010\u001b\u001a\u0004\bn\u0010\u0015R\u001c\u0010s\u001a\u00020\u00048F@\u0007X\u0004¢\u0006\f\u0012\u0004\br\u0010\u001b\u001a\u0004\bq\u0010\u0015R0\u0010}\u001a\u00020t2\u0006\u0010u\u001a\u00020t8\u0006@FX\u000e¢\u0006\u0018\n\u0004\bv\u0010w\u0012\u0004\b|\u0010\u001b\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0016\u0010~\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b~\u0010\u0018R1\u0010\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00048F@BX\u000e¢\u0006\u0014\n\u0004\b\u0010\u0018\u0012\u0005\b\u0001\u0010\u001b\u001a\u0005\b\u0001\u0010\u0015R5\u0010\u0001\u001a\u00020t2\u0006\u0010u\u001a\u00020t8\u0006@FX\u000e¢\u0006\u001c\n\u0005\b\u0001\u0010w\u0012\u0005\b\u0001\u0010\u001b\u001a\u0005\b\u0001\u0010y\"\u0005\b\u0001\u0010{R7\u0010\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u00018B@\u0002X\u0002¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X\u000e¢\u0006\u001f\n\u0006\b\u0001\u0010\u0001\u0012\u0005\b\u0001\u0010\u001b\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u00020\u00048F@\u0007X\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u0010\u001b\u001a\u0005\b\u0001\u0010\u0015¨\u0006\u0001"}, d2 = {"Lnet/gotev/uploadservice/UploadServiceConfig;", "", "Landroid/app/Application;", "context", "", "defaultNotificationChannel", "", Names.DEBUG, "", "initialize", "(Landroid/app/Application;Ljava/lang/String;Z)V", "scheme", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "handler", "addSchemeHandler", "(Ljava/lang/String;Ljava/lang/Class;)V", MessageMetaInfo.COLUMN_PATH, "getSchemeHandler", "(Ljava/lang/String;)Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "toString", "()Ljava/lang/String;", "<set-?>", "c", "Ljava/lang/String;", "getDefaultNotificationChannel", "getDefaultNotificationChannel$annotations", "()V", "Ljava/util/concurrent/AbstractExecutorService;", "d", "Ljava/util/concurrent/AbstractExecutorService;", "getThreadPool", "()Ljava/util/concurrent/AbstractExecutorService;", "setThreadPool", "(Ljava/util/concurrent/AbstractExecutorService;)V", "getThreadPool$annotations", "threadPool", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "uploadId", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", g.a, "Lkotlin/jvm/functions/Function2;", "getNotificationConfigFactory", "()Lkotlin/jvm/functions/Function2;", "setNotificationConfigFactory", "(Lkotlin/jvm/functions/Function2;)V", "getNotificationConfigFactory$annotations", "notificationConfigFactory", "Landroid/content/IntentFilter;", "getBroadcastNotificationActionIntentFilter", "()Landroid/content/IntentFilter;", "getBroadcastNotificationActionIntentFilter$annotations", "broadcastNotificationActionIntentFilter", "Lkotlin/Function1;", "Lnet/gotev/uploadservice/UploadService;", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "f", "Lkotlin/jvm/functions/Function1;", "getNotificationHandlerFactory", "()Lkotlin/jvm/functions/Function1;", "setNotificationHandlerFactory", "(Lkotlin/jvm/functions/Function1;)V", "getNotificationHandlerFactory$annotations", "notificationHandlerFactory", "getBroadcastStatusIntentFilter", "getBroadcastStatusIntentFilter$annotations", "broadcastStatusIntentFilter", "Lnet/gotev/uploadservice/data/RetryPolicyConfig;", "l", "Lnet/gotev/uploadservice/data/RetryPolicyConfig;", "getRetryPolicy", "()Lnet/gotev/uploadservice/data/RetryPolicyConfig;", "setRetryPolicy", "(Lnet/gotev/uploadservice/data/RetryPolicyConfig;)V", "getRetryPolicy$annotations", "retryPolicy", "", "k", "J", "getUploadProgressNotificationIntervalMillis", "()J", "setUploadProgressNotificationIntervalMillis", "(J)V", "getUploadProgressNotificationIntervalMillis$annotations", "uploadProgressNotificationIntervalMillis", "Lnet/gotev/uploadservice/network/HttpStack;", "j", "Lnet/gotev/uploadservice/network/HttpStack;", "getHttpStack", "()Lnet/gotev/uploadservice/network/HttpStack;", "setHttpStack", "(Lnet/gotev/uploadservice/network/HttpStack;)V", "getHttpStack$annotations", "httpStack", "Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "e", "getNotificationActionsObserverFactory", "setNotificationActionsObserverFactory", "getNotificationActionsObserverFactory$annotations", "notificationActionsObserverFactory", AuthSource.OPEN_CHANNEL_LIST, "Z", "isForegroundService", "()Z", "setForegroundService", "(Z)V", "isForegroundService$annotations", "getBroadcastNotificationAction", "getBroadcastNotificationAction$annotations", "broadcastNotificationAction", "getUploadAction", "getUploadAction$annotations", "uploadAction", "", "value", "h", "I", "getIdleTimeoutSeconds", "()I", "setIdleTimeoutSeconds", "(I)V", "getIdleTimeoutSeconds$annotations", "idleTimeoutSeconds", "defaultUserAgent", AuthSource.BOOKING_ORDER, "getNamespace", "getNamespace$annotations", "namespace", "i", "getBufferSizeBytes", "setBufferSizeBytes", "getBufferSizeBytes$annotations", "bufferSizeBytes", "Ljava/util/LinkedHashMap;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "()Ljava/util/LinkedHashMap;", "schemeHandlers", "Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "n", "Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "getPlaceholdersProcessor", "()Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "setPlaceholdersProcessor", "(Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;)V", "getPlaceholdersProcessor$annotations", "placeholdersProcessor", "getBroadcastStatusAction", "getBroadcastStatusAction$annotations", "broadcastStatusAction", "<init>", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadServiceConfig {
    public static final UploadServiceConfig INSTANCE = new UploadServiceConfig();
    public static final Lazy a = t6.c.lazy(d.a);
    @Nullable
    public static String b = null;
    @Nullable
    public static String c = null;
    @NotNull
    public static AbstractExecutorService d = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), (long) 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
    @NotNull
    public static final String defaultUserAgent = "AndroidUploadService/4.5.2";
    @NotNull
    public static Function1<? super UploadService, ? extends NotificationActionsObserver> e = a.a;
    @NotNull
    public static Function1<? super UploadService, ? extends UploadTaskObserver> f = c.a;
    @NotNull
    public static Function2<? super Context, ? super String, UploadNotificationConfig> g = b.a;
    public static int h = 10;
    public static int i = 4096;
    @NotNull
    public static HttpStack j = new HurlStack(null, false, false, 0, 0, 31, null);
    public static long k = 333;
    @NotNull
    public static RetryPolicyConfig l = new RetryPolicyConfig(1, 100, 2, 3);
    public static boolean m = true;
    @NotNull
    public static PlaceholdersProcessor n = new DefaultPlaceholdersProcessor();

    public static final class a extends Lambda implements Function1<UploadService, NotificationActionsObserver> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public NotificationActionsObserver invoke(UploadService uploadService) {
            UploadService uploadService2 = uploadService;
            Intrinsics.checkNotNullParameter(uploadService2, "it");
            return new NotificationActionsObserver(uploadService2);
        }
    }

    public static final class b extends Lambda implements Function2<Context, String, UploadNotificationConfig> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public UploadNotificationConfig invoke(Context context, String str) {
            Context context2 = context;
            String str2 = str;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(str2, "uploadId");
            String defaultNotificationChannel = UploadServiceConfig.getDefaultNotificationChannel();
            Intrinsics.checkNotNull(defaultNotificationChannel);
            StringBuilder L = a2.b.a.a.a.L("Uploading at ");
            L.append(Placeholder.UploadRate);
            L.append(" (");
            L.append(Placeholder.Progress);
            L.append(')');
            UploadNotificationStatusConfig uploadNotificationStatusConfig = new UploadNotificationStatusConfig("Upload", L.toString(), 0, 0, null, null, CollectionsKt__CollectionsKt.arrayListOf(new UploadNotificationAction(17301560, "Cancel", ContextExtensionsKt.getCancelUploadIntent(context2, str2))), false, false, null, 956, null);
            StringBuilder L2 = a2.b.a.a.a.L("Upload completed successfully in ");
            L2.append(Placeholder.ElapsedTime);
            return new UploadNotificationConfig(defaultNotificationChannel, true, uploadNotificationStatusConfig, new UploadNotificationStatusConfig("Upload", L2.toString(), 0, 0, null, null, null, false, false, null, 1020, null), new UploadNotificationStatusConfig("Upload", "Error during upload", 0, 0, null, null, null, false, false, null, 1020, null), new UploadNotificationStatusConfig("Upload", "Upload cancelled", 0, 0, null, null, null, false, false, null, 1020, null));
        }
    }

    public static final class c extends Lambda implements Function1<UploadService, NotificationHandler> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public NotificationHandler invoke(UploadService uploadService) {
            UploadService uploadService2 = uploadService;
            Intrinsics.checkNotNullParameter(uploadService2, "uploadService");
            return new NotificationHandler(uploadService2);
        }
    }

    public static final class d extends Lambda implements Function0<LinkedHashMap<String, Class<? extends SchemeHandler>>> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public LinkedHashMap<String, Class<? extends SchemeHandler>> invoke() {
            LinkedHashMap<String, Class<? extends SchemeHandler>> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("/", FileSchemeHandler.class);
            linkedHashMap.put("content://", ContentResolverSchemeHandler.class);
            return linkedHashMap;
        }
    }

    public static final class e extends Lambda implements Function1<Map.Entry<String, Class<? extends SchemeHandler>>, CharSequence> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(Map.Entry<String, Class<? extends SchemeHandler>> entry) {
            Map.Entry<String, Class<? extends SchemeHandler>> entry2 = entry;
            Intrinsics.checkNotNullParameter(entry2, "<name for destructuring parameter 0>");
            Class<? extends SchemeHandler> value = entry2.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote);
            sb.append(entry2.getKey());
            sb.append("\": \"");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            sb.append(value.getName());
            sb.append(Typography.quote);
            return sb.toString();
        }
    }

    @JvmStatic
    public static final void addSchemeHandler(@NotNull String str, @NotNull Class<? extends SchemeHandler> cls) {
        Intrinsics.checkNotNullParameter(str, "scheme");
        Intrinsics.checkNotNullParameter(cls, "handler");
        if (!Intrinsics.areEqual(str, "/") && !Intrinsics.areEqual(str, "content://")) {
            INSTANCE.a().put(str, cls);
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.e3("Cannot override bundled scheme: ", str, "! If you found a bug in a bundled scheme handler, please open an issue: https://github.com/gotev/android-upload-service").toString());
    }

    @NotNull
    public static final String getBroadcastNotificationAction() {
        return getNamespace() + ".uploadservice.broadcast.notification.action";
    }

    @JvmStatic
    public static /* synthetic */ void getBroadcastNotificationAction$annotations() {
    }

    @NotNull
    public static final IntentFilter getBroadcastNotificationActionIntentFilter() {
        return new IntentFilter(getBroadcastNotificationAction());
    }

    @JvmStatic
    public static /* synthetic */ void getBroadcastNotificationActionIntentFilter$annotations() {
    }

    @NotNull
    public static final String getBroadcastStatusAction() {
        return getNamespace() + ".uploadservice.broadcast.status";
    }

    @JvmStatic
    public static /* synthetic */ void getBroadcastStatusAction$annotations() {
    }

    @NotNull
    public static final IntentFilter getBroadcastStatusIntentFilter() {
        return new IntentFilter(getBroadcastStatusAction());
    }

    @JvmStatic
    public static /* synthetic */ void getBroadcastStatusIntentFilter$annotations() {
    }

    public static final int getBufferSizeBytes() {
        return i;
    }

    @JvmStatic
    public static /* synthetic */ void getBufferSizeBytes$annotations() {
    }

    @Nullable
    public static final String getDefaultNotificationChannel() {
        String str = c;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("You have to set defaultNotificationChannel in your Application subclass");
    }

    @JvmStatic
    public static /* synthetic */ void getDefaultNotificationChannel$annotations() {
    }

    @NotNull
    public static final HttpStack getHttpStack() {
        return j;
    }

    @JvmStatic
    public static /* synthetic */ void getHttpStack$annotations() {
    }

    public static final int getIdleTimeoutSeconds() {
        return h;
    }

    @JvmStatic
    public static /* synthetic */ void getIdleTimeoutSeconds$annotations() {
    }

    @Nullable
    public static final String getNamespace() {
        String str = b;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("You have to set namespace to your app package name (context.packageName) in your Application subclass");
    }

    @JvmStatic
    public static /* synthetic */ void getNamespace$annotations() {
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super net.gotev.uploadservice.UploadService, ? extends net.gotev.uploadservice.observer.request.NotificationActionsObserver>, kotlin.jvm.functions.Function1<net.gotev.uploadservice.UploadService, net.gotev.uploadservice.observer.request.NotificationActionsObserver> */
    @NotNull
    public static final Function1<UploadService, NotificationActionsObserver> getNotificationActionsObserverFactory() {
        return e;
    }

    @JvmStatic
    public static /* synthetic */ void getNotificationActionsObserverFactory$annotations() {
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.content.Context, ? super java.lang.String, net.gotev.uploadservice.data.UploadNotificationConfig>, kotlin.jvm.functions.Function2<android.content.Context, java.lang.String, net.gotev.uploadservice.data.UploadNotificationConfig> */
    @NotNull
    public static final Function2<Context, String, UploadNotificationConfig> getNotificationConfigFactory() {
        return g;
    }

    @JvmStatic
    public static /* synthetic */ void getNotificationConfigFactory$annotations() {
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super net.gotev.uploadservice.UploadService, ? extends net.gotev.uploadservice.observer.task.UploadTaskObserver>, kotlin.jvm.functions.Function1<net.gotev.uploadservice.UploadService, net.gotev.uploadservice.observer.task.UploadTaskObserver> */
    @NotNull
    public static final Function1<UploadService, UploadTaskObserver> getNotificationHandlerFactory() {
        return f;
    }

    @JvmStatic
    public static /* synthetic */ void getNotificationHandlerFactory$annotations() {
    }

    @NotNull
    public static final PlaceholdersProcessor getPlaceholdersProcessor() {
        return n;
    }

    @JvmStatic
    public static /* synthetic */ void getPlaceholdersProcessor$annotations() {
    }

    @NotNull
    public static final RetryPolicyConfig getRetryPolicy() {
        return l;
    }

    @JvmStatic
    public static /* synthetic */ void getRetryPolicy$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final SchemeHandler getSchemeHandler(@NotNull String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        String obj = StringsKt__StringsKt.trim(str).toString();
        for (Map.Entry<String, Class<? extends SchemeHandler>> entry : INSTANCE.a().entrySet()) {
            Class<? extends SchemeHandler> value = entry.getValue();
            if (m.startsWith(obj, entry.getKey(), true)) {
                Object newInstance = value.newInstance();
                SchemeHandler schemeHandler = (SchemeHandler) newInstance;
                schemeHandler.init(obj);
                Intrinsics.checkNotNullExpressionValue(newInstance, "handler.newInstance().ap…edPath)\n                }");
                return schemeHandler;
            }
        }
        StringBuilder R = a2.b.a.a.a.R("Unsupported scheme for ", str, ". Currently supported schemes are ");
        R.append(INSTANCE.a().keySet());
        throw new UnsupportedOperationException(R.toString());
    }

    @NotNull
    public static final AbstractExecutorService getThreadPool() {
        return d;
    }

    @JvmStatic
    public static /* synthetic */ void getThreadPool$annotations() {
    }

    @NotNull
    public static final String getUploadAction() {
        return getNamespace() + ".uploadservice.action.upload";
    }

    @JvmStatic
    public static /* synthetic */ void getUploadAction$annotations() {
    }

    public static final long getUploadProgressNotificationIntervalMillis() {
        return k;
    }

    @JvmStatic
    public static /* synthetic */ void getUploadProgressNotificationIntervalMillis$annotations() {
    }

    @JvmStatic
    public static final void initialize(@NotNull Application application, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(str, "defaultNotificationChannel");
        b = application.getPackageName();
        c = str;
        UploadServiceLogger.setDevelopmentMode(z);
    }

    public static final boolean isForegroundService() {
        return Build.VERSION.SDK_INT >= 26 || m;
    }

    @JvmStatic
    public static /* synthetic */ void isForegroundService$annotations() {
    }

    public static final void setBufferSizeBytes(int i2) {
        if (i2 >= 256) {
            i = i2;
            return;
        }
        throw new IllegalArgumentException("You can't set buffer size lower than 256 bytes".toString());
    }

    public static final void setForegroundService(boolean z) {
        m = z;
    }

    public static final void setHttpStack(@NotNull HttpStack httpStack) {
        Intrinsics.checkNotNullParameter(httpStack, "<set-?>");
        j = httpStack;
    }

    public static final void setIdleTimeoutSeconds(int i2) {
        boolean z = true;
        if (i2 < 1) {
            z = false;
        }
        if (z) {
            h = i2;
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("Idle timeout min allowable value is 1. It cannot be ", i2).toString());
    }

    public static final void setNotificationActionsObserverFactory(@NotNull Function1<? super UploadService, ? extends NotificationActionsObserver> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        e = function1;
    }

    public static final void setNotificationConfigFactory(@NotNull Function2<? super Context, ? super String, UploadNotificationConfig> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        g = function2;
    }

    public static final void setNotificationHandlerFactory(@NotNull Function1<? super UploadService, ? extends UploadTaskObserver> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        f = function1;
    }

    public static final void setPlaceholdersProcessor(@NotNull PlaceholdersProcessor placeholdersProcessor) {
        Intrinsics.checkNotNullParameter(placeholdersProcessor, "<set-?>");
        n = placeholdersProcessor;
    }

    public static final void setRetryPolicy(@NotNull RetryPolicyConfig retryPolicyConfig) {
        Intrinsics.checkNotNullParameter(retryPolicyConfig, "<set-?>");
        l = retryPolicyConfig;
    }

    public static final void setThreadPool(@NotNull AbstractExecutorService abstractExecutorService) {
        Intrinsics.checkNotNullParameter(abstractExecutorService, "<set-?>");
        d = abstractExecutorService;
    }

    public static final void setUploadProgressNotificationIntervalMillis(long j2) {
        k = j2;
    }

    public final LinkedHashMap<String, Class<? extends SchemeHandler>> a() {
        return (LinkedHashMap) a.getValue();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("\n            {\n                \"uploadServiceVersion\": \"4.5.2\",\n                \"androidApiVersion\": ");
        L.append(Build.VERSION.SDK_INT);
        L.append(",\n                \"namespace\": \"");
        L.append(getNamespace());
        L.append("\",\n                \"deviceProcessors\": ");
        L.append(Runtime.getRuntime().availableProcessors());
        L.append(",\n                \"idleTimeoutSeconds\": ");
        L.append(h);
        L.append(",\n                \"bufferSizeBytes\": ");
        L.append(i);
        L.append(",\n                \"httpStack\": \"");
        L.append(j.getClass().getName());
        L.append("\",\n                \"uploadProgressNotificationIntervalMillis\": ");
        L.append(k);
        L.append(",\n                \"retryPolicy\": ");
        L.append(l);
        L.append(",\n                \"isForegroundService\": ");
        L.append(isForegroundService());
        L.append(",\n                \"schemeHandlers\": {");
        Set<Map.Entry<String, Class<? extends SchemeHandler>>> entrySet = a().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "schemeHandlers.entries");
        L.append(CollectionsKt___CollectionsKt.joinToString$default(entrySet, null, null, null, 0, null, e.a, 31, null));
        L.append("}\n            }\n        ");
        return f.trimIndent(L.toString());
    }
}
