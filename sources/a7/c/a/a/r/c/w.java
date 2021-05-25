package a7.c.a.a.r.c;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.utils.encryption.BaseConverter;
public final class w extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, BaseConverter> {
    public static final w a = new w();

    public w() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public BaseConverter invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein, "$receiver");
        return new BaseConverter();
    }
}
