package com.adjust.sdk;

import a2.b.a.a.a;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;
public class RequestHandler implements IRequestHandler {
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private String basePath;
    private ThreadExecutor executor = new SingleThreadCachedScheduler("RequestHandler");
    private String gdprPath;
    private ILogger logger = AdjustFactory.getLogger();
    private WeakReference<IPackageHandler> packageHandlerWeakRef;
    private String subscriptionPath;

    public RequestHandler(IActivityHandler iActivityHandler, IPackageHandler iPackageHandler) {
        init(iActivityHandler, iPackageHandler);
        this.basePath = iPackageHandler.getBasePath();
        this.gdprPath = iPackageHandler.getGdprPath();
        this.subscriptionPath = iPackageHandler.getSubscriptionPath();
    }

    private void closePackageI(ActivityPackage activityPackage, String str, Throwable th) {
        String formatString = Util.formatString("%s. (%s) Will retry later", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
        this.logger.error(formatString, new Object[0]);
        ResponseData buildResponseData = ResponseData.buildResponseData(activityPackage);
        buildResponseData.message = formatString;
        IPackageHandler iPackageHandler = this.packageHandlerWeakRef.get();
        if (iPackageHandler != null) {
            iPackageHandler.closeFirstPackage(buildResponseData, activityPackage);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendI(ActivityPackage activityPackage, int i) {
        String str;
        IActivityHandler iActivityHandler;
        if (activityPackage.getActivityKind() == ActivityKind.GDPR) {
            str = AdjustFactory.getGdprUrl();
            if (this.gdprPath != null) {
                StringBuilder L = a.L(str);
                L.append(this.gdprPath);
                str = L.toString();
            }
        } else if (activityPackage.getActivityKind() == ActivityKind.SUBSCRIPTION) {
            str = AdjustFactory.getSubscriptionUrl();
            if (this.subscriptionPath != null) {
                StringBuilder L2 = a.L(str);
                L2.append(this.subscriptionPath);
                str = L2.toString();
            }
        } else {
            str = AdjustFactory.getBaseUrl();
            if (this.basePath != null) {
                StringBuilder L3 = a.L(str);
                L3.append(this.basePath);
                str = L3.toString();
            }
        }
        StringBuilder L4 = a.L(str);
        L4.append(activityPackage.getPath());
        try {
            ResponseData createPOSTHttpsURLConnection = UtilNetworking.createPOSTHttpsURLConnection(L4.toString(), activityPackage, i);
            IPackageHandler iPackageHandler = this.packageHandlerWeakRef.get();
            if (iPackageHandler != null && (iActivityHandler = this.activityHandlerWeakRef.get()) != null) {
                if (createPOSTHttpsURLConnection.trackingState == TrackingState.OPTED_OUT) {
                    iActivityHandler.gotOptOutResponse();
                } else if (createPOSTHttpsURLConnection.jsonResponse == null) {
                    iPackageHandler.closeFirstPackage(createPOSTHttpsURLConnection, activityPackage);
                } else {
                    iPackageHandler.sendNextPackage(createPOSTHttpsURLConnection);
                }
            }
        } catch (UnsupportedEncodingException e) {
            sendNextPackageI(activityPackage, "Failed to encode parameters", e);
        } catch (SocketTimeoutException e2) {
            closePackageI(activityPackage, "Request timed out", e2);
        } catch (IOException e3) {
            closePackageI(activityPackage, "Request failed", e3);
        } catch (Throwable th) {
            sendNextPackageI(activityPackage, "Runtime exception", th);
        }
    }

    private void sendNextPackageI(ActivityPackage activityPackage, String str, Throwable th) {
        String formatString = Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
        this.logger.error(formatString, new Object[0]);
        ResponseData buildResponseData = ResponseData.buildResponseData(activityPackage);
        buildResponseData.message = formatString;
        IPackageHandler iPackageHandler = this.packageHandlerWeakRef.get();
        if (iPackageHandler != null) {
            iPackageHandler.sendNextPackage(buildResponseData);
        }
    }

    @Override // com.adjust.sdk.IRequestHandler
    public void init(IActivityHandler iActivityHandler, IPackageHandler iPackageHandler) {
        this.packageHandlerWeakRef = new WeakReference<>(iPackageHandler);
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
    }

    @Override // com.adjust.sdk.IRequestHandler
    public void sendPackage(final ActivityPackage activityPackage, final int i) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.RequestHandler.1
            @Override // java.lang.Runnable
            public void run() {
                RequestHandler.this.sendI(activityPackage, i);
            }
        });
    }

    @Override // com.adjust.sdk.IRequestHandler
    public void teardown() {
        this.logger.verbose("RequestHandler teardown", new Object[0]);
        ThreadExecutor threadExecutor = this.executor;
        if (threadExecutor != null) {
            threadExecutor.teardown();
        }
        WeakReference<IPackageHandler> weakReference = this.packageHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<IActivityHandler> weakReference2 = this.activityHandlerWeakRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.executor = null;
        this.packageHandlerWeakRef = null;
        this.activityHandlerWeakRef = null;
        this.logger = null;
    }
}
