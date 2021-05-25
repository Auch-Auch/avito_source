package com.avito.android.booking.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.booking.R;
import com.avito.android.booking.di.BookingInfoDependencies;
import com.avito.android.booking.di.DaggerBookingInfoComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.Event;
import com.avito.android.util.architecture_components.GoBackEvent;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "Lcom/avito/android/booking/info/BookingInfoView;", "d", "Lcom/avito/android/booking/info/BookingInfoView;", "bookingInfoView", "Lcom/avito/android/booking/info/BookingInfoViewModel;", "c", "Lcom/avito/android/booking/info/BookingInfoViewModel;", "viewModel", "Lcom/avito/android/booking/info/BookingInfoViewModelFactory;", "viewModelFactory", "Lcom/avito/android/booking/info/BookingInfoViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/booking/info/BookingInfoViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/booking/info/BookingInfoViewModelFactory;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "<init>", "Companion", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public BookingInfoViewModel c;
    public BookingInfoView d;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public BookingInfoViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoFragment$Companion;", "", "", "itemId", BookingInfoActivity.EXTRA_FROM_BLOCK, "Lcom/avito/android/booking/info/BookingInfoFragment;", "createInstance", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/booking/info/BookingInfoFragment;", "<init>", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final BookingInfoFragment createInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_FROM_BLOCK);
            Bundle bundle = new Bundle();
            bundle.putString(BookingInfoActivity.EXTRA_ITEM_ID, str);
            bundle.putString(BookingInfoActivity.EXTRA_FROM_BLOCK, str2);
            BookingInfoFragment bookingInfoFragment = new BookingInfoFragment();
            bookingInfoFragment.setArguments(bundle);
            return bookingInfoFragment;
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
                BookingInfoFragment.access$getViewModel$p((BookingInfoFragment) this.b).onRetryClicked();
            } else if (i == 1) {
                BookingInfoFragment.access$getViewModel$p((BookingInfoFragment) this.b).onBackClicked();
            } else {
                throw null;
            }
        }
    }

    public static final /* synthetic */ BookingInfoViewModel access$getViewModel$p(BookingInfoFragment bookingInfoFragment) {
        BookingInfoViewModel bookingInfoViewModel = bookingInfoFragment.c;
        if (bookingInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return bookingInfoViewModel;
    }

    public static final void access$resolveActionButtonState(BookingInfoFragment bookingInfoFragment, ActionButtonState actionButtonState) {
        BookingInfoView bookingInfoView = bookingInfoFragment.d;
        if (bookingInfoView != null) {
            bookingInfoView.showActionButton(actionButtonState.getTitle(), actionButtonState.getStyle(), new a2.a.a.u.a.a(bookingInfoFragment, actionButtonState));
        }
    }

    public static final void access$resolveViewState(BookingInfoFragment bookingInfoFragment, LoadingState loadingState) {
        Objects.requireNonNull(bookingInfoFragment);
        if (loadingState instanceof LoadingState.Loading) {
            BookingInfoView bookingInfoView = bookingInfoFragment.d;
            if (bookingInfoView != null) {
                bookingInfoView.showLoading();
            }
        } else if (loadingState instanceof LoadingState.Loaded) {
            BookingInfoView bookingInfoView2 = bookingInfoFragment.d;
            if (bookingInfoView2 != null) {
                bookingInfoView2.notifyDataChanged();
            }
            BookingInfoView bookingInfoView3 = bookingInfoFragment.d;
            if (bookingInfoView3 != null) {
                bookingInfoView3.showContent();
            }
        } else if (loadingState instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState).getError();
            String message = error instanceof ErrorWithMessage ? ((ErrorWithMessage) error).getMessage() : error.toString();
            BookingInfoView bookingInfoView4 = bookingInfoFragment.d;
            if (bookingInfoView4 != null) {
                bookingInfoView4.showError(message);
            }
        }
    }

    public static final void access$routeBy(BookingInfoFragment bookingInfoFragment, Event event) {
        IntentDataHolder intentDataHolder;
        FragmentActivity activity;
        Objects.requireNonNull(bookingInfoFragment);
        if (!event.getHasBeenHandled()) {
            if (event instanceof GoBackEvent) {
                FragmentActivity activity2 = bookingInfoFragment.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            } else if ((event instanceof StartActivityEvent) && (intentDataHolder = (IntentDataHolder) ((StartActivityEvent) event).getContentIfNotHandled()) != null) {
                if (intentDataHolder.getShouldFinish() && (activity = bookingInfoFragment.getActivity()) != null) {
                    activity.finish();
                }
                bookingInfoFragment.startActivity(intentDataHolder.getIntent());
            }
        }
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final BookingInfoViewModelFactory getViewModelFactory() {
        BookingInfoViewModelFactory bookingInfoViewModelFactory = this.viewModelFactory;
        if (bookingInfoViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return bookingInfoViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_booking_info, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BookingInfoViewModel bookingInfoViewModel = this.c;
        if (bookingInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bookingInfoViewModel.getStateChanges().removeObservers(getViewLifecycleOwner());
        bookingInfoViewModel.getActionButtonState().removeObservers(getViewLifecycleOwner());
        bookingInfoViewModel.getRoutingEvents().removeObservers(getViewLifecycleOwner());
        this.d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        BookingInfoViewImpl bookingInfoViewImpl = new BookingInfoViewImpl(view, simpleRecyclerAdapter);
        bookingInfoViewImpl.retryClicks().subscribe(new a(0, this));
        bookingInfoViewImpl.backClicks().subscribe(new a(1, this));
        this.d = bookingInfoViewImpl;
        BookingInfoViewModel bookingInfoViewModel = this.c;
        if (bookingInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bookingInfoViewModel.getStateChanges().observe(getViewLifecycleOwner(), new Observer() { // from class: com.avito.android.booking.info.BookingInfoFragment$sam$i$androidx_lifecycle_Observer$0
            @Override // androidx.lifecycle.Observer
            public final /* synthetic */ void onChanged(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
        bookingInfoViewModel.getActionButtonState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.avito.android.booking.info.BookingInfoFragment$sam$i$androidx_lifecycle_Observer$0
            @Override // androidx.lifecycle.Observer
            public final /* synthetic */ void onChanged(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
        bookingInfoViewModel.getRoutingEvents().observe(getViewLifecycleOwner(), new Observer() { // from class: com.avito.android.booking.info.BookingInfoFragment$sam$i$androidx_lifecycle_Observer$0
            @Override // androidx.lifecycle.Observer
            public final /* synthetic */ void onChanged(Object obj) {
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(obj), "invoke(...)");
            }
        });
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString(BookingInfoActivity.EXTRA_ITEM_ID) : null;
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(EXTRA_ITEM_ID)!!");
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(BookingInfoActivity.EXTRA_FROM_BLOCK);
        }
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNullExpressionValue(str, "arguments?.getString(EXTRA_FROM_BLOCK)!!");
        DaggerBookingInfoComponent.builder().dependencies((BookingInfoDependencies) ComponentDependenciesKt.getDependencies(BookingInfoDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withItemId(string).withFromBlock(str).build().inject(this);
        BookingInfoViewModelFactory bookingInfoViewModelFactory = this.viewModelFactory;
        if (bookingInfoViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, bookingInfoViewModelFactory).get(BookingInfoViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.c = (BookingInfoViewModel) viewModel;
        return true;
    }

    public final void setViewModelFactory(@NotNull BookingInfoViewModelFactory bookingInfoViewModelFactory) {
        Intrinsics.checkNotNullParameter(bookingInfoViewModelFactory, "<set-?>");
        this.viewModelFactory = bookingInfoViewModelFactory;
    }
}
