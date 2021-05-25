package com.avito.android.service.short_task;

import a2.b.a.a.a;
import android.os.Bundle;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/evernote/android/job/util/support/PersistableBundleCompat;", "Landroid/os/Bundle;", "toBundle", "(Lcom/evernote/android/job/util/support/PersistableBundleCompat;)Landroid/os/Bundle;", "toPersistableBundleCompat", "(Landroid/os/Bundle;)Lcom/evernote/android/job/util/support/PersistableBundleCompat;", "job-scheduler_release"}, k = 2, mv = {1, 4, 2})
public final class BundlesKt {
    @NotNull
    public static final Bundle toBundle(@NotNull PersistableBundleCompat persistableBundleCompat) {
        Intrinsics.checkNotNullParameter(persistableBundleCompat, "$this$toBundle");
        Set<String> keySet = persistableBundleCompat.keySet();
        Bundle bundle = new Bundle();
        Intrinsics.checkNotNullExpressionValue(keySet, "keySet");
        for (T t : keySet) {
            Object obj = persistableBundleCompat.get(t);
            if (obj instanceof String) {
                bundle.putString(t, (String) obj);
            } else if (obj instanceof Long) {
                bundle.putLong(t, ((Number) obj).longValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(t, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(t, ((Number) obj).intValue());
            } else {
                StringBuilder L = a.L("Error creating ");
                L.append(Bundle.class.getSimpleName());
                L.append(" from ");
                L.append(PersistableBundleCompat.class.getSimpleName());
                L.append(" due to unhandled ");
                L.append(obj.getClass().getSimpleName());
                L.append(" extra value.\n                    Add corresponding 'is'-check in 'when' expression.\n                ");
                throw new IllegalArgumentException(f.trimIndent(L.toString()));
            }
        }
        return bundle;
    }

    @NotNull
    public static final PersistableBundleCompat toPersistableBundleCompat(@NotNull Bundle bundle) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(bundle, "$this$toPersistableBundleCompat");
        Set<String> keySet = bundle.keySet();
        PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
        Intrinsics.checkNotNullExpressionValue(keySet, "keySet");
        for (T t : keySet) {
            Object obj = bundle.get(t);
            if (obj instanceof String) {
                persistableBundleCompat.putString(t, (String) obj);
            } else if (obj instanceof Long) {
                persistableBundleCompat.putLong(t, ((Number) obj).longValue());
            } else if (obj instanceof Boolean) {
                persistableBundleCompat.putBoolean(t, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                persistableBundleCompat.putInt(t, ((Number) obj).intValue());
            } else {
                StringBuilder L = a.L("Error creating ");
                L.append(PersistableBundleCompat.class.getSimpleName());
                L.append(" from ");
                L.append(Bundle.class.getSimpleName());
                L.append(" due to unhandled ");
                L.append((obj == null || (cls = obj.getClass()) == null) ? null : cls.getSimpleName());
                L.append(" extra value.\n                    Add corresponding 'is'-check in 'when' expression.\n                ");
                throw new IllegalArgumentException(f.trimIndent(L.toString()));
            }
        }
        return persistableBundleCompat;
    }
}
