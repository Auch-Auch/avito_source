package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.p;
import com.yandex.metrica.impl.ob.qm;
public class to {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final Integer c;
    @Nullable
    public final Integer d;
    @Nullable
    public final Integer e;
    @Nullable
    public final Long f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final al.a j;
    @Nullable
    public final Integer k;
    @Nullable
    public final String l;
    @Nullable
    public final String m;
    @Nullable
    public final Integer n;
    @Nullable
    public final Integer o;
    @Nullable
    public final String p;
    @Nullable
    public final String q;
    @Nullable
    public final String r;
    @NonNull
    public final acl s;
    @Nullable
    public final ap t;
    @Nullable
    public final p.a.EnumC0340a u;
    @Nullable
    public final qm.a v;

    public to(@NonNull ContentValues contentValues) {
        al.a aVar;
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger == null) {
            aVar = null;
        } else {
            aVar = al.a.a(asInteger.intValue());
        }
        this.j = aVar;
        this.k = contentValues.getAsInteger("custom_type");
        this.a = contentValues.getAsString("name");
        this.b = contentValues.getAsString("value");
        this.f = contentValues.getAsLong("time");
        this.c = contentValues.getAsInteger("number");
        this.d = contentValues.getAsInteger("global_number");
        this.e = contentValues.getAsInteger("number_of_type");
        this.h = contentValues.getAsString("cell_info");
        this.g = contentValues.getAsString("location_info");
        this.i = contentValues.getAsString("wifi_network_info");
        this.l = contentValues.getAsString("error_environment");
        this.m = contentValues.getAsString("user_info");
        this.n = contentValues.getAsInteger("truncated");
        this.o = contentValues.getAsInteger("connection_type");
        this.p = contentValues.getAsString("cellular_connection_type");
        this.q = contentValues.getAsString("wifi_access_point");
        this.r = contentValues.getAsString("profile_id");
        this.s = acl.a(contentValues.getAsInteger("encrypting_mode"));
        this.t = ap.a(contentValues.getAsInteger("first_occurrence_status"));
        this.u = p.a.EnumC0340a.a(contentValues.getAsInteger("battery_charge_type"));
        this.v = qm.a.a(contentValues.getAsString("collection_mode"));
    }
}
