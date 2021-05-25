package ru.sravni.android.bankproduct.presentation.offer.product.list.view;

import a2.g.r.g;
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
import ru.sravni.android.bankproduct.databinding.OfferProductListFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
import ru.sravni.android.bankproduct.utils.navigation.INavigatorKt;
import ru.sravni.android.bankproduct.utils.navigation.entity.ProductNavOffersInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/view/OfferProductListFragment;", "Lru/sravni/android/bankproduct/utils/CommonFragment;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onPause", "()V", "", "getFragmentModuleName", "()Ljava/lang/String;", "fragmentModuleName", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "f", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "keyboardHider", "Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", g.a, "Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", "productNavOffersInfo", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductListViewModel;", "e", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/IOfferProductListViewModel;", "offerProductListViewModel", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListFragment extends CommonFragment {
    public IOfferProductListViewModel e;
    public IKeyboardHider f;
    public ProductNavOffersInfo g;
    public HashMap h;

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
            Kodein.Builder.DefaultImpls.import$default(builder2, PresentationOfferProductListProviderKt.getPresentationOfferProductListKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public View _$_findCachedViewById(int i) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        View view = (View) this.h.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.h.put(Integer.valueOf(i), findViewById);
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
        return new Kodein.Module("OfferProductListFragmentModule", false, null, a.a, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.g = (arguments == null || (string = arguments.getString(INavigatorKt.NAV_PARAMETER_NAME)) == null) ? null : (ProductNavOffersInfo) a2.b.a.a.a.i2(string, ProductNavOffersInfo.class);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.offer_product_list_fragment_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…sravni, container, false)");
        OfferProductListFragmentSravniBinding offerProductListFragmentSravniBinding = (OfferProductListFragmentSravniBinding) inflate;
        setCurrentModule();
        IOfferProductListViewModel iOfferProductListViewModel = (IOfferProductListViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductListViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.view.OfferProductListFragment$onCreateView$$inlined$instance$1
        }), null);
        this.e = iOfferProductListViewModel;
        ProductNavOffersInfo productNavOffersInfo = this.g;
        if (productNavOffersInfo != null) {
            if (iOfferProductListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductListViewModel");
            }
            iOfferProductListViewModel.initOfferProductNavInfo(productNavOffersInfo);
        }
        this.g = null;
        ISlidingUpPanelViewModel iSlidingUpPanelViewModel = (ISlidingUpPanelViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<ISlidingUpPanelViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.view.OfferProductListFragment$onCreateView$$inlined$instance$2
        }), null);
        IOfferProductListViewModel iOfferProductListViewModel2 = this.e;
        if (iOfferProductListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offerProductListViewModel");
        }
        iOfferProductListViewModel2.updateList();
        IOfferProductListViewModel iOfferProductListViewModel3 = this.e;
        if (iOfferProductListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offerProductListViewModel");
        }
        offerProductListFragmentSravniBinding.setOfferProductListViewModel(iOfferProductListViewModel3);
        offerProductListFragmentSravniBinding.setPanelViewModel(iSlidingUpPanelViewModel);
        offerProductListFragmentSravniBinding.setPanelButtonViewModel((ISlidingPanelButtonViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<ISlidingPanelButtonViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.view.OfferProductListFragment$onCreateView$$inlined$instance$3
        }), null));
        offerProductListFragmentSravniBinding.setSlideLifecycleOwner(getViewLifecycleOwner());
        offerProductListFragmentSravniBinding.setLifecycleOwner(getViewLifecycleOwner());
        View root = offerProductListFragmentSravniBinding.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "binding.root");
        setupActionBar(root, true);
        this.f = (IKeyboardHider) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardHider>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.view.OfferProductListFragment$onCreateView$$inlined$instance$4
        }), null);
        return offerProductListFragmentSravniBinding.getRoot();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IKeyboardHider iKeyboardHider = this.f;
        if (iKeyboardHider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyboardHider");
        }
        iKeyboardHider.hideKeyboard();
        super.onPause();
    }
}
