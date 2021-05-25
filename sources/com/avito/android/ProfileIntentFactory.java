package com.avito.android;

import android.content.Intent;
import com.avito.android.deep_linking.links.PasswordChangeLink;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\tJa\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0016\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/ProfileIntentFactory;", "", "Landroid/content/Intent;", "createEditProfileIntent", "()Landroid/content/Intent;", "profilePreviewIntent", "", "operationId", "createPhotoPickerIntentForProfile", "(Ljava/lang/String;)Landroid/content/Intent;", "createConfirmRegisterIntent", "type", "createSocialLoginIntent", "createSocialLogoutIntent", "", "isSessionsFlow", "source", "login", "loginType", "sessionIdHash", "deviceId", ChannelContext.Item.USER_ID, "createPasswordChangeIntent", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/deep_linking/links/PasswordChangeLink;", "deeplink", "(Lcom/avito/android/deep_linking/links/PasswordChangeLink;)Landroid/content/Intent;", "createPasswordSettingIntent", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent createPasswordChangeIntent$default(ProfileIntentFactory profileIntentFactory, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                String str7 = null;
                String str8 = (i & 2) != 0 ? null : str;
                String str9 = (i & 4) != 0 ? null : str2;
                String str10 = (i & 8) != 0 ? null : str3;
                String str11 = (i & 16) != 0 ? null : str4;
                String str12 = (i & 32) != 0 ? null : str5;
                if ((i & 64) == 0) {
                    str7 = str6;
                }
                return profileIntentFactory.createPasswordChangeIntent(z, str8, str9, str10, str11, str12, str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPasswordChangeIntent");
        }
    }

    @NotNull
    Intent createConfirmRegisterIntent();

    @NotNull
    Intent createEditProfileIntent();

    @NotNull
    Intent createPasswordChangeIntent(@NotNull PasswordChangeLink passwordChangeLink);

    @NotNull
    Intent createPasswordChangeIntent(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6);

    @NotNull
    Intent createPasswordSettingIntent();

    @NotNull
    Intent createPhotoPickerIntentForProfile(@NotNull String str);

    @NotNull
    Intent createSocialLoginIntent(@NotNull String str);

    @NotNull
    Intent createSocialLogoutIntent(@NotNull String str);

    @NotNull
    Intent profilePreviewIntent();
}
