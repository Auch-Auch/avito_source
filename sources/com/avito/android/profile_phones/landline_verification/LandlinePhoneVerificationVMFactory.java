package com.avito.android.profile_phones.landline_verification;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationVMFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationInteractor;", "interactor", "<init>", "(Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationInteractor;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class LandlinePhoneVerificationVMFactory implements ViewModelProvider.Factory {
    public final LandlinePhoneVerificationInteractor a;

    @Inject
    public LandlinePhoneVerificationVMFactory(@NotNull LandlinePhoneVerificationInteractor landlinePhoneVerificationInteractor) {
        Intrinsics.checkNotNullParameter(landlinePhoneVerificationInteractor, "interactor");
        this.a = landlinePhoneVerificationInteractor;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(LandlinePhoneVerificationViewModel.class)) {
            return new LandlinePhoneVerificationViewModel(this.a);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
