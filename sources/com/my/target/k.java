package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.AudioData;
import java.util.Iterator;
public class k extends d<cp> {
    @NonNull
    public static k h() {
        return new k();
    }

    @Nullable
    public cp a(@NonNull cp cpVar, @NonNull a aVar, @NonNull Context context) {
        Iterator<cr<AudioData>> it = cpVar.bV().iterator();
        while (it.hasNext()) {
            it.next().cd();
        }
        return cpVar;
    }
}
