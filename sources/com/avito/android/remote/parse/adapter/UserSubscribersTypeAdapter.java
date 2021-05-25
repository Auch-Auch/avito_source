package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.subscriber.SubscriberItem;
import com.avito.android.remote.model.subscriber.UserSubscribersResultItem;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR.\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/parse/adapter/UserSubscribersTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/subscriber/UserSubscribersResultItem;", "", "", "Ljava/lang/Class;", "Lcom/avito/android/remote/model/subscriber/SubscriberItem;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class UserSubscribersTypeAdapter extends RuntimeTypeAdapter<UserSubscribersResultItem> {
    @NotNull
    public final Map<String, Class<SubscriberItem>> a = q.mapOf(TuplesKt.to("subscriber", SubscriberItem.class));

    public UserSubscribersTypeAdapter() {
        super(null, null, null, 7, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Class<SubscriberItem>> getMapping() {
        return this.a;
    }
}
