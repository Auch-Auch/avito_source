package l6.b0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import com.google.android.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class b extends VersionedParcel {
    public static final Charset j = Charset.forName(C.UTF16_NAME);
    public final DataInputStream a;
    public final DataOutputStream b;
    public DataInputStream c;
    public DataOutputStream d;
    public C0520b e;
    public boolean f;
    public int g;
    public int h;
    public int i;

    /* renamed from: l6.b0.b$b  reason: collision with other inner class name */
    public static class C0520b {
        public final ByteArrayOutputStream a;
        public final DataOutputStream b;
        public final int c;
        public final DataOutputStream d;

        public C0520b(int i, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.a = byteArrayOutputStream;
            this.b = new DataOutputStream(byteArrayOutputStream);
            this.c = i;
            this.d = dataOutputStream;
        }
    }

    public b(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        C0520b bVar = this.e;
        if (bVar != null) {
            try {
                if (bVar.a.size() != 0) {
                    C0520b bVar2 = this.e;
                    bVar2.b.flush();
                    int size = bVar2.a.size();
                    bVar2.d.writeInt((bVar2.c << 16) | (size >= 65535 ? 65535 : size));
                    if (size >= 65535) {
                        bVar2.d.writeInt(size);
                    }
                    bVar2.a.writeTo(bVar2.d);
                }
                this.e = null;
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        return new b(this.c, this.d, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    public final void h(Object obj) {
        if (obj == null) {
            writeInt(0);
        } else if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
        } else if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
        } else if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
        } else if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
        } else if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
        } else if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
        } else if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
        } else {
            StringBuilder L = a2.b.a.a.a.L("Unsupported type ");
            L.append(obj.getClass());
            throw new IllegalArgumentException(L.toString());
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        try {
            return this.c.readBoolean();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < readInt; i2++) {
            String readString = readString();
            int readInt2 = readInt();
            switch (readInt2) {
                case 0:
                    bundle.putParcelable(readString, null);
                    break;
                case 1:
                    bundle.putBundle(readString, readBundle());
                    break;
                case 2:
                    bundle.putBundle(readString, readBundle());
                    break;
                case 3:
                    bundle.putString(readString, readString());
                    break;
                case 4:
                    bundle.putStringArray(readString, (String[]) readArray(new String[0]));
                    break;
                case 5:
                    bundle.putBoolean(readString, readBoolean());
                    break;
                case 6:
                    bundle.putBooleanArray(readString, readBooleanArray());
                    break;
                case 7:
                    bundle.putDouble(readString, readDouble());
                    break;
                case 8:
                    bundle.putDoubleArray(readString, readDoubleArray());
                    break;
                case 9:
                    bundle.putInt(readString, readInt());
                    break;
                case 10:
                    bundle.putIntArray(readString, readIntArray());
                    break;
                case 11:
                    bundle.putLong(readString, readLong());
                    break;
                case 12:
                    bundle.putLongArray(readString, readLongArray());
                    break;
                case 13:
                    bundle.putFloat(readString, readFloat());
                    break;
                case 14:
                    bundle.putFloatArray(readString, readFloatArray());
                    break;
                default:
                    throw new RuntimeException(a2.b.a.a.a.M2("Unknown type ", readInt2));
            }
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        try {
            int readInt = this.c.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.c.readFully(bArr);
            return bArr;
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        try {
            return this.c.readDouble();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i2) {
        while (true) {
            try {
                int i3 = this.h;
                if (i3 == i2) {
                    return true;
                }
                if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                    return false;
                }
                int i4 = this.g;
                int i5 = this.i;
                if (i4 < i5) {
                    this.a.skip((long) (i5 - i4));
                }
                this.i = -1;
                int readInt = this.a.readInt();
                this.g = 0;
                int i6 = readInt & 65535;
                if (i6 == 65535) {
                    i6 = this.a.readInt();
                }
                this.h = (readInt >> 16) & 65535;
                this.i = i6;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        try {
            return this.c.readFloat();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        try {
            return this.c.readInt();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        try {
            return this.c.readLong();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        try {
            int readInt = this.c.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.c.readFully(bArr);
            return new String(bArr, j);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i2) {
        closeField();
        C0520b bVar = new C0520b(i2, this.b);
        this.e = bVar;
        this.d = bVar.b;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean z, boolean z2) {
        if (z) {
            this.f = z2;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z) {
        try {
            this.d.writeBoolean(z);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        if (bundle != null) {
            try {
                Set<String> keySet = bundle.keySet();
                this.d.writeInt(keySet.size());
                for (String str : keySet) {
                    writeString(str);
                    h(bundle.get(str));
                }
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.d.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            try {
                this.d.writeInt(bArr.length);
                this.d.write(bArr);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.d.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence charSequence) {
        if (!this.f) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d2) {
        try {
            this.d.writeDouble(d2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f2) {
        try {
            this.d.writeFloat(f2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i2) {
        try {
            this.d.writeInt(i2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j2) {
        try {
            this.d.writeLong(j2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        if (!this.f) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes(j);
                this.d.writeInt(bytes.length);
                this.d.write(bytes);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.d.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        if (!this.f) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        if (!this.f) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public b(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.g = 0;
        this.h = -1;
        this.i = -1;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new a(inputStream)) : null;
        this.a = dataInputStream;
        dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : dataOutputStream;
        this.b = dataOutputStream;
        this.c = dataInputStream;
        this.d = dataOutputStream;
    }

    public class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            b bVar = b.this;
            int i = bVar.i;
            if (i == -1 || bVar.g < i) {
                int read = super.read();
                b.this.g++;
                return read;
            }
            throw new IOException();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            b bVar = b.this;
            int i = bVar.i;
            if (i == -1 || bVar.g < i) {
                long skip = super.skip(j);
                if (skip > 0) {
                    b.this.g += (int) skip;
                }
                return skip;
            }
            throw new IOException();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            b bVar = b.this;
            int i3 = bVar.i;
            if (i3 == -1 || bVar.g < i3) {
                int read = super.read(bArr, i, i2);
                if (read > 0) {
                    b.this.g += read;
                }
                return read;
            }
            throw new IOException();
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            try {
                this.d.writeInt(i3);
                this.d.write(bArr, i2, i3);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.d.writeInt(-1);
        }
    }
}
