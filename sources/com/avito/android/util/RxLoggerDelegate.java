package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u001b\u0010\u0006\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/util/RxLoggerDelegate;", "Lcom/avito/android/util/RxLogger;", "T", "Lio/reactivex/Observable;", "", "message", "log", "(Lio/reactivex/Observable;Ljava/lang/String;)Lio/reactivex/Observable;", "Lio/reactivex/Single;", "(Lio/reactivex/Single;Ljava/lang/String;)Lio/reactivex/Single;", "Lio/reactivex/Completable;", "(Lio/reactivex/Completable;Ljava/lang/String;)Lio/reactivex/Completable;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "logTag", "", AuthSource.SEND_ABUSE, "Z", "isEnabled", "<init>", "(ZLjava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class RxLoggerDelegate implements RxLogger {
    public final boolean a;
    public final String b;

    public static final class a<T> implements Consumer<Throwable> {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public a(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onError> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public b(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onSubscribe> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public static final class c<T> implements Consumer<T> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ RxLoggerDelegate b;
        public final /* synthetic */ String c;

        public c(AtomicBoolean atomicBoolean, RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = atomicBoolean;
            this.b = rxLoggerDelegate;
            this.c = str;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) {
            if (this.a.compareAndSet(true, false)) {
                String str = this.b.b;
                StringBuilder L = a2.b.a.a.a.L("<onFirst> ");
                L.append(this.c);
                LogsT.verbose$default(str, L.toString(), null, 4, null);
            }
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public d(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onComplete> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public e(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onError> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public static final class f<T> implements Consumer<Disposable> {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public f(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onSubscribe> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public static final class g<T> implements Consumer<T> {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public g(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onSuccess> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public h(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onError> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public static final class i<T> implements Consumer<Disposable> {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public i(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onSubscribe> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public static final class j implements Action {
        public final /* synthetic */ RxLoggerDelegate a;
        public final /* synthetic */ String b;

        public j(RxLoggerDelegate rxLoggerDelegate, String str) {
            this.a = rxLoggerDelegate;
            this.b = str;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            String str = this.a.b;
            StringBuilder L = a2.b.a.a.a.L("<onComplete> ");
            L.append(this.b);
            LogsT.verbose$default(str, L.toString(), null, 4, null);
        }
    }

    public RxLoggerDelegate(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "logTag");
        this.a = z;
        this.b = str;
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public <T> Observable<T> log(@NotNull Observable<T> observable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(observable, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        if (!this.a) {
            return observable;
        }
        Observable<T> doOnError = observable.doOnSubscribe(new b(this, str)).doOnNext(new c(new AtomicBoolean(true), this, str)).doOnComplete(new d(this, str)).doOnError(new e(this, str));
        Intrinsics.checkNotNullExpressionValue(doOnError, "doOnSubscribe {\n        … $message\")\n            }");
        return doOnError;
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public <T> Single<T> log(@NotNull Single<T> single, @NotNull String str) {
        Intrinsics.checkNotNullParameter(single, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        if (!this.a) {
            return single;
        }
        Single<T> doOnError = single.doOnSubscribe(new f(this, str)).doOnSuccess(new g(this, str)).doOnError(new h(this, str));
        Intrinsics.checkNotNullExpressionValue(doOnError, "doOnSubscribe {\n        … $message\")\n            }");
        return doOnError;
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public Completable log(@NotNull Completable completable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(completable, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        if (!this.a) {
            return completable;
        }
        Completable doOnError = completable.doOnSubscribe(new i(this, str)).doOnComplete(new j(this, str)).doOnError(new a(this, str));
        Intrinsics.checkNotNullExpressionValue(doOnError, "doOnSubscribe {\n        … $message\")\n            }");
        return doOnError;
    }
}
