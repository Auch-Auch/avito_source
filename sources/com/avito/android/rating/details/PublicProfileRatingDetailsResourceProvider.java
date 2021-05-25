package com.avito.android.rating.details;

import android.content.res.Resources;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/rating/details/PublicProfileRatingDetailsResourceProvider;", "Lcom/avito/android/rating/details/RatingDetailsResourceProvider;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Landroid/content/res/Resources;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileRatingDetailsResourceProvider implements RatingDetailsResourceProvider {
    public final Resources a;

    public PublicProfileRatingDetailsResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.rating.details.RatingDetailsResourceProvider
    @NotNull
    public String getTitle() {
        String string = this.a.getString(R.string.public_profile_rating_details_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ile_rating_details_title)");
        return string;
    }
}
