package com.avito.android.in_app_calls.service;

import android.os.IBinder;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.IncomingCallHandler;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTask;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CallManagerService_MembersInjector implements MembersInjector<CallManagerService> {
    public final Provider<CallManagerServiceDelegate> a;
    public final Provider<IBinder> b;
    public final Provider<CallManager> c;
    public final Provider<CallNotificationsDelegate> d;
    public final Provider<RingtoneDelegate> e;
    public final Provider<IncomingCallHandler> f;
    public final Provider<CallStartTask> g;

    public CallManagerService_MembersInjector(Provider<CallManagerServiceDelegate> provider, Provider<IBinder> provider2, Provider<CallManager> provider3, Provider<CallNotificationsDelegate> provider4, Provider<RingtoneDelegate> provider5, Provider<IncomingCallHandler> provider6, Provider<CallStartTask> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<CallManagerService> create(Provider<CallManagerServiceDelegate> provider, Provider<IBinder> provider2, Provider<CallManager> provider3, Provider<CallNotificationsDelegate> provider4, Provider<RingtoneDelegate> provider5, Provider<IncomingCallHandler> provider6, Provider<CallStartTask> provider7) {
        return new CallManagerService_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.service.CallManagerService.binder")
    public static void injectBinder(CallManagerService callManagerService, IBinder iBinder) {
        callManagerService.binder = iBinder;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.service.CallManagerService.callManager")
    public static void injectCallManager(CallManagerService callManagerService, CallManager callManager) {
        callManagerService.callManager = callManager;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.service.CallManagerService.callStartTasks")
    public static void injectCallStartTasks(CallManagerService callManagerService, CallStartTask callStartTask) {
        callManagerService.callStartTasks = callStartTask;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.service.CallManagerService.delegate")
    public static void injectDelegate(CallManagerService callManagerService, CallManagerServiceDelegate callManagerServiceDelegate) {
        callManagerService.delegate = callManagerServiceDelegate;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.service.CallManagerService.incomingCallHandler")
    public static void injectIncomingCallHandler(CallManagerService callManagerService, IncomingCallHandler incomingCallHandler) {
        callManagerService.incomingCallHandler = incomingCallHandler;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.service.CallManagerService.notificationsDelegate")
    public static void injectNotificationsDelegate(CallManagerService callManagerService, CallNotificationsDelegate callNotificationsDelegate) {
        callManagerService.notificationsDelegate = callNotificationsDelegate;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.service.CallManagerService.ringtoneDelegate")
    public static void injectRingtoneDelegate(CallManagerService callManagerService, RingtoneDelegate ringtoneDelegate) {
        callManagerService.ringtoneDelegate = ringtoneDelegate;
    }

    public void injectMembers(CallManagerService callManagerService) {
        injectDelegate(callManagerService, this.a.get());
        injectBinder(callManagerService, this.b.get());
        injectCallManager(callManagerService, this.c.get());
        injectNotificationsDelegate(callManagerService, this.d.get());
        injectRingtoneDelegate(callManagerService, this.e.get());
        injectIncomingCallHandler(callManagerService, this.f.get());
        injectCallStartTasks(callManagerService, this.g.get());
    }
}
