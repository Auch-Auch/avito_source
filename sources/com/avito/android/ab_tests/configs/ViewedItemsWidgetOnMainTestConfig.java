package com.avito.android.ab_tests.configs;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.ViewedItemsWidgetOnMainTestGroup;
import com.avito.android.ab_tests.models.AbTestConfig;
import com.avito.android.ab_tests.models.AbTestWithClientExposureConfig;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/ab_tests/configs/ViewedItemsWidgetOnMainTestConfig;", "Lcom/avito/android/ab_tests/models/AbTestWithClientExposureConfig;", "Lcom/avito/android/ab_tests/groups/ViewedItemsWidgetOnMainTestGroup;", "", "getGroups", "()[Lcom/avito/android/ab_tests/groups/ViewedItemsWidgetOnMainTestGroup;", "Lcom/avito/android/Features;", "features", "", "isTestEnabled", "(Lcom/avito/android/Features;)Z", "getDebugOverrideDefaultGroup", "(Lcom/avito/android/Features;)Lcom/avito/android/ab_tests/groups/ViewedItemsWidgetOnMainTestGroup;", "getReleaseDefaultGroup", "()Lcom/avito/android/ab_tests/groups/ViewedItemsWidgetOnMainTestGroup;", "Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", "getOwner", "()Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", UrlParams.OWNER, "c", "Z", "getConsistentWithinSession", "()Z", "consistentWithinSession", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRemoteKey", "()Ljava/lang/String;", "remoteKey", "<init>", "()V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedItemsWidgetOnMainTestConfig extends AbTestWithClientExposureConfig<ViewedItemsWidgetOnMainTestGroup> {
    @NotNull
    public final String a = "seen_items_widget_on_main";
    @NotNull
    public final AbTestConfig.OwnerUnit b = AbTestConfig.OwnerUnit.BUYER_X;
    public final boolean c = true;

    @Override // com.avito.android.ab_tests.models.AbTestConfig
    public boolean getConsistentWithinSession() {
        return this.c;
    }

    @Override // com.avito.android.ab_tests.models.AbTestConfig
    @NotNull
    public AbTestConfig.OwnerUnit getOwner() {
        return this.b;
    }

    @Override // com.avito.android.ab_tests.models.AbTestConfig
    @NotNull
    public String getRemoteKey() {
        return this.a;
    }

    @Override // com.avito.android.ab_tests.models.AbTestWithClientExposureConfig
    public boolean isTestEnabled(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return features.getViewedItemsWidgetOnMain().invoke().booleanValue();
    }

    @Override // com.avito.android.ab_tests.models.AbTestWithClientExposureConfig
    @Nullable
    public ViewedItemsWidgetOnMainTestGroup getDebugOverrideDefaultGroup(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return (ViewedItemsWidgetOnMainTestGroup) getGroupByString(features.getViewedItemsWidgetOnMainMode().invoke().getSelectedOption());
    }

    @Override // com.avito.android.ab_tests.models.AbTestWithClientExposureConfig
    @NotNull
    public ViewedItemsWidgetOnMainTestGroup[] getGroups() {
        return ViewedItemsWidgetOnMainTestGroup.values();
    }

    @Override // com.avito.android.ab_tests.models.AbTestWithClientExposureConfig
    @NotNull
    public ViewedItemsWidgetOnMainTestGroup getReleaseDefaultGroup() {
        return ViewedItemsWidgetOnMainTestGroup.NONE;
    }
}
