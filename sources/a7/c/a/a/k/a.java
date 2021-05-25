package a7.c.a.a.k;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.mock.auth.AuthService;
import ru.sravni.android.bankproduct.repository.token.ITokenDataStorage;
public final class a extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, AuthService> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public AuthService invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new AuthService(((Number) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Long>() { // from class: ru.sravni.android.bankproduct.di.MockDataProviderKt$mockDataKodeinModule$1$1$$special$$inlined$instance$1
        }), "delay")).longValue(), (ITokenDataStorage) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenDataStorage>() { // from class: ru.sravni.android.bankproduct.di.MockDataProviderKt$mockDataKodeinModule$1$1$$special$$inlined$instance$2
        }), "Memory"));
    }
}
