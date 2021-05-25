package com.avito.android.rating.publish.select_advert;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.FragmentsKt;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", "isSubComponent", "Landroidx/fragment/app/Fragment;", "createSelectAdvertFragment", "(Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/analytics/screens/Screen;Z)Landroidx/fragment/app/Fragment;", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class SelectAdvertFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ RatingPublishData a;
        public final /* synthetic */ RatingPublishViewData b;
        public final /* synthetic */ Screen c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, Screen screen, boolean z) {
            super(1);
            this.a = ratingPublishData;
            this.b = ratingPublishViewData;
            this.c = screen;
            this.d = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putParcelable("rating_data", this.a);
            bundle2.putParcelable("rating_view_data", this.b);
            bundle2.putParcelable(VKApiUserFull.SCREEN_NAME, this.c);
            bundle2.putBoolean("sub_component", this.d);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Fragment createSelectAdvertFragment(@NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, @NotNull Screen screen, boolean z) {
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        return FragmentsKt.arguments(new SelectAdvertFragment(), 4, new a(ratingPublishData, ratingPublishViewData, screen, z));
    }

    public static /* synthetic */ Fragment createSelectAdvertFragment$default(RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, Screen screen, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return createSelectAdvertFragment(ratingPublishData, ratingPublishViewData, screen, z);
    }
}
