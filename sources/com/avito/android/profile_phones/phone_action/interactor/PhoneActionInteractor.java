package com.avito.android.profile_phones.phone_action.interactor;

import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;", "", "", "phone", "replacingPhone", "Lio/reactivex/rxjava3/core/Single;", "", "performAction", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneActionInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single performAction$default(PhoneActionInteractor phoneActionInteractor, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return phoneActionInteractor.performAction(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performAction");
        }
    }

    @NotNull
    Single<Unit> performAction(@NotNull String str, @Nullable String str2);
}
