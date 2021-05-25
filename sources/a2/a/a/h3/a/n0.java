package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class n0 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        super(0);
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.t = null;
        return Unit.INSTANCE;
    }
}
