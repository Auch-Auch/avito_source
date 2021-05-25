package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.b;
public class l extends b<bs> {

    public static class a implements b.a<bs> {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        @Override // com.my.target.b.a
        public boolean a() {
            return false;
        }

        @Override // com.my.target.b.a
        @NonNull
        public c<bs> b() {
            return m.a(this.a);
        }

        @Override // com.my.target.b.a
        @Nullable
        public d<bs> c() {
            return null;
        }

        @Override // com.my.target.b.a
        @NonNull
        public e d() {
            return n.b(this.a);
        }
    }

    public interface b extends b.AbstractC0305b {
    }

    public l(a aVar, int i) {
        super(new a(i), aVar);
    }

    @NonNull
    public static b<bs> a(@NonNull a aVar, int i) {
        return new l(aVar, i);
    }
}
