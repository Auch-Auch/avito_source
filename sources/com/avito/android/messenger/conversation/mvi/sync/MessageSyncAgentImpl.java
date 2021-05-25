package com.avito.android.messenger.conversation.mvi.sync;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.MessageSyncException;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.analytics.ShowFoundMessageEvent;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx.arrow.OptionKt;
import com.avito.android.util.rx3.InteropKt;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerEventObserver;
import ru.avito.messenger.MessengerHistory;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.ChatMessageUpdate;
import ru.avito.messenger.api.entity.event.ChatEvent;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
import ru.avito.messenger.api.entity.event.ReadMessageEvent;
import ru.avito.messenger.config.MessengerConfigProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010+\u001a\u00020\u0011\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010>\u001a\u00020\u000e\u0012\u0006\u0010K\u001a\u00020H¢\u0006\u0004\bX\u0010YBa\b\u0017\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010+\u001a\u00020\u0011\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010Z\u001a\u000204\u0012\u0006\u0010K\u001a\u00020H¢\u0006\u0004\bX\u0010[J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010Jc\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u001b*\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u000e0\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001d\u0010C\u001a\u00020?8B@\u0002X\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b1\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006\\"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgentImpl;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "", "subscribeToBackendNotifications", "()V", "", ChannelContext.Item.USER_ID, "channelId", "messageId", "searchQuery", "Lio/reactivex/Completable;", "syncLatestMessages", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lio/reactivex/Single;", "", "syncPreviousPageOfMessages", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Lru/avito/messenger/MessengerHistory;", "", "before", "after", "", "limitPages", "Lkotlin/Function1;", "", "Lru/avito/messenger/api/entity/ChatMessage;", "predicate", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "(Lru/avito/messenger/MessengerHistory;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/account/AccountStateProvider;", "d", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", a2.g.r.g.a, "Lru/avito/messenger/MessengerHistory;", "messengerHistory", "Lcom/avito/android/analytics/Analytics;", "l", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "errorTracker", "Lru/avito/messenger/config/MessengerConfigProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lru/avito/messenger/config/MessengerConfigProvider;", "configProvider", "Lcom/avito/android/messenger/MessengerEntityConverter;", "i", "Lcom/avito/android/messenger/MessengerEntityConverter;", "messengerEntityConverter", "n", "Z", "debounceMarkAsRead", "Lio/reactivex/Scheduler;", "c", "Lkotlin/Lazy;", "()Lio/reactivex/Scheduler;", "syncScheduler", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "e", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "repo", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "o", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "missingUsersSyncAgent", "Lcom/avito/android/messenger/conversation/mvi/sync/SyncJobsScheduler;", "k", "Lcom/avito/android/messenger/conversation/mvi/sync/SyncJobsScheduler;", "syncJobScheduler", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "h", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "messageBodyResolver", "Lru/avito/messenger/MessengerEventObserver;", "f", "Lru/avito/messenger/MessengerEventObserver;", "messengerEventObserver", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lru/avito/messenger/MessengerEventObserver;Lru/avito/messenger/MessengerHistory;Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/sync/SyncJobsScheduler;Lcom/avito/android/analytics/Analytics;Lru/avito/messenger/config/MessengerConfigProvider;ZLcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;)V", "messengerConfigProvider", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lru/avito/messenger/MessengerEventObserver;Lru/avito/messenger/MessengerHistory;Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/conversation/mvi/sync/SyncJobsScheduler;Lcom/avito/android/analytics/Analytics;Lru/avito/messenger/config/MessengerConfigProvider;Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageSyncAgentImpl implements MessageSyncAgent {
    public final MessengerErrorTracker a;
    public final CompositeDisposable b;
    public final Lazy c;
    public final AccountStateProvider d;
    public final MessageRepo e;
    public final MessengerEventObserver f;
    public final MessengerHistory g;
    public final MessageBodyResolver h;
    public final MessengerEntityConverter i;
    public final SchedulersFactory j;
    public final SyncJobsScheduler k;
    public final Analytics l;
    public final MessengerConfigProvider m;
    public final boolean n;
    public final MissingUsersSyncAgent o;

    public static final class a<T, R> implements Function<List<? extends ChatMessage>, ObservableSource<? extends List<? extends ChatMessage>>> {
        public final /* synthetic */ MessageSyncAgentImpl a;
        public final /* synthetic */ MessengerHistory b;
        public final /* synthetic */ Integer c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ String f;

        public a(MessageSyncAgentImpl messageSyncAgentImpl, MessengerHistory messengerHistory, Integer num, Function1 function1, Long l, String str) {
            this.a = messageSyncAgentImpl;
            this.b = messengerHistory;
            this.c = num;
            this.d = function1;
            this.e = l;
            this.f = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends ChatMessage>> apply(List<? extends ChatMessage> list) {
            Integer num;
            T t;
            List<? extends ChatMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messages");
            if (list2.size() < 100 || (((num = this.c) != null && num.intValue() == 0) || ((Boolean) this.d.invoke(list2)).booleanValue())) {
                return Observable.just(list2);
            }
            Integer num2 = this.c;
            Long l = null;
            Integer valueOf = num2 != null ? Integer.valueOf(num2.intValue() - 1) : null;
            Iterator<T> it = list2.iterator();
            if (!it.hasNext()) {
                t = null;
            } else {
                t = it.next();
                if (it.hasNext()) {
                    long created = t.getCreated();
                    do {
                        T next = it.next();
                        long created2 = next.getCreated();
                        if (created > created2) {
                            t = next;
                            created = created2;
                        }
                    } while (it.hasNext());
                }
            }
            T t2 = t;
            if (t2 != null) {
                l = Long.valueOf(t2.getCreated());
            }
            if (l != null) {
                long longValue = l.longValue();
                Long l2 = this.e;
                if (longValue > (l2 != null ? l2.longValue() : Long.MIN_VALUE)) {
                    return this.a.b(this.b, this.f, 1 + l.longValue(), this.e, valueOf, this.d).concatWith(Observable.just(list2));
                }
            }
            return Observable.just(list2);
        }
    }

    public static final class a0 extends Lambda implements Function0<Scheduler> {
        public final /* synthetic */ MessageSyncAgentImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(MessageSyncAgentImpl messageSyncAgentImpl) {
            super(0);
            this.a = messageSyncAgentImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Scheduler invoke() {
            return new SharedScheduler(this.a.j.io());
        }
    }

    public static final class b implements Action {
        public static final b a = new b();

        @Override // io.reactivex.functions.Action
        public final void run() {
            Logs.verbose$default("MessageSyncAgent", a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " Subscription to userId & events disposed"), null, 4, null);
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ MessageSyncAgentImpl a;
        public final /* synthetic */ Scheduler b;
        public final /* synthetic */ CompositeDisposable c;

        public c(MessageSyncAgentImpl messageSyncAgentImpl, Scheduler scheduler, CompositeDisposable compositeDisposable) {
            this.a = messageSyncAgentImpl;
            this.b = scheduler;
            this.c = compositeDisposable;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" Subscribed to userId & events: ");
            sb.append(str2);
            Logs.verbose$default("MessageSyncAgent", sb.toString(), null, 4, null);
            Intrinsics.checkNotNullExpressionValue(str2, ChannelContext.Item.USER_ID);
            if (str2.length() > 0) {
                MessageSyncAgentImpl.access$doSubscribeToBackendNotifications(this.a, str2, this.b, this.c);
            } else {
                this.c.clear();
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("MessageSyncAgent", a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " Subscription to userId & events has encountered an error"), th);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ MessageSyncAgentImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public e(MessageSyncAgentImpl messageSyncAgentImpl, String str, String str2) {
            this.a = messageSyncAgentImpl;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ErrorTracker.DefaultImpls.track$default(this.a.a, new MessageSyncException("Sync latest messages failed", th2), null, t6.n.r.mapOf(TuplesKt.to("channelId", this.b), TuplesKt.to(ChannelContext.Item.USER_ID, this.c)), 2, null);
            Logs.error("MessageSyncAgent", "Sync failed", th2);
        }
    }

    public static final class f<T> implements Consumer<Option<? extends Long>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public f(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Option<? extends Long> option) {
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" Last sync timestamp = ");
            sb.append(option);
            sb.append(" (");
            sb.append(this.a);
            sb.append(", ");
            Logs.verbose$default("MessageSyncAgent", a2.b.a.a.a.s(sb, this.b, ')'), null, 4, null);
        }
    }

    public static final class g<T, R> implements Function<Option<? extends Long>, ObservableSource<? extends List<? extends ChatMessage>>> {
        public final /* synthetic */ MessageSyncAgentImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public g(MessageSyncAgentImpl messageSyncAgentImpl, String str, String str2, String str3, String str4) {
            this.a = messageSyncAgentImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends ChatMessage>> apply(Option<? extends Long> option) {
            Observable<R> observable;
            Option<? extends Long> option2 = option;
            Intrinsics.checkNotNullParameter(option2, "timestampOption");
            if (option2 instanceof None) {
                observable = MessengerHistory.DefaultImpls.history$default(this.a.g, this.b, null, null, null, 14, null).toObservable().concatMap(new j2(0, this));
            } else if (option2 instanceof Some) {
                observable = this.a.m.getConfig().map(a2.a.a.o1.d.a0.n.x.a).flatMapObservable(new a2.a.a.o1.d.a0.n.w(((Number) ((Some) option2).getT()).longValue(), this)).toList().map(a2.a.a.o1.d.a0.n.y.a).toObservable().concatMap(new j2(1, this));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return observable.subscribeOn(this.a.a());
        }
    }

    public static final class j<T, R> implements Function<List<LocalMessage>, List<? extends LocalMessage>> {
        public static final j a = new j();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends LocalMessage> apply(List<LocalMessage> list) {
            List<LocalMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messages");
            List asReversedMutable = t6.n.i.asReversedMutable(list2);
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (T t : asReversedMutable) {
                if (hashSet.add(t.localId)) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
    }

    public static final class l<T> implements Consumer<List<? extends LocalMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public l(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends LocalMessage> list) {
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" Loaded ");
            sb.append(list.size());
            sb.append(" messages (");
            sb.append(this.a);
            sb.append(", ");
            Logs.verbose$default("MessageSyncAgent", a2.b.a.a.a.s(sb, this.b, ')'), null, 4, null);
        }
    }

    public static final class m<T, R> implements Function<List<? extends LocalMessage>, CompletableSource> {
        public final /* synthetic */ MessageSyncAgentImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public m(MessageSyncAgentImpl messageSyncAgentImpl, String str, String str2) {
            this.a = messageSyncAgentImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.avito.android.messenger.conversation.mvi.data.MessageRepo */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(List<? extends LocalMessage> list) {
            T t;
            Completable completable;
            List<? extends LocalMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "resolvedMessages");
            Iterator<T> it = list2.iterator();
            if (!it.hasNext()) {
                t = null;
            } else {
                t = it.next();
                if (it.hasNext()) {
                    long j = t.created;
                    do {
                        T next = it.next();
                        long j2 = next.created;
                        if (j < j2) {
                            t = next;
                            j = j2;
                        }
                    } while (it.hasNext());
                }
            }
            T t2 = t;
            Long valueOf = t2 != null ? Long.valueOf(t2.created) : null;
            Completable createMessages = this.a.e.createMessages(list2);
            if (valueOf != null) {
                Logs.verbose$default("MessageSyncAgent", "Saving new lastSyncedMessageTimestamp = " + valueOf, null, 4, null);
                completable = this.a.e.updateLastSyncedMessageTimestamp(this.b, this.c, valueOf.longValue());
            } else {
                Logs.verbose$default("MessageSyncAgent", "new lastSyncedMessageTimestamp = NULL => Nothing to save", null, 4, null);
                completable = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
            }
            Completable andThen = createMessages.andThen(completable);
            Completable fromAction = Completable.fromAction(new MessageSyncAgentImpl$loadIncompleteMessageBodies$1(this.a, this.b, this.c, null));
            Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…nelId, localId)\n        }");
            return andThen.andThen(fromAction).andThen(MessageSyncAgentImpl.access$syncMissingUsers(this.a, this.b, this.c, list2));
        }
    }

    public static final class n implements Action {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public n(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.f1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb, " Synced latest messages from server (");
            sb.append(this.a);
            sb.append(", ");
            Logs.debug$default("MessageSyncAgent", a2.b.a.a.a.s(sb, this.b, ')'), null, 4, null);
        }
    }

    public static final class o<V> implements Callable<Boolean> {
        public final /* synthetic */ AtomicBoolean a;

        public o(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(this.a.get());
        }
    }

    public static final class p<T> implements Consumer<Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public p(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" Synced previous page of messages from server, hasMorePages = ");
            sb.append(bool);
            sb.append(" (");
            sb.append(this.a);
            sb.append(", ");
            Logs.debug$default("MessageSyncAgent", a2.b.a.a.a.s(sb, this.b, ')'), null, 4, null);
        }
    }

    public static final class q<T> implements Consumer<Throwable> {
        public final /* synthetic */ MessageSyncAgentImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public q(MessageSyncAgentImpl messageSyncAgentImpl, String str, String str2) {
            this.a = messageSyncAgentImpl;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            ErrorTracker.DefaultImpls.track$default(this.a.a, new MessageSyncException("Sync previous messages failed", th), null, t6.n.r.mapOf(TuplesKt.to("channelId", this.b), TuplesKt.to(ChannelContext.Item.USER_ID, this.c)), 2, null);
        }
    }

    public static final class r<T> implements Consumer<Option<? extends Long>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public r(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Option<? extends Long> option) {
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" Oldest message timestamp in channel = ");
            sb.append(option);
            sb.append(" (");
            sb.append(this.a);
            sb.append(", ");
            Logs.verbose$default("MessageSyncAgent", a2.b.a.a.a.s(sb, this.b, ')'), null, 4, null);
        }
    }

    public static final class s<T, R> implements Function<Option<? extends Long>, SingleSource<? extends List<? extends ChatMessage>>> {
        public final /* synthetic */ MessageSyncAgentImpl a;
        public final /* synthetic */ String b;

        public s(MessageSyncAgentImpl messageSyncAgentImpl, String str) {
            this.a = messageSyncAgentImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends List<? extends ChatMessage>> apply(Option<? extends Long> option) {
            Single single;
            Option<? extends Long> option2 = option;
            Intrinsics.checkNotNullParameter(option2, "timestampOption");
            if (option2 instanceof None) {
                single = MessengerHistory.DefaultImpls.history$default(this.a.g, this.b, null, null, null, 14, null);
            } else if (option2 instanceof Some) {
                single = MessengerHistory.DefaultImpls.history$default(this.a.g, this.b, Long.valueOf(((Number) ((Some) option2).getT()).longValue() + 1), null, 100, 4, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return single.subscribeOn(this.a.a());
        }
    }

    public static final class t<T, R> implements Function<List<? extends ChatMessage>, List<? extends ChatMessage>> {
        public final /* synthetic */ AtomicBoolean a;

        public t(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends ChatMessage> apply(List<? extends ChatMessage> list) {
            List<? extends ChatMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "downloadedMessages");
            if (list2.size() == 100) {
                this.a.set(true);
            }
            return list2;
        }
    }

    public static final class w<T, R> implements Function<List<LocalMessage>, List<? extends LocalMessage>> {
        public static final w a = new w();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends LocalMessage> apply(List<LocalMessage> list) {
            List<LocalMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messages");
            List asReversedMutable = t6.n.i.asReversedMutable(list2);
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (T t : asReversedMutable) {
                if (hashSet.add(t.localId)) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
    }

    public static final class y<T> implements Consumer<List<? extends LocalMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public y(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends LocalMessage> list) {
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" Loaded ");
            sb.append(list.size());
            sb.append(" messages (");
            sb.append(this.a);
            sb.append(", ");
            Logs.verbose$default("MessageSyncAgent", a2.b.a.a.a.s(sb, this.b, ')'), null, 4, null);
        }
    }

    public static final class z<T, R> implements Function<List<? extends LocalMessage>, CompletableSource> {
        public final /* synthetic */ MessageSyncAgentImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public z(MessageSyncAgentImpl messageSyncAgentImpl, String str, String str2) {
            this.a = messageSyncAgentImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.messenger.conversation.mvi.data.MessageRepo */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(List<? extends LocalMessage> list) {
            List<? extends LocalMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messages");
            return this.a.e.createMessages(list2).andThen(MessageSyncAgentImpl.access$syncMissingUsers(this.a, this.b, this.c, list2));
        }
    }

    public MessageSyncAgentImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessageRepo messageRepo, @NotNull MessengerEventObserver messengerEventObserver, @NotNull MessengerHistory messengerHistory, @NotNull MessageBodyResolver messageBodyResolver, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull SyncJobsScheduler syncJobsScheduler, @NotNull Analytics analytics, @NotNull MessengerConfigProvider messengerConfigProvider, boolean z2, @NotNull MissingUsersSyncAgent missingUsersSyncAgent) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messageRepo, "repo");
        Intrinsics.checkNotNullParameter(messengerEventObserver, "messengerEventObserver");
        Intrinsics.checkNotNullParameter(messengerHistory, "messengerHistory");
        Intrinsics.checkNotNullParameter(messageBodyResolver, "messageBodyResolver");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(syncJobsScheduler, "syncJobScheduler");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(messengerConfigProvider, "configProvider");
        Intrinsics.checkNotNullParameter(missingUsersSyncAgent, "missingUsersSyncAgent");
        this.d = accountStateProvider;
        this.e = messageRepo;
        this.f = messengerEventObserver;
        this.g = messengerHistory;
        this.h = messageBodyResolver;
        this.i = messengerEntityConverter;
        this.j = schedulersFactory;
        this.k = syncJobsScheduler;
        this.l = analytics;
        this.m = messengerConfigProvider;
        this.n = z2;
        this.o = missingUsersSyncAgent;
        this.a = new MessengerErrorTracker(analytics);
        this.b = new CompositeDisposable();
        this.c = t6.c.lazy(new a0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [a2.a.a.o1.d.a0.n.a0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$doSubscribeToBackendNotifications(com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl r4, java.lang.String r5, io.reactivex.Scheduler r6, io.reactivex.disposables.CompositeDisposable r7) {
        /*
            ru.avito.messenger.MessengerEventObserver r0 = r4.f
            java.lang.Class<ru.avito.messenger.api.entity.event.ChatEvent> r1 = ru.avito.messenger.api.entity.event.ChatEvent.class
            io.reactivex.Observable r0 = r0.observeChatEvents(r1)
            io.reactivex.Observable r0 = r0.subscribeOn(r6)
            io.reactivex.Observable r6 = r0.observeOn(r6)
            a2.a.a.o1.d.a0.n.i r0 = new a2.a.a.o1.d.a0.n.i
            r0.<init>(r4, r5)
            io.reactivex.Completable r6 = r6.concatMapCompletable(r0)
            o r0 = new o
            r1 = 1
            r0.<init>(r1, r5)
            io.reactivex.Completable r6 = r6.doFinally(r0)
            a2.a.a.o1.d.a0.n.j r0 = new a2.a.a.o1.d.a0.n.j
            r0.<init>(r5)
            io.reactivex.Completable r6 = r6.doOnSubscribe(r0)
            o r0 = new o
            r2 = 2
            r0.<init>(r2, r5)
            q3 r2 = new q3
            r3 = 0
            r2.<init>(r3, r5)
            io.reactivex.disposables.Disposable r6 = r6.subscribe(r0, r2)
            java.lang.String r0 = "messengerEventObserver.o…          }\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            io.reactivex.rxkotlin.DisposableKt.addTo(r6, r7)
            com.avito.android.messenger.conversation.mvi.data.MessageRepo r6 = r4.e
            io.reactivex.Observable r6 = r6.getLatestReadLocallyMessage(r5)
            com.avito.android.util.SchedulersFactory r0 = r4.j
            io.reactivex.Scheduler r0 = r0.io()
            io.reactivex.Observable r6 = r6.subscribeOn(r0)
            com.avito.android.util.SchedulersFactory r0 = r4.j
            io.reactivex.Scheduler r0 = r0.computation()
            io.reactivex.Observable r6 = r6.observeOn(r0)
            java.lang.String r0 = "repo.getLatestReadLocall…schedulers.computation())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            io.reactivex.Observable r6 = com.avito.android.util.rx.arrow.OptionKt.filterDefined(r6)
            kotlin.reflect.KProperty1 r0 = a2.a.a.o1.d.a0.n.k.a
            if (r0 == 0) goto L_0x0071
            a2.a.a.o1.d.a0.n.a0 r2 = new a2.a.a.o1.d.a0.n.a0
            r2.<init>(r0)
            r0 = r2
        L_0x0071:
            io.reactivex.functions.Function r0 = (io.reactivex.functions.Function) r0
            io.reactivex.Observable r6 = r6.groupBy(r0)
            a2.a.a.o1.d.a0.n.m r0 = new a2.a.a.o1.d.a0.n.m
            r0.<init>(r4, r5)
            io.reactivex.Observable r4 = r6.flatMap(r0)
            a2.a.a.o1.d.a0.n.n r6 = a2.a.a.o1.d.a0.n.n.a
            q3 r0 = new q3
            r0.<init>(r1, r5)
            o r1 = new o
            r1.<init>(r3, r5)
            io.reactivex.disposables.Disposable r4 = r4.subscribe(r6, r0, r1)
            java.lang.String r5 = "repo.getLatestReadLocall…          }\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            io.reactivex.rxkotlin.DisposableKt.addTo(r4, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl.access$doSubscribeToBackendNotifications(com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl, java.lang.String, io.reactivex.Scheduler, io.reactivex.disposables.CompositeDisposable):void");
    }

    public static final String access$getType$p(MessageSyncAgentImpl messageSyncAgentImpl, ChatEvent chatEvent) {
        Objects.requireNonNull(messageSyncAgentImpl);
        if (chatEvent instanceof ChatMessage) {
            return "message";
        }
        if (chatEvent instanceof ChatMessageUpdate) {
            return "message_update";
        }
        if (chatEvent instanceof ReadChatEvent) {
            return "chat_read";
        }
        if (chatEvent instanceof ReadMessageEvent) {
            return "message_read";
        }
        StringBuilder L = a2.b.a.a.a.L("ignored:");
        L.append(chatEvent.getClass().getName());
        return L.toString();
    }

    public static final Completable access$handleChatMessage(MessageSyncAgentImpl messageSyncAgentImpl, ChatMessage chatMessage, String str, boolean z2) {
        Objects.requireNonNull(messageSyncAgentImpl);
        if (Intrinsics.areEqual(chatMessage.getUid(), str)) {
            Completable doOnComplete = Single.fromCallable(new a2.a.a.o1.d.a0.n.o(messageSyncAgentImpl, chatMessage)).doOnSuccess(a2.a.a.o1.d.a0.n.p.a).flatMapObservable(new a2.a.a.o1.d.a0.n.r(messageSyncAgentImpl, chatMessage, str, z2)).flatMapSingle(new a2.a.a.o1.d.a0.n.s(messageSyncAgentImpl)).flatMapCompletable(new a2.a.a.o1.d.a0.n.t(messageSyncAgentImpl, str, chatMessage)).doOnComplete(new a2.a.a.o1.d.a0.n.u(chatMessage));
            Intrinsics.checkNotNullExpressionValue(doOnComplete, "Single.fromCallable { me…      )\n                }");
            return doOnComplete;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    public static final Completable access$handleReadChatEvent(MessageSyncAgentImpl messageSyncAgentImpl, ReadChatEvent readChatEvent, String str) {
        Objects.requireNonNull(messageSyncAgentImpl);
        if (!Intrinsics.areEqual(readChatEvent.getFromId(), str)) {
            return messageSyncAgentImpl.e.markOutgoingMessagesAsReadInChannel(str, readChatEvent.getChannelId(), readChatEvent.timeStamp);
        }
        return messageSyncAgentImpl.e.markIncomingMessagesAsReadInChannel(str, readChatEvent.getChannelId(), readChatEvent.timeStamp);
    }

    public static final Completable access$handleReadMessageEvent(MessageSyncAgentImpl messageSyncAgentImpl, ReadMessageEvent readMessageEvent, String str) {
        return messageSyncAgentImpl.e.markMessagesAsRead(str, readMessageEvent.getMessageIds(), readMessageEvent.getTimeStamp());
    }

    public static final Observable access$loadAllLatestMessages(MessageSyncAgentImpl messageSyncAgentImpl, MessengerHistory messengerHistory, String str, long j2) {
        Objects.requireNonNull(messageSyncAgentImpl);
        Observable flatMapObservable = MessengerHistory.DefaultImpls.history$default(messengerHistory, str, null, Long.valueOf(j2), 100, 2, null).flatMapObservable(new Function<List<? extends ChatMessage>, ObservableSource<? extends List<? extends ChatMessage>>>(messengerHistory, j2, str) { // from class: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$loadAllLatestMessages$1
            public final /* synthetic */ MessengerHistory b;
            public final /* synthetic */ long c;
            public final /* synthetic */ String d;

            {
                this.b = r2;
                this.c = r3;
                this.d = r5;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ ObservableSource<? extends List<? extends ChatMessage>> apply(List<? extends ChatMessage> list) {
                return apply((List<ChatMessage>) list);
            }

            public final ObservableSource<? extends List<ChatMessage>> apply(@NotNull List<ChatMessage> list) {
                T t2;
                Intrinsics.checkNotNullParameter(list, "messages");
                if (list.size() < 100) {
                    return Observable.just(list);
                }
                Iterator<T> it = list.iterator();
                Long l2 = null;
                if (!it.hasNext()) {
                    t2 = null;
                } else {
                    t2 = it.next();
                    if (it.hasNext()) {
                        long created = t2.getCreated();
                        do {
                            T next = it.next();
                            long created2 = next.getCreated();
                            if (created > created2) {
                                t2 = next;
                                created = created2;
                            }
                        } while (it.hasNext());
                    }
                }
                T t3 = t2;
                if (t3 != null) {
                    l2 = Long.valueOf(t3.getCreated());
                }
                if (l2 == null || l2.longValue() <= this.c) {
                    return Observable.just(list);
                }
                return MessageSyncAgentImpl.c(MessageSyncAgentImpl.this, this.b, this.d, 1 + l2.longValue(), Long.valueOf(this.c), null, null, 24).concatWith(Observable.just(list));
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMapObservable, "history(channelId, after…          }\n            }");
        return flatMapObservable;
    }

    public static final Observable access$loadPreviousMessagesForSearch(MessageSyncAgentImpl messageSyncAgentImpl, MessengerHistory messengerHistory, String str, String str2, List list, String str3, String str4) {
        Object obj;
        Objects.requireNonNull(messageSyncAgentImpl);
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ChatMessage) obj).getId(), str3)) {
                break;
            }
        }
        if (obj != null) {
            messageSyncAgentImpl.l.track(new ShowFoundMessageEvent(str2, str3, str4, true, 1));
            Observable just = Observable.just(list);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(newMessages)");
            return just;
        }
        AtomicInteger atomicInteger = new AtomicInteger(1);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Observable<Option<LocalMessage>> take = messageSyncAgentImpl.e.getMessageWithRemoteId(str, str3).subscribeOn(messageSyncAgentImpl.a()).take(1);
        Intrinsics.checkNotNullExpressionValue(take, "repo.getMessageWithRemot…\n                .take(1)");
        Observable<R> startWith = OptionKt.filterEmpty(take).flatMap(new MessageSyncAgentImpl$loadPreviousMessagesForSearch$2(messageSyncAgentImpl, messengerHistory, str, str2, list, atomicInteger, atomicBoolean, str3, str4)).startWith((Observable<R>) list);
        Intrinsics.checkNotNullExpressionValue(startWith, "repo.getMessageWithRemot…  .startWith(newMessages)");
        return startWith;
    }

    public static final Completable access$syncMissingUsers(MessageSyncAgentImpl messageSyncAgentImpl, String str, String str2, List list) {
        Objects.requireNonNull(messageSyncAgentImpl);
        Completable fromCallable = Completable.fromCallable(new a2.a.a.o1.d.a0.n.z(messageSyncAgentImpl, str, str2, list));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…s\n            )\n        }");
        return fromCallable;
    }

    public static /* synthetic */ Observable c(MessageSyncAgentImpl messageSyncAgentImpl, MessengerHistory messengerHistory, String str, long j2, Long l2, Integer num, Function1 function1, int i2) {
        return messageSyncAgentImpl.b(messengerHistory, str, j2, (i2 & 4) != 0 ? null : l2, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? a2.a.a.o1.d.a0.n.v.a : function1);
    }

    public final Scheduler a() {
        return (Scheduler) this.c.getValue();
    }

    public final Observable<List<ChatMessage>> b(MessengerHistory messengerHistory, String str, long j2, Long l2, Integer num, Function1<? super List<ChatMessage>, Boolean> function1) {
        Observable<R> flatMapObservable = messengerHistory.history(str, Long.valueOf(j2), l2, 100).flatMapObservable(new a(this, messengerHistory, num, function1, l2, str));
        Intrinsics.checkNotNullExpressionValue(flatMapObservable, "history(channelId, befor…          }\n            }");
        return flatMapObservable;
    }

    @Override // com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent
    public void subscribeToBackendNotifications() {
        this.b.clear();
        Scheduler io2 = this.j.io();
        CompositeDisposable compositeDisposable = this.b;
        SharedScheduler sharedScheduler = new SharedScheduler(io2);
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        Disposable subscribe = InteropKt.toV2(this.d.userId()).observeOn(sharedScheduler).distinctUntilChanged().doFinally(b.a).subscribe(new c(this, sharedScheduler, new CompositeDisposable()), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.use…          }\n            )");
        DisposableKt.addTo(subscribe, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [a2.a.a.o1.d.a0.n.a0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Completable syncLatestMessages(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.Nullable java.lang.String r12) {
        /*
            r8 = this;
            java.lang.String r0 = "userId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "channelId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.avito.android.messenger.conversation.mvi.data.MessageRepo r0 = r8.e
            io.reactivex.Single r0 = r0.getLastSyncedMessageTimestamp(r9, r10)
            io.reactivex.Scheduler r1 = r8.a()
            io.reactivex.Single r0 = r0.subscribeOn(r1)
            io.reactivex.Scheduler r1 = r8.a()
            io.reactivex.Single r0 = r0.observeOn(r1)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$f r1 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$f
            r1.<init>(r10, r9)
            io.reactivex.Single r0 = r0.doOnSuccess(r1)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$g r7 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$g
            r1 = r7
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r9
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            io.reactivex.Observable r11 = r0.flatMapObservable(r7)
            io.reactivex.Scheduler r12 = r8.a()
            io.reactivex.Observable r11 = r11.observeOn(r12)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$h r12 = com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl.h.a
            if (r12 == 0) goto L_0x004a
            a2.a.a.o1.d.a0.n.a0 r0 = new a2.a.a.o1.d.a0.n.a0
            r0.<init>(r12)
            r12 = r0
        L_0x004a:
            io.reactivex.functions.Function r12 = (io.reactivex.functions.Function) r12
            io.reactivex.Observable r11 = r11.concatMap(r12)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$i r12 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$i
            com.avito.android.messenger.MessengerEntityConverter r0 = r8.i
            r12.<init>(r0)
            a2.a.a.o1.d.a0.n.a0 r0 = new a2.a.a.o1.d.a0.n.a0
            r0.<init>(r12)
            io.reactivex.Observable r11 = r11.map(r0)
            io.reactivex.Single r11 = r11.toList()
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$j r12 = com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl.j.a
            io.reactivex.Single r11 = r11.map(r12)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$k r12 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$k
            com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver r0 = r8.h
            r12.<init>(r0)
            a2.a.a.o1.d.a0.n.a0 r0 = new a2.a.a.o1.d.a0.n.a0
            r0.<init>(r12)
            io.reactivex.Single r11 = r11.flatMap(r0)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$l r12 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$l
            r12.<init>(r10, r9)
            io.reactivex.Single r11 = r11.doOnSuccess(r12)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$m r12 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$m
            r12.<init>(r8, r9, r10)
            io.reactivex.Completable r11 = r11.flatMapCompletable(r12)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$n r12 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$n
            r12.<init>(r10, r9)
            io.reactivex.Completable r11 = r11.doOnComplete(r12)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$e r12 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$e
            r12.<init>(r8, r10, r9)
            io.reactivex.Completable r9 = r11.doOnError(r12)
            java.lang.String r10 = "repo.getLastSyncedMessag…ed\", error)\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl.syncLatestMessages(java.lang.String, java.lang.String, java.lang.String, java.lang.String):io.reactivex.Completable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [a2.a.a.o1.d.a0.n.a0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Single<java.lang.Boolean> syncPreviousPageOfMessages(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "userId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "channelId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r1 = 0
            r0.<init>(r1)
            com.avito.android.messenger.conversation.mvi.data.MessageRepo r1 = r4.e
            io.reactivex.Single r1 = r1.getOldestMessageTimestampInChannel(r5, r6)
            io.reactivex.Scheduler r2 = r4.a()
            io.reactivex.Single r1 = r1.subscribeOn(r2)
            io.reactivex.Scheduler r2 = r4.a()
            io.reactivex.Single r1 = r1.observeOn(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$r r2 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$r
            r2.<init>(r6, r5)
            io.reactivex.Single r1 = r1.doOnSuccess(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$s r2 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$s
            r2.<init>(r4, r6)
            io.reactivex.Single r1 = r1.flatMap(r2)
            io.reactivex.Observable r1 = r1.toObservable()
            io.reactivex.Scheduler r2 = r4.a()
            io.reactivex.Observable r1 = r1.observeOn(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$t r2 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$t
            r2.<init>(r0)
            io.reactivex.Observable r1 = r1.map(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$u r2 = com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl.u.a
            if (r2 == 0) goto L_0x0057
            a2.a.a.o1.d.a0.n.a0 r3 = new a2.a.a.o1.d.a0.n.a0
            r3.<init>(r2)
            r2 = r3
        L_0x0057:
            io.reactivex.functions.Function r2 = (io.reactivex.functions.Function) r2
            io.reactivex.Observable r1 = r1.concatMap(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$v r2 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$v
            com.avito.android.messenger.MessengerEntityConverter r3 = r4.i
            r2.<init>(r3)
            a2.a.a.o1.d.a0.n.a0 r3 = new a2.a.a.o1.d.a0.n.a0
            r3.<init>(r2)
            io.reactivex.Observable r1 = r1.map(r3)
            io.reactivex.Single r1 = r1.toList()
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$w r2 = com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl.w.a
            io.reactivex.Single r1 = r1.map(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$x r2 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$x
            com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver r3 = r4.h
            r2.<init>(r3)
            a2.a.a.o1.d.a0.n.a0 r3 = new a2.a.a.o1.d.a0.n.a0
            r3.<init>(r2)
            io.reactivex.Single r1 = r1.flatMap(r3)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$y r2 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$y
            r2.<init>(r6, r5)
            io.reactivex.Single r1 = r1.doOnSuccess(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$z r2 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$z
            r2.<init>(r4, r5, r6)
            io.reactivex.Completable r1 = r1.flatMapCompletable(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$o r2 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$o
            r2.<init>(r0)
            io.reactivex.Single r0 = r1.toSingle(r2)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$p r1 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$p
            r1.<init>(r6, r5)
            io.reactivex.Single r0 = r0.doOnSuccess(r1)
            com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$q r1 = new com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl$q
            r1.<init>(r4, r6, r5)
            io.reactivex.Single r5 = r0.doOnError(r1)
            java.lang.String r6 = "repo.getOldestMessageTim…          )\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl.syncPreviousPageOfMessages(java.lang.String, java.lang.String):io.reactivex.Single");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public MessageSyncAgentImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessageRepo messageRepo, @NotNull MessengerEventObserver messengerEventObserver, @NotNull MessengerHistory messengerHistory, @NotNull MessageBodyResolver messageBodyResolver, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull SyncJobsScheduler syncJobsScheduler, @NotNull Analytics analytics, @NotNull MessengerConfigProvider messengerConfigProvider, @NotNull MissingUsersSyncAgent missingUsersSyncAgent) {
        this(accountStateProvider, messageRepo, messengerEventObserver, messengerHistory, messageBodyResolver, messengerEntityConverter, schedulersFactory, syncJobsScheduler, analytics, messengerConfigProvider, true, missingUsersSyncAgent);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messageRepo, "repo");
        Intrinsics.checkNotNullParameter(messengerEventObserver, "messengerEventObserver");
        Intrinsics.checkNotNullParameter(messengerHistory, "messengerHistory");
        Intrinsics.checkNotNullParameter(messageBodyResolver, "messageBodyResolver");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(syncJobsScheduler, "syncJobScheduler");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(messengerConfigProvider, "messengerConfigProvider");
        Intrinsics.checkNotNullParameter(missingUsersSyncAgent, "missingUsersSyncAgent");
    }
}
