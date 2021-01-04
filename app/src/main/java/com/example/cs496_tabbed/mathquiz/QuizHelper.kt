package com.example.cs496_tabbed.mathquiz

import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import java.util.ArrayList

/**
 * Created by acer on 06-Apr-16.
 */
class QuizHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"
    private var dbase: SQLiteDatabase? = null
    override fun onCreate(db: SQLiteDatabase) {
        dbase = db
        val sql = ("CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)")
        db.execSQL(sql)
        addQuestion()
    }

    private fun addQuestion() {
        val q1 = Question("5+2 = ?", "7", "8", "6", "7")
        this.addQuestion(q1)
        val q2 = Question("2+18 = ?", "18", "19", "20", "20")
        this.addQuestion(q2)
        val q3 = Question("10-3 = ?", "6", "7", "8", "7")
        this.addQuestion(q3)
        val q4 = Question("5+7 = ?", "12", "13", "14", "12")
        this.addQuestion(q4)
        val q5 = Question("3-1 = ?", "1", "3", "2", "2")
        this.addQuestion(q5)
        val q6 = Question("0+1 = ?", "1", "0", "10", "1")
        this.addQuestion(q6)
        val q7 = Question("9-9 = ?", "0", "9", "1", "0")
        this.addQuestion(q7)
        val q8 = Question("3+6 = ?", "8", "7", "9", "9")
        this.addQuestion(q8)
        val q9 = Question("1+5 = ?", "6", "7", "5", "6")
        this.addQuestion(q9)
        val q10 = Question("7-5 = ?", "3", "2", "6", "2")
        this.addQuestion(q10)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldV: Int, newV: Int) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST)
        // Create tables again
        onCreate(db)
    }

    // Adding new question
    fun addQuestion(quest: Question) {
// SQLiteDatabase db = this.getWritableDatabase();
        val values = ContentValues()
        values.put(KEY_QUES, quest.qUESTION)
        values.put(KEY_ANSWER, quest.aNSWER)
        values.put(KEY_OPTA, quest.oPTA)
        values.put(KEY_OPTB, quest.oPTB)
        values.put(KEY_OPTC, quest.oPTC)
        // Inserting Row
        dbase!!.insert(TABLE_QUEST, null, values)
    }

    // Select All Query
    val allQuestions:
    // looping through all rows and adding to list
    // return quest list
            List<Question>
        get() {
            val quesList: MutableList<Question> = ArrayList()
            // Select All Query
            val selectQuery = "SELECT * FROM " + TABLE_QUEST
            dbase = this.readableDatabase
            val cursor = dbase!!.rawQuery(selectQuery, null)
            // looping through all rows and adding to list
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        val quest = Question()
                        quest.iD = cursor.getInt(0)
                        quest.qUESTION = cursor.getString(1)
                        quest.aNSWER = cursor.getString(2)
                        quest.oPTA = cursor.getString(3)
                        quest.oPTB = cursor.getString(4)
                        quest.oPTC = cursor.getString(5)
                        quesList.add(quest)
                    } while (cursor.moveToNext())
                }
            }
            // return quest list
            return quesList
        }

    companion object {
        private const val DATABASE_VERSION = 1

        // Database Name
        private const val DATABASE_NAME = "mathsone"

        // tasks table name
        private const val TABLE_QUEST = "quest"

        // tasks Table Columns names
        private const val KEY_ID = "qid"
        private const val KEY_QUES = "qUESTION"
        private const val KEY_ANSWER = "aNSWER" // correct option
        private const val KEY_OPTA = "oPTA" // option a
        private const val KEY_OPTB = "oPTB" // option b
        private const val KEY_OPTC = "oPTC" // option c
    }
}