package kotlin.reflect.jvm.internal.impl.protobuf;
public final class WireFormat {

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

    public static int getTagFieldNumber(int i) {
        return i >>> 3;
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
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        GROUP(r13, 3) {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        MESSAGE(r13, 2) {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType
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
