package l6.c.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public final class h {
    @NonNull
    public final byte[] a;
    @Nullable
    public String b;
    @Nullable
    public List<byte[]> c;

    public h(@NonNull byte[] bArr) {
        this.a = bArr;
    }

    @NonNull
    public static h a(String str, List<byte[]> list) throws IOException {
        Collections.sort(list, b.a);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        for (byte[] bArr : list) {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
        dataOutputStream.flush();
        return new h(byteArrayOutputStream.toByteArray(), str, list);
    }

    public final void b() throws IOException {
        if (this.b == null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.a));
            this.b = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            this.c = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = dataInputStream.readInt();
                byte[] bArr = new byte[readInt2];
                if (dataInputStream.read(bArr) == readInt2) {
                    this.c.add(bArr);
                } else {
                    throw new IllegalStateException("Could not read fingerprint");
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((h) obj).a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public h(@NonNull byte[] bArr, @NonNull String str, @NonNull List<byte[]> list) {
        this.a = bArr;
        this.b = str;
        this.c = new ArrayList(list.size());
        for (byte[] bArr2 : list) {
            this.c.add(Arrays.copyOf(bArr2, bArr2.length));
        }
    }
}
