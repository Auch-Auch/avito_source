package com.avito.android.booking.info;

import a2.g.r.g;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.booking.remote.converter.BookingInfoActionConverter;
import com.avito.android.booking.remote.converter.BookingInfoItemConverter;
import com.avito.android.booking.remote.model.BookingInfoModel;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.Event;
import com.avito.android.util.architecture_components.GoBackEvent;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00106\u001a\u00020-¢\u0006\u0004\bB\u0010CJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR(\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\"\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0013R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010/R&\u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u0013\u001a\u0004\b8\u0010\u0015R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/booking/info/BookingInfoViewModel;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", "onButtonClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onRetryClicked", "()V", "onBackClicked", "c", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "f", "Landroidx/lifecycle/MutableLiveData;", "getStateChanges", "()Landroidx/lifecycle/MutableLiveData;", "stateChanges", "Lcom/avito/android/booking/info/ActionButtonState;", g.a, "getActionButtonState", "actionButtonState", "stateLiveData", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "n", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/architecture_components/Event;", "e", "routingEventsLiveData", "d", "actionButtonStateLiveData", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "i", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/booking/info/BookingInfoInteractor;", "j", "Lcom/avito/android/booking/info/BookingInfoInteractor;", "bookingInfoInteractor", "", "p", "Ljava/lang/String;", "itemId", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers3", VKApiConst.Q, BookingInfoActivity.EXTRA_FROM_BLOCK, "h", "getRoutingEvents", "routingEvents", "Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;", "k", "Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;", "bookingInfoItemConverter", "Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;", "l", "Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;", "bookingInfoActionConverter", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/booking/info/BookingInfoInteractor;Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoViewModelImpl extends ViewModel implements BookingInfoViewModel {
    public final MutableLiveData<LoadingState<Unit>> c;
    public final MutableLiveData<ActionButtonState> d;
    public final MutableLiveData<Event<?>> e;
    @NotNull
    public final MutableLiveData<LoadingState<Unit>> f;
    @NotNull
    public final MutableLiveData<ActionButtonState> g;
    @NotNull
    public final MutableLiveData<Event<?>> h;
    public final DeepLinkIntentFactory i;
    public final BookingInfoInteractor j;
    public final BookingInfoItemConverter k;
    public final BookingInfoActionConverter l;
    public final AdapterPresenter m;
    public final TypedErrorThrowableConverter n;
    public final SchedulersFactory3 o;
    public final String p;
    public final String q;

    public static final class a<T> implements Consumer<TypedResult<BookingInfoModel>> {
        public final /* synthetic */ BookingInfoViewModelImpl a;

        public a(BookingInfoViewModelImpl bookingInfoViewModelImpl) {
            this.a = bookingInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r3v10, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<BookingInfoModel> typedResult) {
            TypedResult<BookingInfoModel> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                BookingInfoModel bookingInfoModel = (BookingInfoModel) ((TypedResult.OfResult) typedResult2).getResult();
                a2.b.a.a.a.s1(this.a.k.convert(bookingInfoModel), this.a.m);
                this.a.d.postValue(this.a.l.convert(bookingInfoModel.getAction()));
                this.a.c.postValue(new LoadingState.Loaded(Unit.INSTANCE));
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.c.postValue(new LoadingState.Error(((TypedResult.OfError) typedResult2).getError()));
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ BookingInfoViewModelImpl a;

        public b(BookingInfoViewModelImpl bookingInfoViewModelImpl) {
            this.a = bookingInfoViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            MutableLiveData mutableLiveData = this.a.c;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.n;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            mutableLiveData.postValue(new LoadingState.Error(typedErrorThrowableConverter.convert(th2)));
        }
    }

    public BookingInfoViewModelImpl(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull BookingInfoInteractor bookingInfoInteractor, @NotNull BookingInfoItemConverter bookingInfoItemConverter, @NotNull BookingInfoActionConverter bookingInfoActionConverter, @NotNull AdapterPresenter adapterPresenter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(bookingInfoInteractor, "bookingInfoInteractor");
        Intrinsics.checkNotNullParameter(bookingInfoItemConverter, "bookingInfoItemConverter");
        Intrinsics.checkNotNullParameter(bookingInfoActionConverter, "bookingInfoActionConverter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers3");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_FROM_BLOCK);
        this.i = deepLinkIntentFactory;
        this.j = bookingInfoInteractor;
        this.k = bookingInfoItemConverter;
        this.l = bookingInfoActionConverter;
        this.m = adapterPresenter;
        this.n = typedErrorThrowableConverter;
        this.o = schedulersFactory3;
        this.p = str;
        this.q = str2;
        MutableLiveData<LoadingState<Unit>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<ActionButtonState> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        MutableLiveData<Event<?>> mutableLiveData3 = new MutableLiveData<>();
        this.e = mutableLiveData3;
        this.f = mutableLiveData;
        this.g = mutableLiveData2;
        this.h = mutableLiveData3;
        c();
    }

    public final void c() {
        this.c.setValue(LoadingState.Loading.INSTANCE);
        this.j.loadBookingInfo(this.p, this.q).subscribeOn(this.o.io()).observeOn(this.o.mainThread()).subscribe(new a(this), new b(this));
    }

    @Override // com.avito.android.booking.info.BookingInfoViewModel
    public void onBackClicked() {
        this.e.postValue(new GoBackEvent());
    }

    @Override // com.avito.android.booking.info.BookingInfoViewModel
    public void onButtonClicked(@Nullable DeepLink deepLink) {
        Event<?> event;
        if (deepLink == null) {
            event = new GoBackEvent();
        } else {
            Intent intent = this.i.getIntent(deepLink);
            if (intent != null) {
                event = new StartActivityEvent(new IntentDataHolder(intent, false));
            } else {
                return;
            }
        }
        this.e.postValue(event);
    }

    @Override // com.avito.android.booking.info.BookingInfoViewModel
    public void onRetryClicked() {
        c();
    }

    @Override // com.avito.android.booking.info.BookingInfoViewModel
    @NotNull
    public MutableLiveData<ActionButtonState> getActionButtonState() {
        return this.g;
    }

    @Override // com.avito.android.booking.info.BookingInfoViewModel
    @NotNull
    public MutableLiveData<Event<?>> getRoutingEvents() {
        return this.h;
    }

    @Override // com.avito.android.booking.info.BookingInfoViewModel
    @NotNull
    public MutableLiveData<LoadingState<Unit>> getStateChanges() {
        return this.f;
    }
}
