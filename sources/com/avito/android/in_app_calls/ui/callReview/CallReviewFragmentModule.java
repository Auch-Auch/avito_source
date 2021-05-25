package com.avito.android.in_app_calls.ui.callReview;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.app.arch_components.ViewModelFactory;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReviewAnalyticEventProvider;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReviewAnalyticEventProviderImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/app/arch_components/ViewModelFactory;", "factory", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter;", "provideCallReviewPresenter", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/app/arch_components/ViewModelFactory;)Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenter;", "<init>", "()V", "Declarations", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CallReviewFragmentModule {
    @NotNull
    public static final CallReviewFragmentModule INSTANCE = new CallReviewFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/in_app_calls/ui/callReview/CallReviewFragmentModule$Declarations;", "", "Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "bindCallReviewPresenterViewModel", "(Lcom/avito/android/in_app_calls/ui/callReview/CallReviewPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProviderImpl;", "Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProvider;", "bindCallReviewAnalyticEventProvider", "(Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProviderImpl;)Lcom/avito/android/in_app_calls/ui/callReview/reviews/CallReviewAnalyticEventProvider;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        CallReviewAnalyticEventProvider bindCallReviewAnalyticEventProvider(@NotNull CallReviewAnalyticEventProviderImpl callReviewAnalyticEventProviderImpl);

        @Binds
        @NotNull
        @ClassKey(CallReviewPresenterImpl.class)
        @IntoMap
        ViewModel bindCallReviewPresenterViewModel(@NotNull CallReviewPresenterImpl callReviewPresenterImpl);
    }

    @Provides
    @NotNull
    public final CallReviewPresenter provideCallReviewPresenter(@NotNull Fragment fragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(fragment, viewModelFactory).get(CallReviewPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        return (CallReviewPresenter) viewModel;
    }
}
