package com.google.firebase.crashlytics.internal.model;

import a2.j.e.d.d.c.a;
import a2.j.e.d.d.c.b;
import a2.j.e.d.d.c.c;
import a2.j.e.d.d.c.d;
import a2.j.e.d.d.c.e;
import a2.j.e.d.d.c.f;
import a2.j.e.d.d.c.g;
import a2.j.e.d.d.c.h;
import a2.j.e.d.d.c.i;
import a2.j.e.d.d.c.j;
import a2.j.e.d.d.c.k;
import a2.j.e.d.d.c.l;
import a2.j.e.d.d.c.m;
import a2.j.e.d.d.c.n;
import a2.j.e.d.d.c.o;
import a2.j.e.d.d.c.p;
import a2.j.e.d.d.c.q;
import a2.j.e.d.d.c.r;
import a2.j.e.d.d.c.s;
import a2.j.e.d.d.c.t;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;
@AutoValue
@Encodable
public abstract class CrashlyticsReport {
    public static final Charset a = Charset.forName("UTF-8");

    @Retention(RetentionPolicy.SOURCE)
    public @interface Architecture {
        public static final int ARM64 = 9;
        public static final int ARMV6 = 5;
        public static final int ARMV7 = 6;
        public static final int UNKNOWN = 7;
        public static final int X86_32 = 0;
        public static final int X86_64 = 1;
    }

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract CrashlyticsReport build();

        @NonNull
        public abstract Builder setBuildVersion(@NonNull String str);

        @NonNull
        public abstract Builder setDisplayVersion(@NonNull String str);

        @NonNull
        public abstract Builder setGmpAppId(@NonNull String str);

        @NonNull
        public abstract Builder setInstallationUuid(@NonNull String str);

        @NonNull
        public abstract Builder setNdkPayload(FilesPayload filesPayload);

        @NonNull
        public abstract Builder setPlatform(int i);

        @NonNull
        public abstract Builder setSdkVersion(@NonNull String str);

        @NonNull
        public abstract Builder setSession(@NonNull Session session);
    }

    @AutoValue
    public static abstract class CustomAttribute {

        @AutoValue.Builder
        public static abstract class Builder {
            @NonNull
            public abstract CustomAttribute build();

            @NonNull
            public abstract Builder setKey(@NonNull String str);

            @NonNull
            public abstract Builder setValue(@NonNull String str);
        }

        @NonNull
        public static Builder builder() {
            return new b.C0079b();
        }

        @NonNull
        public abstract String getKey();

        @NonNull
        public abstract String getValue();
    }

    @AutoValue
    public static abstract class FilesPayload {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract FilesPayload build();

            public abstract Builder setFiles(ImmutableList<File> immutableList);

            public abstract Builder setOrgId(String str);
        }

        @AutoValue
        public static abstract class File {

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract File build();

                public abstract Builder setContents(byte[] bArr);

                public abstract Builder setFilename(String str);
            }

            @NonNull
            public static Builder builder() {
                return new d.b();
            }

            @NonNull
            public abstract byte[] getContents();

            @NonNull
            public abstract String getFilename();
        }

        @NonNull
        public static Builder builder() {
            return new c.b();
        }

        public abstract Builder a();

        @NonNull
        public abstract ImmutableList<File> getFiles();

        @Nullable
        public abstract String getOrgId();
    }

    @AutoValue
    public static abstract class Session {

        @AutoValue
        public static abstract class Application {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract Application build();

                @NonNull
                public abstract Builder setDisplayVersion(@NonNull String str);

                @NonNull
                public abstract Builder setIdentifier(@NonNull String str);

                @NonNull
                public abstract Builder setInstallationUuid(@NonNull String str);

                @NonNull
                public abstract Builder setOrganization(@NonNull Organization organization);

                @NonNull
                public abstract Builder setVersion(@NonNull String str);
            }

            @AutoValue
            public static abstract class Organization {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract Organization build();

                    @NonNull
                    public abstract Builder setClsId(@NonNull String str);
                }

                @NonNull
                public static Builder builder() {
                    return new g.b();
                }

                @NonNull
                public abstract String getClsId();

                @NonNull
                public abstract Builder toBuilder();
            }

            @NonNull
            public static Builder builder() {
                return new f.b();
            }

            @Nullable
            public abstract String getDisplayVersion();

            @NonNull
            public abstract String getIdentifier();

            @Nullable
            public abstract String getInstallationUuid();

            @Nullable
            public abstract Organization getOrganization();

            @NonNull
            public abstract String getVersion();

            @NonNull
            public abstract Builder toBuilder();
        }

        @AutoValue.Builder
        public static abstract class Builder {
            @NonNull
            public abstract Session build();

            @NonNull
            public abstract Builder setApp(@NonNull Application application);

            @NonNull
            public abstract Builder setCrashed(boolean z);

            @NonNull
            public abstract Builder setDevice(@NonNull Device device);

            @NonNull
            public abstract Builder setEndedAt(@NonNull Long l);

            @NonNull
            public abstract Builder setEvents(@NonNull ImmutableList<Event> immutableList);

            @NonNull
            public abstract Builder setGenerator(@NonNull String str);

            @NonNull
            public abstract Builder setGeneratorType(int i);

            @NonNull
            public abstract Builder setIdentifier(@NonNull String str);

            @NonNull
            public Builder setIdentifierFromUtf8Bytes(@NonNull byte[] bArr) {
                return setIdentifier(new String(bArr, CrashlyticsReport.a));
            }

            @NonNull
            public abstract Builder setOs(@NonNull OperatingSystem operatingSystem);

            @NonNull
            public abstract Builder setStartedAt(long j);

            @NonNull
            public abstract Builder setUser(@NonNull User user);
        }

        @AutoValue
        public static abstract class Device {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract Device build();

                @NonNull
                public abstract Builder setArch(int i);

                @NonNull
                public abstract Builder setCores(int i);

                @NonNull
                public abstract Builder setDiskSpace(long j);

                @NonNull
                public abstract Builder setManufacturer(@NonNull String str);

                @NonNull
                public abstract Builder setModel(@NonNull String str);

                @NonNull
                public abstract Builder setModelClass(@NonNull String str);

                @NonNull
                public abstract Builder setRam(long j);

                @NonNull
                public abstract Builder setSimulator(boolean z);

                @NonNull
                public abstract Builder setState(int i);
            }

            @NonNull
            public static Builder builder() {
                return new h.b();
            }

            @NonNull
            public abstract int getArch();

            public abstract int getCores();

            public abstract long getDiskSpace();

            @NonNull
            public abstract String getManufacturer();

            @NonNull
            public abstract String getModel();

            @NonNull
            public abstract String getModelClass();

            public abstract long getRam();

            public abstract int getState();

            public abstract boolean isSimulator();
        }

        @AutoValue
        public static abstract class Event {

            @AutoValue
            public static abstract class Application {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract Application build();

                    @NonNull
                    public abstract Builder setBackground(@Nullable Boolean bool);

                    @NonNull
                    public abstract Builder setCustomAttributes(@NonNull ImmutableList<CustomAttribute> immutableList);

                    @NonNull
                    public abstract Builder setExecution(@NonNull Execution execution);

                    @NonNull
                    public abstract Builder setUiOrientation(int i);
                }

                @AutoValue
                public static abstract class Execution {

                    @AutoValue
                    public static abstract class BinaryImage {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            @NonNull
                            public abstract BinaryImage build();

                            @NonNull
                            public abstract Builder setBaseAddress(long j);

                            @NonNull
                            public abstract Builder setName(@NonNull String str);

                            @NonNull
                            public abstract Builder setSize(long j);

                            @NonNull
                            public abstract Builder setUuid(@Nullable String str);

                            @NonNull
                            public Builder setUuidFromUtf8Bytes(@NonNull byte[] bArr) {
                                return setUuid(new String(bArr, CrashlyticsReport.a));
                            }
                        }

                        @NonNull
                        public static Builder builder() {
                            return new l.b();
                        }

                        @NonNull
                        public abstract long getBaseAddress();

                        @NonNull
                        public abstract String getName();

                        public abstract long getSize();

                        @Nullable
                        @Encodable.Ignore
                        public abstract String getUuid();

                        @Nullable
                        @Encodable.Field(name = "uuid")
                        public byte[] getUuidUtf8Bytes() {
                            String uuid = getUuid();
                            if (uuid != null) {
                                return uuid.getBytes(CrashlyticsReport.a);
                            }
                            return null;
                        }
                    }

                    @AutoValue.Builder
                    public static abstract class Builder {
                        @NonNull
                        public abstract Execution build();

                        @NonNull
                        public abstract Builder setBinaries(@NonNull ImmutableList<BinaryImage> immutableList);

                        @NonNull
                        public abstract Builder setException(@NonNull Exception exception);

                        @NonNull
                        public abstract Builder setSignal(@NonNull Signal signal);

                        @NonNull
                        public abstract Builder setThreads(@NonNull ImmutableList<Thread> immutableList);
                    }

                    @AutoValue
                    public static abstract class Exception {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            @NonNull
                            public abstract Exception build();

                            @NonNull
                            public abstract Builder setCausedBy(@NonNull Exception exception);

                            @NonNull
                            public abstract Builder setFrames(@NonNull ImmutableList<Thread.Frame> immutableList);

                            @NonNull
                            public abstract Builder setOverflowCount(int i);

                            @NonNull
                            public abstract Builder setReason(@NonNull String str);

                            @NonNull
                            public abstract Builder setType(@NonNull String str);
                        }

                        @NonNull
                        public static Builder builder() {
                            return new m.b();
                        }

                        @Nullable
                        public abstract Exception getCausedBy();

                        @NonNull
                        public abstract ImmutableList<Thread.Frame> getFrames();

                        public abstract int getOverflowCount();

                        @Nullable
                        public abstract String getReason();

                        @NonNull
                        public abstract String getType();
                    }

                    @AutoValue
                    public static abstract class Signal {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            @NonNull
                            public abstract Signal build();

                            @NonNull
                            public abstract Builder setAddress(long j);

                            @NonNull
                            public abstract Builder setCode(@NonNull String str);

                            @NonNull
                            public abstract Builder setName(@NonNull String str);
                        }

                        @NonNull
                        public static Builder builder() {
                            return new n.b();
                        }

                        @NonNull
                        public abstract long getAddress();

                        @NonNull
                        public abstract String getCode();

                        @NonNull
                        public abstract String getName();
                    }

                    @AutoValue
                    public static abstract class Thread {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            @NonNull
                            public abstract Thread build();

                            @NonNull
                            public abstract Builder setFrames(@NonNull ImmutableList<Frame> immutableList);

                            @NonNull
                            public abstract Builder setImportance(int i);

                            @NonNull
                            public abstract Builder setName(@NonNull String str);
                        }

                        @AutoValue
                        public static abstract class Frame {

                            @AutoValue.Builder
                            public static abstract class Builder {
                                @NonNull
                                public abstract Frame build();

                                @NonNull
                                public abstract Builder setFile(@NonNull String str);

                                @NonNull
                                public abstract Builder setImportance(int i);

                                @NonNull
                                public abstract Builder setOffset(long j);

                                @NonNull
                                public abstract Builder setPc(long j);

                                @NonNull
                                public abstract Builder setSymbol(@NonNull String str);
                            }

                            @NonNull
                            public static Builder builder() {
                                return new p.b();
                            }

                            @Nullable
                            public abstract String getFile();

                            public abstract int getImportance();

                            public abstract long getOffset();

                            public abstract long getPc();

                            @NonNull
                            public abstract String getSymbol();
                        }

                        @NonNull
                        public static Builder builder() {
                            return new o.b();
                        }

                        @NonNull
                        public abstract ImmutableList<Frame> getFrames();

                        public abstract int getImportance();

                        @NonNull
                        public abstract String getName();
                    }

                    @NonNull
                    public static Builder builder() {
                        return new k.b();
                    }

                    @NonNull
                    public abstract ImmutableList<BinaryImage> getBinaries();

                    @NonNull
                    public abstract Exception getException();

                    @NonNull
                    public abstract Signal getSignal();

                    @NonNull
                    public abstract ImmutableList<Thread> getThreads();
                }

                @NonNull
                public static Builder builder() {
                    return new j.b();
                }

                @Nullable
                public abstract Boolean getBackground();

                @Nullable
                public abstract ImmutableList<CustomAttribute> getCustomAttributes();

                @NonNull
                public abstract Execution getExecution();

                public abstract int getUiOrientation();

                @NonNull
                public abstract Builder toBuilder();
            }

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract Event build();

                @NonNull
                public abstract Builder setApp(@NonNull Application application);

                @NonNull
                public abstract Builder setDevice(@NonNull Device device);

                @NonNull
                public abstract Builder setLog(@NonNull Log log);

                @NonNull
                public abstract Builder setTimestamp(long j);

                @NonNull
                public abstract Builder setType(@NonNull String str);
            }

            @AutoValue
            public static abstract class Device {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract Device build();

                    @NonNull
                    public abstract Builder setBatteryLevel(Double d);

                    @NonNull
                    public abstract Builder setBatteryVelocity(int i);

                    @NonNull
                    public abstract Builder setDiskUsed(long j);

                    @NonNull
                    public abstract Builder setOrientation(int i);

                    @NonNull
                    public abstract Builder setProximityOn(boolean z);

                    @NonNull
                    public abstract Builder setRamUsed(long j);
                }

                @NonNull
                public static Builder builder() {
                    return new q.b();
                }

                @Nullable
                public abstract Double getBatteryLevel();

                public abstract int getBatteryVelocity();

                public abstract long getDiskUsed();

                public abstract int getOrientation();

                public abstract long getRamUsed();

                public abstract boolean isProximityOn();
            }

            @AutoValue
            public static abstract class Log {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract Log build();

                    @NonNull
                    public abstract Builder setContent(@NonNull String str);
                }

                @NonNull
                public static Builder builder() {
                    return new r.b();
                }

                @NonNull
                public abstract String getContent();
            }

            @NonNull
            public static Builder builder() {
                return new i.b();
            }

            @NonNull
            public abstract Application getApp();

            @NonNull
            public abstract Device getDevice();

            @Nullable
            public abstract Log getLog();

            public abstract long getTimestamp();

            @NonNull
            public abstract String getType();

            @NonNull
            public abstract Builder toBuilder();
        }

        @AutoValue
        public static abstract class OperatingSystem {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract OperatingSystem build();

                @NonNull
                public abstract Builder setBuildVersion(@NonNull String str);

                @NonNull
                public abstract Builder setJailbroken(boolean z);

                @NonNull
                public abstract Builder setPlatform(int i);

                @NonNull
                public abstract Builder setVersion(@NonNull String str);
            }

            @NonNull
            public static Builder builder() {
                return new s.b();
            }

            @NonNull
            public abstract String getBuildVersion();

            public abstract int getPlatform();

            @NonNull
            public abstract String getVersion();

            public abstract boolean isJailbroken();
        }

        @AutoValue
        public static abstract class User {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract User build();

                @NonNull
                public abstract Builder setIdentifier(@NonNull String str);
            }

            @NonNull
            public static Builder builder() {
                return new t.b();
            }

            @NonNull
            public abstract String getIdentifier();
        }

        @NonNull
        public static Builder builder() {
            e.b bVar = new e.b();
            bVar.setCrashed(false);
            return bVar;
        }

        @NonNull
        public abstract Application getApp();

        @Nullable
        public abstract Device getDevice();

        @Nullable
        public abstract Long getEndedAt();

        @Nullable
        public abstract ImmutableList<Event> getEvents();

        @NonNull
        public abstract String getGenerator();

        public abstract int getGeneratorType();

        @NonNull
        @Encodable.Ignore
        public abstract String getIdentifier();

        @NonNull
        @Encodable.Field(name = "identifier")
        public byte[] getIdentifierUtf8Bytes() {
            return getIdentifier().getBytes(CrashlyticsReport.a);
        }

        @Nullable
        public abstract OperatingSystem getOs();

        public abstract long getStartedAt();

        @Nullable
        public abstract User getUser();

        public abstract boolean isCrashed();

        @NonNull
        public abstract Builder toBuilder();
    }

    public enum Type {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    @NonNull
    public static Builder builder() {
        return new a.b();
    }

    @NonNull
    public abstract String getBuildVersion();

    @NonNull
    public abstract String getDisplayVersion();

    @NonNull
    public abstract String getGmpAppId();

    @NonNull
    public abstract String getInstallationUuid();

    @Nullable
    public abstract FilesPayload getNdkPayload();

    public abstract int getPlatform();

    @NonNull
    public abstract String getSdkVersion();

    @Nullable
    public abstract Session getSession();

    @Encodable.Ignore
    public Type getType() {
        if (getSession() != null) {
            return Type.JAVA;
        }
        if (getNdkPayload() != null) {
            return Type.NATIVE;
        }
        return Type.INCOMPLETE;
    }

    @NonNull
    public abstract Builder toBuilder();

    @NonNull
    public CrashlyticsReport withEvents(@NonNull ImmutableList<Session.Event> immutableList) {
        if (getSession() != null) {
            return toBuilder().setSession(getSession().toBuilder().setEvents(immutableList).build()).build();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    @NonNull
    public CrashlyticsReport withNdkPayload(@NonNull FilesPayload filesPayload) {
        return toBuilder().setSession(null).setNdkPayload(filesPayload).build();
    }

    @NonNull
    public CrashlyticsReport withOrganizationId(@NonNull String str) {
        Builder builder = toBuilder();
        FilesPayload ndkPayload = getNdkPayload();
        if (ndkPayload != null) {
            builder.setNdkPayload(ndkPayload.a().setOrgId(str).build());
        }
        Session session = getSession();
        if (session != null) {
            Session.Application app = session.getApp();
            Session.Application.Organization organization = app.getOrganization();
            builder.setSession(session.toBuilder().setApp(app.toBuilder().setOrganization((organization != null ? organization.toBuilder() : Session.Application.Organization.builder()).setClsId(str).build()).build()).build());
        }
        return builder.build();
    }

    @NonNull
    public CrashlyticsReport withSessionEndFields(long j, boolean z, @Nullable String str) {
        Builder builder = toBuilder();
        if (getSession() != null) {
            Session.Builder builder2 = getSession().toBuilder();
            builder2.setEndedAt(Long.valueOf(j));
            builder2.setCrashed(z);
            if (str != null) {
                builder2.setUser(Session.User.builder().setIdentifier(str).build()).build();
            }
            builder.setSession(builder2.build());
        }
        return builder.build();
    }
}
