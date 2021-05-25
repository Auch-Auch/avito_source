package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.IParamsCallback;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public class xj implements xm {
    private static final IIdentifierCallback a = new IIdentifierCallback() { // from class: com.yandex.metrica.impl.ob.xj.1
        @Override // com.yandex.metrica.IIdentifierCallback
        public void onReceive(Map<String, String> map) {
        }

        @Override // com.yandex.metrica.IIdentifierCallback
        public void onRequestError(IIdentifierCallback.Reason reason) {
        }
    };
    @NonNull
    private final AtomicReference<IIdentifierCallback> b;

    /* renamed from: com.yandex.metrica.impl.ob.xj$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            IParamsCallback.Reason.values();
            int[] iArr = new int[4];
            a = iArr;
            try {
                IParamsCallback.Reason reason = IParamsCallback.Reason.NETWORK;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                IParamsCallback.Reason reason2 = IParamsCallback.Reason.INVALID_RESPONSE;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public xj(@NonNull IIdentifierCallback iIdentifierCallback) {
        this.b = new AtomicReference<>(iIdentifierCallback);
    }

    @Override // com.yandex.metrica.impl.ob.xm
    public void a(Map<String, String> map) {
        this.b.getAndSet(a).onReceive(map);
    }

    @Override // com.yandex.metrica.impl.ob.xm
    public void a(@NonNull IParamsCallback.Reason reason, Map<String, String> map) {
        this.b.getAndSet(a).onRequestError(a(reason));
    }

    @NonNull
    private IIdentifierCallback.Reason a(@NonNull IParamsCallback.Reason reason) {
        int i = AnonymousClass2.a[reason.ordinal()];
        if (i == 1) {
            return IIdentifierCallback.Reason.NETWORK;
        }
        if (i != 2) {
            return IIdentifierCallback.Reason.UNKNOWN;
        }
        return IIdentifierCallback.Reason.INVALID_RESPONSE;
    }
}
