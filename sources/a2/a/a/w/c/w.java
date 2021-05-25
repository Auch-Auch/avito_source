package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Triple;
public final class w<T> implements Consumer<Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable>> {
    public final /* synthetic */ BrandspacePresenterImpl a;

    public w(BrandspacePresenterImpl brandspacePresenterImpl) {
        this.a = brandspacePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable> triple) {
        this.a.g();
    }
}
