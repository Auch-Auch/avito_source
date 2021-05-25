package com.avito.android.component.vas;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/component/vas/VasHeaderItemPresenterImpl;", "Lcom/avito/android/component/vas/VasHeaderItemPresenter;", "Lcom/avito/android/component/vas/VasHeaderViewHolder;", "view", "Lcom/avito/android/component/vas/VasHeaderItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/vas/VasHeaderViewHolder;Lcom/avito/android/component/vas/VasHeaderItem;I)V", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class VasHeaderItemPresenterImpl implements VasHeaderItemPresenter {
    public void bindView(@NotNull VasHeaderViewHolder vasHeaderViewHolder, @NotNull VasHeaderItem vasHeaderItem, int i) {
        Intrinsics.checkNotNullParameter(vasHeaderViewHolder, "view");
        Intrinsics.checkNotNullParameter(vasHeaderItem, "item");
        vasHeaderViewHolder.setPicture(vasHeaderItem.getPicture());
        vasHeaderViewHolder.setTitle(vasHeaderItem.getTitle());
        if (vasHeaderItem.getSubtitle() == null) {
            vasHeaderViewHolder.setSubtitleVisible(false);
            return;
        }
        vasHeaderViewHolder.setSubtitleVisible(true);
        vasHeaderViewHolder.setSubtitle(vasHeaderItem.getSubtitle());
    }
}
