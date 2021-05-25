package a2.j.b.e.a.b;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.tasks.Task;
import java.util.List;
public interface q2 {
    Task<List<String>> a();

    Task<ParcelFileDescriptor> a(int i, String str, String str2, int i2);

    void a(int i);

    void a(int i, String str);

    void a(String str);

    void a(List<String> list);

    void b();

    void b(int i, String str, String str2, int i2);

    Task<AssetPackStates> c(List<String> list, List<String> list2);

    Task<AssetPackStates> d(List<String> list, x xVar);
}
