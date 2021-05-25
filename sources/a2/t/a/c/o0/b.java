package a2.t.a.c.o0;

import com.voximplant.sdk.call.IEndpointListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.callbacks.Callback;
import com.voximplant.sdk.internal.callbacks.EndpointCallbackController;
import com.voximplant.sdk.internal.callbacks.OnEndpointInfoUpdated;
import com.voximplant.sdk.internal.callbacks.OnEndpointRemoved;
import com.voximplant.sdk.internal.callbacks.OnRemoteVideoStreamAdded;
import com.voximplant.sdk.internal.callbacks.OnRemoteVideoStreamRemoved;
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ EndpointCallbackController a;

    public /* synthetic */ b(EndpointCallbackController endpointCallbackController) {
        this.a = endpointCallbackController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IEndpointListener iEndpointListener;
        EndpointCallbackController endpointCallbackController = this.a;
        while (!endpointCallbackController.b.isEmpty() && (iEndpointListener = endpointCallbackController.a.get()) != null) {
            Callback poll = endpointCallbackController.b.poll();
            if (poll instanceof OnRemoteVideoStreamAdded) {
                Logger.i("Invoke onRemoteVideoStreamAdded");
                OnRemoteVideoStreamAdded onRemoteVideoStreamAdded = (OnRemoteVideoStreamAdded) poll;
                iEndpointListener.onRemoteVideoStreamAdded(onRemoteVideoStreamAdded.getEndpoint(), onRemoteVideoStreamAdded.getVideoStream());
            }
            if (poll instanceof OnRemoteVideoStreamRemoved) {
                Logger.i("Invoke onRemoteVideoStreamRemoved");
                OnRemoteVideoStreamRemoved onRemoteVideoStreamRemoved = (OnRemoteVideoStreamRemoved) poll;
                iEndpointListener.onRemoteVideoStreamRemoved(onRemoteVideoStreamRemoved.getEndpoint(), onRemoteVideoStreamRemoved.getVideoStream());
            }
            if (poll instanceof OnEndpointInfoUpdated) {
                Logger.i("Invoke onEndpointInfoUpdated");
                iEndpointListener.onEndpointInfoUpdated(((OnEndpointInfoUpdated) poll).getEndpoint());
            }
            if (poll instanceof OnEndpointRemoved) {
                Logger.i("Invoke onEndpointRemoved");
                iEndpointListener.onEndpointRemoved(((OnEndpointRemoved) poll).getEndpoint());
            }
        }
    }
}
