package com.avito.android.verification;

import android.content.Context;
import android.content.Intent;
import com.avito.android.VerificationIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.verification.verification_status.actions.VerificationActionActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/verification/VerificationIntentFactoryImpl;", "Lcom/avito/android/VerificationIntentFactory;", "Landroid/content/Intent;", "verificationsList", "()Landroid/content/Intent;", "", "type", "verificationStatus", "(Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/VerificationIntentFactory$VerificationAction;", "action", "verificationAction", "(Lcom/avito/android/VerificationIntentFactory$VerificationAction;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationIntentFactoryImpl implements VerificationIntentFactory {
    public final Context a;

    @Inject
    public VerificationIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.VerificationIntentFactory
    @NotNull
    public Intent verificationAction(@NotNull VerificationIntentFactory.VerificationAction verificationAction, @NotNull String str) {
        Intrinsics.checkNotNullParameter(verificationAction, "action");
        Intrinsics.checkNotNullParameter(str, "type");
        return VerificationActionActivity.Companion.createVerificationActionActivity(this.a, verificationAction, str);
    }

    @Override // com.avito.android.VerificationIntentFactory
    @NotNull
    public Intent verificationStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return VerificationActivity.Companion.createVerificationStatusActivity(this.a, str);
    }

    @Override // com.avito.android.VerificationIntentFactory
    @NotNull
    public Intent verificationsList() {
        return VerificationActivity.Companion.createVerificationsListActivity(this.a);
    }
}
