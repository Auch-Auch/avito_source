package com.avito.android.short_term_rent.confirm_booking;

import a2.a.a.v2.a.k;
import a2.a.a.v2.a.l;
import a2.a.a.v2.a.m;
import a2.a.a.v2.a.n;
import a2.a.a.v2.a.o;
import a2.a.a.v2.a.p;
import a2.g.r.g;
import android.os.Bundle;
import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.StrBookingPaymentFailureLink;
import com.avito.android.items.InputItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.StrBookingCalculationReviewResponse;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.EmailParameter;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.short_term_rent.analytics.NonFatalAnalyticsTracker;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.confirm_booking.items.ValidationErrorsItemFactory;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProvider;
import com.avito.android.short_term_rent.confirm_booking.utils.StrContactsTreeConverter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002Bp\u0012\u0006\u0010t\u001a\u00020q\u0012\u0006\u0010f\u001a\u00020c\u0012\u0007\u0010\u0001\u001a\u00020\u000f\u0012\u0006\u0010D\u001a\u00020\u000f\u0012\u0007\u0010\u0001\u001a\u00020\u000f\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010T\u001a\u00020Q\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010L\u001a\u00020I\u0012\u0007\u0010\u0001\u001a\u00020¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b'\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00104\u001a\b\u0012\u0004\u0012\u00020\u001f0,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u0010.\u001a\u0004\b3\u00100R\"\u0010;\u001a\b\u0012\u0004\u0012\u000206058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010>\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010.\u001a\u0004\b@\u00100R\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000f0,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010.\u001a\u0004\bZ\u00100R\"\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000f0,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010.\u001a\u0004\b]\u00100R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020E0m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010v\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010iR\u0018\u0010x\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010iR(\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0y058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u00108\u001a\u0004\bz\u0010:R\"\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00050,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b|\u0010.\u001a\u0004\b}\u00100R\u0019\u0010\u0001\u001a\u000208\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130y8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010oR\u0018\u0010\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010CR\u0018\u0010\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010C¨\u0006\u0001"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", "", "requestUrlIfSuccess", "", "c", "(Z)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "getBookingCalculationReview", "()V", "onCleared", "", "id", "onItemButtonClicked", "(Ljava/lang/String;)V", "Lcom/avito/conveyor_item/Item;", "element", "newValue", "onElementValueChanged", "(Lcom/avito/conveyor_item/Item;Ljava/lang/String;)V", "Lcom/avito/android/items/InputItem;", "onElementErrorDismissed", "(Lcom/avito/android/items/InputItem;)V", "url", "onUrlClick", "(Ljava/lang/String;)Z", "success", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onCompletePaymentResult", "(ZLcom/avito/android/deep_linking/links/DeepLink;)V", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onRestoreInstanceState", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "analyticsTracker", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getErrorMessageChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "errorMessageChanges", "j", "getDeepLinkChanges", "deepLinkChanges", "Landroidx/lifecycle/MutableLiveData;", "Ljava/lang/Runnable;", g.a, "Landroidx/lifecycle/MutableLiveData;", "getErrorChanges", "()Landroidx/lifecycle/MutableLiveData;", "errorChanges", "t", "Ljava/lang/Runnable;", "validateRunnable", "e", "getProgressChanges", "progressChanges", "x", "Ljava/lang/String;", "checkInDate", "", "z", "I", "guestsCount", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", "contactsTreeConverter", "", "o", "Ljava/util/Map;", "errorsMap", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "B", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "Landroid/os/Handler;", "s", "Landroid/os/Handler;", "validateHandler", "i", "getPayUrlChanges", "payUrlChanges", "h", "getUrlClickChanges", "urlClickChanges", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "n", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "contactsParamsTree", "Lcom/avito/android/util/SchedulersFactory;", VKApiConst.VERSION, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/disposables/Disposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/Disposable;", "requestPayUrlDisposable", "r", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "", "p", "Ljava/util/List;", "dividers", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;", "u", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;", "interactor", "l", "validateDisposable", "k", "reviewDisposable", "", "getDividersChanges", "dividersChanges", "d", "getShowContentChanges", "showContentChanges", "Lcom/avito/android/short_term_rent/analytics/NonFatalAnalyticsTracker;", "F", "Lcom/avito/android/short_term_rent/analytics/NonFatalAnalyticsTracker;", "nonFatalAnalyticsTracker", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;", "D", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;", "resourceProvider", "Lcom/avito/android/util/text/AttributedTextFormatter;", "C", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", VKApiConst.Q, "listItems", "y", "checkOutDate", "w", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;Lcom/avito/android/short_term_rent/analytics/NonFatalAnalyticsTracker;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrConfirmBookingViewModelImpl extends ViewModel implements StrConfirmBookingViewModel {
    public final StrAnalyticsTracker A;
    public final CategoryParametersElementConverter B;
    public final AttributedTextFormatter C;
    public final StrConfirmBookingResourceProvider D;
    public final StrContactsTreeConverter E;
    public final NonFatalAnalyticsTracker F;
    @NotNull
    public final MutableLiveData<List<Integer>> c = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<Unit> d = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> e = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> f = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<Runnable> g = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<String> h = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> i = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> j = new SingleLiveEvent<>();
    public Disposable k;
    public Disposable l;
    public Disposable m;
    public SimpleParametersTree n;
    public Map<String, String> o = r.emptyMap();
    public final List<Integer> p = new ArrayList();
    public List<? extends Item> q = CollectionsKt__CollectionsKt.emptyList();
    public AdapterPresenter r;
    public final Handler s = new Handler();
    public Runnable t = new f(this);
    public final StrConfirmBookingInteractor u;
    public final SchedulersFactory v;
    public final String w;
    public final String x;
    public final String y;
    public final int z;

    public static final class a<T, R> implements Function<LoadingState<? super StrBookingCalculationReviewResponse>, LoadingState<? super List<? extends Item>>> {
        public final /* synthetic */ StrConfirmBookingViewModelImpl a;

        public a(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl) {
            this.a = strConfirmBookingViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super List<? extends Item>> apply(LoadingState<? super StrBookingCalculationReviewResponse> loadingState) {
            LoadingState<? super StrBookingCalculationReviewResponse> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return StrConfirmBookingViewModelImpl.access$convertToListItems(this.a, loadingState2);
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super List<? extends Item>>> {
        public final /* synthetic */ StrConfirmBookingViewModelImpl a;

        public b(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl) {
            this.a = strConfirmBookingViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super List<? extends Item>> loadingState) {
            LoadingState<? super List<? extends Item>> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                StrConfirmBookingViewModelImpl.access$showProgress(this.a);
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.getDividersChanges().setValue(this.a.p);
                StrConfirmBookingViewModelImpl.access$updateView(this.a, (List) ((LoadingState.Loaded) loadingState2).getData());
                StrConfirmBookingViewModelImpl.access$showContent(this.a);
            } else if (loadingState2 instanceof LoadingState.Error) {
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (error instanceof ErrorWithMessage) {
                    this.a.getErrorMessageChanges().setValue(((ErrorWithMessage) error).getMessage());
                }
                this.a.getErrorChanges().setValue(new k(this));
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ StrConfirmBookingViewModelImpl a;

        public c(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl) {
            this.a = strConfirmBookingViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getErrorChanges().setValue(new l(this));
        }
    }

    public static final class d<T> implements Consumer<LoadingState<? super Map<String, ? extends String>>> {
        public final /* synthetic */ StrConfirmBookingViewModelImpl a;
        public final /* synthetic */ boolean b;

        public d(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl, boolean z) {
            this.a = strConfirmBookingViewModelImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super Map<String, ? extends String>> loadingState) {
            LoadingState<? super Map<String, ? extends String>> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                StrConfirmBookingViewModelImpl.access$onValidationInfoLoaded(this.a, (Map) ((LoadingState.Loaded) loadingState2).getData(), this.b);
            } else if (loadingState2 instanceof LoadingState.Error) {
                StrConfirmBookingViewModelImpl.access$onError(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ StrConfirmBookingViewModelImpl a;

        public e(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl, boolean z) {
            this.a = strConfirmBookingViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getErrorMessageChanges().setValue(this.a.D.getErrorOccurred());
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ StrConfirmBookingViewModelImpl a;

        public f(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl) {
            this.a = strConfirmBookingViewModelImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c(false);
        }
    }

    public StrConfirmBookingViewModelImpl(@NotNull StrConfirmBookingInteractor strConfirmBookingInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, @NotNull StrAnalyticsTracker strAnalyticsTracker, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull StrConfirmBookingResourceProvider strConfirmBookingResourceProvider, @NotNull StrContactsTreeConverter strContactsTreeConverter, @NotNull NonFatalAnalyticsTracker nonFatalAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(strConfirmBookingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkInDate");
        Intrinsics.checkNotNullParameter(str3, "checkOutDate");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(strConfirmBookingResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(strContactsTreeConverter, "contactsTreeConverter");
        Intrinsics.checkNotNullParameter(nonFatalAnalyticsTracker, "nonFatalAnalyticsTracker");
        this.u = strConfirmBookingInteractor;
        this.v = schedulersFactory;
        this.w = str;
        this.x = str2;
        this.y = str3;
        this.z = i2;
        this.A = strAnalyticsTracker;
        this.B = categoryParametersElementConverter;
        this.C = attributedTextFormatter;
        this.D = strConfirmBookingResourceProvider;
        this.E = strContactsTreeConverter;
        this.F = nonFatalAnalyticsTracker;
        getBookingCalculationReview();
        strAnalyticsTracker.trackShowConfirmBookingScreenEvent();
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x023e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.util.LoadingState access$convertToListItems(com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelImpl r17, com.avito.android.util.LoadingState r18) {
        /*
        // Method dump skipped, instructions count: 591
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelImpl.access$convertToListItems(com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelImpl, com.avito.android.util.LoadingState):com.avito.android.util.LoadingState");
    }

    public static final void access$onError(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl, TypedError typedError) {
        Objects.requireNonNull(strConfirmBookingViewModelImpl);
        if (typedError instanceof ErrorWithMessage) {
            strConfirmBookingViewModelImpl.getErrorMessageChanges().setValue(((ErrorWithMessage) typedError).getMessage());
        } else {
            strConfirmBookingViewModelImpl.getErrorChanges().setValue(m.a);
        }
    }

    public static final void access$onValidationInfoLoaded(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl, Map map, boolean z2) {
        strConfirmBookingViewModelImpl.o = map;
        int i2 = 0;
        if (!map.isEmpty() || !z2) {
            SimpleParametersTree simpleParametersTree = strConfirmBookingViewModelImpl.n;
            if (simpleParametersTree != null) {
                List convert$default = CategoryParametersElementConverter.convert$default(strConfirmBookingViewModelImpl.B, simpleParametersTree, new ValidationErrorsItemFactory(map), null, 4, null);
                List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) strConfirmBookingViewModelImpl.q);
                Iterator<? extends Item> it = mutableList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (((Item) it.next()) instanceof ParameterElement.Input) {
                        break;
                    } else {
                        i2++;
                    }
                }
                h.removeAll((List) mutableList, (Function1) p.a);
                mutableList.addAll(i2, convert$default);
                if (!strConfirmBookingViewModelImpl.p.isEmpty()) {
                    List<Integer> list = strConfirmBookingViewModelImpl.p;
                    list.remove(list.size() - 1);
                }
                if (i2 > 0 || !convert$default.isEmpty()) {
                    strConfirmBookingViewModelImpl.p.add(Integer.valueOf((convert$default.size() + i2) - 1));
                }
                strConfirmBookingViewModelImpl.getDividersChanges().setValue(strConfirmBookingViewModelImpl.p);
                AdapterPresenter adapterPresenter = strConfirmBookingViewModelImpl.r;
                if (adapterPresenter != null) {
                    a2.b.a.a.a.s1(mutableList, adapterPresenter);
                }
                strConfirmBookingViewModelImpl.q = mutableList;
                return;
            }
            return;
        }
        strConfirmBookingViewModelImpl.A.trackConfirmBookingSubmitEvent();
        SimpleParametersTree simpleParametersTree2 = strConfirmBookingViewModelImpl.n;
        if (simpleParametersTree2 != null) {
            Disposable disposable = strConfirmBookingViewModelImpl.m;
            if (disposable != null) {
                disposable.dispose();
            }
            strConfirmBookingViewModelImpl.m = strConfirmBookingViewModelImpl.u.requestPayUrl(strConfirmBookingViewModelImpl.E.convertToMap(simpleParametersTree2), strConfirmBookingViewModelImpl.z, strConfirmBookingViewModelImpl.w, r.mapOf(TuplesKt.to("range[start]", strConfirmBookingViewModelImpl.x), TuplesKt.to("range[end]", strConfirmBookingViewModelImpl.y)), r.mapOf(TuplesKt.to("redirect[on][success]", "chat"), TuplesKt.to("redirect[on][failure]", "none"))).observeOn(strConfirmBookingViewModelImpl.v.mainThread()).subscribe(new n(strConfirmBookingViewModelImpl), new o(strConfirmBookingViewModelImpl));
        }
    }

    public static final void access$showContent(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl) {
        strConfirmBookingViewModelImpl.getShowContentChanges().setValue(Unit.INSTANCE);
    }

    public static final void access$showProgress(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl) {
        strConfirmBookingViewModelImpl.getProgressChanges().setValue(Unit.INSTANCE);
    }

    public static final void access$updateView(StrConfirmBookingViewModelImpl strConfirmBookingViewModelImpl, List list) {
        AdapterPresenter adapterPresenter = strConfirmBookingViewModelImpl.r;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(list, adapterPresenter);
        }
        strConfirmBookingViewModelImpl.q = list;
    }

    public final void c(boolean z2) {
        SimpleParametersTree simpleParametersTree = this.n;
        if (simpleParametersTree != null) {
            Disposable disposable = this.l;
            if (disposable != null) {
                disposable.dispose();
            }
            this.l = this.u.validateFields(simpleParametersTree).observeOn(this.v.mainThread()).subscribe(new d(this, z2), new e(this, z2));
        }
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    public void getBookingCalculationReview() {
        this.k = this.u.getBookingCalculationReview(this.x, this.y, this.z, this.w).map(new a(this)).observeOn(this.v.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.l;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.m;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.s.removeCallbacksAndMessages(null);
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    public void onCompletePaymentResult(boolean z2, @Nullable DeepLink deepLink) {
        getShowContentChanges().setValue(Unit.INSTANCE);
        if (!z2) {
            return;
        }
        if (deepLink == null) {
            getErrorMessageChanges().setValue(this.D.getUnexpectedPaymentError());
        } else if (deepLink instanceof StrBookingPaymentFailureLink) {
            getErrorMessageChanges().setValue(((StrBookingPaymentFailureLink) deepLink).getMessage());
        } else {
            getDeepLinkChanges().setValue(deepLink);
        }
    }

    @Override // com.avito.android.blueprints.InputItemPresenter.Listener
    public void onElementErrorDismissed(@NotNull InputItem inputItem) {
        Intrinsics.checkNotNullParameter(inputItem, "element");
    }

    @Override // com.avito.android.blueprints.InputItemPresenter.Listener
    public void onElementValueChanged(@NotNull Item item, @NotNull String str) {
        Intrinsics.checkNotNullParameter(item, "element");
        Intrinsics.checkNotNullParameter(str, "newValue");
        String stringId = item.getStringId();
        SimpleParametersTree simpleParametersTree = this.n;
        ParameterSlot findParameter = simpleParametersTree != null ? simpleParametersTree.findParameter(stringId) : null;
        if (findParameter == null) {
            findParameter = null;
        }
        if (findParameter != null) {
            if (findParameter instanceof CharParameter) {
                EditableParameter editableParameter = (EditableParameter) findParameter;
                if (!Intrinsics.areEqual(editableParameter.getValue(), str)) {
                    editableParameter.setValue(str);
                    editableParameter.setError(null);
                }
            } else if (findParameter instanceof PhoneParameter) {
                EditableParameter editableParameter2 = (EditableParameter) findParameter;
                if (!Intrinsics.areEqual(editableParameter2.getValue(), str)) {
                    editableParameter2.setValue(str);
                    editableParameter2.setError(null);
                }
            } else if (findParameter instanceof EmailParameter) {
                EditableParameter editableParameter3 = (EditableParameter) findParameter;
                if (!Intrinsics.areEqual(editableParameter3.getValue(), str)) {
                    editableParameter3.setValue(str);
                    editableParameter3.setError(null);
                }
            }
            this.s.removeCallbacks(this.t);
            this.s.postDelayed(this.t, 1000);
        }
    }

    @Override // com.avito.android.blueprints.ButtonItemPresenter.Listener
    public void onItemButtonClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.s.removeCallbacks(this.t);
        c(true);
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    public void onRestoreInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        SimpleParametersTree simpleParametersTree = (SimpleParametersTree) bundle.getParcelable("bundle_contacts_tree");
        if (simpleParametersTree != null) {
            this.n = simpleParametersTree;
        }
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        SimpleParametersTree simpleParametersTree = this.n;
        if (simpleParametersTree != null) {
            bundle.putParcelable("bundle_contacts_tree", simpleParametersTree);
        }
    }

    @Override // com.avito.android.deep_linking.links.OnUrlClickListener
    public boolean onUrlClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        getUrlClickChanges().setValue(str);
        return true;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.r = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.q));
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getDeepLinkChanges() {
        return this.j;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    @NotNull
    public MutableLiveData<List<Integer>> getDividersChanges() {
        return this.c;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    @NotNull
    public MutableLiveData<Runnable> getErrorChanges() {
        return this.g;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    @NotNull
    public SingleLiveEvent<String> getErrorMessageChanges() {
        return this.f;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    @NotNull
    public SingleLiveEvent<String> getPayUrlChanges() {
        return this.i;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    @NotNull
    public SingleLiveEvent<Unit> getProgressChanges() {
        return this.e;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    @NotNull
    public SingleLiveEvent<Unit> getShowContentChanges() {
        return this.d;
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel
    @NotNull
    public SingleLiveEvent<String> getUrlClickChanges() {
        return this.h;
    }
}
