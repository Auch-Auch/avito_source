package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
public class cl {
    @NonNull
    public final ArrayList<cm> a = new ArrayList<>();
    public int b = 60;

    @NonNull
    public static final cl bI() {
        return new cl();
    }

    public void b(@NonNull cm cmVar) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (cmVar.bO() > this.a.get(i).bO()) {
                this.a.add(i, cmVar);
                return;
            }
        }
        this.a.add(cmVar);
    }

    public int bJ() {
        return this.b;
    }

    @Nullable
    public cm bK() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.remove(0);
    }

    public boolean bL() {
        return !this.a.isEmpty();
    }

    public void r(int i) {
        this.b = i;
    }
}
