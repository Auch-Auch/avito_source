package a7.c.a.a.r.c;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.utils.sms.SmsReceiver;
public final class t extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, SmsReceiver> {
    public static final t a = new t();

    public t() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public SmsReceiver invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein, "$receiver");
        return new SmsReceiver();
    }
}
