package com.avito.android.public_profile.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.FragmentManager;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule;
import com.avito.android.public_profile.PublicProfileFragment;
import com.avito.android.public_profile.di.PublicProfileFragmentModule;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent;", "", "Lcom/avito/android/public_profile/PublicProfileFragment;", "fragment", "", "inject", "(Lcom/avito/android/public_profile/PublicProfileFragment;)V", "Builder", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublicProfileFragmentDependencies.class}, modules = {PublicProfileFragmentModule.class, ProfileAdvertsTabModule.class, PublicProfileTrackerModule.class, DialogModule.class, CompositeSnackbarModule.class})
@PerFragment
public interface PublicProfileFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00002\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00002\b\b\u0001\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\u00002\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u001fH'¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u00020\u00002\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u001fH'¢\u0006\u0004\b$\u0010\"J\u0019\u0010'\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%H'¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H&¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "", "Lcom/avito/android/public_profile/di/PublicProfileFragmentDependencies;", "publicProfileFragmentDependencies", "(Lcom/avito/android/public_profile/di/PublicProfileFragmentDependencies;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "bindResources", "(Landroid/content/res/Resources;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "bindFragmentManager", "(Landroidx/fragment/app/FragmentManager;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "", "userKey", "bindUserKey", "(Ljava/lang/String;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "contextId", "bindContextId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "bindTreeParent", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "withScreen", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "", "isSubComponent", "withSubComponent", "(Z)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenterState", "bindPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "subscriptionsState", "bindSubscriptionsState", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "profile", "bindPublicUserProfile", "(Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "Landroid/app/Activity;", "activity", "bindActivity", "(Landroid/app/Activity;)Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent$Builder;", "Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent;", "build", "()Lcom/avito/android/public_profile/di/PublicProfileFragmentComponent;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder bindContextId(@PublicProfileFragmentModule.ContextId @Nullable String str);

        @BindsInstance
        @NotNull
        Builder bindFragmentManager(@NotNull FragmentManager fragmentManager);

        @BindsInstance
        @NotNull
        Builder bindPresenterState(@PublicProfileFragmentModule.PresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder bindPublicUserProfile(@Nullable DefaultPublicUserProfile defaultPublicUserProfile);

        @BindsInstance
        @NotNull
        Builder bindResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder bindSubscriptionsState(@PublicProfileFragmentModule.SubscriptionsState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder bindTreeParent(@Nullable TreeClickStreamParent treeClickStreamParent);

        @BindsInstance
        @NotNull
        Builder bindUserKey(@PublicProfileFragmentModule.UserKey @NotNull String str);

        @NotNull
        PublicProfileFragmentComponent build();

        @NotNull
        Builder publicProfileFragmentDependencies(@NotNull PublicProfileFragmentDependencies publicProfileFragmentDependencies);

        @BindsInstance
        @NotNull
        Builder withScreen(@ScreenAnalytics @NotNull Screen screen);

        @BindsInstance
        @NotNull
        Builder withSubComponent(@ScreenAnalytics boolean z);
    }

    void inject(@NotNull PublicProfileFragment publicProfileFragment);
}
