package proto.events.apps;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import proto.events.apps.EventOuterClass;
public final class BatchOuterClass {

    public static final class Envelope extends GeneratedMessageLite<Envelope, Builder> implements EnvelopeOrBuilder {
        public static final int COMMON_FIELD_NUMBER = 3;
        public static final int EVENTS_FIELD_NUMBER = 4;
        public static final int META_FIELD_NUMBER = 2;
        public static final int VERSION_FIELD_NUMBER = 1;
        public static final Envelope f;
        public static volatile Parser<Envelope> g;
        public int a;
        public int b;
        public MapFieldLite<String, String> c = MapFieldLite.emptyMapField();
        public MapFieldLite<String, String> d = MapFieldLite.emptyMapField();
        public Internal.ProtobufList<EventOuterClass.Event> e = GeneratedMessageLite.emptyProtobufList();

        public static final class a {
            public static final MapEntryLite<String, String> a;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                a = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }
        }

        public static final class b {
            public static final MapEntryLite<String, String> a;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                a = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }
        }

        static {
            Envelope envelope = new Envelope();
            f = envelope;
            envelope.makeImmutable();
        }

        public static Envelope getDefaultInstance() {
            return f;
        }

        public static Map j(Envelope envelope) {
            if (!envelope.c.isMutable()) {
                envelope.c = envelope.c.mutableCopy();
            }
            return envelope.c;
        }

        public static Map k(Envelope envelope) {
            if (!envelope.d.isMutable()) {
                envelope.d = envelope.d.mutableCopy();
            }
            return envelope.d;
        }

        public static Builder newBuilder() {
            return (Builder) f.toBuilder();
        }

        public static Envelope parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Envelope) GeneratedMessageLite.parseDelimitedFrom(f, inputStream);
        }

        public static Envelope parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Envelope) GeneratedMessageLite.parseFrom(f, byteString);
        }

        public static Parser<Envelope> parser() {
            return f.getParserForType();
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public boolean containsCommon(String str) {
            Objects.requireNonNull(str);
            return this.d.containsKey(str);
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public boolean containsMeta(String str) {
            Objects.requireNonNull(str);
            return this.c.containsKey(str);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke.ordinal()) {
                case 0:
                    return f;
                case 1:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Envelope envelope = (Envelope) obj2;
                    int i = this.b;
                    boolean z2 = i != 0;
                    int i2 = envelope.b;
                    if (i2 != 0) {
                        z = true;
                    }
                    this.b = visitor.visitInt(z2, i, z, i2);
                    this.c = visitor.visitMap(this.c, envelope.c);
                    this.d = visitor.visitMap(this.d, envelope.d);
                    this.e = visitor.visitList(this.e, envelope.e);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= envelope.a;
                    }
                    return this;
                case 2:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.b = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    if (!this.c.isMutable()) {
                                        this.c = this.c.mutableCopy();
                                    }
                                    b.a.parseInto(this.c, codedInputStream, extensionRegistryLite);
                                } else if (readTag == 26) {
                                    if (!this.d.isMutable()) {
                                        this.d = this.d.mutableCopy();
                                    }
                                    a.a.parseInto(this.d, codedInputStream, extensionRegistryLite);
                                } else if (readTag == 34) {
                                    if (!this.e.isModifiable()) {
                                        this.e = GeneratedMessageLite.mutableCopy(this.e);
                                    }
                                    this.e.add((EventOuterClass.Event) codedInputStream.readMessage(EventOuterClass.Event.parser(), extensionRegistryLite));
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 3:
                    this.c.makeImmutable();
                    this.d.makeImmutable();
                    this.e.makeImmutable();
                    return null;
                case 4:
                    return new Envelope();
                case 5:
                    return new Builder(null);
                case 6:
                    break;
                case 7:
                    if (g == null) {
                        synchronized (Envelope.class) {
                            if (g == null) {
                                g = new GeneratedMessageLite.DefaultInstanceBasedParser(f);
                            }
                        }
                    }
                    return g;
                default:
                    throw new UnsupportedOperationException();
            }
            return f;
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        @Deprecated
        public Map<String, String> getCommon() {
            return getCommonMap();
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public int getCommonCount() {
            return this.d.size();
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public Map<String, String> getCommonMap() {
            return Collections.unmodifiableMap(this.d);
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public String getCommonOrDefault(String str, String str2) {
            Objects.requireNonNull(str);
            MapFieldLite<String, String> mapFieldLite = this.d;
            return mapFieldLite.containsKey(str) ? mapFieldLite.get(str) : str2;
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public String getCommonOrThrow(String str) {
            Objects.requireNonNull(str);
            MapFieldLite<String, String> mapFieldLite = this.d;
            if (mapFieldLite.containsKey(str)) {
                return mapFieldLite.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public EventOuterClass.Event getEvents(int i) {
            return this.e.get(i);
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public int getEventsCount() {
            return this.e.size();
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public List<EventOuterClass.Event> getEventsList() {
            return this.e;
        }

        public EventOuterClass.EventOrBuilder getEventsOrBuilder(int i) {
            return this.e.get(i);
        }

        public List<? extends EventOuterClass.EventOrBuilder> getEventsOrBuilderList() {
            return this.e;
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        @Deprecated
        public Map<String, String> getMeta() {
            return getMetaMap();
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public int getMetaCount() {
            return this.c.size();
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public Map<String, String> getMetaMap() {
            return Collections.unmodifiableMap(this.c);
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public String getMetaOrDefault(String str, String str2) {
            Objects.requireNonNull(str);
            MapFieldLite<String, String> mapFieldLite = this.c;
            return mapFieldLite.containsKey(str) ? mapFieldLite.get(str) : str2;
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public String getMetaOrThrow(String str) {
            Objects.requireNonNull(str);
            MapFieldLite<String, String> mapFieldLite = this.c;
            if (mapFieldLite.containsKey(str)) {
                return mapFieldLite.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.b;
            int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                computeInt32Size += b.a.computeMessageSize(2, entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, String> entry2 : this.d.entrySet()) {
                computeInt32Size += a.a.computeMessageSize(3, entry2.getKey(), entry2.getValue());
            }
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(4, this.e.get(i3));
            }
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
        public int getVersion() {
            return this.b;
        }

        public final void l() {
            if (!this.e.isModifiable()) {
                this.e = GeneratedMessageLite.mutableCopy(this.e);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.b;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                b.a.serializeTo(codedOutputStream, 2, entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, String> entry2 : this.d.entrySet()) {
                a.a.serializeTo(codedOutputStream, 3, entry2.getKey(), entry2.getValue());
            }
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                codedOutputStream.writeMessage(4, this.e.get(i2));
            }
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Envelope, Builder> implements EnvelopeOrBuilder {
            public Builder() {
                super(Envelope.f);
            }

            public Builder addAllEvents(Iterable<? extends EventOuterClass.Event> iterable) {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i = Envelope.VERSION_FIELD_NUMBER;
                envelope.l();
                AbstractMessageLite.addAll(iterable, envelope.e);
                return this;
            }

            public Builder addEvents(EventOuterClass.Event event) {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i = Envelope.VERSION_FIELD_NUMBER;
                Objects.requireNonNull(envelope);
                Objects.requireNonNull(event);
                envelope.l();
                envelope.e.add(event);
                return this;
            }

            public Builder clearCommon() {
                copyOnWrite();
                Envelope.k((Envelope) this.instance).clear();
                return this;
            }

            public Builder clearEvents() {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i = Envelope.VERSION_FIELD_NUMBER;
                Objects.requireNonNull(envelope);
                envelope.e = GeneratedMessageLite.emptyProtobufList();
                return this;
            }

            public Builder clearMeta() {
                copyOnWrite();
                Envelope.j((Envelope) this.instance).clear();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Envelope) this.instance).b = 0;
                return this;
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public boolean containsCommon(String str) {
                Objects.requireNonNull(str);
                return ((Envelope) this.instance).getCommonMap().containsKey(str);
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public boolean containsMeta(String str) {
                Objects.requireNonNull(str);
                return ((Envelope) this.instance).getMetaMap().containsKey(str);
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            @Deprecated
            public Map<String, String> getCommon() {
                return getCommonMap();
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public int getCommonCount() {
                return ((Envelope) this.instance).getCommonMap().size();
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public Map<String, String> getCommonMap() {
                return Collections.unmodifiableMap(((Envelope) this.instance).getCommonMap());
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public String getCommonOrDefault(String str, String str2) {
                Objects.requireNonNull(str);
                Map<String, String> commonMap = ((Envelope) this.instance).getCommonMap();
                return commonMap.containsKey(str) ? commonMap.get(str) : str2;
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public String getCommonOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, String> commonMap = ((Envelope) this.instance).getCommonMap();
                if (commonMap.containsKey(str)) {
                    return commonMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public EventOuterClass.Event getEvents(int i) {
                return ((Envelope) this.instance).getEvents(i);
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public int getEventsCount() {
                return ((Envelope) this.instance).getEventsCount();
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public List<EventOuterClass.Event> getEventsList() {
                return Collections.unmodifiableList(((Envelope) this.instance).getEventsList());
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            @Deprecated
            public Map<String, String> getMeta() {
                return getMetaMap();
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public int getMetaCount() {
                return ((Envelope) this.instance).getMetaMap().size();
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public Map<String, String> getMetaMap() {
                return Collections.unmodifiableMap(((Envelope) this.instance).getMetaMap());
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public String getMetaOrDefault(String str, String str2) {
                Objects.requireNonNull(str);
                Map<String, String> metaMap = ((Envelope) this.instance).getMetaMap();
                return metaMap.containsKey(str) ? metaMap.get(str) : str2;
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public String getMetaOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, String> metaMap = ((Envelope) this.instance).getMetaMap();
                if (metaMap.containsKey(str)) {
                    return metaMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // proto.events.apps.BatchOuterClass.EnvelopeOrBuilder
            public int getVersion() {
                return ((Envelope) this.instance).getVersion();
            }

            public Builder putAllCommon(Map<String, String> map) {
                copyOnWrite();
                Envelope.k((Envelope) this.instance).putAll(map);
                return this;
            }

            public Builder putAllMeta(Map<String, String> map) {
                copyOnWrite();
                Envelope.j((Envelope) this.instance).putAll(map);
                return this;
            }

            public Builder putCommon(String str, String str2) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(str2);
                copyOnWrite();
                Envelope.k((Envelope) this.instance).put(str, str2);
                return this;
            }

            public Builder putMeta(String str, String str2) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(str2);
                copyOnWrite();
                Envelope.j((Envelope) this.instance).put(str, str2);
                return this;
            }

            public Builder removeCommon(String str) {
                Objects.requireNonNull(str);
                copyOnWrite();
                Envelope.k((Envelope) this.instance).remove(str);
                return this;
            }

            public Builder removeEvents(int i) {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i2 = Envelope.VERSION_FIELD_NUMBER;
                envelope.l();
                envelope.e.remove(i);
                return this;
            }

            public Builder removeMeta(String str) {
                Objects.requireNonNull(str);
                copyOnWrite();
                Envelope.j((Envelope) this.instance).remove(str);
                return this;
            }

            public Builder setEvents(int i, EventOuterClass.Event event) {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i2 = Envelope.VERSION_FIELD_NUMBER;
                Objects.requireNonNull(envelope);
                Objects.requireNonNull(event);
                envelope.l();
                envelope.e.set(i, event);
                return this;
            }

            public Builder setVersion(int i) {
                copyOnWrite();
                ((Envelope) this.instance).b = i;
                return this;
            }

            public Builder(a aVar) {
                super(Envelope.f);
            }

            public Builder addEvents(int i, EventOuterClass.Event event) {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i2 = Envelope.VERSION_FIELD_NUMBER;
                Objects.requireNonNull(envelope);
                Objects.requireNonNull(event);
                envelope.l();
                envelope.e.add(i, event);
                return this;
            }

            public Builder setEvents(int i, EventOuterClass.Event.Builder builder) {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i2 = Envelope.VERSION_FIELD_NUMBER;
                envelope.l();
                envelope.e.set(i, (EventOuterClass.Event) builder.build());
                return this;
            }

            public Builder addEvents(EventOuterClass.Event.Builder builder) {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i = Envelope.VERSION_FIELD_NUMBER;
                envelope.l();
                envelope.e.add((EventOuterClass.Event) builder.build());
                return this;
            }

            public Builder addEvents(int i, EventOuterClass.Event.Builder builder) {
                copyOnWrite();
                Envelope envelope = (Envelope) this.instance;
                int i2 = Envelope.VERSION_FIELD_NUMBER;
                envelope.l();
                envelope.e.add(i, (EventOuterClass.Event) builder.build());
                return this;
            }
        }

        public static Builder newBuilder(Envelope envelope) {
            return (Builder) ((Builder) f.toBuilder()).mergeFrom((Builder) envelope);
        }

        public static Envelope parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Envelope) GeneratedMessageLite.parseDelimitedFrom(f, inputStream, extensionRegistryLite);
        }

        public static Envelope parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Envelope) GeneratedMessageLite.parseFrom(f, byteString, extensionRegistryLite);
        }

        public static Envelope parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Envelope) GeneratedMessageLite.parseFrom(f, bArr);
        }

        public static Envelope parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Envelope) GeneratedMessageLite.parseFrom(f, bArr, extensionRegistryLite);
        }

        public static Envelope parseFrom(InputStream inputStream) throws IOException {
            return (Envelope) GeneratedMessageLite.parseFrom(f, inputStream);
        }

        public static Envelope parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Envelope) GeneratedMessageLite.parseFrom(f, inputStream, extensionRegistryLite);
        }

        public static Envelope parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Envelope) GeneratedMessageLite.parseFrom(f, codedInputStream);
        }

        public static Envelope parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Envelope) GeneratedMessageLite.parseFrom(f, codedInputStream, extensionRegistryLite);
        }
    }

    public interface EnvelopeOrBuilder extends MessageLiteOrBuilder {
        boolean containsCommon(String str);

        boolean containsMeta(String str);

        @Deprecated
        Map<String, String> getCommon();

        int getCommonCount();

        Map<String, String> getCommonMap();

        String getCommonOrDefault(String str, String str2);

        String getCommonOrThrow(String str);

        EventOuterClass.Event getEvents(int i);

        int getEventsCount();

        List<EventOuterClass.Event> getEventsList();

        @Deprecated
        Map<String, String> getMeta();

        int getMetaCount();

        Map<String, String> getMetaMap();

        String getMetaOrDefault(String str, String str2);

        String getMetaOrThrow(String str);

        int getVersion();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
