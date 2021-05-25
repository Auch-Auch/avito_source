package com.avito.android.booking.order;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.booking.R;
import com.avito.android.booking.di.BookingOrderComponent;
import com.avito.android.booking.di.BookingOrderDependencies;
import com.avito.android.booking.di.DaggerBookingOrderComponent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.Event;
import com.avito.android.util.architecture_components.GoBackEvent;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.avito.android.util.text.AttributedTextFormatter;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\bF\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/booking/order/BookingOrderViewModelFactory;", "viewModelFactory", "Lcom/avito/android/booking/order/BookingOrderViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/booking/order/BookingOrderViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/booking/order/BookingOrderViewModelFactory;)V", "Lcom/avito/android/booking/order/BookingOrderViewModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/booking/order/BookingOrderViewModel;", "viewModel", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/booking/order/BookingOrderView;", "c", "Lcom/avito/android/booking/order/BookingOrderView;", "bookingOrderView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/booking/order/BookingOrderPresenter;", "presenter", "Lcom/avito/android/booking/order/BookingOrderPresenter;", "getPresenter", "()Lcom/avito/android/booking/order/BookingOrderPresenter;", "setPresenter", "(Lcom/avito/android/booking/order/BookingOrderPresenter;)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "itemId", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "Companion", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderFragment extends Fragment {
    public static final int BOOKING_PAYMENT_REQUEST_CODE = 103;
    public static final int CREATE_ORDER_AUTH_REQUEST_CODE = 102;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int LOAD_BOOKING_INFO_AUTH_REQUEST_CODE = 101;
    public String a;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    public BookingOrderViewModel b;
    public BookingOrderView c;
    public CompositeDisposable d = new CompositeDisposable();
    @Inject
    public BookingOrderPresenter presenter;
    @Inject
    public BookingOrderViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderFragment$Companion;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/booking/order/BookingOrderFragment;", "createInstance", "(Ljava/lang/String;)Lcom/avito/android/booking/order/BookingOrderFragment;", "", "BOOKING_PAYMENT_REQUEST_CODE", "I", "CREATE_ORDER_AUTH_REQUEST_CODE", "LOAD_BOOKING_INFO_AUTH_REQUEST_CODE", "<init>", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final BookingOrderFragment createInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Bundle bundle = new Bundle();
            bundle.putString("item_id", str);
            BookingOrderFragment bookingOrderFragment = new BookingOrderFragment();
            bookingOrderFragment.setArguments(bundle);
            return bookingOrderFragment;
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                BookingOrderFragment.access$getViewModel$p((BookingOrderFragment) this.b).onActionButtonClicked();
            } else if (i == 1) {
                BookingOrderFragment.access$getViewModel$p((BookingOrderFragment) this.b).onNavigationButtonClicked();
            } else if (i == 2) {
                BookingOrderFragment.access$getViewModel$p((BookingOrderFragment) this.b).loadBookingData();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Observer<BookingOrderScreenState> {
        public final /* synthetic */ BookingOrderFragment a;

        public b(BookingOrderFragment bookingOrderFragment) {
            this.a = bookingOrderFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(BookingOrderScreenState bookingOrderScreenState) {
            BookingOrderScreenState bookingOrderScreenState2 = bookingOrderScreenState;
            BookingOrderPresenter presenter = this.a.getPresenter();
            Intrinsics.checkNotNullExpressionValue(bookingOrderScreenState2, "state");
            presenter.resolveScreenState(bookingOrderScreenState2);
        }
    }

    public static final class c<T> implements Observer<Event<?>> {
        public final /* synthetic */ BookingOrderFragment a;

        public c(BookingOrderFragment bookingOrderFragment) {
            this.a = bookingOrderFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Event<?> event) {
            Event<?> event2 = event;
            BookingOrderFragment bookingOrderFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(event2, "event");
            BookingOrderFragment.access$handleNavigationEvent(bookingOrderFragment, event2);
        }
    }

    public static final /* synthetic */ BookingOrderViewModel access$getViewModel$p(BookingOrderFragment bookingOrderFragment) {
        BookingOrderViewModel bookingOrderViewModel = bookingOrderFragment.b;
        if (bookingOrderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return bookingOrderViewModel;
    }

    public static final void access$handleNavigationEvent(BookingOrderFragment bookingOrderFragment, Event event) {
        IntentForResultDataHolder intentForResultDataHolder;
        FragmentActivity activity;
        Objects.requireNonNull(bookingOrderFragment);
        if (!event.getHasBeenHandled()) {
            if (event instanceof GoBackEvent) {
                FragmentActivity activity2 = bookingOrderFragment.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            } else if (event instanceof StartActivityEvent) {
                IntentDataHolder intentDataHolder = (IntentDataHolder) ((StartActivityEvent) event).getContentIfNotHandled();
                if (intentDataHolder != null) {
                    if (intentDataHolder.getShouldFinish() && (activity = bookingOrderFragment.getActivity()) != null) {
                        activity.finish();
                    }
                    bookingOrderFragment.startActivity(intentDataHolder.getIntent());
                }
            } else if ((event instanceof StartActivityForResultEvent) && (intentForResultDataHolder = (IntentForResultDataHolder) ((StartActivityForResultEvent) event).getContentIfNotHandled()) != null) {
                bookingOrderFragment.startActivityForResult(intentForResultDataHolder.getIntent(), intentForResultDataHolder.getRequestCode());
            }
        }
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
    }

    @NotNull
    public final BookingOrderPresenter getPresenter() {
        BookingOrderPresenter bookingOrderPresenter = this.presenter;
        if (bookingOrderPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return bookingOrderPresenter;
    }

    @NotNull
    public final BookingOrderViewModelFactory getViewModelFactory() {
        BookingOrderViewModelFactory bookingOrderViewModelFactory = this.viewModelFactory;
        if (bookingOrderViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return bookingOrderViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        switch (i) {
            case 101:
                if (i2 == -1) {
                    Views.setVisible(getView(), true);
                    BookingOrderViewModel bookingOrderViewModel = this.b;
                    if (bookingOrderViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    bookingOrderViewModel.loadBookingData();
                    return;
                }
                requireActivity().finish();
                return;
            case 102:
                if (i2 == -1) {
                    BookingOrderViewModel bookingOrderViewModel2 = this.b;
                    if (bookingOrderViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    bookingOrderViewModel2.onActionButtonClicked();
                    return;
                }
                return;
            case 103:
                DeepLink deepLink = intent != null ? (DeepLink) intent.getParcelableExtra(PaymentProcessingConstants.EXTRA_FINAL_DEEPLINK) : null;
                BookingOrderViewModel bookingOrderViewModel3 = this.b;
                if (bookingOrderViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                bookingOrderViewModel3.resolvePaymentResult(i2, deepLink);
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("item_id") : null;
        Intrinsics.checkNotNull(string);
        this.a = string;
        BookingOrderComponent.Builder dependencies = DaggerBookingOrderComponent.builder().dependencies((BookingOrderDependencies) ComponentDependenciesKt.getDependencies(BookingOrderDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        String str = this.a;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemId");
        }
        BookingOrderComponent.Builder withItemId = dependencies.withItemId(str);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withItemId.withResources(resources).build().inject(this);
        BookingOrderViewModelFactory bookingOrderViewModelFactory = this.viewModelFactory;
        if (bookingOrderViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, bookingOrderViewModelFactory).get(BookingOrderViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.b = (BookingOrderViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.view_booking_order, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        BookingOrderPresenter bookingOrderPresenter = this.presenter;
        if (bookingOrderPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bookingOrderPresenter.unbindView();
        this.d.clear();
        BookingOrderViewModel bookingOrderViewModel = this.b;
        if (bookingOrderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bookingOrderViewModel.getScreenStateChanges().removeObservers(getViewLifecycleOwner());
        BookingOrderViewModel bookingOrderViewModel2 = this.b;
        if (bookingOrderViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bookingOrderViewModel2.getRoutingEvents().removeObservers(getViewLifecycleOwner());
        BookingOrderView bookingOrderView = this.c;
        if (bookingOrderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bookingOrderView");
        }
        BookingOrderViewModel bookingOrderViewModel3 = this.b;
        if (bookingOrderViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bookingOrderView.removeInputTextWatcher(bookingOrderViewModel3.getInputTextWatcher());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        this.c = new BookingOrderViewImpl(view, attributedTextFormatter2);
        BookingOrderPresenter bookingOrderPresenter = this.presenter;
        if (bookingOrderPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        BookingOrderView bookingOrderView = this.c;
        if (bookingOrderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bookingOrderView");
        }
        bookingOrderPresenter.bindView(bookingOrderView);
        CompositeDisposable compositeDisposable = this.d;
        BookingOrderView bookingOrderView2 = this.c;
        if (bookingOrderView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bookingOrderView");
        }
        Disposable subscribe = bookingOrderView2.actionClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "bookingOrderView.actionC…onActionButtonClicked() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        BookingOrderView bookingOrderView3 = this.c;
        if (bookingOrderView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bookingOrderView");
        }
        Disposable subscribe2 = bookingOrderView3.navigationClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "bookingOrderView.navigat…vigationButtonClicked() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        BookingOrderView bookingOrderView4 = this.c;
        if (bookingOrderView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bookingOrderView");
        }
        Disposable subscribe3 = bookingOrderView4.refreshClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "bookingOrderView.refresh…Model.loadBookingData() }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        BookingOrderViewModel bookingOrderViewModel = this.b;
        if (bookingOrderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bookingOrderViewModel.getScreenStateChanges().observe(getViewLifecycleOwner(), new b(this));
        BookingOrderViewModel bookingOrderViewModel2 = this.b;
        if (bookingOrderViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bookingOrderViewModel2.getRoutingEvents().observe(getViewLifecycleOwner(), new c(this));
        BookingOrderView bookingOrderView5 = this.c;
        if (bookingOrderView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bookingOrderView");
        }
        BookingOrderViewModel bookingOrderViewModel3 = this.b;
        if (bookingOrderViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bookingOrderView5.setInputTextWatcher(bookingOrderViewModel3.getInputTextWatcher());
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setPresenter(@NotNull BookingOrderPresenter bookingOrderPresenter) {
        Intrinsics.checkNotNullParameter(bookingOrderPresenter, "<set-?>");
        this.presenter = bookingOrderPresenter;
    }

    public final void setViewModelFactory(@NotNull BookingOrderViewModelFactory bookingOrderViewModelFactory) {
        Intrinsics.checkNotNullParameter(bookingOrderViewModelFactory, "<set-?>");
        this.viewModelFactory = bookingOrderViewModelFactory;
    }
}
