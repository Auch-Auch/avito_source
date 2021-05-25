package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
public final class zzekj {

    public static final class zza extends zzegp<zza, zzb> implements zzeib {
        private static volatile zzeim<zza> zzel;
        private static final zza zzimu;
        private int zzdw;
        private int zzimn;
        private C0196zza zzimo;
        private zzeff zzimp;
        private zzeff zzimq;
        private boolean zzimr;
        private boolean zzims;
        private byte zzimt = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzekj$zza$zza  reason: collision with other inner class name */
        public static final class C0196zza extends zzegp<C0196zza, C0197zza> implements zzeib {
            private static volatile zzeim<C0196zza> zzel;
            private static final C0196zza zzimz;
            private int zzdw;
            private String zzimv = "";
            private String zzimw = "";
            private String zzimx = "";
            private int zzimy;

            /* renamed from: com.google.android.gms.internal.ads.zzekj$zza$zza$zza  reason: collision with other inner class name */
            public static final class C0197zza extends zzegp.zzb<C0196zza, C0197zza> implements zzeib {
                private C0197zza() {
                    super(C0196zza.zzimz);
                }

                public /* synthetic */ C0197zza(zzekl zzekl) {
                    this();
                }
            }

            static {
                C0196zza zza = new C0196zza();
                zzimz = zza;
                zzegp.zza(C0196zza.class, zza);
            }

            private C0196zza() {
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzekl.zzdv[i - 1]) {
                    case 1:
                        return new C0196zza();
                    case 2:
                        return new C0197zza(null);
                    case 3:
                        return zzegp.zza(zzimz, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdw", "zzimv", "zzimw", "zzimx", "zzimy"});
                    case 4:
                        return zzimz;
                    case 5:
                        zzeim<C0196zza> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (C0196zza.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zzimz);
                                    zzel = zzeim;
                                }
                            }
                        }
                        return zzeim;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzb extends zzegp.zzb<zza, zzb> implements zzeib {
            private zzb() {
                super(zza.zzimu);
            }

            public /* synthetic */ zzb(zzekl zzekl) {
                this();
            }
        }

        public enum zzc implements zzegu {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzegt<zzc> zzes = new zzekn();
            private final int value;

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zzht(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            public static zzegw zzw() {
                return zzekm.zzeu;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.ads.zzegu
            public final int zzv() {
                return this.value;
            }
        }

        static {
            zza zza = new zza();
            zzimu = zza;
            zzegp.zza(zza.class, zza);
        }

        private zza() {
            zzeff zzeff = zzeff.zzibd;
            this.zzimp = zzeff;
            this.zzimq = zzeff;
        }

        @Override // com.google.android.gms.internal.ads.zzegp
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzekl.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzegp.zza(zzimu, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdw", "zzimn", zzc.zzw(), "zzimo", "zzimp", "zzimq", "zzimr", "zzims"});
                case 4:
                    return zzimu;
                case 5:
                    zzeim<zza> zzeim = zzel;
                    if (zzeim == null) {
                        synchronized (zza.class) {
                            zzeim = zzel;
                            if (zzeim == null) {
                                zzeim = new zzegp.zza<>(zzimu);
                                zzel = zzeim;
                            }
                        }
                    }
                    return zzeim;
                case 6:
                    return Byte.valueOf(this.zzimt);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzimt = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzb extends zzegp<zzb, zza> implements zzeib {
        private static volatile zzeim<zzb> zzel;
        private static final zzb zzinv;
        private int zzbzm;
        private int zzdw;
        private zzeff zzimp = zzeff.zzibd;
        private byte zzimt = 2;
        private String zzimw = "";
        private int zzing;
        private String zzinh = "";
        private String zzini = "";
        private C0198zzb zzinj;
        private zzeha<zzh> zzink = zzegp.zzbfo();
        private String zzinl = "";
        private zzf zzinm;
        private boolean zzinn;
        private zzeha<String> zzino = zzegp.zzbfo();
        private String zzinp = "";
        private boolean zzinq;
        private boolean zzinr;
        private zzi zzins;
        private zzeha<String> zzint = zzegp.zzbfo();
        private zzeha<String> zzinu = zzegp.zzbfo();

        public static final class zza extends zzegp.zzb<zzb, zza> implements zzeib {
            private zza() {
                super(zzb.zzinv);
            }

            public final String getUrl() {
                return ((zzb) this.zzift).getUrl();
            }

            public final zza zza(zzg zzg) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzb(zzg);
                return this;
            }

            public final List<zzh> zzbim() {
                return Collections.unmodifiableList(((zzb) this.zzift).zzbim());
            }

            public final String zzbin() {
                return ((zzb) this.zzift).zzbin();
            }

            public final zza zzbio() {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzbip();
                return this;
            }

            public final zza zzhy(String str) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).setUrl(str);
                return this;
            }

            public final zza zzhz(String str) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzib(str);
                return this;
            }

            public final zza zzia(String str) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzea(str);
                return this;
            }

            public final zza zzm(Iterable<String> iterable) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzo(iterable);
                return this;
            }

            public final zza zzn(Iterable<String> iterable) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzp(iterable);
                return this;
            }

            public /* synthetic */ zza(zzekl zzekl) {
                this();
            }

            public final zza zza(C0198zzb zzb) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzb(zzb);
                return this;
            }

            public final zza zza(zzh zzh) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzb(zzh);
                return this;
            }

            public final zza zza(zzf zzf) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzb(zzf);
                return this;
            }

            public final zza zza(zzi zzi) {
                if (this.zzifu) {
                    zzbft();
                    this.zzifu = false;
                }
                ((zzb) this.zzift).zzb(zzi);
                return this;
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzekj$zzb$zzb  reason: collision with other inner class name */
        public static final class C0198zzb extends zzegp<C0198zzb, zza> implements zzeib {
            private static volatile zzeim<C0198zzb> zzel;
            private static final C0198zzb zzinx;
            private int zzdw;
            private String zzinw = "";

            /* renamed from: com.google.android.gms.internal.ads.zzekj$zzb$zzb$zza */
            public static final class zza extends zzegp.zzb<C0198zzb, zza> implements zzeib {
                private zza() {
                    super(C0198zzb.zzinx);
                }

                public final zza zzic(String str) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((C0198zzb) this.zzift).zzid(str);
                    return this;
                }

                public /* synthetic */ zza(zzekl zzekl) {
                    this();
                }
            }

            static {
                C0198zzb zzb = new C0198zzb();
                zzinx = zzb;
                zzegp.zza(C0198zzb.class, zzb);
            }

            private C0198zzb() {
            }

            public static zza zzbis() {
                return (zza) zzinx.zzbfj();
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzid(String str) {
                str.getClass();
                this.zzdw |= 1;
                this.zzinw = str;
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzekl.zzdv[i - 1]) {
                    case 1:
                        return new C0198zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzegp.zza(zzinx, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdw", "zzinw"});
                    case 4:
                        return zzinx;
                    case 5:
                        zzeim<C0198zzb> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (C0198zzb.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zzinx);
                                    zzel = zzeim;
                                }
                            }
                        }
                        return zzeim;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzc extends zzegp<zzc, zza> implements zzeib {
            private static volatile zzeim<zzc> zzel;
            private static final zzc zzinz;
            private int zzdw;
            private zzeff zzhvx;
            private byte zzimt = 2;
            private zzeff zziny;

            public static final class zza extends zzegp.zzb<zzc, zza> implements zzeib {
                private zza() {
                    super(zzc.zzinz);
                }

                public final zza zzan(zzeff zzeff) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzc) this.zzift).zzap(zzeff);
                    return this;
                }

                public final zza zzao(zzeff zzeff) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzc) this.zzift).zzae(zzeff);
                    return this;
                }

                public /* synthetic */ zza(zzekl zzekl) {
                    this();
                }
            }

            static {
                zzc zzc = new zzc();
                zzinz = zzc;
                zzegp.zza(zzc.class, zzc);
            }

            private zzc() {
                zzeff zzeff = zzeff.zzibd;
                this.zziny = zzeff;
                this.zzhvx = zzeff;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzae(zzeff zzeff) {
                zzeff.getClass();
                this.zzdw |= 2;
                this.zzhvx = zzeff;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzap(zzeff zzeff) {
                zzeff.getClass();
                this.zzdw |= 1;
                this.zziny = zzeff;
            }

            public static zza zzbiu() {
                return (zza) zzinz.zzbfj();
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzekl.zzdv[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzegp.zza(zzinz, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdw", "zziny", "zzhvx"});
                    case 4:
                        return zzinz;
                    case 5:
                        zzeim<zzc> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (zzc.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zzinz);
                                    zzel = zzeim;
                                }
                            }
                        }
                        return zzeim;
                    case 6:
                        return Byte.valueOf(this.zzimt);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzimt = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzd extends zzegp<zzd, zza> implements zzeib {
            private static volatile zzeim<zzd> zzel;
            private static final zzd zziof;
            private int zzdw;
            private byte zzimt = 2;
            private C0199zzb zzioa;
            private zzeha<zzc> zziob = zzegp.zzbfo();
            private zzeff zzioc;
            private zzeff zziod;
            private int zzioe;

            public static final class zza extends zzegp.zzb<zzd, zza> implements zzeib {
                private zza() {
                    super(zzd.zziof);
                }

                public final zza zza(zzc zzc) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzd) this.zzift).zzb(zzc);
                    return this;
                }

                public /* synthetic */ zza(zzekl zzekl) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzekj$zzb$zzd$zzb  reason: collision with other inner class name */
            public static final class C0199zzb extends zzegp<C0199zzb, zza> implements zzeib {
                private static volatile zzeim<C0199zzb> zzel;
                private static final C0199zzb zzioj;
                private int zzdw;
                private zzeff zziog;
                private zzeff zzioh;
                private zzeff zzioi;

                /* renamed from: com.google.android.gms.internal.ads.zzekj$zzb$zzd$zzb$zza */
                public static final class zza extends zzegp.zzb<C0199zzb, zza> implements zzeib {
                    private zza() {
                        super(C0199zzb.zzioj);
                    }

                    public /* synthetic */ zza(zzekl zzekl) {
                        this();
                    }
                }

                static {
                    C0199zzb zzb = new C0199zzb();
                    zzioj = zzb;
                    zzegp.zza(C0199zzb.class, zzb);
                }

                private C0199zzb() {
                    zzeff zzeff = zzeff.zzibd;
                    this.zziog = zzeff;
                    this.zzioh = zzeff;
                    this.zzioi = zzeff;
                }

                @Override // com.google.android.gms.internal.ads.zzegp
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzekl.zzdv[i - 1]) {
                        case 1:
                            return new C0199zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zzegp.zza(zzioj, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zziog", "zzioh", "zzioi"});
                        case 4:
                            return zzioj;
                        case 5:
                            zzeim<C0199zzb> zzeim = zzel;
                            if (zzeim == null) {
                                synchronized (C0199zzb.class) {
                                    zzeim = zzel;
                                    if (zzeim == null) {
                                        zzeim = new zzegp.zza<>(zzioj);
                                        zzel = zzeim;
                                    }
                                }
                            }
                            return zzeim;
                        case 6:
                            return (byte) 1;
                        case 7:
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }
            }

            static {
                zzd zzd = new zzd();
                zziof = zzd;
                zzegp.zza(zzd.class, zzd);
            }

            private zzd() {
                zzeff zzeff = zzeff.zzibd;
                this.zzioc = zzeff;
                this.zziod = zzeff;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzb(zzc zzc) {
                zzc.getClass();
                zzeha<zzc> zzeha = this.zziob;
                if (!zzeha.zzbdf()) {
                    this.zziob = zzegp.zza(zzeha);
                }
                this.zziob.add(zzc);
            }

            public static zza zzbiw() {
                return (zza) zziof.zzbfj();
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzekl.zzdv[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzegp.zza(zziof, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdw", "zzioa", "zziob", zzc.class, "zzioc", "zziod", "zzioe"});
                    case 4:
                        return zziof;
                    case 5:
                        zzeim<zzd> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (zzd.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zziof);
                                    zzel = zzeim;
                                }
                            }
                        }
                        return zzeim;
                    case 6:
                        return Byte.valueOf(this.zzimt);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzimt = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zze extends zzegp<zze, zza> implements zzeib {
            private static volatile zzeim<zze> zzel;
            private static final zze zziom;
            private int zzdw;
            private byte zzimt = 2;
            private zzeha<zzc> zziob = zzegp.zzbfo();
            private zzeff zzioc;
            private zzeff zziod;
            private int zzioe;
            private C0200zzb zziok;
            private zzeff zziol;

            public static final class zza extends zzegp.zzb<zze, zza> implements zzeib {
                private zza() {
                    super(zze.zziom);
                }

                public /* synthetic */ zza(zzekl zzekl) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzekj$zzb$zze$zzb  reason: collision with other inner class name */
            public static final class C0200zzb extends zzegp<C0200zzb, zza> implements zzeib {
                private static volatile zzeim<C0200zzb> zzel;
                private static final C0200zzb zziop;
                private int zzdw;
                private zzeff zzioi;
                private int zzion;
                private zzeff zzioo;

                /* renamed from: com.google.android.gms.internal.ads.zzekj$zzb$zze$zzb$zza */
                public static final class zza extends zzegp.zzb<C0200zzb, zza> implements zzeib {
                    private zza() {
                        super(C0200zzb.zziop);
                    }

                    public /* synthetic */ zza(zzekl zzekl) {
                        this();
                    }
                }

                static {
                    C0200zzb zzb = new C0200zzb();
                    zziop = zzb;
                    zzegp.zza(C0200zzb.class, zzb);
                }

                private C0200zzb() {
                    zzeff zzeff = zzeff.zzibd;
                    this.zzioo = zzeff;
                    this.zzioi = zzeff;
                }

                @Override // com.google.android.gms.internal.ads.zzegp
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzekl.zzdv[i - 1]) {
                        case 1:
                            return new C0200zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zzegp.zza(zziop, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzion", "zzioo", "zzioi"});
                        case 4:
                            return zziop;
                        case 5:
                            zzeim<C0200zzb> zzeim = zzel;
                            if (zzeim == null) {
                                synchronized (C0200zzb.class) {
                                    zzeim = zzel;
                                    if (zzeim == null) {
                                        zzeim = new zzegp.zza<>(zziop);
                                        zzel = zzeim;
                                    }
                                }
                            }
                            return zzeim;
                        case 6:
                            return (byte) 1;
                        case 7:
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }
            }

            static {
                zze zze = new zze();
                zziom = zze;
                zzegp.zza(zze.class, zze);
            }

            private zze() {
                zzeff zzeff = zzeff.zzibd;
                this.zzioc = zzeff;
                this.zziod = zzeff;
                this.zziol = zzeff;
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzekl.zzdv[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzegp.zza(zziom, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdw", "zziok", "zziob", zzc.class, "zzioc", "zziod", "zzioe", "zziol"});
                    case 4:
                        return zziom;
                    case 5:
                        zzeim<zze> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (zze.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zziom);
                                    zzel = zzeim;
                                }
                            }
                        }
                        return zzeim;
                    case 6:
                        return Byte.valueOf(this.zzimt);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzimt = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzf extends zzegp<zzf, zza> implements zzeib {
            private static volatile zzeim<zzf> zzel;
            private static final zzf zzios;
            private int zzbzm;
            private int zzdw;
            private String zzioq = "";
            private zzeff zzior = zzeff.zzibd;

            public static final class zza extends zzegp.zzb<zzf, zza> implements zzeib {
                private zza() {
                    super(zzf.zzios);
                }

                public final zza zza(EnumC0201zzb zzb) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzf) this.zzift).zzb(zzb);
                    return this;
                }

                public final zza zzaq(zzeff zzeff) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzf) this.zzift).zzar(zzeff);
                    return this;
                }

                public final zza zzie(String str) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzf) this.zzift).setMimeType(str);
                    return this;
                }

                public /* synthetic */ zza(zzekl zzekl) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzekj$zzb$zzf$zzb  reason: collision with other inner class name */
            public enum EnumC0201zzb implements zzegu {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzegt<EnumC0201zzb> zzes = new zzeko();
                private final int value;

                private EnumC0201zzb(int i) {
                    this.value = i;
                }

                public static EnumC0201zzb zzhu(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                public static zzegw zzw() {
                    return zzekp.zzeu;
                }

                @Override // java.lang.Enum, java.lang.Object
                public final String toString() {
                    return "<" + EnumC0201zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
                }

                @Override // com.google.android.gms.internal.ads.zzegu
                public final int zzv() {
                    return this.value;
                }
            }

            static {
                zzf zzf = new zzf();
                zzios = zzf;
                zzegp.zza(zzf.class, zzf);
            }

            private zzf() {
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void setMimeType(String str) {
                str.getClass();
                this.zzdw |= 2;
                this.zzioq = str;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzar(zzeff zzeff) {
                zzeff.getClass();
                this.zzdw |= 4;
                this.zzior = zzeff;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzb(EnumC0201zzb zzb) {
                this.zzbzm = zzb.zzv();
                this.zzdw |= 1;
            }

            public static zza zzbjb() {
                return (zza) zzios.zzbfj();
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzekl.zzdv[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzegp.zza(zzios, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzbzm", EnumC0201zzb.zzw(), "zzioq", "zzior"});
                    case 4:
                        return zzios;
                    case 5:
                        zzeim<zzf> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (zzf.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zzios);
                                    zzel = zzeim;
                                }
                            }
                        }
                        return zzeim;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public enum zzg implements zzegu {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzegt<zzg> zzes = new zzekr();
            private final int value;

            private zzg(int i) {
                this.value = i;
            }

            public static zzg zzhv(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzegw zzw() {
                return zzekq.zzeu;
            }

            @Override // java.lang.Enum, java.lang.Object
            public final String toString() {
                return "<" + zzg.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.ads.zzegu
            public final int zzv() {
                return this.value;
            }
        }

        public static final class zzi extends zzegp<zzi, zza> implements zzeib {
            private static volatile zzeim<zzi> zzel;
            private static final zzi zzipy;
            private int zzdw;
            private String zzipv = "";
            private long zzipw;
            private boolean zzipx;

            public static final class zza extends zzegp.zzb<zzi, zza> implements zzeib {
                private zza() {
                    super(zzi.zzipy);
                }

                public final zza zzbx(boolean z) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzi) this.zzift).zzbw(z);
                    return this;
                }

                public final zza zzfu(long j) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzi) this.zzift).zzft(j);
                    return this;
                }

                public final zza zzij(String str) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzi) this.zzift).zzig(str);
                    return this;
                }

                public /* synthetic */ zza(zzekl zzekl) {
                    this();
                }
            }

            static {
                zzi zzi = new zzi();
                zzipy = zzi;
                zzegp.zza(zzi.class, zzi);
            }

            private zzi() {
            }

            public static zza zzbjg() {
                return (zza) zzipy.zzbfj();
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzbw(boolean z) {
                this.zzdw |= 4;
                this.zzipx = z;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzft(long j) {
                this.zzdw |= 2;
                this.zzipw = j;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzig(String str) {
                str.getClass();
                this.zzdw |= 1;
                this.zzipv = str;
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzekl.zzdv[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzegp.zza(zzipy, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdw", "zzipv", "zzipw", "zzipx"});
                    case 4:
                        return zzipy;
                    case 5:
                        zzeim<zzi> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (zzi.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zzipy);
                                    zzel = zzeim;
                                }
                            }
                        }
                        return zzeim;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        static {
            zzb zzb = new zzb();
            zzinv = zzb;
            zzegp.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void setUrl(String str) {
            str.getClass();
            this.zzdw |= 4;
            this.zzimw = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzg zzg2) {
            this.zzbzm = zzg2.zzv();
            this.zzdw |= 1;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzbip() {
            this.zzdw &= -65;
            this.zzinl = zzinv.zzinl;
        }

        public static zza zzbiq() {
            return (zza) zzinv.zzbfj();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzea(String str) {
            str.getClass();
            this.zzdw |= 64;
            this.zzinl = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzib(String str) {
            str.getClass();
            this.zzdw |= 8;
            this.zzinh = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzo(Iterable<String> iterable) {
            zzeha<String> zzeha = this.zzint;
            if (!zzeha.zzbdf()) {
                this.zzint = zzegp.zza(zzeha);
            }
            zzeev.zza(iterable, this.zzint);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzp(Iterable<String> iterable) {
            zzeha<String> zzeha = this.zzinu;
            if (!zzeha.zzbdf()) {
                this.zzinu = zzegp.zza(zzeha);
            }
            zzeev.zza(iterable, this.zzinu);
        }

        public final String getUrl() {
            return this.zzimw;
        }

        @Override // com.google.android.gms.internal.ads.zzegp
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzekl.zzdv[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzegp.zza(zzinv, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdw", "zzimw", "zzinh", "zzini", "zzink", zzh.class, "zzinn", "zzino", "zzinp", "zzinq", "zzinr", "zzbzm", zzg.zzw(), "zzing", zza.zzc.zzw(), "zzinj", "zzinl", "zzinm", "zzimp", "zzins", "zzint", "zzinu"});
                case 4:
                    return zzinv;
                case 5:
                    zzeim<zzb> zzeim = zzel;
                    if (zzeim == null) {
                        synchronized (zzb.class) {
                            zzeim = zzel;
                            if (zzeim == null) {
                                zzeim = new zzegp.zza<>(zzinv);
                                zzel = zzeim;
                            }
                        }
                    }
                    return zzeim;
                case 6:
                    return Byte.valueOf(this.zzimt);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzimt = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<zzh> zzbim() {
            return this.zzink;
        }

        public final String zzbin() {
            return this.zzinl;
        }

        public static final class zzh extends zzegp<zzh, C0202zzb> implements zzeib {
            private static volatile zzeim<zzh> zzel;
            private static final zzh zzipu;
            private int zzdw;
            private byte zzimt = 2;
            private String zzimw = "";
            private int zzipm;
            private zzd zzipn;
            private zze zzipo;
            private int zzipp;
            private zzegv zzipq = zzegp.zzbfm();
            private String zzipr = "";
            private int zzips;
            private zzeha<String> zzipt = zzegp.zzbfo();

            public enum zza implements zzegu {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzegt<zza> zzes = new zzekt();
                private final int value;

                private zza(int i) {
                    this.value = i;
                }

                public static zza zzhw(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                public static zzegw zzw() {
                    return zzeks.zzeu;
                }

                @Override // java.lang.Enum, java.lang.Object
                public final String toString() {
                    return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
                }

                @Override // com.google.android.gms.internal.ads.zzegu
                public final int zzv() {
                    return this.value;
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzekj$zzb$zzh$zzb  reason: collision with other inner class name */
            public static final class C0202zzb extends zzegp.zzb<zzh, C0202zzb> implements zzeib {
                private C0202zzb() {
                    super(zzh.zzipu);
                }

                public final C0202zzb zzb(zzd zzd) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzh) this.zzift).zza(zzd);
                    return this;
                }

                public final C0202zzb zzhx(int i) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzh) this.zzift).setId(i);
                    return this;
                }

                public final C0202zzb zzih(String str) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzh) this.zzift).setUrl(str);
                    return this;
                }

                public final C0202zzb zzii(String str) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzh) this.zzift).zzif(str);
                    return this;
                }

                public /* synthetic */ C0202zzb(zzekl zzekl) {
                    this();
                }

                public final C0202zzb zzb(zza zza) {
                    if (this.zzifu) {
                        zzbft();
                        this.zzifu = false;
                    }
                    ((zzh) this.zzift).zza(zza);
                    return this;
                }
            }

            static {
                zzh zzh = new zzh();
                zzipu = zzh;
                zzegp.zza(zzh.class, zzh);
            }

            private zzh() {
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void setId(int i) {
                this.zzdw |= 1;
                this.zzipm = i;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void setUrl(String str) {
                str.getClass();
                this.zzdw |= 2;
                this.zzimw = str;
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zza(zzd zzd) {
                zzd.getClass();
                this.zzipn = zzd;
                this.zzdw |= 4;
            }

            public static C0202zzb zzbje() {
                return (C0202zzb) zzipu.zzbfj();
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zzif(String str) {
                str.getClass();
                zzeha<String> zzeha = this.zzipt;
                if (!zzeha.zzbdf()) {
                    this.zzipt = zzegp.zza(zzeha);
                }
                this.zzipt.add(str);
            }

            public final String getUrl() {
                return this.zzimw;
            }

            public final int zzbjd() {
                return this.zzipt.size();
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final void zza(zza zza2) {
                this.zzips = zza2.zzv();
                this.zzdw |= 64;
            }

            @Override // com.google.android.gms.internal.ads.zzegp
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzekl.zzdv[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0202zzb(null);
                    case 3:
                        return zzegp.zza(zzipu, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdw", "zzipm", "zzimw", "zzipn", "zzipo", "zzipp", "zzipq", "zzipr", "zzips", zza.zzw(), "zzipt"});
                    case 4:
                        return zzipu;
                    case 5:
                        zzeim<zzh> zzeim = zzel;
                        if (zzeim == null) {
                            synchronized (zzh.class) {
                                zzeim = zzel;
                                if (zzeim == null) {
                                    zzeim = new zzegp.zza<>(zzipu);
                                    zzel = zzeim;
                                }
                            }
                        }
                        return zzeim;
                    case 6:
                        return Byte.valueOf(this.zzimt);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzimt = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(C0198zzb zzb) {
            zzb.getClass();
            this.zzinj = zzb;
            this.zzdw |= 32;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzh zzh2) {
            zzh2.getClass();
            zzeha<zzh> zzeha = this.zzink;
            if (!zzeha.zzbdf()) {
                this.zzink = zzegp.zza(zzeha);
            }
            this.zzink.add(zzh2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzf zzf2) {
            zzf2.getClass();
            this.zzinm = zzf2;
            this.zzdw |= 128;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzi zzi2) {
            zzi2.getClass();
            this.zzins = zzi2;
            this.zzdw |= 8192;
        }
    }
}
