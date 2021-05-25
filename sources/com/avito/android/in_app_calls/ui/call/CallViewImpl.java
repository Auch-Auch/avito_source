package com.avito.android.in_app_calls.ui.call;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.ab_tests.groups.CallsNewDesignTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.calls.audio.AudioDevice;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.analytics.AppCallRating;
import com.avito.android.in_app_calls.ui.call.CallPresenter;
import com.avito.android.in_app_calls.ui.call.CallView;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.ScaleInOutTouchListener;
import com.avito.android.util.BackingField;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.internal.CheckableImageButton;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010y\u001a\u00020v\u0012\u0006\u0010[\u001a\u000206\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010H\u001a\u00020E\u0012\f\u0010~\u001a\b\u0012\u0004\u0012\u00020{0z¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J+\u0010\u0013\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R9\u0010+\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u00108V@VX\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001e\u00105\u001a\n 3*\u0004\u0018\u000102028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u00104R\u001e\u00109\u001a\n 3*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010=\u001a\n 3*\u0004\u0018\u00010:0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001e\u0010?\u001a\n 3*\u0004\u0018\u00010:0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010<R\"\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b@\u0010.\u001a\u0004\bA\u00100R\u001e\u0010D\u001a\n 3*\u0004\u0018\u00010:0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010<R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010J\u001a\n 3*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u00108R\u001e\u0010M\u001a\n 3*\u0004\u0018\u00010K0K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010LR\u001e\u0010O\u001a\n 3*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u00108R\u001e\u0010Q\u001a\n 3*\u0004\u0018\u00010:0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010<R\u001e\u0010T\u001a\n 3*\u0004\u0018\u00010R0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010SR\u001e\u0010V\u001a\n 3*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u00108R\"\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010.\u001a\u0004\bX\u00100R\u0016\u0010[\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u00108R\u001e\u0010]\u001a\n 3*\u0004\u0018\u000102028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u00104R\u001e\u0010a\u001a\n 3*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\"\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bb\u0010.\u001a\u0004\bc\u00100R\u001e\u0010f\u001a\n 3*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010`R\u001e\u0010h\u001a\n 3*\u0004\u0018\u00010:0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010<R\u001e\u0010j\u001a\n 3*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010`R\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\"\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bo\u0010.\u001a\u0004\bp\u00100R\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u001c\u0010~\u001a\b\u0012\u0004\u0012\u00020{0z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u001f\u0010\u0001\u001a\n 3*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u00108R \u0010\u0001\u001a\n 3*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00108R \u0010\u0001\u001a\n 3*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010`R%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010.\u001a\u0005\b\u0001\u00100R \u0010\u0001\u001a\n 3*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00108R \u0010\u0001\u001a\n 3*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010`R \u0010\u0001\u001a\n 3*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010`R \u0010\u0001\u001a\n 3*\u0004\u0018\u000106068\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00108¨\u0006\u0001"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallViewImpl;", "Lcom/avito/android/in_app_calls/ui/call/CallView;", "", AuthSource.BOOKING_ORDER, "()V", "Lcom/avito/android/calls_shared/AppCallInfo;", "call", "c", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "", "", AuthSource.SEND_ABUSE, "(J)Ljava/lang/String;", "onStart", "onStop", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "prevState", "curState", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "Lio/reactivex/disposables/CompositeDisposable;", "z", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "G", "Lcom/jakewharton/rxrelay2/Relay;", "getRatingButtonClicks", "()Lcom/jakewharton/rxrelay2/Relay;", "ratingButtonClicks", "Lcom/avito/android/server_time/TimeSource;", "K", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "<set-?>", "H", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;)V", "lastRenderedState", "Lio/reactivex/Observable;", "C", "Lio/reactivex/Observable;", "getHangupClicks", "()Lio/reactivex/Observable;", "hangupClicks", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Landroid/view/View;", "p", "Landroid/view/View;", "connectedCallButtons", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "timerView", "i", "itemNameView", ExifInterface.LONGITUDE_EAST, "getMicClicks", "micClicks", g.a, "statusMessageView", "Lcom/avito/android/calls/audio/CallAudioManager;", "L", "Lcom/avito/android/calls/audio/CallAudioManager;", "audioManager", "l", "ratingBadButton", "Landroid/content/Context;", "Landroid/content/Context;", "context", VKApiConst.Q, "finishedCallButtons", "j", "itemPriceView", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "callTitle", "k", "ratingDialog", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getAnswerClicks", "answerClicks", "J", "rootView", "d", "itemImageView", "Lcom/google/android/material/internal/CheckableImageButton;", "u", "Lcom/google/android/material/internal/CheckableImageButton;", "speakerButton", "B", "getDeclineClicks", "declineClicks", "t", "hangupButton", "e", "displayNameView", "w", "closeButton", "Lio/reactivex/disposables/Disposable;", "y", "Lio/reactivex/disposables/Disposable;", "timerDisposable", "F", "getSpeakerClicks", "speakerClicks", "Landroid/graphics/drawable/Drawable;", "x", "Landroid/graphics/drawable/Drawable;", "itemImagePlaceholder", "Landroid/view/Window;", "I", "Landroid/view/Window;", "window", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/CallsNewDesignTestGroup;", "M", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "newDesignTestGroup", "h", "itemSnippet", "n", "ratingGoodButton", VKApiConst.VERSION, "micButton", "D", "getCloseClicks", "closeClicks", "o", "incomingCallButtons", "s", "answerButton", "r", "declineButton", AuthSource.OPEN_CHANNEL_LIST, "ratingNeutralButton", "<init>", "(Landroid/view/Window;Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/calls/audio/CallAudioManager;Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallViewImpl implements CallView {
    public static final /* synthetic */ KProperty[] N = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(CallViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/in_app_calls/ui/call/CallPresenter$State;", 0))};
    @NotNull
    public final Observable<Unit> A;
    @NotNull
    public final Observable<Unit> B;
    @NotNull
    public final Observable<Unit> C;
    @NotNull
    public final Observable<Unit> D;
    @NotNull
    public final Observable<Unit> E;
    @NotNull
    public final Observable<Unit> F;
    @NotNull
    public final Relay<AppCallRating> G;
    @Nullable
    public final ReadWriteProperty H;
    public final Window I;
    public final View J;
    public final TimeSource K;
    public final CallAudioManager L;
    public final ExposedAbTestGroup<CallsNewDesignTestGroup> M;
    public final Context a;
    public final AppCompatTextView b;
    public final SimpleDraweeView c;
    public final SimpleDraweeView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final View h;
    public final TextView i;
    public final TextView j;
    public final View k;
    public final View l;
    public final View m;
    public final View n;
    public final View o;
    public final View p;
    public final View q;
    public final CheckableImageButton r;
    public final CheckableImageButton s;
    public final CheckableImageButton t;
    public final CheckableImageButton u;
    public final CheckableImageButton v;
    public final CheckableImageButton w;
    public final Drawable x;
    public Disposable y;
    public final CompositeDisposable z;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((CallViewImpl) this.b).getRatingButtonClicks().accept(AppCallRating.Bad.INSTANCE);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((CallViewImpl) this.b).getRatingButtonClicks().accept(AppCallRating.Neutral.INSTANCE);
                return Unit.INSTANCE;
            } else if (i == 2) {
                ((CallViewImpl) this.b).getRatingButtonClicks().accept(AppCallRating.Good.INSTANCE);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<AudioDevice> {
        public final /* synthetic */ CallViewImpl a;

        public b(CallViewImpl callViewImpl) {
            this.a = callViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AudioDevice audioDevice) {
            AudioDevice audioDevice2 = audioDevice;
            CallViewImpl callViewImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(audioDevice2, "it");
            CallViewImpl.access$onAudioDeviceChanged(callViewImpl, audioDevice2);
        }
    }

    public CallViewImpl(@NotNull Window window, @NotNull View view, @NotNull TimeSource timeSource, @NotNull CallAudioManager callAudioManager, @NotNull ExposedAbTestGroup<CallsNewDesignTestGroup> exposedAbTestGroup) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(callAudioManager, "audioManager");
        Intrinsics.checkNotNullParameter(exposedAbTestGroup, "newDesignTestGroup");
        this.I = window;
        this.J = view;
        this.K = timeSource;
        this.L = callAudioManager;
        this.M = exposedAbTestGroup;
        Context context = view.getContext();
        this.a = context;
        this.b = (AppCompatTextView) view.findViewById(R.id.call_title);
        this.c = (SimpleDraweeView) view.findViewById(R.id.avatar);
        this.d = (SimpleDraweeView) view.findViewById(R.id.item_image);
        this.e = (TextView) view.findViewById(R.id.display_name);
        this.f = (TextView) view.findViewById(R.id.call_timer);
        this.g = (TextView) view.findViewById(R.id.status_message);
        this.h = view.findViewById(R.id.item_snippet);
        this.i = (TextView) view.findViewById(R.id.item_title);
        this.j = (TextView) view.findViewById(R.id.item_price);
        this.k = view.findViewById(R.id.call_rating_dialog);
        View findViewById = view.findViewById(R.id.call_rating_dialog_bad_button);
        this.l = findViewById;
        View findViewById2 = view.findViewById(R.id.call_rating_dialog_neutral_button);
        this.m = findViewById2;
        View findViewById3 = view.findViewById(R.id.call_rating_dialog_good_button);
        this.n = findViewById3;
        this.o = view.findViewById(R.id.control_buttons_incoming);
        this.p = view.findViewById(R.id.control_buttons_connected);
        this.q = view.findViewById(R.id.control_buttons_finished);
        CheckableImageButton checkableImageButton = (CheckableImageButton) view.findViewById(R.id.decline_button);
        this.r = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) view.findViewById(R.id.answer_button);
        this.s = checkableImageButton2;
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) view.findViewById(R.id.hangup_button);
        this.t = checkableImageButton3;
        CheckableImageButton checkableImageButton4 = (CheckableImageButton) view.findViewById(R.id.speaker_button);
        this.u = checkableImageButton4;
        CheckableImageButton checkableImageButton5 = (CheckableImageButton) view.findViewById(R.id.mic_button);
        this.v = checkableImageButton5;
        CheckableImageButton checkableImageButton6 = (CheckableImageButton) view.findViewById(R.id.close_button);
        this.w = checkableImageButton6;
        int i2 = R.drawable.ic_call_avito_logo_24;
        Drawable drawable2 = context.getDrawable(i2);
        if (drawable2 != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48));
        } else {
            drawable = null;
        }
        this.x = drawable;
        this.z = new CompositeDisposable();
        Intrinsics.checkNotNullExpressionValue(checkableImageButton2, "answerButton");
        this.A = RxView.clicks(checkableImageButton2);
        Intrinsics.checkNotNullExpressionValue(checkableImageButton, "declineButton");
        this.B = RxView.clicks(checkableImageButton);
        Intrinsics.checkNotNullExpressionValue(checkableImageButton3, "hangupButton");
        this.C = RxView.clicks(checkableImageButton3);
        Intrinsics.checkNotNullExpressionValue(checkableImageButton6, "closeButton");
        this.D = RxView.clicks(checkableImageButton6);
        Intrinsics.checkNotNullExpressionValue(checkableImageButton5, "micButton");
        this.E = RxView.clicks(checkableImageButton5);
        Intrinsics.checkNotNullExpressionValue(checkableImageButton4, "speakerButton");
        this.F = RxView.clicks(checkableImageButton4);
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.G = create;
        this.H = new BackingField(null);
        SimpleDraweeView simpleDraweeView = this.d;
        Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "itemImageView");
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setProgressBarImage(this.a.getDrawable(i2));
        findViewById.setOnTouchListener(new ScaleInOutTouchListener(0, 0, new a(0, this), 3, null));
        findViewById2.setOnTouchListener(new ScaleInOutTouchListener(0, 0, new a(1, this), 3, null));
        findViewById3.setOnTouchListener(new ScaleInOutTouchListener(0, 0, new a(2, this), 3, null));
    }

    public static final void access$onAudioDeviceChanged(CallViewImpl callViewImpl, AudioDevice audioDevice) {
        Objects.requireNonNull(callViewImpl);
        if (Intrinsics.areEqual(audioDevice, AudioDevice.None.INSTANCE) || Intrinsics.areEqual(audioDevice, AudioDevice.Earpiece.INSTANCE) || Intrinsics.areEqual(audioDevice, AudioDevice.WiredHeadset.INSTANCE)) {
            CheckableImageButton checkableImageButton = callViewImpl.u;
            Intrinsics.checkNotNullExpressionValue(checkableImageButton, "speakerButton");
            checkableImageButton.setChecked(false);
        } else if (!Intrinsics.areEqual(audioDevice, AudioDevice.Speaker.INSTANCE) && !Intrinsics.areEqual(audioDevice, AudioDevice.Bluetooth.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            CheckableImageButton checkableImageButton2 = callViewImpl.u;
            Intrinsics.checkNotNullExpressionValue(checkableImageButton2, "speakerButton");
            checkableImageButton2.setChecked(true);
        }
    }

    public final String a(long j2) {
        String formatElapsedTime = DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j2));
        Intrinsics.checkNotNullExpressionValue(formatElapsedTime, "DateUtils.formatElapsedT…ISECONDS.toSeconds(this))");
        return formatElapsedTime;
    }

    public final void b() {
        Disposable disposable = this.y;
        if (disposable != null) {
            disposable.dispose();
        }
        Views.conceal(this.f);
    }

    public final void c(AppCallInfo appCallInfo) {
        if (appCallInfo != null) {
            ItemInfo item = appCallInfo.getItem();
            if ((item != null ? item.getTitle() : null) != null) {
                TextView textView = this.i;
                Intrinsics.checkNotNullExpressionValue(textView, "itemNameView");
                textView.setText(item.getTitle());
                TextView textView2 = this.j;
                Intrinsics.checkNotNullExpressionValue(textView2, "itemPriceView");
                textView2.setText(item.getPrice());
                SimpleDraweeView simpleDraweeView = this.d;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "itemImageView");
                SimpleDraweeViewsKt.loadPicture$default(simpleDraweeView, AvitoPictureKt.pictureOf$default(item.getImage(), false, 0.0f, 0.0f, null, 28, null), this.x, null, 4, null);
                Views.show(this.h);
                return;
            }
            Views.conceal(this.h);
            return;
        }
        Views.conceal(this.h);
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    @NotNull
    public Observable<Unit> getAnswerClicks() {
        return this.A;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    @NotNull
    public Observable<Unit> getCloseClicks() {
        return this.D;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    @NotNull
    public Observable<Unit> getDeclineClicks() {
        return this.B;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    @NotNull
    public Observable<Unit> getHangupClicks() {
        return this.C;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer
    @Nullable
    public CallPresenter.State getLastRenderedState(@NotNull Renderer<CallPresenter.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (CallPresenter.State) this.H.getValue(renderer, N[0]);
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    @NotNull
    public Observable<Unit> getMicClicks() {
        return this.E;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    @NotNull
    public Observable<Unit> getSpeakerClicks() {
        return this.F;
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    public void onStart() {
        Disposable subscribe = this.L.currentAudioDeviceChanges().startWith((Observable<AudioDevice>) this.L.currentAudioDevice()).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "audioManager.currentAudi…nAudioDeviceChanged(it) }");
        DisposableKt.addTo(subscribe, this.z);
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    public void onStop() {
        Disposable disposable = this.y;
        if (disposable != null) {
            disposable.dispose();
        }
        Views.conceal(this.f);
        this.z.clear();
    }

    public void render(@NotNull CallPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        CallView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<CallPresenter.State> renderer, @Nullable CallPresenter.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.H.setValue(renderer, N[0], state);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        if (r2 != null) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doRender(@org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer<com.avito.android.in_app_calls.ui.call.CallPresenter.State> r12, @org.jetbrains.annotations.Nullable com.avito.android.in_app_calls.ui.call.CallPresenter.State r13, @org.jetbrains.annotations.NotNull com.avito.android.in_app_calls.ui.call.CallPresenter.State r14) {
        /*
        // Method dump skipped, instructions count: 885
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.in_app_calls.ui.call.CallViewImpl.doRender(com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer, com.avito.android.in_app_calls.ui.call.CallPresenter$State, com.avito.android.in_app_calls.ui.call.CallPresenter$State):void");
    }

    @Override // com.avito.android.in_app_calls.ui.call.CallView
    @NotNull
    public Relay<AppCallRating> getRatingButtonClicks() {
        return this.G;
    }
}
