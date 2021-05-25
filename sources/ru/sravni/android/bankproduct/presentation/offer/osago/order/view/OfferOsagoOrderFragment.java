package ru.sravni.android.bankproduct.presentation.offer.osago.order.view;

import a7.c.a.a.o.f.a.b.b.a;
import a7.c.a.a.o.f.a.b.b.b;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.KodeinProperty;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.databinding.OfferOsagoOrderFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter.AlternativeOsagoCompanyAdapter;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter.IAlternativeCompany;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OsagoOrderButtonState;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigatorKt;
import ru.sravni.android.bankproduct.utils.navigation.entity.OsagoNavOrderInfo;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016²\u0006\u000e\u0010\u0015\u001a\u00020\u00148\n@\nX\u0002"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/order/view/OfferOsagoOrderFragment;", "Lru/sravni/android/bankproduct/utils/CommonFragment;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "getFragmentModuleName", "()Ljava/lang/String;", "fragmentModuleName", "<init>", "()V", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/IOfferOsagoOrderViewModel;", "viewModel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoOrderFragment extends CommonFragment {
    public static final /* synthetic */ KProperty[] f = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(OfferOsagoOrderFragment.class), "viewModel", "<v#0>"))};
    public HashMap e;

    public static final void access$showRestartChatDialog(OfferOsagoOrderFragment offerOsagoOrderFragment, IOfferOsagoOrderViewModel iOfferOsagoOrderViewModel) {
        Objects.requireNonNull(offerOsagoOrderFragment);
        Context context = offerOsagoOrderFragment.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        new MaterialAlertDialogBuilder(context).setTitle((CharSequence) offerOsagoOrderFragment.getString(R.string.order_exit_title)).setMessage((CharSequence) offerOsagoOrderFragment.getString(R.string.order_exit_text)).setPositiveButton(R.string.order_exit_confirm, (DialogInterface.OnClickListener) new a(iOfferOsagoOrderViewModel)).setNegativeButton(R.string.order_exit_decline, (DialogInterface.OnClickListener) b.a).show();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public View _$_findCachedViewById(int i) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        View view = (View) this.e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @Nullable
    public String getFragmentModuleName() {
        return BaseAnalyticKt.ANALYTIC_MODULE_OFFER;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @NotNull
    public Kodein.Module initModule() {
        return PresentationOfferOsagoOrderProviderKt.getPresentationOfferOsagoOrderKodeinModule();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Resources resources;
        DisplayMetrics displayMetrics;
        String string;
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.offer_osago_order_fragment_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…sravni, container, false)");
        OfferOsagoOrderFragmentSravniBinding offerOsagoOrderFragmentSravniBinding = (OfferOsagoOrderFragmentSravniBinding) inflate;
        OsagoNavOrderInfo osagoNavOrderInfo = null;
        KodeinProperty Instance = KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<IOfferOsagoOrderViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.view.OfferOsagoOrderFragment$onCreateView$$inlined$instance$1
        }), null);
        KProperty<? extends Object> kProperty = f[0];
        Lazy provideDelegate = Instance.provideDelegate(null, kProperty);
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString(INavigatorKt.NAV_PARAMETER_NAME)) == null)) {
            osagoNavOrderInfo = (OsagoNavOrderInfo) a2.b.a.a.a.i2(string, OsagoNavOrderInfo.class);
        }
        ((IOfferOsagoOrderViewModel) provideDelegate.getValue()).initOsagoInfo(osagoNavOrderInfo);
        offerOsagoOrderFragmentSravniBinding.setLifecycleOwner(getViewLifecycleOwner());
        offerOsagoOrderFragmentSravniBinding.setOfferOsagoOrderViewModel((IOfferOsagoOrderViewModel) provideDelegate.getValue());
        FragmentActivity activity = getActivity();
        AlternativeOsagoCompanyAdapter alternativeOsagoCompanyAdapter = new AlternativeOsagoCompanyAdapter(c.roundToInt(((double) ((activity == null || (resources = activity.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 640 : displayMetrics.widthPixels)) * 0.85d), (IAlternativeCompany) provideDelegate.getValue());
        DiscreteScrollView discreteScrollView = offerOsagoOrderFragmentSravniBinding.incStatusView.rvAnotherCompany;
        Intrinsics.checkExpressionValueIsNotNull(discreteScrollView, "binding.incStatusView.rvAnotherCompany");
        discreteScrollView.setAdapter(alternativeOsagoCompanyAdapter);
        View root = offerOsagoOrderFragmentSravniBinding.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "binding.root");
        setupActionBar(root, true);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        requireActivity.getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(this, provideDelegate, kProperty, true) { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.view.OfferOsagoOrderFragment$onCreateView$1
            public final /* synthetic */ OfferOsagoOrderFragment c;
            public final /* synthetic */ Lazy d;
            public final /* synthetic */ KProperty e;

            {
                this.c = r1;
                this.d = r2;
                this.e = r3;
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (((IOfferOsagoOrderViewModel) this.d.getValue()).getOsagoOrderButtonState().getValue() != OsagoOrderButtonState.GO_TO_CHAT) {
                    OfferOsagoOrderFragment.access$showRestartChatDialog(this.c, (IOfferOsagoOrderViewModel) this.d.getValue());
                } else {
                    ((IOfferOsagoOrderViewModel) this.d.getValue()).closeAction();
                }
            }
        });
        return offerOsagoOrderFragmentSravniBinding.getRoot();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
