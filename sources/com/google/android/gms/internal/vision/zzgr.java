package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
public final class zzgr extends zzgp {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int tag;
    private final boolean zztq = true;
    private final int zztr;
    private int zzts;

    public zzgr(ByteBuffer byteBuffer, boolean z) {
        super(null);
        this.buffer = byteBuffer.array();
        int position = byteBuffer.position() + byteBuffer.arrayOffset();
        this.pos = position;
        this.zztr = position;
        this.limit = byteBuffer.limit() + byteBuffer.arrayOffset();
    }

    private final byte readByte() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzin.zzhh();
    }

    private final void zzao(int i) throws IOException {
        zzap(i);
        this.pos += i;
    }

    private final void zzap(int i) throws IOException {
        if (i < 0 || i > this.limit - this.pos) {
            throw zzin.zzhh();
        }
    }

    private final void zzaq(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzin.zzhm();
        }
    }

    private final void zzar(int i) throws IOException {
        zzap(i);
        if ((i & 7) != 0) {
            throw zzin.zzhn();
        }
    }

    private final void zzas(int i) throws IOException {
        zzap(i);
        if ((i & 3) != 0) {
            throw zzin.zzhn();
        }
    }

    private final void zzat(int i) throws IOException {
        if (this.pos != i) {
            throw zzin.zzhh();
        }
    }

    private final <T> T zzb(zzkf<T> zzkf, zzho zzho) throws IOException {
        int zzfe = zzfe();
        zzap(zzfe);
        int i = this.limit;
        int i2 = this.pos + zzfe;
        this.limit = i2;
        try {
            T newInstance = zzkf.newInstance();
            zzkf.zza(newInstance, this, zzho);
            zzkf.zzj(newInstance);
            if (this.pos == i2) {
                return newInstance;
            }
            throw zzin.zzhn();
        } finally {
            this.limit = i;
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

    private final boolean zzen() {
        return this.pos == this.limit;
    }

    private final int zzfe() throws IOException {
        int i;
        int i2 = this.pos;
        int i3 = this.limit;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i4;
                return b;
            } else if (i3 - i4 < 9) {
                return (int) zzfg();
            } else {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ -128;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << Ascii.SO);
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i9 < 0) {
                            i = i9 ^ -2080896;
                        } else {
                            i7 = i5 + 1;
                            byte b2 = bArr[i5];
                            i = (i9 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                i5 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            i7 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i7 + 1;
                                                if (bArr[i7] < 0) {
                                                    throw zzin.zzhj();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i7;
                }
                this.pos = i5;
                return i;
            }
        } else {
            throw zzin.zzhh();
        }
    }

    private final long zzff() throws IOException {
        long j;
        long j2;
        long j3;
        int i;
        int i2 = this.pos;
        int i3 = this.limit;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i4;
                return (long) b;
            } else if (i3 - i4 < 9) {
                return zzfg();
            } else {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ -128;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << Ascii.SO);
                    if (i8 >= 0) {
                        i5 = i7;
                        j = (long) (i8 ^ 16256);
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i9 < 0) {
                            i = i9 ^ -2080896;
                        } else {
                            long j4 = (long) i9;
                            int i10 = i5 + 1;
                            long j5 = j4 ^ (((long) bArr[i5]) << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                i5 = i10 + 1;
                                long j6 = j5 ^ (((long) bArr[i10]) << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i10 = i5 + 1;
                                    j5 = j6 ^ (((long) bArr[i5]) << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i5 = i10 + 1;
                                        j6 = j5 ^ (((long) bArr[i10]) << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i11 = i5 + 1;
                                            long j7 = (j6 ^ (((long) bArr[i5]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i5 = i11 + 1;
                                                if (((long) bArr[i11]) < 0) {
                                                    throw zzin.zzhj();
                                                }
                                            } else {
                                                i5 = i11;
                                            }
                                            j = j7;
                                        }
                                    }
                                }
                                j = j6 ^ j2;
                            }
                            j = j5 ^ j3;
                            i5 = i10;
                        }
                    }
                    this.pos = i5;
                    return j;
                }
                j = (long) i;
                this.pos = i5;
                return j;
            }
        } else {
            throw zzin.zzhh();
        }
    }

    private final long zzfg() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readByte = readByte();
            j |= ((long) (readByte & Byte.MAX_VALUE)) << i;
            if ((readByte & 128) == 0) {
                return j;
            }
        }
        throw zzin.zzhj();
    }

    private final int zzfh() throws IOException {
        zzap(4);
        return zzfj();
    }

    private final long zzfi() throws IOException {
        zzap(8);
        return zzfk();
    }

    private final int zzfj() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzfk() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final String zzj(boolean z) throws IOException {
        zzaq(2);
        int zzfe = zzfe();
        if (zzfe == 0) {
            return "";
        }
        zzap(zzfe);
        if (z) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            if (!zzlf.zzf(bArr, i, i + zzfe)) {
                throw zzin.zzho();
            }
        }
        String str = new String(this.buffer, this.pos, zzfe, zzie.UTF_8);
        this.pos += zzfe;
        return str;
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final double readDouble() throws IOException {
        zzaq(1);
        return Double.longBitsToDouble(zzfi());
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final float readFloat() throws IOException {
        zzaq(5);
        return Float.intBitsToFloat(zzfh());
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final String readString() throws IOException {
        return zzj(false);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> T zza(Class<T> cls, zzho zzho) throws IOException {
        zzaq(2);
        return (T) zzb(zzkb.zzik().zzf(cls), zzho);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> T zzc(zzkf<T> zzkf, zzho zzho) throws IOException {
        zzaq(3);
        return (T) zzd(zzkf, zzho);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zze(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzif.zzbs(zzes());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = this.pos + zzfe();
                while (this.pos < zzfe) {
                    zzif.zzbs(zzfe());
                }
                zzat(zzfe);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzes()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzfe2 = this.pos + zzfe();
                while (this.pos < zzfe2) {
                    list.add(Integer.valueOf(zzfe()));
                }
                zzat(zzfe2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzeo() throws IOException {
        if (zzen()) {
            return Integer.MAX_VALUE;
        }
        int zzfe = zzfe();
        this.tag = zzfe;
        if (zzfe == this.zzts) {
            return Integer.MAX_VALUE;
        }
        return zzfe >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final boolean zzep() throws IOException {
        int i;
        int i2;
        if (zzen() || (i = this.tag) == (i2 = this.zzts)) {
            return false;
        }
        int i3 = i & 7;
        if (i3 == 0) {
            int i4 = this.limit;
            int i5 = this.pos;
            if (i4 - i5 >= 10) {
                byte[] bArr = this.buffer;
                int i6 = 0;
                while (true) {
                    if (i6 >= 10) {
                        break;
                    }
                    int i7 = i5 + 1;
                    if (bArr[i5] >= 0) {
                        this.pos = i7;
                        break;
                    }
                    i6++;
                    i5 = i7;
                }
                return true;
            }
            for (int i8 = 0; i8 < 10; i8++) {
                if (readByte() >= 0) {
                    return true;
                }
            }
            throw zzin.zzhj();
        } else if (i3 == 1) {
            zzao(8);
            return true;
        } else if (i3 == 2) {
            zzao(zzfe());
            return true;
        } else if (i3 == 3) {
            this.zzts = ((i >>> 3) << 3) | 4;
            while (zzeo() != Integer.MAX_VALUE && zzep()) {
            }
            if (this.tag == this.zzts) {
                this.zzts = i2;
                return true;
            }
            throw zzin.zzhn();
        } else if (i3 == 5) {
            zzao(4);
            return true;
        } else {
            throw zzin.zzhm();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzeq() throws IOException {
        zzaq(0);
        return zzff();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzer() throws IOException {
        zzaq(0);
        return zzff();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzes() throws IOException {
        zzaq(0);
        return zzfe();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzet() throws IOException {
        zzaq(1);
        return zzfi();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzeu() throws IOException {
        zzaq(5);
        return zzfh();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final boolean zzev() throws IOException {
        zzaq(0);
        if (zzfe() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final String zzew() throws IOException {
        return zzj(true);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final zzgs zzex() throws IOException {
        zzgs zzgs;
        zzaq(2);
        int zzfe = zzfe();
        if (zzfe == 0) {
            return zzgs.zztt;
        }
        zzap(zzfe);
        if (this.zztq) {
            zzgs = zzgs.zzb(this.buffer, this.pos, zzfe);
        } else {
            zzgs = zzgs.zza(this.buffer, this.pos, zzfe);
        }
        this.pos += zzfe;
        return zzgs;
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzey() throws IOException {
        zzaq(0);
        return zzfe();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzez() throws IOException {
        zzaq(0);
        return zzfe();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzf(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzjb.zzac(zzet());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = zzfe();
                zzar(zzfe);
                int i4 = this.pos + zzfe;
                while (this.pos < i4) {
                    zzjb.zzac(zzfk());
                }
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzet()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzfe2 = zzfe();
                zzar(zzfe2);
                int i6 = this.pos + zzfe2;
                while (this.pos < i6) {
                    list.add(Long.valueOf(zzfk()));
                }
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzfa() throws IOException {
        zzaq(5);
        return zzfh();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzfb() throws IOException {
        zzaq(1);
        return zzfi();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final int zzfc() throws IOException {
        zzaq(0);
        return zzhe.zzbb(zzfe());
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final long zzfd() throws IOException {
        zzaq(0);
        return zzhe.zzr(zzff());
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzg(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzfe = zzfe();
                zzas(zzfe);
                int i4 = this.pos + zzfe;
                while (this.pos < i4) {
                    zzif.zzbs(zzfj());
                }
            } else if (i3 == 5) {
                do {
                    zzif.zzbs(zzeu());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzfe2 = zzfe();
                zzas(zzfe2);
                int i6 = this.pos + zzfe2;
                while (this.pos < i6) {
                    list.add(Integer.valueOf(zzfj()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzeu()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzh(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgq.addBoolean(zzev());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = this.pos + zzfe();
                while (this.pos < zzfe) {
                    zzgq.addBoolean(zzfe() != 0);
                }
                zzat(zzfe);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Boolean.valueOf(zzev()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzfe2 = this.pos + zzfe();
                while (this.pos < zzfe2) {
                    list.add(Boolean.valueOf(zzfe() != 0));
                }
                zzat(zzfe2);
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
    public final void zzk(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzif.zzbs(zzey());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = this.pos + zzfe();
                while (this.pos < zzfe) {
                    zzif.zzbs(zzfe());
                }
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzey()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzfe2 = this.pos + zzfe();
                while (this.pos < zzfe2) {
                    list.add(Integer.valueOf(zzfe()));
                }
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzl(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzif.zzbs(zzez());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = this.pos + zzfe();
                while (this.pos < zzfe) {
                    zzif.zzbs(zzfe());
                }
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzez()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzfe2 = this.pos + zzfe();
                while (this.pos < zzfe2) {
                    list.add(Integer.valueOf(zzfe()));
                }
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzm(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzfe = zzfe();
                zzas(zzfe);
                int i4 = this.pos + zzfe;
                while (this.pos < i4) {
                    zzif.zzbs(zzfj());
                }
            } else if (i3 == 5) {
                do {
                    zzif.zzbs(zzfa());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzfe2 = zzfe();
                zzas(zzfe2);
                int i6 = this.pos + zzfe2;
                while (this.pos < i6) {
                    list.add(Integer.valueOf(zzfj()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzfa()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzn(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzjb.zzac(zzfb());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = zzfe();
                zzar(zzfe);
                int i4 = this.pos + zzfe;
                while (this.pos < i4) {
                    zzjb.zzac(zzfk());
                }
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzfb()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzfe2 = zzfe();
                zzar(zzfe2);
                int i6 = this.pos + zzfe2;
                while (this.pos < i6) {
                    list.add(Long.valueOf(zzfk()));
                }
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzo(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzif) {
            zzif zzif = (zzif) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzif.zzbs(zzfc());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = this.pos + zzfe();
                while (this.pos < zzfe) {
                    zzif.zzbs(zzhe.zzbb(zzfe()));
                }
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzfc()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzfe2 = this.pos + zzfe();
                while (this.pos < zzfe2) {
                    list.add(Integer.valueOf(zzhe.zzbb(zzfe())));
                }
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzp(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzjb.zzac(zzfd());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = this.pos + zzfe();
                while (this.pos < zzfe) {
                    zzjb.zzac(zzhe.zzr(zzff()));
                }
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzfd()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzfe2 = this.pos + zzfe();
                while (this.pos < zzfe2) {
                    list.add(Long.valueOf(zzhe.zzr(zzff())));
                }
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
    public final void zzc(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzjb.zzac(zzeq());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = this.pos + zzfe();
                while (this.pos < zzfe) {
                    zzjb.zzac(zzff());
                }
                zzat(zzfe);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzeq()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzfe2 = this.pos + zzfe();
                while (this.pos < zzfe2) {
                    list.add(Long.valueOf(zzff()));
                }
                zzat(zzfe2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zza(List<Double> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhm) {
            zzhm zzhm = (zzhm) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzhm.zzc(readDouble());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = zzfe();
                zzar(zzfe);
                int i4 = this.pos + zzfe;
                while (this.pos < i4) {
                    zzhm.zzc(Double.longBitsToDouble(zzfk()));
                }
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Double.valueOf(readDouble()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzfe2 = zzfe();
                zzar(zzfe2);
                int i6 = this.pos + zzfe2;
                while (this.pos < i6) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzfk())));
                }
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzj(List<zzgs> list) throws IOException {
        int i;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzex());
                if (!zzen()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzfe() == this.tag);
            this.pos = i;
            return;
        }
        throw zzin.zzhm();
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzd(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjb) {
            zzjb zzjb = (zzjb) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzjb.zzac(zzer());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzfe = this.pos + zzfe();
                while (this.pos < zzfe) {
                    zzjb.zzac(zzff());
                }
                zzat(zzfe);
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzer()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzfe2 = this.pos + zzfe();
                while (this.pos < zzfe2) {
                    list.add(Long.valueOf(zzff()));
                }
                zzat(zzfe2);
            } else {
                throw zzin.zzhm();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> T zzb(Class<T> cls, zzho zzho) throws IOException {
        zzaq(3);
        return (T) zzd(zzkb.zzik().zzf(cls), zzho);
    }

    @Override // com.google.android.gms.internal.vision.zzkc
    public final void zzb(List<Float> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhz) {
            zzhz zzhz = (zzhz) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzfe = zzfe();
                zzas(zzfe);
                int i4 = this.pos + zzfe;
                while (this.pos < i4) {
                    zzhz.zzu(Float.intBitsToFloat(zzfj()));
                }
            } else if (i3 == 5) {
                do {
                    zzhz.zzu(readFloat());
                    if (!zzen()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i2;
            } else {
                throw zzin.zzhm();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzfe2 = zzfe();
                zzas(zzfe2);
                int i6 = this.pos + zzfe2;
                while (this.pos < i6) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzfj())));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (!zzen()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzfe() == this.tag);
                this.pos = i;
            } else {
                throw zzin.zzhm();
            }
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.tag & 7) != 2) {
            throw zzin.zzhm();
        } else if (!(list instanceof zziu) || z) {
            do {
                list.add(zzj(z));
                if (!zzen()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzfe() == this.tag);
            this.pos = i;
        } else {
            zziu zziu = (zziu) list;
            do {
                zziu.zzc(zzex());
                if (!zzen()) {
                    i2 = this.pos;
                } else {
                    return;
                }
            } while (zzfe() == this.tag);
            this.pos = i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> void zzb(List<T> list, zzkf<T> zzkf, zzho zzho) throws IOException {
        int i;
        int i2 = this.tag;
        if ((i2 & 7) == 3) {
            do {
                list.add(zzd(zzkf, zzho));
                if (!zzen()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzfe() == i2);
            this.pos = i;
            return;
        }
        throw zzin.zzhm();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzkc
    public final <T> void zza(List<T> list, zzkf<T> zzkf, zzho zzho) throws IOException {
        int i;
        int i2 = this.tag;
        if ((i2 & 7) == 2) {
            do {
                list.add(zzb(zzkf, zzho));
                if (!zzen()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzfe() == i2);
            this.pos = i;
            return;
        }
        throw zzin.zzhm();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzkc
    public final <K, V> void zza(Map<K, V> map, zzje<K, V> zzje, zzho zzho) throws IOException {
        zzaq(2);
        int zzfe = zzfe();
        zzap(zzfe);
        int i = this.limit;
        this.limit = this.pos + zzfe;
        try {
            Object obj = zzje.zzaad;
            Object obj2 = zzje.zzgk;
            while (true) {
                int zzeo = zzeo();
                if (zzeo == Integer.MAX_VALUE) {
                    map.put(obj, obj2);
                    return;
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
        } finally {
            this.limit = i;
        }
    }

    private final Object zza(zzlk zzlk, Class<?> cls, zzho zzho) throws IOException {
        switch (zzgo.zztn[zzlk.ordinal()]) {
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
                return zzj(true);
            case 16:
                return Integer.valueOf(zzey());
            case 17:
                return Long.valueOf(zzeq());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
