package com.avito.android.code_confirmation.phone_confirm;

import android.content.res.Resources;
import com.avito.android.code_confirmation.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCodeConfirmError", "()Ljava/lang/String;", "codeConfirmError", AuthSource.SEND_ABUSE, "getPhoneAlreadyAddedError", "phoneAlreadyAddedError", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    public PhoneConfirmResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.phone_confirm_error_already_added);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…firm_error_already_added)");
        this.a = string;
        String string2 = resources.getString(R.string.phone_confirm_error);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.phone_confirm_error)");
        this.b = string2;
    }

    @NotNull
    public final String getCodeConfirmError() {
        return this.b;
    }

    @NotNull
    public final String getPhoneAlreadyAddedError() {
        return this.a;
    }
}
