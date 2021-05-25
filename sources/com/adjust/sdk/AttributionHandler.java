package com.adjust.sdk;

import android.net.Uri;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import com.adjust.sdk.scheduler.TimerOnce;
import com.facebook.internal.ServerProtocol;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
public class AttributionHandler implements IAttributionHandler {
    private static final String ATTRIBUTION_TIMER_NAME = "Attribution timer";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private String basePath;
    private String clientSdk;
    private String lastInitiatedBy;
    private ILogger logger = AdjustFactory.getLogger();
    private boolean paused;
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler("AttributionHandler");
    private TimerOnce timer = new TimerOnce(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.1
        @Override // java.lang.Runnable
        public void run() {
            AttributionHandler.this.sendAttributionRequest();
        }
    }, ATTRIBUTION_TIMER_NAME);

    public AttributionHandler(IActivityHandler iActivityHandler, boolean z) {
        this.basePath = iActivityHandler.getBasePath();
        this.clientSdk = iActivityHandler.getDeviceInfo().clientSdk;
        init(iActivityHandler, z);
    }

    private ActivityPackage buildAndGetAttributionPackage() {
        long currentTimeMillis = System.currentTimeMillis();
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        ActivityPackage buildAttributionPackage = new PackageBuilder(iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getActivityState(), iActivityHandler.getSessionParameters(), currentTimeMillis).buildAttributionPackage(this.lastInitiatedBy);
        this.lastInitiatedBy = null;
        return buildAttributionPackage;
    }

    private void checkAttributionI(IActivityHandler iActivityHandler, ResponseData responseData) {
        JSONObject jSONObject = responseData.jsonResponse;
        if (jSONObject != null) {
            long optLong = jSONObject.optLong("ask_in", -1);
            if (optLong >= 0) {
                iActivityHandler.setAskingAttribution(true);
                this.lastInitiatedBy = "backend";
                getAttributionI(optLong);
                return;
            }
            iActivityHandler.setAskingAttribution(false);
            responseData.attribution = AdjustAttribution.fromJson(responseData.jsonResponse.optJSONObject("attribution"), responseData.adid, Util.getSdkPrefixPlatform(this.clientSdk));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkAttributionResponseI(IActivityHandler iActivityHandler, AttributionResponseData attributionResponseData) {
        checkAttributionI(iActivityHandler, attributionResponseData);
        checkDeeplinkI(attributionResponseData);
        iActivityHandler.launchAttributionResponseTasks(attributionResponseData);
    }

    private void checkDeeplinkI(AttributionResponseData attributionResponseData) {
        JSONObject optJSONObject;
        String optString;
        JSONObject jSONObject = attributionResponseData.jsonResponse;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("attribution")) != null && (optString = optJSONObject.optString("deeplink", null)) != null) {
            attributionResponseData.deeplink = Uri.parse(optString);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkSdkClickResponseI(IActivityHandler iActivityHandler, SdkClickResponseData sdkClickResponseData) {
        checkAttributionI(iActivityHandler, sdkClickResponseData);
        iActivityHandler.launchSdkClickResponseTasks(sdkClickResponseData);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkSessionResponseI(IActivityHandler iActivityHandler, SessionResponseData sessionResponseData) {
        checkAttributionI(iActivityHandler, sessionResponseData);
        iActivityHandler.launchSessionResponseTasks(sessionResponseData);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getAttributionI(long j) {
        if (this.timer.getFireIn() <= j) {
            if (j != 0) {
                this.logger.debug("Waiting to query attribution in %s seconds", Util.SecondsDisplayFormat.format(((double) j) / 1000.0d));
            }
            this.timer.startIn(j);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendAttributionRequest() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.6
            @Override // java.lang.Runnable
            public void run() {
                AttributionHandler.this.sendAttributionRequestI();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendAttributionRequestI() {
        if (!this.activityHandlerWeakRef.get().getActivityState().isGdprForgotten) {
            if (this.paused) {
                this.logger.debug("Attribution handler is paused", new Object[0]);
                return;
            }
            ActivityPackage buildAndGetAttributionPackage = buildAndGetAttributionPackage();
            this.logger.verbose("%s", buildAndGetAttributionPackage.getExtendedString());
            try {
                ResponseData createGETHttpsURLConnection = UtilNetworking.createGETHttpsURLConnection(buildAndGetAttributionPackage, this.basePath);
                if (createGETHttpsURLConnection instanceof AttributionResponseData) {
                    if (createGETHttpsURLConnection.trackingState == TrackingState.OPTED_OUT) {
                        this.activityHandlerWeakRef.get().gotOptOutResponse();
                    } else {
                        checkAttributionResponse((AttributionResponseData) createGETHttpsURLConnection);
                    }
                }
            } catch (Exception e) {
                this.logger.error("Failed to get attribution (%s)", e.getMessage());
            }
        }
    }

    public void checkAttributionResponse(final AttributionResponseData attributionResponseData) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.5
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (iActivityHandler != null) {
                    AttributionHandler.this.checkAttributionResponseI(iActivityHandler, attributionResponseData);
                }
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSdkClickResponse(final SdkClickResponseData sdkClickResponseData) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.4
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (iActivityHandler != null) {
                    AttributionHandler.this.checkSdkClickResponseI(iActivityHandler, sdkClickResponseData);
                }
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSessionResponse(final SessionResponseData sessionResponseData) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.3
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (iActivityHandler != null) {
                    AttributionHandler.this.checkSessionResponseI(iActivityHandler, sessionResponseData);
                }
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void getAttribution() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.2
            @Override // java.lang.Runnable
            public void run() {
                AttributionHandler.this.lastInitiatedBy = ServerProtocol.DIALOG_PARAM_SDK_VERSION;
                AttributionHandler.this.getAttributionI(0);
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void init(IActivityHandler iActivityHandler, boolean z) {
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.paused = !z;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void resumeSending() {
        this.paused = false;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void teardown() {
        this.logger.verbose("AttributionHandler teardown", new Object[0]);
        TimerOnce timerOnce = this.timer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.timer = null;
        this.logger = null;
        this.scheduler = null;
        this.activityHandlerWeakRef = null;
    }
}
