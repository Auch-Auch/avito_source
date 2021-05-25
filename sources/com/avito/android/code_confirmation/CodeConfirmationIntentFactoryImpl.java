package com.avito.android.code_confirmation;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.CodeConfirmationIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ?\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\rR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/code_confirmation/CodeConfirmationIntentFactoryImpl;", "Lcom/avito/android/CodeConfirmationIntentFactory;", "", "login", "phone", "text", "", "codeTimeout", "", "codeLength", "src", "Landroid/content/Intent;", "codeConfirmationIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;)Landroid/content/Intent;", "challengeId", "phoneAntihackCodeConfirmationIntent", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeConfirmationIntentFactoryImpl implements CodeConfirmationIntentFactory {
    public final Context a;

    @Inject
    public CodeConfirmationIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.CodeConfirmationIntentFactory
    @NotNull
    public Intent codeConfirmationIntent(@NotNull String str, @Nullable String str2, @NotNull String str3, long j, int i, @NotNull String str4) {
        a.Z0(str, "login", str3, "text", str4, "src");
        return CodeConfirmationActivityKt.createCodeConfirmationIntent$default(this.a, str, str2, str3, j, i, str4, null, 128, null);
    }

    @Override // com.avito.android.CodeConfirmationIntentFactory
    @NotNull
    public Intent phoneAntihackCodeConfirmationIntent(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i, @NotNull String str4) {
        a.b1(str, "challengeId", str2, "login", str3, "text", str4, "src");
        return CodeConfirmationActivityKt.createCodeConfirmationIntent$default(this.a, str2, null, str3, j, i, str4, str, 4, null);
    }
}
