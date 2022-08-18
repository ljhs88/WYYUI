package find_fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.wyyui.R;

import java.util.List;

public class buttonAdapter extends RecyclerView.Adapter<buttonAdapter.ViewHolder> {

    private List<String> buttonTextList;
    private List<Integer> buttonImagePathList;
    private Context context;

    public buttonAdapter(List<String> buttonTextList, List<Integer> buttonImagePathList, Context context) {
        this.buttonTextList = buttonTextList;
        this.buttonImagePathList = buttonImagePathList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_recycler_view_one, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(buttonTextList.get(position));
        holder.button.setBackground(context.getDrawable(buttonImagePathList.get(position)));
    }

    @Override
    public int getItemCount() {
        return buttonTextList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button button;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            textView =itemView.findViewById(R.id.text);
        }
    }
}
