package com.avito.android.publish.edit_advert_request.data;

import com.avito.android.Features;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.adverts.EditAdvertResult;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019Jo\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/data/EditAdvertCloudDataSource;", "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertDataSource;", "", "itemId", "categoryId", "", "navigation", "version", "postAction", "params", "publishSessionId", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/adverts/EditAdvertResult;", "editAdvertWithNavigation", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/PublishApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishApi;", "publishApi", "<init>", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/Features;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class EditAdvertCloudDataSource implements EditAdvertDataSource {
    public final PublishApi a;
    public final Features b;

    @Inject
    public EditAdvertCloudDataSource(@NotNull PublishApi publishApi, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = publishApi;
        this.b = features;
    }

    @Override // com.avito.android.publish.edit_advert_request.data.EditAdvertDataSource
    @NotNull
    public Observable<TypedResult<EditAdvertResult>> editAdvertWithNavigation(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map, @Nullable String str3, @Nullable String str4, @NotNull Map<String, String> map2, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        Intrinsics.checkNotNullParameter(map, "navigation");
        Intrinsics.checkNotNullParameter(map2, "params");
        Intrinsics.checkNotNullParameter(str5, "publishSessionId");
        if (this.b.getHtmlDescriptionOnPublish().invoke().booleanValue()) {
            return InteropKt.toV2(this.a.editItemV14(str, str2, map, str3, str4, map2, str5));
        }
        return InteropKt.toV2(this.a.editItemV13(str, str2, map, str3, str4, map2, str5));
    }
}
