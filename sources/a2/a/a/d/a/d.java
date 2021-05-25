package a2.a.a.d.a;

import com.avito.android.abuse.details.AbuseDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ AbuseDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
        super(0);
        this.a = abuseDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.d();
        return Unit.INSTANCE;
    }
}
