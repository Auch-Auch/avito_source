package com.avito.android.profile_phones.phone_management;

import com.avito.android.code_confirmation.RequestCodeInteractor;
import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractor;", "Lcom/avito/android/code_confirmation/RequestCodeInteractor;", "", "currentPhone", "targetPhone", "Lio/reactivex/Completable;", "replacePhone", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneManagementInteractor extends RequestCodeInteractor {
    @NotNull
    Completable replacePhone(@NotNull String str, @NotNull String str2);
}
