package l6.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.browser.R;
import androidx.browser.browseractions.BrowserActionItem;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import androidx.core.content.res.ResourcesCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
@Deprecated
public class a extends BaseAdapter {
    public final List<BrowserActionItem> a;
    public final Context b;

    /* renamed from: l6.c.a.a$a  reason: collision with other inner class name */
    public class RunnableC0521a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ c b;
        public final /* synthetic */ ListenableFuture c;

        public RunnableC0521a(a aVar, String str, c cVar, ListenableFuture listenableFuture) {
            this.a = str;
            this.b = cVar;
            this.c = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            if (TextUtils.equals(this.a, this.b.b.getText())) {
                try {
                    bitmap = (Bitmap) this.c.get();
                } catch (InterruptedException | ExecutionException unused) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    this.b.a.setVisibility(0);
                    this.b.a.setImageBitmap(bitmap);
                    return;
                }
                this.b.a.setVisibility(4);
                this.b.a.setImageBitmap(null);
            }
        }
    }

    public class b implements Executor {
        public b(a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public static class c {
        public final ImageView a;
        public final TextView b;

        public c(ImageView imageView, TextView textView) {
            this.a = imageView;
            this.b = textView;
        }
    }

    public a(List<BrowserActionItem> list, Context context) {
        this.a = list;
        this.b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        BrowserActionItem browserActionItem = this.a.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.browser_actions_context_menu_row, (ViewGroup) null);
            ImageView imageView = (ImageView) view.findViewById(R.id.browser_actions_menu_item_icon);
            TextView textView = (TextView) view.findViewById(R.id.browser_actions_menu_item_text);
            if (imageView == null || textView == null) {
                throw new IllegalStateException("Browser Actions fallback UI does not contain necessary Views.");
            }
            cVar = new c(imageView, textView);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        String title = browserActionItem.getTitle();
        cVar.b.setText(title);
        if (browserActionItem.getIconId() != 0) {
            cVar.a.setImageDrawable(ResourcesCompat.getDrawable(this.b.getResources(), browserActionItem.getIconId(), null));
        } else if (browserActionItem.getIconUri() != null) {
            ListenableFuture<Bitmap> loadBitmap = BrowserServiceFileProvider.loadBitmap(this.b.getContentResolver(), browserActionItem.getIconUri());
            loadBitmap.addListener(new RunnableC0521a(this, title, cVar, loadBitmap), new b(this));
        } else {
            cVar.a.setImageBitmap(null);
            cVar.a.setVisibility(4);
        }
        return view;
    }
}
