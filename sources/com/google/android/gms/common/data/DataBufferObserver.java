package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
public interface DataBufferObserver {

    public interface Observable {
        void addObserver(@RecentlyNonNull DataBufferObserver dataBufferObserver);

        void removeObserver(@RecentlyNonNull DataBufferObserver dataBufferObserver);
    }

    void onDataChanged();

    void onDataRangeChanged(@RecentlyNonNull int i, @RecentlyNonNull int i2);

    void onDataRangeInserted(@RecentlyNonNull int i, @RecentlyNonNull int i2);

    void onDataRangeMoved(@RecentlyNonNull int i, @RecentlyNonNull int i2, @RecentlyNonNull int i3);

    void onDataRangeRemoved(@RecentlyNonNull int i, @RecentlyNonNull int i2);
}
