package com.avito.android.calls.voximplant.rx;

import a2.a.a.z.a.g.k;
import a2.a.a.z.a.g.n;
import a2.a.a.z.a.g.o;
import a2.a.a.z.a.g.p;
import com.avito.android.calls.CallClientSession;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.RetryWhenKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/VoxCallClientSession;", "Lcom/avito/android/calls/CallClientSession;", "Lio/reactivex/rxjava3/core/Completable;", "login", "()Lio/reactivex/rxjava3/core/Completable;", "logout", "Lcom/avito/android/calls/CredentialsStorage;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/CredentialsStorage;", "credentialsStorage", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/calls/auth/UsernameProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls/auth/UsernameProvider;", "usernameProvider", "Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager;", "c", "Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager;", "sessionManager", "<init>", "(Lcom/avito/android/calls/CredentialsStorage;Lcom/avito/android/calls/auth/UsernameProvider;Lcom/avito/android/calls/voximplant/rx/core/VoxSessionManager;Lcom/avito/android/util/SchedulersFactory3;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxCallClientSession implements CallClientSession {
    public final CredentialsStorage a;
    public final UsernameProvider b;
    public final VoxSessionManager c;
    public final SchedulersFactory3 d;

    public static final class a<V> implements Callable<String> {
        public final /* synthetic */ VoxCallClientSession a;

        public a(VoxCallClientSession voxCallClientSession) {
            this.a = voxCallClientSession;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public String call() {
            Logs.debug$default(LogTagsKt.TAG_IAC, "Login to vox", null, 4, null);
            String username = this.a.a.getUsername();
            return username != null ? username : "";
        }
    }

    public static final class b<T, R> implements Function<String, CompletableSource> {
        public final /* synthetic */ VoxCallClientSession a;

        public b(VoxCallClientSession voxCallClientSession) {
            this.a = voxCallClientSession;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(String str) {
            Completable completable;
            String str2 = str;
            Logs.debug$default(LogTagsKt.TAG_IAC, a2.b.a.a.a.d3("Check username=[", str2, ']'), null, 4, null);
            Intrinsics.checkNotNullExpressionValue(str2, Preference.USERNAME);
            if (m.isBlank(str2)) {
                completable = this.a.b.getUsername().onErrorResumeNext(k.a).flatMapCompletable(new a2.a.a.z.a.g.m(this)).retryWhen(RetryWhenKt.exponentialRetry$default(500, 3, this.a.d.computation(), n.a, null, null, 0.0d, 112, null));
            } else {
                completable = Completable.complete();
            }
            return completable.andThen(Single.fromCallable(new o(this)).flatMapCompletable(new p(this)));
        }
    }

    public static final class c<V> implements Callable<Object> {
        public final /* synthetic */ VoxCallClientSession a;

        public c(VoxCallClientSession voxCallClientSession) {
            this.a = voxCallClientSession;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            Logs.debug$default(LogTagsKt.TAG_IAC, "Logout from vox", null, 4, null);
            this.a.a.clearAll();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public VoxCallClientSession(@NotNull CredentialsStorage credentialsStorage, @NotNull UsernameProvider usernameProvider, @NotNull VoxSessionManager voxSessionManager, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(credentialsStorage, "credentialsStorage");
        Intrinsics.checkNotNullParameter(usernameProvider, "usernameProvider");
        Intrinsics.checkNotNullParameter(voxSessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = credentialsStorage;
        this.b = usernameProvider;
        this.c = voxSessionManager;
        this.d = schedulersFactory3;
    }

    @Override // com.avito.android.calls.CallClientSession
    @NotNull
    public Completable login() {
        Completable flatMapCompletable = Single.fromCallable(new a(this)).flatMapCompletable(new b(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Single.fromCallable {\n  …              )\n        }");
        return flatMapCompletable;
    }

    @Override // com.avito.android.calls.CallClientSession
    @NotNull
    public Completable logout() {
        Completable fromCallable = Completable.fromCallable(new c(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…rage.clearAll()\n        }");
        return fromCallable;
    }
}
