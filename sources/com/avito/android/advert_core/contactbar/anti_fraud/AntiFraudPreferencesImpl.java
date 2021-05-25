package com.avito.android.advert_core.contactbar.anti_fraud;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferencesImpl;", "Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;", "", "getAntiFraudCheckListShowCount", "()I", "count", "", "setAntiFraudCheckListShowCount", "(I)V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AntiFraudPreferencesImpl implements AntiFraudPreferences {
    public final Preferences a;

    @Inject
    public AntiFraudPreferencesImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences
    public int getAntiFraudCheckListShowCount() {
        if (1 == this.a.getInt("AntiFraudCheckListVersion", 0)) {
            return this.a.getInt("AntiFraudCheckListCount", 0);
        }
        return 0;
    }

    @Override // com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences
    public void setAntiFraudCheckListShowCount(int i) {
        this.a.putInt("AntiFraudCheckListCount", i);
        this.a.putInt("AntiFraudCheckListVersion", 1);
    }
}
