package net.gotev.uploadservice.observer.task;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.android.parcel.Parcelize;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadNotificationStatusConfig;
import net.gotev.uploadservice.exceptions.UserCancelledUploadException;
import net.gotev.uploadservice.extensions.NotificationManagerExtensionsKt;
import net.gotev.uploadservice.network.ServerResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.ok.android.sdk.OkListener;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u000245B\u000f\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b2\u00103J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J/\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\u0017J'\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'R\u001d\u0010\b\u001a\u00020\u00078B@\u0002X\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u00101¨\u00066"}, d2 = {"Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler;", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "", "uploadId", "", "removeTask", "(Ljava/lang/String;)V", "Landroid/app/NotificationManager;", "notificationManager", "Landroidx/core/app/NotificationCompat$Builder;", "notificationBuilder", "", "Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskData;", "tasks", "updateNotification", "(Landroid/app/NotificationManager;Landroidx/core/app/NotificationCompat$Builder;Ljava/util/Map;)Landroidx/core/app/NotificationCompat$Builder;", "Lnet/gotev/uploadservice/data/UploadInfo;", "info", "", "notificationId", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "notificationConfig", "onStart", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;)V", "onProgress", "Lnet/gotev/uploadservice/network/ServerResponse;", CommonKt.EXTRA_RESPONSE, "onSuccess", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;Lnet/gotev/uploadservice/network/ServerResponse;)V", "", OkListener.KEY_EXCEPTION, "onError", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;Ljava/lang/Throwable;)V", "onCompleted", "Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "status", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", Navigation.CONFIG, AuthSource.SEND_ABUSE, "(Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;)V", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getNotificationManager", "()Landroid/app/NotificationManager;", "Lnet/gotev/uploadservice/UploadService;", "c", "Lnet/gotev/uploadservice/UploadService;", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "(Lnet/gotev/uploadservice/UploadService;)V", "TaskData", "TaskStatus", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public abstract class AbstractSingleNotificationHandler implements UploadTaskObserver {
    public final ConcurrentHashMap<String, TaskData> a = new ConcurrentHashMap<>();
    public final Lazy b;
    public final UploadService c;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskData;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "component1", "()Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "Lnet/gotev/uploadservice/data/UploadInfo;", "component2", "()Lnet/gotev/uploadservice/data/UploadInfo;", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "component3", "()Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "status", "info", Navigation.CONFIG, "copy", "(Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;)Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "getConfig", AuthSource.SEND_ABUSE, "Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "getStatus", AuthSource.BOOKING_ORDER, "Lnet/gotev/uploadservice/data/UploadInfo;", "getInfo", "<init>", "(Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class TaskData implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Creator();
        @NotNull
        public final TaskStatus a;
        @NotNull
        public final UploadInfo b;
        @NotNull
        public final UploadNotificationStatusConfig c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
        public static class Creator implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new TaskData((TaskStatus) Enum.valueOf(TaskStatus.class, parcel.readString()), (UploadInfo) UploadInfo.CREATOR.createFromParcel(parcel), (UploadNotificationStatusConfig) UploadNotificationStatusConfig.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Object[] newArray(int i) {
                return new TaskData[i];
            }
        }

        public TaskData(@NotNull TaskStatus taskStatus, @NotNull UploadInfo uploadInfo, @NotNull UploadNotificationStatusConfig uploadNotificationStatusConfig) {
            Intrinsics.checkNotNullParameter(taskStatus, "status");
            Intrinsics.checkNotNullParameter(uploadInfo, "info");
            Intrinsics.checkNotNullParameter(uploadNotificationStatusConfig, Navigation.CONFIG);
            this.a = taskStatus;
            this.b = uploadInfo;
            this.c = uploadNotificationStatusConfig;
        }

        public static /* synthetic */ TaskData copy$default(TaskData taskData, TaskStatus taskStatus, UploadInfo uploadInfo, UploadNotificationStatusConfig uploadNotificationStatusConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                taskStatus = taskData.a;
            }
            if ((i & 2) != 0) {
                uploadInfo = taskData.b;
            }
            if ((i & 4) != 0) {
                uploadNotificationStatusConfig = taskData.c;
            }
            return taskData.copy(taskStatus, uploadInfo, uploadNotificationStatusConfig);
        }

        @NotNull
        public final TaskStatus component1() {
            return this.a;
        }

        @NotNull
        public final UploadInfo component2() {
            return this.b;
        }

        @NotNull
        public final UploadNotificationStatusConfig component3() {
            return this.c;
        }

        @NotNull
        public final TaskData copy(@NotNull TaskStatus taskStatus, @NotNull UploadInfo uploadInfo, @NotNull UploadNotificationStatusConfig uploadNotificationStatusConfig) {
            Intrinsics.checkNotNullParameter(taskStatus, "status");
            Intrinsics.checkNotNullParameter(uploadInfo, "info");
            Intrinsics.checkNotNullParameter(uploadNotificationStatusConfig, Navigation.CONFIG);
            return new TaskData(taskStatus, uploadInfo, uploadNotificationStatusConfig);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskData)) {
                return false;
            }
            TaskData taskData = (TaskData) obj;
            return Intrinsics.areEqual(this.a, taskData.a) && Intrinsics.areEqual(this.b, taskData.b) && Intrinsics.areEqual(this.c, taskData.c);
        }

        @NotNull
        public final UploadNotificationStatusConfig getConfig() {
            return this.c;
        }

        @NotNull
        public final UploadInfo getInfo() {
            return this.b;
        }

        @NotNull
        public final TaskStatus getStatus() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            TaskStatus taskStatus = this.a;
            int i = 0;
            int hashCode = (taskStatus != null ? taskStatus.hashCode() : 0) * 31;
            UploadInfo uploadInfo = this.b;
            int hashCode2 = (hashCode + (uploadInfo != null ? uploadInfo.hashCode() : 0)) * 31;
            UploadNotificationStatusConfig uploadNotificationStatusConfig = this.c;
            if (uploadNotificationStatusConfig != null) {
                i = uploadNotificationStatusConfig.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("TaskData(status=");
            L.append(this.a);
            L.append(", info=");
            L.append(this.b);
            L.append(", config=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a.name());
            this.b.writeToParcel(parcel, 0);
            this.c.writeToParcel(parcel, 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "InProgress", "Succeeded", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED, "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public enum TaskStatus {
        InProgress,
        Succeeded,
        Failed,
        Cancelled
    }

    public static final class a extends Lambda implements Function0<NotificationManager> {
        public final /* synthetic */ AbstractSingleNotificationHandler a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AbstractSingleNotificationHandler abstractSingleNotificationHandler) {
            super(0);
            this.a = abstractSingleNotificationHandler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public NotificationManager invoke() {
            Object systemService = this.a.c.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService;
        }
    }

    public AbstractSingleNotificationHandler(@NotNull UploadService uploadService) {
        Intrinsics.checkNotNullParameter(uploadService, NotificationCompat.CATEGORY_SERVICE);
        this.c = uploadService;
        Lazy lazy = c.lazy(new a(this));
        this.b = lazy;
        String defaultNotificationChannel = UploadServiceConfig.getDefaultNotificationChannel();
        Intrinsics.checkNotNull(defaultNotificationChannel);
        NotificationManagerExtensionsKt.validateNotificationChannel((NotificationManager) lazy.getValue(), defaultNotificationChannel);
    }

    public final synchronized void a(TaskStatus taskStatus, UploadInfo uploadInfo, UploadNotificationStatusConfig uploadNotificationStatusConfig) {
        NotificationCompat.Builder group;
        NotificationCompat.Builder ongoing;
        Notification build;
        this.a.put(uploadInfo.getUploadId(), new TaskData(taskStatus, uploadInfo, uploadNotificationStatusConfig));
        UploadService uploadService = this.c;
        String defaultNotificationChannel = UploadServiceConfig.getDefaultNotificationChannel();
        Intrinsics.checkNotNull(defaultNotificationChannel);
        NotificationCompat.Builder updateNotification = updateNotification((NotificationManager) this.b.getValue(), new NotificationCompat.Builder(uploadService, defaultNotificationChannel), new HashMap(this.a));
        if (updateNotification != null && (group = updateNotification.setGroup(UploadServiceConfig.getNamespace())) != null && (ongoing = group.setOngoing(true)) != null && (build = ongoing.build()) != null) {
            UploadService uploadService2 = this.c;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
            uploadService2.holdForegroundNotification(name, build);
        }
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onCompleted(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onError(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(th, OkListener.KEY_EXCEPTION);
        if (th instanceof UserCancelledUploadException) {
            a(TaskStatus.Cancelled, uploadInfo, uploadNotificationConfig.getCancelled());
        } else {
            a(TaskStatus.Failed, uploadInfo, uploadNotificationConfig.getCancelled());
        }
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onProgress(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        a(TaskStatus.InProgress, uploadInfo, uploadNotificationConfig.getProgress());
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onStart(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        a(TaskStatus.InProgress, uploadInfo, uploadNotificationConfig.getProgress());
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onSuccess(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig, @NotNull ServerResponse serverResponse) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(serverResponse, CommonKt.EXTRA_RESPONSE);
        a(TaskStatus.Succeeded, uploadInfo, uploadNotificationConfig.getSuccess());
    }

    public final void removeTask(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        this.a.remove(str);
    }

    @Nullable
    public abstract NotificationCompat.Builder updateNotification(@NotNull NotificationManager notificationManager, @NotNull NotificationCompat.Builder builder, @NotNull Map<String, TaskData> map);
}
