package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.f;
import com.yandex.metrica.j;
public class vn {
    @NonNull
    public j a(@NonNull j jVar) {
        return dl.a(jVar.maxReportsInDatabaseCount) ? j.a(jVar).e(a(jVar.maxReportsInDatabaseCount, jVar.apiKey)).b() : jVar;
    }

    @NonNull
    public f a(@NonNull f fVar) {
        return dl.a(fVar.maxReportsInDatabaseCount) ? f.a(fVar).d(a(fVar.maxReportsInDatabaseCount, fVar.apiKey)).b() : fVar;
    }

    private int a(@Nullable Integer num, @NonNull String str) {
        if (num.intValue() < 100) {
            abd.a(str).b("Value passed as maxReportsInDatabaseCount is invalid. Should be greater than or equal to %d, but was: %d. Default value (%d) will be used", 100, num, 100);
            return 100;
        } else if (num.intValue() <= 10000) {
            return num.intValue();
        } else {
            abd.a(str).b("Value passed as maxReportsInDatabaseCount is invalid. Should be less than or equal to %d, but was: %d. Default value (%d) will be used", 10000, num, 10000);
            return 10000;
        }
    }
}
