package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerHistory;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarker;", "", "", ChannelContext.Item.USER_ID, "channelId", "", "timestamp", "Lio/reactivex/Completable;", "markMessagesAsRead", "(Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Completable;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "repo", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/messenger/MessengerHistory;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/MessengerHistory;", "history", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lru/avito/messenger/MessengerHistory;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageIsReadMarker {
    public final MessageRepo a;
    public final MessengerHistory b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<Unit, CompletableSource> {
        public final /* synthetic */ MessageIsReadMarker a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public a(MessageIsReadMarker messageIsReadMarker, String str, String str2, long j) {
            this.a = messageIsReadMarker;
            this.b = str;
            this.c = str2;
            this.d = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.a.markIncomingMessagesAsReadInChannel(this.b, this.c, this.d).subscribeOn(this.a.c.io());
        }
    }

    @Inject
    public MessageIsReadMarker(@NotNull MessageRepo messageRepo, @NotNull MessengerHistory messengerHistory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(messageRepo, "repo");
        Intrinsics.checkNotNullParameter(messengerHistory, "history");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = messageRepo;
        this.b = messengerHistory;
        this.c = schedulersFactory;
    }

    @NotNull
    public final Completable markMessagesAsRead(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable flatMapCompletable = this.b.markChannelAsRead(str2, j).subscribeOn(this.c.computation()).observeOn(this.c.computation()).flatMapCompletable(new a(this, str, str2, j));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "history.markChannelAsRea…ulers.io())\n            }");
        return flatMapCompletable;
    }
}
