package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class w0 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        super(1);
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        MyAdvertDetailsPresenterImpl.c(this.a, null, false, null, null, 15);
        return Unit.INSTANCE;
    }
}
