package com.avito.android.profile.sessions.list.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule;
import com.avito.android.profile.sessions.list.SessionsListFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/sessions/list/di/SessionsListComponent;", "", "Lcom/avito/android/profile/sessions/list/SessionsListFragment;", "fragment", "", "inject", "(Lcom/avito/android/profile/sessions/list/SessionsListFragment;)V", "Factory", "profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SessionsListDependencies.class}, modules = {SessionsListModule.class, CompositeSnackbarModule.class})
@PerFragment
public interface SessionsListComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J9\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/profile/sessions/list/di/SessionsListComponent$Factory;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Kundle;", "state", "", "source", "Lcom/avito/android/profile/sessions/list/di/SessionsListDependencies;", "dependencies", "Lcom/avito/android/profile/sessions/list/di/SessionsListComponent;", "create", "(Landroid/content/res/Resources;Lcom/avito/android/util/Kundle;Ljava/lang/String;Lcom/avito/android/profile/sessions/list/di/SessionsListDependencies;)Lcom/avito/android/profile/sessions/list/di/SessionsListComponent;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        SessionsListComponent create(@BindsInstance @NotNull Resources resources, @BindsInstance @Nullable Kundle kundle, @BindsInstance @SessionsListSource @Nullable String str, @NotNull SessionsListDependencies sessionsListDependencies);
    }

    void inject(@NotNull SessionsListFragment sessionsListFragment);
}
