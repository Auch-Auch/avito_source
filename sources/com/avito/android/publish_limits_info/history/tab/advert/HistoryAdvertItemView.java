package com.avito.android.publish_limits_info.history.tab.advert;

import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "price", "setPrice", "hint", "setHint", "", "isAutoPublishing", "setAutoPublish", "(Z)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public interface HistoryAdvertItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull HistoryAdvertItemView historyAdvertItemView) {
            ItemView.DefaultImpls.onUnbind(historyAdvertItemView);
        }
    }

    void setAutoPublish(boolean z);

    void setHint(@NotNull String str);

    void setImage(@NotNull Picture picture);

    void setPrice(@NotNull String str);

    void setTitle(@NotNull String str);
}
