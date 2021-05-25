package proto.events.apps;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
public final class EventOuterClass {

    public static final class Event extends GeneratedMessageLite<Event, Builder> implements EventOrBuilder {
        public static final int ENV_FIELD_NUMBER = 5;
        public static final int EVENTID_FIELD_NUMBER = 1;
        public static final int PARAMS_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 2;
        public static final Event f;
        public static volatile Parser<Event> g;
        public int a;
        public int b;
        public int c;
        public MapFieldLite<String, String> d = MapFieldLite.emptyMapField();
        public MapFieldLite<String, String> e = MapFieldLite.emptyMapField();

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
            Event event = new Event();
            f = event;
            event.makeImmutable();
        }

        public static Event getDefaultInstance() {
            return f;
        }

        public static Map j(Event event) {
            if (!event.d.isMutable()) {
                event.d = event.d.mutableCopy();
            }
            return event.d;
        }

        public static Map k(Event event) {
            if (!event.e.isMutable()) {
                event.e = event.e.mutableCopy();
            }
            return event.e;
        }

        public static Builder newBuilder() {
            return (Builder) f.toBuilder();
        }

        public static Event parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Event) GeneratedMessageLite.parseDelimitedFrom(f, inputStream);
        }

        public static Event parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(f, byteString);
        }

        public static Parser<Event> parser() {
            return f.getParserForType();
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public boolean containsEnv(String str) {
            Objects.requireNonNull(str);
            return this.e.containsKey(str);
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public boolean containsParams(String str) {
            Objects.requireNonNull(str);
            return this.d.containsKey(str);
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
                    Event event = (Event) obj2;
                    int i = this.b;
                    boolean z2 = i != 0;
                    int i2 = event.b;
                    this.b = visitor.visitInt(z2, i, i2 != 0, i2);
                    int i3 = this.c;
                    boolean z3 = i3 != 0;
                    int i4 = event.c;
                    if (i4 != 0) {
                        z = true;
                    }
                    this.c = visitor.visitInt(z3, i3, z, i4);
                    this.d = visitor.visitMap(this.d, event.d);
                    this.e = visitor.visitMap(this.e, event.e);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= event.a;
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
                                } else if (readTag == 16) {
                                    this.c = codedInputStream.readInt32();
                                } else if (readTag == 34) {
                                    if (!this.d.isMutable()) {
                                        this.d = this.d.mutableCopy();
                                    }
                                    b.a.parseInto(this.d, codedInputStream, extensionRegistryLite);
                                } else if (readTag == 42) {
                                    if (!this.e.isMutable()) {
                                        this.e = this.e.mutableCopy();
                                    }
                                    a.a.parseInto(this.e, codedInputStream, extensionRegistryLite);
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
                    this.d.makeImmutable();
                    this.e.makeImmutable();
                    return null;
                case 4:
                    return new Event();
                case 5:
                    return new Builder(null);
                case 6:
                    break;
                case 7:
                    if (g == null) {
                        synchronized (Event.class) {
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

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        @Deprecated
        public Map<String, String> getEnv() {
            return getEnvMap();
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public int getEnvCount() {
            return this.e.size();
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public Map<String, String> getEnvMap() {
            return Collections.unmodifiableMap(this.e);
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public String getEnvOrDefault(String str, String str2) {
            Objects.requireNonNull(str);
            MapFieldLite<String, String> mapFieldLite = this.e;
            return mapFieldLite.containsKey(str) ? mapFieldLite.get(str) : str2;
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public String getEnvOrThrow(String str) {
            Objects.requireNonNull(str);
            MapFieldLite<String, String> mapFieldLite = this.e;
            if (mapFieldLite.containsKey(str)) {
                return mapFieldLite.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public int getEventId() {
            return this.b;
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        @Deprecated
        public Map<String, String> getParams() {
            return getParamsMap();
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public int getParamsCount() {
            return this.d.size();
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public Map<String, String> getParamsMap() {
            return Collections.unmodifiableMap(this.d);
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public String getParamsOrDefault(String str, String str2) {
            Objects.requireNonNull(str);
            MapFieldLite<String, String> mapFieldLite = this.d;
            return mapFieldLite.containsKey(str) ? mapFieldLite.get(str) : str2;
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public String getParamsOrThrow(String str) {
            Objects.requireNonNull(str);
            MapFieldLite<String, String> mapFieldLite = this.d;
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
            int i2 = 0;
            int i3 = this.b;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
            }
            int i4 = this.c;
            if (i4 != 0) {
                i2 += CodedOutputStream.computeInt32Size(2, i4);
            }
            for (Map.Entry<String, String> entry : this.d.entrySet()) {
                i2 += b.a.computeMessageSize(4, entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, String> entry2 : this.e.entrySet()) {
                i2 += a.a.computeMessageSize(5, entry2.getKey(), entry2.getValue());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        @Override // proto.events.apps.EventOuterClass.EventOrBuilder
        public int getVersion() {
            return this.c;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.b;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.c;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            for (Map.Entry<String, String> entry : this.d.entrySet()) {
                b.a.serializeTo(codedOutputStream, 4, entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, String> entry2 : this.e.entrySet()) {
                a.a.serializeTo(codedOutputStream, 5, entry2.getKey(), entry2.getValue());
            }
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Event, Builder> implements EventOrBuilder {
            public Builder() {
                super(Event.f);
            }

            public Builder clearEnv() {
                copyOnWrite();
                Event.k((Event) this.instance).clear();
                return this;
            }

            public Builder clearEventId() {
                copyOnWrite();
                ((Event) this.instance).b = 0;
                return this;
            }

            public Builder clearParams() {
                copyOnWrite();
                Event.j((Event) this.instance).clear();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Event) this.instance).c = 0;
                return this;
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public boolean containsEnv(String str) {
                Objects.requireNonNull(str);
                return ((Event) this.instance).getEnvMap().containsKey(str);
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public boolean containsParams(String str) {
                Objects.requireNonNull(str);
                return ((Event) this.instance).getParamsMap().containsKey(str);
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            @Deprecated
            public Map<String, String> getEnv() {
                return getEnvMap();
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public int getEnvCount() {
                return ((Event) this.instance).getEnvMap().size();
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public Map<String, String> getEnvMap() {
                return Collections.unmodifiableMap(((Event) this.instance).getEnvMap());
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public String getEnvOrDefault(String str, String str2) {
                Objects.requireNonNull(str);
                Map<String, String> envMap = ((Event) this.instance).getEnvMap();
                return envMap.containsKey(str) ? envMap.get(str) : str2;
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public String getEnvOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, String> envMap = ((Event) this.instance).getEnvMap();
                if (envMap.containsKey(str)) {
                    return envMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public int getEventId() {
                return ((Event) this.instance).getEventId();
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            @Deprecated
            public Map<String, String> getParams() {
                return getParamsMap();
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public int getParamsCount() {
                return ((Event) this.instance).getParamsMap().size();
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public Map<String, String> getParamsMap() {
                return Collections.unmodifiableMap(((Event) this.instance).getParamsMap());
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public String getParamsOrDefault(String str, String str2) {
                Objects.requireNonNull(str);
                Map<String, String> paramsMap = ((Event) this.instance).getParamsMap();
                return paramsMap.containsKey(str) ? paramsMap.get(str) : str2;
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public String getParamsOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, String> paramsMap = ((Event) this.instance).getParamsMap();
                if (paramsMap.containsKey(str)) {
                    return paramsMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // proto.events.apps.EventOuterClass.EventOrBuilder
            public int getVersion() {
                return ((Event) this.instance).getVersion();
            }

            public Builder putAllEnv(Map<String, String> map) {
                copyOnWrite();
                Event.k((Event) this.instance).putAll(map);
                return this;
            }

            public Builder putAllParams(Map<String, String> map) {
                copyOnWrite();
                Event.j((Event) this.instance).putAll(map);
                return this;
            }

            public Builder putEnv(String str, String str2) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(str2);
                copyOnWrite();
                Event.k((Event) this.instance).put(str, str2);
                return this;
            }

            public Builder putParams(String str, String str2) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(str2);
                copyOnWrite();
                Event.j((Event) this.instance).put(str, str2);
                return this;
            }

            public Builder removeEnv(String str) {
                Objects.requireNonNull(str);
                copyOnWrite();
                Event.k((Event) this.instance).remove(str);
                return this;
            }

            public Builder removeParams(String str) {
                Objects.requireNonNull(str);
                copyOnWrite();
                Event.j((Event) this.instance).remove(str);
                return this;
            }

            public Builder setEventId(int i) {
                copyOnWrite();
                ((Event) this.instance).b = i;
                return this;
            }

            public Builder setVersion(int i) {
                copyOnWrite();
                ((Event) this.instance).c = i;
                return this;
            }

            public Builder(a aVar) {
                super(Event.f);
            }
        }

        public static Builder newBuilder(Event event) {
            return (Builder) ((Builder) f.toBuilder()).mergeFrom((Builder) event);
        }

        public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) GeneratedMessageLite.parseDelimitedFrom(f, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(f, byteString, extensionRegistryLite);
        }

        public static Event parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(f, bArr);
        }

        public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(f, bArr, extensionRegistryLite);
        }

        public static Event parseFrom(InputStream inputStream) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(f, inputStream);
        }

        public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(f, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(f, codedInputStream);
        }

        public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(f, codedInputStream, extensionRegistryLite);
        }
    }

    public interface EventOrBuilder extends MessageLiteOrBuilder {
        boolean containsEnv(String str);

        boolean containsParams(String str);

        @Deprecated
        Map<String, String> getEnv();

        int getEnvCount();

        Map<String, String> getEnvMap();

        String getEnvOrDefault(String str, String str2);

        String getEnvOrThrow(String str);

        int getEventId();

        @Deprecated
        Map<String, String> getParams();

        int getParamsCount();

        Map<String, String> getParamsMap();

        String getParamsOrDefault(String str, String str2);

        String getParamsOrThrow(String str);

        int getVersion();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
