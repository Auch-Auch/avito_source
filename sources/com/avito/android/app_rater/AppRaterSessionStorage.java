package com.avito.android.app_rater;

import com.avito.android.remote.model.AppRaterSession;
import com.avito.android.util.preferences.SessionContract;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/app_rater/AppRaterSessionStorage;", "", "Lcom/avito/android/remote/model/AppRaterSession;", SessionContract.SESSION, "", "saveAppRaterSession", "(Lcom/avito/android/remote/model/AppRaterSession;)V", "getLastSession", "()Lcom/avito/android/remote/model/AppRaterSession;", "lastSession", "app-rater_release"}, k = 1, mv = {1, 4, 2})
public interface AppRaterSessionStorage {
    @NotNull
    AppRaterSession getLastSession();

    void saveAppRaterSession(@NotNull AppRaterSession appRaterSession);
}
