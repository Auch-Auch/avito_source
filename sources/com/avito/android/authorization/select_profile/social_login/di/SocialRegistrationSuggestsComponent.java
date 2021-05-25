package com.avito.android.authorization.select_profile.social_login.di;

import android.content.res.Resources;
import com.avito.android.authorization.select_profile.adapter.create_profile.di.CreateProfileItemModule;
import com.avito.android.authorization.select_profile.adapter.profile.di.ProfileItemModule;
import com.avito.android.authorization.select_profile.adapter.text.di.TextItemModule;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsFragment;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.model.registration.RegisteredProfile;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/di/SocialRegistrationSuggestsComponent;", "", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsFragment;", "activity", "", "inject", "(Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsFragment;)V", "Factory", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SocialRegistrationSuggestsDependencies.class}, modules = {SocialRegistrationSuggestsModule.class, CreateProfileItemModule.class, ProfileItemModule.class, TextItemModule.class})
@PerActivity
public interface SocialRegistrationSuggestsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JO\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/di/SocialRegistrationSuggestsComponent$Factory;", "", "", "title", "suggestKey", "socialType", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/authorization/select_profile/social_login/di/SocialRegistrationSuggestsDependencies;", "dependencies", "Lcom/avito/android/authorization/select_profile/social_login/di/SocialRegistrationSuggestsComponent;", "create", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroid/content/res/Resources;Lcom/avito/android/authorization/select_profile/social_login/di/SocialRegistrationSuggestsDependencies;)Lcom/avito/android/authorization/select_profile/social_login/di/SocialRegistrationSuggestsComponent;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        SocialRegistrationSuggestsComponent create(@BindsInstance @ScreenTitle @NotNull String str, @BindsInstance @SuggestKey @NotNull String str2, @BindsInstance @SocialType @NotNull String str3, @BindsInstance @NotNull List<RegisteredProfile> list, @BindsInstance @NotNull Resources resources, @NotNull SocialRegistrationSuggestsDependencies socialRegistrationSuggestsDependencies);
    }

    void inject(@NotNull SocialRegistrationSuggestsFragment socialRegistrationSuggestsFragment);
}
