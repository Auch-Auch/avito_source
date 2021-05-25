package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class y0 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MyAdvertDetailsViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y0(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl) {
        super(0);
        this.a = myAdvertDetailsViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.d0.onVerificationButtonClicked();
        return Unit.INSTANCE;
    }
}
