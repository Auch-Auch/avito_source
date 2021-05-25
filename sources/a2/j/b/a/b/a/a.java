package a2.j.b.a.b.a;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.a.zza;
public final class a extends zza {
    public final Integer a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: a2.j.b.a.b.a.a$a  reason: collision with other inner class name */
    public static final class C0031a extends zza.AbstractC0184zza {
        public Integer a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza.AbstractC0184zza zza(@Nullable Integer num) {
            this.a = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza.AbstractC0184zza zzb(@Nullable String str) {
            this.h = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza.AbstractC0184zza zzc(@Nullable String str) {
            this.c = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza.AbstractC0184zza zzd(@Nullable String str) {
            this.g = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza.AbstractC0184zza zze(@Nullable String str) {
            this.b = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza.AbstractC0184zza zzf(@Nullable String str) {
            this.f = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza.AbstractC0184zza zzg(@Nullable String str) {
            this.e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza.AbstractC0184zza zza(@Nullable String str) {
            this.d = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0184zza
        public zza zza() {
            return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    public /* synthetic */ a(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        Integer num = this.a;
        if (num != null ? num.equals(((a) obj).a) : ((a) obj).a == null) {
            String str = this.b;
            if (str != null ? str.equals(((a) obj).b) : ((a) obj).b == null) {
                String str2 = this.c;
                if (str2 != null ? str2.equals(((a) obj).c) : ((a) obj).c == null) {
                    String str3 = this.d;
                    if (str3 != null ? str3.equals(((a) obj).d) : ((a) obj).d == null) {
                        String str4 = this.e;
                        if (str4 != null ? str4.equals(((a) obj).e) : ((a) obj).e == null) {
                            String str5 = this.f;
                            if (str5 != null ? str5.equals(((a) obj).f) : ((a) obj).f == null) {
                                String str6 = this.g;
                                if (str6 != null ? str6.equals(((a) obj).g) : ((a) obj).g == null) {
                                    String str7 = this.h;
                                    if (str7 == null) {
                                        if (((a) obj).h == null) {
                                            return true;
                                        }
                                    } else if (str7.equals(((a) obj).h)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.h;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode7 ^ i;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("AndroidClientInfo{sdkVersion=");
        L.append(this.a);
        L.append(", model=");
        L.append(this.b);
        L.append(", hardware=");
        L.append(this.c);
        L.append(", device=");
        L.append(this.d);
        L.append(", product=");
        L.append(this.e);
        L.append(", osBuild=");
        L.append(this.f);
        L.append(", manufacturer=");
        L.append(this.g);
        L.append(", fingerprint=");
        return a2.b.a.a.a.t(L, this.h, "}");
    }

    @Override // com.google.android.datatransport.cct.a.zza
    @Nullable
    public String zzb() {
        return this.d;
    }

    @Override // com.google.android.datatransport.cct.a.zza
    @Nullable
    public String zzc() {
        return this.h;
    }

    @Override // com.google.android.datatransport.cct.a.zza
    @Nullable
    public String zzd() {
        return this.c;
    }

    @Override // com.google.android.datatransport.cct.a.zza
    @Nullable
    public String zze() {
        return this.g;
    }

    @Override // com.google.android.datatransport.cct.a.zza
    @Nullable
    public String zzf() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.a.zza
    @Nullable
    public String zzg() {
        return this.f;
    }

    @Override // com.google.android.datatransport.cct.a.zza
    @Nullable
    public String zzh() {
        return this.e;
    }

    @Override // com.google.android.datatransport.cct.a.zza
    @Nullable
    public Integer zzi() {
        return this.a;
    }
}
