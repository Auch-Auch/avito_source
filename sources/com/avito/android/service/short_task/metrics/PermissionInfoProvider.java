package com.avito.android.service.short_task.metrics;

import a2.a.a.o2.a.c.a;
import a2.a.a.o2.a.c.b;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/service/short_task/metrics/PermissionInfoProvider;", "Lcom/avito/android/service/short_task/metrics/MetricProvider;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "c", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lio/reactivex/Observable;", "Lcom/avito/android/service/short_task/metrics/Metric;", "getMetricStream", "()Lio/reactivex/Observable;", "metricStream", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "permissionsKey", "Lcom/avito/android/permissions/PermissionChecker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/permissions/PermissionChecker;", "permissionHelper", "<init>", "(Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class PermissionInfoProvider implements MetricProvider {
    public final Map<String, String> a = r.mapOf(TuplesKt.to("camera_permission", "android.permission.CAMERA"), TuplesKt.to("location_permission", "android.permission.ACCESS_FINE_LOCATION"), TuplesKt.to("photo_library_permission", "android.permission.WRITE_EXTERNAL_STORAGE"));
    public final PermissionChecker b;
    public final NotificationManagerProvider c;

    @Inject
    public PermissionInfoProvider(@NotNull PermissionChecker permissionChecker, @NotNull NotificationManagerProvider notificationManagerProvider) {
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionHelper");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        this.b = permissionChecker;
        this.c = notificationManagerProvider;
    }

    public static final Metric access$getNotificationPermissionState(PermissionInfoProvider permissionInfoProvider) {
        return new Metric("push_notification_permission", Boolean.valueOf(permissionInfoProvider.c.getAreNotificationsEnabled()));
    }

    public static final List access$getRuntimePermissionsState(PermissionInfoProvider permissionInfoProvider) {
        Set<Map.Entry<String, String>> entrySet = permissionInfoProvider.a.entrySet();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(entrySet, 10));
        for (T t : entrySet) {
            arrayList.add(new Metric((String) t.getKey(), Boolean.valueOf(permissionInfoProvider.b.checkPermission((String) t.getValue()))));
        }
        return arrayList;
    }

    @Override // com.avito.android.service.short_task.metrics.MetricProvider
    @NotNull
    public Observable<Metric> getMetricStream() {
        Observable<Metric> flatMap = Observable.fromCallable(new a(this)).flatMap(b.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.fromCallable …le(metricsList)\n        }");
        return flatMap;
    }
}
