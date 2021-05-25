package com.avito.android.screen_opener.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.screen_opener.ProfileScreenResolverFragment;
import com.avito.android.screen_opener.di.ProfileScreenResolverFragmentModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentComponent;", "", "Lcom/avito/android/screen_opener/ProfileScreenResolverFragment;", "fragment", "", "inject", "(Lcom/avito/android/screen_opener/ProfileScreenResolverFragment;)V", "Builder", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ProfileScreenResolverFragmentDependencies.class}, modules = {ProfileScreenResolverFragmentModule.class})
@PerFragment
public interface ProfileScreenResolverFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J7\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentComponent$Builder;", "", "", "userKey", "contextId", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentDependencies;", "dependencies", "Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentComponent;", "create", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/res/Resources;Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentDependencies;)Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentComponent;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Builder {
        @NotNull
        ProfileScreenResolverFragmentComponent create(@ProfileScreenResolverFragmentModule.UserKey @BindsInstance @NotNull String str, @BindsInstance @ProfileScreenResolverFragmentModule.ContextId @Nullable String str2, @BindsInstance @NotNull Resources resources, @NotNull ProfileScreenResolverFragmentDependencies profileScreenResolverFragmentDependencies);
    }

    void inject(@NotNull ProfileScreenResolverFragment profileScreenResolverFragment);
}
