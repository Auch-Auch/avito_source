package com.avito.android.tariff.count.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.TariffCountPriceResult;
import com.avito.android.remote.model.TariffCountResult;
import com.avito.android.tariff.StringProvider;
import com.avito.android.tariff.count.item.CountItem;
import com.avito.android.tariff.count.item.CountItemPresenter;
import com.avito.android.tariff.count.item.bonus.BonusItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010/\u001a\u00020\n\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010f\u001a\u00020c\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010P\u001a\u00020\u001f¢\u0006\u0004\bw\u0010xJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u00020\u00032\u0014\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00180\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010\u0005R&\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020+0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010'R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00102\u001a\b\u0012\u0004\u0012\u00020+0$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0%0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010'R\"\u0010F\u001a\b\u0012\u0004\u0012\u00020\n0<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010>\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u00105R\u0016\u0010J\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u00105R \u0010K\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010'R\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020L0<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010>R\u0016\u0010P\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020U0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010'R\"\u0010Z\u001a\b\u0012\u0004\u0012\u00020L0<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bX\u0010>\u001a\u0004\bY\u0010ER\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010gR(\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0%0i8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\"\u0010q\u001a\b\u0012\u0004\u0012\u00020U0$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bo\u0010'\u001a\u0004\bp\u0010)R\u0016\u0010s\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u00105R(\u0010v\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bt\u0010'\u001a\u0004\bu\u0010)¨\u0006y"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModelImpl;", "Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModel;", "Landroidx/lifecycle/ViewModel;", "", "d", "()V", "Lcom/avito/android/tariff/count/item/CountItem;", "countItem", a2.g.r.g.a, "(Lcom/avito/android/tariff/count/item/CountItem;)V", "", "countId", "Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;", "cost", "e", "(Ljava/lang/String;Lcom/avito/android/tariff/count/viewmodel/TariffCountCost;)V", "", "Lcom/avito/conveyor_item/Item;", "list", "f", "(Ljava/util/List;)V", "c", "(Ljava/util/List;)Lcom/avito/android/tariff/count/item/CountItem;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "onSelectButtonClick", "onRetryButtonClick", "onCleared", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "onViewCreated", "onDestroyView", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "o", "Landroidx/lifecycle/MutableLiveData;", "getProgressChanges", "()Landroidx/lifecycle/MutableLiveData;", "progressChanges", "Lcom/avito/android/tariff/count/viewmodel/PricePanelState;", "pricePanelStateChangesLiveData", VKApiConst.VERSION, "Ljava/lang/String;", "checkoutContext", VKApiConst.Q, "getPricePanelStateChanges", "pricePanelStateChanges", "Lio/reactivex/disposables/Disposable;", "l", "Lio/reactivex/disposables/Disposable;", "clickSubscription", "listChangesLiveData", "Lcom/avito/android/tariff/count/viewmodel/TariffCountConverter;", "x", "Lcom/avito/android/tariff/count/viewmodel/TariffCountConverter;", "converter", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "h", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "messagesLiveData", "Lcom/avito/android/tariff/count/viewmodel/Price;", "j", "priceChangesLiveData", "s", "getMessageEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "messageEvents", AuthSource.OPEN_CHANNEL_LIST, "selectSubscription", "k", "loadingSubscription", "progressChangesLiveData", "Lcom/avito/android/deep_linking/links/DeepLink;", "routingEventsLiveData", "B", "Lcom/avito/android/util/Kundle;", "savedState", "Lcom/avito/android/tariff/StringProvider;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/tariff/StringProvider;", "stringProvider", "", "i", "loadingEventsLiveData", "p", "getRoutingEvents", "routingEvents", "Lcom/avito/android/tariff/count/viewmodel/TariffCountRepository;", "w", "Lcom/avito/android/tariff/count/viewmodel/TariffCountRepository;", "repository", "Lcom/avito/android/tariff/count/viewmodel/PriceConverter;", "y", "Lcom/avito/android/tariff/count/viewmodel/PriceConverter;", "priceConverter", "Lcom/avito/android/util/SchedulersFactory;", "z", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Ljava/util/List;", "items", "Landroidx/lifecycle/LiveData;", "u", "Landroidx/lifecycle/LiveData;", "getPriceChanges", "()Landroidx/lifecycle/LiveData;", "priceChanges", "t", "getLoadingEvents", "loadingEvents", "n", "priceSubscription", "r", "getListChanges", "listChanges", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/count/viewmodel/TariffCountRepository;Lcom/avito/android/tariff/count/viewmodel/TariffCountConverter;Lcom/avito/android/tariff/count/viewmodel/PriceConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/tariff/StringProvider;Lcom/avito/android/util/Kundle;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountViewModelImpl extends ViewModel implements TariffCountViewModel {
    public final StringProvider A;
    public final Kundle B;
    public List<? extends Item> c = CollectionsKt__CollectionsKt.emptyList();
    public final MutableLiveData<LoadingState<?>> d;
    public final SingleLiveEvent<DeepLink> e;
    public final MutableLiveData<PricePanelState> f;
    public final MutableLiveData<List<Item>> g;
    public final SingleLiveEvent<String> h;
    public final MutableLiveData<Boolean> i;
    public final MutableLiveData<LoadingState<Price>> j;
    public Disposable k;
    public Disposable l;
    public Disposable m;
    public Disposable n;
    @NotNull
    public final MutableLiveData<LoadingState<?>> o;
    @NotNull
    public final SingleLiveEvent<DeepLink> p;
    @NotNull
    public final MutableLiveData<PricePanelState> q;
    @NotNull
    public final MutableLiveData<List<Item>> r;
    @NotNull
    public final SingleLiveEvent<String> s;
    @NotNull
    public final MutableLiveData<Boolean> t;
    @NotNull
    public final LiveData<LoadingState<Price>> u;
    public final String v;
    public final TariffCountRepository w;
    public final TariffCountConverter x;
    public final PriceConverter y;
    public final SchedulersFactory z;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<CountItem> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(CountItem countItem) {
            int i = this.a;
            if (i == 0) {
                CountItem countItem2 = countItem;
                Intrinsics.checkNotNullExpressionValue(countItem2, "it");
                TariffCountViewModelImpl.access$postItemsWithoutBonus((TariffCountViewModelImpl) this.b, countItem2);
            } else if (i == 1) {
                CountItem countItem3 = countItem;
                Intrinsics.checkNotNullExpressionValue(countItem3, "it");
                ((TariffCountViewModelImpl) this.b).g(countItem3);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super TariffCountResult>> {
        public final /* synthetic */ TariffCountViewModelImpl a;

        public b(TariffCountViewModelImpl tariffCountViewModelImpl) {
            this.a = tariffCountViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super TariffCountResult> loadingState) {
            LoadingState<? super TariffCountResult> loadingState2 = loadingState;
            TariffCountViewModelImpl tariffCountViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            TariffCountViewModelImpl.access$handleLoadingState(tariffCountViewModelImpl, loadingState2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ TariffCountViewModelImpl a;

        public c(TariffCountViewModelImpl tariffCountViewModelImpl) {
            this.a = tariffCountViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.d.setValue(new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(this.a.A.getUnknownError())));
        }
    }

    public static final class d<T> implements Consumer<CountItem> {
        public final /* synthetic */ TariffCountViewModelImpl a;

        public d(TariffCountViewModelImpl tariffCountViewModelImpl) {
            this.a = tariffCountViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(CountItem countItem) {
            this.a.j.setValue(LoadingState.Loading.INSTANCE);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public static final class f extends Lambda implements Function1<Item, Item> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(TariffCountViewModelImpl tariffCountViewModelImpl, String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Item invoke(Item item) {
            Item item2 = item;
            Intrinsics.checkNotNullParameter(item2, "it");
            return item2 instanceof CountItem ? CountItem.copy$default((CountItem) item2, null, null, null, null, false, Intrinsics.areEqual(item2.getStringId(), this.a), 31, null) : item2;
        }
    }

    public static final class g<T> implements Consumer<LoadingState<? super DeepLinkResponse>> {
        public final /* synthetic */ TariffCountViewModelImpl a;

        public g(TariffCountViewModelImpl tariffCountViewModelImpl) {
            this.a = tariffCountViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super DeepLinkResponse> loadingState) {
            LoadingState<? super DeepLinkResponse> loadingState2 = loadingState;
            TariffCountViewModelImpl tariffCountViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            TariffCountViewModelImpl.access$handleRegionSelectionResponse(tariffCountViewModelImpl, loadingState2);
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ TariffCountViewModelImpl a;

        public h(TariffCountViewModelImpl tariffCountViewModelImpl) {
            this.a = tariffCountViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.h.postValue(this.a.A.getUnknownError());
        }
    }

    public static final class i<T> implements Predicate<LoadingState<? super TariffCountPriceResult>> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(LoadingState<? super TariffCountPriceResult> loadingState) {
            LoadingState<? super TariffCountPriceResult> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return loadingState2 instanceof LoadingState.Loaded;
        }
    }

    public static final class j<T, R> implements Function<LoadingState<? super TariffCountPriceResult>, LoadingState.Loaded<TariffCountPriceResult>> {
        public static final j a = new j();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState.Loaded<TariffCountPriceResult> apply(LoadingState<? super TariffCountPriceResult> loadingState) {
            LoadingState<? super TariffCountPriceResult> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return (LoadingState.Loaded) loadingState2;
        }
    }

    public static final class k<T, R> implements Function<LoadingState.Loaded<TariffCountPriceResult>, TariffCountCost> {
        public final /* synthetic */ TariffCountViewModelImpl a;

        public k(TariffCountViewModelImpl tariffCountViewModelImpl) {
            this.a = tariffCountViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public TariffCountCost apply(LoadingState.Loaded<TariffCountPriceResult> loaded) {
            LoadingState.Loaded<TariffCountPriceResult> loaded2 = loaded;
            Intrinsics.checkNotNullParameter(loaded2, "it");
            return this.a.y.convertPrice(loaded2.getData());
        }
    }

    public static final class l<T> implements Consumer<Disposable> {
        public final /* synthetic */ TariffCountViewModelImpl a;

        public l(TariffCountViewModelImpl tariffCountViewModelImpl) {
            this.a = tariffCountViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.j.setValue(LoadingState.Loading.INSTANCE);
        }
    }

    public static final class m<T> implements Consumer<TariffCountCost> {
        public final /* synthetic */ TariffCountViewModelImpl a;
        public final /* synthetic */ CountItem b;

        public m(TariffCountViewModelImpl tariffCountViewModelImpl, CountItem countItem) {
            this.a = tariffCountViewModelImpl;
            this.b = countItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(TariffCountCost tariffCountCost) {
            TariffCountCost tariffCountCost2 = tariffCountCost;
            TariffCountViewModelImpl tariffCountViewModelImpl = this.a;
            String stringId = this.b.getStringId();
            Intrinsics.checkNotNullExpressionValue(tariffCountCost2, "cost");
            tariffCountViewModelImpl.e(stringId, tariffCountCost2);
        }
    }

    public static final class n<T> implements Consumer<Throwable> {
        public static final n a = new n();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public TariffCountViewModelImpl(@NotNull String str, @NotNull TariffCountRepository tariffCountRepository, @NotNull TariffCountConverter tariffCountConverter, @NotNull PriceConverter priceConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull StringProvider stringProvider, @NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(tariffCountRepository, "repository");
        Intrinsics.checkNotNullParameter(tariffCountConverter, "converter");
        Intrinsics.checkNotNullParameter(priceConverter, "priceConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        this.v = str;
        this.w = tariffCountRepository;
        this.x = tariffCountConverter;
        this.y = priceConverter;
        this.z = schedulersFactory;
        this.A = stringProvider;
        this.B = kundle;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.e = singleLiveEvent;
        MutableLiveData<PricePanelState> mutableLiveData2 = new MutableLiveData<>();
        this.f = mutableLiveData2;
        MutableLiveData<List<Item>> mutableLiveData3 = new MutableLiveData<>();
        this.g = mutableLiveData3;
        SingleLiveEvent<String> singleLiveEvent2 = new SingleLiveEvent<>();
        this.h = singleLiveEvent2;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this.i = mutableLiveData4;
        MutableLiveData<LoadingState<Price>> mutableLiveData5 = new MutableLiveData<>();
        this.j = mutableLiveData5;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.k = empty;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Disposables.empty()");
        this.l = empty2;
        Disposable empty3 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty3, "Disposables.empty()");
        this.m = empty3;
        Disposable empty4 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty4, "Disposables.empty()");
        this.n = empty4;
        d();
        this.o = mutableLiveData;
        this.p = singleLiveEvent;
        this.q = mutableLiveData2;
        this.r = mutableLiveData3;
        this.s = singleLiveEvent2;
        this.t = mutableLiveData4;
        this.u = mutableLiveData5;
    }

    public static final void access$handleLoadingState(TariffCountViewModelImpl tariffCountViewModelImpl, LoadingState loadingState) {
        T t2;
        String stringId;
        tariffCountViewModelImpl.j.setValue(LoadingState.Loading.INSTANCE);
        tariffCountViewModelImpl.d.setValue(loadingState);
        if (loadingState instanceof LoadingState.Loaded) {
            TariffCountResult tariffCountResult = (TariffCountResult) ((LoadingState.Loaded) loadingState).getData();
            tariffCountViewModelImpl.f.setValue(new PricePanelState(tariffCountResult.getActionTitle(), tariffCountResult.getSumTitle()));
            List<Item> convert = tariffCountViewModelImpl.x.convert(tariffCountResult);
            String string = tariffCountViewModelImpl.B.getString("selected_item");
            if (string != null) {
                convert = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(convert), new a2.a.a.e3.b.h.d(string)));
            }
            int i2 = 0;
            if (!(convert instanceof Collection) || !convert.isEmpty()) {
                int i3 = 0;
                for (T t3 : convert) {
                    if (((t3 instanceof CountItem) && t3.isChecked()) && (i3 = i3 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
                i2 = i3;
            }
            if (i2 != 1) {
                Iterator<T> it = convert.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t2 = null;
                        break;
                    }
                    t2 = it.next();
                    if (t2 instanceof CountItem) {
                        break;
                    }
                }
                T t4 = t2;
                if (!(t4 == null || (stringId = t4.getStringId()) == null)) {
                    convert = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(convert), new a2.a.a.e3.b.h.d(stringId)));
                }
            }
            tariffCountViewModelImpl.f(convert);
            CountItem c2 = tariffCountViewModelImpl.c(convert);
            if (c2 != null) {
                tariffCountViewModelImpl.g(c2);
            }
        }
    }

    public static final void access$handleRegionSelectionResponse(TariffCountViewModelImpl tariffCountViewModelImpl, LoadingState loadingState) {
        Objects.requireNonNull(tariffCountViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            tariffCountViewModelImpl.i.setValue(Boolean.FALSE);
            tariffCountViewModelImpl.e.setValue(((DeepLinkResponse) ((LoadingState.Loaded) loadingState).getData()).getDeepLink());
        } else if (loadingState instanceof LoadingState.Loading) {
            tariffCountViewModelImpl.i.setValue(Boolean.TRUE);
        } else if (loadingState instanceof LoadingState.Error) {
            tariffCountViewModelImpl.i.setValue(Boolean.FALSE);
            tariffCountViewModelImpl.h.postValue(tariffCountViewModelImpl.A.getUnknownError());
        }
    }

    public static final void access$postItemsWithoutBonus(TariffCountViewModelImpl tariffCountViewModelImpl, CountItem countItem) {
        tariffCountViewModelImpl.f(SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(tariffCountViewModelImpl.c), a2.a.a.e3.b.h.b.a), new a2.a.a.e3.b.h.c(countItem.getStringId()))));
    }

    public final CountItem c(List<? extends Item> list) {
        T t2;
        boolean z2;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            T t3 = t2;
            if (!(t3 instanceof CountItem) || !t3.isChecked()) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        return t2;
    }

    public final void d() {
        this.k.dispose();
        Disposable subscribe = this.w.getTariffCount(this.v).observeOn(this.z.mainThread()).startWith((Observable<LoadingState<TariffCountResult>>) LoadingState.Loading.INSTANCE).subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getTariffCoun…          }\n            )");
        this.k = subscribe;
    }

    public final void e(String str, TariffCountCost tariffCountCost) {
        this.j.setValue(new LoadingState.Loaded(tariffCountCost.getPrice()));
        BonusItem bonus = tariffCountCost.getBonus();
        if (bonus != null) {
            List<Item> mutableList = SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.c), new f(this, str)));
            int i2 = 0;
            Iterator<? extends Item> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (Intrinsics.areEqual(((Item) it.next()).getStringId(), str)) {
                    break;
                } else {
                    i2++;
                }
            }
            mutableList.add(i2 + 1, bonus);
            this.g.postValue(mutableList);
            this.c = mutableList;
        }
    }

    public final void f(List<? extends Item> list) {
        this.g.postValue(list);
        this.c = list;
    }

    public final void g(CountItem countItem) {
        if (countItem.getCost() != null) {
            e(countItem.getStringId(), countItem.getCost());
            return;
        }
        this.n.dispose();
        Disposable subscribe = this.w.getCountPrice(countItem.getStringId(), this.v).filter(i.a).map(j.a).map(new k(this)).observeOn(this.z.mainThread()).doOnSubscribe(new l(this)).subscribe(new m(this, countItem), n.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getCountPrice…ber.e(it) }\n            )");
        this.n = subscribe;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    @NotNull
    public SingleLiveEvent<String> getMessageEvents() {
        return this.s;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    @NotNull
    public LiveData<LoadingState<Price>> getPriceChanges() {
        return this.u;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getRoutingEvents() {
        return this.p;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        T t2;
        Observable<CountItem> itemClicks;
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2 instanceof CountItemPresenter) {
                break;
            }
        }
        T t3 = t2;
        if (t3 != null && (itemClicks = t3.getItemClicks()) != null) {
            this.l.dispose();
            Disposable subscribe = itemClicks.throttleFirst(300, TimeUnit.MILLISECONDS).distinctUntilChanged().observeOn(this.z.mainThread()).doOnNext(new d(this)).doOnNext(new a(0, this)).subscribe(new a(1, this), e.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks\n            .…ber.e(it) }\n            )");
            this.l = subscribe;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.l.dispose();
        this.k.dispose();
        this.m.dispose();
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    public void onDestroyView() {
        this.n.dispose();
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    public void onRetryButtonClick() {
        d();
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    public void onSelectButtonClick() {
        CountItem c2 = c(this.c);
        if (c2 != null) {
            this.m.dispose();
            Disposable subscribe = this.w.selectTariffCount(c2.getStringId(), this.v).observeOn(this.z.mainThread()).subscribe(new g(this), new h(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "repository.selectTariffC…ownError) }\n            )");
            this.m = subscribe;
        }
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    public void onViewCreated() {
        CountItem c2;
        if (Intrinsics.areEqual(this.j.getValue(), LoadingState.Loading.INSTANCE) && (c2 = c(this.c)) != null) {
            g(c2);
        }
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    @NotNull
    public Kundle saveState() {
        String stringId;
        CountItem c2 = c(this.c);
        if (c2 == null || (stringId = c2.getStringId()) == null) {
            return Kundle.Companion.getEMPTY();
        }
        return new Kundle().putString("selected_item", stringId);
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    @NotNull
    public MutableLiveData<List<Item>> getListChanges() {
        return this.r;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    @NotNull
    public MutableLiveData<Boolean> getLoadingEvents() {
        return this.t;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    @NotNull
    public MutableLiveData<PricePanelState> getPricePanelStateChanges() {
        return this.q;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.o;
    }
}
