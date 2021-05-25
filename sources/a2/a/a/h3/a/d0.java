package a2.a.a.h3.a;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d0 extends Lambda implements Function1<SuccessResult, Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl.j a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d0(MyAdvertDetailsPresenterImpl.j jVar, boolean z, String str) {
        super(1);
        this.a = jVar;
        this.b = z;
        this.c = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(SuccessResult successResult) {
        String str;
        SuccessResult successResult2 = successResult;
        Intrinsics.checkNotNullParameter(successResult2, "stopAdvertResult");
        MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl = this.a.a;
        if (this.b) {
            str = successResult2.getMessage();
        } else {
            str = myAdvertDetailsPresenterImpl.G.getPriceUpdateErrorMessage();
        }
        myAdvertDetailsPresenterImpl.d = str;
        MyAdvertDetailsPresenterImpl.j jVar = this.a;
        MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl2 = jVar.a;
        String str2 = jVar.e;
        Boolean showAppRater = jVar.d.getShowAppRater();
        MyAdvertDetailsPresenterImpl.j jVar2 = this.a;
        MyAdvertDetailsPresenterImpl.access$onAdvertDeactivated(myAdvertDetailsPresenterImpl2, str2, null, showAppRater, MyAdvertDetailsPresenterImpl.access$formatPriceIncrement(jVar2.a, this.c, jVar2.d.getShouldUpdateIncome()));
        return Unit.INSTANCE;
    }
}
