package a7.c.a.a.o.f.a.a.a;

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
import ru.sravni.android.bankproduct.domain.chat.ISelectUserAnswer;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoFilterViewModel;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModel;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoListViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterDescriptionViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferOsagoListViewModel> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferOsagoListViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OfferOsagoListViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$1
        }), null), new OfferOsagoListViewModelFactory((INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$2
        }), null), (IOfferOsagoInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferOsagoInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (ISelectUserAnswer) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ISelectUserAnswer>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$4
        }), null), (ISlidingUpPanelController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ISlidingUpPanelController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$5
        }), null), (IPanelButtonsController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPanelButtonsController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$6
        }), null), (IOfferOsagoFilterViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferOsagoFilterViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$7
        }), null), (IFilterDescriptionViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFilterDescriptionViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$8
        }), null), (IFilterBarrelDayViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFilterBarrelDayViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$9
        }), null), (IFilterListInfoViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFilterListInfoViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$10
        }), null), (IFilterSwitcherListViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFilterSwitcherListViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$11
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$12
        }), null), (IErrorHandlerWithShow) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorHandlerWithShow>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$13
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$14
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$15
        }), null).invoke(BaseAnalyticKt.ANALYTIC_MODULE_OFFER), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$16
        }), null), (IOfferAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$17
        }), null), (IResultAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResultAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$18
        }), null), (IPreviousModuleInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfo>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$19
        }), null), (IResourceProvider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResourceProvider>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$1$$special$$inlined$instance$20
        }), null))).get(OfferOsagoListViewModel.class);
    }
}
