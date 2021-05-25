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
import ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductFilterViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductListViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.OfferProductListViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferProductListViewModel> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductListViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OfferProductListViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$1
        }), null), new OfferProductListViewModelFactory((INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$2
        }), "MainNavigator"), (IOfferProductInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$4
        }), null), (IErrorHandlerWithShow) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorHandlerWithShow>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$5
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$6
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$7
        }), null).invoke(BaseAnalyticKt.ANALYTIC_MODULE_OFFER), (ISlidingUpPanelController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ISlidingUpPanelController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$8
        }), null), (IPanelButtonsController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPanelButtonsController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$9
        }), null), (IOfferProductFilterViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductFilterViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$10
        }), null), (IFilterSliderViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFilterSliderViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$11
        }), null), (IFilterSnapPointViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFilterSnapPointViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$12
        }), null), (IPreviousModuleInfoController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfoController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$13
        }), null), (IOfferAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$14
        }), null), (IResultAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResultAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$15
        }), null), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$16
        }), null), (IFeatureToggleRouterDomain) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFeatureToggleRouterDomain>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$17
        }), null), (IChatInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IChatInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$18
        }), null), (IResourceProvider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResourceProvider>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.list.di.PresentationOfferProductListProviderKt$presentationOfferProductListKodeinModule$1$1$$special$$inlined$instance$19
        }), null))).get(OfferProductListViewModel.class);
    }
}
