package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;
public interface ThreadUtil$MainThreadCallback<T> {
    void addTile(int i, TileList.Tile<T> tile);

    void removeTile(int i, int i2);

    void updateItemCount(int i, int i2);
}
