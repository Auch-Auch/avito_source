package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;
public interface ThreadUtil$BackgroundCallback<T> {
    void loadTile(int i, int i2);

    void recycleTile(TileList.Tile<T> tile);

    void refresh(int i);

    void updateRange(int i, int i2, int i3, int i4, int i5);
}
