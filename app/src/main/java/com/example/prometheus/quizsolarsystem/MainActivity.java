package com.example.prometheus.quizsolarsystem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String question8Answer = "Saturn";
    String quizSummaryMessage;
    String userName;


    /**
     * This method is called when the Submit button is clicked.
     */
    public void submitOnClick(View view) {

        // Find the user's name for the order
        EditText inputNameText = findViewById(R.id.inputName_textView);
        userName = inputNameText.getText().toString();

        //Checkboxes for question ONE
        CheckBox correctAnswer_CB = findViewById(R.id.q1_correctCheckB);
        boolean q1_correctAnswer = correctAnswer_CB.isChecked();
        CheckBox wrongAnswer_CB1 = findViewById(R.id.q1_wrongCheckB1);
        boolean q1_wrongAnswer = wrongAnswer_CB1.isChecked();
        CheckBox wrongAnswer_CB2 = findViewById(R.id.q1_wrongCheckB2);
        boolean q1_wrongAnswer2 = wrongAnswer_CB2.isChecked();

        //Radio button for question TWO
        RadioButton q2RB_correctAnswer = findViewById(R.id.question2_correctRButton);
        boolean q2_correctAnswer = q2RB_correctAnswer.isChecked();
        RadioButton q2RB_wrongAnswer = findViewById(R.id.question2_wrongRButton);
        boolean q2_wrongAnswer = q2RB_wrongAnswer.isChecked();

        //Checkboxes for question THREE
        CheckBox q3correctAnswer_CB = findViewById(R.id.q3_correctCheckB);
        boolean q3_correctAnswer = q3correctAnswer_CB.isChecked();
        CheckBox q3wrongAnswer_CB1 = findViewById(R.id.q3_wrongCheckB1);
        boolean q3_wrongAnswer1 = q3wrongAnswer_CB1.isChecked();
        CheckBox q3wrongAnswer_CB2 = findViewById(R.id.q3_wrongCheckB2);
        boolean q3_wrongAnswer2 = q3wrongAnswer_CB2.isChecked();

        //Checkboxes for question FOUR
        CheckBox q4correctAnswer_CB = findViewById(R.id.q4_correctCheckB);
        boolean q4_correctAnswer = q4correctAnswer_CB.isChecked();
        CheckBox q4wrongAnswer_CB1 = findViewById(R.id.q4_wrongCheckB1);
        boolean q4_wrongAnswer1 = q4wrongAnswer_CB1.isChecked();
        CheckBox q4wrongAnswer_CB2 = findViewById(R.id.q4_wrongCheckB2);
        boolean q4_wrongAnswer2 = q4wrongAnswer_CB2.isChecked();

        //Radio button for question FIVE
        RadioButton q5RB_correctAnswer = findViewById(R.id.question5_correctRButton);
        boolean q5_correctAnswer = q5RB_correctAnswer.isChecked();
        RadioButton q5RB_wrongAnswer = findViewById(R.id.question5_wrongRButton);
        boolean q5_wrongAnswer = q5RB_wrongAnswer.isChecked();

        //Checkboxes for question SIX
        CheckBox q6correctAnswer_CB = findViewById(R.id.q6_correctCheckB);
        boolean q6_correctAnswer = q6correctAnswer_CB.isChecked();
        CheckBox q6wrongAnswer_CB1 = findViewById(R.id.q6_wrongCheckB1);
        boolean q6_wrongAnswer1 = q6wrongAnswer_CB1.isChecked();
        CheckBox q6wrongAnswer_CB2 = findViewById(R.id.q6_wrongCheckB2);
        boolean q6_wrongAnswer2 = q6wrongAnswer_CB2.isChecked();

        //Radio button for question SEVEN
        RadioButton q7RB_correctAnswer = findViewById(R.id.question7_correctRButton);
        boolean q7_correctAnswer = q7RB_correctAnswer.isChecked();
        RadioButton q7RB_wrongAnswer = findViewById(R.id.question7_wrongRButton);
        boolean q7_wrongAnswer = q7RB_wrongAnswer.isChecked();

        // Input answer for question EIGHT
        EditText q8_inputAnswer = findViewById(R.id.question8Input_textView);
        String q8_correctAnswer = q8_inputAnswer.getText().toString();

        //Checkboxes for question NINE
        CheckBox q9correctAnswer_CB = findViewById(R.id.q9_correctCheckB);
        boolean q9_correctAnswer = q9correctAnswer_CB.isChecked();
        CheckBox q9wrongAnswer_CB1 = findViewById(R.id.q9_wrongCheckB1);
        boolean q9_wrongAnswer1 = q9wrongAnswer_CB1.isChecked();
        CheckBox q9wrongAnswer_CB2 = findViewById(R.id.q9_wrongCheckB2);
        boolean q9_wrongAnswer2 = q9wrongAnswer_CB2.isChecked();

        //Checkboxes for question TEN
        CheckBox q10correctAnswer_CB1 = findViewById(R.id.q10_correctCheckB1);
        boolean q10_correctAnswer1 = q10correctAnswer_CB1.isChecked();
        CheckBox q10wrongAnswer_CB1 = findViewById(R.id.q10_wrongCheckB);
        boolean q10_wrongAnswer1 = q10wrongAnswer_CB1.isChecked();
        CheckBox q10correctAnswer_CB2 = findViewById(R.id.q10_correctCheckB2);
        boolean q10_correctAnswer2 = q10correctAnswer_CB2.isChecked();

        int totalScore = calculateScore(q1_correctAnswer, q1_wrongAnswer, q1_wrongAnswer2,
                                        q2_correctAnswer, q2_wrongAnswer,
                                        q3_correctAnswer, q3_wrongAnswer1, q3_wrongAnswer2,
                                        q4_correctAnswer, q4_wrongAnswer1, q4_wrongAnswer2,
                                        q5_correctAnswer, q5_wrongAnswer,
                                        q6_correctAnswer, q6_wrongAnswer1, q6_wrongAnswer2,
                                        q7_correctAnswer, q7_wrongAnswer,
                                        q8_correctAnswer,
                                        q9_correctAnswer, q9_wrongAnswer1, q9_wrongAnswer2,
                                        q10_correctAnswer1, q10_wrongAnswer1, q10_correctAnswer2);

        String summaryMessage = createQuizSummary(userName, totalScore);
        displayScore(summaryMessage);


        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setEnabled(false);

    }

    private String createQuizSummary(String userName, int totalScore) {

        if (totalScore >= 7) {

            quizSummaryMessage = "Hello " + userName;
            quizSummaryMessage += "\nCongratulations!";
            quizSummaryMessage += "\nYou scored " + totalScore + " out of 10";
            quizSummaryMessage += "\nYou passed this quiz! \nGood job!";

            return quizSummaryMessage;

        } else  {

            quizSummaryMessage = "Name: " + userName;
            quizSummaryMessage += "\nYour score is " + totalScore;
            quizSummaryMessage += "\nYou did not pass this quiz! \n\nTry again!";

            return quizSummaryMessage;
        }
    }



    public int calculateScore(boolean q1_correctAnswer, boolean q1_wrongAnswer, boolean q1_wrongAnswer2,
                              boolean q2_correctAnswer, boolean q2_wrongAnswer,
                              boolean q3_correctAnswer, boolean q3_wrongAnswer1, boolean q3_wrongAnswer2,
                              boolean q4_correctAnswer, boolean q4_wrongAnswer1, boolean q4_wrongAnswer2,
                              boolean q5_correctAnswer, boolean q5_wrongAnswer,
                              boolean q6_correctAnswer, boolean q6_wrongAnswer1, boolean q6_wrongAnswer2,
                              boolean q7_correctAnswer, boolean q7_wrongAnswer,
                              String q8_correctAnswer,
                              boolean q9_correctAnswer, boolean q9_wrongAnswer1, boolean q9_wrongAnswer2,
                              boolean q10_correctAnswer1, boolean q10_wrongAnswer1, boolean q10_correctAnswer2) {

        int score = 0;

        //Calculating the correct answer for question ONE
        if (q1_correctAnswer & !q1_wrongAnswer & !q1_wrongAnswer2) {
            score = score + 1;

        } else if (!q1_correctAnswer & !q1_wrongAnswer & !q1_wrongAnswer2) {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 1.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question TWO
        if (q2_correctAnswer && !q2_wrongAnswer) {
            score = score + 1;

        } else {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 2.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question THREE
        if (q3_correctAnswer & !q3_wrongAnswer1 & !q3_wrongAnswer2) {
            score = score + 1;

        } else if (!q3_correctAnswer & !q3_wrongAnswer1 & !q3_wrongAnswer2) {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 3.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question FOUR
        if (q4_correctAnswer & !q4_wrongAnswer1 & !q4_wrongAnswer2) {
            score = score + 1;

        } else if (!q4_correctAnswer & !q4_wrongAnswer1 & !q4_wrongAnswer2) {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 4.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question FIVE
        if (q5_correctAnswer) {
            score = score + 1;

        } else {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 5.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question SIX
        if (q6_correctAnswer & !q6_wrongAnswer1 & !q6_wrongAnswer2) {
            score = score + 1;

        } else if (!q6_correctAnswer & !q6_wrongAnswer1 & !q6_wrongAnswer2) {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 6.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question SEVEN
        if (q7_correctAnswer) {
            score = score + 1;

        } else {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 7.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question EIGHT
        if (question8Answer.equalsIgnoreCase(q8_correctAnswer)) {
            score = score + 1;

        } else {

            Toast.makeText(getApplicationContext(), "You must enter an answer for question 8.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question NINE
        if (q9_correctAnswer & !q9_wrongAnswer1 & !q9_wrongAnswer2) {
            score = score + 1;

        } else if (!q9_correctAnswer & !q9_wrongAnswer1 & !q9_wrongAnswer2) {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 9.",
                    Toast.LENGTH_LONG).show();
        }

        //Calculating the correct answer for question TEN
        if (!q10_wrongAnswer1 & q10_correctAnswer1 & q10_correctAnswer2) {
            score = score + 1;

        } else if (!q10_wrongAnswer1 & !q10_correctAnswer1 & !q10_correctAnswer2) {

            Toast.makeText(getApplicationContext(), "You must select an answer for question 10.",
                    Toast.LENGTH_LONG).show();
        }

        return (score);
    }

    //This method is called when the user click the RESET button.

    public void resetOnClick(View view) {

//        //Resetting the input text for the user NAME
//        EditText inputNameText = findViewById(R.id.inputName_textView);
//        inputNameText.setText(" ");
//
//        //Resets question ONE
//        CheckBox correctAnswer_CB = findViewById(R.id.q1_correctCheckB);
//        correctAnswer_CB.setChecked(false);
//        CheckBox wrongAnswer_CB1 = findViewById(R.id.q1_wrongCheckB1);
//        wrongAnswer_CB1.setChecked(false);
//        CheckBox wrongAnswer_CB2 = findViewById(R.id.q1_wrongCheckB2);
//        wrongAnswer_CB2.setChecked(false);
//
//        //Resets question ONE
//        RadioButton q2RB_correctAnswer = findViewById(R.id.question2_correctRButton);
//        q2RB_correctAnswer.setChecked(false);
//
//        //Resets question THREE
//        CheckBox q3correctAnswer_CB = findViewById(R.id.q3_correctCheckB);
//        q3correctAnswer_CB.setChecked(false);
//        CheckBox q3wrongAnswer_CB1 = findViewById(R.id.q3_wrongCheckB1);
//        q3wrongAnswer_CB1.setChecked(false);
//        CheckBox q3wrongAnswer_CB2 = findViewById(R.id.q3_wrongCheckB2);
//        q3wrongAnswer_CB2.setChecked(false);
//
//        //Resets question FOUR
//        CheckBox q4correctAnswer_CB = findViewById(R.id.q4_correctCheckB);
//        q4correctAnswer_CB.setChecked(false);
//        CheckBox q4wrongAnswer_CB1 = findViewById(R.id.q4_wrongCheckB1);
//        q4wrongAnswer_CB1.setChecked(false);
//        CheckBox q4wrongAnswer_CB2 = findViewById(R.id.q4_wrongCheckB2);
//        q4wrongAnswer_CB2.setChecked(false);
//
//        //Resets question FIVE
//        RadioButton q5RB_correctAnswer = findViewById(R.id.question5_correctRButton);
//        q5RB_correctAnswer.setChecked(false);
//
//        //Resets question SIX
//        CheckBox q6correctAnswer_CB = findViewById(R.id.q6_correctCheckB);
//        q6correctAnswer_CB.setChecked(false);
//        CheckBox q6wrongAnswer_CB1 = findViewById(R.id.q6_wrongCheckB1);
//        q6wrongAnswer_CB1.setChecked(false);
//        CheckBox q6wrongAnswer_CB2 = findViewById(R.id.q6_wrongCheckB2);
//        q6wrongAnswer_CB2.setChecked(false);
//
//        //Resets question SEVEN
//        RadioButton q7RB_correctAnswer = findViewById(R.id.question7_correctRButton);
//        q7RB_correctAnswer.setChecked(false);
//
//        //Resets question EIGHT
//        EditText q8_inputAnswer = findViewById(R.id.question8Input_textView);
//        q8_inputAnswer.setText(" ");
//
//        //Resets question NINE
//        CheckBox q9correctAnswer_CB = findViewById(R.id.q9_correctCheckB);
//        q9correctAnswer_CB.setChecked(false);
//        CheckBox q9wrongAnswer_CB1 = findViewById(R.id.q9_wrongCheckB1);
//        q9wrongAnswer_CB1.setChecked(false);
//        CheckBox q9wrongAnswer_CB2 = findViewById(R.id.q9_wrongCheckB2);
//        q9wrongAnswer_CB2.setChecked(false);
//
//        //Resets question TEN
//        CheckBox q10correctAnswer_CB1 = findViewById(R.id.q10_correctCheckB1);
//        q10correctAnswer_CB1.setChecked(false);
//        CheckBox q10wrongAnswer_CB1 = findViewById(R.id.q10_wrongCheckB);
//        q10wrongAnswer_CB1.setChecked(false);
//        CheckBox q10correctAnswer_CB2 = findViewById(R.id.q10_correctCheckB2);
//        q10correctAnswer_CB2.setChecked(false);



        // This code will restart the quiz/activity
        Intent resetActivity = getIntent();
        finish();
        startActivity(resetActivity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void displayScore(String i) {
        TextView scoreView = findViewById(R.id.scoreResult_TView);
        scoreView.setText(i);
    }
}