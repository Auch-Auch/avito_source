package com.avito.android.profile.sessions.list;

import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.sessions.adapter.SessionsListItem;
import com.avito.android.profile.sessions.adapter.header.SessionsHeaderItem;
import com.avito.android.profile.sessions.adapter.info.SessionsInfoItem;
import com.avito.android.profile.sessions.adapter.loading.SessionsLoadingItem;
import com.avito.android.profile.sessions.adapter.session.SessionItem;
import com.avito.android.remote.SessionsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SessionsAction;
import com.avito.android.remote.model.SessionsHeader;
import com.avito.android.remote.model.SessionsInfo;
import com.avito.android.remote.model.SessionsItem;
import com.avito.android.remote.model.SessionsResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J?\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListInteractorImpl;", "Lcom/avito/android/profile/sessions/list/SessionsListInteractor;", "", "fromTimestamp", "", "timezoneOffset", "", "source", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/android/profile/sessions/adapter/SessionsListItem;", "loadSessions", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "deviceId", "sessionHashId", "loginType", "", "deleteSession", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/SessionsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SessionsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/SessionsApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsListInteractorImpl implements SessionsListInteractor {
    public final SessionsApi a;
    public final TypedErrorThrowableConverter b;
    public final SchedulersFactory3 c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SessionsAction.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            SessionsAction.Type type = SessionsAction.Type.LOGOUT;
            iArr[1] = 1;
            SessionsAction.Type type2 = SessionsAction.Type.ALARM;
            iArr[0] = 2;
        }
    }

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
        public final /* synthetic */ SessionsListInteractorImpl a;

        public b(SessionsListInteractorImpl sessionsListInteractorImpl) {
            this.a = sessionsListInteractorImpl;
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

    public static final class c<T, R> implements Function<SessionsResult, LoadingState<? super List<? extends SessionsListItem>>> {
        public final /* synthetic */ SessionsListInteractorImpl a;

        public c(SessionsListInteractorImpl sessionsListInteractorImpl) {
            this.a = sessionsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super List<? extends SessionsListItem>> apply(SessionsResult sessionsResult) {
            SessionsResult sessionsResult2 = sessionsResult;
            SessionsListInteractorImpl sessionsListInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(sessionsResult2, "it");
            return SessionsListInteractorImpl.access$convert(sessionsListInteractorImpl, sessionsResult2);
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super List<? extends SessionsListItem>>> {
        public final /* synthetic */ SessionsListInteractorImpl a;

        public d(SessionsListInteractorImpl sessionsListInteractorImpl) {
            this.a = sessionsListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super List<? extends SessionsListItem>> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public SessionsListInteractorImpl(@NotNull SessionsApi sessionsApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(sessionsApi, "api");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = sessionsApi;
        this.b = typedErrorThrowableConverter;
        this.c = schedulersFactory3;
    }

    public static final LoadingState access$convert(SessionsListInteractorImpl sessionsListInteractorImpl, SessionsResult sessionsResult) {
        SessionItem.Action.Type type;
        Objects.requireNonNull(sessionsListInteractorImpl);
        ArrayList arrayList = new ArrayList();
        for (T t : sessionsResult.getList()) {
            Parcelable parcelable = null;
            ArrayList arrayList2 = null;
            if (t instanceof SessionsInfo) {
                T t2 = t;
                parcelable = new SessionsInfoItem(t2.getTitle(), t2.getDescription());
            } else if (t instanceof SessionsHeader) {
                parcelable = new SessionsHeaderItem(t.getTitle());
            } else if (t instanceof SessionsItem) {
                T t3 = t;
                List<SessionsAction> actions = t3.getActions();
                if (actions != null) {
                    arrayList2 = new ArrayList(e.collectionSizeOrDefault(actions, 10));
                    for (T t4 : actions) {
                        String title = t4.getTitle();
                        DeepLink deeplink = t4.getDeeplink();
                        int ordinal = t4.getType().ordinal();
                        if (ordinal == 0) {
                            type = SessionItem.Action.Type.ALARM;
                        } else if (ordinal == 1) {
                            type = SessionItem.Action.Type.LOGOUT;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        arrayList2.add(new SessionItem.Action(title, deeplink, type, false, 8, null));
                    }
                }
                String title2 = t3.getTitle();
                String subtitle = t3.getSubtitle();
                String sessionIdHash = t3.getSessionIdHash();
                if (sessionIdHash == null) {
                    sessionIdHash = t3.getDeviceId();
                }
                if (sessionIdHash == null) {
                    sessionIdHash = a2.b.a.a.a.I2("UUID.randomUUID().toString()");
                }
                parcelable = new SessionItem(title2, subtitle, sessionIdHash, arrayList2, t3.isCurrent());
            }
            if (parcelable != null) {
                arrayList.add(parcelable == 1 ? 1 : 0);
            }
        }
        Long cursor = sessionsResult.getCursor();
        if (cursor != null) {
            arrayList.add(new SessionsLoadingItem(cursor.longValue()));
        }
        return new LoadingState.Loaded(arrayList);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListInteractor
    @NotNull
    public Observable<LoadingState<Unit>> deleteSession(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Observable<R> onErrorReturn = this.a.deleteOneSession(str, str2, str3).subscribeOn(this.c.io()).map(a.a).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.deleteOneSession(\n  …eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListInteractor
    @NotNull
    public Observable<LoadingState<List<? extends SessionsListItem>>> loadSessions(@Nullable Long l, @Nullable Integer num, @Nullable String str) {
        Observable<TypedResult<SessionsResult>> subscribeOn = this.a.getSessions(l, num, str).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getSessions(\n       …scribeOn(schedulers.io())");
        Observable<LoadingState<List<? extends SessionsListItem>>> onErrorReturn = TypedObservablesKt.toTyped(subscribeOn).map(new c(this)).onErrorReturn(new d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getSessions(\n       …eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
