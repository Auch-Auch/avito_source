package ru.sravni.android.bankproduct.presentation.offer.osago.list.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel;
import ru.sravni.android.bankproduct.utils.navigation.INavigatorKt;
import ru.sravni.android.bankproduct.utils.navigation.entity.OsagoNavOffersInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/view/OfferOsagoListFragment;", "Lru/sravni/android/bankproduct/utils/CommonFragment;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onResume", "()V", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoListViewModel;", "e", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoListViewModel;", "offerOsagoListViewModel", "", "getFragmentModuleName", "()Ljava/lang/String;", "fragmentModuleName", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListFragment extends CommonFragment {
    public IOfferOsagoListViewModel e;
    public HashMap f;

    public static final class a extends Lambda implements Function1<Kodein.Builder, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Kodein.Builder builder) {
            Kodein.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "$receiver");
            Kodein.Builder.DefaultImpls.import$default(builder2, PresentationOfferOsagoListProviderKt.getPresentationOfferOsagoListKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public View _$_findCachedViewById(int i) {
        if (this.f == null) {
            this.f = new HashMap();
        }
        View view = (View) this.f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @Nullable
    public String getFragmentModuleName() {
        return "result";
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    @NotNull
    public Kodein.Module initModule() {
        return new Kodein.Module("OfferOsagoListFragmentModule", false, null, a.a, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        String string;
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.offer_osago_list_fragment_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…sravni, container, false)");
        OfferOsagoListFragmentSravniBinding offerOsagoListFragmentSravniBinding = (OfferOsagoListFragmentSravniBinding) inflate;
        Bundle arguments = getArguments();
        OsagoNavOffersInfo osagoNavOffersInfo = (arguments == null || (string = arguments.getString(INavigatorKt.NAV_PARAMETER_NAME)) == null) ? null : (OsagoNavOffersInfo) a2.b.a.a.a.i2(string, OsagoNavOffersInfo.class);
        ISlidingUpPanelViewModel iSlidingUpPanelViewModel = (ISlidingUpPanelViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<ISlidingUpPanelViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.view.OfferOsagoListFragment$onCreateView$$inlined$instance$1
        }), null);
        IOfferOsagoListViewModel iOfferOsagoListViewModel = (IOfferOsagoListViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferOsagoListViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.view.OfferOsagoListFragment$onCreateView$$inlined$instance$2
        }), null);
        this.e = iOfferOsagoListViewModel;
        if (iOfferOsagoListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offerOsagoListViewModel");
        }
        iOfferOsagoListViewModel.initOsagoInfo(osagoNavOffersInfo);
        IOfferOsagoListViewModel iOfferOsagoListViewModel2 = this.e;
        if (iOfferOsagoListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offerOsagoListViewModel");
        }
        offerOsagoListFragmentSravniBinding.setOfferOsagoListViewModel(iOfferOsagoListViewModel2);
        offerOsagoListFragmentSravniBinding.setPanelViewModel(iSlidingUpPanelViewModel);
        offerOsagoListFragmentSravniBinding.setPanelButtonViewModel((ISlidingPanelButtonViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<ISlidingPanelButtonViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.view.OfferOsagoListFragment$onCreateView$$inlined$instance$3
        }), null));
        offerOsagoListFragmentSravniBinding.setSlideLifecycleOwner(getViewLifecycleOwner());
        offerOsagoListFragmentSravniBinding.setLifecycleOwner(getViewLifecycleOwner());
        View root = offerOsagoListFragmentSravniBinding.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "binding.root");
        setupActionBar(root, true);
        return offerOsagoListFragmentSravniBinding.getRoot();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOfferOsagoListViewModel iOfferOsagoListViewModel = this.e;
        if (iOfferOsagoListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offerOsagoListViewModel");
        }
        iOfferOsagoListViewModel.checkDate();
    }
}
