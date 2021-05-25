package com.avito.android.messenger.map.search;

import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggests;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B4\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u0011\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR!\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/map/search/LoadFavoritePlacesMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;)Lio/reactivex/Single;", "", "c", "Ljava/lang/String;", ChannelContext.Item.USER_ID, "d", "channelId", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "e", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "itemLocation", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "f", "Lru/avito/messenger/MessengerClient;", "client", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Lru/avito/messenger/MessengerClient;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LoadFavoritePlacesMutator extends MutatorSingle<GeoSearchInteractor.State> {
    public final String c;
    public final String d;
    public final GeoPoint e;
    public final MessengerClient<AvitoMessengerApi> f;

    public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends GeoSearchSuggests>> {
        public final /* synthetic */ LoadFavoritePlacesMutator a;

        public a(LoadFavoritePlacesMutator loadFavoritePlacesMutator) {
            this.a = loadFavoritePlacesMutator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends GeoSearchSuggests> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.getFavoritePlaces(this.a.c, this.a.d, this.a.e, null);
        }
    }

    public static final class b<T, R> implements Function<GeoSearchSuggests, GeoSearchInteractor.State> {
        public final /* synthetic */ GeoSearchInteractor.State a;

        public b(GeoSearchInteractor.State state) {
            this.a = state;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public GeoSearchInteractor.State apply(GeoSearchSuggests geoSearchSuggests) {
            GeoSearchSuggests geoSearchSuggests2 = geoSearchSuggests;
            Intrinsics.checkNotNullParameter(geoSearchSuggests2, "<name for destructuring parameter 0>");
            return GeoSearchInteractor.State.copy$default(this.a, geoSearchSuggests2.component1(), null, 2, null);
        }
    }

    public static final class c<T, R> implements Function<Throwable, GeoSearchInteractor.State> {
        public final /* synthetic */ GeoSearchInteractor.State a;

        public c(GeoSearchInteractor.State state) {
            this.a = state;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public GeoSearchInteractor.State apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return this.a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadFavoritePlacesMutator(@NotNull String str, @NotNull String str2, @Nullable GeoPoint geoPoint, @NotNull MessengerClient<AvitoMessengerApi> messengerClient) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        this.c = str;
        this.d = str2;
        this.e = geoPoint;
        this.f = messengerClient;
    }

    @NotNull
    public Single<GeoSearchInteractor.State> invoke(@NotNull GeoSearchInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        Single<R> onErrorReturn = this.f.withMessengerApi().flatMap(new a(this)).map(new b(state)).onErrorReturn(new c(state));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "client.withMessengerApi(…nErrorReturn { oldState }");
        return onErrorReturn;
    }
}
