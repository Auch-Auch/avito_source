package a7.c.a.a.m;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.mock.controller.chat.ConversationMockController;
import ru.sravni.android.bankproduct.mock.controller.chat.ConversationWebClientStubInfo;
public final class h extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ConversationMockController> {
    public static final h a = new h();

    public h() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ConversationMockController invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return new ConversationMockController((Context) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Application>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$2$$special$$inlined$instance$1
        }), null), (ConversationWebClientStubInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ConversationWebClientStubInfo>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$2$$special$$inlined$instance$2
        }), null));
    }
}
