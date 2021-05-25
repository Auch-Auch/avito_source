package com.avito.android.shop_settings_select;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ShopSettingsSelections;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItem;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItemPresenter;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00105\u001a\u00020\u0006¢\u0006\u0004\bO\u0010PJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00032\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R&\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR*\u0010 \u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u001c0\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0013R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b1\u0010\u001aR\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010?\u001a\b\u0012\u0004\u0012\u00020-0:8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020-0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010<R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020-0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010<R\"\u0010F\u001a\b\u0012\u0004\u0012\u00020-0:8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010<\u001a\u0004\bE\u0010>R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010IR \u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010\u0013¨\u0006Q"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModel;", "", "onCleared", "()V", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "onRetryButtonClick", "loadContent", "Landroidx/lifecycle/MutableLiveData;", "", "e", "Landroidx/lifecycle/MutableLiveData;", "titleLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/LoadingState;", "h", "Landroidx/lifecycle/LiveData;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "", "Lcom/avito/konveyor/blueprint/Item;", "i", "getListChanges", "listChanges", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectContent;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/shop_settings_select/ShopSettingsSelectContent;", "content", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;", VKApiConst.Q, "Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "r", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/shop_settings_select/blueprints/shop_settings_selection/ShopSettingsSelectionItem;", "d", "listLiveData", "j", "getTitleChanges", "titleChanges", "s", "Lcom/avito/android/util/Kundle;", "savedState", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;", "p", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;", "repository", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "l", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getChooseSelectEvent", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "chooseSelectEvent", "f", "openSelectLiveData", g.a, "chooseSelectLiveData", "k", "getOpenSelectEvent", "openSelectEvent", "Lio/reactivex/disposables/Disposable;", "o", "Lio/reactivex/disposables/Disposable;", "clicksDisposable", "n", "loadingDisposable", "c", "progressLiveData", "<init>", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectViewModelImpl extends ViewModel implements ShopSettingsSelectViewModel {
    public final MutableLiveData<LoadingState<?>> c;
    public final MutableLiveData<List<ShopSettingsSelectionItem>> d;
    public final MutableLiveData<String> e;
    public final SingleLiveEvent<ShopSettingsSelectionItem> f;
    public final SingleLiveEvent<ShopSettingsSelectionItem> g;
    @NotNull
    public final LiveData<LoadingState<?>> h;
    @NotNull
    public final LiveData<? extends List<Item>> i;
    @NotNull
    public final LiveData<String> j;
    @NotNull
    public final SingleLiveEvent<ShopSettingsSelectionItem> k;
    @NotNull
    public final SingleLiveEvent<ShopSettingsSelectionItem> l;
    public ShopSettingsSelectContent m;
    public Disposable n;
    public Disposable o;
    public final ShopSettingsSelectRepository p;
    public final ShopSettingsSelectConverter q;
    public final SchedulersFactory r;
    public final Kundle s;

    public static final class a<T> implements Consumer<LoadingState<? super ShopSettingsSelections>> {
        public final /* synthetic */ ShopSettingsSelectViewModelImpl a;

        public a(ShopSettingsSelectViewModelImpl shopSettingsSelectViewModelImpl) {
            this.a = shopSettingsSelectViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super ShopSettingsSelections> loadingState) {
            LoadingState<? super ShopSettingsSelections> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                ShopSettingsSelectViewModelImpl shopSettingsSelectViewModelImpl = this.a;
                ShopSettingsSelectViewModelImpl.access$reloadContent(shopSettingsSelectViewModelImpl, shopSettingsSelectViewModelImpl.q.convert((ShopSettingsSelections) ((LoadingState.Loaded) loadingState2).getData()));
            }
            this.a.c.setValue(loadingState2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Consumer<ShopSettingsSelectionItem> {
        public final /* synthetic */ ShopSettingsSelectViewModelImpl a;

        public c(ShopSettingsSelectViewModelImpl shopSettingsSelectViewModelImpl) {
            this.a = shopSettingsSelectViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ShopSettingsSelectionItem shopSettingsSelectionItem) {
            ShopSettingsSelectionItem shopSettingsSelectionItem2 = shopSettingsSelectionItem;
            ShopSettingsSelectViewModelImpl shopSettingsSelectViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(shopSettingsSelectionItem2, "it");
            ShopSettingsSelectViewModelImpl.access$handleSelectedId(shopSettingsSelectViewModelImpl, shopSettingsSelectionItem2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public ShopSettingsSelectViewModelImpl(@NotNull ShopSettingsSelectRepository shopSettingsSelectRepository, @NotNull ShopSettingsSelectConverter shopSettingsSelectConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(shopSettingsSelectRepository, "repository");
        Intrinsics.checkNotNullParameter(shopSettingsSelectConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        this.p = shopSettingsSelectRepository;
        this.q = shopSettingsSelectConverter;
        this.r = schedulersFactory;
        this.s = kundle;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<List<ShopSettingsSelectionItem>> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.e = mutableLiveData3;
        SingleLiveEvent<ShopSettingsSelectionItem> singleLiveEvent = new SingleLiveEvent<>();
        this.f = singleLiveEvent;
        SingleLiveEvent<ShopSettingsSelectionItem> singleLiveEvent2 = new SingleLiveEvent<>();
        this.g = singleLiveEvent2;
        this.h = mutableLiveData;
        this.i = mutableLiveData2;
        this.j = mutableLiveData3;
        this.k = singleLiveEvent;
        this.l = singleLiveEvent2;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.n = empty;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Disposables.empty()");
        this.o = empty2;
        loadContent();
    }

    public static final void access$handleSelectedId(ShopSettingsSelectViewModelImpl shopSettingsSelectViewModelImpl, ShopSettingsSelectionItem shopSettingsSelectionItem) {
        Objects.requireNonNull(shopSettingsSelectViewModelImpl);
        boolean hasChildren = shopSettingsSelectionItem.getHasChildren();
        if (hasChildren) {
            shopSettingsSelectViewModelImpl.f.setValue(shopSettingsSelectionItem);
        } else if (!hasChildren) {
            shopSettingsSelectViewModelImpl.g.setValue(shopSettingsSelectionItem);
        }
    }

    public static final void access$reloadContent(ShopSettingsSelectViewModelImpl shopSettingsSelectViewModelImpl, ShopSettingsSelectContent shopSettingsSelectContent) {
        shopSettingsSelectViewModelImpl.d.setValue(shopSettingsSelectContent.getSelections());
        shopSettingsSelectViewModelImpl.e.setValue(shopSettingsSelectContent.getTitle());
        shopSettingsSelectViewModelImpl.m = shopSettingsSelectContent;
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectViewModel
    @NotNull
    public SingleLiveEvent<ShopSettingsSelectionItem> getChooseSelectEvent() {
        return this.l;
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectViewModel
    @NotNull
    public LiveData<? extends List<Item>> getListChanges() {
        return this.i;
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectViewModel
    @NotNull
    public SingleLiveEvent<ShopSettingsSelectionItem> getOpenSelectEvent() {
        return this.k;
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectViewModel
    @NotNull
    public LiveData<LoadingState<?>> getProgressChanges() {
        return this.h;
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectViewModel
    @NotNull
    public LiveData<String> getTitleChanges() {
        return this.j;
    }

    public final void loadContent() {
        ShopSettingsSelectContent shopSettingsSelectContent = (ShopSettingsSelectContent) this.s.getParcelable("content");
        if (shopSettingsSelectContent != null) {
            this.d.setValue(shopSettingsSelectContent.getSelections());
            this.e.setValue(shopSettingsSelectContent.getTitle());
            this.m = shopSettingsSelectContent;
            this.c.setValue(new LoadingState.Loaded(Unit.INSTANCE));
            return;
        }
        this.n.dispose();
        Disposable subscribe = this.p.getShopSettingsSelect().observeOn(this.r.mainThread()).startWith((Observable<LoadingState<ShopSettingsSelections>>) LoadingState.Loading.INSTANCE).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getShopSettin…error(it) }\n            )");
        this.n = subscribe;
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.o.dispose();
        ArrayList<ShopSettingsSelectionItemPresenter> arrayList = new ArrayList();
        for (T t : set) {
            if (t instanceof ShopSettingsSelectionItemPresenter) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (ShopSettingsSelectionItemPresenter shopSettingsSelectionItemPresenter : arrayList) {
            arrayList2.add(shopSettingsSelectionItemPresenter.getClicksObservable());
        }
        Disposable subscribe = Observables.merge(arrayList2).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemPresenterSet\n       …error(it) }\n            )");
        this.o = subscribe;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.n.dispose();
        this.o.dispose();
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectViewModel
    public void onRetryButtonClick() {
        loadContent();
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectViewModel
    @NotNull
    public Kundle saveState() {
        Kundle putParcelable;
        ShopSettingsSelectContent shopSettingsSelectContent = this.m;
        return (shopSettingsSelectContent == null || (putParcelable = new Kundle().putParcelable("content", shopSettingsSelectContent)) == null) ? Kundle.Companion.getEMPTY() : putParcelable;
    }
}
