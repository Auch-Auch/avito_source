package com.avito.android.rating.publish.review_input;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "payload", "Landroidx/fragment/app/Fragment;", "createReviewInputFragment", "(Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/remote/model/publish/NextStagePayload;)Landroidx/fragment/app/Fragment;", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class ReviewInputFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ RatingPublishData a;
        public final /* synthetic */ RatingPublishViewData b;
        public final /* synthetic */ NextStagePayload c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, NextStagePayload nextStagePayload) {
            super(1);
            this.a = ratingPublishData;
            this.b = ratingPublishViewData;
            this.c = nextStagePayload;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putParcelable("rating_data", this.a);
            bundle2.putParcelable("rating_view_data", this.b);
            bundle2.putParcelable("key_stage_comment_payload", this.c);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Fragment createReviewInputFragment(@NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, @Nullable NextStagePayload nextStagePayload) {
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        return FragmentsKt.arguments(new ReviewInputFragment(), 3, new a(ratingPublishData, ratingPublishViewData, nextStagePayload));
    }

    public static /* synthetic */ Fragment createReviewInputFragment$default(RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, NextStagePayload nextStagePayload, int i, Object obj) {
        if ((i & 4) != 0) {
            nextStagePayload = null;
        }
        return createReviewInputFragment(ratingPublishData, ratingPublishViewData, nextStagePayload);
    }
}
