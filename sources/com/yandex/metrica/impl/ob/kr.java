package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class kr extends kp {
    @NonNull
    private final km a;
    @Nullable
    private final du b;

    public kr(@NonNull Context context, @NonNull km kmVar, @Nullable du duVar) {
        super(context);
        this.a = kmVar;
        this.b = duVar;
    }

    @Override // com.yandex.metrica.impl.ob.kp
    public void a(@Nullable Bundle bundle, @Nullable kn knVar) {
        this.a.a();
        du duVar = this.b;
        if (duVar != null) {
            duVar.a(a());
        }
        if (knVar != null) {
            knVar.a();
        }
    }
}
