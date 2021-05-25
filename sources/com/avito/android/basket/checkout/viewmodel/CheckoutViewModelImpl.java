package com.avito.android.basket.checkout.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.Features;
import com.avito.android.basket.checkout.item.checkout.CheckoutItem;
import com.avito.android.basket.checkout.item.price.PriceItem;
import com.avito.android.basket.checkout.recycler.CheckoutItemsDiffUtil;
import com.avito.android.basket.checkout.utils.CheckoutCalculator;
import com.avito.android.basket.checkout.utils.PriceItemCreator;
import com.avito.android.component.disclaimer.DisclaimerItem;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.DialogInfo;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.CheckoutCommitResult;
import com.avito.android.remote.model.CheckoutContentsResult;
import com.avito.android.tariff.StringProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.LiveDatasKt;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.conveyor_item.Item;
import com.avito.conveyor_item.ParcelableItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002Bj\u0012\u0006\u0010\u001a\u000209\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u00100\u001a\u00020-\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010q\u001a\u00020n\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010,\u001a\u00020)\u0012\b\u0010 \u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00020\u001b\u0012\u0006\u0010f\u001a\u00020c¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\u00032\u0014\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u00102R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000205048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u000209048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u00107R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020<018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u00102R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010F\u001a\b\u0012\u0004\u0012\u000205048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bC\u00107\u001a\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u000209018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u00102R\u0016\u0010N\u001a\u00020?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010AR\"\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u00102R\"\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000f018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bP\u00102\u001a\u0004\bQ\u0010RR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020T048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u00107R\"\u0010Y\u001a\b\u0012\u0004\u0012\u000209018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u00102\u001a\u0004\bX\u0010RR\"\u0010\\\u001a\b\u0012\u0004\u0012\u00020<018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bZ\u00102\u001a\u0004\b[\u0010RR\"\u0010_\u001a\b\u0012\u0004\u0012\u00020\u0003048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b]\u00107\u001a\u0004\b^\u0010ER\"\u0010b\u001a\b\u0012\u0004\u0012\u000209018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b`\u00102\u001a\u0004\ba\u0010RR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\"\u0010m\u001a\b\u0012\u0004\u0012\u00020h0g8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\"\u0010t\u001a\b\u0012\u0004\u0012\u00020T048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\br\u00107\u001a\u0004\bs\u0010ER\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u001c\u0010y\u001a\b\u0012\u0004\u0012\u000209018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u00102R\"\u0010|\u001a\b\u0012\u0004\u0012\u000209048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bz\u00107\u001a\u0004\b{\u0010ER\u0016\u0010\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0003048\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00107R\u0019\u0010\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006018\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u00102\u001a\u0005\b\u0001\u0010RR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u000b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00102R\u001a\u0010 \u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006£\u0001"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;", "", "d", "()V", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutContent;", "state", "c", "(Lcom/avito/android/util/LoadingState;)V", "", "Lcom/avito/conveyor_item/ParcelableItem;", "Lcom/avito/conveyor_item/Item;", "item", "", "isActive", "e", "(Ljava/util/List;Lcom/avito/conveyor_item/Item;Z)Ljava/util/List;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "onContinueButtonClick", "onRetryButtonClick", "onCleared", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItem;", "onCrossButtonClicked", "(Lcom/avito/android/basket/checkout/item/checkout/CheckoutItem;)V", "onBackToBasketButtonClicked", "Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", "I", "Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", "priceItemCreator", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;", "D", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;", "contentsConverter", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "progressChangesLiveData", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEventsLiveData", "", a2.g.r.g.a, "messagesLiveData", "Lcom/avito/android/util/architecture_components/StartActivityForResultEvent;", "k", "startActivityForResultEventData", "Lio/reactivex/disposables/Disposable;", "n", "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "w", "getRoutingEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEvents", "Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;", "H", "Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;", "priceCalculator", "i", "closeButtonTextChangesLiveData", "p", "commitSubscription", "listChangesLiveData", VKApiConst.VERSION, "getLoadingEvents", "()Landroidx/lifecycle/MutableLiveData;", "loadingEvents", "Lcom/avito/android/paid_services/routing/DialogInfo;", "j", "dialogEventsLiveData", "s", "getButtonTextChanges", "buttonTextChanges", "z", "getStartActivityForResultEvents", "startActivityForResultEvents", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getEndFlowEvents", "endFlowEvents", "x", "getCloseButtonTextChanges", "closeButtonTextChanges", "Lcom/avito/android/Features;", "L", "Lcom/avito/android/Features;", "features", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "t", "Landroidx/lifecycle/LiveData;", "getListChanges", "()Landroidx/lifecycle/LiveData;", "listChanges", "Lcom/avito/android/tariff/StringProvider;", "G", "Lcom/avito/android/tariff/StringProvider;", "stringProvider", "y", "getDialogEvents", "dialogEvents", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutNextStepData;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/basket/checkout/viewmodel/CheckoutNextStepData;", "nextStepData", "buttonTextChangesLiveData", "u", "getMessageEvents", "messageEvents", "B", "Ljava/lang/String;", "checkoutContext", "l", "endFlowEventData", "K", "Lcom/avito/android/util/Kundle;", "savedState", "r", "getProgressChanges", "progressChanges", "Lio/reactivex/disposables/CompositeDisposable;", "o", "Lio/reactivex/disposables/CompositeDisposable;", "clickSubscriptions", VKApiConst.Q, "Ljava/util/List;", "oldItems", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;", "C", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;", "repository", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;", "commitConverter", "Lcom/avito/android/util/SchedulersFactory;", "F", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "h", "loadingEventsLiveData", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "J", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkFactory", "<init>", "(Ljava/lang/String;Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/tariff/StringProvider;Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;Lcom/avito/android/basket/checkout/utils/PriceItemCreator;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/util/Kundle;Lcom/avito/android/Features;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutViewModelImpl extends ViewModel implements CheckoutViewModel {
    @NotNull
    public final SingleLiveEvent<Unit> A;
    public final String B;
    public final CheckoutRepository C;
    public final CheckoutConverter D;
    public final CheckoutCommitConverter E;
    public final SchedulersFactory F;
    public final StringProvider G;
    public final CheckoutCalculator H;
    public final PriceItemCreator I;
    public final DeepLinkIntentFactory J;
    public final Kundle K;
    public final Features L;
    public final MutableLiveData<LoadingState<CheckoutContent>> c;
    public final MutableLiveData<String> d;
    public final MutableLiveData<List<ParcelableItem>> e;
    public final SingleLiveEvent<DeepLink> f;
    public final SingleLiveEvent<String> g;
    public final MutableLiveData<Boolean> h;
    public final MutableLiveData<String> i;
    public final SingleLiveEvent<DialogInfo> j;
    public final MutableLiveData<StartActivityForResultEvent> k;
    public final SingleLiveEvent<Unit> l;
    public CheckoutNextStepData m;
    public Disposable n;
    public CompositeDisposable o = new CompositeDisposable();
    public Disposable p;
    public List<? extends Item> q;
    @NotNull
    public final MutableLiveData<LoadingState<CheckoutContent>> r;
    @NotNull
    public final MutableLiveData<String> s;
    @NotNull
    public final LiveData<ListUpdate> t;
    @NotNull
    public final SingleLiveEvent<String> u;
    @NotNull
    public final MutableLiveData<Boolean> v;
    @NotNull
    public final SingleLiveEvent<DeepLink> w;
    @NotNull
    public final MutableLiveData<String> x;
    @NotNull
    public final SingleLiveEvent<DialogInfo> y;
    @NotNull
    public final MutableLiveData<StartActivityForResultEvent> z;

    public static final class a<T> implements Consumer<DeepLink> {
        public final /* synthetic */ CheckoutViewModelImpl a;

        public a(CheckoutViewModelImpl checkoutViewModelImpl) {
            this.a = checkoutViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(DeepLink deepLink) {
            this.a.f.postValue(deepLink);
        }
    }

    public static final class c<T, R> implements Function<LoadingState<? super CheckoutContentsResult>, LoadingState<? super CheckoutContent>> {
        public final /* synthetic */ CheckoutViewModelImpl a;

        public c(CheckoutViewModelImpl checkoutViewModelImpl) {
            this.a = checkoutViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super CheckoutContent> apply(LoadingState<? super CheckoutContentsResult> loadingState) {
            LoadingState<? super CheckoutContentsResult> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return this.a.D.convertContentResponse(loadingState2);
        }
    }

    public static final class d<T> implements Consumer<LoadingState<? super CheckoutContent>> {
        public final /* synthetic */ CheckoutViewModelImpl a;

        public d(CheckoutViewModelImpl checkoutViewModelImpl) {
            this.a = checkoutViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super CheckoutContent> loadingState) {
            LoadingState<? super CheckoutContent> loadingState2 = loadingState;
            CheckoutViewModelImpl checkoutViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            checkoutViewModelImpl.c(loadingState2);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ CheckoutViewModelImpl a;

        public e(CheckoutViewModelImpl checkoutViewModelImpl) {
            this.a = checkoutViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.c.setValue(new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(this.a.G.getUnknownError())));
        }
    }

    public CheckoutViewModelImpl(@NotNull String str, @NotNull CheckoutRepository checkoutRepository, @NotNull CheckoutConverter checkoutConverter, @NotNull CheckoutCommitConverter checkoutCommitConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull StringProvider stringProvider, @NotNull CheckoutCalculator checkoutCalculator, @NotNull PriceItemCreator priceItemCreator, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull Kundle kundle, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(checkoutRepository, "repository");
        Intrinsics.checkNotNullParameter(checkoutConverter, "contentsConverter");
        Intrinsics.checkNotNullParameter(checkoutCommitConverter, "commitConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(checkoutCalculator, "priceCalculator");
        Intrinsics.checkNotNullParameter(priceItemCreator, "priceItemCreator");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deeplinkFactory");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        Intrinsics.checkNotNullParameter(features, "features");
        this.B = str;
        this.C = checkoutRepository;
        this.D = checkoutConverter;
        this.E = checkoutCommitConverter;
        this.F = schedulersFactory;
        this.G = stringProvider;
        this.H = checkoutCalculator;
        this.I = priceItemCreator;
        this.J = deepLinkIntentFactory;
        this.K = kundle;
        this.L = features;
        MutableLiveData<LoadingState<CheckoutContent>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        MutableLiveData<List<ParcelableItem>> mutableLiveData3 = new MutableLiveData<>();
        this.e = mutableLiveData3;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.f = singleLiveEvent;
        SingleLiveEvent<String> singleLiveEvent2 = new SingleLiveEvent<>();
        this.g = singleLiveEvent2;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this.h = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        this.i = mutableLiveData5;
        SingleLiveEvent<DialogInfo> singleLiveEvent3 = new SingleLiveEvent<>();
        this.j = singleLiveEvent3;
        MutableLiveData<StartActivityForResultEvent> mutableLiveData6 = new MutableLiveData<>();
        this.k = mutableLiveData6;
        SingleLiveEvent<Unit> singleLiveEvent4 = new SingleLiveEvent<>();
        this.l = singleLiveEvent4;
        this.m = (CheckoutNextStepData) kundle.getParcelable("next_step_data");
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.n = empty;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Disposables.empty()");
        this.p = empty2;
        this.q = CollectionsKt__CollectionsKt.emptyList();
        d();
        this.r = mutableLiveData;
        this.s = mutableLiveData2;
        this.t = LiveDatasKt.map(mutableLiveData3, new Function1<List<? extends Item>, ListUpdate>(this) { // from class: com.avito.android.basket.checkout.viewmodel.CheckoutViewModelImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public ListUpdate invoke(List<? extends Item> list) {
                List<? extends Item> list2 = list;
                Intrinsics.checkNotNullParameter(list2, "p1");
                return CheckoutViewModelImpl.access$proceedNewItems((CheckoutViewModelImpl) this.receiver, list2);
            }
        });
        this.u = singleLiveEvent2;
        this.v = mutableLiveData4;
        this.w = singleLiveEvent;
        this.x = mutableLiveData5;
        this.y = singleLiveEvent3;
        this.z = mutableLiveData6;
        this.A = singleLiveEvent4;
    }

    public static final void access$onCheckoutCommitResponse(CheckoutViewModelImpl checkoutViewModelImpl, LoadingState loadingState) {
        Objects.requireNonNull(checkoutViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            CheckoutNextStepData convertCommitResponse = checkoutViewModelImpl.E.convertCommitResponse((CheckoutCommitResult) ((LoadingState.Loaded) loadingState).getData());
            checkoutViewModelImpl.m = convertCommitResponse;
            Intent intent = checkoutViewModelImpl.J.getIntent(convertCommitResponse.getDeepLink());
            if (intent != null) {
                checkoutViewModelImpl.k.setValue(new StartActivityForResultEvent(new IntentForResultDataHolder(intent, 1)));
            }
            checkoutViewModelImpl.h.setValue(Boolean.FALSE);
        } else if (loadingState instanceof LoadingState.Error) {
            checkoutViewModelImpl.h.setValue(Boolean.FALSE);
            checkoutViewModelImpl.g.postValue(checkoutViewModelImpl.G.getUnknownError());
        } else if (loadingState instanceof LoadingState.Loading) {
            checkoutViewModelImpl.h.setValue(Boolean.TRUE);
        }
    }

    public static final ListUpdate access$proceedNewItems(CheckoutViewModelImpl checkoutViewModelImpl, List list) {
        int i2;
        String str;
        LoadingState<CheckoutContent> value = checkoutViewModelImpl.c.getValue();
        String str2 = null;
        if (!(value instanceof LoadingState.Loaded)) {
            value = null;
        }
        LoadingState.Loaded loaded = (LoadingState.Loaded) value;
        CheckoutContent checkoutContent = loaded != null ? (CheckoutContent) loaded.getData() : null;
        int calculateTotal = checkoutViewModelImpl.H.calculateTotal(list);
        PriceItemCreator priceItemCreator = checkoutViewModelImpl.I;
        if (checkoutContent != null) {
            str2 = checkoutContent.getPriceTemplate();
        }
        PriceItem createPriceItem = priceItemCreator.createPriceItem(str2, calculateTotal);
        if (checkoutContent != null) {
            if (createPriceItem != null) {
                str = checkoutContent.getActionTitle();
            } else {
                str = checkoutContent.getEmptyActionTitle();
            }
            if (str != null) {
                checkoutViewModelImpl.d.postValue(str);
            }
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (((Item) listIterator.previous()) instanceof DisclaimerItem) {
                    i2 = listIterator.nextIndex();
                    break;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        int i3 = i2 - 1;
        boolean z2 = true;
        if (i3 > 0 && (mutableList.get(i3) instanceof PriceItem) && createPriceItem != null) {
            Intrinsics.checkNotNull(createPriceItem);
            mutableList.set(i3, createPriceItem);
        } else {
            if (i3 > 0 && !(mutableList.get(i3) instanceof PriceItem) && createPriceItem != null) {
                Intrinsics.checkNotNull(createPriceItem);
                mutableList.add(i2, createPriceItem);
            } else {
                if (i3 <= 0 || !(mutableList.get(i3) instanceof PriceItem) || createPriceItem != null) {
                    z2 = false;
                }
                if (z2) {
                    mutableList.remove(i2);
                    mutableList.remove(i3);
                }
            }
        }
        CheckoutItemsDiffUtil checkoutItemsDiffUtil = new CheckoutItemsDiffUtil(checkoutViewModelImpl.q, mutableList);
        checkoutViewModelImpl.q = mutableList;
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(checkoutItemsDiffUtil);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(callback)");
        return new ListUpdate(mutableList, calculateDiff);
    }

    public final void c(LoadingState<? super CheckoutContent> loadingState) {
        DeepLink delayedAction;
        this.c.setValue(loadingState);
        if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            this.d.setValue(((CheckoutContent) loaded.getData()).getActionTitle());
            this.i.setValue(((CheckoutContent) loaded.getData()).getCloseButtonTitle());
            this.e.setValue(((CheckoutContent) loaded.getData()).getList());
            if (this.L.getMnzTestX20().invoke().booleanValue() && (delayedAction = ((CheckoutContent) loaded.getData()).getDelayedAction()) != null) {
                Observable.just(delayedAction).delay(300, TimeUnit.MILLISECONDS).subscribe(new a(this));
            }
        }
    }

    public final void d() {
        CheckoutContent checkoutContent = (CheckoutContent) this.K.getParcelable("checkout_content");
        if (checkoutContent != null) {
            c(new LoadingState.Loaded(checkoutContent));
            return;
        }
        this.n.dispose();
        Disposable subscribe = this.C.getCheckoutContents(this.B).map(new c(this)).observeOn(this.F.mainThread()).startWith((Observable<R>) ((R) LoadingState.Loading.INSTANCE)).subscribe(new d(this), new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getCheckoutCo…          }\n            )");
        this.n = subscribe;
    }

    public final List<ParcelableItem> e(List<? extends ParcelableItem> list, Item item, boolean z2) {
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (T t2 : list) {
            if ((t2 instanceof CheckoutItem) && Intrinsics.areEqual(t2.getStringId(), item.getStringId())) {
                t2 = CheckoutItem.copy$default(t2, null, null, null, null, null, false, false, z2, null, 383, null);
            }
            arrayList.add(t2);
        }
        return arrayList;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public SingleLiveEvent<DialogInfo> getDialogEvents() {
        return this.y;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public SingleLiveEvent<Unit> getEndFlowEvents() {
        return this.A;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public LiveData<ListUpdate> getListChanges() {
        return this.t;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public SingleLiveEvent<String> getMessageEvents() {
        return this.u;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getRoutingEvents() {
        return this.w;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        ArrayList arrayList = new ArrayList();
        for (T t2 : set) {
            if (t2 instanceof DeeplinkClickStreamProvider) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((DeeplinkClickStreamProvider) it.next()).getDeeplinkClicks());
        }
        CompositeDisposable compositeDisposable = this.o;
        Disposable subscribe = Observable.merge(arrayList2).throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.F.mainThread()).subscribe(new a2.a.a.q.a.i.d(new Function1<DeepLink, Unit>(this.f) { // from class: com.avito.android.basket.checkout.viewmodel.CheckoutViewModelImpl.f
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(DeepLink deepLink) {
                DeepLink deepLink2 = deepLink;
                Intrinsics.checkNotNullParameter(deepLink2, "p1");
                ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                return Unit.INSTANCE;
            }
        }), new a2.a.a.q.a.i.d(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.basket.checkout.viewmodel.CheckoutViewModelImpl.g
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.merge(deeplin…a::setValue, Logs::error)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Bundle extras;
        String stringExtra;
        if (i2 != 1) {
            return;
        }
        if (i3 == 0) {
            if (intent != null && (stringExtra = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT)) != null) {
                this.g.postValue(stringExtra);
            }
        } else if (i3 == -1) {
            DialogInfo dialogInfo = null;
            if (Intrinsics.areEqual((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString(PaymentProcessingConstants.EXTRA_PAYMENT_RESULT), "success")) {
                CheckoutNextStepData checkoutNextStepData = this.m;
                if (checkoutNextStepData != null) {
                    dialogInfo = checkoutNextStepData.getSuccessDialog();
                }
            } else {
                CheckoutNextStepData checkoutNextStepData2 = this.m;
                if (checkoutNextStepData2 != null) {
                    dialogInfo = checkoutNextStepData2.getActiveDialog();
                }
            }
            if (dialogInfo != null) {
                this.j.setValue(dialogInfo);
            } else {
                this.l.setValue(Unit.INSTANCE);
            }
        }
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemClickListener
    public void onBackToBasketButtonClicked(@NotNull CheckoutItem checkoutItem) {
        Intrinsics.checkNotNullParameter(checkoutItem, "item");
        List<ParcelableItem> value = this.e.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "listChangesLiveData.value ?: return");
            this.e.postValue(e(value, checkoutItem, true));
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.o.dispose();
        this.n.dispose();
        this.p.dispose();
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    public void onContinueButtonClick() {
        List<ParcelableItem> value = this.e.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (T t2 : value) {
                if (t2 instanceof CheckoutItem) {
                    arrayList.add(t2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (((CheckoutItem) next).isActive()) {
                    arrayList2.add(next);
                }
            }
            if (arrayList2.isEmpty()) {
                this.l.setValue(Unit.INSTANCE);
                return;
            }
            ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((CheckoutItem) it2.next()).getStringId());
            }
            Set<String> set = CollectionsKt___CollectionsKt.toSet(arrayList3);
            if (set != null) {
                this.p.dispose();
                Disposable subscribe = this.C.commitCheckout(this.B, set).observeOn(this.F.mainThread()).startWith((Observable<LoadingState<CheckoutCommitResult>>) LoadingState.Loading.INSTANCE).subscribe(new a2.a.a.q.a.i.b(this), new a2.a.a.q.a.i.c(this));
                Intrinsics.checkNotNullExpressionValue(subscribe, "repository.commitCheckou…          }\n            )");
                this.p = subscribe;
            }
        }
    }

    @Override // com.avito.android.basket.checkout.item.checkout.CheckoutItemClickListener
    public void onCrossButtonClicked(@NotNull CheckoutItem checkoutItem) {
        Intrinsics.checkNotNullParameter(checkoutItem, "item");
        List<ParcelableItem> value = this.e.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "listChangesLiveData.value ?: return");
            this.e.postValue(e(value, checkoutItem, false));
        }
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    public void onRetryButtonClick() {
        d();
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public Kundle saveState() {
        LoadingState<CheckoutContent> value = this.c.getValue();
        if (!(value instanceof LoadingState.Loaded)) {
            return Kundle.Companion.getEMPTY();
        }
        Kundle kundle = new Kundle();
        LoadingState.Loaded loaded = (LoadingState.Loaded) value;
        String actionTitle = ((CheckoutContent) loaded.getData()).getActionTitle();
        String closeButtonTitle = ((CheckoutContent) loaded.getData()).getCloseButtonTitle();
        List<ParcelableItem> value2 = this.e.getValue();
        if (value2 == null) {
            value2 = ((CheckoutContent) loaded.getData()).getList();
        }
        Intrinsics.checkNotNullExpressionValue(value2, "listChangesLiveData.valu…astLoadingState.data.list");
        return kundle.putParcelable("checkout_content", new CheckoutContent(actionTitle, closeButtonTitle, ((CheckoutContent) loaded.getData()).getEmptyActionTitle(), value2, ((CheckoutContent) loaded.getData()).getPriceTemplate(), ((CheckoutContent) loaded.getData()).getDelayedAction())).putParcelable("next_step_data", this.m);
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public MutableLiveData<String> getButtonTextChanges() {
        return this.s;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public MutableLiveData<String> getCloseButtonTextChanges() {
        return this.x;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public MutableLiveData<Boolean> getLoadingEvents() {
        return this.v;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public MutableLiveData<LoadingState<CheckoutContent>> getProgressChanges() {
        return this.r;
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutViewModel
    @NotNull
    public MutableLiveData<StartActivityForResultEvent> getStartActivityForResultEvents() {
        return this.z;
    }
}
