package com.example.lazar.testlicnosti.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lazar.testlicnosti.R;
import com.example.lazar.testlicnosti.model.Answer;

import java.util.List;

/**
 * Adapter class for answers
 */
public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.AnswerItemViewHolder>{

    private Context context;
    private List<Answer> answers;

    public AnswersAdapter(Context context, List<Answer> answers) {
        this.context = context;
        this.answers = answers;
    }

    @Override
    public AnswerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnswersAdapter.AnswerItemViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.answer_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(AnswerItemViewHolder holder, int position) {
        holder.bind(answers.get(position));
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    /**
     * Answer view holder
     */
    class AnswerItemViewHolder extends RecyclerView.ViewHolder {

        TextView title, text;
        Answer answer;

        AnswerItemViewHolder(View itemView) {
            super(itemView);
            initViews();
        }

        private void bind(Answer answer) {
            this.answer = answer;
            title.setText(answer.getTitle());
            text.setText(answer.getText());
        }

        private void initViews() {
            title = itemView.findViewById(R.id.answer_title);
            text = itemView.findViewById(R.id.answer_text);
        }
    }
}
