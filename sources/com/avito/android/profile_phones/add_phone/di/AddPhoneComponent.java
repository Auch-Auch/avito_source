package com.avito.android.profile_phones.add_phone.di;

import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/di/AddPhoneComponent;", "", "Lcom/avito/android/profile_phones/add_phone/AddPhoneFragment;", "fragment", "", "inject", "(Lcom/avito/android/profile_phones/add_phone/AddPhoneFragment;)V", "Builder", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AddPhoneDependencies.class}, modules = {AddPhoneModule.class})
@PerFragment
public interface AddPhoneComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/di/AddPhoneComponent$Builder;", "", "Lcom/avito/android/profile_phones/add_phone/di/AddPhoneDependencies;", "dependencies", "addPhoneDependencies", "(Lcom/avito/android/profile_phones/add_phone/di/AddPhoneDependencies;)Lcom/avito/android/profile_phones/add_phone/di/AddPhoneComponent$Builder;", "Lcom/avito/android/profile_phones/add_phone/di/AddPhoneModule;", "addPhoneModule", "(Lcom/avito/android/profile_phones/add_phone/di/AddPhoneModule;)Lcom/avito/android/profile_phones/add_phone/di/AddPhoneComponent$Builder;", "Lcom/avito/android/profile_phones/add_phone/di/AddPhoneComponent;", "build", "()Lcom/avito/android/profile_phones/add_phone/di/AddPhoneComponent;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        Builder addPhoneDependencies(@NotNull AddPhoneDependencies addPhoneDependencies);

        @NotNull
        Builder addPhoneModule(@NotNull AddPhoneModule addPhoneModule);

        @NotNull
        AddPhoneComponent build();
    }

    void inject(@NotNull AddPhoneFragment addPhoneFragment);
}
