package com.avito.android.messenger.service.direct_reply;

import com.avito.android.messenger.R;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegate;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.notification.NotificationIdentifier;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJE\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegateImpl;", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate;", "", "channelId", "text", "Lcom/avito/android/remote/notification/NotificationIdentifier;", "notificationId", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate$NotificationController;", "controller", "", "isRetry", MessageBody.RANDOM_ID, "", "sendMessageAndReadChat", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/notification/NotificationIdentifier;Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate$NotificationController;ZLjava/lang/String;)V", "Lcom/avito/android/util/RandomKeyProvider;", "c", "Lcom/avito/android/util/RandomKeyProvider;", "randomIdProvider", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/RandomKeyProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DirectReplyServiceDelegateImpl implements DirectReplyServiceDelegate {
    public final DirectReplyServiceInteractor a;
    public final SchedulersFactory b;
    public final RandomKeyProvider c;

    public static final class a implements Action {
        public final /* synthetic */ DirectReplyServiceDelegate.NotificationController a;

        public a(DirectReplyServiceDelegate.NotificationController notificationController) {
            this.a = notificationController;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.showToast(R.string.messenger_direct_reply_successful);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ DirectReplyServiceDelegate.NotificationController a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(DirectReplyServiceDelegate.NotificationController notificationController, String str, String str2, String str3) {
            this.a = notificationController;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.showToast(R.string.messenger_direct_reply_failed);
            this.a.showFailureNotification(this.b, this.c, this.d);
        }
    }

    @Inject
    public DirectReplyServiceDelegateImpl(@NotNull DirectReplyServiceInteractor directReplyServiceInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(directReplyServiceInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "randomIdProvider");
        this.a = directReplyServiceInteractor;
        this.b = schedulersFactory;
        this.c = randomKeyProvider;
    }

    @Override // com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegate
    public void sendMessageAndReadChat(@NotNull String str, @Nullable String str2, @Nullable NotificationIdentifier notificationIdentifier, @NotNull DirectReplyServiceDelegate.NotificationController notificationController, boolean z, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(notificationController, "controller");
        if (!(str2 == null || m.isBlank(str2))) {
            if (str3 == null) {
                str3 = this.c.generateKey();
            }
            this.a.sendMessageAndReadChat(str, str2, z, str3).timeout(10000, TimeUnit.MILLISECONDS, this.b.computation()).observeOn(this.b.mainThread()).doOnComplete(new a(notificationController)).doOnError(new b(notificationController, str, str2, str3)).onErrorComplete().blockingAwait();
        }
        if (notificationIdentifier != null) {
            notificationController.cancelNotification(notificationIdentifier);
        }
    }
}
