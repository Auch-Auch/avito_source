package com.avito.android.authorization.login_protection.di;

import android.content.res.Resources;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListFragment;
import com.avito.android.di.PerFragment;
import com.avito.android.error_helper.di.ErrorHelperModule;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListComponent;", "", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListFragment;", "fragment", "", "inject", "(Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListFragment;)V", "Factory", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {LoginProtectionPhoneListDependencies.class}, modules = {LoginProtectionPhoneListModule.class, ErrorHelperModule.class})
@PerFragment
public interface LoginProtectionPhoneListComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JQ\u0010\u000e\u001a\u00020\r2\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListComponent$Factory;", "", "", "", "phones", "challengeId", "login", "Landroid/content/res/Resources;", "resources", "", "isAntihackMode", "Lcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListDependencies;", "dependencies", "Lcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListComponent;", "create", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Landroid/content/res/Resources;ZLcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListDependencies;)Lcom/avito/android/authorization/login_protection/di/LoginProtectionPhoneListComponent;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        LoginProtectionPhoneListComponent create(@BindsInstance @NotNull List<String> list, @ChallengeId @BindsInstance @NotNull String str, @BindsInstance @LoginForTfa @Nullable String str2, @BindsInstance @NotNull Resources resources, @IsPhoneListForAntihackMode @BindsInstance boolean z, @NotNull LoginProtectionPhoneListDependencies loginProtectionPhoneListDependencies);
    }

    void inject(@NotNull LoginProtectionPhoneListFragment loginProtectionPhoneListFragment);
}
