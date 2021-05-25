package a2.a.a.s1;

import com.avito.android.util.Logs;
import com.sumsub.sns.core.data.model.SNSException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<SNSException, Unit> {
    public static final d a = new d();

    public d() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(SNSException sNSException) {
        SNSException sNSException2 = sNSException;
        Intrinsics.checkNotNullParameter(sNSException2, "it");
        Logs.error("Sumsub SDK error", sNSException2);
        return Unit.INSTANCE;
    }
}
