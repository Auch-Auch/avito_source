package a2.a.a.o2.a.c;

import com.avito.android.service.short_task.metrics.Metric;
import com.avito.android.service.short_task.metrics.PermissionInfoProvider;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt___CollectionsKt;
public final class a<V> implements Callable<List<? extends Metric>> {
    public final /* synthetic */ PermissionInfoProvider a;

    public a(PermissionInfoProvider permissionInfoProvider) {
        this.a = permissionInfoProvider;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<? extends Metric> call() {
        return CollectionsKt___CollectionsKt.plus((Collection<? extends Metric>) PermissionInfoProvider.access$getRuntimePermissionsState(this.a), PermissionInfoProvider.access$getNotificationPermissionState(this.a));
    }
}
