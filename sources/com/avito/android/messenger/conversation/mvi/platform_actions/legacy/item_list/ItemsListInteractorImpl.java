package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.RawJsonKt;
import com.avito.android.remote.model.messenger.context_actions.RecommendationsResponse;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractor;", "", "methodName", "Lcom/avito/android/remote/model/RawJson;", "params", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/context_actions/RecommendationsResponse;", "getItems", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;)Lio/reactivex/Single;", "callApiMethod", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/Observable;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getReconnects", "()Lio/reactivex/Observable;", "reconnects", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ItemsListInteractorImpl implements ItemsListInteractor {
    @NotNull
    public final Observable<Unit> a;
    public final MessengerClient<AvitoMessengerApi> b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends RawJson>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ RawJson b;

        public a(String str, RawJson rawJson) {
            this.a = str;
            this.b = rawJson;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends RawJson> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.callMethod(this.a, RawJsonKt.orEmpty(this.b));
        }
    }

    public static final class b<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends RecommendationsResponse>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ RawJson b;

        public b(String str, RawJson rawJson) {
            this.a = str;
            this.b = rawJson;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends RecommendationsResponse> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.getRecommendations(this.a, RawJsonKt.orEmpty(this.b));
        }
    }

    public static final class c<T, R> implements Function<Boolean, Unit> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ItemsListInteractorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = messengerClient;
        this.c = schedulersFactory;
        Observable<R> map = messengerClient.allReconnects().debounce(500, TimeUnit.MILLISECONDS, schedulersFactory.computation()).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "client.allReconnects()\n …())\n        .map { Unit }");
        this.a = map;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListInteractor
    @NotNull
    public Single<RawJson> callApiMethod(@NotNull String str, @Nullable RawJson rawJson) {
        Intrinsics.checkNotNullParameter(str, "methodName");
        Single<R> flatMap = this.b.withMessengerApi().flatMap(new a(str, rawJson));
        Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…          )\n            }");
        return flatMap;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListInteractor
    @NotNull
    public Single<RecommendationsResponse> getItems(@NotNull String str, @Nullable RawJson rawJson) {
        Intrinsics.checkNotNullParameter(str, "methodName");
        Single<R> flatMap = this.b.withMessengerApi().flatMap(new b(str, rawJson));
        Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…          )\n            }");
        return flatMap;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListInteractor
    @NotNull
    public Observable<Unit> getReconnects() {
        return this.a;
    }
}
