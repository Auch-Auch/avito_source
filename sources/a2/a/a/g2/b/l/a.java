package a2.a.a.g2.b.l;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.publish.select_advert.SelectAdvertPresenterImpl;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Throwable, List<? extends RatingDetailsItem>> {
    public final /* synthetic */ SelectAdvertPresenterImpl a;

    public a(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
        this.a = selectAdvertPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends RatingDetailsItem> apply(Throwable th) {
        Throwable th2 = th;
        SelectAdvertPresenterImpl selectAdvertPresenterImpl = this.a;
        List list = selectAdvertPresenterImpl.e;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List access$withoutLoadingItem = SelectAdvertPresenterImpl.access$withoutLoadingItem(selectAdvertPresenterImpl, list);
        SelectAdvertPresenterImpl selectAdvertPresenterImpl2 = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        return SelectAdvertPresenterImpl.access$withErrorSnippet(selectAdvertPresenterImpl, access$withoutLoadingItem, SelectAdvertPresenterImpl.access$getMessage(selectAdvertPresenterImpl2, th2));
    }
}
