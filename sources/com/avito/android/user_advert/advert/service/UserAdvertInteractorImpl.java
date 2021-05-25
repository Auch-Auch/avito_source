package com.avito.android.user_advert.advert.service;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorContainer;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.profile.ItemActivateResponse;
import com.avito.android.user_advert.event.ActivationFromPushErrorEvent;
import com.avito.android.user_advert.event.AdvertReactivationStartEvent;
import com.avito.android.user_advert.event.AutoPublishFromPushErrorEvent;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/user_advert/advert/service/UserAdvertInteractorImpl;", "Lcom/avito/android/user_advert/advert/service/UserAdvertInteractor;", "", "reason", BookingInfoActivity.EXTRA_ITEM_ID, "", "closeAdvertSync", "(Ljava/lang/String;Ljava/lang/String;)V", "", "enabled", "setAutoPublishSync", "(ZLjava/lang/String;)Z", "activateAdvertSync", "(Ljava/lang/String;)Z", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", "api", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/user_advert_api/remote/UserAdvertApi;Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertInteractorImpl implements UserAdvertInteractor {
    public final UserAdvertApi a;
    public final Analytics b;

    public static final class a<T, R> implements Function<ItemActivateResponse, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(ItemActivateResponse itemActivateResponse) {
            return Boolean.valueOf(itemActivateResponse.getSuccess());
        }
    }

    public static final class b<T, R> implements Function<Throwable, Boolean> {
        public final /* synthetic */ UserAdvertInteractorImpl a;
        public final /* synthetic */ String b;

        public b(UserAdvertInteractorImpl userAdvertInteractorImpl, String str) {
            this.a = userAdvertInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(Throwable th) {
            Throwable th2 = th;
            UserAdvertInteractorImpl userAdvertInteractorImpl = this.a;
            String str = this.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            UserAdvertInteractorImpl.access$trackActivationError(userAdvertInteractorImpl, str, th2);
            return Boolean.FALSE;
        }
    }

    @Inject
    public UserAdvertInteractorImpl(@NotNull UserAdvertApi userAdvertApi, @NotNull Features features, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(userAdvertApi, "api");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = userAdvertApi;
        this.b = analytics;
    }

    public static final void access$trackActivationError(UserAdvertInteractorImpl userAdvertInteractorImpl, String str, Throwable th) {
        Objects.requireNonNull(userAdvertInteractorImpl);
        if (th instanceof ErrorContainer) {
            ErrorContainer errorContainer = (ErrorContainer) th;
            userAdvertInteractorImpl.b.track(new ActivationFromPushErrorEvent(str, Integer.valueOf(errorContainer.getError().code), errorContainer.getError().simpleMessage));
            return;
        }
        userAdvertInteractorImpl.b.track(new ActivationFromPushErrorEvent(str, null, th.getMessage()));
    }

    @Override // com.avito.android.user_advert.advert.service.UserAdvertInteractor
    public boolean activateAdvertSync(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        try {
            this.b.track(new AdvertReactivationStartEvent(str));
            R blockingGet = this.a.activateAdvert(str).timeout(5, TimeUnit.SECONDS).map(a.a).onErrorReturn(new b(this, str)).blockingGet();
            if (!blockingGet.booleanValue()) {
                Logs.debug$default("UserAdvertInteractor", "Failed to to activate advert with id " + str + " without app opening", null, 4, null);
            }
            Intrinsics.checkNotNullExpressionValue(blockingGet, "resultSuccessful");
            return blockingGet.booleanValue();
        } catch (Exception e) {
            Logs.debug("UserAdvertInteractor", "Failed to to activate advert with id " + str + " without app opening", e);
            return false;
        }
    }

    @Override // com.avito.android.user_advert.advert.service.UserAdvertInteractor
    public void closeAdvertSync(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        try {
            Logs.debug$default("UserAdvertInteractor", "Advert " + str2 + " closed with reason " + str + ": " + this.a.deactivateAdvert(str2, str).timeout(5, TimeUnit.SECONDS).blockingGet().getMessage(), null, 4, null);
        } catch (Exception e) {
            Logs.debug("UserAdvertInteractor", a2.b.a.a.a.d("Failed to close advert ", str2, " with reason ", str), e);
        }
    }

    @Override // com.avito.android.user_advert.advert.service.UserAdvertInteractor
    public boolean setAutoPublishSync(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        try {
            TypedResult<SimpleMessageResult> blockingGet = this.a.setAutoPublishEnabled(str, z).timeout(5, TimeUnit.SECONDS).blockingGet();
            if (blockingGet instanceof TypedResult.OfError) {
                this.b.track(new AutoPublishFromPushErrorEvent(str, null, ((TypedResult.OfError) blockingGet).getError().getMessage()));
                Logs.debug$default("UserAdvertInteractor", "Failed to set autopublish to " + z + " for advert " + str + ": " + ((TypedResult.OfError) blockingGet).getError(), null, 4, null);
                return false;
            }
            Logs.debug$default("UserAdvertInteractor", "Autopublish set to " + z + " for advert " + str, null, 4, null);
            return true;
        } catch (Exception e) {
            this.b.track(new AutoPublishFromPushErrorEvent(str, null, e.getMessage()));
            Logs.debug("UserAdvertInteractor", "Failed to to set autopublish to " + z + " for advert " + str, e);
            return false;
        }
    }
}
