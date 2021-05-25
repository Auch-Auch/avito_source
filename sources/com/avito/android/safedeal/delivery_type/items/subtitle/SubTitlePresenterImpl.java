package com.avito.android.safedeal.delivery_type.items.subtitle;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitlePresenterImpl;", "Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitlePresenter;", "Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitleView;", "view", "Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitleItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitleView;Lcom/avito/android/safedeal/delivery_type/items/subtitle/SubTitleItem;I)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SubTitlePresenterImpl implements SubTitlePresenter {
    public final Context a;
    public final AttributedTextFormatter b;

    @Inject
    public SubTitlePresenterImpl(@NotNull Context context, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = context;
        this.b = attributedTextFormatter;
    }

    public void bindView(@NotNull SubTitleView subTitleView, @NotNull SubTitleItem subTitleItem, int i) {
        Intrinsics.checkNotNullParameter(subTitleView, "view");
        Intrinsics.checkNotNullParameter(subTitleItem, "item");
        subTitleView.setSubTitle(this.b.format(this.a, subTitleItem.getSubTitle()));
    }
}
