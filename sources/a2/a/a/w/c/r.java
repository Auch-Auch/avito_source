package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
public final class r<T, R> implements Function<Throwable, SingleSource<? extends Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable>>> {
    public final /* synthetic */ ExtraLoadingListItems a;

    public r(ExtraLoadingListItems extraLoadingListItems) {
        this.a = extraLoadingListItems;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable>> apply(Throwable th) {
        ExtraLoadingListItems extraLoadingListItems = this.a;
        Intrinsics.checkNotNullExpressionValue(extraLoadingListItems, "item");
        return Single.just(new Triple(extraLoadingListItems, null, th));
    }
}
