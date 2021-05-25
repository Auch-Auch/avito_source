package com.avito.android.messenger.service;

import com.avito.android.MessengerWorkFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.event.BlacklistInfo;
import ru.avito.messenger.api.entity.event.BlacklistRemoveEvent;
import ru.avito.messenger.api.entity.event.ChatClearEvent;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
import ru.avito.messenger.api.entity.event.ReadMessageEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B-\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/service/UnreadChatsCounterSyncAgentImpl;", "Lcom/avito/android/messenger/service/UnreadChatsCounterSyncAgent;", "", "subscribeToCounterUpdates", "()V", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "c", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/account/AccountStateProvider;", "d", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/MessengerWorkFactory;", "e", "Lcom/avito/android/MessengerWorkFactory;", "workFactory", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "updateTriggers", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/MessengerWorkFactory;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UnreadChatsCounterSyncAgentImpl implements UnreadChatsCounterSyncAgent {
    public final Relay<Unit> a = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
    public final CompositeDisposable b = new CompositeDisposable();
    public final MessengerClient<AvitoMessengerApi> c;
    public final AccountStateProvider d;
    public final MessengerWorkFactory e;
    public final SchedulersFactory f;

    /* compiled from: java-style lambda group */
    public static final class a implements Action {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            int i = this.a;
            if (i == 0) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                sb2.append('[');
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(']');
                sb.append(sb2.toString());
                sb.append(" Subscription to userId & events disposed");
                Logs.verbose$default("UnreadChatsCounterSyncAgent", sb.toString(), null, 4, null);
            } else if (i == 1) {
                StringBuilder sb3 = new StringBuilder();
                StringBuilder sb4 = new StringBuilder();
                sb4.append('[');
                Thread currentThread2 = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
                sb4.append(currentThread2.getName());
                sb4.append(']');
                sb3.append(sb4.toString());
                sb3.append(" Subscription to userId & events completed");
                Logs.verbose$default("UnreadChatsCounterSyncAgent", sb3.toString(), null, 4, null);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ UnreadChatsCounterSyncAgentImpl a;

        public b(UnreadChatsCounterSyncAgentImpl unreadChatsCounterSyncAgentImpl) {
            this.a = unreadChatsCounterSyncAgentImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.e.enqueueUpdateUnreadMessagesCountWork();
        }
    }

    public static final class c<T, R> implements Function<String, ObservableSource<? extends Object>> {
        public final /* synthetic */ UnreadChatsCounterSyncAgentImpl a;

        public c(UnreadChatsCounterSyncAgentImpl unreadChatsCounterSyncAgentImpl) {
            this.a = unreadChatsCounterSyncAgentImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: io.reactivex.Observable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Object> apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" Subscribed to userId & events: ");
            sb.append(str2);
            Logs.verbose$default("UnreadChatsCounterSyncAgent", sb.toString(), null, 4, null);
            if (!(str2.length() > 0)) {
                return Observable.just(Unit.INSTANCE);
            }
            UnreadChatsCounterSyncAgentImpl unreadChatsCounterSyncAgentImpl = this.a;
            Scheduler computation = unreadChatsCounterSyncAgentImpl.f.computation();
            Observable merge = Observable.merge(unreadChatsCounterSyncAgentImpl.c.reconnects().observeOn(computation), unreadChatsCounterSyncAgentImpl.c.observeChatEvents(Object.class).observeOn(computation).filter(new UnreadChatsCounterSyncAgentImpl$handleEvents$1(unreadChatsCounterSyncAgentImpl, str2)));
            Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(\n      …pdate(userId) }\n        )");
            return merge.startWith((Observable) Unit.INSTANCE);
        }
    }

    public static final class d<T> implements Consumer<Object> {
        public final /* synthetic */ UnreadChatsCounterSyncAgentImpl a;

        public d(UnreadChatsCounterSyncAgentImpl unreadChatsCounterSyncAgentImpl) {
            this.a = unreadChatsCounterSyncAgentImpl;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object obj) {
            this.a.a.accept(Unit.INSTANCE);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("UnreadChatsCounterSyncAgent", a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " Subscription to userId & events has encountered an error"), th);
        }
    }

    public UnreadChatsCounterSyncAgentImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull AccountStateProvider accountStateProvider, @NotNull MessengerWorkFactory messengerWorkFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerWorkFactory, "workFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.c = messengerClient;
        this.d = accountStateProvider;
        this.e = messengerWorkFactory;
        this.f = schedulersFactory;
    }

    public static final Observable access$handleEvents(UnreadChatsCounterSyncAgentImpl unreadChatsCounterSyncAgentImpl, String str, Scheduler scheduler) {
        Objects.requireNonNull(unreadChatsCounterSyncAgentImpl);
        Observable merge = Observable.merge(unreadChatsCounterSyncAgentImpl.c.reconnects().observeOn(scheduler), unreadChatsCounterSyncAgentImpl.c.observeChatEvents(Object.class).observeOn(scheduler).filter(new UnreadChatsCounterSyncAgentImpl$handleEvents$1(unreadChatsCounterSyncAgentImpl, str)));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(\n      …pdate(userId) }\n        )");
        return merge;
    }

    public static final boolean access$shouldTriggerUpdate(UnreadChatsCounterSyncAgentImpl unreadChatsCounterSyncAgentImpl, Object obj, String str) {
        Objects.requireNonNull(unreadChatsCounterSyncAgentImpl);
        if (obj instanceof ChatMessage) {
            return true ^ Intrinsics.areEqual(((ChatMessage) obj).getFromId(), str);
        }
        if (!(obj instanceof ReadChatEvent) && !(obj instanceof ReadMessageEvent) && !(obj instanceof ChatClearEvent) && !(obj instanceof BlacklistInfo) && !(obj instanceof BlacklistRemoveEvent)) {
            return false;
        }
        return true;
    }

    @Override // com.avito.android.messenger.service.UnreadChatsCounterSyncAgent
    public void subscribeToCounterUpdates() {
        this.b.clear();
        Disposable subscribe = this.a.throttleLatest(3000, TimeUnit.MILLISECONDS, this.f.computation(), true).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "updateTriggers.throttleL…readMessagesCountWork() }");
        DisposableKt.addTo(subscribe, this.b);
        Disposable subscribe2 = InteropKt.toV2(this.d.userId()).observeOn(this.f.computation()).distinctUntilChanged().switchMap(new c(this)).doFinally(a.b).subscribe(new d(this), e.a, a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "accountStateProvider.use…          }\n            )");
        DisposableKt.addTo(subscribe2, this.b);
    }
}
