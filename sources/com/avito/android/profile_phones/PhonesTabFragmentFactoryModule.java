package com.avito.android.profile_phones;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
import com.avito.android.profile_phones.add_phone.AddPhoneTabFragmentData;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment;
import com.avito.android.profile_phones.confirm_phone.PhoneConfirmCodeRequestTabFragmentData;
import com.avito.android.profile_phones.confirm_phone.PhoneConfirmTabFragmentData;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationTabFragmentData;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
import com.avito.android.profile_phones.phone_action.PhoneActionTabFragmentData;
import com.avito.android.profile_phones.phones_list.PhonesListFragment;
import com.avito.android.profile_phones.phones_list.PhonesListTabFragmentData;
import com.avito.android.ui.fragments.TabBaseFragment;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/PhonesTabFragmentFactoryModule;", "", "", "Lcom/avito/android/bottom_navigation/DataTabFragmentFactory;", "providePhonesTabFragmentFactories", "()Ljava/util/Set;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PhonesTabFragmentFactoryModule {
    @NotNull
    public static final PhonesTabFragmentFactoryModule INSTANCE = new PhonesTabFragmentFactoryModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<DataTabFragmentFactory> providePhonesTabFragmentFactories() {
        DataTabFragmentFactory.Companion companion = DataTabFragmentFactory.Companion;
        return y.setOf((Object[]) new DataTabFragmentFactory[]{new DataTabFragmentFactory() { // from class: com.avito.android.profile_phones.PhonesTabFragmentFactoryModule$providePhonesTabFragmentFactories$$inlined$create$1
            @NotNull
            public final Class<?> a = PhonesListTabFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                PhonesListTabFragmentData phonesListTabFragmentData = (PhonesListTabFragmentData) data;
                return PhonesListFragment.Companion.newInstance();
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }, new DataTabFragmentFactory() { // from class: com.avito.android.profile_phones.PhonesTabFragmentFactoryModule$providePhonesTabFragmentFactories$$inlined$create$2
            @NotNull
            public final Class<?> a = AddPhoneTabFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                AddPhoneTabFragmentData addPhoneTabFragmentData = (AddPhoneTabFragmentData) data;
                return AddPhoneFragment.Companion.newInstance();
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }, new DataTabFragmentFactory() { // from class: com.avito.android.profile_phones.PhonesTabFragmentFactoryModule$providePhonesTabFragmentFactories$$inlined$create$3
            @NotNull
            public final Class<?> a = LandlinePhoneVerificationTabFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                LandlinePhoneVerificationTabFragmentData landlinePhoneVerificationTabFragmentData = (LandlinePhoneVerificationTabFragmentData) data;
                return LandlinePhoneVerificationFragment.Companion.newInstance(landlinePhoneVerificationTabFragmentData.getCallId(), landlinePhoneVerificationTabFragmentData.getTitle(), landlinePhoneVerificationTabFragmentData.getSubtitle(), landlinePhoneVerificationTabFragmentData.getDescription(), landlinePhoneVerificationTabFragmentData.getPhone(), landlinePhoneVerificationTabFragmentData.isManual());
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }, new DataTabFragmentFactory() { // from class: com.avito.android.profile_phones.PhonesTabFragmentFactoryModule$providePhonesTabFragmentFactories$$inlined$create$4
            @NotNull
            public final Class<?> a = PhoneConfirmTabFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                PhoneConfirmTabFragmentData phoneConfirmTabFragmentData = (PhoneConfirmTabFragmentData) data;
                return ConfirmPhoneFragment.Companion.newInstance(phoneConfirmTabFragmentData.getArgs().getPhone(), phoneConfirmTabFragmentData.getArgs().getCodeLength(), phoneConfirmTabFragmentData.getArgs().getTimeout());
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }, new DataTabFragmentFactory() { // from class: com.avito.android.profile_phones.PhonesTabFragmentFactoryModule$providePhonesTabFragmentFactories$$inlined$create$5
            @NotNull
            public final Class<?> a = PhoneConfirmCodeRequestTabFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return ConfirmPhoneFragment.Companion.newInstanceWithCodeRequest(((PhoneConfirmCodeRequestTabFragmentData) data).getPhone());
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }, new DataTabFragmentFactory() { // from class: com.avito.android.profile_phones.PhonesTabFragmentFactoryModule$providePhonesTabFragmentFactories$$inlined$create$6
            @NotNull
            public final Class<?> a = PhoneActionTabFragmentData.class;

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public TabBaseFragment create(@NotNull TabFragmentFactory.Data data) {
                Intrinsics.checkNotNullParameter(data, "data");
                PhoneActionTabFragmentData phoneActionTabFragmentData = (PhoneActionTabFragmentData) data;
                return PhoneActionFragment.Companion.newInstance(phoneActionTabFragmentData.getArgs().getPhone(), phoneActionTabFragmentData.getArgs().getAdvertsCount(), phoneActionTabFragmentData.getArgs().getActionCode(), phoneActionTabFragmentData.getArgs().getPhonesForReplacement());
            }

            @Override // com.avito.android.bottom_navigation.DataTabFragmentFactory
            @NotNull
            public Class<?> getDataType() {
                return this.a;
            }
        }});
    }
}
