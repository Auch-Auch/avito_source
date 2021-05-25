package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzafp;
import com.google.android.gms.internal.ads.zzafq;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzxc;
import com.google.android.gms.internal.ads.zzxf;
@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)
    private final boolean zzbnu;
    @Nullable
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", id = 2, type = "android.os.IBinder")
    private final zzxc zzbnv;
    @Nullable
    private AppEventListener zzbnw;
    @Nullable
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 3)
    private final IBinder zzbnx;

    public static final class Builder {
        private boolean zzbnu = false;
        @Nullable
        private AppEventListener zzbnw;
        @Nullable
        private ShouldDelayBannerRenderingListener zzbny;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzbnw = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbnu = z;
            return this;
        }

        @KeepForSdk
        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzbny = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzbnu = builder.zzbnu;
        AppEventListener appEventListener = builder.zzbnw;
        this.zzbnw = appEventListener;
        zzaaa zzaaa = null;
        this.zzbnv = appEventListener != null ? new zzvn(this.zzbnw) : null;
        this.zzbnx = builder.zzbny != null ? new zzaaa(builder.zzbny) : zzaaa;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzbnw;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbnu;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzxc zzxc = this.zzbnv;
        SafeParcelWriter.writeIBinder(parcel, 2, zzxc == null ? null : zzxc.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzbnx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzxc zzjt() {
        return this.zzbnv;
    }

    @Nullable
    public final zzafq zzju() {
        return zzafp.zzy(this.zzbnx);
    }

    @SafeParcelable.Constructor
    public PublisherAdViewOptions(@SafeParcelable.Param(id = 1) boolean z, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder2) {
        this.zzbnu = z;
        this.zzbnv = iBinder != null ? zzxf.zze(iBinder) : null;
        this.zzbnx = iBinder2;
    }
}
