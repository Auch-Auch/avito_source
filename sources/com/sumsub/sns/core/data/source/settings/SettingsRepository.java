package com.sumsub.sns.core.data.source.settings;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "", "", "getDeviceId", "()Ljava/lang/String;", "getApplicantId", "id", "", "setApplicantId", "(Ljava/lang/String;)V", "setDontShowSettingsDialog", "()V", "", "getDontShowSettingsDialog", "()Z", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface SettingsRepository {
    @NotNull
    String getApplicantId();

    @NotNull
    String getDeviceId();

    boolean getDontShowSettingsDialog();

    void setApplicantId(@NotNull String str);

    void setDontShowSettingsDialog();
}
