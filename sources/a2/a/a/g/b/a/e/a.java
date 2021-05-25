package a2.a.a.g.b.a.e;

import com.avito.android.advert_core.analytics.broker.BankData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<BankData, CharSequence> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(BankData bankData) {
        BankData bankData2 = bankData;
        Intrinsics.checkNotNullParameter(bankData2, "it");
        return bankData2.toJson();
    }
}
