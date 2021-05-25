package a2.a.a.g2.b.l;

import com.avito.android.rating.publish.select_advert.SelectAdvertPresenterImpl;
import com.avito.android.remote.model.publish.SearchUserAdvertsResult;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<SearchUserAdvertsResult> {
    public final /* synthetic */ SelectAdvertPresenterImpl a;

    public d(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
        this.a = selectAdvertPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SearchUserAdvertsResult searchUserAdvertsResult) {
        this.a.f = searchUserAdvertsResult.getNextPage();
    }
}
