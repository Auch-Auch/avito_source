package com.avito.android.serp.adapter.map_banner;

import android.net.Uri;
import com.avito.konveyor.blueprint.ItemView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/map_banner/MapBannerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Landroid/net/Uri;", "darkMapScreenUri", "lightMapScreenUri", "", "setImage", "(Landroid/net/Uri;Landroid/net/Uri;)V", "", "buttonText", "setButtonText", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "getMapImageClicks", "()Lio/reactivex/rxjava3/core/Observable;", "mapImageClicks", "getButtonClicks", "buttonClicks", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface MapBannerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MapBannerItemView mapBannerItemView) {
            ItemView.DefaultImpls.onUnbind(mapBannerItemView);
        }
    }

    @NotNull
    Observable<Unit> getButtonClicks();

    @NotNull
    Observable<Unit> getMapImageClicks();

    void setButtonText(@Nullable String str);

    void setImage(@Nullable Uri uri, @Nullable Uri uri2);
}
