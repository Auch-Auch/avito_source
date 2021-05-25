package com.avito.android.payment.lib;

import android.app.Activity;
import android.content.Intent;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.PaymentGenericLink;
import com.avito.android.deep_linking.links.PaymentStatusLink;
import com.avito.android.payment.ModalState;
import com.avito.android.payment.NativeMethodsInteractor;
import com.avito.android.payment.google_pay.GooglePayInteractor;
import com.avito.android.payment.processing.PaymentStatusPollingInteractor;
import com.avito.android.payment.processing.ProcessingResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SimpleUserDialog;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.PaymentMethod;
import com.avito.android.remote.model.payment.generic.PaymentGenericResult;
import com.avito.android.remote.model.payment.service.PaymentSessionResult;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.blueprint.Item;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0004¯\u0001°\u0001BY\u0012\u0006\u0010`\u001a\u00020]\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010 \u0001\u001a\u00030\u0001\u0012\b\u0010¤\u0001\u001a\u00030¡\u0001\u0012\u0006\u0010x\u001a\u00020u\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010X\u001a\u00020U\u0012\u0006\u0010\\\u001a\u00020Y¢\u0006\u0006\b­\u0001\u0010®\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J%\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0015\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u0004J\u0015\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u001d¢\u0006\u0004\b'\u0010 J\r\u0010(\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u0004J\r\u0010)\u001a\u00020\u0002¢\u0006\u0004\b)\u0010\u0004J\u0015\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u001d¢\u0006\u0004\b0\u00101R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u0006028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u00104R\u001f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0006028\u0006@\u0006¢\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001f\u0010L\u001a\b\u0012\u0004\u0012\u00020G0F8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020M028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u00104R:\u0010T\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00020\u0002 Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00020\u0002\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u001d068\u0006@\u0006¢\u0006\f\n\u0004\ba\u00108\u001a\u0004\bb\u0010:R:\u0010e\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00060\u0006 Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00060\u0006\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010SR:\u0010g\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\u001d0\u001d Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010SR\u001f\u0010j\u001a\b\u0012\u0004\u0012\u00020M068\u0006@\u0006¢\u0006\f\n\u0004\bh\u00108\u001a\u0004\bi\u0010:R\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020k028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u00104R:\u0010o\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\"0\" Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\"0\"\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010SR\u001f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u000b068\u0006@\u0006¢\u0006\f\n\u0004\bp\u00108\u001a\u0004\bq\u0010:R:\u0010t\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00020\u0002 Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00020\u0002\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010SR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u001f\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0F8\u0006@\u0006¢\u0006\f\n\u0004\b}\u0010I\u001a\u0004\b~\u0010KR<\u0010\u0001\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00020\u0002 Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00020\u0002\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010SR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00104RC\u0010\u0001\u001a,\u0012\u000e\u0012\f Q*\u0005\u0018\u00010\u00010\u0001 Q*\u0015\u0012\u000e\u0012\f Q*\u0005\u0018\u00010\u00010\u0001\u0018\u00010\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R<\u0010\u0001\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\u001d0\u001d Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010SR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020*0F8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010I\u001a\u0005\b\u0001\u0010KR\u001f\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00104R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00104R<\u0010\u0001\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00020\u0002 Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00020\u0002\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010SR\u001a\u0010 \u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010¤\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R<\u0010¦\u0001\u001a&\u0012\f\u0012\n Q*\u0004\u0018\u00010\u000b0\u000b Q*\u0012\u0012\f\u0012\n Q*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¥\u0001\u0010SR#\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001068\u0006@\u0006¢\u0006\u000e\n\u0005\b§\u0001\u00108\u001a\u0005\b¨\u0001\u0010:R\"\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020k068\u0006@\u0006¢\u0006\u000e\n\u0005\bª\u0001\u00108\u001a\u0005\b«\u0001\u0010:¨\u0006±\u0001"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "loadPaymentMethods", "()V", "onGooglePayButtonClick", "", "paymentMethodPosition", "onPaymentMethodClickListener", "(I)V", "onSubmitPaymentButtonClick", "", "methodSignature", "paymentSessionId", "paymentMethodToken", "sendGeneric", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "activity", "requestCode", "amount", "startGooglePay", "(Landroid/app/Activity;ILjava/lang/String;)V", "Landroid/content/Intent;", "data", "handleGooglePayResponse", "(Landroid/content/Intent;)V", "handleGooglePayError", "handleGooglePayCanceled", "", "success", "onSberbankOnlineAppResult", "(Z)V", "onSberbankOnlineLaunchFailed", "Lcom/avito/android/payment/processing/ProcessingResult;", "result", "handleProcessingResult", "(Lcom/avito/android/payment/processing/ProcessingResult;)V", "shouldCloseActivity", "onDialogClosed", "onCloseButtonClick", "onRefreshButtonClick", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onWebPaymentFinished", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "isGooglePayButton", "isLoading", "setLoadingIndicatorOnButton", "(ZZ)V", "Landroidx/lifecycle/MutableLiveData;", "t", "Landroidx/lifecycle/MutableLiveData;", "mutableSelectedPaymentMethodPositionLiveData", "Landroidx/lifecycle/LiveData;", "w", "Landroidx/lifecycle/LiveData;", "getSubmitButtonInLoadingState", "()Landroidx/lifecycle/LiveData;", "submitButtonInLoadingState", "f", "mutablePayButtonCaptionLiveData", "u", "getSelectedPaymentMethodPositionLiveData", "()Landroidx/lifecycle/MutableLiveData;", "selectedPaymentMethodPositionLiveData", "Lcom/avito/android/payment/lib/PaymentSessionType;", "K", "Lcom/avito/android/payment/lib/PaymentSessionType;", "paymentSessionType", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/payment/lib/PaymentResult;", "l", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getClosePaymentScreenEvent", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "closePaymentScreenEvent", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState;", "d", "mutableViewStateLiveData", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "r", "Lcom/jakewharton/rxrelay2/PublishRelay;", "refreshButtonClicksEvent", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "L", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "M", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/util/SchedulersFactory;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "y", "getGooglePayButtonIsInLoadingState", "googlePayButtonIsInLoadingState", "s", "selectedPaymentMethodPositionRelay", "B", "dialogClosedRelay", "e", "getViewStateLiveData", "viewStateLiveData", "Lcom/avito/android/payment/ModalState;", AuthSource.OPEN_CHANNEL_LIST, "mutableDialogLiveData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "processingResultRelay", a2.g.r.g.a, "getPayButtonCaptionLiveData", "payButtonCaptionLiveData", "D", "sbolLaunchFailedRelay", "Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;", "J", "Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;", "statusPollingInteractor", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "k", "getUriLiveData", "uriLiveData", VKApiConst.Q, "submitButtonClicksRelay", "Lcom/avito/android/payment/NativeMethodsInteractor;", "G", "Lcom/avito/android/payment/NativeMethodsInteractor;", "nativeMethodsInteractor", VKApiConst.VERSION, "mutableSubmitButtonIsInLoadingState", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/avito/android/remote/model/payment/service/PaymentSessionResult;", "o", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "paymentSessionResultRelay", "C", "sbolApp2AppResult", "Lcom/avito/android/payment/lib/PaymentSessionInteractor;", "F", "Lcom/avito/android/payment/lib/PaymentSessionInteractor;", "paymentSessionInteractor", "j", "getDeepLinkLiveData", "deepLinkLiveData", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$GooglePayViewState;", "h", "mutableGooglePayViewStateLiveData", "x", "mutableGooglePayButtonIsInLoadingState", "p", "googlePayButtonClicksRelay", "Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "H", "Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "googlePayInteractor", "Lcom/avito/android/payment/lib/PaymentGenericInteractor;", "I", "Lcom/avito/android/payment/lib/PaymentGenericInteractor;", "paymentGenericInteractor", "z", "googlePayTokenRelay", "i", "getGooglePayViewState", "googlePayViewState", "n", "getDialogLiveData", "dialogLiveData", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/lib/PaymentSessionInteractor;Lcom/avito/android/payment/NativeMethodsInteractor;Lcom/avito/android/payment/google_pay/GooglePayInteractor;Lcom/avito/android/payment/lib/PaymentGenericInteractor;Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;Lcom/avito/android/payment/lib/PaymentSessionType;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "GooglePayViewState", "ViewState", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentMethodsViewModel extends ViewModel {
    public final PublishRelay<ProcessingResult> A;
    public final PublishRelay<Boolean> B;
    public final PublishRelay<Boolean> C;
    public final PublishRelay<Unit> D;
    public final SchedulersFactory E;
    public final PaymentSessionInteractor F;
    public final NativeMethodsInteractor G;
    public final GooglePayInteractor H;
    public final PaymentGenericInteractor I;
    public final PaymentStatusPollingInteractor J;
    public final PaymentSessionType K;
    public final TypedErrorThrowableConverter L;
    public final DeepLinkFactory M;
    public final CompositeDisposable c;
    public final MutableLiveData<ViewState> d;
    @NotNull
    public final LiveData<ViewState> e;
    public final MutableLiveData<String> f;
    @NotNull
    public final LiveData<String> g;
    public final MutableLiveData<GooglePayViewState> h;
    @NotNull
    public final LiveData<GooglePayViewState> i;
    @NotNull
    public final SingleLiveEvent<DeepLink> j = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> k = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<PaymentResult> l = new SingleLiveEvent<>();
    public final MutableLiveData<ModalState> m;
    @NotNull
    public final LiveData<ModalState> n;
    public final BehaviorRelay<PaymentSessionResult> o;
    public final PublishRelay<Unit> p;
    public final PublishRelay<Unit> q;
    public final PublishRelay<Unit> r;
    public final PublishRelay<Integer> s;
    public final MutableLiveData<Integer> t;
    @NotNull
    public final MutableLiveData<Integer> u;
    public final MutableLiveData<Boolean> v;
    @NotNull
    public final LiveData<Boolean> w;
    public final MutableLiveData<Boolean> x;
    @NotNull
    public final LiveData<Boolean> y;
    public final PublishRelay<String> z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsViewModel$GooglePayViewState;", "", "<init>", "()V", "Available", "Unavailable", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$GooglePayViewState$Available;", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$GooglePayViewState$Unavailable;", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class GooglePayViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsViewModel$GooglePayViewState$Available;", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$GooglePayViewState;", "Lcom/avito/android/remote/model/payment/PaymentMethod$GooglePay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/payment/PaymentMethod$GooglePay;", "getPaymentMethod", "()Lcom/avito/android/remote/model/payment/PaymentMethod$GooglePay;", "paymentMethod", "<init>", "(Lcom/avito/android/remote/model/payment/PaymentMethod$GooglePay;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
        public static final class Available extends GooglePayViewState {
            @NotNull
            public final PaymentMethod.GooglePay a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Available(@NotNull PaymentMethod.GooglePay googlePay) {
                super(null);
                Intrinsics.checkNotNullParameter(googlePay, "paymentMethod");
                this.a = googlePay;
            }

            @NotNull
            public final PaymentMethod.GooglePay getPaymentMethod() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsViewModel$GooglePayViewState$Unavailable;", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$GooglePayViewState;", "<init>", "()V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unavailable extends GooglePayViewState {
            @NotNull
            public static final Unavailable INSTANCE = new Unavailable();

            public Unavailable() {
                super(null);
            }
        }

        public GooglePayViewState() {
        }

        public GooglePayViewState(t6.r.a.j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState;", "", "<init>", "()V", "Error", "Loading", "PaymentMethodsList", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState$Loading;", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState$PaymentMethodsList;", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState$Error;", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState$Error;", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ViewState {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState$Loading;", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState;", "<init>", "()V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState$PaymentMethodsList;", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel$ViewState;", "", "Lcom/avito/konveyor/blueprint/Item;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getPaymentMethods", "()Ljava/util/List;", "paymentMethods", "<init>", "(Ljava/util/List;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
        public static final class PaymentMethodsList extends ViewState {
            @NotNull
            public final List<Item> a;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.konveyor.blueprint.Item> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public PaymentMethodsList(@NotNull List<? extends Item> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "paymentMethods");
                this.a = list;
            }

            @NotNull
            public final List<Item> getPaymentMethods() {
                return this.a;
            }
        }

        public ViewState() {
        }

        public ViewState(t6.r.a.j jVar) {
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
        /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((PaymentMethodsViewModel) this.b).loadPaymentMethods();
            } else if (i == 1) {
                ((PaymentMethodsViewModel) this.b).m.setValue(new ModalState.SBOLAppLaunchError());
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T, R> implements Function<PaymentSessionResult, Option<? extends PaymentMethod.GooglePay>> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final Option<? extends PaymentMethod.GooglePay> apply(PaymentSessionResult paymentSessionResult) {
            int i = this.a;
            if (i == 0) {
                PaymentSessionResult paymentSessionResult2 = paymentSessionResult;
                Intrinsics.checkNotNullParameter(paymentSessionResult2, "it");
                return OptionKt.toOption(PaymentMethodsViewModelKt.access$getGooglePayPaymentMethod(paymentSessionResult2));
            } else if (i == 1) {
                PaymentSessionResult paymentSessionResult3 = paymentSessionResult;
                Intrinsics.checkNotNullParameter(paymentSessionResult3, "it");
                return OptionKt.toOption(PaymentMethodsViewModelKt.access$getGooglePayPaymentMethod(paymentSessionResult3));
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Boolean bool) {
            int i = this.a;
            if (i == 0) {
                Boolean bool2 = bool;
                MutableLiveData mutableLiveData = ((PaymentMethodsViewModel) this.b).m;
                Intrinsics.checkNotNullExpressionValue(bool2, "it");
                mutableLiveData.setValue(new ModalState.SBOLResultDialog(bool2.booleanValue()));
            } else if (i == 1) {
                Boolean bool3 = bool;
                ((PaymentMethodsViewModel) this.b).m.setValue(new ModalState.Empty());
                Intrinsics.checkNotNullExpressionValue(bool3, "it");
                if (bool3.booleanValue()) {
                    ((PaymentMethodsViewModel) this.b).getClosePaymentScreenEvent().setValue(PaymentResult.ACTIVE);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class d<T> implements Consumer<ProcessingResult> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public d(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ProcessingResult processingResult) {
            ProcessingResult processingResult2 = processingResult;
            if (processingResult2 instanceof ProcessingResult.Redirect) {
                ProcessingResult.Redirect redirect = (ProcessingResult.Redirect) processingResult2;
                DeepLink createFromUri = this.a.M.createFromUri(redirect.getUriString());
                if (createFromUri instanceof NoMatchLink) {
                    this.a.getUriLiveData().setValue(redirect.getUriString());
                } else {
                    this.a.getDeepLinkLiveData().setValue(createFromUri);
                }
            } else if (processingResult2 instanceof ProcessingResult.Finished) {
                ProcessingResult.Finished finished = (ProcessingResult.Finished) processingResult2;
                SimpleUserDialog userDialog = finished.getPaymentStatus().getUserDialog();
                if (userDialog != null) {
                    this.a.m.setValue(new ModalState.NotifyingDialog(userDialog, !Intrinsics.areEqual(finished.getPaymentStatus().getState(), PaymentStateKt.PAYMENT_STATE_FAILED)));
                    return;
                }
                PaymentMethodsViewModel paymentMethodsViewModel = this.a;
                paymentMethodsViewModel.m.setValue(new ModalState.Empty());
                paymentMethodsViewModel.getClosePaymentScreenEvent().setValue(PaymentMethodsViewModel.access$paymentStatusToPaymentResult(paymentMethodsViewModel, finished.getPaymentStatus()));
            } else if (processingResult2 instanceof ProcessingResult.Error) {
                this.a.m.setValue(new ModalState.ModalError(((ProcessingResult.Error) processingResult2).getMessage()));
            } else {
                boolean z = processingResult2 instanceof ProcessingResult.Canceled;
            }
        }
    }

    public static final class e<T, R> implements Function<PaymentSessionResult, List<? extends List<? extends PaymentMethod>>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends List<? extends PaymentMethod>> apply(PaymentSessionResult paymentSessionResult) {
            PaymentSessionResult paymentSessionResult2 = paymentSessionResult;
            Intrinsics.checkNotNullParameter(paymentSessionResult2, "it");
            return PaymentMethodsViewModelKt.access$getPaymentMethodsWithoutGooglePayGroup(paymentSessionResult2);
        }
    }

    public static final class f<T> implements Consumer<Pair<? extends Integer, ? extends List<? extends List<? extends PaymentMethod>>>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public f(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends Integer, ? extends List<? extends List<? extends PaymentMethod>>> pair) {
            Pair<? extends Integer, ? extends List<? extends List<? extends PaymentMethod>>> pair2 = pair;
            Integer num = (Integer) pair2.component1();
            List list = (List) pair2.component2();
            MutableLiveData mutableLiveData = this.a.d;
            Intrinsics.checkNotNullExpressionValue(list, "paymentMethods");
            List flatten = t6.n.e.flatten(list);
            Intrinsics.checkNotNullExpressionValue(num, "selectedPaymentMethodPosition");
            mutableLiveData.setValue(new ViewState.PaymentMethodsList(PaymentMethodsViewModelKt.access$toKonveyorItems(list, ((PaymentMethod) flatten.get(num.intValue())).getSignature())));
            this.a.getSelectedPaymentMethodPositionLiveData().setValue(num);
        }
    }

    public static final class g<T> implements Consumer<Pair<? extends Unit, ? extends Option<? extends PaymentMethod.GooglePay>>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public g(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends Unit, ? extends Option<? extends PaymentMethod.GooglePay>> pair) {
            PaymentMethod.GooglePay googlePay = (PaymentMethod.GooglePay) ((Option) pair.component2()).orNull();
            if (googlePay != null) {
                this.a.getDeepLinkLiveData().setValue(googlePay.getDeepLink());
            }
        }
    }

    public static final class h<T, R> implements Function<PaymentSessionResult, String> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public String apply(PaymentSessionResult paymentSessionResult) {
            PaymentSessionResult paymentSessionResult2 = paymentSessionResult;
            Intrinsics.checkNotNullParameter(paymentSessionResult2, "it");
            return paymentSessionResult2.getSessionId();
        }
    }

    public static final class i<T> implements Consumer<Triple<? extends String, ? extends String, ? extends Option<? extends PaymentMethod.GooglePay>>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public i(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Triple<? extends String, ? extends String, ? extends Option<? extends PaymentMethod.GooglePay>> triple) {
            Triple<? extends String, ? extends String, ? extends Option<? extends PaymentMethod.GooglePay>> triple2 = triple;
            String str = (String) triple2.component1();
            String str2 = (String) triple2.component2();
            PaymentMethod.GooglePay googlePay = (PaymentMethod.GooglePay) ((Option) triple2.component3()).orNull();
            if (googlePay != null) {
                SingleLiveEvent<DeepLink> deepLinkLiveData = this.a.getDeepLinkLiveData();
                Intrinsics.checkNotNullExpressionValue(str2, "sessionId");
                String signature = googlePay.getSignature();
                Intrinsics.checkNotNullExpressionValue(str, "googlePayToken");
                deepLinkLiveData.setValue(new PaymentGenericLink(str2, signature, str));
            }
        }
    }

    public static final class k<T> implements Consumer<Triple<? extends Unit, ? extends List<? extends PaymentMethod.SelectableMethod>, ? extends Integer>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public k(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Triple<? extends Unit, ? extends List<? extends PaymentMethod.SelectableMethod>, ? extends Integer> triple) {
            Triple<? extends Unit, ? extends List<? extends PaymentMethod.SelectableMethod>, ? extends Integer> triple2 = triple;
            Integer num = (Integer) triple2.component3();
            Intrinsics.checkNotNullExpressionValue(num, VKApiConst.POSITION);
            this.a.getDeepLinkLiveData().setValue(((PaymentMethod.SelectableMethod) ((List) triple2.component2()).get(num.intValue())).getDeepLink());
        }
    }

    public static final class l<T, R> implements Function<Set<? extends String>, ObservableSource<? extends TypedResult<PaymentSessionResult>>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public l(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.payment.lib.PaymentSessionInteractor */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<PaymentSessionResult>> apply(Set<? extends String> set) {
            Set<? extends String> set2 = set;
            Intrinsics.checkNotNullParameter(set2, "nativeMethods");
            return this.a.F.createPaymentSession(this.a.K, set2).subscribeOn(this.a.E.io());
        }
    }

    public static final class m<T, R> implements Function<TypedResult<PaymentSessionResult>, LoadingState<? super PaymentSessionResult>> {
        public static final m a = new m();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PaymentSessionResult> apply(TypedResult<PaymentSessionResult> typedResult) {
            TypedResult<PaymentSessionResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class n<T, R> implements Function<Throwable, LoadingState<? super PaymentSessionResult>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public n(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PaymentSessionResult> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.L.convert(th2));
        }
    }

    public static final class o<T> implements Consumer<LoadingState<? super PaymentSessionResult>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public o(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.jakewharton.rxrelay2.PublishRelay */
        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super PaymentSessionResult> loadingState) {
            Object obj;
            LoadingState<? super PaymentSessionResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.o.accept(loaded.getData());
                this.a.s.accept(0);
                this.a.f.setValue(((PaymentSessionResult) loaded.getData()).getSubmitText());
                MutableLiveData mutableLiveData = this.a.h;
                PaymentMethod.GooglePay access$getGooglePayPaymentMethod = PaymentMethodsViewModelKt.access$getGooglePayPaymentMethod((PaymentSessionResult) loaded.getData());
                if (access$getGooglePayPaymentMethod != null) {
                    obj = new GooglePayViewState.Available(access$getGooglePayPaymentMethod);
                } else {
                    obj = GooglePayViewState.Unavailable.INSTANCE;
                }
                mutableLiveData.setValue(obj);
            } else if (loadingState2 instanceof LoadingState.Loading) {
                this.a.d.setValue(ViewState.Loading.INSTANCE);
            } else if (loadingState2 instanceof LoadingState.Error) {
                MutableLiveData mutableLiveData2 = this.a.d;
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                Objects.requireNonNull(error, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult");
                mutableLiveData2.setValue(new ViewState.Error(((ErrorResult) error).getMessage()));
            }
        }
    }

    public static final class p<T, R> implements Function<TypedResult<PaymentGenericResult>, LoadingState<? super PaymentGenericResult>> {
        public static final p a = new p();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PaymentGenericResult> apply(TypedResult<PaymentGenericResult> typedResult) {
            TypedResult<PaymentGenericResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class q<T, R> implements Function<Throwable, LoadingState<? super PaymentGenericResult>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public q(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PaymentGenericResult> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.L.convert(th2));
        }
    }

    public static final class r<T, R> implements Function<PaymentSessionResult, List<? extends PaymentMethod>> {
        public static final r a = new r();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends PaymentMethod> apply(PaymentSessionResult paymentSessionResult) {
            PaymentSessionResult paymentSessionResult2 = paymentSessionResult;
            Intrinsics.checkNotNullParameter(paymentSessionResult2, "it");
            return t6.n.e.flatten(paymentSessionResult2.getPaymentMethods());
        }
    }

    public static final class s<T> implements Consumer<Pair<? extends LoadingState<? super PaymentGenericResult>, ? extends List<? extends PaymentMethod>>> {
        public final /* synthetic */ PaymentMethodsViewModel a;
        public final /* synthetic */ String b;

        public s(PaymentMethodsViewModel paymentMethodsViewModel, String str) {
            this.a = paymentMethodsViewModel;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r7v7, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends LoadingState<? super PaymentGenericResult>, ? extends List<? extends PaymentMethod>> pair) {
            T t;
            Pair<? extends LoadingState<? super PaymentGenericResult>, ? extends List<? extends PaymentMethod>> pair2 = pair;
            LoadingState loadingState = (LoadingState) pair2.component1();
            List list = (List) pair2.component2();
            Intrinsics.checkNotNullExpressionValue(list, "paymentMethods");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getSignature(), this.b)) {
                    break;
                }
            }
            boolean z = t instanceof PaymentMethod.GooglePay;
            if (loadingState instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
                if (((PaymentGenericResult) loaded.getData()) instanceof PaymentGenericResult.Ok) {
                    Object data = loaded.getData();
                    Objects.requireNonNull(data, "null cannot be cast to non-null type com.avito.android.remote.model.payment.generic.PaymentGenericResult.Ok");
                    String uri = ((PaymentGenericResult.Ok) data).getUri();
                    DeepLink createFromUri = this.a.M.createFromUri(uri);
                    if (createFromUri instanceof PaymentStatusLink) {
                        PaymentStatusLink paymentStatusLink = (PaymentStatusLink) createFromUri;
                        if (paymentStatusLink.getShouldPoll()) {
                            PaymentMethodsViewModel.access$getPaymentStatusPolling(this.a, this.b, 1, paymentStatusLink.getOrderId(), uri);
                            return;
                        }
                    }
                    if (createFromUri instanceof NoMatchLink) {
                        this.a.getUriLiveData().setValue(uri);
                        this.a.setLoadingIndicatorOnButton(z, false);
                        return;
                    }
                    this.a.getDeepLinkLiveData().setValue(createFromUri);
                    this.a.setLoadingIndicatorOnButton(z, false);
                }
            } else if (loadingState instanceof LoadingState.Loading) {
                this.a.setLoadingIndicatorOnButton(z, true);
            } else if (loadingState instanceof LoadingState.Error) {
                this.a.setLoadingIndicatorOnButton(z, false);
                MutableLiveData mutableLiveData = this.a.m;
                TypedError error = ((LoadingState.Error) loadingState).getError();
                Objects.requireNonNull(error, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult");
                mutableLiveData.setValue(new ModalState.ModalError(((ErrorResult) error).getMessage()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14, types: [a2.a.a.t1.c.e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentMethodsViewModel(@org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r7, @org.jetbrains.annotations.NotNull com.avito.android.payment.lib.PaymentSessionInteractor r8, @org.jetbrains.annotations.NotNull com.avito.android.payment.NativeMethodsInteractor r9, @org.jetbrains.annotations.NotNull com.avito.android.payment.google_pay.GooglePayInteractor r10, @org.jetbrains.annotations.NotNull com.avito.android.payment.lib.PaymentGenericInteractor r11, @org.jetbrains.annotations.NotNull com.avito.android.payment.processing.PaymentStatusPollingInteractor r12, @org.jetbrains.annotations.NotNull com.avito.android.payment.lib.PaymentSessionType r13, @org.jetbrains.annotations.NotNull com.avito.android.remote.error.TypedErrorThrowableConverter r14, @org.jetbrains.annotations.NotNull com.avito.android.deep_linking.DeepLinkFactory r15) {
        /*
        // Method dump skipped, instructions count: 509
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.payment.lib.PaymentMethodsViewModel.<init>(com.avito.android.util.SchedulersFactory, com.avito.android.payment.lib.PaymentSessionInteractor, com.avito.android.payment.NativeMethodsInteractor, com.avito.android.payment.google_pay.GooglePayInteractor, com.avito.android.payment.lib.PaymentGenericInteractor, com.avito.android.payment.processing.PaymentStatusPollingInteractor, com.avito.android.payment.lib.PaymentSessionType, com.avito.android.remote.error.TypedErrorThrowableConverter, com.avito.android.deep_linking.DeepLinkFactory):void");
    }

    public static final void access$getPaymentStatusPolling(PaymentMethodsViewModel paymentMethodsViewModel, String str, int i2, String str2, String str3) {
        CompositeDisposable compositeDisposable = paymentMethodsViewModel.c;
        Observable T1 = a2.b.a.a.a.T1(paymentMethodsViewModel.E, paymentMethodsViewModel.J.getPaymentStatus(str2).delay(t6.s.c.roundToLong((float) Math.pow((double) 2.0f, (double) i2)), TimeUnit.SECONDS, paymentMethodsViewModel.E.computation()).subscribeOn(paymentMethodsViewModel.E.io()), "statusPollingInteractor.…lersFactory.mainThread())");
        Observable<R> map = paymentMethodsViewModel.o.map(a2.a.a.t1.c.c.a);
        Intrinsics.checkNotNullExpressionValue(map, "paymentSessionResultRela…aymentMethods.flatten() }");
        Observable withLatestFrom = T1.withLatestFrom(map, PaymentMethodsViewModel$getPaymentStatusPolling$$inlined$withLatestFrom$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(withLatestFrom, "withLatestFrom(other, Bi…n { t1, t2 -> t1 to t2 })");
        Disposable subscribe = withLatestFrom.subscribe(new a2.a.a.t1.c.d(paymentMethodsViewModel, str, i2, str2, str3));
        Intrinsics.checkNotNullExpressionValue(subscribe, "statusPollingInteractor.…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final PaymentResult access$paymentStatusToPaymentResult(PaymentMethodsViewModel paymentMethodsViewModel, PaymentStatusResult.PaymentStatus paymentStatus) {
        Objects.requireNonNull(paymentMethodsViewModel);
        String state = paymentStatus.getState();
        int hashCode = state.hashCode();
        if (hashCode != -1422950650) {
            if (hashCode == 3089282 && state.equals(PaymentStateKt.PAYMENT_STATE_DONE)) {
                return PaymentResult.SUCCESS;
            }
        } else if (state.equals("active")) {
            return PaymentResult.ACTIVE;
        }
        return PaymentResult.FAILURE;
    }

    @NotNull
    public final SingleLiveEvent<PaymentResult> getClosePaymentScreenEvent() {
        return this.l;
    }

    @NotNull
    public final SingleLiveEvent<DeepLink> getDeepLinkLiveData() {
        return this.j;
    }

    @NotNull
    public final LiveData<ModalState> getDialogLiveData() {
        return this.n;
    }

    @NotNull
    public final LiveData<Boolean> getGooglePayButtonIsInLoadingState() {
        return this.y;
    }

    @NotNull
    public final LiveData<GooglePayViewState> getGooglePayViewState() {
        return this.i;
    }

    @NotNull
    public final LiveData<String> getPayButtonCaptionLiveData() {
        return this.g;
    }

    @NotNull
    public final MutableLiveData<Integer> getSelectedPaymentMethodPositionLiveData() {
        return this.u;
    }

    @NotNull
    public final LiveData<Boolean> getSubmitButtonInLoadingState() {
        return this.w;
    }

    @NotNull
    public final SingleLiveEvent<String> getUriLiveData() {
        return this.k;
    }

    @NotNull
    public final LiveData<ViewState> getViewStateLiveData() {
        return this.e;
    }

    public final void handleGooglePayCanceled() {
        this.x.setValue(Boolean.FALSE);
    }

    public final void handleGooglePayError(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        this.H.handleGooglePayError(intent);
    }

    public final void handleGooglePayResponse(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        String extractPaymentToken = this.H.extractPaymentToken(intent);
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(extractPaymentToken, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = extractPaymentToken.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.z.accept(Base64.encodeToString(bytes, 0));
    }

    public final void handleProcessingResult(@NotNull ProcessingResult processingResult) {
        Intrinsics.checkNotNullParameter(processingResult, "result");
        this.A.accept(processingResult);
    }

    public final void loadPaymentMethods() {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.G.getNativeMethods().flatMap(new l(this)).map(m.a).startWith((Observable<R>) ((R) LoadingState.Loading.INSTANCE)).onErrorReturn(new n(this)).subscribeOn(this.E.io()).observeOn(this.E.mainThread()).subscribe(new o(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "nativeMethodsInteractor.…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void onCloseButtonClick() {
        this.l.setValue(PaymentResult.FAILURE);
    }

    public final void onDialogClosed(boolean z2) {
        this.B.accept(Boolean.valueOf(z2));
    }

    public final void onGooglePayButtonClick() {
        this.p.accept(Unit.INSTANCE);
    }

    public final void onPaymentMethodClickListener(int i2) {
        this.s.accept(Integer.valueOf(i2));
    }

    public final void onRefreshButtonClick() {
        this.r.accept(Unit.INSTANCE);
    }

    public final void onSberbankOnlineAppResult(boolean z2) {
        this.C.accept(Boolean.valueOf(z2));
    }

    public final void onSberbankOnlineLaunchFailed() {
        this.D.accept(Unit.INSTANCE);
    }

    public final void onSubmitPaymentButtonClick() {
        this.q.accept(Unit.INSTANCE);
    }

    public final void onWebPaymentFinished(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.j.setValue(deepLink);
    }

    public final void sendGeneric(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "methodSignature", str2, "paymentSessionId", str3, "paymentMethodToken");
        CompositeDisposable compositeDisposable = this.c;
        Observable T1 = a2.b.a.a.a.T1(this.E, this.I.paymentGeneric(this.K, str2, str, str3).map(p.a).startWith((Observable<R>) ((R) LoadingState.Loading.INSTANCE)).onErrorReturn(new q(this)).subscribeOn(this.E.io()), "paymentGenericInteractor…lersFactory.mainThread())");
        Observable<R> map = this.o.map(r.a);
        Intrinsics.checkNotNullExpressionValue(map, "paymentSessionResultRela…aymentMethods.flatten() }");
        Observable withLatestFrom = T1.withLatestFrom(map, PaymentMethodsViewModel$sendGeneric$$inlined$withLatestFrom$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(withLatestFrom, "withLatestFrom(other, Bi…n { t1, t2 -> t1 to t2 })");
        Disposable subscribe = withLatestFrom.subscribe(new s(this, str));
        Intrinsics.checkNotNullExpressionValue(subscribe, "paymentGenericInteractor…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void setLoadingIndicatorOnButton(boolean z2, boolean z3) {
        if (z2) {
            this.x.setValue(Boolean.valueOf(z3));
        } else {
            this.v.setValue(Boolean.valueOf(z3));
        }
    }

    public final void startGooglePay(@NotNull Activity activity, int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "amount");
        this.H.startGooglePay(activity, i2, str);
    }
}
