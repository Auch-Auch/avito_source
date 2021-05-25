package net.gotev.uploadservice.extensions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.UploadTask;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\n\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000b\u001a7\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u00002\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001b\"\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroid/content/Context;", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "params", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "notificationConfig", "", "startNewUpload", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadTaskParameters;Lnet/gotev/uploadservice/data/UploadNotificationConfig;)Ljava/lang/String;", "Landroid/content/Intent;", "Lnet/gotev/uploadservice/extensions/UploadTaskCreationParameters;", "getUploadTaskCreationParameters", "(Landroid/content/Intent;)Lnet/gotev/uploadservice/extensions/UploadTaskCreationParameters;", "creationParameters", "", "notificationId", "", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "observers", "Lnet/gotev/uploadservice/UploadTask;", "getUploadTask", "(Landroid/content/Context;Lnet/gotev/uploadservice/extensions/UploadTaskCreationParameters;I[Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;)Lnet/gotev/uploadservice/UploadTask;", "uploadId", "action", "Landroid/app/PendingIntent;", "getNotificationActionIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/app/PendingIntent;", "getCancelUploadIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/app/PendingIntent;", "getUploadIdToCancel", "(Landroid/content/Intent;)Ljava/lang/String;", "uploadIdToCancel", "uploadservice_release"}, k = 2, mv = {1, 4, 0})
public final class ContextExtensionsKt {

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<String> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
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
                return "Error while instantiating new task. Invalid intent received";
            }
            if (i == 1) {
                return "Error while instantiating new task. Missing notification config.";
            }
            if (i == 2) {
                return "Error while instantiating new task. Missing task parameters.";
            }
            throw null;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            int i = this.a;
            if (i == 0) {
                return "Error while instantiating new task. " + ((UploadTaskParameters) this.b).getTaskClass() + " does not extend UploadTask.";
            } else if (i == 1) {
                return "Error while instantiating new task. " + ((UploadTaskParameters) this.b).getTaskClass() + " does not exist.";
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function0<String> {
        public final /* synthetic */ Class a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Class cls) {
            super(0);
            this.a = cls;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            return a2.b.a.a.a.B2(this.a, a2.b.a.a.a.L("Successfully created new task with class: "));
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
            return "Error while instantiating new task";
        }
    }

    @NotNull
    public static final PendingIntent getCancelUploadIntent(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "$this$getCancelUploadIntent");
        Intrinsics.checkNotNullParameter(str, "uploadId");
        return getNotificationActionIntent(context, str, "cancelUpload");
    }

    @NotNull
    public static final PendingIntent getNotificationActionIntent(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "$this$getNotificationActionIntent");
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(str2, "action");
        Intent intent = new Intent(UploadServiceConfig.getBroadcastNotificationAction());
        intent.setPackage(UploadServiceConfig.getNamespace());
        intent.putExtra("action", str2);
        intent.putExtra("uploadId", str);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, str.hashCode(), intent, 1073741824);
        Intrinsics.checkNotNullExpressionValue(broadcast, "PendingIntent.getBroadca…ntent.FLAG_ONE_SHOT\n    )");
        return broadcast;
    }

    @Nullable
    public static final String getUploadIdToCancel(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$uploadIdToCancel");
        if (!Intrinsics.areEqual(intent.getStringExtra("action"), "cancelUpload")) {
            return null;
        }
        return intent.getStringExtra("uploadId");
    }

    @Nullable
    public static final UploadTask getUploadTask(@NotNull Context context, @NotNull UploadTaskCreationParameters uploadTaskCreationParameters, int i, @NotNull UploadTaskObserver... uploadTaskObserverArr) {
        Intrinsics.checkNotNullParameter(context, "$this$getUploadTask");
        Intrinsics.checkNotNullParameter(uploadTaskCreationParameters, "creationParameters");
        Intrinsics.checkNotNullParameter(uploadTaskObserverArr, "observers");
        try {
            Class<?> cls = Class.forName(uploadTaskCreationParameters.getParams().getTaskClass());
            Object newInstance = cls.newInstance();
            ((UploadTask) newInstance).init(context, uploadTaskCreationParameters.getParams(), uploadTaskCreationParameters.getNotificationConfig(), i, (UploadTaskObserver[]) Arrays.copyOf(uploadTaskObserverArr, uploadTaskObserverArr.length));
            UploadTask uploadTask = (UploadTask) newInstance;
            String tAG$uploadservice_release = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release, "UploadService.TAG");
            UploadServiceLogger.debug(tAG$uploadservice_release, UploadServiceLogger.NA, new c(cls));
            return uploadTask;
        } catch (Throwable th) {
            String tAG$uploadservice_release2 = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release2, "UploadService.TAG");
            UploadServiceLogger.error(tAG$uploadservice_release2, UploadServiceLogger.NA, th, d.a);
            return null;
        }
    }

    @Nullable
    public static final UploadTaskCreationParameters getUploadTaskCreationParameters(@Nullable Intent intent) {
        Class<?> cls;
        if (intent == null || (!Intrinsics.areEqual(intent.getAction(), UploadServiceConfig.getUploadAction()))) {
            String tAG$uploadservice_release = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release, "UploadService.TAG");
            UploadServiceLogger.error$default(tAG$uploadservice_release, UploadServiceLogger.NA, null, a.b, 4, null);
            return null;
        }
        UploadTaskParameters uploadTaskParameters = (UploadTaskParameters) intent.getParcelableExtra("taskParameters");
        if (uploadTaskParameters != null) {
            try {
                cls = Class.forName(uploadTaskParameters.getTaskClass());
            } catch (Throwable th) {
                String tAG$uploadservice_release2 = UploadService.Companion.getTAG$uploadservice_release();
                Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release2, "UploadService.TAG");
                UploadServiceLogger.error(tAG$uploadservice_release2, UploadServiceLogger.NA, th, new b(1, uploadTaskParameters));
                cls = null;
            }
            if (cls != null) {
                if (!UploadTask.class.isAssignableFrom(cls)) {
                    String tAG$uploadservice_release3 = UploadService.Companion.getTAG$uploadservice_release();
                    Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release3, "UploadService.TAG");
                    UploadServiceLogger.error$default(tAG$uploadservice_release3, UploadServiceLogger.NA, null, new b(0, uploadTaskParameters), 4, null);
                    return null;
                }
                UploadNotificationConfig uploadNotificationConfig = (UploadNotificationConfig) intent.getParcelableExtra("taskUploadConfig");
                if (uploadNotificationConfig != null) {
                    return new UploadTaskCreationParameters(uploadTaskParameters, uploadNotificationConfig);
                }
                String tAG$uploadservice_release4 = UploadService.Companion.getTAG$uploadservice_release();
                Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release4, "UploadService.TAG");
                UploadServiceLogger.error$default(tAG$uploadservice_release4, UploadServiceLogger.NA, null, a.c, 4, null);
            }
            return null;
        }
        String tAG$uploadservice_release5 = UploadService.Companion.getTAG$uploadservice_release();
        Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release5, "UploadService.TAG");
        UploadServiceLogger.error$default(tAG$uploadservice_release5, UploadServiceLogger.NA, null, a.d, 4, null);
        return null;
    }

    @NotNull
    public static final String startNewUpload(@NotNull Context context, @NotNull UploadTaskParameters uploadTaskParameters, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(context, "$this$startNewUpload");
        Intrinsics.checkNotNullParameter(uploadTaskParameters, "params");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        Intent intent = new Intent(context, UploadService.class);
        intent.setAction(UploadServiceConfig.getUploadAction());
        intent.putExtra("taskParameters", uploadTaskParameters);
        intent.putExtra("taskUploadConfig", uploadNotificationConfig);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
        return uploadTaskParameters.getId();
    }
}
