package com.avito.android.messenger.service;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Session;
import com.avito.android.util.preferences.SessionContract;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.SessionProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/service/MessengerSessionProvider;", "Lru/avito/messenger/SessionProvider;", "Lio/reactivex/Single;", "", SessionContract.SESSION, "()Lio/reactivex/Single;", "Lio/reactivex/Observable;", "getSessionObservable", "()Lio/reactivex/Observable;", "sessionObservable", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerSessionProvider implements SessionProvider {
    public final AccountStorageInteractor a;

    public static final class a<V> implements Callable<String> {
        public final /* synthetic */ MessengerSessionProvider a;

        public a(MessengerSessionProvider messengerSessionProvider) {
            this.a = messengerSessionProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public String call() {
            Session session = this.a.a.getSession();
            String session2 = session != null ? session.getSession() : null;
            return session2 != null ? session2 : "";
        }
    }

    public static final class b<T, R> implements Function<Session, String> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public String apply(Session session) {
            Session session2 = session;
            Intrinsics.checkNotNullParameter(session2, "it");
            return session2.getSession();
        }
    }

    public MessengerSessionProvider(@NotNull AccountStorageInteractor accountStorageInteractor) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        this.a = accountStorageInteractor;
    }

    @Override // ru.avito.messenger.SessionProvider
    @NotNull
    public Observable<String> getSessionObservable() {
        Observable<String> map = InteropKt.toV2(this.a.session()).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "accountStorageInteractor…      .map { it.session }");
        return map;
    }

    @Override // ru.avito.messenger.SessionProvider
    @NotNull
    public Single<String> session() {
        Single<String> fromCallable = Single.fromCallable(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …?.session.orEmpty()\n    }");
        return fromCallable;
    }
}
