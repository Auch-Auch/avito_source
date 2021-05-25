package a7.c.a.a.m;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.mock.auth.IAuthAccessData;
import ru.sravni.android.bankproduct.mock.webclient.ChatWebClientStub;
import ru.sravni.android.bankproduct.mock.webclient.IConversationRepoMockController;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
public final class i extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, ChatWebClientStub> {
    public static final i a = new i();

    public i() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ChatWebClientStub invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new ChatWebClientStub(((Number) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Long>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$3$$special$$inlined$instance$1
        }), "delay")).longValue(), (IConversationRepoMockController) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IConversationRepoMockController>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$3$$special$$inlined$instance$2
        }), null), (ITokenRefresher) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenRefresher>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$3$$special$$inlined$instance$3
        }), null), (IAuthAccessData) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IAuthAccessData>() { // from class: ru.sravni.android.bankproduct.mock.StubProviderKt$stubKodeinModule$1$3$$special$$inlined$instance$4
        }), null));
    }
}
