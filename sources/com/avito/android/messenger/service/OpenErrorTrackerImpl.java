package com.avito.android.messenger.service;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.ChatListOpenError;
import com.avito.android.messenger.analytics.ChatOpenError;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoReader;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Completable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/service/OpenErrorTrackerImpl;", "Lcom/avito/android/messenger/service/OpenErrorTracker;", "", "channelId", "case", "Lio/reactivex/Completable;", "trackChatOpenError", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "trackChatListOpenError", "()Lio/reactivex/Completable;", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;", "messageRepo", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OpenErrorTrackerImpl implements OpenErrorTracker {
    public final AccountStateProvider a;
    public final MessageRepoReader b;
    public final Analytics c;

    public static final class a<T, R> implements Function<String, SingleSource<? extends Long>> {
        public final /* synthetic */ OpenErrorTrackerImpl a;

        public a(OpenErrorTrackerImpl openErrorTrackerImpl) {
            this.a = openErrorTrackerImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Long> apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            return this.a.b.getMessageCount(str2);
        }
    }

    public static final class b<T> implements Consumer<Long> {
        public final /* synthetic */ OpenErrorTrackerImpl a;

        public b(OpenErrorTrackerImpl openErrorTrackerImpl) {
            this.a = openErrorTrackerImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Long l) {
            this.a.c.track(new ChatListOpenError(l.longValue() > 0));
        }
    }

    public static final class c<T, R> implements Function<String, SingleSource<? extends Long>> {
        public final /* synthetic */ OpenErrorTrackerImpl a;
        public final /* synthetic */ String b;

        public c(OpenErrorTrackerImpl openErrorTrackerImpl, String str) {
            this.a = openErrorTrackerImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Long> apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            return this.a.b.getMessageCount(str2, this.b);
        }
    }

    public static final class d<T> implements Consumer<Long> {
        public final /* synthetic */ OpenErrorTrackerImpl a;
        public final /* synthetic */ String b;

        public d(OpenErrorTrackerImpl openErrorTrackerImpl, String str) {
            this.a = openErrorTrackerImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Long l) {
            this.a.c.track(new ChatOpenError(l.longValue() > 0, this.b));
        }
    }

    @Inject
    public OpenErrorTrackerImpl(@NotNull AccountStateProvider accountStateProvider, @NotNull MessageRepoReader messageRepoReader, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messageRepoReader, "messageRepo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = accountStateProvider;
        this.b = messageRepoReader;
        this.c = analytics;
    }

    @Override // com.avito.android.messenger.service.OpenErrorTracker
    @NotNull
    public Completable trackChatListOpenError() {
        Completable ignoreElement = InteropKt.toV2(this.a.currentUserId()).flatMapSingle(new a(this)).doOnSuccess(new b(this)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "accountStateProvider.cur…         .ignoreElement()");
        return ignoreElement;
    }

    @Override // com.avito.android.messenger.service.OpenErrorTracker
    @NotNull
    public Completable trackChatOpenError(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "case");
        Completable ignoreElement = InteropKt.toV2(this.a.currentUserId()).flatMapSingle(new c(this, str)).doOnSuccess(new d(this, str2)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "accountStateProvider.cur…         .ignoreElement()");
        return ignoreElement;
    }
}
