package a2.a.a.m;

import com.avito.android.auto_catalog.AutoCatalogPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class c<T> implements Consumer<Unit> {
    public final /* synthetic */ AutoCatalogPresenterImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public c(AutoCatalogPresenterImpl autoCatalogPresenterImpl, String str, String str2) {
        this.a = autoCatalogPresenterImpl;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        AutoCatalogPresenterImpl.access$onShareClicked(this.a, this.b, this.c);
    }
}
