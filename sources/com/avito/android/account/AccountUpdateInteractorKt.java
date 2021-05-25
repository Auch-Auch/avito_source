package com.avito.android.account;

import com.avito.android.remote.model.Profile;
import com.avito.android.remote.model.Session;
import com.avito.android.util.ProfilesKt;
import com.avito.android.util.preferences.SessionContract;
import io.reactivex.rxjava3.core.Completable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/account/AccountUpdateInteractor;", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "Lcom/avito/android/remote/model/Profile;", "profile", "", "source", "Lio/reactivex/rxjava3/core/Completable;", "login", "(Lcom/avito/android/account/AccountUpdateInteractor;Lcom/avito/android/remote/model/Session;Lcom/avito/android/remote/model/Profile;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "account-storage_release"}, k = 2, mv = {1, 4, 2})
public final class AccountUpdateInteractorKt {
    @NotNull
    public static final Completable login(@NotNull AccountUpdateInteractor accountUpdateInteractor, @NotNull Session session, @NotNull Profile profile, @Nullable String str) {
        Intrinsics.checkNotNullParameter(accountUpdateInteractor, "$this$login");
        Intrinsics.checkNotNullParameter(session, SessionContract.SESSION);
        Intrinsics.checkNotNullParameter(profile, "profile");
        return accountUpdateInteractor.login(session, ProfilesKt.toProfileInfo(profile), str);
    }
}
