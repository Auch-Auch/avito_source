package a7.c.a.a.p.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.repository.token.ITokenDataStorage;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
import ru.sravni.android.bankproduct.repository.token.TokenRepository;
public final class o extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, TokenRepository> {
    public static final o a = new o();

    public o() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public TokenRepository invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new TokenRepository((ITokenDataStorage) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenDataStorage>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$9$$special$$inlined$instance$1
        }), "SharedPreference"), (ITokenDataStorage) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenDataStorage>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$9$$special$$inlined$instance$2
        }), "Memory"), (IErrorLogger) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$9$$special$$inlined$instance$3
        }), null), (IThrowableWrapper) noArgSimpleBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$9$$special$$inlined$instance$4
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$9$$special$$inlined$instance$5
        }), null).invoke("repository"), (ITokenRefresher) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenRefresher>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$9$$special$$inlined$instance$6
        }), null));
    }
}
