package a2.a.a.g2.b.l;

import android.net.Uri;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.loading.LoadingItem;
import com.avito.android.rating.publish.select_advert.SelectAdvertPresenterImpl;
import com.avito.android.rating.publish.select_advert.adapter.advert.AdvertItem;
import com.avito.android.remote.model.publish.AdvertSummary;
import com.avito.android.remote.model.publish.SearchUserAdvertsResult;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class c<T, R> implements Function<SearchUserAdvertsResult, List<? extends RatingDetailsItem>> {
    public final /* synthetic */ SelectAdvertPresenterImpl a;
    public final /* synthetic */ List b;

    public c(SelectAdvertPresenterImpl selectAdvertPresenterImpl, List list) {
        this.a = selectAdvertPresenterImpl;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends RatingDetailsItem> apply(SearchUserAdvertsResult searchUserAdvertsResult) {
        List<AdvertSummary> items = searchUserAdvertsResult.getItems();
        if (items == null) {
            items = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(items, 10));
        int i = 0;
        for (T t : items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new AdvertItem(String.valueOf(this.b.size() + i), t));
            i = i2;
        }
        if (!(!arrayList.isEmpty()) || this.a.f == null) {
            return CollectionsKt___CollectionsKt.plus((Collection) SelectAdvertPresenterImpl.access$withoutLoadingItem(this.a, this.b), (Iterable) arrayList);
        }
        List plus = CollectionsKt___CollectionsKt.plus((Collection) SelectAdvertPresenterImpl.access$withoutLoadingItem(this.a, this.b), (Iterable) arrayList);
        Uri uri = this.a.f;
        Intrinsics.checkNotNull(uri);
        return CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingItem>) plus, new LoadingItem(uri));
    }
}
