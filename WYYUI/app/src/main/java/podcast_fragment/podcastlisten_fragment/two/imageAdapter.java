package podcast_fragment.podcastlisten_fragment.two;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.wyyui.R;

import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ViewHolder> {

    private List<Integer> imagePathList;
    private Context context;
    private String isOneOrTwo;

    public imageAdapter(List<Integer> adapterImagePathList, Context context, String isOneOrTwo) {
        this.imagePathList = adapterImagePathList;
        this.context = context;
        this.isOneOrTwo = isOneOrTwo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.podcast_listen_two_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageButton.setBackground(context.getDrawable(imagePathList.get(position)));
    }

    @Override
    public int getItemCount() {
        return imagePathList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.image_button);
        }
    }
}
