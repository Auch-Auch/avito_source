package com.avito.android.rating.publish.select_advert.adapter;

import com.avito.android.rating.publish.select_advert.adapter.advert.AdvertItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction;", "", "<init>", "()V", "AdvertItemClick", "RefreshClick", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction$AdvertItemClick;", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction$RefreshClick;", "rating_release"}, k = 1, mv = {1, 4, 2})
public abstract class SelectAdvertAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction$AdvertItemClick;", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction;", "Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItem;", "getAdvertItem", "()Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItem;", "advertItem", "<init>", "(Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItem;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertItemClick extends SelectAdvertAction {
        @NotNull
        public final AdvertItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdvertItemClick(@NotNull AdvertItem advertItem) {
            super(null);
            Intrinsics.checkNotNullParameter(advertItem, "advertItem");
            this.a = advertItem;
        }

        @NotNull
        public final AdvertItem getAdvertItem() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction$RefreshClick;", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class RefreshClick extends SelectAdvertAction {
        public RefreshClick() {
            super(null);
        }
    }

    public SelectAdvertAction() {
    }

    public SelectAdvertAction(j jVar) {
    }
}
