package com.avito.android.payment.wallet.history.details;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.avito.android.Features;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.payment.di.component.DaggerHistoryDetailsComponent;
import com.avito.android.payment.di.component.PaymentDependencies;
import com.avito.android.payment.di.module.HistoryDetailsModule;
import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsViewModel;
import com.avito.android.payment.wallet.history.details.item.ButtonItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.history.PaymentDetails;
import com.avito.android.remote.model.payment.history.Receipt;
import com.avito.android.remote.model.payment.history.ReceiptStatus;
import com.avito.android.util.Contexts;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bI\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R:\u00106\u001a&\u0012\f\u0012\n 3*\u0004\u0018\u00010202 3*\u0012\u0012\f\u0012\n 3*\u0004\u0018\u00010202\u0018\u000101018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0004078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010G¨\u0006K"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/HistoryDetailsBottomSheetDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onActivityCreated", "(Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "onDetach", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/app/external/ApplicationInfoProvider;", "applicationInfoProvider", "Lcom/avito/android/app/external/ApplicationInfoProvider;", "getApplicationInfoProvider", "()Lcom/avito/android/app/external/ApplicationInfoProvider;", "setApplicationInfoProvider", "(Lcom/avito/android/app/external/ApplicationInfoProvider;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/remote/model/payment/history/Receipt;", "kotlin.jvm.PlatformType", "c", "Lcom/jakewharton/rxrelay2/PublishRelay;", "receiptButtonClicksRelay", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", "onShowReceiptButtonClickListener", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModelFactory;", "paymentHistoryDetailsViewModelFactory", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModelFactory;", "getPaymentHistoryDetailsViewModelFactory", "()Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModelFactory;", "setPaymentHistoryDetailsViewModelFactory", "(Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModelFactory;)V", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel;", "paymentHistoryViewModel", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "<init>", "Companion", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class HistoryDetailsBottomSheetDialogFragment extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final CompositeDisposable a = new CompositeDisposable();
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public ApplicationInfoProvider applicationInfoProvider;
    public PaymentHistoryDetailsViewModel b;
    public final PublishRelay<Receipt> c = PublishRelay.create();
    public final Function1<Receipt, Unit> d = new f(this);
    @Inject
    public Features features;
    @Inject
    public PaymentHistoryDetailsViewModelFactory paymentHistoryDetailsViewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/HistoryDetailsBottomSheetDialogFragment$Companion;", "", "Lcom/avito/android/payment/wallet/history/details/PaymentDetailsType;", "type", "", "id", "Lcom/avito/android/payment/wallet/history/details/HistoryDetailsBottomSheetDialogFragment;", "create", "(Lcom/avito/android/payment/wallet/history/details/PaymentDetailsType;Ljava/lang/String;)Lcom/avito/android/payment/wallet/history/details/HistoryDetailsBottomSheetDialogFragment;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final HistoryDetailsBottomSheetDialogFragment create(@NotNull PaymentDetailsType paymentDetailsType, @NotNull String str) {
            Intrinsics.checkNotNullParameter(paymentDetailsType, "type");
            Intrinsics.checkNotNullParameter(str, "id");
            HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment = new HistoryDetailsBottomSheetDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("ARG_PAYMENT_DETAILS_TYPE", paymentDetailsType);
            bundle.putString("ARG_PAYMENT_DETAILS_ID", str);
            historyDetailsBottomSheetDialogFragment.setArguments(bundle);
            return historyDetailsBottomSheetDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ReceiptStatus.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            ReceiptStatus receiptStatus = ReceiptStatus.DONE;
            iArr[0] = 1;
            ReceiptStatus receiptStatus2 = ReceiptStatus.WAIT;
            iArr[1] = 2;
            ReceiptStatus receiptStatus3 = ReceiptStatus.FAIL;
            iArr[2] = 3;
            PaymentDetailsType.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[1] = 1;
            iArr2[0] = 2;
            PaymentDetailsType.values();
            int[] iArr3 = new int[2];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[0] = 1;
            iArr3[1] = 2;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HistoryDetailsBottomSheetDialogFragment a;

        public a(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment) {
            this.a = historyDetailsBottomSheetDialogFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.a();
        }
    }

    public static final class b<T> implements Observer<PaymentHistoryDetailsViewModel.ViewState> {
        public final /* synthetic */ HistoryDetailsBottomSheetDialogFragment a;
        public final /* synthetic */ BottomSheetDialog b;
        public final /* synthetic */ RecyclerView c;
        public final /* synthetic */ LinearLayout d;
        public final /* synthetic */ FrameLayout e;
        public final /* synthetic */ TextView f;

        public b(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment, BottomSheetDialog bottomSheetDialog, RecyclerView recyclerView, LinearLayout linearLayout, FrameLayout frameLayout, TextView textView) {
            this.a = historyDetailsBottomSheetDialogFragment;
            this.b = bottomSheetDialog;
            this.c = recyclerView;
            this.d = linearLayout;
            this.e = frameLayout;
            this.f = textView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(PaymentHistoryDetailsViewModel.ViewState viewState) {
            PaymentHistoryDetailsViewModel.ViewState viewState2 = viewState;
            if (viewState2 instanceof PaymentHistoryDetailsViewModel.ViewState.Content) {
                FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.avito_bottom_sheet);
                if (frameLayout != null) {
                    TransitionDsl transitionDsl = new TransitionDsl(new ChangeBounds());
                    View findViewById = this.b.findViewById(R.id.bottom_sheet);
                    Intrinsics.checkNotNull(findViewById);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "dialog.findViewById<View…>(ui_R.id.bottom_sheet)!!");
                    transitionDsl.addTarget(findViewById);
                    TransitionManager.beginDelayedTransition(frameLayout, transitionDsl.buildTransition());
                }
                Views.show(this.c);
                Views.hide(this.d);
                Views.hide(this.e);
                PaymentDetails paymentDetails = ((PaymentHistoryDetailsViewModel.ViewState.Content) viewState2).getPaymentDetails();
                Resources resources = this.a.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                List<Item> itemList = PaymentDetailsDataMapperKt.toItemList(paymentDetails, resources);
                T t = null;
                for (T t2 : itemList) {
                    if (t2 instanceof ButtonItem) {
                        t = t2;
                    }
                }
                T t3 = t;
                if (t3 != null) {
                    t3.setOnShowReceiptButtonClickListener(this.a.d);
                } else {
                    RecyclerView recyclerView = this.c;
                    Views.changePadding$default(recyclerView, 0, 0, 0, this.a.getResources().getDimensionPixelOffset(com.avito.android.payment.R.dimen.payment_details_recycler_view_additional_padding_if_show_receipt_button_not_presented) + recyclerView.getPaddingBottom(), 7, null);
                }
                a2.b.a.a.a.s1(itemList, this.a.getAdapterPresenter());
            } else if (viewState2 instanceof PaymentHistoryDetailsViewModel.ViewState.Loading) {
                Views.hide(this.c);
                Views.hide(this.d);
                Views.show(this.e);
            } else if (viewState2 instanceof PaymentHistoryDetailsViewModel.ViewState.Error) {
                Views.hide(this.c);
                Views.show(this.d);
                Views.hide(this.e);
                this.f.setText(((PaymentHistoryDetailsViewModel.ViewState.Error) viewState2).getErrorResult().getMessage());
            }
        }
    }

    public static final class c<T> implements Observer<String> {
        public final /* synthetic */ HistoryDetailsBottomSheetDialogFragment a;
        public final /* synthetic */ BottomSheetDialog b;

        public c(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment, BottomSheetDialog bottomSheetDialog) {
            this.a = historyDetailsBottomSheetDialogFragment;
            this.b = bottomSheetDialog;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(String str) {
            String str2 = str;
            String str3 = str2 != null ? str2 : "";
            Bundle arguments = this.a.getArguments();
            PaymentDetailsType paymentDetailsType = null;
            Serializable serializable = arguments != null ? arguments.getSerializable("ARG_PAYMENT_DETAILS_TYPE") : null;
            if (serializable instanceof PaymentDetailsType) {
                paymentDetailsType = serializable;
            }
            PaymentDetailsType paymentDetailsType2 = paymentDetailsType;
            if (paymentDetailsType2 != null) {
                if (!(str3.length() == 0)) {
                    int ordinal = paymentDetailsType2.ordinal();
                    if (ordinal == 0) {
                        str3 = this.a.getResources().getString(com.avito.android.payment.R.string.payment_order_number_template, str2);
                    } else if (ordinal == 1) {
                        str3 = this.a.getResources().getString(com.avito.android.payment.R.string.payment_operation_number_template, str2);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                Intrinsics.checkNotNullExpressionValue(str3, "if (!orderId.isEmpty()) …           } else orderId");
                BottomSheetDialog.setHeaderParams$default(this.b, str3, null, true, false, 10, null);
                return;
            }
            throw new IllegalStateException("Arguments must be passed. Create fragment with `create()` method");
        }
    }

    public static final class d<T> implements Consumer<Receipt> {
        public final /* synthetic */ HistoryDetailsBottomSheetDialogFragment a;

        public d(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment) {
            this.a = historyDetailsBottomSheetDialogFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Receipt receipt) {
            Receipt receipt2 = receipt;
            int ordinal = receipt2.getStatus().ordinal();
            if (ordinal == 0) {
                HistoryDetailsBottomSheetDialogFragment.access$runChromeCustomTabsSafely(this.a, receipt2.getReceiptUrl());
            } else if (ordinal == 1) {
                new FiscalizationInProgressDialogFragment().show(this.a.getChildFragmentManager(), (String) null);
            } else if (ordinal == 2) {
                new FiscalizationErrorDialogFragment().show(this.a.getChildFragmentManager(), (String) null);
            }
        }
    }

    public static final class e implements DialogInterface.OnDismissListener {
        public static final e a = new e();

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public static final class f extends Lambda implements Function1<Receipt, Unit> {
        public final /* synthetic */ HistoryDetailsBottomSheetDialogFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment) {
            super(1);
            this.a = historyDetailsBottomSheetDialogFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Receipt receipt) {
            Receipt receipt2 = receipt;
            Intrinsics.checkNotNullParameter(receipt2, "receipt");
            this.a.c.accept(receipt2);
            return Unit.INSTANCE;
        }
    }

    public static final void access$runChromeCustomTabsSafely(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment, String str) {
        Context context = historyDetailsBottomSheetDialogFragment.getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "this.context ?: return");
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            Context requireContext = historyDetailsBottomSheetDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            CustomTabsIntent build = builder.setToolbarColor(Contexts.getColorByAttr(requireContext, R.attr.blue)).setShowTitle(true).addDefaultShareMenuItem().build();
            Intrinsics.checkNotNullExpressionValue(build, "CustomTabsIntent.Builder…em()\n            .build()");
            ApplicationInfoProvider applicationInfoProvider2 = historyDetailsBottomSheetDialogFragment.applicationInfoProvider;
            if (applicationInfoProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationInfoProvider");
            }
            if (applicationInfoProvider2.isAppInstalled("com.android.chrome")) {
                build.intent.setPackage("com.android.chrome");
                build.launchUrl(context, Uri.parse(str));
                return;
            }
            build.intent.setPackage(null);
            build.launchUrl(context, Uri.parse(str));
        }
    }

    public final void a() {
        String string;
        Bundle arguments = getArguments();
        PaymentDetailsType paymentDetailsType = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("ARG_PAYMENT_DETAILS_TYPE") : null;
        if (serializable instanceof PaymentDetailsType) {
            paymentDetailsType = serializable;
        }
        PaymentDetailsType paymentDetailsType2 = paymentDetailsType;
        if (paymentDetailsType2 != null) {
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (string = arguments2.getString("ARG_PAYMENT_DETAILS_ID")) == null) {
                throw new IllegalStateException("Arguments must be passed. Create fragment with `create()` method");
            }
            Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(ARG… with `create()` method\")");
            int ordinal = paymentDetailsType2.ordinal();
            if (ordinal == 0) {
                PaymentHistoryDetailsViewModel paymentHistoryDetailsViewModel = this.b;
                if (paymentHistoryDetailsViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
                }
                paymentHistoryDetailsViewModel.getOrderDetails(string);
            } else if (ordinal == 1) {
                PaymentHistoryDetailsViewModel paymentHistoryDetailsViewModel2 = this.b;
                if (paymentHistoryDetailsViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
                }
                paymentHistoryDetailsViewModel2.getOperationDetails(string);
            }
        } else {
            throw new IllegalStateException("Arguments must be passed. Create fragment with `create()` method");
        }
    }

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
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
    public final ApplicationInfoProvider getApplicationInfoProvider() {
        ApplicationInfoProvider applicationInfoProvider2 = this.applicationInfoProvider;
        if (applicationInfoProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationInfoProvider");
        }
        return applicationInfoProvider2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final PaymentHistoryDetailsViewModelFactory getPaymentHistoryDetailsViewModelFactory() {
        PaymentHistoryDetailsViewModelFactory paymentHistoryDetailsViewModelFactory2 = this.paymentHistoryDetailsViewModelFactory;
        if (paymentHistoryDetailsViewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryDetailsViewModelFactory");
        }
        return paymentHistoryDetailsViewModelFactory2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Objects.requireNonNull(dialog, "null cannot be cast to non-null type com.avito.android.lib.design.bottom_sheet.BottomSheetDialog");
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        View findViewById = bottomSheetDialog.findViewById(com.avito.android.payment.R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        View findViewById2 = bottomSheetDialog.findViewById(com.avito.android.payment.R.id.error_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        LinearLayout linearLayout = (LinearLayout) findViewById2;
        View findViewById3 = bottomSheetDialog.findViewById(com.avito.android.payment.R.id.error_text_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(id)");
        TextView textView = (TextView) findViewById3;
        View findViewById4 = bottomSheetDialog.findViewById(com.avito.android.payment.R.id.loading_indicator);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(id)");
        FrameLayout frameLayout = (FrameLayout) findViewById4;
        View findViewById5 = bottomSheetDialog.findViewById(com.avito.android.payment.R.id.error_refresh_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(id)");
        ((Button) findViewById5).setOnClickListener(new a(this));
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        PaymentHistoryDetailsViewModel paymentHistoryDetailsViewModel = this.b;
        if (paymentHistoryDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
        }
        paymentHistoryDetailsViewModel.getViewState().observe(requireActivity(), new b(this, bottomSheetDialog, recyclerView, linearLayout, frameLayout, textView));
        PaymentHistoryDetailsViewModel paymentHistoryDetailsViewModel2 = this.b;
        if (paymentHistoryDetailsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryViewModel");
        }
        paymentHistoryDetailsViewModel2.getTitle().observe(requireActivity(), new c(this, bottomSheetDialog));
        if (bundle == null) {
            a();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerHistoryDetailsComponent.builder().paymentDependencies((PaymentDependencies) ComponentDependenciesKt.getDependencies(PaymentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).historyDetailsModule(new HistoryDetailsModule()).build().inject(this);
        PaymentHistoryDetailsViewModelFactory paymentHistoryDetailsViewModelFactory2 = this.paymentHistoryDetailsViewModelFactory;
        if (paymentHistoryDetailsViewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentHistoryDetailsViewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, paymentHistoryDetailsViewModelFactory2).get(PaymentHistoryDetailsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(\n …ilsViewModel::class.java]");
        this.b = (PaymentHistoryDetailsViewModel) viewModel;
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.c.throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "receiptButtonClicksRelay…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        bottomSheetDialog.setContentView(com.avito.android.payment.R.layout.payment_history_detailed_info);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setOnDismissListener(e.a);
        Context context = bottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog.setPeekHeight(Contexts.getDisplayHeight(context));
        Views.hide(bottomSheetDialog.findViewById(R.id.header_divider));
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.a.dispose();
        super.onDetach();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "it");
            if (!activity.isFinishing() && !activity.isChangingConfigurations()) {
                activity.finish();
            }
        }
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setApplicationInfoProvider(@NotNull ApplicationInfoProvider applicationInfoProvider2) {
        Intrinsics.checkNotNullParameter(applicationInfoProvider2, "<set-?>");
        this.applicationInfoProvider = applicationInfoProvider2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setPaymentHistoryDetailsViewModelFactory(@NotNull PaymentHistoryDetailsViewModelFactory paymentHistoryDetailsViewModelFactory2) {
        Intrinsics.checkNotNullParameter(paymentHistoryDetailsViewModelFactory2, "<set-?>");
        this.paymentHistoryDetailsViewModelFactory = paymentHistoryDetailsViewModelFactory2;
    }
}
