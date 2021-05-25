package com.avito.android.public_profile;

import a2.b.a.a.a;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016JA\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/public_profile/ProfileAdvertsInteractorImpl;", "Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", "", "userKey", "shortcut", "", "offset", "limit", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "loadProfileAdverts", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/public_profile/remote/PublicProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/public_profile/remote/PublicProfileApi;", "api", "<init>", "(Lcom/avito/android/public_profile/remote/PublicProfileApi;Lcom/avito/android/util/SchedulersFactory3;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileAdvertsInteractorImpl implements ProfileAdvertsInteractor {
    public final PublicProfileApi a;
    public final SchedulersFactory3 b;

    public ProfileAdvertsInteractorImpl(@NotNull PublicProfileApi publicProfileApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(publicProfileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = publicProfileApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsInteractor
    @NotNull
    public Observable<ProfileAdvertsResult> loadProfileAdverts(@NotNull String str, @NotNull String str2, int i, @Nullable Integer num, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str2, "shortcut");
        return a.a2(this.b, this.a.getProfileAdverts(str, Integer.valueOf(i), num, str2, str3), "api.getProfileAdverts(us…scribeOn(schedulers.io())");
    }
}
