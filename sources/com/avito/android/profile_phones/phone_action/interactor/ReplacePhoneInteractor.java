package com.avito.android.profile_phones.phone_action.interactor;

import a2.b.a.a.a;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/interactor/ReplacePhoneInteractor;", "Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;", "", "phone", "replacingPhone", "Lio/reactivex/rxjava3/core/Single;", "", "performAction", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class ReplacePhoneInteractor implements PhoneActionInteractor {
    public final ProfileApi a;
    public final SchedulersFactory3 b;

    public ReplacePhoneInteractor(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = profileApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.profile_phones.phone_action.interactor.PhoneActionInteractor
    @NotNull
    public Single<Unit> performAction(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        if (str2 == null) {
            Single<Unit> error = Single.error(new IllegalArgumentException("Replacing phone must not be null"));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error(IllegalArgu…phone must not be null\"))");
            return error;
        }
        Single<Unit> flatMap = a.e2(this.b, this.a.replacePhone(str, str2, false), "api.replacePhone(phone, …scribeOn(schedulers.io())").flatMap(ReplacePhoneInteractor$performAction$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        return flatMap;
    }
}
