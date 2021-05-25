package com.avito.android.profile;

import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.preferences.ProfileContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile/PrefProfileInfoStorage;", "Lcom/avito/android/profile/MutableProfileInfoStorage;", "Lcom/avito/android/remote/model/ProfileInfo;", "profileInfo", "", "saveProfileInfo", "(Lcom/avito/android/remote/model/ProfileInfo;)V", "removeProfileInfo", "()V", "getProfileInfo", "()Lcom/avito/android/remote/model/ProfileInfo;", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "profile-info_release"}, k = 1, mv = {1, 4, 2})
public final class PrefProfileInfoStorage implements MutableProfileInfoStorage {
    public final Preferences a;

    public PrefProfileInfoStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.profile.ProfileInfoStorage
    @NotNull
    public ProfileInfo getProfileInfo() {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences();
        ProfileContract profileContract = ProfileContract.INSTANCE;
        return new ProfileInfo(sharedPreferences.getString(profileContract.getID(), null), sharedPreferences.getString(profileContract.getNAME(), null), sharedPreferences.getString(profileContract.getEMAIL(), null), sharedPreferences.getString(profileContract.getIMAGE(), null));
    }

    @Override // com.avito.android.profile.MutableProfileInfoStorage
    public void removeProfileInfo() {
        SharedPreferences.Editor edit = this.a.getSharedPreferences().edit();
        ProfileContract profileContract = ProfileContract.INSTANCE;
        edit.remove(profileContract.getID()).remove(profileContract.getNAME()).remove(profileContract.getEMAIL()).remove(profileContract.getPHONE()).remove(profileContract.getLOCATION_ID()).remove(profileContract.getMETRO_ID()).remove(profileContract.getDISTRICT_ID()).remove(profileContract.getIMAGE()).apply();
    }

    @Override // com.avito.android.profile.MutableProfileInfoStorage
    public void saveProfileInfo(@NotNull ProfileInfo profileInfo) {
        Intrinsics.checkNotNullParameter(profileInfo, "profileInfo");
        SharedPreferences.Editor edit = this.a.getSharedPreferences().edit();
        ProfileContract profileContract = ProfileContract.INSTANCE;
        edit.putString(profileContract.getID(), profileInfo.getUserId()).putString(profileContract.getNAME(), profileInfo.getName()).putString(profileContract.getEMAIL(), profileInfo.getEmail()).putString(profileContract.getIMAGE(), profileInfo.getImage()).apply();
    }
}
