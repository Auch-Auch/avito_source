package com.avito.android.basket_legacy.di.checkout;

import com.avito.android.basket_legacy.item.BasketItem;
import com.avito.android.basket_legacy.item.BasketItemBlueprint;
import com.avito.android.basket_legacy.item.BasketItemPresenter;
import com.avito.android.basket_legacy.item.BasketItemView;
import com.avito.android.basket_legacy.item.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.basket_legacy.item.header.HeaderItem;
import com.avito.android.basket_legacy.item.header.HeaderItemBlueprint;
import com.avito.android.basket_legacy.item.header.HeaderItemPresenter;
import com.avito.android.basket_legacy.item.header.HeaderItemView;
import com.avito.android.basket_legacy.item.total.TotalItem;
import com.avito.android.basket_legacy.item.total.TotalItemBlueprint;
import com.avito.android.basket_legacy.item.total.TotalItemPresenter;
import com.avito.android.basket_legacy.item.total.TotalItemView;
import com.avito.android.component.disclaimer.DisclaimerItem;
import com.avito.android.component.disclaimer.DisclaimerItemPresenter;
import com.avito.android.component.disclaimer.DisclaimerViewHolder;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonItem;
import ru.avito.component.button.ButtonItemPresenter;
import ru.avito.component.button.ButtonViewHolder;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutUiModule;", "", "Lru/avito/component/button/ButtonItemPresenter;", "provideButtonItemPresenter$basket_release", "()Lru/avito/component/button/ButtonItemPresenter;", "provideButtonItemPresenter", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinkClickListener", "Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;", "provideDisclaimerItemPresenter$basket_release", "(Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;", "provideDisclaimerItemPresenter", "<init>", "()V", "Declarations", "basket_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, AttributedTextFormatterModule.class, Declarations.class})
public final class LegacyCheckoutUiModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\t2\u0006\u0010\u0012\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\t2\u0006\u0010\u0012\u001a\u00020\u001fH'¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020$H'¢\u0006\u0004\b%\u0010&J#\u0010*\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0\t2\u0006\u0010\u0012\u001a\u00020'H'¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutUiModule$Declarations;", "", "Lcom/avito/android/basket_legacy/item/BasketItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideBasketItemBlueprint", "(Lcom/avito/android/basket_legacy/item/BasketItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/basket_legacy/item/BasketItemPresenter;", "basketItemPresenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket_legacy/item/BasketItemView;", "Lcom/avito/android/basket_legacy/item/BasketItem;", "provideBasketItemPresenter", "(Lcom/avito/android/basket_legacy/item/BasketItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket_legacy/item/header/HeaderItemBlueprint;", "provideHeaderItemBlueprint", "(Lcom/avito/android/basket_legacy/item/header/HeaderItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/basket_legacy/item/header/HeaderItemPresenter;", "presenter", "Lcom/avito/android/basket_legacy/item/header/HeaderItemView;", "Lcom/avito/android/basket_legacy/item/header/HeaderItem;", "provideHeaderItemPresenter", "(Lcom/avito/android/basket_legacy/item/header/HeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket_legacy/item/total/TotalItemBlueprint;", "provideTotalItemBlueprint", "(Lcom/avito/android/basket_legacy/item/total/TotalItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/basket_legacy/item/total/TotalItemPresenter;", "Lcom/avito/android/basket_legacy/item/total/TotalItemView;", "Lcom/avito/android/basket_legacy/item/total/TotalItem;", "provideTotalItemPresenter", "(Lcom/avito/android/basket_legacy/item/total/TotalItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lru/avito/component/button/ButtonItemPresenter;", "Lru/avito/component/button/ButtonViewHolder;", "Lru/avito/component/button/ButtonItem;", "provideButtonItemPresenter", "(Lru/avito/component/button/ButtonItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket_legacy/item/disclaimer/DisclaimerItemBlueprint;", "provideDisclaimerItemBlueprint", "(Lcom/avito/android/basket_legacy/item/disclaimer/DisclaimerItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;", "Lcom/avito/android/component/disclaimer/DisclaimerViewHolder;", "Lcom/avito/android/component/disclaimer/DisclaimerItem;", "provideDisclaimerItemPresenter", "(Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideBasketItemBlueprint(@NotNull BasketItemBlueprint basketItemBlueprint);

        @Binds
        @NotNull
        @PerFragment
        ItemPresenter<BasketItemView, BasketItem> provideBasketItemPresenter(@NotNull BasketItemPresenter basketItemPresenter);

        @Binds
        @NotNull
        @PerFragment
        ItemPresenter<ButtonViewHolder, ButtonItem> provideButtonItemPresenter(@NotNull ButtonItemPresenter buttonItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideDisclaimerItemBlueprint(@NotNull DisclaimerItemBlueprint disclaimerItemBlueprint);

        @Binds
        @NotNull
        @PerFragment
        ItemPresenter<DisclaimerViewHolder, DisclaimerItem> provideDisclaimerItemPresenter(@NotNull DisclaimerItemPresenter disclaimerItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideHeaderItemBlueprint(@NotNull HeaderItemBlueprint headerItemBlueprint);

        @Binds
        @NotNull
        @PerFragment
        ItemPresenter<HeaderItemView, HeaderItem> provideHeaderItemPresenter(@NotNull HeaderItemPresenter headerItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideTotalItemBlueprint(@NotNull TotalItemBlueprint totalItemBlueprint);

        @Binds
        @NotNull
        @PerFragment
        ItemPresenter<TotalItemView, TotalItem> provideTotalItemPresenter(@NotNull TotalItemPresenter totalItemPresenter);
    }

    public static final class a extends Lambda implements Function1<String, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            return Unit.INSTANCE;
        }
    }

    @Provides
    @PerFragment
    @NotNull
    public final ButtonItemPresenter provideButtonItemPresenter$basket_release() {
        return new ButtonItemPresenter(a.a);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DisclaimerItemPresenter provideDisclaimerItemPresenter$basket_release(@NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, "deepLinkClickListener");
        return new DisclaimerItemPresenter(onDeepLinkClickListener);
    }
}
