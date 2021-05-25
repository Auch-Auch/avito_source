package a7.c.a.a.o.d.a;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel.DialogErrorViewModel;
import ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel.DialogErrorViewModelFactory;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, DialogErrorViewModel> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public DialogErrorViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (DialogErrorViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<DialogFragment>() { // from class: ru.sravni.android.bankproduct.presentation.dialogerror.di.PresentationDialogErrorProviderKt$presentationDialogErrorKodeinModule$1$2$$special$$inlined$instance$1
        }), null), new DialogErrorViewModelFactory((String) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.dialogerror.di.PresentationDialogErrorProviderKt$presentationDialogErrorKodeinModule$1$2$$special$$inlined$instance$2
        }), "argErrorMessage"))).get(DialogErrorViewModel.class);
    }
}
