package a2.a.a.g2.f;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.loading.LoadingItem;
import com.avito.android.rating.user_reviews.UserReviewsPresenterImpl;
import com.avito.android.remote.model.user_reviews.ReviewElement;
import com.avito.android.remote.model.user_reviews.UserReviewsResult;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
import timber.log.Timber;
public final class c<T, R> implements Function<UserReviewsResult, List<? extends RatingDetailsItem>> {
    public final /* synthetic */ UserReviewsPresenterImpl a;
    public final /* synthetic */ List b;

    public c(UserReviewsPresenterImpl userReviewsPresenterImpl, List list) {
        this.a = userReviewsPresenterImpl;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0055 */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends RatingDetailsItem> apply(UserReviewsResult userReviewsResult) {
        List<? extends RatingDetailsItem> list;
        Timber.d("merge", new Object[0]);
        List<ReviewElement> elements = userReviewsResult.getElements();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(elements, 10));
        int i = 0;
        for (T t : elements) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(this.a.m.convert(t, String.valueOf(this.b.size() + i)));
            i = i2;
        }
        boolean z = !arrayList.isEmpty();
        List list2 = arrayList;
        if (!z) {
            list2 = null;
        }
        if (list2 == null) {
            list2 = UserReviewsPresenterImpl.access$emptyReviewsList(this.a);
        }
        if (!(!list2.isEmpty()) || this.a.f == null || UserReviewsPresenterImpl.access$hasErrorSnippet(this.a, list2)) {
            Timber.d("merge WITHOUT Loading", new Object[0]);
            list = CollectionsKt___CollectionsKt.plus((Collection) this.a.b(this.b), (Iterable) list2);
        } else {
            Timber.d("merge WITH Loading", new Object[0]);
            List plus = CollectionsKt___CollectionsKt.plus((Collection) this.a.b(this.b), (Iterable) list2);
            Uri uri = this.a.f;
            Intrinsics.checkNotNull(uri);
            list = CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingItem>) plus, new LoadingItem(uri));
        }
        StringBuilder L = a.L("merged + loading items count ");
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : list) {
            if (t2 instanceof LoadingItem) {
                arrayList2.add(t2);
            }
        }
        L.append(arrayList2.size());
        Timber.d(L.toString(), new Object[0]);
        return list;
    }
}
