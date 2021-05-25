package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
public final class JvmProtoBuf {
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmMethodSignature> constructorSignature;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, Integer> flags;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, Boolean> isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> jvmClassFlags;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmMethodSignature> methodSignature;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmPropertySignature> propertySignature;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation;

    public static final class JvmFieldSignature extends GeneratedMessageLite implements JvmFieldSignatureOrBuilder {
        public static Parser<JvmFieldSignature> PARSER = new a();
        public static final JvmFieldSignature g;
        public final ByteString a;
        public int b;
        public int c;
        public int d;
        public byte e;
        public int f;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmFieldSignature, Builder> implements JvmFieldSignatureOrBuilder {
            public int b;
            public int c;
            public int d;

            public JvmFieldSignature buildPartial() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(this, null);
                int i = this.b;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmFieldSignature.c = this.c;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmFieldSignature.d = this.d;
                jvmFieldSignature.b = i2;
                return jvmFieldSignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setDesc(int i) {
                this.b |= 2;
                this.d = i;
                return this;
            }

            public Builder setName(int i) {
                this.b |= 1;
                this.c = i;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmFieldSignature build() {
                JvmFieldSignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmFieldSignature.hasName()) {
                    setName(jvmFieldSignature.getName());
                }
                if (jvmFieldSignature.hasDesc()) {
                    setDesc(jvmFieldSignature.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(jvmFieldSignature.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                JvmFieldSignature jvmFieldSignature;
                JvmFieldSignature jvmFieldSignature2 = null;
                try {
                    JvmFieldSignature parsePartialFrom = JvmFieldSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    jvmFieldSignature = (JvmFieldSignature) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    jvmFieldSignature2 = jvmFieldSignature;
                }
                if (jvmFieldSignature2 != null) {
                    mergeFrom(jvmFieldSignature2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<JvmFieldSignature> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature();
            g = jvmFieldSignature;
            jvmFieldSignature.c = 0;
            jvmFieldSignature.d = 0;
        }

        public JvmFieldSignature(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.e = -1;
            this.f = -1;
            this.a = builder.getUnknownFields();
        }

        public static JvmFieldSignature getDefaultInstance() {
            return g;
        }

        public static Builder newBuilder(JvmFieldSignature jvmFieldSignature) {
            return newBuilder().mergeFrom(jvmFieldSignature);
        }

        public int getDesc() {
            return this.d;
        }

        public int getName() {
            return this.c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmFieldSignature> getParserForType() {
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
                i2 += CodedOutputStream.computeInt32Size(2, this.d);
            }
            int size = this.a.size() + i2;
            this.f = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.b & 2) == 2;
        }

        public boolean hasName() {
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
            this.e = 1;
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
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmFieldSignature getDefaultInstanceForType() {
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

        public JvmFieldSignature() {
            this.e = -1;
            this.f = -1;
            this.a = ByteString.EMPTY;
        }

        public JvmFieldSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.e = -1;
            this.f = -1;
            boolean z = false;
            this.c = 0;
            this.d = 0;
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

    public interface JvmFieldSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements JvmMethodSignatureOrBuilder {
        public static Parser<JvmMethodSignature> PARSER = new a();
        public static final JvmMethodSignature g;
        public final ByteString a;
        public int b;
        public int c;
        public int d;
        public byte e;
        public int f;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmMethodSignature, Builder> implements JvmMethodSignatureOrBuilder {
            public int b;
            public int c;
            public int d;

            public JvmMethodSignature buildPartial() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(this, null);
                int i = this.b;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmMethodSignature.c = this.c;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmMethodSignature.d = this.d;
                jvmMethodSignature.b = i2;
                return jvmMethodSignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setDesc(int i) {
                this.b |= 2;
                this.d = i;
                return this;
            }

            public Builder setName(int i) {
                this.b |= 1;
                this.c = i;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmMethodSignature build() {
                JvmMethodSignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmMethodSignature.hasName()) {
                    setName(jvmMethodSignature.getName());
                }
                if (jvmMethodSignature.hasDesc()) {
                    setDesc(jvmMethodSignature.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(jvmMethodSignature.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                JvmMethodSignature jvmMethodSignature;
                JvmMethodSignature jvmMethodSignature2 = null;
                try {
                    JvmMethodSignature parsePartialFrom = JvmMethodSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    jvmMethodSignature = (JvmMethodSignature) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    jvmMethodSignature2 = jvmMethodSignature;
                }
                if (jvmMethodSignature2 != null) {
                    mergeFrom(jvmMethodSignature2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<JvmMethodSignature> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature();
            g = jvmMethodSignature;
            jvmMethodSignature.c = 0;
            jvmMethodSignature.d = 0;
        }

        public JvmMethodSignature(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.e = -1;
            this.f = -1;
            this.a = builder.getUnknownFields();
        }

        public static JvmMethodSignature getDefaultInstance() {
            return g;
        }

        public static Builder newBuilder(JvmMethodSignature jvmMethodSignature) {
            return newBuilder().mergeFrom(jvmMethodSignature);
        }

        public int getDesc() {
            return this.d;
        }

        public int getName() {
            return this.c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmMethodSignature> getParserForType() {
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
                i2 += CodedOutputStream.computeInt32Size(2, this.d);
            }
            int size = this.a.size() + i2;
            this.f = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.b & 2) == 2;
        }

        public boolean hasName() {
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
            this.e = 1;
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
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmMethodSignature getDefaultInstanceForType() {
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

        public JvmMethodSignature() {
            this.e = -1;
            this.f = -1;
            this.a = ByteString.EMPTY;
        }

        public JvmMethodSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.e = -1;
            this.f = -1;
            boolean z = false;
            this.c = 0;
            this.d = 0;
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

    public interface JvmMethodSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements JvmPropertySignatureOrBuilder {
        public static Parser<JvmPropertySignature> PARSER = new a();
        public static final JvmPropertySignature i;
        public final ByteString a;
        public int b;
        public JvmFieldSignature c;
        public JvmMethodSignature d;
        public JvmMethodSignature e;
        public JvmMethodSignature f;
        public byte g;
        public int h;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmPropertySignature, Builder> implements JvmPropertySignatureOrBuilder {
            public int b;
            public JvmFieldSignature c = JvmFieldSignature.getDefaultInstance();
            public JvmMethodSignature d = JvmMethodSignature.getDefaultInstance();
            public JvmMethodSignature e = JvmMethodSignature.getDefaultInstance();
            public JvmMethodSignature f = JvmMethodSignature.getDefaultInstance();

            public JvmPropertySignature buildPartial() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(this, null);
                int i = this.b;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmPropertySignature.c = this.c;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmPropertySignature.d = this.d;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                jvmPropertySignature.e = this.e;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                jvmPropertySignature.f = this.f;
                jvmPropertySignature.b = i2;
                return jvmPropertySignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeField(JvmFieldSignature jvmFieldSignature) {
                if ((this.b & 1) != 1 || this.c == JvmFieldSignature.getDefaultInstance()) {
                    this.c = jvmFieldSignature;
                } else {
                    this.c = JvmFieldSignature.newBuilder(this.c).mergeFrom(jvmFieldSignature).buildPartial();
                }
                this.b |= 1;
                return this;
            }

            public Builder mergeGetter(JvmMethodSignature jvmMethodSignature) {
                if ((this.b & 4) != 4 || this.e == JvmMethodSignature.getDefaultInstance()) {
                    this.e = jvmMethodSignature;
                } else {
                    this.e = JvmMethodSignature.newBuilder(this.e).mergeFrom(jvmMethodSignature).buildPartial();
                }
                this.b |= 4;
                return this;
            }

            public Builder mergeSetter(JvmMethodSignature jvmMethodSignature) {
                if ((this.b & 8) != 8 || this.f == JvmMethodSignature.getDefaultInstance()) {
                    this.f = jvmMethodSignature;
                } else {
                    this.f = JvmMethodSignature.newBuilder(this.f).mergeFrom(jvmMethodSignature).buildPartial();
                }
                this.b |= 8;
                return this;
            }

            public Builder mergeSyntheticMethod(JvmMethodSignature jvmMethodSignature) {
                if ((this.b & 2) != 2 || this.d == JvmMethodSignature.getDefaultInstance()) {
                    this.d = jvmMethodSignature;
                } else {
                    this.d = JvmMethodSignature.newBuilder(this.d).mergeFrom(jvmMethodSignature).buildPartial();
                }
                this.b |= 2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmPropertySignature build() {
                JvmPropertySignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmPropertySignature.hasField()) {
                    mergeField(jvmPropertySignature.getField());
                }
                if (jvmPropertySignature.hasSyntheticMethod()) {
                    mergeSyntheticMethod(jvmPropertySignature.getSyntheticMethod());
                }
                if (jvmPropertySignature.hasGetter()) {
                    mergeGetter(jvmPropertySignature.getGetter());
                }
                if (jvmPropertySignature.hasSetter()) {
                    mergeSetter(jvmPropertySignature.getSetter());
                }
                setUnknownFields(getUnknownFields().concat(jvmPropertySignature.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                JvmPropertySignature jvmPropertySignature;
                JvmPropertySignature jvmPropertySignature2 = null;
                try {
                    JvmPropertySignature parsePartialFrom = JvmPropertySignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    jvmPropertySignature = (JvmPropertySignature) e2.getUnfinishedMessage();
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    jvmPropertySignature2 = jvmPropertySignature;
                }
                if (jvmPropertySignature2 != null) {
                    mergeFrom(jvmPropertySignature2);
                }
                throw th;
            }
        }

        public static class a extends AbstractParser<JvmPropertySignature> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature();
            i = jvmPropertySignature;
            jvmPropertySignature.a();
        }

        public JvmPropertySignature(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.g = -1;
            this.h = -1;
            this.a = builder.getUnknownFields();
        }

        public static JvmPropertySignature getDefaultInstance() {
            return i;
        }

        public static Builder newBuilder(JvmPropertySignature jvmPropertySignature) {
            return newBuilder().mergeFrom(jvmPropertySignature);
        }

        public final void a() {
            this.c = JvmFieldSignature.getDefaultInstance();
            this.d = JvmMethodSignature.getDefaultInstance();
            this.e = JvmMethodSignature.getDefaultInstance();
            this.f = JvmMethodSignature.getDefaultInstance();
        }

        public JvmFieldSignature getField() {
            return this.c;
        }

        public JvmMethodSignature getGetter() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.h;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.b & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeMessageSize(1, this.c);
            }
            if ((this.b & 2) == 2) {
                i3 += CodedOutputStream.computeMessageSize(2, this.d);
            }
            if ((this.b & 4) == 4) {
                i3 += CodedOutputStream.computeMessageSize(3, this.e);
            }
            if ((this.b & 8) == 8) {
                i3 += CodedOutputStream.computeMessageSize(4, this.f);
            }
            int size = this.a.size() + i3;
            this.h = size;
            return size;
        }

        public JvmMethodSignature getSetter() {
            return this.f;
        }

        public JvmMethodSignature getSyntheticMethod() {
            return this.d;
        }

        public boolean hasField() {
            return (this.b & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.b & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.b & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
            return (this.b & 2) == 2;
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
            this.g = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.b & 1) == 1) {
                codedOutputStream.writeMessage(1, this.c);
            }
            if ((this.b & 2) == 2) {
                codedOutputStream.writeMessage(2, this.d);
            }
            if ((this.b & 4) == 4) {
                codedOutputStream.writeMessage(3, this.e);
            }
            if ((this.b & 8) == 8) {
                codedOutputStream.writeMessage(4, this.f);
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmPropertySignature getDefaultInstanceForType() {
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

        public JvmPropertySignature() {
            this.g = -1;
            this.h = -1;
            this.a = ByteString.EMPTY;
        }

        public JvmPropertySignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.g = -1;
            this.h = -1;
            a();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        JvmMethodSignature.Builder builder = null;
                        JvmFieldSignature.Builder builder2 = null;
                        JvmMethodSignature.Builder builder3 = null;
                        JvmMethodSignature.Builder builder4 = null;
                        if (readTag == 10) {
                            builder2 = (this.b & 1) == 1 ? this.c.toBuilder() : builder2;
                            JvmFieldSignature jvmFieldSignature = (JvmFieldSignature) codedInputStream.readMessage(JvmFieldSignature.PARSER, extensionRegistryLite);
                            this.c = jvmFieldSignature;
                            if (builder2 != null) {
                                builder2.mergeFrom(jvmFieldSignature);
                                this.c = builder2.buildPartial();
                            }
                            this.b |= 1;
                        } else if (readTag == 18) {
                            builder3 = (this.b & 2) == 2 ? this.d.toBuilder() : builder3;
                            JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) codedInputStream.readMessage(JvmMethodSignature.PARSER, extensionRegistryLite);
                            this.d = jvmMethodSignature;
                            if (builder3 != null) {
                                builder3.mergeFrom(jvmMethodSignature);
                                this.d = builder3.buildPartial();
                            }
                            this.b |= 2;
                        } else if (readTag == 26) {
                            builder4 = (this.b & 4) == 4 ? this.e.toBuilder() : builder4;
                            JvmMethodSignature jvmMethodSignature2 = (JvmMethodSignature) codedInputStream.readMessage(JvmMethodSignature.PARSER, extensionRegistryLite);
                            this.e = jvmMethodSignature2;
                            if (builder4 != null) {
                                builder4.mergeFrom(jvmMethodSignature2);
                                this.e = builder4.buildPartial();
                            }
                            this.b |= 4;
                        } else if (readTag == 34) {
                            builder = (this.b & 8) == 8 ? this.f.toBuilder() : builder;
                            JvmMethodSignature jvmMethodSignature3 = (JvmMethodSignature) codedInputStream.readMessage(JvmMethodSignature.PARSER, extensionRegistryLite);
                            this.f = jvmMethodSignature3;
                            if (builder != null) {
                                builder.mergeFrom(jvmMethodSignature3);
                                this.f = builder.buildPartial();
                            }
                            this.b |= 8;
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

    public interface JvmPropertySignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTableTypes extends GeneratedMessageLite implements StringTableTypesOrBuilder {
        public static Parser<StringTableTypes> PARSER = new a();
        public static final StringTableTypes g;
        public final ByteString a;
        public List<Record> b;
        public List<Integer> c;
        public int d;
        public byte e;
        public int f;

        public static final class Builder extends GeneratedMessageLite.Builder<StringTableTypes, Builder> implements StringTableTypesOrBuilder {
            public int b;
            public List<Record> c = Collections.emptyList();
            public List<Integer> d = Collections.emptyList();

            public StringTableTypes buildPartial() {
                StringTableTypes stringTableTypes = new StringTableTypes(this, null);
                if ((this.b & 1) == 1) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.b &= -2;
                }
                stringTableTypes.b = this.c;
                if ((this.b & 2) == 2) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.b &= -3;
                }
                stringTableTypes.c = this.d;
                return stringTableTypes;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTableTypes build() {
                StringTableTypes buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
            public Builder clone() {
                return new Builder().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.getDefaultInstance()) {
                    return this;
                }
                if (!stringTableTypes.b.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = stringTableTypes.b;
                        this.b &= -2;
                    } else {
                        if ((this.b & 1) != 1) {
                            this.c = new ArrayList(this.c);
                            this.b |= 1;
                        }
                        this.c.addAll(stringTableTypes.b);
                    }
                }
                if (!stringTableTypes.c.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = stringTableTypes.c;
                        this.b &= -3;
                    } else {
                        if ((this.b & 2) != 2) {
                            this.d = new ArrayList(this.d);
                            this.b |= 2;
                        }
                        this.d.addAll(stringTableTypes.c);
                    }
                }
                setUnknownFields(getUnknownFields().concat(stringTableTypes.a));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Throwable th;
                StringTableTypes stringTableTypes;
                StringTableTypes stringTableTypes2 = null;
                try {
                    StringTableTypes parsePartialFrom = StringTableTypes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    stringTableTypes = (StringTableTypes) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    stringTableTypes2 = stringTableTypes;
                }
                if (stringTableTypes2 != null) {
                    mergeFrom(stringTableTypes2);
                }
                throw th;
            }
        }

        public static final class Record extends GeneratedMessageLite implements RecordOrBuilder {
            public static Parser<Record> PARSER = new a();
            public static final Record m;
            public final ByteString a;
            public int b;
            public int c;
            public int d;
            public Object e;
            public Operation f;
            public List<Integer> g;
            public int h;
            public List<Integer> i;
            public int j;
            public byte k;
            public int l;

            public static final class Builder extends GeneratedMessageLite.Builder<Record, Builder> implements RecordOrBuilder {
                public int b;
                public int c = 1;
                public int d;
                public Object e = "";
                public Operation f = Operation.NONE;
                public List<Integer> g = Collections.emptyList();
                public List<Integer> h = Collections.emptyList();

                public Record buildPartial() {
                    Record record = new Record(this, null);
                    int i = this.b;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    record.c = this.c;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    record.d = this.d;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    record.e = this.e;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    record.f = this.f;
                    if ((i & 16) == 16) {
                        this.g = Collections.unmodifiableList(this.g);
                        this.b &= -17;
                    }
                    record.g = this.g;
                    if ((this.b & 32) == 32) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.b &= -33;
                    }
                    record.i = this.h;
                    record.b = i2;
                    return record;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public Builder setOperation(Operation operation) {
                    Objects.requireNonNull(operation);
                    this.b |= 8;
                    this.f = operation;
                    return this;
                }

                public Builder setPredefinedIndex(int i) {
                    this.b |= 2;
                    this.d = i;
                    return this;
                }

                public Builder setRange(int i) {
                    this.b |= 1;
                    this.c = i;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Record build() {
                    Record buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
                public Builder clone() {
                    return new Builder().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Record record) {
                    if (record == Record.getDefaultInstance()) {
                        return this;
                    }
                    if (record.hasRange()) {
                        setRange(record.getRange());
                    }
                    if (record.hasPredefinedIndex()) {
                        setPredefinedIndex(record.getPredefinedIndex());
                    }
                    if (record.hasString()) {
                        this.b |= 4;
                        this.e = record.e;
                    }
                    if (record.hasOperation()) {
                        setOperation(record.getOperation());
                    }
                    if (!record.g.isEmpty()) {
                        if (this.g.isEmpty()) {
                            this.g = record.g;
                            this.b &= -17;
                        } else {
                            if ((this.b & 16) != 16) {
                                this.g = new ArrayList(this.g);
                                this.b |= 16;
                            }
                            this.g.addAll(record.g);
                        }
                    }
                    if (!record.i.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = record.i;
                            this.b &= -33;
                        } else {
                            if ((this.b & 32) != 32) {
                                this.h = new ArrayList(this.h);
                                this.b |= 32;
                            }
                            this.h.addAll(record.i);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(record.a));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Throwable th;
                    Record record;
                    Record record2 = null;
                    try {
                        Record parsePartialFrom = Record.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        record = (Record) e2.getUnfinishedMessage();
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        record2 = record;
                    }
                    if (record2 != null) {
                        mergeFrom(record2);
                    }
                    throw th;
                }
            }

            public enum Operation implements Internal.EnumLite {
                NONE(0),
                INTERNAL_TO_CLASS_ID(1),
                DESC_TO_CLASS_ID(2);
                
                public final int a;

                /* access modifiers changed from: public */
                Operation(int i) {
                    this.a = i;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.a;
                }

                public static Operation valueOf(int i) {
                    if (i == 0) {
                        return NONE;
                    }
                    if (i == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }
            }

            public static class a extends AbstractParser<Record> {
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Record(codedInputStream, extensionRegistryLite, null);
                }
            }

            static {
                Record record = new Record();
                m = record;
                record.a();
            }

            public Record(GeneratedMessageLite.Builder builder, a aVar) {
                super(builder);
                this.h = -1;
                this.j = -1;
                this.k = -1;
                this.l = -1;
                this.a = builder.getUnknownFields();
            }

            public static Record getDefaultInstance() {
                return m;
            }

            public static Builder newBuilder(Record record) {
                return newBuilder().mergeFrom(record);
            }

            public final void a() {
                this.c = 1;
                this.d = 0;
                this.e = "";
                this.f = Operation.NONE;
                this.g = Collections.emptyList();
                this.i = Collections.emptyList();
            }

            public Operation getOperation() {
                return this.f;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Record> getParserForType() {
                return PARSER;
            }

            public int getPredefinedIndex() {
                return this.d;
            }

            public int getRange() {
                return this.c;
            }

            public int getReplaceCharCount() {
                return this.i.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.i;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i2 = this.l;
                if (i2 != -1) {
                    return i2;
                }
                int computeInt32Size = (this.b & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.c) + 0 : 0;
                if ((this.b & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.d);
                }
                if ((this.b & 8) == 8) {
                    computeInt32Size += CodedOutputStream.computeEnumSize(3, this.f.getNumber());
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.g.size(); i4++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(this.g.get(i4).intValue());
                }
                int i5 = computeInt32Size + i3;
                if (!getSubstringIndexList().isEmpty()) {
                    i5 = i5 + 1 + CodedOutputStream.computeInt32SizeNoTag(i3);
                }
                this.h = i3;
                int i6 = 0;
                for (int i7 = 0; i7 < this.i.size(); i7++) {
                    i6 += CodedOutputStream.computeInt32SizeNoTag(this.i.get(i7).intValue());
                }
                int i8 = i5 + i6;
                if (!getReplaceCharList().isEmpty()) {
                    i8 = i8 + 1 + CodedOutputStream.computeInt32SizeNoTag(i6);
                }
                this.j = i6;
                if ((this.b & 4) == 4) {
                    i8 += CodedOutputStream.computeBytesSize(6, getStringBytes());
                }
                int size = this.a.size() + i8;
                this.l = size;
                return size;
            }

            public String getString() {
                Object obj = this.e;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.e = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getStringBytes() {
                Object obj = this.e;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.e = copyFromUtf8;
                return copyFromUtf8;
            }

            public int getSubstringIndexCount() {
                return this.g.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.g;
            }

            public boolean hasOperation() {
                return (this.b & 8) == 8;
            }

            public boolean hasPredefinedIndex() {
                return (this.b & 2) == 2;
            }

            public boolean hasRange() {
                return (this.b & 1) == 1;
            }

            public boolean hasString() {
                return (this.b & 4) == 4;
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
                this.k = 1;
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
                if ((this.b & 8) == 8) {
                    codedOutputStream.writeEnum(3, this.f.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    codedOutputStream.writeRawVarint32(34);
                    codedOutputStream.writeRawVarint32(this.h);
                }
                for (int i2 = 0; i2 < this.g.size(); i2++) {
                    codedOutputStream.writeInt32NoTag(this.g.get(i2).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    codedOutputStream.writeRawVarint32(42);
                    codedOutputStream.writeRawVarint32(this.j);
                }
                for (int i3 = 0; i3 < this.i.size(); i3++) {
                    codedOutputStream.writeInt32NoTag(this.i.get(i3).intValue());
                }
                if ((this.b & 4) == 4) {
                    codedOutputStream.writeBytes(6, getStringBytes());
                }
                codedOutputStream.writeRawBytes(this.a);
            }

            public static Builder newBuilder() {
                return new Builder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Record getDefaultInstanceForType() {
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

            public Record() {
                this.h = -1;
                this.j = -1;
                this.k = -1;
                this.l = -1;
                this.a = ByteString.EMPTY;
            }

            public Record(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this.h = -1;
                this.j = -1;
                this.k = -1;
                this.l = -1;
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
                                Operation valueOf = Operation.valueOf(readEnum);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum);
                                } else {
                                    this.b |= 8;
                                    this.f = valueOf;
                                }
                            } else if (readTag == 32) {
                                if (!(z2 & true)) {
                                    this.g = new ArrayList();
                                    z2 |= true;
                                }
                                this.g.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (readTag == 34) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.g = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.g.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 40) {
                                if (!(z2 & true)) {
                                    this.i = new ArrayList();
                                    z2 |= true;
                                }
                                this.i.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (readTag == 42) {
                                int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.i = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.i.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit2);
                            } else if (readTag == 50) {
                                ByteString readBytes = codedInputStream.readBytes();
                                this.b |= 4;
                                this.e = readBytes;
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
                    this.g = Collections.unmodifiableList(this.g);
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

        public interface RecordOrBuilder extends MessageLiteOrBuilder {
        }

        public static class a extends AbstractParser<StringTableTypes> {
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTableTypes(codedInputStream, extensionRegistryLite, null);
            }
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes();
            g = stringTableTypes;
            stringTableTypes.b = Collections.emptyList();
            stringTableTypes.c = Collections.emptyList();
        }

        public StringTableTypes(GeneratedMessageLite.Builder builder, a aVar) {
            super(builder);
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.a = builder.getUnknownFields();
        }

        public static StringTableTypes getDefaultInstance() {
            return g;
        }

        public static Builder newBuilder(StringTableTypes stringTableTypes) {
            return newBuilder().mergeFrom(stringTableTypes);
        }

        public static StringTableTypes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public List<Integer> getLocalNameList() {
            return this.c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTableTypes> getParserForType() {
            return PARSER;
        }

        public List<Record> getRecordList() {
            return this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.b.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.c.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.c.get(i5).intValue());
            }
            int i6 = i2 + i4;
            if (!getLocalNameList().isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.d = i4;
            int size = this.a.size() + i6;
            this.f = size;
            return size;
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
            this.e = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.b.size(); i++) {
                codedOutputStream.writeMessage(1, this.b.get(i));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(42);
                codedOutputStream.writeRawVarint32(this.d);
            }
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.c.get(i2).intValue());
            }
            codedOutputStream.writeRawBytes(this.a);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTableTypes getDefaultInstanceForType() {
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

        public StringTableTypes() {
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.a = ByteString.EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.util.List<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record> */
        /* JADX WARN: Multi-variable type inference failed */
        public StringTableTypes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.b = Collections.emptyList();
            this.c = Collections.emptyList();
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
                            this.b.add(codedInputStream.readMessage(Record.PARSER, extensionRegistryLite));
                        } else if (readTag == 40) {
                            if (!(z2 & true)) {
                                this.c = new ArrayList();
                                z2 |= true;
                            }
                            this.c.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag == 42) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.c = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.c.add(Integer.valueOf(codedInputStream.readInt32()));
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
                    if (z2 && true) {
                        this.b = Collections.unmodifiableList(this.b);
                    }
                    if (z2 & true) {
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
                this.b = Collections.unmodifiableList(this.b);
            }
            if (z2 & true) {
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

    public interface StringTableTypesOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        ProtoBuf.Constructor defaultInstance = ProtoBuf.Constructor.getDefaultInstance();
        JvmMethodSignature defaultInstance2 = JvmMethodSignature.getDefaultInstance();
        JvmMethodSignature defaultInstance3 = JvmMethodSignature.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, fieldType, JvmMethodSignature.class);
        methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, fieldType, JvmMethodSignature.class);
        ProtoBuf.Function defaultInstance4 = ProtoBuf.Function.getDefaultInstance();
        WireFormat.FieldType fieldType2 = WireFormat.FieldType.INT32;
        lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, fieldType2, Integer.class);
        propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, fieldType, JvmPropertySignature.class);
        flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, fieldType, false, ProtoBuf.Annotation.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, fieldType, false, ProtoBuf.Annotation.class);
        classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, fieldType, false, ProtoBuf.Property.class);
        anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, fieldType2, Integer.class);
        jvmClassFlags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, fieldType2, Integer.class);
        packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, fieldType, false, ProtoBuf.Property.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(constructorSignature);
        extensionRegistryLite.add(methodSignature);
        extensionRegistryLite.add(lambdaClassOriginName);
        extensionRegistryLite.add(propertySignature);
        extensionRegistryLite.add(flags);
        extensionRegistryLite.add(typeAnnotation);
        extensionRegistryLite.add(isRaw);
        extensionRegistryLite.add(typeParameterAnnotation);
        extensionRegistryLite.add(classModuleName);
        extensionRegistryLite.add(classLocalVariable);
        extensionRegistryLite.add(anonymousObjectOriginName);
        extensionRegistryLite.add(jvmClassFlags);
        extensionRegistryLite.add(packageModuleName);
        extensionRegistryLite.add(packageLocalVariable);
    }
}
