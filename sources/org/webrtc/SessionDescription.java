package org.webrtc;

import java.util.Locale;
public class SessionDescription {
    public final String description;
    public final Type type;

    public enum Type {
        OFFER,
        PRANSWER,
        ANSWER;

        public String canonicalForm() {
            return name().toLowerCase(Locale.US);
        }
    }

    @CalledByNative
    public SessionDescription(Type type2, String str) {
        this.type = type2;
        this.description = str;
    }

    @CalledByNative
    public String getDescription() {
        return this.description;
    }

    @CalledByNative
    public String getTypeInCanonicalForm() {
        return this.type.canonicalForm();
    }
}
