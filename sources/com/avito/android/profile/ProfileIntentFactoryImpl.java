package com.avito.android.profile;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.ProfileIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.UserProfileFragmentData;
import com.avito.android.deep_linking.links.PasswordChangeLink;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.profile.edit.EditProfileActivityKt;
import com.avito.android.profile.password_change.PasswordChangeActivityKt;
import com.avito.android.profile.password_setting.PasswordSettingActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.social.SocialActivityKt;
import com.avito.android.social.SocialTypeToStringMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\tJS\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0016\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/profile/ProfileIntentFactoryImpl;", "Lcom/avito/android/ProfileIntentFactory;", "Landroid/content/Intent;", "createEditProfileIntent", "()Landroid/content/Intent;", "profilePreviewIntent", "", "operationId", "createPhotoPickerIntentForProfile", "(Ljava/lang/String;)Landroid/content/Intent;", "createConfirmRegisterIntent", "type", "createSocialLoginIntent", "createSocialLogoutIntent", "", "isSessionsFlow", "source", "login", "loginType", "sessionIdHash", "deviceId", ChannelContext.Item.USER_ID, "createPasswordChangeIntent", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/deep_linking/links/PasswordChangeLink;", "deeplink", "(Lcom/avito/android/deep_linking/links/PasswordChangeLink;)Landroid/content/Intent;", "createPasswordSettingIntent", "Lcom/avito/android/CoreActivityIntentFactory;", "c", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Lcom/avito/android/social/SocialTypeToStringMapper;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;Lcom/avito/android/social/SocialTypeToStringMapper;Lcom/avito/android/CoreActivityIntentFactory;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public class ProfileIntentFactoryImpl implements ProfileIntentFactory {
    public final Application a;
    public final SocialTypeToStringMapper b;
    public final CoreActivityIntentFactory c;

    @Inject
    public ProfileIntentFactoryImpl(@NotNull Application application, @NotNull SocialTypeToStringMapper socialTypeToStringMapper, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper, "socialTypeToStringMapper");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = application;
        this.b = socialTypeToStringMapper;
        this.c = coreActivityIntentFactory;
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent createConfirmRegisterIntent() {
        return createEditProfileIntent();
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent createEditProfileIntent() {
        return EditProfileActivityKt.createEditProfileIntent(this.a);
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent createPasswordChangeIntent(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return PasswordChangeActivityKt.createPasswordChangeActivity(this.a, z, str, str2, str3, str4, str5, str6);
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent createPasswordSettingIntent() {
        return PasswordSettingActivityKt.createPasswordSettingActivity(this.a);
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent createPhotoPickerIntentForProfile(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return PhotoPickerActivityKt.createPhotoPickerActivityIntent$default(this.a, str, "profile", 1, 1, null, true, true, CameraType.FrontCamera.INSTANCE, PublishIntentFactory.PhotoPickerMode.MODE_LEGACY, 32, null);
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent createSocialLoginIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return SocialActivityKt.createSocialActivityLoginIntent(this.a, this.b.mapToSocialType(str));
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent createSocialLogoutIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return SocialActivityKt.createSocialActivityLogoutIntent(this.a, this.b.mapToSocialType(str));
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent profilePreviewIntent() {
        return this.c.mainScreenWithTab(new UserProfileFragmentData());
    }

    @Override // com.avito.android.ProfileIntentFactory
    @NotNull
    public Intent createPasswordChangeIntent(@NotNull PasswordChangeLink passwordChangeLink) {
        Intrinsics.checkNotNullParameter(passwordChangeLink, "deeplink");
        if (passwordChangeLink.getSource() != null) {
            return PasswordChangeActivityKt.createPasswordChangeActivity(this.a, true, passwordChangeLink.getSource(), passwordChangeLink.getLogin(), passwordChangeLink.getLoginType(), passwordChangeLink.getSessionIdHash(), passwordChangeLink.getDeviceId(), passwordChangeLink.getUserId());
        }
        return PasswordChangeActivityKt.createPasswordChangeActivity$default(this.a, false, null, null, null, null, null, null, 252, null);
    }
}
