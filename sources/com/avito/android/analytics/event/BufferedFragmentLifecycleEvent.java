package com.avito.android.analytics.event;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\tR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/avito/android/analytics/event/BufferedFragmentLifecycleEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "", "toString", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getAction", "action", "", "Landroidx/fragment/app/Fragment;", "c", "Ljava/util/List;", "getFragments", "()Ljava/util/List;", "fragments", AuthSource.SEND_ABUSE, "getTab", "tab", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class BufferedFragmentLifecycleEvent implements FirebaseCrashlyticsEvent {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final List<Fragment> c;

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends androidx.fragment.app.Fragment> */
    /* JADX WARN: Multi-variable type inference failed */
    public BufferedFragmentLifecycleEvent(@NotNull String str, @NotNull String str2, @NotNull List<? extends Fragment> list) {
        a.c1(str, "tab", str2, "action", list, "fragments");
        this.a = str;
        this.b = str2;
        this.c = list;
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
    public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
        firebaseCrashlyticsEventTracker.trackEvent(toString());
    }

    @NotNull
    public final String getAction() {
        return this.b;
    }

    @NotNull
    public final List<Fragment> getFragments() {
        return this.c;
    }

    @NotNull
    public final String getTab() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Fragment> list = this.c;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getClass().getSimpleName());
        }
        sb.append(arrayList);
        sb.append(' ');
        sb.append(this.b);
        sb.append(" in ");
        return a.t(sb, this.a, " tab");
    }
}
