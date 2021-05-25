package com.avito.android.short_term_rent.di.module;

import android.text.TextWatcher;
import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.ButtonItemPresenterImpl;
import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.blueprints.InputItemPresenterImpl;
import com.avito.android.conveyor_shared_item.notification.NotificationItemBlueprint;
import com.avito.android.conveyor_shared_item.notification.NotificationItemPresenter;
import com.avito.android.conveyor_shared_item.notification.NotificationItemPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.InputItemFormatterProviderModule;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel;
import com.avito.android.short_term_rent.confirm_booking.items.link.LinkItemBlueprint;
import com.avito.android.short_term_rent.confirm_booking.items.link.LinkItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemPresenter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b?\u0010@J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001c\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0001\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020$2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010-\u001a\u00020*H\u0001¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020*H\u0001¢\u0006\u0004\b.\u0010/J\u000f\u00104\u001a\u000201H\u0001¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u00020\f2\u0006\u0010\u001f\u001a\u000201H\u0001¢\u0006\u0004\b5\u00106J\u000f\u0010;\u001a\u000208H\u0001¢\u0006\u0004\b9\u0010:J\u0017\u0010>\u001a\u00020\n2\u0006\u0010\u001f\u001a\u000208H\u0001¢\u0006\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/StrConfirmBookingBlueprintsModule;", "", "Lcom/avito/android/blueprints/InputItemBlueprint;", "inputItemBlueprint", "Lcom/avito/android/conveyor_shared_item/notification/NotificationItemBlueprint;", "notificationItemBlueprint", "Lcom/avito/android/blueprints/ButtonItemBlueprint;", "buttonItemBlueprint", "Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemBlueprint;", "summaryItemBlueprint", "Lcom/avito/android/short_term_rent/confirm_booking/items/link/LinkItemBlueprint;", "linkItemBlueprint", "Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemBlueprint;", "disclaimerItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/blueprints/InputItemBlueprint;Lcom/avito/android/conveyor_shared_item/notification/NotificationItemBlueprint;Lcom/avito/android/blueprints/ButtonItemBlueprint;Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemBlueprint;Lcom/avito/android/short_term_rent/confirm_booking/items/link/LinkItemBlueprint;Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/android/blueprints/InputItemPresenter;", "inputItemPresenter", "provideInputItemBluePrint", "(Lcom/avito/android/blueprints/InputItemPresenter;)Lcom/avito/android/blueprints/InputItemBlueprint;", "Ldagger/Lazy;", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/text/TextWatcher;", "phoneTextWatcher", "Lcom/avito/android/provider/InputItemFormatterProvider;", "formatterProvider", "provideInputItemPresenter", "(Ldagger/Lazy;Landroid/text/TextWatcher;Lcom/avito/android/provider/InputItemFormatterProvider;)Lcom/avito/android/blueprints/InputItemPresenter;", "Lcom/avito/android/conveyor_shared_item/notification/NotificationItemPresenter;", "presenter", "provideNotificationItemBlueprint", "(Lcom/avito/android/conveyor_shared_item/notification/NotificationItemPresenter;)Lcom/avito/android/conveyor_shared_item/notification/NotificationItemBlueprint;", "provideNotificationItemPresenter", "()Lcom/avito/android/conveyor_shared_item/notification/NotificationItemPresenter;", "Lcom/avito/android/blueprints/ButtonItemPresenter;", "buttonItemPresenter", "provideButtonBlueprint", "(Lcom/avito/android/blueprints/ButtonItemPresenter;)Lcom/avito/android/blueprints/ButtonItemBlueprint;", "provideButtonItemPresenter", "(Ldagger/Lazy;)Lcom/avito/android/blueprints/ButtonItemPresenter;", "Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemPresenter;", "provideSummaryItemPresenter$short_term_rent_release", "()Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemPresenter;", "provideSummaryItemPresenter", "provideSummaryItemBlueprint$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemPresenter;)Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemBlueprint;", "provideSummaryItemBlueprint", "Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemPresenter;", "provideDisclaimerItemPresenter$short_term_rent_release", "()Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemPresenter;", "provideDisclaimerItemPresenter", "provideDisclaimerItemBlueprint$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemPresenter;)Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemBlueprint;", "provideDisclaimerItemBlueprint", "Lcom/avito/android/short_term_rent/confirm_booking/items/link/LinkItemPresenter;", "provideLinkItemPresenter$short_term_rent_release", "()Lcom/avito/android/short_term_rent/confirm_booking/items/link/LinkItemPresenter;", "provideLinkItemPresenter", "provideLinkItemBlueprint$short_term_rent_release", "(Lcom/avito/android/short_term_rent/confirm_booking/items/link/LinkItemPresenter;)Lcom/avito/android/short_term_rent/confirm_booking/items/link/LinkItemBlueprint;", "provideLinkItemBlueprint", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class, InputItemFormatterProviderModule.class})
public final class StrConfirmBookingBlueprintsModule {
    @NotNull
    public static final StrConfirmBookingBlueprintsModule INSTANCE = new StrConfirmBookingBlueprintsModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ButtonItemBlueprint provideButtonBlueprint(@NotNull ButtonItemPresenter buttonItemPresenter) {
        Intrinsics.checkNotNullParameter(buttonItemPresenter, "buttonItemPresenter");
        return new ButtonItemBlueprint(buttonItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ButtonItemPresenter provideButtonItemPresenter(@NotNull Lazy<StrConfirmBookingViewModel> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ButtonItemPresenterImpl(lazy);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DisclaimerItemBlueprint provideDisclaimerItemBlueprint$short_term_rent_release(@NotNull DisclaimerItemPresenter disclaimerItemPresenter) {
        Intrinsics.checkNotNullParameter(disclaimerItemPresenter, "presenter");
        return new DisclaimerItemBlueprint(disclaimerItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DisclaimerItemPresenter provideDisclaimerItemPresenter$short_term_rent_release() {
        return new DisclaimerItemPresenter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final InputItemBlueprint provideInputItemBluePrint(@NotNull InputItemPresenter inputItemPresenter) {
        Intrinsics.checkNotNullParameter(inputItemPresenter, "inputItemPresenter");
        return new InputItemBlueprint(inputItemPresenter, null, 2, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final InputItemPresenter provideInputItemPresenter(@NotNull Lazy<StrConfirmBookingViewModel> lazy, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull TextWatcher textWatcher, @NotNull InputItemFormatterProvider inputItemFormatterProvider) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(textWatcher, "phoneTextWatcher");
        Intrinsics.checkNotNullParameter(inputItemFormatterProvider, "formatterProvider");
        return new InputItemPresenterImpl(lazy, textWatcher, inputItemFormatterProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder(@NotNull InputItemBlueprint inputItemBlueprint, @NotNull NotificationItemBlueprint notificationItemBlueprint, @NotNull ButtonItemBlueprint buttonItemBlueprint, @NotNull SummaryItemBlueprint summaryItemBlueprint, @NotNull LinkItemBlueprint linkItemBlueprint, @NotNull DisclaimerItemBlueprint disclaimerItemBlueprint) {
        Intrinsics.checkNotNullParameter(inputItemBlueprint, "inputItemBlueprint");
        Intrinsics.checkNotNullParameter(notificationItemBlueprint, "notificationItemBlueprint");
        Intrinsics.checkNotNullParameter(buttonItemBlueprint, "buttonItemBlueprint");
        Intrinsics.checkNotNullParameter(summaryItemBlueprint, "summaryItemBlueprint");
        Intrinsics.checkNotNullParameter(linkItemBlueprint, "linkItemBlueprint");
        Intrinsics.checkNotNullParameter(disclaimerItemBlueprint, "disclaimerItemBlueprint");
        return new ItemBinder.Builder().registerItem(inputItemBlueprint).registerItem(notificationItemBlueprint).registerItem(buttonItemBlueprint).registerItem(summaryItemBlueprint).registerItem(linkItemBlueprint).registerItem(disclaimerItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LinkItemBlueprint provideLinkItemBlueprint$short_term_rent_release(@NotNull LinkItemPresenter linkItemPresenter) {
        Intrinsics.checkNotNullParameter(linkItemPresenter, "presenter");
        return new LinkItemBlueprint(linkItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LinkItemPresenter provideLinkItemPresenter$short_term_rent_release() {
        return new LinkItemPresenter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final NotificationItemBlueprint provideNotificationItemBlueprint(@NotNull NotificationItemPresenter notificationItemPresenter) {
        Intrinsics.checkNotNullParameter(notificationItemPresenter, "presenter");
        return new NotificationItemBlueprint(notificationItemPresenter, null, 2, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final NotificationItemPresenter provideNotificationItemPresenter() {
        return new NotificationItemPresenterImpl(null, 1, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SummaryItemBlueprint provideSummaryItemBlueprint$short_term_rent_release(@NotNull SummaryItemPresenter summaryItemPresenter) {
        Intrinsics.checkNotNullParameter(summaryItemPresenter, "presenter");
        return new SummaryItemBlueprint(summaryItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SummaryItemPresenter provideSummaryItemPresenter$short_term_rent_release() {
        return new SummaryItemPresenter();
    }
}
