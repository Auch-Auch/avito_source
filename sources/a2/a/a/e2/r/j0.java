package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenter;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.android.util.Throwables;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class j0 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        super(1);
        this.a = publishDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        PublishDetailsPresenter.Router router;
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        ItemDetailsView itemDetailsView = this.a.c;
        if (itemDetailsView != null) {
            itemDetailsView.hideValidationProgress();
        }
        ItemDetailsView itemDetailsView2 = this.a.c;
        if (itemDetailsView2 != null) {
            itemDetailsView2.showContent();
        }
        if (Throwables.isNetworkProblem(th2)) {
            ItemDetailsView itemDetailsView3 = this.a.c;
            if (itemDetailsView3 != null) {
                itemDetailsView3.showError(this.a.q.getNetworkError());
            }
        } else if (Throwables.isAuthProblem(th2) && (router = this.a.g) != null) {
            router.navigateToAuth();
        }
        return Unit.INSTANCE;
    }
}
