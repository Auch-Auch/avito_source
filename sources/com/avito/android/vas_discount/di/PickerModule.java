package com.avito.android.vas_discount.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.component.user_advert.SimpleUserAdvertItemClickListener;
import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.component.user_advert.UserAdvertItemListBlueprint;
import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import com.avito.android.component.user_advert.UserAdvertItemPresenterImpl;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitleBlueprint;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DiscountResponse;
import com.avito.android.vas_discount.business.DiscountToItemConverter;
import com.avito.android.vas_discount.business.DiscountToItemConverterImpl;
import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModel;
import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModelFactory;
import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModelImpl;
import com.avito.android.vas_discount.ui.items.button.ButtonItemBlueprint;
import com.avito.android.vas_discount.ui.items.button.ButtonItemPresenter;
import com.avito.android.vas_discount.ui.items.description.DescriptionItemBlueprint;
import com.avito.android.vas_discount.ui.items.description.DescriptionPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0010\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0010\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/vas_discount/di/PickerModule;", "", "Ldagger/Lazy;", "Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;", "provideUserAdvertPresenter", "(Ldagger/Lazy;)Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;", "Lcom/avito/android/remote/model/DiscountResponse;", "provideDiscountResponse", "()Lcom/avito/android/remote/model/DiscountResponse;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModel;", "provideViewModel", "(Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModel;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideUserAdvertItemListBlueprint", "(Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/bottom_sheet/title/TitlePresenter;", "provideTitlePresenter", "()Lcom/avito/android/conveyor_shared_item/bottom_sheet/title/TitlePresenter;", "provideTitleBlueprint", "(Lcom/avito/android/conveyor_shared_item/bottom_sheet/title/TitlePresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Landroidx/fragment/app/Fragment;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/Fragment;", "fragment", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/DiscountResponse;", "discountResponse", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/remote/model/DiscountResponse;)V", "Declarations", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class PickerModule {
    public final Fragment a;
    public final DiscountResponse b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0010\u001a\u00020\u0018H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H'¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/avito/android/vas_discount/di/PickerModule$Declarations;", "", "Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideUserAdvertPresenter", "(Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_discount/ui/items/description/DescriptionPresenter;", "descriptionPresenter", "provideDescriptionItemPresenter", "(Lcom/avito/android/vas_discount/ui/items/description/DescriptionPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_discount/ui/items/button/ButtonItemPresenter;", "buttonItemPresenter", "provideButtonPresenter", "(Lcom/avito/android/vas_discount/ui/items/button/ButtonItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_discount/ui/items/description/DescriptionItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideDescriptionBlueprint", "(Lcom/avito/android/vas_discount/ui/items/description/DescriptionItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/bottom_sheet/title/TitlePresenter;", "titlePresenter", "bindTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/bottom_sheet/title/TitlePresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_discount/ui/items/button/ButtonItemBlueprint;", "provideButtonItemBlueprint", "(Lcom/avito/android/vas_discount/ui/items/button/ButtonItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/vas_discount/business/DiscountToItemConverterImpl;", "discountToItemConverter", "Lcom/avito/android/vas_discount/business/DiscountToItemConverter;", "provideConverter", "(Lcom/avito/android/vas_discount/business/DiscountToItemConverterImpl;)Lcom/avito/android/vas_discount/business/DiscountToItemConverter;", "Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModelFactory;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/component/user_advert/SimpleUserAdvertItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "provideClickListener", "(Lcom/avito/android/component/user_advert/SimpleUserAdvertItemClickListener;)Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> bindTitlePresenter(@NotNull TitlePresenter titlePresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideButtonItemBlueprint(@NotNull ButtonItemBlueprint buttonItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideButtonPresenter(@NotNull ButtonItemPresenter buttonItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        UserAdvertItemClickListener provideClickListener(@NotNull SimpleUserAdvertItemClickListener simpleUserAdvertItemClickListener);

        @PerFragment
        @Binds
        @NotNull
        DiscountToItemConverter provideConverter(@NotNull DiscountToItemConverterImpl discountToItemConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideDescriptionBlueprint(@NotNull DescriptionItemBlueprint descriptionItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideDescriptionItemPresenter(@NotNull DescriptionPresenter descriptionPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideUserAdvertPresenter(@NotNull UserAdvertItemPresenter userAdvertItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull DiscountPickerViewModelFactory discountPickerViewModelFactory);
    }

    public PickerModule(@NotNull Fragment fragment, @NotNull DiscountResponse discountResponse) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(discountResponse, "discountResponse");
        this.a = fragment;
        this.b = discountResponse;
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiscountResponse provideDiscountResponse() {
        return this.b;
    }

    @Provides
    @IntoSet
    @NotNull
    @PerFragment
    public final ItemBlueprint<?, ?> provideTitleBlueprint(@NotNull TitlePresenter titlePresenter) {
        Intrinsics.checkNotNullParameter(titlePresenter, "presenter");
        return new TitleBlueprint(titlePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TitlePresenter provideTitlePresenter() {
        return new TitlePresenter();
    }

    @Provides
    @IntoSet
    @NotNull
    @PerFragment
    public final ItemBlueprint<?, ?> provideUserAdvertItemListBlueprint(@NotNull UserAdvertItemPresenter userAdvertItemPresenter) {
        Intrinsics.checkNotNullParameter(userAdvertItemPresenter, "presenter");
        return new UserAdvertItemListBlueprint(userAdvertItemPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final UserAdvertItemPresenter provideUserAdvertPresenter(@NotNull Lazy<UserAdvertItemClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new UserAdvertItemPresenterImpl(lazy);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiscountPickerViewModel provideViewModel(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModel viewModel = ViewModelProviders.of(this.a, factory).get(DiscountPickerViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (DiscountPickerViewModel) viewModel;
    }
}
