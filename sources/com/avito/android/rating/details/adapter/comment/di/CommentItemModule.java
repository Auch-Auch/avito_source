package com.avito.android.rating.details.adapter.comment.di;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.di.PerActivity;
import com.avito.android.rating.details.adapter.comment.CommentItemBlueprint;
import com.avito.android.rating.details.adapter.comment.CommentItemPresenter;
import com.avito.android.rating.details.adapter.comment.CommentItemPresenterImpl;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/rating/details/adapter/comment/di/CommentItemModule;", "", "Lcom/avito/android/rating/details/adapter/comment/CommentItemPresenter;", "presenter", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint$rating_release", "(Lcom/avito/android/rating/details/adapter/comment/CommentItemPresenter;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBlueprint", "providePresenter$rating_release", "()Lcom/avito/android/rating/details/adapter/comment/CommentItemPresenter;", "providePresenter", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CommentItemModule {
    @NotNull
    public static final CommentItemModule INSTANCE = new CommentItemModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @PerActivity
    public static final ItemBlueprint<?, ?> provideBlueprint$rating_release(@NotNull CommentItemPresenter commentItemPresenter, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(commentItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(consumer, "imageClicks");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features, "features");
        return new CommentItemBlueprint(commentItemPresenter, consumer, activity, features);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CommentItemPresenter providePresenter$rating_release() {
        return new CommentItemPresenterImpl();
    }
}
