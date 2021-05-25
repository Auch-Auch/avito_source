package com.avito.android.enabler;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.util.BuildInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitorImpl;", "Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitor;", "Lcom/avito/android/enabler/RemoteFeature;", "", "feature", "", "onTouched", "(Lcom/avito/android/enabler/RemoteFeature;)V", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "crashlytics", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "<init>", "(Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteFeaturesCrashlyticsMonitorImpl implements RemoteFeaturesCrashlyticsMonitor {
    private final BuildInfo buildInfo;
    private final FirebaseCrashlytics crashlytics;

    @Inject
    public RemoteFeaturesCrashlyticsMonitorImpl(@NotNull BuildInfo buildInfo2, @NotNull FirebaseCrashlytics firebaseCrashlytics) {
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "crashlytics");
        this.buildInfo = buildInfo2;
        this.crashlytics = firebaseCrashlytics;
    }

    @Override // com.avito.android.enabler.RemoteFeaturesCrashlyticsMonitor
    public void onTouched(@NotNull RemoteFeature<Object> remoteFeature) {
        String str;
        Intrinsics.checkNotNullParameter(remoteFeature, "feature");
        if (!Intrinsics.areEqual(remoteFeature.getValue(), remoteFeature.getOriginalValue())) {
            String string = this.crashlytics.getString("changedToggles");
            if (string == null) {
                string = "";
            }
            boolean z = true;
            List split$default = StringsKt__StringsKt.split$default((CharSequence) string, new char[]{';'}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : split$default) {
                if (!m.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            if (this.buildInfo.isDebug()) {
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (m.startsWith$default((String) it.next(), remoteFeature.getKey() + '=', false, 2, null)) {
                            z = false;
                            break;
                        }
                    }
                }
                if (!z) {
                    StringBuilder L = a.L("Changed toggles already contain ");
                    L.append(remoteFeature.getKey());
                    L.append("; ");
                    L.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(L.toString().toString());
                }
            }
            if (remoteFeature.getValue() instanceof Boolean) {
                Object value = remoteFeature.getValue();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                str = ((Boolean) value).booleanValue() ? "1" : "0";
            } else {
                str = remoteFeature.getValue().toString();
            }
            this.crashlytics.setString("changedToggles", CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.plus((Collection<? extends String>) arrayList, remoteFeature.getKey() + '=' + str), ";", null, null, 0, null, null, 62, null));
        }
    }
}
