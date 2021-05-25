package a2.g.k.z;

import java.util.HashMap;
public final class a extends HashMap<String, String> {
    public a() {
        put("embedding.weight", "embed.weight");
        put("dense1.weight", "fc1.weight");
        put("dense2.weight", "fc2.weight");
        put("dense3.weight", "fc3.weight");
        put("dense1.bias", "fc1.bias");
        put("dense2.bias", "fc2.bias");
        put("dense3.bias", "fc3.bias");
    }
}
