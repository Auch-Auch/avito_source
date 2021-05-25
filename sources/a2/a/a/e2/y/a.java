package a2.a.a.e2.y;

import com.avito.android.publish.premoderation.AdvertDuplicatePresenter;
import com.avito.android.publish.premoderation.AdvertDuplicatePresenterImpl;
import com.avito.android.remote.model.AdvertDuplicateResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ AdvertDuplicatePresenterImpl a;
    public final /* synthetic */ AdvertDuplicateResult b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AdvertDuplicatePresenterImpl advertDuplicatePresenterImpl, AdvertDuplicateResult advertDuplicateResult) {
        super(1);
        this.a = advertDuplicatePresenterImpl;
        this.b = advertDuplicateResult;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        AdvertDuplicatePresenter.Router router = this.a.b;
        if (router != null) {
            router.followDeepLink(this.b.getAction().getDeepLink());
        }
        return Unit.INSTANCE;
    }
}
