package com.google.android.gms.common;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
@ShowFirstParty
@KeepForSdk
public class FirstPartyScopes {
    @RecentlyNonNull
    @KeepForSdk
    public static final String GAMES_1P = "https://www.googleapis.com/auth/games.firstparty";

    private FirstPartyScopes() {
    }
}
