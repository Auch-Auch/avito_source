package com.avito.android.user_advert.advert;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertStorageImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertStorage;", "", "incrementAdvertsForCallsCreated", "()V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "", "getAdvertsForCallsCreated", "()I", "advertsForCallsCreated", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "Companion", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertStorageImpl implements MyAdvertStorage {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Preferences a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertStorageImpl$Companion;", "", "", "ADVERTS_NUMBER_CREATED", "Ljava/lang/String;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public MyAdvertStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertStorage
    public int getAdvertsForCallsCreated() {
        return this.a.getInt("adverts_for_calls_created_number", 0);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertStorage
    public void incrementAdvertsForCallsCreated() {
        this.a.putInt("adverts_for_calls_created_number", getAdvertsForCallsCreated() + 1);
    }
}
