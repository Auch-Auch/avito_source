package com.avito.android.public_profile;

import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", "", "", "userKey", "shortcut", "", "offset", "limit", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "loadProfileAdverts", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileAdvertsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadProfileAdverts$default(ProfileAdvertsInteractor profileAdvertsInteractor, String str, String str2, int i, Integer num, String str3, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    num = null;
                }
                return profileAdvertsInteractor.loadProfileAdverts(str, str2, i, num, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadProfileAdverts");
        }
    }

    @NotNull
    Observable<ProfileAdvertsResult> loadProfileAdverts(@NotNull String str, @NotNull String str2, int i, @Nullable Integer num, @Nullable String str3);
}
