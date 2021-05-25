package com.sumsub.sns.prooface.presentation.view;

import a2.b.a.a.a;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.sumsub.idensic_mobile_sdk_liveness_3dface.R;
import com.sumsub.sns.core.common.ExtensionsKt;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001(\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B6\b\u0007\u0012\u0006\u0010~\u001a\u00020}\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0012\t\b\u0002\u0010\u0001\u001a\u00020\t\u0012\t\b\u0002\u0010\u0001\u001a\u00020\t¢\u0006\u0006\b\u0001\u0010\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\u0004J/\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017R$\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198\u0002@BX\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010-R\u0016\u00100\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010&R.\u00107\u001a\u0004\u0018\u0001012\b\u0010\u001a\u001a\u0004\u0018\u0001018\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0006\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0013\u0010;\u001a\u0002088F@\u0006¢\u0006\u0006\u001a\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR*\u0010T\u001a\u00020H2\u0006\u0010\u001a\u001a\u00020H8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010J\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010JR\u0016\u0010Y\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR$\u0010\\\u001a\u00020H2\u0006\u0010\u001a\u001a\u00020H8\u0002@BX\u000e¢\u0006\f\n\u0004\bZ\u0010J\"\u0004\b[\u0010SR\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R$\u0010c\u001a\u00020H2\u0006\u0010\u001a\u001a\u00020H8\u0002@BX\u000e¢\u0006\f\n\u0004\ba\u0010J\"\u0004\bb\u0010SR\u0016\u0010e\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010&R\u0016\u0010g\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010XR\u0016\u0010h\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010XR\u0016\u0010j\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010&R\u0016\u0010l\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010_R\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010XR\u0016\u0010q\u001a\u00020o8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010pR\u0016\u0010s\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010&R\u0016\u0010u\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010XR\u0016\u0010w\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010&R\u0016\u0010x\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010XR\u0016\u0010z\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010XR\u0016\u0010|\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010_¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView;", "Landroid/view/View;", "", "ejVYvrSYmsA1fCSIPxDrI", "()V", "lk42nG4RRcMiHe8r6w", "oVTxbCNkVuXyP468Xhsl9qtSE9v", "aDBqOnRnCJ0gWECtZQu", "onDetachedFromWindow", "", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Cwa7EHp4RmMFhwpOCPWojiqbo", "Lkotlin/ranges/IntRange;", "value", "kDAQ7EcTyoX7WE", "Lkotlin/ranges/IntRange;", "setProgressRange", "(Lkotlin/ranges/IntRange;)V", "progressRange", "", "Ku863HM4m4Edc3Ql5I", "J", "detectingAnimationSpeed", "Landroid/graphics/Paint;", "zzrHq5THgQdVhShelxegx", "Landroid/graphics/Paint;", "mFaceRectanglePaint", "com/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView$AyZhE6NYuOjRPjA", "yr0oPNYrJWblwzfs6tPicPv", "Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView$AyZhE6NYuOjRPjA;", "radiusHolder", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "bgBitmap", "Lq8HuNUg0Q623MqNOEDpEO", "mFaceScanCompletePaint", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "getFaceRectangle", "()Landroid/graphics/RectF;", "setFaceRectangle", "(Landroid/graphics/RectF;)V", "faceRectangle", "Landroid/graphics/Rect;", "getFaceCapturingRect", "()Landroid/graphics/Rect;", "faceCapturingRect", "Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView$mrIBiYc0Jm;", "J3eZRYS4AnxhOKbC2x2nQNPT", "Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView$mrIBiYc0Jm;", "getStateListener$idensic_mobile_sdk_prooface_release", "()Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView$mrIBiYc0Jm;", "setStateListener$idensic_mobile_sdk_prooface_release", "(Lcom/sumsub/sns/prooface/presentation/view/SNSLivenessFaceView$mrIBiYc0Jm;)V", "stateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "idM1z15K75", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "updater", "", "mdHgHuGChkRJqBUMUk707", "F", "detectingArc2RotationAngle", "Landroidx/dynamicanimation/animation/SpringAnimation;", "N434VQHTrGUotPhpDDIhYJrpL4ro", "Landroidx/dynamicanimation/animation/SpringAnimation;", "radiusAnimation", "getRecognizingFactor", "()F", "setRecognizingFactor", "(F)V", "recognizingFactor", "qNDua1J9EaZOsmugz0J", "detectingArc1RotationAngle", "xXAwgfSH699GDAm5vBCX", "I", "mColorFaceMarkerActive", "rOohFjltS1r352oBvriA440", "setProgressRotationAngle", "progressRotationAngle", "Landroid/animation/ValueAnimator;", "YWVVuaVDYicbKjhsZbjQiRooZ", "Landroid/animation/ValueAnimator;", "progressRotationAnimator", "TISdV9vjEDKYTeuQpV0VHpJbW", "setDetectingFactor", "detectingFactor", "TJ0S4kl1Dl9bj8ZIzGCLBDun", "mFaceCutCirclePaint", "lSN1Mfux3Agbjibaf", "mColorOverlay", "focusRadius", "IfdBCmzdK0SFAUN", "mFaceRecognizingPaint", "nBrxtyIHUH54OOmxO2aE715szhyYI", "recognizingAnimationInDirect", "RSNWAXaUEPwMjkxe", "mMarkerPadding", "", "()Z", "isAnalyzing", "cPMlB5HN7W4Ve3yHBwMXNEUvD", "mFaceProgressMarkerPaint", "zpUNQNyEwze91nGOHa", "mMarkerSize", "M6kaoQeazePMH0Sq8", "mFaceCapturingPaint", "maxRadius", "SNgolBHyrZdj4a7ixZ6wFGE", "mColorFaceMarkerInActive", "aHA7rWvEdW6bbOdx1EKD4aVF0k", "recognizingAnimationDirect", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "DDdm1ec8RQad6rlXcC8U", "mrIBiYc0Jm", "idensic-mobile-sdk-prooface_release"}, k = 1, mv = {1, 4, 2})
public final class SNSLivenessFaceView extends View {
    public static final /* synthetic */ int h5Bjmt78yD4idGXxf49sZRGuR = 0;
    public float Cwa7EHp4RmMFhwpOCPWojiqbo;
    public final Paint IfdBCmzdK0SFAUN;
    @Nullable
    public mrIBiYc0Jm J3eZRYS4AnxhOKbC2x2nQNPT;
    public long Ku863HM4m4Edc3Ql5I;
    public final Paint Lq8HuNUg0Q623MqNOEDpEO;
    public final Paint M6kaoQeazePMH0Sq8;
    public final SpringAnimation N434VQHTrGUotPhpDDIhYJrpL4ro;
    public final int RSNWAXaUEPwMjkxe;
    public final int SNgolBHyrZdj4a7ixZ6wFGE;
    public float TISdV9vjEDKYTeuQpV0VHpJbW;
    public final Paint TJ0S4kl1Dl9bj8ZIzGCLBDun;
    public final ValueAnimator YWVVuaVDYicbKjhsZbjQiRooZ;
    public int aDBqOnRnCJ0gWECtZQu;
    public final ValueAnimator aHA7rWvEdW6bbOdx1EKD4aVF0k;
    public final Paint cPMlB5HN7W4Ve3yHBwMXNEUvD;
    public int ejVYvrSYmsA1fCSIPxDrI;
    public final ValueAnimator.AnimatorUpdateListener idM1z15K75;
    public IntRange kDAQ7EcTyoX7WE;
    public final int lSN1Mfux3Agbjibaf;
    public Bitmap lk42nG4RRcMiHe8r6w;
    public float mdHgHuGChkRJqBUMUk707;
    public final ValueAnimator nBrxtyIHUH54OOmxO2aE715szhyYI;
    @Nullable
    public RectF oVTxbCNkVuXyP468Xhsl9qtSE9v;
    public float qNDua1J9EaZOsmugz0J;
    public float rOohFjltS1r352oBvriA440;
    public final int xXAwgfSH699GDAm5vBCX;
    public final AyZhE6NYuOjRPjA yr0oPNYrJWblwzfs6tPicPv;
    public final int zpUNQNyEwze91nGOHa;
    public final Paint zzrHq5THgQdVhShelxegx;

    public static final class AyZhE6NYuOjRPjA extends FloatPropertyCompat<SNSLivenessFaceView> {
        public final /* synthetic */ SNSLivenessFaceView Cwa7EHp4RmMFhwpOCPWojiqbo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AyZhE6NYuOjRPjA(SNSLivenessFaceView sNSLivenessFaceView, String str) {
            super(str);
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLivenessFaceView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(SNSLivenessFaceView sNSLivenessFaceView) {
            return this.Cwa7EHp4RmMFhwpOCPWojiqbo.getRecognizingFactor() * 1000.0f;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(SNSLivenessFaceView sNSLivenessFaceView, float f) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.setRecognizingFactor(f / 1000.0f);
        }
    }

    public static final class BYfFGQyI88 implements Animator.AnimatorListener {
        public final /* synthetic */ SNSLivenessFaceView Cwa7EHp4RmMFhwpOCPWojiqbo;

        public BYfFGQyI88(SNSLivenessFaceView sNSLivenessFaceView) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLivenessFaceView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            SNSLivenessFaceView sNSLivenessFaceView = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            int i = SNSLivenessFaceView.h5Bjmt78yD4idGXxf49sZRGuR;
            if (!sNSLivenessFaceView.Cwa7EHp4RmMFhwpOCPWojiqbo()) {
                this.Cwa7EHp4RmMFhwpOCPWojiqbo.aHA7rWvEdW6bbOdx1EKD4aVF0k.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
        }
    }

    public enum DDdm1ec8RQad6rlXcC8U {
        Recognizing,
        Recognized,
        Analyzing,
        Complete
    }

    public static final class IXGaYizhe6FCHn8nw5EAC9h8U1 implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ SNSLivenessFaceView Cwa7EHp4RmMFhwpOCPWojiqbo;

        public IXGaYizhe6FCHn8nw5EAC9h8U1(SNSLivenessFaceView sNSLivenessFaceView) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLivenessFaceView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            SNSLivenessFaceView sNSLivenessFaceView = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            sNSLivenessFaceView.setDetectingFactor(((Float) animatedValue).floatValue());
            SNSLivenessFaceView sNSLivenessFaceView2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            sNSLivenessFaceView2.qNDua1J9EaZOsmugz0J = (Math.abs(sNSLivenessFaceView2.TISdV9vjEDKYTeuQpV0VHpJbW) * 0.3f) + sNSLivenessFaceView2.qNDua1J9EaZOsmugz0J;
            SNSLivenessFaceView sNSLivenessFaceView3 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            sNSLivenessFaceView3.mdHgHuGChkRJqBUMUk707 = (Math.abs(sNSLivenessFaceView3.TISdV9vjEDKYTeuQpV0VHpJbW) * 0.5f) + sNSLivenessFaceView3.mdHgHuGChkRJqBUMUk707;
        }
    }

    public static final class UGPkPVVOmk179tTX8sQoOodQt implements Animator.AnimatorListener {
        public final /* synthetic */ SNSLivenessFaceView Cwa7EHp4RmMFhwpOCPWojiqbo;

        public UGPkPVVOmk179tTX8sQoOodQt(SNSLivenessFaceView sNSLivenessFaceView) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLivenessFaceView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            SNSLivenessFaceView sNSLivenessFaceView = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            int i = SNSLivenessFaceView.h5Bjmt78yD4idGXxf49sZRGuR;
            if (!sNSLivenessFaceView.Cwa7EHp4RmMFhwpOCPWojiqbo()) {
                this.Cwa7EHp4RmMFhwpOCPWojiqbo.nBrxtyIHUH54OOmxO2aE715szhyYI.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
        }
    }

    public static final class VVeXCTyov0hLti0HOLqom2taL0gk implements DynamicAnimation.OnAnimationEndListener {
        public final /* synthetic */ SNSLivenessFaceView Cwa7EHp4RmMFhwpOCPWojiqbo;

        public VVeXCTyov0hLti0HOLqom2taL0gk(SNSLivenessFaceView sNSLivenessFaceView) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLivenessFaceView;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public final void onAnimationEnd(DynamicAnimation<DynamicAnimation<?>> dynamicAnimation, boolean z, float f, float f2) {
            DDdm1ec8RQad6rlXcC8U dDdm1ec8RQad6rlXcC8U;
            mrIBiYc0Jm stateListener$idensic_mobile_sdk_prooface_release = this.Cwa7EHp4RmMFhwpOCPWojiqbo.getStateListener$idensic_mobile_sdk_prooface_release();
            if (stateListener$idensic_mobile_sdk_prooface_release != null) {
                float recognizingFactor = this.Cwa7EHp4RmMFhwpOCPWojiqbo.getRecognizingFactor();
                if (recognizingFactor == 0.0f) {
                    dDdm1ec8RQad6rlXcC8U = this.Cwa7EHp4RmMFhwpOCPWojiqbo.Cwa7EHp4RmMFhwpOCPWojiqbo() ? DDdm1ec8RQad6rlXcC8U.Analyzing : DDdm1ec8RQad6rlXcC8U.Recognized;
                } else if (recognizingFactor == 1.0f) {
                    dDdm1ec8RQad6rlXcC8U = DDdm1ec8RQad6rlXcC8U.Complete;
                } else {
                    dDdm1ec8RQad6rlXcC8U = DDdm1ec8RQad6rlXcC8U.Recognizing;
                }
                stateListener$idensic_mobile_sdk_prooface_release.Cwa7EHp4RmMFhwpOCPWojiqbo(dDdm1ec8RQad6rlXcC8U);
            }
        }
    }

    public static final class alNh9hLeM39 implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ SNSLivenessFaceView Cwa7EHp4RmMFhwpOCPWojiqbo;

        public alNh9hLeM39(SNSLivenessFaceView sNSLivenessFaceView) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = sNSLivenessFaceView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            SNSLivenessFaceView sNSLivenessFaceView = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            sNSLivenessFaceView.setProgressRotationAngle(((Float) animatedValue).floatValue());
        }
    }

    public interface mrIBiYc0Jm {
        void Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull DDdm1ec8RQad6rlXcC8U dDdm1ec8RQad6rlXcC8U);
    }

    @JvmOverloads
    public SNSLivenessFaceView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public SNSLivenessFaceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public SNSLivenessFaceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSLivenessFaceView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.snsProofaceViewStyle : i, (i3 & 8) != 0 ? R.style.SNSProofaceViewStyle : i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setDetectingFactor(float f) {
        if (this.TISdV9vjEDKYTeuQpV0VHpJbW != f) {
            this.TISdV9vjEDKYTeuQpV0VHpJbW = f;
            postInvalidateOnAnimation();
        }
    }

    private final void setProgressRange(IntRange intRange) {
        if (!Intrinsics.areEqual(intRange, this.kDAQ7EcTyoX7WE)) {
            this.kDAQ7EcTyoX7WE = intRange;
            postInvalidateOnAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setProgressRotationAngle(float f) {
        if (f != this.rOohFjltS1r352oBvriA440) {
            this.rOohFjltS1r352oBvriA440 = f;
            postInvalidateOnAnimation();
        }
    }

    public final void aDBqOnRnCJ0gWECtZQu() {
        this.N434VQHTrGUotPhpDDIhYJrpL4ro.animateToFinalPosition(1000.0f);
        setProgressRange(IntRange.Companion.getEMPTY());
        this.aHA7rWvEdW6bbOdx1EKD4aVF0k.cancel();
        this.nBrxtyIHUH54OOmxO2aE715szhyYI.cancel();
        this.YWVVuaVDYicbKjhsZbjQiRooZ.cancel();
    }

    public final void ejVYvrSYmsA1fCSIPxDrI() {
        this.N434VQHTrGUotPhpDDIhYJrpL4ro.animateToFinalPosition(-1000.0f);
        setProgressRange(IntRange.Companion.getEMPTY());
        this.aHA7rWvEdW6bbOdx1EKD4aVF0k.cancel();
        this.nBrxtyIHUH54OOmxO2aE715szhyYI.cancel();
        this.YWVVuaVDYicbKjhsZbjQiRooZ.cancel();
    }

    @NotNull
    public final Rect getFaceCapturingRect() {
        int coerceAtMost = e.coerceAtMost((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) - (((this.zpUNQNyEwze91nGOHa * 2) + (this.RSNWAXaUEPwMjkxe * 2)) + ((int) this.cPMlB5HN7W4Ve3yHBwMXNEUvD.getStrokeWidth()));
        int paddingLeft = getPaddingLeft() + ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - coerceAtMost) / 2);
        int paddingTop = getPaddingTop() + ((((getHeight() - getPaddingTop()) - getPaddingBottom()) - coerceAtMost) / 2);
        return new Rect(paddingLeft, paddingTop, paddingLeft + coerceAtMost, coerceAtMost + paddingTop);
    }

    @Nullable
    public final RectF getFaceRectangle() {
        return this.oVTxbCNkVuXyP468Xhsl9qtSE9v;
    }

    public final float getRecognizingFactor() {
        return this.Cwa7EHp4RmMFhwpOCPWojiqbo;
    }

    @Nullable
    public final mrIBiYc0Jm getStateListener$idensic_mobile_sdk_prooface_release() {
        return this.J3eZRYS4AnxhOKbC2x2nQNPT;
    }

    public final void lk42nG4RRcMiHe8r6w() {
        this.N434VQHTrGUotPhpDDIhYJrpL4ro.animateToFinalPosition(0.0f);
        if (!this.aHA7rWvEdW6bbOdx1EKD4aVF0k.isStarted() && !this.nBrxtyIHUH54OOmxO2aE715szhyYI.isStarted()) {
            this.aHA7rWvEdW6bbOdx1EKD4aVF0k.start();
            this.nBrxtyIHUH54OOmxO2aE715szhyYI.cancel();
        }
        setProgressRange(new IntRange(0, 360));
        if (!this.YWVVuaVDYicbKjhsZbjQiRooZ.isStarted()) {
            this.YWVVuaVDYicbKjhsZbjQiRooZ.start();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.N434VQHTrGUotPhpDDIhYJrpL4ro.cancel();
        this.aHA7rWvEdW6bbOdx1EKD4aVF0k.cancel();
        this.nBrxtyIHUH54OOmxO2aE715szhyYI.cancel();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        float f;
        RectF rectF;
        super.onDraw(canvas);
        canvas.save();
        RectF rectF2 = new RectF(getFaceCapturingRect());
        float centerX = rectF2.centerX();
        float centerY = rectF2.centerY();
        float f2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
        float f3 = (float) 0;
        if (f2 < f3) {
            int i = this.aDBqOnRnCJ0gWECtZQu;
            f = ((float) i) - (((float) (this.ejVYvrSYmsA1fCSIPxDrI - i)) * f2);
        } else {
            f = (((float) 1) - f2) * ((float) this.aDBqOnRnCJ0gWECtZQu);
        }
        Bitmap bitmap = this.lk42nG4RRcMiHe8r6w;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        if (Cwa7EHp4RmMFhwpOCPWojiqbo()) {
            canvas.drawCircle(centerX, centerY, f, this.Lq8HuNUg0Q623MqNOEDpEO);
        }
        float f4 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
        if (f4 < f3) {
            this.M6kaoQeazePMH0Sq8.setAlpha((int) (((float) 255) * (-e.coerceAtMost(f4, 0.0f))));
            Rect faceCapturingRect = getFaceCapturingRect();
            int width = faceCapturingRect.width() / 5;
            int height = faceCapturingRect.height() / 5;
            int i2 = faceCapturingRect.left;
            float f5 = (float) faceCapturingRect.top;
            canvas.drawLine((float) i2, f5, (float) (i2 + width), f5, this.M6kaoQeazePMH0Sq8);
            float f6 = (float) faceCapturingRect.left;
            int i3 = faceCapturingRect.top;
            canvas.drawLine(f6, (float) i3, f6, (float) (i3 + height), this.M6kaoQeazePMH0Sq8);
            int i4 = faceCapturingRect.right;
            float f7 = (float) faceCapturingRect.top;
            canvas.drawLine((float) i4, f7, (float) (i4 - width), f7, this.M6kaoQeazePMH0Sq8);
            float f8 = (float) faceCapturingRect.right;
            int i5 = faceCapturingRect.top;
            canvas.drawLine(f8, (float) i5, f8, (float) (i5 + height), this.M6kaoQeazePMH0Sq8);
            int i6 = faceCapturingRect.left;
            float f9 = (float) faceCapturingRect.bottom;
            canvas.drawLine((float) i6, f9, (float) (i6 + width), f9, this.M6kaoQeazePMH0Sq8);
            float f10 = (float) faceCapturingRect.left;
            int i7 = faceCapturingRect.bottom;
            canvas.drawLine(f10, (float) i7, f10, (float) (i7 - height), this.M6kaoQeazePMH0Sq8);
            int i8 = faceCapturingRect.right;
            float f11 = (float) faceCapturingRect.bottom;
            canvas.drawLine((float) i8, f11, (float) (i8 - width), f11, this.M6kaoQeazePMH0Sq8);
            float f12 = (float) faceCapturingRect.right;
            int i9 = faceCapturingRect.bottom;
            canvas.drawLine(f12, (float) i9, f12, (float) (i9 - height), this.M6kaoQeazePMH0Sq8);
        }
        Cwa7EHp4RmMFhwpOCPWojiqbo(canvas);
        if (this.Cwa7EHp4RmMFhwpOCPWojiqbo == 0.0f && !Cwa7EHp4RmMFhwpOCPWojiqbo()) {
            RectF rectF3 = new RectF(getFaceCapturingRect());
            rectF3.inset(0.0f, (rectF3.height() * (((float) 1) - Math.abs(this.TISdV9vjEDKYTeuQpV0VHpJbW))) / ((float) 2));
            float f13 = this.TISdV9vjEDKYTeuQpV0VHpJbW > f3 ? 180.0f : 0.0f;
            canvas.save();
            canvas.rotate(this.qNDua1J9EaZOsmugz0J, rectF3.centerX(), rectF3.centerY());
            canvas.drawArc(rectF3, f13, 180.0f, false, this.IfdBCmzdK0SFAUN);
            canvas.rotate((-this.qNDua1J9EaZOsmugz0J) - this.mdHgHuGChkRJqBUMUk707, rectF3.centerX(), rectF3.centerY());
            canvas.drawArc(rectF3, f13, 180.0f, false, this.IfdBCmzdK0SFAUN);
            canvas.restore();
        }
        if (this.Cwa7EHp4RmMFhwpOCPWojiqbo < 0.0f && (rectF = this.oVTxbCNkVuXyP468Xhsl9qtSE9v) != null) {
            canvas.drawRect(rectF, this.zzrHq5THgQdVhShelxegx);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int coerceAtMost = e.coerceAtMost((View.MeasureSpec.getSize(i) - getPaddingStart()) - getPaddingEnd(), (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom());
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getPaddingEnd() + getPaddingStart() + coerceAtMost, 1073741824), View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + coerceAtMost, 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Rect faceCapturingRect = getFaceCapturingRect();
        float coerceAtLeast = (float) e.coerceAtLeast(faceCapturingRect.centerX(), i - faceCapturingRect.centerX());
        float coerceAtLeast2 = (float) e.coerceAtLeast(faceCapturingRect.centerY(), i2 - faceCapturingRect.centerY());
        this.ejVYvrSYmsA1fCSIPxDrI = (int) ((float) Math.sqrt((double) ((coerceAtLeast2 * coerceAtLeast2) + (coerceAtLeast * coerceAtLeast))));
        this.aDBqOnRnCJ0gWECtZQu = getFaceCapturingRect().width() / 2;
        Bitmap bitmap = this.lk42nG4RRcMiHe8r6w;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.lk42nG4RRcMiHe8r6w = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    public final void setFaceRectangle(@Nullable RectF rectF) {
        if (!Intrinsics.areEqual(rectF, this.oVTxbCNkVuXyP468Xhsl9qtSE9v)) {
            this.oVTxbCNkVuXyP468Xhsl9qtSE9v = rectF;
            postInvalidate();
        }
    }

    public final void setRecognizingFactor(float f) {
        float f2;
        if (this.Cwa7EHp4RmMFhwpOCPWojiqbo != f) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = e.coerceIn(f, -1.0f, 1.0f);
            RectF rectF = new RectF(getFaceCapturingRect());
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float f3 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            if (f3 < ((float) 0)) {
                int i = this.aDBqOnRnCJ0gWECtZQu;
                f2 = ((float) i) - (((float) (this.ejVYvrSYmsA1fCSIPxDrI - i)) * f3);
            } else {
                f2 = (((float) 1) - f3) * ((float) this.aDBqOnRnCJ0gWECtZQu);
            }
            Bitmap bitmap = this.lk42nG4RRcMiHe8r6w;
            if (bitmap != null) {
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(this.lSN1Mfux3Agbjibaf);
                canvas.drawCircle(centerX, centerY, f2, this.TJ0S4kl1Dl9bj8ZIzGCLBDun);
            }
            postInvalidate();
        }
    }

    public final void setStateListener$idensic_mobile_sdk_prooface_release(@Nullable mrIBiYc0Jm mribiyc0jm) {
        this.J3eZRYS4AnxhOKbC2x2nQNPT = mribiyc0jm;
    }

    public final boolean Cwa7EHp4RmMFhwpOCPWojiqbo() {
        return this.Cwa7EHp4RmMFhwpOCPWojiqbo == 0.0f && Intrinsics.areEqual(this.kDAQ7EcTyoX7WE, IntRange.Companion.getEMPTY());
    }

    public final void oVTxbCNkVuXyP468Xhsl9qtSE9v() {
        this.N434VQHTrGUotPhpDDIhYJrpL4ro.animateToFinalPosition(0.0f);
        setProgressRange(IntRange.Companion.getEMPTY());
        this.aHA7rWvEdW6bbOdx1EKD4aVF0k.cancel();
        this.nBrxtyIHUH54OOmxO2aE715szhyYI.cancel();
        if (!this.YWVVuaVDYicbKjhsZbjQiRooZ.isStarted()) {
            this.YWVVuaVDYicbKjhsZbjQiRooZ.start();
        }
    }

    @JvmOverloads
    public SNSLivenessFaceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.Cwa7EHp4RmMFhwpOCPWojiqbo = -1.0f;
        AyZhE6NYuOjRPjA ayZhE6NYuOjRPjA = new AyZhE6NYuOjRPjA(this, "recognizingFactor");
        this.yr0oPNYrJWblwzfs6tPicPv = ayZhE6NYuOjRPjA;
        SpringAnimation springAnimation = new SpringAnimation(this, ayZhE6NYuOjRPjA, this.Cwa7EHp4RmMFhwpOCPWojiqbo);
        springAnimation.getSpring().setDampingRatio(0.75f);
        springAnimation.getSpring().setStiffness(200.0f);
        springAnimation.setMinValue(-1000.0f);
        springAnimation.setMaxValue(1000.0f);
        springAnimation.addEndListener(new VVeXCTyov0hLti0HOLqom2taL0gk(this));
        this.N434VQHTrGUotPhpDDIhYJrpL4ro = springAnimation;
        this.TISdV9vjEDKYTeuQpV0VHpJbW = -1.0f;
        this.Ku863HM4m4Edc3Ql5I = 1000;
        this.qNDua1J9EaZOsmugz0J = 25.0f;
        this.mdHgHuGChkRJqBUMUk707 = 25.0f;
        IXGaYizhe6FCHn8nw5EAC9h8U1 iXGaYizhe6FCHn8nw5EAC9h8U1 = new IXGaYizhe6FCHn8nw5EAC9h8U1(this);
        this.idM1z15K75 = iXGaYizhe6FCHn8nw5EAC9h8U1;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-1.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.Ku863HM4m4Edc3Ql5I);
        ofFloat.addUpdateListener(iXGaYizhe6FCHn8nw5EAC9h8U1);
        ofFloat.addListener(new UGPkPVVOmk179tTX8sQoOodQt(this));
        this.aHA7rWvEdW6bbOdx1EKD4aVF0k = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, -1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration(this.Ku863HM4m4Edc3Ql5I);
        ofFloat2.addUpdateListener(iXGaYizhe6FCHn8nw5EAC9h8U1);
        ofFloat2.addListener(new BYfFGQyI88(this));
        this.nBrxtyIHUH54OOmxO2aE715szhyYI = ofFloat2;
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 4.0f);
        ofFloat3.setDuration(this.Ku863HM4m4Edc3Ql5I);
        ofFloat3.setInterpolator(new LinearInterpolator());
        ofFloat3.addUpdateListener(new alNh9hLeM39(this));
        ofFloat3.setRepeatCount(-1);
        this.YWVVuaVDYicbKjhsZbjQiRooZ = ofFloat3;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.cPMlB5HN7W4Ve3yHBwMXNEUvD = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.M6kaoQeazePMH0Sq8 = paint2;
        Paint paint3 = new Paint(1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.TJ0S4kl1Dl9bj8ZIzGCLBDun = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.FILL_AND_STROKE);
        this.Lq8HuNUg0Q623MqNOEDpEO = paint4;
        Paint paint5 = new Paint(1);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        this.IfdBCmzdK0SFAUN = paint5;
        Paint paint6 = new Paint(1);
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setColor(-65281);
        paint6.setStrokeWidth((float) ExtensionsKt.getPx(2));
        this.zzrHq5THgQdVhShelxegx = paint6;
        this.kDAQ7EcTyoX7WE = IntRange.Companion.getEMPTY();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSProofaceView, i, i2);
        int styledColor = com.sumsub.sns.core.presentation.ExtensionsKt.getStyledColor(obtainStyledAttributes, R.styleable.SNSProofaceView_snsProofaceMarkerActiveColor, -65281);
        this.xXAwgfSH699GDAm5vBCX = styledColor;
        this.SNgolBHyrZdj4a7ixZ6wFGE = com.sumsub.sns.core.presentation.ExtensionsKt.getStyledColor(obtainStyledAttributes, R.styleable.SNSProofaceView_snsProofaceMarkerInActiveColor, -65281);
        paint.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.SNSProofaceView_snsProofaceMarkerStroke, 0.0f));
        this.zpUNQNyEwze91nGOHa = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSProofaceView_snsProofaceMarkerSize, 0);
        this.RSNWAXaUEPwMjkxe = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSProofaceView_snsProofaceMarkerPadding, 0);
        this.lSN1Mfux3Agbjibaf = com.sumsub.sns.core.presentation.ExtensionsKt.getStyledColor(obtainStyledAttributes, R.styleable.SNSProofaceView_snsProofaceOverlayColor, -1);
        paint4.setColor(com.sumsub.sns.core.presentation.ExtensionsKt.getStyledColor(obtainStyledAttributes, R.styleable.SNSProofaceView_snsProofaceCompleteOverlayColor, -1));
        paint2.setColor(com.sumsub.sns.core.presentation.ExtensionsKt.getStyledColor(obtainStyledAttributes, R.styleable.SNSProofaceView_snsProofaceCapturingRectColor, -1));
        paint2.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.SNSProofaceView_snsProofaceCapturingRectStroke, 0.0f));
        paint5.setColor(com.sumsub.sns.core.presentation.ExtensionsKt.getStyledColor(obtainStyledAttributes, R.styleable.SNSProofaceView_snsProofaceRecognizingColor, -1));
        paint5.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.SNSProofaceView_snsProofaceRecognizingStroke, 0.0f));
        this.Ku863HM4m4Edc3Ql5I = (long) obtainStyledAttributes.getInt(R.styleable.SNSProofaceView_snsProofaceRecognizingAnimationSpeed, 1000);
        int i3 = R.styleable.SNSProofaceView_android_padding;
        if (obtainStyledAttributes.hasValue(i3)) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i3, 0);
            setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        } else {
            setPadding(obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSProofaceView_android_paddingLeft, getPaddingLeft()), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSProofaceView_android_paddingTop, getPaddingTop()), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSProofaceView_android_paddingRight, getPaddingRight()), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSProofaceView_android_paddingBottom, getPaddingBottom()));
        }
        obtainStyledAttributes.recycle();
        paint.setColor(styledColor);
    }

    public final void Cwa7EHp4RmMFhwpOCPWojiqbo(Canvas canvas) {
        float f = (float) 1;
        float abs = f - Math.abs(e.coerceIn(this.Cwa7EHp4RmMFhwpOCPWojiqbo, -0.11f, 0.11f) * ((float) 10));
        if (abs <= f && abs >= ((float) 0)) {
            float f2 = ((float) this.zpUNQNyEwze91nGOHa) * abs;
            int i = this.aDBqOnRnCJ0gWECtZQu;
            float f3 = (((float) i) - (((float) (this.ejVYvrSYmsA1fCSIPxDrI - i)) * this.Cwa7EHp4RmMFhwpOCPWojiqbo)) + ((float) this.RSNWAXaUEPwMjkxe);
            RectF rectF = new RectF(getFaceCapturingRect());
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            canvas.save();
            canvas.rotate(this.rOohFjltS1r352oBvriA440, centerX, centerY);
            for (Iterator it = e.step(e.until(0, 360), 4).iterator(); it.hasNext(); it = it) {
                int nextInt = ((IntIterator) it).nextInt();
                double d = (double) centerX;
                double d2 = (double) f3;
                double radians = (double) ((float) Math.toRadians((double) nextInt));
                float a = (float) a.a(radians, d2, d);
                double d3 = (double) centerY;
                float cos = (float) (d3 - (Math.cos(radians) * d2));
                double d4 = (double) (f3 + f2);
                float a3 = (float) a.a(radians, d4, d);
                float cos2 = (float) (d3 - (Math.cos(radians) * d4));
                this.cPMlB5HN7W4Ve3yHBwMXNEUvD.setColor((Cwa7EHp4RmMFhwpOCPWojiqbo() || this.kDAQ7EcTyoX7WE.contains(nextInt)) ? this.xXAwgfSH699GDAm5vBCX : this.SNgolBHyrZdj4a7ixZ6wFGE);
                canvas.drawLine(a, cos, a3, cos2, this.cPMlB5HN7W4Ve3yHBwMXNEUvD);
                centerY = centerY;
            }
            canvas.restore();
        }
    }
}
