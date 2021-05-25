package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.profile.UserProfile;
import java.util.Map;
public class vp implements IReporter {
    public static final adw<String> a = new ads(new adq("Event name"));
    public static final adw<String> b = new ads(new adq("Error message"));
    public static final adw<Throwable> c = new ads(new adr("Unhandled exception"));
    public static final adw<UserProfile> d = new ads(new adr("User profile"));
    public static final adw<Revenue> e = new ads(new adr("Revenue"));

    @Override // com.yandex.metrica.IReporter
    public void pauseSession() {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(@NonNull String str, @Nullable Throwable th) throws adt {
        b.a(str);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull String str) throws adt {
        a.a(str);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(@NonNull Revenue revenue) throws adt {
        e.a(revenue);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(@NonNull Throwable th) throws adt {
        c.a(th);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(@NonNull UserProfile userProfile) throws adt {
        d.a(userProfile);
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
    }

    @Override // com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(boolean z) {
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(@Nullable String str) {
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull String str, @Nullable String str2) throws adt {
        a.a(str);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(@NonNull String str, @Nullable Map<String, Object> map) throws adt {
        a.a(str);
    }
}
