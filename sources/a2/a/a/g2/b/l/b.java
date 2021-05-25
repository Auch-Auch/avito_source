package a2.a.a.g2.b.l;

import com.avito.android.rating.publish.select_advert.SelectAdvertPresenterImpl;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ SelectAdvertPresenterImpl a;

    public b(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
        this.a = selectAdvertPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.i = false;
    }
}
