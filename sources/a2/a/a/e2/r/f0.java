package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.view.ItemDetailsView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class f0<T> implements Consumer<Disposable> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    public f0(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        this.a = publishDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        ItemDetailsView itemDetailsView = this.a.c;
        if (itemDetailsView != null) {
            itemDetailsView.showProgress();
        }
    }
}
