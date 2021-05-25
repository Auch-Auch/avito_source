package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
public class MapEntryLite<K, V> {
    public final a<K, V> a;
    public final K b;
    public final V c;

    public static class a<K, V> {
        public final WireFormat.FieldType a;
        public final K b;
        public final WireFormat.FieldType c;
        public final V d;

        public a(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
            this.a = fieldType;
            this.b = k;
            this.c = fieldType2;
            this.d = v;
        }
    }

    public MapEntryLite(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        this.a = new a<>(fieldType, k, fieldType2, v);
        this.b = k;
        this.c = v;
    }

    public static <T> T a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t) throws IOException {
        int ordinal = fieldType.ordinal();
        if (ordinal == 9) {
            throw new RuntimeException("Groups are not allowed in maps.");
        } else if (ordinal != 10) {
            return ordinal != 13 ? (T) FieldSet.o(codedInputStream, fieldType, true) : (T) Integer.valueOf(codedInputStream.readEnum());
        } else {
            MessageLite.Builder builder = t.toBuilder();
            codedInputStream.readMessage(builder, extensionRegistryLite);
            return (T) builder.buildPartial();
        }
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        return new MapEntryLite<>(fieldType, k, fieldType2, v);
    }

    public int computeMessageSize(int i, K k, V v) {
        int computeTagSize = CodedOutputStream.computeTagSize(i);
        a<K, V> aVar = this.a;
        return CodedOutputStream.a(FieldSet.d(aVar.c, 2, v) + FieldSet.d(aVar.a, 1, k)) + computeTagSize;
    }

    public K getKey() {
        return this.b;
    }

    public V getValue() {
        return this.c;
    }

    public Map.Entry<K, V> parseEntry(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        CodedInputStream newCodedInput = byteString.newCodedInput();
        a<K, V> aVar = this.a;
        Object obj = aVar.b;
        Object obj2 = aVar.d;
        while (true) {
            int readTag = newCodedInput.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == (aVar.a.getWireType() | 8)) {
                obj = a(newCodedInput, extensionRegistryLite, aVar.a, obj);
            } else if (readTag == (aVar.c.getWireType() | 16)) {
                obj2 = a(newCodedInput, extensionRegistryLite, aVar.c, obj2);
            } else if (!newCodedInput.skipField(readTag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.protobuf.MapFieldLite<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
        a<K, V> aVar = this.a;
        Object obj = aVar.b;
        Object obj2 = aVar.d;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == (this.a.a.getWireType() | 8)) {
                obj = a(codedInputStream, extensionRegistryLite, this.a.a, obj);
            } else if (readTag == (this.a.c.getWireType() | 16)) {
                obj2 = a(codedInputStream, extensionRegistryLite, this.a.c, obj2);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(0);
        codedInputStream.popLimit(pushLimit);
        mapFieldLite.put(obj, obj2);
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int i, K k, V v) throws IOException {
        codedOutputStream.writeTag(i, 2);
        a<K, V> aVar = this.a;
        codedOutputStream.writeUInt32NoTag(FieldSet.d(aVar.c, 2, v) + FieldSet.d(aVar.a, 1, k));
        a<K, V> aVar2 = this.a;
        FieldSet.r(codedOutputStream, aVar2.a, 1, k);
        FieldSet.r(codedOutputStream, aVar2.c, 2, v);
    }
}
