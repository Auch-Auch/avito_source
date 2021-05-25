package com.avito.android.developments_catalog.items.description;

import com.avito.android.advert_core.advert.DescriptionListener;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/developments_catalog/items/description/DescriptionPresenterImpl;", "Lcom/avito/android/developments_catalog/items/description/DescriptionPresenter;", "Lcom/avito/android/advert_core/advert/DescriptionListener;", "Lcom/avito/android/developments_catalog/items/description/DescriptionView;", "view", "Lcom/avito/android/developments_catalog/items/description/DescriptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/developments_catalog/items/description/DescriptionView;Lcom/avito/android/developments_catalog/items/description/DescriptionItem;I)V", "", "category", "onDescriptionExpanded", "(Ljava/lang/String;)V", "onDescriptionExpandExist", "()V", "onDescriptionCopy", "", AuthSource.SEND_ABUSE, "J", "stateId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/developments_catalog/items/description/DescriptionView;", "descriptionView", "Lcom/avito/android/developments_catalog/items/description/DescriptionExpandListener;", "c", "Lcom/avito/android/developments_catalog/items/description/DescriptionExpandListener;", "descriptionExpandListener", "<init>", "(Lcom/avito/android/developments_catalog/items/description/DescriptionExpandListener;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DescriptionPresenterImpl implements DescriptionPresenter, DescriptionListener {
    public long a;
    public DescriptionView b;
    public final DescriptionExpandListener c;

    @Inject
    public DescriptionPresenterImpl(@NotNull DescriptionExpandListener descriptionExpandListener) {
        Intrinsics.checkNotNullParameter(descriptionExpandListener, "descriptionExpandListener");
        this.c = descriptionExpandListener;
    }

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionCopy() {
    }

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionExpandExist() {
    }

    @Override // com.avito.android.advert_core.advert.DescriptionListener
    public void onDescriptionExpanded(@Nullable String str) {
        DescriptionExpandListener descriptionExpandListener = this.c;
        long j = this.a;
        DescriptionView descriptionView = this.b;
        descriptionExpandListener.onDescriptionExpanded(j, descriptionView != null ? descriptionView.onSaveState() : null);
    }

    public void bindView(@NotNull DescriptionView descriptionView, @NotNull DescriptionItem descriptionItem, int i) {
        Intrinsics.checkNotNullParameter(descriptionView, "view");
        Intrinsics.checkNotNullParameter(descriptionItem, "item");
        this.a = descriptionItem.getStateId();
        this.b = descriptionView;
        descriptionView.showDescription(descriptionItem.getDescription(), descriptionItem.getState(), this);
    }
}
