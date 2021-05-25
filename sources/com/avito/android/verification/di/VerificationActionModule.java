package com.avito.android.verification.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.di.PerActivity;
import com.avito.android.verification.verification_status.VerificationStatusInteractor;
import com.avito.android.verification.verification_status.VerificationStatusInteractorImpl;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModel;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/verification/di/VerificationActionModule;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModelFactory;", "factory", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel;", "provideUserStats", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModelFactory;)Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel;", "<init>", "()V", "Declarations", "verification_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class VerificationActionModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/verification/di/VerificationActionModule$Declarations;", "", "Lcom/avito/android/verification/verification_status/VerificationStatusInteractorImpl;", "impl", "Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;", "bindInteractor", "(Lcom/avito/android/verification/verification_status/VerificationStatusInteractorImpl;)Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;", "verification_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        VerificationStatusInteractor bindInteractor(@NotNull VerificationStatusInteractorImpl verificationStatusInteractorImpl);
    }

    @Provides
    @PerActivity
    @NotNull
    public final VerificationActionViewModel provideUserStats(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull VerificationActionViewModelFactory verificationActionViewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(verificationActionViewModelFactory, "factory");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, verificationActionViewModelFactory).get(VerificationActionViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo…ionViewModel::class.java)");
        return (VerificationActionViewModel) viewModel;
    }
}
