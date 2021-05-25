package com.avito.android.payment.lib.di;

import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.payment.NativeMethodsInteractor;
import com.avito.android.payment.google_pay.GooglePayInteractor;
import com.avito.android.payment.lib.PaymentGenericInteractor;
import com.avito.android.payment.lib.PaymentMethodsViewModelFactory;
import com.avito.android.payment.lib.PaymentSessionInteractor;
import com.avito.android.payment.lib.PaymentSessionType;
import com.avito.android.payment.lib.di.PaymentMethodsModule;
import com.avito.android.payment.processing.PaymentStatusPollingInteractor;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentMethodsModule_Declarations_BindViewModuleFactoryFactory implements Factory<PaymentMethodsViewModelFactory> {
    public final Provider<SchedulersFactory> a;
    public final Provider<PaymentSessionInteractor> b;
    public final Provider<NativeMethodsInteractor> c;
    public final Provider<GooglePayInteractor> d;
    public final Provider<PaymentGenericInteractor> e;
    public final Provider<PaymentStatusPollingInteractor> f;
    public final Provider<PaymentSessionType> g;
    public final Provider<TypedErrorThrowableConverter> h;
    public final Provider<DeepLinkFactory> i;

    public PaymentMethodsModule_Declarations_BindViewModuleFactoryFactory(Provider<SchedulersFactory> provider, Provider<PaymentSessionInteractor> provider2, Provider<NativeMethodsInteractor> provider3, Provider<GooglePayInteractor> provider4, Provider<PaymentGenericInteractor> provider5, Provider<PaymentStatusPollingInteractor> provider6, Provider<PaymentSessionType> provider7, Provider<TypedErrorThrowableConverter> provider8, Provider<DeepLinkFactory> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static PaymentMethodsViewModelFactory bindViewModuleFactory(SchedulersFactory schedulersFactory, PaymentSessionInteractor paymentSessionInteractor, NativeMethodsInteractor nativeMethodsInteractor, GooglePayInteractor googlePayInteractor, PaymentGenericInteractor paymentGenericInteractor, PaymentStatusPollingInteractor paymentStatusPollingInteractor, PaymentSessionType paymentSessionType, TypedErrorThrowableConverter typedErrorThrowableConverter, DeepLinkFactory deepLinkFactory) {
        return (PaymentMethodsViewModelFactory) Preconditions.checkNotNullFromProvides(PaymentMethodsModule.Declarations.bindViewModuleFactory(schedulersFactory, paymentSessionInteractor, nativeMethodsInteractor, googlePayInteractor, paymentGenericInteractor, paymentStatusPollingInteractor, paymentSessionType, typedErrorThrowableConverter, deepLinkFactory));
    }

    public static PaymentMethodsModule_Declarations_BindViewModuleFactoryFactory create(Provider<SchedulersFactory> provider, Provider<PaymentSessionInteractor> provider2, Provider<NativeMethodsInteractor> provider3, Provider<GooglePayInteractor> provider4, Provider<PaymentGenericInteractor> provider5, Provider<PaymentStatusPollingInteractor> provider6, Provider<PaymentSessionType> provider7, Provider<TypedErrorThrowableConverter> provider8, Provider<DeepLinkFactory> provider9) {
        return new PaymentMethodsModule_Declarations_BindViewModuleFactoryFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public PaymentMethodsViewModelFactory get() {
        return bindViewModuleFactory(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
