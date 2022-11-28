package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dwm.R;
import com.example.dwm.User;
import com.example.dwm.comment;
import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
//import com.example.dwm.databinding.CommentsampleBinding;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class commentAdapter extends RecyclerView.Adapter<commentAdapter.viewholder> {
   Context context;
   ArrayList<comment> commentArrayList;


    public commentAdapter(Context context, ArrayList<comment> commentArrayList) {
        this.context = context;
        this.commentArrayList = commentArrayList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.commentsample,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        comment cmmnt=commentArrayList.get(position);
        String text= TimeAgo.using(cmmnt.getCommentedat());
        holder.text.setText(commentArrayList.get(position).getCommentbody());
        holder.time.setText(text);
        FirebaseDatabase.getInstance().getReference().child("users").child(cmmnt.getCommentedby()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user=snapshot.getValue(User.class);
                Picasso.get().load(user.getProfilephoto())
                        .placeholder(R.drawable.defaultuser)
                        .into(holder.circleImageView);
                holder.name.setText(user.getName());

                if(snapshot.hasChild("liveindelhi")) {
                    if (snapshot.child("liveindelhi").getValue().equals("yes")) {
                        holder.dlbadge.setVisibility(View.VISIBLE);
                    } else if (snapshot.child("liveindelhi").getValue().equals("no")) {
                        holder.dlbadge.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView name;
        TextView text;
        TextView time;
        ImageView dlbadge;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.commentname);
            text=itemView.findViewById(R.id.commentText);
            time=itemView.findViewById(R.id.commentTime);
            circleImageView=itemView.findViewById(R.id.commentimg);
            dlbadge=itemView.findViewById(R.id.dlbadge);


        }
    }
}

