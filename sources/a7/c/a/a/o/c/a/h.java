package a7.c.a.a.o.c.a;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IButtonAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditDetailAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditOffersAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOffersAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOrderAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel;
public final class h extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, List<? extends IChatAnswerInitialize>> {
    public static final h a = new h();

    public h() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public List<? extends IChatAnswerInitialize> invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new IChatAnswerInitialize[]{(IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IButtonAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$1
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ICreditDetailAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$2
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ICreditOffersAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$3
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFreeTextAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$4
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IMaskTextAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$5
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOsagoOffersAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$6
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IOsagoOrderAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$7
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPassportScanAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$8
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ISliderAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$9
        }), null), (IChatAnswerInitialize) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ISuggestionAnswerViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$2$$special$$inlined$instance$10
        }), null)});
    }
}
