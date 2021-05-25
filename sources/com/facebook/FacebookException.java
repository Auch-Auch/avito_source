package com.facebook;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.Random;
public class FacebookException extends RuntimeException {
    public static final long serialVersionUID = 1;

    public class a implements FeatureManager.Callback {
        public final /* synthetic */ String a;

        public a(FacebookException facebookException, String str) {
            this.a = str;
        }

        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                try {
                    ErrorReportHandler.save(this.a);
                } catch (Exception unused) {
                }
            }
        }
    }

    public FacebookException() {
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        return getMessage();
    }

    public FacebookException(String str) {
        super(str);
        Random random = new Random();
        if (str != null && FacebookSdk.isInitialized() && random.nextInt(100) > 50) {
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new a(this, str));
        }
    }

    public FacebookException(String str, Object... objArr) {
        this(String.format(str, objArr));
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }
}
