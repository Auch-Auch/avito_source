package a7.c.a.a.o.f.a.a.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoFilterViewModel;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.OfferOsagoFilterViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferOsagoFilterViewModel> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferOsagoFilterViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OfferOsagoFilterViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$2$$special$$inlined$instance$1
        }), null), new OfferOsagoFilterViewModelFactory((IResultAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResultAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$2$$special$$inlined$instance$2
        }), null), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$2$$special$$inlined$instance$3
        }), null), (IPreviousModuleInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfo>() { // from class: ru.sravni.android.bankproduct.presentation.offer.osago.list.di.PresentationOfferOsagoListProviderKt$presentationOfferOsagoListKodeinModule$1$2$$special$$inlined$instance$4
        }), null))).get(OfferOsagoFilterViewModel.class);
    }
}
