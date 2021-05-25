package a7.c.a.a.o.f.b.a.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoController;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.OfferProductInfoFromListViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.OfferProductInfoFromListViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
public final class c extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferProductInfoFromListViewModel> {
    public static final c a = new c();

    public c() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductInfoFromListViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OfferProductInfoFromListViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$3$$special$$inlined$instance$1
        }), null), new OfferProductInfoFromListViewModelFactory((IOfferProductInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$3$$special$$inlined$instance$2
        }), null), (IOfferProductInfoController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInfoController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$3$$special$$inlined$instance$3
        }), null), (IFeatureToggleRouterDomain) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFeatureToggleRouterDomain>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$3$$special$$inlined$instance$4
        }), null), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$3$$special$$inlined$instance$5
        }), null))).get(OfferProductInfoFromListViewModel.class);
    }
}
