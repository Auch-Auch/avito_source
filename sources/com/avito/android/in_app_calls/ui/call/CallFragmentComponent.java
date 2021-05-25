package com.avito.android.in_app_calls.ui.call;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponent;", "", "Lcom/avito/android/in_app_calls/ui/call/CallFragment;", "fragment", "", "inject", "(Lcom/avito/android/in_app_calls/ui/call/CallFragment;)V", "Builder", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CallFragmentComponentDependencies.class}, modules = {CallFragmentModule.class})
@PerFragment
public interface CallFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponent$Builder;", "", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponent$Builder;", "Landroidx/fragment/app/FragmentActivity;", "activity", "(Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponent$Builder;", "Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponentDependencies;", "deps", "dependencies", "(Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponentDependencies;)Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponent$Builder;", "Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponent;", "build", "()Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponent;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull FragmentActivity fragmentActivity);

        @NotNull
        CallFragmentComponent build();

        @NotNull
        Builder dependencies(@NotNull CallFragmentComponentDependencies callFragmentComponentDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull CallFragment callFragment);
}
