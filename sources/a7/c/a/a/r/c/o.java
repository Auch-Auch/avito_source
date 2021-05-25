package a7.c.a.a.r.c;

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
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.keyboard.KeyboardViewModel;
import ru.sravni.android.bankproduct.utils.keyboard.KeyboardViewModelFactory;
public final class o extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, KeyboardViewModel> {
    public static final o a = new o();

    public o() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public KeyboardViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (KeyboardViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<AppCompatActivity>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$23$$special$$inlined$instance$1
        }), null), new KeyboardViewModelFactory((IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$23$$special$$inlined$instance$2
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$23$$special$$inlined$instance$3
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$23$$special$$inlined$instance$4
        }), null).invoke("chat"))).get(KeyboardViewModel.class);
    }
}
