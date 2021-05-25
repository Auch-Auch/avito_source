package a7.c.a.a.r.c;

import javax.crypto.Cipher;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
public final class x extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, Cipher> {
    public static final x a = new x();

    public x() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Cipher invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein, "$receiver");
        return Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
}
