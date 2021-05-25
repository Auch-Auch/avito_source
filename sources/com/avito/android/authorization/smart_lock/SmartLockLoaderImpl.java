package com.avito.android.authorization.smart_lock;

import a2.a.a.b.a.e;
import android.content.Context;
import android.content.Intent;
import com.avito.android.account.Credentials;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.auth.tracker.check.CheckTrackerModule;
import com.avito.android.authorization.event.SmartLockAccountFoundEvent;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResponse;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.Task;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00104\u001a\u000201\u0012\b\u00105\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b6\u00107J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001f\u001a\u00020\b*\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010*R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoaderImpl;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "connect", "()Lio/reactivex/rxjava3/core/Observable;", "command", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/account/Credentials$PasswordCredentials;", "run", "(Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;)Lio/reactivex/rxjava3/core/Maybe;", "", "resultCode", "Landroid/content/Intent;", "data", "", "handleResult", "(ILandroid/content/Intent;)V", "", "skipSingleAccountConfirmation", "load", "(Z)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lio/reactivex/rxjava3/core/Single;", CheckTrackerModule.NAME, "()Lio/reactivex/rxjava3/core/Single;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;)V", "Lcom/google/android/gms/auth/api/credentials/Credential;", AuthSource.BOOKING_ORDER, "(Lcom/google/android/gms/auth/api/credentials/Credential;)Lcom/avito/android/account/Credentials$PasswordCredentials;", "Lcom/avito/android/util/DialogRouter;", "d", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "commands", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "state", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/DialogRouter;Landroid/content/Context;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/Kundle;)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
public final class SmartLockLoaderImpl implements SmartLockLoader {
    public SmartLockLoader.Command a;
    public PublishSubject<SmartLockLoader.Command> b;
    public final Analytics c;
    public DialogRouter d;
    public final Context e;
    public final SchedulersFactory3 f;

    public static final class a<T, R> implements Function<Task<CredentialRequestResponse>, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(Task<CredentialRequestResponse> task) {
            boolean z;
            Task<CredentialRequestResponse> task2 = task;
            Intrinsics.checkNotNullExpressionValue(task2, "task");
            if (!task2.isSuccessful()) {
                Exception exception = task2.getException();
                if (!(exception instanceof ResolvableApiException)) {
                    exception = null;
                }
                ResolvableApiException resolvableApiException = (ResolvableApiException) exception;
                if (resolvableApiException == null || resolvableApiException.getStatusCode() != 6) {
                    z = false;
                    return Boolean.valueOf(z);
                }
            }
            z = true;
            return Boolean.valueOf(z);
        }
    }

    public static final class b<T, R> implements Function<Throwable, Boolean> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public /* bridge */ /* synthetic */ Boolean apply(Throwable th) {
            return Boolean.FALSE;
        }
    }

    public static final class c<T> implements Predicate<SmartLockLoader.Command> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(SmartLockLoader.Command command) {
            return !(command instanceof SmartLockLoader.Command.Wait);
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ SmartLockLoaderImpl a;
        public final /* synthetic */ SmartLockLoader.Command b;

        public d(SmartLockLoaderImpl smartLockLoaderImpl, SmartLockLoader.Command command) {
            this.a = smartLockLoaderImpl;
            this.b = command;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            if (Intrinsics.areEqual(this.a.a, this.b)) {
                this.a.a = null;
            }
        }
    }

    public SmartLockLoaderImpl(@NotNull Analytics analytics, @NotNull DialogRouter dialogRouter, @NotNull Context context, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.c = analytics;
        this.d = dialogRouter;
        this.e = context;
        this.f = schedulersFactory3;
        this.a = kundle != null ? (SmartLockLoader.Command) kundle.getParcelable("command") : null;
        PublishSubject<SmartLockLoader.Command> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.b = create;
    }

    public static final void access$push(SmartLockLoaderImpl smartLockLoaderImpl, SmartLockLoader.Command command) {
        smartLockLoaderImpl.a = command;
        smartLockLoaderImpl.b.onNext(command);
    }

    public final void a(SmartLockLoader.Command command) {
        this.a = command;
        this.b.onNext(command);
    }

    public final Credentials.PasswordCredentials b(Credential credential) {
        String id = credential.getId();
        Intrinsics.checkNotNullExpressionValue(id, "id");
        String password = credential.getPassword();
        if (password == null) {
            password = "";
        }
        return new Credentials.PasswordCredentials(id, password);
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
    @NotNull
    public Single<Boolean> check() {
        Single create = Single.create(new e(this));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …Success(task) }\n        }");
        Single<Boolean> timeout = create.map(a.a).onErrorReturn(b.a).timeout(5, TimeUnit.SECONDS, this.f.io());
        Intrinsics.checkNotNullExpressionValue(timeout, "request()\n            .m…SECONDS, schedulers.io())");
        return timeout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r1 != null) goto L_0x0016;
     */
    @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Observable<com.avito.android.authorization.smart_lock.SmartLockLoader.Command> connect() {
        /*
            r3 = this;
            io.reactivex.rxjava3.subjects.PublishSubject<com.avito.android.authorization.smart_lock.SmartLockLoader$Command> r0 = r3.b
            com.avito.android.authorization.smart_lock.SmartLockLoader$Command r1 = r3.a
            if (r1 == 0) goto L_0x0012
            io.reactivex.rxjava3.core.Observable r1 = io.reactivex.rxjava3.core.Observable.just(r1)
            java.lang.String r2 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 == 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            io.reactivex.rxjava3.core.Observable r1 = io.reactivex.rxjava3.core.Observable.empty()
        L_0x0016:
            io.reactivex.rxjava3.core.Observable r0 = io.reactivex.rxjava3.core.Observable.merge(r0, r1)
            java.lang.String r1 = "Observable.merge(\n      …ervable.empty()\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.smart_lock.SmartLockLoaderImpl.connect():io.reactivex.rxjava3.core.Observable");
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
    @NotNull
    public Observable<Maybe<Credentials.PasswordCredentials>> connectWithObservables() {
        return SmartLockLoader.DefaultImpls.connectWithObservables(this);
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
    public void handleResult(int i, @Nullable Intent intent) {
        Integer valueOf = intent != null ? Integer.valueOf(i) : null;
        if (valueOf != null && valueOf.intValue() == -1) {
            Credential credential = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
            this.c.track(new SmartLockAccountFoundEvent());
            Intrinsics.checkNotNullExpressionValue(credential, "credential");
            SmartLockLoader.Command.Finish finish = new SmartLockLoader.Command.Finish(credential);
            this.a = finish;
            this.b.onNext(finish);
        } else if (valueOf != null && valueOf.intValue() == 0) {
            a(SmartLockLoader.Command.Cancel.INSTANCE);
        } else {
            SmartLockLoader.Command.Error error = new SmartLockLoader.Command.Error("SmartLock result handling failed");
            this.a = error;
            this.b.onNext(error);
        }
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
    public void load(boolean z) {
        SmartLockLoader.Command.Load load = new SmartLockLoader.Command.Load(z);
        this.a = load;
        this.b.onNext(load);
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("command", this.a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0083, code lost:
        if (r1 != null) goto L_0x008a;
     */
    @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Maybe<com.avito.android.account.Credentials.PasswordCredentials> run(@org.jetbrains.annotations.NotNull com.avito.android.authorization.smart_lock.SmartLockLoader.Command r7) {
        /*
            r6 = this;
            java.lang.String r0 = "command"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7 instanceof com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Load
            if (r0 == 0) goto L_0x0053
            r0 = r7
            com.avito.android.authorization.smart_lock.SmartLockLoader$Command$Load r0 = (com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Load) r0
            boolean r0 = r0.getSkipSingleAccountConfirmation()
            a2.a.a.b.a.e r1 = new a2.a.a.b.a.e
            r1.<init>(r6)
            io.reactivex.rxjava3.core.Single r1 = io.reactivex.rxjava3.core.Single.create(r1)
            java.lang.String r2 = "Single.create { emitter …Success(task) }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxjava3.core.Maybe r1 = r1.toMaybe()
            a2.a.a.b.a.c r2 = new a2.a.a.b.a.c
            r2.<init>(r6)
            io.reactivex.rxjava3.core.Maybe r1 = r1.flatMap(r2)
            r2 = 5
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            com.avito.android.util.SchedulersFactory3 r5 = r6.f
            io.reactivex.rxjava3.core.Scheduler r5 = r5.io()
            io.reactivex.rxjava3.core.Maybe r1 = r1.timeout(r2, r4, r5)
            a2.a.a.b.a.d r2 = new a2.a.a.b.a.d
            r2.<init>(r6, r0)
            io.reactivex.rxjava3.core.Maybe r0 = r1.flatMap(r2)
            java.lang.String r1 = "request().toMaybe()\n    …          }\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.avito.android.util.SchedulersFactory3 r1 = r6.f
            io.reactivex.rxjava3.core.Scheduler r1 = r1.mainThread()
            io.reactivex.rxjava3.core.Maybe r0 = r0.observeOn(r1)
            goto L_0x00cf
        L_0x0053:
            boolean r0 = r7 instanceof com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Finish
            if (r0 == 0) goto L_0x0067
            r0 = r7
            com.avito.android.authorization.smart_lock.SmartLockLoader$Command$Finish r0 = (com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Finish) r0
            com.google.android.gms.auth.api.credentials.Credential r0 = r0.getCredential()
            com.avito.android.account.Credentials$PasswordCredentials r0 = r6.b(r0)
            io.reactivex.rxjava3.core.Maybe r0 = com.avito.android.util.rx3.Maybies.toMaybe(r0)
            goto L_0x00cf
        L_0x0067:
            boolean r0 = r7 instanceof com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Cancel
            if (r0 == 0) goto L_0x0070
            io.reactivex.rxjava3.core.Maybe r0 = io.reactivex.rxjava3.core.Maybe.empty()
            goto L_0x00cf
        L_0x0070:
            boolean r0 = r7 instanceof com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Wait
            if (r0 == 0) goto L_0x00a1
            io.reactivex.rxjava3.subjects.PublishSubject<com.avito.android.authorization.smart_lock.SmartLockLoader$Command> r0 = r6.b
            com.avito.android.authorization.smart_lock.SmartLockLoader$Command r1 = r6.a
            if (r1 == 0) goto L_0x0086
            io.reactivex.rxjava3.core.Observable r1 = io.reactivex.rxjava3.core.Observable.just(r1)
            java.lang.String r2 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 == 0) goto L_0x0086
            goto L_0x008a
        L_0x0086:
            io.reactivex.rxjava3.core.Observable r1 = io.reactivex.rxjava3.core.Observable.empty()
        L_0x008a:
            io.reactivex.rxjava3.core.Observable r0 = io.reactivex.rxjava3.core.Observable.merge(r0, r1)
            com.avito.android.authorization.smart_lock.SmartLockLoaderImpl$c r1 = com.avito.android.authorization.smart_lock.SmartLockLoaderImpl.c.a
            io.reactivex.rxjava3.core.Observable r0 = r0.filter(r1)
            io.reactivex.rxjava3.core.Maybe r0 = r0.firstElement()
            io.reactivex.rxjava3.core.Completable r0 = r0.ignoreElement()
            io.reactivex.rxjava3.core.Maybe r0 = r0.toMaybe()
            goto L_0x00cf
        L_0x00a1:
            boolean r0 = r7 instanceof com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Confirm
            if (r0 == 0) goto L_0x00bb
            r0 = r7
            com.avito.android.authorization.smart_lock.SmartLockLoader$Command$Confirm r0 = (com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Confirm) r0
            com.google.android.gms.auth.api.credentials.Credential r0 = r0.getCredential()
            a2.a.a.b.a.a r1 = new a2.a.a.b.a.a
            r1.<init>(r6, r0)
            io.reactivex.rxjava3.core.Maybe r0 = io.reactivex.rxjava3.core.Maybe.create(r1)
            java.lang.String r1 = "Maybe.create { emitter -…dismiss()\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x00cf
        L_0x00bb:
            boolean r0 = r7 instanceof com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Error
            if (r0 == 0) goto L_0x00de
            com.avito.android.authorization.smart_lock.SmartLockException r0 = new com.avito.android.authorization.smart_lock.SmartLockException
            r1 = r7
            com.avito.android.authorization.smart_lock.SmartLockLoader$Command$Error r1 = (com.avito.android.authorization.smart_lock.SmartLockLoader.Command.Error) r1
            java.lang.String r1 = r1.getMessage()
            r0.<init>(r1)
            io.reactivex.rxjava3.core.Maybe r0 = io.reactivex.rxjava3.core.Maybe.error(r0)
        L_0x00cf:
            com.avito.android.authorization.smart_lock.SmartLockLoaderImpl$d r1 = new com.avito.android.authorization.smart_lock.SmartLockLoaderImpl$d
            r1.<init>(r6, r7)
            io.reactivex.rxjava3.core.Maybe r7 = r0.doAfterTerminate(r1)
            java.lang.String r0 = "when (command) {\n       …nd = null\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            return r7
        L_0x00de:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.smart_lock.SmartLockLoaderImpl.run(com.avito.android.authorization.smart_lock.SmartLockLoader$Command):io.reactivex.rxjava3.core.Maybe");
    }
}
