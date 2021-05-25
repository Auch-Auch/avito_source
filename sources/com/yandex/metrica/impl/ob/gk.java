package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.fk;
import com.yandex.metrica.impl.ob.fn;
public interface gk<C extends fn & fk> {
    @NonNull
    fl c(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yc ycVar);

    @NonNull
    C d(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yc ycVar);
}
