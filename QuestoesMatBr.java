package com.example.pipeline.superensino3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erick on 21/04/2017.
 */

public class QuestoesMatBr extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "onlineicttutorQuiz";

    // Table name
    private static final String TABLE_QUESTION = "question";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUESION = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd"; //option d

    private SQLiteDatabase myDatabase;

    public QuestoesMatBr(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESION
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD+" TEXT)";

        db.execSQL(sql);

        addQuestions();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);

        // Create tables again
        onCreate(db);
    }

    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    public List<Question> getAllQuestions() {

        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        myDatabase=this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOptionA(cursor.getString(3));
                quest.setOptionB(cursor.getString(4));
                quest.setOptionC(cursor.getString(5));
                quest.setOptionD(cursor.getString(6));

                quesList.add(quest);

            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    private void addQuestions()
    {
        //format is question-option1-option2-option3-option4-answer

        Question q1=new Question("Geraldo quer trocar sua nota de R$100,00 por notas de menor valor. Qual opção corresponde ao mesmo valor?  ","2 notas de R$ 20,00 e 4 notas de R$ 5,00. ", "3 notas de R$ 10,00 e 1 nota de R$ 50,00.", "3 notas de R$ 50,00 e 2 notas de R$ 10,00. ", "4 notas de R$ 20,00 e 2 notas de R$ 10,00.","4 notas de R$ 20,00 e 2 notas de R$ 10,00.");
        this.addQuestion(q1);

        Question q2=new Question("Luciana tem duas cédulas de R$5,00, quatro moedas de R$1,00, oito moedas de R$0,10 e cinco moedas de R$0,50. Somadas as cédulas e as moedas, quantos reais Luciana possui?","R$ 6,60 ", "R$ 12,30", "R$ 17,30", "R$ 19,00","R$ 17,30 ");
        this.addQuestion(q2);

        Question q3=new Question("Um feirante levou duas centenas de laranjas para vender na feira, dessas, vendeu uma centena, quatro dezenas e oito unidades. O número de laranjas que sobrou foi:","48", "52", "148", "152","148");
        this.addQuestion(q3);

        Question q4=new Question("Observe o numeral 128 784, sua decomposição é:","128+784 unidades ", "10.000+20000+700+80+4", "100+20+8+784 ", "100.000+20.000+8.000+700+80+4","100.000+20.000+8.000+700+80+4");
        this.addQuestion(q4);

        Question q5=new Question("Qual é a decomposição do número 3 358?","(3 x 100) + (3 x 100) + (5 x 10) + (8 x 1)", "(3 x 1000) + (3 x 100) + (5 x 10) + (8 x 1)", "(3 x 1000) + (3 x 100) + (5 x 100) + (8 x 1)", "(3 x 1000) + (3 x 100) + (5 x 10) + (8 x 10)"," (3 x 1000) + (3 x 100) + (5 x 10) + (8 x 1");
        this.addQuestion(q5);




    }


    // Adding new question
    public void addQuestion(Question quest) {

        ContentValues values = new ContentValues();
        values.put(KEY_QUESION, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOptionA());
        values.put(KEY_OPTB, quest.getOptionB());
        values.put(KEY_OPTC, quest.getOptionC());
        values.put(KEY_OPTD, quest.getOptionD());

        // Inserting Row
        myDatabase.insert(TABLE_QUESTION, null, values);
    }
}
