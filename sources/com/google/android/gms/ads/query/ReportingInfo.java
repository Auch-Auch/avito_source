package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzarj;
import com.google.android.gms.internal.ads.zzark;
import java.util.List;
import java.util.Map;
@KeepForSdk
public final class ReportingInfo {
    private final zzarj zzhik;

    @KeepForSdk
    public static final class Builder {
        private final zzark zzhil;

        @KeepForSdk
        public Builder(View view) {
            zzark zzark = new zzark();
            this.zzhil = zzark;
            zzark.zzk(view);
        }

        @KeepForSdk
        public final ReportingInfo build() {
            return new ReportingInfo(this);
        }

        @KeepForSdk
        public final Builder setAssetViews(Map<String, View> map) {
            this.zzhil.zzh(map);
            return this;
        }
    }

    private ReportingInfo(Builder builder) {
        this.zzhik = new zzarj(builder.zzhil);
    }

    @KeepForSdk
    public final void reportTouchEvent(MotionEvent motionEvent) {
        this.zzhik.reportTouchEvent(motionEvent);
    }

    @KeepForSdk
    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzhik.updateClickUrl(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzhik.updateImpressionUrls(list, updateImpressionUrlsCallback);
    }
}
