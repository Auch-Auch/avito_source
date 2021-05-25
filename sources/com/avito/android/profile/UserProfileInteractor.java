package com.avito.android.profile;

import com.avito.android.code_confirmation.RequestCodeInteractor;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.remote.model.user_profile.UserProfileResult;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile/UserProfileInteractor;", "Lcom/avito/android/code_confirmation/RequestCodeInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "loadProfileInfo", "()Lio/reactivex/Observable;", "", "phone", "Lio/reactivex/Completable;", "deletePhone", "(Ljava/lang/String;)Lio/reactivex/Completable;", "setPhoneForAllAdverts", "Lio/reactivex/Single;", "", "Lcom/avito/android/remote/model/user_profile/Phone;", "getPhones", "()Lio/reactivex/Single;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface UserProfileInteractor extends RequestCodeInteractor {
    @NotNull
    Completable deletePhone(@NotNull String str);

    @NotNull
    Single<List<Phone>> getPhones();

    @NotNull
    Observable<UserProfileResult> loadProfileInfo();

    @NotNull
    Completable setPhoneForAllAdverts(@NotNull String str);
}
