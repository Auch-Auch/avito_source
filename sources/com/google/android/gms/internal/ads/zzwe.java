package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.Random;
import java.util.WeakHashMap;
public final class zzwe {
    private static zzwe zzcin = new zzwe();
    private final zzbat zzcio;
    private final zzvr zzcip;
    private final String zzciq;
    private final zzaao zzcir;
    private final zzaaq zzcis;
    private final zzaap zzcit;
    private final zzbbg zzciu;
    private final Random zzciv;
    private final WeakHashMap<QueryInfo, String> zzciw;

    public zzwe() {
        this(new zzbat(), new zzvr(new zzva(), new zzvb(), new zzzd(), new zzaga(), new zzatx(), new zzavb(), new zzaqj(), new zzafz()), new zzaao(), new zzaaq(), new zzaap(), zzbat.zzyo(), new zzbbg(0, 202006000, true), new Random(), new WeakHashMap());
    }

    public static zzbat zzpq() {
        return zzcin.zzcio;
    }

    public static zzvr zzpr() {
        return zzcin.zzcip;
    }

    public static zzaaq zzps() {
        return zzcin.zzcis;
    }

    public static zzaao zzpt() {
        return zzcin.zzcir;
    }

    public static zzaap zzpu() {
        return zzcin.zzcit;
    }

    public static String zzpv() {
        return zzcin.zzciq;
    }

    public static zzbbg zzpw() {
        return zzcin.zzciu;
    }

    public static Random zzpx() {
        return zzcin.zzciv;
    }

    public static WeakHashMap<QueryInfo, String> zzpy() {
        return zzcin.zzciw;
    }

    private zzwe(zzbat zzbat, zzvr zzvr, zzaao zzaao, zzaaq zzaaq, zzaap zzaap, String str, zzbbg zzbbg, Random random, WeakHashMap<QueryInfo, String> weakHashMap) {
        this.zzcio = zzbat;
        this.zzcip = zzvr;
        this.zzcir = zzaao;
        this.zzcis = zzaaq;
        this.zzcit = zzaap;
        this.zzciq = str;
        this.zzciu = zzbbg;
        this.zzciv = random;
        this.zzciw = weakHashMap;
    }
}
