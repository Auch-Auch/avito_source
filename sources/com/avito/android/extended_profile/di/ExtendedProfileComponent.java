package com.avito.android.extended_profile.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.di.PerFragment;
import com.avito.android.extended_profile.ExtendedProfileFragment;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/extended_profile/di/ExtendedProfileComponent;", "", "Lcom/avito/android/extended_profile/ExtendedProfileFragment;", "fragment", "", "inject", "(Lcom/avito/android/extended_profile/ExtendedProfileFragment;)V", "Factory", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ExtendedProfileDependencies.class}, modules = {ExtendedProfileModule.class, ExtendedProfileTrackerModule.class})
@PerFragment
public interface ExtendedProfileComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001Ja\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/extended_profile/di/ExtendedProfileComponent$Factory;", "", "", "userKey", "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "profile", "contextId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Landroid/app/Activity;", "activity", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/extended_profile/di/ExtendedProfileDependencies;", "dependencies", "Lcom/avito/android/extended_profile/di/ExtendedProfileComponent;", "create", "(Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Landroid/app/Activity;Landroidx/fragment/app/Fragment;Landroid/content/res/Resources;Lcom/avito/android/extended_profile/di/ExtendedProfileDependencies;)Lcom/avito/android/extended_profile/di/ExtendedProfileComponent;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        ExtendedProfileComponent create(@BindsInstance @UserKey @NotNull String str, @BindsInstance @NotNull ExtendedPublicUserProfile extendedPublicUserProfile, @BindsInstance @ContextId @Nullable String str2, @BindsInstance @Nullable TreeClickStreamParent treeClickStreamParent, @BindsInstance @NotNull Activity activity, @BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull Resources resources, @NotNull ExtendedProfileDependencies extendedProfileDependencies);
    }

    void inject(@NotNull ExtendedProfileFragment extendedProfileFragment);
}
