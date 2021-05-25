package net.gotev.uploadservice;

import a2.g.r.g;
import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.exceptions.UploadError;
import net.gotev.uploadservice.exceptions.UserCancelledUploadException;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.HttpStack;
import net.gotev.uploadservice.network.ServerResponse;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0019\b&\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b`\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\t\u0010\nJA\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0004¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020$H\u0004¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0004¢\u0006\u0004\b(\u0010\u0019R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010\f\u001a\u00020\u000b8\u0004@\u0004X.¢\u0006\u0012\n\u0004\b\f\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00106\u001a\b\u0012\u0004\u0012\u000203028D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u00108R\u0016\u0010B\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u00108R\"\u0010C\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020I8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b7\u0010JR\"\u0010P\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bL\u00108\u001a\u0004\bM\u0010N\"\u0004\bO\u0010\u001fR\u0016\u0010S\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010Y\u001a\u00020$8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010'R\u0016\u0010[\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u00108R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010R\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lnet/gotev/uploadservice/UploadTask;", "Ljava/lang/Runnable;", "", OkListener.KEY_EXCEPTION, "", AuthSource.BOOKING_ORDER, "(Ljava/lang/Throwable;)V", "Lnet/gotev/uploadservice/network/HttpStack;", "httpStack", "upload", "(Lnet/gotev/uploadservice/network/HttpStack;)V", "Landroid/content/Context;", "context", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "taskParams", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "notificationConfig", "", "notificationId", "", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "taskObservers", "init", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadTaskParameters;Lnet/gotev/uploadservice/data/UploadNotificationConfig;I[Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;)V", "performInitialization", "()V", "run", "resetUploadedBytes", "", "bytesSent", "onProgress", "(J)V", "Lnet/gotev/uploadservice/network/ServerResponse;", CommonKt.EXTRA_RESPONSE, "onResponseReceived", "(Lnet/gotev/uploadservice/network/ServerResponse;)V", "", "value", "setAllFilesHaveBeenSuccessfullyUploaded", "(Z)V", "cancel", "Ljava/util/ArrayList;", "d", "Ljava/util/ArrayList;", "observers", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "Lnet/gotev/uploadservice/data/UploadFile;", "getSuccessfullyUploadedFiles", "()Ljava/util/List;", "successfullyUploadedFiles", AuthSource.SEND_ABUSE, "J", "lastProgressNotificationTime", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "getNotificationConfig", "()Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "setNotificationConfig", "(Lnet/gotev/uploadservice/data/UploadNotificationConfig;)V", g.a, "startTime", "i", "errorDelay", "params", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "getParams", "()Lnet/gotev/uploadservice/data/UploadTaskParameters;", "setParams", "(Lnet/gotev/uploadservice/data/UploadTaskParameters;)V", "Lnet/gotev/uploadservice/data/UploadInfo;", "()Lnet/gotev/uploadservice/data/UploadInfo;", "uploadInfo", "e", "getTotalBytes", "()J", "setTotalBytes", "totalBytes", "h", "I", "attempts", "c", "Z", "getShouldContinue", "()Z", "setShouldContinue", "shouldContinue", "f", "uploadedBytes", "getNotificationId", "()I", "setNotificationId", "(I)V", "<init>", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public abstract class UploadTask implements Runnable {
    public static final Companion Companion = new Companion(null);
    public static final String j = UploadTask.class.getSimpleName();
    public long a;
    public int b;
    public boolean c = true;
    @NotNull
    public Context context;
    public final ArrayList<UploadTaskObserver> d = new ArrayList<>(2);
    public long e;
    public long f;
    public final long g = new Date().getTime();
    public int h;
    public long i = ((long) UploadServiceConfig.getRetryPolicy().getInitialWaitTimeSeconds());
    @NotNull
    public UploadNotificationConfig notificationConfig;
    @NotNull
    public UploadTaskParameters params;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lnet/gotev/uploadservice/UploadTask$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            int i = this.a;
            if (i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("upload ");
                sb.append(((ServerResponse) this.b).isSuccessful() ? "completed" : "error");
                return sb.toString();
            } else if (i == 1) {
                return "successfully deleted: " + ((UploadFile) this.b).getPath();
            } else if (i == 2) {
                return "error while deleting: " + ((UploadFile) this.b).getPath();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<String> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "error";
        }
    }

    public static final class c extends Lambda implements Function0<String> {
        public final /* synthetic */ UploadTask a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(UploadTask uploadTask) {
            super(0);
            this.a = uploadTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("uploaded ");
            L.append((this.a.f * ((long) 100)) / this.a.getTotalBytes());
            L.append("%, ");
            L.append(this.a.f);
            L.append(" of ");
            L.append(this.a.getTotalBytes());
            L.append(" bytes");
            return L.toString();
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
            return "error while uploading but user requested cancellation.";
        }
    }

    public static final class e extends Lambda implements Function0<String> {
        public final /* synthetic */ UploadTask a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(UploadTask uploadTask) {
            super(0);
            this.a = uploadTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder L = a2.b.a.a.a.L("error on attempt ");
            L.append(this.a.h + 1);
            L.append(". Waiting ");
            L.append(this.a.i);
            L.append("s before next attempt.");
            return L.toString();
        }
    }

    public static /* synthetic */ void setAllFilesHaveBeenSuccessfullyUploaded$default(UploadTask uploadTask, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = true;
            }
            uploadTask.setAllFilesHaveBeenSuccessfullyUploaded(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAllFilesHaveBeenSuccessfullyUploaded");
    }

    public final UploadInfo a() {
        UploadTaskParameters uploadTaskParameters = this.params;
        if (uploadTaskParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        String id = uploadTaskParameters.getId();
        long j2 = this.g;
        long j3 = this.f;
        long j4 = this.e;
        int i2 = this.h;
        UploadTaskParameters uploadTaskParameters2 = this.params;
        if (uploadTaskParameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        return new UploadInfo(id, j2, j3, j4, i2, uploadTaskParameters2.getFiles());
    }

    public final void b(Throwable th) {
        String str = j;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadTaskParameters uploadTaskParameters = this.params;
        if (uploadTaskParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        UploadServiceLogger.error(str, uploadTaskParameters.getId(), th, b.a);
        UploadInfo a3 = a();
        for (UploadTaskObserver uploadTaskObserver : this.d) {
            try {
                int i2 = this.b;
                UploadNotificationConfig uploadNotificationConfig = this.notificationConfig;
                if (uploadNotificationConfig == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationConfig");
                }
                uploadTaskObserver.onError(a3, i2, uploadNotificationConfig, th);
            } catch (Throwable th2) {
                String str2 = j;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                UploadServiceLogger.error(str2, getParams().getId(), th2, UploadTask$doForEachObserver$1$1.INSTANCE);
            }
        }
        for (UploadTaskObserver uploadTaskObserver2 : this.d) {
            try {
                int i3 = this.b;
                UploadNotificationConfig uploadNotificationConfig2 = this.notificationConfig;
                if (uploadNotificationConfig2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationConfig");
                }
                uploadTaskObserver2.onCompleted(a3, i3, uploadNotificationConfig2);
            } catch (Throwable th3) {
                String str3 = j;
                Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                UploadServiceLogger.error(str3, getParams().getId(), th3, UploadTask$doForEachObserver$1$1.INSTANCE);
            }
        }
    }

    public final void cancel() {
        this.c = false;
    }

    @NotNull
    public final Context getContext() {
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context2;
    }

    @NotNull
    public final UploadNotificationConfig getNotificationConfig() {
        UploadNotificationConfig uploadNotificationConfig = this.notificationConfig;
        if (uploadNotificationConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationConfig");
        }
        return uploadNotificationConfig;
    }

    public final int getNotificationId() {
        return this.b;
    }

    @NotNull
    public final UploadTaskParameters getParams() {
        UploadTaskParameters uploadTaskParameters = this.params;
        if (uploadTaskParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        return uploadTaskParameters;
    }

    public final boolean getShouldContinue() {
        return this.c;
    }

    @NotNull
    public final List<UploadFile> getSuccessfullyUploadedFiles() {
        UploadTaskParameters uploadTaskParameters = this.params;
        if (uploadTaskParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        ArrayList<UploadFile> files = uploadTaskParameters.getFiles();
        ArrayList arrayList = new ArrayList();
        for (T t : files) {
            if (t.getSuccessfullyUploaded()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public final long getTotalBytes() {
        return this.e;
    }

    public final void init(@NotNull Context context2, @NotNull UploadTaskParameters uploadTaskParameters, @NotNull UploadNotificationConfig uploadNotificationConfig, int i2, @NotNull UploadTaskObserver... uploadTaskObserverArr) throws IOException {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(uploadTaskParameters, "taskParams");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(uploadTaskObserverArr, "taskObservers");
        this.context = context2;
        this.params = uploadTaskParameters;
        this.b = i2;
        this.notificationConfig = uploadNotificationConfig;
        for (UploadTaskObserver uploadTaskObserver : uploadTaskObserverArr) {
            this.d.add(uploadTaskObserver);
        }
        performInitialization();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onProgress(long r6) {
        /*
            r5 = this;
            long r0 = r5.f
            long r0 = r0 + r6
            r5.f = r0
            long r6 = r5.e
            long r2 = java.lang.System.currentTimeMillis()
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x001c
            long r6 = r5.a
            long r0 = net.gotev.uploadservice.UploadServiceConfig.getUploadProgressNotificationIntervalMillis()
            long r0 = r0 + r6
            int r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x001c
            r6 = 1
            goto L_0x001f
        L_0x001c:
            r5.a = r2
            r6 = 0
        L_0x001f:
            if (r6 == 0) goto L_0x0022
            return
        L_0x0022:
            java.lang.String r6 = net.gotev.uploadservice.UploadTask.j
            java.lang.String r7 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            net.gotev.uploadservice.data.UploadTaskParameters r0 = r5.params
            if (r0 != 0) goto L_0x0032
            java.lang.String r1 = "params"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0032:
            java.lang.String r0 = r0.getId()
            net.gotev.uploadservice.UploadTask$c r1 = new net.gotev.uploadservice.UploadTask$c
            r1.<init>(r5)
            net.gotev.uploadservice.logger.UploadServiceLogger.debug(r6, r0, r1)
            java.util.ArrayList r6 = access$getObservers$p(r5)
            java.util.Iterator r6 = r6.iterator()
        L_0x0046:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x007b
            java.lang.Object r0 = r6.next()
            net.gotev.uploadservice.observer.task.UploadTaskObserver r0 = (net.gotev.uploadservice.observer.task.UploadTaskObserver) r0
            net.gotev.uploadservice.data.UploadInfo r1 = r5.a()     // Catch:{ all -> 0x0065 }
            int r2 = r5.b     // Catch:{ all -> 0x0065 }
            net.gotev.uploadservice.data.UploadNotificationConfig r3 = r5.notificationConfig     // Catch:{ all -> 0x0065 }
            if (r3 != 0) goto L_0x0061
            java.lang.String r4 = "notificationConfig"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x0065 }
        L_0x0061:
            r0.onProgress(r1, r2, r3)     // Catch:{ all -> 0x0065 }
            goto L_0x0046
        L_0x0065:
            r0 = move-exception
            java.lang.String r1 = access$getTAG$cp()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            net.gotev.uploadservice.data.UploadTaskParameters r2 = r5.getParams()
            java.lang.String r2 = r2.getId()
            net.gotev.uploadservice.UploadTask$doForEachObserver$1$1 r3 = net.gotev.uploadservice.UploadTask$doForEachObserver$1$1.INSTANCE
            net.gotev.uploadservice.logger.UploadServiceLogger.error(r1, r2, r0, r3)
            goto L_0x0046
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.UploadTask.onProgress(long):void");
    }

    public final void onResponseReceived(@NotNull ServerResponse serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, CommonKt.EXTRA_RESPONSE);
        String str = j;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadTaskParameters uploadTaskParameters = this.params;
        if (uploadTaskParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        UploadServiceLogger.debug(str, uploadTaskParameters.getId(), new a(0, serverResponse));
        if (serverResponse.isSuccessful()) {
            UploadTaskParameters uploadTaskParameters2 = this.params;
            if (uploadTaskParameters2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }
            if (uploadTaskParameters2.getAutoDeleteSuccessfullyUploadedFiles()) {
                for (UploadFile uploadFile : getSuccessfullyUploadedFiles()) {
                    SchemeHandler handler = uploadFile.getHandler();
                    Context context2 = this.context;
                    if (context2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                    }
                    if (handler.delete(context2)) {
                        String str2 = j;
                        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                        UploadTaskParameters uploadTaskParameters3 = this.params;
                        if (uploadTaskParameters3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("params");
                        }
                        UploadServiceLogger.info(str2, uploadTaskParameters3.getId(), new a(1, uploadFile));
                    } else {
                        String str3 = j;
                        Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                        UploadTaskParameters uploadTaskParameters4 = this.params;
                        if (uploadTaskParameters4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("params");
                        }
                        UploadServiceLogger.error$default(str3, uploadTaskParameters4.getId(), null, new a(2, uploadFile), 4, null);
                    }
                }
            }
            for (UploadTaskObserver uploadTaskObserver : this.d) {
                try {
                    UploadInfo a3 = a();
                    int i2 = this.b;
                    UploadNotificationConfig uploadNotificationConfig = this.notificationConfig;
                    if (uploadNotificationConfig == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationConfig");
                    }
                    uploadTaskObserver.onSuccess(a3, i2, uploadNotificationConfig, serverResponse);
                } catch (Throwable th) {
                    String str4 = j;
                    Intrinsics.checkNotNullExpressionValue(str4, "TAG");
                    UploadServiceLogger.error(str4, getParams().getId(), th, UploadTask$doForEachObserver$1$1.INSTANCE);
                }
            }
        } else {
            for (UploadTaskObserver uploadTaskObserver2 : this.d) {
                try {
                    UploadInfo a4 = a();
                    int i3 = this.b;
                    UploadNotificationConfig uploadNotificationConfig2 = this.notificationConfig;
                    if (uploadNotificationConfig2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationConfig");
                    }
                    uploadTaskObserver2.onError(a4, i3, uploadNotificationConfig2, new UploadError(serverResponse));
                } catch (Throwable th2) {
                    String str5 = j;
                    Intrinsics.checkNotNullExpressionValue(str5, "TAG");
                    UploadServiceLogger.error(str5, getParams().getId(), th2, UploadTask$doForEachObserver$1$1.INSTANCE);
                }
            }
        }
        for (UploadTaskObserver uploadTaskObserver3 : this.d) {
            try {
                UploadInfo a5 = a();
                int i4 = this.b;
                UploadNotificationConfig uploadNotificationConfig3 = this.notificationConfig;
                if (uploadNotificationConfig3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationConfig");
                }
                uploadTaskObserver3.onCompleted(a5, i4, uploadNotificationConfig3);
            } catch (Throwable th3) {
                String str6 = j;
                Intrinsics.checkNotNullExpressionValue(str6, "TAG");
                UploadServiceLogger.error(str6, getParams().getId(), th3, UploadTask$doForEachObserver$1$1.INSTANCE);
            }
        }
    }

    public void performInitialization() {
    }

    public final void resetUploadedBytes() {
        this.f = 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (UploadTaskObserver uploadTaskObserver : this.d) {
            try {
                UploadInfo a3 = a();
                int i2 = this.b;
                UploadNotificationConfig uploadNotificationConfig = this.notificationConfig;
                if (uploadNotificationConfig == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationConfig");
                }
                uploadTaskObserver.onStart(a3, i2, uploadNotificationConfig);
            } catch (Throwable th) {
                String str = j;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                UploadServiceLogger.error(str, getParams().getId(), th, UploadTask$doForEachObserver$1$1.INSTANCE);
            }
        }
        this.h = 0;
        this.i = (long) UploadServiceConfig.getRetryPolicy().getInitialWaitTimeSeconds();
        while (true) {
            int i3 = this.h;
            UploadTaskParameters uploadTaskParameters = this.params;
            if (uploadTaskParameters == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }
            if (i3 > uploadTaskParameters.getMaxRetries() || !this.c) {
                break;
            }
            try {
                resetUploadedBytes();
                upload(UploadServiceConfig.getHttpStack());
                break;
            } catch (Throwable unused) {
            }
        }
        if (!this.c) {
            String str2 = j;
            Intrinsics.checkNotNullExpressionValue(str2, "TAG");
            UploadTaskParameters uploadTaskParameters2 = this.params;
            if (uploadTaskParameters2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }
            UploadServiceLogger.debug(str2, uploadTaskParameters2.getId(), v6.a.a.b.a);
            b(new UserCancelledUploadException());
        }
    }

    public final void setAllFilesHaveBeenSuccessfullyUploaded(boolean z) {
        UploadTaskParameters uploadTaskParameters = this.params;
        if (uploadTaskParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        Iterator<T> it = uploadTaskParameters.getFiles().iterator();
        while (it.hasNext()) {
            it.next().setSuccessfullyUploaded(z);
        }
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setNotificationConfig(@NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "<set-?>");
        this.notificationConfig = uploadNotificationConfig;
    }

    public final void setNotificationId(int i2) {
        this.b = i2;
    }

    public final void setParams(@NotNull UploadTaskParameters uploadTaskParameters) {
        Intrinsics.checkNotNullParameter(uploadTaskParameters, "<set-?>");
        this.params = uploadTaskParameters;
    }

    public final void setShouldContinue(boolean z) {
        this.c = z;
    }

    public final void setTotalBytes(long j2) {
        this.e = j2;
    }

    public abstract void upload(@NotNull HttpStack httpStack) throws Exception;
}
