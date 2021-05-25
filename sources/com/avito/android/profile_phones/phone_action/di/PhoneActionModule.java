package com.avito.android.profile_phones.phone_action.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.phone_action.PhoneParcelableEntity;
import com.avito.android.profile_phones.phone_action.interactor.PhoneActionInteractor;
import com.avito.android.profile_phones.phone_action.interactor.RemovePhoneInteractor;
import com.avito.android.profile_phones.phone_action.interactor.ReplacePhoneInteractor;
import com.avito.android.profile_phones.phone_action.interactor.SetPhoneForAllInteractor;
import com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider;
import com.avito.android.profile_phones.phone_action.resource_providers.RemovingPhoneResourceProvider;
import com.avito.android.profile_phones.phone_action.resource_providers.ReplacingPhoneResourceProvider;
import com.avito.android.profile_phones.phone_action.resource_providers.SettingPhoneForAllResourceProvider;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModelFactory;
import com.avito.android.profile_phones.phones_list.list_item.PhoneActionCode;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u00041234B5\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010$\u001a\u00020\u0012\u0012\u0006\u0010.\u001a\u00020\u000e\u0012\u0006\u0010+\u001a\u00020\u0016\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b/\u00100J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00065"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/di/PhoneActionModule;", "", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;", "provideRemovePhoneInteractor$profile_phones_release", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;", "provideRemovePhoneInteractor", "Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "provideRemovingPhoneResourceProvider$profile_phones_release", "()Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "provideRemovingPhoneResourceProvider", "", "providePhone$profile_phones_release", "()Ljava/lang/String;", "providePhone", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "providePhoneActionCode$profile_phones_release", "()Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "providePhoneActionCode", "", "providePhoneAdvertsCount$profile_phones_release", "()I", "providePhoneAdvertsCount", "", "Lcom/avito/android/profile_phones/phone_action/PhoneParcelableEntity;", "provideReplacingPhones$profile_phones_release", "()Ljava/util/List;", "provideReplacingPhones", "e", "Ljava/util/List;", "phonesForReplacement", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "actionCode", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "d", "I", "advertsCount", "c", "Ljava/lang/String;", "phone", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;Ljava/lang/String;ILjava/util/List;)V", "Dependencies", "PhoneAdvertsCount", "PhoneUnderAction", "ReplacingPhones", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class PhoneActionModule {
    public final Resources a;
    public final PhoneActionCode b;
    public final String c;
    public final int d;
    public final List<PhoneParcelableEntity> e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/di/PhoneActionModule$Dependencies;", "", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull PhoneActionViewModelFactory phoneActionViewModelFactory);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/di/PhoneActionModule$PhoneAdvertsCount;", "", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PhoneAdvertsCount {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/di/PhoneActionModule$PhoneUnderAction;", "", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PhoneUnderAction {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/di/PhoneActionModule$ReplacingPhones;", "", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ReplacingPhones {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            PhoneActionCode.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            PhoneActionCode phoneActionCode = PhoneActionCode.REMOVE;
            iArr[0] = 1;
            PhoneActionCode phoneActionCode2 = PhoneActionCode.REPLACE_FOR_ADS;
            iArr[3] = 2;
            PhoneActionCode phoneActionCode3 = PhoneActionCode.SET_FOR_ALL;
            iArr[2] = 3;
            PhoneActionCode.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[3] = 2;
            iArr2[2] = 3;
        }
    }

    public PhoneActionModule(@NotNull Resources resources, @NotNull PhoneActionCode phoneActionCode, @NotNull String str, int i, @NotNull List<PhoneParcelableEntity> list) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(phoneActionCode, "actionCode");
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(list, "phonesForReplacement");
        this.a = resources;
        this.b = phoneActionCode;
        this.c = str;
        this.d = i;
        this.e = list;
    }

    @Provides
    @PerFragment
    @NotNull
    public final String providePhone$profile_phones_release() {
        return this.c;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhoneActionCode providePhoneActionCode$profile_phones_release() {
        return this.b;
    }

    @Provides
    @PerFragment
    public final int providePhoneAdvertsCount$profile_phones_release() {
        return this.d;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhoneActionInteractor provideRemovePhoneInteractor$profile_phones_release(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        int ordinal = this.b.ordinal();
        if (ordinal == 0) {
            return new RemovePhoneInteractor(profileApi, schedulersFactory3);
        }
        if (ordinal == 2) {
            return new SetPhoneForAllInteractor(profileApi, schedulersFactory3);
        }
        if (ordinal == 3) {
            return new ReplacePhoneInteractor(profileApi, schedulersFactory3);
        }
        StringBuilder L = a.L("Action ");
        L.append(this.b);
        L.append(" not supported");
        throw new NotImplementedError(L.toString());
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhoneActionResourceProvider provideRemovingPhoneResourceProvider$profile_phones_release() {
        int ordinal = this.b.ordinal();
        if (ordinal == 0) {
            return new RemovingPhoneResourceProvider(this.c, this.d, this.a);
        }
        if (ordinal == 2) {
            return new SettingPhoneForAllResourceProvider(this.c, this.a);
        }
        if (ordinal == 3) {
            return new ReplacingPhoneResourceProvider(this.c, this.d, this.a);
        }
        StringBuilder L = a.L("Action ");
        L.append(this.b);
        L.append(" not supported");
        throw new NotImplementedError(L.toString());
    }

    @Provides
    @NotNull
    @PerFragment
    public final List<PhoneParcelableEntity> provideReplacingPhones$profile_phones_release() {
        return this.e;
    }
}
