package a2.l.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Iterator;
public final class r implements Iterable<View> {
    public final /* synthetic */ ViewGroup a;

    public class a implements Iterator<View> {
        public int a = 0;

        public a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < r.this.a.getChildCount();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup viewGroup = r.this.a;
            int i = this.a;
            this.a = i + 1;
            return viewGroup.getChildAt(i);
        }
    }

    public r(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<View> iterator() {
        return new a();
    }
}
