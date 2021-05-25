package com.avito.android.service.short_task.metrics;

import android.os.Build;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DataDiskUsage;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/service/short_task/metrics/DataDiskUsageMetricProvider;", "Lcom/avito/android/service/short_task/metrics/MetricProvider;", "Lio/reactivex/Observable;", "Lcom/avito/android/service/short_task/metrics/Metric;", "getMetricStream", "()Lio/reactivex/Observable;", "metricStream", "Lcom/avito/android/util/DataDiskUsage;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/DataDiskUsage;", "dataDiskUsage", "<init>", "(Lcom/avito/android/util/DataDiskUsage;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class DataDiskUsageMetricProvider implements MetricProvider {
    public final DataDiskUsage a;

    public DataDiskUsageMetricProvider(@NotNull DataDiskUsage dataDiskUsage) {
        Intrinsics.checkNotNullParameter(dataDiskUsage, "dataDiskUsage");
        this.a = dataDiskUsage;
    }

    @Override // com.avito.android.service.short_task.metrics.MetricProvider
    @NotNull
    public Observable<Metric> getMetricStream() {
        List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new Metric("disk_capacity", Long.valueOf(this.a.getTotalSpace())), new Metric("free_disk_space", Long.valueOf(this.a.getFreeSpace())), new Metric("android_data_size_total", Long.valueOf(this.a.getDataSize())), new Metric("android_data_size_cache", Long.valueOf(this.a.getCacheSize())), new Metric("android_data_size_code_cache", Long.valueOf(this.a.getCodeCacheSize())), new Metric("android_data_size_databases", Long.valueOf(this.a.getDatabasesSize())), new Metric("android_data_size_files", Long.valueOf(this.a.getFilesSize())), new Metric("android_data_size_lib", Long.valueOf(this.a.getLibSize())), new Metric("android_data_size_shared_prefs", Long.valueOf(this.a.getSharedPrefsSize())), new Metric("android_data_size_app_webview", Long.valueOf(this.a.getAppWebviewSize())), new Metric("android_data_size_no_backup", Long.valueOf(this.a.getNoBackupSize())));
        if (Build.VERSION.SDK_INT >= 26) {
            mutableListOf.add(new Metric("android_data_size_apk", Long.valueOf(this.a.apkSize())));
        }
        Observable<Metric> fromIterable = Observable.fromIterable(mutableListOf);
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Observable.fromIterable(metrics)");
        return fromIterable;
    }
}
