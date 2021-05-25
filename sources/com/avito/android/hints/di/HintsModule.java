package com.avito.android.hints.di;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.hints.repository.HintsConverter;
import com.avito.android.hints.repository.HintsConverterImpl;
import com.avito.android.hints.repository.HintsRepository;
import com.avito.android.hints.repository.HintsRepositoryImpl;
import com.avito.android.hints.viewmodel.HintViewModelFactory;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/hints/di/HintsModule;", "", "<init>", "()V", "Declarations", "hints_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class})
public final class HintsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/hints/di/HintsModule$Declarations;", "", "Lcom/avito/android/hints/repository/HintsRepositoryImpl;", "hintsRepository", "Lcom/avito/android/hints/repository/HintsRepository;", "provideRepository", "(Lcom/avito/android/hints/repository/HintsRepositoryImpl;)Lcom/avito/android/hints/repository/HintsRepository;", "Lcom/avito/android/hints/repository/HintsConverterImpl;", "converter", "Lcom/avito/android/hints/repository/HintsConverter;", "provideConverter", "(Lcom/avito/android/hints/repository/HintsConverterImpl;)Lcom/avito/android/hints/repository/HintsConverter;", "Lcom/avito/android/hints/viewmodel/HintViewModelFactory;", "hintViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/hints/viewmodel/HintViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "hints_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        HintsConverter provideConverter(@NotNull HintsConverterImpl hintsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        HintsRepository provideRepository(@NotNull HintsRepositoryImpl hintsRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull HintViewModelFactory hintViewModelFactory);
    }
}
