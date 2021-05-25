package com.avito.android.remote.model.user_reviews;

import com.avito.android.remote.parse.adapter.RuntimeTypeAdapter;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/user_reviews/UserReviewsTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/user_reviews/ReviewElement;", "", "", "Ljava/lang/reflect/Type;", "mapping", "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewsTypeAdapter extends RuntimeTypeAdapter<ReviewElement> {
    @NotNull
    private final Map<String, Type> mapping = q.mapOf(TuplesKt.to("rating", RatingElement.class));

    public UserReviewsTypeAdapter() {
        super(null, null, null, 7, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Type> getMapping() {
        return this.mapping;
    }
}
