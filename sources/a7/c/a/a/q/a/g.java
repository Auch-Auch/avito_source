package a7.c.a.a.q.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.storage.token.TokenDataSharedPreferenceStorage;
public final class g extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, TokenDataSharedPreferenceStorage> {
    public static final g a = new g();

    public g() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public TokenDataSharedPreferenceStorage invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (TokenDataSharedPreferenceStorage) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<TokenDataSharedPreferenceStorage>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$7$$special$$inlined$instance$1
        }), null);
    }
}
