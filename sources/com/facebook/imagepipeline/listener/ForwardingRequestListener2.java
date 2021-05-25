package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
public class ForwardingRequestListener2 implements RequestListener2 {
    public final List<RequestListener2> a;

    public ForwardingRequestListener2(Set<RequestListener2> set) {
        this.a = new ArrayList(set.size());
        for (RequestListener2 requestListener2 : set) {
            if (requestListener2 != null) {
                this.a.add(requestListener2);
            }
        }
    }

    public void addRequestListener(RequestListener2 requestListener2) {
        this.a.add(requestListener2);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(ProducerContext producerContext, String str, String str2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onProducerEvent(producerContext, str, str2);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onProducerFinishWithCancellation(producerContext, str, map);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onProducerFinishWithFailure(producerContext, str, th, map);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onProducerFinishWithSuccess(producerContext, str, map);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(ProducerContext producerContext, String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onProducerStart(producerContext, str);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(ProducerContext producerContext) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onRequestCancellation(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(ProducerContext producerContext, Throwable th) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onRequestFailure(producerContext, th);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(ProducerContext producerContext) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onRequestStart(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(ProducerContext producerContext) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onRequestSuccess(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(ProducerContext producerContext, String str, boolean z) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).onUltimateProducerReached(producerContext, str, z);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(ProducerContext producerContext, String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).requiresExtraMap(producerContext, str)) {
                return true;
            }
        }
        return false;
    }

    public ForwardingRequestListener2(RequestListener2... requestListener2Arr) {
        this.a = new ArrayList(requestListener2Arr.length);
        for (RequestListener2 requestListener2 : requestListener2Arr) {
            if (requestListener2 != null) {
                this.a.add(requestListener2);
            }
        }
    }
}
