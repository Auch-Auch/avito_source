package a7.c.a.a.o.f.a.b.a;

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
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.offer.osago.IOfferOsagoInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModel;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.OfferOsagoOrderViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferOsagoOrderViewModel> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferOsagoOrderViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OfferOsagoOrderViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$1
        }), null), new OfferOsagoOrderViewModelFactory((INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$2
        }), "MainNavigator"), (IOfferOsagoInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferOsagoInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$4
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$5
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$6
        }), null).invoke(BaseAnalyticKt.ANALYTIC_MODULE_OFFER), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$7
        }), null), (IOfferAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$8
        }), null), (IPreviousModuleInfoController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfoController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$9
        }), null), (IResourceProvider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResourceProvider>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.order.di.PresentationOfferOsagoOrderProviderKt$presentationOfferOsagoOrderKodeinModule$1$1$$special$$inlined$instance$10
        }), null))).get(OfferOsagoOrderViewModel.class);
    }
}
