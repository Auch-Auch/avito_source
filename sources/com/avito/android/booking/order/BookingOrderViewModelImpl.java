package com.avito.android.booking.order;

import a2.g.r.g;
import android.content.Intent;
import android.text.Editable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.PaymentIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.booking.order.BookingOrderScreenState;
import com.avito.android.booking.remote.model.BookingConstraint;
import com.avito.android.booking.remote.model.BookingOrderResponse;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.CarBookingOrderPayLink;
import com.avito.android.deep_linking.links.CarBookingOrderPaymentFailureLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.ListUtils;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.architecture_components.Event;
import com.avito.android.util.architecture_components.GoBackEvent;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010N\u001a\u00020+¢\u0006\u0004\bS\u0010TJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J!\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u00020!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R \u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003000/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R*\u0010>\u001a\u0010\u0012\f\u0012\n :*\u0004\u0018\u00010909088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u0002090/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u00102R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001e\u0010L\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010-R&\u0010R\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003000/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bO\u00102\u001a\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/booking/order/BookingOrderViewModel;", "", "loadBookingData", "()V", "onNavigationButtonClicked", "onActionButtonClicked", "", "resultCode", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "resolvePaymentResult", "(ILcom/avito/android/deep_linking/links/DeepLink;)V", "", "shouldFinish", "c", "(Lcom/avito/android/deep_linking/links/DeepLink;Z)V", "requestCode", "d", "(I)V", "Lcom/avito/android/booking/order/BookingOrderInteractor;", "j", "Lcom/avito/android/booking/order/BookingOrderInteractor;", "bookingOrderInteractor", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "l", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SimpleTextWatcher;", "i", "Lcom/avito/android/util/SimpleTextWatcher;", "getInputTextWatcher", "()Lcom/avito/android/util/SimpleTextWatcher;", "inputTextWatcher", "Lcom/avito/android/account/AccountStateProvider;", "k", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "", "h", "Ljava/lang/String;", "lastInput", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/architecture_components/Event;", "e", "Landroidx/lifecycle/MutableLiveData;", "routingEventsLiveData", "Lcom/avito/android/booking/order/BookingOrderInputValidator;", "n", "Lcom/avito/android/booking/order/BookingOrderInputValidator;", "bookingOrderInputValidator", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/LiveData;", "getScreenStateChanges", "()Landroidx/lifecycle/LiveData;", "screenStateChanges", "screenChangesLiveData", "Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "p", "Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "resourceProvider", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "", "Lcom/avito/android/booking/remote/model/BookingConstraint;", g.a, "Ljava/util/List;", "constraints", VKApiConst.Q, "itemId", "f", "getRoutingEvents", "()Landroidx/lifecycle/MutableLiveData;", "routingEvents", "<init>", "(Lcom/avito/android/booking/order/BookingOrderInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/booking/order/BookingOrderInputValidator;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/booking/order/BookingOrderResourceProvider;Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderViewModelImpl extends ViewModel implements BookingOrderViewModel {
    public final MutableLiveData<BookingOrderScreenState> c;
    @NotNull
    public final LiveData<BookingOrderScreenState> d;
    public final MutableLiveData<Event<?>> e;
    @NotNull
    public final MutableLiveData<Event<?>> f;
    public List<BookingConstraint> g;
    public String h;
    @NotNull
    public final SimpleTextWatcher i = new SimpleTextWatcher(this) { // from class: com.avito.android.booking.order.BookingOrderViewModelImpl.1
        public final /* synthetic */ BookingOrderViewModelImpl a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "s");
            if (!Intrinsics.areEqual(editable.toString(), this.a.h)) {
                this.a.h = editable.toString();
                this.a.c.postValue(BookingOrderScreenState.InputNormal.INSTANCE);
            }
        }
    };
    public final BookingOrderInteractor j;
    public final AccountStateProvider k;
    public final DeepLinkIntentFactory l;
    public final ActivityIntentFactory m;
    public final BookingOrderInputValidator n;
    public final SchedulersFactory3 o;
    public final BookingOrderResourceProvider p;
    public final String q;

    public static final class a<T> implements Consumer<LoadingState<? super BookingOrderResponse>> {
        public final /* synthetic */ BookingOrderViewModelImpl a;

        public a(BookingOrderViewModelImpl bookingOrderViewModelImpl) {
            this.a = bookingOrderViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super BookingOrderResponse> loadingState) {
            String str;
            LoadingState<? super BookingOrderResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                AttributedText description = ((BookingOrderResponse) loaded.getData()).getOrderInfo().getDescription();
                if (description != null) {
                    description.setOnDeepLinkClickListener(new BookingOrderViewModelImpl$loadBookingData$1$1(this));
                }
                this.a.g = ((BookingOrderResponse) loaded.getData()).getInput().getConstraints();
                this.a.c.postValue(new BookingOrderScreenState.OrderInfoLoaded((BookingOrderResponse) loaded.getData()));
            } else if (loadingState2 instanceof LoadingState.Error) {
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (error instanceof ErrorWithMessage) {
                    str = ((ErrorWithMessage) error).getMessage();
                } else {
                    str = this.a.p.unknownErrorMessage();
                }
                this.a.c.postValue(new BookingOrderScreenState.LoadingError(str));
            } else if (loadingState2 instanceof LoadingState.Loading) {
                this.a.c.postValue(BookingOrderScreenState.Loading.INSTANCE);
            }
        }
    }

    public BookingOrderViewModelImpl(@NotNull BookingOrderInteractor bookingOrderInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull BookingOrderInputValidator bookingOrderInputValidator, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull BookingOrderResourceProvider bookingOrderResourceProvider, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bookingOrderInteractor, "bookingOrderInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(bookingOrderInputValidator, "bookingOrderInputValidator");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(bookingOrderResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.j = bookingOrderInteractor;
        this.k = accountStateProvider;
        this.l = deepLinkIntentFactory;
        this.m = activityIntentFactory;
        this.n = bookingOrderInputValidator;
        this.o = schedulersFactory3;
        this.p = bookingOrderResourceProvider;
        this.q = str;
        MutableLiveData<BookingOrderScreenState> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        LiveData<BookingOrderScreenState> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Transformations.distinct…ed(screenChangesLiveData)");
        this.d = distinctUntilChanged;
        MutableLiveData<Event<?>> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        this.f = mutableLiveData2;
        if (accountStateProvider.isAuthorized()) {
            loadBookingData();
        } else {
            d(101);
        }
    }

    public static final void access$navigateToPayment(BookingOrderViewModelImpl bookingOrderViewModelImpl, DeepLink deepLink) {
        Objects.requireNonNull(bookingOrderViewModelImpl);
        if (deepLink instanceof CarBookingOrderPayLink) {
            bookingOrderViewModelImpl.e.postValue(new StartActivityForResultEvent(new IntentForResultDataHolder(PaymentIntentFactory.DefaultImpls.webPaymentIntent$default(bookingOrderViewModelImpl.m, ((CarBookingOrderPayLink) deepLink).getPaymentUri(), null, 2, null), 103)));
            return;
        }
        bookingOrderViewModelImpl.c(deepLink, false);
    }

    public final void c(DeepLink deepLink, boolean z) {
        Intent intent = this.l.getIntent(deepLink);
        if (intent != null) {
            this.e.postValue(new StartActivityEvent(new IntentDataHolder(intent, z)));
        }
    }

    public final void d(int i2) {
        Intent authIntent$default = AuthIntentFactory.DefaultImpls.authIntent$default(this.m, null, AuthSource.BOOKING_ORDER, null, 5, null);
        authIntent$default.setFlags(603979776);
        this.e.postValue(new StartActivityForResultEvent(new IntentForResultDataHolder(authIntent$default, i2)));
    }

    @Override // com.avito.android.booking.order.BookingOrderViewModel
    @NotNull
    public LiveData<BookingOrderScreenState> getScreenStateChanges() {
        return this.d;
    }

    @Override // com.avito.android.booking.order.BookingOrderViewModel
    public void loadBookingData() {
        this.j.loadBookingOrderData(this.q).subscribeOn(this.o.io()).observeOn(this.o.mainThread()).subscribe(new a(this));
    }

    @Override // com.avito.android.booking.order.BookingOrderViewModel
    public void onActionButtonClicked() {
        String str = this.h;
        if (str == null) {
            str = "";
        }
        if (ListUtils.isNotNullAndNotEmpty(this.g)) {
            BookingOrderInputValidator bookingOrderInputValidator = this.n;
            List<BookingConstraint> list = this.g;
            Intrinsics.checkNotNull(list);
            ValidationResult validate = bookingOrderInputValidator.validate(str, list);
            if (!validate.isValid() && validate.getErrorMessage() != null) {
                this.c.postValue(new BookingOrderScreenState.InputError(validate.getErrorMessage()));
                return;
            }
        }
        if (this.k.isAuthorized()) {
            this.j.createBookingOrder(this.q, str).subscribeOn(this.o.io()).observeOn(this.o.mainThread()).subscribe(new a2.a.a.u.b.a(this));
            return;
        }
        d(102);
    }

    @Override // com.avito.android.booking.order.BookingOrderViewModel
    public void onNavigationButtonClicked() {
        this.e.postValue(new GoBackEvent());
    }

    @Override // com.avito.android.booking.order.BookingOrderViewModel
    public void resolvePaymentResult(int i2, @Nullable DeepLink deepLink) {
        this.c.postValue(BookingOrderScreenState.Content.INSTANCE);
        if (i2 != -1) {
            this.c.postValue(new BookingOrderScreenState.Message(this.p.unknownErrorMessage()));
        } else if (deepLink instanceof CarBookingOrderPaymentFailureLink) {
            new BookingOrderScreenState.Message(((CarBookingOrderPaymentFailureLink) deepLink).getMessage());
        } else if (deepLink == null) {
            new BookingOrderScreenState.Message(this.p.paymentErrorMessage());
        } else {
            c(deepLink, true);
        }
    }

    @Override // com.avito.android.booking.order.BookingOrderViewModel
    @NotNull
    public SimpleTextWatcher getInputTextWatcher() {
        return this.i;
    }

    @Override // com.avito.android.booking.order.BookingOrderViewModel
    @NotNull
    public MutableLiveData<Event<?>> getRoutingEvents() {
        return this.f;
    }
}
