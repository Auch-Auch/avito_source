package com.avito.android.verification.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.di.PerFragment;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.avito.android.verification.verification_status.VerificationStatusConverter;
import com.avito.android.verification.verification_status.VerificationStatusConverterImpl;
import com.avito.android.verification.verification_status.VerificationStatusInteractor;
import com.avito.android.verification.verification_status.VerificationStatusInteractorImpl;
import com.avito.android.verification.verification_status.VerificationStatusViewModel;
import com.avito.android.verification.verification_status.VerificationStatusViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/verification/di/VerificationStatusModule;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModelFactory;", "factory", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel;", "provideUserStats", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/avito/android/verification/verification_status/VerificationStatusViewModelFactory;)Lcom/avito/android/verification/verification_status/VerificationStatusViewModel;", "<init>", "()V", "Declarations", "verification_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class VerificationStatusModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/verification/di/VerificationStatusModule$Declarations;", "", "Lcom/avito/android/verification/verification_status/VerificationStatusConverterImpl;", "impl", "Lcom/avito/android/verification/verification_status/VerificationStatusConverter;", "bindConverter", "(Lcom/avito/android/verification/verification_status/VerificationStatusConverterImpl;)Lcom/avito/android/verification/verification_status/VerificationStatusConverter;", "Lcom/avito/android/verification/verification_status/VerificationStatusInteractorImpl;", "Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;", "bindInteractor", "(Lcom/avito/android/verification/verification_status/VerificationStatusInteractorImpl;)Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;", "Lcom/avito/android/util/text/AttributedTextFormatterImpl;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "bindFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatterImpl;)Lcom/avito/android/util/text/AttributedTextFormatter;", "verification_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        VerificationStatusConverter bindConverter(@NotNull VerificationStatusConverterImpl verificationStatusConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        AttributedTextFormatter bindFormatter(@NotNull AttributedTextFormatterImpl attributedTextFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        VerificationStatusInteractor bindInteractor(@NotNull VerificationStatusInteractorImpl verificationStatusInteractorImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final VerificationStatusViewModel provideUserStats(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull VerificationStatusViewModelFactory verificationStatusViewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(verificationStatusViewModelFactory, "factory");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, verificationStatusViewModelFactory).get(VerificationStatusViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo…tusViewModel::class.java)");
        return (VerificationStatusViewModel) viewModel;
    }
}
