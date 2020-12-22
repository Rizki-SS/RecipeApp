package com.example.recipeapp.utility.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BookMarkDB(context: Context) : SQLiteOpenHelper(context,
    DATABASE_NAME, null,
    DATABASE_VERSION
) {

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "RecipeApp.db"

        const val TABLE = "bookmark"
        const val ID_RECIPE = "id"
        const val NAMA_RECIPE = "title"
        const val IMAGE = "image"
        const val DESCRIPTION = "description"
        const val BAHAN = "ingredients"
        const val LANGKAH = "instructions"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_RECIPE_TABLE = ("CREATE TABLE ${TABLE.toString()} ( "
                + "${ID_RECIPE.toString()} INTEGER PRIMARY KEY,"
                + "${NAMA_RECIPE.toString()} TEXT,"
                + "${IMAGE.toString()} TEXT,"
                + "${DESCRIPTION.toString()} TEXT,"
                + "${BAHAN.toString()} TEXT,"
                + "${LANGKAH.toString()} TEXT"
                + ")")
        db?.execSQL(CREATE_RECIPE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val IF_EXIT = "DROP TABLE IF EXISTS ${TABLE.toString()}"
        db?.execSQL(IF_EXIT)
    }
}