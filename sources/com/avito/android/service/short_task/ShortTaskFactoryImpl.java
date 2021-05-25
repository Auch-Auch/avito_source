package com.avito.android.service.short_task;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.statsd.SendStatsdEventsTask;
import com.avito.android.analytics.provider.statsd.SendStatsdEventsTaskKt;
import com.avito.android.service.short_task.app_update.AppUpdateTask;
import com.avito.android.service.short_task.app_update.AppUpdateTaskKt;
import com.avito.android.service.short_task.clickstream.SendClickStreamEventsTask;
import com.avito.android.service.short_task.clickstream.SendClickStreamEventsTaskKt;
import com.avito.android.service.short_task.metrics.SendDataSizeTask;
import com.avito.android.service.short_task.metrics.SendDataSizeTaskKt;
import com.avito.android.service.short_task.metrics.SendMetricTask;
import com.avito.android.service.short_task.metrics.SendMetricTaskKt;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/service/short_task/ShortTaskFactoryImpl;", "Lcom/avito/android/service/short_task/ShortTaskFactory;", "", "tag", "Lcom/avito/android/service/short_task/ShortTask;", "createTask", "(Ljava/lang/String;)Lcom/avito/android/service/short_task/ShortTask;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class ShortTaskFactoryImpl implements ShortTaskFactory {
    @Override // com.avito.android.service.short_task.ShortTaskFactory
    @Nullable
    public ShortTask createTask(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        switch (str.hashCode()) {
            case -1718230145:
                if (str.equals(SendDataSizeTaskKt.SEND_DATA_SIZE_TASK)) {
                    return new SendDataSizeTask();
                }
                break;
            case -1707755628:
                if (str.equals(FingerprintCalculationTaskKt.FINGERPRINT_CALC_TASK_TAG)) {
                    return new FingerprintCalculationTask();
                }
                break;
            case -1076613364:
                if (str.equals(TimeRequestTaskKt.CHECK_REQUEST_TASK)) {
                    return new TimeRequestTask();
                }
                break;
            case -623235316:
                if (str.equals(SendMetricTaskKt.SEND_METRICS_TASK)) {
                    return new SendMetricTask();
                }
                break;
            case -281249251:
                if (str.equals(AppUpdateTaskKt.APP_UPDATE_TASK_TAG)) {
                    return new AppUpdateTask();
                }
                break;
            case 951250556:
                if (str.equals(SendStatsdEventsTaskKt.SEND_STATSD_EVENTS_TASK)) {
                    return new SendStatsdEventsTask();
                }
                break;
            case 1568846090:
                if (str.equals(SendClickStreamEventsTaskKt.SEND_CLICK_STREAM_EVENTS_TASK)) {
                    return new SendClickStreamEventsTask();
                }
                break;
        }
        Logs.error(new IllegalArgumentException(a.c3("ShortTaskFactoryImpl: no task for tag ", str)));
        return null;
    }
}
