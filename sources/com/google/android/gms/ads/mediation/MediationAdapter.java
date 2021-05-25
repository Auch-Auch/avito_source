package com.google.android.gms.ads.mediation;

import android.os.Bundle;
public interface MediationAdapter extends MediationExtrasReceiver {

    public static class zza {
        private int zzeqf;

        public final Bundle zzadc() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzeqf);
            return bundle;
        }

        public final zza zzdv(int i) {
            this.zzeqf = 1;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
