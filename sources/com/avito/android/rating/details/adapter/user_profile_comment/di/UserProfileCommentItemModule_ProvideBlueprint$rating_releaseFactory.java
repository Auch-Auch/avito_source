package com.avito.android.rating.details.adapter.user_profile_comment.di;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemPresenter;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class UserProfileCommentItemModule_ProvideBlueprint$rating_releaseFactory implements Factory<ItemBlueprint<?, ?>> {
    public final Provider<UserProfileCommentItemPresenter> a;
    public final Provider<Consumer<TnsGalleryItemClickAction>> b;
    public final Provider<Activity> c;
    public final Provider<Features> d;

    public UserProfileCommentItemModule_ProvideBlueprint$rating_releaseFactory(Provider<UserProfileCommentItemPresenter> provider, Provider<Consumer<TnsGalleryItemClickAction>> provider2, Provider<Activity> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static UserProfileCommentItemModule_ProvideBlueprint$rating_releaseFactory create(Provider<UserProfileCommentItemPresenter> provider, Provider<Consumer<TnsGalleryItemClickAction>> provider2, Provider<Activity> provider3, Provider<Features> provider4) {
        return new UserProfileCommentItemModule_ProvideBlueprint$rating_releaseFactory(provider, provider2, provider3, provider4);
    }

    public static ItemBlueprint<?, ?> provideBlueprint$rating_release(UserProfileCommentItemPresenter userProfileCommentItemPresenter, Consumer<TnsGalleryItemClickAction> consumer, Activity activity, Features features) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(UserProfileCommentItemModule.provideBlueprint$rating_release(userProfileCommentItemPresenter, consumer, activity, features));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideBlueprint$rating_release(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
