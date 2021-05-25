package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.my.target.common.models.ImageData;
import com.my.target.gn;
import java.util.ArrayList;
import java.util.List;
public class gk extends RecyclerView.Adapter<b> {
    @NonNull
    public final Context c;
    @NonNull
    public final List<ch> d = new ArrayList();
    @Nullable
    public c e;

    public static class a extends FrameLayout {
        public int height;
        public int width;

        public a(@NonNull Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (size == 0) {
                size = this.width;
            }
            if (size2 == 0) {
                size2 = this.height;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
        }
    }

    public static class b extends RecyclerView.ViewHolder {
        @NonNull
        public final gc s;
        @NonNull
        public final FrameLayout t;

        public b(@NonNull FrameLayout frameLayout, @NonNull gc gcVar, @NonNull FrameLayout frameLayout2) {
            super(frameLayout);
            this.s = gcVar;
            this.t = frameLayout2;
        }
    }

    public interface c extends View.OnClickListener {
    }

    public gk(@NonNull Context context) {
        this.c = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        return i == this.d.size() - 1 ? 2 : 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull b bVar, int i) {
        gl glVar;
        gn.a aVar;
        b bVar2 = bVar;
        c cVar = this.e;
        if (!(cVar == null || (aVar = (glVar = gl.this).I0) == null)) {
            aVar.b(i, glVar.getContext());
        }
        ImageData imageData = null;
        ch chVar = i < this.d.size() ? this.d.get(i) : null;
        if (chVar != null) {
            imageData = chVar.getImage();
        }
        if (imageData != null) {
            bVar2.s.setPlaceholderDimensions(imageData.getWidth(), imageData.getHeight());
            Bitmap bitmap = imageData.getBitmap();
            if (bitmap != null) {
                bVar2.s.setImageBitmap(bitmap);
            } else {
                ia.a(imageData, bVar2.s);
            }
        }
        gc gcVar = bVar2.s;
        gcVar.setContentDescription("card_" + i);
        bVar2.t.setOnClickListener(this.e);
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        a aVar = new a(this.c);
        aVar.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        gc gcVar = new gc(this.c);
        io.a(gcVar, "card_media_view");
        aVar.addView(gcVar, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this.c);
        if (viewGroup.isClickable()) {
            io.a(frameLayout, 0, 1153821432);
        }
        aVar.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        return new b(aVar, gcVar, frameLayout);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull b bVar) {
        b bVar2 = bVar;
        int adapterPosition = bVar2.getAdapterPosition();
        ch chVar = (adapterPosition <= 0 || adapterPosition >= this.d.size()) ? null : this.d.get(adapterPosition);
        bVar2.s.setImageData(null);
        ImageData image = chVar != null ? chVar.getImage() : null;
        if (image != null) {
            ia.b(image, bVar2.s);
        }
        bVar2.t.setOnClickListener(null);
    }
}
