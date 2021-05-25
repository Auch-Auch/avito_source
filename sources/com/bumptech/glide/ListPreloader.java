package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    public final int a;
    public final b b;
    public final RequestManager c;
    public final PreloadModelProvider<T> d;
    public final PreloadSizeProvider<T> e;
    public int f;
    public int g;
    public int h = -1;
    public int i;
    public boolean j = true;

    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t, int i, int i2);
    }

    public static final class a implements Target<Object> {
        public int a;
        public int b;
        @Nullable
        public Request c;

        @Override // com.bumptech.glide.request.target.Target
        @Nullable
        public Request getRequest() {
            return this.c;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.b, this.a);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(@Nullable Request request) {
            this.c = request;
        }
    }

    public static final class b {
        public final Queue<a> a;

        public b(int i) {
            this.a = Util.createQueue(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.a.offer(new a());
            }
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager, @NonNull PreloadModelProvider<T> preloadModelProvider, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i2) {
        this.c = requestManager;
        this.d = preloadModelProvider;
        this.e = preloadSizeProvider;
        this.a = i2;
        this.b = new b(i2 + 1);
    }

    public final void a(int i2, boolean z) {
        int i3;
        int i4;
        if (this.j != z) {
            this.j = z;
            for (int i5 = 0; i5 < this.b.a.size(); i5++) {
                RequestManager requestManager = this.c;
                b bVar = this.b;
                a poll = bVar.a.poll();
                bVar.a.offer(poll);
                poll.b = 0;
                poll.a = 0;
                requestManager.clear(poll);
            }
        }
        int i6 = (z ? this.a : -this.a) + i2;
        if (i2 < i6) {
            i3 = Math.max(this.f, i2);
            i4 = i6;
        } else {
            i4 = Math.min(this.g, i2);
            i3 = i6;
        }
        int min = Math.min(this.i, i4);
        int min2 = Math.min(this.i, Math.max(0, i3));
        if (i2 < i6) {
            for (int i7 = min2; i7 < min; i7++) {
                b(this.d.getPreloadItems(i7), i7, true);
            }
        } else {
            for (int i8 = min - 1; i8 >= min2; i8--) {
                b(this.d.getPreloadItems(i8), i8, false);
            }
        }
        this.g = min2;
        this.f = min;
    }

    public final void b(List<T> list, int i2, boolean z) {
        int size = list.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                c(list.get(i3), i2, i3);
            }
            return;
        }
        for (int i4 = size - 1; i4 >= 0; i4--) {
            c(list.get(i4), i2, i4);
        }
    }

    public final void c(@Nullable T t, int i2, int i3) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t != null && (preloadSize = this.e.getPreloadSize(t, i2, i3)) != null && (preloadRequestBuilder = this.d.getPreloadRequestBuilder(t)) != null) {
            b bVar = this.b;
            int i4 = preloadSize[0];
            int i5 = preloadSize[1];
            a poll = bVar.a.poll();
            bVar.a.offer(poll);
            poll.b = i4;
            poll.a = i5;
            preloadRequestBuilder.into((RequestBuilder<?>) poll);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.i = i4;
        int i5 = this.h;
        if (i2 > i5) {
            a(i3 + i2, true);
        } else if (i2 < i5) {
            a(i2, false);
        }
        this.h = i2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
