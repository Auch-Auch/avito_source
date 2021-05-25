package com.avito.android.basket_legacy.viewmodels.checkout;

import a2.a.a.r.b.a.d;
import a2.a.a.r.b.a.e;
import a2.a.a.r.b.a.f;
import a2.g.r.g;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.basket_legacy.item.BasketItem;
import com.avito.android.basket_legacy.item.header.HeaderItem;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.CheckoutNavigationIcon;
import com.avito.android.basket_legacy.utils.CloseEvent;
import com.avito.android.basket_legacy.utils.DisclaimerProvider;
import com.avito.android.basket_legacy.utils.FeesToBasketItemConverter;
import com.avito.android.basket_legacy.utils.LegacyCheckoutItemsDiffUtil;
import com.avito.android.basket_legacy.utils.PriceCalculator;
import com.avito.android.basket_legacy.utils.StringProvider;
import com.avito.android.basket_legacy.utils.VasToBasketItemConverter;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.LegacyPaidServicesLink;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.LiveDatasKt;
import com.avito.android.util.architecture_components.MessageEvent;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.avito.android.vas_performance.ui.recycler.ListUpdate;
import com.avito.conveyor_item.Item;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B|\u0012\u0007\u0010\u0001\u001a\u00020\u001a\u0012\u0006\u0010s\u001a\u00020\u001a\u0012\b\u0010a\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010X\u001a\u00020U\u0012\u0006\u0010\u001a\u00020|\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010{\u001a\u00020x\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00107\u001a\u000204¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001eR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\"\u0010;\u001a\b\u0012\u0004\u0012\u0002080\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010\u001c\u001a\u0004\b:\u0010\u001eR\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u0002080@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020L0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010\u001c\u001a\u0004\bN\u0010\u001eR\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020L0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010BR\"\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010\u001c\u001a\u0004\b]\u0010\u001eR\u0018\u0010a\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020[0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010BR\"\u0010g\u001a\b\u0012\u0004\u0012\u00020d0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\be\u0010\u001c\u001a\u0004\bf\u0010\u001eR\"\u0010k\u001a\b\u0012\u0004\u0012\u00020h0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010\u001c\u001a\u0004\bj\u0010\u001eR\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020d0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010BR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010s\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010`R\"\u0010w\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0P0t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010`R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0@8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010BR\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020(0@8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010B¨\u0006\u0001"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/checkout/CheckoutViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;", "Lcom/avito/android/basket_legacy/item/BasketItem;", "item", "", "onCrossClick", "(Lcom/avito/android/basket_legacy/item/BasketItem;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lio/reactivex/Observable;", "clickObservable", "observeButtonClicks", "(Lio/reactivex/Observable;)V", "onCleared", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/lifecycle/LiveData;", "", VKApiConst.Q, "Landroidx/lifecycle/LiveData;", "getButtonTextChanges", "()Landroidx/lifecycle/LiveData;", "buttonTextChanges", "Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;", "y", "Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;", "feesConverter", "Lcom/avito/android/basket_legacy/utils/StringProvider;", "C", "Lcom/avito/android/basket_legacy/utils/StringProvider;", "stringProvider", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", AuthSource.OPEN_CHANNEL_LIST, "getStartActivityEvents", "startActivityEvents", "Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;", "D", "Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;", "disclaimerProvider", "Lcom/avito/android/Features;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "F", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/architecture_components/MessageEvent;", "p", "getMessageEvents", "messageEvents", "Lcom/avito/android/ActivityIntentFactory;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "messageEventsLiveData", "Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;", "x", "Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;", "vasConverter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "z", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/basket_legacy/utils/CloseEvent;", "o", "getCloseEvents", "closeEvents", "", "Lcom/avito/conveyor_item/Item;", "j", "Ljava/util/List;", "oldItems", "", VKApiConst.VERSION, "Z", "lfRequired", "e", "closeEventsLiveData", "Lcom/avito/android/util/architecture_components/StartActivityForResultEvent;", "n", "getStartActivityForResultEvents", "startActivityForResultEvents", "u", "Ljava/lang/String;", "openedFrom", "h", "startActivityForResultEventData", "Lcom/avito/android/basket_legacy/utils/CheckoutNavigationIcon;", "l", "getNavigationChanges", "navigationChanges", "Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "r", "getListUpdates", "listUpdates", "i", "navigationChangesLiveData", "Lio/reactivex/disposables/Disposable;", "k", "Lio/reactivex/disposables/Disposable;", "disposable", "t", "vasContext", "Landroidx/lifecycle/MediatorLiveData;", "c", "Landroidx/lifecycle/MediatorLiveData;", "resultLiveData", "Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "B", "Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "priceCalculator", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "w", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "repository", "s", BookingInfoActivity.EXTRA_ITEM_ID, "d", "buttonTextLiveData", g.a, "startActivityEventData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/basket_legacy/utils/PriceCalculator;Lcom/avito/android/basket_legacy/utils/StringProvider;Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutViewModelImpl extends ViewModel implements LegacyCheckoutViewModel {
    public final ActivityIntentFactory A;
    public final PriceCalculator B;
    public final StringProvider C;
    public final DisclaimerProvider D;
    public final Features E;
    public final SchedulersFactory F;
    public final MediatorLiveData<List<Item>> c;
    public final MutableLiveData<String> d;
    public final MutableLiveData<CloseEvent> e;
    public final MutableLiveData<MessageEvent> f;
    public final MutableLiveData<StartActivityEvent> g;
    public final MutableLiveData<StartActivityForResultEvent> h;
    public final MutableLiveData<CheckoutNavigationIcon> i;
    public List<? extends Item> j = CollectionsKt__CollectionsKt.emptyList();
    public Disposable k;
    @NotNull
    public final LiveData<CheckoutNavigationIcon> l;
    @NotNull
    public final LiveData<StartActivityEvent> m;
    @NotNull
    public final LiveData<StartActivityForResultEvent> n;
    @NotNull
    public final LiveData<CloseEvent> o;
    @NotNull
    public final LiveData<MessageEvent> p;
    @NotNull
    public final LiveData<String> q;
    @NotNull
    public final LiveData<ListUpdate> r;
    public final String s;
    public final String t;
    public final String u;
    public final boolean v;
    public final BasketRepository w;
    public final VasToBasketItemConverter x;
    public final FeesToBasketItemConverter y;
    public final DeepLinkIntentFactory z;

    public static final class a extends Lambda implements Function1<List<? extends Item>, ListUpdate> {
        public final /* synthetic */ CheckoutViewModelImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CheckoutViewModelImpl checkoutViewModelImpl) {
            super(1);
            this.a = checkoutViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ListUpdate invoke(List<? extends Item> list) {
            List<? extends Item> list2 = list;
            CheckoutViewModelImpl checkoutViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return CheckoutViewModelImpl.access$proceedNewItems(checkoutViewModelImpl, list2);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ CheckoutViewModelImpl a;

        public b(CheckoutViewModelImpl checkoutViewModelImpl) {
            this.a = checkoutViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            CheckoutViewModelImpl.access$handleButtonClick(this.a);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public CheckoutViewModelImpl(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z2, @NotNull BasketRepository basketRepository, @NotNull VasToBasketItemConverter vasToBasketItemConverter, @NotNull FeesToBasketItemConverter feesToBasketItemConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull PriceCalculator priceCalculator, @NotNull StringProvider stringProvider, @NotNull DisclaimerProvider disclaimerProvider, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "vasContext");
        Intrinsics.checkNotNullParameter(basketRepository, "repository");
        Intrinsics.checkNotNullParameter(vasToBasketItemConverter, "vasConverter");
        Intrinsics.checkNotNullParameter(feesToBasketItemConverter, "feesConverter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(priceCalculator, "priceCalculator");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(disclaimerProvider, "disclaimerProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.s = str;
        this.t = str2;
        this.u = str3;
        this.v = z2;
        this.w = basketRepository;
        this.x = vasToBasketItemConverter;
        this.y = feesToBasketItemConverter;
        this.z = deepLinkIntentFactory;
        this.A = activityIntentFactory;
        this.B = priceCalculator;
        this.C = stringProvider;
        this.D = disclaimerProvider;
        this.E = features;
        this.F = schedulersFactory;
        MediatorLiveData<List<Item>> mediatorLiveData = new MediatorLiveData<>();
        this.c = mediatorLiveData;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<CloseEvent> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        MutableLiveData<MessageEvent> mutableLiveData3 = new MutableLiveData<>();
        this.f = mutableLiveData3;
        MutableLiveData<StartActivityEvent> mutableLiveData4 = new MutableLiveData<>();
        this.g = mutableLiveData4;
        MutableLiveData<StartActivityForResultEvent> mutableLiveData5 = new MutableLiveData<>();
        this.h = mutableLiveData5;
        MutableLiveData<CheckoutNavigationIcon> mutableLiveData6 = new MutableLiveData<>();
        this.i = mutableLiveData6;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.k = empty;
        Single.zip(Observable.merge(basketRepository.getLfPackageObservable().map(new e(this)), basketRepository.getSingleFeeObservable().map(new f(this)), Observable.just(CollectionsKt__CollectionsKt.emptyList())).firstOrError(), basketRepository.getVasObservable().map(new a2.a.a.r.b.a.g(this)).first((R) CollectionsKt__CollectionsKt.emptyList()), a2.a.a.r.b.a.b.a).subscribe(new a2.a.a.r.b.a.c(this), d.a);
        this.l = mutableLiveData6;
        this.m = mutableLiveData4;
        this.n = mutableLiveData5;
        this.o = mutableLiveData2;
        this.p = mutableLiveData3;
        this.q = mutableLiveData;
        this.r = LiveDatasKt.map(mediatorLiveData, new a(this));
    }

    public static final void access$handleButtonClick(CheckoutViewModelImpl checkoutViewModelImpl) {
        Sequence asSequence;
        List<String> list;
        List<Item> value = checkoutViewModelImpl.c.getValue();
        if (value != null && (asSequence = CollectionsKt___CollectionsKt.asSequence(value)) != null) {
            Sequence filter = SequencesKt___SequencesKt.filter(asSequence, CheckoutViewModelImpl$handleButtonClick$$inlined$filterIsInstance$1.INSTANCE);
            Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
            Sequence map = SequencesKt___SequencesKt.map(filter, a2.a.a.r.b.a.a.a);
            if (map != null && (list = SequencesKt___SequencesKt.toList(map)) != null) {
                boolean z2 = true;
                if (list.isEmpty()) {
                    MutableLiveData<CloseEvent> mutableLiveData = checkoutViewModelImpl.e;
                    if (!checkoutViewModelImpl.E.getShowAppRater().invoke().booleanValue() || !Intrinsics.areEqual(checkoutViewModelImpl.u, LegacyPaidServicesLink.FROM_CREATION) || checkoutViewModelImpl.v) {
                        z2 = false;
                    }
                    mutableLiveData.setValue(new CloseEvent(false, z2));
                    return;
                }
                checkoutViewModelImpl.h.setValue(new StartActivityForResultEvent(new IntentForResultDataHolder(checkoutViewModelImpl.A.servicePaymentIntent(checkoutViewModelImpl.s, list, checkoutViewModelImpl.t), 1)));
            }
        }
    }

    public static final ListUpdate access$proceedNewItems(CheckoutViewModelImpl checkoutViewModelImpl, List list) {
        List list2;
        String str;
        Item priceItem = checkoutViewModelImpl.B.getPriceItem(list);
        if (priceItem == null || (list2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Item[]{priceItem, checkoutViewModelImpl.D.getDisclaimerItem()})) == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!list2.isEmpty()) {
            str = checkoutViewModelImpl.C.getPayButtonText();
        } else if (Intrinsics.areEqual(checkoutViewModelImpl.u, LegacyPaidServicesLink.FROM_CREATION)) {
            str = checkoutViewModelImpl.C.getContinueWithoutVasText();
        } else {
            str = checkoutViewModelImpl.C.getReturnToAdvertText();
        }
        checkoutViewModelImpl.d.postValue(str);
        List<? extends Item> plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) list2);
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(plus), CheckoutViewModelImpl$updateNavigationIcon$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : filter) {
            if (((BasketItem) obj).isCancelable()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list3 = (List) pair.component1();
        if (!(!((List) pair.component2()).isEmpty()) || !list3.isEmpty()) {
            checkoutViewModelImpl.i.postValue(CheckoutNavigationIcon.BACK);
        } else {
            checkoutViewModelImpl.i.postValue(CheckoutNavigationIcon.CROSS);
        }
        LegacyCheckoutItemsDiffUtil legacyCheckoutItemsDiffUtil = new LegacyCheckoutItemsDiffUtil(checkoutViewModelImpl.j, plus);
        checkoutViewModelImpl.j = plus;
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(legacyCheckoutItemsDiffUtil);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(callback)");
        return new ListUpdate(plus, calculateDiff);
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    @NotNull
    public LiveData<String> getButtonTextChanges() {
        return this.q;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    @NotNull
    public LiveData<CloseEvent> getCloseEvents() {
        return this.o;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    @NotNull
    public LiveData<ListUpdate> getListUpdates() {
        return this.r;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    @NotNull
    public LiveData<MessageEvent> getMessageEvents() {
        return this.p;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    @NotNull
    public LiveData<CheckoutNavigationIcon> getNavigationChanges() {
        return this.l;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    @NotNull
    public LiveData<StartActivityEvent> getStartActivityEvents() {
        return this.m;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    @NotNull
    public LiveData<StartActivityForResultEvent> getStartActivityForResultEvents() {
        return this.n;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    public void observeButtonClicks(@NotNull Observable<Unit> observable) {
        Intrinsics.checkNotNullParameter(observable, "clickObservable");
        this.k.dispose();
        Disposable subscribe = observable.throttleFirst(100, TimeUnit.MILLISECONDS, this.F.computation()).observeOn(this.F.mainThread()).subscribe(new b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "clickObservable\n        …ber.e(it) }\n            )");
        this.k = subscribe;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i2 == 1) {
            String str = null;
            if (i3 == 0) {
                if (intent != null) {
                    str = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT);
                }
                if (str != null) {
                    this.f.postValue(new MessageEvent(str));
                }
            } else if (i3 == -1) {
                this.e.postValue(new CloseEvent(true, false, 2, null));
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.k.dispose();
    }

    @Override // com.avito.android.basket_legacy.utils.CrossClickListener
    public void onCrossClick(@NotNull BasketItem basketItem) {
        List<Item> mutableList;
        HeaderItem headerItem;
        Object obj;
        Object obj2;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(basketItem, "item");
        List<Item> value = this.c.getValue();
        if (value != null && (mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value)) != null) {
            Iterator it = mutableList.iterator();
            while (true) {
                headerItem = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Item item = (Item) obj;
                if (!(item instanceof BasketItem) || !Intrinsics.areEqual(((BasketItem) item).getServiceId(), basketItem.getServiceId())) {
                    z3 = false;
                    continue;
                } else {
                    z3 = true;
                    continue;
                }
                if (z3) {
                    break;
                }
            }
            if (!(obj instanceof BasketItem)) {
                obj = null;
            }
            BasketItem basketItem2 = (BasketItem) obj;
            if (basketItem2 != null) {
                Iterator it2 = mutableList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    Item item2 = (Item) obj2;
                    if (!(item2 instanceof HeaderItem) || !Intrinsics.areEqual(item2.getStringId(), basketItem2.getSectionId())) {
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
                if (obj2 instanceof HeaderItem) {
                    headerItem = obj2;
                }
                HeaderItem headerItem2 = headerItem;
                if (headerItem2 != null) {
                    mutableList.remove(basketItem2);
                    headerItem2.setCount(headerItem2.getCount() - 1);
                    if (headerItem2.getCount() <= 0) {
                        mutableList.remove(headerItem2);
                    }
                    this.w.removeVas(basketItem.getServiceId());
                    this.c.postValue(mutableList);
                }
            }
        }
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.z.getIntent(deepLink);
        if (intent != null) {
            this.g.postValue(new StartActivityEvent(new IntentDataHolder(intent, false)));
        }
    }
}
