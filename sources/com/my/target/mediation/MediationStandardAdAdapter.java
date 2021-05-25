package com.my.target.mediation;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.my.target.ads.MyTargetView;
public interface MediationStandardAdAdapter extends MediationAdapter {

    public interface MediationStandardAdListener {
        void onClick(@NonNull MediationStandardAdAdapter mediationStandardAdAdapter);

        void onLoad(@NonNull View view, @NonNull MediationStandardAdAdapter mediationStandardAdAdapter);

        void onNoAd(@NonNull String str, @NonNull MediationStandardAdAdapter mediationStandardAdAdapter);

        void onShow(@NonNull MediationStandardAdAdapter mediationStandardAdAdapter);
    }

    void load(@NonNull MediationAdConfig mediationAdConfig, @NonNull MyTargetView.AdSize adSize, @NonNull MediationStandardAdListener mediationStandardAdListener, @NonNull Context context);
}
