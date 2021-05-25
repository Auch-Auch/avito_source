package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.BrandspacePresenterImpl;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.Triple;
public final class s<T, R> implements Function<ExtraLoadingListItems, SingleSource<? extends Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable>>> {
    public final /* synthetic */ BrandspacePresenterImpl a;

    public s(BrandspacePresenterImpl brandspacePresenterImpl) {
        this.a = brandspacePresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable>> apply(ExtraLoadingListItems extraLoadingListItems) {
        ExtraLoadingListItems extraLoadingListItems2 = extraLoadingListItems;
        return this.a.l.loadAdverts(extraLoadingListItems2.getAdvertSource()).map(new q(extraLoadingListItems2)).onErrorResumeNext(new r(extraLoadingListItems2));
    }
}
