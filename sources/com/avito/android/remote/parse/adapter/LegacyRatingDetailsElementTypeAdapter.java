package com.avito.android.remote.parse.adapter;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.rating_details_legacy.ActionElement;
import com.avito.android.remote.model.rating_details_legacy.ButtonElement;
import com.avito.android.remote.model.rating_details_legacy.CommentElement;
import com.avito.android.remote.model.rating_details_legacy.RatingDetailsElement;
import com.avito.android.remote.model.rating_details_legacy.RatingScoreElement;
import com.avito.android.remote.model.rating_details_legacy.TextElement;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR0\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/LegacyRatingDetailsElementTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/rating_details_legacy/RatingDetailsElement;", "", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyRatingDetailsElementTypeAdapter extends RuntimeTypeAdapter<RatingDetailsElement> {
    @NotNull
    public final Map<String, Class<? extends RatingDetailsElement>> a = r.mapOf(TuplesKt.to("rating", CommentElement.class), TuplesKt.to("action", ActionElement.class), TuplesKt.to(PhonePageSourceKt.PHONE_SOURCE_BUTTON, ButtonElement.class), TuplesKt.to("text", TextElement.class), TuplesKt.to("score", RatingScoreElement.class));

    public LegacyRatingDetailsElementTypeAdapter() {
        super(null, null, null, 7, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Class<? extends RatingDetailsElement>> getMapping() {
        return this.a;
    }
}
