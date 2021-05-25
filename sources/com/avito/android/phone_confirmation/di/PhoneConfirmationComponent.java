package com.avito.android.phone_confirmation.di;

import android.app.Activity;
import com.avito.android.di.PerActivity;
import com.avito.android.phone_confirmation.PhoneConfirmationActivity;
import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/phone_confirmation/di/PhoneConfirmationComponent;", "", "Lcom/avito/android/phone_confirmation/PhoneConfirmationActivity;", "activity", "", "inject", "(Lcom/avito/android/phone_confirmation/PhoneConfirmationActivity;)V", "Builder", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PhoneConfirmationDependencies.class}, modules = {PhoneConfirmationModule.class})
@PerActivity
public interface PhoneConfirmationComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/phone_confirmation/di/PhoneConfirmationComponent$Builder;", "", "Lcom/avito/android/phone_confirmation/di/PhoneConfirmationDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/phone_confirmation/di/PhoneConfirmationDependencies;)Lcom/avito/android/phone_confirmation/di/PhoneConfirmationComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/phone_confirmation/di/PhoneConfirmationComponent$Builder;", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "initialState", "withInitialState", "(Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;)Lcom/avito/android/phone_confirmation/di/PhoneConfirmationComponent$Builder;", "", "confirmPhoneOnConsultationForm", "withConfirmationType", "(Z)Lcom/avito/android/phone_confirmation/di/PhoneConfirmationComponent$Builder;", "Lcom/avito/android/phone_confirmation/di/PhoneConfirmationComponent;", "build", "()Lcom/avito/android/phone_confirmation/di/PhoneConfirmationComponent;", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PhoneConfirmationComponent build();

        @NotNull
        Builder dependentOn(@NotNull PhoneConfirmationDependencies phoneConfirmationDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withConfirmationType(boolean z);

        @BindsInstance
        @NotNull
        Builder withInitialState(@NotNull PhoneConfirmationScreenState phoneConfirmationScreenState);
    }

    void inject(@NotNull PhoneConfirmationActivity phoneConfirmationActivity);
}
