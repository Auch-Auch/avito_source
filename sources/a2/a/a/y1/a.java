package a2.a.a.y1;

import com.avito.android.photo_view.ImageListPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
public final class a<T> implements Consumer<Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ ImageListPresenterImpl a;

    public a(ImageListPresenterImpl imageListPresenterImpl) {
        this.a = imageListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Pair<? extends Integer, ? extends Integer> pair) {
        Pair<? extends Integer, ? extends Integer> pair2 = pair;
        this.a.n.move(((Number) pair2.component1()).intValue(), ((Number) pair2.component2()).intValue());
    }
}
