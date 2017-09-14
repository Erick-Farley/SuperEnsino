package com.example.pipeline.superensino3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erick on 19/04/2017.
 */

public class QuestoesMatDecomposicao extends SQLiteOpenHelper {

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

    public QuestoesMatDecomposicao(Context context) {
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

        Question q1=new Question("Luciano decompôs um número da seguinte forma: 3 x 100 + 2 x  10 + 1 x 6. Qual é esse número? ","302", "326", " 316", "346","326");
        this.addQuestion(q1);

        Question q2=new Question("O NÚMERO 1250 DECOMPOSTO CORRETAMENTE É:","1 UNIDADE DE MILHAR + 2 CENTENAS + 5 DEZENAS", "1 UNIDADE DE MILHAR + 2 CENTENAS + 5 DEZENAS", "1 UNIDADE DE MILHAR + 2 CENTENAS + 5 DEZENAS", "1 UNIDADE DE MILHAR + 2 CENTENAS + 5 DEZENAS","1 UNIDADE DE MILHAR + 2 CENTENAS + 5 DEZENAS");
        this.addQuestion(q2);

        Question q3=new Question("DE QUE MANEIRA ESTA DECOMPOSTA CORRETAMENTE O NUMERAL 2789?","2 UNIDADE DE MILHAR + 7 CENTENAS + 8 DEZENAS + 9 UNIDADES", "2 UNIDADE DE MILHAR + 8 CENTENAS + 7 DEZENAS + 9 UNIDADES", "2 UNIDADE DE MILHAR + 7 CENTENAS + 9 DEZENAS + 9 UNIDADES", "2 UNIDADE DE MILHAR + 7 CENTENAS + 8 DEZENAS","2 UNIDADE DE MILHAR + 7 CENTENAS + 8 DEZENAS + 9 UNIDADES");
        this.addQuestion(q3);

        Question q4=new Question("3 Unidade de Milhar + 8 centenas + 3 unidades é igual a :","3803", "3800", "3893", "3883","3803");
        this.addQuestion(q4);

        Question q5=new Question("Soraia Pensou no seguinte número: \n" +
                "•\t5 Dezenas de milhar \n" +
                "•\t3 Unidades de milhar\n" +
                "•\t2 Centenas\n" +
                "•\t4 Dezenas\n" +
                "•\t1 Unidade\n" +
                "Em que número Soraia Pensou ?\n","53.214", "52.214", "53.241", "53.211","53.241");
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
