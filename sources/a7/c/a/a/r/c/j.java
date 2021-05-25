package a7.c.a.a.r.c;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.SlidingPanelButtonViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.SlidingPanelButtonViewModelFactory;
public final class j extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, SlidingPanelButtonViewModel> {
    public static final j a = new j();

    public j() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public SlidingPanelButtonViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (SlidingPanelButtonViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$19$$special$$inlined$instance$1
        }), null), new SlidingPanelButtonViewModelFactory((ISlidingUpPanelController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ISlidingUpPanelViewModel>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$19$$special$$inlined$instance$2
        }), null))).get(SlidingPanelButtonViewModel.class);
    }
}
