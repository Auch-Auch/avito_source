package a7.c.a.a.r.c;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.SimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.sravnierror.ThrowableWrapper;
import ru.sravni.android.bankproduct.utils.di.UtilProviderKt;
public final class b extends Lambda implements Function2<SimpleBindingKodein<? extends Object>, String, ThrowableWrapper> {
    public static final b a = new b();

    public b() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public ThrowableWrapper invoke(SimpleBindingKodein<? extends Object> simpleBindingKodein, String str) {
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(simpleBindingKodein, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "key");
        return UtilProviderKt.throwableWrapperFactoryMethod(str2);
    }
}
