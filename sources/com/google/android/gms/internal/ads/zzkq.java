package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public final class zzkq {
    public int height;
    public int number;
    public int type;
    public int width;
    public zzjn zzahb;
    public int zzahf;
    public byte[] zzahg;
    public int zzahi;
    public int zzahj;
    private String zzahp;
    public String zzari;
    public int zzarj;
    public boolean zzark;
    public byte[] zzarl;
    public zzkf zzarm;
    public byte[] zzarn;
    public int zzaro;
    public int zzarp;
    public int zzarq;
    public boolean zzarr;
    public int zzars;
    public int zzart;
    public int zzaru;
    public int zzarv;
    public int zzarw;
    public float zzarx;
    public float zzary;
    public float zzarz;
    public float zzasa;
    public float zzasb;
    public float zzasc;
    public float zzasd;
    public float zzase;
    public float zzasf;
    public float zzasg;
    public int zzash;
    public long zzasi;
    public long zzasj;
    public boolean zzask;
    public boolean zzasl;
    public zzkg zzasm;
    public int zzasn;

    private zzkq() {
        this.width = -1;
        this.height = -1;
        this.zzaro = -1;
        this.zzarp = -1;
        this.zzarq = 0;
        this.zzahg = null;
        this.zzahf = -1;
        this.zzarr = false;
        this.zzars = -1;
        this.zzart = -1;
        this.zzaru = -1;
        this.zzarv = 1000;
        this.zzarw = 200;
        this.zzarx = -1.0f;
        this.zzary = -1.0f;
        this.zzarz = -1.0f;
        this.zzasa = -1.0f;
        this.zzasb = -1.0f;
        this.zzasc = -1.0f;
        this.zzasd = -1.0f;
        this.zzase = -1.0f;
        this.zzasf = -1.0f;
        this.zzasg = -1.0f;
        this.zzahi = 1;
        this.zzash = -1;
        this.zzahj = 8000;
        this.zzasi = 0;
        this.zzasj = 0;
        this.zzasl = true;
        this.zzahp = "eng";
    }

    private static boolean zzb(zzpk zzpk) throws zzhv {
        try {
            int zziz = zzpk.zziz();
            if (zziz == 1) {
                return true;
            }
            if (zziz == 65534) {
                zzpk.zzbo(24);
                if (zzpk.readLong() == zzkl.zzgt().getMostSignificantBits() && zzpk.readLong() == zzkl.zzgt().getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhv("Error parsing MS/ACM codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) throws zzhv {
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhv("Error parsing vorbis codec private");
                    }
                    throw new zzhv("Error parsing vorbis codec private");
                }
                throw new zzhv("Error parsing vorbis codec private");
            }
            throw new zzhv("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhv("Error parsing vorbis codec private");
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void zza(zzjx zzjx, int i) throws zzhv {
        char c;
        int i2;
        int i3;
        String str;
        ArrayList arrayList;
        zzho zzho;
        int i4;
        zzpr zzpr;
        byte[] bArr;
        int i5;
        int zzbr;
        List<byte[]> list;
        List<byte[]> list2;
        List<byte[]> list3;
        String str2 = this.zzari;
        str2.hashCode();
        int i6 = 1;
        switch (str2.hashCode()) {
            case -2095576542:
                if (str2.equals("V_MPEG4/ISO/AP")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -2095575984:
                if (str2.equals("V_MPEG4/ISO/SP")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1985379776:
                if (str2.equals("A_MS/ACM")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1784763192:
                if (str2.equals("A_TRUEHD")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1730367663:
                if (str2.equals("A_VORBIS")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1482641358:
                if (str2.equals("A_MPEG/L2")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1482641357:
                if (str2.equals("A_MPEG/L3")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1373388978:
                if (str2.equals("V_MS/VFW/FOURCC")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -933872740:
                if (str2.equals("S_DVBSUB")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -538363189:
                if (str2.equals("V_MPEG4/ISO/ASP")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -538363109:
                if (str2.equals("V_MPEG4/ISO/AVC")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -425012669:
                if (str2.equals("S_VOBSUB")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -356037306:
                if (str2.equals("A_DTS/LOSSLESS")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 62923557:
                if (str2.equals("A_AAC")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 62923603:
                if (str2.equals("A_AC3")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 62927045:
                if (str2.equals("A_DTS")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 82338133:
                if (str2.equals("V_VP8")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 82338134:
                if (str2.equals("V_VP9")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 99146302:
                if (str2.equals("S_HDMV/PGS")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 444813526:
                if (str2.equals("V_THEORA")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 542569478:
                if (str2.equals("A_DTS/EXPRESS")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 725957860:
                if (str2.equals("A_PCM/INT/LIT")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 855502857:
                if (str2.equals("V_MPEGH/ISO/HEVC")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1422270023:
                if (str2.equals("S_TEXT/UTF8")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1809237540:
                if (str2.equals("V_MPEG2")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 1950749482:
                if (str2.equals("A_EAC3")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 1950789798:
                if (str2.equals("A_FLAC")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 1951062397:
                if (str2.equals("A_OPUS")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        String str3 = MimeTypes.AUDIO_RAW;
        switch (c) {
            case 0:
            case 1:
            case '\t':
                str = MimeTypes.APPLICATION_PGS;
                byte[] bArr2 = this.zzarn;
                List<byte[]> singletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str3 = MimeTypes.VIDEO_MP4V;
                list2 = singletonList;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 2:
                str = MimeTypes.APPLICATION_PGS;
                if (zzb(new zzpk(this.zzarn))) {
                    zzbr = zzpq.zzbr(this.zzash);
                    if (zzbr == 0) {
                        MimeTypes.AUDIO_UNKNOWN.length();
                    }
                    i3 = zzbr;
                    list3 = null;
                    i2 = -1;
                    arrayList = list3;
                    break;
                } else if (MimeTypes.AUDIO_UNKNOWN.length() != 0) {
                    "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat(MimeTypes.AUDIO_UNKNOWN);
                } else {
                    new String("Non-PCM MS/ACM is unsupported. Setting mimeType to ");
                }
                str3 = MimeTypes.AUDIO_UNKNOWN;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
            case 3:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.AUDIO_TRUEHD;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 4:
                str = MimeTypes.APPLICATION_PGS;
                List<byte[]> zzd = zzd(this.zzarn);
                str3 = MimeTypes.AUDIO_VORBIS;
                i3 = -1;
                i2 = 8192;
                arrayList = zzd;
                break;
            case 5:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.AUDIO_MPEG_L2;
                arrayList = null;
                i3 = -1;
                i2 = 4096;
                break;
            case 6:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.AUDIO_MPEG;
                arrayList = null;
                i3 = -1;
                i2 = 4096;
                break;
            case 7:
                str = MimeTypes.APPLICATION_PGS;
                List<byte[]> zza = zza(new zzpk(this.zzarn));
                if (zza != null) {
                    str3 = MimeTypes.VIDEO_VC1;
                    list2 = zza;
                } else {
                    str3 = MimeTypes.VIDEO_UNKNOWN;
                    list2 = zza;
                }
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case '\b':
                str = MimeTypes.APPLICATION_PGS;
                byte[] bArr3 = this.zzarn;
                List<byte[]> singletonList2 = Collections.singletonList(new byte[]{bArr3[0], bArr3[1], bArr3[2], bArr3[3]});
                str3 = MimeTypes.APPLICATION_DVBSUBS;
                list2 = singletonList2;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case '\n':
                str = MimeTypes.APPLICATION_PGS;
                zzps zzg = zzps.zzg(new zzpk(this.zzarn));
                list = zzg.zzaha;
                this.zzasn = zzg.zzasn;
                str3 = MimeTypes.VIDEO_H264;
                list2 = list;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 11:
                str = MimeTypes.APPLICATION_PGS;
                List<byte[]> singletonList3 = Collections.singletonList(this.zzarn);
                str3 = MimeTypes.APPLICATION_VOBSUB;
                list2 = singletonList3;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case '\f':
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.AUDIO_DTS_HD;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case '\r':
                str = MimeTypes.APPLICATION_PGS;
                List<byte[]> singletonList4 = Collections.singletonList(this.zzarn);
                str3 = MimeTypes.AUDIO_AAC;
                list2 = singletonList4;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 14:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.AUDIO_AC3;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 15:
            case 20:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.AUDIO_DTS;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 16:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.VIDEO_VP8;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 17:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.VIDEO_VP9;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 18:
                str = MimeTypes.APPLICATION_PGS;
                list2 = null;
                str3 = str;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 19:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.VIDEO_UNKNOWN;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 21:
                str = MimeTypes.APPLICATION_PGS;
                zzbr = zzpq.zzbr(this.zzash);
                if (zzbr == 0) {
                    MimeTypes.AUDIO_UNKNOWN.length();
                    str3 = MimeTypes.AUDIO_UNKNOWN;
                    list2 = null;
                    i3 = -1;
                    list3 = list2;
                    i2 = -1;
                    arrayList = list3;
                    break;
                }
                i3 = zzbr;
                list3 = null;
                i2 = -1;
                arrayList = list3;
            case 22:
                str = MimeTypes.APPLICATION_PGS;
                zzpy zzi = zzpy.zzi(new zzpk(this.zzarn));
                list = zzi.zzaha;
                this.zzasn = zzi.zzasn;
                str3 = MimeTypes.VIDEO_H265;
                list2 = list;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 23:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.APPLICATION_SUBRIP;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 24:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.VIDEO_MPEG2;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 25:
                str = MimeTypes.APPLICATION_PGS;
                str3 = MimeTypes.AUDIO_E_AC3;
                list2 = null;
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 26:
                str = MimeTypes.APPLICATION_PGS;
                str3 = "audio/x-flac";
                list2 = Collections.singletonList(this.zzarn);
                i3 = -1;
                list3 = list2;
                i2 = -1;
                arrayList = list3;
                break;
            case 27:
                ArrayList arrayList2 = new ArrayList(3);
                arrayList2.add(this.zzarn);
                ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.nativeOrder());
                str = MimeTypes.APPLICATION_PGS;
                arrayList2.add(order.putLong(this.zzasi).array());
                arrayList2.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzasj).array());
                str3 = MimeTypes.AUDIO_OPUS;
                i3 = -1;
                i2 = 5760;
                arrayList = arrayList2;
                break;
            default:
                throw new zzhv("Unrecognized codec identifier.");
        }
        int i7 = (this.zzasl ? 1 : 0) | 0 | (this.zzask ? 2 : 0);
        if (zzpg.zzbf(str3)) {
            zzho = zzho.zza(Integer.toString(i), str3, null, -1, i2, this.zzahi, this.zzahj, i3, arrayList, this.zzahb, i7, this.zzahp);
        } else if (zzpg.zzbg(str3)) {
            if (this.zzarq == 0) {
                int i8 = this.zzaro;
                i4 = -1;
                if (i8 == -1) {
                    i8 = this.width;
                }
                this.zzaro = i8;
                int i9 = this.zzarp;
                if (i9 == -1) {
                    i9 = this.height;
                }
                this.zzarp = i9;
            } else {
                i4 = -1;
            }
            int i10 = this.zzaro;
            float f = (i10 == i4 || (i5 = this.zzarp) == i4) ? -1.0f : ((float) (this.height * i10)) / ((float) (this.width * i5));
            if (this.zzarr) {
                if (this.zzarx == -1.0f || this.zzary == -1.0f || this.zzarz == -1.0f || this.zzasa == -1.0f || this.zzasb == -1.0f || this.zzasc == -1.0f || this.zzasd == -1.0f || this.zzase == -1.0f || this.zzasf == -1.0f || this.zzasg == -1.0f) {
                    bArr = null;
                } else {
                    bArr = new byte[25];
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.put((byte) 0);
                    wrap.putShort((short) ((int) ((this.zzarx * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzary * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzarz * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzasa * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzasb * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzasc * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzasd * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzase * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) (this.zzasf + 0.5f)));
                    wrap.putShort((short) ((int) (this.zzasg + 0.5f)));
                    wrap.putShort((short) this.zzarv);
                    wrap.putShort((short) this.zzarw);
                }
                zzpr = new zzpr(this.zzars, this.zzaru, this.zzart, bArr);
            } else {
                zzpr = null;
            }
            zzho = zzho.zza(Integer.toString(i), str3, null, -1, i2, this.width, this.height, -1.0f, arrayList, -1, f, this.zzahg, this.zzahf, zzpr, this.zzahb);
            i6 = 2;
        } else {
            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                zzho = zzho.zza(Integer.toString(i), str3, (String) null, -1, i7, this.zzahp, this.zzahb);
            } else if (MimeTypes.APPLICATION_VOBSUB.equals(str3) || str.equals(str3) || MimeTypes.APPLICATION_DVBSUBS.equals(str3)) {
                zzho = zzho.zza(Integer.toString(i), str3, (String) null, -1, arrayList, this.zzahp, this.zzahb);
            } else {
                throw new zzhv("Unexpected MIME type.");
            }
            i6 = 3;
        }
        zzkg zzc = zzjx.zzc(this.number, i6);
        this.zzasm = zzc;
        zzc.zze(zzho);
    }

    public /* synthetic */ zzkq(zzko zzko) {
        this();
    }

    private static List<byte[]> zza(zzpk zzpk) throws zzhv {
        try {
            zzpk.zzbp(16);
            if (zzpk.zzjb() != 826496599) {
                return null;
            }
            byte[] bArr = zzpk.data;
            for (int position = zzpk.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhv("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhv("Error parsing FourCC VC1 codec private");
        }
    }
}
