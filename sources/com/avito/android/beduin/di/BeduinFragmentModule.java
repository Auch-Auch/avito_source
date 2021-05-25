package com.avito.android.beduin.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.ComponentsContextImpl;
import com.avito.android.beduin.core.form.ComponentsForm;
import com.avito.android.beduin.core.form.ComponentsFormImpl;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModelFactory;
import com.avito.android.di.PerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/beduin/di/BeduinFragmentModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModelFactory;", "viewModelFactory", "Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel;", "provideViewModel$beduin_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModelFactory;)Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModel;", "provideViewModel", "<init>", "()V", "Deps", "beduin_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Deps.class})
public final class BeduinFragmentModule {
    @NotNull
    public static final BeduinFragmentModule INSTANCE = new BeduinFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/beduin/di/BeduinFragmentModule$Deps;", "", "Lcom/avito/android/beduin/core/ComponentsContextImpl;", "ctx", "Lcom/avito/android/beduin/core/ComponentsContext;", "bindComponentsContext", "(Lcom/avito/android/beduin/core/ComponentsContextImpl;)Lcom/avito/android/beduin/core/ComponentsContext;", "Lcom/avito/android/beduin/core/form/ComponentsFormImpl;", "form", "Lcom/avito/android/beduin/core/form/ComponentsForm;", "bindComponentsForm", "(Lcom/avito/android/beduin/core/form/ComponentsFormImpl;)Lcom/avito/android/beduin/core/form/ComponentsForm;", "beduin_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Deps {
        @PerFragment
        @Binds
        @NotNull
        ComponentsContext bindComponentsContext(@NotNull ComponentsContextImpl componentsContextImpl);

        @PerFragment
        @Binds
        @NotNull
        ComponentsForm bindComponentsForm(@NotNull ComponentsFormImpl componentsFormImpl);
    }

    @Provides
    @NotNull
    public final BeduinViewModel provideViewModel$beduin_release(@NotNull Fragment fragment, @NotNull BeduinViewModelFactory beduinViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(beduinViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, beduinViewModelFactory).get(BeduinViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…uinViewModel::class.java)");
        return (BeduinViewModel) viewModel;
    }
}
