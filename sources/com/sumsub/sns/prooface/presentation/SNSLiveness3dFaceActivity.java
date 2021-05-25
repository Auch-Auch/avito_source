package com.sumsub.sns.prooface.presentation;

import a2.b.a.a.a;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.annotation.Keep;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.transition.TransitionManager;
import butterknife.BindView;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.preferences.SessionContract;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameProcessor;
import com.sumsub.idensic_mobile_sdk_liveness_3dface.R;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.SNSModule;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.data.model.AnswerType;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.data.model.SNSLivenessResult;
import com.sumsub.sns.core.presentation.BaseActivity;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.prooface.SNSProoface;
import com.sumsub.sns.prooface.presentation.view.SNSLivenessFaceView;
import com.transitionseverywhere.ChangeText;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.r.a.j;
import timber.log.Timber;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.jwhDxwXekejRxO2JfrNpROimz;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\u000fJ\u001b\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ3\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0007\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\rH\u0014¢\u0006\u0004\b \u0010\u000fJ\u000f\u0010!\u001a\u00020\rH\u0014¢\u0006\u0004\b!\u0010\u000fJ/\u0010'\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00142\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\rH\u0014¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\rH\u0014¢\u0006\u0004\b*\u0010\u000fJ\u0017\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J!\u00102\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u0014H\u0016¢\u0006\u0004\b2\u00103R\u0016\u00105\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u00104R\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001d\u0010P\u001a\u00020\u00028T@\u0014X\u0002¢\u0006\f\n\u0004\b\u0007\u0010M\u001a\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020Q8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010RR\"\u0010T\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bT\u0010@\u001a\u0004\bU\u0010B\"\u0004\bV\u0010DR\"\u0010X\u001a\u00020W8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010d\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\be\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR\"\u0010i\u001a\u00020h8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010o\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bo\u0010@\u001a\u0004\bp\u0010B\"\u0004\bq\u0010DR\"\u0010s\u001a\u00020r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010y\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\by\u0010@\u001a\u0004\bz\u0010B\"\u0004\b{\u0010DR\"\u0010|\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b|\u0010@\u001a\u0004\b}\u0010B\"\u0004\b~\u0010DR \u0010\u0001\u001a\u00020:8B@\u0002X\u0002¢\u0006\u000e\n\u0004\b\u0010M\u001a\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u00020:8B@\u0002X\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010M\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010<R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/prooface/presentation/SNSLiveness3dFaceActivity;", "Lcom/sumsub/sns/core/presentation/BaseActivity;", "LxwKerWrNChj/xwKerWrNChj/xwKerWrNChj/xwKerWrNChj/Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g/tjrpI83q5sk1iMEXPz1hKo;", "Landroid/hardware/SensorEventListener;", "Lcom/sumsub/sns/core/data/model/SNSLivenessResult;", "result", "Landroid/content/Intent;", "Cwa7EHp4RmMFhwpOCPWojiqbo", "(Lcom/sumsub/sns/core/data/model/SNSLivenessResult;)Landroid/content/Intent;", "LxwKerWrNChj/xwKerWrNChj/xwKerWrNChj/xwKerWrNChj/xwKerWrNChj/YuBMj5oYSZ1EKs0piMUZxDCY;", SessionContract.SESSION, "", "(LxwKerWrNChj/xwKerWrNChj/xwKerWrNChj/xwKerWrNChj/xwKerWrNChj/YuBMj5oYSZ1EKs0piMUZxDCY;)Ljava/lang/String;", "", "aDBqOnRnCJ0gWECtZQu", "()V", "lk42nG4RRcMiHe8r6w", "ejVYvrSYmsA1fCSIPxDrI", "Landroid/content/Context;", "context", "", "screenBrightnessMode", "screenBrightnessValue", "Lkotlin/Pair;", "(Landroid/content/Context;II)Lkotlin/Pair;", "getLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "onStart", "onStop", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onPause", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "(Landroid/hardware/SensorEvent;)V", "Landroid/hardware/Sensor;", "sensor", GeoContract.ACCURACY, "onAccuracyChanged", "(Landroid/hardware/Sensor;I)V", "I", "brightnessValue", "", "yr0oPNYrJWblwzfs6tPicPv", "F", "illumination", "", "TISdV9vjEDKYTeuQpV0VHpJbW", "Z", "isLivenessStarted", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "brightnessMode", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "Lkotlin/Lazy;", "oVTxbCNkVuXyP468Xhsl9qtSE9v", "()LxwKerWrNChj/xwKerWrNChj/xwKerWrNChj/xwKerWrNChj/Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g/tjrpI83q5sk1iMEXPz1hKo;", "viewModel", "Landroid/graphics/RectF;", "()Landroid/graphics/RectF;", "capturingBox", "tvDebug", "getTvDebug", "setTvDebug", "Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView;", "faceView", "Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView;", "getFaceView", "()Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView;", "setFaceView", "(Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView;)V", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getIvCompleteImage", "()Landroid/widget/ImageView;", "setIvCompleteImage", "(Landroid/widget/ImageView;)V", "ivCompleteImage", "ivIcon", "getIvIcon", "setIvIcon", "Landroid/widget/Button;", "btnTryAgain", "Landroid/widget/Button;", "getBtnTryAgain", "()Landroid/widget/Button;", "setBtnTryAgain", "(Landroid/widget/Button;)V", "tvSubTitle", "getTvSubTitle", "setTvSubTitle", "Lcom/otaliastudios/cameraview/CameraView;", "cameraView", "Lcom/otaliastudios/cameraview/CameraView;", "getCameraView", "()Lcom/otaliastudios/cameraview/CameraView;", "setCameraView", "(Lcom/otaliastudios/cameraview/CameraView;)V", "tvHint", "getTvHint", "setTvHint", "tvPowered", "getTvPowered", "setTvPowered", "idM1z15K75", "getAllowSettingsDialog", "()Z", "allowSettingsDialog", "Landroid/view/ViewGroup;", "vgResult", "Landroid/view/ViewGroup;", "getVgResult", "()Landroid/view/ViewGroup;", "setVgResult", "(Landroid/view/ViewGroup;)V", "Lcom/otaliastudios/cameraview/CameraListener;", "Ku863HM4m4Edc3Ql5I", "Lcom/otaliastudios/cameraview/CameraListener;", "cameraListener", "Landroid/hardware/SensorManager;", "N434VQHTrGUotPhpDDIhYJrpL4ro", "Landroid/hardware/SensorManager;", "sensorManager", "mdHgHuGChkRJqBUMUk707", "isDebug", "needRestoreBrightness", "Lcom/otaliastudios/cameraview/frame/FrameProcessor;", "qNDua1J9EaZOsmugz0J", "Lcom/otaliastudios/cameraview/frame/FrameProcessor;", "frameProcessor", "J3eZRYS4AnxhOKbC2x2nQNPT", "Landroid/hardware/Sensor;", "lightSensor", "<init>", "Companion", "idensic-mobile-sdk-prooface_release"}, k = 1, mv = {1, 4, 2})
public final class SNSLiveness3dFaceActivity extends BaseActivity<xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo> implements SensorEventListener {
    @Keep
    @NotNull
    public static final String EXTRA_RESULT = "EXTRA_RESULT";
    public static final String[] aHA7rWvEdW6bbOdx1EKD4aVF0k = {"android.permission.CAMERA"};
    @NotNull
    public final Lazy Cwa7EHp4RmMFhwpOCPWojiqbo = new ViewModelLazy(Reflection.getOrCreateKotlinClass(xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo.class), new VVeXCTyov0hLti0HOLqom2taL0gk(this), new TMhVE1fAztLhk7pGvAeXb(this));
    public Sensor J3eZRYS4AnxhOKbC2x2nQNPT;
    public final CameraListener Ku863HM4m4Edc3Ql5I = new BYfFGQyI88(this);
    public SensorManager N434VQHTrGUotPhpDDIhYJrpL4ro;
    public boolean TISdV9vjEDKYTeuQpV0VHpJbW;
    public boolean aDBqOnRnCJ0gWECtZQu;
    @BindView(1952)
    public Button btnTryAgain;
    @BindView(1956)
    public CameraView cameraView;
    public int ejVYvrSYmsA1fCSIPxDrI = 255;
    @BindView(2022)
    public SNSLivenessFaceView faceView;
    public final Lazy idM1z15K75 = c.lazy(UGPkPVVOmk179tTX8sQoOodQt.Cwa7EHp4RmMFhwpOCPWojiqbo);
    @BindView(2062)
    public ImageView ivIcon;
    public int lk42nG4RRcMiHe8r6w;
    public final Lazy mdHgHuGChkRJqBUMUk707 = c.lazy(DDdm1ec8RQad6rlXcC8U.Cwa7EHp4RmMFhwpOCPWojiqbo);
    public ImageView oVTxbCNkVuXyP468Xhsl9qtSE9v;
    public final FrameProcessor qNDua1J9EaZOsmugz0J = new alNh9hLeM39(this);
    @BindView(2258)
    public Toolbar toolbar;
    @BindView(1987)
    public TextView tvDebug;
    @BindView(2272)
    public TextView tvHint;
    @BindView(2273)
    public TextView tvPowered;
    @BindView(2274)
    public TextView tvSubTitle;
    @BindView(2275)
    public TextView tvTitle;
    @BindView(2280)
    public ViewGroup vgResult;
    public float yr0oPNYrJWblwzfs6tPicPv = Float.MAX_VALUE;

    public static final class AyZhE6NYuOjRPjA<T> implements Observer<T> {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        public AyZhE6NYuOjRPjA(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            if (t != null) {
                T t2 = t;
                if (t2 instanceof tjrpI83q5sk1iMEXPz1hKo.alNh9hLeM39.C0698alNh9hLeM39) {
                    StringBuilder L = a.L("Liveness3dResult.Progress: ");
                    L.append(t2.Cwa7EHp4RmMFhwpOCPWojiqbo);
                    Timber.d(L.toString(), new Object[0]);
                } else if (t2 instanceof tjrpI83q5sk1iMEXPz1hKo.alNh9hLeM39.UGPkPVVOmk179tTX8sQoOodQt) {
                    StringBuilder L2 = a.L("Liveness3dResult.Error: ");
                    T t3 = t2;
                    L2.append(t3.Cwa7EHp4RmMFhwpOCPWojiqbo);
                    Timber.d(L2.toString(), new Object[0]);
                    if (t3.Cwa7EHp4RmMFhwpOCPWojiqbo instanceof SNSException.Network) {
                        SNSLiveness3dFaceActivity.lk42nG4RRcMiHe8r6w(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
                    }
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.getViewModel().Cwa7EHp4RmMFhwpOCPWojiqbo(t3.Cwa7EHp4RmMFhwpOCPWojiqbo);
                } else if (t2 instanceof tjrpI83q5sk1iMEXPz1hKo.alNh9hLeM39.DDdm1ec8RQad6rlXcC8U) {
                    StringBuilder L3 = a.L("Liveness3dResult.SessionResult: ");
                    T t4 = t2;
                    L3.append(t4.Cwa7EHp4RmMFhwpOCPWojiqbo);
                    Timber.d(L3.toString(), new Object[0]);
                    SNSLiveness3dFaceActivity.Cwa7EHp4RmMFhwpOCPWojiqbo(this.Cwa7EHp4RmMFhwpOCPWojiqbo, t4.Cwa7EHp4RmMFhwpOCPWojiqbo);
                } else if (Intrinsics.areEqual(t2, tjrpI83q5sk1iMEXPz1hKo.alNh9hLeM39.mrIBiYc0Jm.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                    Timber.d("Liveness3dResult.Started", new Object[0]);
                    SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                    ExtensionsKt.setTextWithAnimation(sNSLiveness3dFaceActivity.tvHint, sNSLiveness3dFaceActivity.getTextResource(R.string.sns_facescan_hint_facePosition));
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.ejVYvrSYmsA1fCSIPxDrI();
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.oVTxbCNkVuXyP468Xhsl9qtSE9v.setVisibility(8);
                } else if (Intrinsics.areEqual(t2, tjrpI83q5sk1iMEXPz1hKo.alNh9hLeM39.BYfFGQyI88.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                    Timber.d("Liveness3dResult.LowConnection", new Object[0]);
                    SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                    ExtensionsKt.setTextWithAnimation(sNSLiveness3dFaceActivity2.tvHint, sNSLiveness3dFaceActivity2.getTextResource(R.string.sns_facescan_hint_processingTakesTooLong));
                } else if (t2 instanceof tjrpI83q5sk1iMEXPz1hKo.alNh9hLeM39.VVeXCTyov0hLti0HOLqom2taL0gk) {
                    Timber.d("Liveness3dResult.Completed", new Object[0]);
                    TransitionManager.beginDelayedTransition((ViewGroup) this.Cwa7EHp4RmMFhwpOCPWojiqbo.findViewById(R.id.overlayContainer), new ChangeText().setChangeBehavior(3));
                    SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity3 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                    ExtensionsKt.setTextWithAnimation(sNSLiveness3dFaceActivity3.tvHint, sNSLiveness3dFaceActivity3.getTextResource(R.string.sns_facescan_hint_processing));
                    SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity4 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                    sNSLiveness3dFaceActivity4.getClass();
                    Timber.d("stopLivenessSession", new Object[0]);
                    sNSLiveness3dFaceActivity4.TISdV9vjEDKYTeuQpV0VHpJbW = false;
                    sNSLiveness3dFaceActivity4.cameraView.removeFrameProcessor(sNSLiveness3dFaceActivity4.qNDua1J9EaZOsmugz0J);
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.oVTxbCNkVuXyP468Xhsl9qtSE9v();
                    if (this.Cwa7EHp4RmMFhwpOCPWojiqbo.oVTxbCNkVuXyP468Xhsl9qtSE9v.getVisibility() != 0) {
                        ImageView imageView = this.Cwa7EHp4RmMFhwpOCPWojiqbo.oVTxbCNkVuXyP468Xhsl9qtSE9v;
                        imageView.setImageBitmap(t2.Cwa7EHp4RmMFhwpOCPWojiqbo);
                        imageView.setVisibility(0);
                        imageView.setAlpha(0.0f);
                        imageView.animate().alpha(1.0f).setDuration((long) imageView.getResources().getInteger(17694720)).start();
                    }
                }
            }
        }
    }

    public static final class BYfFGQyI88 extends CameraListener {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public BYfFGQyI88(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onCameraError(@NotNull CameraException cameraException) {
            Timber.d("onCameraError: " + cameraException, new Object[0]);
            super.onCameraError(cameraException);
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.getViewModel().Cwa7EHp4RmMFhwpOCPWojiqbo(cameraException);
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onCameraOpened(@NotNull CameraOptions cameraOptions) {
            SNSLiveness3dFaceActivity.ejVYvrSYmsA1fCSIPxDrI(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.ejVYvrSYmsA1fCSIPxDrI();
        }
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00068\u0006@\u0007XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/prooface/presentation/SNSLiveness3dFaceActivity$Companion;", "", "Landroid/content/Context;", "context", "Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "", "idDocSetType", "actionId", "actionType", "Landroid/content/Intent;", "newIntent", "(Landroid/content/Context;Lcom/sumsub/sns/core/common/SNSSession;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "EXTRA_ACTION_ID", "Ljava/lang/String;", "EXTRA_ACTION_TYPE", "EXTRA_ID_DOC_SET_TYPE", "EXTRA_RESULT", "", "MINIMUM_LIGHT", "I", "REQUEST_CAMERA_PERMISSION", "", "REQUIRED_PERMISSIONS", "[Ljava/lang/String;", "", "RESULT_DELAY", "J", "<init>", "()V", "idensic-mobile-sdk-prooface_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Intent newIntent$default(Companion companion, Context context, SNSSession sNSSession, String str, String str2, String str3, int i, Object obj) {
            return companion.newIntent(context, sNSSession, str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
        }

        @Keep
        @NotNull
        public final Intent newIntent(@NotNull Context context, @NotNull SNSSession sNSSession, @NotNull String str, @Nullable String str2, @Nullable String str3) {
            return new Intent(context, SNSLiveness3dFaceActivity.class).putExtra("EXTRA_ID_DOC_SET_TYPE", str).putExtra("EXTRA_ACTION_ID", str2).putExtra("EXTRA_ACTION_TYPE", str3).putExtra(SNSConstants.Intent.SNS_EXTRA_SESSION, sNSSession);
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public static final class DDdm1ec8RQad6rlXcC8U extends Lambda implements Function0<Boolean> {
        public static final DDdm1ec8RQad6rlXcC8U Cwa7EHp4RmMFhwpOCPWojiqbo = new DDdm1ec8RQad6rlXcC8U();

        public DDdm1ec8RQad6rlXcC8U() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            SNSModule pluggedModule = SNSMobileSDK.INSTANCE.getPluggedModule(SNSProoface.class.getName());
            if (!(pluggedModule instanceof SNSProoface)) {
                pluggedModule = null;
            }
            SNSProoface sNSProoface = (SNSProoface) pluggedModule;
            return Boolean.valueOf(sNSProoface != null ? sNSProoface.isDebug() : false);
        }
    }

    public static final class IXGaYizhe6FCHn8nw5EAC9h8U1<T> implements Observer<Event<? extends T>> {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        public IXGaYizhe6FCHn8nw5EAC9h8U1(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object obj) {
            Object contentIfNotHandled;
            SNSLivenessReason reason;
            Event event = (Event) obj;
            if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                SNSLivenessResult sNSLivenessResult = (SNSLivenessResult) contentIfNotHandled;
                SNSLivenessReason sNSLivenessReason = null;
                SNSLivenessResult.FaceDetection faceDetection = (SNSLivenessResult.FaceDetection) (!(contentIfNotHandled instanceof SNSLivenessResult.FaceDetection) ? null : contentIfNotHandled);
                if (faceDetection == null || (reason = faceDetection.getReason()) == null) {
                    if (!(contentIfNotHandled instanceof SNSLivenessResult.FaceAuth)) {
                        contentIfNotHandled = null;
                    }
                    SNSLivenessResult.FaceAuth faceAuth = (SNSLivenessResult.FaceAuth) contentIfNotHandled;
                    if (faceAuth != null) {
                        sNSLivenessReason = faceAuth.getReason();
                    }
                } else {
                    sNSLivenessReason = reason;
                }
                if (!(sNSLivenessReason instanceof SNSLivenessReason.VeritifcationSuccessfully) && !Intrinsics.areEqual(sNSLivenessReason, SNSLivenessReason.CompletedUnsuccessfullyAllowContinue.INSTANCE)) {
                    SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                    String[] strArr = SNSLiveness3dFaceActivity.aHA7rWvEdW6bbOdx1EKD4aVF0k;
                    sNSLiveness3dFaceActivity.setResult(0, sNSLiveness3dFaceActivity.Cwa7EHp4RmMFhwpOCPWojiqbo(sNSLivenessResult));
                } else {
                    SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                    String[] strArr2 = SNSLiveness3dFaceActivity.aHA7rWvEdW6bbOdx1EKD4aVF0k;
                    sNSLiveness3dFaceActivity2.setResult(-1, sNSLiveness3dFaceActivity2.Cwa7EHp4RmMFhwpOCPWojiqbo(sNSLivenessResult));
                }
                this.Cwa7EHp4RmMFhwpOCPWojiqbo.finish();
            }
        }
    }

    public static final class TMhVE1fAztLhk7pGvAeXb extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TMhVE1fAztLhk7pGvAeXb(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            super(0);
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            return new jwhDxwXekejRxO2JfrNpROimz(sNSLiveness3dFaceActivity, sNSLiveness3dFaceActivity.getServiceLocator(), this.Cwa7EHp4RmMFhwpOCPWojiqbo.getIntent().getExtras());
        }
    }

    public static final class UGPkPVVOmk179tTX8sQoOodQt extends Lambda implements Function0<Boolean> {
        public static final UGPkPVVOmk179tTX8sQoOodQt Cwa7EHp4RmMFhwpOCPWojiqbo = new UGPkPVVOmk179tTX8sQoOodQt();

        public UGPkPVVOmk179tTX8sQoOodQt() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            SNSModule pluggedModule = SNSMobileSDK.INSTANCE.getPluggedModule(SNSProoface.class.getName());
            if (!(pluggedModule instanceof SNSProoface)) {
                pluggedModule = null;
            }
            SNSProoface sNSProoface = (SNSProoface) pluggedModule;
            return Boolean.valueOf(sNSProoface != null ? sNSProoface.isShowSettingsDialog() : false);
        }
    }

    public static final class VVeXCTyov0hLti0HOLqom2taL0gk extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VVeXCTyov0hLti0HOLqom2taL0gk(ComponentActivity componentActivity) {
            super(0);
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = componentActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelStore invoke() {
            return this.Cwa7EHp4RmMFhwpOCPWojiqbo.getViewModelStore();
        }
    }

    public static final class YuBMj5oYSZ1EKs0piMUZxDCY implements SNSLivenessFaceView.mrIBiYc0Jm {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public YuBMj5oYSZ1EKs0piMUZxDCY(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // com.sumsub.sns.prooface.presentation.view.SNSLivenessFaceView.mrIBiYc0Jm
        public void Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull SNSLivenessFaceView.DDdm1ec8RQad6rlXcC8U dDdm1ec8RQad6rlXcC8U) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.getViewModel().YWVVuaVDYicbKjhsZbjQiRooZ = dDdm1ec8RQad6rlXcC8U == SNSLivenessFaceView.DDdm1ec8RQad6rlXcC8U.Recognized;
        }
    }

    public static final class alNh9hLeM39 implements FrameProcessor {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        public static final class VVeXCTyov0hLti0HOLqom2taL0gk implements Runnable {
            public final /* synthetic */ String Cwa7EHp4RmMFhwpOCPWojiqbo;
            public final /* synthetic */ alNh9hLeM39 oVTxbCNkVuXyP468Xhsl9qtSE9v;

            public VVeXCTyov0hLti0HOLqom2taL0gk(String str, alNh9hLeM39 alnh9hlem39, Frame frame) {
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = str;
                this.oVTxbCNkVuXyP468Xhsl9qtSE9v = alnh9hlem39;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.oVTxbCNkVuXyP468Xhsl9qtSE9v.Cwa7EHp4RmMFhwpOCPWojiqbo.tvDebug.setText(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
            }
        }

        public alNh9hLeM39(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // com.otaliastudios.cameraview.frame.FrameProcessor
        public final void process(@NotNull Frame frame) {
            SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            if (sNSLiveness3dFaceActivity.TISdV9vjEDKYTeuQpV0VHpJbW) {
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo oVTxbCNkVuXyP468Xhsl9qtSE9v = sNSLiveness3dFaceActivity.getViewModel();
                RectF Cwa7EHp4RmMFhwpOCPWojiqbo2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo.Cwa7EHp4RmMFhwpOCPWojiqbo();
                int format = frame.getFormat();
                int rotationToView = frame.getRotationToView();
                int width = frame.getSize().getWidth();
                int height = frame.getSize().getHeight();
                Object data = frame.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                oVTxbCNkVuXyP468Xhsl9qtSE9v.TJ0S4kl1Dl9bj8ZIzGCLBDun.processImage(Cwa7EHp4RmMFhwpOCPWojiqbo2, format, rotationToView, width, height, (byte[]) data, new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.drPJedvLehhLIDUBStFv2zCqMzLzQ(oVTxbCNkVuXyP468Xhsl9qtSE9v));
                SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                TextView textView = sNSLiveness3dFaceActivity2.tvDebug;
                if (!((Boolean) sNSLiveness3dFaceActivity2.mdHgHuGChkRJqBUMUk707.getValue()).booleanValue()) {
                    textView = null;
                }
                if (textView != null) {
                    StringBuilder L = a.L(" Rotation: ");
                    L.append(frame.getRotationToView());
                    L.append(" Time: ");
                    L.append(frame.getTime());
                    L.append(" \nBox: ");
                    L.append(this.Cwa7EHp4RmMFhwpOCPWojiqbo.Cwa7EHp4RmMFhwpOCPWojiqbo());
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.tvDebug.post(new VVeXCTyov0hLti0HOLqom2taL0gk(L.toString(), this, frame));
                }
            }
        }
    }

    public static final class djGN3DbfslkNo4T0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        public djGN3DbfslkNo4T0(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            ExtensionsKt.openAppSettings(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
        }
    }

    public static final class drPJedvLehhLIDUBStFv2zCqMzLzQ implements DialogInterface.OnCancelListener {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        public drPJedvLehhLIDUBStFv2zCqMzLzQ(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.finish();
        }
    }

    public static final class mrIBiYc0Jm<T> implements Observer<T> {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        public mrIBiYc0Jm(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            if (t != null) {
                T t2 = t;
                if (this.Cwa7EHp4RmMFhwpOCPWojiqbo.vgResult.getVisibility() == 0) {
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.aDBqOnRnCJ0gWECtZQu();
                    return;
                }
                SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                if (sNSLiveness3dFaceActivity.TISdV9vjEDKYTeuQpV0VHpJbW) {
                    if (t2 instanceof tjrpI83q5sk1iMEXPz1hKo.BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt) {
                        ExtensionsKt.setTextWithAnimation(sNSLiveness3dFaceActivity.tvHint, sNSLiveness3dFaceActivity.getTextResource(R.string.sns_facescan_hint_facePosition));
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.ejVYvrSYmsA1fCSIPxDrI();
                        if (SNSLiveness3dFaceActivity.oVTxbCNkVuXyP468Xhsl9qtSE9v(this.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                            this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.setFaceRectangle(null);
                        }
                    } else if (t2 instanceof tjrpI83q5sk1iMEXPz1hKo.BYfFGQyI88.C0694BYfFGQyI88) {
                        ExtensionsKt.setTextWithAnimation(sNSLiveness3dFaceActivity.tvHint, sNSLiveness3dFaceActivity.getTextResource(R.string.sns_facescan_hint_facePosition));
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.ejVYvrSYmsA1fCSIPxDrI();
                        if (SNSLiveness3dFaceActivity.oVTxbCNkVuXyP468Xhsl9qtSE9v(this.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                            SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                            sNSLiveness3dFaceActivity2.faceView.setFaceRectangle(SNSLiveness3dFaceActivity.Cwa7EHp4RmMFhwpOCPWojiqbo(sNSLiveness3dFaceActivity2, t2.Cwa7EHp4RmMFhwpOCPWojiqbo));
                        }
                    } else if (Intrinsics.areEqual(t2, tjrpI83q5sk1iMEXPz1hKo.BYfFGQyI88.alNh9hLeM39.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                        SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity3 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                        ExtensionsKt.setTextWithAnimation(sNSLiveness3dFaceActivity3.tvHint, sNSLiveness3dFaceActivity3.getTextResource(R.string.sns_facescan_hint_facePosition));
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.ejVYvrSYmsA1fCSIPxDrI();
                        if (SNSLiveness3dFaceActivity.oVTxbCNkVuXyP468Xhsl9qtSE9v(this.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                            this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.setFaceRectangle(null);
                        }
                    } else if (t2 instanceof tjrpI83q5sk1iMEXPz1hKo.BYfFGQyI88.VVeXCTyov0hLti0HOLqom2taL0gk) {
                        SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity4 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                        ExtensionsKt.setTextWithAnimation(sNSLiveness3dFaceActivity4.tvHint, sNSLiveness3dFaceActivity4.getTextResource(R.string.sns_facescan_hint_lookStraight));
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo.faceView.lk42nG4RRcMiHe8r6w();
                        if (SNSLiveness3dFaceActivity.oVTxbCNkVuXyP468Xhsl9qtSE9v(this.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                            SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity5 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                            sNSLiveness3dFaceActivity5.faceView.setFaceRectangle(SNSLiveness3dFaceActivity.Cwa7EHp4RmMFhwpOCPWojiqbo(sNSLiveness3dFaceActivity5, t2.Cwa7EHp4RmMFhwpOCPWojiqbo));
                        }
                    }
                }
            }
        }
    }

    public static final class tjrpI83q5sk1iMEXPz1hKo implements DialogInterface.OnClickListener {
        public final /* synthetic */ SNSLiveness3dFaceActivity Cwa7EHp4RmMFhwpOCPWojiqbo;

        public tjrpI83q5sk1iMEXPz1hKo(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLiveness3dFaceActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.finish();
        }
    }

    static {
        new Companion(null);
    }

    public static final void Cwa7EHp4RmMFhwpOCPWojiqbo(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity, xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY) {
        int i;
        CharSequence charSequence;
        CharSequence textResource;
        sNSLiveness3dFaceActivity.getClass();
        Timber.d("showResult: " + yuBMj5oYSZ1EKs0piMUZxDCY, new Object[0]);
        ImageView imageView = sNSLiveness3dFaceActivity.ivIcon;
        AnswerType oVTxbCNkVuXyP468Xhsl9qtSE9v2 = yuBMj5oYSZ1EKs0piMUZxDCY != null ? yuBMj5oYSZ1EKs0piMUZxDCY.oVTxbCNkVuXyP468Xhsl9qtSE9v() : null;
        AnswerType answerType = AnswerType.Green;
        if (oVTxbCNkVuXyP468Xhsl9qtSE9v2 == answerType) {
            i = R.drawable.sns_ic_success;
        } else {
            if (!Intrinsics.areEqual(yuBMj5oYSZ1EKs0piMUZxDCY != null ? yuBMj5oYSZ1EKs0piMUZxDCY.Cwa7EHp4RmMFhwpOCPWojiqbo() : null, Boolean.TRUE) || yuBMj5oYSZ1EKs0piMUZxDCY.oVTxbCNkVuXyP468Xhsl9qtSE9v() == answerType) {
                i = R.drawable.sns_ic_fatal_error;
            } else {
                i = R.drawable.sns_ic_submitted;
            }
        }
        imageView.setImageResource(i);
        TextView textView = sNSLiveness3dFaceActivity.tvTitle;
        Integer valueOf = Integer.valueOf(ExtensionsKt.getStringIdentifier(sNSLiveness3dFaceActivity, String.format(SNSConstants.Resources.Key.FACESCAN_TITLE_KEY, Arrays.copyOf(new Object[]{sNSLiveness3dFaceActivity.Cwa7EHp4RmMFhwpOCPWojiqbo(yuBMj5oYSZ1EKs0piMUZxDCY)}, 1))));
        if (!(valueOf.intValue() != 0)) {
            valueOf = null;
        }
        CharSequence charSequence2 = "";
        if (valueOf == null || (charSequence = sNSLiveness3dFaceActivity.getTextResource(valueOf.intValue())) == null) {
            charSequence = charSequence2;
        }
        textView.setText(charSequence);
        TextView textView2 = sNSLiveness3dFaceActivity.tvSubTitle;
        Integer valueOf2 = Integer.valueOf(ExtensionsKt.getStringIdentifier(sNSLiveness3dFaceActivity, String.format(SNSConstants.Resources.Key.FACESCAN_TEXT_KEY, Arrays.copyOf(new Object[]{sNSLiveness3dFaceActivity.Cwa7EHp4RmMFhwpOCPWojiqbo(yuBMj5oYSZ1EKs0piMUZxDCY)}, 1))));
        if (!(valueOf2.intValue() != 0)) {
            valueOf2 = null;
        }
        if (!(valueOf2 == null || (textResource = sNSLiveness3dFaceActivity.getTextResource(valueOf2.intValue())) == null)) {
            charSequence2 = textResource;
        }
        textView2.setText(charSequence2);
        if ((yuBMj5oYSZ1EKs0piMUZxDCY != null ? yuBMj5oYSZ1EKs0piMUZxDCY.oVTxbCNkVuXyP468Xhsl9qtSE9v() : null) != answerType) {
            if (!Intrinsics.areEqual(yuBMj5oYSZ1EKs0piMUZxDCY != null ? yuBMj5oYSZ1EKs0piMUZxDCY.Cwa7EHp4RmMFhwpOCPWojiqbo() : null, Boolean.TRUE)) {
                sNSLiveness3dFaceActivity.btnTryAgain.setVisibility(0);
                sNSLiveness3dFaceActivity.btnTryAgain.setText(sNSLiveness3dFaceActivity.getTextResource(R.string.sns_facescan_action_retry));
                sNSLiveness3dFaceActivity.btnTryAgain.setOnClickListener(new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.AyZhE6NYuOjRPjA(sNSLiveness3dFaceActivity));
                Cwa7EHp4RmMFhwpOCPWojiqbo(sNSLiveness3dFaceActivity, (Function0) null, 1);
            }
        }
        sNSLiveness3dFaceActivity.btnTryAgain.setVisibility(8);
        sNSLiveness3dFaceActivity.vgResult.postDelayed(new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.mrIBiYc0Jm(sNSLiveness3dFaceActivity, yuBMj5oYSZ1EKs0piMUZxDCY), 1000);
        Cwa7EHp4RmMFhwpOCPWojiqbo(sNSLiveness3dFaceActivity, (Function0) null, 1);
    }

    public static final void ejVYvrSYmsA1fCSIPxDrI(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
        sNSLiveness3dFaceActivity.getClass();
        Timber.d("startLivenessSession", new Object[0]);
        sNSLiveness3dFaceActivity.oVTxbCNkVuXyP468Xhsl9qtSE9v.setVisibility(8);
        sNSLiveness3dFaceActivity.TISdV9vjEDKYTeuQpV0VHpJbW = true;
        sNSLiveness3dFaceActivity.cameraView.addFrameProcessor(sNSLiveness3dFaceActivity.qNDua1J9EaZOsmugz0J);
        xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo oVTxbCNkVuXyP468Xhsl9qtSE9v2 = sNSLiveness3dFaceActivity.getViewModel();
        RectF Cwa7EHp4RmMFhwpOCPWojiqbo2 = sNSLiveness3dFaceActivity.Cwa7EHp4RmMFhwpOCPWojiqbo();
        String stringExtra = sNSLiveness3dFaceActivity.getIntent().getStringExtra("EXTRA_ACTION_ID");
        String stringExtra2 = sNSLiveness3dFaceActivity.getIntent().getStringExtra("EXTRA_ACTION_TYPE");
        StringBuilder L = a.L("Built-in ");
        L.append(sNSLiveness3dFaceActivity.cameraView.getFacing().name());
        L.append(" camera");
        String sb = L.toString();
        oVTxbCNkVuXyP468Xhsl9qtSE9v2.getClass();
        Timber.d("SNSLiveness3dFaceViewModel.startSession: " + Cwa7EHp4RmMFhwpOCPWojiqbo2, new Object[0]);
        oVTxbCNkVuXyP468Xhsl9qtSE9v2.N434VQHTrGUotPhpDDIhYJrpL4ro = sb;
        oVTxbCNkVuXyP468Xhsl9qtSE9v2.ejVYvrSYmsA1fCSIPxDrI = stringExtra;
        oVTxbCNkVuXyP468Xhsl9qtSE9v2.aDBqOnRnCJ0gWECtZQu = stringExtra2;
        xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88 bYfFGQyI88 = oVTxbCNkVuXyP468Xhsl9qtSE9v2.zzrHq5THgQdVhShelxegx;
        tjrpI83q5sk1iMEXPz1hKo.DDdm1ec8RQad6rlXcC8U dDdm1ec8RQad6rlXcC8U = oVTxbCNkVuXyP468Xhsl9qtSE9v2.Ku863HM4m4Edc3Ql5I;
        bYfFGQyI88.Cwa7EHp4RmMFhwpOCPWojiqbo = 0;
        bYfFGQyI88.lk42nG4RRcMiHe8r6w = dDdm1ec8RQad6rlXcC8U;
        bYfFGQyI88.Cwa7EHp4RmMFhwpOCPWojiqbo();
        oVTxbCNkVuXyP468Xhsl9qtSE9v2.TJ0S4kl1Dl9bj8ZIzGCLBDun.start();
        oVTxbCNkVuXyP468Xhsl9qtSE9v2.aHA7rWvEdW6bbOdx1EKD4aVF0k = System.currentTimeMillis() + ((long) 100);
    }

    public static final void lk42nG4RRcMiHe8r6w(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
        sNSLiveness3dFaceActivity.faceView.aDBqOnRnCJ0gWECtZQu();
        sNSLiveness3dFaceActivity.ivIcon.setImageResource(R.drawable.sns_ic_warning);
        sNSLiveness3dFaceActivity.tvTitle.setText(sNSLiveness3dFaceActivity.getTextResource(R.string.sns_oops_network_title));
        sNSLiveness3dFaceActivity.tvSubTitle.setText(sNSLiveness3dFaceActivity.getTextResource(R.string.sns_oops_network_html));
        sNSLiveness3dFaceActivity.btnTryAgain.setText(sNSLiveness3dFaceActivity.getTextResource(R.string.sns_oops_action_retry));
        sNSLiveness3dFaceActivity.btnTryAgain.setOnClickListener(new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.DDdm1ec8RQad6rlXcC8U(sNSLiveness3dFaceActivity));
        Cwa7EHp4RmMFhwpOCPWojiqbo(sNSLiveness3dFaceActivity, (Function0) null, 1);
    }

    public static final boolean oVTxbCNkVuXyP468Xhsl9qtSE9v(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
        return ((Boolean) sNSLiveness3dFaceActivity.mdHgHuGChkRJqBUMUk707.getValue()).booleanValue();
    }

    public final void aDBqOnRnCJ0gWECtZQu() {
        new MaterialAlertDialogBuilder(this).setMessage(getTextResource(com.sumsub.sns.camera.R.string.sns_alert_lackOfCameraPermissions)).setPositiveButton(getTextResource(com.sumsub.sns.camera.R.string.sns_alert_action_ok), (DialogInterface.OnClickListener) new tjrpI83q5sk1iMEXPz1hKo(this)).setNeutralButton(getTextResource(R.string.sns_alert_action_settings), (DialogInterface.OnClickListener) new djGN3DbfslkNo4T0(this)).setOnCancelListener((DialogInterface.OnCancelListener) new drPJedvLehhLIDUBStFv2zCqMzLzQ(this)).create().show();
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    public int getLayoutId() {
        return R.layout.sns_activity_liveness_3dface;
    }

    @NotNull
    /* renamed from: oVTxbCNkVuXyP468Xhsl9qtSE9v */
    public xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo getViewModel() {
        return (xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo) this.Cwa7EHp4RmMFhwpOCPWojiqbo.getValue();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@Nullable Sensor sensor, int i) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        getViewModel().onBackClicked();
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setSupportActionBar(this.toolbar);
        this.toolbar.setNavigationOnClickListener(new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.VVeXCTyov0hLti0HOLqom2taL0gk(this));
        setTitle("");
        this.cameraView.addCameraListener(this.Ku863HM4m4Edc3Ql5I);
        this.cameraView.setLifecycleOwner(this);
        CameraView cameraView2 = this.cameraView;
        CameraOptions cameraOptions = cameraView2.getCameraOptions();
        cameraView2.setExposureCorrection(cameraOptions != null ? cameraOptions.getExposureCorrectionMaxValue() : Float.MAX_VALUE);
        this.oVTxbCNkVuXyP468Xhsl9qtSE9v = (ImageView) findViewById(R.id.completeImage);
        Object systemService = getSystemService("sensor");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        this.N434VQHTrGUotPhpDDIhYJrpL4ro = sensorManager;
        this.J3eZRYS4AnxhOKbC2x2nQNPT = sensorManager.getDefaultSensor(5);
        this.tvPowered.setText(getTextResource(com.sumsub.sns.core.R.string.sns_general_poweredBy));
        getViewModel().getFinish().observe(this, new IXGaYizhe6FCHn8nw5EAC9h8U1(this));
        getViewModel().cPMlB5HN7W4Ve3yHBwMXNEUvD.observe(this, new mrIBiYc0Jm(this));
        getViewModel().M6kaoQeazePMH0Sq8.observe(this, new AyZhE6NYuOjRPjA(this));
        this.faceView.setStateListener$idensic_mobile_sdk_prooface_release(new YuBMj5oYSZ1EKs0piMUZxDCY(this));
        if (((Boolean) this.mdHgHuGChkRJqBUMUk707.getValue()).booleanValue()) {
            this.tvDebug.setVisibility(0);
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(this) && ((Boolean) this.idM1z15K75.getValue()).booleanValue() && !getViewModel().xXAwgfSH699GDAm5vBCX.getDontShowSettingsDialog()) {
            new MaterialAlertDialogBuilder(this).setMessage(getTextResource(R.string.sns_alert_lackOfSettingsPermissions)).setPositiveButton(getTextResource(R.string.sns_alert_action_ok), (DialogInterface.OnClickListener) new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.UGPkPVVOmk179tTX8sQoOodQt(this)).setNegativeButton(getTextResource(R.string.sns_alert_action_dont_show), (DialogInterface.OnClickListener) new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.BYfFGQyI88(this)).setNeutralButton(getTextResource(R.string.sns_alert_action_cancel), (DialogInterface.OnClickListener) xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.alNh9hLeM39.Cwa7EHp4RmMFhwpOCPWojiqbo).create().show();
        }
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.N434VQHTrGUotPhpDDIhYJrpL4ro.unregisterListener(this);
        lk42nG4RRcMiHe8r6w();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        boolean z;
        if (i == 41) {
            boolean z2 = true;
            if (!(iArr.length == 0)) {
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    if (iArr[i2] == -1) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    String[] strArr2 = aHA7rWvEdW6bbOdx1EKD4aVF0k;
                    int length2 = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            z2 = false;
                            break;
                        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, strArr2[i3])) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z2) {
                        setResult(0, Cwa7EHp4RmMFhwpOCPWojiqbo((SNSLivenessResult) null));
                        finish();
                        return;
                    }
                    aDBqOnRnCJ0gWECtZQu();
                }
            }
        }
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.N434VQHTrGUotPhpDDIhYJrpL4ro.registerListener(this, this.J3eZRYS4AnxhOKbC2x2nQNPT, 3);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent sensorEvent) {
        this.yr0oPNYrJWblwzfs6tPicPv = sensorEvent.values[0];
        ejVYvrSYmsA1fCSIPxDrI();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        String[] strArr = aHA7rWvEdW6bbOdx1EKD4aVF0k;
        int length = strArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (ContextCompat.checkSelfPermission(this, strArr[i]) == -1) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            ActivityCompat.requestPermissions(this, aHA7rWvEdW6bbOdx1EKD4aVF0k, 41);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        getViewModel().Cwa7EHp4RmMFhwpOCPWojiqbo();
        super.onStop();
    }

    public final void lk42nG4RRcMiHe8r6w() {
        if (Build.VERSION.SDK_INT >= 23 && this.aDBqOnRnCJ0gWECtZQu && Settings.System.canWrite(this)) {
            Cwa7EHp4RmMFhwpOCPWojiqbo(this, this.lk42nG4RRcMiHe8r6w, this.ejVYvrSYmsA1fCSIPxDrI);
            this.aDBqOnRnCJ0gWECtZQu = false;
        }
    }

    public final void ejVYvrSYmsA1fCSIPxDrI() {
        if (Build.VERSION.SDK_INT >= 23 && this.yr0oPNYrJWblwzfs6tPicPv < ((float) 10) && !this.aDBqOnRnCJ0gWECtZQu && Settings.System.canWrite(this)) {
            Pair<Integer, Integer> Cwa7EHp4RmMFhwpOCPWojiqbo2 = Cwa7EHp4RmMFhwpOCPWojiqbo(this, 0, 255);
            this.lk42nG4RRcMiHe8r6w = Cwa7EHp4RmMFhwpOCPWojiqbo2.getFirst().intValue();
            this.ejVYvrSYmsA1fCSIPxDrI = Cwa7EHp4RmMFhwpOCPWojiqbo2.getSecond().intValue();
            this.aDBqOnRnCJ0gWECtZQu = true;
        }
    }

    public final RectF Cwa7EHp4RmMFhwpOCPWojiqbo() {
        Rect faceCapturingRect = this.faceView.getFaceCapturingRect();
        int[] iArr = new int[2];
        this.cameraView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        this.faceView.getLocationInWindow(iArr2);
        return new RectF(((float) ((iArr2[0] - iArr[0]) + faceCapturingRect.left)) / ((float) this.cameraView.getWidth()), ((float) ((iArr2[1] - iArr[1]) + faceCapturingRect.top)) / ((float) this.cameraView.getHeight()), ((float) ((iArr2[0] - iArr[0]) + faceCapturingRect.right)) / ((float) this.cameraView.getWidth()), ((float) ((iArr2[1] - iArr[1]) + faceCapturingRect.bottom)) / ((float) this.cameraView.getHeight()));
    }

    public final Intent Cwa7EHp4RmMFhwpOCPWojiqbo(SNSLivenessResult sNSLivenessResult) {
        Intent putExtra = new Intent().putExtra(SNSConstants.Intent.SNS_EXTRA_DOCUMENT, (Document) getIntent().getParcelableExtra(SNSConstants.Intent.SNS_EXTRA_DOCUMENT));
        if (sNSLivenessResult != null) {
            putExtra.putExtra("EXTRA_RESULT", sNSLivenessResult);
        }
        return putExtra;
    }

    public static final RectF Cwa7EHp4RmMFhwpOCPWojiqbo(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity, RectF rectF) {
        int[] iArr = new int[2];
        sNSLiveness3dFaceActivity.cameraView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        sNSLiveness3dFaceActivity.faceView.getLocationInWindow(iArr2);
        return new RectF(((rectF.left * ((float) sNSLiveness3dFaceActivity.cameraView.getWidth())) - ((float) iArr2[0])) + ((float) iArr[0]), ((rectF.top * ((float) sNSLiveness3dFaceActivity.cameraView.getHeight())) - ((float) iArr2[1])) + ((float) iArr[1]), ((rectF.right * ((float) sNSLiveness3dFaceActivity.cameraView.getWidth())) - ((float) iArr2[0])) + ((float) iArr[0]), ((rectF.bottom * ((float) sNSLiveness3dFaceActivity.cameraView.getHeight())) - ((float) iArr2[1])) + ((float) iArr[1]));
    }

    public final String Cwa7EHp4RmMFhwpOCPWojiqbo(xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY) {
        Boolean bool = null;
        AnswerType oVTxbCNkVuXyP468Xhsl9qtSE9v2 = yuBMj5oYSZ1EKs0piMUZxDCY != null ? yuBMj5oYSZ1EKs0piMUZxDCY.oVTxbCNkVuXyP468Xhsl9qtSE9v() : null;
        AnswerType answerType = AnswerType.Green;
        if (oVTxbCNkVuXyP468Xhsl9qtSE9v2 == answerType) {
            return answerType.getValue();
        }
        if (yuBMj5oYSZ1EKs0piMUZxDCY != null) {
            bool = yuBMj5oYSZ1EKs0piMUZxDCY.Cwa7EHp4RmMFhwpOCPWojiqbo();
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE) || yuBMj5oYSZ1EKs0piMUZxDCY.oVTxbCNkVuXyP468Xhsl9qtSE9v() == answerType) {
            return AnswerType.Red.getValue();
        }
        return AnswerType.Yellow.getValue();
    }

    public static final void Cwa7EHp4RmMFhwpOCPWojiqbo(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity) {
        sNSLiveness3dFaceActivity.tvHint.setAlpha(0.0f);
        sNSLiveness3dFaceActivity.tvHint.animate().alpha(1.0f).start();
        sNSLiveness3dFaceActivity.faceView.ejVYvrSYmsA1fCSIPxDrI();
        sNSLiveness3dFaceActivity.vgResult.setVisibility(8);
    }

    public static void Cwa7EHp4RmMFhwpOCPWojiqbo(SNSLiveness3dFaceActivity sNSLiveness3dFaceActivity, Function0 function0, int i) {
        xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY = (i & 1) != 0 ? xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.YuBMj5oYSZ1EKs0piMUZxDCY.Cwa7EHp4RmMFhwpOCPWojiqbo : null;
        sNSLiveness3dFaceActivity.vgResult.setVisibility(0);
        sNSLiveness3dFaceActivity.faceView.aDBqOnRnCJ0gWECtZQu();
        sNSLiveness3dFaceActivity.ivIcon.setScaleX(0.0f);
        SpringAnimation springAnimation = new SpringAnimation(sNSLiveness3dFaceActivity.ivIcon, DynamicAnimation.SCALE_X, 1.0f);
        springAnimation.getSpring().setStiffness(200.0f);
        springAnimation.getSpring().setDampingRatio(0.75f);
        springAnimation.addEndListener(new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.IXGaYizhe6FCHn8nw5EAC9h8U1(yuBMj5oYSZ1EKs0piMUZxDCY));
        springAnimation.start();
        sNSLiveness3dFaceActivity.ivIcon.setScaleY(0.0f);
        SpringAnimation springAnimation2 = new SpringAnimation(sNSLiveness3dFaceActivity.ivIcon, DynamicAnimation.SCALE_Y, 1.0f);
        springAnimation2.getSpring().setStiffness(200.0f);
        springAnimation2.getSpring().setDampingRatio(0.75f);
        springAnimation2.start();
        if (sNSLiveness3dFaceActivity.btnTryAgain.getVisibility() == 0) {
            sNSLiveness3dFaceActivity.btnTryAgain.setAlpha(0.0f);
            sNSLiveness3dFaceActivity.btnTryAgain.animate().alpha(1.0f).start();
        }
        sNSLiveness3dFaceActivity.tvHint.setAlpha(1.0f);
        sNSLiveness3dFaceActivity.tvHint.animate().alpha(0.0f).start();
        sNSLiveness3dFaceActivity.lk42nG4RRcMiHe8r6w();
    }

    public final Pair<Integer, Integer> Cwa7EHp4RmMFhwpOCPWojiqbo(Context context, int i, int i2) {
        int i3 = Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode", -1);
        int i4 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        if (!(i3 == -1 || i4 == -1)) {
            Settings.System.putInt(context.getContentResolver(), "screen_brightness_mode", i);
            Settings.System.putInt(context.getContentResolver(), "screen_brightness", i2);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.screenBrightness = ((float) i2) / ((float) 255);
            getWindow().setAttributes(attributes);
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
