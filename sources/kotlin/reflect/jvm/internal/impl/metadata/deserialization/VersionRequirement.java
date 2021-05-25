package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class VersionRequirement {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final Version a;
    @NotNull
    public final ProtoBuf.VersionRequirement.VersionKind b;
    @NotNull
    public final DeprecationLevel c;
    @Nullable
    public final Integer d;
    @Nullable
    public final String e;

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3};

            static {
                ProtoBuf.VersionRequirement.Level.values();
            }
        }

        public Companion() {
        }

        @NotNull
        public final List<VersionRequirement> create(@NotNull MessageLite messageLite, @NotNull NameResolver nameResolver, @NotNull VersionRequirementTable versionRequirementTable) {
            List<Integer> list;
            Intrinsics.checkNotNullParameter(messageLite, "proto");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(versionRequirementTable, "table");
            if (messageLite instanceof ProtoBuf.Class) {
                list = ((ProtoBuf.Class) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Constructor) {
                list = ((ProtoBuf.Constructor) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Function) {
                list = ((ProtoBuf.Function) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Property) {
                list = ((ProtoBuf.Property) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.TypeAlias) {
                list = ((ProtoBuf.TypeAlias) messageLite).getVersionRequirementList();
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Unexpected declaration: ", messageLite.getClass()));
            }
            Intrinsics.checkNotNullExpressionValue(list, "ids");
            ArrayList arrayList = new ArrayList();
            for (Integer num : list) {
                Intrinsics.checkNotNullExpressionValue(num, "id");
                VersionRequirement create = create(num.intValue(), nameResolver, versionRequirementTable);
                if (create != null) {
                    arrayList.add(create);
                }
            }
            return arrayList;
        }

        public Companion(j jVar) {
        }

        @Nullable
        public final VersionRequirement create(int i, @NotNull NameResolver nameResolver, @NotNull VersionRequirementTable versionRequirementTable) {
            DeprecationLevel deprecationLevel;
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(versionRequirementTable, "table");
            ProtoBuf.VersionRequirement versionRequirement = versionRequirementTable.get(i);
            String str = null;
            if (versionRequirement == null) {
                return null;
            }
            Version decode = Version.Companion.decode(versionRequirement.hasVersion() ? Integer.valueOf(versionRequirement.getVersion()) : null, versionRequirement.hasVersionFull() ? Integer.valueOf(versionRequirement.getVersionFull()) : null);
            ProtoBuf.VersionRequirement.Level level = versionRequirement.getLevel();
            Intrinsics.checkNotNull(level);
            int ordinal = level.ordinal();
            if (ordinal == 0) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (ordinal == 1) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else if (ordinal == 2) {
                deprecationLevel = DeprecationLevel.HIDDEN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Integer valueOf = versionRequirement.hasErrorCode() ? Integer.valueOf(versionRequirement.getErrorCode()) : null;
            if (versionRequirement.hasMessage()) {
                str = nameResolver.getString(versionRequirement.getMessage());
            }
            ProtoBuf.VersionRequirement.VersionKind versionKind = versionRequirement.getVersionKind();
            Intrinsics.checkNotNullExpressionValue(versionKind, "info.versionKind");
            return new VersionRequirement(decode, versionKind, deprecationLevel, valueOf, str);
        }
    }

    public static final class Version {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @JvmField
        @NotNull
        public static final Version INFINITY = new Version(256, 256, 256);
        public final int a;
        public final int b;
        public final int c;

        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final Version decode(@Nullable Integer num, @Nullable Integer num2) {
                if (num2 != null) {
                    return new Version(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new Version(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return Version.INFINITY;
            }

            public Companion(j jVar) {
            }
        }

        public Version(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @NotNull
        public final String asString() {
            int i;
            StringBuilder sb;
            if (this.c == 0) {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append(FormatterType.defaultDecimalSeparator);
                i = this.b;
            } else {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append(FormatterType.defaultDecimalSeparator);
                sb.append(this.b);
                sb.append(FormatterType.defaultDecimalSeparator);
                i = this.c;
            }
            sb.append(i);
            return sb.toString();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Version)) {
                return false;
            }
            Version version = (Version) obj;
            return this.a == version.a && this.b == version.b && this.c == version.c;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        @NotNull
        public String toString() {
            return asString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Version(int i, int i2, int i3, int i4, j jVar) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public VersionRequirement(@NotNull Version version, @NotNull ProtoBuf.VersionRequirement.VersionKind versionKind, @NotNull DeprecationLevel deprecationLevel, @Nullable Integer num, @Nullable String str) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(versionKind, MessageBody.Location.KIND);
        Intrinsics.checkNotNullParameter(deprecationLevel, FirebaseAnalytics.Param.LEVEL);
        this.a = version;
        this.b = versionKind;
        this.c = deprecationLevel;
        this.d = num;
        this.e = str;
    }

    @NotNull
    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.b;
    }

    @NotNull
    public final Version getVersion() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("since ");
        L.append(this.a);
        L.append(' ');
        L.append(this.c);
        Integer num = this.d;
        String str = "";
        L.append(num != null ? Intrinsics.stringPlus(" error ", num) : str);
        String str2 = this.e;
        if (str2 != null) {
            str = Intrinsics.stringPlus(": ", str2);
        }
        L.append(str);
        return L.toString();
    }
}
