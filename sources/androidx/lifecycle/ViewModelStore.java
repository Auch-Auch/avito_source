package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class ViewModelStore {
    public final HashMap<String, ViewModel> a = new HashMap<>();

    public final void clear() {
        for (ViewModel viewModel : this.a.values()) {
            viewModel.b = true;
            Map<String, Object> map = viewModel.a;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : viewModel.a.values()) {
                        if (obj instanceof Closeable) {
                            try {
                                ((Closeable) obj).close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
            viewModel.onCleared();
        }
        this.a.clear();
    }
}
