package a7.c.a.a.o.f.b.b.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductFilterViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductFilterViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferProductFilterViewModel> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductFilterViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OfferProductFilterViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$1
        }), null), new OfferProductFilterViewModelFactory((IPanelButtonsController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPanelButtonsController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$2
        }), null), (IOfferProductInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$3
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$4
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$5
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$6
        }), null).invoke(BaseAnalyticKt.ANALYTIC_MODULE_OFFER), (IPreviousModuleInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfo>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$7
        }), null), (IResultAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResultAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$8
        }), null), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$9
        }), null), (IFeatureToggleRouterDomain) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFeatureToggleRouterDomain>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$2$$special$$inlined$instance$10
        }), null))).get(OfferProductFilterViewModel.class);
    }
}
