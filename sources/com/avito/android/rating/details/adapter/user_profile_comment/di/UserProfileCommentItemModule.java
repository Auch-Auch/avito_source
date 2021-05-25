package com.avito.android.rating.details.adapter.user_profile_comment.di;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.di.PerActivity;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemBlueprint;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemPresenter;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemPresenterImpl;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J=\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0014\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/rating/details/adapter/user_profile_comment/di/UserProfileCommentItemModule;", "", "Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItemPresenter;", "presenter", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$rating_release", "(Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItemPresenter;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "clicksRelay", "providePresenter$rating_release", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItemPresenter;", "providePresenter", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserProfileCommentItemModule {
    @NotNull
    public static final UserProfileCommentItemModule INSTANCE = new UserProfileCommentItemModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @PerActivity
    public static final ItemBlueprint<?, ?> provideBlueprint$rating_release(@NotNull UserProfileCommentItemPresenter userProfileCommentItemPresenter, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(userProfileCommentItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(consumer, "imageClicks");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features, "features");
        return new UserProfileCommentItemBlueprint(userProfileCommentItemPresenter, consumer, activity, features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final UserProfileCommentItemPresenter providePresenter$rating_release(@NotNull PublishRelay<RatingDetailsItem> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "clicksRelay");
        return new UserProfileCommentItemPresenterImpl(publishRelay);
    }
}
