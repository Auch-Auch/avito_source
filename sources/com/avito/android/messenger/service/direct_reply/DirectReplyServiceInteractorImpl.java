package com.avito.android.messenger.service.direct_reply;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.NetworkType;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.messenger.analytics.MessageType;
import com.avito.android.messenger.analytics.SendMessageAttemptEvent;
import com.avito.android.messenger.analytics.SendMessageEvent;
import com.avito.android.messenger.analytics.ServerConnectionType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\b\u0007\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractorImpl;", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractor;", "", "channelId", "text", "", "isRetry", MessageBody.RANDOM_ID, "Lio/reactivex/Completable;", "sendMessageAndReadChat", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/Completable;", "Lcom/avito/android/analytics/NetworkTypeProvider;", "e", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/messenger/api/AvitoMessengerApi;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/api/AvitoMessengerApi;", "fallbackApi", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/server_time/TimeSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lru/avito/messenger/MessengerClient;", "client", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/NetworkTypeProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DirectReplyServiceInteractorImpl implements DirectReplyServiceInteractor {
    public final AvitoMessengerApi a;
    public final TimeSource b;
    public final SchedulersFactory c;
    public final Analytics d;
    public final NetworkTypeProvider e;

    public static final class a implements Action {
        public final /* synthetic */ DirectReplyServiceInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(DirectReplyServiceInteractorImpl directReplyServiceInteractorImpl, String str, String str2) {
            this.a = directReplyServiceInteractorImpl;
            this.b = str;
            this.c = str2;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            ServerConnectionType serverConnectionType;
            String networkType = this.a.e.networkType();
            Analytics analytics = this.a.d;
            String str = this.b;
            MessageType messageType = MessageType.TEXT;
            String str2 = this.c;
            NetworkType networkType2 = NetworkType.CLASS_NONE;
            boolean z = !Intrinsics.areEqual(networkType, networkType2.getStr());
            if (!Intrinsics.areEqual(networkType, networkType2.getStr())) {
                serverConnectionType = ServerConnectionType.FALLBACK;
            } else {
                serverConnectionType = ServerConnectionType.NONE;
            }
            analytics.track(new SendMessageAttemptEvent(str, messageType, str2, z, networkType, serverConnectionType));
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ DirectReplyServiceInteractorImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(DirectReplyServiceInteractorImpl directReplyServiceInteractorImpl, boolean z, String str, String str2) {
            this.a = directReplyServiceInteractorImpl;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Event event;
            Analytics analytics = this.a.d;
            if (this.b) {
                event = new SendMessageEvent.Retry(this.c, MessageType.TEXT, this.d, true);
            } else {
                event = new SendMessageEvent.Send(this.c, MessageType.TEXT, true);
            }
            analytics.track(event);
        }
    }

    @Inject
    public DirectReplyServiceInteractorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull TimeSource timeSource, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull NetworkTypeProvider networkTypeProvider) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        this.b = timeSource;
        this.c = schedulersFactory;
        this.d = analytics;
        this.e = networkTypeProvider;
        this.a = messengerClient.getFallbackApi();
    }

    @Override // com.avito.android.messenger.service.direct_reply.DirectReplyServiceInteractor
    @NotNull
    public Completable sendMessageAndReadChat(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "channelId", str2, "text", str3, MessageBody.RANDOM_ID);
        Completable subscribeOn = Completable.fromAction(new a(this, str, str3)).andThen(this.a.sendTextMessage(str, str3, str2, null).ignoreElement()).doOnComplete(new b(this, z, str, str3)).andThen(this.a.markChannelAsRead(str, MessengerTimestamp.fromMillis(this.b.now())).ignoreElement().onErrorComplete().subscribeOn(this.c.io())).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Completable.fromAction {…scribeOn(schedulers.io())");
        return subscribeOn;
    }
}
