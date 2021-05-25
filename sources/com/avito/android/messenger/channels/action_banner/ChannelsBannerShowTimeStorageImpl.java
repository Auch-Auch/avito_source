package com.avito.android.messenger.channels.action_banner;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/channels/action_banner/ChannelsBannerShowTimeStorageImpl;", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBannerShowTimeStorage;", "", "bannerId", "", "nextShowTime", "", "saveBannerShowTime", "(IJ)V", "getBannerShowTime", "(I)J", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "key", "Landroid/content/SharedPreferences;", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", "preferences", "<init>", "(Landroid/content/SharedPreferences;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsBannerShowTimeStorageImpl implements ChannelsBannerShowTimeStorage {
    public final SharedPreferences a;
    public final String b;

    public ChannelsBannerShowTimeStorageImpl(@NotNull SharedPreferences sharedPreferences, @NotNull String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        Intrinsics.checkNotNullParameter(str, "key");
        this.a = sharedPreferences;
        this.b = str;
    }

    @Override // com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorage
    public long getBannerShowTime(int i) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences.getLong(this.b + FormatterType.defaultDecimalSeparator + i, 0);
    }

    @Override // com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorage
    @SuppressLint({"ApplySharedPref"})
    public void saveBannerShowTime(int i, long j) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putLong(this.b + FormatterType.defaultDecimalSeparator + i, j).commit();
    }
}
