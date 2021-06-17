package QuizAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.AddQuestions;
import com.example.quizapp.AllQuestions;
import com.example.quizapp.CreateTestSection;
import com.example.quizapp.R;
import com.example.quizapp.TestSetting;

import java.util.ArrayList;

import Modelspojo.Quizmodel;

public class Quizadapter extends RecyclerView.Adapter<Quizadapter.viewHolder> {

    ArrayList<Quizmodel> list;
    Context context;

    public Quizadapter(ArrayList<Quizmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recyclerview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Quizmodel quizmodel = list.get(position);
        holder.imageView.setImageResource(quizmodel.getPic());
        holder.textView.setText(quizmodel.getText());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Reccler_ImageBtn);
            textView = itemView.findViewById(R.id.Recycler_text_btn);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            // Toast.makeText(context, "position"+position, Toast.LENGTH_SHORT).show();

            // Intent intent=new Intent(context, CreateTestSection.class);
            //context.startActivity(intent);

            if (position == 0) {
                    Toast.makeText(context, "Add Question"+position, Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(context, AddQuestions.class);
                context.startActivity(intent1);
            }
            else if (position == 1) {
                  Toast.makeText(context, "All Question"+position, Toast.LENGTH_SHORT).show();
                Intent intent2= new Intent(context, AllQuestions.class);
                context.startActivity(intent2);
            }
            else if (position == 2) {
                  Toast.makeText(context, "Test Setting"+position, Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(context, TestSetting.class);
                context.startActivity(intent3);
            }
            else if (position==3){
                 Toast.makeText(context, "Create Test Section"+position, Toast.LENGTH_SHORT).show();

                Intent intent4 = new Intent(context, CreateTestSection.class);
                context.startActivity(intent4);
            }

        }
    }
}

