package com.yandex.metrica;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class PreloadInfo {
    public String a;
    public Map<String, String> b;

    public static class Builder {
        public String a;
        public Map<String, String> b = new HashMap();

        public Builder(String str, a aVar) {
            this.a = str;
        }

        public PreloadInfo build() {
            return new PreloadInfo(this, null);
        }

        public Builder setAdditionalParams(String str, String str2) {
            if (!(str == null || str2 == null)) {
                this.b.put(str, str2);
            }
            return this;
        }
    }

    public PreloadInfo(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = Collections.unmodifiableMap(builder.b);
    }

    public static Builder newBuilder(String str) {
        return new Builder(str, null);
    }

    public Map<String, String> getAdditionalParams() {
        return this.b;
    }

    public String getTrackingId() {
        return this.a;
    }
}
