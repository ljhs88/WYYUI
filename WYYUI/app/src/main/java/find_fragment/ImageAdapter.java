package find_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.wyyui.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<Integer> imagePathList;
    private List<String> titleList;
    private Context context;

    public ImageAdapter(List<Integer> imagePathList, List<String> titleList, Context context) {
        this.imagePathList = imagePathList;
        this.titleList = titleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_recycler_view_two, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        holder.button.setBackground(context.getDrawable(imagePathList.get(position)));
        holder.textView.setText(titleList.get(position));
    }

    @Override
    public int getItemCount() {
        return imagePathList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
