package com.avito.android.profile.sessions.social_logout;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.SessionsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004JC\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractorImpl;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractor;", "", "isAuthorized", "()Z", "", "deviceId", "sessionHashId", "loginType", "source", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "", "logout", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "Lcom/avito/android/remote/SessionsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SessionsApi;", "api", "Lcom/avito/android/account/AccountStorageInteractor;", "d", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/SessionsApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountStorageInteractor;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsSocialLogoutInteractorImpl implements SessionsSocialLogoutInteractor {
    public final SessionsApi a;
    public final TypedErrorThrowableConverter b;
    public final SchedulersFactory3 c;
    public final AccountStorageInteractor d;

    public static final class a<T, R> implements Function<TypedResult<Unit>, LoadingState<? super Unit>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Unit> apply(TypedResult<Unit> typedResult) {
            TypedResult<Unit> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super Unit>> {
        public final /* synthetic */ SessionsSocialLogoutInteractorImpl a;

        public b(SessionsSocialLogoutInteractorImpl sessionsSocialLogoutInteractorImpl) {
            this.a = sessionsSocialLogoutInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Unit> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public SessionsSocialLogoutInteractorImpl(@NotNull SessionsApi sessionsApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountStorageInteractor accountStorageInteractor) {
        Intrinsics.checkNotNullParameter(sessionsApi, "api");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        this.a = sessionsApi;
        this.b = typedErrorThrowableConverter;
        this.c = schedulersFactory3;
        this.d = accountStorageInteractor;
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutInteractor
    @Nullable
    public String getCurrentUserId() {
        return this.d.getCurrentUserId();
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutInteractor
    public boolean isAuthorized() {
        return this.d.isAuthorized();
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutInteractor
    @NotNull
    public Observable<LoadingState<Unit>> logout(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Observable<R> onErrorReturn = this.a.deleteOtherSessions(str, str2, str3, str4).subscribeOn(this.c.io()).map(a.a).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.deleteOtherSessions(…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
