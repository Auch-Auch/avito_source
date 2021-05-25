package com.avito.android.select.title;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/select/title/TitleItemPresenterImpl;", "Lcom/avito/android/select/title/TitleItemPresenter;", "Lcom/avito/android/select/title/TitleItemView;", "view", "Lcom/avito/android/select/title/TitleItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/select/title/TitleItemView;Lcom/avito/android/select/title/TitleItem;I)V", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class TitleItemPresenterImpl implements TitleItemPresenter {
    public void bindView(@NotNull TitleItemView titleItemView, @NotNull TitleItem titleItem, int i) {
        Intrinsics.checkNotNullParameter(titleItemView, "view");
        Intrinsics.checkNotNullParameter(titleItem, "item");
        titleItemView.setTitle(titleItem.getTitle());
    }
}
