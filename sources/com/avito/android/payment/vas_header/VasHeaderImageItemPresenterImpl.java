package com.avito.android.payment.vas_header;

import com.avito.android.component.vas.VasHeaderViewHolder;
import com.avito.android.image_loader.AvitoPictureKt;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/vas_header/VasHeaderImageItemPresenterImpl;", "Lcom/avito/android/payment/vas_header/VasHeaderImageItemPresenter;", "Lcom/avito/android/component/vas/VasHeaderViewHolder;", "view", "Lcom/avito/android/payment/vas_header/VasHeaderImageItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/vas/VasHeaderViewHolder;Lcom/avito/android/payment/vas_header/VasHeaderImageItem;I)V", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class VasHeaderImageItemPresenterImpl implements VasHeaderImageItemPresenter {
    public void bindView(@NotNull VasHeaderViewHolder vasHeaderViewHolder, @NotNull VasHeaderImageItem vasHeaderImageItem, int i) {
        Intrinsics.checkNotNullParameter(vasHeaderViewHolder, "view");
        Intrinsics.checkNotNullParameter(vasHeaderImageItem, "item");
        vasHeaderViewHolder.setPicture(AvitoPictureKt.pictureOf$default(vasHeaderImageItem.getImage(), true, 0.0f, 0.0f, null, 28, null));
        vasHeaderViewHolder.setTitle(vasHeaderImageItem.getTitle());
        vasHeaderViewHolder.setSubtitle(vasHeaderImageItem.getSubtitle());
    }
}
