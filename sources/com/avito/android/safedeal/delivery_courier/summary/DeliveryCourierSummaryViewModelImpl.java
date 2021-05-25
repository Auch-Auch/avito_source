package com.avito.android.safedeal.delivery_courier.summary;

import a2.a.a.i2.a.b.l;
import a2.a.a.i2.a.b.m;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeliveryCourierOrderPaymentFailureLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.android.safedeal.delivery_courier.analytics.OpenCourierSummaryScreenEvent;
import com.avito.android.safedeal.delivery_courier.analytics.adjust.CourierOrderPaidAdjustEvent;
import com.avito.android.safedeal.delivery_courier.analytics.adjust.OpenCourierSummaryAdjustEvent;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractorImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.DialogState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\\\u0012\u0006\u0010c\u001a\u00020`\u0012\u0006\u0010\u001a\u00020|\u0012\u0006\u0010;\u001a\u000208\u0012\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010T\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010©\u0001\u001a\u00030¦\u0001\u0012\u0006\u0010M\u001a\u00020J\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J#\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u00020\u00032\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J!\u0010+\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.J\u0011\u0010/\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0003H\u0014¢\u0006\u0004\b1\u0010\u0005R\"\u00107\u001a\b\u0012\u0004\u0012\u00020)028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010B\u001a\b\u0012\u0004\u0012\u00020=0<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010I\u001a\u00020C2\u0006\u0010D\u001a\u00020C8\u0016@RX\u000e¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\"\u0010X\u001a\b\u0012\u0004\u0012\u00020U028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bV\u00104\u001a\u0004\bW\u00106R\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010SR\"\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00030<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010?\u001a\u0004\b^\u0010AR\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\"\u0010e\u001a\b\u0012\u0004\u0012\u00020O0<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010?\u001a\u0004\bd\u0010AR\"\u0010h\u001a\b\u0012\u0004\u0012\u00020C0<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bf\u0010?\u001a\u0004\bg\u0010AR\"\u0010o\u001a\b\u0012\u0004\u0012\u00020j0i8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020C0N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010PR\u0016\u0010x\u001a\u00020=8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010{\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010zR\u0016\u0010\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R$\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020U0<8\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b\u0004\u0010?\u001a\u0005\b\u0001\u0010AR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001d\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010SR%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012028\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u00104\u001a\u0005\b\u0001\u00106R%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012028\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u00104\u001a\u0005\b\u0001\u00106R\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020U0N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010PR%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030i8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010l\u001a\u0005\b\u0001\u0010nR'\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020'028\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u00104\u001a\u0005\b\u0001\u00106R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020=0N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010PR%\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\f0i8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b \u0001\u0010l\u001a\u0005\b¡\u0001\u0010nR\u001a\u0010¤\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b£\u0001\u0010SR\u001d\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010PR\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R%\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030i8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bª\u0001\u0010l\u001a\u0005\b«\u0001\u0010nR\u001a\u0010®\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b­\u0001\u0010S¨\u0006±\u0001"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "", "j", "()V", "h", "k", a2.g.r.g.a, "i", "c", "showContent", "Ljava/lang/Runnable;", "retryRunnable", "Lcom/avito/android/remote/error/TypedError;", "error", "e", "(Ljava/lang/Runnable;Lcom/avito/android/remote/error/TypedError;)V", "", "message", "f", "(Ljava/lang/String;)V", "", "Lcom/avito/conveyor_item/Item;", "items", "l", "(Ljava/util/List;)V", "", "errors", "d", "(Ljava/util/Map;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "location", "onLocationSelected", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "", "success", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onCompletePaymentResult", "(ZLcom/avito/android/deep_linking/links/DeepLink;)V", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "getSelectedAddress", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "onCleared", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "u", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getDeepLinkChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "deepLinkChanges", "Lcom/avito/android/util/SchedulersFactory;", "I", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", "n", "Lio/reactivex/functions/Consumer;", "getCourierServiceChangeConsumer", "()Lio/reactivex/functions/Consumer;", "courierServiceChangeConsumer", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", "<set-?>", "F", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", "getDialogState", "()Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", "dialogState", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", "M", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", "resourceProvider", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/jakewharton/rxrelay2/Relay;", "changeRelay", "K", "Ljava/lang/String;", "searchContext", "Lcom/avito/android/category_parameters/ParameterElement$SelectDeepLink;", "o", "getSelectDeepLinkChanges", "selectDeepLinkChanges", "x", "Ljava/util/List;", "listItems", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "paymentUrl", "getSubmitButtonClickConsumer", "submitButtonClickConsumer", "Lcom/avito/android/analytics/Analytics;", "G", "Lcom/avito/android/analytics/Analytics;", "analytics", "getChangeConsumer", "changeConsumer", AuthSource.OPEN_CHANNEL_LIST, "getDialogStateConsumer", "dialogStateConsumer", "Landroidx/lifecycle/MutableLiveData;", "", "p", "Landroidx/lifecycle/MutableLiveData;", "getErrorPositionChanges", "()Landroidx/lifecycle/MutableLiveData;", "errorPositionChanges", "y", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "B", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "selectedAddress", "dialogStateChangeRelay", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", "selectedService", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;", "H", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;", "interactor", "getSelectDeepLinkClickConsumer", "selectDeepLinkClickConsumer", "Lcom/avito/android/account/AccountStateProvider;", "N", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "loadSummaryDisposable", "C", "lastProviderKey", VKApiConst.VERSION, "getPayUrlChanges", "payUrlChanges", "t", "getSnackBarChanges", "snackBarChanges", "selectDeepLinkClickRelay", VKApiConst.Q, "getShowContentChanges", "showContentChanges", "D", "Ljava/util/Map;", "lastParametersMap", "w", "getCloseScreenChanges", "closeScreenChanges", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "O", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "courierServiceChangeRelay", "s", "getErrorChanges", "errorChanges", "J", BookingInfoActivity.EXTRA_ITEM_ID, "submitButtonClickRelay", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;", "L", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;", "converter", "r", "getProgressChanges", "progressChanges", "z", "selectItemId", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierSummaryViewModelImpl extends ViewModel implements DeliveryCourierSummaryViewModel {
    public String A;
    public AddressParameter.Value B;
    public String C;
    public Map<String, String> D;
    public BaseCourierServiceItem E;
    @NotNull
    public DialogState F;
    public final Analytics G;
    public final DeliveryCourierSummaryInteractor H;
    public final SchedulersFactory I;
    public final String J;
    public final String K;
    public final DeliveryCourierSummaryItemsConverter L;
    public final DeliveryCourierSummaryResourceProvider M;
    public final AccountStateProvider N;
    public final BaseScreenPerformanceTracker O;
    public final CompositeDisposable c = new CompositeDisposable();
    public Disposable d;
    public final Relay<ParameterElement.SelectDeepLink> e;
    public final Relay<ParameterElement> f;
    public final Relay<Unit> g;
    public final Relay<DialogState> h;
    public final Relay<BaseCourierServiceItem> i;
    @NotNull
    public final Consumer<ParameterElement.SelectDeepLink> j;
    @NotNull
    public final Consumer<ParameterElement> k;
    @NotNull
    public final Consumer<Unit> l;
    @NotNull
    public final Consumer<DialogState> m;
    @NotNull
    public final Consumer<BaseCourierServiceItem> n;
    @NotNull
    public final SingleLiveEvent<ParameterElement.SelectDeepLink> o;
    @NotNull
    public final MutableLiveData<Integer> p;
    @NotNull
    public final MutableLiveData<Unit> q;
    @NotNull
    public final MutableLiveData<Unit> r;
    @NotNull
    public final MutableLiveData<Runnable> s;
    @NotNull
    public final SingleLiveEvent<String> t;
    @NotNull
    public final SingleLiveEvent<DeepLink> u;
    @NotNull
    public final SingleLiveEvent<String> v;
    @NotNull
    public final SingleLiveEvent<Boolean> w;
    public List<? extends Item> x;
    public AdapterPresenter y;
    public String z;

    public static final class a implements Runnable {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public a(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c();
        }
    }

    public static final class b<T> implements Consumer<DialogState> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public b(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DialogState dialogState) {
            DialogState dialogState2 = dialogState;
            DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(dialogState2, "it");
            deliveryCourierSummaryViewModelImpl.F = dialogState2;
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public c(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.g();
        }
    }

    public static final class d<T> implements Consumer<ParameterElement> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public d(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement parameterElement) {
            String value;
            ParameterElement parameterElement2 = parameterElement;
            if (parameterElement2 instanceof ParameterElement.Input) {
                String value2 = ((ParameterElement.Input) parameterElement2).getValue();
                if (value2 != null) {
                    DeliveryCourierSummaryViewModelImpl.access$onElementValueChanged(this.a, parameterElement2, value2);
                }
            } else if ((parameterElement2 instanceof ParameterElement.SelectDeepLink) && (value = ((ParameterElement.SelectDeepLink) parameterElement2).getValue()) != null) {
                DeliveryCourierSummaryViewModelImpl.access$onElementValueChanged(this.a, parameterElement2, value);
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public e(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            DeliveryCourierSummaryViewModelImpl.access$showUnknownError(this.a);
            this.a.h();
        }
    }

    public static final class f<T> implements Consumer<BaseCourierServiceItem> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public f(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BaseCourierServiceItem baseCourierServiceItem) {
            BaseCourierServiceItem baseCourierServiceItem2 = baseCourierServiceItem;
            if (this.a.E == null || !Intrinsics.areEqual(baseCourierServiceItem2, DeliveryCourierSummaryViewModelImpl.access$getSelectedService$p(this.a))) {
                DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(baseCourierServiceItem2, NotificationCompat.CATEGORY_SERVICE);
                deliveryCourierSummaryViewModelImpl.E = baseCourierServiceItem2;
                DeliveryCourierSummaryViewModelImpl.access$showItems(this.a, this.a.L.updateCost(this.a.x, DeliveryCourierSummaryViewModelImpl.access$getSelectedService$p(this.a)));
            }
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public g(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.i();
        }
    }

    public static final class h<T> implements Consumer<ParameterElement.SelectDeepLink> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public h(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.SelectDeepLink selectDeepLink) {
            ParameterElement.SelectDeepLink selectDeepLink2 = selectDeepLink;
            this.a.z = selectDeepLink2.getStringId();
            SingleLiveEvent<ParameterElement.SelectDeepLink> selectDeepLinkChanges = this.a.getSelectDeepLinkChanges();
            Intrinsics.checkNotNullExpressionValue(selectDeepLink2, "it");
            selectDeepLinkChanges.setValue(selectDeepLink2);
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public i(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl = this.a;
            DeliveryCourierSummaryViewModelImpl.access$showSnackBarMessage(deliveryCourierSummaryViewModelImpl, deliveryCourierSummaryViewModelImpl.M.getSelectDeeplinkError());
            this.a.j();
        }
    }

    public static final class j<T> implements Consumer<Unit> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public j(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            ParametersTree parametersTree = this.a.L.getParametersTree();
            String str = this.a.A;
            boolean z = true;
            if (!(!Intrinsics.areEqual(DeliveryCourierSummaryViewModelImpl.access$getSelectedService$p(this.a).getStringId(), this.a.C)) && !(!Intrinsics.areEqual(this.a.L.getParametersMap(), this.a.D))) {
                z = false;
            }
            if (!z && str != null) {
                this.a.getPayUrlChanges().setValue(str);
            } else if (parametersTree != null) {
                DeliveryCourierSummaryViewModelImpl.access$validateFields(this.a, parametersTree);
            } else {
                DeliveryCourierSummaryViewModelImpl.access$showUnknownError(this.a);
            }
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryCourierSummaryViewModelImpl a;

        public k(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
            this.a = deliveryCourierSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            DeliveryCourierSummaryViewModelImpl.access$showUnknownError(this.a);
            this.a.k();
        }
    }

    public DeliveryCourierSummaryViewModelImpl(@NotNull Analytics analytics, @NotNull DeliveryCourierSummaryInteractor deliveryCourierSummaryInteractor, @NotNull SchedulersFactory schedulersFactory, @Nullable String str, @Nullable String str2, @NotNull DeliveryCourierSummaryItemsConverter deliveryCourierSummaryItemsConverter, @NotNull DeliveryCourierSummaryResourceProvider deliveryCourierSummaryResourceProvider, @NotNull AccountStateProvider accountStateProvider, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryItemsConverter, "converter");
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.G = analytics;
        this.H = deliveryCourierSummaryInteractor;
        this.I = schedulersFactory;
        this.J = str;
        this.K = str2;
        this.L = deliveryCourierSummaryItemsConverter;
        this.M = deliveryCourierSummaryResourceProvider;
        this.N = accountStateProvider;
        this.O = baseScreenPerformanceTracker;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.e = create;
        BehaviorRelay create2 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "BehaviorRelay.create()");
        this.f = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.g = create3;
        PublishRelay create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.h = create4;
        PublishRelay create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.i = create5;
        this.j = create;
        this.k = create2;
        this.l = create3;
        this.m = create4;
        this.n = create5;
        this.o = new SingleLiveEvent<>();
        this.p = new MutableLiveData<>();
        this.q = new MutableLiveData<>();
        this.r = new MutableLiveData<>();
        this.s = new MutableLiveData<>();
        this.t = new SingleLiveEvent<>();
        this.u = new SingleLiveEvent<>();
        this.v = new SingleLiveEvent<>();
        this.w = new SingleLiveEvent<>();
        this.x = CollectionsKt__CollectionsKt.emptyList();
        this.F = DialogState.HIDDEN;
        h();
        j();
        k();
        g();
        i();
        c();
        analytics.track(new OpenCourierSummaryAdjustEvent());
    }

    public static final /* synthetic */ BaseCourierServiceItem access$getSelectedService$p(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
        BaseCourierServiceItem baseCourierServiceItem = deliveryCourierSummaryViewModelImpl.E;
        if (baseCourierServiceItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedService");
        }
        return baseCourierServiceItem;
    }

    public static final void access$onElementValueChanged(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl, Item item, String str) {
        deliveryCourierSummaryViewModelImpl.L.onParameterValueChanged(item.getStringId(), str);
    }

    public static final void access$onSummaryLoaded(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl, DeliveryCourierSummary deliveryCourierSummary) {
        deliveryCourierSummaryViewModelImpl.O.trackLoaded();
        deliveryCourierSummaryViewModelImpl.O.startPreparing();
        deliveryCourierSummaryViewModelImpl.B = deliveryCourierSummary.getLastAddress();
        List<Item> convert = deliveryCourierSummaryViewModelImpl.L.convert(deliveryCourierSummary, deliveryCourierSummaryViewModelImpl);
        deliveryCourierSummaryViewModelImpl.O.trackPrepared();
        deliveryCourierSummaryViewModelImpl.O.startDrawing();
        AdapterPresenter adapterPresenter = deliveryCourierSummaryViewModelImpl.y;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(convert, adapterPresenter);
        }
        deliveryCourierSummaryViewModelImpl.x = convert;
        deliveryCourierSummaryViewModelImpl.showContent();
        deliveryCourierSummaryViewModelImpl.O.trackDrawn();
    }

    public static final void access$showError(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl, TypedError typedError) {
        deliveryCourierSummaryViewModelImpl.showContent();
        if (typedError instanceof ErrorWithMessage) {
            deliveryCourierSummaryViewModelImpl.f(((ErrorWithMessage) typedError).getMessage());
        } else if (typedError instanceof DeliveryCourierSummaryInteractorImpl.IncorrectField) {
            deliveryCourierSummaryViewModelImpl.d(((DeliveryCourierSummaryInteractorImpl.IncorrectField) typedError).getMap());
        } else {
            deliveryCourierSummaryViewModelImpl.f(deliveryCourierSummaryViewModelImpl.M.getErrorOccurred());
        }
    }

    public static final void access$showFullScreenProgress(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
        deliveryCourierSummaryViewModelImpl.getShowContentChanges().setValue(null);
        deliveryCourierSummaryViewModelImpl.getErrorChanges().setValue(null);
        deliveryCourierSummaryViewModelImpl.getProgressChanges().setValue(Unit.INSTANCE);
    }

    public static final void access$showItems(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl, List list) {
        AdapterPresenter adapterPresenter = deliveryCourierSummaryViewModelImpl.y;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(list, adapterPresenter);
        }
        deliveryCourierSummaryViewModelImpl.x = list;
        deliveryCourierSummaryViewModelImpl.showContent();
    }

    public static final void access$showSnackBarMessage(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl, String str) {
        deliveryCourierSummaryViewModelImpl.getSnackBarChanges().postValue(str);
    }

    public static final void access$showUnknownError(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl) {
        deliveryCourierSummaryViewModelImpl.f(deliveryCourierSummaryViewModelImpl.M.getErrorOccurred());
    }

    public static final void access$validateFields(DeliveryCourierSummaryViewModelImpl deliveryCourierSummaryViewModelImpl, ParametersTree parametersTree) {
        CompositeDisposable compositeDisposable = deliveryCourierSummaryViewModelImpl.c;
        Disposable subscribe = deliveryCourierSummaryViewModelImpl.H.validateFields(parametersTree).observeOn(deliveryCourierSummaryViewModelImpl.I.mainThread()).subscribe(new l(deliveryCourierSummaryViewModelImpl), new m(deliveryCourierSummaryViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.validateField…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void c() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.O.startLoading();
        String str = this.J;
        if (str != null) {
            Disposable subscribe = this.H.getOrderSummary(str).observeOn(this.I.mainThread()).subscribe(new a2.a.a.i2.a.b.i(this), new a2.a.a.i2.a.b.k(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(schedulers.mai…          }\n            )");
            this.d = subscribe;
            String currentUserId = this.N.getCurrentUserId();
            if (currentUserId != null) {
                this.G.track(new OpenCourierSummaryScreenEvent(currentUserId, str));
                return;
            }
            return;
        }
        e(new a(this), null);
    }

    public final void d(Map<String, String> map) {
        List<Item> applyErrors = this.L.applyErrors(map, this.x);
        this.x = applyErrors;
        l(applyErrors);
        Integer firstErrorPosition = this.L.getFirstErrorPosition(this.x);
        if (firstErrorPosition != null) {
            getErrorPositionChanges().setValue(Integer.valueOf(firstErrorPosition.intValue()));
            getErrorPositionChanges().setValue(null);
        }
        if (map.isEmpty()) {
            String str = this.J;
            Map<String, String> parametersMap = this.L.getParametersMap();
            BaseCourierServiceItem baseCourierServiceItem = this.E;
            String stringId = baseCourierServiceItem != null ? baseCourierServiceItem.getStringId() : "dostavista";
            if (str == null || !(!parametersMap.isEmpty())) {
                showContent();
                f(this.M.getErrorOccurred());
                return;
            }
            this.C = stringId;
            this.D = parametersMap;
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = this.H.createOrder(str, stringId, parametersMap).observeOn(this.I.mainThread()).subscribe(new a2.a.a.i2.a.b.f(this), new a2.a.a.i2.a.b.g(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n             …      }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        showContent();
    }

    public final void e(Runnable runnable, TypedError typedError) {
        this.O.trackLoadingError();
        getShowContentChanges().setValue(null);
        getErrorChanges().setValue(runnable);
        getProgressChanges().setValue(null);
        this.O.startDrawing();
        if (typedError instanceof ErrorWithMessage) {
            f(((ErrorWithMessage) typedError).getMessage());
        } else {
            f(this.M.getErrorOccurred());
        }
        this.O.trackDrawnError();
    }

    public final void f(String str) {
        getSnackBarChanges().postValue(str);
    }

    public final void g() {
        Disposable subscribe = this.h.observeOn(this.I.mainThread()).subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "dialogStateChangeRelay\n …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public Consumer<ParameterElement> getChangeConsumer() {
        return this.k;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public Consumer<BaseCourierServiceItem> getCourierServiceChangeConsumer() {
        return this.n;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public DialogState getDialogState() {
        return this.F;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public Consumer<DialogState> getDialogStateConsumer() {
        return this.m;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public Consumer<ParameterElement.SelectDeepLink> getSelectDeepLinkClickConsumer() {
        return this.j;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @Nullable
    public AddressParameter.Value getSelectedAddress() {
        return this.B;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public Consumer<Unit> getSubmitButtonClickConsumer() {
        return this.l;
    }

    public final void h() {
        Disposable subscribe = this.f.subscribe(new d(this), new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "changeRelay\n            …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void i() {
        Disposable subscribe = this.i.observeOn(this.I.mainThread()).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "courierServiceChangeRela…          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void j() {
        Disposable subscribe = this.e.observeOn(this.I.mainThread()).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new h(this), new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "selectDeepLinkClickRelay…          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void k() {
        Disposable subscribe = this.g.observeOn(this.I.mainThread()).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new j(this), new k(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "submitButtonClickRelay\n …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void l(List<? extends Item> list) {
        AdapterPresenter adapterPresenter = this.y;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(list, adapterPresenter);
        }
        this.x = list;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    public void onCompletePaymentResult(boolean z2, @Nullable DeepLink deepLink) {
        showContent();
        if (!z2) {
            return;
        }
        if (deepLink == null) {
            f(this.M.getPaymentError());
        } else if (deepLink instanceof DeliveryCourierOrderPaymentFailureLink) {
            f(((DeliveryCourierOrderPaymentFailureLink) deepLink).getMessage());
        } else {
            getCloseScreenChanges().setValue(Boolean.TRUE);
            getDeepLinkChanges().setValue(deepLink);
            String str = this.J;
            if (str != null) {
                this.G.track(new CourierOrderPaidAdjustEvent(str));
            }
        }
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        getDeepLinkChanges().setValue(deepLink);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    public void onLocationSelected(@NotNull AddressParameter.Value value) {
        Intrinsics.checkNotNullParameter(value, "location");
        String text = value.getText();
        if (text == null) {
            text = "";
        }
        String str = this.z;
        if (str != null) {
            l(this.L.applyParameterValue(this.x, str, text));
            this.z = null;
        }
        this.B = value;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.y = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.x));
    }

    public final void showContent() {
        getShowContentChanges().setValue(Unit.INSTANCE);
        getErrorChanges().setValue(null);
        getProgressChanges().setValue(null);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public SingleLiveEvent<Boolean> getCloseScreenChanges() {
        return this.w;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getDeepLinkChanges() {
        return this.u;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public MutableLiveData<Runnable> getErrorChanges() {
        return this.s;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public MutableLiveData<Integer> getErrorPositionChanges() {
        return this.p;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public SingleLiveEvent<String> getPayUrlChanges() {
        return this.v;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public MutableLiveData<Unit> getProgressChanges() {
        return this.r;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public SingleLiveEvent<ParameterElement.SelectDeepLink> getSelectDeepLinkChanges() {
        return this.o;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public MutableLiveData<Unit> getShowContentChanges() {
        return this.q;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel
    @NotNull
    public SingleLiveEvent<String> getSnackBarChanges() {
        return this.t;
    }
}
