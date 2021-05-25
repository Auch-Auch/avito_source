package com.avito.android.ab_tests.groups;

import com.avito.android.ab_tests.models.RemoteNamingGroup;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/ab_tests/groups/FpsSlowdownTestGroup;", "", "Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "", "isAmbush", "()Z", "isConstantFpsDrop", "", "targetFps", "()I", "", "ambushStrength", "()J", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRemoteName", "()Ljava/lang/String;", "remoteName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "CONTROL", "CONSTANT_40", "CONSTANT_30", "CONSTANT_20", "RANDOM_2000", "RANDOM_1000", "RANDOM_500", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public enum FpsSlowdownTestGroup implements RemoteNamingGroup {
    NONE(""),
    CONTROL("control"),
    CONSTANT_40("constant40"),
    CONSTANT_30("constant30"),
    CONSTANT_20("constant20"),
    RANDOM_2000("random2000"),
    RANDOM_1000("random1000"),
    RANDOM_500("random500");
    
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            FpsSlowdownTestGroup.values();
            int[] iArr = new int[8];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[3] = 2;
            iArr[4] = 3;
            FpsSlowdownTestGroup.values();
            int[] iArr2 = new int[8];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[5] = 1;
            iArr2[6] = 2;
            iArr2[7] = 3;
        }
    }

    /* access modifiers changed from: public */
    FpsSlowdownTestGroup(String str) {
        this.a = str;
    }

    public final long ambushStrength() {
        int ordinal = ordinal();
        if (ordinal == 5) {
            return 2000;
        }
        if (ordinal != 6) {
            return ordinal != 7 ? 0 : 500;
        }
        return 1000;
    }

    @Override // com.avito.android.ab_tests.models.RemoteNamingGroup
    @NotNull
    public String getRemoteName() {
        return this.a;
    }

    public final boolean isAmbush() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new FpsSlowdownTestGroup[]{RANDOM_2000, RANDOM_1000, RANDOM_500}).contains(this);
    }

    public final boolean isConstantFpsDrop() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new FpsSlowdownTestGroup[]{CONSTANT_40, CONSTANT_30, CONSTANT_20}).contains(this);
    }

    public final int targetFps() {
        int ordinal = ordinal();
        if (ordinal == 2) {
            return 40;
        }
        if (ordinal != 3) {
            return ordinal != 4 ? Integer.MAX_VALUE : 20;
        }
        return 30;
    }
}
