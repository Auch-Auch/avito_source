package ru.sravni.android.bankproduct.presentation.offer.product.info.view;

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
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBinding;
import ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoFromChat;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoFromList;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoFromChatViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoFromListViewModel;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigatorKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/view/OfferProductInfoFragment;", "Lru/sravni/android/bankproduct/utils/CommonFragment;", "Lorg/kodein/di/Kodein$Module;", "initModule", "()Lorg/kodein/di/Kodein$Module;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "getFragmentModuleName", "()Ljava/lang/String;", "fragmentModuleName", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "h", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "detailInfoFromChat", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoFromChatViewModel;", "f", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoFromChatViewModel;", "offerProductInfoFromChatViewModel", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;", g.a, "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;", "detailInfoFromList", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoFromListViewModel;", "e", "Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoFromListViewModel;", "offerProductInfoFromListViewModel", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductInfoFragment extends CommonFragment {
    public IOfferProductInfoFromListViewModel e;
    public IOfferProductInfoFromChatViewModel f;
    public OfferProductDetailInfoFromList g;
    public OfferProductDetailInfoFromChat h;
    public HashMap i;

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
            Kodein.Builder.DefaultImpls.import$default(builder2, PresentationOfferProductInfoProviderKt.getPresentationOfferProductInfoKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment
    public View _$_findCachedViewById(int i2) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        View view = (View) this.i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.i.put(Integer.valueOf(i2), findViewById);
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
        return new Kodein.Module("OfferProductInfoFragmentModule", false, null, a.a, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        OfferProductDetailInfo offerProductDetailInfo;
        OfferProductDetailInfoFromChat detailInfoFromChat;
        String string2;
        OfferProductDetailInfo offerProductDetailInfo2;
        OfferProductDetailInfoFromList detailInfoFromList;
        super.onCreate(bundle);
        this.e = (IOfferProductInfoFromListViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInfoFromListViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.view.OfferProductInfoFragment$onCreate$$inlined$instance$1
        }), null);
        this.f = (IOfferProductInfoFromChatViewModel) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInfoFromChatViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.view.OfferProductInfoFragment$onCreate$$inlined$instance$2
        }), null);
        Bundle arguments = getArguments();
        if (!(arguments == null || (string2 = arguments.getString(INavigatorKt.NAV_PARAMETER_NAME)) == null || (offerProductDetailInfo2 = (OfferProductDetailInfo) a2.b.a.a.a.i2(string2, OfferProductDetailInfo.class)) == null || (detailInfoFromList = offerProductDetailInfo2.getDetailInfoFromList()) == null)) {
            this.g = detailInfoFromList;
            IOfferProductInfoFromListViewModel iOfferProductInfoFromListViewModel = this.e;
            if (iOfferProductInfoFromListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductInfoFromListViewModel");
            }
            iOfferProductInfoFromListViewModel.initWithDetailInfo(detailInfoFromList);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString(INavigatorKt.NAV_PARAMETER_NAME)) != null && (offerProductDetailInfo = (OfferProductDetailInfo) a2.b.a.a.a.i2(string, OfferProductDetailInfo.class)) != null && (detailInfoFromChat = offerProductDetailInfo.getDetailInfoFromChat()) != null) {
            this.h = detailInfoFromChat;
            IOfferProductInfoFromChatViewModel iOfferProductInfoFromChatViewModel = this.f;
            if (iOfferProductInfoFromChatViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductInfoFromChatViewModel");
            }
            iOfferProductInfoFromChatViewModel.initWithDetailInfo(detailInfoFromChat);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.offer_product_info_fragment_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…      false\n            )");
        OfferProductInfoFragmentSravniBinding offerProductInfoFragmentSravniBinding = (OfferProductInfoFragmentSravniBinding) inflate;
        setCurrentModule();
        if (this.g != null) {
            IOfferProductInfoFromListViewModel iOfferProductInfoFromListViewModel = this.e;
            if (iOfferProductInfoFromListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductInfoFromListViewModel");
            }
            offerProductInfoFragmentSravniBinding.setOfferProductInfoViewModel(iOfferProductInfoFromListViewModel.getOfferProductInfoController());
            IOfferProductInfoFromListViewModel iOfferProductInfoFromListViewModel2 = this.e;
            if (iOfferProductInfoFromListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductInfoFromListViewModel");
            }
            offerProductInfoFragmentSravniBinding.setClickOfferProduct(iOfferProductInfoFromListViewModel2);
            IOfferProductInfoFromListViewModel iOfferProductInfoFromListViewModel3 = this.e;
            if (iOfferProductInfoFromListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductInfoFromListViewModel");
            }
            offerProductInfoFragmentSravniBinding.setProductAction(iOfferProductInfoFromListViewModel3);
        }
        if (this.h != null) {
            IOfferProductInfoFromChatViewModel iOfferProductInfoFromChatViewModel = this.f;
            if (iOfferProductInfoFromChatViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductInfoFromChatViewModel");
            }
            offerProductInfoFragmentSravniBinding.setOfferProductInfoViewModel(iOfferProductInfoFromChatViewModel.getOfferProductInfoController());
            IOfferProductInfoFromChatViewModel iOfferProductInfoFromChatViewModel2 = this.f;
            if (iOfferProductInfoFromChatViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductInfoFromChatViewModel");
            }
            offerProductInfoFragmentSravniBinding.setClickOfferProduct(iOfferProductInfoFromChatViewModel2);
            IOfferProductInfoFromChatViewModel iOfferProductInfoFromChatViewModel3 = this.f;
            if (iOfferProductInfoFromChatViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offerProductInfoFromChatViewModel");
            }
            offerProductInfoFragmentSravniBinding.setOfferRetryErrorViewModel(iOfferProductInfoFromChatViewModel3);
        }
        offerProductInfoFragmentSravniBinding.setLifecycleOwner(getViewLifecycleOwner());
        View root = offerProductInfoFragmentSravniBinding.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "binding.root");
        setupActionBar(root, true);
        return offerProductInfoFragmentSravniBinding.getRoot();
    }

    @Override // ru.sravni.android.bankproduct.utils.CommonFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
