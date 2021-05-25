package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendErrorValue;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR0\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/PretendResultTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/PretendErrorValue;", "", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PretendResultTypeAdapter extends RuntimeTypeAdapter<PretendErrorValue> {
    @NotNull
    public final Map<String, Class<? extends PretendErrorValue>> a = r.mapOf(TuplesKt.to("objects", PretendErrorValue.ObjectsMessages.class), TuplesKt.to("range", PretendErrorValue.FieldsMessages.class));

    public PretendResultTypeAdapter() {
        super(null, null, PretendErrorValue.Message.class, 3, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Class<? extends PretendErrorValue>> getMapping() {
        return this.a;
    }
}
