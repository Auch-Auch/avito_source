package com.avito.android.in_app_calls.di;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.in_app_calls.ui.root.InAppCallActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {CallActivityComponentDependencies.class}, modules = {CallActivityModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallActivityComponent;", "", "Lcom/avito/android/in_app_calls/ui/root/InAppCallActivity;", "activity", "", "inject", "(Lcom/avito/android/in_app_calls/ui/root/InAppCallActivity;)V", "CallActivityComponentComponentFactory", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallActivityComponent$CallActivityComponentComponentFactory;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/in_app_calls/di/CallActivityComponentDependencies;", "dependencies", "Lcom/avito/android/in_app_calls/di/CallActivityComponent;", "create", "(Landroidx/fragment/app/FragmentActivity;Landroid/content/res/Resources;Lcom/avito/android/in_app_calls/di/CallActivityComponentDependencies;)Lcom/avito/android/in_app_calls/di/CallActivityComponent;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface CallActivityComponentComponentFactory {
        @NotNull
        CallActivityComponent create(@BindsInstance @NotNull FragmentActivity fragmentActivity, @BindsInstance @NotNull Resources resources, @NotNull CallActivityComponentDependencies callActivityComponentDependencies);
    }

    void inject(@NotNull InAppCallActivity inAppCallActivity);
}
