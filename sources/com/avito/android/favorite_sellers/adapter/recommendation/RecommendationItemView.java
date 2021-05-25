package com.avito.android.favorite_sellers.adapter.recommendation;

import android.os.Parcelable;
import com.avito.android.favorite_sellers.RecommendationCarouselItem;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.data_source.DataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/favorite_sellers/RecommendationCarouselItem;", "dataSource", "setCarouselItems", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "", VKApiConst.POSITION, "notifyItemChanged", "(I)V", "scrollToNextItem", "()V", "Landroid/os/Parcelable;", "state", "restoreScrollState", "(Landroid/os/Parcelable;)V", "Lio/reactivex/rxjava3/core/Observable;", "getScrollStateUpdates", "()Lio/reactivex/rxjava3/core/Observable;", "scrollStateUpdates", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public interface RecommendationItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull RecommendationItemView recommendationItemView) {
            ItemView.DefaultImpls.onUnbind(recommendationItemView);
        }
    }

    @NotNull
    Observable<Parcelable> getScrollStateUpdates();

    void notifyItemChanged(int i);

    void restoreScrollState(@NotNull Parcelable parcelable);

    void scrollToNextItem();

    void setCarouselItems(@NotNull DataSource<RecommendationCarouselItem> dataSource);

    void setTitle(@Nullable CharSequence charSequence);

    void setUnbindListener(@Nullable Function0<Unit> function0);
}
