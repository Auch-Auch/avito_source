package a2.t.a.c.o0;

import com.voximplant.sdk.call.ICallListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.callbacks.CallCallbackController;
import com.voximplant.sdk.internal.callbacks.Callback;
import com.voximplant.sdk.internal.callbacks.OnCallAudioStarted;
import com.voximplant.sdk.internal.callbacks.OnCallConnected;
import com.voximplant.sdk.internal.callbacks.OnCallDisconnected;
import com.voximplant.sdk.internal.callbacks.OnCallFailed;
import com.voximplant.sdk.internal.callbacks.OnCallRinging;
import com.voximplant.sdk.internal.callbacks.OnCallStatsReceived;
import com.voximplant.sdk.internal.callbacks.OnEndpointAdded;
import com.voximplant.sdk.internal.callbacks.OnIceCompleted;
import com.voximplant.sdk.internal.callbacks.OnIceTimeout;
import com.voximplant.sdk.internal.callbacks.OnLocalVideoStreamAdded;
import com.voximplant.sdk.internal.callbacks.OnLocalVideoStreamRemoved;
import com.voximplant.sdk.internal.callbacks.OnMessageReceived;
import com.voximplant.sdk.internal.callbacks.OnSIPInfoReceived;
import java.util.Iterator;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ CallCallbackController a;

    public /* synthetic */ a(CallCallbackController callCallbackController) {
        this.a = callCallbackController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CallCallbackController callCallbackController = this.a;
        if (callCallbackController.a.isEmpty()) {
            return;
        }
        while (!callCallbackController.b.isEmpty()) {
            Callback poll = callCallbackController.b.poll();
            Iterator<ICallListener> it = callCallbackController.a.iterator();
            while (it.hasNext()) {
                ICallListener next = it.next();
                if (poll instanceof OnCallConnected) {
                    Logger.i("Invoke onCallConnected");
                    OnCallConnected onCallConnected = (OnCallConnected) poll;
                    next.onCallConnected(onCallConnected.getCall(), onCallConnected.getHeaders());
                }
                if (poll instanceof OnCallFailed) {
                    Logger.i("Invoke onCallFailed");
                    OnCallFailed onCallFailed = (OnCallFailed) poll;
                    next.onCallFailed(onCallFailed.getCall(), onCallFailed.getErrorCode(), onCallFailed.getErrorDescription(), onCallFailed.getHeaders());
                }
                if (poll instanceof OnCallRinging) {
                    Logger.i("Invoke onCallRinging");
                    OnCallRinging onCallRinging = (OnCallRinging) poll;
                    next.onCallRinging(onCallRinging.getCall(), onCallRinging.getHeaders());
                }
                if (poll instanceof OnCallAudioStarted) {
                    Logger.i("Invoke onCallAudioStarted");
                    next.onCallAudioStarted(((OnCallAudioStarted) poll).getCall());
                }
                if (poll instanceof OnCallDisconnected) {
                    Logger.i("Invoke onCallDisconnected");
                    OnCallDisconnected onCallDisconnected = (OnCallDisconnected) poll;
                    next.onCallDisconnected(onCallDisconnected.getCall(), onCallDisconnected.getHeaders(), onCallDisconnected.getAnsweredStatus());
                }
                if (poll instanceof OnMessageReceived) {
                    Logger.i("Invoke onMessageReceived");
                    OnMessageReceived onMessageReceived = (OnMessageReceived) poll;
                    next.onMessageReceived(onMessageReceived.getCall(), onMessageReceived.getMessage());
                }
                if (poll instanceof OnSIPInfoReceived) {
                    Logger.i("Invoke onSIPInfoReceived");
                    OnSIPInfoReceived onSIPInfoReceived = (OnSIPInfoReceived) poll;
                    next.onSIPInfoReceived(onSIPInfoReceived.getCall(), onSIPInfoReceived.getMimeType(), onSIPInfoReceived.getContent(), onSIPInfoReceived.getHeaders());
                }
                if (poll instanceof OnLocalVideoStreamAdded) {
                    Logger.i("Invoke onLocalVideoStreamAdded");
                    OnLocalVideoStreamAdded onLocalVideoStreamAdded = (OnLocalVideoStreamAdded) poll;
                    next.onLocalVideoStreamAdded(onLocalVideoStreamAdded.getCall(), onLocalVideoStreamAdded.getVideoStream());
                }
                if (poll instanceof OnLocalVideoStreamRemoved) {
                    Logger.i("Invoke onLocalVideoStreamRemoved");
                    OnLocalVideoStreamRemoved onLocalVideoStreamRemoved = (OnLocalVideoStreamRemoved) poll;
                    next.onLocalVideoStreamRemoved(onLocalVideoStreamRemoved.getCall(), onLocalVideoStreamRemoved.getVideoStream());
                }
                if (poll instanceof OnIceCompleted) {
                    Logger.i("Invoke onICECompleted");
                    next.onICECompleted(((OnIceCompleted) poll).getCall());
                }
                if (poll instanceof OnIceTimeout) {
                    Logger.i("Invoke onICETimeout");
                    next.onICETimeout(((OnIceTimeout) poll).getCall());
                }
                if (poll instanceof OnEndpointAdded) {
                    Logger.i("Invoke onEndpointAdded");
                    OnEndpointAdded onEndpointAdded = (OnEndpointAdded) poll;
                    next.onEndpointAdded(onEndpointAdded.getCall(), onEndpointAdded.getEndpoint());
                }
                if (poll instanceof OnCallStatsReceived) {
                    Logger.i("Invoke onCallStatsReceived");
                    OnCallStatsReceived onCallStatsReceived = (OnCallStatsReceived) poll;
                    next.onCallStatsReceived(onCallStatsReceived.a, onCallStatsReceived.b);
                }
            }
        }
    }
}
