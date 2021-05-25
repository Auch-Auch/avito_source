package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.BrandspaceItemBuilderImpl;
import java.util.concurrent.Callable;
public final class a<V> implements Callable<Boolean> {
    public final /* synthetic */ BrandspaceItem a;
    public final /* synthetic */ BrandspaceItemBuilderImpl.a b;

    public a(BrandspaceItem brandspaceItem, BrandspaceItemBuilderImpl.a aVar) {
        this.a = brandspaceItem;
        this.b = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        return Boolean.valueOf(this.b.a.getLastBlockItemIds().add(Long.valueOf(this.a.getId())));
    }
}
