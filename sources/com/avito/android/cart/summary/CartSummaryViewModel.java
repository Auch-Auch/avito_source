package com.avito.android.cart.summary;

import a2.a.a.a0.a.o;
import a2.a.a.a0.a.p;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.cart.summary.CartSummaryView;
import com.avito.android.cart.summary.konveyor.CartSummaryItemsConverter;
import com.avito.android.cart.summary.konveyor.price.PriceItem;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.cart.model.Action;
import com.avito.android.remote.cart.model.Banner;
import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.remote.cart.model.CheckQuantityResponse;
import com.avito.android.remote.cart.model.DeleteItemResponse;
import com.avito.android.remote.cart.model.Price;
import com.avito.android.remote.cart.model.Store;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0001B±\u0001\u0012\u0006\u0010{\u001a\u00020x\u0012\u0006\u0010b\u001a\u00020_\u0012\u0007\u0010\u0001\u001a\u00020~\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010[\u001a\u00020X\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u001c\u0010<\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209070)j\u0002`:\u0012\u0010\u0010w\u001a\f\u0012\u0004\u0012\u0002080)j\u0002`u\u0012\u0010\u0010-\u001a\f\u0012\u0004\u0012\u00020\u00150)j\u0002`*\u0012\u001f\u0010\u0001\u001a\u001a\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u000208\u0012\u0005\u0012\u00030\u0001070)j\u0003`\u0001\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0006\b\u0001\u0010\u0001J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ)\u0010\u0017\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u000eR\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010-\u001a\f\u0012\u0004\u0012\u00020\u00150)j\u0002`*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010'R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u00105R,\u0010<\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209070)j\u0002`:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010,R\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010!\u001a\u0004\b>\u0010#R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020@0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010'R\u0018\u0010E\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010'R!\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010!\u001a\u0004\bJ\u0010#R\u001f\u0010N\u001a\b\u0012\u0004\u0012\u00020\b0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010!\u001a\u0004\bM\u0010#R\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020P0O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u001f\u0010e\u001a\b\u0012\u0004\u0012\u00020@0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\bc\u0010!\u001a\u0004\bd\u0010#R\u0018\u0010f\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010]R!\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010P0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010!\u001a\u0004\bh\u0010#R\u001e\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010RR\u001f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8\u0006@\u0006¢\u0006\f\n\u0004\bl\u0010!\u001a\u0004\bm\u0010#R\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010oR\u001f\u0010t\u001a\b\u0012\u0004\u0012\u00020q0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\br\u0010!\u001a\u0004\bs\u0010#R \u0010w\u001a\f\u0012\u0004\u0012\u0002080)j\u0002`u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010,R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010DR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u001c\u0010}\u001a\b\u0012\u0004\u0012\u00020q0O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010RR\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0%8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010'R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R0\u0010\u0001\u001a\u001a\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u000208\u0012\u0005\u0012\u00030\u0001070)j\u0003`\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010,R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150%8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010'R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010\u0001R\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010!\u001a\u0005\b\u0001\u0010#R\u001f\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00128B@\u0002X\u0004¢\u0006\u0007\u001a\u0005\bC\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "", "fullScreenLoading", "", "onRefresh", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onSubmitClicked", "onCleared", "()V", a2.g.r.g.a, "f", "e", "", "Lcom/avito/conveyor_item/Item;", "items", "", "screenTitle", "i", "(Ljava/util/List;Ljava/lang/String;)V", "errorMsg", "", "throwable", "d", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "h", "Landroidx/lifecycle/LiveData;", "z", "Landroidx/lifecycle/LiveData;", "getSnackbarErrorMessagesChanges", "()Landroidx/lifecycle/LiveData;", "snackbarErrorMessagesChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "p", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "snackbarErrorMessagesLiveData", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/cart/summary/OpenAdvertDetailsObservable;", "K", "Lio/reactivex/rxjava3/core/Observable;", "openAdvertDetailsObservable", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "M", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "k", "requestAuthLiveData", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lkotlin/Pair;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "", "Lcom/avito/android/cart/summary/QuantityChangesObservable;", "I", "quantityChanges", "s", "getStopRefresh", "stopRefresh", "Landroid/content/Intent;", "r", "intentsLiveData", "c", "Ljava/lang/String;", "xHash", "n", "stopRefreshLiveData", "Lcom/avito/android/remote/cart/model/Banner;", "w", "getAlertBannerChanges", "alertBannerChanges", "x", "getDeepLinks", "deepLinks", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/cart/summary/CartSummaryView$SubmitButton;", "l", "Landroidx/lifecycle/MutableLiveData;", "submitButtonLiveData", "Lcom/avito/android/cart/summary/CartSummaryResourceProvider;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/cart/summary/CartSummaryResourceProvider;", "resourceProvider", "Lcom/avito/android/account/AccountStateProvider;", "F", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "checkQuantityDisposable", "Lcom/avito/android/cart/summary/CartSummaryRepository;", "C", "Lcom/avito/android/cart/summary/CartSummaryRepository;", "repository", "y", "getIntents", "intents", "checkQuantityOnSubmitDisposable", VKApiConst.VERSION, "getSubmitButtonChanges", "submitButtonChanges", "o", "alertBannerLiveData", "u", "getRequestAuth", "requestAuth", "Ljava/util/List;", "listItems", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState;", "t", "getScreenStateChanges", "screenStateChanges", "Lcom/avito/android/cart/summary/DeleteItemObservable;", "J", "deleteItemObservable", "Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", "B", "Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", "analytics", "j", "screenStateLiveData", "Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;", "D", "Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;", "itemsConverter", AuthSource.OPEN_CHANNEL_LIST, "deepLinksLiveData", "Lcom/avito/android/util/SchedulersFactory3;", "G", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/ActivityIntentFactory;", "H", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/cart/analytics/summary/StepperUsageType;", "Lcom/avito/android/cart/summary/StepperUsageObservable;", "L", "stepperUsageObservable", VKApiConst.Q, "snackbarInfoMessagesLiveData", "Lcom/avito/android/remote/cart/model/CartSummary$EmptyCart;", "Lcom/avito/android/remote/cart/model/CartSummary$EmptyCart;", "emptyCart", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getSnackbarInfoMessagesChanges", "snackbarInfoMessagesChanges", "Lcom/avito/android/cart/summary/ItemQuantity;", "()Ljava/util/List;", "itemsQuantity", "<init>", "(Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;Lcom/avito/android/cart/summary/CartSummaryRepository;Lcom/avito/android/cart/summary/konveyor/CartSummaryItemsConverter;Lcom/avito/android/cart/summary/CartSummaryResourceProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/ActivityIntentFactory;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "ScreenState", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CartSummaryViewModel extends ViewModel implements OnDeepLinkClickListener {
    @NotNull
    public final LiveData<String> A;
    public final CartSummaryAnalyticsTracker B;
    public final CartSummaryRepository C;
    public final CartSummaryItemsConverter D;
    public final CartSummaryResourceProvider E;
    public final AccountStateProvider F;
    public final SchedulersFactory3 G;
    public final ActivityIntentFactory H;
    public final Observable<Pair<ProductItem, Integer>> I;
    public final Observable<ProductItem> J;
    public final Observable<String> K;
    public final Observable<Pair<ProductItem, StepperUsageType>> L;
    public final BaseScreenPerformanceTracker M;
    public String c;
    public String d;
    public CartSummary.EmptyCart e;
    public List<? extends Item> f = CollectionsKt__CollectionsKt.emptyList();
    public final CompositeDisposable g;
    public Disposable h;
    public Disposable i;
    public final MutableLiveData<ScreenState> j;
    public final SingleLiveEvent<Unit> k;
    public final MutableLiveData<CartSummaryView.SubmitButton> l;
    public final SingleLiveEvent<DeepLink> m;
    public final SingleLiveEvent<Unit> n;
    public final MutableLiveData<Banner> o;
    public final SingleLiveEvent<String> p;
    public final SingleLiveEvent<String> q;
    public final SingleLiveEvent<Intent> r;
    @NotNull
    public final LiveData<Unit> s;
    @NotNull
    public final LiveData<ScreenState> t;
    @NotNull
    public final LiveData<Unit> u;
    @NotNull
    public final LiveData<CartSummaryView.SubmitButton> v;
    @NotNull
    public final LiveData<Banner> w;
    @NotNull
    public final LiveData<DeepLink> x;
    @NotNull
    public final LiveData<Intent> y;
    @NotNull
    public final LiveData<String> z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState;", "", "<init>", "()V", "Empty", "Error", "Loaded", "Loading", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Loading;", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Empty;", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Loaded;", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Error;", "cart_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ScreenState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Empty;", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState;", "Lcom/avito/android/remote/cart/model/CartSummary$EmptyCart;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/cart/model/CartSummary$EmptyCart;", "getData", "()Lcom/avito/android/remote/cart/model/CartSummary$EmptyCart;", "data", "<init>", "(Lcom/avito/android/remote/cart/model/CartSummary$EmptyCart;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends ScreenState {
            @Nullable
            public final CartSummary.EmptyCart a;

            public Empty(@Nullable CartSummary.EmptyCart emptyCart) {
                super(null);
                this.a = emptyCart;
            }

            @Nullable
            public final CartSummary.EmptyCart getData() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Error;", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ScreenState {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Loaded;", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "component2", "()Ljava/util/List;", "screenTitle", "items", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getScreenTitle", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends ScreenState {
            @Nullable
            public final String a;
            @NotNull
            public final List<Item> b;

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@Nullable String str, @NotNull List<? extends Item> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "items");
                this.a = str;
                this.b = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.cart.summary.CartSummaryViewModel$ScreenState$Loaded */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.a;
                }
                if ((i & 2) != 0) {
                    list = loaded.b;
                }
                return loaded.copy(str, list);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final List<Item> component2() {
                return this.b;
            }

            @NotNull
            public final Loaded copy(@Nullable String str, @NotNull List<? extends Item> list) {
                Intrinsics.checkNotNullParameter(list, "items");
                return new Loaded(str, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                return Intrinsics.areEqual(this.a, loaded.a) && Intrinsics.areEqual(this.b, loaded.b);
            }

            @NotNull
            public final List<Item> getItems() {
                return this.b;
            }

            @Nullable
            public final String getScreenTitle() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<Item> list = this.b;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Loaded(screenTitle=");
                L.append(this.a);
                L.append(", items=");
                return a2.b.a.a.a.w(L, this.b, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState$Loading;", "Lcom/avito/android/cart/summary/CartSummaryViewModel$ScreenState;", "", AuthSource.SEND_ABUSE, "Z", "isFullScreen", "()Z", "<init>", "(Z)V", "cart_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ScreenState {
            public final boolean a;

            public Loading(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean isFullScreen() {
                return this.a;
            }
        }

        public ScreenState() {
        }

        public ScreenState(t6.r.a.j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ CartSummaryViewModel a;

        public a(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            CartSummaryViewModel.access$setSubmitButtonLoading(this.a, true);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ CartSummaryViewModel a;

        public b(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            CartSummaryViewModel.access$setSubmitButtonLoading(this.a, false);
        }
    }

    public static final class c<T> implements Consumer<CheckQuantityResponse> {
        public final /* synthetic */ CartSummaryViewModel a;
        public final /* synthetic */ DeepLink b;

        public c(CartSummaryViewModel cartSummaryViewModel, DeepLink deepLink) {
            this.a = cartSummaryViewModel;
            this.b = deepLink;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(CheckQuantityResponse checkQuantityResponse) {
            CheckQuantityResponse checkQuantityResponse2 = checkQuantityResponse;
            CartSummaryViewModel cartSummaryViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(checkQuantityResponse2, "resp");
            CartSummaryViewModel.access$updateQuantity(cartSummaryViewModel, checkQuantityResponse2);
            CartSummaryViewModel.access$handleActions(this.a, checkQuantityResponse2.getActions());
            if (checkQuantityResponse2.getBanner() == null) {
                this.a.onDeepLinkClick(this.b);
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ CartSummaryViewModel a;

        public d(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            SingleLiveEvent singleLiveEvent = this.a.p;
            String access$tryExtractErrorMessage = CartSummaryViewModel.access$tryExtractErrorMessage(this.a, th2);
            if (access$tryExtractErrorMessage == null) {
                access$tryExtractErrorMessage = this.a.E.getCheckQuantityErrorMsg();
            }
            singleLiveEvent.postValue(access$tryExtractErrorMessage);
            Logs.error$default("CART_SUMMARY", "failed to check quantity: " + th2, null, 4, null);
        }
    }

    public static final class e<T, R> implements Function<ProductItem, SingleSource<? extends Pair<? extends String, ? extends DeleteItemResponse>>> {
        public final /* synthetic */ CartSummaryViewModel a;

        public e(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Pair<? extends String, ? extends DeleteItemResponse>> apply(ProductItem productItem) {
            String stringId = productItem.getStringId();
            Single<R> flatMap = this.a.C.deleteItem(stringId).flatMap(CartSummaryViewModel$subscribeToItemsDeletions$1$$special$$inlined$toTyped$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
            return flatMap.map(new a2.a.a.a0.a.n(stringId));
        }
    }

    public static final class f<T> implements Consumer<Pair<? extends String, ? extends DeleteItemResponse>> {
        public final /* synthetic */ CartSummaryViewModel a;

        public f(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Pair<? extends String, ? extends DeleteItemResponse> pair) {
            Pair<? extends String, ? extends DeleteItemResponse> pair2 = pair;
            String str = (String) pair2.component1();
            DeleteItemResponse deleteItemResponse = (DeleteItemResponse) pair2.component2();
            this.a.o.postValue(deleteItemResponse.getBanner());
            List<Price> updatedPrices = deleteItemResponse.getUpdatedPrices();
            List<PriceItem> convert = updatedPrices != null ? this.a.D.convert(updatedPrices) : null;
            if (convert == null) {
                convert = CollectionsKt__CollectionsKt.emptyList();
            }
            List list = this.a.f;
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (!Intrinsics.areEqual(t.getStringId(), str)) {
                    arrayList.add(t);
                }
            }
            this.a.i(CartSummaryItemsOperationsKt.replaceTotals(CartSummaryItemsOperationsKt.updateStoresAfterDeletion(arrayList, deleteItemResponse.getStores()), convert), deleteItemResponse.getScreenTitle());
            this.a.B.trackItemDeleted(str, this.a.c(), "swipe_card");
            CartSummaryViewModel.access$handleActions(this.a, deleteItemResponse.getActions());
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ CartSummaryViewModel a;

        public g(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            String access$tryExtractErrorMessage = CartSummaryViewModel.access$tryExtractErrorMessage(this.a, th);
            SingleLiveEvent singleLiveEvent = this.a.p;
            if (access$tryExtractErrorMessage == null) {
                access$tryExtractErrorMessage = this.a.E.getItemDeletionErrorMsg();
            }
            singleLiveEvent.postValue(access$tryExtractErrorMessage);
            Logs.error$default("CART_SUMMARY", "An error occurred during item deletion", null, 4, null);
            this.a.e();
        }
    }

    public static final class h<T> implements Consumer<Pair<? extends ProductItem, ? extends Integer>> {
        public final /* synthetic */ CartSummaryViewModel a;

        public h(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Pair<? extends ProductItem, ? extends Integer> pair) {
            T t;
            boolean z;
            Pair<? extends ProductItem, ? extends Integer> pair2 = pair;
            ProductItem productItem = (ProductItem) pair2.component1();
            int intValue = ((Number) pair2.component2()).intValue();
            Iterator<T> it = this.a.f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                T t2 = t;
                if (!Intrinsics.areEqual(t2.getStringId(), productItem.getStringId()) || !(t2 instanceof ProductItem)) {
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
            T t3 = t;
            if (t3 instanceof ProductItem) {
                T t4 = t3;
                t4.setStepper(Store.Item.Stepper.copy$default(t4.getStepper(), 0, intValue, 1, null));
            }
        }
    }

    public static final class i<T, R> implements Function<Pair<? extends ProductItem, ? extends Integer>, SingleSource<? extends CheckQuantityResponse>> {
        public final /* synthetic */ CartSummaryViewModel a;

        public i(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends CheckQuantityResponse> apply(Pair<? extends ProductItem, ? extends Integer> pair) {
            Disposable disposable = this.a.i;
            if (disposable != null) {
                disposable.dispose();
            }
            Single<R> flatMap = this.a.C.checkQuantity(this.a.c()).flatMap(CartSummaryViewModel$subscribeToQuantityChanges$2$$special$$inlined$toTyped$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
            return flatMap;
        }
    }

    public static final class j<T> implements Consumer<CheckQuantityResponse> {
        public final /* synthetic */ CartSummaryViewModel a;

        public j(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(CheckQuantityResponse checkQuantityResponse) {
            CheckQuantityResponse checkQuantityResponse2 = checkQuantityResponse;
            CartSummaryViewModel cartSummaryViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(checkQuantityResponse2, "it");
            CartSummaryViewModel.access$updateQuantity(cartSummaryViewModel, checkQuantityResponse2);
            CartSummaryViewModel.access$handleActions(this.a, checkQuantityResponse2.getActions());
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public final /* synthetic */ CartSummaryViewModel a;

        public k(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            SingleLiveEvent singleLiveEvent = this.a.p;
            String access$tryExtractErrorMessage = CartSummaryViewModel.access$tryExtractErrorMessage(this.a, th2);
            if (access$tryExtractErrorMessage == null) {
                access$tryExtractErrorMessage = this.a.E.getCheckQuantityErrorMsg();
            }
            singleLiveEvent.postValue(access$tryExtractErrorMessage);
            Logs.error$default("CART_SUMMARY", "failed to check quantity: " + th2, null, 4, null);
            this.a.f();
        }
    }

    public static final class l<T1, T2, R> implements BiFunction<Pair<? extends ProductItem, ? extends Integer>, Pair<? extends ProductItem, ? extends StepperUsageType>, Triple<? extends String, ? extends Integer, ? extends StepperUsageType>> {
        public static final l a = new l();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Triple<? extends String, ? extends Integer, ? extends StepperUsageType> apply(Pair<? extends ProductItem, ? extends Integer> pair, Pair<? extends ProductItem, ? extends StepperUsageType> pair2) {
            Pair<? extends ProductItem, ? extends Integer> pair3 = pair;
            int intValue = ((Number) pair3.component2()).intValue();
            return new Triple<>(((ProductItem) pair3.component1()).getStringId(), Integer.valueOf(intValue), (StepperUsageType) pair2.component2());
        }
    }

    public static final class m<T> implements Consumer<Triple<? extends String, ? extends Integer, ? extends StepperUsageType>> {
        public final /* synthetic */ CartSummaryViewModel a;

        public m(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Triple<? extends String, ? extends Integer, ? extends StepperUsageType> triple) {
            Triple<? extends String, ? extends Integer, ? extends StepperUsageType> triple2 = triple;
            this.a.B.trackStepperUsage((String) triple2.component1(), ((Number) triple2.component2()).intValue(), (StepperUsageType) triple2.component3());
        }
    }

    public static final class n<T> implements Consumer<Throwable> {
        public final /* synthetic */ CartSummaryViewModel a;

        public n(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.g();
        }
    }

    public CartSummaryViewModel(@NotNull CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker, @NotNull CartSummaryRepository cartSummaryRepository, @NotNull CartSummaryItemsConverter cartSummaryItemsConverter, @NotNull CartSummaryResourceProvider cartSummaryResourceProvider, @NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Observable<Pair<ProductItem, Integer>> observable, @NotNull Observable<ProductItem> observable2, @NotNull Observable<String> observable3, @NotNull Observable<Pair<ProductItem, StepperUsageType>> observable4, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(cartSummaryAnalyticsTracker, "analytics");
        Intrinsics.checkNotNullParameter(cartSummaryRepository, "repository");
        Intrinsics.checkNotNullParameter(cartSummaryItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(cartSummaryResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(observable, "quantityChanges");
        Intrinsics.checkNotNullParameter(observable2, "deleteItemObservable");
        Intrinsics.checkNotNullParameter(observable3, "openAdvertDetailsObservable");
        Intrinsics.checkNotNullParameter(observable4, "stepperUsageObservable");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.B = cartSummaryAnalyticsTracker;
        this.C = cartSummaryRepository;
        this.D = cartSummaryItemsConverter;
        this.E = cartSummaryResourceProvider;
        this.F = accountStateProvider;
        this.G = schedulersFactory3;
        this.H = activityIntentFactory;
        this.I = observable;
        this.J = observable2;
        this.K = observable3;
        this.L = observable4;
        this.M = baseScreenPerformanceTracker;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.g = compositeDisposable;
        MutableLiveData<ScreenState> mutableLiveData = new MutableLiveData<>();
        this.j = mutableLiveData;
        SingleLiveEvent<Unit> singleLiveEvent = new SingleLiveEvent<>();
        this.k = singleLiveEvent;
        MutableLiveData<CartSummaryView.SubmitButton> mutableLiveData2 = new MutableLiveData<>();
        this.l = mutableLiveData2;
        SingleLiveEvent<DeepLink> singleLiveEvent2 = new SingleLiveEvent<>();
        this.m = singleLiveEvent2;
        SingleLiveEvent<Unit> singleLiveEvent3 = new SingleLiveEvent<>();
        this.n = singleLiveEvent3;
        MutableLiveData<Banner> mutableLiveData3 = new MutableLiveData<>(null);
        this.o = mutableLiveData3;
        SingleLiveEvent<String> singleLiveEvent4 = new SingleLiveEvent<>();
        this.p = singleLiveEvent4;
        SingleLiveEvent<String> singleLiveEvent5 = new SingleLiveEvent<>();
        this.q = singleLiveEvent5;
        SingleLiveEvent<Intent> singleLiveEvent6 = new SingleLiveEvent<>();
        this.r = singleLiveEvent6;
        this.s = singleLiveEvent3;
        this.t = mutableLiveData;
        this.u = singleLiveEvent;
        this.v = mutableLiveData2;
        this.w = mutableLiveData3;
        this.x = singleLiveEvent2;
        this.y = singleLiveEvent6;
        this.z = singleLiveEvent4;
        this.A = singleLiveEvent5;
        Disposable subscribe = accountStateProvider.authorized().subscribeOn(schedulersFactory3.io()).distinctUntilChanged().filter(a2.a.a.a0.a.h.a).subscribe(new a2.a.a.a0.a.i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountState.authorized(…iveData.postValue(Unit) }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        f();
        e();
        Disposable subscribe2 = observable3.subscribe(new o(this), p.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "openAdvertDetailsObserva…rror(TAG, it) }\n        )");
        DisposableKt.addTo(subscribe2, compositeDisposable);
        g();
    }

    public static final void access$handleActions(CartSummaryViewModel cartSummaryViewModel, List list) {
        Objects.requireNonNull(cartSummaryViewModel);
        if (list != null) {
            CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker = cartSummaryViewModel.B;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof Action.LogEvent) {
                    arrayList.add(obj);
                }
            }
            cartSummaryAnalyticsTracker.trackEvents(arrayList);
        }
    }

    public static final void access$onEmptyCartLoaded(CartSummaryViewModel cartSummaryViewModel, CartSummary.EmptyCart emptyCart) {
        Objects.requireNonNull(cartSummaryViewModel);
        cartSummaryViewModel.d = emptyCart != null ? emptyCart.getScreenTitle() : null;
        cartSummaryViewModel.h();
        cartSummaryViewModel.j.postValue(new ScreenState.Empty(emptyCart));
        cartSummaryViewModel.B.trackScreenOpened(cartSummaryViewModel.c, CollectionsKt__CollectionsKt.emptyList());
    }

    public static final void access$onFullCartLoaded(CartSummaryViewModel cartSummaryViewModel, CartSummary cartSummary) {
        cartSummaryViewModel.o.postValue(cartSummary.getBanner());
        CartSummary.FullCart fullCart = cartSummary.getFullCart();
        if (fullCart != null) {
            List<Item> convert = cartSummaryViewModel.D.convert(cartSummary);
            cartSummaryViewModel.h();
            cartSummaryViewModel.i(convert, fullCart.getScreenTitle());
            cartSummaryViewModel.l.postValue(new CartSummaryView.SubmitButton(fullCart.getSubmitButton(), false, 2, null));
            List<Store> stores = fullCart.getStores();
            if (stores == null) {
                stores = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = stores.iterator();
            while (it.hasNext()) {
                List<Store.Item> items = it.next().getItems();
                if (items == null) {
                    items = CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(items, 10));
                for (T t2 : items) {
                    arrayList2.add(new ItemQuantity(t2.getId(), t2.getStepper().getQuantity()));
                }
                t6.n.h.addAll(arrayList, arrayList2);
            }
            cartSummaryViewModel.B.trackScreenOpened(cartSummaryViewModel.c, arrayList);
        }
    }

    public static final void access$setSubmitButtonLoading(CartSummaryViewModel cartSummaryViewModel, boolean z2) {
        MutableLiveData<CartSummaryView.SubmitButton> mutableLiveData = cartSummaryViewModel.l;
        CartSummaryView.SubmitButton value = mutableLiveData.getValue();
        CartSummaryView.SubmitButton submitButton = null;
        if (value != null) {
            submitButton = CartSummaryView.SubmitButton.copy$default(value, null, z2, 1, null);
        }
        mutableLiveData.postValue(submitButton);
    }

    public static final void access$showLoading(CartSummaryViewModel cartSummaryViewModel, boolean z2) {
        cartSummaryViewModel.M.startLoading();
        cartSummaryViewModel.j.postValue(new ScreenState.Loading(z2));
    }

    public static final String access$tryExtractErrorMessage(CartSummaryViewModel cartSummaryViewModel, Throwable th) {
        Objects.requireNonNull(cartSummaryViewModel);
        if (!(th instanceof TypedResultException)) {
            th = null;
        }
        TypedResultException typedResultException = (TypedResultException) th;
        TypedError errorResult = typedResultException != null ? typedResultException.getErrorResult() : null;
        if (!(errorResult instanceof ErrorWithMessage)) {
            errorResult = null;
        }
        ErrorWithMessage errorWithMessage = (ErrorWithMessage) errorResult;
        if (errorWithMessage != null) {
            return errorWithMessage.getMessage();
        }
        return null;
    }

    public static final void access$updateQuantity(CartSummaryViewModel cartSummaryViewModel, CheckQuantityResponse checkQuantityResponse) {
        Objects.requireNonNull(cartSummaryViewModel);
        cartSummaryViewModel.d = checkQuantityResponse.getScreenTitle();
        if (checkQuantityResponse.getStores() == null) {
            cartSummaryViewModel.j.postValue(new ScreenState.Empty(cartSummaryViewModel.e));
            return;
        }
        cartSummaryViewModel.o.postValue(checkQuantityResponse.getBanner());
        List<Item> replaceTotals = CartSummaryItemsOperationsKt.replaceTotals(cartSummaryViewModel.f, cartSummaryViewModel.D.convert(checkQuantityResponse.getUpdatedPrices()));
        List<CheckQuantityResponse.Store> stores = checkQuantityResponse.getStores();
        Intrinsics.checkNotNull(stores);
        cartSummaryViewModel.i(CartSummaryItemsOperationsKt.updateStores(replaceTotals, stores), cartSummaryViewModel.d);
    }

    public final List<ItemQuantity> c() {
        List<? extends Item> list = this.f;
        ArrayList<ProductItem> arrayList = new ArrayList();
        for (T t2 : list) {
            if (t2 instanceof ProductItem) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
        for (ProductItem productItem : arrayList) {
            arrayList2.add(new ItemQuantity(productItem.getStringId(), productItem.getStepper().getQuantity()));
        }
        return arrayList2;
    }

    public final void d(String str, Throwable th) {
        this.j.postValue(new ScreenState.Error(str != null ? str : this.E.getGeneralErrorMessage()));
        if (str == null) {
            str = th != null ? th.getMessage() : null;
        }
        Logs.error$default("CART_SUMMARY", a2.b.a.a.a.c3("An error occurred: ", str), null, 4, null);
    }

    public final void e() {
        Disposable subscribe = this.J.flatMapSingle(new e(this)).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "deleteItemObservable\n   …          }\n            )");
        DisposableKt.addTo(subscribe, this.g);
    }

    public final void f() {
        Disposable disposable = this.h;
        if (disposable != null) {
            disposable.dispose();
        }
        this.h = this.I.doOnNext(new h(this)).debounce(400, TimeUnit.MILLISECONDS, this.G.computation()).switchMapSingle(new i(this)).subscribe(new j(this), new k(this));
    }

    public final void g() {
        Disposable subscribe = this.I.withLatestFrom(this.L, l.a).subscribe(new m(this), new n(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "quantityChanges\n        …          }\n            )");
        DisposableKt.addTo(subscribe, this.g);
    }

    @NotNull
    public final LiveData<Banner> getAlertBannerChanges() {
        return this.w;
    }

    @NotNull
    public final LiveData<DeepLink> getDeepLinks() {
        return this.x;
    }

    @NotNull
    public final LiveData<Intent> getIntents() {
        return this.y;
    }

    @NotNull
    public final LiveData<Unit> getRequestAuth() {
        return this.u;
    }

    @NotNull
    public final LiveData<ScreenState> getScreenStateChanges() {
        return this.t;
    }

    @NotNull
    public final LiveData<String> getSnackbarErrorMessagesChanges() {
        return this.z;
    }

    @NotNull
    public final LiveData<String> getSnackbarInfoMessagesChanges() {
        return this.A;
    }

    @NotNull
    public final LiveData<Unit> getStopRefresh() {
        return this.s;
    }

    @NotNull
    public final LiveData<CartSummaryView.SubmitButton> getSubmitButtonChanges() {
        return this.v;
    }

    public final void h() {
        this.M.trackPrepared();
        this.M.startDrawing();
    }

    public final void i(List<? extends Item> list, String str) {
        this.d = str;
        this.f = list;
        boolean z2 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next() instanceof ProductItem) {
                        z2 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z2) {
            this.j.postValue(new ScreenState.Empty(this.e));
        } else {
            this.j.postValue(new ScreenState.Loaded(str, list));
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.g.clear();
        Disposable disposable = this.h;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.i;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.m.postValue(deepLink);
    }

    public final void onRefresh(boolean z2) {
        Disposable subscribe = this.C.getCart().toObservable().map(a2.a.a.a0.a.j.a).startWithItem((R) LoadingState.Loading.INSTANCE).doOnEach(new a2.a.a.a0.a.k(this)).subscribe(new a2.a.a.a0.a.l(this, z2), new a2.a.a.a0.a.m(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getCart()\n   …ble = it) }\n            )");
        DisposableKt.addTo(subscribe, this.g);
    }

    public final void onSubmitClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        List<ItemQuantity> c2 = c();
        this.B.trackSubmitClicked(c2);
        Disposable disposable = this.i;
        if (disposable != null) {
            disposable.dispose();
        }
        Single<R> flatMap = this.C.checkQuantity(c2).flatMap(CartSummaryViewModel$onSubmitClicked$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        this.i = flatMap.doOnSubscribe(new a(this)).doFinally(new b(this)).subscribe(new c(this, deepLink), new d(this));
    }
}
