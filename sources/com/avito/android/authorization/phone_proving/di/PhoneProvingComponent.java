package com.avito.android.authorization.phone_proving.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.authorization.phone_proving.PhoneProvingActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent;", "", "Lcom/avito/android/authorization/phone_proving/PhoneProvingActivity;", "activity", "", "inject", "(Lcom/avito/android/authorization/phone_proving/PhoneProvingActivity;)V", "Builder", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PhoneProvingDependencies.class}, modules = {PhoneProvingModule.class, DialogModule.class, ErrorHelperModule.class})
@PerActivity
public interface PhoneProvingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u0016\u001a\u00020\u0012H'¢\u0006\u0004\b\u0017\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0012H'¢\u0006\u0004\b\u0019\u0010\u0015J\u0019\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent$Builder;", "", "Lcom/avito/android/authorization/phone_proving/di/PhoneProvingDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/authorization/phone_proving/di/PhoneProvingDependencies;)Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent$Builder;", "", "challengeId", "withChallengeId", "(Ljava/lang/String;)Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent$Builder;", "phonePart", "withPhonePart", "inputHint", "withInputHint", "", "isOpenedFromPhoneList", "withIsOpenedFromPhoneListFlag", "(Z)Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent$Builder;", "Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent;", "build", "()Lcom/avito/android/authorization/phone_proving/di/PhoneProvingComponent;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PhoneProvingComponent build();

        @NotNull
        Builder dependentOn(@NotNull PhoneProvingDependencies phoneProvingDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withChallengeId(@ChallengeId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withInputHint(@InputHint @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withIsOpenedFromPhoneListFlag(@IsOpenedFromPhoneList boolean z);

        @BindsInstance
        @NotNull
        Builder withPhonePart(@PhonePart @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull PhoneProvingActivity phoneProvingActivity);
}
