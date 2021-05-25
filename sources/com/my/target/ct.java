package com.my.target;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
public class ct extends cn {
    @NonNull
    public final String b;
    @NonNull
    public final ArrayList<cj> c = new ArrayList<>();
    @NonNull
    public final ArrayList<Pair<String, String>> d = new ArrayList<>();
    @Nullable
    public JSONObject e;
    public boolean f;
    @Nullable
    public String g;
    @Nullable
    public String h;
    @Nullable
    public String i;
    @Nullable
    public String j;
    @Nullable
    public String k;
    @Nullable
    public String l;

    public ct(@NonNull String str) {
        this.b = str;
    }

    @NonNull
    public static ct A(@NonNull String str) {
        return new ct(str);
    }

    public void B(@Nullable String str) {
        this.h = str;
    }

    public void C(@Nullable String str) {
        this.i = str;
    }

    public void D(@Nullable String str) {
        this.j = str;
    }

    public void E(@Nullable String str) {
        this.k = str;
    }

    public void F(@Nullable String str) {
        this.l = str;
    }

    @Nullable
    public String G(@NonNull String str) {
        Iterator<Pair<String, String>> it = this.d.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (str.equals(next.first)) {
                return (String) next.second;
            }
        }
        return null;
    }

    public void a(@NonNull cj cjVar) {
        this.c.add(cjVar);
    }

    public void c(@Nullable JSONObject jSONObject) {
        this.e = jSONObject;
    }

    @NonNull
    public List<cj> ca() {
        return new ArrayList(this.c);
    }

    @Nullable
    public JSONObject ci() {
        return this.e;
    }

    @NonNull
    public ArrayList<Pair<String, String>> cj() {
        return this.d;
    }

    @Nullable
    public String ck() {
        return this.h;
    }

    @Nullable
    public String cl() {
        return this.i;
    }

    @Nullable
    public String cm() {
        return this.j;
    }

    @Nullable
    public String cn() {
        return this.k;
    }

    @Nullable
    public String co() {
        return this.l;
    }

    @Override // com.my.target.cn
    public int getBannersCount() {
        return this.c.size();
    }

    @NonNull
    public String getName() {
        return this.b;
    }

    @Nullable
    public String getTitle() {
        return this.g;
    }

    public boolean isCached() {
        return this.f;
    }

    public void s(boolean z) {
        this.f = z;
    }

    public void setTitle(@Nullable String str) {
        this.g = str;
    }
}
