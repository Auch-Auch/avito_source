package l6.b.d;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.facebook.common.util.UriUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
@SuppressLint({"RestrictedAPI"})
public class p extends ResourceCursorAdapter implements View.OnClickListener {
    public static final /* synthetic */ int q = 0;
    public final SearchView d;
    public final SearchableInfo e;
    public final Context f;
    public final WeakHashMap<String, Drawable.ConstantState> g;
    public final int h;
    public int i = 1;
    public ColorStateList j;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public int p = -1;

    public static final class a {
        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public a(View view) {
            this.a = (TextView) view.findViewById(16908308);
            this.b = (TextView) view.findViewById(16908309);
            this.c = (ImageView) view.findViewById(16908295);
            this.d = (ImageView) view.findViewById(16908296);
            this.e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    public p(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.d = searchView;
        this.e = searchableInfo;
        this.h = searchView.getSuggestionCommitIconResId();
        this.f = context;
        this.g = weakHashMap;
    }

    public static String e(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception unused) {
            return null;
        }
    }

    public Drawable b(Uri uri) throws FileNotFoundException {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException(a2.b.a.a.a.W2("Single path segment is not a resource ID: ", uri));
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException(a2.b.a.a.a.W2("More than two path segments: ", uri));
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    throw new FileNotFoundException(a2.b.a.a.a.W2("No resource found for: ", uri));
                }
                throw new FileNotFoundException(a2.b.a.a.a.W2("No path: ", uri));
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException(a2.b.a.a.a.W2("No package found for authority: ", uri));
            }
        } else {
            throw new FileNotFoundException(a2.b.a.a.a.W2("No authority: ", uri));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v6, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012d  */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(android.view.View r19, android.content.Context r20, android.database.Cursor r21) {
        /*
        // Method dump skipped, instructions count: 418
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.b.d.p.bindView(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    public final Drawable c(String str) {
        Drawable drawable;
        Uri parse;
        InputStream openInputStream;
        Drawable drawable2;
        Drawable drawable3 = null;
        if (str != null && !str.isEmpty() && !"0".equals(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                String str2 = "android.resource://" + this.f.getPackageName() + "/" + parseInt;
                Drawable.ConstantState constantState = this.g.get(str2);
                if (constantState == null) {
                    drawable2 = null;
                } else {
                    drawable2 = constantState.newDrawable();
                }
                if (drawable2 != null) {
                    return drawable2;
                }
                Drawable drawable4 = ContextCompat.getDrawable(this.f, parseInt);
                if (drawable4 != null) {
                    this.g.put(str2, drawable4.getConstantState());
                }
                return drawable4;
            } catch (NumberFormatException unused) {
                Drawable.ConstantState constantState2 = this.g.get(str);
                if (constantState2 == null) {
                    drawable = null;
                } else {
                    drawable = constantState2.newDrawable();
                }
                if (drawable != null) {
                    return drawable;
                }
                parse = Uri.parse(str);
                try {
                    if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(parse.getScheme())) {
                        try {
                            drawable3 = b(parse);
                        } catch (Resources.NotFoundException unused2) {
                            throw new FileNotFoundException("Resource does not exist: " + parse);
                        }
                    } else {
                        openInputStream = this.f.getContentResolver().openInputStream(parse);
                        if (openInputStream != null) {
                            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                            try {
                                openInputStream.close();
                            } catch (IOException unused3) {
                                String str3 = "Error closing icon stream for " + parse;
                            }
                            drawable3 = createFromStream;
                        } else {
                            throw new FileNotFoundException("Failed to open " + parse);
                        }
                    }
                } catch (FileNotFoundException e2) {
                    String str4 = "Icon not found: " + parse + ", " + e2.getMessage();
                }
                if (drawable3 != null) {
                    this.g.put(str, drawable3.getConstantState());
                }
            } catch (Resources.NotFoundException unused4) {
                return null;
            } catch (Throwable th) {
                try {
                    openInputStream.close();
                } catch (IOException unused5) {
                    String str5 = "Error closing icon stream for " + parse;
                }
                throw th;
            }
        }
        return drawable3;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, l6.i.a.a.AbstractC0528a
    public void changeCursor(Cursor cursor) {
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.k = cursor.getColumnIndex("suggest_text_1");
                this.l = cursor.getColumnIndex("suggest_text_2");
                this.m = cursor.getColumnIndex("suggest_text_2_url");
                this.n = cursor.getColumnIndex("suggest_icon_1");
                this.o = cursor.getColumnIndex("suggest_icon_2");
                this.p = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, l6.i.a.a.AbstractC0528a
    public CharSequence convertToString(Cursor cursor) {
        String e2;
        String e3;
        if (cursor == null) {
            return null;
        }
        String e4 = e(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (e4 != null) {
            return e4;
        }
        if (this.e.shouldRewriteQueryFromData() && (e3 = e(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return e3;
        }
        if (!this.e.shouldRewriteQueryFromText() || (e2 = e(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return e2;
    }

    public Cursor d(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public final void f(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            View newDropDownView = newDropDownView(this.mContext, this.mCursor, viewGroup);
            if (newDropDownView != null) {
                ((a) newDropDownView.getTag()).a.setText(e2.toString());
            }
            return newDropDownView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            View newView = newView(this.mContext, this.mCursor, viewGroup);
            ((a) newView.getTag()).a.setText(e2.toString());
            return newView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new a(newView));
        ((ImageView) newView.findViewById(R.id.edit_query)).setImageResource(this.h);
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        f(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        f(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.d.p((CharSequence) tag);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, l6.i.a.a.AbstractC0528a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.d.getVisibility() == 0 && this.d.getWindowVisibility() == 0) {
            try {
                Cursor d2 = d(this.e, charSequence2, 50);
                if (d2 != null) {
                    d2.getCount();
                    return d2;
                }
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }
}
