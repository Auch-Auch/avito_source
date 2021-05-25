package com.google.android.gms.ads.rewarded;
public class ServerSideVerificationOptions {
    private final String zzdve;
    private final String zzdvf;

    public static final class Builder {
        private String zzdve = "";
        private String zzdvf = "";

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public final Builder setCustomData(String str) {
            this.zzdvf = str;
            return this;
        }

        public final Builder setUserId(String str) {
            this.zzdve = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.zzdve = builder.zzdve;
        this.zzdvf = builder.zzdvf;
    }

    public String getCustomData() {
        return this.zzdvf;
    }

    public String getUserId() {
        return this.zzdve;
    }
}
