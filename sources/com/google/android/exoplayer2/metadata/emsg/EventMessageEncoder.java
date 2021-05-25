package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
public final class EventMessageEncoder {
    public final ByteArrayOutputStream a;
    public final DataOutputStream b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void a(DataOutputStream dataOutputStream, long j) throws IOException {
        dataOutputStream.writeByte(((int) (j >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j) & 255);
    }

    public byte[] encode(EventMessage eventMessage) {
        this.a.reset();
        try {
            DataOutputStream dataOutputStream = this.b;
            dataOutputStream.writeBytes(eventMessage.schemeIdUri);
            dataOutputStream.writeByte(0);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            DataOutputStream dataOutputStream2 = this.b;
            dataOutputStream2.writeBytes(str);
            dataOutputStream2.writeByte(0);
            a(this.b, eventMessage.durationMs);
            a(this.b, eventMessage.id);
            this.b.write(eventMessage.messageData);
            this.b.flush();
            return this.a.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
