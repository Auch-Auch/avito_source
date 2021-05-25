package com.avito.android.version_conflict;

import android.content.Context;
import android.content.Intent;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/version_conflict/ConfigUpdatedRouterImpl;", "Lcom/avito/android/version_conflict/ConfigUpdatedRouter;", "", "openUpdateProposalScreen", "()V", "openUpdateRequiredScreen", "openUpgradeWithDeviceWarningScreen", "openDeviceNotSupportedScreen", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "applicationContext", "<init>", "(Landroid/content/Context;Lcom/avito/android/ActivityIntentFactory;)V", "version-conflict_release"}, k = 1, mv = {1, 4, 2})
public final class ConfigUpdatedRouterImpl implements ConfigUpdatedRouter {
    public final Context a;
    public final ActivityIntentFactory b;

    public ConfigUpdatedRouterImpl(@NotNull Context context, @NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        this.a = context;
        this.b = activityIntentFactory;
    }

    @Override // com.avito.android.version_conflict.ConfigUpdatedRouter
    public void openDeviceNotSupportedScreen() {
        Intent resolveAppVersionConflictActivity = this.b.resolveAppVersionConflictActivity(4);
        resolveAppVersionConflictActivity.addFlags(268435456);
        this.a.startActivity(resolveAppVersionConflictActivity);
    }

    @Override // com.avito.android.version_conflict.ConfigUpdatedRouter
    public void openUpdateProposalScreen() {
        Intent resolveAppVersionConflictActivity = this.b.resolveAppVersionConflictActivity(1);
        resolveAppVersionConflictActivity.addFlags(268435456);
        this.a.startActivity(resolveAppVersionConflictActivity);
    }

    @Override // com.avito.android.version_conflict.ConfigUpdatedRouter
    public void openUpdateRequiredScreen() {
        Intent resolveAppVersionConflictActivity = this.b.resolveAppVersionConflictActivity(2);
        resolveAppVersionConflictActivity.addFlags(268435456);
        this.a.startActivity(resolveAppVersionConflictActivity);
    }

    @Override // com.avito.android.version_conflict.ConfigUpdatedRouter
    public void openUpgradeWithDeviceWarningScreen() {
        Intent resolveAppVersionConflictActivity = this.b.resolveAppVersionConflictActivity(3);
        resolveAppVersionConflictActivity.addFlags(268435456);
        this.a.startActivity(resolveAppVersionConflictActivity);
    }
}
