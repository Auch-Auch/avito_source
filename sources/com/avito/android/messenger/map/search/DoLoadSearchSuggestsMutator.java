package com.avito.android.messenger.map.search;

import a2.g.r.g;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggests;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B<\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u00110\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR!\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u00110\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/map/search/DoLoadSearchSuggestsMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "oldState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;)Lio/reactivex/Single;", "", g.a, "J", "requestId", "", "c", "Ljava/lang/String;", "channelId", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "f", "Lru/avito/messenger/MessengerClient;", "client", "d", "query", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "e", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Lru/avito/messenger/MessengerClient;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DoLoadSearchSuggestsMutator extends MutatorSingle<GeoSearchInteractor.State> {
    public final String c;
    public final String d;
    public final GeoPoint e;
    public final MessengerClient<AvitoMessengerApi> f;
    public final long g;

    public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends GeoSearchSuggests>> {
        public final /* synthetic */ DoLoadSearchSuggestsMutator a;

        public a(DoLoadSearchSuggestsMutator doLoadSearchSuggestsMutator) {
            this.a = doLoadSearchSuggestsMutator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends GeoSearchSuggests> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.getGeoSearchSuggests(this.a.c, this.a.d, this.a.e);
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
            return GeoSearchInteractor.State.copy$default(this.a, null, new Loading.Success(geoSearchSuggests2.component1()), 1, null);
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
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return GeoSearchInteractor.State.copy$default(this.a, null, new Loading.Error(th2), 1, null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoLoadSearchSuggestsMutator(@NotNull String str, @NotNull String str2, @Nullable GeoPoint geoPoint, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, long j) {
        super("DoLoadSearchSuggestsMutator(requestId = " + j + ", query = " + str2 + ')');
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "query");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        this.c = str;
        this.d = str2;
        this.e = geoPoint;
        this.f = messengerClient;
        this.g = j;
    }

    @NotNull
    public Single<GeoSearchInteractor.State> invoke(@NotNull GeoSearchInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        if (!(state.getSearchSuggests() instanceof Loading.InProgress) || ((Loading.InProgress) state.getSearchSuggests()).getId() != this.g) {
            return Singles.toSingle(state);
        }
        Single<R> onErrorReturn = this.f.withMessengerApi().flatMap(new a(this)).map(new b(state)).onErrorReturn(new c(state));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "client.withMessengerApi(…      )\n                }");
        return onErrorReturn;
    }
}
