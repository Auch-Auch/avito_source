package com.avito.android.remote.model.user_reviews;

import android.net.Uri;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/user_reviews/UserReviewsResult;", "", "Landroid/net/Uri;", "nextPage", "Landroid/net/Uri;", "getNextPage", "()Landroid/net/Uri;", "", "Lcom/avito/android/remote/model/user_reviews/ReviewElement;", MessengerShareContentUtility.ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Landroid/net/Uri;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewsResult {
    @SerializedName("entries")
    @NotNull
    private final List<ReviewElement> elements;
    @SerializedName("nextPage")
    @Nullable
    private final Uri nextPage;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.user_reviews.ReviewElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public UserReviewsResult(@NotNull List<? extends ReviewElement> list, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.elements = list;
        this.nextPage = uri;
    }

    @NotNull
    public final List<ReviewElement> getElements() {
        return this.elements;
    }

    @Nullable
    public final Uri getNextPage() {
        return this.nextPage;
    }
}
