package a7.c.a.a.o.e.a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.presentation.main.viewmodel.ErrorViewModel;
import ru.sravni.android.bankproduct.presentation.main.viewmodel.ErrorViewModelFactory;
public final class e extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ErrorViewModel> {
    public static final e a = new e();

    public e() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ErrorViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (ErrorViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<AppCompatActivity>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$3$$special$$inlined$instance$1
        }), null), new ErrorViewModelFactory((IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$3$$special$$inlined$instance$2
        }), null))).get(ErrorViewModel.class);
    }
}
