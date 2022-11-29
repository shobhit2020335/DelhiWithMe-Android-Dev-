package Adapter;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dwm.R;
import com.example.dwm.cinemahall;
import com.example.dwm.hangout;
import com.example.dwm.local_market;
import com.example.dwm.mall;
import com.example.dwm.restaurant;
import com.example.dwm.travel;

public class homeAdapter extends RecyclerView.Adapter<homeAdapter.viewHolder> {


    static String[] data;
    int[] img;
    static Context context;
    private ItemClickListener mitemClickListener;

    public homeAdapter(String[] data, int[] img,ItemClickListener itemClickListener) {
        this.data = data;
        this.img = img;
        this.mitemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_home, parent, false);
        context = parent.getContext();
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.textView.setText(data[position]);
        holder.imageView.setImageResource(img[position]);
        holder.textView.setOnClickListener(view->{
            mitemClickListener.onItemclick(position);
        });



    }

    @Override
    public int getItemCount() {
        return data.length;
    }
    public interface ItemClickListener{
        void onItemclick(int  index);
    }

    static class viewHolder extends RecyclerView.ViewHolder {
        de.hdodenhof.circleimageview.CircleImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.circleImageView);
            textView = itemView.findViewById(R.id.cat_heading);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
//                        if (pos == 1) {
//                            Intent intent = new Intent(context, cinemahall.class);
//                            context.startActivity(intent);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        }

//                        Toast.makeText(v.getContext(), "You clicked " + data[pos], Toast.LENGTH_SHORT).show();
                    }
//                    if (pos == 0) {
////                        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
////                        getFragmentManager()
////                                .beginTransaction()
////                                .replace(R.id.homelayout, )
////                                .commit();
//                        Intent intent = new Intent(context, hangout.class);
//                        context.startActivity(intent);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    }

//                    } else if (pos == 2) {
//                        Intent intent = new Intent(context, restaurant.class);
//                        context.startActivity(intent);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    } else if (pos == 3) {
//                        Intent intent = new Intent(context, mall.class);
//                        context.startActivity(intent);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    } else if (pos == 4) {
//                        Intent intent = new Intent(context, local_market.class);
//                        context.startActivity(intent);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    } else {
//                        Intent intent = new Intent(context, travel.class);
//                        context.startActivity(intent);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    }
                }
            });
//            imageView.setOnClickListener((View.OnClickListener) this);
        }
    }
}
