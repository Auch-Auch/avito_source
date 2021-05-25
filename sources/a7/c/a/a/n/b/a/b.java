package a7.c.a.a.n.b.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.network.chat.ChatWebClient;
import ru.sravni.android.bankproduct.network.chat.IChatApi;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ChatWebClient> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ChatWebClient invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return new ChatWebClient((IChatApi) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IChatApi>() { // from class: ru.sravni.android.bankproduct.network.chat.di.NetworkChatProviderKt$networkChatKodeinModule$1$2$$special$$inlined$instance$1
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.network.chat.di.NetworkChatProviderKt$networkChatKodeinModule$1$2$$special$$inlined$instance$2
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.network.chat.di.NetworkChatProviderKt$networkChatKodeinModule$1$2$$special$$inlined$instance$3
        }), null).invoke("network"), (ITokenRefresher) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenRefresher>() { // from class: ru.sravni.android.bankproduct.network.chat.di.NetworkChatProviderKt$networkChatKodeinModule$1$2$$special$$inlined$instance$4
        }), null));
    }
}
