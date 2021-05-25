package com.avito.android.messenger.connection;

import a2.a.a.o1.c.b;
import a2.a.a.o1.c.c;
import a2.a.a.o1.c.d;
import a2.g.r.g;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgent;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.messenger.KeepConnectionProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0006\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0007\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0&8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/messenger/connection/AvitoMessengerKeepConnectionProvider;", "Lru/avito/messenger/KeepConnectionProvider;", "Landroidx/lifecycle/LifecycleObserver;", "", "onAppForeground$messenger_release", "()V", "onAppForeground", "onAppBackground$messenger_release", "onAppBackground", "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", g.a, "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "errorHandler", "Ljava/util/concurrent/atomic/AtomicBoolean;", AuthSource.BOOKING_ORDER, "Ljava/util/concurrent/atomic/AtomicBoolean;", "wasInForeground", "Lru/avito/android/persistence/messenger/MessageDao;", "d", "Lru/avito/android/persistence/messenger/MessageDao;", "messageDao", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "f", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "channelSyncOnPushAgent", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/account/AccountStateProvider;", "c", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "foregroundState", "Lio/reactivex/Observable;", "getShouldKeepConnection", "()Lio/reactivex/Observable;", "shouldKeepConnection", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/android/persistence/messenger/MessageDao;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMessengerKeepConnectionProvider implements KeepConnectionProvider, LifecycleObserver {
    public final BehaviorRelay<Boolean> a;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final AccountStateProvider c;
    public final MessageDao d;
    public final SchedulersFactory e;
    public final ChannelSyncOnPushAgent f;
    public final DatabaseErrorHandler g;

    public static final class a<T, R> implements Function<String, ObservableSource<? extends Boolean>> {
        public final /* synthetic */ AvitoMessengerKeepConnectionProvider a;

        public a(AvitoMessengerKeepConnectionProvider avitoMessengerKeepConnectionProvider) {
            this.a = avitoMessengerKeepConnectionProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Boolean> apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            if (!(str2.length() > 0)) {
                return Observable.just(Boolean.FALSE);
            }
            Observable<R> onErrorReturn = this.a.d.pendingMessageCount(str2).subscribeOn(this.a.e.io()).retryWhen(new a2.a.a.o1.c.a(this)).observeOn(this.a.e.computation()).map(b.a).onErrorReturn(c.a);
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "messageDao.pendingMessag… .onErrorReturn { false }");
            Observable<T> observeOn = this.a.a.observeOn(this.a.e.computation());
            Intrinsics.checkNotNullExpressionValue(observeOn, "foregroundState.observeO…schedulers.computation())");
            Observable<R> map = this.a.f.getStateObservable().map(d.a);
            Intrinsics.checkNotNullExpressionValue(map, "channelSyncOnPushAgent.s….hasUnprocessedRequests }");
            Observable combineLatest = Observable.combineLatest(onErrorReturn, observeOn, map, new AvitoMessengerKeepConnectionProvider$shouldKeepConnection$1$$special$$inlined$combineLatestWith$1());
            Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
            return combineLatest.distinctUntilChanged().switchMap(new a2.a.a.o1.c.g(this));
        }
    }

    public AvitoMessengerKeepConnectionProvider(@NotNull AccountStateProvider accountStateProvider, @NotNull MessageDao messageDao, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelSyncOnPushAgent channelSyncOnPushAgent, @NotNull DatabaseErrorHandler databaseErrorHandler) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messageDao, "messageDao");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelSyncOnPushAgent, "channelSyncOnPushAgent");
        Intrinsics.checkNotNullParameter(databaseErrorHandler, "errorHandler");
        this.c = accountStateProvider;
        this.d = messageDao;
        this.e = schedulersFactory;
        this.f = channelSyncOnPushAgent;
        this.g = databaseErrorHandler;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(false)");
        this.a = createDefault;
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override // ru.avito.messenger.KeepConnectionProvider
    @NotNull
    public Observable<Boolean> getShouldKeepConnection() {
        Observable<Boolean> switchMap = InteropKt.toV2(this.c.userId()).observeOn(this.e.computation()).distinctUntilChanged().switchMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(switchMap, "accountStateProvider.use…          }\n            }");
        return switchMap;
    }

    @VisibleForTesting
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onAppBackground$messenger_release() {
        this.a.accept(Boolean.FALSE);
    }

    @VisibleForTesting
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onAppForeground$messenger_release() {
        this.a.accept(Boolean.TRUE);
        this.b.set(true);
    }
}
