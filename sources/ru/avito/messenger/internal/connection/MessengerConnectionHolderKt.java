package ru.avito.messenger.internal.connection;

import androidx.annotation.VisibleForTesting;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.Singles;
import com.avito.android.util.preferences.SessionContract;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerSessionRefresher;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerSocketTerminationException;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001aC\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000b\u0010\f\"\u001c\u0010\u000e\u001a\u00020\r8\u0000@\u0001XT¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "Lru/avito/messenger/MessengerSessionRefresher;", "refresher", "", SessionContract.SESSION, "source", "sequenceId", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lio/reactivex/Single;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "handleConnectionError", "(Lru/avito/messenger/internal/entity/messenger/TerminationEvent;Lru/avito/messenger/MessengerSessionRefresher;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/communications_common/analytics/ErrorTracker;)Lio/reactivex/Single;", "", "STATE_WATCHDOG_TIMEOUT_S", "J", "getSTATE_WATCHDOG_TIMEOUT_S$annotations", "()V", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class MessengerConnectionHolderKt {
    public static final long STATE_WATCHDOG_TIMEOUT_S = 15;

    public static final class a<T, R> implements Function<Throwable, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Boolean.FALSE;
        }
    }

    public static final class b<T, R> implements Function<Boolean, MessengerConnectionHolder.State> {
        public final /* synthetic */ TerminationEvent a;
        public final /* synthetic */ String b;

        public b(TerminationEvent terminationEvent, String str) {
            this.a = terminationEvent;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MessengerConnectionHolder.State apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "refreshed");
            if (bool2.booleanValue()) {
                return new MessengerConnectionHolder.State.Disconnected(true, null, this.b, 2, null);
            }
            return new MessengerConnectionHolder.State.Disconnected(true, this.a, null);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getSTATE_WATCHDOG_TIMEOUT_S$annotations() {
    }

    @VisibleForTesting(otherwise = 3)
    @NotNull
    public static final Single<MessengerConnectionHolder.State> handleConnectionError(@NotNull TerminationEvent terminationEvent, @NotNull MessengerSessionRefresher messengerSessionRefresher, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull ErrorTracker errorTracker) {
        Throwable unknown;
        Integer code;
        Intrinsics.checkNotNullParameter(terminationEvent, "$this$handleConnectionError");
        Intrinsics.checkNotNullParameter(messengerSessionRefresher, "refresher");
        Intrinsics.checkNotNullParameter(str, SessionContract.SESSION);
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        if (terminationEvent instanceof TerminationEvent.UnauthorizedError) {
            unknown = new MessengerSocketTerminationException.UnauthorizedError(((TerminationEvent.UnauthorizedError) terminationEvent).getError());
        } else if (terminationEvent instanceof TerminationEvent.ForbiddenError) {
            unknown = new MessengerSocketTerminationException.ForbiddenError(((TerminationEvent.ForbiddenError) terminationEvent).getError());
        } else if (terminationEvent instanceof TerminationEvent.ClosedByUser) {
            unknown = new MessengerSocketTerminationException.ClosedByUser();
        } else if (terminationEvent instanceof TerminationEvent.NetworkError) {
            unknown = new MessengerSocketTerminationException.NetworkError(((TerminationEvent.NetworkError) terminationEvent).getError());
        } else if (terminationEvent instanceof TerminationEvent.Unknown) {
            TerminationEvent.Unknown unknown2 = (TerminationEvent.Unknown) terminationEvent;
            unknown = new MessengerSocketTerminationException.Unknown(unknown2.getReason(), unknown2.getError());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        boolean z = false;
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to(SessionContract.SESSION, str), TuplesKt.to("source", str2));
        Integer code2 = terminationEvent.getCode();
        if (code2 != null) {
            mutableMapOf.put("code", Integer.valueOf(code2.intValue()));
        }
        if (str3 != null) {
            mutableMapOf.put("sequenceId", str3);
        }
        ErrorTracker.DefaultImpls.track$default(errorTracker, unknown, null, mutableMapOf, 2, null);
        if ((str.length() > 0) && (terminationEvent instanceof TerminationEvent.UnauthorizedError)) {
            z = true;
        }
        if (z) {
            Single<R> map = messengerSessionRefresher.refreshSession(str, str2).onErrorReturn(a.a).map(new b(terminationEvent, str3));
            Intrinsics.checkNotNullExpressionValue(map, "refresher.refreshSession…      }\n                }");
            return map;
        } else if (str3 != null && (code = terminationEvent.getCode()) != null && code.intValue() == 3410) {
            return Singles.toSingle(new MessengerConnectionHolder.State.Disconnected(true, terminationEvent, null));
        } else {
            Single<MessengerConnectionHolder.State> just = Single.just(new MessengerConnectionHolder.State.Disconnected(true, terminationEvent, str3));
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(\n           …          )\n            )");
            return just;
        }
    }
}
