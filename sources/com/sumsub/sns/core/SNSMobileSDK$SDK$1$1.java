package com.sumsub.sns.core;

import a2.b.a.a.a;
import android.content.Intent;
import com.google.android.gms.security.ProviderInstaller;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$SDK$1$1", "Lcom/google/android/gms/security/ProviderInstaller$ProviderInstallListener;", "", CommonKt.TAG_ERROR_CODE, "Landroid/content/Intent;", "resolveIntent", "", "onProviderInstallFailed", "(ILandroid/content/Intent;)V", "onProviderInstalled", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSMobileSDK$SDK$1$1 implements ProviderInstaller.ProviderInstallListener {
    @Override // com.google.android.gms.security.ProviderInstaller.ProviderInstallListener
    public void onProviderInstallFailed(int i, @Nullable Intent intent) {
        Timber.d(a.M2("onProviderInstallFailed: ", i), new Object[0]);
    }

    @Override // com.google.android.gms.security.ProviderInstaller.ProviderInstallListener
    public void onProviderInstalled() {
        Timber.d("onProviderInstalled", new Object[0]);
    }
}
