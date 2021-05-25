package com.avito.android.passport_verification;

import android.content.Context;
import android.content.Intent;
import com.avito.android.IdentityVerificationIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/passport_verification/IdentityVerificationIntentFactoryImpl;", "Lcom/avito/android/IdentityVerificationIntentFactory;", "", "urlForSdk", "flowName", "Landroid/content/Intent;", "passportVerificationIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
public final class IdentityVerificationIntentFactoryImpl implements IdentityVerificationIntentFactory {
    public final Context a;

    @Inject
    public IdentityVerificationIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.IdentityVerificationIntentFactory
    @NotNull
    public Intent passportVerificationIntent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "urlForSdk");
        Intrinsics.checkNotNullParameter(str2, "flowName");
        return SumsubVerificationActivity.Companion.createSumsubVerificationActivity(this.a, str, str2);
    }
}
