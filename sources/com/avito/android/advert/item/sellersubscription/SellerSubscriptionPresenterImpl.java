package com.avito.android.advert.item.sellersubscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.FavoriteSeller;
import com.avito.android.advert.item.AdvertDetailsItemsHolder;
import com.avito.android.advert.item.AdvertDetailsView;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.sellersubscription.action.SellerSubscriptionAction;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscribeSellerButtonEvent;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.analytics.event.favorite.UnsubscribeSellerButtonEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.RefreshLink;
import com.avito.android.deep_linking.links.SellerSubscribeLink;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.SubscribeResult;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.Singles;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001lBU\b\u0007\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010d\u001a\u00020a\u0012\f\u0010i\u001a\b\u0012\u0004\u0012\u00020f0e\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020K0J\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\bj\u0010kJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u000bJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u000bJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u000bJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b%\u0010#J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b&\u0010#J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u000bR\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u00101R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020K0J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010[R\u0016\u0010]\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u00108R\u0016\u0010^\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u00108R\u0018\u0010`\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010<R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020f0e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006m"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "Lcom/avito/android/advert/item/AdvertDetailsView;", "view", "", "attachView", "(Lcom/avito/android/advert/item/AdvertDetailsView;)V", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "attachSubscriptionSettingsView", "(Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;)V", "detachView", "()V", "detachSubscriptionSettingsView", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter$Router;)V", "detachRouter", "Lcom/avito/android/advert/item/AdvertDetailsItemsHolder;", "holder", "onItemsReady", "(Lcom/avito/android/advert/item/AdvertDetailsItemsHolder;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "state", "onRestoreState", "(Lcom/avito/android/util/Kundle;)V", "onAuthSuccess", "onAuthFailed", "onEnableNotificationDialogSuccess", "onSubscriptionDeepLinkReturned", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;", "item", "d", "(Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;)V", "e", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "Lcom/avito/android/analytics/Analytics;", "u", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/deep_linking/links/DeepLink;", "k", "Lcom/avito/android/deep_linking/links/DeepLink;", "nextDeepLink", "l", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;", "currentItemForUpdate", "Lcom/avito/android/advert/item/AdvertDetailsView;", a2.g.r.g.a, "Lcom/avito/android/advert/item/AdvertDetailsItemsHolder;", "itemsHolder", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "actionDisposables", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState;", "h", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState;", "targetState", "j", "currentConfiguringItem", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "f", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter$Router;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractor;", "n", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractor;", "interactor", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/item/sellersubscription/action/SellerSubscriptionAction;", "s", "Lio/reactivex/rxjava3/core/Observable;", "subscriptionActions", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "t", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "p", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "subscriptionSettingsView", "interactorDisposables", "settingsDisposables", "i", "retryOnAuthSuccessTargetState", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;", VKApiConst.Q, "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;", "resourceProvider", "Lcom/avito/android/util/Formatter;", "", "r", "Lcom/avito/android/util/Formatter;", "errorFormatter", "<init>", "(Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionResourceProvider;Lcom/avito/android/util/Formatter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/analytics/Analytics;)V", "TargetState", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SellerSubscriptionPresenterImpl implements SellerSubscriptionPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    public final CompositeDisposable c = new CompositeDisposable();
    public AdvertDetailsView d;
    public SubscriptionSettingsView e;
    public SellerSubscriptionPresenter.Router f;
    public AdvertDetailsItemsHolder g;
    public TargetState h;
    public TargetState i;
    public AdvertDetailsSellerSubscriptionItem j;
    public DeepLink k;
    public AdvertDetailsSellerSubscriptionItem l;
    public final SubscriptionSource m = SubscriptionSource.ADVERT_DETAILS;
    public final SellerSubscriptionInteractor n;
    public final SchedulersFactory3 o;
    public final NotificationManagerProvider p;
    public final SellerSubscriptionResourceProvider q;
    public final Formatter<Throwable> r;
    public final Observable<SellerSubscriptionAction> s;
    public final CompositeSnackbarPresenter t;
    public final Analytics u;

    public static abstract class TargetState implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState$NotificationActivated;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSellerKey", "()Ljava/lang/String;", "sellerKey", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class NotificationActivated extends TargetState {
            public static final Parcelable.Creator<NotificationActivated> CREATOR = new Creator();
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<NotificationActivated> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final NotificationActivated createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new NotificationActivated(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final NotificationActivated[] newArray(int i) {
                    return new NotificationActivated[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NotificationActivated(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "sellerKey");
                this.a = str;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenterImpl.TargetState
            @NotNull
            public String getSellerKey() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState$NotificationDeactivated;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSellerKey", "()Ljava/lang/String;", "sellerKey", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class NotificationDeactivated extends TargetState {
            public static final Parcelable.Creator<NotificationDeactivated> CREATOR = new Creator();
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<NotificationDeactivated> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final NotificationDeactivated createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new NotificationDeactivated(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final NotificationDeactivated[] newArray(int i) {
                    return new NotificationDeactivated[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NotificationDeactivated(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "sellerKey");
                this.a = str;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenterImpl.TargetState
            @NotNull
            public String getSellerKey() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState$Subscribed;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSellerKey", "()Ljava/lang/String;", "sellerKey", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class Subscribed extends TargetState {
            public static final Parcelable.Creator<Subscribed> CREATOR = new Creator();
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Subscribed> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Subscribed createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Subscribed(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Subscribed[] newArray(int i) {
                    return new Subscribed[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Subscribed(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "sellerKey");
                this.a = str;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenterImpl.TargetState
            @NotNull
            public String getSellerKey() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState$Unsubscribed;", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenterImpl$TargetState;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSellerKey", "()Ljava/lang/String;", "sellerKey", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unsubscribed extends TargetState {
            public static final Parcelable.Creator<Unsubscribed> CREATOR = new Creator();
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Unsubscribed> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Unsubscribed createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Unsubscribed(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Unsubscribed[] newArray(int i) {
                    return new Unsubscribed[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Unsubscribed(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "sellerKey");
                this.a = str;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenterImpl.TargetState
            @NotNull
            public String getSellerKey() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }
        }

        public TargetState() {
        }

        @NotNull
        public abstract String getSellerKey();

        public TargetState(t6.r.a.j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            SellerSubscriptionState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            SellerNotificationsState.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem = ((SellerSubscriptionPresenterImpl) this.b).j;
                if (advertDetailsSellerSubscriptionItem != null) {
                    SellerSubscriptionPresenterImpl.access$toggleNotifications((SellerSubscriptionPresenterImpl) this.b, advertDetailsSellerSubscriptionItem);
                }
            } else if (i == 1) {
                AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem2 = ((SellerSubscriptionPresenterImpl) this.b).j;
                if (advertDetailsSellerSubscriptionItem2 != null) {
                    SellerSubscriptionPresenterImpl.access$toggleSubscribe((SellerSubscriptionPresenterImpl) this.b, advertDetailsSellerSubscriptionItem2);
                }
            } else if (i == 2) {
                ((SellerSubscriptionPresenterImpl) this.b).j = null;
            } else {
                throw null;
            }
        }
    }

    public static final class a0<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;
        public final /* synthetic */ SellerSubscriptionState c;

        public a0(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, SellerSubscriptionState sellerSubscriptionState) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
            this.c = sellerSubscriptionState;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.b.setSubscriptionState(this.c);
            SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            SellerSubscriptionPresenterImpl.access$handleError(sellerSubscriptionPresenterImpl, th2, this.b);
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;

        public b(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl) {
            this.a = sellerSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setNotificationLoading(true);
            }
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;

        public c(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl) {
            this.a = sellerSubscriptionPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setNotificationLoading(false);
            }
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;
        public final /* synthetic */ SellerNotificationsState c;

        public d(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, SellerNotificationsState sellerNotificationsState) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
            this.c = sellerNotificationsState;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.b.setNotificationsState(this.c);
            SellerSubscriptionPresenterImpl.access$updateItem(this.a, this.b);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;

        public e(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setNotificationActivated(true);
            }
            this.b.setNotificationsState(SellerNotificationsState.ACTIVATED);
            SellerSubscriptionPresenterImpl.access$notifySellerUpdated(this.a, this.b);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;
        public final /* synthetic */ SellerNotificationsState c;

        public f(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, SellerNotificationsState sellerNotificationsState) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
            this.c = sellerNotificationsState;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.b.setNotificationsState(this.c);
            SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            SellerSubscriptionPresenterImpl.access$handleError(sellerSubscriptionPresenterImpl, th2, this.b);
        }
    }

    public static final class g<T> implements Consumer<SellerSubscriptionAction> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;

        public g(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl) {
            this.a = sellerSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SellerSubscriptionAction sellerSubscriptionAction) {
            SellerSubscriptionAction sellerSubscriptionAction2 = sellerSubscriptionAction;
            if (sellerSubscriptionAction2 instanceof SellerSubscriptionAction.Subscribe) {
                SellerSubscriptionPresenterImpl.access$toggleSubscribe(this.a, ((SellerSubscriptionAction.Subscribe) sellerSubscriptionAction2).getItem());
            } else if (sellerSubscriptionAction2 instanceof SellerSubscriptionAction.OpenSubscriptionSettings) {
                SellerSubscriptionPresenterImpl.access$openSubscriptionSettings(this.a, ((SellerSubscriptionAction.OpenSubscriptionSettings) sellerSubscriptionAction2).getItem());
            }
        }
    }

    public static final class h<T> implements Consumer<Unit> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;

        public h(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl) {
            this.a = sellerSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.c();
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class j<T> implements Consumer<Disposable> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;

        public j(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl) {
            this.a = sellerSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setNotificationLoading(true);
            }
        }
    }

    public static final class k implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;

        public k(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl) {
            this.a = sellerSubscriptionPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setNotificationLoading(false);
            }
        }
    }

    public static final class l implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;
        public final /* synthetic */ SellerNotificationsState c;

        public l(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, SellerNotificationsState sellerNotificationsState) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
            this.c = sellerNotificationsState;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.b.setNotificationsState(this.c);
            SellerSubscriptionPresenterImpl.access$updateItem(this.a, this.b);
        }
    }

    public static final class m implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;

        public m(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setNotificationActivated(false);
            }
            this.b.setNotificationsState(SellerNotificationsState.DEACTIVATED);
            SellerSubscriptionPresenterImpl.access$notifySellerUpdated(this.a, this.b);
        }
    }

    public static final class n<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;
        public final /* synthetic */ SellerNotificationsState c;

        public n(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, SellerNotificationsState sellerNotificationsState) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
            this.c = sellerNotificationsState;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.b.setNotificationsState(this.c);
            SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            SellerSubscriptionPresenterImpl.access$handleError(sellerSubscriptionPresenterImpl, th2, this.b);
        }
    }

    public static final class o<T, R> implements Function<Set<? extends FavoriteSeller>, SingleSource<? extends Map<String, ? extends FavoriteSeller>>> {
        public static final o a = new o();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Map<String, ? extends FavoriteSeller>> apply(Set<? extends FavoriteSeller> set) {
            Set<? extends FavoriteSeller> set2 = set;
            Intrinsics.checkNotNullExpressionValue(set2, "sellerSet");
            LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(t6.n.q.mapCapacity(t6.n.e.collectionSizeOrDefault(set2, 10)), 16));
            for (T t : set2) {
                linkedHashMap.put(t.getUserKey(), t);
            }
            return Singles.toSingle(linkedHashMap);
        }
    }

    public static final class p<T> implements Consumer<Map<String, ? extends FavoriteSeller>> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsItemsHolder b;

        public p(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsItemsHolder advertDetailsItemsHolder) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsItemsHolder;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Map<String, ? extends FavoriteSeller> map) {
            Map<String, ? extends FavoriteSeller> map2 = map;
            for (T t : this.b.getItemsWithType(AdvertDetailsSellerSubscriptionItem.class)) {
                FavoriteSeller favoriteSeller = (FavoriteSeller) map2.get(t.getSellerKey());
                if (favoriteSeller != null) {
                    t.setSubscriptionState(SellerSubscriptionPresenterImpl.access$getSubscriptionState(this.a, favoriteSeller));
                    t.setNotificationsState(SellerSubscriptionPresenterImpl.access$getNotificationState(this.a, favoriteSeller));
                    SellerSubscriptionPresenterImpl.access$updateItem(this.a, t);
                }
            }
        }
    }

    public static final class q<T> implements Consumer<Throwable> {
        public static final q a = new q();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class r<T> implements Consumer<Disposable> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem c;

        public r(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, String str, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = str;
            this.c = advertDetailsSellerSubscriptionItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.h = new TargetState.Subscribed(this.b);
            this.c.setSubscriptionState(SellerSubscriptionState.LOADING);
            SellerSubscriptionPresenterImpl.access$updateItem(this.a, this.c);
        }
    }

    public static final class s implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;

        public s(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.h = null;
            SellerSubscriptionPresenterImpl.access$updateItem(this.a, this.b);
        }
    }

    public static final class t implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;
        public final /* synthetic */ SellerSubscriptionState c;

        public t(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, SellerSubscriptionState sellerSubscriptionState) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
            this.c = sellerSubscriptionState;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.b.setSubscriptionState(this.c);
            SellerSubscriptionPresenterImpl.access$updateItem(this.a, this.b);
        }
    }

    public static final class u<T> implements Consumer<SubscribeResult> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;

        public u(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SubscribeResult subscribeResult) {
            SubscribeResult subscribeResult2 = subscribeResult;
            if (Intrinsics.areEqual(subscribeResult2.isNotificationsActivated(), Boolean.TRUE) && this.a.p.getAreNotificationsEnabled()) {
                CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(this.a.t, this.a.q.notificationsActivated(), 0, null, 0, null, 0, null, null, 254, null);
            }
            this.b.setSubscriptionState(SellerSubscriptionState.SUBSCRIBED);
            AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem = this.b;
            SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(subscribeResult2, "result");
            advertDetailsSellerSubscriptionItem.setNotificationsState(SellerSubscriptionPresenterImpl.access$toNotificationState(sellerSubscriptionPresenterImpl, subscribeResult2));
            SellerSubscriptionPresenterImpl.access$notifySellerUpdated(this.a, this.b);
        }
    }

    public static final class v<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;
        public final /* synthetic */ SellerSubscriptionState c;

        public v(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, SellerSubscriptionState sellerSubscriptionState) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
            this.c = sellerSubscriptionState;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.b.setSubscriptionState(this.c);
            SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            SellerSubscriptionPresenterImpl.access$handleError(sellerSubscriptionPresenterImpl, th2, this.b);
        }
    }

    public static final class w<T> implements Consumer<Disposable> {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;

        public w(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl) {
            this.a = sellerSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setUnsubscribeLoading(true);
            }
        }
    }

    public static final class x implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;

        public x(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl) {
            this.a = sellerSubscriptionPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setUnsubscribeLoading(false);
            }
        }
    }

    public static final class y implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;
        public final /* synthetic */ SellerSubscriptionState c;

        public y(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, SellerSubscriptionState sellerSubscriptionState) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
            this.c = sellerSubscriptionState;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.b.setSubscriptionState(this.c);
            SellerSubscriptionPresenterImpl.access$updateItem(this.a, this.b);
        }
    }

    public static final class z implements Action {
        public final /* synthetic */ SellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;

        public z(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
            this.a = sellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.b.setSubscriptionState(SellerSubscriptionState.UNSUBSCRIBED);
            this.b.setNotificationsState(null);
            SellerSubscriptionPresenterImpl.access$notifySellerUpdated(this.a, this.b);
            SubscriptionSettingsView subscriptionSettingsView = this.a.e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.closeSubscriptionSettings();
            }
        }
    }

    @Inject
    public SellerSubscriptionPresenterImpl(@NotNull SellerSubscriptionInteractor sellerSubscriptionInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull SellerSubscriptionResourceProvider sellerSubscriptionResourceProvider, @NotNull Formatter<Throwable> formatter, @NotNull Observable<SellerSubscriptionAction> observable, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(sellerSubscriptionInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        Intrinsics.checkNotNullParameter(sellerSubscriptionResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(observable, "subscriptionActions");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.n = sellerSubscriptionInteractor;
        this.o = schedulersFactory3;
        this.p = notificationManagerProvider;
        this.q = sellerSubscriptionResourceProvider;
        this.r = formatter;
        this.s = observable;
        this.t = compositeSnackbarPresenter;
        this.u = analytics;
    }

    public static final SellerNotificationsState access$getNotificationState(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, FavoriteSeller favoriteSeller) {
        Boolean isNotificationsActivated;
        Objects.requireNonNull(sellerSubscriptionPresenterImpl);
        if (!favoriteSeller.isSubscribed() || (isNotificationsActivated = favoriteSeller.isNotificationsActivated()) == null) {
            return null;
        }
        if (Intrinsics.areEqual(isNotificationsActivated, Boolean.TRUE)) {
            return SellerNotificationsState.ACTIVATED;
        }
        if (Intrinsics.areEqual(isNotificationsActivated, Boolean.FALSE)) {
            return SellerNotificationsState.DEACTIVATED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final SellerSubscriptionState access$getSubscriptionState(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, FavoriteSeller favoriteSeller) {
        Objects.requireNonNull(sellerSubscriptionPresenterImpl);
        boolean isSubscribed = favoriteSeller.isSubscribed();
        if (isSubscribed) {
            return SellerSubscriptionState.SUBSCRIBED;
        }
        if (!isSubscribed) {
            return SellerSubscriptionState.UNSUBSCRIBED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void access$handleError(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, Throwable th, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        Objects.requireNonNull(sellerSubscriptionPresenterImpl);
        boolean z2 = th instanceof TypedResultException;
        boolean z3 = false;
        if (z2) {
            TypedError errorResult = ((TypedResultException) th).getErrorResult();
            if ((errorResult instanceof ErrorResult.Unauthorized) || (errorResult instanceof ErrorResult.Unauthenticated)) {
                z3 = true;
            }
        }
        if (z3) {
            sellerSubscriptionPresenterImpl.i = sellerSubscriptionPresenterImpl.h;
            SellerSubscriptionPresenter.Router router = sellerSubscriptionPresenterImpl.f;
            if (router != null) {
                router.onAuthRequired(AuthSource.SUBSCRIBE_SELLER);
                return;
            }
            return;
        }
        if (z2) {
            TypedResultException typedResultException = (TypedResultException) th;
            if (typedResultException.getErrorResult() instanceof ErrorResult.ErrorDialog) {
                TypedError errorResult2 = typedResultException.getErrorResult();
                Objects.requireNonNull(errorResult2, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult.ErrorDialog");
                ErrorResult.ErrorDialog errorDialog = (ErrorResult.ErrorDialog) errorResult2;
                AdvertDetailsView advertDetailsView = sellerSubscriptionPresenterImpl.d;
                if (advertDetailsView != null) {
                    advertDetailsView.showErrorDialog(errorDialog, new a2.a.a.f.x.b0.a(sellerSubscriptionPresenterImpl, errorDialog, advertDetailsSellerSubscriptionItem));
                    return;
                }
                return;
            }
        }
        CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(sellerSubscriptionPresenterImpl.t, sellerSubscriptionPresenterImpl.r.format(th), 0, null, 0, null, 0, null, null, 254, null);
    }

    public static final void access$notifySellerUpdated(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        Boolean bool;
        CompositeDisposable compositeDisposable = sellerSubscriptionPresenterImpl.b;
        SellerSubscriptionInteractor sellerSubscriptionInteractor = sellerSubscriptionPresenterImpl.n;
        String sellerKey = advertDetailsSellerSubscriptionItem.getSellerKey();
        boolean z2 = false;
        Boolean valueOf = Boolean.valueOf(advertDetailsSellerSubscriptionItem.getSubscriptionState() == SellerSubscriptionState.SUBSCRIBED);
        SellerNotificationsState notificationsState = advertDetailsSellerSubscriptionItem.getNotificationsState();
        if (notificationsState != null) {
            if (notificationsState == SellerNotificationsState.ACTIVATED) {
                z2 = true;
            }
            bool = Boolean.valueOf(z2);
        } else {
            bool = null;
        }
        Disposable subscribe = sellerSubscriptionInteractor.updateSeller(sellerKey, valueOf, bool).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.updateSeller(…D }\n        ).subscribe()");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$openSubscriptionSettings(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        sellerSubscriptionPresenterImpl.j = advertDetailsSellerSubscriptionItem;
        SubscriptionSettingsView subscriptionSettingsView = sellerSubscriptionPresenterImpl.e;
        if (subscriptionSettingsView != null) {
            subscriptionSettingsView.setNotificationActivated(advertDetailsSellerSubscriptionItem.getNotificationsState() == SellerNotificationsState.ACTIVATED);
            subscriptionSettingsView.openSubscriptionSettings();
        }
    }

    public static final SellerNotificationsState access$toNotificationState(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, SubscribeResult subscribeResult) {
        Objects.requireNonNull(sellerSubscriptionPresenterImpl);
        Boolean isNotificationsActivated = subscribeResult.isNotificationsActivated();
        if (isNotificationsActivated == null) {
            return null;
        }
        if (Intrinsics.areEqual(isNotificationsActivated, Boolean.TRUE)) {
            return SellerNotificationsState.ACTIVATED;
        }
        if (Intrinsics.areEqual(isNotificationsActivated, Boolean.FALSE)) {
            return SellerNotificationsState.DEACTIVATED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void access$toggleNotifications(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        AdvertDetailsView advertDetailsView = sellerSubscriptionPresenterImpl.d;
        if (advertDetailsView == null) {
            return;
        }
        if (!sellerSubscriptionPresenterImpl.p.getAreNotificationsEnabled()) {
            advertDetailsView.showEnableNotificationDialog();
            return;
        }
        SellerNotificationsState notificationsState = advertDetailsSellerSubscriptionItem.getNotificationsState();
        if (notificationsState != null) {
            int ordinal = notificationsState.ordinal();
            if (ordinal == 0) {
                sellerSubscriptionPresenterImpl.b(advertDetailsSellerSubscriptionItem);
            } else if (ordinal == 1) {
                sellerSubscriptionPresenterImpl.a(advertDetailsSellerSubscriptionItem);
            }
        }
    }

    public static final void access$toggleSubscribe(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        Objects.requireNonNull(sellerSubscriptionPresenterImpl);
        int ordinal = advertDetailsSellerSubscriptionItem.getSubscriptionState().ordinal();
        if (ordinal == 0) {
            sellerSubscriptionPresenterImpl.u.track(new UnsubscribeSellerButtonEvent(advertDetailsSellerSubscriptionItem.getSellerKey(), SubscriptionSource.ADVERT_DETAILS));
            sellerSubscriptionPresenterImpl.e(advertDetailsSellerSubscriptionItem);
        } else if (ordinal == 1) {
            sellerSubscriptionPresenterImpl.u.track(new SubscribeSellerButtonEvent(advertDetailsSellerSubscriptionItem.getSellerKey(), SubscriptionSource.ADVERT_DETAILS));
            sellerSubscriptionPresenterImpl.d(advertDetailsSellerSubscriptionItem);
        }
    }

    public static final void access$updateItem(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        AdvertDetailsView advertDetailsView;
        AdvertDetailsItemsHolder advertDetailsItemsHolder = sellerSubscriptionPresenterImpl.g;
        if (advertDetailsItemsHolder != null && (advertDetailsView = sellerSubscriptionPresenterImpl.d) != null) {
            advertDetailsView.notifyItemAtPositionChanged(advertDetailsItemsHolder.getItemPosition(advertDetailsSellerSubscriptionItem));
        }
    }

    public final void a(AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        SellerNotificationsState sellerNotificationsState = SellerNotificationsState.DEACTIVATED;
        if (advertDetailsSellerSubscriptionItem.getNotificationsState() == sellerNotificationsState) {
            String sellerKey = advertDetailsSellerSubscriptionItem.getSellerKey();
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = this.n.changeNotifications(sellerKey, true, this.m).observeOn(this.o.mainThread()).doOnSubscribe(new b(this)).doAfterTerminate(new c(this)).doOnDispose(new d(this, advertDetailsSellerSubscriptionItem, sellerNotificationsState)).subscribe(new e(this, advertDetailsSellerSubscriptionItem), new f(this, advertDetailsSellerSubscriptionItem, sellerNotificationsState));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.changeNotific…(it, item)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void attachRouter(@NotNull SellerSubscriptionPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.f = router;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void attachSubscriptionSettingsView(@NotNull SubscriptionSettingsView subscriptionSettingsView) {
        Intrinsics.checkNotNullParameter(subscriptionSettingsView, "view");
        this.e = subscriptionSettingsView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = subscriptionSettingsView.notificationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.notificationClicks(…fications(it) }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = subscriptionSettingsView.unsubscribeClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.unsubscribeClicks()…Subscribe(it) }\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.c;
        Disposable subscribe3 = subscriptionSettingsView.dismissEvents().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.dismissEvents()\n   …Item = null\n            }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        if (this.j != null) {
            subscriptionSettingsView.openSubscriptionSettings();
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void attachView(@NotNull AdvertDetailsView advertDetailsView) {
        Intrinsics.checkNotNullParameter(advertDetailsView, "view");
        this.d = advertDetailsView;
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.s.subscribe(new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscriptionActions\n    …          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.b;
        Disposable subscribe2 = this.n.updates().observeOn(this.o.mainThread()).subscribe(new h(this), i.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "interactor.updates()\n   ….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        c();
    }

    public final void b(AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        SellerNotificationsState sellerNotificationsState = SellerNotificationsState.ACTIVATED;
        if (advertDetailsSellerSubscriptionItem.getNotificationsState() == sellerNotificationsState) {
            String sellerKey = advertDetailsSellerSubscriptionItem.getSellerKey();
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = this.n.changeNotifications(sellerKey, false, this.m).observeOn(this.o.mainThread()).doOnSubscribe(new j(this)).doAfterTerminate(new k(this)).doOnDispose(new l(this, advertDetailsSellerSubscriptionItem, sellerNotificationsState)).subscribe(new m(this, advertDetailsSellerSubscriptionItem), new n(this, advertDetailsSellerSubscriptionItem, sellerNotificationsState));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.changeNotific…(it, item)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void c() {
        AdvertDetailsItemsHolder advertDetailsItemsHolder = this.g;
        if (advertDetailsItemsHolder != null) {
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = this.n.getSellers().flatMap(o.a).observeOn(this.o.mainThread()).subscribe(new p(this, advertDetailsItemsHolder), q.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getSellers()\n….error(it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void d(AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        SellerSubscriptionState sellerSubscriptionState = SellerSubscriptionState.UNSUBSCRIBED;
        if (advertDetailsSellerSubscriptionItem.getSubscriptionState() == sellerSubscriptionState) {
            String sellerKey = advertDetailsSellerSubscriptionItem.getSellerKey();
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = this.n.subscribe(sellerKey, this.m).observeOn(this.o.mainThread()).doOnSubscribe(new r(this, sellerKey, advertDetailsSellerSubscriptionItem)).doAfterTerminate(new s(this, advertDetailsSellerSubscriptionItem)).doOnDispose(new t(this, advertDetailsSellerSubscriptionItem, sellerSubscriptionState)).subscribe(new u(this, advertDetailsSellerSubscriptionItem), new v(this, advertDetailsSellerSubscriptionItem, sellerSubscriptionState));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.subscribe(sel…(it, item)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void detachRouter() {
        this.f = null;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void detachSubscriptionSettingsView() {
        this.c.clear();
        this.e = null;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void detachView() {
        this.a.clear();
        this.b.clear();
        this.d = null;
    }

    public final void e(AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        SellerSubscriptionState sellerSubscriptionState = SellerSubscriptionState.SUBSCRIBED;
        if (advertDetailsSellerSubscriptionItem.getSubscriptionState() == sellerSubscriptionState) {
            String sellerKey = advertDetailsSellerSubscriptionItem.getSellerKey();
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = this.n.unsubscribe(sellerKey, this.m).observeOn(this.o.mainThread()).doOnSubscribe(new w(this)).doAfterTerminate(new x(this)).doOnDispose(new y(this, advertDetailsSellerSubscriptionItem, sellerSubscriptionState)).subscribe(new z(this, advertDetailsSellerSubscriptionItem), new a0(this, advertDetailsSellerSubscriptionItem, sellerSubscriptionState));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.unsubscribe(s…(it, item)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void onAuthFailed() {
        this.i = null;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void onAuthSuccess() {
        this.h = this.i;
        this.i = null;
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void onEnableNotificationDialogSuccess() {
        SellerSubscriptionPresenter.Router router = this.f;
        if (router != null) {
            router.openNotificationsSettings();
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void onItemsReady(@NotNull AdvertDetailsItemsHolder advertDetailsItemsHolder) {
        Object obj;
        Intrinsics.checkNotNullParameter(advertDetailsItemsHolder, "holder");
        this.g = advertDetailsItemsHolder;
        TargetState targetState = this.h;
        if (targetState != null) {
            Iterator it = advertDetailsItemsHolder.getItemsWithType(AdvertDetailsSellerSubscriptionItem.class).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((AdvertDetailsSellerSubscriptionItem) obj).getSellerKey(), targetState.getSellerKey())) {
                    break;
                }
            }
            AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem = (AdvertDetailsSellerSubscriptionItem) obj;
            if (advertDetailsSellerSubscriptionItem == null) {
                return;
            }
            if (targetState instanceof TargetState.Subscribed) {
                d(advertDetailsSellerSubscriptionItem);
            } else if (targetState instanceof TargetState.Unsubscribed) {
                e(advertDetailsSellerSubscriptionItem);
            } else if (targetState instanceof TargetState.NotificationActivated) {
                a(advertDetailsSellerSubscriptionItem);
            } else if (targetState instanceof TargetState.NotificationDeactivated) {
                b(advertDetailsSellerSubscriptionItem);
            }
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void onRestoreState(@NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(kundle, "state");
        this.h = (TargetState) kundle.getParcelable("target_state");
        this.i = (TargetState) kundle.getParcelable("retry_on_auth_success_target_state");
        this.j = (AdvertDetailsSellerSubscriptionItem) kundle.getParcelable("current_configuring_item");
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("target_state", this.h).putParcelable("retry_on_auth_success_target_state", this.i).putParcelable("current_configuring_item", this.j);
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter
    public void onSubscriptionDeepLinkReturned() {
        AdvertDetailsView advertDetailsView;
        DeepLink deepLink = this.k;
        if (deepLink == null) {
            return;
        }
        if (deepLink instanceof RefreshLink) {
            AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem = this.l;
            if (advertDetailsSellerSubscriptionItem != null) {
                AdvertDetailsItemsHolder advertDetailsItemsHolder = this.g;
                if (!(advertDetailsItemsHolder == null || (advertDetailsView = this.d) == null)) {
                    advertDetailsView.notifyItemAtPositionChanged(advertDetailsItemsHolder.getItemPosition(advertDetailsSellerSubscriptionItem));
                }
                this.l = null;
            }
        } else if (deepLink instanceof SellerSubscribeLink) {
            SellerSubscribeLink sellerSubscribeLink = (SellerSubscribeLink) deepLink;
            AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem2 = this.l;
            if (advertDetailsSellerSubscriptionItem2 != null) {
                if (Intrinsics.areEqual(advertDetailsSellerSubscriptionItem2.getSellerKey(), sellerSubscribeLink.getHash())) {
                    d(advertDetailsSellerSubscriptionItem2);
                }
                this.l = null;
            }
        }
    }
}
