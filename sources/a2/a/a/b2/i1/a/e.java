package a2.a.a.b2.i1.a;

import com.avito.android.profile.tfa.settings.TfaSettingsViewImpl;
import com.avito.android.util.text.TextViewsKt;
public final class e implements Runnable {
    public final /* synthetic */ TfaSettingsViewImpl a;

    public e(TfaSettingsViewImpl tfaSettingsViewImpl) {
        this.a = tfaSettingsViewImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextViewsKt.setAttributedText$default(this.a.c, TfaSettingsViewImpl.access$getDescriptionText$p(this.a), null, 2, null);
    }
}
