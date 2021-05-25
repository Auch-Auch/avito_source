package com.avito.android.authorization.login_protection;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.login_protection.action.PhoneListAction;
import com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatter;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import javax.inject.Provider;
public final class LoginProtectionListPresenterImpl_Factory implements Factory<LoginProtectionListPresenterImpl> {
    public final Provider<TfaInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<List<String>> c;
    public final Provider<String> d;
    public final Provider<String> e;
    public final Provider<AdapterPresenter> f;
    public final Provider<Observable<PhoneListAction>> g;
    public final Provider<LoginProtectionPhoneFormatter> h;
    public final Provider<Analytics> i;
    public final Provider<ErrorFormatter> j;
    public final Provider<Boolean> k;

    public LoginProtectionListPresenterImpl_Factory(Provider<TfaInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<List<String>> provider3, Provider<String> provider4, Provider<String> provider5, Provider<AdapterPresenter> provider6, Provider<Observable<PhoneListAction>> provider7, Provider<LoginProtectionPhoneFormatter> provider8, Provider<Analytics> provider9, Provider<ErrorFormatter> provider10, Provider<Boolean> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static LoginProtectionListPresenterImpl_Factory create(Provider<TfaInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<List<String>> provider3, Provider<String> provider4, Provider<String> provider5, Provider<AdapterPresenter> provider6, Provider<Observable<PhoneListAction>> provider7, Provider<LoginProtectionPhoneFormatter> provider8, Provider<Analytics> provider9, Provider<ErrorFormatter> provider10, Provider<Boolean> provider11) {
        return new LoginProtectionListPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static LoginProtectionListPresenterImpl newInstance(Lazy<TfaInteractor> lazy, SchedulersFactory3 schedulersFactory3, List<String> list, String str, String str2, AdapterPresenter adapterPresenter, Observable<PhoneListAction> observable, LoginProtectionPhoneFormatter loginProtectionPhoneFormatter, Analytics analytics, ErrorFormatter errorFormatter, boolean z) {
        return new LoginProtectionListPresenterImpl(lazy, schedulersFactory3, list, str, str2, adapterPresenter, observable, loginProtectionPhoneFormatter, analytics, errorFormatter, z);
    }

    @Override // javax.inject.Provider
    public LoginProtectionListPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get().booleanValue());
    }
}
