package com.avito.android.publish.edit_advert_request;

import a2.a.a.e2.u.d;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.edit_advert_request.analytics.ItemEditCityChangeAlertEvent;
import com.avito.android.publish.edit_advert_request.data.EditAdvertRepository;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.adverts.EditAdvertResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00011B'\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010,\u001a\u0004\u0018\u00010\u00188F@\u0006¢\u0006\f\u0012\u0004\b+\u0010\f\u001a\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "", "initScreen", "(Lcom/avito/android/publish/PublishViewModel;)V", "onRetryClicked", "()V", "onCleared", "goPrevious", "onFeesSuccess", "c", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "editProcessDisposable", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", "e", "Ljava/lang/String;", "message", "d", "Lcom/avito/android/publish/PublishViewModel;", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepository;", g.a, "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepository;", "repository", "getPostAction", "()Ljava/lang/String;", "getPostAction$annotations", "postAction", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepository;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "ViewState", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class EditAdvertRequestViewModel extends ViewModel {
    public Disposable c;
    public PublishViewModel d;
    public String e = "";
    public final MutableLiveData<ViewState> f = new MutableLiveData<>();
    public final EditAdvertRepository g;
    public final SchedulersFactory h;
    public final Analytics i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "", "<init>", "()V", "Error", "FinishEdit", "Loading", "OpenDeepLinkAndFinish", "ShowActionDialog", "ShowFees", "ShowFeesLegacy", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$Loading;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$ShowFeesLegacy;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$ShowFees;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$ShowActionDialog;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$OpenDeepLinkAndFinish;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$FinishEdit;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$Error;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$Error;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "Lcom/avito/android/remote/error/ErrorResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/ErrorResult;", "getError", "()Lcom/avito/android/remote/error/ErrorResult;", "error", "<init>", "(Lcom/avito/android/remote/error/ErrorResult;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ViewState {
            @NotNull
            public final ErrorResult a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull ErrorResult errorResult) {
                super(null);
                Intrinsics.checkNotNullParameter(errorResult, "error");
                this.a = errorResult;
            }

            @NotNull
            public final ErrorResult getError() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$FinishEdit;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.SEND_ABUSE, "getMessage", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class FinishEdit extends ViewState {
            @NotNull
            public final String a;
            @Nullable
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FinishEdit(@NotNull String str, @Nullable String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
                this.b = str2;
            }

            @Nullable
            public final String getAdvertId() {
                return this.b;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$Loading;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$OpenDeepLinkAndFinish;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenDeepLinkAndFinish extends ViewState {
            @NotNull
            public final DeepLink a;
            @Nullable
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenDeepLinkAndFinish(@NotNull DeepLink deepLink, @Nullable String str) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                this.a = deepLink;
                this.b = str;
            }

            @Nullable
            public final String getAdvertId() {
                return this.b;
            }

            @NotNull
            public final DeepLink getDeepLink() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$ShowActionDialog;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "Lkotlin/Function0;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "getOnPositiveClicked", "()Lkotlin/jvm/functions/Function0;", "onPositiveClicked", "Lcom/avito/android/remote/model/Action$Confirmation;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Action$Confirmation;", "getDialogData", "()Lcom/avito/android/remote/model/Action$Confirmation;", "dialogData", "<init>", "(Lcom/avito/android/remote/model/Action$Confirmation;Lkotlin/jvm/functions/Function0;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowActionDialog extends ViewState {
            @NotNull
            public final Action.Confirmation a;
            @NotNull
            public final Function0<Unit> b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowActionDialog(@NotNull Action.Confirmation confirmation, @NotNull Function0<Unit> function0) {
                super(null);
                Intrinsics.checkNotNullParameter(confirmation, "dialogData");
                Intrinsics.checkNotNullParameter(function0, "onPositiveClicked");
                this.a = confirmation;
                this.b = function0;
            }

            @NotNull
            public final Action.Confirmation getDialogData() {
                return this.a;
            }

            @NotNull
            public final Function0<Unit> getOnPositiveClicked() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$ShowFees;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "itemId", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowFees extends ViewState {
            @NotNull
            public final DeepLink a;
            @NotNull
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowFees(@NotNull DeepLink deepLink, @NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                Intrinsics.checkNotNullParameter(str, "itemId");
                this.a = deepLink;
                this.b = str;
            }

            @NotNull
            public final DeepLink getDeeplink() {
                return this.a;
            }

            @NotNull
            public final String getItemId() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState$ShowFeesLegacy;", "Lcom/avito/android/publish/edit_advert_request/EditAdvertRequestViewModel$ViewState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "itemId", "<init>", "(Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowFeesLegacy extends ViewState {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowFeesLegacy(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "itemId");
                this.a = str;
            }

            @NotNull
            public final String getItemId() {
                return this.a;
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<TypedResult<EditAdvertResult>> {
        public final /* synthetic */ EditAdvertRequestViewModel a;
        public final /* synthetic */ ItemBrief b;

        public a(EditAdvertRequestViewModel editAdvertRequestViewModel, ItemBrief itemBrief) {
            this.a = editAdvertRequestViewModel;
            this.b = itemBrief;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(TypedResult<EditAdvertResult> typedResult) {
            Map<String, PretendErrorValue> errors;
            TypedResult<EditAdvertResult> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                EditAdvertResult editAdvertResult = (EditAdvertResult) ((TypedResult.OfResult) typedResult2).getResult();
                if (editAdvertResult instanceof EditAdvertResult.Ok) {
                    EditAdvertRequestViewModel.access$onItemEdited(this.a, (EditAdvertResult.Ok) editAdvertResult, this.b.getId());
                } else if (editAdvertResult instanceof EditAdvertResult.InputErrors) {
                    PretendResult messages = ((EditAdvertResult.InputErrors) editAdvertResult).getMessages();
                    if (messages != null && (errors = messages.getErrors()) != null) {
                        EditAdvertRequestViewModel.access$showPretendErrors(this.a, errors);
                    }
                } else if (editAdvertResult instanceof EditAdvertResult.NeedSupport) {
                    EditAdvertRequestViewModel.access$showUserDialogWithAction(this.a, ((EditAdvertResult.NeedSupport) editAdvertResult).getAction());
                }
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.f.setValue(new ViewState.Error(((TypedResult.OfError) typedResult2).getError()));
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ EditAdvertRequestViewModel a;

        public b(EditAdvertRequestViewModel editAdvertRequestViewModel) {
            this.a = editAdvertRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.f.setValue(new ViewState.Error(new ErrorResult.UnknownError("", null, null, 6, null)));
        }
    }

    public EditAdvertRequestViewModel(@NotNull EditAdvertRepository editAdvertRepository, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(editAdvertRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.g = editAdvertRepository;
        this.h = schedulersFactory;
        this.i = analytics;
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(EditAdvertRequestViewModel editAdvertRequestViewModel) {
        PublishViewModel publishViewModel = editAdvertRequestViewModel.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final void access$onItemEdited(EditAdvertRequestViewModel editAdvertRequestViewModel, EditAdvertResult.Ok ok, String str) {
        Objects.requireNonNull(editAdvertRequestViewModel);
        DeepLink deepLink = ok.getDeepLink();
        if (deepLink != null) {
            editAdvertRequestViewModel.e = ok.getMessage();
            editAdvertRequestViewModel.f.setValue(new ViewState.ShowFees(deepLink, str));
        } else if (ok.getShowFees()) {
            editAdvertRequestViewModel.e = ok.getMessage();
            editAdvertRequestViewModel.f.setValue(new ViewState.ShowFeesLegacy(str));
        } else {
            editAdvertRequestViewModel.f.setValue(new ViewState.FinishEdit(ok.getMessage(), str));
        }
    }

    public static final void access$showPretendErrors(EditAdvertRequestViewModel editAdvertRequestViewModel, Map map) {
        String str;
        PublishViewModel publishViewModel = editAdvertRequestViewModel.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        if (!publishViewModel.handleServerValidationErrors(map)) {
            PretendErrorValue pretendErrorValue = (PretendErrorValue) CollectionsKt___CollectionsKt.firstOrNull(map.values());
            if (pretendErrorValue == null || (str = pretendErrorValue.getSingleMessage()) == null) {
                str = "";
            }
            editAdvertRequestViewModel.f.setValue(new ViewState.Error(new ErrorResult.UnknownError(str, null, null, 6, null)));
        }
    }

    public static final void access$showUserDialogWithAction(EditAdvertRequestViewModel editAdvertRequestViewModel, Action action) {
        Objects.requireNonNull(editAdvertRequestViewModel);
        String str = null;
        if (action.getConfirmation() == null) {
            Logs.error$default("EditAdvertRequestViewModel: action has no confirmation data for dialog", null, 2, null);
            editAdvertRequestViewModel.f.setValue(new ViewState.Error(new ErrorResult.UnknownError("", null, null, 6, null)));
            return;
        }
        Action.Confirmation confirmation = action.getConfirmation();
        Intrinsics.checkNotNull(confirmation);
        MutableLiveData<ViewState> mutableLiveData = editAdvertRequestViewModel.f;
        ViewState.ShowActionDialog showActionDialog = new ViewState.ShowActionDialog(confirmation, new d(editAdvertRequestViewModel, action));
        Analytics analytics = editAdvertRequestViewModel.i;
        PublishViewModel publishViewModel = editAdvertRequestViewModel.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        ItemBrief item = publishViewModel.getItem();
        if (item != null) {
            str = item.getId();
        }
        if (str == null) {
            str = "";
        }
        analytics.track(new ItemEditCityChangeAlertEvent(str));
        mutableLiveData.setValue(showActionDialog);
    }

    public static /* synthetic */ void getPostAction$annotations() {
    }

    public final void c() {
        Disposable disposable = this.c;
        if (disposable == null || disposable.isDisposed()) {
            PublishViewModel publishViewModel = this.d;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            CategoryParameters categoryParameters = publishViewModel.getCategoryParameters();
            if (categoryParameters == null) {
                PublishViewModel publishViewModel2 = this.d;
                if (publishViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                publishViewModel2.handleErrorOrFail("Cannot edit advert as categoryParameters is null");
                return;
            }
            PublishViewModel publishViewModel3 = this.d;
            if (publishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            ItemBrief item = publishViewModel3.getItem();
            if (item == null) {
                PublishViewModel publishViewModel4 = this.d;
                if (publishViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                publishViewModel4.handleErrorOrFail("Cannot edit advert as item is null");
                return;
            }
            this.f.setValue(ViewState.Loading.INSTANCE);
            EditAdvertRepository editAdvertRepository = this.g;
            String id = item.getId();
            String categoryId = item.getCategoryId();
            if (categoryId == null) {
                categoryId = "";
            }
            PublishViewModel publishViewModel5 = this.d;
            if (publishViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            Navigation navigation = publishViewModel5.getNavigation();
            String version = item.getVersion();
            PublishViewModel publishViewModel6 = this.d;
            if (publishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            this.c = editAdvertRepository.editAdvert(id, categoryId, navigation, version, publishViewModel6.getPostAction(), categoryParameters).subscribeOn(this.h.io()).observeOn(this.h.mainThread()).subscribe(new a(this, item), new b(this));
        }
    }

    @Nullable
    public final String getPostAction() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel.getPostAction();
    }

    public final void goPrevious() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    public final void initScreen(@NotNull PublishViewModel publishViewModel) {
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        this.d = publishViewModel;
        c();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    public final void onFeesSuccess() {
        MutableLiveData<ViewState> mutableLiveData = this.f;
        String str = this.e;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        ItemBrief item = publishViewModel.getItem();
        mutableLiveData.setValue(new ViewState.FinishEdit(str, item != null ? item.getId() : null));
        this.e = "";
    }

    public final void onRetryClicked() {
        c();
    }

    @NotNull
    public final LiveData<ViewState> screenState() {
        return this.f;
    }
}
