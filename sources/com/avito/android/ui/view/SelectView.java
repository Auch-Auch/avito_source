package com.avito.android.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.avito.android.remote.model.Entity;
@Deprecated
public class SelectView extends BaseSelectView<Entity> {
    public SelectView(Context context) {
        super(context);
    }

    public SelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public String getValueLabel(@NonNull Entity entity) {
        return entity.getName();
    }

    public SelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
