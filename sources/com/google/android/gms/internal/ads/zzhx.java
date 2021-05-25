package com.google.android.gms.internal.ads;

import java.io.IOException;
public interface zzhx extends zzhe {
    void disable();

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i);

    void start() throws zzhd;

    void stop() throws zzhd;

    void zza(zzhz zzhz, zzho[] zzhoArr, zznm zznm, long j, boolean z, long j2) throws zzhd;

    void zza(zzho[] zzhoArr, zznm zznm, long j) throws zzhd;

    void zzb(long j, long j2) throws zzhd;

    void zzdo(long j) throws zzhd;

    zzhw zzdx();

    zzpd zzdy();

    zznm zzdz();

    boolean zzea();

    void zzeb();

    boolean zzec();

    void zzed() throws IOException;

    boolean zzfc();
}
