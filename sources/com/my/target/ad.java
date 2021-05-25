package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class ad extends d<cu> {
    @NonNull
    public static ad m() {
        return new ad();
    }

    @Nullable
    public cu a(@NonNull cu cuVar, @NonNull a aVar, @NonNull Context context) {
        ck cr = cuVar.cr();
        if (cr == null) {
            cl bQ = cuVar.bQ();
            if (bQ == null || !bQ.bL()) {
                return null;
            }
            return cuVar;
        }
        bo adChoices = cr.getAdChoices();
        if (adChoices == null) {
            return cuVar;
        }
        ia.b(adChoices.getIcon()).ab(context);
        return cuVar;
    }
}
