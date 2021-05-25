package a7.c.a.a.p.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenRepository;
import ru.sravni.android.bankproduct.repository.auth.AuthRepository;
import ru.sravni.android.bankproduct.repository.auth.IAuthWebClient;
public final class n extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, AuthRepository> {
    public static final n a = new n();

    public n() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public AuthRepository invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new AuthRepository((ITokenRepository) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenRepository>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$8$$special$$inlined$instance$1
        }), null), (IAuthWebClient) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IAuthWebClient>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$8$$special$$inlined$instance$2
        }), null), (IThrowableWrapper) noArgSimpleBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$8$$special$$inlined$instance$3
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$8$$special$$inlined$instance$4
        }), null).invoke("repository"));
    }
}
