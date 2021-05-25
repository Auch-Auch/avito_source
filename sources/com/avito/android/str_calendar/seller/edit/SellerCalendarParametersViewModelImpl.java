package com.avito.android.str_calendar.seller.edit;

import a2.a.a.b3.c.b.q;
import a2.a.a.b3.c.b.r;
import a2.a.a.b3.c.b.s;
import a2.a.a.b3.c.b.t;
import a2.a.a.b3.c.b.u;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.StrSellerCalendarParameters;
import com.avito.android.remote.model.category_parameters.GroupParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.str_calendar.seller.edit.view.SellerCalendarParametersItemsDiffUtilCallback;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010t\u001a\u00020q\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010I\u001a\u00020\r\u0012\u0006\u0010M\u001a\u00020J\u0012\b\u0010\u000e\u001a\u0004\u0018\u000103\u0012\b\u0010\u000f\u001a\u0004\u0018\u000103\u0012\u0006\u0010Y\u001a\u00020V¢\u0006\u0004\b~\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0005R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010$R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\r0-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u0010\u000e\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R(\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020807068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020>068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010<R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010$R\"\u0010F\u001a\b\u0012\u0004\u0012\u00020#0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010)\u001a\u0004\bE\u0010+R\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010P\u001a\b\u0012\u0004\u0012\u00020B0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010)\u001a\u0004\bO\u0010+R\"\u0010T\u001a\b\u0012\u0004\u0012\u00020Q068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bR\u0010:\u001a\u0004\bS\u0010<R\u0018\u0010\u000f\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u00105R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010$R\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010$R\"\u0010^\u001a\b\u0012\u0004\u0012\u00020Q0-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010/\u001a\u0004\b]\u00101R\u001c\u0010`\u001a\b\u0012\u0004\u0012\u000208078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010_R\"\u0010d\u001a\b\u0012\u0004\u0012\u00020a0-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bb\u0010/\u001a\u0004\bc\u00101R.\u0010m\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010e8\u0016@VX\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00030'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bn\u0010)\u001a\u0004\bo\u0010+R\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\"\u0010w\u001a\b\u0012\u0004\u0012\u00020\u0003068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bu\u0010:\u001a\u0004\bv\u0010<R\"\u0010z\u001a\b\u0012\u0004\u0012\u00020#0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bx\u0010)\u001a\u0004\by\u0010+R\"\u0010}\u001a\b\u0012\u0004\u0012\u00020\u0003068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b{\u0010:\u001a\u0004\b|\u0010<¨\u0006\u0001"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;", "", "onCleared", "()V", "j", a2.g.r.g.a, "k", "f", "h", "i", "c", "", "startDate", "endDate", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "showContent", "e", "Lcom/avito/android/util/SchedulersFactory;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "submitDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "", "Lcom/avito/conveyor_item/Item;", "Ljava/util/List;", "listItems", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "Lcom/jakewharton/rxrelay2/Relay;", "radioGroupSelectRelay", "chipsSelectRelay", "Lio/reactivex/functions/Consumer;", "x", "Lio/reactivex/functions/Consumer;", "getGetDataConsumer", "()Lio/reactivex/functions/Consumer;", "getDataConsumer", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", VKApiConst.Q, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getErrorMessageChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "errorMessageChanges", "Ljava/util/Date;", "D", "Ljava/util/Date;", "Landroidx/lifecycle/MutableLiveData;", "", "", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/lifecycle/MutableLiveData;", "getGroupsBoundsChanges", "()Landroidx/lifecycle/MutableLiveData;", "groupsBoundsChanges", "Ljava/lang/Runnable;", "p", "getErrorChanges", "errorChanges", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "changeRelay", VKApiConst.VERSION, "getChipsSelectConsumer", "chipsSelectConsumer", "B", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "C", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "parametersConverter", "y", "getChangeConsumer", "changeConsumer", "", "r", "getEnableApplyButtonChanges", "enableApplyButtonChanges", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "F", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "resourceProvider", "applyClicksRelay", "getDataRelay", "s", "getCloseScreenChanges", "closeScreenChanges", "Ljava/util/Set;", "groupsBounds", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "l", "getUpdateViewChanges", "updateViewChanges", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "value", "t", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "adapterPresenter", "u", "getApplyClicksConsumer", "applyClicksConsumer", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", "z", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", "interactor", "n", "getShowContentChanges", "showContentChanges", "w", "getRadioGroupSelectConsumer", "radioGroupSelectConsumer", "o", "getProgressChanges", "progressChanges", "<init>", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;Ljava/util/Date;Ljava/util/Date;Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarParametersViewModelImpl extends ViewModel implements SellerCalendarParametersViewModel {
    public final SchedulersFactory A;
    public final String B;
    public final SellerCalendarParametersConverter C;
    public final Date D;
    public final Date E;
    public final SellerCalendarParamsResourceProvider F;
    public Set<Integer> c = y.emptySet();
    public List<? extends Item> d = CollectionsKt__CollectionsKt.emptyList();
    public final Relay<Unit> e;
    public final Relay<ParameterElement.Select> f;
    public final Relay<ParameterElement.Select> g;
    public final Relay<Unit> h;
    public final Relay<ParameterElement.Input> i;
    public CompositeDisposable j;
    public Disposable k;
    @NotNull
    public final SingleLiveEvent<DiffUtil.DiffResult> l;
    @NotNull
    public final MutableLiveData<Set<Integer>> m;
    @NotNull
    public final MutableLiveData<Unit> n;
    @NotNull
    public final MutableLiveData<Unit> o;
    @NotNull
    public final MutableLiveData<Runnable> p;
    @NotNull
    public final SingleLiveEvent<String> q;
    @NotNull
    public final MutableLiveData<Boolean> r;
    @NotNull
    public final SingleLiveEvent<Boolean> s;
    @Nullable
    public AdapterPresenter t;
    @NotNull
    public final Consumer<Unit> u;
    @NotNull
    public final Consumer<ParameterElement.Select> v;
    @NotNull
    public final Consumer<ParameterElement.Select> w;
    @NotNull
    public final Consumer<Unit> x;
    @NotNull
    public final Consumer<ParameterElement.Input> y;
    public final SellerCalendarParametersInteractor z;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public a(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            SellerCalendarParametersViewModelImpl.access$validateParameters(this.a);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public b(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.f();
        }
    }

    public static final class c<T> implements Consumer<ParameterElement.Select> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public c(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.Select select) {
            String stringId;
            ParameterElement.Select select2 = select;
            SelectableItem selectedValue = select2.getSelectedValue();
            if (selectedValue != null && (stringId = selectedValue.getStringId()) != null) {
                SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(select2, "element");
                SellerCalendarParametersViewModelImpl.access$onElementValueChanged(sellerCalendarParametersViewModelImpl, select2, stringId);
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public d(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.g();
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public e(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            if (this.a.d.isEmpty()) {
                SellerCalendarParametersViewModelImpl.access$getData(this.a);
            }
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public f(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            SellerCalendarParametersViewModelImpl.access$showFullScreenError(this.a, new s(this));
            this.a.h();
        }
    }

    public static final class g<T> implements Consumer<ParameterElement.Input> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public g(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.Input input) {
            ParameterElement.Input input2 = input;
            String value = input2.getValue();
            if (value != null) {
                SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(input2, "element");
                SellerCalendarParametersViewModelImpl.access$onElementValueChanged(sellerCalendarParametersViewModelImpl, input2, value);
            }
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public h(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.i();
        }
    }

    public static final class i<T> implements Consumer<Pair<? extends List<? extends Item>, ? extends Set<? extends Integer>>> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public i(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends List<? extends Item>, ? extends Set<? extends Integer>> pair) {
            Pair<? extends List<? extends Item>, ? extends Set<? extends Integer>> pair2 = pair;
            AdapterPresenter adapterPresenter = this.a.getAdapterPresenter();
            if (adapterPresenter != null) {
                adapterPresenter.onDataSourceChanged(new ListDataSource((List) pair2.getFirst()));
            }
            SingleLiveEvent<DiffUtil.DiffResult> updateViewChanges = this.a.getUpdateViewChanges();
            SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl = this.a;
            updateViewChanges.setValue(SellerCalendarParametersViewModelImpl.access$calculateDiff(sellerCalendarParametersViewModelImpl, sellerCalendarParametersViewModelImpl.d, (List) pair2.getFirst()));
            this.a.d = (List) pair2.getFirst();
            this.a.c = (Set) pair2.getSecond();
            this.a.getGroupsBoundsChanges().setValue(this.a.c);
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public j(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.j();
        }
    }

    public static final class k<T> implements Consumer<ParameterElement.Select> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public k(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.Select select) {
            String stringId;
            ParameterElement.Select select2 = select;
            SelectableItem selectedValue = select2.getSelectedValue();
            if (selectedValue != null && (stringId = selectedValue.getStringId()) != null) {
                SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(select2, "element");
                SellerCalendarParametersViewModelImpl.access$onElementValueChanged(sellerCalendarParametersViewModelImpl, select2, stringId);
            }
        }
    }

    public static final class l<T> implements Consumer<Throwable> {
        public final /* synthetic */ SellerCalendarParametersViewModelImpl a;

        public l(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
            this.a = sellerCalendarParametersViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.getErrorMessageChanges().postValue(this.a.F.getErrorOccurred());
            this.a.k();
        }
    }

    public SellerCalendarParametersViewModelImpl(@NotNull SellerCalendarParametersInteractor sellerCalendarParametersInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull SellerCalendarParametersConverter sellerCalendarParametersConverter, @Nullable Date date, @Nullable Date date2, @NotNull SellerCalendarParamsResourceProvider sellerCalendarParamsResourceProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarParametersInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(sellerCalendarParametersConverter, "parametersConverter");
        Intrinsics.checkNotNullParameter(sellerCalendarParamsResourceProvider, "resourceProvider");
        this.z = sellerCalendarParametersInteractor;
        this.A = schedulersFactory;
        this.B = str;
        this.C = sellerCalendarParametersConverter;
        this.D = date;
        this.E = date2;
        this.F = sellerCalendarParamsResourceProvider;
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.e = create;
        BehaviorRelay create2 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "BehaviorRelay.create()");
        this.f = create2;
        BehaviorRelay create3 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "BehaviorRelay.create()");
        this.g = create3;
        BehaviorRelay create4 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "BehaviorRelay.create()");
        this.h = create4;
        BehaviorRelay create5 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "BehaviorRelay.create()");
        this.i = create5;
        this.j = new CompositeDisposable();
        this.l = new SingleLiveEvent<>();
        this.m = new MutableLiveData<>();
        this.n = new MutableLiveData<>();
        this.o = new MutableLiveData<>();
        this.p = new MutableLiveData<>();
        this.q = new SingleLiveEvent<>();
        this.r = new MutableLiveData<>();
        this.s = new SingleLiveEvent<>();
        this.u = create;
        this.v = create2;
        this.w = create3;
        this.x = create4;
        this.y = create5;
        getEnableApplyButtonChanges().setValue(Boolean.FALSE);
        j();
        g();
        k();
        f();
        h();
        i();
        e();
    }

    public static final DiffUtil.DiffResult access$calculateDiff(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl, List list, List list2) {
        Objects.requireNonNull(sellerCalendarParametersViewModelImpl);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SellerCalendarParametersItemsDiffUtilCallback(list, list2));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(diffCallback)");
        return calculateDiff;
    }

    public static final void access$getData(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
        Date date = sellerCalendarParametersViewModelImpl.D;
        if (date != null && sellerCalendarParametersViewModelImpl.E != null) {
            sellerCalendarParametersViewModelImpl.d(StrDateUtilsKt.convertToStrDate(date), StrDateUtilsKt.convertToStrDate(sellerCalendarParametersViewModelImpl.E));
        } else if (date != null) {
            String convertToStrDate = StrDateUtilsKt.convertToStrDate(date);
            sellerCalendarParametersViewModelImpl.d(convertToStrDate, convertToStrDate);
        } else {
            sellerCalendarParametersViewModelImpl.c();
        }
    }

    public static final void access$onElementValueChanged(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl, Item item, String str) {
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(sellerCalendarParametersViewModelImpl.getEnableApplyButtonChanges().getValue(), bool)) {
            sellerCalendarParametersViewModelImpl.getEnableApplyButtonChanges().setValue(bool);
        }
        sellerCalendarParametersViewModelImpl.C.onParameterValueChanged(item.getStringId(), str);
    }

    public static final void access$onParametersLoaded(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl, StrSellerCalendarParameters strSellerCalendarParameters) {
        Objects.requireNonNull(sellerCalendarParametersViewModelImpl);
        List<GroupParameter> formFields = strSellerCalendarParameters.getFormFields();
        if (formFields != null) {
            sellerCalendarParametersViewModelImpl.C.convert(formFields);
            sellerCalendarParametersViewModelImpl.showContent();
            return;
        }
        throw new IllegalStateException("Form fields in server response are null");
    }

    public static final void access$onValidateInfoLoaded(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl, Map map) {
        sellerCalendarParametersViewModelImpl.C.setErrorsMap(map);
        if (map.isEmpty()) {
            Disposable disposable = sellerCalendarParametersViewModelImpl.k;
            if (disposable != null) {
                disposable.dispose();
            }
            SellerCalendarParametersInteractor sellerCalendarParametersInteractor = sellerCalendarParametersViewModelImpl.z;
            String str = sellerCalendarParametersViewModelImpl.B;
            Map<String, String> convertToMap = sellerCalendarParametersViewModelImpl.C.convertToMap();
            Date date = sellerCalendarParametersViewModelImpl.D;
            String str2 = null;
            String convertToStrDate = date != null ? StrDateUtilsKt.convertToStrDate(date) : null;
            Date date2 = sellerCalendarParametersViewModelImpl.E;
            if (date2 != null) {
                str2 = StrDateUtilsKt.convertToStrDate(date2);
            }
            sellerCalendarParametersViewModelImpl.k = sellerCalendarParametersInteractor.submitParameters(str, convertToMap, convertToStrDate, str2).observeOn(sellerCalendarParametersViewModelImpl.A.mainThread()).subscribe(new q(sellerCalendarParametersViewModelImpl), new r(sellerCalendarParametersViewModelImpl));
        }
    }

    public static final void access$showFullScreenError(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl, Runnable runnable) {
        sellerCalendarParametersViewModelImpl.getShowContentChanges().setValue(null);
        sellerCalendarParametersViewModelImpl.getErrorChanges().setValue(runnable);
        sellerCalendarParametersViewModelImpl.getProgressChanges().setValue(null);
    }

    public static final void access$validateParameters(SellerCalendarParametersViewModelImpl sellerCalendarParametersViewModelImpl) {
        ParametersTree parametersTree = sellerCalendarParametersViewModelImpl.C.getParametersTree();
        if (parametersTree != null) {
            Disposable subscribe = sellerCalendarParametersViewModelImpl.z.validateFields(parametersTree).observeOn(sellerCalendarParametersViewModelImpl.A.mainThread()).subscribe(new t(sellerCalendarParametersViewModelImpl), new u(sellerCalendarParametersViewModelImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.validateField…          }\n            )");
            DisposableKt.addTo(subscribe, sellerCalendarParametersViewModelImpl.j);
        }
    }

    public final void c() {
        Disposable subscribe = this.z.getSellerCalendarBaseParameters(this.B).observeOn(this.A.mainThread()).subscribe(new SellerCalendarParametersViewModelImpl$subscribeToParams$1(this), new SellerCalendarParametersViewModelImpl$subscribeToParams$2(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(schedulers.mai…          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void d(String str, String str2) {
        Disposable subscribe = this.z.getSellerCalendarRangeParameters(this.B, str, str2).observeOn(this.A.mainThread()).subscribe(new SellerCalendarParametersViewModelImpl$subscribeToParams$1(this), new SellerCalendarParametersViewModelImpl$subscribeToParams$2(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(schedulers.mai…          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void e() {
        getShowContentChanges().setValue(null);
        getErrorChanges().setValue(null);
        getProgressChanges().setValue(Unit.INSTANCE);
    }

    public final void f() {
        Disposable subscribe = this.e.throttleFirst(1, TimeUnit.SECONDS).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "applyClicksRelay\n       …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void g() {
        Disposable subscribe = this.f.observeOn(this.A.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "chipsSelectRelay\n       …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @Nullable
    public AdapterPresenter getAdapterPresenter() {
        return this.t;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public Consumer<Unit> getApplyClicksConsumer() {
        return this.u;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public Consumer<ParameterElement.Input> getChangeConsumer() {
        return this.y;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public Consumer<ParameterElement.Select> getChipsSelectConsumer() {
        return this.v;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public Consumer<Unit> getGetDataConsumer() {
        return this.x;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public Consumer<ParameterElement.Select> getRadioGroupSelectConsumer() {
        return this.w;
    }

    public final void h() {
        Disposable subscribe = this.h.subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "getDataRelay\n           …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void i() {
        Disposable subscribe = this.i.subscribe(new g(this), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "changeRelay\n            …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void j() {
        Disposable subscribe = this.C.getItemsObservable().observeOn(this.A.mainThread()).subscribe(new i(this), new j(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "parametersConverter.item…          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    public final void k() {
        Disposable subscribe = this.g.observeOn(this.A.mainThread()).subscribe(new k(this), new l(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "radioGroupSelectRelay\n  …          }\n            )");
        DisposableKt.addTo(subscribe, this.j);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.j.clear();
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    public void setAdapterPresenter(@Nullable AdapterPresenter adapterPresenter) {
        this.t = adapterPresenter;
        if (adapterPresenter != null) {
            adapterPresenter.onDataSourceChanged(new ListDataSource(this.d));
        }
    }

    public final void showContent() {
        getShowContentChanges().setValue(Unit.INSTANCE);
        getErrorChanges().setValue(null);
        getProgressChanges().setValue(null);
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public SingleLiveEvent<Boolean> getCloseScreenChanges() {
        return this.s;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public MutableLiveData<Boolean> getEnableApplyButtonChanges() {
        return this.r;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public MutableLiveData<Runnable> getErrorChanges() {
        return this.p;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public SingleLiveEvent<String> getErrorMessageChanges() {
        return this.q;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public MutableLiveData<Set<Integer>> getGroupsBoundsChanges() {
        return this.m;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public MutableLiveData<Unit> getProgressChanges() {
        return this.o;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public MutableLiveData<Unit> getShowContentChanges() {
        return this.n;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel
    @NotNull
    public SingleLiveEvent<DiffUtil.DiffResult> getUpdateViewChanges() {
        return this.l;
    }
}
