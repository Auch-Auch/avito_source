package com.avito.android.messenger.support.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.support.SupportChatFormFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/support/di/SupportChatFormComponent;", "", "Lcom/avito/android/messenger/support/SupportChatFormFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/support/SupportChatFormFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SupportChatFormDependencies.class}, modules = {SupportChatFormModule.class})
@PerFragment
public interface SupportChatFormComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/support/di/SupportChatFormComponent$Builder;", "", "", "problemId", "(I)Lcom/avito/android/messenger/support/di/SupportChatFormComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/support/di/SupportChatFormComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/messenger/support/di/SupportChatFormComponent$Builder;", "Lcom/avito/android/messenger/support/di/SupportChatFormDependencies;", "dependencies", "(Lcom/avito/android/messenger/support/di/SupportChatFormDependencies;)Lcom/avito/android/messenger/support/di/SupportChatFormComponent$Builder;", "Lcom/avito/android/messenger/support/di/SupportChatFormComponent;", "build", "()Lcom/avito/android/messenger/support/di/SupportChatFormComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SupportChatFormComponent build();

        @NotNull
        Builder dependencies(@NotNull SupportChatFormDependencies supportChatFormDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder problemId(int i);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull SupportChatFormFragment supportChatFormFragment);
}
