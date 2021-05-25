package com.avito.android.profile_phones.landline_verification.di;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationVMFactory;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/di/LandlinePhoneVerificationModule;", "", "<init>", "()V", "Dependencies", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, AttributedTextFormatterModule.class})
public final class LandlinePhoneVerificationModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/di/LandlinePhoneVerificationModule$Dependencies;", "", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationVMFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "bindViewModelFactory", "(Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationVMFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory bindViewModelFactory(@NotNull LandlinePhoneVerificationVMFactory landlinePhoneVerificationVMFactory);
    }
}
