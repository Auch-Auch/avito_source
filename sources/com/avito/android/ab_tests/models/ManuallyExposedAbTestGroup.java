package com.avito.android.ab_tests.models;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.events.ExposureEventKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "T", "Lcom/avito/android/ab_tests/models/RemoteAbTest;", "", "expose", "()V", "", "getTestConfig", "()Ljava/lang/Object;", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", "feature", "", "getRemoteKey", "()Ljava/lang/String;", "remoteKey", "getTestGroup", "testGroup", "<init>", "(Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;Lcom/avito/android/analytics/Analytics;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class ManuallyExposedAbTestGroup<T> implements RemoteAbTest<T> {
    public final TestGroupWithClientExposure<T> a;
    public final Analytics b;

    public ManuallyExposedAbTestGroup(@NotNull TestGroupWithClientExposure<T> testGroupWithClientExposure, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(testGroupWithClientExposure, "feature");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = testGroupWithClientExposure;
        this.b = analytics;
    }

    public final void expose() {
        ExposureEventKt.exposeIfNeeded(this.a, this.b);
    }

    @Override // com.avito.android.ab_tests.models.RemoteAbTest
    @NotNull
    public String getRemoteKey() {
        return this.a.getRemoteKey();
    }

    @Nullable
    public final Object getTestConfig() {
        return this.a.getTestConfig();
    }

    @Override // com.avito.android.ab_tests.models.AbTestGroup
    public T getTestGroup() {
        return this.a.getTestGroup();
    }
}
