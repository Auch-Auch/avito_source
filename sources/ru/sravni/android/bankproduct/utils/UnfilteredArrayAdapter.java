package ru.sravni.android.bankproduct.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0011B%\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0013\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/utils/UnfilteredArrayAdapter;", "T", "Landroid/widget/ArrayAdapter;", "Landroid/widget/Filter;", "getFilter", "()Landroid/widget/Filter;", "", "newElements", "", "setElements", "(Ljava/util/List;)V", "", "element", "", "itemToStringConverter", "(Ljava/lang/Object;)Ljava/lang/String;", "Lru/sravni/android/bankproduct/utils/UnfilteredArrayAdapter$a;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/UnfilteredArrayAdapter$a;", "filter", "Landroid/content/Context;", "context", "", "textViewResourceId", "items", "<init>", "(Landroid/content/Context;ILjava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public class UnfilteredArrayAdapter<T> extends ArrayAdapter<T> {
    public final UnfilteredArrayAdapter<T>.a a = new a();

    public final class a extends Filter {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.widget.Filter
        @NotNull
        public CharSequence convertResultToString(@Nullable Object obj) {
            return UnfilteredArrayAdapter.this.itemToStringConverter(obj);
        }

        @Override // android.widget.Filter
        @NotNull
        public Filter.FilterResults performFiltering(@Nullable CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            int count = UnfilteredArrayAdapter.this.getCount();
            filterResults.count = count;
            IntRange until = e.until(0, count);
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(until, 10));
            Iterator<T> it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(UnfilteredArrayAdapter.this.getItem(((IntIterator) it).nextInt()));
            }
            filterResults.values = arrayList;
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(@Nullable CharSequence charSequence, @Nullable Filter.FilterResults filterResults) {
            UnfilteredArrayAdapter.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnfilteredArrayAdapter(@NotNull Context context, int i, @NotNull List<? extends T> list) {
        super(context, i, CollectionsKt___CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(list, "items");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    @NotNull
    public Filter getFilter() {
        return this.a;
    }

    @NotNull
    public String itemToStringConverter(@Nullable Object obj) {
        String obj2;
        return (obj == null || (obj2 = obj.toString()) == null) ? "" : obj2;
    }

    public final void setElements(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "newElements");
        clear();
        addAll(list);
        notifyDataSetChanged();
    }
}
