package com.avito.android.safedeal.delivery_courier.order_update;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.base.BaseParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderParams;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\u0006\u0010v\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010z\u001a\u00020w\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010f\u001a\u00020c\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\tJ\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\tR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010'R\"\u00105\u001a\b\u0012\u0004\u0012\u0002000/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u0010:\u001a\b\u0012\u0004\u0012\u000200068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u00107\u001a\u0004\b8\u00109R$\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010'R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020H0G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\"\u0010R\u001a\b\u0012\u0004\u0012\u00020P0;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010=\u001a\u0004\bQ\u0010?R\u001c\u0010T\u001a\b\u0012\u0004\u0012\u0002000G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010JR\"\u0010X\u001a\b\u0012\u0004\u0012\u00020H0G8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010J\u001a\u0004\bV\u0010WR$\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010=\u001a\u0004\bZ\u0010?R$\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010=\u001a\u0004\b]\u0010?R\"\u0010b\u001a\b\u0012\u0004\u0012\u00020_068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b`\u00107\u001a\u0004\ba\u00109R\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR&\u0010i\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030g0;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010=\u001a\u0004\bh\u0010?R\u0018\u0010l\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\"\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00030;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bm\u0010=\u001a\u0004\bn\u0010?R\"\u0010r\u001a\b\u0012\u0004\u0012\u00020P0;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bp\u0010=\u001a\u0004\bq\u0010?R\u0018\u0010t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010'R\u0016\u0010v\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010'R\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010+R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModelImpl;", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;", "Landroidx/lifecycle/ViewModel;", "", "value", "", "e", "(Ljava/lang/String;)V", "d", "()V", "c", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "onCleared", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "onLocationSelected", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "timeInterval", "onTimeIntervalSelected", "(Lcom/avito/android/remote/model/delivery_courier/TimeInterval;)V", "loadData", "getSelectedAddress", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "getSelectedTimeInterval", "()Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "submitData", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "C", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "itemsConverter", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", "interactor", "x", "Ljava/lang/String;", "advertID", "", VKApiConst.VERSION, "Ljava/util/List;", "requiredFields", "z", "source", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$SelectDeepLink;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/functions/Consumer;", "getSelectDeepLinkClickConsumer", "()Lio/reactivex/functions/Consumer;", "selectDeepLinkClickConsumer", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSelectDeepLinkChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "selectDeepLinkChanges", "Landroidx/lifecycle/MutableLiveData;", "j", "Landroidx/lifecycle/MutableLiveData;", "getSubmitButtonTextChanges", "()Landroidx/lifecycle/MutableLiveData;", "submitButtonTextChanges", "s", "selectItemId", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "D", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "resourceProvider", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/category_parameters/ParameterElement;", "n", "Lcom/jakewharton/rxrelay2/Relay;", "textChangesRelay", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "tracker", "", "getSubmitButtonEnabledChanges", "submitButtonEnabledChanges", "l", "selectDeepLinkClickRelay", "o", "getTextChangesConsumer", "()Lcom/jakewharton/rxrelay2/Relay;", "textChangesConsumer", "k", "getCancelButtonTextChanges", "cancelButtonTextChanges", "i", "getToolbarTitleChanges", "toolbarTitleChanges", "", "h", "getCloseScreenChanges", "closeScreenChanges", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "F", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "performanceTracker", "Lcom/avito/android/util/LoadingState;", "getProgressChanges", "progressChanges", "u", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selectedTimeInterval", "f", "getSnackbarChanges", "snackbarChanges", a2.g.r.g.a, "getSubmitButtonSpinnerChanges", "submitButtonSpinnerChanges", "w", SDKConstants.PARAM_USER_ID, "y", "orderID", "Lcom/avito/android/util/SchedulersFactory;", "B", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", VKApiConst.Q, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "Lcom/avito/conveyor_item/Item;", "r", PlatformActions.ItemsList.TYPE, "t", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "selectedAddress", "Lio/reactivex/disposables/CompositeDisposable;", "p", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;Lcom/avito/android/account/AccountStateProvider;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierOrderUpdateViewModelImpl extends ViewModel implements DeliveryCourierOrderUpdateViewModel {
    public final DeliveryCourierOrderUpdateInteractor A;
    public final SchedulersFactory B;
    public final DeliveryCourierItemsConverter C;
    public final DeliveryCourierOrderUpdateResourceProvider D;
    public final DeliveryCourierOrderUpdateAnalyticsTracker E;
    public final BaseScreenPerformanceTracker F;
    @NotNull
    public final SingleLiveEvent<ParameterElement.SelectDeepLink> c = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<Boolean> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<LoadingState<?>> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> g = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<Integer> h = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<String> i = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> j = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> k = new MutableLiveData<>();
    public final Relay<ParameterElement.SelectDeepLink> l;
    @NotNull
    public final Consumer<ParameterElement.SelectDeepLink> m;
    public final Relay<ParameterElement> n;
    @NotNull
    public final Relay<ParameterElement> o;
    public final CompositeDisposable p;
    public AdapterPresenter q;
    public List<? extends Item> r;
    public String s;
    public AddressParameter.Value t;
    public TimeInterval u;
    public final List<String> v;
    public final String w;
    public String x;
    public final String y;
    public final String z;

    public static final class a<T> implements Consumer<LoadingState<? super DeliveryCourierOrderParams>> {
        public final /* synthetic */ DeliveryCourierOrderUpdateViewModelImpl a;

        public a(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
            this.a = deliveryCourierOrderUpdateViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super DeliveryCourierOrderParams> loadingState) {
            LoadingState<? super DeliveryCourierOrderParams> loadingState2 = loadingState;
            this.a.getProgressChanges().setValue(loadingState2);
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.F.trackLoaded();
                this.a.F.startPreparing();
                DeliveryCourierOrderParams deliveryCourierOrderParams = (DeliveryCourierOrderParams) ((LoadingState.Loaded) loadingState2).getData();
                this.a.getToolbarTitleChanges().setValue(deliveryCourierOrderParams.getToolbarTitle());
                this.a.getSubmitButtonTextChanges().setValue(deliveryCourierOrderParams.getSubmitButtonText());
                this.a.getCancelButtonTextChanges().setValue(deliveryCourierOrderParams.getCancelButtonText());
                List<Item> convert = this.a.C.convert(deliveryCourierOrderParams);
                this.a.F.trackPrepared();
                this.a.F.startDrawing();
                DeliveryCourierOrderUpdateViewModelImpl.access$updateView(this.a, convert);
                this.a.F.trackDrawn();
                this.a.u = deliveryCourierOrderParams.getSelectedTimeInterval();
                DeliveryCourierOrderUpdateViewModelImpl.access$fillRequiredFieldsMap(this.a, deliveryCourierOrderParams);
                String itemID = deliveryCourierOrderParams.getItemID();
                this.a.x = itemID;
                if (this.a.w != null && itemID != null) {
                    this.a.E.trackScreenOpened(this.a.z, this.a.w, itemID, this.a.y);
                }
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierOrderUpdateViewModelImpl a;

        public b(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
            this.a = deliveryCourierOrderUpdateViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error(th2);
            this.a.E.trackLoadFormFailed();
            this.a.F.trackLoadingError();
            this.a.F.startDrawing();
            MutableLiveData<LoadingState<?>> progressChanges = this.a.getProgressChanges();
            String networkLoadingError = this.a.D.getNetworkLoadingError();
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            progressChanges.setValue(new LoadingState.Error(new ErrorWithMessage.Unknown(networkLoadingError, th2)));
            this.a.F.trackDrawnError();
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super Map<String, ? extends String>>> {
        public final /* synthetic */ DeliveryCourierOrderUpdateViewModelImpl a;

        public c(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
            this.a = deliveryCourierOrderUpdateViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super Map<String, ? extends String>> loadingState) {
            LoadingState<? super Map<String, ? extends String>> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.a.getSubmitButtonSpinnerChanges().setValue(Boolean.TRUE);
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.getSubmitButtonSpinnerChanges().setValue(Boolean.FALSE);
                this.a.getCloseScreenChanges().setValue(-1);
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.getSubmitButtonSpinnerChanges().setValue(Boolean.FALSE);
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (error instanceof ErrorResult.IncorrectData) {
                    DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl = this.a;
                    DeliveryCourierOrderUpdateViewModelImpl.access$updateView(deliveryCourierOrderUpdateViewModelImpl, deliveryCourierOrderUpdateViewModelImpl.C.applyErrors(this.a.r, ((ErrorResult.IncorrectData) error).getMessages()));
                } else if (error instanceof ErrorWithMessage) {
                    this.a.getSnackbarChanges().setValue(((ErrorWithMessage) error).getMessage());
                } else {
                    this.a.getSnackbarChanges().setValue(this.a.D.getTryAgainError());
                }
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierOrderUpdateViewModelImpl a;

        public d(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
            this.a = deliveryCourierOrderUpdateViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.E.trackSubmitError();
        }
    }

    public static final class e<T> implements Consumer<ParameterElement> {
        public final /* synthetic */ DeliveryCourierOrderUpdateViewModelImpl a;

        public e(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
            this.a = deliveryCourierOrderUpdateViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement parameterElement) {
            ParameterElement parameterElement2 = parameterElement;
            String str = "";
            if (parameterElement2 instanceof ParameterElement.SelectDeepLink) {
                DeliveryCourierItemsConverter deliveryCourierItemsConverter = this.a.C;
                List<? extends Item> list = this.a.r;
                String stringId = parameterElement2.getStringId();
                String value = ((ParameterElement.SelectDeepLink) parameterElement2).getValue();
                if (value != null) {
                    str = value;
                }
                deliveryCourierItemsConverter.applyParameterValue(list, stringId, str);
            } else if (parameterElement2 instanceof ParameterElement.Input) {
                DeliveryCourierItemsConverter deliveryCourierItemsConverter2 = this.a.C;
                List<? extends Item> list2 = this.a.r;
                String stringId2 = parameterElement2.getStringId();
                String value2 = ((ParameterElement.Input) parameterElement2).getValue();
                if (value2 != null) {
                    str = value2;
                }
                deliveryCourierItemsConverter2.applyParameterValue(list2, stringId2, str);
            }
            this.a.getSubmitButtonEnabledChanges().setValue(Boolean.valueOf(DeliveryCourierOrderUpdateViewModelImpl.access$allRequiredFieldsNotEmpty(this.a)));
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierOrderUpdateViewModelImpl a;

        public f(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
            this.a = deliveryCourierOrderUpdateViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.E.trackRequiredFieldChangeError();
            this.a.c();
        }
    }

    public static final class g<T> implements Consumer<ParameterElement.SelectDeepLink> {
        public final /* synthetic */ DeliveryCourierOrderUpdateViewModelImpl a;

        public g(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
            this.a = deliveryCourierOrderUpdateViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.SelectDeepLink selectDeepLink) {
            ParameterElement.SelectDeepLink selectDeepLink2 = selectDeepLink;
            this.a.s = selectDeepLink2.getStringId();
            SingleLiveEvent<ParameterElement.SelectDeepLink> selectDeepLinkChanges = this.a.getSelectDeepLinkChanges();
            Intrinsics.checkNotNullExpressionValue(selectDeepLink2, "it");
            selectDeepLinkChanges.setValue(selectDeepLink2);
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierOrderUpdateViewModelImpl a;

        public h(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
            this.a = deliveryCourierOrderUpdateViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getSnackbarChanges().setValue(this.a.D.getSelectDeeplinkError());
            this.a.d();
        }
    }

    public DeliveryCourierOrderUpdateViewModelImpl(@NotNull String str, @NotNull String str2, @NotNull DeliveryCourierOrderUpdateInteractor deliveryCourierOrderUpdateInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull DeliveryCourierItemsConverter deliveryCourierItemsConverter, @NotNull DeliveryCourierOrderUpdateResourceProvider deliveryCourierOrderUpdateResourceProvider, @NotNull DeliveryCourierOrderUpdateAnalyticsTracker deliveryCourierOrderUpdateAnalyticsTracker, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker, @NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryCourierItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateAnalyticsTracker, "tracker");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        this.y = str;
        this.z = str2;
        this.A = deliveryCourierOrderUpdateInteractor;
        this.B = schedulersFactory;
        this.C = deliveryCourierItemsConverter;
        this.D = deliveryCourierOrderUpdateResourceProvider;
        this.E = deliveryCourierOrderUpdateAnalyticsTracker;
        this.F = baseScreenPerformanceTracker;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.l = create;
        this.m = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.n = create2;
        this.o = create2;
        this.p = new CompositeDisposable();
        this.r = CollectionsKt__CollectionsKt.emptyList();
        this.v = new ArrayList();
        this.w = accountStateProvider.getCurrentUserId();
        d();
        c();
        loadData();
    }

    public static final boolean access$allRequiredFieldsNotEmpty(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl) {
        int i2;
        Map<String, String> parametersMap = deliveryCourierOrderUpdateViewModelImpl.C.getParametersMap();
        List<String> list = deliveryCourierOrderUpdateViewModelImpl.v;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            i2 = 0;
            while (it.hasNext()) {
                String str = parametersMap.get(it.next());
                if ((str == null || str.length() == 0) && (i2 = i2 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    public static final void access$fillRequiredFieldsMap(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl, DeliveryCourierOrderParams deliveryCourierOrderParams) {
        Objects.requireNonNull(deliveryCourierOrderUpdateViewModelImpl);
        List<DeliveryCourierOrderParams.FormGroup> groups = deliveryCourierOrderParams.getGroups();
        if (groups != null) {
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                List<ParameterSlot> formSections = it.next().getFormSections();
                if (formSections != null) {
                    for (T t2 : formSections) {
                        T t3 = !(t2 instanceof BaseParameter) ? null : t2;
                        if ((t3 != null ? t3.getRequired() : false) && (t2 instanceof EditableParameter)) {
                            deliveryCourierOrderUpdateViewModelImpl.v.add(t2.getId());
                        }
                    }
                }
            }
        }
    }

    public static final void access$updateView(DeliveryCourierOrderUpdateViewModelImpl deliveryCourierOrderUpdateViewModelImpl, List list) {
        AdapterPresenter adapterPresenter = deliveryCourierOrderUpdateViewModelImpl.q;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(list, adapterPresenter);
        }
        deliveryCourierOrderUpdateViewModelImpl.r = list;
    }

    public final void c() {
        Disposable subscribe = this.n.observeOn(this.B.mainThread()).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "textChangesRelay\n       …          }\n            )");
        DisposableKt.addTo(subscribe, this.p);
    }

    public final void d() {
        Disposable subscribe = this.l.observeOn(this.B.mainThread()).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new g(this), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "selectDeepLinkClickRelay…          }\n            )");
        DisposableKt.addTo(subscribe, this.p);
    }

    public final void e(String str) {
        String str2 = this.s;
        if (str2 != null) {
            List<Item> applyParameterValue = this.C.applyParameterValue(this.r, str2, str);
            AdapterPresenter adapterPresenter = this.q;
            if (adapterPresenter != null) {
                a2.b.a.a.a.s1(applyParameterValue, adapterPresenter);
            }
            this.r = applyParameterValue;
            this.s = null;
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public Consumer<ParameterElement.SelectDeepLink> getSelectDeepLinkClickConsumer() {
        return this.m;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @Nullable
    public AddressParameter.Value getSelectedAddress() {
        return this.t;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @Nullable
    public TimeInterval getSelectedTimeInterval() {
        return this.u;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    public void loadData() {
        this.F.startLoading();
        Disposable subscribe = this.A.getCourierOrderUpdateParams(this.y, this.z).observeOn(this.B.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getCourierOrd…          }\n            )");
        DisposableKt.addTo(subscribe, this.p);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.p.dispose();
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    public void onLocationSelected(@NotNull AddressParameter.Value value) {
        Intrinsics.checkNotNullParameter(value, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        String text = value.getText();
        if (text == null) {
            text = "";
        }
        e(text);
        this.t = value;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    public void onTimeIntervalSelected(@NotNull TimeInterval timeInterval) {
        Intrinsics.checkNotNullParameter(timeInterval, "timeInterval");
        e(timeInterval.getTitle());
        this.u = timeInterval;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        this.q = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.r));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    public void submitData() {
        String str = this.x;
        String str2 = this.w;
        if (!(str2 == null || str == null)) {
            this.E.trackSubmitButtonClicked(this.z, str2, str, this.y);
        }
        Disposable subscribe = this.A.submitCourierOrderUpdate(this.y, this.z, this.C.getSubmitParametersMap(this.u), this.C.getParametersTrees()).observeOn(this.B.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.submitCourier…          }\n            )");
        DisposableKt.addTo(subscribe, this.p);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public MutableLiveData<String> getCancelButtonTextChanges() {
        return this.k;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public SingleLiveEvent<Integer> getCloseScreenChanges() {
        return this.h;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.e;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public SingleLiveEvent<ParameterElement.SelectDeepLink> getSelectDeepLinkChanges() {
        return this.c;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public MutableLiveData<String> getSnackbarChanges() {
        return this.f;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public MutableLiveData<Boolean> getSubmitButtonEnabledChanges() {
        return this.d;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public MutableLiveData<Boolean> getSubmitButtonSpinnerChanges() {
        return this.g;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public MutableLiveData<String> getSubmitButtonTextChanges() {
        return this.j;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public Relay<ParameterElement> getTextChangesConsumer() {
        return this.o;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel
    @NotNull
    public MutableLiveData<String> getToolbarTitleChanges() {
        return this.i;
    }
}
