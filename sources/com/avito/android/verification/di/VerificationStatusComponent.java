package com.avito.android.verification.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.di.PerFragment;
import com.avito.android.verification.verification_status.VerificationStatusFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/verification/di/VerificationStatusComponent;", "", "Lcom/avito/android/verification/verification_status/VerificationStatusFragment;", "fragment", "", "inject", "(Lcom/avito/android/verification/verification_status/VerificationStatusFragment;)V", "Factory", "verification_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {VerificationStatusDependencies.class}, modules = {VerificationStatusModule.class, VerificationModule.class})
@PerFragment
public interface VerificationStatusComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/verification/di/VerificationStatusComponent$Factory;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/verification/di/VerificationStatusDependencies;", "dependencies", "Lcom/avito/android/verification/di/VerificationStatusComponent;", "create", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroid/content/res/Resources;Lcom/avito/android/verification/di/VerificationStatusDependencies;)Lcom/avito/android/verification/di/VerificationStatusComponent;", "verification_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        VerificationStatusComponent create(@BindsInstance @NotNull ViewModelStoreOwner viewModelStoreOwner, @BindsInstance @NotNull Resources resources, @NotNull VerificationStatusDependencies verificationStatusDependencies);
    }

    void inject(@NotNull VerificationStatusFragment verificationStatusFragment);
}
