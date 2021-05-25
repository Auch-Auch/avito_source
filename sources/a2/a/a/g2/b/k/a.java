package a2.a.a.g2.b.k;

import com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl;
import com.avito.android.rating.publish.deal_stage.DealStageView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ DealStagePresenterImpl a;

    public a(DealStagePresenterImpl dealStagePresenterImpl) {
        this.a = dealStagePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        DealStageView dealStageView = this.a.a;
        if (dealStageView != null) {
            dealStageView.showProgress();
        }
    }
}
