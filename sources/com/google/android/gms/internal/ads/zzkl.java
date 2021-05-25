package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzjn;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
public final class zzkl implements zzjv {
    private static final zzka zzapf = new zzko();
    private static final byte[] zzapg = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzaph = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID zzapi = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaid;
    private final zzks zzaoz;
    private final zzkj zzapj;
    private final SparseArray<zzkq> zzapk;
    private final boolean zzapl;
    private final zzpk zzapm;
    private final zzpk zzapn;
    private final zzpk zzapo;
    private final zzpk zzapp;
    private final zzpk zzapq;
    private final zzpk zzapr;
    private final zzpk zzaps;
    private final zzpk zzapt;
    private final zzpk zzapu;
    private ByteBuffer zzapv;
    private long zzapw;
    private long zzapx;
    private long zzapy;
    private long zzapz;
    private zzkq zzaqa;
    private boolean zzaqb;
    private int zzaqc;
    private long zzaqd;
    private boolean zzaqe;
    private long zzaqf;
    private long zzaqg;
    private long zzaqh;
    private zzpe zzaqi;
    private zzpe zzaqj;
    private boolean zzaqk;
    private int zzaql;
    private long zzaqm;
    private long zzaqn;
    private int zzaqo;
    private int zzaqp;
    private int[] zzaqq;
    private int zzaqr;
    private int zzaqs;
    private int zzaqt;
    private int zzaqu;
    private boolean zzaqv;
    private boolean zzaqw;
    private boolean zzaqx;
    private boolean zzaqy;
    private byte zzaqz;
    private int zzara;
    private int zzarb;
    private int zzarc;
    private boolean zzard;
    private boolean zzare;
    private zzjx zzarf;

    public zzkl() {
        this(0);
    }

    public static int zzan(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    public static boolean zzao(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    private final void zzb(zzjy zzjy, int i) throws IOException, InterruptedException {
        if (this.zzapo.limit() < i) {
            if (this.zzapo.capacity() < i) {
                zzpk zzpk = this.zzapo;
                byte[] bArr = zzpk.data;
                zzpk.zzc(Arrays.copyOf(bArr, Math.max(bArr.length << 1, i)), this.zzapo.limit());
            }
            zzpk zzpk2 = this.zzapo;
            zzjy.readFully(zzpk2.data, zzpk2.limit(), i - this.zzapo.limit());
            this.zzapo.zzbn(i);
        }
    }

    private final long zzea(long j) throws zzhv {
        long j2 = this.zzapy;
        if (j2 != C.TIME_UNSET) {
            return zzpq.zza(j, j2, 1000);
        }
        throw new zzhv("Can't scale timecode prior to timecodeScale being set.");
    }

    private final void zzgs() {
        this.zzaqu = 0;
        this.zzarc = 0;
        this.zzarb = 0;
        this.zzaqv = false;
        this.zzaqw = false;
        this.zzaqy = false;
        this.zzara = 0;
        this.zzaqz = 0;
        this.zzaqx = false;
        this.zzapr.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final boolean zza(zzjy zzjy) throws IOException, InterruptedException {
        return new zzkp().zza(zzjy);
    }

    public final void zzap(int i) throws zzhv {
        zzke zzke;
        zzpe zzpe;
        zzpe zzpe2;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.zzaqa.zzari;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    zzkq zzkq = this.zzaqa;
                    zzkq.zza(this.zzarf, zzkq.number);
                    SparseArray<zzkq> sparseArray = this.zzapk;
                    zzkq zzkq2 = this.zzaqa;
                    sparseArray.put(zzkq2.number, zzkq2);
                }
                this.zzaqa = null;
            } else if (i == 19899) {
                int i4 = this.zzaqc;
                if (i4 != -1) {
                    long j = this.zzaqd;
                    if (j != -1) {
                        if (i4 == 475249515) {
                            this.zzaqf = j;
                            return;
                        }
                        return;
                    }
                }
                throw new zzhv("Mandatory element SeekID or SeekPosition not found");
            } else if (i == 25152) {
                zzkq zzkq3 = this.zzaqa;
                if (!zzkq3.zzark) {
                    return;
                }
                if (zzkq3.zzarm != null) {
                    zzkq3.zzahb = new zzjn(new zzjn.zza(zzha.UUID_NIL, MimeTypes.VIDEO_WEBM, this.zzaqa.zzarm.zzaow));
                    return;
                }
                throw new zzhv("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i == 28032) {
                zzkq zzkq4 = this.zzaqa;
                if (zzkq4.zzark && zzkq4.zzarl != null) {
                    throw new zzhv("Combining encryption and compression is not supported");
                }
            } else if (i == 357149030) {
                if (this.zzapy == C.TIME_UNSET) {
                    this.zzapy = 1000000;
                }
                long j2 = this.zzapz;
                if (j2 != C.TIME_UNSET) {
                    this.zzaid = zzea(j2);
                }
            } else if (i != 374648427) {
                if (i == 475249515 && !this.zzaqb) {
                    zzjx zzjx = this.zzarf;
                    if (this.zzapx == -1 || this.zzaid == C.TIME_UNSET || (zzpe = this.zzaqi) == null || zzpe.size() == 0 || (zzpe2 = this.zzaqj) == null || zzpe2.size() != this.zzaqi.size()) {
                        this.zzaqi = null;
                        this.zzaqj = null;
                        zzke = new zzkd(this.zzaid);
                    } else {
                        int size = this.zzaqi.size();
                        int[] iArr = new int[size];
                        long[] jArr = new long[size];
                        long[] jArr2 = new long[size];
                        long[] jArr3 = new long[size];
                        for (int i5 = 0; i5 < size; i5++) {
                            jArr3[i5] = this.zzaqi.get(i5);
                            jArr[i5] = this.zzaqj.get(i5) + this.zzapx;
                        }
                        while (true) {
                            i2 = size - 1;
                            if (i3 >= i2) {
                                break;
                            }
                            int i6 = i3 + 1;
                            iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                            jArr2[i3] = jArr3[i6] - jArr3[i3];
                            i3 = i6;
                        }
                        iArr[i2] = (int) ((this.zzapx + this.zzapw) - jArr[i2]);
                        jArr2[i2] = this.zzaid - jArr3[i2];
                        this.zzaqi = null;
                        this.zzaqj = null;
                        zzke = new zzjt(iArr, jArr, jArr2, jArr3);
                    }
                    zzjx.zza(zzke);
                    this.zzaqb = true;
                }
            } else if (this.zzapk.size() != 0) {
                this.zzarf.zzgp();
            } else {
                throw new zzhv("No valid tracks were found");
            }
        } else if (this.zzaql == 2) {
            if (!this.zzare) {
                this.zzaqt |= 1;
            }
            zza(this.zzapk.get(this.zzaqr), this.zzaqm);
            this.zzaql = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzc(long j, long j2) {
        this.zzaqh = C.TIME_UNSET;
        this.zzaql = 0;
        this.zzapj.reset();
        this.zzaoz.reset();
        zzgs();
    }

    public final void zzd(int i, long j, long j2) throws zzhv {
        if (i == 160) {
            this.zzare = false;
        } else if (i == 174) {
            this.zzaqa = new zzkq(null);
        } else if (i == 187) {
            this.zzaqk = false;
        } else if (i == 19899) {
            this.zzaqc = -1;
            this.zzaqd = -1;
        } else if (i == 20533) {
            this.zzaqa.zzark = true;
        } else if (i == 21968) {
            this.zzaqa.zzarr = true;
        } else if (i == 408125543) {
            long j3 = this.zzapx;
            if (j3 == -1 || j3 == j) {
                this.zzapx = j;
                this.zzapw = j2;
                return;
            }
            throw new zzhv("Multiple Segment elements not supported");
        } else if (i == 475249515) {
            this.zzaqi = new zzpe();
            this.zzaqj = new zzpe();
        } else if (i != 524531317 || this.zzaqb) {
        } else {
            if (!this.zzapl || this.zzaqf == -1) {
                this.zzarf.zza(new zzkd(this.zzaid));
                this.zzaqb = true;
                return;
            }
            this.zzaqe = true;
        }
    }

    private zzkl(int i) {
        this(new zzki(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zza(zzjx zzjx) {
        this.zzarf = zzjx;
    }

    private zzkl(zzkj zzkj, int i) {
        this.zzapx = -1;
        this.zzapy = C.TIME_UNSET;
        this.zzapz = C.TIME_UNSET;
        this.zzaid = C.TIME_UNSET;
        this.zzaqf = -1;
        this.zzaqg = -1;
        this.zzaqh = C.TIME_UNSET;
        this.zzapj = zzkj;
        zzkj.zza(new zzkn(this, null));
        this.zzapl = true;
        this.zzaoz = new zzks();
        this.zzapk = new SparseArray<>();
        this.zzapo = new zzpk(4);
        this.zzapp = new zzpk(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzapq = new zzpk(4);
        this.zzapm = new zzpk(zzpf.zzbjn);
        this.zzapn = new zzpk(4);
        this.zzapr = new zzpk();
        this.zzaps = new zzpk();
        this.zzapt = new zzpk(8);
        this.zzapu = new zzpk();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjv
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjy r9, com.google.android.gms.internal.ads.zzkb r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            r0 = 0
            r8.zzard = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003a
            boolean r3 = r8.zzard
            if (r3 != 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzkj r2 = r8.zzapj
            boolean r2 = r2.zzb(r9)
            if (r2 == 0) goto L_0x0005
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaqe
            if (r5 == 0) goto L_0x0025
            r8.zzaqg = r3
            long r3 = r8.zzaqf
            r10.position = r3
            r8.zzaqe = r0
        L_0x0023:
            r3 = 1
            goto L_0x0037
        L_0x0025:
            boolean r3 = r8.zzaqb
            if (r3 == 0) goto L_0x0036
            long r3 = r8.zzaqg
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            r10.position = r3
            r8.zzaqg = r5
            goto L_0x0023
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003a:
            if (r2 == 0) goto L_0x003d
            return r0
        L_0x003d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkl.zza(com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzkb):int");
    }

    public final void zzc(int i, long j) throws zzhv {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        this.zzaqa.type = (int) j;
                        return;
                    case 136:
                        zzkq zzkq = this.zzaqa;
                        if (j == 1) {
                            z = true;
                        }
                        zzkq.zzask = z;
                        return;
                    case 155:
                        this.zzaqn = zzea(j);
                        return;
                    case 159:
                        this.zzaqa.zzahi = (int) j;
                        return;
                    case 176:
                        this.zzaqa.width = (int) j;
                        return;
                    case 179:
                        this.zzaqi.add(zzea(j));
                        return;
                    case 186:
                        this.zzaqa.height = (int) j;
                        return;
                    case 215:
                        this.zzaqa.number = (int) j;
                        return;
                    case 231:
                        this.zzaqh = zzea(j);
                        return;
                    case 241:
                        if (!this.zzaqk) {
                            this.zzaqj.add(j);
                            this.zzaqk = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzare = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(" not supported");
                            throw new zzhv(sb.toString());
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(" not supported");
                            throw new zzhv(sb2.toString());
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(" not supported");
                            throw new zzhv(sb3.toString());
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(" not supported");
                            throw new zzhv(sb4.toString());
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(" not supported");
                            throw new zzhv(sb5.toString());
                        }
                        return;
                    case 21420:
                        this.zzaqd = j + this.zzapx;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.zzaqa.zzahf = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzaqa.zzahf = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzaqa.zzahf = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzaqa.zzahf = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.zzaqa.zzaro = (int) j;
                        return;
                    case 21682:
                        this.zzaqa.zzarq = (int) j;
                        return;
                    case 21690:
                        this.zzaqa.zzarp = (int) j;
                        return;
                    case 21930:
                        zzkq zzkq2 = this.zzaqa;
                        if (j == 1) {
                            z = true;
                        }
                        zzkq2.zzasl = z;
                        return;
                    case 22186:
                        this.zzaqa.zzasi = j;
                        return;
                    case 22203:
                        this.zzaqa.zzasj = j;
                        return;
                    case 25188:
                        this.zzaqa.zzash = (int) j;
                        return;
                    case 2352003:
                        this.zzaqa.zzarj = (int) j;
                        return;
                    case 2807729:
                        this.zzapy = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.zzaqa.zzaru = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.zzaqa.zzaru = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.zzaqa.zzart = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.zzaqa.zzart = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.zzaqa.zzart = 3;
                                return;
                            case 21947:
                                zzkq zzkq3 = this.zzaqa;
                                zzkq3.zzarr = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    zzkq3.zzars = 1;
                                    return;
                                } else if (i5 == 9) {
                                    zzkq3.zzars = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    zzkq3.zzars = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.zzaqa.zzarv = (int) j;
                                return;
                            case 21949:
                                this.zzaqa.zzarw = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzhv(sb6.toString());
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(" not supported");
            throw new zzhv(sb7.toString());
        }
    }

    public final void zza(int i, double d) {
        if (i == 181) {
            this.zzaqa.zzahj = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzaqa.zzarx = (float) d;
                    return;
                case 21970:
                    this.zzaqa.zzary = (float) d;
                    return;
                case 21971:
                    this.zzaqa.zzarz = (float) d;
                    return;
                case 21972:
                    this.zzaqa.zzasa = (float) d;
                    return;
                case 21973:
                    this.zzaqa.zzasb = (float) d;
                    return;
                case 21974:
                    this.zzaqa.zzasc = (float) d;
                    return;
                case 21975:
                    this.zzaqa.zzasd = (float) d;
                    return;
                case 21976:
                    this.zzaqa.zzase = (float) d;
                    return;
                case 21977:
                    this.zzaqa.zzasf = (float) d;
                    return;
                case 21978:
                    this.zzaqa.zzasg = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.zzapz = (long) d;
        }
    }

    public final void zza(int i, String str) throws zzhv {
        if (i == 134) {
            this.zzaqa.zzari = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                this.zzaqa.zzahp = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new zzhv(a.s2(a.q0(str, 22), "DocType ", str, " not supported"));
        }
    }

    public final void zza(int i, int i2, zzjy zzjy) throws IOException, InterruptedException {
        int i3;
        int i4;
        int i5;
        int[] iArr;
        int i6 = 0;
        int i7 = 1;
        if (i == 161 || i == 163) {
            int i8 = 8;
            if (this.zzaql == 0) {
                this.zzaqr = (int) this.zzaoz.zza(zzjy, false, true, 8);
                this.zzaqs = this.zzaoz.zzgu();
                this.zzaqn = C.TIME_UNSET;
                this.zzaql = 1;
                this.zzapo.reset();
            }
            zzkq zzkq = this.zzapk.get(this.zzaqr);
            if (zzkq == null) {
                zzjy.zzai(i2 - this.zzaqs);
                this.zzaql = 0;
                return;
            }
            if (this.zzaql == 1) {
                zzb(zzjy, 3);
                int i9 = (this.zzapo.data[2] & 6) >> 1;
                byte b = 255;
                if (i9 == 0) {
                    this.zzaqp = 1;
                    int[] zza = zza(this.zzaqq, 1);
                    this.zzaqq = zza;
                    zza[0] = (i2 - this.zzaqs) - 3;
                } else if (i == 163) {
                    int i10 = 4;
                    zzb(zzjy, 4);
                    int i11 = (this.zzapo.data[3] & 255) + 1;
                    this.zzaqp = i11;
                    int[] zza2 = zza(this.zzaqq, i11);
                    this.zzaqq = zza2;
                    if (i9 == 2) {
                        int i12 = this.zzaqp;
                        Arrays.fill(zza2, 0, i12, ((i2 - this.zzaqs) - 4) / i12);
                    } else if (i9 == 1) {
                        int i13 = 0;
                        int i14 = 0;
                        while (true) {
                            i4 = this.zzaqp;
                            if (i13 >= i4 - 1) {
                                break;
                            }
                            this.zzaqq[i13] = 0;
                            do {
                                i10++;
                                zzb(zzjy, i10);
                                i5 = this.zzapo.data[i10 - 1] & 255;
                                iArr = this.zzaqq;
                                iArr[i13] = iArr[i13] + i5;
                            } while (i5 == 255);
                            i14 += iArr[i13];
                            i13++;
                        }
                        this.zzaqq[i4 - 1] = ((i2 - this.zzaqs) - i10) - i14;
                    } else if (i9 == 3) {
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            int i17 = this.zzaqp;
                            if (i15 >= i17 - 1) {
                                this.zzaqq[i17 - 1] = ((i2 - this.zzaqs) - i10) - i16;
                                break;
                            }
                            this.zzaqq[i15] = i6;
                            i10++;
                            zzb(zzjy, i10);
                            int i18 = i10 - 1;
                            if (this.zzapo.data[i18] != 0) {
                                long j = 0;
                                int i19 = 0;
                                while (true) {
                                    if (i19 >= i8) {
                                        i3 = i15;
                                        break;
                                    }
                                    int i20 = i7 << (7 - i19);
                                    if ((this.zzapo.data[i18] & i20) != 0) {
                                        i10 += i19;
                                        zzb(zzjy, i10);
                                        i3 = i15;
                                        long j2 = (long) ((~i20) & this.zzapo.data[i18] & b);
                                        j = j2;
                                        for (int i21 = i18 + 1; i21 < i10; i21++) {
                                            j = (j << 8) | ((long) (this.zzapo.data[i21] & b));
                                            b = 255;
                                        }
                                        if (i3 > 0) {
                                            j -= (1 << ((i19 * 7) + 6)) - 1;
                                        }
                                    } else {
                                        i19++;
                                        i7 = 1;
                                        b = 255;
                                        i8 = 8;
                                    }
                                }
                                if (j < -2147483648L || j > 2147483647L) {
                                    break;
                                }
                                int i22 = (int) j;
                                int[] iArr2 = this.zzaqq;
                                if (i3 != 0) {
                                    i22 += iArr2[i3 - 1];
                                }
                                iArr2[i3] = i22;
                                i16 += iArr2[i3];
                                i15 = i3 + 1;
                                i6 = 0;
                                i7 = 1;
                                b = 255;
                                i8 = 8;
                            } else {
                                throw new zzhv("No valid varint length mask found");
                            }
                        }
                        throw new zzhv("EBML lacing sample size out of range.");
                    } else {
                        throw new zzhv(a.m2(36, "Unexpected lacing value: ", i9));
                    }
                } else {
                    throw new zzhv("Lacing only supported in SimpleBlocks.");
                }
                byte[] bArr = this.zzapo.data;
                this.zzaqm = this.zzaqh + zzea((long) ((bArr[1] & 255) | (bArr[0] << 8)));
                byte[] bArr2 = this.zzapo.data;
                this.zzaqt = ((zzkq.type == 2 || (i == 163 && (bArr2[2] & 128) == 128)) ? 1 : 0) | ((bArr2[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
                this.zzaql = 2;
                this.zzaqo = 0;
            }
            if (i == 163) {
                while (true) {
                    int i23 = this.zzaqo;
                    if (i23 < this.zzaqp) {
                        zza(zzjy, zzkq, this.zzaqq[i23]);
                        zza(zzkq, this.zzaqm + ((long) ((this.zzaqo * zzkq.zzarj) / 1000)));
                        this.zzaqo++;
                    } else {
                        this.zzaql = 0;
                        return;
                    }
                }
            } else {
                zza(zzjy, zzkq, this.zzaqq[0]);
            }
        } else if (i == 16981) {
            byte[] bArr3 = new byte[i2];
            this.zzaqa.zzarl = bArr3;
            zzjy.readFully(bArr3, 0, i2);
        } else if (i == 18402) {
            byte[] bArr4 = new byte[i2];
            zzjy.readFully(bArr4, 0, i2);
            this.zzaqa.zzarm = new zzkf(1, bArr4);
        } else if (i == 21419) {
            Arrays.fill(this.zzapq.data, (byte) 0);
            zzjy.readFully(this.zzapq.data, 4 - i2, i2);
            this.zzapq.zzbo(0);
            this.zzaqc = (int) this.zzapq.zzja();
        } else if (i == 25506) {
            byte[] bArr5 = new byte[i2];
            this.zzaqa.zzarn = bArr5;
            zzjy.readFully(bArr5, 0, i2);
        } else if (i == 30322) {
            byte[] bArr6 = new byte[i2];
            this.zzaqa.zzahg = bArr6;
            zzjy.readFully(bArr6, 0, i2);
        } else {
            throw new zzhv(a.m2(26, "Unexpected id: ", i));
        }
    }

    private final void zza(zzkq zzkq, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzkq.zzari)) {
            byte[] bArr2 = this.zzaps.data;
            long j2 = this.zzaqn;
            if (j2 == C.TIME_UNSET) {
                bArr = zzaph;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzpq.zzbk(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzkg zzkg = zzkq.zzasm;
            zzpk zzpk = this.zzaps;
            zzkg.zza(zzpk, zzpk.limit());
            this.zzarc = this.zzaps.limit() + this.zzarc;
        }
        zzkq.zzasm.zza(j, this.zzaqt, this.zzarc, 0, zzkq.zzarm);
        this.zzard = true;
        zzgs();
    }

    private final void zza(zzjy zzjy, zzkq zzkq, int i) throws IOException, InterruptedException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzkq.zzari)) {
            byte[] bArr = zzapg;
            int length = bArr.length + i;
            if (this.zzaps.capacity() < length) {
                this.zzaps.data = Arrays.copyOf(bArr, length + i);
            }
            zzjy.readFully(this.zzaps.data, bArr.length, i);
            this.zzaps.zzbo(0);
            this.zzaps.zzbn(length);
            return;
        }
        zzkg zzkg = zzkq.zzasm;
        if (!this.zzaqv) {
            if (zzkq.zzark) {
                this.zzaqt &= -1073741825;
                int i3 = 128;
                if (!this.zzaqw) {
                    zzjy.readFully(this.zzapo.data, 0, 1);
                    this.zzaqu++;
                    byte[] bArr2 = this.zzapo.data;
                    if ((bArr2[0] & 128) != 128) {
                        this.zzaqz = bArr2[0];
                        this.zzaqw = true;
                    } else {
                        throw new zzhv("Extension bit is set in signal byte");
                    }
                }
                byte b = this.zzaqz;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.zzaqt |= 1073741824;
                    if (!this.zzaqx) {
                        zzjy.readFully(this.zzapt.data, 0, 8);
                        this.zzaqu += 8;
                        this.zzaqx = true;
                        zzpk zzpk = this.zzapo;
                        byte[] bArr3 = zzpk.data;
                        if (!z) {
                            i3 = 0;
                        }
                        bArr3[0] = (byte) (i3 | 8);
                        zzpk.zzbo(0);
                        zzkg.zza(this.zzapo, 1);
                        this.zzarc++;
                        this.zzapt.zzbo(0);
                        zzkg.zza(this.zzapt, 8);
                        this.zzarc += 8;
                    }
                    if (z) {
                        if (!this.zzaqy) {
                            zzjy.readFully(this.zzapo.data, 0, 1);
                            this.zzaqu++;
                            this.zzapo.zzbo(0);
                            this.zzara = this.zzapo.readUnsignedByte();
                            this.zzaqy = true;
                        }
                        int i4 = this.zzara << 2;
                        this.zzapo.reset(i4);
                        zzjy.readFully(this.zzapo.data, 0, i4);
                        this.zzaqu += i4;
                        short s = (short) ((this.zzara / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzapv;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.zzapv = ByteBuffer.allocate(i5);
                        }
                        this.zzapv.position(0);
                        this.zzapv.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.zzara;
                            if (i6 >= i2) {
                                break;
                            }
                            int zzjd = this.zzapo.zzjd();
                            if (i6 % 2 == 0) {
                                this.zzapv.putShort((short) (zzjd - i7));
                            } else {
                                this.zzapv.putInt(zzjd - i7);
                            }
                            i6++;
                            i7 = zzjd;
                        }
                        int i8 = (i - this.zzaqu) - i7;
                        if (i2 % 2 == 1) {
                            this.zzapv.putInt(i8);
                        } else {
                            this.zzapv.putShort((short) i8);
                            this.zzapv.putInt(0);
                        }
                        this.zzapu.zzc(this.zzapv.array(), i5);
                        zzkg.zza(this.zzapu, i5);
                        this.zzarc += i5;
                    }
                }
            } else {
                byte[] bArr4 = zzkq.zzarl;
                if (bArr4 != null) {
                    this.zzapr.zzc(bArr4, bArr4.length);
                }
            }
            this.zzaqv = true;
        }
        int limit = this.zzapr.limit() + i;
        if (!"V_MPEG4/ISO/AVC".equals(zzkq.zzari) && !"V_MPEGH/ISO/HEVC".equals(zzkq.zzari)) {
            while (true) {
                int i9 = this.zzaqu;
                if (i9 >= limit) {
                    break;
                }
                zza(zzjy, zzkg, limit - i9);
            }
        } else {
            byte[] bArr5 = this.zzapn.data;
            bArr5[0] = 0;
            bArr5[1] = 0;
            bArr5[2] = 0;
            int i10 = zzkq.zzasn;
            int i11 = 4 - i10;
            while (this.zzaqu < limit) {
                int i12 = this.zzarb;
                if (i12 == 0) {
                    int min = Math.min(i10, this.zzapr.zziy());
                    zzjy.readFully(bArr5, i11 + min, i10 - min);
                    if (min > 0) {
                        this.zzapr.zze(bArr5, i11, min);
                    }
                    this.zzaqu += i10;
                    this.zzapn.zzbo(0);
                    this.zzarb = this.zzapn.zzjd();
                    this.zzapm.zzbo(0);
                    zzkg.zza(this.zzapm, 4);
                    this.zzarc += 4;
                } else {
                    this.zzarb = i12 - zza(zzjy, zzkg, i12);
                }
            }
        }
        if ("A_VORBIS".equals(zzkq.zzari)) {
            this.zzapp.zzbo(0);
            zzkg.zza(this.zzapp, 4);
            this.zzarc += 4;
        }
    }

    private final int zza(zzjy zzjy, zzkg zzkg, int i) throws IOException, InterruptedException {
        int i2;
        int zziy = this.zzapr.zziy();
        if (zziy > 0) {
            i2 = Math.min(i, zziy);
            zzkg.zza(this.zzapr, i2);
        } else {
            i2 = zzkg.zza(zzjy, i, false);
        }
        this.zzaqu += i2;
        this.zzarc += i2;
        return i2;
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length << 1, i)];
    }
}
