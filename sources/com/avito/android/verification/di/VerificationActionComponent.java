package com.avito.android.verification.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.di.PerActivity;
import com.avito.android.verification.verification_status.actions.VerificationActionActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/verification/di/VerificationActionComponent;", "", "Lcom/avito/android/verification/verification_status/actions/VerificationActionActivity;", "activity", "", "inject", "(Lcom/avito/android/verification/verification_status/actions/VerificationActionActivity;)V", "Factory", "verification_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {VerificationActionDependencies.class}, modules = {VerificationActionModule.class, VerificationModule.class})
@PerActivity
public interface VerificationActionComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/verification/di/VerificationActionComponent$Factory;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Lcom/avito/android/verification/di/VerificationActionDependencies;", "dependencies", "Landroid/content/res/Resources;", "resources", "", "type", "Lcom/avito/android/verification/di/VerificationActionComponent;", "create", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/avito/android/verification/di/VerificationActionDependencies;Landroid/content/res/Resources;Ljava/lang/String;)Lcom/avito/android/verification/di/VerificationActionComponent;", "verification_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        VerificationActionComponent create(@BindsInstance @NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull VerificationActionDependencies verificationActionDependencies, @BindsInstance @NotNull Resources resources, @BindsInstance @VerificationType @NotNull String str);
    }

    void inject(@NotNull VerificationActionActivity verificationActionActivity);
}
