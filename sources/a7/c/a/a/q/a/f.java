package a7.c.a.a.q.a;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.storage.token.TokenDataSharedPreferenceStorage;
import ru.sravni.android.bankproduct.utils.encryption.IEncryptionUtil;
public final class f extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, TokenDataSharedPreferenceStorage> {
    public static final f a = new f();

    public f() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public TokenDataSharedPreferenceStorage invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new TokenDataSharedPreferenceStorage((Context) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Application>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$6$$special$$inlined$instance$1
        }), null), (IEncryptionUtil) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IEncryptionUtil>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$6$$special$$inlined$instance$2
        }), null), (IErrorLogger) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt$storageKodeinModule$1$6$$special$$inlined$instance$3
        }), "externalErrorLogger"));
    }
}
