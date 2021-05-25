package a7.c.a.a.o.f.b.a.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.offer.product.IOfferProductInteractor;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoController;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.OfferProductInfoFromChatViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.OfferProductInfoFromChatViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferProductInfoFromChatViewModel> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductInfoFromChatViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OfferProductInfoFromChatViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$2$$special$$inlined$instance$1
        }), null), new OfferProductInfoFromChatViewModelFactory((IOfferProductInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$2$$special$$inlined$instance$2
        }), null), (IOfferProductInfoController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOfferProductInfoController>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$2$$special$$inlined$instance$3
        }), null), (IFeatureToggleRouterDomain) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFeatureToggleRouterDomain>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$2$$special$$inlined$instance$4
        }), null), (IResourceProvider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResourceProvider>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.info.di.PresentationOfferProductInfoProviderKt$presentationOfferProductInfoKodeinModule$1$2$$special$$inlined$instance$5
        }), null))).get(OfferProductInfoFromChatViewModel.class);
    }
}
