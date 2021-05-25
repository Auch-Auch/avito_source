package com.avito.android.ab_tests.models;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.events.ExposureEventKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "T", "Lcom/avito/android/ab_tests/models/RemoteAbTest;", "", "exposeIfNeeded", "()V", "", AuthSource.SEND_ABUSE, "Z", "wasExposed", "Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", "feature", "getTestGroup", "()Ljava/lang/Object;", "testGroup", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "getRemoteKey", "()Ljava/lang/String;", "remoteKey", "<init>", "(Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;Lcom/avito/android/analytics/Analytics;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class SingleManuallyExposedAbTestGroup<T> implements RemoteAbTest<T> {
    public boolean a;
    public final TestGroupWithClientExposure<T> b;
    public final Analytics c;

    public SingleManuallyExposedAbTestGroup(@NotNull TestGroupWithClientExposure<T> testGroupWithClientExposure, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(testGroupWithClientExposure, "feature");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = testGroupWithClientExposure;
        this.c = analytics;
    }

    public final void exposeIfNeeded() {
        if (!this.a) {
            ExposureEventKt.exposeIfNeeded(this.b, this.c);
            this.a = true;
        }
    }

    @Override // com.avito.android.ab_tests.models.RemoteAbTest
    @NotNull
    public String getRemoteKey() {
        return this.b.getRemoteKey();
    }

    @Override // com.avito.android.ab_tests.models.AbTestGroup
    public T getTestGroup() {
        return this.b.getTestGroup();
    }
}
