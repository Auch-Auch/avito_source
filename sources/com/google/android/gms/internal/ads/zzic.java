package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
public final class zzic {
    private static final int[] zzaig = {1, 2, 3, 6};
    private static final int[] zzaih = {OpusUtil.SAMPLE_RATE, 44100, 32000};
    private static final int[] zzaii = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};
    private static final int[] zzaij = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzaik = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzail = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzho zza(zzpk zzpk, String str, String str2, zzjn zzjn) {
        int i = zzaih[(zzpk.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpk.readUnsignedByte();
        int i2 = zzaij[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzho.zza(str, MimeTypes.AUDIO_AC3, null, -1, -1, i2, i, null, zzjn, 0, str2);
    }

    public static zzho zzb(zzpk zzpk, String str, String str2, zzjn zzjn) {
        zzpk.zzbp(2);
        int i = zzaih[(zzpk.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpk.readUnsignedByte();
        int i2 = zzaij[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzho.zza(str, MimeTypes.AUDIO_E_AC3, null, -1, -1, i2, i, null, zzjn, 0, str2);
    }

    public static int zzfg() {
        return 1536;
    }

    public static int zzm(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzaig[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
