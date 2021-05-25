package com.avito.android.certificate_pinning;

import android.app.Activity;
import android.content.Intent;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.app.ActivityProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/certificate_pinning/CertificatePinningErrorRouterImpl;", "Lcom/avito/android/certificate_pinning/CertificatePinningErrorRouter;", "", "openCertificateExpiredScreen", "()V", "openCertificateSpoofingScreen", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/app/ActivityProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/app/ActivityProvider;", "activityProvider", "<init>", "(Lcom/avito/android/app/ActivityProvider;Lcom/avito/android/ActivityIntentFactory;)V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public final class CertificatePinningErrorRouterImpl implements CertificatePinningErrorRouter {
    public final ActivityProvider a;
    @NotNull
    public final ActivityIntentFactory b;

    public CertificatePinningErrorRouterImpl(@NotNull ActivityProvider activityProvider, @NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "intentFactory");
        this.a = activityProvider;
        this.b = activityIntentFactory;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        return this.b;
    }

    @Override // com.avito.android.certificate_pinning.CertificatePinningErrorRouter
    public void openCertificateExpiredScreen() {
        Intent addFlags = this.b.updateApplicationIntent().addFlags(268468224);
        Intrinsics.checkNotNullExpressionValue(addFlags, "intentFactory\n          …t.FLAG_ACTIVITY_NEW_TASK)");
        Activity activity = this.a.get();
        if (activity != null) {
            activity.startActivity(addFlags);
            activity.finish();
        }
    }

    @Override // com.avito.android.certificate_pinning.CertificatePinningErrorRouter
    public void openCertificateSpoofingScreen() {
        Intent certificateUnsafeNetworkWarningIntent = this.b.certificateUnsafeNetworkWarningIntent();
        Activity activity = this.a.get();
        if (activity != null) {
            activity.startActivity(certificateUnsafeNetworkWarningIntent);
        }
    }
}
