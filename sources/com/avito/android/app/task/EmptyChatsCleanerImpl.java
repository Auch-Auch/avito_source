package com.avito.android.app.task;

import a2.g.r.g;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.LogsT;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b%\u0010&B1\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b%\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/app/task/EmptyChatsCleanerImpl;", "Lcom/avito/android/app/task/EmptyChatsCleaner;", "", "startEmptyChatsCleanup", "()V", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Ljava/util/concurrent/TimeUnit;", "h", "Ljava/util/concurrent/TimeUnit;", "cutoffDurationUnit", "Lcom/avito/android/account/AccountStateProvider;", "c", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "e", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "channelRepo", "Lcom/avito/android/server_time/TimeSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", g.a, "J", "cutoffDuration", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;", "d", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;", "messageRepo", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/util/SchedulersFactory;JLjava/util/concurrent/TimeUnit;)V", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyChatsCleanerImpl implements EmptyChatsCleaner {
    public final CompositeDisposable a;
    public final TimeSource b;
    public final AccountStateProvider c;
    public final MessageRepoWriter d;
    public final ChannelRepo e;
    public final SchedulersFactory f;
    public final long g;
    public final TimeUnit h;

    public static final class a<T, R> implements Function<String, CompletableSource> {
        public final /* synthetic */ EmptyChatsCleanerImpl a;

        public a(EmptyChatsCleanerImpl emptyChatsCleanerImpl) {
            this.a = emptyChatsCleanerImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            EmptyChatsCleanerImpl emptyChatsCleanerImpl = this.a;
            long now = emptyChatsCleanerImpl.b.now();
            long convert = TimeUnit.MILLISECONDS.convert(emptyChatsCleanerImpl.g, emptyChatsCleanerImpl.h);
            long j = now - convert;
            long fromMillis = MessengerTimestamp.fromMillis(j);
            StringBuilder O = a2.b.a.a.a.O("calculateCutoffTimestamp(): \n                |   ", now, " = nowTimestamp\n                |   ");
            O.append(convert);
            a2.b.a.a.a.l1(O, " = cutoffDurationMs\n                |   ", j, " = cutoffTimestamp\n                |   ");
            LogsT.verbose$default("EmptyChatsCleaner", f.trimMargin$default(a2.b.a.a.a.l(O, fromMillis, " = cutoffTimestampConverted"), null, 1, null), null, 4, null);
            return this.a.e.getIdsOfEmptyChannelsOlderThanTimestamp(str2, fromMillis).observeOn(this.a.f.computation()).take(1).flatMapCompletable(new a2.a.a.j.a.f(this, str2));
        }
    }

    public static final class b implements Action {
        public static final b a = new b();

        @Override // io.reactivex.functions.Action
        public final void run() {
            LogsT.verbose$default("EmptyChatsCleaner", "cleanup successful!", null, 4, null);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            LogsT.error("EmptyChatsCleaner", "Error while cleaning up empty chats", th);
        }
    }

    public EmptyChatsCleanerImpl(@NotNull TimeSource timeSource, @NotNull AccountStateProvider accountStateProvider, @NotNull MessageRepoWriter messageRepoWriter, @NotNull ChannelRepo channelRepo, @NotNull SchedulersFactory schedulersFactory, long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messageRepoWriter, "messageRepo");
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(timeUnit, "cutoffDurationUnit");
        this.b = timeSource;
        this.c = accountStateProvider;
        this.d = messageRepoWriter;
        this.e = channelRepo;
        this.f = schedulersFactory;
        this.g = j;
        this.h = timeUnit;
        this.a = new CompositeDisposable();
    }

    public static final long access$calculateCutoffTimestamp(EmptyChatsCleanerImpl emptyChatsCleanerImpl) {
        Objects.requireNonNull(emptyChatsCleanerImpl);
        long now = emptyChatsCleanerImpl.b.now();
        long convert = TimeUnit.MILLISECONDS.convert(emptyChatsCleanerImpl.g, emptyChatsCleanerImpl.h);
        long j = now - convert;
        long fromMillis = MessengerTimestamp.fromMillis(j);
        StringBuilder O = a2.b.a.a.a.O("calculateCutoffTimestamp(): \n                |   ", now, " = nowTimestamp\n                |   ");
        O.append(convert);
        a2.b.a.a.a.l1(O, " = cutoffDurationMs\n                |   ", j, " = cutoffTimestamp\n                |   ");
        LogsT.verbose$default("EmptyChatsCleaner", f.trimMargin$default(a2.b.a.a.a.l(O, fromMillis, " = cutoffTimestampConverted"), null, 1, null), null, 4, null);
        return fromMillis;
    }

    public static final Completable access$deleteMessagesAndChannelsWithIds(EmptyChatsCleanerImpl emptyChatsCleanerImpl, String str, List list) {
        Objects.requireNonNull(emptyChatsCleanerImpl);
        if (!list.isEmpty()) {
            Completable andThen = emptyChatsCleanerImpl.d.deleteMessagesWithChannelIds(str, list).andThen(emptyChatsCleanerImpl.e.deleteChannelsById(str, list));
            Intrinsics.checkNotNullExpressionValue(andThen, "messageRepo.deleteMessag…, idsOfChannelsToDelete))");
            return andThen;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    @Override // com.avito.android.app.task.EmptyChatsCleaner
    public void startEmptyChatsCleanup() {
        this.a.clear();
        Observable<String> take = this.c.userId().filter(EmptyChatsCleanerImpl$startEmptyChatsCleanup$$inlined$firstNotBlankUserId$1.INSTANCE).take(1);
        Intrinsics.checkNotNullExpressionValue(take, "userId()\n        .filter…lank() }\n        .take(1)");
        Disposable subscribe = InteropKt.toV2(take).observeOn(this.f.computation()).flatMapCompletable(new a(this)).observeOn(this.f.computation()).subscribeOn(this.f.computation()).subscribe(b.a, c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.fir…          }\n            )");
        DisposableKt.addTo(subscribe, this.a);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public EmptyChatsCleanerImpl(@NotNull TimeSource timeSource, @NotNull AccountStateProvider accountStateProvider, @NotNull MessageRepoWriter messageRepoWriter, @NotNull ChannelRepo channelRepo, @NotNull SchedulersFactory schedulersFactory) {
        this(timeSource, accountStateProvider, messageRepoWriter, channelRepo, schedulersFactory, 29, TimeUnit.DAYS);
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messageRepoWriter, "messageRepo");
        Intrinsics.checkNotNullParameter(channelRepo, "channelRepo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
    }
}
