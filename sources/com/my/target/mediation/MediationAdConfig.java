package com.my.target.mediation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.MyTargetPrivacy;
import java.util.Map;
public interface MediationAdConfig {
    int getAge();

    int getGender();

    @Nullable
    String getPayload();

    @NonNull
    String getPlacementId();

    @NonNull
    MyTargetPrivacy getPrivacy();

    @NonNull
    Map<String, String> getServerParams();

    boolean isUserAgeRestricted();

    boolean isUserConsent();

    boolean isUserConsentSpecified();
}
