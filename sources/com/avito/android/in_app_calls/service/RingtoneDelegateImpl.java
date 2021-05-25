package com.avito.android.in_app_calls.service;

import a2.a.a.f1.f.r;
import a2.a.a.f1.f.s;
import a2.g.r.g;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0016\"B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004R\u001e\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/in_app_calls/service/RingtoneDelegateImpl;", "Lcom/avito/android/in_app_calls/service/RingtoneDelegate;", "", "playRingtone", "()V", "stopRingtone", "destroy", AuthSource.SEND_ABUSE, "Landroid/media/AudioAttributes;", "kotlin.jvm.PlatformType", "e", "Landroid/media/AudioAttributes;", "ringerAudioAttributes", "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Landroid/app/Service;", "h", "Landroid/app/Service;", NotificationCompat.CATEGORY_SERVICE, "Landroid/app/NotificationManager;", AuthSource.BOOKING_ORDER, "Landroid/app/NotificationManager;", "notificationManager", "", "f", "Z", "isPlaying", "Landroid/media/Ringtone;", "d", "Landroid/media/Ringtone;", "ringtone", "Landroid/media/AudioManager;", "c", "Landroid/media/AudioManager;", "audioManager", "Landroid/os/Vibrator;", "Landroid/os/Vibrator;", "vibrator", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/app/Service;Lcom/avito/android/Features;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class RingtoneDelegateImpl implements RingtoneDelegate {
    public final Vibrator a;
    public final NotificationManager b;
    public final AudioManager c;
    public final Ringtone d;
    public final AudioAttributes e;
    public boolean f;
    public final CompositeDisposable g;
    public final Service h;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Integer> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Integer num) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                } else if (((RingtoneDelegateImpl) this.b).f) {
                    ((RingtoneDelegateImpl) this.b).playRingtone();
                }
            } else if (((RingtoneDelegateImpl) this.b).f) {
                ((RingtoneDelegateImpl) this.b).playRingtone();
            }
        }
    }

    @RequiresApi(23)
    public final class b extends BroadcastReceiver {
        @NotNull
        public final NotificationManager a;
        @NotNull
        public final Function1<Integer, Unit> b;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull RingtoneDelegateImpl ringtoneDelegateImpl, @NotNull NotificationManager notificationManager, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
            Intrinsics.checkNotNullParameter(function1, "callback");
            this.a = notificationManager;
            this.b = function1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.app.action.INTERRUPTION_FILTER_CHANGED")) {
                this.b.invoke(Integer.valueOf(this.a.getCurrentInterruptionFilter()));
            }
        }
    }

    public final class c extends BroadcastReceiver {
        @NotNull
        public final Function1<Integer, Unit> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull RingtoneDelegateImpl ringtoneDelegateImpl, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "callback");
            this.a = function1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            int intExtra;
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.media.RINGER_MODE_CHANGED") && (intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1)) != -1) {
                this.a.invoke(Integer.valueOf(intExtra));
            }
        }
    }

    @Inject
    public RingtoneDelegateImpl(@NotNull Service service, @NotNull Features features) {
        Uri uri;
        Intrinsics.checkNotNullParameter(service, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(features, "features");
        this.h = service;
        Object systemService = service.getSystemService("vibrator");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        this.a = (Vibrator) systemService;
        Object systemService2 = service.getSystemService("notification");
        Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
        this.b = (NotificationManager) systemService2;
        Object systemService3 = service.getSystemService("audio");
        Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.media.AudioManager");
        this.c = (AudioManager) systemService3;
        AudioAttributes build = new AudioAttributes.Builder().setContentType(4).setUsage(6).build();
        this.e = build;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.g = compositeDisposable;
        if (features.getCallsFixRingtone().invoke().booleanValue()) {
            uri = Settings.System.DEFAULT_RINGTONE_URI;
        } else {
            uri = RingtoneManager.getActualDefaultRingtoneUri(service, 1);
        }
        Logs.debug$default("RingtoneDelegate", "Got ringtone uri=[" + uri + ']', null, 4, null);
        Ringtone ringtone = RingtoneManager.getRingtone(service, uri);
        this.d = ringtone;
        if (ringtone != null) {
            ringtone.setAudioAttributes(build);
        }
        Observable create = Observable.create(new s(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ver(receiver) }\n        }");
        Disposable subscribe = create.distinctUntilChanged().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "ringerModeChanges()\n    …          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        if (Build.VERSION.SDK_INT >= 23) {
            Observable create2 = Observable.create(new r(this));
            Intrinsics.checkNotNullExpressionValue(create2, "Observable.create { emit…ver(receiver) }\n        }");
            Disposable subscribe2 = create2.distinctUntilChanged().subscribe(new a(1, this));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "dndModeChanges()\n       …      }\n                }");
            DisposableKt.plusAssign(compositeDisposable, subscribe2);
        }
    }

    public final void a() {
        int vibrateSetting;
        boolean z = true;
        if ((ContextCompat.checkSelfPermission(this.h, "android.permission.VIBRATE") == 0) && this.a.hasVibrator()) {
            int ringerMode = this.c.getRingerMode();
            if (ringerMode == 0 || (ringerMode != 1 && (Build.VERSION.SDK_INT > 22 ? Settings.System.getInt(this.h.getContentResolver(), "vibrate_when_ringing", 0) != 1 : !((vibrateSetting = this.c.getVibrateSetting(0)) == 1 || vibrateSetting == 2)))) {
                z = false;
            }
            if (!z) {
                this.a.cancel();
            } else if (Build.VERSION.SDK_INT >= 26) {
                this.a.vibrate(VibrationEffect.createWaveform(RingtoneDelegateKt.access$getDEFAULT_VIBRATION_PATTERN$p(), 0), this.e);
            } else {
                this.a.vibrate(RingtoneDelegateKt.access$getDEFAULT_VIBRATION_PATTERN$p(), 0, this.e);
            }
        }
    }

    @Override // com.avito.android.in_app_calls.service.RingtoneDelegate
    public void destroy() {
        this.g.dispose();
        if (this.f) {
            stopRingtone();
        }
    }

    @Override // com.avito.android.in_app_calls.service.RingtoneDelegate
    public void playRingtone() {
        int currentInterruptionFilter;
        if ((Build.VERSION.SDK_INT < 23 || (currentInterruptionFilter = this.b.getCurrentInterruptionFilter()) == 0 || currentInterruptionFilter == 1) ? false : true) {
            Ringtone ringtone = this.d;
            if (ringtone != null) {
                try {
                    ringtone.stop();
                } catch (Exception e2) {
                    Logs.debug("RingtoneDelegate", "Failed to stop player", e2);
                }
            }
            a();
        } else {
            this.c.requestAudioFocus(null, 2, 1);
            Ringtone ringtone2 = this.d;
            if (ringtone2 != null) {
                ringtone2.play();
            }
            a();
        }
        this.f = true;
    }

    @Override // com.avito.android.in_app_calls.service.RingtoneDelegate
    public void stopRingtone() {
        Ringtone ringtone = this.d;
        if (ringtone != null) {
            try {
                ringtone.stop();
            } catch (Exception e2) {
                Logs.debug("RingtoneDelegate", "Failed to stop player", e2);
            }
        }
        if ((ContextCompat.checkSelfPermission(this.h, "android.permission.VIBRATE") == 0) && this.a.hasVibrator()) {
            this.a.cancel();
        }
        this.f = false;
    }
}
