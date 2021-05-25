package com.avito.android.advert_core.messenger;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.Channel;
import ru.avito.messenger.api.entity.context.ChannelContext;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractorImpl;", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Single;", "", "notifySellerAboutCall", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "source", "Lru/avito/messenger/api/entity/Channel;", "createChat", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lru/avito/messenger/api/AvitoMessengerApi;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/api/AvitoMessengerApi;", "messengerApi", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lru/avito/messenger/api/AvitoMessengerApi;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertMessengerInteractorImpl implements AdvertMessengerInteractor {
    public final AvitoMessengerApi a;
    public final AccountStateProvider b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<Boolean, SingleSource<? extends Channel>> {
        public final /* synthetic */ AdvertMessengerInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(AdvertMessengerInteractorImpl advertMessengerInteractorImpl, String str, String str2) {
            this.a = advertMessengerInteractorImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Channel> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (bool2.booleanValue()) {
                return InteropKt.toV3(this.a.a.createChat(this.b, this.c)).subscribeOn(this.a.c.io());
            }
            return Single.error(new UnauthorizedException());
        }
    }

    public static final class b<T, R> implements Function<Channel, SingleSource<? extends Boolean>> {
        public final /* synthetic */ AdvertMessengerInteractorImpl a;

        public b(AdvertMessengerInteractorImpl advertMessengerInteractorImpl) {
            this.a = advertMessengerInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Boolean> apply(Channel channel) {
            Channel channel2 = channel;
            String channelId = channel2.getChannelId();
            ChannelContext context = channel2.getContext();
            String str = null;
            if (!(context instanceof ChannelContext.Item)) {
                context = null;
            }
            ChannelContext.Item item = (ChannelContext.Item) context;
            if (item != null) {
                str = item.getUserId();
            }
            if (str != null) {
                return InteropKt.toV3(this.a.a.sendCallMessage(channelId, str)).map(a2.a.a.g.i.a.a);
            }
            return Single.just(Boolean.FALSE);
        }
    }

    @Inject
    public AdvertMessengerInteractorImpl(@NotNull AvitoMessengerApi avitoMessengerApi, @NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(avitoMessengerApi, "messengerApi");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = avitoMessengerApi;
        this.b = accountStateProvider;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.advert_core.messenger.AdvertMessengerInteractor
    @NotNull
    public Single<Channel> createChat(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Single<R> flatMap = this.b.currentAuthorized().flatMap(new a(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "accountStateProvider.cur…          }\n            }");
        return flatMap;
    }

    @Override // com.avito.android.advert_core.messenger.AdvertMessengerInteractor
    @NotNull
    public Single<Boolean> notifySellerAboutCall(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.e2(this.c, createChat(str, null).observeOn(this.c.io()).flatMap(new b(this)), "createChat(advertId, nul…scribeOn(schedulers.io())");
    }
}
