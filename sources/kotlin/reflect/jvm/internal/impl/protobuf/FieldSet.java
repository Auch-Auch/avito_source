package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import t6.w.f.a.m.e.c;
import t6.w.f.a.m.e.d;
public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    public static final FieldSet d = new FieldSet(true);
    public final d<FieldDescriptorType, Object> a;
    public boolean b;
    public boolean c = false;

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    public FieldSet() {
        int i = d.f;
        this.a = new c(16);
    }

    public static int d(WireFormat.FieldType fieldType, Object obj) {
        switch (fieldType.ordinal()) {
            case 0:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 1:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 2:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 3:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 5:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 6:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 7:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 8:
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 12:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 13:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int e(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        int computeTagSize;
        int d2;
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            int i = 0;
            if (fieldDescriptorLite.isPacked()) {
                for (Object obj2 : (List) obj) {
                    i += d(liteType, obj2);
                }
                computeTagSize = CodedOutputStream.computeTagSize(number) + i;
                d2 = CodedOutputStream.computeRawVarint32Size(i);
            } else {
                for (Object obj3 : (List) obj) {
                    int computeTagSize2 = CodedOutputStream.computeTagSize(number);
                    if (liteType == WireFormat.FieldType.GROUP) {
                        computeTagSize2 *= 2;
                    }
                    i += d(liteType, obj3) + computeTagSize2;
                }
                return i;
            }
        } else {
            computeTagSize = CodedOutputStream.computeTagSize(number);
            if (liteType == WireFormat.FieldType.GROUP) {
                computeTagSize *= 2;
            }
            d2 = d(liteType, obj);
        }
        return d2 + computeTagSize;
    }

    public static int g(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public static Object l(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z) throws IOException {
        switch (fieldType.ordinal()) {
            case 0:
                return Double.valueOf(codedInputStream.readDouble());
            case 1:
                return Float.valueOf(codedInputStream.readFloat());
            case 2:
                return Long.valueOf(codedInputStream.readInt64());
            case 3:
                return Long.valueOf(codedInputStream.readUInt64());
            case 4:
                return Integer.valueOf(codedInputStream.readInt32());
            case 5:
                return Long.valueOf(codedInputStream.readFixed64());
            case 6:
                return Integer.valueOf(codedInputStream.readFixed32());
            case 7:
                return Boolean.valueOf(codedInputStream.readBool());
            case 8:
                if (z) {
                    return codedInputStream.readStringRequireUtf8();
                }
                return codedInputStream.readString();
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return codedInputStream.readBytes();
            case 12:
                return Integer.valueOf(codedInputStream.readUInt32());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(codedInputStream.readSFixed32());
            case 15:
                return Long.valueOf(codedInputStream.readSFixed64());
            case 16:
                return Integer.valueOf(codedInputStream.readSInt32());
            case 17:
                return Long.valueOf(codedInputStream.readSInt64());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.LazyField) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite) == false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void n(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType r2, java.lang.Object r3) {
        /*
            java.util.Objects.requireNonNull(r3)
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r0 = 1
            r1 = 0
            switch(r2) {
                case 0: goto L_0x003e;
                case 1: goto L_0x003b;
                case 2: goto L_0x0038;
                case 3: goto L_0x0035;
                case 4: goto L_0x0032;
                case 5: goto L_0x002f;
                case 6: goto L_0x0023;
                case 7: goto L_0x001a;
                case 8: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0040
        L_0x0011:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            if (r2 != 0) goto L_0x002d
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.LazyField
            if (r2 == 0) goto L_0x002c
            goto L_0x002d
        L_0x001a:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x002d
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            if (r2 == 0) goto L_0x002c
            goto L_0x002d
        L_0x0023:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.ByteString
            if (r2 != 0) goto L_0x002d
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            r1 = r0
            goto L_0x0040
        L_0x002f:
            boolean r1 = r3 instanceof java.lang.String
            goto L_0x0040
        L_0x0032:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L_0x0040
        L_0x0035:
            boolean r1 = r3 instanceof java.lang.Double
            goto L_0x0040
        L_0x0038:
            boolean r1 = r3 instanceof java.lang.Float
            goto L_0x0040
        L_0x003b:
            boolean r1 = r3 instanceof java.lang.Long
            goto L_0x0040
        L_0x003e:
            boolean r1 = r3 instanceof java.lang.Integer
        L_0x0040:
            if (r1 == 0) goto L_0x0043
            return
        L_0x0043:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
            switch-data {0->0x003e, 1->0x003b, 2->0x0038, 3->0x0035, 4->0x0032, 5->0x002f, 6->0x0023, 7->0x001a, 8->0x0011, }
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.n(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public static void o(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i, (MessageLite) obj);
            return;
        }
        codedOutputStream.writeTag(i, g(fieldType, false));
        p(codedOutputStream, fieldType, obj);
    }

    public static void p(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (fieldType.ordinal()) {
            case 0:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                return;
            case 1:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                return;
            case 2:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                return;
            case 3:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 5:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 6:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 7:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                return;
            case 8:
                codedOutputStream.writeStringNoTag((String) obj);
                return;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    return;
                }
            case 12:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    return;
                }
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                return;
            default:
                return;
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (((GeneratedMessageLite.b) fielddescriptortype).d) {
            n(((GeneratedMessageLite.b) fielddescriptortype).c, obj);
            Object f = f(fielddescriptortype);
            if (f == null) {
                list = new ArrayList();
                this.a.h(fielddescriptortype, list);
            } else {
                list = (List) f;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b */
    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> fieldSet = new FieldSet<>();
        for (int i = 0; i < this.a.e(); i++) {
            Map.Entry<FieldDescriptorType, Object> d2 = this.a.d(i);
            fieldSet.m(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.f()) {
            fieldSet.m(entry.getKey(), entry.getValue());
        }
        fieldSet.c = this.c;
        return fieldSet;
    }

    public final Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public Object f(FieldDescriptorType fielddescriptortype) {
        Object obj = this.a.get(fielddescriptortype);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    public boolean h() {
        for (int i = 0; i < this.a.e(); i++) {
            if (!i(this.a.d(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.f()) {
            if (!i(entry)) {
                return false;
            }
        }
        return true;
    }

    public final boolean i(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                for (MessageLite messageLite : (List) entry.getValue()) {
                    if (!messageLite.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof LazyField) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public void j() {
        if (!this.b) {
            c cVar = (c) this.a;
            if (!cVar.d) {
                for (int i = 0; i < cVar.e(); i++) {
                    Map.Entry d2 = cVar.d(i);
                    if (((FieldDescriptorLite) d2.getKey()).isRepeated()) {
                        d2.setValue(Collections.unmodifiableList((List) d2.getValue()));
                    }
                }
                for (Map.Entry entry : cVar.f()) {
                    if (((FieldDescriptorLite) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            if (!cVar.d) {
                cVar.c = cVar.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(cVar.c);
                cVar.d = true;
            }
            this.b = true;
        }
    }

    public final void k(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (key.isRepeated()) {
            Object f = f(key);
            if (f == null) {
                f = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) f).add(c(obj));
            }
            this.a.h(key, f);
        } else if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object f2 = f(key);
            if (f2 == null) {
                this.a.h(key, c(value));
                return;
            }
            this.a.h(key, key.internalMergeFrom(((MessageLite) f2).toBuilder(), (MessageLite) value).build());
        } else {
            this.a.h(key, c(value));
        }
    }

    public void m(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            n(fielddescriptortype.getLiteType(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                n(fielddescriptortype.getLiteType(), it.next());
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof LazyField) {
            this.c = true;
        }
        this.a.h(fielddescriptortype, obj);
    }

    public FieldSet(boolean z) {
        int i = d.f;
        this.a = new c(0);
        j();
    }
}
