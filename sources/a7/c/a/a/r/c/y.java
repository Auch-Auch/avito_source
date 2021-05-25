package a7.c.a.a.r.c;

import javax.crypto.Cipher;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.utils.encryption.EncryptionUtil;
import ru.sravni.android.bankproduct.utils.encryption.IBaseConverter;
import ru.sravni.android.bankproduct.utils.encryption.ICryptParamsFormer;
public final class y extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, EncryptionUtil> {
    public static final y a = new y();

    public y() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public EncryptionUtil invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new EncryptionUtil((ICryptParamsFormer) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ICryptParamsFormer>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$9$$special$$inlined$instance$1
        }), null), (IBaseConverter) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IBaseConverter>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$9$$special$$inlined$instance$2
        }), null), (Cipher) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<Cipher>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$9$$special$$inlined$instance$3
        }), null));
    }
}
