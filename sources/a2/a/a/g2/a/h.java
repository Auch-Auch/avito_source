package a2.a.a.g2.a;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<RatingDetailsItem, Boolean> {
    public static final h a = new h();

    public h() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(RatingDetailsItem ratingDetailsItem) {
        RatingDetailsItem ratingDetailsItem2 = ratingDetailsItem;
        Intrinsics.checkNotNullParameter(ratingDetailsItem2, "it");
        return Boolean.valueOf(ratingDetailsItem2.getId() == Long.MAX_VALUE);
    }
}
