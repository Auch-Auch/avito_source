package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.delivery.Overlay;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR.\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/parse/adapter/OverlayTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/delivery/Overlay;", "", "", "Ljava/lang/Class;", "Lcom/avito/android/remote/model/delivery/Overlay$Label;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class OverlayTypeAdapter extends RuntimeTypeAdapter<Overlay> {
    @NotNull
    public final Map<String, Class<Overlay.Label>> a = q.mapOf(TuplesKt.to("label", Overlay.Label.class));

    public OverlayTypeAdapter() {
        super(null, "content", null, 5, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Class<Overlay.Label>> getMapping() {
        return this.a;
    }
}
