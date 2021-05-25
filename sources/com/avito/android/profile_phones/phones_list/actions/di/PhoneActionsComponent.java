package com.avito.android.profile_phones.phones_list.actions.di;

import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsComponent;", "", "Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionsSheetDialogFragment;", "fragment", "", "inject", "(Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionsSheetDialogFragment;)V", "Builder", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PhoneActionsDependencies.class}, modules = {PhoneActionsModule.class})
@PerFragment
public interface PhoneActionsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsComponent$Builder;", "", "Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsDependencies;", "dependencies", "phonesListDependencies", "(Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsDependencies;)Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsComponent$Builder;", "Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsComponent;", "build", "()Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsComponent;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PhoneActionsComponent build();

        @NotNull
        Builder phonesListDependencies(@NotNull PhoneActionsDependencies phoneActionsDependencies);
    }

    void inject(@NotNull PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment);
}
