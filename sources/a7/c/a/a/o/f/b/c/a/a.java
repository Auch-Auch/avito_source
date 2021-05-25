package a7.c.a.a.o.f.b.c.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel.OfferProductStatusViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel.OfferProductStatusViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OfferProductStatusViewModel> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OfferProductStatusViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OfferProductStatusViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.status.di.PresentationOfferProductStatusKodeinModuleKt$presentationOfferProductStatusKodeinModule$1$1$$special$$inlined$instance$1
        }), null), new OfferProductStatusViewModelFactory((INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.status.di.PresentationOfferProductStatusKodeinModuleKt$presentationOfferProductStatusKodeinModule$1$1$$special$$inlined$instance$2
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.offer.product.status.di.PresentationOfferProductStatusKodeinModuleKt$presentationOfferProductStatusKodeinModule$1$1$$special$$inlined$instance$3
        }), null))).get(OfferProductStatusViewModel.class);
    }
}
