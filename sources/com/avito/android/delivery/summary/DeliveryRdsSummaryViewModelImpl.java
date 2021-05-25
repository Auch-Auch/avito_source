package com.avito.android.delivery.summary;

import a2.a.a.k0.e.a0;
import a2.a.a.k0.e.b0;
import a2.a.a.k0.e.d0;
import a2.a.a.k0.e.e0;
import a2.a.a.k0.e.f0;
import a2.a.a.k0.e.g0;
import a2.a.a.k0.e.w;
import a2.a.a.k0.e.x;
import a2.a.a.k0.e.y;
import a2.a.a.k0.e.z;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.SummaryState;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeliveryOrderPaymentFailureLink;
import com.avito.android.delivery.analytics.summary.ChangeType;
import com.avito.android.delivery.analytics.summary.DeliveryPaymentSuccessfulEvent;
import com.avito.android.delivery.analytics.summary.ItemQuantityChangedEvent;
import com.avito.android.delivery.analytics.summary.StepperIsShownEvent;
import com.avito.android.delivery.summary.ChangeAction;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverterKt;
import com.avito.android.delivery.summary.konveyor.button.ButtonItem;
import com.avito.android.delivery.summary.konveyor.button.ButtonState;
import com.avito.android.delivery.summary.konveyor.price.PriceItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.UrlResult;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.delivery.DeliverySpecificQuantityState;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.delivery.OrderIdResult;
import com.avito.android.remote.model.text.Attribute;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import io.reactivex.rxjava3.kotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bv\u0012\b\u0010Ø\u0001\u001a\u00030Õ\u0001\u0012\b\u0010§\u0001\u001a\u00030¤\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010Ç\u0001\u001a\u00030Ä\u0001\u0012\u0007\u0010\u0001\u001a\u00020\u0012\t\u0010²\u0001\u001a\u0004\u0018\u00010(\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010Ü\u0001\u001a\u00030Ù\u0001\u0012\t\u0010ì\u0001\u001a\u0004\u0018\u00010D\u0012\u0006\u0010~\u001a\u000206\u0012\b\u0010ë\u0001\u001a\u00030è\u0001¢\u0006\u0006\bí\u0001\u0010î\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u001d\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J#\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u001d\u0010\u001d\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\nH\u0002¢\u0006\u0004\b\u001d\u0010\u000eJ\u001f\u0010\"\u001a\u00020!*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0002¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020 *\u00020 H\u0002¢\u0006\u0004\b$\u0010%J9\u0010*\u001a\b\u0012\u0004\u0012\u00020&0\n*\b\u0012\u0004\u0012\u00020&0\n2\u0018\b\u0002\u0010)\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010'H\u0002¢\u0006\u0004\b*\u0010+J\u0013\u0010-\u001a\u00020\u0003*\u00020,H\u0003¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020(H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J!\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u0002062\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00032\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010B\u001a\u00020\u00032\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u0011\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bE\u0010FJ-\u0010J\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010(2\b\u0010H\u001a\u0004\u0018\u00010(2\b\u0010I\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0003H\u0014¢\u0006\u0004\bL\u0010\u0005R\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00030M8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010N\u001a\u0004\bO\u0010PR\"\u0010X\u001a\b\u0012\u0004\u0012\u00020S0R8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010ZR$\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140R8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010U\u001a\u0004\b]\u0010WR\u001c\u0010`\u001a\b\u0012\u0004\u0012\u0002060R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010UR\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020>0Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010ZR.\u0010h\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u0002060c0b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR$\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010e\u001a\u0004\bj\u0010gR\"\u0010m\u001a\b\u0012\u0004\u0012\u00020(0M8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010N\u001a\u0004\bl\u0010PR\"\u0010o\u001a\b\u0012\u0004\u0012\u00020>0M8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010N\u001a\u0004\bn\u0010PR\"\u0010r\u001a\b\u0012\u0004\u0012\u00020p0M8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010N\u001a\u0004\bq\u0010PR\u001c\u0010s\u001a\b\u0012\u0004\u0012\u00020p0Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010ZR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010uR\"\u0010y\u001a\b\u0012\u0004\u0012\u00020w0M8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010N\u001a\u0004\bx\u0010PR\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020z0Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010ZR\u0016\u0010~\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010}R\u0019\u0010\u0001\u001a\u000208\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030R8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010U\u001a\u0005\b\u0001\u0010WR\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002060Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010ZR\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\u0007\n\u0005\b\"\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020w0Y8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010ZR\u001b\u0010\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\u0012\u0012\r\u0012\u000b \u0001*\u0004\u0018\u000106060\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R1\u0010 \u0001\u001a\u0012\u0012\r\u0012\u000b \u0001*\u0004\u0018\u000106060\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R%\u0010£\u0001\u001a\b\u0012\u0004\u0012\u0002060b8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b¡\u0001\u0010e\u001a\u0005\b¢\u0001\u0010gR\u001a\u0010§\u0001\u001a\u00030¤\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R%\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u0002080b8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b¨\u0001\u0010e\u001a\u0005\b©\u0001\u0010gR%\u0010­\u0001\u001a\b\u0012\u0004\u0012\u00020(0b8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b«\u0001\u0010e\u001a\u0005\b¬\u0001\u0010gR\u001b\u0010°\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001b\u0010²\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b±\u0001\u0010¯\u0001R\u001d\u0010´\u0001\u001a\u000206*\u00020\u001b8B@\u0002X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010³\u0001R\u001e\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u0002060R8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bµ\u0001\u0010UR%\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020>0R8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b·\u0001\u0010U\u001a\u0005\b¸\u0001\u0010WR(\u0010½\u0001\u001a\u0002062\u0007\u0010º\u0001\u001a\u0002068\u0016@RX\u000e¢\u0006\u000e\n\u0004\b\u001d\u0010}\u001a\u0006\b»\u0001\u0010¼\u0001R\u0018\u0010¾\u0001\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010·\u0001R'\u0010Á\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030R8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b¿\u0001\u0010U\u001a\u0005\bÀ\u0001\u0010WR\u001a\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001a\u0010Ç\u0001\u001a\u00030Ä\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R$\u0010É\u0001\u001a\b\u0012\u0004\u0012\u0002060M8\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b\u0007\u0010N\u001a\u0005\bÈ\u0001\u0010PR&\u0010Í\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010b8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bË\u0001\u0010e\u001a\u0005\bÌ\u0001\u0010gR&\u0010Ñ\u0001\u001a\t\u0012\u0005\u0012\u00030Î\u00010R8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bÏ\u0001\u0010U\u001a\u0005\bÐ\u0001\u0010WR\u001d\u0010Ò\u0001\u001a\b\u0012\u0004\u0012\u00020(0Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010ZR$\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020z0M8\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b$\u0010N\u001a\u0005\bÓ\u0001\u0010PR\u001a\u0010Ø\u0001\u001a\u00030Õ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u001a\u0010Ü\u0001\u001a\u00030Ù\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010Þ\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b*\u0010Ý\u0001R\u001c\u0010á\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001f\u0010ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\n8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R%\u0010ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030b8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bå\u0001\u0010e\u001a\u0005\bæ\u0001\u0010gR\u001a\u0010ë\u0001\u001a\u00030è\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001¨\u0006ï\u0001"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;", "", "p", "()V", "n", "r", "o", VKApiConst.Q, "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Calculation;", "prices", "s", "(Ljava/util/List;)V", "f", "showContent", "j", "Lcom/avito/android/remote/error/TypedError;", "error", "Ljava/lang/Runnable;", "retryRunnable", "i", "(Lcom/avito/android/remote/error/TypedError;Ljava/lang/Runnable;)V", "h", "(Lcom/avito/android/remote/error/TypedError;)V", "l", "Lcom/avito/conveyor_item/Item;", "items", "u", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.OPEN_CHANNEL_LIST, "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/disposables/Disposable;", "t", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;)Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "", "valuesMap", "d", "(Ljava/util/List;Ljava/util/Map;)Ljava/util/List;", "Lcom/avito/android/remote/model/delivery/DeliverySpecificQuantityState;", "c", "(Lcom/avito/android/remote/model/delivery/DeliverySpecificQuantityState;)V", AnalyticFieldsName.orderId, a2.g.r.g.a, "(Ljava/lang/String;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "success", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onCompletePaymentResult", "(ZLcom/avito/android/deep_linking/links/DeepLink;)V", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", FirebaseAnalytics.Param.QUANTITY, "Lcom/avito/android/delivery/analytics/summary/ChangeType;", "changeType", "onStepperClicked", "(ILcom/avito/android/delivery/analytics/summary/ChangeType;)V", "Lcom/avito/android/SummaryState;", "checkoutSummary", "()Lcom/avito/android/SummaryState;", "markerId", "fiasGuid", "serviceId", "updatePoint", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onCleared", "Lio/reactivex/rxjava3/functions/Consumer;", "Lio/reactivex/rxjava3/functions/Consumer;", "getSubmitButtonClickConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "submitButtonClickConsumer", "Landroidx/lifecycle/MutableLiveData;", "", "C", "Landroidx/lifecycle/MutableLiveData;", "getDisabledImageAlphaChanges", "()Landroidx/lifecycle/MutableLiveData;", "disabledImageAlphaChanges", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/jakewharton/rxrelay3/Relay;", "submitButtonClickRelay", "x", "getErrorChanges", "errorChanges", "F", "disableAllViewsLiveData", "itemQuantityRelay", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lkotlin/Pair;", "y", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSnackBarErrorChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "snackBarErrorChanges", "J", "getStepperTooltipMessages", "stepperTooltipMessages", "getEditButtonClickConsumer", "editButtonClickConsumer", "getItemQuantityConsumer", "itemQuantityConsumer", "Lcom/avito/android/delivery/summary/konveyor/button/ButtonState;", "getSubmitButtonStateConsumer", "submitButtonStateConsumer", "submitButtonStateRelay", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "getChangeConsumer", "changeConsumer", "Lcom/avito/android/delivery/summary/ChangeAction;", "k", "editActionRelay", "Z", "isOrderFromCart", "Lcom/avito/android/util/SchedulersFactory3;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "X", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "converter", "w", "getProgressChanges", "progressChanges", "imageLoadedSuccessfullyRelay", "Lcom/avito/android/delivery/summary/konveyor/button/ButtonItem;", "Lcom/avito/android/delivery/summary/konveyor/button/ButtonItem;", "submitButtonItem", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;", "T", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;", "interactor", "e", "changeRelay", "Q", "Lcom/avito/android/SummaryState;", "state", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "K", "Landroidx/lifecycle/LiveData;", "getDisableAllViews", "()Landroidx/lifecycle/LiveData;", "disableAllViews", "L", "getPricePerPieceVisible", "pricePerPieceVisible", "B", "getCloseScreenChanges", "closeScreenChanges", "Lcom/avito/android/Features;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/Features;", "features", "z", "getDeepLinkChanges", "deepLinkChanges", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getPayUrlChanges", "payUrlChanges", "O", "Ljava/lang/String;", "analyticsAdvertID", ExifInterface.LONGITUDE_WEST, "payOrderId", "(Lcom/avito/conveyor_item/Item;)Z", "isSubmitButton", "G", "pricePerPieceVisibleLiveData", "I", "getItemMaxQuantityChanges", "itemMaxQuantityChanges", "<set-?>", "getHeaderStepperVisible", "()Z", "headerStepperVisible", "currentItemQuantity", VKApiConst.VERSION, "getShowContentChanges", "showContentChanges", "N", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "U", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "contactsFieldsInteractor", "getImageLoadedSuccessfullyConsumer", "imageLoadedSuccessfullyConsumer", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "D", "getEditContactsChanges", "editContactsChanges", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;", "H", "getHeaderChanges", "headerChanges", "editButtonClickRelay", "getEditActionConsumer", "editActionConsumer", "Lcom/avito/android/analytics/Analytics;", "R", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;", "Y", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/Disposable;", "loadSummaryDisposable", "P", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "contactsGroup", "M", "Ljava/util/List;", "listItems", ExifInterface.LONGITUDE_EAST, "getEditPointChanges", "editPointChanges", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "a0", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "summaryState", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;Lcom/avito/android/SummaryState;ZLcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryViewModelImpl extends ViewModel implements DeliveryRdsSummaryViewModel {
    @NotNull
    public final SingleLiveEvent<String> A;
    @NotNull
    public final SingleLiveEvent<Boolean> B;
    @NotNull
    public final MutableLiveData<Float> C;
    @NotNull
    public final SingleLiveEvent<DeliverySummaryRds.ContactsGroup> D;
    @NotNull
    public final SingleLiveEvent<Unit> E;
    public final MutableLiveData<Boolean> F;
    public final MutableLiveData<Boolean> G;
    @NotNull
    public final MutableLiveData<DeliverySummaryRds.Header> H;
    @NotNull
    public final MutableLiveData<Integer> I;
    @NotNull
    public final SingleLiveEvent<String> J;
    @NotNull
    public final LiveData<Boolean> K;
    @NotNull
    public final LiveData<Boolean> L;
    public List<? extends Item> M;
    public AdapterPresenter N;
    public final String O;
    public DeliverySummaryRds.ContactsGroup P;
    public SummaryState Q;
    public final Analytics R;
    public final Features S;
    public final DeliveryRdsSummaryInteractor T;
    public final DeliveryRdsContactsFieldsInteractor U;
    public final SchedulersFactory3 V;
    public String W;
    public final DeliveryRdsSummaryItemsConverter X;
    public final DeliveryRdsSummaryResourceProvider Y;
    public final boolean Z;
    public final BaseScreenPerformanceTracker a0;
    public final CompositeDisposable c;
    public Disposable d;
    public final Relay<ParameterElement.Input> e;
    public final Relay<Unit> f;
    public final Relay<ButtonState> g;
    public final Relay<Integer> h;
    public final Relay<Boolean> i;
    public final Relay<String> j;
    public final Relay<ChangeAction> k;
    public int l = 1;
    public ButtonItem m;
    @NotNull
    public final Consumer<ParameterElement.Input> n;
    @NotNull
    public final Consumer<Unit> o;
    @NotNull
    public final Consumer<ButtonState> p;
    @NotNull
    public final Consumer<Integer> q;
    @NotNull
    public final Consumer<Boolean> r;
    @NotNull
    public final Consumer<String> s;
    @NotNull
    public final Consumer<ChangeAction> t;
    public boolean u;
    @NotNull
    public final MutableLiveData<Unit> v;
    @NotNull
    public final MutableLiveData<Unit> w;
    @NotNull
    public final MutableLiveData<Runnable> x;
    @NotNull
    public final SingleLiveEvent<Pair<String, Boolean>> y;
    @NotNull
    public final SingleLiveEvent<DeepLink> z;

    public static final class a implements Runnable {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public a(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.f();
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super UrlResult>> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public b(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super UrlResult> loadingState) {
            LoadingState<? super UrlResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                DeliveryRdsSummaryViewModelImpl.access$onPaymentUrlLoaded(this.a, ((UrlResult) ((LoadingState.Loaded) loadingState2).getData()).getUrl());
            } else if (loadingState2 instanceof LoadingState.Loading) {
                DeliveryRdsSummaryViewModelImpl.access$showProgress(this.a);
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.h(((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public c(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.showContent();
            this.a.l();
        }
    }

    public static final class d<T> implements Consumer<LoadingState<? super DeliverySummaryRds>> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public d(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super DeliverySummaryRds> loadingState) {
            LoadingState<? super DeliverySummaryRds> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.a.j();
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.i(((LoadingState.Error) loadingState2).getError(), new g0(new y(this.a)));
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                DeliveryRdsSummaryViewModelImpl.access$onSummaryLoaded(this.a, (DeliverySummaryRds) ((LoadingState.Loaded) loadingState2).getData());
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public e(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th);
            this.a.i(null, new z(this));
        }
    }

    public static final class f<T> implements Consumer<ChangeAction> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public f(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ChangeAction changeAction) {
            ChangeAction changeAction2 = changeAction;
            if (changeAction2 instanceof ChangeAction.EditContacts) {
                DeliveryRdsSummaryViewModelImpl.access$handleChangeContacts(this.a, ((ChangeAction.EditContacts) changeAction2).getContacts());
            }
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public g(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th);
            this.a.l();
            this.a.n();
        }
    }

    public static final class h<T> implements Consumer<String> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public h(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            DeliverySummaryRds.ContactsGroup contactsGroup;
            String str2 = str;
            if (str2 != null) {
                int hashCode = str2.hashCode();
                if (hashCode != -1069440095) {
                    if (hashCode == -391823610 && str2.equals(DeliveryRdsSummaryItemsConverterKt.HEADER_USER_INFO_ID) && (contactsGroup = this.a.P) != null) {
                        SingleLiveEvent<DeliverySummaryRds.ContactsGroup> editContactsChanges = this.a.getEditContactsChanges();
                        List<ParameterSlot> formSections = contactsGroup.getFormSections();
                        editContactsChanges.postValue(DeliverySummaryRds.ContactsGroup.copy$default(contactsGroup, null, false, formSections != null ? this.a.d(formSections, null) : null, null, null, 27, null));
                    }
                } else if (str2.equals(DeliveryRdsSummaryItemsConverterKt.HEADER_ADDRESS_ID)) {
                    this.a.getEditPointChanges().postValue(Unit.INSTANCE);
                }
            }
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public i(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.l();
            this.a.o();
        }
    }

    public static final class j<T> implements Consumer<ParameterElement.Input> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public j(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ParameterElement.Input input) {
            Map map;
            Map<String, String> contacts;
            ParameterElement.Input input2 = input;
            String value = input2.getValue();
            if (value != null) {
                DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl = this.a;
                SummaryState summaryState = deliveryRdsSummaryViewModelImpl.Q;
                SummaryState summaryState2 = null;
                if (summaryState != null) {
                    SummaryState summaryState3 = this.a.Q;
                    if (summaryState3 == null || (contacts = summaryState3.getContacts()) == null || (map = t6.n.r.toMutableMap(contacts)) == null) {
                        map = null;
                    } else {
                        map.put(input2.getStringId(), input2.getValue());
                    }
                    summaryState2 = SummaryState.copy$default(summaryState, null, null, null, null, map, false, 47, null);
                }
                deliveryRdsSummaryViewModelImpl.Q = summaryState2;
                DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl2 = this.a;
                Intrinsics.checkNotNullExpressionValue(input2, "element");
                DeliveryRdsSummaryViewModelImpl.access$onElementValueChanged(deliveryRdsSummaryViewModelImpl2, input2, value);
            }
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public k(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th);
            this.a.l();
            this.a.p();
        }
    }

    public static final class l<T> implements Consumer<Integer> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public l(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            MutableLiveData mutableLiveData = this.a.G;
            boolean z = true;
            if (num.intValue() <= 1) {
                z = false;
            }
            mutableLiveData.postValue(Boolean.valueOf(z));
        }
    }

    public static final class m<T> implements Predicate<Integer> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public m(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Integer num) {
            Integer num2 = num;
            SummaryState summaryState = this.a.Q;
            if (!((summaryState == null || summaryState.getAdvertId() == null || summaryState.getFiasGuid() == null || summaryState.getServiceId() == null) ? false : true) || !this.a.getHeaderStepperVisible()) {
                return false;
            }
            int i = this.a.l;
            if (num2 != null && num2.intValue() == i) {
                return false;
            }
            return true;
        }
    }

    public static final class n<T, R> implements Function<Integer, SingleSource<? extends DeliverySpecificQuantityState>> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public n(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends DeliverySpecificQuantityState> apply(Integer num) {
            Integer num2 = num;
            DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, FirebaseAnalytics.Param.QUANTITY);
            deliveryRdsSummaryViewModelImpl.l = num2.intValue();
            DeliveryRdsSummaryInteractor deliveryRdsSummaryInteractor = this.a.T;
            SummaryState summaryState = this.a.Q;
            Intrinsics.checkNotNull(summaryState);
            String advertId = summaryState.getAdvertId();
            Intrinsics.checkNotNull(advertId);
            SummaryState summaryState2 = this.a.Q;
            Intrinsics.checkNotNull(summaryState2);
            String fiasGuid = summaryState2.getFiasGuid();
            Intrinsics.checkNotNull(fiasGuid);
            SummaryState summaryState3 = this.a.Q;
            Intrinsics.checkNotNull(summaryState3);
            String serviceId = summaryState3.getServiceId();
            Intrinsics.checkNotNull(serviceId);
            return deliveryRdsSummaryInteractor.checkQuantity(advertId, fiasGuid, serviceId, num2.intValue());
        }
    }

    public static final class o<T> implements Consumer<DeliverySpecificQuantityState> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public o(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeliverySpecificQuantityState deliverySpecificQuantityState) {
            DeliverySpecificQuantityState deliverySpecificQuantityState2 = deliverySpecificQuantityState;
            DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(deliverySpecificQuantityState2, "state");
            deliveryRdsSummaryViewModelImpl.c(deliverySpecificQuantityState2);
            this.a.s(deliverySpecificQuantityState2.getUpdatedPrice());
        }
    }

    public static final class p<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public p(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th2);
            DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            DeliveryRdsSummaryViewModelImpl.access$showError(deliveryRdsSummaryViewModelImpl, th2);
            this.a.q();
        }
    }

    public static final class q<T> implements Consumer<Unit> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public q(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            ParametersTree parametersTree = this.a.X.getParametersTree();
            String str = this.a.W;
            if (parametersTree != null) {
                DeliveryRdsSummaryViewModelImpl.access$validateFields(this.a, parametersTree);
            } else if (str != null) {
                this.a.g(str);
            } else {
                this.a.l();
            }
        }
    }

    public static final class r<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

        public r(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
            this.a = deliveryRdsSummaryViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th);
            this.a.l();
            this.a.r();
        }
    }

    public DeliveryRdsSummaryViewModelImpl(@NotNull Analytics analytics, @NotNull Features features, @NotNull DeliveryRdsSummaryInteractor deliveryRdsSummaryInteractor, @NotNull DeliveryRdsContactsFieldsInteractor deliveryRdsContactsFieldsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable String str, @NotNull DeliveryRdsSummaryItemsConverter deliveryRdsSummaryItemsConverter, @NotNull DeliveryRdsSummaryResourceProvider deliveryRdsSummaryResourceProvider, @Nullable SummaryState summaryState, boolean z2, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        PublishRelay publishRelay;
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryInteractor, "interactor");
        Intrinsics.checkNotNullParameter(deliveryRdsContactsFieldsInteractor, "contactsFieldsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryItemsConverter, "converter");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.R = analytics;
        this.S = features;
        this.T = deliveryRdsSummaryInteractor;
        this.U = deliveryRdsContactsFieldsInteractor;
        this.V = schedulersFactory3;
        this.W = str;
        this.X = deliveryRdsSummaryItemsConverter;
        this.Y = deliveryRdsSummaryResourceProvider;
        this.Z = z2;
        this.a0 = baseScreenPerformanceTracker;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.c = compositeDisposable;
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.e = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.f = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.g = create3;
        PublishRelay create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.h = create4;
        PublishRelay create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.i = create5;
        PublishRelay create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        this.j = create6;
        PublishRelay create7 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create7, "PublishRelay.create()");
        this.k = create7;
        this.n = create;
        this.o = create2;
        this.p = create3;
        this.q = create4;
        this.r = create5;
        this.s = create6;
        this.t = create7;
        this.u = features.getDeliverySummaryQuantityChoice().invoke().booleanValue();
        this.v = new MutableLiveData<>();
        this.w = new MutableLiveData<>();
        this.x = new MutableLiveData<>();
        this.y = new SingleLiveEvent<>();
        this.z = new SingleLiveEvent<>();
        this.A = new SingleLiveEvent<>();
        this.B = new SingleLiveEvent<>();
        this.C = new MutableLiveData<>();
        this.D = new SingleLiveEvent<>();
        this.E = new SingleLiveEvent<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.F = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.G = mutableLiveData2;
        this.H = new MutableLiveData<>();
        this.I = new MutableLiveData<>();
        this.J = new SingleLiveEvent<>();
        LiveData<Boolean> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Transformations.distinct…(disableAllViewsLiveData)");
        this.K = distinctUntilChanged;
        LiveData<Boolean> distinctUntilChanged2 = Transformations.distinctUntilChanged(mutableLiveData2);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged2, "Transformations.distinct…ePerPieceVisibleLiveData)");
        this.L = distinctUntilChanged2;
        this.M = CollectionsKt__CollectionsKt.emptyList();
        SummaryState summaryState2 = null;
        this.O = summaryState != null ? summaryState.getAdvertId() : null;
        if (summaryState != null) {
            publishRelay = create5;
            summaryState2 = SummaryState.copy$default(summaryState, null, null, null, null, null, false, 63, null);
        } else {
            publishRelay = create5;
        }
        this.Q = summaryState2;
        p();
        r();
        Observable observeOn = create3.observeOn(schedulersFactory3.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "submitButtonStateRelay.o…(schedulers.mainThread())");
        DisposableKt.addTo(SubscribersKt.subscribeBy$default(observeOn, new d0(this), (Function0) null, new Function1<ButtonState, Unit>(this) { // from class: a2.a.a.k0.e.c0
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(ButtonState buttonState) {
                ButtonState buttonState2 = buttonState;
                Intrinsics.checkNotNullParameter(buttonState2, "p1");
                DeliveryRdsSummaryViewModelImpl.access$updateSubmitButton((DeliveryRdsSummaryViewModelImpl) this.receiver, buttonState2);
                return Unit.INSTANCE;
            }
        }, 2, (Object) null), compositeDisposable);
        q();
        Disposable subscribe = publishRelay.observeOn(schedulersFactory3.mainThread()).subscribe(new a0(this), b0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "imageLoadedSuccessfullyR…(TAG, it) }\n            )");
        DisposableKt.addTo(subscribe, compositeDisposable);
        o();
        n();
        f();
    }

    public static final void access$applyCheckQuantityResult(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, DeliverySpecificQuantityState deliverySpecificQuantityState) {
        deliveryRdsSummaryViewModelImpl.showContent();
        deliveryRdsSummaryViewModelImpl.c(deliverySpecificQuantityState);
        deliveryRdsSummaryViewModelImpl.s(deliverySpecificQuantityState.getUpdatedPrice());
    }

    public static final /* synthetic */ ButtonItem access$getSubmitButtonItem$p(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        ButtonItem buttonItem = deliveryRdsSummaryViewModelImpl.m;
        if (buttonItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitButtonItem");
        }
        return buttonItem;
    }

    public static final void access$handleChangeContacts(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, Map map) {
        deliveryRdsSummaryViewModelImpl.u(deliveryRdsSummaryViewModelImpl.X.applyValues(map, deliveryRdsSummaryViewModelImpl.M));
        DeliverySummaryRds.ContactsGroup contactsGroup = deliveryRdsSummaryViewModelImpl.P;
        DeliverySummaryRds.ContactsGroup contactsGroup2 = null;
        SummaryState summaryState = null;
        if (contactsGroup != null) {
            List<ParameterSlot> formSections = contactsGroup.getFormSections();
            List<ParameterSlot> d2 = formSections != null ? deliveryRdsSummaryViewModelImpl.d(formSections, map) : null;
            SummaryState summaryState2 = deliveryRdsSummaryViewModelImpl.Q;
            if (summaryState2 != null) {
                summaryState = SummaryState.copy$default(summaryState2, null, null, null, null, map, false, 47, null);
            }
            deliveryRdsSummaryViewModelImpl.Q = summaryState;
            if (d2 != null) {
                deliveryRdsSummaryViewModelImpl.X.createParametersTree(d2);
            }
            contactsGroup2 = DeliverySummaryRds.ContactsGroup.copy$default(contactsGroup, null, false, d2, null, null, 27, null);
        }
        deliveryRdsSummaryViewModelImpl.P = contactsGroup2;
    }

    public static final void access$onElementValueChanged(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, Item item, String str) {
        deliveryRdsSummaryViewModelImpl.X.onParameterValueChanged(item.getStringId(), str);
    }

    public static final void access$onOrderCreated(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, OrderIdResult orderIdResult) {
        if (deliveryRdsSummaryViewModelImpl.S.getDeliverySummaryQuantityChoice().invoke().booleanValue() || deliveryRdsSummaryViewModelImpl.Z) {
            deliveryRdsSummaryViewModelImpl.g(orderIdResult.getOrderId());
            return;
        }
        deliveryRdsSummaryViewModelImpl.W = orderIdResult.getOrderId();
        Disposable subscribe = deliveryRdsSummaryViewModelImpl.T.getExistingOrderSummary(orderIdResult.getOrderId()).observeOn(deliveryRdsSummaryViewModelImpl.V.mainThread()).subscribe(new w(deliveryRdsSummaryViewModelImpl, orderIdResult), new x(deliveryRdsSummaryViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getExistingOr…      }\n                )");
        DisposableKt.addTo(subscribe, deliveryRdsSummaryViewModelImpl.c);
    }

    public static final void access$onPaymentUrlLoaded(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, String str) {
        deliveryRdsSummaryViewModelImpl.getPayUrlChanges().setValue(str);
        deliveryRdsSummaryViewModelImpl.showContent();
    }

    public static final void access$onSummaryLoaded(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, DeliverySummaryRds deliverySummaryRds) {
        DeliverySummaryRds deliverySummaryRds2;
        List<ParameterSlot> formSections;
        String str;
        deliveryRdsSummaryViewModelImpl.a0.trackLoaded();
        deliveryRdsSummaryViewModelImpl.a0.startPreparing();
        Item item = null;
        if (deliveryRdsSummaryViewModelImpl.S.getDeliverySummaryQuantityChoice().invoke().booleanValue()) {
            deliverySummaryRds2 = deliveryRdsSummaryViewModelImpl.t(deliverySummaryRds);
        } else {
            DeliverySummaryRds.Header header = deliverySummaryRds.getHeader();
            deliverySummaryRds2 = deliveryRdsSummaryViewModelImpl.t(DeliverySummaryRds.copy$default(deliverySummaryRds, header != null ? DeliverySummaryRds.Header.copy$default(header, null, null, null, null, null, 23, null) : null, null, null, null, null, null, 62, null));
        }
        DeliverySummaryRds.Header header2 = deliverySummaryRds2.getHeader();
        boolean z2 = false;
        deliveryRdsSummaryViewModelImpl.u = (header2 != null ? header2.getAvailableQuantity() : null) != null;
        DeliverySummaryRds.Header header3 = deliverySummaryRds2.getHeader();
        if (header3 != null) {
            Integer availableQuantity = header3.getAvailableQuantity();
            if (availableQuantity != null) {
                deliveryRdsSummaryViewModelImpl.l = t6.v.e.coerceAtMost(deliveryRdsSummaryViewModelImpl.l, availableQuantity.intValue());
            }
            deliveryRdsSummaryViewModelImpl.getHeaderChanges().setValue(header3);
            String tooltip = header3.getTooltip();
            if (tooltip != null) {
                if (tooltip.length() > 0) {
                    z2 = true;
                }
                if (!z2) {
                    tooltip = null;
                }
                if (tooltip != null) {
                    deliveryRdsSummaryViewModelImpl.getStepperTooltipMessages().setValue(tooltip);
                }
            }
            if (deliveryRdsSummaryViewModelImpl.getHeaderStepperVisible() && (str = deliveryRdsSummaryViewModelImpl.O) != null) {
                deliveryRdsSummaryViewModelImpl.R.track(new StepperIsShownEvent(str));
            }
        }
        List<Item> convert = deliveryRdsSummaryViewModelImpl.X.convert(deliverySummaryRds2, deliveryRdsSummaryViewModelImpl);
        ListIterator<Item> listIterator = convert.listIterator(convert.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Item previous = listIterator.previous();
            if (deliveryRdsSummaryViewModelImpl.e(previous)) {
                item = previous;
                break;
            }
        }
        Item item2 = item;
        if (item2 != null) {
            deliveryRdsSummaryViewModelImpl.m = (ButtonItem) item2;
        }
        deliveryRdsSummaryViewModelImpl.a0.trackPrepared();
        deliveryRdsSummaryViewModelImpl.a0.startDrawing();
        AdapterPresenter adapterPresenter = deliveryRdsSummaryViewModelImpl.N;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(convert, adapterPresenter);
        }
        deliveryRdsSummaryViewModelImpl.M = convert;
        deliveryRdsSummaryViewModelImpl.showContent();
        deliveryRdsSummaryViewModelImpl.a0.trackDrawn();
        DeliverySummaryRds.ContactsGroup contactsGroup = deliverySummaryRds2.getContactsGroup();
        deliveryRdsSummaryViewModelImpl.P = contactsGroup;
        if (contactsGroup != null && (formSections = contactsGroup.getFormSections()) != null) {
            deliveryRdsSummaryViewModelImpl.X.createParametersTree(formSections);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0097, code lost:
        if (r1 != null) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$onValidationResultLoaded(com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl r6, java.util.Map r7) {
        /*
            java.util.Objects.requireNonNull(r6)
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x00dc
            com.avito.android.Features r7 = r6.S
            com.avito.android.toggle.Feature r7 = r7.getCreateDeliveryOrderWithCartSupport()
            java.lang.Object r7 = r7.invoke()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r0 = 1
            r1 = 0
            java.lang.String r2 = "Single.just(headerSteppe…          }\n            )"
            java.lang.String r3 = "Single.just(headerSteppe…apCheckQuantityIfNeeded()"
            java.lang.String r4 = "Single.just(headerSteppe… state?.advertId != null)"
            r5 = 0
            if (r7 == 0) goto L_0x0089
            boolean r7 = r6.getHeaderStepperVisible()
            if (r7 == 0) goto L_0x0035
            com.avito.android.SummaryState r7 = r6.Q
            if (r7 == 0) goto L_0x0032
            java.lang.String r1 = r7.getAdvertId()
        L_0x0032:
            if (r1 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r0)
            io.reactivex.rxjava3.core.Single r7 = io.reactivex.rxjava3.core.Single.just(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            a2.a.a.k0.e.s r0 = new a2.a.a.k0.e.s
            r0.<init>(r6)
            io.reactivex.rxjava3.core.Maybe r7 = r7.flatMapMaybe(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            a2.a.a.k0.e.t r0 = new a2.a.a.k0.e.t
            r0.<init>(r6)
            io.reactivex.rxjava3.core.Maybe r7 = r7.flatMapSingle(r0)
            com.avito.android.util.SchedulersFactory3 r0 = r6.V
            io.reactivex.rxjava3.core.Scheduler r0 = r0.mainThread()
            io.reactivex.rxjava3.core.Maybe r7 = r7.observeOn(r0)
            a2.a.a.k0.e.l r0 = new a2.a.a.k0.e.l
            r0.<init>(r6)
            io.reactivex.rxjava3.core.Maybe r7 = r7.doOnSubscribe(r0)
            a2.a.a.k0.e.m r0 = new a2.a.a.k0.e.m
            r0.<init>(r6)
            io.reactivex.rxjava3.core.Maybe r7 = r7.doOnTerminate(r0)
            a2.a.a.k0.e.n r0 = new a2.a.a.k0.e.n
            r0.<init>(r6)
            a2.a.a.k0.e.o r1 = new a2.a.a.k0.e.o
            r1.<init>(r6)
            io.reactivex.rxjava3.disposables.Disposable r7 = r7.subscribe(r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            io.reactivex.rxjava3.disposables.CompositeDisposable r6 = r6.c
            io.reactivex.rxjava3.kotlin.DisposableKt.addTo(r7, r6)
            goto L_0x00ea
        L_0x0089:
            boolean r7 = r6.getHeaderStepperVisible()
            if (r7 == 0) goto L_0x009a
            com.avito.android.SummaryState r7 = r6.Q
            if (r7 == 0) goto L_0x0097
            java.lang.String r1 = r7.getAdvertId()
        L_0x0097:
            if (r1 == 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r0 = 0
        L_0x009b:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r0)
            io.reactivex.rxjava3.core.Single r7 = io.reactivex.rxjava3.core.Single.just(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            a2.a.a.k0.e.s r0 = new a2.a.a.k0.e.s
            r0.<init>(r6)
            io.reactivex.rxjava3.core.Maybe r7 = r7.flatMapMaybe(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            a2.a.a.k0.e.u r0 = new a2.a.a.k0.e.u
            r0.<init>(r6)
            io.reactivex.rxjava3.core.Observable r7 = r7.flatMapObservable(r0)
            com.avito.android.util.SchedulersFactory3 r0 = r6.V
            io.reactivex.rxjava3.core.Scheduler r0 = r0.mainThread()
            io.reactivex.rxjava3.core.Observable r7 = r7.observeOn(r0)
            a2.a.a.k0.e.p r0 = new a2.a.a.k0.e.p
            r0.<init>(r6)
            a2.a.a.k0.e.q r1 = new a2.a.a.k0.e.q
            r1.<init>(r6)
            io.reactivex.rxjava3.disposables.Disposable r7 = r7.subscribe(r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            io.reactivex.rxjava3.disposables.CompositeDisposable r6 = r6.c
            io.reactivex.rxjava3.kotlin.DisposableKt.addTo(r7, r6)
            goto L_0x00ea
        L_0x00dc:
            com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter r0 = r6.X
            java.util.List<? extends com.avito.conveyor_item.Item> r1 = r6.M
            java.util.List r7 = r0.applyErrors(r7, r1)
            r6.u(r7)
            r6.showContent()
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl.access$onValidationResultLoaded(com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl, java.util.Map):void");
    }

    public static final void access$showProgress(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        int i2;
        if (deliveryRdsSummaryViewModelImpl.S.getDeliverySummaryQuantityChoice().invoke().booleanValue()) {
            deliveryRdsSummaryViewModelImpl.F.setValue(Boolean.TRUE);
            List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) deliveryRdsSummaryViewModelImpl.M);
            ListIterator<? extends Item> listIterator = mutableList.listIterator(mutableList.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (deliveryRdsSummaryViewModelImpl.e((Item) listIterator.previous())) {
                        i2 = listIterator.nextIndex();
                        break;
                    }
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 != -1) {
                Object remove = mutableList.remove(i2);
                Objects.requireNonNull(remove, "null cannot be cast to non-null type com.avito.android.delivery.summary.konveyor.button.ButtonItem");
                deliveryRdsSummaryViewModelImpl.m = (ButtonItem) remove;
                mutableList.add(i2, ButtonItem.Companion.getLOADING());
                AdapterPresenter adapterPresenter = deliveryRdsSummaryViewModelImpl.N;
                if (adapterPresenter != null) {
                    a2.b.a.a.a.s1(mutableList, adapterPresenter);
                }
                deliveryRdsSummaryViewModelImpl.M = mutableList;
                return;
            }
            return;
        }
        deliveryRdsSummaryViewModelImpl.j();
    }

    public static final void access$updateSubmitButton(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, ButtonState buttonState) {
        Object obj = null;
        for (Object obj2 : CollectionsKt___CollectionsKt.withIndex(deliveryRdsSummaryViewModelImpl.M)) {
            if (deliveryRdsSummaryViewModelImpl.e((Item) ((IndexedValue) obj2).component2())) {
                obj = obj2;
            }
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        if (indexedValue != null) {
            int component1 = indexedValue.component1();
            Item item = (Item) indexedValue.component2();
            Objects.requireNonNull(item, "null cannot be cast to non-null type com.avito.android.delivery.summary.konveyor.button.ButtonItem");
            ButtonItem buttonItem = (ButtonItem) item;
            List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) deliveryRdsSummaryViewModelImpl.M);
            String text = buttonState.getText();
            if (text == null) {
                text = buttonItem.getText();
            }
            Boolean isLoading = buttonState.isLoading();
            boolean booleanValue = isLoading != null ? isLoading.booleanValue() : buttonItem.isLoading();
            Boolean isEnabled = buttonState.isEnabled();
            ButtonItem copy$default = ButtonItem.copy$default(buttonItem, null, text, booleanValue, isEnabled != null ? isEnabled.booleanValue() : buttonItem.isEnabled(), 1, null);
            deliveryRdsSummaryViewModelImpl.m = copy$default;
            mutableList.set(component1, copy$default);
            AdapterPresenter adapterPresenter = deliveryRdsSummaryViewModelImpl.N;
            if (adapterPresenter != null) {
                a2.b.a.a.a.s1(mutableList, adapterPresenter);
            }
            deliveryRdsSummaryViewModelImpl.M = mutableList;
        }
    }

    public static final void access$updateView(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, List list) {
        AdapterPresenter adapterPresenter = deliveryRdsSummaryViewModelImpl.N;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(list, adapterPresenter);
        }
        deliveryRdsSummaryViewModelImpl.M = list;
    }

    public static final void access$validateFields(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, ParametersTree parametersTree) {
        Disposable subscribe = deliveryRdsSummaryViewModelImpl.U.validateFields(parametersTree).observeOn(deliveryRdsSummaryViewModelImpl.V.mainThread()).subscribe(new e0(deliveryRdsSummaryViewModelImpl), new f0(deliveryRdsSummaryViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "contactsFieldsInteractor…          }\n            )");
        DisposableKt.addTo(subscribe, deliveryRdsSummaryViewModelImpl.c);
    }

    public static void k(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, String str, boolean z2, int i2) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        deliveryRdsSummaryViewModelImpl.getSnackBarErrorChanges().postValue(TuplesKt.to(str, Boolean.valueOf(z2)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        if ((r0.length() > 0) != false) goto L_0x003f;
     */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.avito.android.remote.model.delivery.DeliverySpecificQuantityState r5) {
        /*
            r4 = this;
            int r0 = r4.l
            int r1 = r5.getAvailableQuantity()
            int r0 = t6.v.e.coerceAtMost(r0, r1)
            r4.l = r0
            androidx.lifecycle.MutableLiveData r0 = r4.getItemMaxQuantityChanges()
            int r1 = r5.getAvailableQuantity()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.setValue(r1)
            com.avito.android.util.architecture_components.SingleLiveEvent r0 = r4.getStepperTooltipMessages()
            java.lang.String r1 = r5.getTooltipMessage()
            r0.setValue(r1)
            java.lang.String r0 = r4.O
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = r5.getTooltipMessage()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003e
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            if (r1 == 0) goto L_0x0057
            com.avito.android.analytics.Analytics r0 = r4.R
            com.avito.android.delivery.analytics.summary.StepperTooltipWasShownEvent r1 = new com.avito.android.delivery.analytics.summary.StepperTooltipWasShownEvent
            java.lang.String r2 = r4.O
            com.avito.android.delivery.analytics.summary.ErrorType$Companion r3 = com.avito.android.delivery.analytics.summary.ErrorType.Companion
            int r5 = r5.getAvailableQuantity()
            com.avito.android.delivery.analytics.summary.ErrorType r5 = r3.fromQuantity(r5)
            r1.<init>(r2, r5)
            r0.track(r1)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl.c(com.avito.android.remote.model.delivery.DeliverySpecificQuantityState):void");
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @Nullable
    public SummaryState checkoutSummary() {
        return this.Q;
    }

    public final List<ParameterSlot> d(List<? extends ParameterSlot> list, Map<String, String> map) {
        Object obj;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (T t2 : list) {
            if (t2 instanceof CharParameter) {
                if (map == null || (obj = CharParameter.copy$default(t2, null, null, false, false, null, null, null, map.get(t2.getId()), null, null, null, null, null, null, null, 32639, null)) == null) {
                    obj = CharParameter.copy$default(t2, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
                }
            } else if (!(t2 instanceof PhoneParameter)) {
                throw new IllegalArgumentException("Cannot copy " + ((Object) t2));
            } else if (map == null || (obj = PhoneParameter.copy$default(t2, null, null, false, false, null, null, null, map.get(t2.getId()), null, null, null, 1919, null)) == null) {
                obj = PhoneParameter.copy$default(t2, null, null, false, false, null, null, null, null, null, null, null, 2047, null);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final boolean e(Item item) {
        return (item instanceof ButtonItem) && Intrinsics.areEqual(item.getStringId(), DeliveryRdsSummaryItemsConverterKt.SUBMIT_BUTTON_ID);
    }

    public final void f() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a0.startLoading();
        SummaryState summaryState = this.Q;
        String str = null;
        String fiasGuid = summaryState != null ? summaryState.getFiasGuid() : null;
        SummaryState summaryState2 = this.Q;
        String serviceId = summaryState2 != null ? summaryState2.getServiceId() : null;
        String str2 = this.W;
        if (fiasGuid != null && serviceId != null) {
            DeliveryRdsSummaryInteractor deliveryRdsSummaryInteractor = this.T;
            SummaryState summaryState3 = this.Q;
            if (summaryState3 != null) {
                str = summaryState3.getAdvertId();
            }
            this.d = m(deliveryRdsSummaryInteractor.getOrderSummary(str, fiasGuid, serviceId));
        } else if (str2 != null) {
            this.d = m(this.T.getExistingOrderSummary(str2));
        } else {
            i(null, new a(this));
        }
    }

    public final void g(String str) {
        Disposable subscribe = this.T.getPaymentUrl(str).observeOn(this.V.mainThread()).subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getPaymentUrl…          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public Consumer<ParameterElement.Input> getChangeConsumer() {
        return this.n;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public LiveData<Boolean> getDisableAllViews() {
        return this.K;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public Consumer<ChangeAction> getEditActionConsumer() {
        return this.t;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public Consumer<String> getEditButtonClickConsumer() {
        return this.s;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    public boolean getHeaderStepperVisible() {
        return this.u;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public Consumer<Boolean> getImageLoadedSuccessfullyConsumer() {
        return this.r;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public Consumer<Integer> getItemQuantityConsumer() {
        return this.q;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public LiveData<Boolean> getPricePerPieceVisible() {
        return this.L;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public Consumer<Unit> getSubmitButtonClickConsumer() {
        return this.o;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public Consumer<ButtonState> getSubmitButtonStateConsumer() {
        return this.p;
    }

    public final void h(TypedError typedError) {
        showContent();
        if (typedError instanceof ErrorWithMessage) {
            k(this, ((ErrorWithMessage) typedError).getMessage(), false, 2);
        } else {
            l();
        }
    }

    public final void i(TypedError typedError, Runnable runnable) {
        this.a0.trackLoadingError();
        getShowContentChanges().setValue(null);
        getErrorChanges().setValue(runnable);
        getProgressChanges().setValue(null);
        this.a0.startDrawing();
        if (typedError instanceof ErrorWithMessage) {
            k(this, ((ErrorWithMessage) typedError).getMessage(), false, 2);
        } else {
            k(this, this.Y.getErrorOccurred(), false, 2);
        }
        this.a0.trackDrawnError();
    }

    public final void j() {
        getShowContentChanges().setValue(null);
        getErrorChanges().setValue(null);
        getProgressChanges().setValue(Unit.INSTANCE);
    }

    public final void l() {
        k(this, this.Y.getErrorOccurred(), false, 2);
    }

    public final Disposable m(Observable<LoadingState<DeliverySummaryRds>> observable) {
        Disposable subscribe = observable.observeOn(this.V.mainThread()).subscribe(new d(this), new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(schedulers.mai…          }\n            )");
        return subscribe;
    }

    public final void n() {
        Disposable subscribe = this.k.subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "editActionRelay\n        …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void o() {
        Disposable subscribe = this.j.observeOn(this.V.mainThread()).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new h(this), new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "editButtonClickRelay\n   …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    public void onCompletePaymentResult(boolean z2, @Nullable DeepLink deepLink) {
        showContent();
        if (!z2) {
            return;
        }
        if (deepLink == null || (deepLink instanceof DeliveryOrderPaymentFailureLink)) {
            k(this, this.Y.getPaymentError(), false, 2);
            return;
        }
        getCloseScreenChanges().setValue(Boolean.TRUE);
        getDeepLinkChanges().setValue(deepLink);
        String str = this.O;
        if (str != null) {
            this.R.track(new DeliveryPaymentSuccessfulEvent(str));
        }
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        getDeepLinkChanges().setValue(deepLink);
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    public void onStepperClicked(int i2, @NotNull ChangeType changeType) {
        Intrinsics.checkNotNullParameter(changeType, "changeType");
        String str = this.O;
        if (str != null) {
            this.R.track(new ItemQuantityChangedEvent(str, Integer.valueOf(i2), changeType));
        }
    }

    public final void p() {
        Disposable subscribe = this.e.subscribe(new j(this), new k(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "changeRelay\n            …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void q() {
        if (getHeaderStepperVisible() && !this.Z) {
            Disposable subscribe = this.h.doOnNext(new l(this)).debounce(400, TimeUnit.MILLISECONDS, this.V.computation()).filter(new m(this)).switchMapSingle(new n(this)).observeOn(this.V.mainThread()).subscribe(new o(this), new p(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "itemQuantityRelay\n      …          }\n            )");
            DisposableKt.addTo(subscribe, this.c);
        }
    }

    public final void r() {
        Disposable subscribe = this.f.observeOn(this.V.mainThread()).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new q(this), new r(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "submitButtonClickRelay\n …          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void s(List<DeliverySummaryRds.Calculation> list) {
        int i2;
        Iterator<? extends Item> it = this.M.iterator();
        int i3 = 0;
        while (true) {
            i2 = -1;
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (((Item) it.next()) instanceof PriceItem) {
                break;
            } else {
                i3++;
            }
        }
        List<? extends Item> list2 = this.M;
        ListIterator<? extends Item> listIterator = list2.listIterator(list2.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (((Item) listIterator.previous()) instanceof PriceItem) {
                    i2 = listIterator.nextIndex();
                    break;
                }
            } else {
                break;
            }
        }
        List plus = CollectionsKt___CollectionsKt.plus((Collection) this.M.subList(0, i3), (Iterable) DeliveryRdsSummaryItemsConverterKt.toPriceItems(list));
        List<? extends Item> list3 = this.M;
        u(CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) list3.subList(i2 + 1, list3.size())));
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.N = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.M));
    }

    public final void showContent() {
        int i2;
        boolean z2;
        if (this.S.getDeliverySummaryQuantityChoice().invoke().booleanValue()) {
            this.F.setValue(Boolean.FALSE);
            if (!(!(this.m != null))) {
                List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.M);
                ListIterator<? extends Item> listIterator = mutableList.listIterator(mutableList.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        i2 = -1;
                        break;
                    }
                    Item item = (Item) listIterator.previous();
                    if (!(item instanceof ButtonItem) || !Intrinsics.areEqual(item.getStringId(), DeliveryRdsSummaryItemsConverterKt.LOADING_BUTTON_ID)) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        i2 = listIterator.nextIndex();
                        break;
                    }
                }
                if (i2 != -1) {
                    mutableList.remove(i2);
                    ButtonItem buttonItem = this.m;
                    if (buttonItem == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("submitButtonItem");
                    }
                    mutableList.add(i2, buttonItem);
                    AdapterPresenter adapterPresenter = this.N;
                    if (adapterPresenter != null) {
                        a2.b.a.a.a.s1(mutableList, adapterPresenter);
                    }
                    this.M = mutableList;
                }
            }
        }
        getShowContentChanges().setValue(Unit.INSTANCE);
        getErrorChanges().setValue(null);
        getProgressChanges().setValue(null);
    }

    public final DeliverySummaryRds t(DeliverySummaryRds deliverySummaryRds) {
        String str;
        Map<String, String> contacts;
        ArrayList arrayList;
        SummaryState summaryState = this.Q;
        SummaryState summaryState2 = null;
        if (!(summaryState == null || (contacts = summaryState.getContacts()) == null)) {
            DeliverySummaryRds.ContactsGroup contactsGroup = deliverySummaryRds.getContactsGroup();
            List<DeliverySummaryRds.ContactsGroup.PrefilledContact> prefilledContactsGroup = deliverySummaryRds.getContactsGroup().getPrefilledContactsGroup();
            if (prefilledContactsGroup != null) {
                ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(prefilledContactsGroup, 10));
                for (T t2 : prefilledContactsGroup) {
                    AttributedText text = t2.getText();
                    String str2 = contacts.get(t2.getId());
                    if (str2 == null) {
                        str2 = "";
                    }
                    arrayList2.add(DeliverySummaryRds.ContactsGroup.PrefilledContact.copy$default(t2, null, AttributedText.copy$default(text, str2, null, 2, null), 1, null));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            List<ParameterSlot> formSections = deliverySummaryRds.getContactsGroup().getFormSections();
            DeliverySummaryRds copy$default = DeliverySummaryRds.copy$default(deliverySummaryRds, null, null, null, DeliverySummaryRds.ContactsGroup.copy$default(contactsGroup, null, false, formSections != null ? d(formSections, contacts) : null, null, arrayList, 11, null), null, null, 55, null);
            if (copy$default != null) {
                return copy$default;
            }
        }
        List<DeliverySummaryRds.ContactsGroup.PrefilledContact> prefilledContactsGroup2 = deliverySummaryRds.getContactsGroup().getPrefilledContactsGroup();
        if (prefilledContactsGroup2 != null) {
            SummaryState summaryState3 = this.Q;
            if (summaryState3 != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (T t3 : prefilledContactsGroup2) {
                    linkedHashMap.put(t3.getId(), ((Attribute) CollectionsKt___CollectionsKt.first((List<? extends Object>) t3.getText().getAttributes())).getTitle());
                }
                summaryState2 = SummaryState.copy$default(summaryState3, null, null, null, null, linkedHashMap, false, 47, null);
            }
            this.Q = summaryState2;
            return deliverySummaryRds;
        }
        List<ParameterSlot> formSections2 = deliverySummaryRds.getContactsGroup().getFormSections();
        if (formSections2 == null) {
            return deliverySummaryRds;
        }
        SummaryState summaryState4 = this.Q;
        if (summaryState4 != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (T t4 : formSections2) {
                String id = t4.getId();
                if (t4 instanceof CharParameter) {
                    str = t4.get_value();
                } else if (t4 instanceof PhoneParameter) {
                    str = t4.get_value();
                } else {
                    throw new IllegalArgumentException("Cannot copy " + ((Object) t4));
                }
                linkedHashMap2.put(id, str);
            }
            summaryState2 = SummaryState.copy$default(summaryState4, null, null, null, null, linkedHashMap2, false, 47, null);
        }
        this.Q = summaryState2;
        return deliverySummaryRds;
    }

    public final void u(List<? extends Item> list) {
        AdapterPresenter adapterPresenter = this.N;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(list, adapterPresenter);
        }
        this.M = list;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    public void updatePoint(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        SummaryState summaryState = this.Q;
        this.Q = summaryState != null ? SummaryState.copy$default(summaryState, str, str2, str3, null, null, false, 56, null) : null;
        f();
    }

    public static final void access$showError(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl, Throwable th) {
        deliveryRdsSummaryViewModelImpl.showContent();
        if (th instanceof TypedResultException) {
            deliveryRdsSummaryViewModelImpl.h(((TypedResultException) th).getErrorResult());
        } else {
            deliveryRdsSummaryViewModelImpl.l();
        }
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public SingleLiveEvent<Boolean> getCloseScreenChanges() {
        return this.B;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getDeepLinkChanges() {
        return this.z;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public MutableLiveData<Float> getDisabledImageAlphaChanges() {
        return this.C;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public SingleLiveEvent<DeliverySummaryRds.ContactsGroup> getEditContactsChanges() {
        return this.D;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public SingleLiveEvent<Unit> getEditPointChanges() {
        return this.E;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public MutableLiveData<Runnable> getErrorChanges() {
        return this.x;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public MutableLiveData<DeliverySummaryRds.Header> getHeaderChanges() {
        return this.H;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public MutableLiveData<Integer> getItemMaxQuantityChanges() {
        return this.I;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public SingleLiveEvent<String> getPayUrlChanges() {
        return this.A;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public MutableLiveData<Unit> getProgressChanges() {
        return this.w;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public MutableLiveData<Unit> getShowContentChanges() {
        return this.v;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public SingleLiveEvent<Pair<String, Boolean>> getSnackBarErrorChanges() {
        return this.y;
    }

    @Override // com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel
    @NotNull
    public SingleLiveEvent<String> getStepperTooltipMessages() {
        return this.J;
    }
}
