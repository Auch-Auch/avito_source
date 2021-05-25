package com.avito.android.favorites.event;

import androidx.annotation.Nullable;
import com.avito.android.remote.model.Error;
import com.avito.android.util.AvitoResponseException;
public class FavoriteUpdateEvent {
    public static final FavoriteUpdateEvent ITEM_ADDED_EVENT = new FavoriteUpdateEvent(0, null);
    public static final int ITEM_ADDED_STATE = 0;
    public static final FavoriteUpdateEvent ITEM_REMOVED_EVENT = new FavoriteUpdateEvent(1, null);
    public static final int ITEM_REMOVED_STATE = 1;
    public static final int UPDATE_ERROR_STATE = 2;
    @Nullable
    public final AvitoResponseException mException;
    public final int mState;

    public FavoriteUpdateEvent(int i, Error error) {
        this.mState = i;
        this.mException = new AvitoResponseException(error);
    }

    public static FavoriteUpdateEvent added() {
        return ITEM_ADDED_EVENT;
    }

    public static FavoriteUpdateEvent error(Error error) {
        return new FavoriteUpdateEvent(2, error);
    }

    public static FavoriteUpdateEvent removed() {
        return ITEM_REMOVED_EVENT;
    }

    @Nullable
    public AvitoResponseException getException() {
        return this.mException;
    }
}
