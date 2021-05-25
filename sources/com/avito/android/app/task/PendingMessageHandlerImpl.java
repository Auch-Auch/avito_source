package com.avito.android.app.task;

import a2.a.a.j.a.a0;
import a2.a.a.j.a.b0;
import a2.a.a.j.a.c0;
import a2.a.a.j.a.e0;
import a2.a.a.j.a.g0;
import a2.a.a.j.a.h0;
import a2.a.a.j.a.i0;
import a2.a.a.j.a.r;
import a2.a.a.j.a.u;
import a2.a.a.j.a.v;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkType;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.MessageSendingException;
import com.avito.android.messenger.analytics.MessageType;
import com.avito.android.messenger.analytics.SendMessageAttemptEvent;
import com.avito.android.messenger.analytics.SendMessageFailEvent;
import com.avito.android.messenger.analytics.ServerConnectionType;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.google.firebase.messaging.Constants;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerConnection;
import ru.avito.messenger.MessengerState;
import ru.avito.messenger.internal.ConstantsKt;
import t6.n.d;
import t6.v.e;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B_\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010>\u001a\u00020:8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0010\u0010;\u001a\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/avito/android/app/task/PendingMessageHandlerImpl;", "Lcom/avito/android/app/task/PendingMessageHandler;", "Lio/reactivex/Scheduler;", "scheduler", "Lio/reactivex/Completable;", "startMessageHandling", "(Lio/reactivex/Scheduler;)Lio/reactivex/Completable;", "Lcom/avito/android/app/task/MessageSendingTracker;", "tracker", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "", "attemptsMade", "", "error", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/app/task/MessageSendingTracker;Lcom/avito/android/remote/model/messenger/message/LocalMessage;ILjava/lang/Throwable;)V", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "d", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "h", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/account/AccountStateProvider;", "c", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/app/task/MessageSendingTrackerFactory;", g.a, "Lcom/avito/android/app/task/MessageSendingTrackerFactory;", "sendingTrackerFactory", "Lcom/avito/android/analytics/NetworkTypeProvider;", "k", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/app/task/LocalMessageSender;", "e", "Lcom/avito/android/app/task/LocalMessageSender;", "messageSender", "Lru/avito/messenger/MessengerConnection;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/MessengerConnection;", "connection", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/server_time/TimeSource;", "f", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "Lkotlin/Lazy;", "getRetryTimeoutMs", "()J", "retryTimeoutMs", "Lcom/avito/android/Features;", "features", "<init>", "(Lru/avito/messenger/MessengerConnection;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/app/task/LocalMessageSender;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/app/task/MessageSendingTrackerFactory;Lcom/avito/android/communications_common/analytics/ErrorTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/NetworkTypeProvider;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PendingMessageHandlerImpl implements PendingMessageHandler {
    public final Lazy a;
    public final MessengerConnection b;
    public final AccountStateProvider c;
    public final MessageRepo d;
    public final LocalMessageSender e;
    public final TimeSource f;
    public final MessageSendingTrackerFactory g;
    public final ErrorTracker h;
    public final SchedulersFactory i;
    public final Analytics j;
    public final NetworkTypeProvider k;

    public static final class a extends Lambda implements Function0<Long> {
        public final /* synthetic */ PendingMessageHandlerImpl a;
        public final /* synthetic */ Features b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PendingMessageHandlerImpl pendingMessageHandlerImpl, Features features) {
            super(0);
            this.a = pendingMessageHandlerImpl;
            this.b = features;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            return Long.valueOf(PendingMessageHandlerImpl.access$getAutoRetryTimeoutMs$p(this.a, this.b));
        }
    }

    public static final class b<T, R> implements Function<String, CompletableSource> {
        public final /* synthetic */ PendingMessageHandlerImpl a;
        public final /* synthetic */ Scheduler b;

        public b(PendingMessageHandlerImpl pendingMessageHandlerImpl, Scheduler scheduler) {
            this.a = pendingMessageHandlerImpl;
            this.b = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            if (!(str2.length() > 0)) {
                return Completable.fromAction(b0.a);
            }
            Logs.verbose$default("PendingMessageHandler", "Started resending messages", null, 4, null);
            return this.a.d.observeFirstPendingMessage(str2).subscribeOn(this.b).observeOn(this.b).distinctUntilChanged(v.a).switchMapCompletable(new a0(this));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ PendingMessageHandlerImpl a;

        public c(PendingMessageHandlerImpl pendingMessageHandlerImpl) {
            this.a = pendingMessageHandlerImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ErrorTracker errorTracker = this.a.h;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            ErrorTracker.DefaultImpls.track$default(errorTracker, new MessageSendingFatalException("Message sending is broken", th2), null, null, 6, null);
        }
    }

    public PendingMessageHandlerImpl(@NotNull MessengerConnection messengerConnection, @NotNull AccountStateProvider accountStateProvider, @NotNull MessageRepo messageRepo, @NotNull LocalMessageSender localMessageSender, @NotNull TimeSource timeSource, @NotNull MessageSendingTrackerFactory messageSendingTrackerFactory, @NotNull ErrorTracker errorTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull NetworkTypeProvider networkTypeProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(messengerConnection, "connection");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(localMessageSender, "messageSender");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(messageSendingTrackerFactory, "sendingTrackerFactory");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = messengerConnection;
        this.c = accountStateProvider;
        this.d = messageRepo;
        this.e = localMessageSender;
        this.f = timeSource;
        this.g = messageSendingTrackerFactory;
        this.h = errorTracker;
        this.i = schedulersFactory;
        this.j = analytics;
        this.k = networkTypeProvider;
        this.a = t6.c.lazy(new a(this, features));
    }

    public static final long access$getAutoRetryTimeoutMs$p(PendingMessageHandlerImpl pendingMessageHandlerImpl, Features features) {
        Objects.requireNonNull(pendingMessageHandlerImpl);
        Long longOrNull = l.toLongOrNull(features.getMessengerAutoRetryMaxTimeout().invoke());
        if (longOrNull == null) {
            return ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS;
        }
        return e.coerceAtLeast(TimeUnit.SECONDS.toMillis(longOrNull.longValue()), 5000L);
    }

    public static final long access$getRetryTimeoutMs$p(PendingMessageHandlerImpl pendingMessageHandlerImpl) {
        return ((Number) pendingMessageHandlerImpl.a.getValue()).longValue();
    }

    public static final Completable access$markAsFailedWhenExpired(PendingMessageHandlerImpl pendingMessageHandlerImpl, LocalMessage localMessage, Scheduler scheduler) {
        MessageSendingTracker createTracker = pendingMessageHandlerImpl.g.createTracker(localMessage);
        long coerceAtLeast = e.coerceAtLeast((access$getRetryTimeoutMs$p(pendingMessageHandlerImpl) + MessengerTimestamp.toMillis(localMessage.created)) - pendingMessageHandlerImpl.f.now(), 0L);
        StringBuilder O = a2.b.a.a.a.O("Message will expire in ", coerceAtLeast, " ms: ");
        O.append(localMessage.localId);
        Logs.verbose$default("PendingMessageHandler", O.toString(), null, 4, null);
        Completable flatMapCompletable = Single.timer(coerceAtLeast, TimeUnit.MILLISECONDS, pendingMessageHandlerImpl.i.computation()).flatMapCompletable(new u(pendingMessageHandlerImpl, localMessage, scheduler, createTracker));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Single.timer(expirationT…          }\n            }");
        return flatMapCompletable;
    }

    public static final void access$trackSendAttempt(PendingMessageHandlerImpl pendingMessageHandlerImpl, LocalMessage localMessage) {
        MessageType messageType;
        ServerConnectionType serverConnectionType;
        Objects.requireNonNull(pendingMessageHandlerImpl);
        String networkType = pendingMessageHandlerImpl.k.networkType();
        Analytics analytics = pendingMessageHandlerImpl.j;
        String str = localMessage.channelId;
        MessageBody messageBody = localMessage.body;
        if ((messageBody instanceof MessageBody.ItemReference) || (messageBody instanceof MessageBody.Item)) {
            messageType = MessageType.ITEM;
        } else if ((messageBody instanceof MessageBody.LocalImage) || (messageBody instanceof MessageBody.ImageReference) || (messageBody instanceof MessageBody.ImageBody)) {
            messageType = MessageType.IMAGE;
        } else if (messageBody instanceof MessageBody.Link) {
            messageType = MessageType.LINK;
        } else if (messageBody instanceof MessageBody.Location) {
            messageType = MessageType.GEO;
        } else if (messageBody instanceof MessageBody.Text.Regular) {
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Text.Regular");
            if (((MessageBody.Text.Regular) messageBody).getSuggestedTemplates() != null) {
                messageType = MessageType.SUGGEST;
            } else {
                messageType = MessageType.TEXT;
            }
        } else if (messageBody instanceof MessageBody.File) {
            messageType = MessageType.FILE;
        } else if (!(messageBody instanceof MessageBody.Text.Reaction) && !(messageBody instanceof MessageBody.Call) && !(messageBody instanceof MessageBody.AppCall) && !(messageBody instanceof MessageBody.Deleted) && !(messageBody instanceof MessageBody.Unknown) && !(messageBody instanceof MessageBody.SystemMessageBody.Platform) && !(messageBody instanceof MessageBody.SystemMessageBody.Text) && !(messageBody instanceof MessageBody.SystemMessageBody.Unknown)) {
            throw new NoWhenBranchMatchedException();
        } else {
            messageType = MessageType.TEXT;
        }
        String str2 = localMessage.localId;
        boolean z = !Intrinsics.areEqual(networkType, NetworkType.CLASS_NONE.getStr());
        MessengerState blockingFirst = pendingMessageHandlerImpl.b.state().blockingFirst();
        if (Intrinsics.areEqual(blockingFirst, MessengerState.Connected.INSTANCE)) {
            serverConnectionType = ServerConnectionType.SOCKET;
        } else if (!(blockingFirst instanceof MessengerState.Connecting) && !(blockingFirst instanceof MessengerState.Disconnected)) {
            throw new NoWhenBranchMatchedException();
        } else {
            serverConnectionType = ServerConnectionType.NONE;
        }
        analytics.track(new SendMessageAttemptEvent(str, messageType, str2, z, networkType, serverConnectionType));
    }

    public static final void access$trackSendingStart(PendingMessageHandlerImpl pendingMessageHandlerImpl, MessageSendingTracker messageSendingTracker, LocalMessage localMessage, int i2) {
        Objects.requireNonNull(pendingMessageHandlerImpl);
        StringBuilder sb = new StringBuilder();
        sb.append("Started sending message attempt #");
        sb.append(i2);
        sb.append(": ");
        StringBuilder L = a2.b.a.a.a.L("LocalMessage(localId='");
        L.append(localMessage.localId);
        L.append("', remoteId='");
        L.append(localMessage.remoteId);
        L.append("', channelId='");
        L.append(localMessage.channelId);
        L.append("', fromId='");
        L.append(localMessage.fromId);
        L.append("')");
        sb.append(L.toString());
        Logs.debug$default("PendingMessageHandler", sb.toString(), null, 4, null);
        if (i2 == 1) {
            messageSendingTracker.trackSendingStarted();
        }
    }

    public static final void access$trackSendingSuccess(PendingMessageHandlerImpl pendingMessageHandlerImpl, MessageSendingTracker messageSendingTracker, LocalMessage localMessage, int i2) {
        Objects.requireNonNull(pendingMessageHandlerImpl);
        Logs.debug$default("PendingMessageHandler", "Message sent with attempt #" + i2 + ": " + localMessage.localId, null, 4, null);
        messageSendingTracker.trackSendingCompleted(i2, true);
    }

    public static final Completable access$trySendingMessage(PendingMessageHandlerImpl pendingMessageHandlerImpl, LocalMessage localMessage, Scheduler scheduler) {
        MessageSendingTracker createTracker = pendingMessageHandlerImpl.g.createTracker(localMessage);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        long coerceAtLeast = e.coerceAtLeast((access$getRetryTimeoutMs$p(pendingMessageHandlerImpl) + MessengerTimestamp.toMillis(localMessage.created)) - pendingMessageHandlerImpl.f.now(), 0L);
        StringBuilder O = a2.b.a.a.a.O("Message will expire in ", coerceAtLeast, " ms: ");
        O.append(localMessage.localId);
        Logs.verbose$default("PendingMessageHandler", O.toString(), null, 4, null);
        if (coerceAtLeast > 0) {
            Single<LocalMessage> doOnSubscribe = pendingMessageHandlerImpl.e.sendMessage(localMessage).doOnSubscribe(new c0(pendingMessageHandlerImpl, atomicInteger, createTracker, localMessage));
            Intrinsics.checkNotNullExpressionValue(doOnSubscribe, "messageSender.sendMessag…tempt()\n                }");
            Single<LocalMessage> retryWhen = doOnSubscribe.retryWhen(new r(pendingMessageHandlerImpl, atomicInteger, localMessage));
            Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …}\n            }\n        }");
            Completable onErrorResumeNext = retryWhen.timeout(coerceAtLeast, TimeUnit.MILLISECONDS, pendingMessageHandlerImpl.i.computation()).flatMapCompletable(new e0(pendingMessageHandlerImpl, createTracker, atomicInteger)).onErrorResumeNext(new g0(pendingMessageHandlerImpl, localMessage, createTracker, atomicInteger, scheduler));
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "messageSender.sendMessag…eduler)\n                }");
            return onErrorResumeNext;
        }
        Completable doFinally = pendingMessageHandlerImpl.d.markMessagesAsFailed(d.listOf(localMessage.localId)).subscribeOn(scheduler).observeOn(scheduler).doOnSubscribe(new h0(createTracker)).doFinally(new i0(pendingMessageHandlerImpl, createTracker, localMessage));
        Intrinsics.checkNotNullExpressionValue(doFinally, "messageRepo.markMessages…sage, attemptsMade = 0) }");
        return doFinally;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005b: APUT  
      (r5v1 kotlin.Pair[])
      (0 ??[int, short, byte, char])
      (wrap: kotlin.Pair : 0x0056: INVOKE  (r6v2 kotlin.Pair) = 
      (wrap: java.lang.String : ?: SGET   com.google.firebase.messaging.Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE java.lang.String)
      (r6v1 java.lang.String)
     type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public final void a(MessageSendingTracker messageSendingTracker, LocalMessage localMessage, int i2, Throwable th) {
        String str;
        boolean z = th != null ? th instanceof TimeoutException : true;
        ErrorTracker errorTracker = this.h;
        MessageSendingException messageSendingException = new MessageSendingException("Failed to send message", th);
        Pair[] pairArr = new Pair[4];
        MessageBody messageBody = localMessage.body;
        if (messageBody instanceof MessageBody.Text.Regular) {
            str = "text";
        } else if (messageBody instanceof MessageBody.Text.Reaction) {
            str = "text-reaction";
        } else if (messageBody instanceof MessageBody.Link) {
            str = "link";
        } else if (messageBody instanceof MessageBody.Item) {
            str = "item";
        } else if (messageBody instanceof MessageBody.LocalImage) {
            str = "image";
        } else if (messageBody instanceof MessageBody.Location) {
            str = "location";
        } else if (messageBody instanceof MessageBody.Call) {
            str = "call";
        } else {
            str = messageBody.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(str, "body.javaClass.name");
        }
        pairArr[0] = TuplesKt.to(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, str);
        pairArr[1] = TuplesKt.to("attemptsMade", Integer.valueOf(i2));
        pairArr[2] = TuplesKt.to("createdMs", Long.valueOf(MessengerTimestamp.toMillis(localMessage.created)));
        pairArr[3] = TuplesKt.to("isExpired", Boolean.valueOf(z));
        ErrorTracker.DefaultImpls.track$default(errorTracker, messageSendingException, null, t6.n.r.mapOf(pairArr), 2, null);
        if (z) {
            StringBuilder L = a2.b.a.a.a.L("Message expired: ");
            L.append(localMessage.localId);
            Logs.debug("PendingMessageHandler", L.toString(), th);
        } else {
            StringBuilder L2 = a2.b.a.a.a.L("Message sending failed: ");
            L2.append(localMessage.localId);
            Logs.debug("PendingMessageHandler", L2.toString(), th);
        }
        messageSendingTracker.trackSendingCompleted(i2, false);
        this.j.track(new SendMessageFailEvent(localMessage.channelId, localMessage.localId));
    }

    @Override // com.avito.android.app.task.PendingMessageHandler
    @NotNull
    public Completable startMessageHandling(@NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Completable onErrorComplete = InteropKt.toV2(this.c.userId()).observeOn(scheduler).distinctUntilChanged().switchMapCompletable(new b(this, scheduler)).retry(3).doOnError(new c(this)).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "accountStateProvider.use…       .onErrorComplete()");
        return onErrorComplete;
    }
}
