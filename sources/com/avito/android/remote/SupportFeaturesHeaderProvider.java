package com.avito.android.remote;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.interceptor.HeaderProvider;
import com.avito.android.toggle.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/SupportFeaturesHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "", "isMandatory", "Z", "()Z", "getValue", "value", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class SupportFeaturesHeaderProvider implements HeaderProvider {
    @NotNull
    public final String a = "X-Supported-Features";
    public final Features b;

    public SupportFeaturesHeaderProvider(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = features;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @Nullable
    public String getValue() {
        boolean z;
        List<Feature<Object>> features = this.b.getFeatures();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = features.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t = next;
            String apiToggleId = t.getApiToggleId();
            if (!(apiToggleId == null || apiToggleId.length() == 0)) {
                if ((t.getValue() instanceof Boolean) && Intrinsics.areEqual(t.getValue(), Boolean.TRUE)) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Feature) it2.next()).getApiToggleId());
        }
        StringBuilder sb = new StringBuilder();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            if (!(sb.length() == 0)) {
                str = ';' + str;
            }
            sb.append(str);
            Intrinsics.checkNotNullExpressionValue(sb, "sb.append(if (sb.isEmpty()) id else \";$id\")");
        }
        if (sb.length() == 0) {
            z = true;
        }
        if (z) {
            return null;
        }
        return sb.toString();
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return false;
    }
}
