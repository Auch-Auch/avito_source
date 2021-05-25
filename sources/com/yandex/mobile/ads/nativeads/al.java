package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.ref.WeakReference;
public final class al {
    @NonNull
    private final WeakReference<View> a;
    @NonNull
    private final WeakReference<TextView> b;
    @NonNull
    private final WeakReference<TextView> c;
    @NonNull
    private final WeakReference<TextView> d;
    @NonNull
    private final WeakReference<TextView> e;
    @NonNull
    private final WeakReference<TextView> f;
    @NonNull
    private final WeakReference<ImageView> g;
    @NonNull
    private final WeakReference<Button> h;
    @NonNull
    private final WeakReference<ImageView> i;
    @NonNull
    private final WeakReference<ImageView> j;
    @NonNull
    private final WeakReference<MediaView> k;
    @NonNull
    private final WeakReference<TextView> l;
    @NonNull
    private final WeakReference<View> m;
    @NonNull
    private final WeakReference<TextView> n;
    @NonNull
    private final WeakReference<TextView> o;
    @NonNull
    private final WeakReference<TextView> p;
    @NonNull
    private final WeakReference<TextView> q;

    public static final class a {
        @NonNull
        private final View a;
        @Nullable
        private TextView b;
        @Nullable
        private TextView c;
        @Nullable
        private TextView d;
        @Nullable
        private TextView e;
        @Nullable
        private TextView f;
        @Nullable
        private ImageView g;
        @Nullable
        private Button h;
        @Nullable
        private ImageView i;
        @Nullable
        private ImageView j;
        @Nullable
        private MediaView k;
        @Nullable
        private TextView l;
        @Nullable
        private View m;
        @Nullable
        private TextView n;
        @Nullable
        private TextView o;
        @Nullable
        private TextView p;
        @Nullable
        private TextView q;

        public a(@NonNull View view) {
            this.a = view;
        }

        @NonNull
        public final al a() {
            return new al(this, (byte) 0);
        }

        @NonNull
        public final a b(@Nullable TextView textView) {
            this.c = textView;
            return this;
        }

        @NonNull
        public final a c(@Nullable TextView textView) {
            this.d = textView;
            return this;
        }

        @NonNull
        public final a d(@Nullable TextView textView) {
            this.f = textView;
            return this;
        }

        @NonNull
        public final a e(@Nullable TextView textView) {
            this.l = textView;
            return this;
        }

        @NonNull
        public final a f(@Nullable TextView textView) {
            this.n = textView;
            return this;
        }

        @NonNull
        public final a g(@Nullable TextView textView) {
            this.o = textView;
            return this;
        }

        @NonNull
        public final a h(@Nullable TextView textView) {
            this.p = textView;
            return this;
        }

        @NonNull
        public final a i(@Nullable TextView textView) {
            this.q = textView;
            return this;
        }

        @NonNull
        public final a a(@Nullable TextView textView) {
            this.b = textView;
            return this;
        }

        @NonNull
        public final a b(@Nullable ImageView imageView) {
            this.i = imageView;
            return this;
        }

        @NonNull
        public final a c(@Nullable ImageView imageView) {
            this.j = imageView;
            return this;
        }

        @NonNull
        public final a a(@Nullable ImageView imageView) {
            this.g = imageView;
            return this;
        }

        @NonNull
        public final a a(@Nullable Button button) {
            this.h = button;
            return this;
        }

        @NonNull
        public final a a(@Nullable MediaView mediaView) {
            this.k = mediaView;
            return this;
        }

        @NonNull
        public final a a(@Nullable View view) {
            this.m = view;
            return this;
        }
    }

    public /* synthetic */ al(a aVar, byte b2) {
        this(aVar);
    }

    @NonNull
    public final View a() {
        return this.a.get();
    }

    @Nullable
    public final TextView b() {
        return this.b.get();
    }

    @Nullable
    public final TextView c() {
        return this.c.get();
    }

    @Nullable
    public final TextView d() {
        return this.d.get();
    }

    @Nullable
    public final TextView e() {
        return this.e.get();
    }

    @Nullable
    public final TextView f() {
        return this.f.get();
    }

    @Nullable
    public final ImageView g() {
        return this.g.get();
    }

    @Nullable
    public final Button h() {
        return this.h.get();
    }

    @Nullable
    public final ImageView i() {
        return this.i.get();
    }

    @Nullable
    public final ImageView j() {
        return this.j.get();
    }

    @Nullable
    public final MediaView k() {
        return this.k.get();
    }

    @Nullable
    public final TextView l() {
        return this.l.get();
    }

    @Nullable
    public final View m() {
        return this.m.get();
    }

    @Nullable
    public final TextView n() {
        return this.n.get();
    }

    @Nullable
    public final TextView o() {
        return this.o.get();
    }

    @Nullable
    public final TextView p() {
        return this.p.get();
    }

    @Nullable
    public final TextView q() {
        return this.q.get();
    }

    private al(@NonNull a aVar) {
        this.a = new WeakReference<>(aVar.a);
        this.b = new WeakReference<>(aVar.b);
        this.c = new WeakReference<>(aVar.c);
        this.d = new WeakReference<>(aVar.d);
        this.e = new WeakReference<>(aVar.e);
        this.f = new WeakReference<>(aVar.f);
        this.g = new WeakReference<>(aVar.g);
        this.h = new WeakReference<>(aVar.h);
        this.i = new WeakReference<>(aVar.i);
        this.j = new WeakReference<>(aVar.j);
        this.k = new WeakReference<>(aVar.k);
        this.l = new WeakReference<>(aVar.l);
        this.m = new WeakReference<>(aVar.m);
        this.n = new WeakReference<>(aVar.n);
        this.o = new WeakReference<>(aVar.o);
        this.p = new WeakReference<>(aVar.p);
        this.q = new WeakReference<>(aVar.q);
    }
}
