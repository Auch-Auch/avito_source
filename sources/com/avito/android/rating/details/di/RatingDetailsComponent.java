package com.avito.android.rating.details.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.rating.details.RatingDetailsActivity;
import com.avito.android.rating.details.adapter.action.di.ActionItemModule;
import com.avito.android.rating.details.adapter.button.di.ButtonItemModule;
import com.avito.android.rating.details.adapter.comment.di.CommentItemModule;
import com.avito.android.rating.details.adapter.error_snippet.di.ErrorSnippetItemModule;
import com.avito.android.rating.details.adapter.info.di.InfoItemModule;
import com.avito.android.rating.details.adapter.loading.di.LoadingItemModule;
import com.avito.android.rating.details.adapter.rating.di.RatingItemModule;
import com.avito.android.rating.details.adapter.text.di.TextItemModule;
import com.avito.android.rating.details.adapter.user_profile_comment.di.UserProfileCommentItemModule;
import com.avito.android.rating.details.di.RatingDetailsModule;
import com.avito.android.rating.di.RatingsTnsGalleryClicksModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/details/di/RatingDetailsComponent;", "", "Lcom/avito/android/rating/details/RatingDetailsActivity;", "activity", "", "inject", "(Lcom/avito/android/rating/details/RatingDetailsActivity;)V", "Builder", "rating_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {RatingDetailsDependencies.class}, modules = {RatingDetailsModule.class, DialogModule.class, ActionItemModule.class, CommentItemModule.class, UserProfileCommentItemModule.class, ErrorSnippetItemModule.class, RatingItemModule.class, ButtonItemModule.class, TextItemModule.class, InfoItemModule.class, LoadingItemModule.class, RatingsTnsGalleryClicksModule.class})
@PerActivity
public interface RatingDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00002\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/rating/details/di/RatingDetailsComponent$Builder;", "", "Lcom/avito/android/rating/details/di/RatingDetailsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/rating/details/di/RatingDetailsDependencies;)Lcom/avito/android/rating/details/di/RatingDetailsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "with", "(Landroid/content/res/Resources;)Lcom/avito/android/rating/details/di/RatingDetailsComponent$Builder;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/rating/details/di/RatingDetailsComponent$Builder;", "", "userKey", "withUserKey", "(Ljava/lang/String;)Lcom/avito/android/rating/details/di/RatingDetailsComponent$Builder;", "shopId", "withShopId", "Lcom/avito/android/util/Kundle;", "presenterState", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/rating/details/di/RatingDetailsComponent$Builder;", "Lcom/avito/android/rating/details/di/RatingDetailsComponent;", "build", "()Lcom/avito/android/rating/details/di/RatingDetailsComponent;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        RatingDetailsComponent build();

        @NotNull
        Builder dependentOn(@NotNull RatingDetailsDependencies ratingDetailsDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withShopId(@RatingDetailsModule.ShopId @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withUserKey(@RatingDetailsModule.UserKey @Nullable String str);
    }

    void inject(@NotNull RatingDetailsActivity ratingDetailsActivity);
}
