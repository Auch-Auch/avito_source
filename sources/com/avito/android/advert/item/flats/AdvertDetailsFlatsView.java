package com.avito.android.advert.item.flats;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/flats/AdvertDetailsFlatsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "bindTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "setParameters", "(Ljava/util/List;)V", "applyClosedAdvert", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsFlatsView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsFlatsView advertDetailsFlatsView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsFlatsView);
        }
    }

    void applyClosedAdvert();

    void bindTitle(@Nullable AttributedText attributedText);

    void setParameters(@NotNull List<AdvertParameters.Parameter> list);
}
