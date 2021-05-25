package com.avito.android.code_confirmation;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aU\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "context", "", "login", "phone", "text", "", "codeTimeout", "", "codeLength", "src", "challengeId", "Landroid/content/Intent;", "createCodeConfirmationIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "code-confirmation_release"}, k = 2, mv = {1, 4, 2})
public final class CodeConfirmationActivityKt {
    @NotNull
    public static final Intent createCodeConfirmationIntent(@NotNull Context context, @NotNull String str, @Nullable String str2, @NotNull String str3, long j, int i, @NotNull String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(str4, "src");
        Intent putExtra = CodeConfirmationParamsKt.putLogin(new Intent(context, CodeConfirmationActivity.class), str).putExtra("text", str3).putExtra("timeout", j).putExtra("length", i).putExtra("src", str4).putExtra("challenge_id", str5).putExtra("phone_number", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…(KEY_PHONE_NUMBER, phone)");
        return putExtra;
    }

    public static /* synthetic */ Intent createCodeConfirmationIntent$default(Context context, String str, String str2, String str3, long j, int i, String str4, String str5, int i2, Object obj) {
        return createCodeConfirmationIntent(context, str, (i2 & 4) != 0 ? null : str2, str3, j, i, str4, (i2 & 128) != 0 ? null : str5);
    }
}
