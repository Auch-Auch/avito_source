package com.avito.android.delivery.map.point_info.konveyor.service.multiple;

import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "label", "setLabel", "(Ljava/lang/String;)V", "", "subtitles", "setSubtitles", "(Ljava/util/List;)V", "id", "Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "setClickConsumer", "(Ljava/lang/String;Lio/reactivex/rxjava3/functions/Consumer;)V", "", "selected", "setSelected", "(Z)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface MultiServiceItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MultiServiceItemView multiServiceItemView) {
            ItemView.DefaultImpls.onUnbind(multiServiceItemView);
        }
    }

    void setClickConsumer(@NotNull String str, @NotNull Consumer<String> consumer);

    void setLabel(@Nullable String str);

    void setSelected(boolean z);

    void setSubtitles(@NotNull List<AttributedText> list);

    void setTitle(@NotNull AttributedText attributedText);
}
