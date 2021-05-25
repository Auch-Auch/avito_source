package com.avito.android.remote.parse.adapter;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.util.Collections;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SocialNetworkTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/social/SocialNetwork;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "", "", "Ljava/lang/reflect/Type;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "(Lcom/avito/android/Features;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class SocialNetworkTypeAdapter extends RuntimeTypeAdapter<SocialNetwork> {
    @NotNull
    public final Map<String, Type> a;
    public final Features b;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0066: APUT  
      (r0v2 kotlin.Pair[])
      (5 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0061: INVOKE  (r8v6 kotlin.Pair) = ("esia"), (r1v12 java.lang.Class<com.avito.android.remote.model.social.SocialNetwork$Esia>) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialNetworkTypeAdapter(@NotNull Features features) {
        super("type", null, null, 6, null);
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = features;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("fb", SocialNetwork.Facebook.class);
        pairArr[1] = TuplesKt.to("gp", SocialNetwork.Google.class);
        pairArr[2] = TuplesKt.to("ok", SocialNetwork.Odnoklassniki.class);
        pairArr[3] = TuplesKt.to("vk", SocialNetwork.Vkontakte.class);
        pairArr[4] = TuplesKt.to("apple", SocialNetwork.Apple.class);
        pairArr[5] = TuplesKt.to("esia", !features.getEsiaInProfile().invoke().booleanValue() ? null : SocialNetwork.Esia.class);
        this.a = Collections.filterValuesNotNull(r.mapOf(pairArr));
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Type> getMapping() {
        return this.a;
    }
}
