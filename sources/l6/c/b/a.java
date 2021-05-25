package l6.c.b;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsSessionToken;
public final /* synthetic */ class a implements IBinder.DeathRecipient {
    public final /* synthetic */ CustomTabsService.a a;
    public final /* synthetic */ CustomTabsSessionToken b;

    public /* synthetic */ a(CustomTabsService.a aVar, CustomTabsSessionToken customTabsSessionToken) {
        this.a = aVar;
        this.b = customTabsSessionToken;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        CustomTabsService.a aVar = this.a;
        CustomTabsService.this.cleanUpSession(this.b);
    }
}
