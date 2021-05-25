package com.avito.android.profile_phones.phone_action.di;

import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/di/PhoneActionComponent;", "", "Lcom/avito/android/profile_phones/phone_action/PhoneActionFragment;", "fragment", "", "inject", "(Lcom/avito/android/profile_phones/phone_action/PhoneActionFragment;)V", "Builder", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PhoneActionDependencies.class}, modules = {PhoneActionModule.class})
@PerFragment
public interface PhoneActionComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/di/PhoneActionComponent$Builder;", "", "Lcom/avito/android/profile_phones/phone_action/di/PhoneActionDependencies;", "dependencies", "(Lcom/avito/android/profile_phones/phone_action/di/PhoneActionDependencies;)Lcom/avito/android/profile_phones/phone_action/di/PhoneActionComponent$Builder;", "Lcom/avito/android/profile_phones/phone_action/di/PhoneActionModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "phoneActionModule", "(Lcom/avito/android/profile_phones/phone_action/di/PhoneActionModule;)Lcom/avito/android/profile_phones/phone_action/di/PhoneActionComponent$Builder;", "Lcom/avito/android/profile_phones/phone_action/di/PhoneActionComponent;", "build", "()Lcom/avito/android/profile_phones/phone_action/di/PhoneActionComponent;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PhoneActionComponent build();

        @NotNull
        Builder dependencies(@NotNull PhoneActionDependencies phoneActionDependencies);

        @NotNull
        Builder phoneActionModule(@NotNull PhoneActionModule phoneActionModule);
    }

    void inject(@NotNull PhoneActionFragment phoneActionFragment);
}
