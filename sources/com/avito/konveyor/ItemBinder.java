package com.avito.konveyor;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.blueprint.PayloadItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.avito.konveyor.blueprint.ViewTypeProvider;
import com.avito.konveyor.exception.ItemNotSupportedException;
import com.avito.konveyor.exception.ViewTypeCollisionException;
import com.avito.konveyor.validation.ValidationPolicy;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004:\u0001(J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016¢\u0006\u0004\b\u0019\u0010\u001eJ%\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00130\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010&¨\u0006)"}, d2 = {"Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "Lcom/avito/konveyor/blueprint/PayloadItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "getItemViewType", "(Lcom/avito/konveyor/blueprint/Item;)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Lkotlin/Function1;", "Landroid/view/View;", "inflateFunc", "buildViewHolder", "(Landroid/view/ViewGroup;ILkotlin/jvm/functions/Function1;)Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "getItemBluePrint", "(I)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "view", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;Lcom/avito/konveyor/blueprint/Item;I)V", "", "", "payloads", "(Lcom/avito/konveyor/blueprint/ItemView;Lcom/avito/konveyor/blueprint/Item;ILjava/util/List;)V", "Lcom/avito/konveyor/blueprint/ItemPresenter;", AuthSource.SEND_ABUSE, "(Lcom/avito/konveyor/blueprint/Item;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/konveyor/validation/ValidationPolicy;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/validation/ValidationPolicy;", "policy", "Ljava/util/List;", "itemBluePrints", "Builder", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public final class ItemBinder implements ViewHolderBuilder<BaseViewHolder>, ViewTypeProvider, PayloadItemPresenter<ItemView, Item> {
    public final List<ItemBlueprint<?, ?>> a;
    public final ValidationPolicy b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0004\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/konveyor/ItemBinder$Builder;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bluePrint", "registerItem", "(Lcom/avito/konveyor/blueprint/ItemBlueprint;)Lcom/avito/konveyor/ItemBinder$Builder;", "Lcom/avito/konveyor/validation/ValidationPolicy;", "validationPolicy", "setValidationPolicy", "(Lcom/avito/konveyor/validation/ValidationPolicy;)Lcom/avito/konveyor/ItemBinder$Builder;", "Lcom/avito/konveyor/ItemBinder;", "build", "()Lcom/avito/konveyor/ItemBinder;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/validation/ValidationPolicy;", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "itemBluePrints", "<init>", "()V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        public final List<ItemBlueprint<?, ?>> a = new ArrayList();
        public ValidationPolicy b = konveyorConfiguration.INSTANCE.getPolicy$konveyor_release();

        @NotNull
        public final ItemBinder build() {
            return new ItemBinder(this.a, this.b, null);
        }

        @NotNull
        public final Builder registerItem(@NotNull ItemBlueprint<?, ?> itemBlueprint) {
            Intrinsics.checkNotNullParameter(itemBlueprint, "bluePrint");
            this.a.add(itemBlueprint);
            return this;
        }

        @NotNull
        public final Builder setValidationPolicy(@NotNull ValidationPolicy validationPolicy) {
            Intrinsics.checkNotNullParameter(validationPolicy, "validationPolicy");
            this.b = validationPolicy;
            return this;
        }
    }

    public ItemBinder(List list, ValidationPolicy validationPolicy, j jVar) {
        this.a = list;
        this.b = validationPolicy;
    }

    public final ItemPresenter<ItemView, Item> a(Item item) {
        ItemBlueprint<?, ?> itemBlueprint;
        try {
            itemBlueprint = this.a.get(getItemViewType(item));
        } catch (Exception unused) {
            itemBlueprint = null;
        }
        if (itemBlueprint == null && this.b.getValidateEagerly()) {
            throw new ItemNotSupportedException(item);
        } else if (itemBlueprint != null) {
            return itemBlueprint.getPresenter();
        } else {
            return null;
        }
    }

    @Override // com.avito.konveyor.blueprint.ItemPresenter
    public void bindView(@NotNull ItemView itemView, @NotNull Item item, int i) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemPresenter<ItemView, Item> a3 = a(item);
        if (a3 != null) {
            a3.bindView(itemView, item, i);
        }
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.konveyor.blueprint.ViewHolderBuilder
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.konveyor.adapter.BaseViewHolder buildViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup r2, int r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends android.view.View> r4) {
        /*
            r1 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "inflateFunc"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List<com.avito.konveyor.blueprint.ItemBlueprint<?, ?>> r0 = r1.a     // Catch:{ Exception -> 0x0013 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ Exception -> 0x0013 }
            com.avito.konveyor.blueprint.ItemBlueprint r3 = (com.avito.konveyor.blueprint.ItemBlueprint) r3     // Catch:{ Exception -> 0x0013 }
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            if (r3 == 0) goto L_0x0035
            com.avito.konveyor.blueprint.ViewHolderBuilder$ViewHolderProvider r0 = r3.getViewHolderProvider()
            kotlin.jvm.functions.Function2 r0 = r0.getCreator()
            com.avito.konveyor.blueprint.ViewHolderBuilder$ViewHolderProvider r3 = r3.getViewHolderProvider()
            int r3 = r3.getLayoutId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r3 = r4.invoke(r3)
            java.lang.Object r2 = r0.invoke(r2, r3)
            com.avito.konveyor.adapter.BaseViewHolder r2 = (com.avito.konveyor.adapter.BaseViewHolder) r2
            return r2
        L_0x0035:
            com.avito.konveyor.validation.ValidationPolicy r3 = r1.b
            boolean r3 = r3.getValidateEagerly()
            if (r3 != 0) goto L_0x0043
            com.avito.konveyor.adapter.EmptyViewHolder r3 = new com.avito.konveyor.adapter.EmptyViewHolder
            r3.<init>(r2)
            return r3
        L_0x0043:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "View type is not supported"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.konveyor.ItemBinder.buildViewHolder(android.view.ViewGroup, int, kotlin.jvm.functions.Function1):com.avito.konveyor.adapter.BaseViewHolder");
    }

    @Nullable
    public final ItemBlueprint<?, ?> getItemBluePrint(int i) {
        if (i < this.a.size()) {
            return this.a.get(i);
        }
        return null;
    }

    @Override // com.avito.konveyor.blueprint.ViewTypeProvider
    public int getItemViewType(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.b.getValidateEagerly()) {
            List<ItemBlueprint<?, ?>> list = this.a;
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (t.isRelevantItem(item)) {
                    arrayList.add(t);
                }
            }
            if (arrayList.size() > 1) {
                throw new ViewTypeCollisionException(item);
            }
        }
        int i = 0;
        for (T t2 : this.a) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (t2.isRelevantItem(item)) {
                return i;
            }
            i = i2;
        }
        if (!this.b.getValidateEagerly()) {
            return -1;
        }
        throw new ItemNotSupportedException(item);
    }

    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public void bindView(@NotNull ItemView itemView, @NotNull Item item, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        ItemPresenter<ItemView, Item> a3 = a(item);
        if (a3 == null) {
            return;
        }
        if (!(!list.isEmpty()) || !(a3 instanceof PayloadItemPresenter)) {
            a3.bindView(itemView, item, i);
        } else {
            ((PayloadItemPresenter) a3).bindView(itemView, item, i, list);
        }
    }
}
