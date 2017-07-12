package com.adamandeve.g7.myapplication;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener, View.OnLongClickListener, View.OnDragListener {
    ArrayList<TileModel> tileList = new ArrayList<>();

    boolean isDropSuccess = false;
    int width = 0;
    int margin = 20;
    private int oneUnit = 0;
    private int longClickedposition = 0;
    private int swappedPosition = 0;
    private CompositeView dragView;
    private FrameLayout mainLayout;
    private int count;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mainLayout = (FrameLayout) findViewById(R.id.main_layout);
        ViewTreeObserver vto = mainLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewTreeObserver obs = mainLayout.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
            }
        });
//        count = getIntent().getIntExtra("count", 0);
        count = 6;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        oneUnit = width / 20;
        if (count == 4) {
            tileList.add(new TileModel("#2080DA", "A", android.R.drawable.ic_menu_search, 1, oneUnit * 10, oneUnit * 10, 0, margin, margin, margin));
            tileList.add(new TileModel("#de3b00", "B", android.R.drawable.ic_menu_edit, 2, oneUnit * 10 - margin, oneUnit * 5, oneUnit * 10 + margin, margin, margin, margin));
            tileList.add(new TileModel("#60B117", "C", android.R.drawable.ic_menu_report_image, 3, oneUnit * 10 - margin, oneUnit * 5 - margin, oneUnit * 10 + margin, oneUnit * 5 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#DCB728", "D", android.R.drawable.ic_menu_camera, 4, oneUnit * 20, oneUnit * 6 - margin, 0, oneUnit * 10 + 2 * margin, margin, margin));
        } else if (count == 5) {
            tileList.add(new TileModel("#2080DA", "A", android.R.drawable.ic_menu_search, 1, oneUnit * 10, oneUnit * 10, 0, margin, margin, margin));
            tileList.add(new TileModel("#de3b00", "B", android.R.drawable.ic_menu_edit, 2, oneUnit * 10 - margin, oneUnit * 10, oneUnit * 10 + margin, margin, margin, margin));
            tileList.add(new TileModel("#60B117", "C", android.R.drawable.ic_menu_report_image, 3, oneUnit * 20, oneUnit * 6 - margin, 0, oneUnit * 10 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#DCB728", "D", android.R.drawable.ic_menu_camera, 4, oneUnit * 10, oneUnit * 10, 0, oneUnit * 16 + 2*margin, margin, margin));
            tileList.add(new TileModel("#FF0000", "E", R.drawable.android, 5, oneUnit * 10 - margin, oneUnit * 10, oneUnit * 10 + margin, oneUnit * 16 + 2*margin, margin, margin));
        } else if (count == 6) {

            tileList.add(new TileModel("#2080DA", "A", android.R.drawable.ic_menu_search, 1, oneUnit * 10, oneUnit * 10, 0, margin, margin, margin));
            tileList.add(new TileModel("#de3b00", "B", android.R.drawable.ic_menu_edit, 2, oneUnit * 10 - margin, oneUnit * 5, oneUnit * 10 + margin, margin, margin, margin));
            tileList.add(new TileModel("#60B117", "C", android.R.drawable.ic_menu_report_image, 3, oneUnit * 10 - margin, oneUnit * 5 - margin, oneUnit * 10 + margin, oneUnit * 5 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#60B117", "D", android.R.drawable.ic_menu_report_image, 3, oneUnit * 20, oneUnit * 6 - margin, 0, oneUnit * 10 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#DCB728", "E", android.R.drawable.ic_menu_camera, 4, oneUnit * 10, oneUnit * 10, 0, oneUnit * 16 + 2*margin, margin, margin));
            tileList.add(new TileModel("#FF0000", "F", R.drawable.android, 5, oneUnit * 10 - margin, oneUnit * 10, oneUnit * 10 + margin, oneUnit * 16 + 2*margin, margin, margin));

                   } else if (count == 7) {
            tileList.add(new TileModel("#2080DA", "A", android.R.drawable.ic_menu_search, 1, oneUnit * 12, oneUnit * 12, 0, margin, margin, margin));
            tileList.add(new TileModel("#de3b00", "B", android.R.drawable.ic_menu_edit, 2, oneUnit * 8 - margin, oneUnit * 5, oneUnit * 12 + margin, margin, margin, margin));
            tileList.add(new TileModel("#60B117", "C", android.R.drawable.ic_menu_report_image, 3, oneUnit * 8 - margin, oneUnit * 7 - margin, oneUnit * 12 + margin, oneUnit * 5 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#DCB728", "D", android.R.drawable.ic_menu_camera, 4, oneUnit * 20, oneUnit * 6 - margin, 0, oneUnit * 12 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#8A1ABE", "E", android.R.drawable.ic_menu_send, 5, oneUnit * 10, oneUnit * 7, 0, oneUnit * 18 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#32B0BF", "F", android.R.drawable.ic_menu_add, 6, oneUnit * 10, oneUnit * 7, oneUnit * 10 + margin, oneUnit * 18 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#FF0000", "G", R.drawable.android, 7, oneUnit * 20, oneUnit * 10, 0, oneUnit * 26 + margin, margin, margin));
        } else {
            tileList.add(new TileModel("#2080DA", "A", android.R.drawable.ic_menu_search, 1, oneUnit * 12, oneUnit * 12, 0, margin, margin, margin));
            tileList.add(new TileModel("#de3b00", "B", android.R.drawable.ic_menu_edit, 2, oneUnit * 8 - margin, oneUnit * 5, oneUnit * 12 + margin, margin, margin, margin));
            tileList.add(new TileModel("#60B117", "C", android.R.drawable.ic_menu_report_image, 3, oneUnit * 8 - margin, oneUnit * 7 - margin, oneUnit * 12 + margin, oneUnit * 5 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#DCB728", "D", android.R.drawable.ic_menu_camera, 4, oneUnit * 20, oneUnit * 6 - margin, 0, oneUnit * 12 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#8A1ABE", "E", android.R.drawable.ic_menu_send, 5, oneUnit * 10, oneUnit * 7, 0, oneUnit * 18 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#32B0BF", "F", android.R.drawable.ic_menu_add, 6, oneUnit * 10, oneUnit * 7, oneUnit * 10 + margin, oneUnit * 18 + 2 * margin, margin, margin));
            tileList.add(new TileModel("#FF0000", "G", R.drawable.android, 7, oneUnit * 20, oneUnit * 10, 0, oneUnit * 26 + margin, margin, margin));
            tileList.add(new TileModel("#FF0000", "H", R.drawable.android, 8, oneUnit * 20, oneUnit * 10, 0, oneUnit * 37 + margin, margin, margin));

        }
        generateView();
    }

    private void generateView() {


        for (int i = 0; i < tileList.size(); i++) {
            TileModel tileModel = tileList.get(i);
            CompositeView view = new CompositeView(this, tileModel);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            view.setOnDragListener(this);
            mainLayout.addView(view);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 1:
                Toast.makeText(this, "Pressed 1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Pressed 2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Pressed 3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "Pressed 4", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this, "Pressed 5", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(this, "Pressed 6", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(this, "Pressed 6", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        dragView = (CompositeView) view;
        longClickedposition = view.getId() - 1;
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(((CompositeView) view).getText(), mimeTypes, item);
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(data, //data to be dragged
                shadowBuilder, //drag shadow
                view, //local data about the drag and drop operation
                0   //no needed flags
        );
        view.setAlpha(0.5f);

        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                v.setAlpha(0.75f);
                break;
            case DragEvent.ACTION_DRAG_ENTERED:

                isDropSuccess = true;
                v.setAlpha(0.5f);
                break;
            case DragEvent.ACTION_DRAG_EXITED:

                isDropSuccess = false;
                v.setAlpha(0.75f);
                break;
            case DragEvent.ACTION_DROP:
                v.setAlpha(1.0f);
                if (isDropSuccess) {
                    ((CompositeView) v).setBackgroundColorHex(tileList.get(longClickedposition).getColor());
                    ((CompositeView) v).setText(tileList.get(longClickedposition).getTitle());
                    ((CompositeView) v).setIcon(tileList.get(longClickedposition).getImage());
                    swappedPosition = v.getId() - 1;
                    ((CompositeView) v).setId(tileList.get(longClickedposition).getId());
                }
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                v.setAlpha(1.0f);
                CompositeView view = (CompositeView) event.getLocalState();
                if (isDropSuccess) {
                    view.setVisibility(View.VISIBLE);
                    dragView.setBackgroundColorHex(tileList.get(swappedPosition).getColor());
                    dragView.setText(tileList.get(swappedPosition).getTitle());
                    dragView.setIcon(tileList.get(swappedPosition).getImage());
                    dragView.setId(tileList.get(swappedPosition).getId());
                }
            default:
                break;
        }
        return true;
    }

}
