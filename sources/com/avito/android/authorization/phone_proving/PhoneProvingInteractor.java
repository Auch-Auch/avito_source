package com.avito.android.authorization.phone_proving;

import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/phone_proving/PhoneProvingInteractor;", "", "", "challengeId", "phone", "Lio/reactivex/Completable;", "provePhone", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneProvingInteractor {
    @NotNull
    Completable provePhone(@NotNull String str, @NotNull String str2);
}
