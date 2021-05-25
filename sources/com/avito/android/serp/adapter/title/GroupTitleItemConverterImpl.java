package com.avito.android.serp.adapter.title;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpAdvertGroupTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/title/GroupTitleItemConverterImpl;", "Lcom/avito/android/serp/adapter/title/GroupTitleItemConverter;", "Lcom/avito/android/remote/model/SerpAdvertGroupTitle;", "serpAdvertGroupTitle", "Lcom/avito/android/serp/adapter/title/GroupTitleItem;", "convert", "(Lcom/avito/android/remote/model/SerpAdvertGroupTitle;)Lcom/avito/android/serp/adapter/title/GroupTitleItem;", "", AuthSource.SEND_ABUSE, "I", "columnsCount", "<init>", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class GroupTitleItemConverterImpl implements GroupTitleItemConverter {
    public final int a;

    public GroupTitleItemConverterImpl(int i) {
        this.a = i;
    }

    @Override // com.avito.android.serp.adapter.title.GroupTitleItemConverter
    @NotNull
    public GroupTitleItem convert(@NotNull SerpAdvertGroupTitle serpAdvertGroupTitle) {
        Intrinsics.checkNotNullParameter(serpAdvertGroupTitle, "serpAdvertGroupTitle");
        String text = serpAdvertGroupTitle.getText();
        String str = text != null ? text : "";
        String text2 = serpAdvertGroupTitle.getText();
        long hashCode = (long) (text2 != null ? text2.hashCode() : 0);
        String text3 = serpAdvertGroupTitle.getText();
        if (text3 == null) {
            text3 = "";
        }
        return new GroupTitleItem(hashCode, text3, this.a, str);
    }
}
