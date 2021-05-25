package com.avito.android.profile.password_change.business;

import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJC\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00022\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/password_change/business/PasswordChangeInteractor;", "", "Lio/reactivex/Observable;", "", "getUserLogin", "()Lio/reactivex/Observable;", "", "isAuthorized", "()Z", "oldPassword", "newPassword", "sessionHashId", "source", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/password/PasswordChangeResult;", "changePassword", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface PasswordChangeInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable changePassword$default(PasswordChangeInteractor passwordChangeInteractor, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = null;
                }
                if ((i & 8) != 0) {
                    str4 = null;
                }
                return passwordChangeInteractor.changePassword(str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changePassword");
        }
    }

    @NotNull
    Observable<LoadingState<PasswordChangeResult>> changePassword(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4);

    @Nullable
    String getCurrentUserId();

    @NotNull
    Observable<String> getUserLogin();

    boolean isAuthorized();
}
