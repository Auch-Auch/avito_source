package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
public class LazyFieldLite {
    public volatile boolean a;
    public volatile MessageLite value;

    public void ensureInitialized(MessageLite messageLite) {
        if (this.value == null) {
            synchronized (this) {
                if (this.value == null) {
                    try {
                        this.value = messageLite;
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    public int getSerializedSize() {
        if (this.a) {
            return this.value.getSerializedSize();
        }
        throw null;
    }

    public MessageLite getValue(MessageLite messageLite) {
        ensureInitialized(messageLite);
        return this.value;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.value = messageLite;
        this.a = true;
        return messageLite2;
    }
}
