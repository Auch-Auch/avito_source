package a7.c.a.a.o.c.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.OsagoOrderAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.OsagoOrderAnswerViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
public final class c extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, OsagoOrderAnswerViewModel> {
    public static final c a = new c();

    public c() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public OsagoOrderAnswerViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (OsagoOrderAnswerViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$12$$special$$inlined$instance$1
        }), null), new OsagoOrderAnswerViewModelFactory((INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$12$$special$$inlined$instance$2
        }), null), (IErrorHandlerWithShow) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorHandlerWithShow>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$12$$special$$inlined$instance$3
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$12$$special$$inlined$instance$4
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$12$$special$$inlined$instance$5
        }), null).invoke("chat"), (IResourceProvider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResourceProvider>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$12$$special$$inlined$instance$6
        }), null))).get(OsagoOrderAnswerViewModel.class);
    }
}
