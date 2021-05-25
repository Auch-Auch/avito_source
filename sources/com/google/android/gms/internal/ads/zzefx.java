package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;
public final class zzefx implements zzeip {
    private int tag;
    private final zzefq zzicd;
    private int zzice;
    private int zzicf = 0;

    private zzefx(zzefq zzefq) {
        zzefq zzefq2 = (zzefq) zzegr.zza(zzefq, "input");
        this.zzicd = zzefq2;
        zzefq2.zzibs = this;
    }

    public static zzefx zza(zzefq zzefq) {
        zzefx zzefx = zzefq.zzibs;
        if (zzefx != null) {
            return zzefx;
        }
        return new zzefx(zzefq);
    }

    private final <T> T zzc(zzeiv<T> zzeiv, zzegc zzegc) throws IOException {
        int zzbec = this.zzicd.zzbec();
        zzefq zzefq = this.zzicd;
        if (zzefq.zzibp < zzefq.zzibq) {
            int zzga = zzefq.zzga(zzbec);
            T newInstance = zzeiv.newInstance();
            this.zzicd.zzibp++;
            zzeiv.zza(newInstance, this, zzegc);
            zzeiv.zzaj(newInstance);
            this.zzicd.zzfy(0);
            zzefq zzefq2 = this.zzicd;
            zzefq2.zzibp--;
            zzefq2.zzgb(zzga);
            return newInstance;
        }
        throw new zzegz("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzeiv<T> zzeiv, zzegc zzegc) throws IOException {
        int i = this.zzice;
        this.zzice = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzeiv.newInstance();
            zzeiv.zza(newInstance, this, zzegc);
            zzeiv.zzaj(newInstance);
            if (this.tag == this.zzice) {
                return newInstance;
            }
            throw zzegz.zzbgi();
        } finally {
            this.zzice = i;
        }
    }

    private final void zzgi(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzegz.zzbgg();
        }
    }

    private static void zzgj(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzegz.zzbgi();
        }
    }

    private static void zzgk(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzegz.zzbgi();
        }
    }

    private final void zzgl(int i) throws IOException {
        if (this.zzicd.zzbek() != i) {
            throw zzegz.zzbgb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final double readDouble() throws IOException {
        zzgi(1);
        return this.zzicd.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final float readFloat() throws IOException {
        zzgi(5);
        return this.zzicd.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final String readString() throws IOException {
        zzgi(2);
        return this.zzicd.readString();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final <T> T zzb(zzeiv<T> zzeiv, zzegc zzegc) throws IOException {
        zzgi(3);
        return (T) zzd(zzeiv, zzegc);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final long zzbdu() throws IOException {
        zzgi(0);
        return this.zzicd.zzbdu();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final long zzbdv() throws IOException {
        zzgi(0);
        return this.zzicd.zzbdv();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int zzbdw() throws IOException {
        zzgi(0);
        return this.zzicd.zzbdw();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final long zzbdx() throws IOException {
        zzgi(1);
        return this.zzicd.zzbdx();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int zzbdy() throws IOException {
        zzgi(5);
        return this.zzicd.zzbdy();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final boolean zzbdz() throws IOException {
        zzgi(0);
        return this.zzicd.zzbdz();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final String zzbea() throws IOException {
        zzgi(2);
        return this.zzicd.zzbea();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final zzeff zzbeb() throws IOException {
        zzgi(2);
        return this.zzicd.zzbeb();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int zzbec() throws IOException {
        zzgi(0);
        return this.zzicd.zzbec();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int zzbed() throws IOException {
        zzgi(0);
        return this.zzicd.zzbed();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int zzbee() throws IOException {
        zzgi(5);
        return this.zzicd.zzbee();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final long zzbef() throws IOException {
        zzgi(1);
        return this.zzicd.zzbef();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int zzbeg() throws IOException {
        zzgi(0);
        return this.zzicd.zzbeg();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final long zzbeh() throws IOException {
        zzgi(0);
        return this.zzicd.zzbeh();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int zzber() throws IOException {
        int i = this.zzicf;
        if (i != 0) {
            this.tag = i;
            this.zzicf = 0;
        } else {
            this.tag = this.zzicd.zzbdt();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzice) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final boolean zzbes() throws IOException {
        int i;
        if (this.zzicd.zzbej() || (i = this.tag) == this.zzice) {
            return false;
        }
        return this.zzicd.zzfz(i);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzk(List<Double> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzega) {
            zzega zzega = (zzega) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzega.zzd(this.zzicd.readDouble());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbec = this.zzicd.zzbec();
                zzgj(zzbec);
                int zzbek = this.zzicd.zzbek() + zzbec;
                do {
                    zzega.zzd(this.zzicd.readDouble());
                } while (this.zzicd.zzbek() < zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzicd.readDouble()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbec2 = this.zzicd.zzbec();
                zzgj(zzbec2);
                int zzbek2 = this.zzicd.zzbek() + zzbec2;
                do {
                    list.add(Double.valueOf(this.zzicd.readDouble()));
                } while (this.zzicd.zzbek() < zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzl(List<Float> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzego) {
            zzego zzego = (zzego) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbec = this.zzicd.zzbec();
                zzgk(zzbec);
                int zzbek = this.zzicd.zzbek() + zzbec;
                do {
                    zzego.zzh(this.zzicd.readFloat());
                } while (this.zzicd.zzbek() < zzbek);
            } else if (i == 5) {
                do {
                    zzego.zzh(this.zzicd.readFloat());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbec2 = this.zzicd.zzbec();
                zzgk(zzbec2);
                int zzbek2 = this.zzicd.zzbek() + zzbec2;
                do {
                    list.add(Float.valueOf(this.zzicd.readFloat()));
                } while (this.zzicd.zzbek() < zzbek2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzicd.readFloat()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzm(List<Long> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzehn) {
            zzehn zzehn = (zzehn) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzehn.zzfs(this.zzicd.zzbdu());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbek = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    zzehn.zzfs(this.zzicd.zzbdu());
                } while (this.zzicd.zzbek() < zzbek);
                zzgl(zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzicd.zzbdu()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbek2 = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    list.add(Long.valueOf(this.zzicd.zzbdu()));
                } while (this.zzicd.zzbek() < zzbek2);
                zzgl(zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzn(List<Long> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzehn) {
            zzehn zzehn = (zzehn) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzehn.zzfs(this.zzicd.zzbdv());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbek = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    zzehn.zzfs(this.zzicd.zzbdv());
                } while (this.zzicd.zzbek() < zzbek);
                zzgl(zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzicd.zzbdv()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbek2 = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    list.add(Long.valueOf(this.zzicd.zzbdv()));
                } while (this.zzicd.zzbek() < zzbek2);
                zzgl(zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzo(List<Integer> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzegs) {
            zzegs zzegs = (zzegs) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzegs.zzhc(this.zzicd.zzbdw());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbek = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    zzegs.zzhc(this.zzicd.zzbdw());
                } while (this.zzicd.zzbek() < zzbek);
                zzgl(zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbdw()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbek2 = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbdw()));
                } while (this.zzicd.zzbek() < zzbek2);
                zzgl(zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzp(List<Long> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzehn) {
            zzehn zzehn = (zzehn) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzehn.zzfs(this.zzicd.zzbdx());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbec = this.zzicd.zzbec();
                zzgj(zzbec);
                int zzbek = this.zzicd.zzbek() + zzbec;
                do {
                    zzehn.zzfs(this.zzicd.zzbdx());
                } while (this.zzicd.zzbek() < zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzicd.zzbdx()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbec2 = this.zzicd.zzbec();
                zzgj(zzbec2);
                int zzbek2 = this.zzicd.zzbek() + zzbec2;
                do {
                    list.add(Long.valueOf(this.zzicd.zzbdx()));
                } while (this.zzicd.zzbek() < zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzq(List<Integer> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzegs) {
            zzegs zzegs = (zzegs) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbec = this.zzicd.zzbec();
                zzgk(zzbec);
                int zzbek = this.zzicd.zzbek() + zzbec;
                do {
                    zzegs.zzhc(this.zzicd.zzbdy());
                } while (this.zzicd.zzbek() < zzbek);
            } else if (i == 5) {
                do {
                    zzegs.zzhc(this.zzicd.zzbdy());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbec2 = this.zzicd.zzbec();
                zzgk(zzbec2);
                int zzbek2 = this.zzicd.zzbek() + zzbec2;
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbdy()));
                } while (this.zzicd.zzbek() < zzbek2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbdy()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzr(List<Boolean> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzefd) {
            zzefd zzefd = (zzefd) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzefd.addBoolean(this.zzicd.zzbdz());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbek = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    zzefd.addBoolean(this.zzicd.zzbdz());
                } while (this.zzicd.zzbek() < zzbek);
                zzgl(zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzicd.zzbdz()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbek2 = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    list.add(Boolean.valueOf(this.zzicd.zzbdz()));
                } while (this.zzicd.zzbek() < zzbek2);
                zzgl(zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzs(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzt(List<zzeff> list) throws IOException {
        int zzbdt;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzbeb());
                if (!this.zzicd.zzbej()) {
                    zzbdt = this.zzicd.zzbdt();
                } else {
                    return;
                }
            } while (zzbdt == this.tag);
            this.zzicf = zzbdt;
            return;
        }
        throw zzegz.zzbgg();
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzu(List<Integer> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzegs) {
            zzegs zzegs = (zzegs) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzegs.zzhc(this.zzicd.zzbec());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbek = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    zzegs.zzhc(this.zzicd.zzbec());
                } while (this.zzicd.zzbek() < zzbek);
                zzgl(zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbec()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbek2 = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbec()));
                } while (this.zzicd.zzbek() < zzbek2);
                zzgl(zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzv(List<Integer> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzegs) {
            zzegs zzegs = (zzegs) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzegs.zzhc(this.zzicd.zzbed());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbek = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    zzegs.zzhc(this.zzicd.zzbed());
                } while (this.zzicd.zzbek() < zzbek);
                zzgl(zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbed()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbek2 = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbed()));
                } while (this.zzicd.zzbek() < zzbek2);
                zzgl(zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzw(List<Integer> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzegs) {
            zzegs zzegs = (zzegs) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbec = this.zzicd.zzbec();
                zzgk(zzbec);
                int zzbek = this.zzicd.zzbek() + zzbec;
                do {
                    zzegs.zzhc(this.zzicd.zzbee());
                } while (this.zzicd.zzbek() < zzbek);
            } else if (i == 5) {
                do {
                    zzegs.zzhc(this.zzicd.zzbee());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbec2 = this.zzicd.zzbec();
                zzgk(zzbec2);
                int zzbek2 = this.zzicd.zzbek() + zzbec2;
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbee()));
                } while (this.zzicd.zzbek() < zzbek2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbee()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzx(List<Long> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzehn) {
            zzehn zzehn = (zzehn) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzehn.zzfs(this.zzicd.zzbef());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbec = this.zzicd.zzbec();
                zzgj(zzbec);
                int zzbek = this.zzicd.zzbek() + zzbec;
                do {
                    zzehn.zzfs(this.zzicd.zzbef());
                } while (this.zzicd.zzbek() < zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzicd.zzbef()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbec2 = this.zzicd.zzbec();
                zzgj(zzbec2);
                int zzbek2 = this.zzicd.zzbek() + zzbec2;
                do {
                    list.add(Long.valueOf(this.zzicd.zzbef()));
                } while (this.zzicd.zzbek() < zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzy(List<Integer> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzegs) {
            zzegs zzegs = (zzegs) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzegs.zzhc(this.zzicd.zzbeg());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbek = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    zzegs.zzhc(this.zzicd.zzbeg());
                } while (this.zzicd.zzbek() < zzbek);
                zzgl(zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbeg()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbek2 = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    list.add(Integer.valueOf(this.zzicd.zzbeg()));
                } while (this.zzicd.zzbek() < zzbek2);
                zzgl(zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final void zzz(List<Long> list) throws IOException {
        int zzbdt;
        int zzbdt2;
        if (list instanceof zzehn) {
            zzehn zzehn = (zzehn) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzehn.zzfs(this.zzicd.zzbeh());
                    if (!this.zzicd.zzbej()) {
                        zzbdt2 = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt2 == this.tag);
                this.zzicf = zzbdt2;
            } else if (i == 2) {
                int zzbek = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    zzehn.zzfs(this.zzicd.zzbeh());
                } while (this.zzicd.zzbek() < zzbek);
                zzgl(zzbek);
            } else {
                throw zzegz.zzbgg();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzicd.zzbeh()));
                    if (!this.zzicd.zzbej()) {
                        zzbdt = this.zzicd.zzbdt();
                    } else {
                        return;
                    }
                } while (zzbdt == this.tag);
                this.zzicf = zzbdt;
            } else if (i2 == 2) {
                int zzbek2 = this.zzicd.zzbek() + this.zzicd.zzbec();
                do {
                    list.add(Long.valueOf(this.zzicd.zzbeh()));
                } while (this.zzicd.zzbek() < zzbek2);
                zzgl(zzbek2);
            } else {
                throw zzegz.zzbgg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final <T> T zza(zzeiv<T> zzeiv, zzegc zzegc) throws IOException {
        zzgi(2);
        return (T) zzc(zzeiv, zzegc);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeip
    public final <T> void zzb(List<T> list, zzeiv<T> zzeiv, zzegc zzegc) throws IOException {
        int zzbdt;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzeiv, zzegc));
                if (!this.zzicd.zzbej() && this.zzicf == 0) {
                    zzbdt = this.zzicd.zzbdt();
                } else {
                    return;
                }
            } while (zzbdt == i);
            this.zzicf = zzbdt;
            return;
        }
        throw zzegz.zzbgg();
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzbdt;
        int zzbdt2;
        if ((this.tag & 7) != 2) {
            throw zzegz.zzbgg();
        } else if (!(list instanceof zzehk) || z) {
            do {
                list.add(z ? zzbea() : readString());
                if (!this.zzicd.zzbej()) {
                    zzbdt = this.zzicd.zzbdt();
                } else {
                    return;
                }
            } while (zzbdt == this.tag);
            this.zzicf = zzbdt;
        } else {
            zzehk zzehk = (zzehk) list;
            do {
                zzehk.zzaj(zzbeb());
                if (!this.zzicd.zzbej()) {
                    zzbdt2 = this.zzicd.zzbdt();
                } else {
                    return;
                }
            } while (zzbdt2 == this.tag);
            this.zzicf = zzbdt2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeip
    public final <T> void zza(List<T> list, zzeiv<T> zzeiv, zzegc zzegc) throws IOException {
        int zzbdt;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzeiv, zzegc));
                if (!this.zzicd.zzbej() && this.zzicf == 0) {
                    zzbdt = this.zzicd.zzbdt();
                } else {
                    return;
                }
            } while (zzbdt == i);
            this.zzicf = zzbdt;
            return;
        }
        throw zzegz.zzbgg();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeip
    public final <K, V> void zza(Map<K, V> map, zzehu<K, V> zzehu, zzegc zzegc) throws IOException {
        int zzber;
        zzgi(2);
        int zzga = this.zzicd.zzga(this.zzicd.zzbec());
        Object obj = zzehu.zzihv;
        Object obj2 = zzehu.zzckv;
        while (true) {
            try {
                zzber = zzber();
            } finally {
                this.zzicd.zzgb(zzga);
            }
            if (zzber == Integer.MAX_VALUE || this.zzicd.zzbej()) {
                break;
            } else if (zzber == 1) {
                obj = zza(zzehu.zzihu, (Class<?>) null, (zzegc) null);
            } else if (zzber != 2) {
                try {
                    if (!zzbes()) {
                        throw new zzegz("Unable to parse map entry.");
                    }
                } catch (zzehc unused) {
                    if (!zzbes()) {
                        throw new zzegz("Unable to parse map entry.");
                    }
                }
            } else {
                obj2 = zza(zzehu.zzihw, zzehu.zzckv.getClass(), zzegc);
            }
        }
        map.put(obj, obj2);
    }

    private final Object zza(zzeke zzeke, Class<?> cls, zzegc zzegc) throws IOException {
        switch (zzefw.zzicc[zzeke.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbdz());
            case 2:
                return zzbeb();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbed());
            case 5:
                return Integer.valueOf(zzbdy());
            case 6:
                return Long.valueOf(zzbdx());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbdw());
            case 9:
                return Long.valueOf(zzbdv());
            case 10:
                zzgi(2);
                return zzc(zzeio.zzbhg().zzh(cls), zzegc);
            case 11:
                return Integer.valueOf(zzbee());
            case 12:
                return Long.valueOf(zzbef());
            case 13:
                return Integer.valueOf(zzbeg());
            case 14:
                return Long.valueOf(zzbeh());
            case 15:
                return zzbea();
            case 16:
                return Integer.valueOf(zzbec());
            case 17:
                return Long.valueOf(zzbdu());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
