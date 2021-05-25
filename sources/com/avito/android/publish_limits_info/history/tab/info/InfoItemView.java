package com.avito.android.publish_limits_info.history.tab.info;

import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setDescription", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "setExtra", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public interface InfoItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull InfoItemView infoItemView) {
            ItemView.DefaultImpls.onUnbind(infoItemView);
        }
    }

    void setDescription(@Nullable String str);

    void setExtra(@Nullable AttributedText attributedText);
}
