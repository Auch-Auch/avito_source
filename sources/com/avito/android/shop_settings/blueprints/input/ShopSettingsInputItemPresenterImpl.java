package com.avito.android.shop_settings.blueprints.input;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemPresenterImpl;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemPresenter;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemView;", "view", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItemView;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem;I)V", "<init>", "()V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsInputItemPresenterImpl implements ShopSettingsInputItemPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            ShopSettingsInputItem.State.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            iArr2[2] = 3;
        }
    }

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ ShopSettingsInputItemPresenterImpl a;
        public final /* synthetic */ ShopSettingsInputItemView b;
        public final /* synthetic */ ShopSettingsInputItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopSettingsInputItemPresenterImpl shopSettingsInputItemPresenterImpl, ShopSettingsInputItemView shopSettingsInputItemView, ShopSettingsInputItem shopSettingsInputItem) {
            super(1);
            this.a = shopSettingsInputItemPresenterImpl;
            this.b = shopSettingsInputItemView;
            this.c = shopSettingsInputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            ShopSettingsInputItemPresenterImpl.access$onTextChange(this.a, this.b, this.c, str2);
            return Unit.INSTANCE;
        }
    }

    public static final void access$onTextChange(ShopSettingsInputItemPresenterImpl shopSettingsInputItemPresenterImpl, ShopSettingsInputItemView shopSettingsInputItemView, ShopSettingsInputItem shopSettingsInputItem, String str) {
        Objects.requireNonNull(shopSettingsInputItemPresenterImpl);
        shopSettingsInputItem.setCurrentText(str);
        Boolean value = shopSettingsInputItem.getDidChange().getValue();
        Intrinsics.checkNotNullExpressionValue(value, "textDidChange");
        if (value.booleanValue()) {
            shopSettingsInputItemView.setInputState(Input.Companion.getSTATE_NORMAL());
        } else {
            int ordinal = shopSettingsInputItem.getState().ordinal();
            if (ordinal == 0) {
                shopSettingsInputItemView.setInputState(Input.Companion.getSTATE_ERROR());
            } else if (ordinal == 1) {
                shopSettingsInputItemView.setInputState(Input.Companion.getSTATE_WARNING());
            } else if (ordinal == 2) {
                shopSettingsInputItemView.setInputState(Input.Companion.getSTATE_NORMAL());
            }
        }
        if (shopSettingsInputItem.isConfirmed()) {
            shopSettingsInputItemView.setConfirmed(!value.booleanValue());
        }
    }

    public void bindView(@NotNull ShopSettingsInputItemView shopSettingsInputItemView, @NotNull ShopSettingsInputItem shopSettingsInputItem, int i) {
        Intrinsics.checkNotNullParameter(shopSettingsInputItemView, "view");
        Intrinsics.checkNotNullParameter(shopSettingsInputItem, "item");
        shopSettingsInputItemView.setTextChangeListener(null);
        shopSettingsInputItemView.setFormatterType(FormatterType.Companion.getSIMPLE());
        shopSettingsInputItemView.setTitle(shopSettingsInputItem.getTitle());
        shopSettingsInputItemView.setText(shopSettingsInputItem.getCurrentText());
        Boolean value = shopSettingsInputItem.getDidChange().getValue();
        int ordinal = shopSettingsInputItem.getState().ordinal();
        if (ordinal == 0) {
            shopSettingsInputItemView.showError(shopSettingsInputItem.getSuggestion());
            Intrinsics.checkNotNullExpressionValue(value, "textDidChange");
            if (value.booleanValue()) {
                shopSettingsInputItemView.setInputState(Input.Companion.getSTATE_NORMAL());
            }
        } else if (ordinal == 1) {
            shopSettingsInputItemView.showWarning();
            Intrinsics.checkNotNullExpressionValue(value, "textDidChange");
            if (value.booleanValue()) {
                shopSettingsInputItemView.setInputState(Input.Companion.getSTATE_NORMAL());
            }
        } else if (ordinal == 2) {
            shopSettingsInputItemView.showNormal(shopSettingsInputItem.getSuggestion());
        }
        shopSettingsInputItemView.setEnabled(shopSettingsInputItem.isModifiable());
        shopSettingsInputItemView.setHint(shopSettingsInputItem.getPlaceholder());
        if (shopSettingsInputItem.isConfirmed()) {
            shopSettingsInputItemView.setConfirmed(!value.booleanValue());
        } else {
            shopSettingsInputItemView.setConfirmed(false);
        }
        shopSettingsInputItemView.setFormatterType(shopSettingsInputItem.getFormatterType());
        shopSettingsInputItemView.setTextChangeListener(new a(this, shopSettingsInputItemView, shopSettingsInputItem));
    }
}
