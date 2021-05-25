package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.IQualityIssueListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.SharedData;
import com.voximplant.sdk.internal.callbacks.Callback;
import com.voximplant.sdk.internal.callbacks.OnCodecMismatch;
import com.voximplant.sdk.internal.callbacks.OnHighMediaLatency;
import com.voximplant.sdk.internal.callbacks.OnIceDisconnected;
import com.voximplant.sdk.internal.callbacks.OnLocalVideoDegradation;
import com.voximplant.sdk.internal.callbacks.OnLowBandwidth;
import com.voximplant.sdk.internal.callbacks.OnNoAudioSignal;
import com.voximplant.sdk.internal.callbacks.OnPacketLoss;
import com.voximplant.sdk.internal.callbacks.QualityCallbackController;
import java.util.Objects;
import java.util.concurrent.Executor;
public class QualityCallbackController {
    public IQualityIssueListener a;
    public Executor b = SharedData.getCallbackExecutor();
    public final ICall c;

    public QualityCallbackController(ICall iCall) {
        this.c = iCall;
    }

    public void invokeQualityIssueEvent(Callback callback) {
        this.b.execute(new Runnable(callback) { // from class: a2.t.a.c.o0.e
            public final /* synthetic */ Callback b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                QualityCallbackController qualityCallbackController = QualityCallbackController.this;
                Callback callback2 = this.b;
                Objects.requireNonNull(qualityCallbackController);
                Logger.w("Quality issue: " + callback2);
                IQualityIssueListener iQualityIssueListener = qualityCallbackController.a;
                if (iQualityIssueListener == null) {
                    Logger.w("QualityCallbackController: invokeEvent: listener is not set");
                    return;
                }
                if (callback2 instanceof OnCodecMismatch) {
                    Logger.w("Invoke onCodecMismatch");
                    OnCodecMismatch onCodecMismatch = (OnCodecMismatch) callback2;
                    iQualityIssueListener.onCodecMismatch(qualityCallbackController.c, onCodecMismatch.getLevel(), onCodecMismatch.getSendCodec());
                }
                if (callback2 instanceof OnLocalVideoDegradation) {
                    Logger.w("Invoke onLocalVideoDegradation");
                    OnLocalVideoDegradation onLocalVideoDegradation = (OnLocalVideoDegradation) callback2;
                    iQualityIssueListener.onLocalVideoDegradation(qualityCallbackController.c, onLocalVideoDegradation.getLevel(), onLocalVideoDegradation.getTargetFrameWidth(), onLocalVideoDegradation.getTargetFrameHeight(), onLocalVideoDegradation.getActualFrameWidth(), onLocalVideoDegradation.getActualFrameHeight());
                }
                if (callback2 instanceof OnIceDisconnected) {
                    Logger.w("Invoke onIceDisconnected");
                    iQualityIssueListener.onIceDisconnected(qualityCallbackController.c, ((OnIceDisconnected) callback2).getLevel());
                }
                if (callback2 instanceof OnPacketLoss) {
                    Logger.w("Invoke OnPacketLoss");
                    OnPacketLoss onPacketLoss = (OnPacketLoss) callback2;
                    iQualityIssueListener.onPacketLoss(qualityCallbackController.c, onPacketLoss.getLevel(), onPacketLoss.getPacketLoss());
                }
                if (callback2 instanceof OnHighMediaLatency) {
                    Logger.w("Invoke onHighMediaLatency");
                    OnHighMediaLatency onHighMediaLatency = (OnHighMediaLatency) callback2;
                    iQualityIssueListener.onHighMediaLatency(qualityCallbackController.c, onHighMediaLatency.getLevel(), onHighMediaLatency.getLatency());
                }
                if (callback2 instanceof OnNoAudioSignal) {
                    Logger.w("Invoke onNoAudioSignal");
                    iQualityIssueListener.onNoAudioSignal(qualityCallbackController.c, ((OnNoAudioSignal) callback2).getLevel());
                }
                if (callback2 instanceof OnLowBandwidth) {
                    Logger.w("Invoke onLowBandwidth");
                    OnLowBandwidth onLowBandwidth = (OnLowBandwidth) callback2;
                    iQualityIssueListener.onLowBandwidth(qualityCallbackController.c, onLowBandwidth.getLevel(), onLowBandwidth.getTargetBitrate(), onLowBandwidth.getActualBitrate());
                }
            }
        });
    }

    public void setQualityListener(IQualityIssueListener iQualityIssueListener) {
        this.a = iQualityIssueListener;
    }
}
