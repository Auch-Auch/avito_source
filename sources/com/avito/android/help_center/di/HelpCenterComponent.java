package com.avito.android.help_center.di;

import com.avito.android.di.PerFragment;
import com.avito.android.help_center.HelpCenterFragment;
import com.avito.android.help_center.HelpCenterPresenterState;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/help_center/di/HelpCenterComponent;", "", "Lcom/avito/android/help_center/HelpCenterFragment;", "helpCenterFragment", "", "inject", "(Lcom/avito/android/help_center/HelpCenterFragment;)V", "Builder", "help-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {HelpCenterComponentDependencies.class}, modules = {HelpCenterModule.class})
@PerFragment
public interface HelpCenterComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00002\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/help_center/di/HelpCenterComponent$Builder;", "", "Lcom/avito/android/help_center/di/HelpCenterComponentDependencies;", "dependencies", "(Lcom/avito/android/help_center/di/HelpCenterComponentDependencies;)Lcom/avito/android/help_center/di/HelpCenterComponent$Builder;", "", "url", "(Ljava/lang/String;)Lcom/avito/android/help_center/di/HelpCenterComponent$Builder;", "Lcom/avito/android/help_center/HelpCenterPresenterState;", "state", "(Lcom/avito/android/help_center/HelpCenterPresenterState;)Lcom/avito/android/help_center/di/HelpCenterComponent$Builder;", "Lcom/avito/android/help_center/di/HelpCenterComponent;", "build", "()Lcom/avito/android/help_center/di/HelpCenterComponent;", "help-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        HelpCenterComponent build();

        @NotNull
        Builder dependencies(@NotNull HelpCenterComponentDependencies helpCenterComponentDependencies);

        @BindsInstance
        @NotNull
        Builder state(@Nullable HelpCenterPresenterState helpCenterPresenterState);

        @BindsInstance
        @NotNull
        Builder url(@Url @Nullable String str);
    }

    void inject(@NotNull HelpCenterFragment helpCenterFragment);
}
