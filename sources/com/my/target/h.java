package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.VideoData;
import java.util.Iterator;
public class h extends d<co> {
    @NonNull
    public static h g() {
        return new h();
    }

    @Nullable
    public co a(@NonNull co coVar, @NonNull a aVar, @NonNull Context context) {
        Iterator<cr<VideoData>> it = coVar.bS().iterator();
        while (it.hasNext()) {
            it.next().cd();
        }
        return coVar;
    }
}
