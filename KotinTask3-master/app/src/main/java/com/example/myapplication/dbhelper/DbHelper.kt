package com.example.myapplication.dbhelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class DbHelper(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_USERS)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $USER_TABLE")
        onCreate(db)
    }

    fun addUser(
        firstname: String?,
        surname: String?,
        email: String?,
        password: String?,
        password_confirm: String?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_FIRST_NAME, firstname)
        values.put(COLUMN_SURNAME, surname)
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_PASS, password)
        values.put(COLUMN_CONFIRM_PASS, password_confirm)
        val id = db.insert(USER_TABLE, null, values)
        db.close()
        val d = Log.d(TAG, "addUser: $id")
    }

    fun getUser(
        email: String,
        password: String
    ): Boolean { //HashMap<String, String> user = new HashMap<String, String>();
        val selectQuery =
            "select * from " + USER_TABLE + " where " + COLUMN_EMAIL + " = " + "'" + email + "'" +
                    " and " + COLUMN_PASS + " = " + "'" + password + "'"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        //move to first row
        cursor.moveToFirst()
        if (cursor.count > 0) { //user.put("email", cursor.getString(1));
            return true
        }
        cursor.close()
        db.close()
        return false
    }

    companion object {
        private const val TAG = "MAINACTIVITY"
        const val DB_NAME = "myapp.db"
        const val DB_VERSION = 1
        const val USER_TABLE = "users"
        const val COLUMN_ID = "_id"
        const val COLUMN_FIRST_NAME = "firstname"
        const val COLUMN_SURNAME = "surname"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASS = "password"
        const val COLUMN_CONFIRM_PASS = "password_confirm"
        const val CREATE_TABLE_USERS =
            "CREATE TABLE " + USER_TABLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FIRST_NAME + " TEXT, " +
                    COLUMN_SURNAME + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PASS + " TEXT, " +
                    COLUMN_CONFIRM_PASS + " TEXT );"
    }
}
