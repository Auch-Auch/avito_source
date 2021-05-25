package com.avito.android.remote.model.ab_tests;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/ab_tests/AbTest;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;", "component2", "()Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;", "component3", "testGroup", "analyticParams", "testConfig", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;Ljava/lang/String;)Lcom/avito/android/remote/model/ab_tests/AbTest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTestGroup", "Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;", "getAnalyticParams", "getTestConfig", "setTestConfig", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/ab_tests/AnalyticsParams;Ljava/lang/String;)V", "config_release"}, k = 1, mv = {1, 4, 2})
public final class AbTest {
    @Nullable
    private final AnalyticsParams analyticParams;
    @Nullable
    private String testConfig;
    @NotNull
    private final String testGroup;

    public AbTest(@NotNull String str, @Nullable AnalyticsParams analyticsParams, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "testGroup");
        this.testGroup = str;
        this.analyticParams = analyticsParams;
        this.testConfig = str2;
    }

    public static /* synthetic */ AbTest copy$default(AbTest abTest, String str, AnalyticsParams analyticsParams, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = abTest.testGroup;
        }
        if ((i & 2) != 0) {
            analyticsParams = abTest.analyticParams;
        }
        if ((i & 4) != 0) {
            str2 = abTest.testConfig;
        }
        return abTest.copy(str, analyticsParams, str2);
    }

    @NotNull
    public final String component1() {
        return this.testGroup;
    }

    @Nullable
    public final AnalyticsParams component2() {
        return this.analyticParams;
    }

    @Nullable
    public final String component3() {
        return this.testConfig;
    }

    @NotNull
    public final AbTest copy(@NotNull String str, @Nullable AnalyticsParams analyticsParams, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "testGroup");
        return new AbTest(str, analyticsParams, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbTest)) {
            return false;
        }
        AbTest abTest = (AbTest) obj;
        return Intrinsics.areEqual(this.testGroup, abTest.testGroup) && Intrinsics.areEqual(this.analyticParams, abTest.analyticParams) && Intrinsics.areEqual(this.testConfig, abTest.testConfig);
    }

    @Nullable
    public final AnalyticsParams getAnalyticParams() {
        return this.analyticParams;
    }

    @Nullable
    public final String getTestConfig() {
        return this.testConfig;
    }

    @NotNull
    public final String getTestGroup() {
        return this.testGroup;
    }

    public int hashCode() {
        String str = this.testGroup;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AnalyticsParams analyticsParams = this.analyticParams;
        int hashCode2 = (hashCode + (analyticsParams != null ? analyticsParams.hashCode() : 0)) * 31;
        String str2 = this.testConfig;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setTestConfig(@Nullable String str) {
        this.testConfig = str;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AbTest(testGroup=");
        L.append(this.testGroup);
        L.append(", analyticParams=");
        L.append(this.analyticParams);
        L.append(", testConfig=");
        return a.t(L, this.testConfig, ")");
    }
}
