package com.avito.android.shop_settings.blueprints.select;

import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem;
import com.avito.android.shop_settings.di.SelectItemClick;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItemPresenterImpl;", "Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItemPresenter;", "Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItemView;", "view", "Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItemView;Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "selectItemClickListener", "<init>", "(Lcom/jakewharton/rxrelay2/PublishRelay;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectItemPresenterImpl implements ShopSettingsSelectItemPresenter {
    public final PublishRelay<ShopSettingsSelectItem> a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ShopSettingsInputItem.State.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            ShopSettingsInputItem.State state = ShopSettingsInputItem.State.Error;
            iArr[0] = 1;
            ShopSettingsInputItem.State state2 = ShopSettingsInputItem.State.Warning;
            iArr[1] = 2;
            ShopSettingsInputItem.State state3 = ShopSettingsInputItem.State.Normal;
            iArr[2] = 3;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopSettingsSelectItemPresenterImpl a;
        public final /* synthetic */ ShopSettingsSelectItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopSettingsSelectItemPresenterImpl shopSettingsSelectItemPresenterImpl, ShopSettingsSelectItem shopSettingsSelectItem) {
            super(0);
            this.a = shopSettingsSelectItemPresenterImpl;
            this.b = shopSettingsSelectItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ ShopSettingsSelectItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ShopSettingsSelectItem shopSettingsSelectItem) {
            super(1);
            this.a = shopSettingsSelectItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            if (str2.length() == 0) {
                this.a.setValue(null);
                this.a.setParentValues(CollectionsKt__CollectionsKt.emptyList());
                this.a.setCurrentText("");
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ShopSettingsSelectItemPresenterImpl(@SelectItemClick @NotNull PublishRelay<ShopSettingsSelectItem> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "selectItemClickListener");
        this.a = publishRelay;
    }

    public void bindView(@NotNull ShopSettingsSelectItemView shopSettingsSelectItemView, @NotNull ShopSettingsSelectItem shopSettingsSelectItem, int i) {
        Intrinsics.checkNotNullParameter(shopSettingsSelectItemView, "view");
        Intrinsics.checkNotNullParameter(shopSettingsSelectItem, "item");
        shopSettingsSelectItemView.setTextChangeListener(null);
        shopSettingsSelectItemView.setTitle(shopSettingsSelectItem.getTitle());
        shopSettingsSelectItemView.setText(shopSettingsSelectItem.getCurrentText());
        Boolean value = shopSettingsSelectItem.getDidChange().getValue();
        int ordinal = shopSettingsSelectItem.getState().ordinal();
        if (ordinal == 0) {
            shopSettingsSelectItemView.showError(shopSettingsSelectItem.getSuggestion());
            Intrinsics.checkNotNullExpressionValue(value, "textDidChange");
            if (value.booleanValue()) {
                shopSettingsSelectItemView.setInputState(Input.Companion.getSTATE_NORMAL());
            }
        } else if (ordinal == 1) {
            shopSettingsSelectItemView.showWarning();
            Intrinsics.checkNotNullExpressionValue(value, "textDidChange");
            if (value.booleanValue()) {
                shopSettingsSelectItemView.setInputState(Input.Companion.getSTATE_NORMAL());
            }
        } else if (ordinal == 2) {
            shopSettingsSelectItemView.showNormal(shopSettingsSelectItem.getSuggestion());
        }
        shopSettingsSelectItemView.setEnabled(shopSettingsSelectItem.isModifiable());
        shopSettingsSelectItemView.setHint(shopSettingsSelectItem.getPlaceholder());
        if (shopSettingsSelectItem.isConfirmed()) {
            shopSettingsSelectItemView.setConfirmed(!value.booleanValue());
        } else {
            shopSettingsSelectItemView.setConfirmed(false);
        }
        shopSettingsSelectItemView.setOnClickListener(new a(this, shopSettingsSelectItem));
        shopSettingsSelectItemView.setTextChangeListener(new b(shopSettingsSelectItem));
    }
}
