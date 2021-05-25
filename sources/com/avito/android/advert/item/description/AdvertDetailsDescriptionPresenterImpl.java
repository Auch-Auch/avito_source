package com.avito.android.advert.item.description;

import com.avito.android.advert_core.advert.DescriptionListener;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u001e\u0010\u0010J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionPresenterImpl;", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionPresenter;", "Lcom/avito/android/advert_core/advert/DescriptionListener;", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionView;", "view", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionView;Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;I)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDescriptionListener", "(Lcom/avito/android/advert_core/advert/DescriptionListener;)V", "onDescriptionExpandExist", "()V", "", "category", "onDescriptionExpanded", "(Ljava/lang/String;)V", "onDescriptionCopy", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/advert/DescriptionListener;", "descriptionListener", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;", "c", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionView;", "descriptionView", "<init>", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDescriptionPresenterImpl implements AdvertDetailsDescriptionPresenter, DescriptionListener {
    public DescriptionListener a;
    public AdvertDetailsDescriptionItem b;
    public AdvertDetailsDescriptionView c;

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionCopy() {
        DescriptionListener descriptionListener = this.a;
        if (descriptionListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionListener");
        }
        descriptionListener.onDescriptionCopy();
    }

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionExpandExist() {
        DescriptionListener descriptionListener = this.a;
        if (descriptionListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionListener");
        }
        descriptionListener.onDescriptionExpandExist();
    }

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionExpanded(@Nullable String str) {
        DescriptionListener descriptionListener = this.a;
        if (descriptionListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionListener");
        }
        descriptionListener.onDescriptionExpanded(str);
        AdvertDetailsDescriptionItem advertDetailsDescriptionItem = this.b;
        if (advertDetailsDescriptionItem != null) {
            AdvertDetailsDescriptionView advertDetailsDescriptionView = this.c;
            advertDetailsDescriptionItem.setExpandPanelState(advertDetailsDescriptionView != null ? advertDetailsDescriptionView.onSaveState() : null);
        }
    }

    @Override // com.avito.android.advert.item.description.AdvertDetailsDescriptionPresenter
    public void setDescriptionListener(@NotNull DescriptionListener descriptionListener) {
        Intrinsics.checkNotNullParameter(descriptionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = descriptionListener;
    }

    public void bindView(@NotNull AdvertDetailsDescriptionView advertDetailsDescriptionView, @NotNull AdvertDetailsDescriptionItem advertDetailsDescriptionItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsDescriptionView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsDescriptionItem, "item");
        this.b = advertDetailsDescriptionItem;
        this.c = advertDetailsDescriptionView;
        advertDetailsDescriptionView.showDescription(advertDetailsDescriptionItem, this);
        if (advertDetailsDescriptionItem.getClosedAdvert()) {
            advertDetailsDescriptionView.applyClosedAdvert();
        }
    }
}
