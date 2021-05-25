package com.avito.android.code_confirmation.phone_confirm;

import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "", "", "login", "src", "", "retry", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneCodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "code", "Lcom/avito/android/code_confirmation/phone_confirm/ConfirmedCodeData;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneConfirmInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single requestCode$default(PhoneConfirmInteractor phoneConfirmInteractor, String str, String str2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return phoneConfirmInteractor.requestCode(str, str2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestCode");
        }
    }

    @NotNull
    Single<PhoneCodeInfo> requestCode(@NotNull String str, @NotNull String str2, boolean z);

    @NotNull
    Single<ConfirmedCodeData> sendCode(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
