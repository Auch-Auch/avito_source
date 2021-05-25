package com.avito.android.shop.list.presentation.item;

import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.shop.list.presentation.item.ShopItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shop.ShopListCard;
import ru.avito.component.shop.ShopListCardImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0018\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/shop/list/presentation/item/ShopItemViewImpl;", "Lcom/avito/android/shop/list/presentation/item/ShopItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/shop/ShopListCard;", "", "category", "", "setCategory", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "description", "setDescription", "", "isEnabled", "setEnabled", "(Z)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "title", "setTitle", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopItemViewImpl extends BaseViewHolder implements ShopItemView, ShopListCard {
    public final /* synthetic */ ShopListCardImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new ShopListCardImpl(view);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ShopItemView.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setCategory(@Nullable String str) {
        this.s.setCategory(str);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setClickListener(function0);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setDescription(@Nullable String str) {
        this.s.setDescription(str);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.s.setPicture(picture);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}
