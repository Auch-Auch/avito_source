package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.auto.value.AutoValue;
@AutoValue
public abstract class SendRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder a(Encoding encoding);

        public abstract Builder b(Event<?> event);

        public abstract SendRequest build();

        public abstract Builder c(Transformer<?, byte[]> transformer);

        public <T> Builder setEvent(Event<T> event, Encoding encoding, Transformer<T, byte[]> transformer) {
            b(event);
            a(encoding);
            c(transformer);
            return this;
        }

        public abstract Builder setTransportContext(TransportContext transportContext);

        public abstract Builder setTransportName(String str);
    }

    public abstract Encoding a();

    public abstract Event<?> b();

    public abstract Transformer<?, byte[]> c();

    public abstract TransportContext d();

    public abstract String e();
}
