package com.avito.android.profile.sessions.list;

import com.avito.android.profile.sessions.adapter.SessionsListItem;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JE\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\f\u0010\rJ?\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListInteractor;", "", "", "fromTimestamp", "", "timezoneOffset", "", "source", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/android/profile/sessions/adapter/SessionsListItem;", "loadSessions", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "deviceId", "sessionHashId", "loginType", "", "deleteSession", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsListInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable deleteSession$default(SessionsListInteractor sessionsListInteractor, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return sessionsListInteractor.deleteSession(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteSession");
        }

        public static /* synthetic */ Observable loadSessions$default(SessionsListInteractor sessionsListInteractor, Long l, Integer num, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    l = null;
                }
                if ((i & 2) != 0) {
                    num = null;
                }
                if ((i & 4) != 0) {
                    str = null;
                }
                return sessionsListInteractor.loadSessions(l, num, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSessions");
        }
    }

    @NotNull
    Observable<LoadingState<Unit>> deleteSession(@Nullable String str, @Nullable String str2, @Nullable String str3);

    @NotNull
    Observable<LoadingState<List<? extends SessionsListItem>>> loadSessions(@Nullable Long l, @Nullable Integer num, @Nullable String str);
}
