package com.avito.android.advert_core.phone_request;

import android.content.Intent;
import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/advert_core/phone_request/PhoneRequestRouter;", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "Landroid/content/Intent;", "intent", "", "startActivitySafely", "(Landroid/content/Intent;)V", "leaveScreen", "()V", "startActivity", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneRequestRouter extends AsyncPhoneAuthRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void showAuth(@NotNull PhoneRequestRouter phoneRequestRouter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "src");
            AsyncPhoneAuthRouter.DefaultImpls.showAuth(phoneRequestRouter, str);
        }
    }

    void leaveScreen();

    void startActivity(@NotNull Intent intent);

    void startActivitySafely(@NotNull Intent intent);
}
