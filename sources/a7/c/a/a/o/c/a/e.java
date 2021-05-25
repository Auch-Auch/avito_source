package a7.c.a.a.o.c.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.PassportScanAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.PassportScanViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
public final class e extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, PassportScanAnswerViewModel> {
    public static final e a = new e();

    public e() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public PassportScanAnswerViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (PassportScanAnswerViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$14$$special$$inlined$instance$1
        }), null), new PassportScanViewModelFactory((IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$14$$special$$inlined$instance$2
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$14$$special$$inlined$instance$3
        }), null).invoke("chat"), (IErrorHandlerWithShow) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorHandlerWithShow>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$14$$special$$inlined$instance$4
        }), null), (IResourceProvider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResourceProvider>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$14$$special$$inlined$instance$5
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$14$$special$$inlined$instance$6
        }), null))).get(PassportScanAnswerViewModel.class);
    }
}
