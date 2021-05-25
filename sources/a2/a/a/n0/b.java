package a2.a.a.n0;

import com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl;
import com.avito.android.developments_catalog.DevelopmentsCatalogRouter;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<Unit> {
    public final /* synthetic */ DevelopmentsCatalogPresenterImpl a;

    public b(DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl) {
        this.a = developmentsCatalogPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        DevelopmentsCatalogRouter developmentsCatalogRouter = this.a.b;
        if (developmentsCatalogRouter != null) {
            developmentsCatalogRouter.closeScreen();
        }
    }
}
