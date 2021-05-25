package com.avito.android.ab_tests.models;

import com.avito.android.Features;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0018J;\u0010\f\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/avito/android/ab_tests/models/AbTestConfig;", "TEST", "SOURCE", "", "savedAbTest", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "testConfig", "", "remoteKey", "createAbTest", "(Ljava/lang/Object;Lcom/avito/android/Features;Lcom/avito/android/util/BuildInfo;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", "getOwner", "()Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", UrlParams.OWNER, "", "getConsistentWithinSession", "()Z", "consistentWithinSession", "getRemoteKey", "()Ljava/lang/String;", "OwnerUnit", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public interface AbTestConfig<TEST, SOURCE> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/ab_tests/models/AbTestConfig$OwnerUnit;", "", "<init>", "(Ljava/lang/String;I)V", "ADV", "AUTO", "AUTOTEKA", "BUYER_X", "DESIGN_SYSTEM", "GEO", "MESSENGER", "PERFORMANCE", "REAL_ESTATE", "SAFEDEAL", "SELLER_X", "TRUST_AND_SAFETY", "JOB", "IN_APP_CALLS", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
    public enum OwnerUnit {
        ADV,
        AUTO,
        AUTOTEKA,
        BUYER_X,
        DESIGN_SYSTEM,
        GEO,
        MESSENGER,
        PERFORMANCE,
        REAL_ESTATE,
        SAFEDEAL,
        SELLER_X,
        TRUST_AND_SAFETY,
        JOB,
        IN_APP_CALLS
    }

    TEST createAbTest(@Nullable SOURCE source, @NotNull Features features, @NotNull BuildInfo buildInfo, @Nullable Object obj, @NotNull String str);

    boolean getConsistentWithinSession();

    @NotNull
    OwnerUnit getOwner();

    @NotNull
    String getRemoteKey();
}
