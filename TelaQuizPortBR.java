package com.example.pipeline.superensino3;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaQuizPortBR extends AppCompatActivity {

    private List<Question> questionsList;
    private Question currentQuestion;

    private TextView txtQuestion,tvNoOfQs;
    private RadioButton rbtnA, rbtnB, rbtnC,rbtnD;
    private Button btnNext;

    private int obtainedScore=0;
    private int questionId=0;

    private int answeredQsNo=0;

    ArrayList<String> myAnsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_quiz_port);

        //Initialize the view
        init();

        //Initialize the database
        final QuestoesPortDigrafo dbAdapter=new QuestoesPortDigrafo(this);
        questionsList= dbAdapter.getAllQuestions();
        currentQuestion=questionsList.get(questionId);

        //Set question
        setQuestionsView();

        //Check and Next
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());

                Log.e("Answer ID", "Selected Positioned  value - "+grp.getCheckedRadioButtonId());

                if(answer!=null){
                    Log.e("Answer", currentQuestion.getANSWER() + " -- " + answer.getText());
                    //Add answer to the list
                    myAnsList.add(""+answer.getText());

                    if(currentQuestion.getANSWER().equals(answer.getText())){
                        obtainedScore++;
                        Log.e("comments", "Correct Answer");
                        Log.d("score", "Obtained score " + obtainedScore);
                    }else{
                        Log.e("comments", "Wrong Answer");
                    }
                    if(questionId<dbAdapter.rowCount()){
                        currentQuestion=questionsList.get(questionId);
                        setQuestionsView();
                    }else{
                        Intent intent = new Intent(TelaQuizPortBR.this, TelaResultado.class);

                        Bundle b = new Bundle();
                        b.putInt("score", obtainedScore);
                        b.putInt("totalQs", questionsList.size());
                        b.putStringArrayList("myAnsList", myAnsList);
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();

                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Escolha uma resposta por favor", Toast.LENGTH_LONG).show();
                }

                //Need to clear the checked item id
                grp.clearCheck();


            }//end onClick Method
        });
    }

    public void init(){
        tvNoOfQs=(TextView)findViewById(R.id.tvNumberOfQuestions);
        txtQuestion=(TextView)findViewById(R.id.tvQuestion);
        rbtnA=(RadioButton)findViewById(R.id.radio0);
        rbtnB=(RadioButton)findViewById(R.id.radio1);
        rbtnC=(RadioButton)findViewById(R.id.radio2);
        rbtnD=(RadioButton)findViewById(R.id.radio3);

        btnNext=(Button)findViewById(R.id.btnNext);

        myAnsList = new ArrayList<String>();
    }


    private void setQuestionsView()
    {
        rbtnA.setChecked(false);
        rbtnB.setChecked(false);
        rbtnC.setChecked(false);
        rbtnD.setChecked(false);

        answeredQsNo=questionId+1;
        tvNoOfQs.setText("Questão "+answeredQsNo+" de "+questionsList.size());

        txtQuestion.setText(currentQuestion.getQUESTION());
        rbtnA.setText(currentQuestion.getOptionA());
        rbtnB.setText(currentQuestion.getOptionB());
        rbtnC.setText(currentQuestion.getOptionC());
        rbtnD.setText(currentQuestion.getOptionD());

        questionId++;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
