package a2.a.a.m;

import com.avito.android.auto_catalog.AutoCatalogPresenterImpl;
import com.avito.android.auto_catalog.AutoCatalogRouter;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class d<T> implements Consumer<Unit> {
    public final /* synthetic */ AutoCatalogPresenterImpl a;

    public d(AutoCatalogPresenterImpl autoCatalogPresenterImpl) {
        this.a = autoCatalogPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        AutoCatalogRouter autoCatalogRouter = this.a.c;
        if (autoCatalogRouter != null) {
            autoCatalogRouter.closeScreen();
        }
    }
}
