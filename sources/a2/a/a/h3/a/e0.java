package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e0 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl.n a;
    public final /* synthetic */ Throwable b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e0(MyAdvertDetailsPresenterImpl.n nVar, Throwable th) {
        super(0);
        this.a = nVar;
        this.b = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        String format = this.a.a.I.format(this.b);
        MyAdvertDetailsView myAdvertDetailsView = this.a.a.b;
        if (myAdvertDetailsView != null) {
            myAdvertDetailsView.showError(format);
        }
        MyAdvertDetailsPresenterImpl.access$showLoadingProblem(this.a.a);
        return Unit.INSTANCE;
    }
}
