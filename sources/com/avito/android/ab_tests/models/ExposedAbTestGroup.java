package com.avito.android.ab_tests.models;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.events.ExposureEventKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "T", "Lcom/avito/android/ab_tests/models/RemoteAbTest;", "", AuthSource.SEND_ABUSE, "Z", "wasExposed", "Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", "feature", "", "getRemoteKey", "()Ljava/lang/String;", "remoteKey", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "getTestGroup", "()Ljava/lang/Object;", "testGroup", "<init>", "(Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;Lcom/avito/android/analytics/Analytics;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class ExposedAbTestGroup<T> implements RemoteAbTest<T> {
    public boolean a;
    public final TestGroupWithClientExposure<T> b;
    public final Analytics c;

    public ExposedAbTestGroup(@NotNull TestGroupWithClientExposure<T> testGroupWithClientExposure, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(testGroupWithClientExposure, "feature");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = testGroupWithClientExposure;
        this.c = analytics;
    }

    @Override // com.avito.android.ab_tests.models.RemoteAbTest
    @NotNull
    public String getRemoteKey() {
        return this.b.getRemoteKey();
    }

    @Override // com.avito.android.ab_tests.models.AbTestGroup
    public T getTestGroup() {
        if (!this.a) {
            ExposureEventKt.exposeIfNeeded(this.b, this.c);
            this.a = true;
        }
        return this.b.getTestGroup();
    }
}
