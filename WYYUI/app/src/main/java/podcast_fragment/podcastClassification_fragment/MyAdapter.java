package podcast_fragment.podcastClassification_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.coolweather.wyyui.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Integer> {

    private int recourseId;
    private Context context;

    public MyAdapter(@NonNull Context context, int resource, List<Integer> imagePathList) {
        super(context, resource, imagePathList);
        this.recourseId = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder holder;
        Integer i = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(recourseId, parent, false);
            holder = new ViewHolder();
            holder.imageButton = view.findViewById(R.id.image_button);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.imageButton.setBackground(context.getDrawable(i));
        return view;
    }

    class ViewHolder {
        ImageButton imageButton;
    }
}
