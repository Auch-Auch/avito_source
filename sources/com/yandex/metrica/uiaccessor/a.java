package com.yandex.metrica.uiaccessor;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
public class a implements b {
    @NonNull
    public final AbstractC0365a a;
    @Nullable
    public FragmentManager.FragmentLifecycleCallbacks b;

    /* renamed from: com.yandex.metrica.uiaccessor.a$a  reason: collision with other inner class name */
    public interface AbstractC0365a {
    }

    public class b extends FragmentManager.FragmentLifecycleCallbacks {
        public b(a aVar, Activity activity) {
        }
    }

    public a(@NonNull AbstractC0365a aVar) throws Throwable {
        this.a = aVar;
    }

    @Override // com.yandex.metrica.uiaccessor.b
    public void a(@NonNull Activity activity) throws Throwable {
        if (activity instanceof FragmentActivity) {
            if (this.b == null) {
                this.b = new b(this, activity);
            }
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            supportFragmentManager.unregisterFragmentLifecycleCallbacks(this.b);
            supportFragmentManager.registerFragmentLifecycleCallbacks(this.b, true);
        }
    }
}
