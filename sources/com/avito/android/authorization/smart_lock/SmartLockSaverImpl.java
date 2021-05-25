package com.avito.android.authorization.smart_lock;

import a2.a.a.b.a.f;
import android.content.Context;
import android.content.Intent;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.event.SmartLockSaveEvent;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preference;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010&\u001a\u00020#\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b-\u0010.J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockSaverImpl;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;", "connect", "()Lio/reactivex/rxjava3/core/Observable;", "command", "Lio/reactivex/rxjava3/core/Maybe;", "", "run", "(Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;)Lio/reactivex/rxjava3/core/Maybe;", "", "login", Preference.PASSWORD, "save", "(Ljava/lang/String;Ljava/lang/String;)V", "", "resultCode", "Landroid/content/Intent;", "data", "handleResult", "(ILandroid/content/Intent;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;)V", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "Lio/reactivex/rxjava3/subjects/PublishSubject;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "commands", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "state", "<init>", "(Landroid/content/Context;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/Kundle;)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
public final class SmartLockSaverImpl implements SmartLockSaver {
    public SmartLockSaver.Command a;
    public PublishSubject<SmartLockSaver.Command> b;
    public final Context c;
    public final Analytics d;
    public final SchedulersFactory3 e;

    public static final class a implements Action {
        public final /* synthetic */ SmartLockSaverImpl a;
        public final /* synthetic */ SmartLockSaver.Command b;

        public a(SmartLockSaverImpl smartLockSaverImpl, SmartLockSaver.Command command) {
            this.a = smartLockSaverImpl;
            this.b = command;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            if (Intrinsics.areEqual(this.a.a, this.b)) {
                this.a.a = null;
            }
        }
    }

    public SmartLockSaverImpl(@NotNull Context context, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.c = context;
        this.d = analytics;
        this.e = schedulersFactory3;
        this.a = kundle != null ? (SmartLockSaver.Command) kundle.getParcelable("command") : null;
        PublishSubject<SmartLockSaver.Command> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.b = create;
    }

    public final void a(SmartLockSaver.Command command) {
        this.a = command;
        this.b.onNext(command);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r1 != null) goto L_0x0016;
     */
    @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Observable<com.avito.android.authorization.smart_lock.SmartLockSaver.Command> connect() {
        /*
            r3 = this;
            io.reactivex.rxjava3.subjects.PublishSubject<com.avito.android.authorization.smart_lock.SmartLockSaver$Command> r0 = r3.b
            com.avito.android.authorization.smart_lock.SmartLockSaver$Command r1 = r3.a
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
            java.lang.String r1 = "Observable.merge(\n      … Observable.empty()\n    )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.smart_lock.SmartLockSaverImpl.connect():io.reactivex.rxjava3.core.Observable");
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
    @NotNull
    public Observable<Maybe<Unit>> connectWithObservables() {
        return SmartLockSaver.DefaultImpls.connectWithObservables(this);
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
    public void handleResult(int i, @Nullable Intent intent) {
        if (i != -1) {
            SmartLockSaver.Command.Error error = new SmartLockSaver.Command.Error("SmartLock result handling failed");
            this.a = error;
            this.b.onNext(error);
            return;
        }
        this.d.track(new SmartLockSaveEvent());
        a(SmartLockSaver.Command.Finish.INSTANCE);
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("command", this.a);
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
    @NotNull
    public Maybe<Unit> run(@NotNull SmartLockSaver.Command command) {
        Maybe maybe;
        Intrinsics.checkNotNullParameter(command, "command");
        if (command instanceof SmartLockSaver.Command.Save) {
            SmartLockSaver.Command.Save save = (SmartLockSaver.Command.Save) command;
            Maybe timeout = Maybe.create(new f(this, save.getLogin(), save.getPassword())).timeout(5, TimeUnit.SECONDS, this.e.io());
            Intrinsics.checkNotNullExpressionValue(timeout, "Maybe.create<Unit> { emi…SECONDS, schedulers.io())");
            maybe = timeout.observeOn(this.e.mainThread());
        } else if (command instanceof SmartLockSaver.Command.Finish) {
            maybe = Maybe.just(Unit.INSTANCE);
        } else if (command instanceof SmartLockSaver.Command.Error) {
            maybe = Maybe.error(new SmartLockException(((SmartLockSaver.Command.Error) command).getMessage()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Maybe<Unit> doAfterTerminate = maybe.doAfterTerminate(new a(this, command));
        Intrinsics.checkNotNullExpressionValue(doAfterTerminate, "when (command) {\n       …l\n            }\n        }");
        return doAfterTerminate;
    }

    @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
    public void save(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
        SmartLockSaver.Command.Save save = new SmartLockSaver.Command.Save(str, str2);
        this.a = save;
        this.b.onNext(save);
    }
}
