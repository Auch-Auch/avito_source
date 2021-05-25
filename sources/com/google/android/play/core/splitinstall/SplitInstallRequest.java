package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class SplitInstallRequest {
    public final List<String> a;
    public final List<Locale> b;

    public static class Builder {
        public final List<String> a = new ArrayList();
        public final List<Locale> b = new ArrayList();

        public Builder() {
        }

        public /* synthetic */ Builder(byte[] bArr) {
        }

        public Builder addLanguage(Locale locale) {
            this.b.add(locale);
            return this;
        }

        public Builder addModule(String str) {
            this.a.add(str);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest(this);
        }
    }

    public /* synthetic */ SplitInstallRequest(Builder builder) {
        this.a = new ArrayList(builder.a);
        this.b = new ArrayList(builder.b);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public List<Locale> getLanguages() {
        return this.b;
    }

    public List<String> getModuleNames() {
        return this.a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.a, this.b);
    }
}
