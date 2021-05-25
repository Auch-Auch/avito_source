package l6.b.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;
public class f extends CursorAdapter {
    public final int a;
    public final int b;
    public final /* synthetic */ AlertController.RecycleListView c;
    public final /* synthetic */ AlertController d;
    public final /* synthetic */ AlertController.AlertParams e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(AlertController.AlertParams alertParams, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.e = alertParams;
        this.c = recycleListView;
        this.d = alertController;
        Cursor cursor2 = getCursor();
        this.a = cursor2.getColumnIndexOrThrow(alertParams.mLabelColumn);
        this.b = cursor2.getColumnIndexOrThrow(alertParams.mIsCheckedColumn);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.a));
        AlertController.RecycleListView recycleListView = this.c;
        int position = cursor.getPosition();
        boolean z = true;
        if (cursor.getInt(this.b) != 1) {
            z = false;
        }
        recycleListView.setItemChecked(position, z);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.e.mInflater.inflate(this.d.M, viewGroup, false);
    }
}
