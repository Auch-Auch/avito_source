package com.avito.android.analytics.provider.clickstream;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.service.short_task.clickstream.SendClickStreamEventsTask;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/ClickStreamPendingFlushInteractor;", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "", "flush", "()V", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", AuthSource.SEND_ABUSE, "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "scheduler", "<init>", "(Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class ClickStreamPendingFlushInteractor implements InHouseAnalyticsFlushInteractor {
    public final ShortTaskExactScheduler a;

    @Inject
    public ClickStreamPendingFlushInteractor(@NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "scheduler");
        this.a = shortTaskExactScheduler;
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor
    public void flush() {
        ShortTaskExactScheduler.DefaultImpls.schedule$default(this.a, new SendClickStreamEventsTask(), new LongRange(1, 90000), true, null, 8, null);
    }
}
