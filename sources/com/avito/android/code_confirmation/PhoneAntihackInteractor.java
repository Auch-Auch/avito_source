package com.avito.android.code_confirmation;

import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;", "", "", "login", "Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;)Lio/reactivex/Observable;", "code", "challengeId", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneAntihackInteractor {
    @NotNull
    Observable<CodeInfo> requestCode(@NotNull String str);

    @NotNull
    Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
