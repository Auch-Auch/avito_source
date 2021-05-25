package com.yandex.runtime.bindings;

import com.yandex.runtime.bindings.internal.ArchiveReader;
import com.yandex.runtime.bindings.internal.ArchiveWriter;
import java.nio.ByteBuffer;
import java.util.List;
@Deprecated
public class Serialization {
    private static byte[] byteBufferToByteArray(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        byteBuffer.position(0);
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return bArr;
    }

    public static <T extends Serializable> T deserialize(ByteBuffer byteBuffer, Class<T> cls) {
        return (T) new ArchiveReader(byteBuffer).add((ArchiveReader) null, false, (Class<ArchiveReader>) cls);
    }

    public static <T extends Serializable> List<T> deserializeArray(ByteBuffer byteBuffer, Class<T> cls) {
        return new ArchiveReader(byteBuffer).add((List) null, false, (ArchivingHandler) new ClassHandler(cls));
    }

    public static <T extends Serializable> List<T> deserializeArrayFromBytes(byte[] bArr, Class<T> cls) {
        return deserializeArray(ByteBuffer.wrap(bArr), cls);
    }

    public static <T extends Serializable> T deserializeFromBytes(byte[] bArr, Class<T> cls) {
        return (T) deserialize(ByteBuffer.wrap(bArr), cls);
    }

    public static <T extends Serializable> ByteBuffer serialize(T t) {
        ArchiveWriter archiveWriter = new ArchiveWriter();
        t.serialize(archiveWriter);
        return archiveWriter.data();
    }

    public static <T extends Serializable> ByteBuffer serializeArray(List<T> list) {
        ArchiveWriter archiveWriter = new ArchiveWriter();
        archiveWriter.add(list.size());
        for (T t : list) {
            t.serialize(archiveWriter);
        }
        return archiveWriter.data();
    }

    public static <T extends Serializable> byte[] serializeArrayToBytes(List<T> list) {
        return byteBufferToByteArray(serializeArray(list));
    }

    public static <T extends Serializable> byte[] serializeToBytes(T t) {
        return byteBufferToByteArray(serialize(t));
    }
}
