package com.google.protobuf;

import java.io.IOException;
public final class WireFormat {
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);
        
        public final Object a;

        /* access modifiers changed from: public */
        JavaType(Object obj) {
            this.a = obj;
        }
    }

    public enum b {
        LOOSE {
            @Override // com.google.protobuf.WireFormat.b
            public Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.readString();
            }
        },
        STRICT {
            @Override // com.google.protobuf.WireFormat.b
            public Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.readStringRequireUtf8();
            }
        },
        LAZY {
            @Override // com.google.protobuf.WireFormat.b
            public Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.readBytes();
            }
        };

        /* access modifiers changed from: public */
        b(a aVar) {
        }

        public abstract Object a(CodedInputStream codedInputStream) throws IOException;
    }

    public static Object a(CodedInputStream codedInputStream, FieldType fieldType, b bVar) throws IOException {
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
                return bVar.a(codedInputStream);
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

    public static int getTagFieldNumber(int i) {
        return i >>> 3;
    }

    public static int getTagWireType(int i) {
        return i & 7;
    }

    /* JADX WARN: Init of enum INT64 can be incorrect */
    /* JADX WARN: Init of enum UINT64 can be incorrect */
    /* JADX WARN: Init of enum INT32 can be incorrect */
    /* JADX WARN: Init of enum FIXED64 can be incorrect */
    /* JADX WARN: Init of enum FIXED32 can be incorrect */
    /* JADX WARN: Init of enum GROUP can be incorrect */
    /* JADX WARN: Init of enum MESSAGE can be incorrect */
    /* JADX WARN: Init of enum UINT32 can be incorrect */
    /* JADX WARN: Init of enum SFIXED32 can be incorrect */
    /* JADX WARN: Init of enum SFIXED64 can be incorrect */
    /* JADX WARN: Init of enum SINT32 can be incorrect */
    /* JADX WARN: Init of enum SINT64 can be incorrect */
    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(r5, 0),
        UINT64(r5, 0),
        INT32(r11, 0),
        FIXED64(r5, 1),
        FIXED32(r11, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) {
            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        GROUP(r13, 3) {
            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        MESSAGE(r13, 2) {
            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) {
            @Override // com.google.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        UINT32(r11, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(r11, 5),
        SFIXED64(r5, 1),
        SINT32(r11, 0),
        SINT64(r5, 0);
        
        public final JavaType a;
        public final int b;

        /* access modifiers changed from: public */
        static {
            JavaType javaType = JavaType.LONG;
            JavaType javaType2 = JavaType.INT;
            JavaType javaType3 = JavaType.MESSAGE;
        }

        /* access modifiers changed from: public */
        FieldType(JavaType javaType, int i) {
            this.a = javaType;
            this.b = i;
        }

        public JavaType getJavaType() {
            return this.a;
        }

        public int getWireType() {
            return this.b;
        }

        public boolean isPackable() {
            return true;
        }

        /* access modifiers changed from: public */
        FieldType(JavaType javaType, int i, a aVar) {
            this.a = javaType;
            this.b = i;
        }
    }
}
