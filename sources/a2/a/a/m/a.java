package a2.a.a.m;

import com.avito.android.auto_catalog.AutoCatalogPresenterImpl;
import com.avito.android.auto_catalog.AutoCatalogView;
import com.avito.android.auto_catalog.remote.model.AutoCatalogResponse;
import com.avito.android.serp.adapter.PersistableSerpItem;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Pair;
public final class a<T> implements Consumer<Pair<? extends Long, ? extends List<? extends PersistableSerpItem>>> {
    public final /* synthetic */ AutoCatalogPresenterImpl a;

    public a(AutoCatalogPresenterImpl autoCatalogPresenterImpl) {
        this.a = autoCatalogPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Pair<? extends Long, ? extends List<? extends PersistableSerpItem>> pair) {
        this.a.g = pair;
        AutoCatalogResponse autoCatalogResponse = this.a.f;
        if (autoCatalogResponse != null) {
            AutoCatalogPresenterImpl autoCatalogPresenterImpl = this.a;
            autoCatalogPresenterImpl.e = AutoCatalogPresenterImpl.access$prepareContentScreen(autoCatalogPresenterImpl, autoCatalogResponse);
            AutoCatalogView autoCatalogView = this.a.b;
            if (autoCatalogView != null) {
                autoCatalogView.bindItems(this.a.e);
            }
        }
    }
}
