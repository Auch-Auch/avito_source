package a2.a.a.g2.b.k;

import com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl;
import com.avito.android.rating.publish.deal_stage.DealStageView;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ DealStagePresenterImpl a;

    public b(DealStagePresenterImpl dealStagePresenterImpl) {
        this.a = dealStagePresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        DealStageView dealStageView = this.a.a;
        if (dealStageView != null) {
            dealStageView.hideProgress();
        }
    }
}
