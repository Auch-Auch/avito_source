package com.avito.android.ab_tests.configs;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.AbTestConfig;
import com.avito.android.ab_tests.models.AbTestWithClientExposureConfig;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/ab_tests/configs/AutoGenerationsFilterWithPhotosTestConfig;", "Lcom/avito/android/ab_tests/models/AbTestWithClientExposureConfig;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "", "getGroups", "()[Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "Lcom/avito/android/Features;", "features", "", "isTestEnabled", "(Lcom/avito/android/Features;)Z", "getDebugOverrideDefaultGroup", "(Lcom/avito/android/Features;)Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "getReleaseDefaultGroup", "()Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", AuthSource.BOOKING_ORDER, "Z", "getConsistentWithinSession", "()Z", "consistentWithinSession", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRemoteKey", "()Ljava/lang/String;", "remoteKey", "Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", "c", "Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", "getOwner", "()Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", UrlParams.OWNER, "<init>", "()V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class AutoGenerationsFilterWithPhotosTestConfig extends AbTestWithClientExposureConfig<SimpleTestGroup> {
    @NotNull
    public final String a = "android_auto_photo_generation";
    public final boolean b = true;
    @NotNull
    public final AbTestConfig.OwnerUnit c = AbTestConfig.OwnerUnit.AUTO;

    @Override // com.avito.android.ab_tests.models.AbTestConfig
    public boolean getConsistentWithinSession() {
        return this.b;
    }

    @Override // com.avito.android.ab_tests.models.AbTestConfig
    @NotNull
    public AbTestConfig.OwnerUnit getOwner() {
        return this.c;
    }

    @Override // com.avito.android.ab_tests.models.AbTestConfig
    @NotNull
    public String getRemoteKey() {
        return this.a;
    }

    @Override // com.avito.android.ab_tests.models.AbTestWithClientExposureConfig
    public boolean isTestEnabled(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return features.getImageSelectInFiltersMvp3().invoke().booleanValue();
    }

    @Override // com.avito.android.ab_tests.models.AbTestWithClientExposureConfig
    @Nullable
    public SimpleTestGroup getDebugOverrideDefaultGroup(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return (SimpleTestGroup) getGroupByString(features.getAutoFilterGenerationsWithPhotosGroup().getValue().getSelectedOption());
    }

    @Override // com.avito.android.ab_tests.models.AbTestWithClientExposureConfig
    @NotNull
    public SimpleTestGroup[] getGroups() {
        return SimpleTestGroup.values();
    }

    @Override // com.avito.android.ab_tests.models.AbTestWithClientExposureConfig
    @NotNull
    public SimpleTestGroup getReleaseDefaultGroup() {
        return SimpleTestGroup.CONTROL;
    }
}
