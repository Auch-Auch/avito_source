package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenter;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class z extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;
    public final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(PublishDetailsPresenterImpl publishDetailsPresenterImpl, String str) {
        super(0);
        this.a = publishDetailsPresenterImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        PublishDetailsPresenter.Router router = this.a.g;
        if (router != null) {
            router.showHelpCenterScreen(this.b);
        }
        return Unit.INSTANCE;
    }
}
