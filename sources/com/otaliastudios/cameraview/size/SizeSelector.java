package com.otaliastudios.cameraview.size;

import androidx.annotation.NonNull;
import java.util.List;
public interface SizeSelector {
    @NonNull
    List<Size> select(@NonNull List<Size> list);
}
