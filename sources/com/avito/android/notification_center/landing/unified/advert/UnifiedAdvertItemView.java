package com.avito.android.notification_center.landing.unified.advert;

import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rH&¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0014\u0010\u0006J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0018\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0006J\u001f\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "", "setAddress", "(Ljava/lang/String;)V", Sort.DISTANCE, "setDistance", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "isFavorite", "setIsFavorite", "(Z)V", "isViewed", "setIsViewed", "location", "setLocation", "price", "setPrice", "priceWithoutDiscount", "setAdvertPriceWithoutDiscount", "title", "setTitle", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setFavoriteClickListener", "setUnbindListener", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface UnifiedAdvertItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull UnifiedAdvertItemView unifiedAdvertItemView) {
            ItemView.DefaultImpls.onUnbind(unifiedAdvertItemView);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertListCard
    void setAddress(@Nullable String str);

    void setAdvertPriceWithoutDiscount(@Nullable String str);

    @Override // ru.avito.component.serp.SerpAdvertListCard
    void setClickListener(@Nullable Function0<Unit> function0);

    @Override // ru.avito.component.serp.SerpAdvertListCard
    void setDistance(@Nullable String str);

    void setFavoriteClickListener(@Nullable Function0<Unit> function0);

    void setImage(@NotNull Image image);

    void setIsFavorite(boolean z);

    void setIsViewed(boolean z);

    @Override // ru.avito.component.serp.SerpAdvertListCard
    void setLocation(@Nullable String str);

    void setPrice(@Nullable String str);

    @Override // ru.avito.component.serp.SerpAdvertListCard
    void setTitle(@NotNull String str);

    void setUnbindListener(@Nullable Function0<Unit> function0);
}
