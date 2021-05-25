package a2.a.a.n0;

import com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ DevelopmentsCatalogPresenterImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public a(DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl, String str, String str2) {
        this.a = developmentsCatalogPresenterImpl;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        DevelopmentsCatalogPresenterImpl.access$onShareClicked(this.a, this.b, this.c);
    }
}
