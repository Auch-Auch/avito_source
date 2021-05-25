package com.sumsub.sns.core.data.source.settings;

import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.common.SNSConstants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/core/data/source/settings/RealSettingsRepository;", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "", "getDeviceId", "()Ljava/lang/String;", "getApplicantId", "id", "", "setApplicantId", "(Ljava/lang/String;)V", "", "getDontShowSettingsDialog", "()Z", "setDontShowSettingsDialog", "()V", "Landroid/content/SharedPreferences;", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", "preferences", "<init>", "(Landroid/content/SharedPreferences;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RealSettingsRepository implements SettingsRepository {
    public final SharedPreferences a;

    public RealSettingsRepository(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        this.a = sharedPreferences;
    }

    @Override // com.sumsub.sns.core.data.source.settings.SettingsRepository
    @NotNull
    public String getApplicantId() {
        String str = "";
        String string = this.a.getString(SNSConstants.Preference.KEY_APPLICANT_ID, str);
        if (string != null) {
            str = string;
        }
        Intrinsics.checkNotNullExpressionValue(str, "preferences.getString(SN…Y_APPLICANT_ID, \"\") ?: \"\"");
        return str;
    }

    @Override // com.sumsub.sns.core.data.source.settings.SettingsRepository
    @NotNull
    public String getDeviceId() {
        String string = this.a.getString(SNSConstants.Preference.KEY_DEVICE_ID, null);
        if (string == null || string.length() == 0) {
            string = UUID.randomUUID().toString();
        }
        SharedPreferences.Editor edit = this.a.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putString(SNSConstants.Preference.KEY_DEVICE_ID, string);
        edit.commit();
        return string;
    }

    @Override // com.sumsub.sns.core.data.source.settings.SettingsRepository
    public boolean getDontShowSettingsDialog() {
        return this.a.getBoolean(SNSConstants.Preference.KEY_DONT_SHOW_SETTINGS_DIALOG, false);
    }

    @Override // com.sumsub.sns.core.data.source.settings.SettingsRepository
    public void setApplicantId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        SharedPreferences.Editor edit = this.a.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putString(SNSConstants.Preference.KEY_APPLICANT_ID, str);
        edit.commit();
    }

    @Override // com.sumsub.sns.core.data.source.settings.SettingsRepository
    public void setDontShowSettingsDialog() {
        SharedPreferences.Editor edit = this.a.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "editor");
        edit.putBoolean(SNSConstants.Preference.KEY_DONT_SHOW_SETTINGS_DIALOG, true);
        edit.commit();
    }
}
