package com.avito.android.publish.drafts.analytics;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGeneratorImpl;", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "", "reCreatePublishSessionId", "()Ljava/lang/String;", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorage", "Lcom/avito/android/server_time/TimeSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/remote/DeviceIdProvider;", "c", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/remote/DeviceIdProvider;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishSessionIdGeneratorImpl implements PublishSessionIdGenerator {
    public final TimeSource a;
    public final AccountStorageInteractor b;
    public final DeviceIdProvider c;

    public PublishSessionIdGeneratorImpl(@NotNull TimeSource timeSource, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull DeviceIdProvider deviceIdProvider) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorage");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        this.a = timeSource;
        this.b = accountStorageInteractor;
        this.c = deviceIdProvider;
    }

    @Override // com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator
    @NotNull
    public String reCreatePublishSessionId() {
        String userId = this.b.toBlocking().getUserId();
        if (userId == null) {
            userId = this.c.getValue();
        }
        long now = this.a.now();
        return userId + "_Android_" + now;
    }
}
