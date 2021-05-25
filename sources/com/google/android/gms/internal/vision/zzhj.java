package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;
public final class zzhj implements zzkc {
    private int tag;
    private int zzts;
    private final zzhe zzul;
    private int zzum = 0;

    private zzhj(zzhe zzhe) {
        zzhe zzhe2 = (zzhe) zzie.zza(zzhe, "input");
        this.zzul = zzhe2;
        zzhe2.zzue = this;
    }

    public static zzhj zza(zzhe zzhe) {
        zzhj zzhj = zzhe.zzue;
        if (zzhj != null) {
            return zzhj;
        }
        return new zzhj(zzhe);
    }

    private final void zzaq(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzin.zzhm();
        }
    }

    private static void zzar(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzin.zzhn();
        }
    }

    private static void zzas(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzin.zzhn();
        }
    }

    private final void zzat(int i) throws IOException {
        if (this.zzul.zzft() != i) {
            throw zzin.zzhh();
        }
    }

    private final <T> T zzd(zzkf<T> zzkf, zzho zzho) throws IOException {
        int i = this.zzts;
        this.zzts = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzkf.newInstance();
            zzkf.zza(newInstance, this, zzho);
            zzkf.zzj(newInstance);
            if (this.tag == this.zzts) {
                return newInstance;
            }
            throw zzin.zzhn();
        } finally {
            this.zzts = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final double readDouble() throws IOException {
        zzaq(1);
        return this.zzul.readDouble();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final float readFloat() throws IOException {
        zzaq(5);
        return this.zzul.readFloat();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final String readString() throws IOException {
        zzaq(2);
        return this.zzul.readString();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> T zzb(Class<T> cls, zzho zzho) throws IOException {
        zzaq(3);
        return (T) zzd(zzkb.zzik().zzf(cls), zzho);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> T zzc(zzkf<T> zzkf, zzho zzho) throws IOException {
        zzaq(3);
        return (T) zzd(zzkf, zzho);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zze(List<Integer> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzif.zzbs(this.zzul.zzes());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzft = this.zzul.zzft() + this.zzul.zzey();
                do {
                    zzif.zzbs(this.zzul.zzes());
                } while (this.zzul.zzft() < zzft);
                zzat(zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzul.zzes()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzft2 = this.zzul.zzft() + this.zzul.zzey();
                do {
                    list.add(Integer.valueOf(this.zzul.zzes()));
                } while (this.zzul.zzft() < zzft2);
                zzat(zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzeo() throws IOException {
        int i = this.zzum;
        if (i != 0) {
            this.tag = i;
            this.zzum = 0;
        } else {
            this.tag = this.zzul.zzfr();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzts) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final boolean zzep() throws IOException {
        int i;
        if (this.zzul.zzen() || (i = this.tag) == this.zzts) {
            return false;
        }
        return this.zzul.zzay(i);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzeq() throws IOException {
        zzaq(0);
        return this.zzul.zzeq();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzer() throws IOException {
        zzaq(0);
        return this.zzul.zzer();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzes() throws IOException {
        zzaq(0);
        return this.zzul.zzes();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzet() throws IOException {
        zzaq(1);
        return this.zzul.zzet();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzeu() throws IOException {
        zzaq(5);
        return this.zzul.zzeu();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final boolean zzev() throws IOException {
        zzaq(0);
        return this.zzul.zzev();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final String zzew() throws IOException {
        zzaq(2);
        return this.zzul.zzew();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final zzgs zzex() throws IOException {
        zzaq(2);
        return this.zzul.zzex();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzey() throws IOException {
        zzaq(0);
        return this.zzul.zzey();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzez() throws IOException {
        zzaq(0);
        return this.zzul.zzez();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzf(List<Long> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzjb.zzac(this.zzul.zzet());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzey = this.zzul.zzey();
                zzar(zzey);
                int zzft = this.zzul.zzft() + zzey;
                do {
                    zzjb.zzac(this.zzul.zzet());
                } while (this.zzul.zzft() < zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzul.zzet()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzey2 = this.zzul.zzey();
                zzar(zzey2);
                int zzft2 = this.zzul.zzft() + zzey2;
                do {
                    list.add(Long.valueOf(this.zzul.zzet()));
                } while (this.zzul.zzft() < zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzfa() throws IOException {
        zzaq(5);
        return this.zzul.zzfa();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzfb() throws IOException {
        zzaq(1);
        return this.zzul.zzfb();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzfc() throws IOException {
        zzaq(0);
        return this.zzul.zzfc();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzfd() throws IOException {
        zzaq(0);
        return this.zzul.zzfd();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzg(List<Integer> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzey = this.zzul.zzey();
                zzas(zzey);
                int zzft = this.zzul.zzft() + zzey;
                do {
                    zzif.zzbs(this.zzul.zzeu());
                } while (this.zzul.zzft() < zzft);
            } else if (i == 5) {
                do {
                    zzif.zzbs(this.zzul.zzeu());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzey2 = this.zzul.zzey();
                zzas(zzey2);
                int zzft2 = this.zzul.zzft() + zzey2;
                do {
                    list.add(Integer.valueOf(this.zzul.zzeu()));
                } while (this.zzul.zzft() < zzft2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzul.zzeu()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzh(List<Boolean> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgq.addBoolean(this.zzul.zzev());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzft = this.zzul.zzft() + this.zzul.zzey();
                do {
                    zzgq.addBoolean(this.zzul.zzev());
                } while (this.zzul.zzft() < zzft);
                zzat(zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzul.zzev()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzft2 = this.zzul.zzft() + this.zzul.zzey();
                do {
                    list.add(Boolean.valueOf(this.zzul.zzev()));
                } while (this.zzul.zzft() < zzft2);
                zzat(zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzj(List<zzgs> list) throws IOException {
        int zzfr;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzex());
                if (!this.zzul.zzen()) {
                    zzfr = this.zzul.zzfr();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zzum = zzfr;
            return;
        }
        throw zzin.zzhm();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzk(List<Integer> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzif.zzbs(this.zzul.zzey());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzft = this.zzul.zzft() + this.zzul.zzey();
                do {
                    zzif.zzbs(this.zzul.zzey());
                } while (this.zzul.zzft() < zzft);
                zzat(zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzul.zzey()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzft2 = this.zzul.zzft() + this.zzul.zzey();
                do {
                    list.add(Integer.valueOf(this.zzul.zzey()));
                } while (this.zzul.zzft() < zzft2);
                zzat(zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzl(List<Integer> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzif.zzbs(this.zzul.zzez());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzft = this.zzul.zzft() + this.zzul.zzey();
                do {
                    zzif.zzbs(this.zzul.zzez());
                } while (this.zzul.zzft() < zzft);
                zzat(zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzul.zzez()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzft2 = this.zzul.zzft() + this.zzul.zzey();
                do {
                    list.add(Integer.valueOf(this.zzul.zzez()));
                } while (this.zzul.zzft() < zzft2);
                zzat(zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzm(List<Integer> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzey = this.zzul.zzey();
                zzas(zzey);
                int zzft = this.zzul.zzft() + zzey;
                do {
                    zzif.zzbs(this.zzul.zzfa());
                } while (this.zzul.zzft() < zzft);
            } else if (i == 5) {
                do {
                    zzif.zzbs(this.zzul.zzfa());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzey2 = this.zzul.zzey();
                zzas(zzey2);
                int zzft2 = this.zzul.zzft() + zzey2;
                do {
                    list.add(Integer.valueOf(this.zzul.zzfa()));
                } while (this.zzul.zzft() < zzft2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzul.zzfa()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzn(List<Long> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzjb.zzac(this.zzul.zzfb());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzey = this.zzul.zzey();
                zzar(zzey);
                int zzft = this.zzul.zzft() + zzey;
                do {
                    zzjb.zzac(this.zzul.zzfb());
                } while (this.zzul.zzft() < zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzul.zzfb()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzey2 = this.zzul.zzey();
                zzar(zzey2);
                int zzft2 = this.zzul.zzft() + zzey2;
                do {
                    list.add(Long.valueOf(this.zzul.zzfb()));
                } while (this.zzul.zzft() < zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzo(List<Integer> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzif.zzbs(this.zzul.zzfc());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzft = this.zzul.zzft() + this.zzul.zzey();
                do {
                    zzif.zzbs(this.zzul.zzfc());
                } while (this.zzul.zzft() < zzft);
                zzat(zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzul.zzfc()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzft2 = this.zzul.zzft() + this.zzul.zzey();
                do {
                    list.add(Integer.valueOf(this.zzul.zzfc()));
                } while (this.zzul.zzft() < zzft2);
                zzat(zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzp(List<Long> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzjb.zzac(this.zzul.zzfd());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzft = this.zzul.zzft() + this.zzul.zzey();
                do {
                    zzjb.zzac(this.zzul.zzfd());
                } while (this.zzul.zzft() < zzft);
                zzat(zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzul.zzfd()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzft2 = this.zzul.zzft() + this.zzul.zzey();
                do {
                    list.add(Long.valueOf(this.zzul.zzfd()));
                } while (this.zzul.zzft() < zzft2);
                zzat(zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    private final <T> T zzb(zzkf<T> zzkf, zzho zzho) throws IOException {
        int zzey = this.zzul.zzey();
        zzhe zzhe = this.zzul;
        if (zzhe.zzub < zzhe.zzuc) {
            int zzaz = zzhe.zzaz(zzey);
            T newInstance = zzkf.newInstance();
            this.zzul.zzub++;
            zzkf.zza(newInstance, this, zzho);
            zzkf.zzj(newInstance);
            this.zzul.zzax(0);
            zzhe zzhe2 = this.zzul;
            zzhe2.zzub--;
            zzhe2.zzba(zzaz);
            return newInstance;
        }
        throw new zzin("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> T zza(Class<T> cls, zzho zzho) throws IOException {
        zzaq(2);
        return (T) zzb(zzkb.zzik().zzf(cls), zzho);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzc(List<Long> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzjb.zzac(this.zzul.zzeq());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzft = this.zzul.zzft() + this.zzul.zzey();
                do {
                    zzjb.zzac(this.zzul.zzeq());
                } while (this.zzul.zzft() < zzft);
                zzat(zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzul.zzeq()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzft2 = this.zzul.zzft() + this.zzul.zzey();
                do {
                    list.add(Long.valueOf(this.zzul.zzeq()));
                } while (this.zzul.zzft() < zzft2);
                zzat(zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> T zza(zzkf<T> zzkf, zzho zzho) throws IOException {
        zzaq(2);
        return (T) zzb(zzkf, zzho);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zza(List<Double> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzhm) {
            zzhm zzhm = (zzhm) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzhm.zzc(this.zzul.readDouble());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzey = this.zzul.zzey();
                zzar(zzey);
                int zzft = this.zzul.zzft() + zzey;
                do {
                    zzhm.zzc(this.zzul.readDouble());
                } while (this.zzul.zzft() < zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzul.readDouble()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzey2 = this.zzul.zzey();
                zzar(zzey2);
                int zzft2 = this.zzul.zzft() + zzey2;
                do {
                    list.add(Double.valueOf(this.zzul.readDouble()));
                } while (this.zzul.zzft() < zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzd(List<Long> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzjb.zzac(this.zzul.zzer());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else if (i == 2) {
                int zzft = this.zzul.zzft() + this.zzul.zzey();
                do {
                    zzjb.zzac(this.zzul.zzer());
                } while (this.zzul.zzft() < zzft);
                zzat(zzft);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzul.zzer()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else if (i2 == 2) {
                int zzft2 = this.zzul.zzft() + this.zzul.zzey();
                do {
                    list.add(Long.valueOf(this.zzul.zzer()));
                } while (this.zzul.zzft() < zzft2);
                zzat(zzft2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzb(List<Float> list) throws IOException {
        int zzfr;
        int zzfr2;
        if (list instanceof zzhz) {
            zzhz zzhz = (zzhz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzey = this.zzul.zzey();
                zzas(zzey);
                int zzft = this.zzul.zzft() + zzey;
                do {
                    zzhz.zzu(this.zzul.readFloat());
                } while (this.zzul.zzft() < zzft);
            } else if (i == 5) {
                do {
                    zzhz.zzu(this.zzul.readFloat());
                    if (!this.zzul.zzen()) {
                        zzfr2 = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr2 == this.tag);
                this.zzum = zzfr2;
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzey2 = this.zzul.zzey();
                zzas(zzey2);
                int zzft2 = this.zzul.zzft() + zzey2;
                do {
                    list.add(Float.valueOf(this.zzul.readFloat()));
                } while (this.zzul.zzft() < zzft2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzul.readFloat()));
                    if (!this.zzul.zzen()) {
                        zzfr = this.zzul.zzfr();
                    } else {
                        return;
                    }
                } while (zzfr == this.tag);
                this.zzum = zzfr;
            } else {
                throw zzin.zzhm();
            }
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzfr;
        int zzfr2;
        if ((this.tag & 7) != 2) {
            throw zzin.zzhm();
        } else if (!(list instanceof zziu) || z) {
            do {
                list.add(z ? zzew() : readString());
                if (!this.zzul.zzen()) {
                    zzfr = this.zzul.zzfr();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zzum = zzfr;
        } else {
            zziu zziu = (zziu) list;
            do {
                zziu.zzc(zzex());
                if (!this.zzul.zzen()) {
                    zzfr2 = this.zzul.zzfr();
                } else {
                    return;
                }
            } while (zzfr2 == this.tag);
            this.zzum = zzfr2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> void zzb(List<T> list, zzkf<T> zzkf, zzho zzho) throws IOException {
        int zzfr;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzkf, zzho));
                if (!this.zzul.zzen() && this.zzum == 0) {
                    zzfr = this.zzul.zzfr();
                } else {
                    return;
                }
            } while (zzfr == i);
            this.zzum = zzfr;
            return;
        }
        throw zzin.zzhm();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> void zza(List<T> list, zzkf<T> zzkf, zzho zzho) throws IOException {
        int zzfr;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzb(zzkf, zzho));
                if (!this.zzul.zzen() && this.zzum == 0) {
                    zzfr = this.zzul.zzfr();
                } else {
                    return;
                }
            } while (zzfr == i);
            this.zzum = zzfr;
            return;
        }
        throw zzin.zzhm();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzkc
    public final <K, V> void zza(Map<K, V> map, zzje<K, V> zzje, zzho zzho) throws IOException {
        int zzeo;
        zzaq(2);
        int zzaz = this.zzul.zzaz(this.zzul.zzey());
        Object obj = zzje.zzaad;
        Object obj2 = zzje.zzgk;
        while (true) {
            try {
                zzeo = zzeo();
            } finally {
                this.zzul.zzba(zzaz);
            }
            if (zzeo == Integer.MAX_VALUE || this.zzul.zzen()) {
                break;
            } else if (zzeo == 1) {
                obj = zza(zzje.zzaac, (Class<?>) null, (zzho) null);
            } else if (zzeo != 2) {
                try {
                    if (!zzep()) {
                        throw new zzin("Unable to parse map entry.");
                    }
                } catch (zzim unused) {
                    if (!zzep()) {
                        throw new zzin("Unable to parse map entry.");
                    }
                }
            } else {
                obj2 = zza(zzje.zzaae, zzje.zzgk.getClass(), zzho);
            }
        }
        map.put(obj, obj2);
    }

    private final Object zza(zzlk zzlk, Class<?> cls, zzho zzho) throws IOException {
        switch (zzhi.zztn[zzlk.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzev());
            case 2:
                return zzex();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzez());
            case 5:
                return Integer.valueOf(zzeu());
            case 6:
                return Long.valueOf(zzet());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzes());
            case 9:
                return Long.valueOf(zzer());
            case 10:
                return zza(cls, zzho);
            case 11:
                return Integer.valueOf(zzfa());
            case 12:
                return Long.valueOf(zzfb());
            case 13:
                return Integer.valueOf(zzfc());
            case 14:
                return Long.valueOf(zzfd());
            case 15:
                return zzew();
            case 16:
                return Integer.valueOf(zzey());
            case 17:
                return Long.valueOf(zzeq());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
