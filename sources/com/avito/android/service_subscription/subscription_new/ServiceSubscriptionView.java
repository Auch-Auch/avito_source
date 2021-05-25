package com.avito.android.service_subscription.subscription_new;

import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.profile.DescriptionAttribute;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u001d\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006J\u001d\u0010\u0018\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011H&¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u0006J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u0006J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H&¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u0004H&¢\u0006\u0004\b&\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010)¨\u0006/"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionView;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "text", "Lcom/avito/android/remote/model/UniversalColor;", "color", "showBanner", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;)V", "setSubscriptionTitle", "footer", "setFooter", MessengerShareContentUtility.SUBTITLE, "setSubscriptionSubtitle", "", "Lcom/avito/android/remote/model/profile/DescriptionAttribute;", Navigation.ATTRIBUTES, "setAttributes", "(Ljava/util/List;)V", "setPackagesTitle", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData;", "setPackageAttributes", "actionName", "initActionButton", "showSnackbar", "", "isEnabled", "setActionEnabled", "(Z)V", "error", "showLoadingError", "showActionError", "showProgress", "()V", "hideProgress", "showDivider", "Lio/reactivex/Observable;", "getSubscriptionActionClicks", "()Lio/reactivex/Observable;", "subscriptionActionClicks", "getNavigationClicks", "navigationClicks", "getRefreshClicks", "refreshClicks", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ServiceSubscriptionView {
    @NotNull
    Observable<Unit> getNavigationClicks();

    @NotNull
    Observable<Unit> getRefreshClicks();

    @NotNull
    Observable<Unit> getSubscriptionActionClicks();

    void hideProgress();

    void initActionButton(@NotNull String str);

    void setActionEnabled(boolean z);

    void setAttributes(@NotNull List<DescriptionAttribute> list);

    void setFooter(@Nullable String str);

    void setPackageAttributes(@NotNull List<? extends PackageAttributeViewData> list);

    void setPackagesTitle(@Nullable String str);

    void setSubscriptionSubtitle(@Nullable String str);

    void setSubscriptionTitle(@Nullable String str);

    void setTitle(@Nullable String str);

    void showActionError(@NotNull String str);

    void showBanner(@Nullable String str, @Nullable String str2, @Nullable UniversalColor universalColor);

    void showDivider();

    void showLoadingError(@NotNull String str);

    void showProgress();

    void showSnackbar(@NotNull String str);
}
