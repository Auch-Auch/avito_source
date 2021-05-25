package com.avito.android.messenger.map.search;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BN\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0004\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000b\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nR!\u0010\u0010\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchInteractorImpl;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "", "query", "", "getSearchSuggests", "(Ljava/lang/String;)V", "onCleared", "()V", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", VKApiConst.Q, "Lru/avito/messenger/MessengerClient;", "client", "o", "Ljava/lang/String;", "channelId", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "p", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "Ljava/util/concurrent/atomic/AtomicLong;", "n", "Ljava/util/concurrent/atomic/AtomicLong;", "requestId", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "itemLocation", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GeoSearchInteractorImpl extends BaseMviEntityWithMutatorsRelay<GeoSearchInteractor.State> implements GeoSearchInteractor {
    public final CompositeDisposable m;
    public final AtomicLong n = new AtomicLong(0);
    public final String o;
    public final GeoPoint p;
    public final MessengerClient<AvitoMessengerApi> q;

    public static final class a<T> implements Predicate<String> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            return str2.length() > 0;
        }
    }

    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ GeoSearchInteractorImpl a;
        public final /* synthetic */ GeoPoint b;

        public b(GeoSearchInteractorImpl geoSearchInteractorImpl, GeoPoint geoPoint) {
            this.a = geoSearchInteractorImpl;
            this.b = geoPoint;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            Relay mutatorsRelay = this.a.getMutatorsRelay();
            Intrinsics.checkNotNullExpressionValue(str2, ChannelContext.Item.USER_ID);
            mutatorsRelay.accept(new LoadFavoritePlacesMutator(str2, this.a.o, this.b, this.a.q));
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GeoSearchInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(GeoSearchInteractorImpl geoSearchInteractorImpl, String str, long j) {
            super(0);
            this.a = geoSearchInteractorImpl;
            this.b = str;
            this.c = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getMutatorsRelay().accept(new DoLoadSearchSuggestsMutator(this.a.o, this.b, this.a.p, this.a.q, this.c));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public GeoSearchInteractorImpl(@NotNull AccountStateProvider accountStateProvider, @Named("channel_id") @NotNull String str, @Named("item_location") @Nullable GeoPoint geoPoint, @Named("center_point") @Nullable GeoPoint geoPoint2, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull SchedulersFactory schedulersFactory) {
        super("GeoSearchInteractor", GeoSearchInteractor.State.Companion.getDEFAULT(), schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.o = str;
        this.p = geoPoint2;
        this.q = messengerClient;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.m = compositeDisposable;
        Disposable subscribe = InteropKt.toV2(accountStateProvider.userId()).observeOn(schedulersFactory.io()).filter(a.a).subscribe(new b(this, geoPoint));
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.use…          )\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchInteractor
    public void getSearchSuggests(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        long andIncrement = this.n.getAndIncrement();
        Relay mutatorsRelay = getMutatorsRelay();
        LoadSearchSuggestsMutator loadSearchSuggestsMutator = new LoadSearchSuggestsMutator(andIncrement, new c(this, str, andIncrement));
        mutatorsRelay.accept(new MutatorSingle(loadSearchSuggestsMutator.getName(), new GeoSearchInteractorImpl$getSearchSuggests$$inlined$plusAssign$1(loadSearchSuggestsMutator)));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.m.clear();
        super.onCleared();
    }
}
