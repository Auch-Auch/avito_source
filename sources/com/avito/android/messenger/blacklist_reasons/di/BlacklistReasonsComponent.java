package com.avito.android.messenger.blacklist_reasons.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponent;", "", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {BlacklistReasonsComponentDependencies.class}, modules = {BlacklistReasonsModule.class})
@PerFragment
public interface BlacklistReasonsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponent$Builder;", "", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponent$Builder;", "Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponentDependencies;", "deps", "dependencies", "(Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponentDependencies;)Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponent$Builder;", "Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponent;", "build", "()Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        BlacklistReasonsComponent build();

        @NotNull
        Builder dependencies(@NotNull BlacklistReasonsComponentDependencies blacklistReasonsComponentDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull BlacklistReasonsFragment blacklistReasonsFragment);
}
