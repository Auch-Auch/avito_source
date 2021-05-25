package com.avito.android.ab_tests.models;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ab_tests.AnalyticsParams;
import com.avito.android.remote.model.ab_tests.WithClientExposure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B/\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\u00028\u00008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u001c\u0010\u0018\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", "T", "Lcom/avito/android/ab_tests/models/RemoteAbTest;", "Lcom/avito/android/remote/model/ab_tests/WithClientExposure;", "", "c", "Ljava/lang/Object;", "getTestConfig", "()Ljava/lang/Object;", "testConfig", "Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;", "getAnalyticParams", "()Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;", "analyticParams", AuthSource.BOOKING_ORDER, "getTestGroup", "testGroup", "", "d", "Ljava/lang/String;", "getRemoteKey", "()Ljava/lang/String;", "remoteKey", "<init>", "(Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class TestGroupWithClientExposure<T> implements RemoteAbTest<T>, WithClientExposure {
    @Nullable
    public final AnalyticsParams a;
    public final T b;
    @Nullable
    public final Object c;
    @NotNull
    public final String d;

    public TestGroupWithClientExposure(@Nullable AnalyticsParams analyticsParams, T t, @Nullable Object obj, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "remoteKey");
        this.a = analyticsParams;
        this.b = t;
        this.c = obj;
        this.d = str;
    }

    @Override // com.avito.android.remote.model.ab_tests.WithClientExposure
    @Nullable
    public AnalyticsParams getAnalyticParams() {
        return this.a;
    }

    @Override // com.avito.android.ab_tests.models.RemoteAbTest
    @NotNull
    public String getRemoteKey() {
        return this.d;
    }

    @Nullable
    public final Object getTestConfig() {
        return this.c;
    }

    @Override // com.avito.android.ab_tests.models.AbTestGroup
    public T getTestGroup() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TestGroupWithClientExposure(AnalyticsParams analyticsParams, Object obj, Object obj2, String str, int i, j jVar) {
        this(analyticsParams, obj, (i & 4) != 0 ? null : obj2, (i & 8) != 0 ? "" : str);
    }
}
