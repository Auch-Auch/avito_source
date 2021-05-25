package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.sumsub.sns.core.SNSActionResult;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.data.listener.SNSActionResultHandler;
import com.sumsub.sns.core.data.listener.SNSErrorHandler;
import com.sumsub.sns.core.data.model.AnswerType;
import com.sumsub.sns.core.data.model.AppConfig;
import com.sumsub.sns.core.data.model.AppConfigKt;
import com.sumsub.sns.core.data.model.LogType;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.data.model.SNSLivenessResult;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.core.domain.FaceDetector;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.presentation.base.SNSBaseViewModel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.concurrent.Executors;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.WebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
import t6.r.a.j;
import timber.log.Timber;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.YuBMj5oYSZ1EKs0piMUZxDCY;
public final class tjrpI83q5sk1iMEXPz1hKo extends SNSBaseViewModel {
    public static final SimpleDateFormat RSNWAXaUEPwMjkxe = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public boolean Cwa7EHp4RmMFhwpOCPWojiqbo;
    public final xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.VVeXCTyov0hLti0HOLqom2taL0gk IfdBCmzdK0SFAUN;
    public final MutableSharedFlow<Triple<FaceDetector.RawImage, FaceDetector.Size, String>> J3eZRYS4AnxhOKbC2x2nQNPT = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    public final DDdm1ec8RQad6rlXcC8U Ku863HM4m4Edc3Ql5I;
    public final Gson Lq8HuNUg0Q623MqNOEDpEO;
    @NotNull
    public final MutableLiveData<alNh9hLeM39> M6kaoQeazePMH0Sq8;
    public String N434VQHTrGUotPhpDDIhYJrpL4ro = "";
    public final CommonRepository SNgolBHyrZdj4a7ixZ6wFGE;
    public final ExecutorCoroutineDispatcher TISdV9vjEDKYTeuQpV0VHpJbW;
    public final FaceDetector TJ0S4kl1Dl9bj8ZIzGCLBDun;
    public boolean YWVVuaVDYicbKjhsZbjQiRooZ;
    public String aDBqOnRnCJ0gWECtZQu;
    public long aHA7rWvEdW6bbOdx1EKD4aVF0k;
    public final MutableLiveData<BYfFGQyI88> cPMlB5HN7W4Ve3yHBwMXNEUvD;
    public String ejVYvrSYmsA1fCSIPxDrI;
    public long idM1z15K75;
    public final String lSN1Mfux3Agbjibaf;
    public Timer lk42nG4RRcMiHe8r6w;
    public int mdHgHuGChkRJqBUMUk707;
    public String nBrxtyIHUH54OOmxO2aE715szhyYI;
    public Timer oVTxbCNkVuXyP468Xhsl9qtSE9v;
    public int qNDua1J9EaZOsmugz0J;
    public Bitmap rOohFjltS1r352oBvriA440;
    public final SettingsRepository xXAwgfSH699GDAm5vBCX;
    public final String yr0oPNYrJWblwzfs6tPicPv;
    public final SendLogUseCase zpUNQNyEwze91nGOHa;
    public final xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88 zzrHq5THgQdVhShelxegx;

    public static abstract class BYfFGQyI88 {

        /* renamed from: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo$BYfFGQyI88$BYfFGQyI88  reason: collision with other inner class name */
        public static final class C0694BYfFGQyI88 extends BYfFGQyI88 {
            @NotNull
            public final RectF Cwa7EHp4RmMFhwpOCPWojiqbo;

            public C0694BYfFGQyI88(@NotNull RectF rectF) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = rectF;
            }
        }

        public static final class UGPkPVVOmk179tTX8sQoOodQt extends BYfFGQyI88 {
            @NotNull
            public static final UGPkPVVOmk179tTX8sQoOodQt Cwa7EHp4RmMFhwpOCPWojiqbo = new UGPkPVVOmk179tTX8sQoOodQt();

            public UGPkPVVOmk179tTX8sQoOodQt() {
                super(null);
            }
        }

        public static final class VVeXCTyov0hLti0HOLqom2taL0gk extends BYfFGQyI88 {
            @NotNull
            public final RectF Cwa7EHp4RmMFhwpOCPWojiqbo;

            public VVeXCTyov0hLti0HOLqom2taL0gk(@NotNull RectF rectF) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = rectF;
            }
        }

        public static final class alNh9hLeM39 extends BYfFGQyI88 {
            @NotNull
            public static final alNh9hLeM39 Cwa7EHp4RmMFhwpOCPWojiqbo = new alNh9hLeM39();

            public alNh9hLeM39() {
                super(null);
            }
        }

        public BYfFGQyI88() {
        }

        public /* synthetic */ BYfFGQyI88(j jVar) {
            this();
        }
    }

    public static final class DDdm1ec8RQad6rlXcC8U implements BYfFGQyI88.VVeXCTyov0hLti0HOLqom2taL0gk {
        public final /* synthetic */ tjrpI83q5sk1iMEXPz1hKo Cwa7EHp4RmMFhwpOCPWojiqbo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DDdm1ec8RQad6rlXcC8U(tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = tjrpi83q5sk1imexpz1hko;
        }

        @Override // xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88.VVeXCTyov0hLti0HOLqom2taL0gk
        public void Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt uGPkPVVOmk179tTX8sQoOodQt) {
            SNSActionResult sNSActionResult;
            AnswerType oVTxbCNkVuXyP468Xhsl9qtSE9v;
            String aDBqOnRnCJ0gWECtZQu;
            Integer lk42nG4RRcMiHe8r6w;
            int i = 0;
            Timber.d("SNSLiveness3dFaceViewModel.onResult: result=" + uGPkPVVOmk179tTX8sQoOodQt, new Object[0]);
            tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            Timer timer = tjrpi83q5sk1imexpz1hko.lk42nG4RRcMiHe8r6w;
            if (timer != null) {
                timer.cancel();
            }
            AnswerType answerType = null;
            tjrpi83q5sk1imexpz1hko.lk42nG4RRcMiHe8r6w = null;
            Timer timer2 = tjrpi83q5sk1imexpz1hko.oVTxbCNkVuXyP468Xhsl9qtSE9v;
            if (timer2 != null) {
                timer2.cancel();
            }
            tjrpi83q5sk1imexpz1hko.oVTxbCNkVuXyP468Xhsl9qtSE9v = null;
            if (uGPkPVVOmk179tTX8sQoOodQt instanceof BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.mrIBiYc0Jm) {
                tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.mrIBiYc0Jm mribiyc0jm = (BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.mrIBiYc0Jm) uGPkPVVOmk179tTX8sQoOodQt;
                YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY = mribiyc0jm.Cwa7EHp4RmMFhwpOCPWojiqbo;
                if (!(yuBMj5oYSZ1EKs0piMUZxDCY == null || (lk42nG4RRcMiHe8r6w = yuBMj5oYSZ1EKs0piMUZxDCY.lk42nG4RRcMiHe8r6w()) == null)) {
                    i = lk42nG4RRcMiHe8r6w.intValue();
                }
                tjrpi83q5sk1imexpz1hko2.qNDua1J9EaZOsmugz0J = i;
                this.Cwa7EHp4RmMFhwpOCPWojiqbo.idM1z15K75 = 0;
                YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY2 = mribiyc0jm.Cwa7EHp4RmMFhwpOCPWojiqbo;
                if (!(yuBMj5oYSZ1EKs0piMUZxDCY2 == null || (aDBqOnRnCJ0gWECtZQu = yuBMj5oYSZ1EKs0piMUZxDCY2.aDBqOnRnCJ0gWECtZQu()) == null)) {
                    try {
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo.IfdBCmzdK0SFAUN.Cwa7EHp4RmMFhwpOCPWojiqbo(aDBqOnRnCJ0gWECtZQu);
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo.nBrxtyIHUH54OOmxO2aE715szhyYI = aDBqOnRnCJ0gWECtZQu;
                    } catch (Exception e) {
                        Timber.e(e);
                    }
                }
                this.Cwa7EHp4RmMFhwpOCPWojiqbo.M6kaoQeazePMH0Sq8.postValue(alNh9hLeM39.mrIBiYc0Jm.Cwa7EHp4RmMFhwpOCPWojiqbo);
            } else if (uGPkPVVOmk179tTX8sQoOodQt instanceof BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.alNh9hLeM39) {
                YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY3 = ((BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.alNh9hLeM39) uGPkPVVOmk179tTX8sQoOodQt).Cwa7EHp4RmMFhwpOCPWojiqbo;
                if (yuBMj5oYSZ1EKs0piMUZxDCY3 != null) {
                    answerType = yuBMj5oYSZ1EKs0piMUZxDCY3.oVTxbCNkVuXyP468Xhsl9qtSE9v();
                }
                if (answerType == AnswerType.Yellow) {
                    tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko3 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                    tjrpi83q5sk1imexpz1hko3.mdHgHuGChkRJqBUMUk707 = 0;
                    tjrpi83q5sk1imexpz1hko3.M6kaoQeazePMH0Sq8.postValue(alNh9hLeM39.mrIBiYc0Jm.Cwa7EHp4RmMFhwpOCPWojiqbo);
                }
            } else if (uGPkPVVOmk179tTX8sQoOodQt instanceof BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.C0701UGPkPVVOmk179tTX8sQoOodQt) {
                tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko4 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                tjrpi83q5sk1imexpz1hko4.qNDua1J9EaZOsmugz0J = 0;
                tjrpi83q5sk1imexpz1hko4.M6kaoQeazePMH0Sq8.postValue(new alNh9hLeM39.VVeXCTyov0hLti0HOLqom2taL0gk(tjrpi83q5sk1imexpz1hko4.rOohFjltS1r352oBvriA440));
            } else if (uGPkPVVOmk179tTX8sQoOodQt instanceof BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.AyZhE6NYuOjRPjA) {
                tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko5 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                tjrpi83q5sk1imexpz1hko5.qNDua1J9EaZOsmugz0J = 0;
                String str = tjrpi83q5sk1imexpz1hko5.ejVYvrSYmsA1fCSIPxDrI;
                if (str != null) {
                    try {
                        SNSActionResultHandler actionResultHandler = SNSMobileSDK.INSTANCE.getActionResultHandler();
                        if (actionResultHandler != null) {
                            String str2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo.aDBqOnRnCJ0gWECtZQu;
                            if (str2 == null) {
                                str2 = "";
                            }
                            YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY4 = ((BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.AyZhE6NYuOjRPjA) uGPkPVVOmk179tTX8sQoOodQt).Cwa7EHp4RmMFhwpOCPWojiqbo;
                            String value = (yuBMj5oYSZ1EKs0piMUZxDCY4 == null || (oVTxbCNkVuXyP468Xhsl9qtSE9v = yuBMj5oYSZ1EKs0piMUZxDCY4.oVTxbCNkVuXyP468Xhsl9qtSE9v()) == null) ? null : oVTxbCNkVuXyP468Xhsl9qtSE9v.getValue();
                            YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY5 = ((BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.AyZhE6NYuOjRPjA) uGPkPVVOmk179tTX8sQoOodQt).Cwa7EHp4RmMFhwpOCPWojiqbo;
                            sNSActionResult = actionResultHandler.onActionResult(str, str2, value, Intrinsics.areEqual(yuBMj5oYSZ1EKs0piMUZxDCY5 != null ? yuBMj5oYSZ1EKs0piMUZxDCY5.Cwa7EHp4RmMFhwpOCPWojiqbo() : null, Boolean.TRUE));
                        } else {
                            sNSActionResult = null;
                        }
                        if (sNSActionResult == SNSActionResult.Cancel) {
                            Timber.d("onActionResultHandler: Cancelled by host application", new Object[0]);
                            ActionLiveData actionLiveData = this.Cwa7EHp4RmMFhwpOCPWojiqbo.get_finishActionLiveData();
                            String str3 = this.Cwa7EHp4RmMFhwpOCPWojiqbo.ejVYvrSYmsA1fCSIPxDrI;
                            SNSLivenessReason.CancelledByHostApplication cancelledByHostApplication = SNSLivenessReason.CancelledByHostApplication.INSTANCE;
                            YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY6 = ((BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.AyZhE6NYuOjRPjA) uGPkPVVOmk179tTX8sQoOodQt).Cwa7EHp4RmMFhwpOCPWojiqbo;
                            if (yuBMj5oYSZ1EKs0piMUZxDCY6 != null) {
                                answerType = yuBMj5oYSZ1EKs0piMUZxDCY6.oVTxbCNkVuXyP468Xhsl9qtSE9v();
                            }
                            actionLiveData.postValue(new Event(new SNSLivenessResult.FaceAuth(str3, cancelledByHostApplication, answerType)));
                            this.Cwa7EHp4RmMFhwpOCPWojiqbo.TJ0S4kl1Dl9bj8ZIzGCLBDun.stop();
                            return;
                        }
                    } catch (Exception e2) {
                        Timber.e("Error while calling action result handler", new Object[0]);
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo.Cwa7EHp4RmMFhwpOCPWojiqbo(e2);
                    }
                }
                this.Cwa7EHp4RmMFhwpOCPWojiqbo.M6kaoQeazePMH0Sq8.postValue(new alNh9hLeM39.DDdm1ec8RQad6rlXcC8U(((BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.AyZhE6NYuOjRPjA) uGPkPVVOmk179tTX8sQoOodQt).Cwa7EHp4RmMFhwpOCPWojiqbo));
            } else if (!(uGPkPVVOmk179tTX8sQoOodQt instanceof BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.IXGaYizhe6FCHn8nw5EAC9h8U1)) {
                if (uGPkPVVOmk179tTX8sQoOodQt instanceof BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.C0700BYfFGQyI88) {
                    Throwable th = ((BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.C0700BYfFGQyI88) uGPkPVVOmk179tTX8sQoOodQt).Cwa7EHp4RmMFhwpOCPWojiqbo;
                    Objects.requireNonNull(th, "null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
                    SNSException.Network network = new SNSException.Network((Exception) th);
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.M6kaoQeazePMH0Sq8.postValue(new alNh9hLeM39.UGPkPVVOmk179tTX8sQoOodQt(network));
                    try {
                        SNSErrorHandler errorHandler = SNSMobileSDK.INSTANCE.getErrorHandler();
                        if (errorHandler != null) {
                            errorHandler.onError(network);
                        }
                    } catch (Exception e3) {
                        Timber.e(e3);
                    }
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.qNDua1J9EaZOsmugz0J = 0;
                } else if (Intrinsics.areEqual(uGPkPVVOmk179tTX8sQoOodQt, BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.VVeXCTyov0hLti0HOLqom2taL0gk.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.M6kaoQeazePMH0Sq8.postValue(new alNh9hLeM39.UGPkPVVOmk179tTX8sQoOodQt(new SNSException.Network(new IOException())));
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.qNDua1J9EaZOsmugz0J = 0;
                } else if (Intrinsics.areEqual(uGPkPVVOmk179tTX8sQoOodQt, BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.DDdm1ec8RQad6rlXcC8U.Cwa7EHp4RmMFhwpOCPWojiqbo)) {
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo.qNDua1J9EaZOsmugz0J = 0;
                }
            }
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceViewModel$2", f = "SNSLiveness3dFaceViewModel.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
    public static final class UGPkPVVOmk179tTX8sQoOodQt extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object Cwa7EHp4RmMFhwpOCPWojiqbo;
        public final /* synthetic */ tjrpI83q5sk1iMEXPz1hKo ejVYvrSYmsA1fCSIPxDrI;
        public int lk42nG4RRcMiHe8r6w;
        public Object oVTxbCNkVuXyP468Xhsl9qtSE9v;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UGPkPVVOmk179tTX8sQoOodQt(tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko, Continuation continuation) {
            super(2, continuation);
            this.ejVYvrSYmsA1fCSIPxDrI = tjrpi83q5sk1imexpz1hko;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new UGPkPVVOmk179tTX8sQoOodQt(this.ejVYvrSYmsA1fCSIPxDrI, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new UGPkPVVOmk179tTX8sQoOodQt(this.ejVYvrSYmsA1fCSIPxDrI, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z;
            tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko;
            tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko2;
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i = this.lk42nG4RRcMiHe8r6w;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko3 = this.ejVYvrSYmsA1fCSIPxDrI;
                try {
                    CommonRepository commonRepository = tjrpi83q5sk1imexpz1hko3.SNgolBHyrZdj4a7ixZ6wFGE;
                    String str = tjrpi83q5sk1imexpz1hko3.lSN1Mfux3Agbjibaf;
                    try {
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo = tjrpi83q5sk1imexpz1hko3;
                        this.oVTxbCNkVuXyP468Xhsl9qtSE9v = tjrpi83q5sk1imexpz1hko3;
                        this.lk42nG4RRcMiHe8r6w = 1;
                        Object config$default = CommonRepository.DefaultImpls.getConfig$default(commonRepository, str, false, this, 2, null);
                        if (config$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tjrpi83q5sk1imexpz1hko = tjrpi83q5sk1imexpz1hko3;
                        obj = config$default;
                    } catch (Exception unused) {
                        tjrpi83q5sk1imexpz1hko2 = tjrpi83q5sk1imexpz1hko3;
                        tjrpi83q5sk1imexpz1hko3 = tjrpi83q5sk1imexpz1hko2;
                        tjrpi83q5sk1imexpz1hko = tjrpi83q5sk1imexpz1hko3;
                        z = false;
                        tjrpi83q5sk1imexpz1hko.Cwa7EHp4RmMFhwpOCPWojiqbo = z;
                        return Unit.INSTANCE;
                    }
                } catch (Exception unused2) {
                    tjrpi83q5sk1imexpz1hko = tjrpi83q5sk1imexpz1hko3;
                    z = false;
                    tjrpi83q5sk1imexpz1hko.Cwa7EHp4RmMFhwpOCPWojiqbo = z;
                    return Unit.INSTANCE;
                }
            } else if (i == 1) {
                tjrpi83q5sk1imexpz1hko = (tjrpI83q5sk1iMEXPz1hKo) this.oVTxbCNkVuXyP468Xhsl9qtSE9v;
                tjrpi83q5sk1imexpz1hko2 = (tjrpI83q5sk1iMEXPz1hKo) this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception unused3) {
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = AppConfigKt.livenessSaveMode((AppConfig) obj, this.ejVYvrSYmsA1fCSIPxDrI.Lq8HuNUg0Q623MqNOEDpEO);
            tjrpi83q5sk1imexpz1hko.Cwa7EHp4RmMFhwpOCPWojiqbo = z;
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceViewModel$1", f = "SNSLiveness3dFaceViewModel.kt", i = {}, l = {487}, m = "invokeSuspend", n = {}, s = {})
    public static final class VVeXCTyov0hLti0HOLqom2taL0gk extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int Cwa7EHp4RmMFhwpOCPWojiqbo;
        public final /* synthetic */ tjrpI83q5sk1iMEXPz1hKo oVTxbCNkVuXyP468Xhsl9qtSE9v;

        @DebugMetadata(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceViewModel$1$invokeSuspend$$inlined$transform$1", f = "SNSLiveness3dFaceViewModel.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
        public static final class UGPkPVVOmk179tTX8sQoOodQt extends SuspendLambda implements Function2<FlowCollector<? super xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.mrIBiYc0Jm>, Continuation<? super Unit>, Object> {
            public FlowCollector Cwa7EHp4RmMFhwpOCPWojiqbo;
            public final /* synthetic */ VVeXCTyov0hLti0HOLqom2taL0gk ejVYvrSYmsA1fCSIPxDrI;
            public final /* synthetic */ Flow lk42nG4RRcMiHe8r6w;
            public int oVTxbCNkVuXyP468Xhsl9qtSE9v;

            /* renamed from: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo$VVeXCTyov0hLti0HOLqom2taL0gk$UGPkPVVOmk179tTX8sQoOodQt$VVeXCTyov0hLti0HOLqom2taL0gk  reason: collision with other inner class name */
            public static final class C0695VVeXCTyov0hLti0HOLqom2taL0gk implements FlowCollector<Triple<? extends FaceDetector.RawImage, ? extends FaceDetector.Size, ? extends String>> {
                public final /* synthetic */ UGPkPVVOmk179tTX8sQoOodQt Cwa7EHp4RmMFhwpOCPWojiqbo;
                public final /* synthetic */ FlowCollector oVTxbCNkVuXyP468Xhsl9qtSE9v;

                @DebugMetadata(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceViewModel$1$invokeSuspend$$inlined$transform$1$1", f = "SNSLiveness3dFaceViewModel.kt", i = {}, l = {139}, m = "emit", n = {}, s = {})
                /* renamed from: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo$VVeXCTyov0hLti0HOLqom2taL0gk$UGPkPVVOmk179tTX8sQoOodQt$VVeXCTyov0hLti0HOLqom2taL0gk$VVeXCTyov0hLti0HOLqom2taL0gk  reason: collision with other inner class name */
                public static final class C0696VVeXCTyov0hLti0HOLqom2taL0gk extends ContinuationImpl {
                    public /* synthetic */ Object Cwa7EHp4RmMFhwpOCPWojiqbo;
                    public final /* synthetic */ C0695VVeXCTyov0hLti0HOLqom2taL0gk lk42nG4RRcMiHe8r6w;
                    public int oVTxbCNkVuXyP468Xhsl9qtSE9v;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public C0696VVeXCTyov0hLti0HOLqom2taL0gk(C0695VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk, Continuation continuation) {
                        super(continuation);
                        this.lk42nG4RRcMiHe8r6w = vVeXCTyov0hLti0HOLqom2taL0gk;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.Cwa7EHp4RmMFhwpOCPWojiqbo = obj;
                        this.oVTxbCNkVuXyP468Xhsl9qtSE9v |= Integer.MIN_VALUE;
                        return this.lk42nG4RRcMiHe8r6w.emit(null, this);
                    }
                }

                public C0695VVeXCTyov0hLti0HOLqom2taL0gk(UGPkPVVOmk179tTX8sQoOodQt uGPkPVVOmk179tTX8sQoOodQt, FlowCollector flowCollector) {
                    this.Cwa7EHp4RmMFhwpOCPWojiqbo = uGPkPVVOmk179tTX8sQoOodQt;
                    this.oVTxbCNkVuXyP468Xhsl9qtSE9v = flowCollector;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
                /* JADX WARNING: Code restructure failed: missing block: B:87:0x03f1, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:88:0x03f2, code lost:
                    kotlin.io.CloseableKt.closeFinally(r9, r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:89:0x03f6, code lost:
                    throw r0;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object emit(kotlin.Triple<? extends com.sumsub.sns.core.domain.FaceDetector.RawImage, ? extends com.sumsub.sns.core.domain.FaceDetector.Size, ? extends java.lang.String> r37, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r38) {
                    /*
                    // Method dump skipped, instructions count: 1015
                    */
                    throw new UnsupportedOperationException("Method not decompiled: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo.VVeXCTyov0hLti0HOLqom2taL0gk.UGPkPVVOmk179tTX8sQoOodQt.C0695VVeXCTyov0hLti0HOLqom2taL0gk.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UGPkPVVOmk179tTX8sQoOodQt(Flow flow, Continuation continuation, VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk) {
                super(2, continuation);
                this.lk42nG4RRcMiHe8r6w = flow;
                this.ejVYvrSYmsA1fCSIPxDrI = vVeXCTyov0hLti0HOLqom2taL0gk;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                UGPkPVVOmk179tTX8sQoOodQt uGPkPVVOmk179tTX8sQoOodQt = new UGPkPVVOmk179tTX8sQoOodQt(this.lk42nG4RRcMiHe8r6w, continuation, this.ejVYvrSYmsA1fCSIPxDrI);
                uGPkPVVOmk179tTX8sQoOodQt.Cwa7EHp4RmMFhwpOCPWojiqbo = (FlowCollector) obj;
                return uGPkPVVOmk179tTX8sQoOodQt;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlowCollector<? super xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.mrIBiYc0Jm> flowCollector, Continuation<? super Unit> continuation) {
                UGPkPVVOmk179tTX8sQoOodQt uGPkPVVOmk179tTX8sQoOodQt = new UGPkPVVOmk179tTX8sQoOodQt(this.lk42nG4RRcMiHe8r6w, continuation, this.ejVYvrSYmsA1fCSIPxDrI);
                uGPkPVVOmk179tTX8sQoOodQt.Cwa7EHp4RmMFhwpOCPWojiqbo = flowCollector;
                return uGPkPVVOmk179tTX8sQoOodQt.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
                int i = this.oVTxbCNkVuXyP468Xhsl9qtSE9v;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                    Flow flow = this.lk42nG4RRcMiHe8r6w;
                    C0695VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk = new C0695VVeXCTyov0hLti0HOLqom2taL0gk(this, flowCollector);
                    this.oVTxbCNkVuXyP468Xhsl9qtSE9v = 1;
                    if (flow.collect(vVeXCTyov0hLti0HOLqom2taL0gk, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        /* renamed from: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo$VVeXCTyov0hLti0HOLqom2taL0gk$VVeXCTyov0hLti0HOLqom2taL0gk  reason: collision with other inner class name */
        public static final class C0697VVeXCTyov0hLti0HOLqom2taL0gk implements FlowCollector<xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.mrIBiYc0Jm> {
            public final /* synthetic */ VVeXCTyov0hLti0HOLqom2taL0gk Cwa7EHp4RmMFhwpOCPWojiqbo;

            public C0697VVeXCTyov0hLti0HOLqom2taL0gk(VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk) {
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = vVeXCTyov0hLti0HOLqom2taL0gk;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.mrIBiYc0Jm mribiyc0jm, @NotNull Continuation continuation) {
                this.Cwa7EHp4RmMFhwpOCPWojiqbo.oVTxbCNkVuXyP468Xhsl9qtSE9v.zzrHq5THgQdVhShelxegx.Cwa7EHp4RmMFhwpOCPWojiqbo(mribiyc0jm);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VVeXCTyov0hLti0HOLqom2taL0gk(tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko, Continuation continuation) {
            super(2, continuation);
            this.oVTxbCNkVuXyP468Xhsl9qtSE9v = tjrpi83q5sk1imexpz1hko;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new VVeXCTyov0hLti0HOLqom2taL0gk(this.oVTxbCNkVuXyP468Xhsl9qtSE9v, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new VVeXCTyov0hLti0HOLqom2taL0gk(this.oVTxbCNkVuXyP468Xhsl9qtSE9v, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flow = FlowKt.flow(new UGPkPVVOmk179tTX8sQoOodQt(this.oVTxbCNkVuXyP468Xhsl9qtSE9v.J3eZRYS4AnxhOKbC2x2nQNPT, null, this));
                C0697VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk = new C0697VVeXCTyov0hLti0HOLqom2taL0gk(this);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = 1;
                if (flow.collect(vVeXCTyov0hLti0HOLqom2taL0gk, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static abstract class alNh9hLeM39 {

        public static final class BYfFGQyI88 extends alNh9hLeM39 {
            @NotNull
            public static final BYfFGQyI88 Cwa7EHp4RmMFhwpOCPWojiqbo = new BYfFGQyI88();

            public BYfFGQyI88() {
                super(null);
            }
        }

        public static final class DDdm1ec8RQad6rlXcC8U extends alNh9hLeM39 {
            @Nullable
            public final YuBMj5oYSZ1EKs0piMUZxDCY Cwa7EHp4RmMFhwpOCPWojiqbo;

            public DDdm1ec8RQad6rlXcC8U(@Nullable YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = yuBMj5oYSZ1EKs0piMUZxDCY;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof DDdm1ec8RQad6rlXcC8U) && Intrinsics.areEqual(this.Cwa7EHp4RmMFhwpOCPWojiqbo, ((DDdm1ec8RQad6rlXcC8U) obj).Cwa7EHp4RmMFhwpOCPWojiqbo);
                }
                return true;
            }

            public int hashCode() {
                YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                if (yuBMj5oYSZ1EKs0piMUZxDCY != null) {
                    return yuBMj5oYSZ1EKs0piMUZxDCY.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("SessionResult(session=");
                L.append(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
                L.append(")");
                return L.toString();
            }
        }

        public static final class UGPkPVVOmk179tTX8sQoOodQt extends alNh9hLeM39 {
            @NotNull
            public final Exception Cwa7EHp4RmMFhwpOCPWojiqbo;

            public UGPkPVVOmk179tTX8sQoOodQt(@NotNull Exception exc) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = exc;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof UGPkPVVOmk179tTX8sQoOodQt) && Intrinsics.areEqual(this.Cwa7EHp4RmMFhwpOCPWojiqbo, ((UGPkPVVOmk179tTX8sQoOodQt) obj).Cwa7EHp4RmMFhwpOCPWojiqbo);
                }
                return true;
            }

            public int hashCode() {
                Exception exc = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                if (exc != null) {
                    return exc.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Error(e=");
                L.append(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
                L.append(")");
                return L.toString();
            }
        }

        public static final class VVeXCTyov0hLti0HOLqom2taL0gk extends alNh9hLeM39 {
            @Nullable
            public final Bitmap Cwa7EHp4RmMFhwpOCPWojiqbo;

            public VVeXCTyov0hLti0HOLqom2taL0gk(@Nullable Bitmap bitmap) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = bitmap;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof VVeXCTyov0hLti0HOLqom2taL0gk) && Intrinsics.areEqual(this.Cwa7EHp4RmMFhwpOCPWojiqbo, ((VVeXCTyov0hLti0HOLqom2taL0gk) obj).Cwa7EHp4RmMFhwpOCPWojiqbo);
                }
                return true;
            }

            public int hashCode() {
                Bitmap bitmap = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                if (bitmap != null) {
                    return bitmap.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Completed(blurredLastImage=");
                L.append(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
                L.append(")");
                return L.toString();
            }
        }

        /* renamed from: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g.tjrpI83q5sk1iMEXPz1hKo$alNh9hLeM39$alNh9hLeM39  reason: collision with other inner class name */
        public static final class C0698alNh9hLeM39 extends alNh9hLeM39 {
            public final float Cwa7EHp4RmMFhwpOCPWojiqbo;

            public C0698alNh9hLeM39(float f) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = f;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof C0698alNh9hLeM39) && Float.compare(this.Cwa7EHp4RmMFhwpOCPWojiqbo, ((C0698alNh9hLeM39) obj).Cwa7EHp4RmMFhwpOCPWojiqbo) == 0;
                }
                return true;
            }

            public int hashCode() {
                return Float.floatToIntBits(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Progress(progress=");
                L.append(this.Cwa7EHp4RmMFhwpOCPWojiqbo);
                L.append(")");
                return L.toString();
            }
        }

        public static final class mrIBiYc0Jm extends alNh9hLeM39 {
            @NotNull
            public static final mrIBiYc0Jm Cwa7EHp4RmMFhwpOCPWojiqbo = new mrIBiYc0Jm();

            public mrIBiYc0Jm() {
                super(null);
            }
        }

        public alNh9hLeM39() {
        }

        public /* synthetic */ alNh9hLeM39(j jVar) {
            this();
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceViewModel$sendLog$1", f = "SNSLiveness3dFaceViewModel.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
    public static final class mrIBiYc0Jm extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int Cwa7EHp4RmMFhwpOCPWojiqbo;
        public final /* synthetic */ Throwable lk42nG4RRcMiHe8r6w;
        public final /* synthetic */ tjrpI83q5sk1iMEXPz1hKo oVTxbCNkVuXyP468Xhsl9qtSE9v;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public mrIBiYc0Jm(tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko, Throwable th, Continuation continuation) {
            super(2, continuation);
            this.oVTxbCNkVuXyP468Xhsl9qtSE9v = tjrpi83q5sk1imexpz1hko;
            this.lk42nG4RRcMiHe8r6w = th;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new mrIBiYc0Jm(this.oVTxbCNkVuXyP468Xhsl9qtSE9v, this.lk42nG4RRcMiHe8r6w, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new mrIBiYc0Jm(this.oVTxbCNkVuXyP468Xhsl9qtSE9v, this.lk42nG4RRcMiHe8r6w, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendLogUseCase sendLogUseCase = this.oVTxbCNkVuXyP468Xhsl9qtSE9v.zpUNQNyEwze91nGOHa;
                LogType logType = LogType.Error;
                Throwable th = this.lk42nG4RRcMiHe8r6w;
                SendLogUseCase.Params params = new SendLogUseCase.Params(logType, th, th.getMessage());
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = 1;
                if (sendLogUseCase.invoke(params, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public tjrpI83q5sk1iMEXPz1hKo(@NotNull FaceDetector faceDetector, @NotNull Gson gson, @NotNull xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk, @NotNull xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88 bYfFGQyI88, @NotNull SettingsRepository settingsRepository, @NotNull CommonRepository commonRepository, @NotNull String str, @NotNull SendLogUseCase sendLogUseCase) {
        this.TJ0S4kl1Dl9bj8ZIzGCLBDun = faceDetector;
        this.Lq8HuNUg0Q623MqNOEDpEO = gson;
        this.IfdBCmzdK0SFAUN = vVeXCTyov0hLti0HOLqom2taL0gk;
        this.zzrHq5THgQdVhShelxegx = bYfFGQyI88;
        this.xXAwgfSH699GDAm5vBCX = settingsRepository;
        this.SNgolBHyrZdj4a7ixZ6wFGE = commonRepository;
        this.lSN1Mfux3Agbjibaf = str;
        this.zpUNQNyEwze91nGOHa = sendLogUseCase;
        StringBuilder L = a2.b.a.a.a.L("msdk2 / 1.17.1 (Android ");
        L.append(Build.VERSION.RELEASE);
        L.append(") - App ");
        SNSMobileSDK sNSMobileSDK = SNSMobileSDK.INSTANCE;
        L.append(sNSMobileSDK.getPackageName());
        L.append(' ');
        L.append(sNSMobileSDK.getVersionName());
        L.append(" / ");
        L.append(sNSMobileSDK.getVersionCode());
        this.yr0oPNYrJWblwzfs6tPicPv = L.toString();
        ExecutorCoroutineDispatcher from = ExecutorsKt.from(Executors.newSingleThreadExecutor());
        this.TISdV9vjEDKYTeuQpV0VHpJbW = from;
        this.Ku863HM4m4Edc3Ql5I = new DDdm1ec8RQad6rlXcC8U(this);
        this.mdHgHuGChkRJqBUMUk707 = Integer.MAX_VALUE;
        this.nBrxtyIHUH54OOmxO2aE715szhyYI = "";
        this.cPMlB5HN7W4Ve3yHBwMXNEUvD = new MutableLiveData<>();
        this.M6kaoQeazePMH0Sq8 = new MutableLiveData<>();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), from, null, new VVeXCTyov0hLti0HOLqom2taL0gk(this, null), 2, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new UGPkPVVOmk179tTX8sQoOodQt(this, null), 3, null);
    }

    @Override // com.sumsub.sns.core.presentation.base.SNSBaseViewModel
    public void onBackClicked() {
        Object obj;
        YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY;
        boolean z = false;
        Timber.d("SNSLiveness3dFaceViewModel.onBackClicked", new Object[0]);
        String str = this.ejVYvrSYmsA1fCSIPxDrI;
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (z) {
            obj = new SNSLivenessResult.FaceDetection(SNSLivenessReason.UserCancelled.INSTANCE);
        } else {
            String str2 = this.ejVYvrSYmsA1fCSIPxDrI;
            SNSLivenessReason.UserCancelled userCancelled = SNSLivenessReason.UserCancelled.INSTANCE;
            alNh9hLeM39 value = this.M6kaoQeazePMH0Sq8.getValue();
            AnswerType answerType = null;
            if (!(value instanceof alNh9hLeM39.DDdm1ec8RQad6rlXcC8U)) {
                value = null;
            }
            alNh9hLeM39.DDdm1ec8RQad6rlXcC8U dDdm1ec8RQad6rlXcC8U = (alNh9hLeM39.DDdm1ec8RQad6rlXcC8U) value;
            if (!(dDdm1ec8RQad6rlXcC8U == null || (yuBMj5oYSZ1EKs0piMUZxDCY = dDdm1ec8RQad6rlXcC8U.Cwa7EHp4RmMFhwpOCPWojiqbo) == null)) {
                answerType = yuBMj5oYSZ1EKs0piMUZxDCY.oVTxbCNkVuXyP468Xhsl9qtSE9v();
            }
            obj = new SNSLivenessResult.FaceAuth(str2, userCancelled, answerType);
        }
        get_finishActionLiveData().postValue(new Event<>(obj));
        Cwa7EHp4RmMFhwpOCPWojiqbo();
    }

    public final void Cwa7EHp4RmMFhwpOCPWojiqbo() {
        this.TJ0S4kl1Dl9bj8ZIzGCLBDun.stop();
        xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88 bYfFGQyI88 = this.zzrHq5THgQdVhShelxegx;
        bYfFGQyI88.getClass();
        Timber.d("Liveness3dFaceRepository.disconnect", new Object[0]);
        WebSocket webSocket = bYfFGQyI88.oVTxbCNkVuXyP468Xhsl9qtSE9v;
        if (webSocket != null) {
            webSocket.close(1000, "disconnect");
        }
        bYfFGQyI88.oVTxbCNkVuXyP468Xhsl9qtSE9v = null;
    }

    public final void Cwa7EHp4RmMFhwpOCPWojiqbo(boolean z, @NotNull AnswerType answerType) {
        SNSLivenessReason sNSLivenessReason;
        Object obj;
        boolean z2 = false;
        Timber.d("SNSLiveness3dFaceViewModel.finishSession: allowContinue=" + z + " answer=" + answerType, new Object[0]);
        if (answerType == AnswerType.Green) {
            sNSLivenessReason = SNSLivenessReason.VeritifcationSuccessfully.INSTANCE;
        } else if (answerType != AnswerType.Red || !z) {
            sNSLivenessReason = SNSLivenessReason.UnknownInternalError.INSTANCE;
        } else {
            sNSLivenessReason = SNSLivenessReason.CompletedUnsuccessfullyAllowContinue.INSTANCE;
        }
        String str = this.ejVYvrSYmsA1fCSIPxDrI;
        if (str == null || str.length() == 0) {
            z2 = true;
        }
        if (z2) {
            obj = new SNSLivenessResult.FaceDetection(sNSLivenessReason);
        } else {
            obj = new SNSLivenessResult.FaceAuth(this.ejVYvrSYmsA1fCSIPxDrI, sNSLivenessReason, answerType);
        }
        get_finishActionLiveData().postValue(new Event<>(obj));
        Cwa7EHp4RmMFhwpOCPWojiqbo();
    }

    public final void Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull Throwable th) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), NonCancellable.INSTANCE, null, new mrIBiYc0Jm(this, th, null), 2, null);
    }
}
