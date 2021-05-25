package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.n.r;
import t6.r.a.j;
public final class JavaTypeEnhancementState {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final JavaTypeEnhancementState DEFAULT;
    @JvmField
    @NotNull
    public static final ReportLevel DEFAULT_REPORT_LEVEL_FOR_JSPECIFY;
    @JvmField
    @NotNull
    public static final JavaTypeEnhancementState DISABLED_JSR_305;
    @JvmField
    @NotNull
    public static final JavaTypeEnhancementState STRICT;
    @NotNull
    public final ReportLevel a;
    @Nullable
    public final ReportLevel b;
    @NotNull
    public final Map<String, ReportLevel> c;
    public final boolean d;
    @NotNull
    public final ReportLevel e;
    @NotNull
    public final Lazy f;
    public final boolean g;
    public final boolean h;

    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<String[]> {
        public final /* synthetic */ JavaTypeEnhancementState a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JavaTypeEnhancementState javaTypeEnhancementState) {
            super(0);
            this.a = javaTypeEnhancementState;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String[] invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.a.getGlobalJsr305Level().getDescription());
            ReportLevel migrationLevelForJsr305 = this.a.getMigrationLevelForJsr305();
            if (migrationLevelForJsr305 != null) {
                arrayList.add(Intrinsics.stringPlus("under-migration:", migrationLevelForJsr305.getDescription()));
            }
            for (Map.Entry<String, ReportLevel> entry : this.a.getUserDefinedLevelForSpecificJsr305Annotation().entrySet()) {
                StringBuilder I = a2.b.a.a.a.I('@');
                I.append(entry.getKey());
                I.append(':');
                I.append(entry.getValue().getDescription());
                arrayList.add(I.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
    }

    static {
        ReportLevel reportLevel = ReportLevel.WARN;
        DEFAULT_REPORT_LEVEL_FOR_JSPECIFY = reportLevel;
        DEFAULT = new JavaTypeEnhancementState(reportLevel, null, r.emptyMap(), false, null, 24, null);
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        DISABLED_JSR_305 = new JavaTypeEnhancementState(reportLevel2, reportLevel2, r.emptyMap(), false, null, 24, null);
        ReportLevel reportLevel3 = ReportLevel.STRICT;
        STRICT = new JavaTypeEnhancementState(reportLevel3, reportLevel3, r.emptyMap(), false, null, 24, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<java.lang.String, ? extends kotlin.reflect.jvm.internal.impl.utils.ReportLevel> */
    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(@NotNull ReportLevel reportLevel, @Nullable ReportLevel reportLevel2, @NotNull Map<String, ? extends ReportLevel> map, boolean z, @NotNull ReportLevel reportLevel3) {
        Intrinsics.checkNotNullParameter(reportLevel, "globalJsr305Level");
        Intrinsics.checkNotNullParameter(map, "userDefinedLevelForSpecificJsr305Annotation");
        Intrinsics.checkNotNullParameter(reportLevel3, "jspecifyReportLevel");
        this.a = reportLevel;
        this.b = reportLevel2;
        this.c = map;
        this.d = z;
        this.e = reportLevel3;
        this.f = c.lazy(new a(this));
        ReportLevel reportLevel4 = ReportLevel.IGNORE;
        boolean z2 = true;
        boolean z3 = reportLevel == reportLevel4 && reportLevel2 == reportLevel4 && map.isEmpty();
        this.g = z3;
        if (!z3 && reportLevel3 != reportLevel4) {
            z2 = false;
        }
        this.h = z2;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.h;
    }

    public final boolean getDisabledJsr305() {
        return this.g;
    }

    public final boolean getEnableCompatqualCheckerFrameworkAnnotations() {
        return this.d;
    }

    @NotNull
    public final ReportLevel getGlobalJsr305Level() {
        return this.a;
    }

    @NotNull
    public final ReportLevel getJspecifyReportLevel() {
        return this.e;
    }

    @Nullable
    public final ReportLevel getMigrationLevelForJsr305() {
        return this.b;
    }

    @NotNull
    public final Map<String, ReportLevel> getUserDefinedLevelForSpecificJsr305Annotation() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeEnhancementState(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, boolean z, ReportLevel reportLevel3, int i, j jVar) {
        this(reportLevel, reportLevel2, map, (i & 8) != 0 ? true : z, (i & 16) != 0 ? DEFAULT_REPORT_LEVEL_FOR_JSPECIFY : reportLevel3);
    }
}
