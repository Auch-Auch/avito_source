package com.google.protobuf;

import a2.j.i.e;
import a2.j.i.f;
import a2.j.i.g;
import a2.j.i.i;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    public int memoizedSerializedSize = -1;
    public UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        public final MessageType a;
        public MessageType instance;
        public boolean isBuilt = false;

        public Builder(MessageType messagetype) {
            this.a = messagetype;
            this.instance = (MessageType) ((GeneratedMessageLite) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE));
        }

        public void copyOnWrite() {
            if (this.isBuilt) {
                MessageType messagetype = (MessageType) ((GeneratedMessageLite) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE));
                messagetype.i(MergeFromVisitor.INSTANCE, this.instance);
                this.instance = messagetype;
                this.isBuilt = false;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.protobuf.GeneratedMessageLite$Builder<MessageType extends com.google.protobuf.GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends com.google.protobuf.GeneratedMessageLite$Builder<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return internalMergeFrom((Builder<MessageType, BuilderType>) ((GeneratedMessageLite) abstractMessageLite));
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public final BuilderType clear() {
            this.instance = (MessageType) ((GeneratedMessageLite) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE));
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.a;
        }

        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom((Builder<MessageType, BuilderType>) messagetype);
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            this.instance.i(MergeFromVisitor.INSTANCE, messagetype);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            copyOnWrite();
            try {
                this.instance.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, codedInputStream, extensionRegistryLite);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        public T b;

        public DefaultInstanceBasedParser(T t) {
            this.b = t;
        }

        @Override // com.google.protobuf.Parser
        public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.g(this.b, codedInputStream, extensionRegistryLite);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        public ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
            MessageType messagetype2 = this.instance;
            ((ExtendableMessage) messagetype2).extensions = ((ExtendableMessage) messagetype2).extensions.clone();
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            Objects.requireNonNull(extensionLite);
            GeneratedExtension<MessageType, ?> generatedExtension = (GeneratedExtension) extensionLite;
            b(generatedExtension);
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions.a(generatedExtension.d, generatedExtension.b(type));
            return this;
        }

        public final void b(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            Objects.requireNonNull(extensionLite);
            GeneratedExtension<MessageType, ?> generatedExtension = (GeneratedExtension) extensionLite;
            b(generatedExtension);
            copyOnWrite();
            FieldSet<c> fieldSet = ((ExtendableMessage) this.instance).extensions;
            fieldSet.a.remove(generatedExtension.d);
            if (fieldSet.a.isEmpty()) {
                fieldSet.c = false;
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public void copyOnWrite() {
            if (this.isBuilt) {
                super.copyOnWrite();
                MessageType messagetype = this.instance;
                ((ExtendableMessage) messagetype).extensions = ((ExtendableMessage) messagetype).extensions.clone();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(extensionLite);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            return ((ExtendableMessage) this.instance).getExtensionCount(extensionLite);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.instance).hasExtension(extensionLite);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i, Type type) {
            Objects.requireNonNull(extensionLite);
            GeneratedExtension<MessageType, ?> generatedExtension = (GeneratedExtension) extensionLite;
            b(generatedExtension);
            copyOnWrite();
            FieldSet<c> fieldSet = ((ExtendableMessage) this.instance).extensions;
            c cVar = generatedExtension.d;
            Object b = generatedExtension.b(type);
            Objects.requireNonNull(fieldSet);
            if (cVar.isRepeated()) {
                Object g = fieldSet.g(cVar);
                if (g != null) {
                    FieldSet.q(cVar.getLiteType(), b);
                    ((List) g).set(i, b);
                    return this;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(extensionLite, i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public final MessageType buildPartial() {
            if (this.isBuilt) {
                return (MessageType) ((ExtendableMessage) this.instance);
            }
            ((ExtendableMessage) this.instance).extensions.l();
            return (MessageType) ((ExtendableMessage) super.buildPartial());
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object
        public BuilderType clone() {
            return (BuilderType) ((ExtendableBuilder) super.clone());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.ArrayList */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            Objects.requireNonNull(extensionLite);
            GeneratedExtension<MessageType, ?> generatedExtension = (GeneratedExtension) extensionLite;
            b(generatedExtension);
            copyOnWrite();
            FieldSet<c> fieldSet = ((ExtendableMessage) this.instance).extensions;
            c cVar = generatedExtension.d;
            if (!cVar.d) {
                type = (Type) generatedExtension.b(type);
            } else if (cVar.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : type) {
                    arrayList.add(generatedExtension.b(obj));
                }
                type = arrayList;
            }
            fieldSet.p(cVar, type);
            return this;
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        public final ContainingType a;
        public final Type b;
        public final MessageLite c;
        public final c d;

        /* JADX WARN: Incorrect args count in method signature: (TContainingType;TType;Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/GeneratedMessageLite$c;Ljava/lang/Class;)V */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.protobuf.MessageLite */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, c cVar) {
            if (messageLite == 0) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (cVar.c == WireFormat.FieldType.MESSAGE && messageLite2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.a = messageLite;
                this.b = obj;
                this.c = messageLite2;
                this.d = cVar;
            }
        }

        public Object a(Object obj) {
            return this.d.getLiteJavaType() == WireFormat.JavaType.ENUM ? this.d.a.findValueByNumber(((Integer) obj).intValue()) : obj;
        }

        public Object b(Object obj) {
            return this.d.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).getNumber()) : obj;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.a;
        }

        @Override // com.google.protobuf.ExtensionLite
        public Type getDefaultValue() {
            return this.b;
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return this.d.c;
        }

        @Override // com.google.protobuf.ExtensionLite
        public MessageLite getMessageDefaultInstance() {
            return this.c;
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return this.d.b;
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return this.d.d;
        }
    }

    public static class MergeFromVisitor implements Visitor {
        public static final MergeFromVisitor INSTANCE = new MergeFromVisitor();

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            int size = booleanList.size();
            int size2 = booleanList2.size();
            if (size > 0 && size2 > 0) {
                if (!booleanList.isModifiable()) {
                    booleanList = booleanList.mutableCopyWithCapacity(size2 + size);
                }
                booleanList.addAll(booleanList2);
            }
            return size > 0 ? booleanList : booleanList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            return z2 ? byteString2 : byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            return z2 ? d2 : d;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            int size = doubleList.size();
            int size2 = doubleList2.size();
            if (size > 0 && size2 > 0) {
                if (!doubleList.isModifiable()) {
                    doubleList = doubleList.mutableCopyWithCapacity(size2 + size);
                }
                doubleList.addAll(doubleList2);
            }
            return size > 0 ? doubleList : doubleList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<c> visitExtensions(FieldSet<c> fieldSet, FieldSet<c> fieldSet2) {
            if (fieldSet.b) {
                fieldSet = fieldSet.clone();
            }
            fieldSet.m(fieldSet2);
            return fieldSet;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            return z2 ? f2 : f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            int size = floatList.size();
            int size2 = floatList2.size();
            if (size > 0 && size2 > 0) {
                if (!floatList.isModifiable()) {
                    floatList = floatList.mutableCopyWithCapacity(size2 + size);
                }
                floatList.addAll(floatList2);
            }
            return size > 0 ? floatList : floatList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            int size = intList.size();
            int size2 = intList2.size();
            if (size > 0 && size2 > 0) {
                if (!intList.isModifiable()) {
                    intList = intList.mutableCopyWithCapacity(size2 + size);
                }
                intList.addAll(intList2);
            }
            return size > 0 ? intList : intList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public LazyFieldLite visitLazyMessage(LazyFieldLite lazyFieldLite, LazyFieldLite lazyFieldLite2) {
            if (lazyFieldLite2 != null) {
                if (lazyFieldLite == null) {
                    lazyFieldLite = new LazyFieldLite();
                }
                lazyFieldLite.merge(lazyFieldLite2);
            }
            return lazyFieldLite;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            return size > 0 ? protobufList : protobufList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            int size = longList.size();
            int size2 = longList2.size();
            if (size > 0 && size2 > 0) {
                if (!longList.isModifiable()) {
                    longList = longList.mutableCopyWithCapacity(size2 + size);
                }
                longList.addAll(longList2);
            }
            return size > 0 ? longList : longList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            if (!mapFieldLite2.isEmpty()) {
                if (!mapFieldLite.isMutable()) {
                    mapFieldLite = mapFieldLite.mutableCopy();
                }
                mapFieldLite.mergeFrom(mapFieldLite2);
            }
            return mapFieldLite;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T t, T t2) {
            return (t == null || t2 == null) ? t != null ? t : t2 : (T) t.toBuilder().mergeFrom(t2).build();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            LazyFieldLite lazyFieldLite = z ? (LazyFieldLite) obj : new LazyFieldLite();
            lazyFieldLite.merge((LazyFieldLite) obj2);
            return lazyFieldLite;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            return z ? visitMessage((MessageLite) obj, (MessageLite) obj2) : obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean z) {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            return unknownFieldSetLite2 == UnknownFieldSetLite.getDefaultInstance() ? unknownFieldSetLite : UnknownFieldSetLite.c(unknownFieldSetLite, unknownFieldSetLite2);
        }
    }

    public enum MethodToInvoke {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final String a;
        public final byte[] b;

        public SerializedForm(MessageLite messageLite) {
            this.a = messageLite.getClass().getName();
            this.b = messageLite.toByteArray();
        }

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        public Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = Class.forName(this.a).getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).newBuilderForType().mergeFrom(this.b).buildPartial();
            } catch (ClassNotFoundException e) {
                StringBuilder L = a2.b.a.a.a.L("Unable to find proto buffer class: ");
                L.append(this.a);
                throw new RuntimeException(L.toString(), e);
            } catch (NoSuchFieldException unused) {
                try {
                    Field declaredField2 = Class.forName(this.a).getDeclaredField("defaultInstance");
                    declaredField2.setAccessible(true);
                    return ((MessageLite) declaredField2.get(null)).newBuilderForType().mergeFrom(this.b).buildPartial();
                } catch (ClassNotFoundException e2) {
                    StringBuilder L2 = a2.b.a.a.a.L("Unable to find proto buffer class: ");
                    L2.append(this.a);
                    throw new RuntimeException(L2.toString(), e2);
                } catch (NoSuchFieldException e3) {
                    StringBuilder L3 = a2.b.a.a.a.L("Unable to find defaultInstance in ");
                    L3.append(this.a);
                    throw new RuntimeException(L3.toString(), e3);
                } catch (SecurityException e4) {
                    StringBuilder L4 = a2.b.a.a.a.L("Unable to call defaultInstance in ");
                    L4.append(this.a);
                    throw new RuntimeException(L4.toString(), e4);
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException("Unable to call parsePartialFrom", e5);
                } catch (InvalidProtocolBufferException e6) {
                    throw new RuntimeException("Unable to understand proto buffer", e6);
                }
            } catch (SecurityException e7) {
                StringBuilder L5 = a2.b.a.a.a.L("Unable to call DEFAULT_INSTANCE in ");
                L5.append(this.a);
                throw new RuntimeException(L5.toString(), e7);
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("Unable to call parsePartialFrom", e8);
            } catch (InvalidProtocolBufferException e9) {
                throw new RuntimeException("Unable to understand proto buffer", e9);
            }
        }
    }

    public interface Visitor {
        boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4);

        Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2);

        ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2);

        double visitDouble(boolean z, double d, boolean z2, double d2);

        Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2);

        FieldSet<c> visitExtensions(FieldSet<c> fieldSet, FieldSet<c> fieldSet2);

        float visitFloat(boolean z, float f, boolean z2, float f2);

        Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2);

        int visitInt(boolean z, int i, boolean z2, int i2);

        Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2);

        LazyFieldLite visitLazyMessage(LazyFieldLite lazyFieldLite, LazyFieldLite lazyFieldLite2);

        <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2);

        long visitLong(boolean z, long j, boolean z2, long j2);

        Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2);

        <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2);

        <T extends MessageLite> T visitMessage(T t, T t2);

        Object visitOneofBoolean(boolean z, Object obj, Object obj2);

        Object visitOneofByteString(boolean z, Object obj, Object obj2);

        Object visitOneofDouble(boolean z, Object obj, Object obj2);

        Object visitOneofFloat(boolean z, Object obj, Object obj2);

        Object visitOneofInt(boolean z, Object obj, Object obj2);

        Object visitOneofLazyMessage(boolean z, Object obj, Object obj2);

        Object visitOneofLong(boolean z, Object obj, Object obj2);

        Object visitOneofMessage(boolean z, Object obj, Object obj2);

        void visitOneofNotSet(boolean z);

        Object visitOneofString(boolean z, Object obj, Object obj2);

        String visitString(boolean z, String str, boolean z2, String str2);

        UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2);
    }

    public static class b implements Visitor {
        public static final b a = new b();
        public static final a b = new a();

        public static final class a extends RuntimeException {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3 && z2 == z4) {
                return z2;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            if (booleanList.equals(booleanList2)) {
                return booleanList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            if (z == z2 && byteString.equals(byteString2)) {
                return byteString;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            if (z == z2 && d == d2) {
                return d;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            if (doubleList.equals(doubleList2)) {
                return doubleList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<c> visitExtensions(FieldSet<c> fieldSet, FieldSet<c> fieldSet2) {
            if (fieldSet.equals(fieldSet2)) {
                return fieldSet;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            if (z == z2 && f == f2) {
                return f;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            if (floatList.equals(floatList2)) {
                return floatList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean z, int i, boolean z2, int i2) {
            if (z == z2 && i == i2) {
                return i;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            if (intList.equals(intList2)) {
                return intList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public LazyFieldLite visitLazyMessage(LazyFieldLite lazyFieldLite, LazyFieldLite lazyFieldLite2) {
            if (lazyFieldLite == null && lazyFieldLite2 == null) {
                return null;
            }
            if (lazyFieldLite == null || lazyFieldLite2 == null) {
                throw b;
            } else if (lazyFieldLite.equals(lazyFieldLite2)) {
                return lazyFieldLite;
            } else {
                throw b;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            if (protobufList.equals(protobufList2)) {
                return protobufList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean z, long j, boolean z2, long j2) {
            if (z == z2 && j == j2) {
                return j;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            if (longList.equals(longList2)) {
                return longList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            if (mapFieldLite.equals(mapFieldLite2)) {
                return mapFieldLite;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t == null || t2 == null) {
                throw b;
            }
            ((GeneratedMessageLite) t).d(this, t2);
            return t;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            if (z && ((GeneratedMessageLite) obj).d(this, (MessageLite) obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean z) {
            if (z) {
                throw b;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            if (unknownFieldSetLite.equals(unknownFieldSetLite2)) {
                return unknownFieldSetLite;
            }
            throw b;
        }
    }

    public static final class c implements FieldSet.FieldDescriptorLite<c> {
        public final Internal.EnumLiteMap<?> a;
        public final int b;
        public final WireFormat.FieldType c;
        public final boolean d;
        public final boolean e;

        public c(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.a = enumLiteMap;
            this.b = i;
            this.c = fieldType;
            this.d = z;
            this.e = z2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.b - ((c) obj).b;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.a;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.c.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.c;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.b;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.google.protobuf.GeneratedMessageLite$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((Builder) ((GeneratedMessageLite) messageLite));
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.e;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.d;
        }
    }

    public static class d implements Visitor {
        public int a = 0;

        public d(a aVar) {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            this.a = Internal.hashBoolean(z2) + (this.a * 53);
            return z2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            this.a = booleanList.hashCode() + (this.a * 53);
            return booleanList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            this.a = byteString.hashCode() + (this.a * 53);
            return byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            this.a = Internal.hashLong(Double.doubleToLongBits(d)) + (this.a * 53);
            return d;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            this.a = doubleList.hashCode() + (this.a * 53);
            return doubleList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<c> visitExtensions(FieldSet<c> fieldSet, FieldSet<c> fieldSet2) {
            this.a = fieldSet.hashCode() + (this.a * 53);
            return fieldSet;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            this.a = Float.floatToIntBits(f) + (this.a * 53);
            return f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            this.a = floatList.hashCode() + (this.a * 53);
            return floatList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean z, int i, boolean z2, int i2) {
            this.a = (this.a * 53) + i;
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            this.a = intList.hashCode() + (this.a * 53);
            return intList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public LazyFieldLite visitLazyMessage(LazyFieldLite lazyFieldLite, LazyFieldLite lazyFieldLite2) {
            this.a = (this.a * 53) + (lazyFieldLite != null ? lazyFieldLite.hashCode() : 37);
            return lazyFieldLite;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            this.a = protobufList.hashCode() + (this.a * 53);
            return protobufList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean z, long j, boolean z2, long j2) {
            this.a = Internal.hashLong(j) + (this.a * 53);
            return j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            this.a = longList.hashCode() + (this.a * 53);
            return longList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            this.a = mapFieldLite.hashCode() + (this.a * 53);
            return mapFieldLite;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: com.google.protobuf.GeneratedMessageLite */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T t, T t2) {
            int i;
            if (t == null) {
                i = 37;
            } else if (t instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                if (generatedMessageLite.memoizedHashCode == 0) {
                    int i2 = this.a;
                    this.a = 0;
                    generatedMessageLite.i(this, generatedMessageLite);
                    generatedMessageLite.memoizedHashCode = this.a;
                    this.a = i2;
                }
                i = generatedMessageLite.memoizedHashCode;
            } else {
                i = t.hashCode();
            }
            this.a = (this.a * 53) + i;
            return t;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            this.a = Internal.hashBoolean(((Boolean) obj).booleanValue()) + (this.a * 53);
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            this.a = obj.hashCode() + (this.a * 53);
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            this.a = Internal.hashLong(Double.doubleToLongBits(((Double) obj).doubleValue())) + (this.a * 53);
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            this.a = Float.floatToIntBits(((Float) obj).floatValue()) + (this.a * 53);
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            this.a = ((Integer) obj).intValue() + (this.a * 53);
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            this.a = obj.hashCode() + (this.a * 53);
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            this.a = Internal.hashLong(((Long) obj).longValue()) + (this.a * 53);
            return obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.google.protobuf.GeneratedMessageLite */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            int i;
            MessageLite messageLite = (MessageLite) obj;
            MessageLite messageLite2 = (MessageLite) obj2;
            if (messageLite == null) {
                i = 37;
            } else if (messageLite instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) messageLite;
                if (generatedMessageLite.memoizedHashCode == 0) {
                    int i2 = this.a;
                    this.a = 0;
                    generatedMessageLite.i(this, generatedMessageLite);
                    generatedMessageLite.memoizedHashCode = this.a;
                    this.a = i2;
                }
                i = generatedMessageLite.memoizedHashCode;
            } else {
                i = messageLite.hashCode();
            }
            this.a = (this.a * 53) + i;
            return messageLite;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean z) {
            if (z) {
                throw new IllegalStateException();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            this.a = obj.hashCode() + (this.a * 53);
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean z, String str, boolean z2, String str2) {
            this.a = str.hashCode() + (this.a * 53);
            return str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
            this.a = unknownFieldSetLite.hashCode() + (this.a * 53);
            return unknownFieldSetLite;
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T b(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new UninitializedMessageException(t).asInvalidProtocolBufferException().setUnfinishedMessage(t);
    }

    public static Object e(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static Internal.BooleanList emptyBooleanList() {
        return a2.j.i.b.d;
    }

    public static Internal.DoubleList emptyDoubleList() {
        return a2.j.i.c.d;
    }

    public static Internal.FloatList emptyFloatList() {
        return e.d;
    }

    public static Internal.IntList emptyIntList() {
        return f.d;
    }

    public static Internal.LongList emptyLongList() {
        return g.d;
    }

    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return i.c;
    }

    public static <T extends GeneratedMessageLite<T, ?>> T f(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream newInstance = CodedInputStream.newInstance(new AbstractMessageLite.Builder.a(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            T t2 = (T) g(t, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return t2;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(t2);
            }
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T g(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) ((GeneratedMessageLite) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE));
        try {
            t2.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, codedInputStream, extensionRegistryLite);
            t2.makeImmutable();
            return t2;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw e;
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T h(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream newInstance = CodedInputStream.newInstance(bArr);
            T t2 = (T) g(t, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return t2;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(t2);
            }
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    public static Internal.IntList mutableCopy(Internal.IntList intList) {
        int size = intList.size();
        return intList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new c(enumLiteMap, i, fieldType, true, z));
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new c(enumLiteMap, i, fieldType, false, false));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        T t2 = (T) f(t, inputStream, ExtensionRegistryLite.getEmptyRegistry());
        b(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString) throws InvalidProtocolBufferException {
        T t2 = (T) parseFrom(t, byteString, ExtensionRegistryLite.getEmptyRegistry());
        b(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) g(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    public final void c() {
        if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
            this.unknownFields = new UnknownFieldSetLite(0, new int[8], new Object[8], true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.protobuf.GeneratedMessageLite<MessageType extends com.google.protobuf.GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends com.google.protobuf.GeneratedMessageLite$Builder<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean d(b bVar, MessageLite messageLite) {
        if (this == messageLite) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(messageLite)) {
            return false;
        }
        i(bVar, (GeneratedMessageLite) messageLite);
        return true;
    }

    public Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.protobuf.GeneratedMessageLite<MessageType extends com.google.protobuf.GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends com.google.protobuf.GeneratedMessageLite$Builder<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        try {
            i(b.a, (GeneratedMessageLite) obj);
            return true;
        } catch (b.a unused) {
            return false;
        }
    }

    @Override // com.google.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    public int hashCode() {
        if (this.memoizedHashCode == 0) {
            d dVar = new d(null);
            i(dVar, this);
            this.memoizedHashCode = dVar.a;
        }
        return this.memoizedHashCode;
    }

    public void i(Visitor visitor, MessageType messagetype) {
        dynamicMethod(MethodToInvoke.VISIT, visitor, messagetype);
        this.unknownFields = visitor.visitUnknownFields(this.unknownFields, messagetype.unknownFields);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) != null;
    }

    public void makeImmutable() {
        dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
        this.unknownFields.makeImmutable();
    }

    public void mergeLengthDelimitedField(int i, ByteString byteString) {
        c();
        UnknownFieldSetLite unknownFieldSetLite = this.unknownFields;
        unknownFieldSetLite.a();
        if (i != 0) {
            unknownFieldSetLite.d((i << 3) | 2, byteString);
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.c(this.unknownFields, unknownFieldSetLite);
    }

    public void mergeVarintField(int i, int i2) {
        c();
        UnknownFieldSetLite unknownFieldSetLite = this.unknownFields;
        unknownFieldSetLite.a();
        if (i != 0) {
            unknownFieldSetLite.d((i << 3) | 0, Long.valueOf((long) i2));
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public boolean parseUnknownField(int i, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.getTagWireType(i) == 4) {
            return false;
        }
        c();
        return this.unknownFields.b(i, codedInputStream);
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        AppCompatDelegateImpl.i.O1(this, sb, 0);
        return sb.toString();
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t, boolean z) {
        return t.dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.valueOf(z)) != null;
    }

    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ((GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE));
    }

    @Override // com.google.protobuf.MessageLite
    public final BuilderType newBuilderForType() {
        return (BuilderType) ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER));
    }

    @Override // com.google.protobuf.MessageLite
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER));
        buildertype.mergeFrom(this);
        return buildertype;
    }

    public static final <T extends GeneratedMessageLite<T, ?>> void makeImmutable(T t) {
        t.dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
    }

    public static Internal.LongList mutableCopy(Internal.LongList longList) {
        int size = longList.size();
        return longList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            T t2 = (T) g(t, newCodedInput, extensionRegistryLite);
            try {
                newCodedInput.checkLastTagWas(0);
                b(t2);
                return t2;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(t2);
            }
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) f(t, inputStream, extensionRegistryLite);
        b(t2);
        return t2;
    }

    public static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        T t2 = (T) h(t, bArr, ExtensionRegistryLite.getEmptyRegistry());
        b(t2);
        return t2;
    }

    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) h(t, bArr, extensionRegistryLite);
        b(t2);
        return t2;
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        public FieldSet<c> extensions = new FieldSet<>();

        public class ExtensionWriter {
            public final Iterator<Map.Entry<c, Object>> a;
            public Map.Entry<c, Object> b;
            public final boolean c;

            public ExtensionWriter(boolean z, a aVar) {
                Iterator<Map.Entry<c, Object>> k = ExtendableMessage.this.extensions.k();
                this.a = k;
                if (k.hasNext()) {
                    this.b = k.next();
                }
                this.c = z;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<c, Object> entry = this.b;
                    if (entry != null && entry.getKey().b < i) {
                        c key = this.b.getKey();
                        if (!this.c || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.d) {
                            Object value = this.b.getValue();
                            int i2 = FieldSet.d;
                            WireFormat.FieldType liteType = key.getLiteType();
                            int number = key.getNumber();
                            if (key.isRepeated()) {
                                List<Object> list = (List) value;
                                if (key.isPacked()) {
                                    codedOutputStream.writeTag(number, 2);
                                    int i3 = 0;
                                    for (Object obj : list) {
                                        i3 += FieldSet.e(liteType, obj);
                                    }
                                    codedOutputStream.writeRawVarint32(i3);
                                    for (Object obj2 : list) {
                                        FieldSet.s(codedOutputStream, liteType, obj2);
                                    }
                                } else {
                                    for (Object obj3 : list) {
                                        FieldSet.r(codedOutputStream, liteType, number, obj3);
                                    }
                                }
                            } else if (value instanceof LazyField) {
                                FieldSet.r(codedOutputStream, liteType, number, ((LazyField) value).getValue());
                            } else {
                                FieldSet.r(codedOutputStream, liteType, number, value);
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

        public boolean extensionsAreInitialized() {
            FieldSet<c> fieldSet = this.extensions;
            for (int i = 0; i < fieldSet.a.e(); i++) {
                if (!fieldSet.j(fieldSet.a.d(i))) {
                    return false;
                }
            }
            for (Object obj : fieldSet.a.f()) {
                if (!fieldSet.j((Map.Entry) obj)) {
                    return false;
                }
            }
            return true;
        }

        public int extensionsSerializedSize() {
            FieldSet<c> fieldSet = this.extensions;
            int i = 0;
            for (int i2 = 0; i2 < fieldSet.a.e(); i2++) {
                Map.Entry<FieldDescriptorType, Object> d = fieldSet.a.d(i2);
                i += FieldSet.f(d.getKey(), d.getValue());
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : fieldSet.a.f()) {
                i += FieldSet.f(entry.getKey(), entry.getValue());
            }
            return i;
        }

        public int extensionsSerializedSizeAsMessageSet() {
            FieldSet<c> fieldSet = this.extensions;
            int i = 0;
            for (int i2 = 0; i2 < fieldSet.a.e(); i2++) {
                i += fieldSet.h(fieldSet.a.d(i2));
            }
            for (Object obj : fieldSet.a.f()) {
                i += fieldSet.h((Map.Entry) obj);
            }
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Objects.requireNonNull(extensionLite);
            GeneratedExtension<MessageType, ?> generatedExtension = (GeneratedExtension) extensionLite;
            j(generatedExtension);
            Type<Object> type = (Type) this.extensions.g(generatedExtension.d);
            if (type == null) {
                return generatedExtension.b;
            }
            c cVar = generatedExtension.d;
            if (!cVar.d) {
                return (Type) generatedExtension.a(type);
            }
            if (cVar.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return type;
            }
            Type type2 = (Type) new ArrayList();
            for (Object obj : type) {
                type2.add(generatedExtension.a(obj));
            }
            return type2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            Objects.requireNonNull(extensionLite);
            GeneratedExtension<MessageType, ?> generatedExtension = (GeneratedExtension) extensionLite;
            j(generatedExtension);
            FieldSet<c> fieldSet = this.extensions;
            c cVar = generatedExtension.d;
            Objects.requireNonNull(fieldSet);
            if (cVar.isRepeated()) {
                Object g = fieldSet.g(cVar);
                if (g == null) {
                    return 0;
                }
                return ((List) g).size();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Objects.requireNonNull(extensionLite);
            GeneratedExtension<MessageType, ?> generatedExtension = (GeneratedExtension) extensionLite;
            j(generatedExtension);
            FieldSet<c> fieldSet = this.extensions;
            c cVar = generatedExtension.d;
            Objects.requireNonNull(fieldSet);
            if (!cVar.isRepeated()) {
                return fieldSet.a.get(cVar) != null;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public void i(Visitor visitor, GeneratedMessageLite generatedMessageLite) {
            ExtendableMessage extendableMessage = (ExtendableMessage) generatedMessageLite;
            GeneratedMessageLite.super.i(visitor, extendableMessage);
            this.extensions = visitor.visitExtensions(this.extensions, extendableMessage.extensions);
        }

        public final void j(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final void makeImmutable() {
            GeneratedMessageLite.super.makeImmutable();
            this.extensions.l();
        }

        public final void mergeExtensionFields(MessageType messagetype) {
            FieldSet<c> fieldSet = this.extensions;
            if (fieldSet.b) {
                this.extensions = fieldSet.clone();
            }
            this.extensions.m(messagetype.extensions);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false, null);
        }

        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(true, null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <MessageType extends com.google.protobuf.MessageLite> boolean parseUnknownField(MessageType r7, com.google.protobuf.CodedInputStream r8, com.google.protobuf.ExtensionRegistryLite r9, int r10) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 269
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.ExtendableMessage.parseUnknownField(com.google.protobuf.MessageLite, com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite, int):boolean");
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            Objects.requireNonNull(extensionLite);
            GeneratedExtension<MessageType, ?> generatedExtension = (GeneratedExtension) extensionLite;
            j(generatedExtension);
            FieldSet<c> fieldSet = this.extensions;
            c cVar = generatedExtension.d;
            Objects.requireNonNull(fieldSet);
            if (cVar.isRepeated()) {
                Object g = fieldSet.g(cVar);
                if (g != null) {
                    return (Type) generatedExtension.a(((List) g).get(i));
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        T t2 = (T) g(t, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry());
        b(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) g(t, CodedInputStream.newInstance(inputStream), extensionRegistryLite);
        b(t2);
        return t2;
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) parseFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) g(t, codedInputStream, extensionRegistryLite);
        b(t2);
        return t2;
    }
}
