package com.avito.android.code_confirmation;

import android.app.Activity;
import android.content.IntentFilter;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CodeReceiverImpl_Factory implements Factory<CodeReceiverImpl> {
    public final Provider<Activity> a;
    public final Provider<IntentFilter> b;
    public final Provider<SmsRetrieverClient> c;

    public CodeReceiverImpl_Factory(Provider<Activity> provider, Provider<IntentFilter> provider2, Provider<SmsRetrieverClient> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CodeReceiverImpl_Factory create(Provider<Activity> provider, Provider<IntentFilter> provider2, Provider<SmsRetrieverClient> provider3) {
        return new CodeReceiverImpl_Factory(provider, provider2, provider3);
    }

    public static CodeReceiverImpl newInstance(Activity activity, IntentFilter intentFilter, SmsRetrieverClient smsRetrieverClient) {
        return new CodeReceiverImpl(activity, intentFilter, smsRetrieverClient);
    }

    @Override // javax.inject.Provider
    public CodeReceiverImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
