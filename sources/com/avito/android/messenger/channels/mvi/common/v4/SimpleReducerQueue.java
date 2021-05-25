package com.avito.android.messenger.channels.mvi.common.v4;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.LogsT;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001b\u0012\u0006\u0010$\u001a\u00020\u001c\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b%\u0010&J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR(\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/SimpleReducerQueue;", "", "StateT", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "value", "", "plusAssign", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)V", "dispose", "()V", "", "isDisposed", "()Z", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "getStream", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "stream", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/Relay;", "qRelay", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "qDisposable", "Lio/reactivex/Scheduler;", "d", "Lio/reactivex/Scheduler;", "qScheduler", "", "e", "Ljava/lang/String;", "logTag", "scheduler", "<init>", "(Lio/reactivex/Scheduler;Ljava/lang/String;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleReducerQueue<StateT> implements ReducerQueue<StateT> {
    @NotNull
    public final PublishRelay<Reducible<StateT>> a;
    public final Relay<Reducible<StateT>> b;
    public final CompositeDisposable c;
    public final Scheduler d;
    public final String e;

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ SimpleReducerQueue a;

        public a(SimpleReducerQueue simpleReducerQueue) {
            this.a = simpleReducerQueue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            String str = this.a.e;
            if (str != null) {
                LogsT.verbose$default(str, "{RQ} subscribed to qRelay", null, 4, null);
            }
        }
    }

    public static final class b<T> implements Consumer<Reducible<StateT>> {
        public final /* synthetic */ SimpleReducerQueue a;

        public b(SimpleReducerQueue simpleReducerQueue) {
            this.a = simpleReducerQueue;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
            Reducible reducible = (Reducible) obj;
            String str = this.a.e;
            if (str != null) {
                LogsT.verbose$default(str, "{RQ} sendToReducer(reducible = " + reducible + ')', null, 4, null);
            }
            reducible.sendToReducer(this.a.getStream());
        }
    }

    public SimpleReducerQueue(@NotNull Scheduler scheduler, @Nullable String str) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        this.e = str;
        PublishRelay<Reducible<StateT>> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        Relay<Reducible<StateT>> J1 = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.b = J1;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.c = compositeDisposable;
        SharedScheduler sharedScheduler = new SharedScheduler(scheduler);
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        this.d = sharedScheduler;
        Disposable subscribe = J1.observeOn(sharedScheduler).doOnSubscribe(new a(this)).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "qRelay.observeOn(qSchedu…cer(stream)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue
    public void plusAssign(@NotNull Reducible<StateT> reducible) {
        Intrinsics.checkNotNullParameter(reducible, "value");
        String str = this.e;
        if (str != null) {
            LogsT.verbose$default(str, "{RQ} plusAssign(value = " + reducible + ')', null, 4, null);
        }
        this.b.accept(reducible);
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue
    @NotNull
    public PublishRelay<Reducible<StateT>> getStream() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleReducerQueue(Scheduler scheduler, String str, int i, j jVar) {
        this(scheduler, (i & 2) != 0 ? null : str);
    }
}
