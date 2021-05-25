package com.avito.android.user_advert.soa_with_price;

import a2.a.a.h3.b.a;
import a2.a.a.h3.b.b;
import a2.a.a.h3.b.c;
import a2.a.a.h3.b.d;
import a2.a.a.h3.b.e;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.R;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemPresenter;
import com.avito.android.user_advert.soa_with_price.di.CloseReasonSheetDialogComponent;
import com.avito.android.user_advert.soa_with_price.di.DaggerCloseReasonSheetDialogComponent;
import com.avito.android.util.Contexts;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import io.reactivex.disposables.Disposable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bM\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006N"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceSheetDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroyView", "()V", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "priceFocusDisposable", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory;)V", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModel;", "viewModel", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModel;", "getViewModel", "()Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModel;", "setViewModel", "(Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModel;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModelFactory;", "viewModelFactory", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModelFactory;)V", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", "itemPresenter", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", "getItemPresenter", "()Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", "setItemPresenter", "(Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;)V", "<init>", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class SoaWithPriceSheetDialogFragment extends DialogFragment {
    public String a;
    @Inject
    public RecyclerView.Adapter<BaseViewHolder> adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    public Disposable b;
    @Inject
    public CloseReasonItemPresenter itemPresenter;
    @Inject
    public SchedulersFactory schedulers;
    public SoaWithPriceViewModel viewModel;
    @Inject
    public SoaWithPriceViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            NavigationButtonType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final /* synthetic */ String access$getAdvertId$p(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment) {
        String str = soaWithPriceSheetDialogFragment.a;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
        }
        return str;
    }

    public static final void access$initChooseReasonDialog(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, BottomSheetDialog bottomSheetDialog, CharSequence charSequence) {
        SoaWithPriceViewModel soaWithPriceViewModel = soaWithPriceSheetDialogFragment.viewModel;
        if (soaWithPriceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel.getEnterPriceDetails().removeObservers(soaWithPriceSheetDialogFragment);
        int i = R.id.soa_with_price_sheet;
        View findViewById = bottomSheetDialog.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        viewGroup.removeAllViews();
        soaWithPriceSheetDialogFragment.getLayoutInflater().inflate(R.layout.close_reasons_sheet_content, viewGroup, true);
        View findViewById2 = bottomSheetDialog.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        ViewGroup viewGroup2 = (ViewGroup) findViewById2;
        RecyclerView.Adapter<BaseViewHolder> adapter2 = soaWithPriceSheetDialogFragment.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        CloseReasonsSheetDialogViewImpl closeReasonsSheetDialogViewImpl = new CloseReasonsSheetDialogViewImpl(viewGroup2, adapter2);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, charSequence, null, true, true, 2, null);
        SoaWithPriceViewModel soaWithPriceViewModel2 = soaWithPriceSheetDialogFragment.viewModel;
        if (soaWithPriceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel2.getCloseReasonItems().observe(soaWithPriceSheetDialogFragment, new a(soaWithPriceSheetDialogFragment, closeReasonsSheetDialogViewImpl));
        SoaWithPriceViewModel soaWithPriceViewModel3 = soaWithPriceSheetDialogFragment.viewModel;
        if (soaWithPriceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        CloseReasonItemPresenter closeReasonItemPresenter = soaWithPriceSheetDialogFragment.itemPresenter;
        if (closeReasonItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenter");
        }
        soaWithPriceViewModel3.subscribeToReasonItemSelections(closeReasonItemPresenter.getItemSelectedObservable());
        Disposable disposable = soaWithPriceSheetDialogFragment.b;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public static final void access$initEnterPriceDialog(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, BottomSheetDialog bottomSheetDialog, CharSequence charSequence) {
        SoaWithPriceViewModel soaWithPriceViewModel = soaWithPriceSheetDialogFragment.viewModel;
        if (soaWithPriceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel.getCloseReasonItems().removeObservers(soaWithPriceSheetDialogFragment);
        int i = R.id.soa_with_price_sheet;
        View findViewById = bottomSheetDialog.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        viewGroup.removeAllViews();
        soaWithPriceSheetDialogFragment.getLayoutInflater().inflate(R.layout.price_input_sheet_content, viewGroup, true);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, charSequence, null, true, true, 2, null);
        View findViewById2 = bottomSheetDialog.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        PriceSheetDialogViewImpl priceSheetDialogViewImpl = new PriceSheetDialogViewImpl((ViewGroup) findViewById2);
        SoaWithPriceViewModel soaWithPriceViewModel2 = soaWithPriceSheetDialogFragment.viewModel;
        if (soaWithPriceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel2.getEnterPriceDetails().observe(soaWithPriceSheetDialogFragment, new b(soaWithPriceSheetDialogFragment, priceSheetDialogViewImpl));
        SoaWithPriceViewModel soaWithPriceViewModel3 = soaWithPriceSheetDialogFragment.viewModel;
        if (soaWithPriceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel3.subscribeToPriceChangingEvents(priceSheetDialogViewImpl.getPriceChangingEvents());
        SoaWithPriceViewModel soaWithPriceViewModel4 = soaWithPriceSheetDialogFragment.viewModel;
        if (soaWithPriceViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel4.subscribeToPriceSubmittedEvents(priceSheetDialogViewImpl.getPriceSubmittedEvents());
        Disposable disposable = soaWithPriceSheetDialogFragment.b;
        if (disposable != null) {
            disposable.dispose();
        }
        soaWithPriceSheetDialogFragment.b = priceSheetDialogViewImpl.getPriceInputFocusChanges().subscribe(new c(soaWithPriceSheetDialogFragment), d.a);
    }

    public static final void access$setNavigationButton(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, BottomSheetDialog bottomSheetDialog, NavigationButtonType navigationButtonType) {
        Objects.requireNonNull(soaWithPriceSheetDialogFragment);
        View findViewById = bottomSheetDialog.findViewById(com.avito.android.lib.design.R.id.bottom_sheet_close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        ImageView imageView = (ImageView) findViewById;
        int ordinal = navigationButtonType.ordinal();
        if (ordinal == 0) {
            imageView.setBackgroundResource(com.avito.android.ui_components.R.drawable.ic_close_24);
            imageView.setOnClickListener(new u2(0, soaWithPriceSheetDialogFragment));
        } else if (ordinal == 1) {
            imageView.setBackgroundResource(com.avito.android.ui_components.R.drawable.ic_back_24);
            imageView.setOnClickListener(new u2(1, soaWithPriceSheetDialogFragment));
        }
    }

    @NotNull
    public final RecyclerView.Adapter<BaseViewHolder> getAdapter() {
        RecyclerView.Adapter<BaseViewHolder> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter2;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
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
    public final CloseReasonItemPresenter getItemPresenter() {
        CloseReasonItemPresenter closeReasonItemPresenter = this.itemPresenter;
        if (closeReasonItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenter");
        }
        return closeReasonItemPresenter;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory;
    }

    @NotNull
    public final SoaWithPriceViewModel getViewModel() {
        SoaWithPriceViewModel soaWithPriceViewModel = this.viewModel;
        if (soaWithPriceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return soaWithPriceViewModel;
    }

    @NotNull
    public final SoaWithPriceViewModelFactory getViewModelFactory() {
        SoaWithPriceViewModelFactory soaWithPriceViewModelFactory = this.viewModelFactory;
        if (soaWithPriceViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return soaWithPriceViewModelFactory;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        Parcelable parcelable = requireArguments.getParcelable("arguments");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "arguments.getParcelable<…guments>(KEY_ARGUMENTS)!!");
        SoaWithPriceArguments soaWithPriceArguments = (SoaWithPriceArguments) parcelable;
        this.a = soaWithPriceArguments.getAdvertId();
        CloseReasonSheetDialogComponent.Builder withArguments = DaggerCloseReasonSheetDialogComponent.builder().dependentOn((CoreComponentDependencies) ComponentDependenciesKt.getDependencies(CoreComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withArguments(soaWithPriceArguments);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withArguments.withResources(resources).build().inject(this);
        SoaWithPriceViewModelFactory soaWithPriceViewModelFactory = this.viewModelFactory;
        if (soaWithPriceViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = new ViewModelProvider(this, soaWithPriceViewModelFactory).get(SoaWithPriceViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(\n     …iceViewModel::class.java)");
        SoaWithPriceViewModel soaWithPriceViewModel = (SoaWithPriceViewModel) viewModel2;
        this.viewModel = soaWithPriceViewModel;
        if (soaWithPriceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel.prepareData();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.soa_with_price_sheet_dialog, -1);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        Context context = bottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog.setPeekHeight(Contexts.getDisplayHeight(context));
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        SoaWithPriceViewModel soaWithPriceViewModel = this.viewModel;
        if (soaWithPriceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel.getRoutingEvents().observe(this, new e(this, bottomSheetDialog));
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        SoaWithPriceViewModel soaWithPriceViewModel = this.viewModel;
        if (soaWithPriceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaWithPriceViewModel.onDestroyView();
        super.onDestroyView();
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<BaseViewHolder> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setItemPresenter(@NotNull CloseReasonItemPresenter closeReasonItemPresenter) {
        Intrinsics.checkNotNullParameter(closeReasonItemPresenter, "<set-?>");
        this.itemPresenter = closeReasonItemPresenter;
    }

    public final void setSchedulers(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "<set-?>");
        this.schedulers = schedulersFactory;
    }

    public final void setViewModel(@NotNull SoaWithPriceViewModel soaWithPriceViewModel) {
        Intrinsics.checkNotNullParameter(soaWithPriceViewModel, "<set-?>");
        this.viewModel = soaWithPriceViewModel;
    }

    public final void setViewModelFactory(@NotNull SoaWithPriceViewModelFactory soaWithPriceViewModelFactory) {
        Intrinsics.checkNotNullParameter(soaWithPriceViewModelFactory, "<set-?>");
        this.viewModelFactory = soaWithPriceViewModelFactory;
    }
}
