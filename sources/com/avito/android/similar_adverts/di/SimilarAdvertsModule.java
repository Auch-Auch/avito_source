package com.avito.android.similar_adverts.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.similar_adverts.SimilarAdvertsInteractor;
import com.avito.android.similar_adverts.SimilarAdvertsInteractorImpl;
import com.avito.android.similar_adverts.SimilarAdvertsResourceProvider;
import com.avito.android.similar_adverts.SimilarAdvertsResourceProviderImpl;
import com.avito.android.similar_adverts.SimilarAdvertsViewModel;
import com.avito.android.similar_adverts.SimilarAdvertsViewModelImpl;
import com.avito.android.similar_adverts.SimilarAdvertsViewModelImplFactory;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/similar_adverts/di/SimilarAdvertsModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/similar_adverts/SimilarAdvertsViewModelImplFactory;", "viewModelFactory", "Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "provideSimilarAdvertsViewModel$similar_adverts_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/similar_adverts/SimilarAdvertsViewModelImplFactory;)Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "provideSimilarAdvertsViewModel", "<init>", "()V", "Dependencies", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, AttributedTextFormatterModule.class})
public final class SimilarAdvertsModule {
    @NotNull
    public static final SimilarAdvertsModule INSTANCE = new SimilarAdvertsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/similar_adverts/di/SimilarAdvertsModule$Dependencies;", "", "Lcom/avito/android/similar_adverts/SimilarAdvertsInteractorImpl;", "interactor", "Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;", "bindsSimilarAdvertsInteractor", "(Lcom/avito/android/similar_adverts/SimilarAdvertsInteractorImpl;)Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProviderImpl;", "similarResourceProvider", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "bindAdvertSimilarResourceProvider", "(Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProviderImpl;)Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        SimilarAdvertsResourceProvider bindAdvertSimilarResourceProvider(@NotNull SimilarAdvertsResourceProviderImpl similarAdvertsResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SimilarAdvertsInteractor bindsSimilarAdvertsInteractor(@NotNull SimilarAdvertsInteractorImpl similarAdvertsInteractorImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimilarAdvertsViewModel provideSimilarAdvertsViewModel$similar_adverts_release(@NotNull Fragment fragment, @NotNull SimilarAdvertsViewModelImplFactory similarAdvertsViewModelImplFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(similarAdvertsViewModelImplFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, similarAdvertsViewModelImplFactory).get(SimilarAdvertsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (SimilarAdvertsViewModel) viewModel;
    }
}
