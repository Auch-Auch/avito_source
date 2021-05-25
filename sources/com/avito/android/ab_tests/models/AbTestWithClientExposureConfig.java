package com.avito.android.ab_tests.models;

import com.avito.android.Features;
import com.avito.android.ab_tests.models.RemoteNamingGroup;
import com.avito.android.remote.model.ab_tests.AbTest;
import com.avito.android.util.BuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u00050\u0003B\u0007¢\u0006\u0004\b!\u0010\"J?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H$¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00028\u0000H$¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/ab_tests/models/AbTestWithClientExposureConfig;", "Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "GROUP", "Lcom/avito/android/ab_tests/models/AbTestConfig;", "Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", "Lcom/avito/android/remote/model/ab_tests/AbTest;", "savedAbTest", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "", "testConfig", "", "remoteKey", "createAbTest", "(Lcom/avito/android/remote/model/ab_tests/AbTest;Lcom/avito/android/Features;Lcom/avito/android/util/BuildInfo;Ljava/lang/Object;Ljava/lang/String;)Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", "name", "getGroupByString", "(Ljava/lang/String;)Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "", "getGroups", "()[Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "", "isTestEnabled", "(Lcom/avito/android/Features;)Z", "getDebugOverrideDefaultGroup", "(Lcom/avito/android/Features;)Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "getReleaseDefaultGroup", "()Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "Ljava/lang/Class;", "getTestConfigClass", "()Ljava/lang/Class;", "<init>", "()V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbTestWithClientExposureConfig<GROUP extends RemoteNamingGroup> implements AbTestConfig<TestGroupWithClientExposure<GROUP>, AbTest> {
    @Nullable
    public abstract GROUP getDebugOverrideDefaultGroup(@NotNull Features features);

    @Nullable
    public final GROUP getGroupByString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        GROUP[] groups = getGroups();
        for (GROUP group : groups) {
            if (Intrinsics.areEqual(group.getRemoteName(), str)) {
                return group;
            }
        }
        return null;
    }

    @NotNull
    public abstract GROUP[] getGroups();

    @NotNull
    public abstract GROUP getReleaseDefaultGroup();

    @Nullable
    public Class<?> getTestConfigClass() {
        return null;
    }

    public abstract boolean isTestEnabled(@NotNull Features features);

    @NotNull
    public final TestGroupWithClientExposure<GROUP> createAbTest(@Nullable AbTest abTest, @NotNull Features features, @NotNull BuildInfo buildInfo, @Nullable Object obj, @NotNull String str) {
        GROUP group;
        GROUP groupByString;
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(str, "remoteKey");
        if (abTest != null && features.getEnableServerFeatureToggles().invoke().booleanValue() && isTestEnabled(features) && (groupByString = getGroupByString(abTest.getTestGroup())) != null) {
            return new TestGroupWithClientExposure<>(abTest.getAnalyticParams(), groupByString, obj, str);
        }
        if (!buildInfo.isDebug() || !isTestEnabled(features)) {
            group = getReleaseDefaultGroup();
        } else {
            group = getDebugOverrideDefaultGroup(features);
            if (group == null) {
                group = getReleaseDefaultGroup();
            }
        }
        return new TestGroupWithClientExposure<>(null, group, null, str);
    }
}
