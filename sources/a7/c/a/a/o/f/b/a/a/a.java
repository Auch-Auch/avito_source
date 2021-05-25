package a7.c.a.a.o.f.b.a.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.OfferProductInfoController;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferProductInfoController> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductInfoController invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return new OfferProductInfoController((INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$1
        }), "MainNavigator"), (IOfferProductInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$2
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (IErrorHandlerWithShow) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorHandlerWithShow>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$4
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$5
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$6
        }), null).invoke(BaseAnalyticKt.ANALYTIC_MODULE_OFFER), (IOfferAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$7
        }), null), (IPreviousModuleInfoController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfoController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$8
        }), null), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$9
        }), null), (IChatInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IChatInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$1$$special$$inlined$instance$10
        }), null));
    }
}
