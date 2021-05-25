package com.avito.android.user_adverts.di.host_fragment;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.di.PerFragment;
import com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies;
import com.avito.android.user_adverts.di.UserAdvertsTrackerModule;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import com.avito.android.util.UrlParams;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent;", "Lcom/avito/android/user_adverts/di/UserAdvertsListComponentDependencies;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment;", "fragment", "", "inject", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment;)V", "Builder", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UserAdvertsHostFragmentDependencies.class}, modules = {UserAdvertsHostFragmentModule.class, UserAdvertsTrackerModule.class})
@PerFragment
public interface UserAdvertsHostFragmentComponent extends UserAdvertsListComponentDependencies {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent$Builder;", "", "Landroid/os/Bundle;", "state", "(Landroid/os/Bundle;)Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent$Builder;", "", "defaultShortcut", "(Ljava/lang/String;)Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent$Builder;", "Landroidx/fragment/app/FragmentManager;", "manager", "fragmentManager", "(Landroidx/fragment/app/FragmentManager;)Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent$Builder;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "formatter", "withFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent$Builder;", "Landroidx/lifecycle/ViewModelStoreOwner;", UrlParams.OWNER, "withViewModelStoreOwner", "(Landroidx/lifecycle/ViewModelStoreOwner;)Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent$Builder;", "Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentDependencies;", "component", "userAdvertsHostFragmentDependencies", "(Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentDependencies;)Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent$Builder;", "Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent;", "build", "()Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentComponent;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        UserAdvertsHostFragmentComponent build();

        @BindsInstance
        @NotNull
        Builder defaultShortcut(@Nullable String str);

        @BindsInstance
        @NotNull
        Builder fragmentManager(@NotNull FragmentManager fragmentManager);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder state(@Nullable Bundle bundle);

        @NotNull
        Builder userAdvertsHostFragmentDependencies(@NotNull UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies);

        @BindsInstance
        @NotNull
        Builder withFormatter(@NotNull AttributedTextFormatter attributedTextFormatter);

        @BindsInstance
        @NotNull
        Builder withViewModelStoreOwner(@NotNull ViewModelStoreOwner viewModelStoreOwner);
    }

    void inject(@NotNull UserAdvertsHostFragment userAdvertsHostFragment);
}
