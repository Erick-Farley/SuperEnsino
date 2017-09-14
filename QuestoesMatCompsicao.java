package com.example.pipeline.superensino3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erick on 17/04/2017.
 */

public class QuestoesMatCompsicao extends SQLiteOpenHelper {
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

    public QuestoesMatCompsicao(Context context) {
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

        Question q1=new Question("A população de Corumbá, no Mato Grosso do Sul, é de 95.704 habitantes. O número de pessoas que moram em Corumbá escrito por extenso é:","Noventa e cinco mil setecentos e quatro habitantes", "Noventa e cinco mil e setenta e quatro habitantes ", "2", "1","4");
        this.addQuestion(q1);

        Question q2=new Question("Um garoto completou 1.960 bolinhas de gude em sua coleção. Esse número é composto de:","1 unidade de milhar, 9 dezenas e 6 unidades", "1 unidade de milhar, 9 centenas e 6 dezenas. ", "1 unidade de milhar, 60 unidades. ", "1 unidade de milhar, 90 unidades. ","1 unidade de milhar, 9 centenas e 6 dezenas. ");
        this.addQuestion(q2);

        Question q3=new Question("A professora de João pediu para ele decompor um número e ele fez da seguinte forma:   4 x 1000 + 3 x 10 + 5 x 1. Qual foi o número pedido?","4035", "4305", "5034", "5304","4035");
        this.addQuestion(q3);

        Question q4=new Question("Somando 2 centenas + 3 dezenas + 5 unidades, obtemos:","235", "255", "325", "253","235");
        this.addQuestion(q4);

        Question q5=new Question("Compondo o número 2000 + 50 + 5. Obtemos: ","2555", "2055", "20575", "2052","2055");
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

