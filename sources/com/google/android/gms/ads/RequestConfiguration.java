package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbbd;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
public class RequestConfiguration {
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    public static final List<String> zzadn = Arrays.asList("MA", "T", "PG", "G");
    private final int zzadj;
    private final int zzadk;
    private final String zzadl;
    private final List<String> zzadm;

    public static class Builder {
        private int zzadj = -1;
        private int zzadk = -1;
        private String zzadl = null;
        private final List<String> zzadm = new ArrayList();

        public RequestConfiguration build() {
            return new RequestConfiguration(this.zzadj, this.zzadk, this.zzadl, this.zzadm);
        }

        public Builder setMaxAdContentRating(String str) {
            if (str == null || "".equals(str)) {
                this.zzadl = null;
            } else if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
                this.zzadl = str;
            } else {
                zzbbd.zzfe(str.length() != 0 ? "Invalid value passed to setMaxAdContentRating: ".concat(str) : new String("Invalid value passed to setMaxAdContentRating: "));
            }
            return this;
        }

        public Builder setTagForChildDirectedTreatment(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzadj = i;
            } else {
                StringBuilder sb = new StringBuilder(68);
                sb.append("Invalid value passed to setTagForChildDirectedTreatment: ");
                sb.append(i);
                zzbbd.zzfe(sb.toString());
            }
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzadk = i;
            } else {
                StringBuilder sb = new StringBuilder(63);
                sb.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
                sb.append(i);
                zzbbd.zzfe(sb.toString());
            }
            return this;
        }

        public Builder setTestDeviceIds(@Nullable List<String> list) {
            this.zzadm.clear();
            if (list != null) {
                this.zzadm.addAll(list);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    private RequestConfiguration(int i, int i2, String str, List<String> list) {
        this.zzadj = i;
        this.zzadk = i2;
        this.zzadl = str;
        this.zzadm = list;
    }

    public String getMaxAdContentRating() {
        String str = this.zzadl;
        return str == null ? "" : str;
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzadj;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzadk;
    }

    public List<String> getTestDeviceIds() {
        return new ArrayList(this.zzadm);
    }

    public Builder toBuilder() {
        return new Builder().setTagForChildDirectedTreatment(this.zzadj).setTagForUnderAgeOfConsent(this.zzadk).setMaxAdContentRating(this.zzadl).setTestDeviceIds(this.zzadm);
    }
}
