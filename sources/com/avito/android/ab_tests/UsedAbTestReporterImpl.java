package com.avito.android.ab_tests;

import com.avito.android.ab_tests.models.RemoteNamingGroup;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/ab_tests/UsedAbTestReporterImpl;", "Lcom/avito/android/ab_tests/UsedAbTestReporter;", "", "testName", "Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "testGroup", "", "reportUsageTest", "(Ljava/lang/String;Lcom/avito/android/ab_tests/models/RemoteNamingGroup;)V", AuthSource.SEND_ABUSE, "()V", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "crashlytics", "", "Ljava/util/Map;", "usedTests", "<init>", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class UsedAbTestReporterImpl implements UsedAbTestReporter {
    public final Map<String, RemoteNamingGroup> a = new LinkedHashMap();
    public final FirebaseCrashlytics b;

    @Inject
    public UsedAbTestReporterImpl(@NotNull FirebaseCrashlytics firebaseCrashlytics) {
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "crashlytics");
        this.b = firebaseCrashlytics;
    }

    public final void a() {
        if (this.b.isInitialized()) {
            Map<String, RemoteNamingGroup> map = this.a;
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, RemoteNamingGroup> entry : map.entrySet()) {
                arrayList.add(entry.getKey() + '=' + entry.getValue().getRemoteName());
            }
            this.b.setString("usedTests", CollectionsKt___CollectionsKt.joinToString$default(arrayList, ";", null, null, 0, null, null, 62, null));
        }
    }

    @Override // com.avito.android.ab_tests.UsedAbTestReporter
    public synchronized void reportUsageTest(@NotNull String str, @NotNull RemoteNamingGroup remoteNamingGroup) {
        Intrinsics.checkNotNullParameter(str, "testName");
        Intrinsics.checkNotNullParameter(remoteNamingGroup, "testGroup");
        RemoteNamingGroup put = this.a.put(str, remoteNamingGroup);
        if (!Intrinsics.areEqual(remoteNamingGroup.getRemoteName(), put != null ? put.getRemoteName() : null)) {
            if (m.isBlank(remoteNamingGroup.getRemoteName())) {
                this.a.remove(str);
            }
            a();
        }
    }
}
