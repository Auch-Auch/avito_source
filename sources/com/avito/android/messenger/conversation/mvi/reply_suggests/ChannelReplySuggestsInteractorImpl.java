package com.avito.android.messenger.conversation.mvi.reply_suggests;

import arrow.core.Either;
import arrow.core.EitherKt;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R.\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsInteractor;", "Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", AuthSource.SEND_ABUSE, "Lhu/akarnokd/rxjava2/schedulers/SharedScheduler;", "scheduler", "Lio/reactivex/Observable;", "Larrow/core/Either;", "", "", "", "getReplySuggests", "()Lio/reactivex/Observable;", "replySuggests", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "c", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "channelContextInteractor", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "d", "Lru/avito/messenger/MessengerClient;", "client", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "channelId", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelReplySuggestsInteractorImpl implements ChannelReplySuggestsInteractor {
    public final SharedScheduler a;
    public final String b;
    public final ChannelContextInteractor c;
    public final MessengerClient<AvitoMessengerApi> d;

    public static final class a<T1, T2> implements BiPredicate<ChannelContextInteractor.State, ChannelContextInteractor.State> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiPredicate
        public boolean test(ChannelContextInteractor.State state, ChannelContextInteractor.State state2) {
            ChannelContextInteractor.State state3 = state;
            ChannelContextInteractor.State state4 = state2;
            Intrinsics.checkNotNullParameter(state3, "prevState");
            Intrinsics.checkNotNullParameter(state4, "curState");
            return state3 == state4;
        }
    }

    public static final class b<T, R> implements Function<ChannelContextInteractor.State, Boolean> {
        public final /* synthetic */ ChannelReplySuggestsInteractorImpl a;

        public b(ChannelReplySuggestsInteractorImpl channelReplySuggestsInteractorImpl) {
            this.a = channelReplySuggestsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(ChannelContextInteractor.State state) {
            ChannelContextInteractor.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            return Boolean.valueOf(ChannelReplySuggestsInteractorImpl.access$getShouldLoadReplySuggests$p(this.a, state2));
        }
    }

    public static final class c<T, R> implements Function<Boolean, SingleSource<? extends Either<? extends Throwable, ? extends List<? extends String>>>> {
        public final /* synthetic */ ChannelReplySuggestsInteractorImpl a;

        public c(ChannelReplySuggestsInteractorImpl channelReplySuggestsInteractorImpl) {
            this.a = channelReplySuggestsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Either<? extends Throwable, ? extends List<? extends String>>> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "shouldLoadReplySuggests");
            if (bool2.booleanValue()) {
                Single<R> map = this.a.d.withMessengerApi().flatMap(new a2.a.a.o1.d.a0.l.a(this)).map(new a2.a.a.o1.d.a0.l.b(this));
                Intrinsics.checkNotNullExpressionValue(map, "client.withMessengerApi(…                        }");
                return map;
            }
            Either right = EitherKt.right(CollectionsKt__CollectionsKt.emptyList());
            Objects.requireNonNull(right, "null cannot be cast to non-null type arrow.core.Either<kotlin.Throwable, kotlin.collections.List<kotlin.String>>");
            Single just = Single.just(right);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(\n           …                        )");
            return just;
        }
    }

    public static final class d<T, R> implements Function<Throwable, Either<? extends Throwable, ? extends List<? extends String>>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Either<? extends Throwable, ? extends List<? extends String>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return EitherKt.left(th2);
        }
    }

    public ChannelReplySuggestsInteractorImpl(@NotNull String str, @NotNull ChannelContextInteractor channelContextInteractor, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(channelContextInteractor, "channelContextInteractor");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = str;
        this.c = channelContextInteractor;
        this.d = messengerClient;
        this.a = new SharedScheduler(schedulersFactory.io());
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean access$getShouldLoadReplySuggests$p(com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractorImpl r4, com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor.State r5) {
        /*
            java.util.Objects.requireNonNull(r4)
            com.avito.android.messenger.channels.mvi.common.Loading r4 = r5.getChannelState()
            boolean r0 = r4 instanceof com.avito.android.messenger.channels.mvi.common.Loading.Success
            r1 = 0
            if (r0 != 0) goto L_0x000d
            r4 = r1
        L_0x000d:
            com.avito.android.messenger.channels.mvi.common.Loading$Success r4 = (com.avito.android.messenger.channels.mvi.common.Loading.Success) r4
            if (r4 == 0) goto L_0x0018
            java.lang.Object r4 = r4.getValue()
            com.avito.android.remote.model.messenger.Channel r4 = (com.avito.android.remote.model.messenger.Channel) r4
            goto L_0x0019
        L_0x0018:
            r4 = r1
        L_0x0019:
            r0 = 0
            r2 = 1
            if (r4 == 0) goto L_0x006d
            boolean r3 = r4.isAnswered()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x006d
            com.avito.android.remote.model.messenger.InputState r3 = r4.getInputState()
            if (r3 == 0) goto L_0x0030
            boolean r3 = r3.isDisabled()
            if (r3 == r2) goto L_0x003c
        L_0x0030:
            com.avito.android.remote.model.messenger.InputState r3 = r4.getInputState()
            if (r3 != 0) goto L_0x003e
            com.avito.android.remote.model.messenger.ReadOnlyState r3 = r4.getReadOnlyState()
            if (r3 == 0) goto L_0x003e
        L_0x003c:
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            if (r3 != 0) goto L_0x006d
            java.lang.String r5 = r5.getCurrentUserId()
            int r3 = r5.length()
            if (r3 <= 0) goto L_0x004d
            r3 = 1
            goto L_0x004e
        L_0x004d:
            r3 = 0
        L_0x004e:
            if (r3 == 0) goto L_0x0069
            com.avito.android.remote.model.messenger.context.ChannelContext r4 = r4.getContext()
            boolean r3 = r4 instanceof com.avito.android.remote.model.messenger.context.ChannelContext.Item
            if (r3 != 0) goto L_0x0059
            r4 = r1
        L_0x0059:
            com.avito.android.remote.model.messenger.context.ChannelContext$Item r4 = (com.avito.android.remote.model.messenger.context.ChannelContext.Item) r4
            if (r4 == 0) goto L_0x0061
            java.lang.String r1 = r4.getUserId()
        L_0x0061:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            if (r4 == 0) goto L_0x0069
            r4 = 1
            goto L_0x006a
        L_0x0069:
            r4 = 0
        L_0x006a:
            if (r4 == 0) goto L_0x006d
            r0 = 1
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractorImpl.access$getShouldLoadReplySuggests$p(com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractorImpl, com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor$State):boolean");
    }

    public static final boolean access$isSeller(ChannelReplySuggestsInteractorImpl channelReplySuggestsInteractorImpl, String str, Channel channel) {
        Objects.requireNonNull(channelReplySuggestsInteractorImpl);
        if (!(str.length() > 0)) {
            return false;
        }
        ChannelContext context = channel.getContext();
        String str2 = null;
        if (!(context instanceof ChannelContext.Item)) {
            context = null;
        }
        ChannelContext.Item item = (ChannelContext.Item) context;
        if (item != null) {
            str2 = item.getUserId();
        }
        return Intrinsics.areEqual(str, str2);
    }

    @Override // com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractor
    @NotNull
    public Observable<Either<Throwable, List<String>>> getReplySuggests() {
        Observable<Either<Throwable, List<String>>> onErrorReturn = this.c.getStateObservable().observeOn(this.a).distinctUntilChanged(a.a).map(new b(this)).distinctUntilChanged().switchMapSingle(new c(this)).onErrorReturn(d.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "channelContextInteractor…{ error -> error.left() }");
        return onErrorReturn;
    }
}
