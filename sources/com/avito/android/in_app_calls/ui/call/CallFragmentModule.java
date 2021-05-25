package com.avito.android.in_app_calls.ui.call;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.app.arch_components.ViewModelFactory;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.ui.AudioDeviceChooser;
import com.avito.android.in_app_calls.ui.AudioDeviceChooserImpl;
import com.avito.android.in_app_calls.ui.InAppCallsRouter;
import com.avito.android.in_app_calls.ui.InAppCallsRouterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallFragmentModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/app/arch_components/ViewModelFactory;", "factory", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter;", "provideCallPresenter", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/app/arch_components/ViewModelFactory;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter;", "Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "provideInAppCallRouter", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "<init>", "()V", "Declarations", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CallFragmentModule {
    @NotNull
    public static final CallFragmentModule INSTANCE = new CallFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallFragmentModule$Declarations;", "", "Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "bindDeclineReasonPresenterViewModel", "(Lcom/avito/android/in_app_calls/ui/call/CallPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/in_app_calls/ui/AudioDeviceChooserImpl;", "Lcom/avito/android/in_app_calls/ui/AudioDeviceChooser;", "bindAudioDeviceChooser", "(Lcom/avito/android/in_app_calls/ui/AudioDeviceChooserImpl;)Lcom/avito/android/in_app_calls/ui/AudioDeviceChooser;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        AudioDeviceChooser bindAudioDeviceChooser(@NotNull AudioDeviceChooserImpl audioDeviceChooserImpl);

        @Binds
        @NotNull
        @ClassKey(CallPresenterImpl.class)
        @IntoMap
        ViewModel bindDeclineReasonPresenterViewModel(@NotNull CallPresenterImpl callPresenterImpl);
    }

    @Provides
    @NotNull
    public final CallPresenter provideCallPresenter(@NotNull Fragment fragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(fragment, viewModelFactory).get(CallPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        return (CallPresenter) viewModel;
    }

    @Provides
    @NotNull
    public final InAppCallsRouter provideInAppCallRouter(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        return new InAppCallsRouterImpl(parentFragmentManager, R.id.in_app_call_root);
    }
}
