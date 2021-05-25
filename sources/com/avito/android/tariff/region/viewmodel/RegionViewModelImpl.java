package com.avito.android.tariff.region.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.TariffRegionResult;
import com.avito.android.tariff.StringProvider;
import com.avito.android.tariff.region.item.RegionItem;
import com.avito.android.tariff.region.item.RegionItemPresenter;
import com.avito.android.tariff.region.recycler.RegionDiffUtilCallback;
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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010A\u001a\u00020\u000b\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010Q\u001a\u00020\u001a¢\u0006\u0004\bd\u0010eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\u00032\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00130\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001fR8\u0010)\u001a\u001e\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020#0\"j\u0002`$0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010,R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010&R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u001f\u001a\u0004\b8\u0010,R \u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010&R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020<0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010&R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u00101R\u0016\u0010I\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u00101R\"\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000b0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010&\u001a\u0004\bK\u0010(R2\u0010N\u001a\u001e\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020#0\"j\u0002`$0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010&R\u0016\u0010Q\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010\u001fR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\"\u0010Z\u001a\b\u0012\u0004\u0012\u00020<0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bX\u0010&\u001a\u0004\bY\u0010(R\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R&\u0010a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b_\u0010&\u001a\u0004\b`\u0010(R\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010b¨\u0006f"}, d2 = {"Lcom/avito/android/tariff/region/viewmodel/RegionViewModelImpl;", "Lcom/avito/android/tariff/region/viewmodel/RegionViewModel;", "Landroidx/lifecycle/ViewModel;", "", "d", "()V", "", "Lcom/avito/conveyor_item/Item;", "list", "e", "(Ljava/util/List;)V", "", "selectedItemId", "f", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Lcom/avito/android/tariff/region/item/RegionItem;", "c", "(Ljava/util/List;)Lcom/avito/android/tariff/region/item/RegionItem;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "onSelectButtonClick", "onRetryButtonClick", "onCleared", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEventsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "Lcom/avito/android/tariff/region/viewmodel/ListUpdate;", "p", "Landroidx/lifecycle/MutableLiveData;", "getListChanges", "()Landroidx/lifecycle/MutableLiveData;", "listChanges", VKApiConst.Q, "getMessageEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "messageEvents", "buttonTextChangesLiveData", "Lio/reactivex/disposables/Disposable;", "k", "Lio/reactivex/disposables/Disposable;", "clickSubscription", "Lcom/avito/android/util/SchedulersFactory;", VKApiConst.VERSION, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "n", "getRoutingEvents", "routingEvents", "Lcom/avito/android/util/LoadingState;", "progressChangesLiveData", "", "i", "loadingEventsLiveData", "s", "Ljava/lang/String;", "checkoutContext", "Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;", "t", "Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;", "repository", "j", "loadingSubscription", "l", "selectSubscription", "o", "getButtonTextChanges", "buttonTextChanges", a2.g.r.g.a, "listChangesLiveData", "x", "Lcom/avito/android/util/Kundle;", "savedState", "h", "messagesLiveData", "Lcom/avito/android/tariff/StringProvider;", "w", "Lcom/avito/android/tariff/StringProvider;", "stringProvider", "r", "getLoadingEvents", "loadingEvents", "Lcom/avito/android/tariff/region/viewmodel/RegionConverter;", "u", "Lcom/avito/android/tariff/region/viewmodel/RegionConverter;", "converter", AuthSource.OPEN_CHANNEL_LIST, "getProgressChanges", "progressChanges", "Ljava/util/List;", "items", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;Lcom/avito/android/tariff/region/viewmodel/RegionConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/tariff/StringProvider;Lcom/avito/android/util/Kundle;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class RegionViewModelImpl extends ViewModel implements RegionViewModel {
    public List<? extends Item> c = CollectionsKt__CollectionsKt.emptyList();
    public final MutableLiveData<LoadingState<?>> d;
    public final SingleLiveEvent<DeepLink> e;
    public final MutableLiveData<String> f;
    public final MutableLiveData<Pair<List<Item>, DiffUtil.DiffResult>> g;
    public final SingleLiveEvent<String> h;
    public final MutableLiveData<Boolean> i;
    public Disposable j;
    public Disposable k;
    public Disposable l;
    @NotNull
    public final MutableLiveData<LoadingState<?>> m;
    @NotNull
    public final SingleLiveEvent<DeepLink> n;
    @NotNull
    public final MutableLiveData<String> o;
    @NotNull
    public final MutableLiveData<Pair<List<Item>, DiffUtil.DiffResult>> p;
    @NotNull
    public final SingleLiveEvent<String> q;
    @NotNull
    public final MutableLiveData<Boolean> r;
    public final String s;
    public final TariffRegionRepository t;
    public final RegionConverter u;
    public final SchedulersFactory v;
    public final StringProvider w;
    public final Kundle x;

    public static final class a<T> implements Consumer<LoadingState<? super TariffRegionResult>> {
        public final /* synthetic */ RegionViewModelImpl a;

        public a(RegionViewModelImpl regionViewModelImpl) {
            this.a = regionViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super TariffRegionResult> loadingState) {
            LoadingState<? super TariffRegionResult> loadingState2 = loadingState;
            RegionViewModelImpl regionViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            RegionViewModelImpl.access$handleLoadingState(regionViewModelImpl, loadingState2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ RegionViewModelImpl a;

        public b(RegionViewModelImpl regionViewModelImpl) {
            this.a = regionViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.d.setValue(new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(this.a.w.getUnknownError())));
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ RegionViewModelImpl a;

        public c(RegionViewModelImpl regionViewModelImpl) {
            this.a = regionViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            RegionViewModelImpl regionViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            RegionViewModelImpl.access$onItemClicked(regionViewModelImpl, str2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public static final class e<T> implements Consumer<LoadingState<? super DeepLinkResponse>> {
        public final /* synthetic */ RegionViewModelImpl a;

        public e(RegionViewModelImpl regionViewModelImpl) {
            this.a = regionViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super DeepLinkResponse> loadingState) {
            LoadingState<? super DeepLinkResponse> loadingState2 = loadingState;
            RegionViewModelImpl regionViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            RegionViewModelImpl.access$handleRegionSelectionResponse(regionViewModelImpl, loadingState2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ RegionViewModelImpl a;

        public f(RegionViewModelImpl regionViewModelImpl) {
            this.a = regionViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.h.postValue(this.a.w.getUnknownError());
        }
    }

    public static final class g extends Lambda implements Function1<Item, Item> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Item invoke(Item item) {
            Item item2 = item;
            Intrinsics.checkNotNullParameter(item2, "it");
            return item2 instanceof RegionItem ? RegionItem.copy$default((RegionItem) item2, null, null, Intrinsics.areEqual(item2.getStringId(), this.a), 3, null) : item2;
        }
    }

    public RegionViewModelImpl(@NotNull String str, @NotNull TariffRegionRepository tariffRegionRepository, @NotNull RegionConverter regionConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull StringProvider stringProvider, @NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(tariffRegionRepository, "repository");
        Intrinsics.checkNotNullParameter(regionConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        this.s = str;
        this.t = tariffRegionRepository;
        this.u = regionConverter;
        this.v = schedulersFactory;
        this.w = stringProvider;
        this.x = kundle;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.e = singleLiveEvent;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this.f = mutableLiveData2;
        MutableLiveData<Pair<List<Item>, DiffUtil.DiffResult>> mutableLiveData3 = new MutableLiveData<>();
        this.g = mutableLiveData3;
        SingleLiveEvent<String> singleLiveEvent2 = new SingleLiveEvent<>();
        this.h = singleLiveEvent2;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this.i = mutableLiveData4;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.j = empty;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Disposables.empty()");
        this.k = empty2;
        Disposable empty3 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty3, "Disposables.empty()");
        this.l = empty3;
        d();
        this.m = mutableLiveData;
        this.n = singleLiveEvent;
        this.o = mutableLiveData2;
        this.p = mutableLiveData3;
        this.q = singleLiveEvent2;
        this.r = mutableLiveData4;
    }

    public static final void access$handleLoadingState(RegionViewModelImpl regionViewModelImpl, LoadingState loadingState) {
        T t2;
        String str;
        regionViewModelImpl.d.setValue(loadingState);
        if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            regionViewModelImpl.f.setValue(((TariffRegionResult) loaded.getData()).getActionTitle());
            List<Item> convert = regionViewModelImpl.u.convert((TariffRegionResult) loaded.getData());
            String string = regionViewModelImpl.x.getString("selected_item");
            if (string != null) {
                convert = regionViewModelImpl.f(convert, string);
            }
            if (regionViewModelImpl.c(convert) == null) {
                Iterator<T> it = convert.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t2 = null;
                        break;
                    }
                    t2 = it.next();
                    if (t2 instanceof RegionItem) {
                        break;
                    }
                }
                T t3 = t2;
                if (t3 == null || (str = t3.getStringId()) == null) {
                    str = "";
                }
                regionViewModelImpl.e(regionViewModelImpl.f(convert, str));
                return;
            }
            regionViewModelImpl.e(convert);
        }
    }

    public static final void access$handleRegionSelectionResponse(RegionViewModelImpl regionViewModelImpl, LoadingState loadingState) {
        Objects.requireNonNull(regionViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            regionViewModelImpl.i.setValue(Boolean.FALSE);
            regionViewModelImpl.e.setValue(((DeepLinkResponse) ((LoadingState.Loaded) loadingState).getData()).getDeepLink());
        } else if (loadingState instanceof LoadingState.Loading) {
            regionViewModelImpl.i.setValue(Boolean.TRUE);
        } else if (loadingState instanceof LoadingState.Error) {
            regionViewModelImpl.i.setValue(Boolean.FALSE);
            regionViewModelImpl.h.postValue(regionViewModelImpl.w.getUnknownError());
        }
    }

    public static final void access$onItemClicked(RegionViewModelImpl regionViewModelImpl, String str) {
        RegionItem c2 = regionViewModelImpl.c(regionViewModelImpl.c);
        if (c2 == null || !Intrinsics.areEqual(c2.getStringId(), str)) {
            regionViewModelImpl.e(regionViewModelImpl.f(regionViewModelImpl.c, str));
        }
    }

    public final RegionItem c(List<? extends Item> list) {
        T t2;
        boolean z;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            T t3 = t2;
            if (!(t3 instanceof RegionItem) || !t3.isChecked()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        return t2;
    }

    public final void d() {
        this.j.dispose();
        Disposable subscribe = this.t.getTariffRegions(this.s).observeOn(this.v.mainThread()).startWith((Observable<LoadingState<TariffRegionResult>>) LoadingState.Loading.INSTANCE).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getTariffRegi…          }\n            )");
        this.j = subscribe;
    }

    public final void e(List<? extends Item> list) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new RegionDiffUtilCallback(this.c, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(callback)");
        this.g.setValue(new Pair<>(list, calculateDiff));
        this.c = list;
    }

    public final List<Item> f(List<? extends Item> list, String str) {
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list), new g(str)));
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    @NotNull
    public SingleLiveEvent<String> getMessageEvents() {
        return this.q;
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getRoutingEvents() {
        return this.n;
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        T t2;
        Observable<String> regionSelectionObservable;
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2 instanceof RegionItemPresenter) {
                break;
            }
        }
        T t3 = t2;
        if (t3 != null && (regionSelectionObservable = t3.getRegionSelectionObservable()) != null) {
            this.k.dispose();
            Disposable subscribe = regionSelectionObservable.throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.v.mainThread()).subscribe(new c(this), d.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "observable\n            .…ber.e(it) }\n            )");
            this.k = subscribe;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.k.dispose();
        this.j.dispose();
        this.l.dispose();
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    public void onRetryButtonClick() {
        d();
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    public void onSelectButtonClick() {
        T t2;
        boolean z;
        Iterator<T> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            T t3 = t2;
            if (!(t3 instanceof RegionItem) || !t3.isChecked()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t4 = t2;
        if (t4 != null) {
            this.l.dispose();
            Disposable subscribe = this.t.selectTariffRegionLegacy(t4.getStringId(), this.s).observeOn(this.v.mainThread()).subscribe(new e(this), new f(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "repository.selectTariffR…ownError) }\n            )");
            this.l = subscribe;
        }
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    @NotNull
    public Kundle saveState() {
        RegionItem c2 = c(this.c);
        if (c2 != null) {
            return new Kundle().putString("selected_item", c2.getStringId());
        }
        return Kundle.Companion.getEMPTY();
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    @NotNull
    public MutableLiveData<String> getButtonTextChanges() {
        return this.o;
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    @NotNull
    public MutableLiveData<Pair<List<Item>, DiffUtil.DiffResult>> getListChanges() {
        return this.p;
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    @NotNull
    public MutableLiveData<Boolean> getLoadingEvents() {
        return this.r;
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.m;
    }
}
