package a2.a.a.g2.a;

import android.net.Uri;
import com.avito.android.rating.details.RatingDetailsPresenterImpl;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.loading.LoadingItem;
import com.avito.android.remote.model.rating_details.RatingDetailsElement;
import com.avito.android.remote.model.rating_details.RatingDetailsResult;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class c<T, R> implements Function<RatingDetailsResult, List<? extends RatingDetailsItem>> {
    public final /* synthetic */ RatingDetailsPresenterImpl a;
    public final /* synthetic */ List b;

    public c(RatingDetailsPresenterImpl ratingDetailsPresenterImpl, List list) {
        this.a = ratingDetailsPresenterImpl;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends RatingDetailsItem> apply(RatingDetailsResult ratingDetailsResult) {
        List<RatingDetailsElement> elements = ratingDetailsResult.getElements();
        if (elements == null) {
            elements = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(elements, 10));
        int i = 0;
        for (T t : elements) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String valueOf = String.valueOf(this.b.size() + i);
            arrayList.add(this.a.q.convert(t, valueOf));
            i = i2;
        }
        if (!(!arrayList.isEmpty()) || this.a.f == null) {
            return CollectionsKt___CollectionsKt.plus((Collection) RatingDetailsPresenterImpl.access$withoutLoadingItem(this.a, this.b), (Iterable) arrayList);
        }
        List plus = CollectionsKt___CollectionsKt.plus((Collection) RatingDetailsPresenterImpl.access$withoutLoadingItem(this.a, this.b), (Iterable) arrayList);
        Uri uri = this.a.f;
        Intrinsics.checkNotNull(uri);
        return CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingItem>) plus, new LoadingItem(uri));
    }
}
