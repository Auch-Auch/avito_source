package com.avito.android.home.default_search_location;

import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorageImpl;", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;", "", "setIsChangeCoordinates", "()V", "", "isChangeCoordinates", "()Z", "Landroid/content/SharedPreferences;", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", "preferences", "<init>", "(Landroid/content/SharedPreferences;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultSearchLocationStorageImpl implements DefaultSearchLocationStorage {
    public final SharedPreferences a;

    public DefaultSearchLocationStorageImpl(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        this.a = sharedPreferences;
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationStorage
    public boolean isChangeCoordinates() {
        return this.a.getBoolean("get_coordinates", false);
    }

    @Override // com.avito.android.home.default_search_location.DefaultSearchLocationStorage
    public void setIsChangeCoordinates() {
        this.a.edit().putBoolean("get_coordinates", true).apply();
    }
}
