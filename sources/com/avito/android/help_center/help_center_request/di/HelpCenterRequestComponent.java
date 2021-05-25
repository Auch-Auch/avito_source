package com.avito.android.help_center.help_center_request.di;

import com.avito.android.di.PerFragment;
import com.avito.android.help_center.help_center_request.HelpCenterRequestFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestComponent;", "", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestFragment;", "fragment", "", "inject", "(Lcom/avito/android/help_center/help_center_request/HelpCenterRequestFragment;)V", "Builder", "help-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {HelpCenterRequestDependencies.class}, modules = {HelpCenterRequestModule.class})
@PerFragment
public interface HelpCenterRequestComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00002\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00002\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\b\u0010\u0007J\u001b\u0010\t\u001a\u00020\u00002\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestComponent$Builder;", "", "Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestDependencies;", "dependencies", "(Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestDependencies;)Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestComponent$Builder;", "", "theme", "(Ljava/lang/String;)Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestComponent$Builder;", "advertisementId", "contextId", "Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestComponent;", "build", "()Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestComponent;", "help-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder advertisementId(@AdvertisementId @Nullable String str);

        @NotNull
        HelpCenterRequestComponent build();

        @BindsInstance
        @NotNull
        Builder contextId(@ContextId @Nullable String str);

        @NotNull
        Builder dependencies(@NotNull HelpCenterRequestDependencies helpCenterRequestDependencies);

        @BindsInstance
        @NotNull
        Builder theme(@Theme @Nullable String str);
    }

    void inject(@NotNull HelpCenterRequestFragment helpCenterRequestFragment);
}
