package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;
public final class ProtoBuf {

    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static Parser<Annotation> PARSER = new a();
        public static final Annotation g;
        public final ByteString a;
        public int b;
        public int c;
        public List<Argument> d;
        public byte e;
        public int f;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new a();
            public static final Argument g;
            public final ByteString a;
            public int b;
            public int c;
            public Value d;
            public byte e;
            public int f;

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                public int b;
                public int c;
                public Value d = Value.getDefaultInstance();

                public Argument buildPartial() {
                    Argument argument = new Argument(this, null);
                    int i = this.b;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    argument.c = this.c;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    argument.d = this.d;
                    argument.b = i2;
                    return argument;
                }

                public Value getValue() {
                    return this.d;
                }

                public boolean hasNameId() {
                    return (this.b & 1) == 1;
                }

                public boolean hasValue() {
                    return (this.b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasNameId() && hasValue() && getValue().isInitialized()) {
                        return true;
                    }
                    return false;
                }

                public Builder mergeValue(Value value) {
                    if ((this.b & 2) != 2 || this.d == Value.getDefaultInstance()) {
                        this.d = value;
                    } else {
                        this.d = Value.newBuilder(this.d).mergeFrom(value).buildPartial();
                    }
                    this.b |= 2;
                    return this;
                }

                public Builder setNameId(int i) {
                    this.b |= 1;
                    this.c = i;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
                public Builder clone() {
                    return new Builder().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasNameId()) {
                        setNameId(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        mergeValue(argument.getValue());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.a));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Throwable th;
                    Argument argument;
                    Argument argument2 = null;
                    try {
                        Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        argument = (Argument) e.getUnfinishedMessage();
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        argument2 = argument;
                    }
                    if (argument2 != null) {
                        mergeFrom(argument2);
                    }
                    throw th;
                }
            }

            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static Parser<Value> PARSER = new a();
                public static final Value p;
                public final ByteString a;
                public int b;
                public Type c;
                public long d;
                public float e;
                public double f;
                public int g;
                public int h;
                public int i;
                public Annotation j;
                public List<Value> k;
                public int l;
                public int m;
                public byte n;
                public int o;

                public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                    public int b;
                    public Type c = Type.BYTE;
                    public long d;
                    public float e;
                    public double f;
                    public int g;
                    public int h;
                    public int i;
                    public Annotation j = Annotation.getDefaultInstance();
                    public List<Value> k = Collections.emptyList();
                    public int l;
                    public int m;

                    public Value buildPartial() {
                        Value value = new Value(this, null);
                        int i2 = this.b;
                        int i3 = 1;
                        if ((i2 & 1) != 1) {
                            i3 = 0;
                        }
                        value.c = this.c;
                        if ((i2 & 2) == 2) {
                            i3 |= 2;
                        }
                        value.d = this.d;
                        if ((i2 & 4) == 4) {
                            i3 |= 4;
                        }
                        value.e = this.e;
                        if ((i2 & 8) == 8) {
                            i3 |= 8;
                        }
                        value.f = this.f;
                        if ((i2 & 16) == 16) {
                            i3 |= 16;
                        }
                        value.g = this.g;
                        if ((i2 & 32) == 32) {
                            i3 |= 32;
                        }
                        value.h = this.h;
                        if ((i2 & 64) == 64) {
                            i3 |= 64;
                        }
                        value.i = this.i;
                        if ((i2 & 128) == 128) {
                            i3 |= 128;
                        }
                        value.j = this.j;
                        if ((i2 & 256) == 256) {
                            this.k = Collections.unmodifiableList(this.k);
                            this.b &= -257;
                        }
                        value.k = this.k;
                        if ((i2 & 512) == 512) {
                            i3 |= 256;
                        }
                        value.l = this.l;
                        if ((i2 & 1024) == 1024) {
                            i3 |= 512;
                        }
                        value.m = this.m;
                        value.b = i3;
                        return value;
                    }

                    public Annotation getAnnotation() {
                        return this.j;
                    }

                    public Value getArrayElement(int i2) {
                        return this.k.get(i2);
                    }

                    public int getArrayElementCount() {
                        return this.k.size();
                    }

                    public boolean hasAnnotation() {
                        return (this.b & 128) == 128;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        if (hasAnnotation() && !getAnnotation().isInitialized()) {
                            return false;
                        }
                        for (int i2 = 0; i2 < getArrayElementCount(); i2++) {
                            if (!getArrayElement(i2).isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    public Builder mergeAnnotation(Annotation annotation) {
                        if ((this.b & 128) != 128 || this.j == Annotation.getDefaultInstance()) {
                            this.j = annotation;
                        } else {
                            this.j = Annotation.newBuilder(this.j).mergeFrom(annotation).buildPartial();
                        }
                        this.b |= 128;
                        return this;
                    }

                    public Builder setArrayDimensionCount(int i2) {
                        this.b |= 512;
                        this.l = i2;
                        return this;
                    }

                    public Builder setClassId(int i2) {
                        this.b |= 32;
                        this.h = i2;
                        return this;
                    }

                    public Builder setDoubleValue(double d2) {
                        this.b |= 8;
                        this.f = d2;
                        return this;
                    }

                    public Builder setEnumValueId(int i2) {
                        this.b |= 64;
                        this.i = i2;
                        return this;
                    }

                    public Builder setFlags(int i2) {
                        this.b |= 1024;
                        this.m = i2;
                        return this;
                    }

                    public Builder setFloatValue(float f2) {
                        this.b |= 4;
                        this.e = f2;
                        return this;
                    }

                    public Builder setIntValue(long j2) {
                        this.b |= 2;
                        this.d = j2;
                        return this;
                    }

                    public Builder setStringValue(int i2) {
                        this.b |= 16;
                        this.g = i2;
                        return this;
                    }

                    public Builder setType(Type type) {
                        Objects.requireNonNull(type);
                        this.b |= 1;
                        this.c = type;
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Value build() {
                        Value buildPartial = buildPartial();
                        if (buildPartial.isInitialized()) {
                            return buildPartial;
                        }
                        throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
                    public Builder clone() {
                        return new Builder().mergeFrom(buildPartial());
                    }

                    public Builder mergeFrom(Value value) {
                        if (value == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (value.hasType()) {
                            setType(value.getType());
                        }
                        if (value.hasIntValue()) {
                            setIntValue(value.getIntValue());
                        }
                        if (value.hasFloatValue()) {
                            setFloatValue(value.getFloatValue());
                        }
                        if (value.hasDoubleValue()) {
                            setDoubleValue(value.getDoubleValue());
                        }
                        if (value.hasStringValue()) {
                            setStringValue(value.getStringValue());
                        }
                        if (value.hasClassId()) {
                            setClassId(value.getClassId());
                        }
                        if (value.hasEnumValueId()) {
                            setEnumValueId(value.getEnumValueId());
                        }
                        if (value.hasAnnotation()) {
                            mergeAnnotation(value.getAnnotation());
                        }
                        if (!value.k.isEmpty()) {
                            if (this.k.isEmpty()) {
                                this.k = value.k;
                                this.b &= -257;
                            } else {
                                if ((this.b & 256) != 256) {
                                    this.k = new ArrayList(this.k);
                                    this.b |= 256;
                                }
                                this.k.addAll(value.k);
                            }
                        }
                        if (value.hasArrayDimensionCount()) {
                            setArrayDimensionCount(value.getArrayDimensionCount());
                        }
                        if (value.hasFlags()) {
                            setFlags(value.getFlags());
                        }
                        setUnknownFields(getUnknownFields().concat(value.a));
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        Throwable th;
                        Value value;
                        Value value2 = null;
                        try {
                            Value parsePartialFrom = Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            value = (Value) e2.getUnfinishedMessage();
                            throw e2;
                        } catch (Throwable th2) {
                            th = th2;
                            value2 = value;
                        }
                        if (value2 != null) {
                            mergeFrom(value2);
                        }
                        throw th;
                    }
                }

                public enum Type implements Internal.EnumLite {
                    BYTE(0),
                    CHAR(1),
                    SHORT(2),
                    INT(3),
                    LONG(4),
                    FLOAT(5),
                    DOUBLE(6),
                    BOOLEAN(7),
                    STRING(8),
                    CLASS(9),
                    ENUM(10),
                    ANNOTATION(11),
                    ARRAY(12);
                    
                    public final int a;

                    /* access modifiers changed from: public */
                    Type(int i) {
                        this.a = i;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.a;
                    }

                    public static Type valueOf(int i) {
                        switch (i) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }
                }

                public static class a extends AbstractParser<Value> {
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                    public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return new Value(codedInputStream, extensionRegistryLite, null);
                    }
                }

                static {
                    Value value = new Value();
                    p = value;
                    value.a();
                }

                public Value(GeneratedMessageLite.Builder builder, a aVar) {
                    super(builder);
                    this.n = -1;
                    this.o = -1;
                    this.a = builder.getUnknownFields();
                }

                public static Value getDefaultInstance() {
                    return p;
                }

                public static Builder newBuilder(Value value) {
                    return newBuilder().mergeFrom(value);
                }

                public final void a() {
                    this.c = Type.BYTE;
                    this.d = 0;
                    this.e = 0.0f;
                    this.f = 0.0d;
                    this.g = 0;
                    this.h = 0;
                    this.i = 0;
                    this.j = Annotation.getDefaultInstance();
                    this.k = Collections.emptyList();
                    this.l = 0;
                    this.m = 0;
                }

                public Annotation getAnnotation() {
                    return this.j;
                }

                public int getArrayDimensionCount() {
                    return this.l;
                }

                public Value getArrayElement(int i2) {
                    return this.k.get(i2);
                }

                public int getArrayElementCount() {
                    return this.k.size();
                }

                public List<Value> getArrayElementList() {
                    return this.k;
                }

                public int getClassId() {
                    return this.h;
                }

                public double getDoubleValue() {
                    return this.f;
                }

                public int getEnumValueId() {
                    return this.i;
                }

                public int getFlags() {
                    return this.m;
                }

                public float getFloatValue() {
                    return this.e;
                }

                public long getIntValue() {
                    return this.d;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public int getSerializedSize() {
                    int i2 = this.o;
                    if (i2 != -1) {
                        return i2;
                    }
                    int computeEnumSize = (this.b & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.c.getNumber()) + 0 : 0;
                    if ((this.b & 2) == 2) {
                        computeEnumSize += CodedOutputStream.computeSInt64Size(2, this.d);
                    }
                    if ((this.b & 4) == 4) {
                        computeEnumSize += CodedOutputStream.computeFloatSize(3, this.e);
                    }
                    if ((this.b & 8) == 8) {
                        computeEnumSize += CodedOutputStream.computeDoubleSize(4, this.f);
                    }
                    if ((this.b & 16) == 16) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(5, this.g);
                    }
                    if ((this.b & 32) == 32) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(6, this.h);
                    }
                    if ((this.b & 64) == 64) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(7, this.i);
                    }
                    if ((this.b & 128) == 128) {
                        computeEnumSize += CodedOutputStream.computeMessageSize(8, this.j);
                    }
                    for (int i3 = 0; i3 < this.k.size(); i3++) {
                        computeEnumSize += CodedOutputStream.computeMessageSize(9, this.k.get(i3));
                    }
                    if ((this.b & 512) == 512) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(10, this.m);
                    }
                    if ((this.b & 256) == 256) {
                        computeEnumSize += CodedOutputStream.computeInt32Size(11, this.l);
                    }
                    int size = this.a.size() + computeEnumSize;
                    this.o = size;
                    return size;
                }

                public int getStringValue() {
                    return this.g;
                }

                public Type getType() {
                    return this.c;
                }

                public boolean hasAnnotation() {
                    return (this.b & 128) == 128;
                }

                public boolean hasArrayDimensionCount() {
                    return (this.b & 256) == 256;
                }

                public boolean hasClassId() {
                    return (this.b & 32) == 32;
                }

                public boolean hasDoubleValue() {
                    return (this.b & 8) == 8;
                }

                public boolean hasEnumValueId() {
                    return (this.b & 64) == 64;
                }

                public boolean hasFlags() {
                    return (this.b & 512) == 512;
                }

                public boolean hasFloatValue() {
                    return (this.b & 4) == 4;
                }

                public boolean hasIntValue() {
                    return (this.b & 2) == 2;
                }

                public boolean hasStringValue() {
                    return (this.b & 16) == 16;
                }

                public boolean hasType() {
                    return (this.b & 1) == 1;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    byte b2 = this.n;
                    if (b2 == 1) {
                        return true;
                    }
                    if (b2 == 0) {
                        return false;
                    }
                    if (!hasAnnotation() || getAnnotation().isInitialized()) {
                        for (int i2 = 0; i2 < getArrayElementCount(); i2++) {
                            if (!getArrayElement(i2).isInitialized()) {
                                this.n = 0;
                                return false;
                            }
                        }
                        this.n = 1;
                        return true;
                    }
                    this.n = 0;
                    return false;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                    getSerializedSize();
                    if ((this.b & 1) == 1) {
                        codedOutputStream.writeEnum(1, this.c.getNumber());
                    }
                    if ((this.b & 2) == 2) {
                        codedOutputStream.writeSInt64(2, this.d);
                    }
                    if ((this.b & 4) == 4) {
                        codedOutputStream.writeFloat(3, this.e);
                    }
                    if ((this.b & 8) == 8) {
                        codedOutputStream.writeDouble(4, this.f);
                    }
                    if ((this.b & 16) == 16) {
                        codedOutputStream.writeInt32(5, this.g);
                    }
                    if ((this.b & 32) == 32) {
                        codedOutputStream.writeInt32(6, this.h);
                    }
                    if ((this.b & 64) == 64) {
                        codedOutputStream.writeInt32(7, this.i);
                    }
                    if ((this.b & 128) == 128) {
                        codedOutputStream.writeMessage(8, this.j);
                    }
                    for (int i2 = 0; i2 < this.k.size(); i2++) {
                        codedOutputStream.writeMessage(9, this.k.get(i2));
                    }
                    if ((this.b & 512) == 512) {
                        codedOutputStream.writeInt32(10, this.m);
                    }
                    if ((this.b & 256) == 256) {
                        codedOutputStream.writeInt32(11, this.l);
                    }
                    codedOutputStream.writeRawBytes(this.a);
                }

                public static Builder newBuilder() {
                    return new Builder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Value getDefaultInstanceForType() {
                    return p;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder toBuilder() {
                    return newBuilder(this);
                }

                public Value() {
                    this.n = -1;
                    this.o = -1;
                    this.a = ByteString.EMPTY;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r5v32, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> */
                /* JADX WARN: Multi-variable type inference failed */
                public Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                    this.n = -1;
                    this.o = -1;
                    a();
                    ByteString.Output newOutput = ByteString.newOutput();
                    CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    int readEnum = codedInputStream.readEnum();
                                    Type valueOf = Type.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                        continue;
                                    } else {
                                        this.b |= 1;
                                        this.c = valueOf;
                                    }
                                case 16:
                                    this.b |= 2;
                                    this.d = codedInputStream.readSInt64();
                                    continue;
                                case 29:
                                    this.b |= 4;
                                    this.e = codedInputStream.readFloat();
                                    continue;
                                case 33:
                                    this.b |= 8;
                                    this.f = codedInputStream.readDouble();
                                    continue;
                                case 40:
                                    this.b |= 16;
                                    this.g = codedInputStream.readInt32();
                                    continue;
                                case 48:
                                    this.b |= 32;
                                    this.h = codedInputStream.readInt32();
                                    continue;
                                case 56:
                                    this.b |= 64;
                                    this.i = codedInputStream.readInt32();
                                    continue;
                                case 66:
                                    Builder builder = (this.b & 128) == 128 ? this.j.toBuilder() : null;
                                    Annotation annotation = (Annotation) codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite);
                                    this.j = annotation;
                                    if (builder != null) {
                                        builder.mergeFrom(annotation);
                                        this.j = builder.buildPartial();
                                    }
                                    this.b |= 128;
                                    continue;
                                case 74:
                                    if (!(z2 & true)) {
                                        this.k = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.k.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                    continue;
                                case 80:
                                    this.b |= 512;
                                    this.m = codedInputStream.readInt32();
                                    continue;
                                case 88:
                                    this.b |= 256;
                                    this.l = codedInputStream.readInt32();
                                    continue;
                                default:
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        } catch (IOException e3) {
                            throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                        } catch (Throwable th) {
                            if (z2 & true) {
                                this.k = Collections.unmodifiableList(this.k);
                            }
                            try {
                                newInstance.flush();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                this.a = newOutput.toByteString();
                                throw th2;
                            }
                            this.a = newOutput.toByteString();
                            makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 & true) {
                        this.k = Collections.unmodifiableList(this.k);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        this.a = newOutput.toByteString();
                        throw th3;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                }
            }

            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            public static class a extends AbstractParser<Argument> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite, null);
                }
            }

            static {
                Argument argument = new Argument();
                g = argument;
                argument.c = 0;
                argument.d = Value.getDefaultInstance();
            }

            public Argument(GeneratedMessageLite.Builder builder, a aVar) {
                super(builder);
                this.e = -1;
                this.f = -1;
                this.a = builder.getUnknownFields();
            }

            public static Argument getDefaultInstance() {
                return g;
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            public int getNameId() {
                return this.c;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.f;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.b & 1) == 1) {
                    i2 = 0 + CodedOutputStream.computeInt32Size(1, this.c);
                }
                if ((this.b & 2) == 2) {
                    i2 += CodedOutputStream.computeMessageSize(2, this.d);
                }
                int size = this.a.size() + i2;
                this.f = size;
                return size;
            }

            public Value getValue() {
                return this.d;
            }

            public boolean hasNameId() {
                return (this.b & 1) == 1;
            }

            public boolean hasValue() {
                return (this.b & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.e;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!hasNameId()) {
                    this.e = 0;
                    return false;
                } else if (!hasValue()) {
                    this.e = 0;
                    return false;
                } else if (!getValue().isInitialized()) {
                    this.e = 0;
                    return false;
                } else {
                    this.e = 1;
                    return true;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.b & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.c);
                }
                if ((this.b & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.d);
                }
                codedOutputStream.writeRawBytes(this.a);
            }

            public static Builder newBuilder() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return g;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            public Argument() {
                this.e = -1;
                this.f = -1;
                this.a = ByteString.EMPTY;
            }

            public Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this.e = -1;
                this.f = -1;
                boolean z = false;
                this.c = 0;
                this.d = Value.getDefaultInstance();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.b |= 1;
                                this.c = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                Value.Builder builder = (this.b & 2) == 2 ? this.d.toBuilder() : null;
                                Value value = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                                this.d = value;
                                if (builder != null) {
                                    builder.mergeFrom(value);
                                    this.d = builder.buildPartial();
                                }
                                this.b |= 2;
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.a = newOutput.toByteString();
                            throw th2;
                        }
                        this.a = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.a = newOutput.toByteString();
                    throw th3;
                }
                this.a = newOutput.toByteString();
                makeExtensionsImmutable();
            }
        }

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            public int b;
            public int c;
            public List<Argument> d = Collections.emptyList();

            public Annotation buildPartial() {
                Annotation annotation = new Annotation(this, null);
                int i = this.b;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                annotation.c = this.c;
                if ((i & 2) == 2) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.b &= -3;
                }
                annotation.d = this.d;
                annotation.b = i2;
                return annotation;
            }

            public Argument getArgument(int i) {
                return this.d.get(i);
            }

            public int getArgumentCount() {
                return this.d.size();
            }

            public boolean hasId() {
                return (this.b & 1) == 1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                for (int i = 0; i < getArgumentCount(); i++) {
                    if (!getArgument(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder setId(int i) {
                this.b |= 1;
                this.c = i;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Annotation build() {
                Annotation buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Annotation annotation) {
                if (annotation == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (annotation.hasId()) {
                    setId(annotation.getId());
                }
                if (!annotation.d.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = annotation.d;
                        this.b &= -3;
                    } else {
                        if ((this.b & 2) != 2) {
                            this.d = new ArrayList(this.d);
                            this.b |= 2;
                        }
                        this.d.addAll(annotation.d);
                    }
                }
                setUnknownFields(getUnknownFields().concat(annotation.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Annotation annotation;
                Annotation annotation2 = null;
                try {
                    Annotation parsePartialFrom = Annotation.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    annotation = (Annotation) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    annotation2 = annotation;
                }
                if (annotation2 != null) {
                    mergeFrom(annotation2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<Annotation> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Annotation(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Annotation annotation = new Annotation();
            g = annotation;
            annotation.c = 0;
            annotation.d = Collections.emptyList();
        }

        public Annotation(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.e = -1;
            this.f = -1;
            this.a = builder.getUnknownFields();
        }

        public static Annotation getDefaultInstance() {
            return g;
        }

        public static Builder newBuilder(Annotation annotation) {
            return newBuilder().mergeFrom(annotation);
        }

        public Argument getArgument(int i) {
            return this.d.get(i);
        }

        public int getArgumentCount() {
            return this.d.size();
        }

        public List<Argument> getArgumentList() {
            return this.d;
        }

        public int getId() {
            return this.c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.b & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.c) + 0 : 0;
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.d.get(i2));
            }
            int size = this.a.size() + computeInt32Size;
            this.f = size;
            return size;
        }

        public boolean hasId() {
            return (this.b & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.e;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasId()) {
                this.e = 0;
                return false;
            }
            for (int i = 0; i < getArgumentCount(); i++) {
                if (!getArgument(i).isInitialized()) {
                    this.e = 0;
                    return false;
                }
            }
            this.e = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.b & 1) == 1) {
                codedOutputStream.writeInt32(1, this.c);
            }
            for (int i = 0; i < this.d.size(); i++) {
                codedOutputStream.writeMessage(2, this.d.get(i));
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Annotation getDefaultInstanceForType() {
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Annotation() {
            this.e = -1;
            this.f = -1;
            this.a = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument> */
        /* JADX WARN: Multi-variable type inference failed */
        public Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.e = -1;
            this.f = -1;
            boolean z = false;
            this.c = 0;
            this.d = Collections.emptyList();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.b |= 1;
                            this.c = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            if (!(z2 & true)) {
                                this.d = new ArrayList();
                                z2 |= true;
                            }
                            this.d.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.d = Collections.unmodifiableList(this.d);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.d = Collections.unmodifiableList(this.d);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements ClassOrBuilder {
        public static Parser<Class> PARSER = new a();
        public static final Class y;
        public final ByteString b;
        public int c;
        public int d;
        public int e;
        public int f;
        public List<TypeParameter> g;
        public List<Type> h;
        public List<Integer> i;
        public int j;
        public List<Integer> k;
        public int l;
        public List<Constructor> m;
        public List<Function> n;
        public List<Property> o;
        public List<TypeAlias> p;
        public List<EnumEntry> q;
        public List<Integer> r;
        public int s;
        public TypeTable t;
        public List<Integer> u;
        public VersionRequirementTable v;
        public byte w;
        public int x;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            public int d;
            public int e = 6;
            public int f;
            public int g;
            public List<TypeParameter> h = Collections.emptyList();
            public List<Type> i = Collections.emptyList();
            public List<Integer> j = Collections.emptyList();
            public List<Integer> k = Collections.emptyList();
            public List<Constructor> l = Collections.emptyList();
            public List<Function> m = Collections.emptyList();
            public List<Property> n = Collections.emptyList();
            public List<TypeAlias> o = Collections.emptyList();
            public List<EnumEntry> p = Collections.emptyList();
            public List<Integer> q = Collections.emptyList();
            public TypeTable r = TypeTable.getDefaultInstance();
            public List<Integer> s = Collections.emptyList();
            public VersionRequirementTable t = VersionRequirementTable.getDefaultInstance();

            public Class buildPartial() {
                Class r0 = new Class(this, (a) null);
                int i2 = this.d;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                r0.d = this.e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                r0.e = this.f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                r0.f = this.g;
                if ((i2 & 8) == 8) {
                    this.h = Collections.unmodifiableList(this.h);
                    this.d &= -9;
                }
                r0.g = this.h;
                if ((this.d & 16) == 16) {
                    this.i = Collections.unmodifiableList(this.i);
                    this.d &= -17;
                }
                r0.h = this.i;
                if ((this.d & 32) == 32) {
                    this.j = Collections.unmodifiableList(this.j);
                    this.d &= -33;
                }
                r0.i = this.j;
                if ((this.d & 64) == 64) {
                    this.k = Collections.unmodifiableList(this.k);
                    this.d &= -65;
                }
                r0.k = this.k;
                if ((this.d & 128) == 128) {
                    this.l = Collections.unmodifiableList(this.l);
                    this.d &= -129;
                }
                r0.m = this.l;
                if ((this.d & 256) == 256) {
                    this.m = Collections.unmodifiableList(this.m);
                    this.d &= -257;
                }
                r0.n = this.m;
                if ((this.d & 512) == 512) {
                    this.n = Collections.unmodifiableList(this.n);
                    this.d &= -513;
                }
                r0.o = this.n;
                if ((this.d & 1024) == 1024) {
                    this.o = Collections.unmodifiableList(this.o);
                    this.d &= -1025;
                }
                r0.p = this.o;
                if ((this.d & 2048) == 2048) {
                    this.p = Collections.unmodifiableList(this.p);
                    this.d &= -2049;
                }
                r0.q = this.p;
                if ((this.d & 4096) == 4096) {
                    this.q = Collections.unmodifiableList(this.q);
                    this.d &= -4097;
                }
                r0.r = this.q;
                if ((i2 & 8192) == 8192) {
                    i3 |= 8;
                }
                r0.t = this.r;
                if ((this.d & 16384) == 16384) {
                    this.s = Collections.unmodifiableList(this.s);
                    this.d &= -16385;
                }
                r0.u = this.s;
                if ((i2 & 32768) == 32768) {
                    i3 |= 16;
                }
                r0.v = this.t;
                r0.c = i3;
                return r0;
            }

            public Constructor getConstructor(int i2) {
                return this.l.get(i2);
            }

            public int getConstructorCount() {
                return this.l.size();
            }

            public EnumEntry getEnumEntry(int i2) {
                return this.p.get(i2);
            }

            public int getEnumEntryCount() {
                return this.p.size();
            }

            public Function getFunction(int i2) {
                return this.m.get(i2);
            }

            public int getFunctionCount() {
                return this.m.size();
            }

            public Property getProperty(int i2) {
                return this.n.get(i2);
            }

            public int getPropertyCount() {
                return this.n.size();
            }

            public Type getSupertype(int i2) {
                return this.i.get(i2);
            }

            public int getSupertypeCount() {
                return this.i.size();
            }

            public TypeAlias getTypeAlias(int i2) {
                return this.o.get(i2);
            }

            public int getTypeAliasCount() {
                return this.o.size();
            }

            public TypeParameter getTypeParameter(int i2) {
                return this.h.get(i2);
            }

            public int getTypeParameterCount() {
                return this.h.size();
            }

            public TypeTable getTypeTable() {
                return this.r;
            }

            public boolean hasFqName() {
                return (this.d & 2) == 2;
            }

            public boolean hasTypeTable() {
                return (this.d & 8192) == 8192;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasFqName()) {
                    return false;
                }
                for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                    if (!getTypeParameter(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getSupertypeCount(); i3++) {
                    if (!getSupertype(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i4 = 0; i4 < getConstructorCount(); i4++) {
                    if (!getConstructor(i4).isInitialized()) {
                        return false;
                    }
                }
                for (int i5 = 0; i5 < getFunctionCount(); i5++) {
                    if (!getFunction(i5).isInitialized()) {
                        return false;
                    }
                }
                for (int i6 = 0; i6 < getPropertyCount(); i6++) {
                    if (!getProperty(i6).isInitialized()) {
                        return false;
                    }
                }
                for (int i7 = 0; i7 < getTypeAliasCount(); i7++) {
                    if (!getTypeAlias(i7).isInitialized()) {
                        return false;
                    }
                }
                for (int i8 = 0; i8 < getEnumEntryCount(); i8++) {
                    if (!getEnumEntry(i8).isInitialized()) {
                        return false;
                    }
                }
                if ((!hasTypeTable() || getTypeTable().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.d & 8192) != 8192 || this.r == TypeTable.getDefaultInstance()) {
                    this.r = typeTable;
                } else {
                    this.r = TypeTable.newBuilder(this.r).mergeFrom(typeTable).buildPartial();
                }
                this.d |= 8192;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.d & 32768) != 32768 || this.t == VersionRequirementTable.getDefaultInstance()) {
                    this.t = versionRequirementTable;
                } else {
                    this.t = VersionRequirementTable.newBuilder(this.t).mergeFrom(versionRequirementTable).buildPartial();
                }
                this.d |= 32768;
                return this;
            }

            public Builder setCompanionObjectName(int i2) {
                this.d |= 4;
                this.g = i2;
                return this;
            }

            public Builder setFlags(int i2) {
                this.d |= 1;
                this.e = i2;
                return this;
            }

            public Builder setFqName(int i2) {
                this.d |= 2;
                this.f = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Class build() {
                Class buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            public Builder mergeFrom(Class r4) {
                if (r4 == Class.getDefaultInstance()) {
                    return this;
                }
                if (r4.hasFlags()) {
                    setFlags(r4.getFlags());
                }
                if (r4.hasFqName()) {
                    setFqName(r4.getFqName());
                }
                if (r4.hasCompanionObjectName()) {
                    setCompanionObjectName(r4.getCompanionObjectName());
                }
                if (!r4.g.isEmpty()) {
                    if (this.h.isEmpty()) {
                        this.h = r4.g;
                        this.d &= -9;
                    } else {
                        if ((this.d & 8) != 8) {
                            this.h = new ArrayList(this.h);
                            this.d |= 8;
                        }
                        this.h.addAll(r4.g);
                    }
                }
                if (!r4.h.isEmpty()) {
                    if (this.i.isEmpty()) {
                        this.i = r4.h;
                        this.d &= -17;
                    } else {
                        if ((this.d & 16) != 16) {
                            this.i = new ArrayList(this.i);
                            this.d |= 16;
                        }
                        this.i.addAll(r4.h);
                    }
                }
                if (!r4.i.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = r4.i;
                        this.d &= -33;
                    } else {
                        if ((this.d & 32) != 32) {
                            this.j = new ArrayList(this.j);
                            this.d |= 32;
                        }
                        this.j.addAll(r4.i);
                    }
                }
                if (!r4.k.isEmpty()) {
                    if (this.k.isEmpty()) {
                        this.k = r4.k;
                        this.d &= -65;
                    } else {
                        if ((this.d & 64) != 64) {
                            this.k = new ArrayList(this.k);
                            this.d |= 64;
                        }
                        this.k.addAll(r4.k);
                    }
                }
                if (!r4.m.isEmpty()) {
                    if (this.l.isEmpty()) {
                        this.l = r4.m;
                        this.d &= -129;
                    } else {
                        if ((this.d & 128) != 128) {
                            this.l = new ArrayList(this.l);
                            this.d |= 128;
                        }
                        this.l.addAll(r4.m);
                    }
                }
                if (!r4.n.isEmpty()) {
                    if (this.m.isEmpty()) {
                        this.m = r4.n;
                        this.d &= -257;
                    } else {
                        if ((this.d & 256) != 256) {
                            this.m = new ArrayList(this.m);
                            this.d |= 256;
                        }
                        this.m.addAll(r4.n);
                    }
                }
                if (!r4.o.isEmpty()) {
                    if (this.n.isEmpty()) {
                        this.n = r4.o;
                        this.d &= -513;
                    } else {
                        if ((this.d & 512) != 512) {
                            this.n = new ArrayList(this.n);
                            this.d |= 512;
                        }
                        this.n.addAll(r4.o);
                    }
                }
                if (!r4.p.isEmpty()) {
                    if (this.o.isEmpty()) {
                        this.o = r4.p;
                        this.d &= -1025;
                    } else {
                        if ((this.d & 1024) != 1024) {
                            this.o = new ArrayList(this.o);
                            this.d |= 1024;
                        }
                        this.o.addAll(r4.p);
                    }
                }
                if (!r4.q.isEmpty()) {
                    if (this.p.isEmpty()) {
                        this.p = r4.q;
                        this.d &= -2049;
                    } else {
                        if ((this.d & 2048) != 2048) {
                            this.p = new ArrayList(this.p);
                            this.d |= 2048;
                        }
                        this.p.addAll(r4.q);
                    }
                }
                if (!r4.r.isEmpty()) {
                    if (this.q.isEmpty()) {
                        this.q = r4.r;
                        this.d &= -4097;
                    } else {
                        if ((this.d & 4096) != 4096) {
                            this.q = new ArrayList(this.q);
                            this.d |= 4096;
                        }
                        this.q.addAll(r4.r);
                    }
                }
                if (r4.hasTypeTable()) {
                    mergeTypeTable(r4.getTypeTable());
                }
                if (!r4.u.isEmpty()) {
                    if (this.s.isEmpty()) {
                        this.s = r4.u;
                        this.d &= -16385;
                    } else {
                        if ((this.d & 16384) != 16384) {
                            this.s = new ArrayList(this.s);
                            this.d |= 16384;
                        }
                        this.s.addAll(r4.u);
                    }
                }
                if (r4.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(r4.getVersionRequirementTable());
                }
                mergeExtensionFields(r4);
                setUnknownFields(getUnknownFields().concat(r4.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Class r4;
                Class r0 = null;
                try {
                    Class parsePartialFrom = Class.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    r4 = (Class) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    r0 = r4;
                }
                if (r0 != null) {
                    mergeFrom(r0);
                }
                throw th;
            }
        }

        public enum Kind implements Internal.EnumLite {
            CLASS(0),
            INTERFACE(1),
            ENUM_CLASS(2),
            ENUM_ENTRY(3),
            ANNOTATION_CLASS(4),
            OBJECT(5),
            COMPANION_OBJECT(6);
            
            public final int a;

            /* access modifiers changed from: public */
            Kind(int i) {
                this.a = i;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.a;
            }

            public static Kind valueOf(int i) {
                switch (i) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }
        }

        public static class a extends AbstractParser<Class> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Class(codedInputStream, extensionRegistryLite);
            }
        }

        static {
            Class r0 = new Class();
            y = r0;
            r0.b();
        }

        public Class(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.j = -1;
            this.l = -1;
            this.s = -1;
            this.w = -1;
            this.x = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static Class getDefaultInstance() {
            return y;
        }

        public static Builder newBuilder(Class r1) {
            return newBuilder().mergeFrom(r1);
        }

        public static Class parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public final void b() {
            this.d = 6;
            this.e = 0;
            this.f = 0;
            this.g = Collections.emptyList();
            this.h = Collections.emptyList();
            this.i = Collections.emptyList();
            this.k = Collections.emptyList();
            this.m = Collections.emptyList();
            this.n = Collections.emptyList();
            this.o = Collections.emptyList();
            this.p = Collections.emptyList();
            this.q = Collections.emptyList();
            this.r = Collections.emptyList();
            this.t = TypeTable.getDefaultInstance();
            this.u = Collections.emptyList();
            this.v = VersionRequirementTable.getDefaultInstance();
        }

        public int getCompanionObjectName() {
            return this.f;
        }

        public Constructor getConstructor(int i2) {
            return this.m.get(i2);
        }

        public int getConstructorCount() {
            return this.m.size();
        }

        public List<Constructor> getConstructorList() {
            return this.m;
        }

        public EnumEntry getEnumEntry(int i2) {
            return this.q.get(i2);
        }

        public int getEnumEntryCount() {
            return this.q.size();
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.q;
        }

        public int getFlags() {
            return this.d;
        }

        public int getFqName() {
            return this.e;
        }

        public Function getFunction(int i2) {
            return this.n.get(i2);
        }

        public int getFunctionCount() {
            return this.n.size();
        }

        public List<Function> getFunctionList() {
            return this.n;
        }

        public List<Integer> getNestedClassNameList() {
            return this.k;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Class> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i2) {
            return this.o.get(i2);
        }

        public int getPropertyCount() {
            return this.o.size();
        }

        public List<Property> getPropertyList() {
            return this.o;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.r;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.x;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.c & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.d) + 0 : 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.i.size(); i4++) {
                i3 += CodedOutputStream.computeInt32SizeNoTag(this.i.get(i4).intValue());
            }
            int i5 = computeInt32Size + i3;
            if (!getSupertypeIdList().isEmpty()) {
                i5 = i5 + 1 + CodedOutputStream.computeInt32SizeNoTag(i3);
            }
            this.j = i3;
            if ((this.c & 2) == 2) {
                i5 += CodedOutputStream.computeInt32Size(3, this.e);
            }
            if ((this.c & 4) == 4) {
                i5 += CodedOutputStream.computeInt32Size(4, this.f);
            }
            for (int i6 = 0; i6 < this.g.size(); i6++) {
                i5 += CodedOutputStream.computeMessageSize(5, this.g.get(i6));
            }
            for (int i7 = 0; i7 < this.h.size(); i7++) {
                i5 += CodedOutputStream.computeMessageSize(6, this.h.get(i7));
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.k.size(); i9++) {
                i8 += CodedOutputStream.computeInt32SizeNoTag(this.k.get(i9).intValue());
            }
            int i10 = i5 + i8;
            if (!getNestedClassNameList().isEmpty()) {
                i10 = i10 + 1 + CodedOutputStream.computeInt32SizeNoTag(i8);
            }
            this.l = i8;
            for (int i11 = 0; i11 < this.m.size(); i11++) {
                i10 += CodedOutputStream.computeMessageSize(8, this.m.get(i11));
            }
            for (int i12 = 0; i12 < this.n.size(); i12++) {
                i10 += CodedOutputStream.computeMessageSize(9, this.n.get(i12));
            }
            for (int i13 = 0; i13 < this.o.size(); i13++) {
                i10 += CodedOutputStream.computeMessageSize(10, this.o.get(i13));
            }
            for (int i14 = 0; i14 < this.p.size(); i14++) {
                i10 += CodedOutputStream.computeMessageSize(11, this.p.get(i14));
            }
            for (int i15 = 0; i15 < this.q.size(); i15++) {
                i10 += CodedOutputStream.computeMessageSize(13, this.q.get(i15));
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.r.size(); i17++) {
                i16 += CodedOutputStream.computeInt32SizeNoTag(this.r.get(i17).intValue());
            }
            int i18 = i10 + i16;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                i18 = i18 + 2 + CodedOutputStream.computeInt32SizeNoTag(i16);
            }
            this.s = i16;
            if ((this.c & 8) == 8) {
                i18 += CodedOutputStream.computeMessageSize(30, this.t);
            }
            int i19 = 0;
            for (int i20 = 0; i20 < this.u.size(); i20++) {
                i19 += CodedOutputStream.computeInt32SizeNoTag(this.u.get(i20).intValue());
            }
            int size = (getVersionRequirementList().size() * 2) + i18 + i19;
            if ((this.c & 16) == 16) {
                size += CodedOutputStream.computeMessageSize(32, this.v);
            }
            int size2 = this.b.size() + extensionsSerializedSize() + size;
            this.x = size2;
            return size2;
        }

        public Type getSupertype(int i2) {
            return this.h.get(i2);
        }

        public int getSupertypeCount() {
            return this.h.size();
        }

        public List<Integer> getSupertypeIdList() {
            return this.i;
        }

        public List<Type> getSupertypeList() {
            return this.h;
        }

        public TypeAlias getTypeAlias(int i2) {
            return this.p.get(i2);
        }

        public int getTypeAliasCount() {
            return this.p.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.p;
        }

        public TypeParameter getTypeParameter(int i2) {
            return this.g.get(i2);
        }

        public int getTypeParameterCount() {
            return this.g.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.g;
        }

        public TypeTable getTypeTable() {
            return this.t;
        }

        public List<Integer> getVersionRequirementList() {
            return this.u;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.v;
        }

        public boolean hasCompanionObjectName() {
            return (this.c & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.c & 1) == 1;
        }

        public boolean hasFqName() {
            return (this.c & 2) == 2;
        }

        public boolean hasTypeTable() {
            return (this.c & 8) == 8;
        }

        public boolean hasVersionRequirementTable() {
            return (this.c & 16) == 16;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.w;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasFqName()) {
                this.w = 0;
                return false;
            }
            for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                if (!getTypeParameter(i2).isInitialized()) {
                    this.w = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getSupertypeCount(); i3++) {
                if (!getSupertype(i3).isInitialized()) {
                    this.w = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getConstructorCount(); i4++) {
                if (!getConstructor(i4).isInitialized()) {
                    this.w = 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < getFunctionCount(); i5++) {
                if (!getFunction(i5).isInitialized()) {
                    this.w = 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < getPropertyCount(); i6++) {
                if (!getProperty(i6).isInitialized()) {
                    this.w = 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getTypeAliasCount(); i7++) {
                if (!getTypeAlias(i7).isInitialized()) {
                    this.w = 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getEnumEntryCount(); i8++) {
                if (!getEnumEntry(i8).isInitialized()) {
                    this.w = 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.w = 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.w = 0;
                return false;
            } else {
                this.w = 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.d);
            }
            if (getSupertypeIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(18);
                codedOutputStream.writeRawVarint32(this.j);
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.i.get(i2).intValue());
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt32(3, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeInt32(4, this.f);
            }
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                codedOutputStream.writeMessage(5, this.g.get(i3));
            }
            for (int i4 = 0; i4 < this.h.size(); i4++) {
                codedOutputStream.writeMessage(6, this.h.get(i4));
            }
            if (getNestedClassNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(58);
                codedOutputStream.writeRawVarint32(this.l);
            }
            for (int i5 = 0; i5 < this.k.size(); i5++) {
                codedOutputStream.writeInt32NoTag(this.k.get(i5).intValue());
            }
            for (int i6 = 0; i6 < this.m.size(); i6++) {
                codedOutputStream.writeMessage(8, this.m.get(i6));
            }
            for (int i7 = 0; i7 < this.n.size(); i7++) {
                codedOutputStream.writeMessage(9, this.n.get(i7));
            }
            for (int i8 = 0; i8 < this.o.size(); i8++) {
                codedOutputStream.writeMessage(10, this.o.get(i8));
            }
            for (int i9 = 0; i9 < this.p.size(); i9++) {
                codedOutputStream.writeMessage(11, this.p.get(i9));
            }
            for (int i10 = 0; i10 < this.q.size(); i10++) {
                codedOutputStream.writeMessage(13, this.q.get(i10));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(130);
                codedOutputStream.writeRawVarint32(this.s);
            }
            for (int i11 = 0; i11 < this.r.size(); i11++) {
                codedOutputStream.writeInt32NoTag(this.r.get(i11).intValue());
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeMessage(30, this.t);
            }
            for (int i12 = 0; i12 < this.u.size(); i12++) {
                codedOutputStream.writeInt32(31, this.u.get(i12).intValue());
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeMessage(32, this.v);
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Class getDefaultInstanceForType() {
            return y;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Class() {
            this.j = -1;
            this.l = -1;
            this.s = -1;
            this.w = -1;
            this.x = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v23, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v26, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v34, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v37, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v40, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v43, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v46, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> */
        /* JADX WARN: Multi-variable type inference failed */
        public Class(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.j = -1;
            this.l = -1;
            this.s = -1;
            this.w = -1;
            this.x = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    TypeTable.Builder builder = null;
                    VersionRequirementTable.Builder builder2 = null;
                    switch (readTag) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.c |= 1;
                            this.d = codedInputStream.readInt32();
                            break;
                        case 16:
                            if (!(z2 & true)) {
                                this.i = new ArrayList();
                                z2 |= true;
                            }
                            this.i.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 18:
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.i = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.i.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                            break;
                        case 24:
                            this.c |= 2;
                            this.e = codedInputStream.readInt32();
                            break;
                        case 32:
                            this.c |= 4;
                            this.f = codedInputStream.readInt32();
                            break;
                        case 42:
                            if (!(z2 & true)) {
                                this.g = new ArrayList();
                                z2 |= true;
                            }
                            this.g.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                            break;
                        case 50:
                            if (!(z2 & true)) {
                                this.h = new ArrayList();
                                z2 |= true;
                            }
                            this.h.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                            break;
                        case 56:
                            if (!(z2 & true)) {
                                this.k = new ArrayList();
                                z2 |= true;
                            }
                            this.k.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 58:
                            int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.k = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.k.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit2);
                            break;
                        case 66:
                            if (!(z2 & true)) {
                                this.m = new ArrayList();
                                z2 |= true;
                            }
                            this.m.add(codedInputStream.readMessage(Constructor.PARSER, extensionRegistryLite));
                            break;
                        case 74:
                            if (!(z2 & true)) {
                                this.n = new ArrayList();
                                z2 |= true;
                            }
                            this.n.add(codedInputStream.readMessage(Function.PARSER, extensionRegistryLite));
                            break;
                        case 82:
                            if (!(z2 & true)) {
                                this.o = new ArrayList();
                                z2 |= true;
                            }
                            this.o.add(codedInputStream.readMessage(Property.PARSER, extensionRegistryLite));
                            break;
                        case 90:
                            if (!(z2 & true)) {
                                this.p = new ArrayList();
                                z2 |= true;
                            }
                            this.p.add(codedInputStream.readMessage(TypeAlias.PARSER, extensionRegistryLite));
                            break;
                        case 106:
                            if (!(z2 & true)) {
                                this.q = new ArrayList();
                                z2 |= true;
                            }
                            this.q.add(codedInputStream.readMessage(EnumEntry.PARSER, extensionRegistryLite));
                            break;
                        case 128:
                            if (!(z2 & true)) {
                                this.r = new ArrayList();
                                z2 |= true;
                            }
                            this.r.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 130:
                            int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.r = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.r.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit3);
                            break;
                        case 242:
                            builder = (this.c & 8) == 8 ? this.t.toBuilder() : builder;
                            TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                            this.t = typeTable;
                            if (builder != null) {
                                builder.mergeFrom(typeTable);
                                this.t = builder.buildPartial();
                            }
                            this.c |= 8;
                            break;
                        case 248:
                            if (!(z2 & true)) {
                                this.u = new ArrayList();
                                z2 |= true;
                            }
                            this.u.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 250:
                            int pushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.u = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.u.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit4);
                            break;
                        case 258:
                            builder2 = (this.c & 16) == 16 ? this.v.toBuilder() : builder2;
                            VersionRequirementTable versionRequirementTable = (VersionRequirementTable) codedInputStream.readMessage(VersionRequirementTable.PARSER, extensionRegistryLite);
                            this.v = versionRequirementTable;
                            if (builder2 != null) {
                                builder2.mergeFrom(versionRequirementTable);
                                this.v = builder2.buildPartial();
                            }
                            this.c |= 16;
                            break;
                        default:
                            if (parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            }
                            z = true;
                            break;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if (z2 & true) {
                        this.g = Collections.unmodifiableList(this.g);
                    }
                    if (z2 & true) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    if (z2 & true) {
                        this.k = Collections.unmodifiableList(this.k);
                    }
                    if (z2 & true) {
                        this.m = Collections.unmodifiableList(this.m);
                    }
                    if (z2 & true) {
                        this.n = Collections.unmodifiableList(this.n);
                    }
                    if (z2 & true) {
                        this.o = Collections.unmodifiableList(this.o);
                    }
                    if (z2 & true) {
                        this.p = Collections.unmodifiableList(this.p);
                    }
                    if (z2 & true) {
                        this.q = Collections.unmodifiableList(this.q);
                    }
                    if (z2 & true) {
                        this.r = Collections.unmodifiableList(this.r);
                    }
                    if (z2 & true) {
                        this.u = Collections.unmodifiableList(this.u);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.i = Collections.unmodifiableList(this.i);
            }
            if (z2 & true) {
                this.g = Collections.unmodifiableList(this.g);
            }
            if (z2 & true) {
                this.h = Collections.unmodifiableList(this.h);
            }
            if (z2 & true) {
                this.k = Collections.unmodifiableList(this.k);
            }
            if (z2 & true) {
                this.m = Collections.unmodifiableList(this.m);
            }
            if (z2 & true) {
                this.n = Collections.unmodifiableList(this.n);
            }
            if (z2 & true) {
                this.o = Collections.unmodifiableList(this.o);
            }
            if (z2 & true) {
                this.p = Collections.unmodifiableList(this.p);
            }
            if (z2 & true) {
                this.q = Collections.unmodifiableList(this.q);
            }
            if (z2 & true) {
                this.r = Collections.unmodifiableList(this.r);
            }
            if (z2 & true) {
                this.u = Collections.unmodifiableList(this.u);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ClassOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static Parser<Constructor> PARSER = new a();
        public static final Constructor i;
        public final ByteString b;
        public int c;
        public int d;
        public List<ValueParameter> e;
        public List<Integer> f;
        public byte g;
        public int h;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            public int d;
            public int e = 6;
            public List<ValueParameter> f = Collections.emptyList();
            public List<Integer> g = Collections.emptyList();

            public Constructor buildPartial() {
                Constructor constructor = new Constructor(this, null);
                int i = this.d;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                constructor.d = this.e;
                if ((i & 2) == 2) {
                    this.f = Collections.unmodifiableList(this.f);
                    this.d &= -3;
                }
                constructor.e = this.f;
                if ((this.d & 4) == 4) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.d &= -5;
                }
                constructor.f = this.g;
                constructor.c = i2;
                return constructor;
            }

            public ValueParameter getValueParameter(int i) {
                return this.f.get(i);
            }

            public int getValueParameterCount() {
                return this.f.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getValueParameterCount(); i++) {
                    if (!getValueParameter(i).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder setFlags(int i) {
                this.d |= 1;
                this.e = i;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Constructor build() {
                Constructor buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            public Builder mergeFrom(Constructor constructor) {
                if (constructor == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (constructor.hasFlags()) {
                    setFlags(constructor.getFlags());
                }
                if (!constructor.e.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = constructor.e;
                        this.d &= -3;
                    } else {
                        if ((this.d & 2) != 2) {
                            this.f = new ArrayList(this.f);
                            this.d |= 2;
                        }
                        this.f.addAll(constructor.e);
                    }
                }
                if (!constructor.f.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = constructor.f;
                        this.d &= -5;
                    } else {
                        if ((this.d & 4) != 4) {
                            this.g = new ArrayList(this.g);
                            this.d |= 4;
                        }
                        this.g.addAll(constructor.f);
                    }
                }
                mergeExtensionFields(constructor);
                setUnknownFields(getUnknownFields().concat(constructor.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Constructor constructor;
                Constructor constructor2 = null;
                try {
                    Constructor parsePartialFrom = Constructor.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    constructor = (Constructor) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    constructor2 = constructor;
                }
                if (constructor2 != null) {
                    mergeFrom(constructor2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<Constructor> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Constructor(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Constructor constructor = new Constructor();
            i = constructor;
            constructor.d = 6;
            constructor.e = Collections.emptyList();
            constructor.f = Collections.emptyList();
        }

        public Constructor(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.g = -1;
            this.h = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static Constructor getDefaultInstance() {
            return i;
        }

        public static Builder newBuilder(Constructor constructor) {
            return newBuilder().mergeFrom(constructor);
        }

        public int getFlags() {
            return this.d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.h;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.c & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.d) + 0 : 0;
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.e.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.f.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.f.get(i5).intValue());
            }
            int size = this.b.size() + extensionsSerializedSize() + (getVersionRequirementList().size() * 2) + computeInt32Size + i4;
            this.h = size;
            return size;
        }

        public ValueParameter getValueParameter(int i2) {
            return this.e.get(i2);
        }

        public int getValueParameterCount() {
            return this.e.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.e;
        }

        public List<Integer> getVersionRequirementList() {
            return this.f;
        }

        public boolean hasFlags() {
            return (this.c & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.g;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < getValueParameterCount(); i2++) {
                if (!getValueParameter(i2).isInitialized()) {
                    this.g = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.g = 0;
                return false;
            }
            this.g = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.d);
            }
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                codedOutputStream.writeMessage(2, this.e.get(i2));
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                codedOutputStream.writeInt32(31, this.f.get(i3).intValue());
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Constructor getDefaultInstanceForType() {
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Constructor() {
            this.g = -1;
            this.h = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> */
        /* JADX WARN: Multi-variable type inference failed */
        public Constructor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.g = -1;
            this.h = -1;
            this.d = 6;
            this.e = Collections.emptyList();
            this.f = Collections.emptyList();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.c |= 1;
                            this.d = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            if (!(z2 & true)) {
                                this.e = new ArrayList();
                                z2 |= true;
                            }
                            this.e.add(codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite));
                        } else if (readTag == 248) {
                            if (!(z2 & true)) {
                                this.f = new ArrayList();
                                z2 |= true;
                            }
                            this.f.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag == 250) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.f = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.f.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    if (z2 & true) {
                        this.f = Collections.unmodifiableList(this.f);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.e = Collections.unmodifiableList(this.e);
            }
            if (z2 & true) {
                this.f = Collections.unmodifiableList(this.f);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ConstructorOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Contract extends GeneratedMessageLite implements ContractOrBuilder {
        public static Parser<Contract> PARSER = new a();
        public static final Contract e;
        public final ByteString a;
        public List<Effect> b;
        public byte c;
        public int d;

        public static final class Builder extends GeneratedMessageLite.Builder<Contract, Builder> implements ContractOrBuilder {
            public int b;
            public List<Effect> c = Collections.emptyList();

            public Contract buildPartial() {
                Contract contract = new Contract(this, null);
                if ((this.b & 1) == 1) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.b &= -2;
                }
                contract.b = this.c;
                return contract;
            }

            public Effect getEffect(int i) {
                return this.c.get(i);
            }

            public int getEffectCount() {
                return this.c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getEffectCount(); i++) {
                    if (!getEffect(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Contract build() {
                Contract buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Contract contract) {
                if (contract == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!contract.b.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = contract.b;
                        this.b &= -2;
                    } else {
                        if ((this.b & 1) != 1) {
                            this.c = new ArrayList(this.c);
                            this.b |= 1;
                        }
                        this.c.addAll(contract.b);
                    }
                }
                setUnknownFields(getUnknownFields().concat(contract.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Contract contract;
                Contract contract2 = null;
                try {
                    Contract parsePartialFrom = Contract.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    contract = (Contract) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    contract2 = contract;
                }
                if (contract2 != null) {
                    mergeFrom(contract2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<Contract> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Contract(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Contract contract = new Contract();
            e = contract;
            contract.b = Collections.emptyList();
        }

        public Contract(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.c = -1;
            this.d = -1;
            this.a = builder.getUnknownFields();
        }

        public static Contract getDefaultInstance() {
            return e;
        }

        public static Builder newBuilder(Contract contract) {
            return newBuilder().mergeFrom(contract);
        }

        public Effect getEffect(int i) {
            return this.b.get(i);
        }

        public int getEffectCount() {
            return this.b.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.d;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.b.get(i3));
            }
            int size = this.a.size() + i2;
            this.d = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.c;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < getEffectCount(); i++) {
                if (!getEffect(i).isInitialized()) {
                    this.c = 0;
                    return false;
                }
            }
            this.c = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.b.size(); i++) {
                codedOutputStream.writeMessage(1, this.b.get(i));
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Contract getDefaultInstanceForType() {
            return e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Contract() {
            this.c = -1;
            this.d = -1;
            this.a = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect> */
        /* JADX WARN: Multi-variable type inference failed */
        public Contract(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.c = -1;
            this.d = -1;
            this.b = Collections.emptyList();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.b = new ArrayList();
                                z2 |= true;
                            }
                            this.b.add(codedInputStream.readMessage(Effect.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.b = Collections.unmodifiableList(this.b);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.b = Collections.unmodifiableList(this.b);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ContractOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Effect extends GeneratedMessageLite implements EffectOrBuilder {
        public static Parser<Effect> PARSER = new a();
        public static final Effect i;
        public final ByteString a;
        public int b;
        public EffectType c;
        public List<Expression> d;
        public Expression e;
        public InvocationKind f;
        public byte g;
        public int h;

        public static final class Builder extends GeneratedMessageLite.Builder<Effect, Builder> implements EffectOrBuilder {
            public int b;
            public EffectType c = EffectType.RETURNS_CONSTANT;
            public List<Expression> d = Collections.emptyList();
            public Expression e = Expression.getDefaultInstance();
            public InvocationKind f = InvocationKind.AT_MOST_ONCE;

            public Effect buildPartial() {
                Effect effect = new Effect(this, null);
                int i = this.b;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                effect.c = this.c;
                if ((i & 2) == 2) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.b &= -3;
                }
                effect.d = this.d;
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                effect.e = this.e;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                effect.f = this.f;
                effect.b = i2;
                return effect;
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.e;
            }

            public Expression getEffectConstructorArgument(int i) {
                return this.d.get(i);
            }

            public int getEffectConstructorArgumentCount() {
                return this.d.size();
            }

            public boolean hasConclusionOfConditionalEffect() {
                return (this.b & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
                    if (!getEffectConstructorArgument(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeConclusionOfConditionalEffect(Expression expression) {
                if ((this.b & 4) != 4 || this.e == Expression.getDefaultInstance()) {
                    this.e = expression;
                } else {
                    this.e = Expression.newBuilder(this.e).mergeFrom(expression).buildPartial();
                }
                this.b |= 4;
                return this;
            }

            public Builder setEffectType(EffectType effectType) {
                Objects.requireNonNull(effectType);
                this.b |= 1;
                this.c = effectType;
                return this;
            }

            public Builder setKind(InvocationKind invocationKind) {
                Objects.requireNonNull(invocationKind);
                this.b |= 8;
                this.f = invocationKind;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Effect build() {
                Effect buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Effect effect) {
                if (effect == Effect.getDefaultInstance()) {
                    return this;
                }
                if (effect.hasEffectType()) {
                    setEffectType(effect.getEffectType());
                }
                if (!effect.d.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = effect.d;
                        this.b &= -3;
                    } else {
                        if ((this.b & 2) != 2) {
                            this.d = new ArrayList(this.d);
                            this.b |= 2;
                        }
                        this.d.addAll(effect.d);
                    }
                }
                if (effect.hasConclusionOfConditionalEffect()) {
                    mergeConclusionOfConditionalEffect(effect.getConclusionOfConditionalEffect());
                }
                if (effect.hasKind()) {
                    setKind(effect.getKind());
                }
                setUnknownFields(getUnknownFields().concat(effect.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Effect effect;
                Effect effect2 = null;
                try {
                    Effect parsePartialFrom = Effect.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    effect = (Effect) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    effect2 = effect;
                }
                if (effect2 != null) {
                    mergeFrom(effect2);
                }
                throw th;
            }
        }

        public enum EffectType implements Internal.EnumLite {
            RETURNS_CONSTANT(0),
            CALLS(1),
            RETURNS_NOT_NULL(2);
            
            public final int a;

            /* access modifiers changed from: public */
            EffectType(int i) {
                this.a = i;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.a;
            }

            public static EffectType valueOf(int i) {
                if (i == 0) {
                    return RETURNS_CONSTANT;
                }
                if (i == 1) {
                    return CALLS;
                }
                if (i != 2) {
                    return null;
                }
                return RETURNS_NOT_NULL;
            }
        }

        public enum InvocationKind implements Internal.EnumLite {
            AT_MOST_ONCE(0),
            EXACTLY_ONCE(1),
            AT_LEAST_ONCE(2);
            
            public final int a;

            /* access modifiers changed from: public */
            InvocationKind(int i) {
                this.a = i;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.a;
            }

            public static InvocationKind valueOf(int i) {
                if (i == 0) {
                    return AT_MOST_ONCE;
                }
                if (i == 1) {
                    return EXACTLY_ONCE;
                }
                if (i != 2) {
                    return null;
                }
                return AT_LEAST_ONCE;
            }
        }

        public static class a extends AbstractParser<Effect> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Effect(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Effect effect = new Effect();
            i = effect;
            effect.a();
        }

        public Effect(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.g = -1;
            this.h = -1;
            this.a = builder.getUnknownFields();
        }

        public static Effect getDefaultInstance() {
            return i;
        }

        public static Builder newBuilder(Effect effect) {
            return newBuilder().mergeFrom(effect);
        }

        public final void a() {
            this.c = EffectType.RETURNS_CONSTANT;
            this.d = Collections.emptyList();
            this.e = Expression.getDefaultInstance();
            this.f = InvocationKind.AT_MOST_ONCE;
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.e;
        }

        public Expression getEffectConstructorArgument(int i2) {
            return this.d.get(i2);
        }

        public int getEffectConstructorArgumentCount() {
            return this.d.size();
        }

        public EffectType getEffectType() {
            return this.c;
        }

        public InvocationKind getKind() {
            return this.f;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.h;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.b & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.c.getNumber()) + 0 : 0;
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.d.get(i3));
            }
            if ((this.b & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.e);
            }
            if ((this.b & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeEnumSize(4, this.f.getNumber());
            }
            int size = this.a.size() + computeEnumSize;
            this.h = size;
            return size;
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.b & 2) == 2;
        }

        public boolean hasEffectType() {
            return (this.b & 1) == 1;
        }

        public boolean hasKind() {
            return (this.b & 4) == 4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.g;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < getEffectConstructorArgumentCount(); i2++) {
                if (!getEffectConstructorArgument(i2).isInitialized()) {
                    this.g = 0;
                    return false;
                }
            }
            if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                this.g = 1;
                return true;
            }
            this.g = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.b & 1) == 1) {
                codedOutputStream.writeEnum(1, this.c.getNumber());
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                codedOutputStream.writeMessage(2, this.d.get(i2));
            }
            if ((this.b & 2) == 2) {
                codedOutputStream.writeMessage(3, this.e);
            }
            if ((this.b & 4) == 4) {
                codedOutputStream.writeEnum(4, this.f.getNumber());
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Effect getDefaultInstanceForType() {
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Effect() {
            this.g = -1;
            this.h = -1;
            this.a = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v11, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> */
        /* JADX WARN: Multi-variable type inference failed */
        public Effect(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.g = -1;
            this.h = -1;
            a();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            int readEnum = codedInputStream.readEnum();
                            EffectType valueOf = EffectType.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.b |= 1;
                                this.c = valueOf;
                            }
                        } else if (readTag == 18) {
                            if (!(z2 & true)) {
                                this.d = new ArrayList();
                                z2 |= true;
                            }
                            this.d.add(codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite));
                        } else if (readTag == 26) {
                            Expression.Builder builder = (this.b & 2) == 2 ? this.e.toBuilder() : null;
                            Expression expression = (Expression) codedInputStream.readMessage(Expression.PARSER, extensionRegistryLite);
                            this.e = expression;
                            if (builder != null) {
                                builder.mergeFrom(expression);
                                this.e = builder.buildPartial();
                            }
                            this.b |= 2;
                        } else if (readTag == 32) {
                            int readEnum2 = codedInputStream.readEnum();
                            InvocationKind valueOf2 = InvocationKind.valueOf(readEnum2);
                            if (valueOf2 == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum2);
                            } else {
                                this.b |= 4;
                                this.f = valueOf2;
                            }
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.d = Collections.unmodifiableList(this.d);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.d = Collections.unmodifiableList(this.d);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface EffectOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static Parser<EnumEntry> PARSER = new a();
        public static final EnumEntry g;
        public final ByteString b;
        public int c;
        public int d;
        public byte e;
        public int f;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            public int d;
            public int e;

            public EnumEntry buildPartial() {
                EnumEntry enumEntry = new EnumEntry(this, null);
                int i = 1;
                if ((this.d & 1) != 1) {
                    i = 0;
                }
                enumEntry.d = this.e;
                enumEntry.c = i;
                return enumEntry;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return extensionsAreInitialized();
            }

            public Builder setName(int i) {
                this.d |= 1;
                this.e = i;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public EnumEntry build() {
                EnumEntry buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            public Builder mergeFrom(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    setName(enumEntry.getName());
                }
                mergeExtensionFields(enumEntry);
                setUnknownFields(getUnknownFields().concat(enumEntry.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                EnumEntry enumEntry;
                EnumEntry enumEntry2 = null;
                try {
                    EnumEntry parsePartialFrom = EnumEntry.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    enumEntry = (EnumEntry) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    enumEntry2 = enumEntry;
                }
                if (enumEntry2 != null) {
                    mergeFrom(enumEntry2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<EnumEntry> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumEntry(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            EnumEntry enumEntry = new EnumEntry();
            g = enumEntry;
            enumEntry.d = 0;
        }

        public EnumEntry(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.e = -1;
            this.f = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static EnumEntry getDefaultInstance() {
            return g;
        }

        public static Builder newBuilder(EnumEntry enumEntry) {
            return newBuilder().mergeFrom(enumEntry);
        }

        public int getName() {
            return this.d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<EnumEntry> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.c & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, this.d);
            }
            int size = this.b.size() + extensionsSerializedSize() + i2;
            this.f = size;
            return size;
        }

        public boolean hasName() {
            return (this.c & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.e;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.e = 0;
                return false;
            }
            this.e = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.d);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public EnumEntry getDefaultInstanceForType() {
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public EnumEntry() {
            this.e = -1;
            this.f = -1;
            this.b = ByteString.EMPTY;
        }

        public EnumEntry(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.e = -1;
            this.f = -1;
            boolean z = false;
            this.d = 0;
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.c |= 1;
                            this.d = codedInputStream.readInt32();
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface EnumEntryOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Expression extends GeneratedMessageLite implements ExpressionOrBuilder {
        public static Parser<Expression> PARSER = new a();
        public static final Expression l;
        public final ByteString a;
        public int b;
        public int c;
        public int d;
        public ConstantValue e;
        public Type f;
        public int g;
        public List<Expression> h;
        public List<Expression> i;
        public byte j;
        public int k;

        public static final class Builder extends GeneratedMessageLite.Builder<Expression, Builder> implements ExpressionOrBuilder {
            public int b;
            public int c;
            public int d;
            public ConstantValue e = ConstantValue.TRUE;
            public Type f = Type.getDefaultInstance();
            public int g;
            public List<Expression> h = Collections.emptyList();
            public List<Expression> i = Collections.emptyList();

            public Expression buildPartial() {
                Expression expression = new Expression(this, null);
                int i2 = this.b;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                expression.c = this.c;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                expression.d = this.d;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                expression.e = this.e;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                expression.f = this.f;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                expression.g = this.g;
                if ((i2 & 32) == 32) {
                    this.h = Collections.unmodifiableList(this.h);
                    this.b &= -33;
                }
                expression.h = this.h;
                if ((this.b & 64) == 64) {
                    this.i = Collections.unmodifiableList(this.i);
                    this.b &= -65;
                }
                expression.i = this.i;
                expression.b = i3;
                return expression;
            }

            public Expression getAndArgument(int i2) {
                return this.h.get(i2);
            }

            public int getAndArgumentCount() {
                return this.h.size();
            }

            public Type getIsInstanceType() {
                return this.f;
            }

            public Expression getOrArgument(int i2) {
                return this.i.get(i2);
            }

            public int getOrArgumentCount() {
                return this.i.size();
            }

            public boolean hasIsInstanceType() {
                return (this.b & 8) == 8;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                    return false;
                }
                for (int i2 = 0; i2 < getAndArgumentCount(); i2++) {
                    if (!getAndArgument(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getOrArgumentCount(); i3++) {
                    if (!getOrArgument(i3).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeIsInstanceType(Type type) {
                if ((this.b & 8) != 8 || this.f == Type.getDefaultInstance()) {
                    this.f = type;
                } else {
                    this.f = Type.newBuilder(this.f).mergeFrom(type).buildPartial();
                }
                this.b |= 8;
                return this;
            }

            public Builder setConstantValue(ConstantValue constantValue) {
                Objects.requireNonNull(constantValue);
                this.b |= 4;
                this.e = constantValue;
                return this;
            }

            public Builder setFlags(int i2) {
                this.b |= 1;
                this.c = i2;
                return this;
            }

            public Builder setIsInstanceTypeId(int i2) {
                this.b |= 16;
                this.g = i2;
                return this;
            }

            public Builder setValueParameterReference(int i2) {
                this.b |= 2;
                this.d = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Expression build() {
                Expression buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Expression expression) {
                if (expression == Expression.getDefaultInstance()) {
                    return this;
                }
                if (expression.hasFlags()) {
                    setFlags(expression.getFlags());
                }
                if (expression.hasValueParameterReference()) {
                    setValueParameterReference(expression.getValueParameterReference());
                }
                if (expression.hasConstantValue()) {
                    setConstantValue(expression.getConstantValue());
                }
                if (expression.hasIsInstanceType()) {
                    mergeIsInstanceType(expression.getIsInstanceType());
                }
                if (expression.hasIsInstanceTypeId()) {
                    setIsInstanceTypeId(expression.getIsInstanceTypeId());
                }
                if (!expression.h.isEmpty()) {
                    if (this.h.isEmpty()) {
                        this.h = expression.h;
                        this.b &= -33;
                    } else {
                        if ((this.b & 32) != 32) {
                            this.h = new ArrayList(this.h);
                            this.b |= 32;
                        }
                        this.h.addAll(expression.h);
                    }
                }
                if (!expression.i.isEmpty()) {
                    if (this.i.isEmpty()) {
                        this.i = expression.i;
                        this.b &= -65;
                    } else {
                        if ((this.b & 64) != 64) {
                            this.i = new ArrayList(this.i);
                            this.b |= 64;
                        }
                        this.i.addAll(expression.i);
                    }
                }
                setUnknownFields(getUnknownFields().concat(expression.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Expression expression;
                Expression expression2 = null;
                try {
                    Expression parsePartialFrom = Expression.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    expression = (Expression) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    expression2 = expression;
                }
                if (expression2 != null) {
                    mergeFrom(expression2);
                }
                throw th;
            }
        }

        public enum ConstantValue implements Internal.EnumLite {
            TRUE(0),
            FALSE(1),
            NULL(2);
            
            public final int a;

            /* access modifiers changed from: public */
            ConstantValue(int i) {
                this.a = i;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.a;
            }

            public static ConstantValue valueOf(int i) {
                if (i == 0) {
                    return TRUE;
                }
                if (i == 1) {
                    return FALSE;
                }
                if (i != 2) {
                    return null;
                }
                return NULL;
            }
        }

        public static class a extends AbstractParser<Expression> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Expression(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Expression expression = new Expression();
            l = expression;
            expression.a();
        }

        public Expression(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.j = -1;
            this.k = -1;
            this.a = builder.getUnknownFields();
        }

        public static Expression getDefaultInstance() {
            return l;
        }

        public static Builder newBuilder(Expression expression) {
            return newBuilder().mergeFrom(expression);
        }

        public final void a() {
            this.c = 0;
            this.d = 0;
            this.e = ConstantValue.TRUE;
            this.f = Type.getDefaultInstance();
            this.g = 0;
            this.h = Collections.emptyList();
            this.i = Collections.emptyList();
        }

        public Expression getAndArgument(int i2) {
            return this.h.get(i2);
        }

        public int getAndArgumentCount() {
            return this.h.size();
        }

        public ConstantValue getConstantValue() {
            return this.e;
        }

        public int getFlags() {
            return this.c;
        }

        public Type getIsInstanceType() {
            return this.f;
        }

        public int getIsInstanceTypeId() {
            return this.g;
        }

        public Expression getOrArgument(int i2) {
            return this.i.get(i2);
        }

        public int getOrArgumentCount() {
            return this.i.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.k;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.b & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.c) + 0 : 0;
            if ((this.b & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.d);
            }
            if ((this.b & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeEnumSize(3, this.e.getNumber());
            }
            if ((this.b & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.f);
            }
            if ((this.b & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.g);
            }
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.h.get(i3));
            }
            for (int i4 = 0; i4 < this.i.size(); i4++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(7, this.i.get(i4));
            }
            int size = this.a.size() + computeInt32Size;
            this.k = size;
            return size;
        }

        public int getValueParameterReference() {
            return this.d;
        }

        public boolean hasConstantValue() {
            return (this.b & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.b & 1) == 1;
        }

        public boolean hasIsInstanceType() {
            return (this.b & 8) == 8;
        }

        public boolean hasIsInstanceTypeId() {
            return (this.b & 16) == 16;
        }

        public boolean hasValueParameterReference() {
            return (this.b & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.j;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasIsInstanceType() || getIsInstanceType().isInitialized()) {
                for (int i2 = 0; i2 < getAndArgumentCount(); i2++) {
                    if (!getAndArgument(i2).isInitialized()) {
                        this.j = 0;
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getOrArgumentCount(); i3++) {
                    if (!getOrArgument(i3).isInitialized()) {
                        this.j = 0;
                        return false;
                    }
                }
                this.j = 1;
                return true;
            }
            this.j = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.b & 1) == 1) {
                codedOutputStream.writeInt32(1, this.c);
            }
            if ((this.b & 2) == 2) {
                codedOutputStream.writeInt32(2, this.d);
            }
            if ((this.b & 4) == 4) {
                codedOutputStream.writeEnum(3, this.e.getNumber());
            }
            if ((this.b & 8) == 8) {
                codedOutputStream.writeMessage(4, this.f);
            }
            if ((this.b & 16) == 16) {
                codedOutputStream.writeInt32(5, this.g);
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                codedOutputStream.writeMessage(6, this.h.get(i2));
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                codedOutputStream.writeMessage(7, this.i.get(i3));
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Expression getDefaultInstanceForType() {
            return l;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Expression() {
            this.j = -1;
            this.k = -1;
            this.a = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> */
        /* JADX WARN: Multi-variable type inference failed */
        public Expression(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.j = -1;
            this.k = -1;
            a();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.b |= 1;
                            this.c = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.b |= 2;
                            this.d = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            int readEnum = codedInputStream.readEnum();
                            ConstantValue valueOf = ConstantValue.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.b |= 4;
                                this.e = valueOf;
                            }
                        } else if (readTag == 34) {
                            Type.Builder builder = (this.b & 8) == 8 ? this.f.toBuilder() : null;
                            Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.f = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.f = builder.buildPartial();
                            }
                            this.b |= 8;
                        } else if (readTag == 40) {
                            this.b |= 16;
                            this.g = codedInputStream.readInt32();
                        } else if (readTag == 50) {
                            if (!(z2 & true)) {
                                this.h = new ArrayList();
                                z2 |= true;
                            }
                            this.h.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                        } else if (readTag == 58) {
                            if (!(z2 & true)) {
                                this.i = new ArrayList();
                                z2 |= true;
                            }
                            this.i.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    if (z2 & true) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.h = Collections.unmodifiableList(this.h);
            }
            if (z2 & true) {
                this.i = Collections.unmodifiableList(this.i);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ExpressionOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements FunctionOrBuilder {
        public static Parser<Function> PARSER = new a();
        public static final Function r;
        public final ByteString b;
        public int c;
        public int d;
        public int e;
        public int f;
        public Type g;
        public int h;
        public List<TypeParameter> i;
        public Type j;
        public int k;
        public List<ValueParameter> l;
        public TypeTable m;
        public List<Integer> n;
        public Contract o;
        public byte p;
        public int q;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            public int d;
            public int e = 6;
            public int f = 6;
            public int g;
            public Type h = Type.getDefaultInstance();
            public int i;
            public List<TypeParameter> j = Collections.emptyList();
            public Type k = Type.getDefaultInstance();
            public int l;
            public List<ValueParameter> m = Collections.emptyList();
            public TypeTable n = TypeTable.getDefaultInstance();
            public List<Integer> o = Collections.emptyList();
            public Contract p = Contract.getDefaultInstance();

            public Function buildPartial() {
                Function function = new Function(this, null);
                int i2 = this.d;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                function.d = this.e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                function.e = this.f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                function.f = this.g;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                function.g = this.h;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                function.h = this.i;
                if ((i2 & 32) == 32) {
                    this.j = Collections.unmodifiableList(this.j);
                    this.d &= -33;
                }
                function.i = this.j;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                function.j = this.k;
                if ((i2 & 128) == 128) {
                    i3 |= 64;
                }
                function.k = this.l;
                if ((this.d & 256) == 256) {
                    this.m = Collections.unmodifiableList(this.m);
                    this.d &= -257;
                }
                function.l = this.m;
                if ((i2 & 512) == 512) {
                    i3 |= 128;
                }
                function.m = this.n;
                if ((this.d & 1024) == 1024) {
                    this.o = Collections.unmodifiableList(this.o);
                    this.d &= -1025;
                }
                function.n = this.o;
                if ((i2 & 2048) == 2048) {
                    i3 |= 256;
                }
                function.o = this.p;
                function.c = i3;
                return function;
            }

            public Contract getContract() {
                return this.p;
            }

            public Type getReceiverType() {
                return this.k;
            }

            public Type getReturnType() {
                return this.h;
            }

            public TypeParameter getTypeParameter(int i2) {
                return this.j.get(i2);
            }

            public int getTypeParameterCount() {
                return this.j.size();
            }

            public TypeTable getTypeTable() {
                return this.n;
            }

            public ValueParameter getValueParameter(int i2) {
                return this.m.get(i2);
            }

            public int getValueParameterCount() {
                return this.m.size();
            }

            public boolean hasContract() {
                return (this.d & 2048) == 2048;
            }

            public boolean hasName() {
                return (this.d & 4) == 4;
            }

            public boolean hasReceiverType() {
                return (this.d & 64) == 64;
            }

            public boolean hasReturnType() {
                return (this.d & 8) == 8;
            }

            public boolean hasTypeTable() {
                return (this.d & 512) == 512;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasReturnType() && !getReturnType().isInitialized()) {
                    return false;
                }
                for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                    if (!getTypeParameter(i2).isInitialized()) {
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                    if (!getValueParameter(i3).isInitialized()) {
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    return false;
                }
                if ((!hasContract() || getContract().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeContract(Contract contract) {
                if ((this.d & 2048) != 2048 || this.p == Contract.getDefaultInstance()) {
                    this.p = contract;
                } else {
                    this.p = Contract.newBuilder(this.p).mergeFrom(contract).buildPartial();
                }
                this.d |= 2048;
                return this;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.d & 64) != 64 || this.k == Type.getDefaultInstance()) {
                    this.k = type;
                } else {
                    this.k = Type.newBuilder(this.k).mergeFrom(type).buildPartial();
                }
                this.d |= 64;
                return this;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.d & 8) != 8 || this.h == Type.getDefaultInstance()) {
                    this.h = type;
                } else {
                    this.h = Type.newBuilder(this.h).mergeFrom(type).buildPartial();
                }
                this.d |= 8;
                return this;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.d & 512) != 512 || this.n == TypeTable.getDefaultInstance()) {
                    this.n = typeTable;
                } else {
                    this.n = TypeTable.newBuilder(this.n).mergeFrom(typeTable).buildPartial();
                }
                this.d |= 512;
                return this;
            }

            public Builder setFlags(int i2) {
                this.d |= 1;
                this.e = i2;
                return this;
            }

            public Builder setName(int i2) {
                this.d |= 4;
                this.g = i2;
                return this;
            }

            public Builder setOldFlags(int i2) {
                this.d |= 2;
                this.f = i2;
                return this;
            }

            public Builder setReceiverTypeId(int i2) {
                this.d |= 128;
                this.l = i2;
                return this;
            }

            public Builder setReturnTypeId(int i2) {
                this.d |= 16;
                this.i = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Function build() {
                Function buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            public Builder mergeFrom(Function function) {
                if (function == Function.getDefaultInstance()) {
                    return this;
                }
                if (function.hasFlags()) {
                    setFlags(function.getFlags());
                }
                if (function.hasOldFlags()) {
                    setOldFlags(function.getOldFlags());
                }
                if (function.hasName()) {
                    setName(function.getName());
                }
                if (function.hasReturnType()) {
                    mergeReturnType(function.getReturnType());
                }
                if (function.hasReturnTypeId()) {
                    setReturnTypeId(function.getReturnTypeId());
                }
                if (!function.i.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = function.i;
                        this.d &= -33;
                    } else {
                        if ((this.d & 32) != 32) {
                            this.j = new ArrayList(this.j);
                            this.d |= 32;
                        }
                        this.j.addAll(function.i);
                    }
                }
                if (function.hasReceiverType()) {
                    mergeReceiverType(function.getReceiverType());
                }
                if (function.hasReceiverTypeId()) {
                    setReceiverTypeId(function.getReceiverTypeId());
                }
                if (!function.l.isEmpty()) {
                    if (this.m.isEmpty()) {
                        this.m = function.l;
                        this.d &= -257;
                    } else {
                        if ((this.d & 256) != 256) {
                            this.m = new ArrayList(this.m);
                            this.d |= 256;
                        }
                        this.m.addAll(function.l);
                    }
                }
                if (function.hasTypeTable()) {
                    mergeTypeTable(function.getTypeTable());
                }
                if (!function.n.isEmpty()) {
                    if (this.o.isEmpty()) {
                        this.o = function.n;
                        this.d &= -1025;
                    } else {
                        if ((this.d & 1024) != 1024) {
                            this.o = new ArrayList(this.o);
                            this.d |= 1024;
                        }
                        this.o.addAll(function.n);
                    }
                }
                if (function.hasContract()) {
                    mergeContract(function.getContract());
                }
                mergeExtensionFields(function);
                setUnknownFields(getUnknownFields().concat(function.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Function function;
                Function function2 = null;
                try {
                    Function parsePartialFrom = Function.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    function = (Function) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    function2 = function;
                }
                if (function2 != null) {
                    mergeFrom(function2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<Function> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Function(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Function function = new Function();
            r = function;
            function.b();
        }

        public Function(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.p = -1;
            this.q = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static Function getDefaultInstance() {
            return r;
        }

        public static Builder newBuilder(Function function) {
            return newBuilder().mergeFrom(function);
        }

        public static Function parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public final void b() {
            this.d = 6;
            this.e = 6;
            this.f = 0;
            this.g = Type.getDefaultInstance();
            this.h = 0;
            this.i = Collections.emptyList();
            this.j = Type.getDefaultInstance();
            this.k = 0;
            this.l = Collections.emptyList();
            this.m = TypeTable.getDefaultInstance();
            this.n = Collections.emptyList();
            this.o = Contract.getDefaultInstance();
        }

        public Contract getContract() {
            return this.o;
        }

        public int getFlags() {
            return this.d;
        }

        public int getName() {
            return this.f;
        }

        public int getOldFlags() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Function> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.j;
        }

        public int getReceiverTypeId() {
            return this.k;
        }

        public Type getReturnType() {
            return this.g;
        }

        public int getReturnTypeId() {
            return this.h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.q;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.c & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.e) + 0 : 0;
            if ((this.c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.f);
            }
            if ((this.c & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.g);
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.i.get(i3));
            }
            if ((this.c & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.j);
            }
            for (int i4 = 0; i4 < this.l.size(); i4++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.l.get(i4));
            }
            if ((this.c & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.h);
            }
            if ((this.c & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.k);
            }
            if ((this.c & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.d);
            }
            if ((this.c & 128) == 128) {
                computeInt32Size += CodedOutputStream.computeMessageSize(30, this.m);
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.n.size(); i6++) {
                i5 += CodedOutputStream.computeInt32SizeNoTag(this.n.get(i6).intValue());
            }
            int size = (getVersionRequirementList().size() * 2) + computeInt32Size + i5;
            if ((this.c & 256) == 256) {
                size += CodedOutputStream.computeMessageSize(32, this.o);
            }
            int size2 = this.b.size() + extensionsSerializedSize() + size;
            this.q = size2;
            return size2;
        }

        public TypeParameter getTypeParameter(int i2) {
            return this.i.get(i2);
        }

        public int getTypeParameterCount() {
            return this.i.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.i;
        }

        public TypeTable getTypeTable() {
            return this.m;
        }

        public ValueParameter getValueParameter(int i2) {
            return this.l.get(i2);
        }

        public int getValueParameterCount() {
            return this.l.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.l;
        }

        public List<Integer> getVersionRequirementList() {
            return this.n;
        }

        public boolean hasContract() {
            return (this.c & 256) == 256;
        }

        public boolean hasFlags() {
            return (this.c & 1) == 1;
        }

        public boolean hasName() {
            return (this.c & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.c & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.c & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.c & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.c & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.c & 16) == 16;
        }

        public boolean hasTypeTable() {
            return (this.c & 128) == 128;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.p;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasName()) {
                this.p = 0;
                return false;
            } else if (!hasReturnType() || getReturnType().isInitialized()) {
                for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                    if (!getTypeParameter(i2).isInitialized()) {
                        this.p = 0;
                        return false;
                    }
                }
                if (!hasReceiverType() || getReceiverType().isInitialized()) {
                    for (int i3 = 0; i3 < getValueParameterCount(); i3++) {
                        if (!getValueParameter(i3).isInitialized()) {
                            this.p = 0;
                            return false;
                        }
                    }
                    if (hasTypeTable() && !getTypeTable().isInitialized()) {
                        this.p = 0;
                        return false;
                    } else if (hasContract() && !getContract().isInitialized()) {
                        this.p = 0;
                        return false;
                    } else if (!extensionsAreInitialized()) {
                        this.p = 0;
                        return false;
                    } else {
                        this.p = 1;
                        return true;
                    }
                } else {
                    this.p = 0;
                    return false;
                }
            } else {
                this.p = 0;
                return false;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt32(1, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeInt32(2, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeMessage(3, this.g);
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                codedOutputStream.writeMessage(4, this.i.get(i2));
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeMessage(5, this.j);
            }
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                codedOutputStream.writeMessage(6, this.l.get(i3));
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt32(7, this.h);
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt32(8, this.k);
            }
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(9, this.d);
            }
            if ((this.c & 128) == 128) {
                codedOutputStream.writeMessage(30, this.m);
            }
            for (int i4 = 0; i4 < this.n.size(); i4++) {
                codedOutputStream.writeInt32(31, this.n.get(i4).intValue());
            }
            if ((this.c & 256) == 256) {
                codedOutputStream.writeMessage(32, this.o);
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Function getDefaultInstanceForType() {
            return r;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Function() {
            this.p = -1;
            this.q = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v26, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v38, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> */
        /* JADX WARN: Multi-variable type inference failed */
        public Function(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.p = -1;
            this.q = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    Contract.Builder builder = null;
                    TypeTable.Builder builder2 = null;
                    Type.Builder builder3 = null;
                    Type.Builder builder4 = null;
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.c |= 2;
                            this.e = codedInputStream.readInt32();
                            continue;
                        case 16:
                            this.c |= 4;
                            this.f = codedInputStream.readInt32();
                            continue;
                        case 26:
                            builder4 = (this.c & 8) == 8 ? this.g.toBuilder() : builder4;
                            Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.g = type;
                            if (builder4 != null) {
                                builder4.mergeFrom(type);
                                this.g = builder4.buildPartial();
                            }
                            this.c |= 8;
                            continue;
                        case 34:
                            if (!(z2 & true)) {
                                this.i = new ArrayList();
                                z2 |= true;
                            }
                            this.i.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                            continue;
                        case 42:
                            builder3 = (this.c & 32) == 32 ? this.j.toBuilder() : builder3;
                            Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.j = type2;
                            if (builder3 != null) {
                                builder3.mergeFrom(type2);
                                this.j = builder3.buildPartial();
                            }
                            this.c |= 32;
                            continue;
                        case 50:
                            if (!(z2 & true)) {
                                this.l = new ArrayList();
                                z2 |= true;
                            }
                            this.l.add(codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite));
                            continue;
                        case 56:
                            this.c |= 16;
                            this.h = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.c |= 64;
                            this.k = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.c |= 1;
                            this.d = codedInputStream.readInt32();
                            continue;
                        case 242:
                            builder2 = (this.c & 128) == 128 ? this.m.toBuilder() : builder2;
                            TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                            this.m = typeTable;
                            if (builder2 != null) {
                                builder2.mergeFrom(typeTable);
                                this.m = builder2.buildPartial();
                            }
                            this.c |= 128;
                            continue;
                        case 248:
                            if (!(z2 & true)) {
                                this.n = new ArrayList();
                                z2 |= true;
                            }
                            this.n.add(Integer.valueOf(codedInputStream.readInt32()));
                            continue;
                        case 250:
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.n = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.n.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                            continue;
                        case 258:
                            builder = (this.c & 256) == 256 ? this.o.toBuilder() : builder;
                            Contract contract = (Contract) codedInputStream.readMessage(Contract.PARSER, extensionRegistryLite);
                            this.o = contract;
                            if (builder != null) {
                                builder.mergeFrom(contract);
                                this.o = builder.buildPartial();
                            }
                            this.c |= 256;
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if (z2 & true) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    if (z2 & true) {
                        this.n = Collections.unmodifiableList(this.n);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.i = Collections.unmodifiableList(this.i);
            }
            if (z2 & true) {
                this.l = Collections.unmodifiableList(this.l);
            }
            if (z2 & true) {
                this.n = Collections.unmodifiableList(this.n);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface FunctionOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public enum MemberKind implements Internal.EnumLite {
        DECLARATION(0),
        FAKE_OVERRIDE(1),
        DELEGATION(2),
        SYNTHESIZED(3);
        
        public final int a;

        /* access modifiers changed from: public */
        MemberKind(int i) {
            this.a = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.a;
        }

        public static MemberKind valueOf(int i) {
            if (i == 0) {
                return DECLARATION;
            }
            if (i == 1) {
                return FAKE_OVERRIDE;
            }
            if (i == 2) {
                return DELEGATION;
            }
            if (i != 3) {
                return null;
            }
            return SYNTHESIZED;
        }
    }

    public enum Modality implements Internal.EnumLite {
        FINAL(0),
        OPEN(1),
        ABSTRACT(2),
        SEALED(3);
        
        public final int a;

        /* access modifiers changed from: public */
        Modality(int i) {
            this.a = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.a;
        }

        public static Modality valueOf(int i) {
            if (i == 0) {
                return FINAL;
            }
            if (i == 1) {
                return OPEN;
            }
            if (i == 2) {
                return ABSTRACT;
            }
            if (i != 3) {
                return null;
            }
            return SEALED;
        }
    }

    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements PackageOrBuilder {
        public static Parser<Package> PARSER = new a();
        public static final Package k;
        public final ByteString b;
        public int c;
        public List<Function> d;
        public List<Property> e;
        public List<TypeAlias> f;
        public TypeTable g;
        public VersionRequirementTable h;
        public byte i;
        public int j;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            public int d;
            public List<Function> e = Collections.emptyList();
            public List<Property> f = Collections.emptyList();
            public List<TypeAlias> g = Collections.emptyList();
            public TypeTable h = TypeTable.getDefaultInstance();
            public VersionRequirementTable i = VersionRequirementTable.getDefaultInstance();

            public Package buildPartial() {
                Package r0 = new Package(this, null);
                int i2 = this.d;
                int i3 = 1;
                if ((i2 & 1) == 1) {
                    this.e = Collections.unmodifiableList(this.e);
                    this.d &= -2;
                }
                r0.d = this.e;
                if ((this.d & 2) == 2) {
                    this.f = Collections.unmodifiableList(this.f);
                    this.d &= -3;
                }
                r0.e = this.f;
                if ((this.d & 4) == 4) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.d &= -5;
                }
                r0.f = this.g;
                if ((i2 & 8) != 8) {
                    i3 = 0;
                }
                r0.g = this.h;
                if ((i2 & 16) == 16) {
                    i3 |= 2;
                }
                r0.h = this.i;
                r0.c = i3;
                return r0;
            }

            public Function getFunction(int i2) {
                return this.e.get(i2);
            }

            public int getFunctionCount() {
                return this.e.size();
            }

            public Property getProperty(int i2) {
                return this.f.get(i2);
            }

            public int getPropertyCount() {
                return this.f.size();
            }

            public TypeAlias getTypeAlias(int i2) {
                return this.g.get(i2);
            }

            public int getTypeAliasCount() {
                return this.g.size();
            }

            public TypeTable getTypeTable() {
                return this.h;
            }

            public boolean hasTypeTable() {
                return (this.d & 8) == 8;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < getFunctionCount(); i2++) {
                    if (!getFunction(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getPropertyCount(); i3++) {
                    if (!getProperty(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i4 = 0; i4 < getTypeAliasCount(); i4++) {
                    if (!getTypeAlias(i4).isInitialized()) {
                        return false;
                    }
                }
                if ((!hasTypeTable() || getTypeTable().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeTypeTable(TypeTable typeTable) {
                if ((this.d & 8) != 8 || this.h == TypeTable.getDefaultInstance()) {
                    this.h = typeTable;
                } else {
                    this.h = TypeTable.newBuilder(this.h).mergeFrom(typeTable).buildPartial();
                }
                this.d |= 8;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable versionRequirementTable) {
                if ((this.d & 16) != 16 || this.i == VersionRequirementTable.getDefaultInstance()) {
                    this.i = versionRequirementTable;
                } else {
                    this.i = VersionRequirementTable.newBuilder(this.i).mergeFrom(versionRequirementTable).buildPartial();
                }
                this.d |= 16;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Package build() {
                Package buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            public Builder mergeFrom(Package r4) {
                if (r4 == Package.getDefaultInstance()) {
                    return this;
                }
                if (!r4.d.isEmpty()) {
                    if (this.e.isEmpty()) {
                        this.e = r4.d;
                        this.d &= -2;
                    } else {
                        if ((this.d & 1) != 1) {
                            this.e = new ArrayList(this.e);
                            this.d |= 1;
                        }
                        this.e.addAll(r4.d);
                    }
                }
                if (!r4.e.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = r4.e;
                        this.d &= -3;
                    } else {
                        if ((this.d & 2) != 2) {
                            this.f = new ArrayList(this.f);
                            this.d |= 2;
                        }
                        this.f.addAll(r4.e);
                    }
                }
                if (!r4.f.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = r4.f;
                        this.d &= -5;
                    } else {
                        if ((this.d & 4) != 4) {
                            this.g = new ArrayList(this.g);
                            this.d |= 4;
                        }
                        this.g.addAll(r4.f);
                    }
                }
                if (r4.hasTypeTable()) {
                    mergeTypeTable(r4.getTypeTable());
                }
                if (r4.hasVersionRequirementTable()) {
                    mergeVersionRequirementTable(r4.getVersionRequirementTable());
                }
                mergeExtensionFields(r4);
                setUnknownFields(getUnknownFields().concat(r4.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Package r4;
                Package r0 = null;
                try {
                    Package parsePartialFrom = Package.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    r4 = (Package) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    r0 = r4;
                }
                if (r0 != null) {
                    mergeFrom(r0);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<Package> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Package(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Package r0 = new Package();
            k = r0;
            r0.b();
        }

        public Package(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.i = -1;
            this.j = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static Package getDefaultInstance() {
            return k;
        }

        public static Builder newBuilder(Package r1) {
            return newBuilder().mergeFrom(r1);
        }

        public static Package parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public final void b() {
            this.d = Collections.emptyList();
            this.e = Collections.emptyList();
            this.f = Collections.emptyList();
            this.g = TypeTable.getDefaultInstance();
            this.h = VersionRequirementTable.getDefaultInstance();
        }

        public Function getFunction(int i2) {
            return this.d.get(i2);
        }

        public int getFunctionCount() {
            return this.d.size();
        }

        public List<Function> getFunctionList() {
            return this.d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Package> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i2) {
            return this.e.get(i2);
        }

        public int getPropertyCount() {
            return this.e.size();
        }

        public List<Property> getPropertyList() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                i3 += CodedOutputStream.computeMessageSize(3, this.d.get(i4));
            }
            for (int i5 = 0; i5 < this.e.size(); i5++) {
                i3 += CodedOutputStream.computeMessageSize(4, this.e.get(i5));
            }
            for (int i6 = 0; i6 < this.f.size(); i6++) {
                i3 += CodedOutputStream.computeMessageSize(5, this.f.get(i6));
            }
            if ((this.c & 1) == 1) {
                i3 += CodedOutputStream.computeMessageSize(30, this.g);
            }
            if ((this.c & 2) == 2) {
                i3 += CodedOutputStream.computeMessageSize(32, this.h);
            }
            int size = this.b.size() + extensionsSerializedSize() + i3;
            this.j = size;
            return size;
        }

        public TypeAlias getTypeAlias(int i2) {
            return this.f.get(i2);
        }

        public int getTypeAliasCount() {
            return this.f.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.f;
        }

        public TypeTable getTypeTable() {
            return this.g;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.h;
        }

        public boolean hasTypeTable() {
            return (this.c & 1) == 1;
        }

        public boolean hasVersionRequirementTable() {
            return (this.c & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < getFunctionCount(); i2++) {
                if (!getFunction(i2).isInitialized()) {
                    this.i = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getPropertyCount(); i3++) {
                if (!getProperty(i3).isInitialized()) {
                    this.i = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getTypeAliasCount(); i4++) {
                if (!getTypeAlias(i4).isInitialized()) {
                    this.i = 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.i = 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.i = 0;
                return false;
            } else {
                this.i = 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                codedOutputStream.writeMessage(3, this.d.get(i2));
            }
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                codedOutputStream.writeMessage(4, this.e.get(i3));
            }
            for (int i4 = 0; i4 < this.f.size(); i4++) {
                codedOutputStream.writeMessage(5, this.f.get(i4));
            }
            if ((this.c & 1) == 1) {
                codedOutputStream.writeMessage(30, this.g);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeMessage(32, this.h);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Package getDefaultInstanceForType() {
            return k;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Package() {
            this.i = -1;
            this.j = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v20, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v23, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v26, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> */
        /* JADX WARN: Multi-variable type inference failed */
        public Package(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.i = -1;
            this.j = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 26) {
                            if (!z2 || !true) {
                                this.d = new ArrayList();
                                z2 |= true;
                            }
                            this.d.add(codedInputStream.readMessage(Function.PARSER, extensionRegistryLite));
                        } else if (readTag == 34) {
                            if (!(z2 & true)) {
                                this.e = new ArrayList();
                                z2 |= true;
                            }
                            this.e.add(codedInputStream.readMessage(Property.PARSER, extensionRegistryLite));
                        } else if (readTag != 42) {
                            VersionRequirementTable.Builder builder = null;
                            TypeTable.Builder builder2 = null;
                            if (readTag == 242) {
                                builder2 = (this.c & 1) == 1 ? this.g.toBuilder() : builder2;
                                TypeTable typeTable = (TypeTable) codedInputStream.readMessage(TypeTable.PARSER, extensionRegistryLite);
                                this.g = typeTable;
                                if (builder2 != null) {
                                    builder2.mergeFrom(typeTable);
                                    this.g = builder2.buildPartial();
                                }
                                this.c |= 1;
                            } else if (readTag == 258) {
                                builder = (this.c & 2) == 2 ? this.h.toBuilder() : builder;
                                VersionRequirementTable versionRequirementTable = (VersionRequirementTable) codedInputStream.readMessage(VersionRequirementTable.PARSER, extensionRegistryLite);
                                this.h = versionRequirementTable;
                                if (builder != null) {
                                    builder.mergeFrom(versionRequirementTable);
                                    this.h = builder.buildPartial();
                                }
                                this.c |= 2;
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            if (!(z2 & true)) {
                                this.f = new ArrayList();
                                z2 |= true;
                            }
                            this.f.add(codedInputStream.readMessage(TypeAlias.PARSER, extensionRegistryLite));
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.d = Collections.unmodifiableList(this.d);
                    }
                    if (z2 & true) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    if (z2 & true) {
                        this.f = Collections.unmodifiableList(this.f);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.d = Collections.unmodifiableList(this.d);
            }
            if (z2 & true) {
                this.e = Collections.unmodifiableList(this.e);
            }
            if (z2 & true) {
                this.f = Collections.unmodifiableList(this.f);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements PackageFragmentOrBuilder {
        public static Parser<PackageFragment> PARSER = new a();
        public static final PackageFragment j;
        public final ByteString b;
        public int c;
        public StringTable d;
        public QualifiedNameTable e;
        public Package f;
        public List<Class> g;
        public byte h;
        public int i;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder> implements PackageFragmentOrBuilder {
            public int d;
            public StringTable e = StringTable.getDefaultInstance();
            public QualifiedNameTable f = QualifiedNameTable.getDefaultInstance();
            public Package g = Package.getDefaultInstance();
            public List<Class> h = Collections.emptyList();

            public PackageFragment buildPartial() {
                PackageFragment packageFragment = new PackageFragment(this, null);
                int i = this.d;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                packageFragment.d = this.e;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                packageFragment.e = this.f;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                packageFragment.f = this.g;
                if ((i & 8) == 8) {
                    this.h = Collections.unmodifiableList(this.h);
                    this.d &= -9;
                }
                packageFragment.g = this.h;
                packageFragment.c = i2;
                return packageFragment;
            }

            public Class getClass_(int i) {
                return this.h.get(i);
            }

            public int getClass_Count() {
                return this.h.size();
            }

            public Package getPackage() {
                return this.g;
            }

            public QualifiedNameTable getQualifiedNames() {
                return this.f;
            }

            public boolean hasPackage() {
                return (this.d & 4) == 4;
            }

            public boolean hasQualifiedNames() {
                return (this.d & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                    return false;
                }
                if (hasPackage() && !getPackage().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getClass_Count(); i++) {
                    if (!getClass_(i).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergePackage(Package r4) {
                if ((this.d & 4) != 4 || this.g == Package.getDefaultInstance()) {
                    this.g = r4;
                } else {
                    this.g = Package.newBuilder(this.g).mergeFrom(r4).buildPartial();
                }
                this.d |= 4;
                return this;
            }

            public Builder mergeQualifiedNames(QualifiedNameTable qualifiedNameTable) {
                if ((this.d & 2) != 2 || this.f == QualifiedNameTable.getDefaultInstance()) {
                    this.f = qualifiedNameTable;
                } else {
                    this.f = QualifiedNameTable.newBuilder(this.f).mergeFrom(qualifiedNameTable).buildPartial();
                }
                this.d |= 2;
                return this;
            }

            public Builder mergeStrings(StringTable stringTable) {
                if ((this.d & 1) != 1 || this.e == StringTable.getDefaultInstance()) {
                    this.e = stringTable;
                } else {
                    this.e = StringTable.newBuilder(this.e).mergeFrom(stringTable).buildPartial();
                }
                this.d |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public PackageFragment build() {
                PackageFragment buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            public Builder mergeFrom(PackageFragment packageFragment) {
                if (packageFragment == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (packageFragment.hasStrings()) {
                    mergeStrings(packageFragment.getStrings());
                }
                if (packageFragment.hasQualifiedNames()) {
                    mergeQualifiedNames(packageFragment.getQualifiedNames());
                }
                if (packageFragment.hasPackage()) {
                    mergePackage(packageFragment.getPackage());
                }
                if (!packageFragment.g.isEmpty()) {
                    if (this.h.isEmpty()) {
                        this.h = packageFragment.g;
                        this.d &= -9;
                    } else {
                        if ((this.d & 8) != 8) {
                            this.h = new ArrayList(this.h);
                            this.d |= 8;
                        }
                        this.h.addAll(packageFragment.g);
                    }
                }
                mergeExtensionFields(packageFragment);
                setUnknownFields(getUnknownFields().concat(packageFragment.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                PackageFragment packageFragment;
                PackageFragment packageFragment2 = null;
                try {
                    PackageFragment parsePartialFrom = PackageFragment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    packageFragment = (PackageFragment) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    packageFragment2 = packageFragment;
                }
                if (packageFragment2 != null) {
                    mergeFrom(packageFragment2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<PackageFragment> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PackageFragment(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            PackageFragment packageFragment = new PackageFragment();
            j = packageFragment;
            packageFragment.b();
        }

        public PackageFragment(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.h = -1;
            this.i = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static PackageFragment getDefaultInstance() {
            return j;
        }

        public static Builder newBuilder(PackageFragment packageFragment) {
            return newBuilder().mergeFrom(packageFragment);
        }

        public static PackageFragment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public final void b() {
            this.d = StringTable.getDefaultInstance();
            this.e = QualifiedNameTable.getDefaultInstance();
            this.f = Package.getDefaultInstance();
            this.g = Collections.emptyList();
        }

        public Class getClass_(int i2) {
            return this.g.get(i2);
        }

        public int getClass_Count() {
            return this.g.size();
        }

        public List<Class> getClass_List() {
            return this.g;
        }

        public Package getPackage() {
            return this.f;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.i;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.c & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.d) + 0 : 0;
            if ((this.c & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.e);
            }
            if ((this.c & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.f);
            }
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, this.g.get(i3));
            }
            int size = this.b.size() + extensionsSerializedSize() + computeMessageSize;
            this.i = size;
            return size;
        }

        public StringTable getStrings() {
            return this.d;
        }

        public boolean hasPackage() {
            return (this.c & 4) == 4;
        }

        public boolean hasQualifiedNames() {
            return (this.c & 2) == 2;
        }

        public boolean hasStrings() {
            return (this.c & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.h;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.h = 0;
                return false;
            } else if (!hasPackage() || getPackage().isInitialized()) {
                for (int i2 = 0; i2 < getClass_Count(); i2++) {
                    if (!getClass_(i2).isInitialized()) {
                        this.h = 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.h = 0;
                    return false;
                }
                this.h = 1;
                return true;
            } else {
                this.h = 0;
                return false;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeMessage(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeMessage(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f);
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                codedOutputStream.writeMessage(4, this.g.get(i2));
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public PackageFragment getDefaultInstanceForType() {
            return j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public PackageFragment() {
            this.h = -1;
            this.i = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> */
        /* JADX WARN: Multi-variable type inference failed */
        public PackageFragment(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.h = -1;
            this.i = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        Package.Builder builder = null;
                        StringTable.Builder builder2 = null;
                        QualifiedNameTable.Builder builder3 = null;
                        if (readTag == 10) {
                            builder2 = (this.c & 1) == 1 ? this.d.toBuilder() : builder2;
                            StringTable stringTable = (StringTable) codedInputStream.readMessage(StringTable.PARSER, extensionRegistryLite);
                            this.d = stringTable;
                            if (builder2 != null) {
                                builder2.mergeFrom(stringTable);
                                this.d = builder2.buildPartial();
                            }
                            this.c |= 1;
                        } else if (readTag == 18) {
                            builder3 = (this.c & 2) == 2 ? this.e.toBuilder() : builder3;
                            QualifiedNameTable qualifiedNameTable = (QualifiedNameTable) codedInputStream.readMessage(QualifiedNameTable.PARSER, extensionRegistryLite);
                            this.e = qualifiedNameTable;
                            if (builder3 != null) {
                                builder3.mergeFrom(qualifiedNameTable);
                                this.e = builder3.buildPartial();
                            }
                            this.c |= 2;
                        } else if (readTag == 26) {
                            builder = (this.c & 4) == 4 ? this.f.toBuilder() : builder;
                            Package r5 = (Package) codedInputStream.readMessage(Package.PARSER, extensionRegistryLite);
                            this.f = r5;
                            if (builder != null) {
                                builder.mergeFrom(r5);
                                this.f = builder.buildPartial();
                            }
                            this.c |= 4;
                        } else if (readTag == 34) {
                            if (!(z2 & true)) {
                                this.g = new ArrayList();
                                z2 |= true;
                            }
                            this.g.add(codedInputStream.readMessage(Class.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.g = Collections.unmodifiableList(this.g);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.g = Collections.unmodifiableList(this.g);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface PackageFragmentOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface PackageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements PropertyOrBuilder {
        public static Parser<Property> PARSER = new a();
        public static final Property r;
        public final ByteString b;
        public int c;
        public int d;
        public int e;
        public int f;
        public Type g;
        public int h;
        public List<TypeParameter> i;
        public Type j;
        public int k;
        public ValueParameter l;
        public int m;
        public int n;
        public List<Integer> o;
        public byte p;
        public int q;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            public int d;
            public int e = 518;
            public int f = 2054;
            public int g;
            public Type h = Type.getDefaultInstance();
            public int i;
            public List<TypeParameter> j = Collections.emptyList();
            public Type k = Type.getDefaultInstance();
            public int l;
            public ValueParameter m = ValueParameter.getDefaultInstance();
            public int n;
            public int o;
            public List<Integer> p = Collections.emptyList();

            public Property buildPartial() {
                Property property = new Property(this, null);
                int i2 = this.d;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                property.d = this.e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                property.e = this.f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                property.f = this.g;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                property.g = this.h;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                property.h = this.i;
                if ((i2 & 32) == 32) {
                    this.j = Collections.unmodifiableList(this.j);
                    this.d &= -33;
                }
                property.i = this.j;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                property.j = this.k;
                if ((i2 & 128) == 128) {
                    i3 |= 64;
                }
                property.k = this.l;
                if ((i2 & 256) == 256) {
                    i3 |= 128;
                }
                property.l = this.m;
                if ((i2 & 512) == 512) {
                    i3 |= 256;
                }
                property.m = this.n;
                if ((i2 & 1024) == 1024) {
                    i3 |= 512;
                }
                property.n = this.o;
                if ((this.d & 2048) == 2048) {
                    this.p = Collections.unmodifiableList(this.p);
                    this.d &= -2049;
                }
                property.o = this.p;
                property.c = i3;
                return property;
            }

            public Type getReceiverType() {
                return this.k;
            }

            public Type getReturnType() {
                return this.h;
            }

            public ValueParameter getSetterValueParameter() {
                return this.m;
            }

            public TypeParameter getTypeParameter(int i2) {
                return this.j.get(i2);
            }

            public int getTypeParameterCount() {
                return this.j.size();
            }

            public boolean hasName() {
                return (this.d & 4) == 4;
            }

            public boolean hasReceiverType() {
                return (this.d & 64) == 64;
            }

            public boolean hasReturnType() {
                return (this.d & 8) == 8;
            }

            public boolean hasSetterValueParameter() {
                return (this.d & 256) == 256;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasReturnType() && !getReturnType().isInitialized()) {
                    return false;
                }
                for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                    if (!getTypeParameter(i2).isInitialized()) {
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    return false;
                }
                if ((!hasSetterValueParameter() || getSetterValueParameter().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeReceiverType(Type type) {
                if ((this.d & 64) != 64 || this.k == Type.getDefaultInstance()) {
                    this.k = type;
                } else {
                    this.k = Type.newBuilder(this.k).mergeFrom(type).buildPartial();
                }
                this.d |= 64;
                return this;
            }

            public Builder mergeReturnType(Type type) {
                if ((this.d & 8) != 8 || this.h == Type.getDefaultInstance()) {
                    this.h = type;
                } else {
                    this.h = Type.newBuilder(this.h).mergeFrom(type).buildPartial();
                }
                this.d |= 8;
                return this;
            }

            public Builder mergeSetterValueParameter(ValueParameter valueParameter) {
                if ((this.d & 256) != 256 || this.m == ValueParameter.getDefaultInstance()) {
                    this.m = valueParameter;
                } else {
                    this.m = ValueParameter.newBuilder(this.m).mergeFrom(valueParameter).buildPartial();
                }
                this.d |= 256;
                return this;
            }

            public Builder setFlags(int i2) {
                this.d |= 1;
                this.e = i2;
                return this;
            }

            public Builder setGetterFlags(int i2) {
                this.d |= 512;
                this.n = i2;
                return this;
            }

            public Builder setName(int i2) {
                this.d |= 4;
                this.g = i2;
                return this;
            }

            public Builder setOldFlags(int i2) {
                this.d |= 2;
                this.f = i2;
                return this;
            }

            public Builder setReceiverTypeId(int i2) {
                this.d |= 128;
                this.l = i2;
                return this;
            }

            public Builder setReturnTypeId(int i2) {
                this.d |= 16;
                this.i = i2;
                return this;
            }

            public Builder setSetterFlags(int i2) {
                this.d |= 1024;
                this.o = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Property build() {
                Property buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            public Builder mergeFrom(Property property) {
                if (property == Property.getDefaultInstance()) {
                    return this;
                }
                if (property.hasFlags()) {
                    setFlags(property.getFlags());
                }
                if (property.hasOldFlags()) {
                    setOldFlags(property.getOldFlags());
                }
                if (property.hasName()) {
                    setName(property.getName());
                }
                if (property.hasReturnType()) {
                    mergeReturnType(property.getReturnType());
                }
                if (property.hasReturnTypeId()) {
                    setReturnTypeId(property.getReturnTypeId());
                }
                if (!property.i.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = property.i;
                        this.d &= -33;
                    } else {
                        if ((this.d & 32) != 32) {
                            this.j = new ArrayList(this.j);
                            this.d |= 32;
                        }
                        this.j.addAll(property.i);
                    }
                }
                if (property.hasReceiverType()) {
                    mergeReceiverType(property.getReceiverType());
                }
                if (property.hasReceiverTypeId()) {
                    setReceiverTypeId(property.getReceiverTypeId());
                }
                if (property.hasSetterValueParameter()) {
                    mergeSetterValueParameter(property.getSetterValueParameter());
                }
                if (property.hasGetterFlags()) {
                    setGetterFlags(property.getGetterFlags());
                }
                if (property.hasSetterFlags()) {
                    setSetterFlags(property.getSetterFlags());
                }
                if (!property.o.isEmpty()) {
                    if (this.p.isEmpty()) {
                        this.p = property.o;
                        this.d &= -2049;
                    } else {
                        if ((this.d & 2048) != 2048) {
                            this.p = new ArrayList(this.p);
                            this.d |= 2048;
                        }
                        this.p.addAll(property.o);
                    }
                }
                mergeExtensionFields(property);
                setUnknownFields(getUnknownFields().concat(property.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Property property;
                Property property2 = null;
                try {
                    Property parsePartialFrom = Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    property = (Property) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    property2 = property;
                }
                if (property2 != null) {
                    mergeFrom(property2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<Property> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Property(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Property property = new Property();
            r = property;
            property.b();
        }

        public Property(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.p = -1;
            this.q = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static Property getDefaultInstance() {
            return r;
        }

        public static Builder newBuilder(Property property) {
            return newBuilder().mergeFrom(property);
        }

        public final void b() {
            this.d = 518;
            this.e = 2054;
            this.f = 0;
            this.g = Type.getDefaultInstance();
            this.h = 0;
            this.i = Collections.emptyList();
            this.j = Type.getDefaultInstance();
            this.k = 0;
            this.l = ValueParameter.getDefaultInstance();
            this.m = 0;
            this.n = 0;
            this.o = Collections.emptyList();
        }

        public int getFlags() {
            return this.d;
        }

        public int getGetterFlags() {
            return this.m;
        }

        public int getName() {
            return this.f;
        }

        public int getOldFlags() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Property> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.j;
        }

        public int getReceiverTypeId() {
            return this.k;
        }

        public Type getReturnType() {
            return this.g;
        }

        public int getReturnTypeId() {
            return this.h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.q;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.c & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.e) + 0 : 0;
            if ((this.c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.f);
            }
            if ((this.c & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.g);
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.i.get(i3));
            }
            if ((this.c & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.j);
            }
            if ((this.c & 128) == 128) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.l);
            }
            if ((this.c & 256) == 256) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.m);
            }
            if ((this.c & 512) == 512) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.n);
            }
            if ((this.c & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.h);
            }
            if ((this.c & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(10, this.k);
            }
            if ((this.c & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, this.d);
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.o.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.o.get(i5).intValue());
            }
            int size = this.b.size() + extensionsSerializedSize() + (getVersionRequirementList().size() * 2) + computeInt32Size + i4;
            this.q = size;
            return size;
        }

        public int getSetterFlags() {
            return this.n;
        }

        public ValueParameter getSetterValueParameter() {
            return this.l;
        }

        public TypeParameter getTypeParameter(int i2) {
            return this.i.get(i2);
        }

        public int getTypeParameterCount() {
            return this.i.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.i;
        }

        public List<Integer> getVersionRequirementList() {
            return this.o;
        }

        public boolean hasFlags() {
            return (this.c & 1) == 1;
        }

        public boolean hasGetterFlags() {
            return (this.c & 256) == 256;
        }

        public boolean hasName() {
            return (this.c & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.c & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.c & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.c & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.c & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.c & 16) == 16;
        }

        public boolean hasSetterFlags() {
            return (this.c & 512) == 512;
        }

        public boolean hasSetterValueParameter() {
            return (this.c & 128) == 128;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.p;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasName()) {
                this.p = 0;
                return false;
            } else if (!hasReturnType() || getReturnType().isInitialized()) {
                for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                    if (!getTypeParameter(i2).isInitialized()) {
                        this.p = 0;
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    this.p = 0;
                    return false;
                } else if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                    this.p = 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.p = 0;
                    return false;
                } else {
                    this.p = 1;
                    return true;
                }
            } else {
                this.p = 0;
                return false;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt32(1, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeInt32(2, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeMessage(3, this.g);
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                codedOutputStream.writeMessage(4, this.i.get(i2));
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeMessage(5, this.j);
            }
            if ((this.c & 128) == 128) {
                codedOutputStream.writeMessage(6, this.l);
            }
            if ((this.c & 256) == 256) {
                codedOutputStream.writeInt32(7, this.m);
            }
            if ((this.c & 512) == 512) {
                codedOutputStream.writeInt32(8, this.n);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt32(9, this.h);
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt32(10, this.k);
            }
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(11, this.d);
            }
            for (int i3 = 0; i3 < this.o.size(); i3++) {
                codedOutputStream.writeInt32(31, this.o.get(i3).intValue());
            }
            newExtensionWriter.writeUntil(19000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Property getDefaultInstanceForType() {
            return r;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Property() {
            this.p = -1;
            this.q = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v19, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> */
        /* JADX WARN: Multi-variable type inference failed */
        public Property(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.p = -1;
            this.q = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    Type.Builder builder = null;
                    ValueParameter.Builder builder2 = null;
                    Type.Builder builder3 = null;
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.c |= 2;
                            this.e = codedInputStream.readInt32();
                            continue;
                        case 16:
                            this.c |= 4;
                            this.f = codedInputStream.readInt32();
                            continue;
                        case 26:
                            builder = (this.c & 8) == 8 ? this.g.toBuilder() : builder;
                            Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.g = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.g = builder.buildPartial();
                            }
                            this.c |= 8;
                            continue;
                        case 34:
                            if (!(z2 & true)) {
                                this.i = new ArrayList();
                                z2 |= true;
                            }
                            this.i.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                            continue;
                        case 42:
                            builder3 = (this.c & 32) == 32 ? this.j.toBuilder() : builder3;
                            Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.j = type2;
                            if (builder3 != null) {
                                builder3.mergeFrom(type2);
                                this.j = builder3.buildPartial();
                            }
                            this.c |= 32;
                            continue;
                        case 50:
                            builder2 = (this.c & 128) == 128 ? this.l.toBuilder() : builder2;
                            ValueParameter valueParameter = (ValueParameter) codedInputStream.readMessage(ValueParameter.PARSER, extensionRegistryLite);
                            this.l = valueParameter;
                            if (builder2 != null) {
                                builder2.mergeFrom(valueParameter);
                                this.l = builder2.buildPartial();
                            }
                            this.c |= 128;
                            continue;
                        case 56:
                            this.c |= 256;
                            this.m = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.c |= 512;
                            this.n = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.c |= 16;
                            this.h = codedInputStream.readInt32();
                            continue;
                        case 80:
                            this.c |= 64;
                            this.k = codedInputStream.readInt32();
                            continue;
                        case 88:
                            this.c |= 1;
                            this.d = codedInputStream.readInt32();
                            continue;
                        case 248:
                            if (!(z2 & true)) {
                                this.o = new ArrayList();
                                z2 |= true;
                            }
                            this.o.add(Integer.valueOf(codedInputStream.readInt32()));
                            continue;
                        case 250:
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.o = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.o.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if (z2 & true) {
                        this.o = Collections.unmodifiableList(this.o);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.i = Collections.unmodifiableList(this.i);
            }
            if (z2 & true) {
                this.o = Collections.unmodifiableList(this.o);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface PropertyOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> PARSER = new a();
        public static final QualifiedNameTable e;
        public final ByteString a;
        public List<QualifiedName> b;
        public byte c;
        public int d;

        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            public int b;
            public List<QualifiedName> c = Collections.emptyList();

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(this, null);
                if ((this.b & 1) == 1) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.b &= -2;
                }
                qualifiedNameTable.b = this.c;
                return qualifiedNameTable;
            }

            public QualifiedName getQualifiedName(int i) {
                return this.c.get(i);
            }

            public int getQualifiedNameCount() {
                return this.c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getQualifiedNameCount(); i++) {
                    if (!getQualifiedName(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public QualifiedNameTable build() {
                QualifiedNameTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!qualifiedNameTable.b.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = qualifiedNameTable.b;
                        this.b &= -2;
                    } else {
                        if ((this.b & 1) != 1) {
                            this.c = new ArrayList(this.c);
                            this.b |= 1;
                        }
                        this.c.addAll(qualifiedNameTable.b);
                    }
                }
                setUnknownFields(getUnknownFields().concat(qualifiedNameTable.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                QualifiedNameTable qualifiedNameTable;
                QualifiedNameTable qualifiedNameTable2 = null;
                try {
                    QualifiedNameTable parsePartialFrom = QualifiedNameTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    qualifiedNameTable = (QualifiedNameTable) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    qualifiedNameTable2 = qualifiedNameTable;
                }
                if (qualifiedNameTable2 != null) {
                    mergeFrom(qualifiedNameTable2);
                }
                throw th;
            }
        }

        public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
            public static Parser<QualifiedName> PARSER = new a();
            public static final QualifiedName h;
            public final ByteString a;
            public int b;
            public int c;
            public int d;
            public Kind e;
            public byte f;
            public int g;

            public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                public int b;
                public int c = -1;
                public int d;
                public Kind e = Kind.PACKAGE;

                public QualifiedName buildPartial() {
                    QualifiedName qualifiedName = new QualifiedName(this, null);
                    int i = this.b;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    qualifiedName.c = this.c;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    qualifiedName.d = this.d;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    qualifiedName.e = this.e;
                    qualifiedName.b = i2;
                    return qualifiedName;
                }

                public boolean hasShortName() {
                    return (this.b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return hasShortName();
                }

                public Builder setKind(Kind kind) {
                    Objects.requireNonNull(kind);
                    this.b |= 4;
                    this.e = kind;
                    return this;
                }

                public Builder setParentQualifiedName(int i) {
                    this.b |= 1;
                    this.c = i;
                    return this;
                }

                public Builder setShortName(int i) {
                    this.b |= 2;
                    this.d = i;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public QualifiedName build() {
                    QualifiedName buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
                public Builder clone() {
                    return new Builder().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (qualifiedName.hasParentQualifiedName()) {
                        setParentQualifiedName(qualifiedName.getParentQualifiedName());
                    }
                    if (qualifiedName.hasShortName()) {
                        setShortName(qualifiedName.getShortName());
                    }
                    if (qualifiedName.hasKind()) {
                        setKind(qualifiedName.getKind());
                    }
                    setUnknownFields(getUnknownFields().concat(qualifiedName.a));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Throwable th;
                    QualifiedName qualifiedName;
                    QualifiedName qualifiedName2 = null;
                    try {
                        QualifiedName parsePartialFrom = QualifiedName.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        qualifiedName = (QualifiedName) e2.getUnfinishedMessage();
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        qualifiedName2 = qualifiedName;
                    }
                    if (qualifiedName2 != null) {
                        mergeFrom(qualifiedName2);
                    }
                    throw th;
                }
            }

            public enum Kind implements Internal.EnumLite {
                CLASS(0),
                PACKAGE(1),
                LOCAL(2);
                
                public final int a;

                /* access modifiers changed from: public */
                Kind(int i) {
                    this.a = i;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.a;
                }

                public static Kind valueOf(int i) {
                    if (i == 0) {
                        return CLASS;
                    }
                    if (i == 1) {
                        return PACKAGE;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return LOCAL;
                }
            }

            public static class a extends AbstractParser<QualifiedName> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new QualifiedName(codedInputStream, extensionRegistryLite, null);
                }
            }

            static {
                QualifiedName qualifiedName = new QualifiedName();
                h = qualifiedName;
                qualifiedName.c = -1;
                qualifiedName.d = 0;
                qualifiedName.e = Kind.PACKAGE;
            }

            public QualifiedName(GeneratedMessageLite.Builder builder, a aVar) {
                super(builder);
                this.f = -1;
                this.g = -1;
                this.a = builder.getUnknownFields();
            }

            public static QualifiedName getDefaultInstance() {
                return h;
            }

            public static Builder newBuilder(QualifiedName qualifiedName) {
                return newBuilder().mergeFrom(qualifiedName);
            }

            public Kind getKind() {
                return this.e;
            }

            public int getParentQualifiedName() {
                return this.c;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.g;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.b & 1) == 1) {
                    i2 = 0 + CodedOutputStream.computeInt32Size(1, this.c);
                }
                if ((this.b & 2) == 2) {
                    i2 += CodedOutputStream.computeInt32Size(2, this.d);
                }
                if ((this.b & 4) == 4) {
                    i2 += CodedOutputStream.computeEnumSize(3, this.e.getNumber());
                }
                int size = this.a.size() + i2;
                this.g = size;
                return size;
            }

            public int getShortName() {
                return this.d;
            }

            public boolean hasKind() {
                return (this.b & 4) == 4;
            }

            public boolean hasParentQualifiedName() {
                return (this.b & 1) == 1;
            }

            public boolean hasShortName() {
                return (this.b & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.f;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!hasShortName()) {
                    this.f = 0;
                    return false;
                }
                this.f = 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.b & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.c);
                }
                if ((this.b & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.d);
                }
                if ((this.b & 4) == 4) {
                    codedOutputStream.writeEnum(3, this.e.getNumber());
                }
                codedOutputStream.writeRawBytes(this.a);
            }

            public static Builder newBuilder() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedName getDefaultInstanceForType() {
                return h;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            public QualifiedName() {
                this.f = -1;
                this.g = -1;
                this.a = ByteString.EMPTY;
            }

            public QualifiedName(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this.f = -1;
                this.g = -1;
                this.c = -1;
                boolean z = false;
                this.d = 0;
                this.e = Kind.PACKAGE;
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.b |= 1;
                                this.c = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.b |= 2;
                                this.d = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                int readEnum = codedInputStream.readEnum();
                                Kind valueOf = Kind.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.b |= 4;
                                    this.e = valueOf;
                                }
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.a = newOutput.toByteString();
                            throw th2;
                        }
                        this.a = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.a = newOutput.toByteString();
                    throw th3;
                }
                this.a = newOutput.toByteString();
                makeExtensionsImmutable();
            }
        }

        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        public static class a extends AbstractParser<QualifiedNameTable> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable();
            e = qualifiedNameTable;
            qualifiedNameTable.b = Collections.emptyList();
        }

        public QualifiedNameTable(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.c = -1;
            this.d = -1;
            this.a = builder.getUnknownFields();
        }

        public static QualifiedNameTable getDefaultInstance() {
            return e;
        }

        public static Builder newBuilder(QualifiedNameTable qualifiedNameTable) {
            return newBuilder().mergeFrom(qualifiedNameTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public QualifiedName getQualifiedName(int i) {
            return this.b.get(i);
        }

        public int getQualifiedNameCount() {
            return this.b.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.d;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.b.get(i3));
            }
            int size = this.a.size() + i2;
            this.d = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.c;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < getQualifiedNameCount(); i++) {
                if (!getQualifiedName(i).isInitialized()) {
                    this.c = 0;
                    return false;
                }
            }
            this.c = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.b.size(); i++) {
                codedOutputStream.writeMessage(1, this.b.get(i));
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public QualifiedNameTable getDefaultInstanceForType() {
            return e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public QualifiedNameTable() {
            this.c = -1;
            this.d = -1;
            this.a = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName> */
        /* JADX WARN: Multi-variable type inference failed */
        public QualifiedNameTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.c = -1;
            this.d = -1;
            this.b = Collections.emptyList();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.b = new ArrayList();
                                z2 |= true;
                            }
                            this.b.add(codedInputStream.readMessage(QualifiedName.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.b = Collections.unmodifiableList(this.b);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.b = Collections.unmodifiableList(this.b);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> PARSER = new a();
        public static final StringTable e;
        public final ByteString a;
        public LazyStringList b;
        public byte c;
        public int d;

        public static final class Builder extends GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            public int b;
            public LazyStringList c = LazyStringArrayList.EMPTY;

            public StringTable buildPartial() {
                StringTable stringTable = new StringTable(this, null);
                if ((this.b & 1) == 1) {
                    this.c = this.c.getUnmodifiableView();
                    this.b &= -2;
                }
                stringTable.b = this.c;
                return stringTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTable build() {
                StringTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(StringTable stringTable) {
                if (stringTable == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!stringTable.b.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = stringTable.b;
                        this.b &= -2;
                    } else {
                        if ((this.b & 1) != 1) {
                            this.c = new LazyStringArrayList(this.c);
                            this.b |= 1;
                        }
                        this.c.addAll(stringTable.b);
                    }
                }
                setUnknownFields(getUnknownFields().concat(stringTable.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                StringTable stringTable;
                StringTable stringTable2 = null;
                try {
                    StringTable parsePartialFrom = StringTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    stringTable = (StringTable) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    stringTable2 = stringTable;
                }
                if (stringTable2 != null) {
                    mergeFrom(stringTable2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<StringTable> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTable(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            StringTable stringTable = new StringTable();
            e = stringTable;
            stringTable.b = LazyStringArrayList.EMPTY;
        }

        public StringTable(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.c = -1;
            this.d = -1;
            this.a = builder.getUnknownFields();
        }

        public static StringTable getDefaultInstance() {
            return e;
        }

        public static Builder newBuilder(StringTable stringTable) {
            return newBuilder().mergeFrom(stringTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.d;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                i2 += CodedOutputStream.computeBytesSizeNoTag(this.b.getByteString(i3));
            }
            int size = this.a.size() + (getStringList().size() * 1) + 0 + i2;
            this.d = size;
            return size;
        }

        public String getString(int i) {
            return (String) this.b.get(i);
        }

        public ProtocolStringList getStringList() {
            return this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.c;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.c = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.b.size(); i++) {
                codedOutputStream.writeBytes(1, this.b.getByteString(i));
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTable getDefaultInstanceForType() {
            return e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public StringTable() {
            this.c = -1;
            this.d = -1;
            this.a = ByteString.EMPTY;
        }

        public StringTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.c = -1;
            this.d = -1;
            this.b = LazyStringArrayList.EMPTY;
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            ByteString readBytes = codedInputStream.readBytes();
                            if (!z2 || !true) {
                                this.b = new LazyStringArrayList();
                                z2 |= true;
                            }
                            this.b.add(readBytes);
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.b = this.b.getUnmodifiableView();
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.b = this.b.getUnmodifiableView();
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements TypeOrBuilder {
        public static Parser<Type> PARSER = new a();
        public static final Type t;
        public final ByteString b;
        public int c;
        public List<Argument> d;
        public boolean e;
        public int f;
        public Type g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public Type m;
        public int n;
        public Type o;
        public int p;
        public int q;
        public byte r;
        public int s;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER = new a();
            public static final Argument h;
            public final ByteString a;
            public int b;
            public Projection c;
            public Type d;
            public int e;
            public byte f;
            public int g;

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                public int b;
                public Projection c = Projection.INV;
                public Type d = Type.getDefaultInstance();
                public int e;

                public Argument buildPartial() {
                    Argument argument = new Argument(this, null);
                    int i = this.b;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    argument.c = this.c;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    argument.d = this.d;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    argument.e = this.e;
                    argument.b = i2;
                    return argument;
                }

                public Type getType() {
                    return this.d;
                }

                public boolean hasType() {
                    return (this.b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return !hasType() || getType().isInitialized();
                }

                public Builder mergeType(Type type) {
                    if ((this.b & 2) != 2 || this.d == Type.getDefaultInstance()) {
                        this.d = type;
                    } else {
                        this.d = Type.newBuilder(this.d).mergeFrom(type).buildPartial();
                    }
                    this.b |= 2;
                    return this;
                }

                public Builder setProjection(Projection projection) {
                    Objects.requireNonNull(projection);
                    this.b |= 1;
                    this.c = projection;
                    return this;
                }

                public Builder setTypeId(int i) {
                    this.b |= 4;
                    this.e = i;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
                public Builder clone() {
                    return new Builder().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasProjection()) {
                        setProjection(argument.getProjection());
                    }
                    if (argument.hasType()) {
                        mergeType(argument.getType());
                    }
                    if (argument.hasTypeId()) {
                        setTypeId(argument.getTypeId());
                    }
                    setUnknownFields(getUnknownFields().concat(argument.a));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Throwable th;
                    Argument argument;
                    Argument argument2 = null;
                    try {
                        Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        argument = (Argument) e2.getUnfinishedMessage();
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        argument2 = argument;
                    }
                    if (argument2 != null) {
                        mergeFrom(argument2);
                    }
                    throw th;
                }
            }

            public enum Projection implements Internal.EnumLite {
                IN(0),
                OUT(1),
                INV(2),
                STAR(3);
                
                public final int a;

                /* access modifiers changed from: public */
                Projection(int i) {
                    this.a = i;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.a;
                }

                public static Projection valueOf(int i) {
                    if (i == 0) {
                        return IN;
                    }
                    if (i == 1) {
                        return OUT;
                    }
                    if (i == 2) {
                        return INV;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return STAR;
                }
            }

            public static class a extends AbstractParser<Argument> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Argument(codedInputStream, extensionRegistryLite, null);
                }
            }

            static {
                Argument argument = new Argument();
                h = argument;
                argument.c = Projection.INV;
                argument.d = Type.getDefaultInstance();
                argument.e = 0;
            }

            public Argument(GeneratedMessageLite.Builder builder, a aVar) {
                super(builder);
                this.f = -1;
                this.g = -1;
                this.a = builder.getUnknownFields();
            }

            public static Argument getDefaultInstance() {
                return h;
            }

            public static Builder newBuilder(Argument argument) {
                return newBuilder().mergeFrom(argument);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public Projection getProjection() {
                return this.c;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.g;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.b & 1) == 1) {
                    i2 = 0 + CodedOutputStream.computeEnumSize(1, this.c.getNumber());
                }
                if ((this.b & 2) == 2) {
                    i2 += CodedOutputStream.computeMessageSize(2, this.d);
                }
                if ((this.b & 4) == 4) {
                    i2 += CodedOutputStream.computeInt32Size(3, this.e);
                }
                int size = this.a.size() + i2;
                this.g = size;
                return size;
            }

            public Type getType() {
                return this.d;
            }

            public int getTypeId() {
                return this.e;
            }

            public boolean hasProjection() {
                return (this.b & 1) == 1;
            }

            public boolean hasType() {
                return (this.b & 2) == 2;
            }

            public boolean hasTypeId() {
                return (this.b & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.f;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!hasType() || getType().isInitialized()) {
                    this.f = 1;
                    return true;
                }
                this.f = 0;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.b & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.c.getNumber());
                }
                if ((this.b & 2) == 2) {
                    codedOutputStream.writeMessage(2, this.d);
                }
                if ((this.b & 4) == 4) {
                    codedOutputStream.writeInt32(3, this.e);
                }
                codedOutputStream.writeRawBytes(this.a);
            }

            public static Builder newBuilder() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return h;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            public Argument() {
                this.f = -1;
                this.g = -1;
                this.a = ByteString.EMPTY;
            }

            public Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this.f = -1;
                this.g = -1;
                this.c = Projection.INV;
                this.d = Type.getDefaultInstance();
                boolean z = false;
                this.e = 0;
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                int readEnum = codedInputStream.readEnum();
                                Projection valueOf = Projection.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.b |= 1;
                                    this.c = valueOf;
                                }
                            } else if (readTag == 18) {
                                Builder builder = (this.b & 2) == 2 ? this.d.toBuilder() : null;
                                Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.d = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.d = builder.buildPartial();
                                }
                                this.b |= 2;
                            } else if (readTag == 24) {
                                this.b |= 4;
                                this.e = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    } catch (Throwable th) {
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.a = newOutput.toByteString();
                            throw th2;
                        }
                        this.a = newOutput.toByteString();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.a = newOutput.toByteString();
                    throw th3;
                }
                this.a = newOutput.toByteString();
                makeExtensionsImmutable();
            }
        }

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            public int d;
            public List<Argument> e = Collections.emptyList();
            public boolean f;
            public int g;
            public Type h = Type.getDefaultInstance();
            public int i;
            public int j;
            public int k;
            public int l;
            public int m;
            public Type n = Type.getDefaultInstance();
            public int o;
            public Type p = Type.getDefaultInstance();
            public int q;
            public int r;

            public Type buildPartial() {
                Type type = new Type(this, null);
                int i2 = this.d;
                int i3 = 1;
                if ((i2 & 1) == 1) {
                    this.e = Collections.unmodifiableList(this.e);
                    this.d &= -2;
                }
                type.d = this.e;
                if ((i2 & 2) != 2) {
                    i3 = 0;
                }
                type.e = this.f;
                if ((i2 & 4) == 4) {
                    i3 |= 2;
                }
                type.f = this.g;
                if ((i2 & 8) == 8) {
                    i3 |= 4;
                }
                type.g = this.h;
                if ((i2 & 16) == 16) {
                    i3 |= 8;
                }
                type.h = this.i;
                if ((i2 & 32) == 32) {
                    i3 |= 16;
                }
                type.i = this.j;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                type.j = this.k;
                if ((i2 & 128) == 128) {
                    i3 |= 64;
                }
                type.k = this.l;
                if ((i2 & 256) == 256) {
                    i3 |= 128;
                }
                type.l = this.m;
                if ((i2 & 512) == 512) {
                    i3 |= 256;
                }
                type.m = this.n;
                if ((i2 & 1024) == 1024) {
                    i3 |= 512;
                }
                type.n = this.o;
                if ((i2 & 2048) == 2048) {
                    i3 |= 1024;
                }
                type.o = this.p;
                if ((i2 & 4096) == 4096) {
                    i3 |= 2048;
                }
                type.p = this.q;
                if ((i2 & 8192) == 8192) {
                    i3 |= 4096;
                }
                type.q = this.r;
                type.c = i3;
                return type;
            }

            public Type getAbbreviatedType() {
                return this.p;
            }

            public Argument getArgument(int i2) {
                return this.e.get(i2);
            }

            public int getArgumentCount() {
                return this.e.size();
            }

            public Type getFlexibleUpperBound() {
                return this.h;
            }

            public Type getOuterType() {
                return this.n;
            }

            public boolean hasAbbreviatedType() {
                return (this.d & 2048) == 2048;
            }

            public boolean hasFlexibleUpperBound() {
                return (this.d & 8) == 8;
            }

            public boolean hasOuterType() {
                return (this.d & 512) == 512;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < getArgumentCount(); i2++) {
                    if (!getArgument(i2).isInitialized()) {
                        return false;
                    }
                }
                if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                    return false;
                }
                if (hasOuterType() && !getOuterType().isInitialized()) {
                    return false;
                }
                if ((!hasAbbreviatedType() || getAbbreviatedType().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeAbbreviatedType(Type type) {
                if ((this.d & 2048) != 2048 || this.p == Type.getDefaultInstance()) {
                    this.p = type;
                } else {
                    this.p = Type.newBuilder(this.p).mergeFrom(type).buildPartial();
                }
                this.d |= 2048;
                return this;
            }

            public Builder mergeFlexibleUpperBound(Type type) {
                if ((this.d & 8) != 8 || this.h == Type.getDefaultInstance()) {
                    this.h = type;
                } else {
                    this.h = Type.newBuilder(this.h).mergeFrom(type).buildPartial();
                }
                this.d |= 8;
                return this;
            }

            public Builder mergeOuterType(Type type) {
                if ((this.d & 512) != 512 || this.n == Type.getDefaultInstance()) {
                    this.n = type;
                } else {
                    this.n = Type.newBuilder(this.n).mergeFrom(type).buildPartial();
                }
                this.d |= 512;
                return this;
            }

            public Builder setAbbreviatedTypeId(int i2) {
                this.d |= 4096;
                this.q = i2;
                return this;
            }

            public Builder setClassName(int i2) {
                this.d |= 32;
                this.j = i2;
                return this;
            }

            public Builder setFlags(int i2) {
                this.d |= 8192;
                this.r = i2;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int i2) {
                this.d |= 4;
                this.g = i2;
                return this;
            }

            public Builder setFlexibleUpperBoundId(int i2) {
                this.d |= 16;
                this.i = i2;
                return this;
            }

            public Builder setNullable(boolean z) {
                this.d |= 2;
                this.f = z;
                return this;
            }

            public Builder setOuterTypeId(int i2) {
                this.d |= 1024;
                this.o = i2;
                return this;
            }

            public Builder setTypeAliasName(int i2) {
                this.d |= 256;
                this.m = i2;
                return this;
            }

            public Builder setTypeParameter(int i2) {
                this.d |= 64;
                this.k = i2;
                return this;
            }

            public Builder setTypeParameterName(int i2) {
                this.d |= 128;
                this.l = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Type build() {
                Type buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            public Builder mergeFrom(Type type) {
                if (type == Type.getDefaultInstance()) {
                    return this;
                }
                if (!type.d.isEmpty()) {
                    if (this.e.isEmpty()) {
                        this.e = type.d;
                        this.d &= -2;
                    } else {
                        if ((this.d & 1) != 1) {
                            this.e = new ArrayList(this.e);
                            this.d |= 1;
                        }
                        this.e.addAll(type.d);
                    }
                }
                if (type.hasNullable()) {
                    setNullable(type.getNullable());
                }
                if (type.hasFlexibleTypeCapabilitiesId()) {
                    setFlexibleTypeCapabilitiesId(type.getFlexibleTypeCapabilitiesId());
                }
                if (type.hasFlexibleUpperBound()) {
                    mergeFlexibleUpperBound(type.getFlexibleUpperBound());
                }
                if (type.hasFlexibleUpperBoundId()) {
                    setFlexibleUpperBoundId(type.getFlexibleUpperBoundId());
                }
                if (type.hasClassName()) {
                    setClassName(type.getClassName());
                }
                if (type.hasTypeParameter()) {
                    setTypeParameter(type.getTypeParameter());
                }
                if (type.hasTypeParameterName()) {
                    setTypeParameterName(type.getTypeParameterName());
                }
                if (type.hasTypeAliasName()) {
                    setTypeAliasName(type.getTypeAliasName());
                }
                if (type.hasOuterType()) {
                    mergeOuterType(type.getOuterType());
                }
                if (type.hasOuterTypeId()) {
                    setOuterTypeId(type.getOuterTypeId());
                }
                if (type.hasAbbreviatedType()) {
                    mergeAbbreviatedType(type.getAbbreviatedType());
                }
                if (type.hasAbbreviatedTypeId()) {
                    setAbbreviatedTypeId(type.getAbbreviatedTypeId());
                }
                if (type.hasFlags()) {
                    setFlags(type.getFlags());
                }
                mergeExtensionFields(type);
                setUnknownFields(getUnknownFields().concat(type.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                Type type;
                Type type2 = null;
                try {
                    Type parsePartialFrom = Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    type = (Type) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    type2 = type;
                }
                if (type2 != null) {
                    mergeFrom(type2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<Type> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Type(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            Type type = new Type();
            t = type;
            type.b();
        }

        public Type(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.r = -1;
            this.s = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static Type getDefaultInstance() {
            return t;
        }

        public static Builder newBuilder(Type type) {
            return newBuilder().mergeFrom(type);
        }

        public final void b() {
            this.d = Collections.emptyList();
            this.e = false;
            this.f = 0;
            this.g = getDefaultInstance();
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = getDefaultInstance();
            this.n = 0;
            this.o = getDefaultInstance();
            this.p = 0;
            this.q = 0;
        }

        public Type getAbbreviatedType() {
            return this.o;
        }

        public int getAbbreviatedTypeId() {
            return this.p;
        }

        public Argument getArgument(int i2) {
            return this.d.get(i2);
        }

        public int getArgumentCount() {
            return this.d.size();
        }

        public List<Argument> getArgumentList() {
            return this.d;
        }

        public int getClassName() {
            return this.i;
        }

        public int getFlags() {
            return this.q;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.f;
        }

        public Type getFlexibleUpperBound() {
            return this.g;
        }

        public int getFlexibleUpperBoundId() {
            return this.h;
        }

        public boolean getNullable() {
            return this.e;
        }

        public Type getOuterType() {
            return this.m;
        }

        public int getOuterTypeId() {
            return this.n;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Type> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.s;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.c & 4096) == 4096 ? CodedOutputStream.computeInt32Size(1, this.q) + 0 : 0;
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.d.get(i3));
            }
            if ((this.c & 1) == 1) {
                computeInt32Size += CodedOutputStream.computeBoolSize(3, this.e);
            }
            if ((this.c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, this.f);
            }
            if ((this.c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.g);
            }
            if ((this.c & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, this.i);
            }
            if ((this.c & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.j);
            }
            if ((this.c & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(8, this.h);
            }
            if ((this.c & 64) == 64) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, this.k);
            }
            if ((this.c & 256) == 256) {
                computeInt32Size += CodedOutputStream.computeMessageSize(10, this.m);
            }
            if ((this.c & 512) == 512) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, this.n);
            }
            if ((this.c & 128) == 128) {
                computeInt32Size += CodedOutputStream.computeInt32Size(12, this.l);
            }
            if ((this.c & 1024) == 1024) {
                computeInt32Size += CodedOutputStream.computeMessageSize(13, this.o);
            }
            if ((this.c & 2048) == 2048) {
                computeInt32Size += CodedOutputStream.computeInt32Size(14, this.p);
            }
            int size = this.b.size() + extensionsSerializedSize() + computeInt32Size;
            this.s = size;
            return size;
        }

        public int getTypeAliasName() {
            return this.l;
        }

        public int getTypeParameter() {
            return this.j;
        }

        public int getTypeParameterName() {
            return this.k;
        }

        public boolean hasAbbreviatedType() {
            return (this.c & 1024) == 1024;
        }

        public boolean hasAbbreviatedTypeId() {
            return (this.c & 2048) == 2048;
        }

        public boolean hasClassName() {
            return (this.c & 16) == 16;
        }

        public boolean hasFlags() {
            return (this.c & 4096) == 4096;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.c & 2) == 2;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.c & 4) == 4;
        }

        public boolean hasFlexibleUpperBoundId() {
            return (this.c & 8) == 8;
        }

        public boolean hasNullable() {
            return (this.c & 1) == 1;
        }

        public boolean hasOuterType() {
            return (this.c & 256) == 256;
        }

        public boolean hasOuterTypeId() {
            return (this.c & 512) == 512;
        }

        public boolean hasTypeAliasName() {
            return (this.c & 128) == 128;
        }

        public boolean hasTypeParameter() {
            return (this.c & 32) == 32;
        }

        public boolean hasTypeParameterName() {
            return (this.c & 64) == 64;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.r;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < getArgumentCount(); i2++) {
                if (!getArgument(i2).isInitialized()) {
                    this.r = 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.r = 0;
                return false;
            } else if (hasOuterType() && !getOuterType().isInitialized()) {
                this.r = 0;
                return false;
            } else if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.r = 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.r = 0;
                return false;
            } else {
                this.r = 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 4096) == 4096) {
                codedOutputStream.writeInt32(1, this.q);
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                codedOutputStream.writeMessage(2, this.d.get(i2));
            }
            if ((this.c & 1) == 1) {
                codedOutputStream.writeBool(3, this.e);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt32(4, this.f);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeMessage(5, this.g);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeInt32(6, this.i);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeInt32(7, this.j);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt32(8, this.h);
            }
            if ((this.c & 64) == 64) {
                codedOutputStream.writeInt32(9, this.k);
            }
            if ((this.c & 256) == 256) {
                codedOutputStream.writeMessage(10, this.m);
            }
            if ((this.c & 512) == 512) {
                codedOutputStream.writeInt32(11, this.n);
            }
            if ((this.c & 128) == 128) {
                codedOutputStream.writeInt32(12, this.l);
            }
            if ((this.c & 1024) == 1024) {
                codedOutputStream.writeMessage(13, this.o);
            }
            if ((this.c & 2048) == 2048) {
                codedOutputStream.writeInt32(14, this.p);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Type getDefaultInstanceForType() {
            return t;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Type() {
            this.r = -1;
            this.s = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument> */
        /* JADX WARN: Multi-variable type inference failed */
        public Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.r = -1;
            this.s = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    Builder builder = null;
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.c |= 4096;
                            this.q = codedInputStream.readInt32();
                            continue;
                        case 18:
                            if (!z2 || !true) {
                                this.d = new ArrayList();
                                z2 |= true;
                            }
                            this.d.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                            continue;
                        case 24:
                            this.c |= 1;
                            this.e = codedInputStream.readBool();
                            continue;
                        case 32:
                            this.c |= 2;
                            this.f = codedInputStream.readInt32();
                            continue;
                        case 42:
                            builder = (this.c & 4) == 4 ? this.g.toBuilder() : builder;
                            Type type = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.g = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.g = builder.buildPartial();
                            }
                            this.c |= 4;
                            continue;
                        case 48:
                            this.c |= 16;
                            this.i = codedInputStream.readInt32();
                            continue;
                        case 56:
                            this.c |= 32;
                            this.j = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.c |= 8;
                            this.h = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.c |= 64;
                            this.k = codedInputStream.readInt32();
                            continue;
                        case 82:
                            builder = (this.c & 256) == 256 ? this.m.toBuilder() : builder;
                            Type type2 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.m = type2;
                            if (builder != null) {
                                builder.mergeFrom(type2);
                                this.m = builder.buildPartial();
                            }
                            this.c |= 256;
                            continue;
                        case 88:
                            this.c |= 512;
                            this.n = codedInputStream.readInt32();
                            continue;
                        case 96:
                            this.c |= 128;
                            this.l = codedInputStream.readInt32();
                            continue;
                        case 106:
                            builder = (this.c & 1024) == 1024 ? this.o.toBuilder() : builder;
                            Type type3 = (Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                            this.o = type3;
                            if (builder != null) {
                                builder.mergeFrom(type3);
                                this.o = builder.buildPartial();
                            }
                            this.c |= 1024;
                            continue;
                        case 112:
                            this.c |= 2048;
                            this.p = codedInputStream.readInt32();
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.d = Collections.unmodifiableList(this.d);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.d = Collections.unmodifiableList(this.d);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static Parser<TypeAlias> PARSER = new a();
        public static final TypeAlias o;
        public final ByteString b;
        public int c;
        public int d;
        public int e;
        public List<TypeParameter> f;
        public Type g;
        public int h;
        public Type i;
        public int j;
        public List<Annotation> k;
        public List<Integer> l;
        public byte m;
        public int n;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            public int d;
            public int e = 6;
            public int f;
            public List<TypeParameter> g = Collections.emptyList();
            public Type h = Type.getDefaultInstance();
            public int i;
            public Type j = Type.getDefaultInstance();
            public int k;
            public List<Annotation> l = Collections.emptyList();
            public List<Integer> m = Collections.emptyList();

            public TypeAlias buildPartial() {
                TypeAlias typeAlias = new TypeAlias(this, null);
                int i2 = this.d;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                typeAlias.d = this.e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                typeAlias.e = this.f;
                if ((i2 & 4) == 4) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.d &= -5;
                }
                typeAlias.f = this.g;
                if ((i2 & 8) == 8) {
                    i3 |= 4;
                }
                typeAlias.g = this.h;
                if ((i2 & 16) == 16) {
                    i3 |= 8;
                }
                typeAlias.h = this.i;
                if ((i2 & 32) == 32) {
                    i3 |= 16;
                }
                typeAlias.i = this.j;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                typeAlias.j = this.k;
                if ((this.d & 128) == 128) {
                    this.l = Collections.unmodifiableList(this.l);
                    this.d &= -129;
                }
                typeAlias.k = this.l;
                if ((this.d & 256) == 256) {
                    this.m = Collections.unmodifiableList(this.m);
                    this.d &= -257;
                }
                typeAlias.l = this.m;
                typeAlias.c = i3;
                return typeAlias;
            }

            public Annotation getAnnotation(int i2) {
                return this.l.get(i2);
            }

            public int getAnnotationCount() {
                return this.l.size();
            }

            public Type getExpandedType() {
                return this.j;
            }

            public TypeParameter getTypeParameter(int i2) {
                return this.g.get(i2);
            }

            public int getTypeParameterCount() {
                return this.g.size();
            }

            public Type getUnderlyingType() {
                return this.h;
            }

            public boolean hasExpandedType() {
                return (this.d & 32) == 32;
            }

            public boolean hasName() {
                return (this.d & 2) == 2;
            }

            public boolean hasUnderlyingType() {
                return (this.d & 8) == 8;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                    if (!getTypeParameter(i2).isInitialized()) {
                        return false;
                    }
                }
                if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                    return false;
                }
                if (hasExpandedType() && !getExpandedType().isInitialized()) {
                    return false;
                }
                for (int i3 = 0; i3 < getAnnotationCount(); i3++) {
                    if (!getAnnotation(i3).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeExpandedType(Type type) {
                if ((this.d & 32) != 32 || this.j == Type.getDefaultInstance()) {
                    this.j = type;
                } else {
                    this.j = Type.newBuilder(this.j).mergeFrom(type).buildPartial();
                }
                this.d |= 32;
                return this;
            }

            public Builder mergeUnderlyingType(Type type) {
                if ((this.d & 8) != 8 || this.h == Type.getDefaultInstance()) {
                    this.h = type;
                } else {
                    this.h = Type.newBuilder(this.h).mergeFrom(type).buildPartial();
                }
                this.d |= 8;
                return this;
            }

            public Builder setExpandedTypeId(int i2) {
                this.d |= 64;
                this.k = i2;
                return this;
            }

            public Builder setFlags(int i2) {
                this.d |= 1;
                this.e = i2;
                return this;
            }

            public Builder setName(int i2) {
                this.d |= 2;
                this.f = i2;
                return this;
            }

            public Builder setUnderlyingTypeId(int i2) {
                this.d |= 16;
                this.i = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeAlias build() {
                TypeAlias buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            public Builder mergeFrom(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (typeAlias.hasFlags()) {
                    setFlags(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    setName(typeAlias.getName());
                }
                if (!typeAlias.f.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = typeAlias.f;
                        this.d &= -5;
                    } else {
                        if ((this.d & 4) != 4) {
                            this.g = new ArrayList(this.g);
                            this.d |= 4;
                        }
                        this.g.addAll(typeAlias.f);
                    }
                }
                if (typeAlias.hasUnderlyingType()) {
                    mergeUnderlyingType(typeAlias.getUnderlyingType());
                }
                if (typeAlias.hasUnderlyingTypeId()) {
                    setUnderlyingTypeId(typeAlias.getUnderlyingTypeId());
                }
                if (typeAlias.hasExpandedType()) {
                    mergeExpandedType(typeAlias.getExpandedType());
                }
                if (typeAlias.hasExpandedTypeId()) {
                    setExpandedTypeId(typeAlias.getExpandedTypeId());
                }
                if (!typeAlias.k.isEmpty()) {
                    if (this.l.isEmpty()) {
                        this.l = typeAlias.k;
                        this.d &= -129;
                    } else {
                        if ((this.d & 128) != 128) {
                            this.l = new ArrayList(this.l);
                            this.d |= 128;
                        }
                        this.l.addAll(typeAlias.k);
                    }
                }
                if (!typeAlias.l.isEmpty()) {
                    if (this.m.isEmpty()) {
                        this.m = typeAlias.l;
                        this.d &= -257;
                    } else {
                        if ((this.d & 256) != 256) {
                            this.m = new ArrayList(this.m);
                            this.d |= 256;
                        }
                        this.m.addAll(typeAlias.l);
                    }
                }
                mergeExtensionFields(typeAlias);
                setUnknownFields(getUnknownFields().concat(typeAlias.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                TypeAlias typeAlias;
                TypeAlias typeAlias2 = null;
                try {
                    TypeAlias parsePartialFrom = TypeAlias.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    typeAlias = (TypeAlias) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    typeAlias2 = typeAlias;
                }
                if (typeAlias2 != null) {
                    mergeFrom(typeAlias2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<TypeAlias> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeAlias(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            TypeAlias typeAlias = new TypeAlias();
            o = typeAlias;
            typeAlias.b();
        }

        public TypeAlias(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.m = -1;
            this.n = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static TypeAlias getDefaultInstance() {
            return o;
        }

        public static Builder newBuilder(TypeAlias typeAlias) {
            return newBuilder().mergeFrom(typeAlias);
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public final void b() {
            this.d = 6;
            this.e = 0;
            this.f = Collections.emptyList();
            this.g = Type.getDefaultInstance();
            this.h = 0;
            this.i = Type.getDefaultInstance();
            this.j = 0;
            this.k = Collections.emptyList();
            this.l = Collections.emptyList();
        }

        public Annotation getAnnotation(int i2) {
            return this.k.get(i2);
        }

        public int getAnnotationCount() {
            return this.k.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.k;
        }

        public Type getExpandedType() {
            return this.i;
        }

        public int getExpandedTypeId() {
            return this.j;
        }

        public int getFlags() {
            return this.d;
        }

        public int getName() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.c & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.d) + 0 : 0;
            if ((this.c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.e);
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.f.get(i3));
            }
            if ((this.c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.g);
            }
            if ((this.c & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, this.h);
            }
            if ((this.c & 16) == 16) {
                computeInt32Size += CodedOutputStream.computeMessageSize(6, this.i);
            }
            if ((this.c & 32) == 32) {
                computeInt32Size += CodedOutputStream.computeInt32Size(7, this.j);
            }
            for (int i4 = 0; i4 < this.k.size(); i4++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(8, this.k.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.l.size(); i6++) {
                i5 += CodedOutputStream.computeInt32SizeNoTag(this.l.get(i6).intValue());
            }
            int size = this.b.size() + extensionsSerializedSize() + (getVersionRequirementList().size() * 2) + computeInt32Size + i5;
            this.n = size;
            return size;
        }

        public TypeParameter getTypeParameter(int i2) {
            return this.f.get(i2);
        }

        public int getTypeParameterCount() {
            return this.f.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.f;
        }

        public Type getUnderlyingType() {
            return this.g;
        }

        public int getUnderlyingTypeId() {
            return this.h;
        }

        public List<Integer> getVersionRequirementList() {
            return this.l;
        }

        public boolean hasExpandedType() {
            return (this.c & 16) == 16;
        }

        public boolean hasExpandedTypeId() {
            return (this.c & 32) == 32;
        }

        public boolean hasFlags() {
            return (this.c & 1) == 1;
        }

        public boolean hasName() {
            return (this.c & 2) == 2;
        }

        public boolean hasUnderlyingType() {
            return (this.c & 4) == 4;
        }

        public boolean hasUnderlyingTypeId() {
            return (this.c & 8) == 8;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasName()) {
                this.m = 0;
                return false;
            }
            for (int i2 = 0; i2 < getTypeParameterCount(); i2++) {
                if (!getTypeParameter(i2).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.m = 0;
                return false;
            } else if (!hasExpandedType() || getExpandedType().isInitialized()) {
                for (int i3 = 0; i3 < getAnnotationCount(); i3++) {
                    if (!getAnnotation(i3).isInitialized()) {
                        this.m = 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.m = 0;
                    return false;
                }
                this.m = 1;
                return true;
            } else {
                this.m = 0;
                return false;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt32(2, this.e);
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                codedOutputStream.writeMessage(3, this.f.get(i2));
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeMessage(4, this.g);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt32(5, this.h);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeMessage(6, this.i);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeInt32(7, this.j);
            }
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                codedOutputStream.writeMessage(8, this.k.get(i3));
            }
            for (int i4 = 0; i4 < this.l.size(); i4++) {
                codedOutputStream.writeInt32(31, this.l.get(i4).intValue());
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeAlias getDefaultInstanceForType() {
            return o;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public TypeAlias() {
            this.m = -1;
            this.n = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v10, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v37, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation> */
        /* JADX WARN: Multi-variable type inference failed */
        public TypeAlias(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.m = -1;
            this.n = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    Type.Builder builder = null;
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.c |= 1;
                            this.d = codedInputStream.readInt32();
                            continue;
                        case 16:
                            this.c |= 2;
                            this.e = codedInputStream.readInt32();
                            continue;
                        case 26:
                            if (!(z2 & true)) {
                                this.f = new ArrayList();
                                z2 |= true;
                            }
                            this.f.add(codedInputStream.readMessage(TypeParameter.PARSER, extensionRegistryLite));
                            continue;
                        case 34:
                            builder = (this.c & 4) == 4 ? this.g.toBuilder() : builder;
                            Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.g = type;
                            if (builder != null) {
                                builder.mergeFrom(type);
                                this.g = builder.buildPartial();
                            }
                            this.c |= 4;
                            continue;
                        case 40:
                            this.c |= 8;
                            this.h = codedInputStream.readInt32();
                            continue;
                        case 50:
                            builder = (this.c & 16) == 16 ? this.i.toBuilder() : builder;
                            Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                            this.i = type2;
                            if (builder != null) {
                                builder.mergeFrom(type2);
                                this.i = builder.buildPartial();
                            }
                            this.c |= 16;
                            continue;
                        case 56:
                            this.c |= 32;
                            this.j = codedInputStream.readInt32();
                            continue;
                        case 66:
                            if (!(z2 & true)) {
                                this.k = new ArrayList();
                                z2 |= true;
                            }
                            this.k.add(codedInputStream.readMessage(Annotation.PARSER, extensionRegistryLite));
                            continue;
                        case 248:
                            if (!(z2 & true)) {
                                this.l = new ArrayList();
                                z2 |= true;
                            }
                            this.l.add(Integer.valueOf(codedInputStream.readInt32()));
                            continue;
                        case 250:
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.l = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.l.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.f = Collections.unmodifiableList(this.f);
                    }
                    if (z2 & true) {
                        this.k = Collections.unmodifiableList(this.k);
                    }
                    if (z2 & true) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.f = Collections.unmodifiableList(this.f);
            }
            if (z2 & true) {
                this.k = Collections.unmodifiableList(this.k);
            }
            if (z2 & true) {
                this.l = Collections.unmodifiableList(this.l);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface TypeAliasOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface TypeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static Parser<TypeParameter> PARSER = new a();
        public static final TypeParameter m;
        public final ByteString b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public Variance g;
        public List<Type> h;
        public List<Integer> i;
        public int j;
        public byte k;
        public int l;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            public int d;
            public int e;
            public int f;
            public boolean g;
            public Variance h = Variance.INV;
            public List<Type> i = Collections.emptyList();
            public List<Integer> j = Collections.emptyList();

            public TypeParameter buildPartial() {
                TypeParameter typeParameter = new TypeParameter(this, null);
                int i2 = this.d;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                typeParameter.d = this.e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                typeParameter.e = this.f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                typeParameter.f = this.g;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                typeParameter.g = this.h;
                if ((i2 & 16) == 16) {
                    this.i = Collections.unmodifiableList(this.i);
                    this.d &= -17;
                }
                typeParameter.h = this.i;
                if ((this.d & 32) == 32) {
                    this.j = Collections.unmodifiableList(this.j);
                    this.d &= -33;
                }
                typeParameter.i = this.j;
                typeParameter.c = i3;
                return typeParameter;
            }

            public Type getUpperBound(int i2) {
                return this.i.get(i2);
            }

            public int getUpperBoundCount() {
                return this.i.size();
            }

            public boolean hasId() {
                return (this.d & 1) == 1;
            }

            public boolean hasName() {
                return (this.d & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!(hasId() && hasName())) {
                    return false;
                }
                for (int i2 = 0; i2 < getUpperBoundCount(); i2++) {
                    if (!getUpperBound(i2).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder setId(int i2) {
                this.d |= 1;
                this.e = i2;
                return this;
            }

            public Builder setName(int i2) {
                this.d |= 2;
                this.f = i2;
                return this;
            }

            public Builder setReified(boolean z) {
                this.d |= 4;
                this.g = z;
                return this;
            }

            public Builder setVariance(Variance variance) {
                Objects.requireNonNull(variance);
                this.d |= 8;
                this.h = variance;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeParameter build() {
                TypeParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            public Builder mergeFrom(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    setId(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    setName(typeParameter.getName());
                }
                if (typeParameter.hasReified()) {
                    setReified(typeParameter.getReified());
                }
                if (typeParameter.hasVariance()) {
                    setVariance(typeParameter.getVariance());
                }
                if (!typeParameter.h.isEmpty()) {
                    if (this.i.isEmpty()) {
                        this.i = typeParameter.h;
                        this.d &= -17;
                    } else {
                        if ((this.d & 16) != 16) {
                            this.i = new ArrayList(this.i);
                            this.d |= 16;
                        }
                        this.i.addAll(typeParameter.h);
                    }
                }
                if (!typeParameter.i.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = typeParameter.i;
                        this.d &= -33;
                    } else {
                        if ((this.d & 32) != 32) {
                            this.j = new ArrayList(this.j);
                            this.d |= 32;
                        }
                        this.j.addAll(typeParameter.i);
                    }
                }
                mergeExtensionFields(typeParameter);
                setUnknownFields(getUnknownFields().concat(typeParameter.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                TypeParameter typeParameter;
                TypeParameter typeParameter2 = null;
                try {
                    TypeParameter parsePartialFrom = TypeParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    typeParameter = (TypeParameter) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    typeParameter2 = typeParameter;
                }
                if (typeParameter2 != null) {
                    mergeFrom(typeParameter2);
                }
                throw th;
            }
        }

        public enum Variance implements Internal.EnumLite {
            IN(0),
            OUT(1),
            INV(2);
            
            public final int a;

            /* access modifiers changed from: public */
            Variance(int i) {
                this.a = i;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.a;
            }

            public static Variance valueOf(int i) {
                if (i == 0) {
                    return IN;
                }
                if (i == 1) {
                    return OUT;
                }
                if (i != 2) {
                    return null;
                }
                return INV;
            }
        }

        public static class a extends AbstractParser<TypeParameter> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeParameter(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            TypeParameter typeParameter = new TypeParameter();
            m = typeParameter;
            typeParameter.b();
        }

        public TypeParameter(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static TypeParameter getDefaultInstance() {
            return m;
        }

        public static Builder newBuilder(TypeParameter typeParameter) {
            return newBuilder().mergeFrom(typeParameter);
        }

        public final void b() {
            this.d = 0;
            this.e = 0;
            this.f = false;
            this.g = Variance.INV;
            this.h = Collections.emptyList();
            this.i = Collections.emptyList();
        }

        public int getId() {
            return this.d;
        }

        public int getName() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.f;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.l;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.c & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.d) + 0 : 0;
            if ((this.c & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.e);
            }
            if ((this.c & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBoolSize(3, this.f);
            }
            if ((this.c & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeEnumSize(4, this.g.getNumber());
            }
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(5, this.h.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.i.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.i.get(i5).intValue());
            }
            int i6 = computeInt32Size + i4;
            if (!getUpperBoundIdList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.j = i4;
            int size = this.b.size() + extensionsSerializedSize() + i6;
            this.l = size;
            return size;
        }

        public Type getUpperBound(int i2) {
            return this.h.get(i2);
        }

        public int getUpperBoundCount() {
            return this.h.size();
        }

        public List<Integer> getUpperBoundIdList() {
            return this.i;
        }

        public List<Type> getUpperBoundList() {
            return this.h;
        }

        public Variance getVariance() {
            return this.g;
        }

        public boolean hasId() {
            return (this.c & 1) == 1;
        }

        public boolean hasName() {
            return (this.c & 2) == 2;
        }

        public boolean hasReified() {
            return (this.c & 4) == 4;
        }

        public boolean hasVariance() {
            return (this.c & 8) == 8;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasId()) {
                this.k = 0;
                return false;
            } else if (!hasName()) {
                this.k = 0;
                return false;
            } else {
                for (int i2 = 0; i2 < getUpperBoundCount(); i2++) {
                    if (!getUpperBound(i2).isInitialized()) {
                        this.k = 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.k = 0;
                    return false;
                }
                this.k = 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt32(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeBool(3, this.f);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeEnum(4, this.g.getNumber());
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                codedOutputStream.writeMessage(5, this.h.get(i2));
            }
            if (getUpperBoundIdList().size() > 0) {
                codedOutputStream.writeRawVarint32(50);
                codedOutputStream.writeRawVarint32(this.j);
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                codedOutputStream.writeInt32NoTag(this.i.get(i3).intValue());
            }
            newExtensionWriter.writeUntil(1000, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeParameter getDefaultInstanceForType() {
            return m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public TypeParameter() {
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.b = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public TypeParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.j = -1;
            this.k = -1;
            this.l = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.c |= 1;
                            this.d = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.c |= 2;
                            this.e = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            this.c |= 4;
                            this.f = codedInputStream.readBool();
                        } else if (readTag == 32) {
                            int readEnum = codedInputStream.readEnum();
                            Variance valueOf = Variance.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.c |= 8;
                                this.g = valueOf;
                            }
                        } else if (readTag == 42) {
                            if (!(z2 & true)) {
                                this.h = new ArrayList();
                                z2 |= true;
                            }
                            this.h.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                        } else if (readTag == 48) {
                            if (!(z2 & true)) {
                                this.i = new ArrayList();
                                z2 |= true;
                            }
                            this.i.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag == 50) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.i = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.i.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    if (z2 & true) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.h = Collections.unmodifiableList(this.h);
            }
            if (z2 & true) {
                this.i = Collections.unmodifiableList(this.i);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface TypeParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static Parser<TypeTable> PARSER = new a();
        public static final TypeTable g;
        public final ByteString a;
        public int b;
        public List<Type> c;
        public int d;
        public byte e;
        public int f;

        public static final class Builder extends GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            public int b;
            public List<Type> c = Collections.emptyList();
            public int d = -1;

            public TypeTable buildPartial() {
                TypeTable typeTable = new TypeTable(this, null);
                int i = this.b;
                int i2 = 1;
                if ((i & 1) == 1) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.b &= -2;
                }
                typeTable.c = this.c;
                if ((i & 2) != 2) {
                    i2 = 0;
                }
                typeTable.d = this.d;
                typeTable.b = i2;
                return typeTable;
            }

            public Type getType(int i) {
                return this.c.get(i);
            }

            public int getTypeCount() {
                return this.c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getTypeCount(); i++) {
                    if (!getType(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder setFirstNullable(int i) {
                this.b |= 2;
                this.d = i;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeTable build() {
                TypeTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(TypeTable typeTable) {
                if (typeTable == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!typeTable.c.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = typeTable.c;
                        this.b &= -2;
                    } else {
                        if ((this.b & 1) != 1) {
                            this.c = new ArrayList(this.c);
                            this.b |= 1;
                        }
                        this.c.addAll(typeTable.c);
                    }
                }
                if (typeTable.hasFirstNullable()) {
                    setFirstNullable(typeTable.getFirstNullable());
                }
                setUnknownFields(getUnknownFields().concat(typeTable.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                TypeTable typeTable;
                TypeTable typeTable2 = null;
                try {
                    TypeTable parsePartialFrom = TypeTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    typeTable = (TypeTable) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    typeTable2 = typeTable;
                }
                if (typeTable2 != null) {
                    mergeFrom(typeTable2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<TypeTable> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TypeTable(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            TypeTable typeTable = new TypeTable();
            g = typeTable;
            typeTable.c = Collections.emptyList();
            typeTable.d = -1;
        }

        public TypeTable(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.e = -1;
            this.f = -1;
            this.a = builder.getUnknownFields();
        }

        public static TypeTable getDefaultInstance() {
            return g;
        }

        public static Builder newBuilder(TypeTable typeTable) {
            return newBuilder().mergeFrom(typeTable);
        }

        public int getFirstNullable() {
            return this.d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.c.get(i3));
            }
            if ((this.b & 1) == 1) {
                i2 += CodedOutputStream.computeInt32Size(2, this.d);
            }
            int size = this.a.size() + i2;
            this.f = size;
            return size;
        }

        public Type getType(int i) {
            return this.c.get(i);
        }

        public int getTypeCount() {
            return this.c.size();
        }

        public List<Type> getTypeList() {
            return this.c;
        }

        public boolean hasFirstNullable() {
            return (this.b & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.e;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < getTypeCount(); i++) {
                if (!getType(i).isInitialized()) {
                    this.e = 0;
                    return false;
                }
            }
            this.e = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.c.size(); i++) {
                codedOutputStream.writeMessage(1, this.c.get(i));
            }
            if ((this.b & 1) == 1) {
                codedOutputStream.writeInt32(2, this.d);
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeTable getDefaultInstanceForType() {
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public TypeTable() {
            this.e = -1;
            this.f = -1;
            this.a = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public TypeTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.e = -1;
            this.f = -1;
            this.c = Collections.emptyList();
            this.d = -1;
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.c = new ArrayList();
                                z2 |= true;
                            }
                            this.c.add(codedInputStream.readMessage(Type.PARSER, extensionRegistryLite));
                        } else if (readTag == 16) {
                            this.b |= 1;
                            this.d = codedInputStream.readInt32();
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.c = Collections.unmodifiableList(this.c);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.c = Collections.unmodifiableList(this.c);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static Parser<ValueParameter> PARSER = new a();
        public static final ValueParameter l;
        public final ByteString b;
        public int c;
        public int d;
        public int e;
        public Type f;
        public int g;
        public Type h;
        public int i;
        public byte j;
        public int k;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            public int d;
            public int e;
            public int f;
            public Type g = Type.getDefaultInstance();
            public int h;
            public Type i = Type.getDefaultInstance();
            public int j;

            public ValueParameter buildPartial() {
                ValueParameter valueParameter = new ValueParameter(this, null);
                int i2 = this.d;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                valueParameter.d = this.e;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                valueParameter.e = this.f;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                valueParameter.f = this.g;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                valueParameter.g = this.h;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                valueParameter.h = this.i;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                valueParameter.i = this.j;
                valueParameter.c = i3;
                return valueParameter;
            }

            public Type getType() {
                return this.g;
            }

            public Type getVarargElementType() {
                return this.i;
            }

            public boolean hasName() {
                return (this.d & 2) == 2;
            }

            public boolean hasType() {
                return (this.d & 4) == 4;
            }

            public boolean hasVarargElementType() {
                return (this.d & 16) == 16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasType() && !getType().isInitialized()) {
                    return false;
                }
                if ((!hasVarargElementType() || getVarargElementType().isInitialized()) && extensionsAreInitialized()) {
                    return true;
                }
                return false;
            }

            public Builder mergeType(Type type) {
                if ((this.d & 4) != 4 || this.g == Type.getDefaultInstance()) {
                    this.g = type;
                } else {
                    this.g = Type.newBuilder(this.g).mergeFrom(type).buildPartial();
                }
                this.d |= 4;
                return this;
            }

            public Builder mergeVarargElementType(Type type) {
                if ((this.d & 16) != 16 || this.i == Type.getDefaultInstance()) {
                    this.i = type;
                } else {
                    this.i = Type.newBuilder(this.i).mergeFrom(type).buildPartial();
                }
                this.d |= 16;
                return this;
            }

            public Builder setFlags(int i2) {
                this.d |= 1;
                this.e = i2;
                return this;
            }

            public Builder setName(int i2) {
                this.d |= 2;
                this.f = i2;
                return this;
            }

            public Builder setTypeId(int i2) {
                this.d |= 8;
                this.h = i2;
                return this;
            }

            public Builder setVarargElementTypeId(int i2) {
                this.d |= 32;
                this.j = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public ValueParameter build() {
                ValueParameter buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            public Builder mergeFrom(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (valueParameter.hasFlags()) {
                    setFlags(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    setName(valueParameter.getName());
                }
                if (valueParameter.hasType()) {
                    mergeType(valueParameter.getType());
                }
                if (valueParameter.hasTypeId()) {
                    setTypeId(valueParameter.getTypeId());
                }
                if (valueParameter.hasVarargElementType()) {
                    mergeVarargElementType(valueParameter.getVarargElementType());
                }
                if (valueParameter.hasVarargElementTypeId()) {
                    setVarargElementTypeId(valueParameter.getVarargElementTypeId());
                }
                mergeExtensionFields(valueParameter);
                setUnknownFields(getUnknownFields().concat(valueParameter.b));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                ValueParameter valueParameter;
                ValueParameter valueParameter2 = null;
                try {
                    ValueParameter parsePartialFrom = ValueParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    valueParameter = (ValueParameter) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    valueParameter2 = valueParameter;
                }
                if (valueParameter2 != null) {
                    mergeFrom(valueParameter2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<ValueParameter> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ValueParameter(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            ValueParameter valueParameter = new ValueParameter();
            l = valueParameter;
            valueParameter.b();
        }

        public ValueParameter(GeneratedMessageLite.ExtendableBuilder extendableBuilder, a aVar) {
            super(extendableBuilder);
            this.j = -1;
            this.k = -1;
            this.b = extendableBuilder.getUnknownFields();
        }

        public static ValueParameter getDefaultInstance() {
            return l;
        }

        public static Builder newBuilder(ValueParameter valueParameter) {
            return newBuilder().mergeFrom(valueParameter);
        }

        public final void b() {
            this.d = 0;
            this.e = 0;
            this.f = Type.getDefaultInstance();
            this.g = 0;
            this.h = Type.getDefaultInstance();
            this.i = 0;
        }

        public int getFlags() {
            return this.d;
        }

        public int getName() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.k;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.c & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeInt32Size(1, this.d);
            }
            if ((this.c & 2) == 2) {
                i3 += CodedOutputStream.computeInt32Size(2, this.e);
            }
            if ((this.c & 4) == 4) {
                i3 += CodedOutputStream.computeMessageSize(3, this.f);
            }
            if ((this.c & 16) == 16) {
                i3 += CodedOutputStream.computeMessageSize(4, this.h);
            }
            if ((this.c & 8) == 8) {
                i3 += CodedOutputStream.computeInt32Size(5, this.g);
            }
            if ((this.c & 32) == 32) {
                i3 += CodedOutputStream.computeInt32Size(6, this.i);
            }
            int size = this.b.size() + extensionsSerializedSize() + i3;
            this.k = size;
            return size;
        }

        public Type getType() {
            return this.f;
        }

        public int getTypeId() {
            return this.g;
        }

        public Type getVarargElementType() {
            return this.h;
        }

        public int getVarargElementTypeId() {
            return this.i;
        }

        public boolean hasFlags() {
            return (this.c & 1) == 1;
        }

        public boolean hasName() {
            return (this.c & 2) == 2;
        }

        public boolean hasType() {
            return (this.c & 4) == 4;
        }

        public boolean hasTypeId() {
            return (this.c & 8) == 8;
        }

        public boolean hasVarargElementType() {
            return (this.c & 16) == 16;
        }

        public boolean hasVarargElementTypeId() {
            return (this.c & 32) == 32;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.j;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasName()) {
                this.j = 0;
                return false;
            } else if (hasType() && !getType().isInitialized()) {
                this.j = 0;
                return false;
            } else if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.j = 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.j = 0;
                return false;
            } else {
                this.j = 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.c & 1) == 1) {
                codedOutputStream.writeInt32(1, this.d);
            }
            if ((this.c & 2) == 2) {
                codedOutputStream.writeInt32(2, this.e);
            }
            if ((this.c & 4) == 4) {
                codedOutputStream.writeMessage(3, this.f);
            }
            if ((this.c & 16) == 16) {
                codedOutputStream.writeMessage(4, this.h);
            }
            if ((this.c & 8) == 8) {
                codedOutputStream.writeInt32(5, this.g);
            }
            if ((this.c & 32) == 32) {
                codedOutputStream.writeInt32(6, this.i);
            }
            newExtensionWriter.writeUntil(200, codedOutputStream);
            codedOutputStream.writeRawBytes(this.b);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ValueParameter getDefaultInstanceForType() {
            return l;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public ValueParameter() {
            this.j = -1;
            this.k = -1;
            this.b = ByteString.EMPTY;
        }

        public ValueParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.j = -1;
            this.k = -1;
            b();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.c |= 1;
                            this.d = codedInputStream.readInt32();
                        } else if (readTag != 16) {
                            Type.Builder builder = null;
                            if (readTag == 26) {
                                builder = (this.c & 4) == 4 ? this.f.toBuilder() : builder;
                                Type type = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.f = type;
                                if (builder != null) {
                                    builder.mergeFrom(type);
                                    this.f = builder.buildPartial();
                                }
                                this.c |= 4;
                            } else if (readTag == 34) {
                                builder = (this.c & 16) == 16 ? this.h.toBuilder() : builder;
                                Type type2 = (Type) codedInputStream.readMessage(Type.PARSER, extensionRegistryLite);
                                this.h = type2;
                                if (builder != null) {
                                    builder.mergeFrom(type2);
                                    this.h = builder.buildPartial();
                                }
                                this.c |= 16;
                            } else if (readTag == 40) {
                                this.c |= 8;
                                this.g = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.c |= 32;
                                this.i = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.c |= 2;
                            this.e = codedInputStream.readInt32();
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = newOutput.toByteString();
                        throw th2;
                    }
                    this.b = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.b = newOutput.toByteString();
                throw th3;
            }
            this.b = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ValueParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class VersionRequirement extends GeneratedMessageLite implements VersionRequirementOrBuilder {
        public static Parser<VersionRequirement> PARSER = new a();
        public static final VersionRequirement k;
        public final ByteString a;
        public int b;
        public int c;
        public int d;
        public Level e;
        public int f;
        public int g;
        public VersionKind h;
        public byte i;
        public int j;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirement, Builder> implements VersionRequirementOrBuilder {
            public int b;
            public int c;
            public int d;
            public Level e = Level.ERROR;
            public int f;
            public int g;
            public VersionKind h = VersionKind.LANGUAGE_VERSION;

            public VersionRequirement buildPartial() {
                VersionRequirement versionRequirement = new VersionRequirement(this, null);
                int i = this.b;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                versionRequirement.c = this.c;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                versionRequirement.d = this.d;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                versionRequirement.e = this.e;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                versionRequirement.f = this.f;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                versionRequirement.g = this.g;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                versionRequirement.h = this.h;
                versionRequirement.b = i2;
                return versionRequirement;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setErrorCode(int i) {
                this.b |= 8;
                this.f = i;
                return this;
            }

            public Builder setLevel(Level level) {
                Objects.requireNonNull(level);
                this.b |= 4;
                this.e = level;
                return this;
            }

            public Builder setMessage(int i) {
                this.b |= 16;
                this.g = i;
                return this;
            }

            public Builder setVersion(int i) {
                this.b |= 1;
                this.c = i;
                return this;
            }

            public Builder setVersionFull(int i) {
                this.b |= 2;
                this.d = i;
                return this;
            }

            public Builder setVersionKind(VersionKind versionKind) {
                Objects.requireNonNull(versionKind);
                this.b |= 32;
                this.h = versionKind;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirement build() {
                VersionRequirement buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (versionRequirement.hasVersion()) {
                    setVersion(versionRequirement.getVersion());
                }
                if (versionRequirement.hasVersionFull()) {
                    setVersionFull(versionRequirement.getVersionFull());
                }
                if (versionRequirement.hasLevel()) {
                    setLevel(versionRequirement.getLevel());
                }
                if (versionRequirement.hasErrorCode()) {
                    setErrorCode(versionRequirement.getErrorCode());
                }
                if (versionRequirement.hasMessage()) {
                    setMessage(versionRequirement.getMessage());
                }
                if (versionRequirement.hasVersionKind()) {
                    setVersionKind(versionRequirement.getVersionKind());
                }
                setUnknownFields(getUnknownFields().concat(versionRequirement.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                VersionRequirement versionRequirement;
                VersionRequirement versionRequirement2 = null;
                try {
                    VersionRequirement parsePartialFrom = VersionRequirement.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    versionRequirement = (VersionRequirement) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    versionRequirement2 = versionRequirement;
                }
                if (versionRequirement2 != null) {
                    mergeFrom(versionRequirement2);
                }
                throw th;
            }
        }

        public enum Level implements Internal.EnumLite {
            WARNING(0),
            ERROR(1),
            HIDDEN(2);
            
            public final int a;

            /* access modifiers changed from: public */
            Level(int i) {
                this.a = i;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.a;
            }

            public static Level valueOf(int i) {
                if (i == 0) {
                    return WARNING;
                }
                if (i == 1) {
                    return ERROR;
                }
                if (i != 2) {
                    return null;
                }
                return HIDDEN;
            }
        }

        public enum VersionKind implements Internal.EnumLite {
            LANGUAGE_VERSION(0),
            COMPILER_VERSION(1),
            API_VERSION(2);
            
            public final int a;

            /* access modifiers changed from: public */
            VersionKind(int i) {
                this.a = i;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.a;
            }

            public static VersionKind valueOf(int i) {
                if (i == 0) {
                    return LANGUAGE_VERSION;
                }
                if (i == 1) {
                    return COMPILER_VERSION;
                }
                if (i != 2) {
                    return null;
                }
                return API_VERSION;
            }
        }

        public static class a extends AbstractParser<VersionRequirement> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirement(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            VersionRequirement versionRequirement = new VersionRequirement();
            k = versionRequirement;
            versionRequirement.c = 0;
            versionRequirement.d = 0;
            versionRequirement.e = Level.ERROR;
            versionRequirement.f = 0;
            versionRequirement.g = 0;
            versionRequirement.h = VersionKind.LANGUAGE_VERSION;
        }

        public VersionRequirement(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.i = -1;
            this.j = -1;
            this.a = builder.getUnknownFields();
        }

        public static VersionRequirement getDefaultInstance() {
            return k;
        }

        public static Builder newBuilder(VersionRequirement versionRequirement) {
            return newBuilder().mergeFrom(versionRequirement);
        }

        public int getErrorCode() {
            return this.f;
        }

        public Level getLevel() {
            return this.e;
        }

        public int getMessage() {
            return this.g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.j;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.b & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeInt32Size(1, this.c);
            }
            if ((this.b & 2) == 2) {
                i3 += CodedOutputStream.computeInt32Size(2, this.d);
            }
            if ((this.b & 4) == 4) {
                i3 += CodedOutputStream.computeEnumSize(3, this.e.getNumber());
            }
            if ((this.b & 8) == 8) {
                i3 += CodedOutputStream.computeInt32Size(4, this.f);
            }
            if ((this.b & 16) == 16) {
                i3 += CodedOutputStream.computeInt32Size(5, this.g);
            }
            if ((this.b & 32) == 32) {
                i3 += CodedOutputStream.computeEnumSize(6, this.h.getNumber());
            }
            int size = this.a.size() + i3;
            this.j = size;
            return size;
        }

        public int getVersion() {
            return this.c;
        }

        public int getVersionFull() {
            return this.d;
        }

        public VersionKind getVersionKind() {
            return this.h;
        }

        public boolean hasErrorCode() {
            return (this.b & 8) == 8;
        }

        public boolean hasLevel() {
            return (this.b & 4) == 4;
        }

        public boolean hasMessage() {
            return (this.b & 16) == 16;
        }

        public boolean hasVersion() {
            return (this.b & 1) == 1;
        }

        public boolean hasVersionFull() {
            return (this.b & 2) == 2;
        }

        public boolean hasVersionKind() {
            return (this.b & 32) == 32;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.i = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.b & 1) == 1) {
                codedOutputStream.writeInt32(1, this.c);
            }
            if ((this.b & 2) == 2) {
                codedOutputStream.writeInt32(2, this.d);
            }
            if ((this.b & 4) == 4) {
                codedOutputStream.writeEnum(3, this.e.getNumber());
            }
            if ((this.b & 8) == 8) {
                codedOutputStream.writeInt32(4, this.f);
            }
            if ((this.b & 16) == 16) {
                codedOutputStream.writeInt32(5, this.g);
            }
            if ((this.b & 32) == 32) {
                codedOutputStream.writeEnum(6, this.h.getNumber());
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirement getDefaultInstanceForType() {
            return k;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public VersionRequirement() {
            this.i = -1;
            this.j = -1;
            this.a = ByteString.EMPTY;
        }

        public VersionRequirement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.i = -1;
            this.j = -1;
            boolean z = false;
            this.c = 0;
            this.d = 0;
            this.e = Level.ERROR;
            this.f = 0;
            this.g = 0;
            this.h = VersionKind.LANGUAGE_VERSION;
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.b |= 1;
                            this.c = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.b |= 2;
                            this.d = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            int readEnum = codedInputStream.readEnum();
                            Level valueOf = Level.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.b |= 4;
                                this.e = valueOf;
                            }
                        } else if (readTag == 32) {
                            this.b |= 8;
                            this.f = codedInputStream.readInt32();
                        } else if (readTag == 40) {
                            this.b |= 16;
                            this.g = codedInputStream.readInt32();
                        } else if (readTag == 48) {
                            int readEnum2 = codedInputStream.readEnum();
                            VersionKind valueOf2 = VersionKind.valueOf(readEnum2);
                            if (valueOf2 == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum2);
                            } else {
                                this.b |= 32;
                                this.h = valueOf2;
                            }
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface VersionRequirementOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class VersionRequirementTable extends GeneratedMessageLite implements VersionRequirementTableOrBuilder {
        public static Parser<VersionRequirementTable> PARSER = new a();
        public static final VersionRequirementTable e;
        public final ByteString a;
        public List<VersionRequirement> b;
        public byte c;
        public int d;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder> implements VersionRequirementTableOrBuilder {
            public int b;
            public List<VersionRequirement> c = Collections.emptyList();

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable(this, null);
                if ((this.b & 1) == 1) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.b &= -2;
                }
                versionRequirementTable.b = this.c;
                return versionRequirementTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirementTable build() {
                VersionRequirementTable buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!versionRequirementTable.b.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = versionRequirementTable.b;
                        this.b &= -2;
                    } else {
                        if ((this.b & 1) != 1) {
                            this.c = new ArrayList(this.c);
                            this.b |= 1;
                        }
                        this.c.addAll(versionRequirementTable.b);
                    }
                }
                setUnknownFields(getUnknownFields().concat(versionRequirementTable.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                VersionRequirementTable versionRequirementTable;
                VersionRequirementTable versionRequirementTable2 = null;
                try {
                    VersionRequirementTable parsePartialFrom = VersionRequirementTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    versionRequirementTable = (VersionRequirementTable) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    versionRequirementTable2 = versionRequirementTable;
                }
                if (versionRequirementTable2 != null) {
                    mergeFrom(versionRequirementTable2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<VersionRequirementTable> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VersionRequirementTable(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            VersionRequirementTable versionRequirementTable = new VersionRequirementTable();
            e = versionRequirementTable;
            versionRequirementTable.b = Collections.emptyList();
        }

        public VersionRequirementTable(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.c = -1;
            this.d = -1;
            this.a = builder.getUnknownFields();
        }

        public static VersionRequirementTable getDefaultInstance() {
            return e;
        }

        public static Builder newBuilder(VersionRequirementTable versionRequirementTable) {
            return newBuilder().mergeFrom(versionRequirementTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public int getRequirementCount() {
            return this.b.size();
        }

        public List<VersionRequirement> getRequirementList() {
            return this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.d;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.b.get(i3));
            }
            int size = this.a.size() + i2;
            this.d = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.c;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.c = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.b.size(); i++) {
                codedOutputStream.writeMessage(1, this.b.get(i));
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirementTable getDefaultInstanceForType() {
            return e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public VersionRequirementTable() {
            this.c = -1;
            this.d = -1;
            this.a = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement> */
        /* JADX WARN: Multi-variable type inference failed */
        public VersionRequirementTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.c = -1;
            this.d = -1;
            this.b = Collections.emptyList();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.b = new ArrayList();
                                z2 |= true;
                            }
                            this.b.add(codedInputStream.readMessage(VersionRequirement.PARSER, extensionRegistryLite));
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.b = Collections.unmodifiableList(this.b);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.a = newOutput.toByteString();
                        throw th2;
                    }
                    this.a = newOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 && true) {
                this.b = Collections.unmodifiableList(this.b);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.a = newOutput.toByteString();
                throw th3;
            }
            this.a = newOutput.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface VersionRequirementTableOrBuilder extends MessageLiteOrBuilder {
    }

    public enum Visibility implements Internal.EnumLite {
        INTERNAL(0),
        PRIVATE(1),
        PROTECTED(2),
        PUBLIC(3),
        PRIVATE_TO_THIS(4),
        LOCAL(5);
        
        public final int a;

        /* access modifiers changed from: public */
        Visibility(int i) {
            this.a = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.a;
        }

        public static Visibility valueOf(int i) {
            if (i == 0) {
                return INTERNAL;
            }
            if (i == 1) {
                return PRIVATE;
            }
            if (i == 2) {
                return PROTECTED;
            }
            if (i == 3) {
                return PUBLIC;
            }
            if (i == 4) {
                return PRIVATE_TO_THIS;
            }
            if (i != 5) {
                return null;
            }
            return LOCAL;
        }
    }
}
