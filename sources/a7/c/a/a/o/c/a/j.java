package a7.c.a.a.o.c.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.analytic.v2.product.IProductAnalytic;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.controller.IChatAnalyticController;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.ChatViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.ChatViewModelFactory;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
public final class j extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ChatViewModel> {
    public static final j a = new j();

    public j() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ChatViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (ChatViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$1
        }), null), new ChatViewModelFactory((ChatInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ChatInfo>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$2
        }), "chatInfo"), (IChatAnalyticController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IChatAnalyticController>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$3
        }), null), (IChatInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IChatInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$4
        }), null), (IKeyboardHider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardHider>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$5
        }), null), (IErrorHandlerWithShow) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorHandlerWithShow>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$6
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$7
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$8
        }), null).invoke("chat"), (IPreviousModuleInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfo>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$9
        }), null), (IProductAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$10
        }), null), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$11
        }), null), (List) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<List<? extends IChatAnswerInitialize>>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$4$$special$$inlined$instance$12
        }), null))).get(ChatViewModel.class);
    }
}
