package a2.g.v.m;

import android.view.View;
import com.facebook.share.widget.LikeView;
public class b implements View.OnClickListener {
    public final /* synthetic */ LikeView a;

    public b(LikeView likeView) {
        this.a = likeView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LikeView.a(this.a);
    }
}
