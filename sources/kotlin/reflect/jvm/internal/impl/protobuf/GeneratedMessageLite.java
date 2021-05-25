package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyField;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import t6.w.f.a.m.e.d;
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        public final ContainingType a;
        public final Type b;
        public final MessageLite c;
        public final b d;
        public final Method e;

        public GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, b bVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (bVar.c == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.a = containingtype;
                this.b = type;
                this.c = messageLite;
                this.d = bVar;
                if (Internal.EnumLite.class.isAssignableFrom(cls)) {
                    try {
                        this.e = cls.getMethod("valueOf", Integer.TYPE);
                    } catch (NoSuchMethodException e2) {
                        String name = cls.getName();
                        StringBuilder sb = new StringBuilder(name.length() + 45 + 7);
                        a2.b.a.a.a.n1(sb, "Generated message class \"", name, "\" missing method \"", "valueOf");
                        sb.append("\".");
                        throw new RuntimeException(sb.toString(), e2);
                    }
                } else {
                    this.e = null;
                }
            }
        }

        public Object a(Object obj) {
            if (this.d.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            try {
                return this.e.invoke(null, (Integer) obj);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
            } catch (InvocationTargetException e3) {
                Throwable cause = e3.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else {
                    throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
                }
            }
        }

        public Object b(Object obj) {
            return this.d.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).getNumber()) : obj;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.a;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.c;
        }

        public int getNumber() {
            return this.d.b;
        }
    }

    public static final class b implements FieldSet.FieldDescriptorLite<b> {
        public final Internal.EnumLiteMap<?> a;
        public final int b;
        public final WireFormat.FieldType c;
        public final boolean d;
        public final boolean e;

        public b(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.a = enumLiteMap;
            this.b = i;
            this.c = fieldType;
            this.d = z;
            this.e = z2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.b - ((b) obj).b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.c.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.d;
        }
    }

    public GeneratedMessageLite() {
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new b(enumLiteMap, i, fieldType, true, z), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new b(enumLiteMap, i, fieldType, false, false), cls);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public void makeExtensionsImmutable() {
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        return codedInputStream.skipField(i, codedOutputStream);
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        public ByteString a = ByteString.EMPTY;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        public final ByteString getUnknownFields() {
            return this.a;
        }

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final BuilderType setUnknownFields(ByteString byteString) {
            this.a = byteString;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    public GeneratedMessageLite(Builder builder) {
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        public FieldSet<b> b = FieldSet.d;
        public boolean c;

        public boolean extensionsAreInitialized() {
            return this.b.h();
        }

        public final void mergeExtensionFields(MessageType messagetype) {
            if (!this.c) {
                this.b = this.b.clone();
                this.c = true;
            }
            FieldSet<b> fieldSet = this.b;
            FieldSet<b> fieldSet2 = messagetype.a;
            Objects.requireNonNull(fieldSet);
            for (int i = 0; i < fieldSet2.a.e(); i++) {
                fieldSet.k(fieldSet2.a.d(i));
            }
            for (Object obj : fieldSet2.a.f()) {
                fieldSet.k((Map.Entry) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, java.lang.Object
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        public final FieldSet<b> a;

        public class ExtensionWriter {
            public final Iterator<Map.Entry<b, Object>> a;
            public Map.Entry<b, Object> b;
            public final boolean c;

            public ExtensionWriter(boolean z, a aVar) {
                Iterator<Map.Entry<b, Object>> it;
                FieldSet<b> fieldSet = ExtendableMessage.this.a;
                if (fieldSet.c) {
                    it = new LazyField.c<>(((d.C0685d) fieldSet.a.entrySet()).iterator());
                } else {
                    it = ((d.C0685d) fieldSet.a.entrySet()).iterator();
                }
                this.a = it;
                if (it.hasNext()) {
                    this.b = it.next();
                }
                this.c = z;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<b, Object> entry = this.b;
                    if (entry != null && entry.getKey().b < i) {
                        b key = this.b.getKey();
                        if (!this.c || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.d) {
                            Object value = this.b.getValue();
                            FieldSet fieldSet = FieldSet.d;
                            WireFormat.FieldType liteType = key.getLiteType();
                            int number = key.getNumber();
                            if (key.isRepeated()) {
                                List<Object> list = (List) value;
                                if (key.isPacked()) {
                                    codedOutputStream.writeTag(number, 2);
                                    int i2 = 0;
                                    for (Object obj : list) {
                                        i2 += FieldSet.d(liteType, obj);
                                    }
                                    codedOutputStream.writeRawVarint32(i2);
                                    for (Object obj2 : list) {
                                        FieldSet.p(codedOutputStream, liteType, obj2);
                                    }
                                } else {
                                    for (Object obj3 : list) {
                                        FieldSet.o(codedOutputStream, liteType, number, obj3);
                                    }
                                }
                            } else if (value instanceof LazyField) {
                                FieldSet.o(codedOutputStream, liteType, number, ((LazyField) value).getValue());
                            } else {
                                FieldSet.o(codedOutputStream, liteType, number, value);
                            }
                        } else {
                            codedOutputStream.writeMessageSetExtension(key.b, (MessageLite) this.b.getValue());
                        }
                        if (this.a.hasNext()) {
                            this.b = this.a.next();
                        } else {
                            this.b = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public ExtendableMessage() {
            this.a = new FieldSet<>();
        }

        public final void a(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public boolean extensionsAreInitialized() {
            return this.a.h();
        }

        public int extensionsSerializedSize() {
            FieldSet<b> fieldSet = this.a;
            int i = 0;
            for (int i2 = 0; i2 < fieldSet.a.e(); i2++) {
                Map.Entry<FieldDescriptorType, Object> d = fieldSet.a.d(i2);
                i += FieldSet.e(d.getKey(), d.getValue());
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : fieldSet.a.f()) {
                i += FieldSet.e(entry.getKey(), entry.getValue());
            }
            return i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            a(generatedExtension);
            Type<Object> type = (Type) this.a.f(generatedExtension.d);
            if (type == null) {
                return generatedExtension.b;
            }
            b bVar = generatedExtension.d;
            if (!bVar.d) {
                return (Type) generatedExtension.a(type);
            }
            if (bVar.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return type;
            }
            Type type2 = (Type) new ArrayList();
            for (Object obj : type) {
                type2.add(generatedExtension.a(obj));
            }
            return type2;
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            a(generatedExtension);
            FieldSet<b> fieldSet = this.a;
            b bVar = generatedExtension.d;
            Objects.requireNonNull(fieldSet);
            if (bVar.isRepeated()) {
                Object f = fieldSet.f(bVar);
                if (f == null) {
                    return 0;
                }
                return ((List) f).size();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            a(generatedExtension);
            FieldSet<b> fieldSet = this.a;
            b bVar = generatedExtension.d;
            Objects.requireNonNull(fieldSet);
            if (!bVar.isRepeated()) {
                return fieldSet.a.get(bVar) != null;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.a.j();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false, null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r9, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r10, int r11) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 268
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, int):boolean");
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            extendableBuilder.b.j();
            extendableBuilder.c = false;
            this.a = extendableBuilder.b;
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            a(generatedExtension);
            FieldSet<b> fieldSet = this.a;
            b bVar = generatedExtension.d;
            Objects.requireNonNull(fieldSet);
            if (bVar.isRepeated()) {
                Object f = fieldSet.f(bVar);
                if (f != null) {
                    return (Type) generatedExtension.a(((List) f).get(i));
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }
}
