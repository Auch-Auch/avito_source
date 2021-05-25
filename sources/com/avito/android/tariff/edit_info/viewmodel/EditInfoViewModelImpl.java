package com.avito.android.tariff.edit_info.viewmodel;

import a2.a.a.e3.d.e.h;
import a2.a.a.e3.d.e.i;
import a2.a.a.e3.d.e.k;
import a2.a.a.e3.d.e.l;
import a2.a.a.e3.d.e.m;
import a2.a.a.e3.d.e.n;
import a2.a.a.e3.d.e.o;
import a2.a.a.e3.d.e.p;
import a2.a.a.e3.d.e.q;
import a2.a.a.e3.d.e.r;
import a2.a.a.e3.d.e.s;
import a2.a.a.e3.d.e.t;
import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.change.TariffAutoProlongResult;
import com.avito.android.remote.model.edit.BottomSheetAction;
import com.avito.android.remote.model.edit.TariffEditInfoResult;
import com.avito.android.remote.model.edit.TariffSheet;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogItem;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogPresenter;
import com.avito.android.tariff.edit_info.item.alert_dialog.DeepLinkActionItem;
import com.avito.android.tariff.edit_info.item.alert_dialog.ShowNextActionItem;
import com.avito.android.tariff.edit_info.item.alert_dialog.TariffAlertActionItem;
import com.avito.android.tariff.edit_info.item.alert_dialog.TariffSheetActionItem;
import com.avito.android.tariff.edit_info.item.button.ButtonItemPresenter;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallPresenter;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItem;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemPresenter;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenter;
import com.avito.android.tariff.edit_info.item.tabs.TariffEditConvertInfo;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010M\u001a\u000201\u0012\u0006\u0010k\u001a\u00020h\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010@\u001a\u00020=¢\u0006\u0004\bw\u0010xJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b*\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J%\u0010\u0018\u001a\u00020\u00052\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00160\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010!R\u0016\u0010&\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010!R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020'0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010!R(\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010!\u001a\u0004\b-\u0010.R\"\u00106\u001a\b\u0012\u0004\u0012\u000201008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u0002010\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010!R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010C\u001a\b\u0012\u0004\u0012\u00020'008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u00103\u001a\u0004\bB\u00105R&\u0010F\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010!\u001a\u0004\bE\u0010.R\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010GR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010P\u001a\b\u0012\u0004\u0012\u000201008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u00103\u001a\u0004\bO\u00105R\"\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010!R\u001c\u0010T\u001a\b\u0012\u0004\u0012\u0002010\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010!R\"\u0010[\u001a\b\u0012\u0004\u0012\u00020V0U8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010b\u001a\b\u0012\u0004\u0012\u00020'008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b`\u00103\u001a\u0004\ba\u00105R\"\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010!R\"\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001f008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\be\u00103\u001a\u0004\bf\u00105R\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010\u001cR\u001c\u0010o\u001a\b\u0012\u0004\u0012\u00020V0U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010XR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR(\u0010v\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bt\u00103\u001a\u0004\bu\u00105¨\u0006y"}, d2 = {"Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModelImpl;", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/tariff/edit_info/item/tabs/TariffEditConvertInfo;", "tariffEditConvertInfo", "", "c", "(Lcom/avito/android/tariff/edit_info/item/tabs/TariffEditConvertInfo;)V", "", "Lcom/avito/conveyor_item/Item;", "", "isSwitchOn", "isSwitchEnabled", "e", "(Ljava/util/List;ZZ)Ljava/util/List;", "list", "d", "(Ljava/util/List;)V", "onCleared", "()V", "onRetryButtonClick", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "loadData", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/tariff/edit_info/viewmodel/BottomSheetParams;", "n", "Landroidx/lifecycle/MutableLiveData;", "bottomSheetLiveData", "Lcom/avito/android/util/LoadingState;", "k", "progressChangesLiveData", "autoprolongSubscription", "", "o", "nextTabLiveData", "p", "closeBottomSheetLiveData", "t", "getListChanges", "()Landroidx/lifecycle/MutableLiveData;", "listChanges", "Landroidx/lifecycle/LiveData;", "", VKApiConst.VERSION, "Landroidx/lifecycle/LiveData;", "getTitleChanges", "()Landroidx/lifecycle/LiveData;", "titleChanges", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;", "D", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;", "converter", "j", "errorChangesLiveData", "Lcom/avito/android/util/SchedulersFactory;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "z", "getNextTabActionChanges", "nextTabActionChanges", "s", "getProgressChanges", "progressChanges", "Ljava/util/List;", "items", VKApiConst.Q, "Lcom/avito/android/tariff/edit_info/item/tabs/TariffEditConvertInfo;", "B", "Ljava/lang/String;", "checkoutContext", "x", "getErrorChanges", "errorChanges", AuthSource.OPEN_CHANNEL_LIST, "headerChangesLiveData", "i", "titleChangesLiveData", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "u", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getRoutingEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEvents", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "r", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "tabsItemPresenter", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getCloseBottomSheetChanges", "closeBottomSheetChanges", "h", "listChangesLiveData", "y", "getBottomSheetActionChanges", "bottomSheetActionChanges", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;", "C", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;", "repository", "f", "applyChangeSubscription", "l", "routingEventsLiveData", "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "clickSubscriptions", "w", "getHeaderChanges", "headerChanges", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoViewModelImpl extends ViewModel implements EditInfoViewModel {
    @NotNull
    public final LiveData<Object> A;
    public final String B;
    public final EditInfoRepository C;
    public final EditInfoConverter D;
    public final SchedulersFactory E;
    public List<? extends Item> c = CollectionsKt__CollectionsKt.emptyList();
    public Disposable d;
    public Disposable e;
    public Disposable f;
    public final CompositeDisposable g;
    public final MutableLiveData<List<Item>> h;
    public final MutableLiveData<String> i;
    public final MutableLiveData<String> j;
    public final MutableLiveData<LoadingState<?>> k;
    public final SingleLiveEvent<DeepLink> l;
    public final MutableLiveData<List<Item>> m;
    public final MutableLiveData<BottomSheetParams> n;
    public final MutableLiveData<Object> o;
    public final MutableLiveData<Object> p;
    public TariffEditConvertInfo q;
    public TabsItemPresenter r;
    @NotNull
    public final MutableLiveData<LoadingState<?>> s;
    @NotNull
    public final MutableLiveData<List<Item>> t;
    @NotNull
    public final SingleLiveEvent<DeepLink> u;
    @NotNull
    public final LiveData<String> v;
    @NotNull
    public final LiveData<List<Item>> w;
    @NotNull
    public final LiveData<String> x;
    @NotNull
    public final LiveData<BottomSheetParams> y;
    @NotNull
    public final LiveData<Object> z;

    public static final class a<T> implements Consumer<LoadingState<? super TariffEditInfoResult>> {
        public final /* synthetic */ EditInfoViewModelImpl a;

        public a(EditInfoViewModelImpl editInfoViewModelImpl) {
            this.a = editInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super TariffEditInfoResult> loadingState) {
            this.a.k.postValue(loadingState);
        }
    }

    public static final class b<T> implements Predicate<LoadingState<? super TariffEditInfoResult>> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(LoadingState<? super TariffEditInfoResult> loadingState) {
            LoadingState<? super TariffEditInfoResult> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return loadingState2 instanceof LoadingState.Loaded;
        }
    }

    public static final class c<T, R> implements Function<LoadingState<? super TariffEditInfoResult>, LoadingState.Loaded<TariffEditInfoResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState.Loaded<TariffEditInfoResult> apply(LoadingState<? super TariffEditInfoResult> loadingState) {
            LoadingState<? super TariffEditInfoResult> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return (LoadingState.Loaded) loadingState2;
        }
    }

    public static final class d<T, R> implements Function<LoadingState.Loaded<TariffEditInfoResult>, TariffEditConvertInfo> {
        public final /* synthetic */ EditInfoViewModelImpl a;

        public d(EditInfoViewModelImpl editInfoViewModelImpl) {
            this.a = editInfoViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public TariffEditConvertInfo apply(LoadingState.Loaded<TariffEditInfoResult> loaded) {
            LoadingState.Loaded<TariffEditInfoResult> loaded2 = loaded;
            Intrinsics.checkNotNullParameter(loaded2, "it");
            return this.a.D.convert(loaded2.getData());
        }
    }

    public static final class e<T> implements Consumer<TariffEditConvertInfo> {
        public final /* synthetic */ EditInfoViewModelImpl a;

        public e(EditInfoViewModelImpl editInfoViewModelImpl) {
            this.a = editInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(TariffEditConvertInfo tariffEditConvertInfo) {
            TariffEditConvertInfo tariffEditConvertInfo2 = tariffEditConvertInfo;
            EditInfoViewModelImpl editInfoViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(tariffEditConvertInfo2, "it");
            editInfoViewModelImpl.c(tariffEditConvertInfo2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ EditInfoViewModelImpl a;

        public f(EditInfoViewModelImpl editInfoViewModelImpl) {
            this.a = editInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            this.a.k.setValue(new LoadingState.Error(new ErrorWithMessage.Unknown("", th2)));
        }
    }

    public EditInfoViewModelImpl(@NotNull String str, @NotNull EditInfoRepository editInfoRepository, @NotNull EditInfoConverter editInfoConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(editInfoRepository, "repository");
        Intrinsics.checkNotNullParameter(editInfoConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.B = str;
        this.C = editInfoRepository;
        this.D = editInfoConverter;
        this.E = schedulersFactory;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.d = empty;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Disposables.empty()");
        this.e = empty2;
        Disposable empty3 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty3, "Disposables.empty()");
        this.f = empty3;
        this.g = new CompositeDisposable();
        MutableLiveData<List<Item>> mutableLiveData = new MutableLiveData<>();
        this.h = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this.i = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.j = mutableLiveData3;
        MutableLiveData<LoadingState<?>> mutableLiveData4 = new MutableLiveData<>();
        this.k = mutableLiveData4;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.l = singleLiveEvent;
        MutableLiveData<List<Item>> mutableLiveData5 = new MutableLiveData<>();
        this.m = mutableLiveData5;
        MutableLiveData<BottomSheetParams> mutableLiveData6 = new MutableLiveData<>();
        this.n = mutableLiveData6;
        MutableLiveData<Object> mutableLiveData7 = new MutableLiveData<>();
        this.o = mutableLiveData7;
        MutableLiveData<Object> mutableLiveData8 = new MutableLiveData<>();
        this.p = mutableLiveData8;
        loadData();
        this.s = mutableLiveData4;
        this.t = mutableLiveData;
        this.u = singleLiveEvent;
        this.v = mutableLiveData2;
        this.w = mutableLiveData5;
        this.x = mutableLiveData3;
        this.y = mutableLiveData6;
        this.z = mutableLiveData7;
        this.A = mutableLiveData8;
    }

    public static final void access$applyChanges(EditInfoViewModelImpl editInfoViewModelImpl, TariffSheetActionItem tariffSheetActionItem) {
        editInfoViewModelImpl.f.dispose();
        Disposable subscribe = editInfoViewModelImpl.C.getApplyChange().startWith((Observable<LoadingState<Object>>) LoadingState.Loading.INSTANCE).observeOn(editInfoViewModelImpl.E.mainThread()).subscribe(new a2.a.a.e3.d.e.a(editInfoViewModelImpl), a2.a.a.e3.d.e.b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getApplyChang…   }, { Logs.error(it) })");
        editInfoViewModelImpl.f = subscribe;
    }

    public static final void access$discardTariffChange(EditInfoViewModelImpl editInfoViewModelImpl) {
        Objects.requireNonNull(editInfoViewModelImpl);
    }

    public static final void access$handleAlertBannerClicks(EditInfoViewModelImpl editInfoViewModelImpl, TariffAlertActionItem tariffAlertActionItem) {
        TariffEditConvertInfo tariffEditConvertInfo;
        boolean z2;
        BottomSheetAction bottomSheetAction;
        BottomSheetAction bottomSheetAction2;
        Objects.requireNonNull(editInfoViewModelImpl);
        if (tariffAlertActionItem instanceof DeepLinkActionItem) {
            editInfoViewModelImpl.l.postValue(((DeepLinkActionItem) tariffAlertActionItem).getDeeplink());
        } else if (tariffAlertActionItem instanceof TariffSheetActionItem) {
            TariffSheetActionItem tariffSheetActionItem = (TariffSheetActionItem) tariffAlertActionItem;
            TariffSheet tariffSheet = tariffSheetActionItem.getTariffSheet();
            MutableLiveData<BottomSheetParams> mutableLiveData = editInfoViewModelImpl.n;
            String title = tariffSheet.getTitle();
            List<AttributedText> descriptions = tariffSheet.getDescriptions();
            List<BottomSheetAction> actions = tariffSheet.getActions();
            String title2 = (actions == null || (bottomSheetAction2 = (BottomSheetAction) CollectionsKt___CollectionsKt.getOrNull(actions, 0)) == null) ? null : bottomSheetAction2.getTitle();
            List<BottomSheetAction> actions2 = tariffSheet.getActions();
            mutableLiveData.postValue(new BottomSheetParams(title, descriptions, title2, (actions2 == null || (bottomSheetAction = (BottomSheetAction) CollectionsKt___CollectionsKt.getOrNull(actions2, 1)) == null) ? null : bottomSheetAction.getTitle(), new g6(0, editInfoViewModelImpl, tariffSheetActionItem), new g6(1, editInfoViewModelImpl, tariffSheetActionItem), 0, null, 192, null));
        } else if ((tariffAlertActionItem instanceof ShowNextActionItem) && (tariffEditConvertInfo = editInfoViewModelImpl.q) != null) {
            int index = tariffEditConvertInfo.getTariffEditInfo().getSelectedTab().getIndex();
            Iterator<T> it = tariffEditConvertInfo.getTariffEditInfo().getTabs().keySet().iterator();
            if (it.hasNext()) {
                int index2 = it.next().getIndex();
                while (it.hasNext()) {
                    int index3 = it.next().getIndex();
                    if (index2 < index3) {
                        index2 = index3;
                    }
                }
                if (index != index2) {
                    for (T t2 : tariffEditConvertInfo.getTariffEditInfo().getTabs().keySet()) {
                        int i2 = index + 1;
                        if (t2.getIndex() == i2) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            tariffEditConvertInfo.getTariffEditInfo().setSelectedTab(t2);
                            tariffEditConvertInfo.getTabsItem().setSelectedIndex(i2);
                            TabsItemPresenter tabsItemPresenter = editInfoViewModelImpl.r;
                            if (tabsItemPresenter != null) {
                                tabsItemPresenter.unbindListener();
                            }
                            editInfoViewModelImpl.c(tariffEditConvertInfo);
                            return;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                return;
            }
            throw new NoSuchElementException();
        }
    }

    public static final void access$handleLoadingResult(EditInfoViewModelImpl editInfoViewModelImpl, LoadingState loadingState, boolean z2) {
        Objects.requireNonNull(editInfoViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            List<Item> e2 = editInfoViewModelImpl.e(editInfoViewModelImpl.c, ((TariffAutoProlongResult) ((LoadingState.Loaded) loadingState).getData()).getAutoProlong(), true);
            editInfoViewModelImpl.h.postValue(e2);
            editInfoViewModelImpl.c = e2;
        } else if (loadingState instanceof LoadingState.Error) {
            MutableLiveData<String> mutableLiveData = editInfoViewModelImpl.j;
            TypedError error = ((LoadingState.Error) loadingState).getError();
            Objects.requireNonNull(error, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult");
            mutableLiveData.postValue(((ErrorResult) error).getMessage());
            List<Item> e3 = editInfoViewModelImpl.e(editInfoViewModelImpl.c, !z2, true);
            editInfoViewModelImpl.h.postValue(e3);
            editInfoViewModelImpl.c = e3;
        }
    }

    public static final void access$publishNewItems(EditInfoViewModelImpl editInfoViewModelImpl, List list) {
        editInfoViewModelImpl.h.postValue(list);
        editInfoViewModelImpl.c = list;
    }

    public static final void access$updateProlongationState(EditInfoViewModelImpl editInfoViewModelImpl, boolean z2) {
        editInfoViewModelImpl.e.dispose();
        List<Item> e2 = editInfoViewModelImpl.e(editInfoViewModelImpl.c, z2, false);
        editInfoViewModelImpl.h.postValue(e2);
        editInfoViewModelImpl.c = e2;
        Disposable subscribe = editInfoViewModelImpl.C.postTariffAutoprolong(z2).startWith((Observable<LoadingState<TariffAutoProlongResult>>) LoadingState.Loading.INSTANCE).observeOn(editInfoViewModelImpl.E.mainThread()).subscribe(new r(editInfoViewModelImpl, z2), new s(editInfoViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.postTariffAut…ror(error)\n            })");
        editInfoViewModelImpl.e = subscribe;
    }

    public final void c(TariffEditConvertInfo tariffEditConvertInfo) {
        this.q = tariffEditConvertInfo;
        this.i.postValue(tariffEditConvertInfo.getTariffEditInfo().getTitle());
        d(tariffEditConvertInfo.getTariffEditInfo().getItemsForTab(tariffEditConvertInfo.getTariffEditInfo().getSelectedTab()));
        List<Item> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(tariffEditConvertInfo.getTabsItem());
        AlertDialogItem dialogItem = tariffEditConvertInfo.getDialogItem();
        if (dialogItem != null) {
            mutableListOf.add(0, dialogItem);
        }
        this.m.postValue(mutableListOf);
    }

    public final void d(List<? extends Item> list) {
        this.h.postValue(list);
        this.c = list;
    }

    public final List<Item> e(List<? extends Item> list, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (T t2 : list) {
            if (t2 instanceof TariffProlongationItem) {
                t2 = TariffProlongationItem.copy$default(t2, null, null, null, null, z2, z3, null, 79, null);
            }
            arrayList.add(t2);
        }
        return arrayList;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public LiveData<BottomSheetParams> getBottomSheetActionChanges() {
        return this.y;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public LiveData<Object> getCloseBottomSheetChanges() {
        return this.A;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public LiveData<String> getErrorChanges() {
        return this.x;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public LiveData<List<Item>> getHeaderChanges() {
        return this.w;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public LiveData<Object> getNextTabActionChanges() {
        return this.z;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getRoutingEvents() {
        return this.u;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public LiveData<String> getTitleChanges() {
        return this.v;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    public void loadData() {
        this.d.dispose();
        Disposable subscribe = this.C.getTariffInfo(this.B).startWith((Observable<LoadingState<TariffEditInfoResult>>) LoadingState.Loading.INSTANCE).doOnNext(new a(this)).filter(b.a).map(c.a).map(new d(this)).observeOn(this.E.mainThread()).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getTariffInfo…ror(error)\n            })");
        this.d = subscribe;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.g.clear();
        for (T t2 : set) {
            if (t2 instanceof DeeplinkClickStreamProvider) {
                CompositeDisposable compositeDisposable = this.g;
                Disposable subscribe = t2.getDeeplinkClicks().throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new h(this), i.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "provider.deeplinkClicks\n…   }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (t2 instanceof TabsItemPresenter) {
                CompositeDisposable compositeDisposable2 = this.g;
                T t3 = t2;
                this.r = t3;
                Disposable subscribe2 = t3.getTabSelects().throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new p(this), q.a);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "tabsItemPresenter.tabSel…   }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            } else if (t2 instanceof TariffProlongationItemPresenter) {
                CompositeDisposable compositeDisposable3 = this.g;
                Disposable subscribe3 = t2.getProlongationClicks().throttleFirst(300, TimeUnit.MILLISECONDS).map(m.a).subscribe(new n(this), o.a);
                Intrinsics.checkNotNullExpressionValue(subscribe3, "prolongationItemPresente…error(it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            } else if (t2 instanceof ButtonItemPresenter) {
                CompositeDisposable compositeDisposable4 = this.g;
                Disposable subscribe4 = t2.getButtonClicks().throttleFirst(300, TimeUnit.MILLISECONDS).map(a2.a.a.e3.d.e.e.a).observeOn(this.E.mainThread()).subscribe(new a2.a.a.e3.d.e.f(this), a2.a.a.e3.d.e.g.a);
                Intrinsics.checkNotNullExpressionValue(subscribe4, "buttonItemPresenter.butt…   }, { Logs.error(it) })");
                DisposableKt.plusAssign(compositeDisposable4, subscribe4);
            } else if (t2 instanceof AlertDialogPresenter) {
                CompositeDisposable compositeDisposable5 = this.g;
                Disposable subscribe5 = t2.getButtonClicks().throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new t(new Function1<TariffAlertActionItem, Unit>(this) { // from class: a2.a.a.e3.d.e.c
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(TariffAlertActionItem tariffAlertActionItem) {
                        TariffAlertActionItem tariffAlertActionItem2 = tariffAlertActionItem;
                        Intrinsics.checkNotNullParameter(tariffAlertActionItem2, "p1");
                        EditInfoViewModelImpl.access$handleAlertBannerClicks((EditInfoViewModelImpl) this.receiver, tariffAlertActionItem2);
                        return Unit.INSTANCE;
                    }
                }), a2.a.a.e3.d.e.d.a);
                Intrinsics.checkNotNullExpressionValue(subscribe5, "alertDialogPresenter.but…licks) { Logs.error(it) }");
                DisposableKt.plusAssign(compositeDisposable5, subscribe5);
            } else if (t2 instanceof ManagerCallPresenter) {
                CompositeDisposable compositeDisposable6 = this.g;
                Disposable subscribe6 = t2.getButtonClicks().throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new k(this), l.a);
                Intrinsics.checkNotNullExpressionValue(subscribe6, "managerCallPresenter.but….error(it)\n            })");
                DisposableKt.plusAssign(compositeDisposable6, subscribe6);
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.dispose();
        this.e.dispose();
        this.g.dispose();
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    public void onRetryButtonClick() {
        loadData();
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public MutableLiveData<List<Item>> getListChanges() {
        return this.t;
    }

    @Override // com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.s;
    }
}
