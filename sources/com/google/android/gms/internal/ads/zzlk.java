package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.common.net.HttpHeaders;
public final class zzlk {
    private static final int zzayt = zzpq.zzbl("nam");
    private static final int zzayu = zzpq.zzbl("trk");
    private static final int zzayv = zzpq.zzbl("cmt");
    private static final int zzayw = zzpq.zzbl("day");
    private static final int zzayx = zzpq.zzbl("ART");
    private static final int zzayy = zzpq.zzbl("too");
    private static final int zzayz = zzpq.zzbl("alb");
    private static final int zzaza = zzpq.zzbl("com");
    private static final int zzazb = zzpq.zzbl("wrt");
    private static final int zzazc = zzpq.zzbl("lyr");
    private static final int zzazd = zzpq.zzbl("gen");
    private static final int zzaze = zzpq.zzbl("covr");
    private static final int zzazf = zzpq.zzbl("gnre");
    private static final int zzazg = zzpq.zzbl("grp");
    private static final int zzazh = zzpq.zzbl("disk");
    private static final int zzazi = zzpq.zzbl("trkn");
    private static final int zzazj = zzpq.zzbl("tmpo");
    private static final int zzazk = zzpq.zzbl("cpil");
    private static final int zzazl = zzpq.zzbl("aART");
    private static final int zzazm = zzpq.zzbl("sonm");
    private static final int zzazn = zzpq.zzbl("soal");
    private static final int zzazo = zzpq.zzbl("soar");
    private static final int zzazp = zzpq.zzbl("soaa");
    private static final int zzazq = zzpq.zzbl("soco");
    private static final int zzazr = zzpq.zzbl("rtng");
    private static final int zzazs = zzpq.zzbl("pgap");
    private static final int zzazt = zzpq.zzbl("sosn");
    private static final int zzazu = zzpq.zzbl("tvsh");
    private static final int zzazv = zzpq.zzbl(InternalFrame.ID);
    private static final String[] zzazw = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzmm zza(int i, String str, zzpk zzpk) {
        int readInt = zzpk.readInt();
        if (zzpk.readInt() == zzkr.zzavt) {
            zzpk.zzbp(8);
            return new zzmm(str, null, zzpk.zzbq(readInt - 16));
        }
        String valueOf = String.valueOf(zzkr.zzas(i));
        if (valueOf.length() != 0) {
            "Failed to parse text attribute: ".concat(valueOf);
        } else {
            new String("Failed to parse text attribute: ");
        }
        return null;
    }

    private static zzmm zzb(int i, String str, zzpk zzpk) {
        int readInt = zzpk.readInt();
        if (zzpk.readInt() == zzkr.zzavt && readInt >= 22) {
            zzpk.zzbp(10);
            int readUnsignedShort = zzpk.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzpk.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzmm(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzkr.zzas(i));
        if (valueOf2.length() != 0) {
            "Failed to parse index/count attribute: ".concat(valueOf2);
        } else {
            new String("Failed to parse index/count attribute: ");
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[Catch:{ all -> 0x0293 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzmc.zza zzd(com.google.android.gms.internal.ads.zzpk r14) {
        /*
        // Method dump skipped, instructions count: 664
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlk.zzd(com.google.android.gms.internal.ads.zzpk):com.google.android.gms.internal.ads.zzmc$zza");
    }

    private static int zze(zzpk zzpk) {
        zzpk.zzbp(4);
        if (zzpk.readInt() != zzkr.zzavt) {
            return -1;
        }
        zzpk.zzbp(8);
        return zzpk.readUnsignedByte();
    }

    private static zzmj zza(int i, String str, zzpk zzpk, boolean z, boolean z2) {
        int zze = zze(zzpk);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze < 0) {
            String valueOf = String.valueOf(zzkr.zzas(i));
            if (valueOf.length() != 0) {
                "Failed to parse uint8 attribute: ".concat(valueOf);
            } else {
                new String("Failed to parse uint8 attribute: ");
            }
            return null;
        } else if (z) {
            return new zzmm(str, null, Integer.toString(zze));
        } else {
            return new zzmi(C.LANGUAGE_UNDETERMINED, str, Integer.toString(zze));
        }
    }
}
