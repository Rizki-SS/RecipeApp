package com.example.recipeapp.utility.db

import android.content.ContentValues
import android.content.Context
import com.example.recipeapp.model.RecipeModel


class BookMarkDBHandle(
    private val context: Context
) {
    val dbHelper = BookMarkDB(context)

    fun create(recipe:RecipeModel){
        val db = dbHelper.writableDatabase
        val value = ContentValues().apply {
            put(BookMarkDB.ID_RECIPE, recipe.id)
            put(BookMarkDB.NAMA_RECIPE, recipe.title)
            put(BookMarkDB.DESCRIPTION, recipe.description)
            put(BookMarkDB.BAHAN, recipe.ingredients)
            put(BookMarkDB.LANGKAH, recipe.instructions)
            put(BookMarkDB.IMAGE, recipe.image)
        }
        val newRawId = db?.insert(BookMarkDB.TABLE,null,value)
    }

    fun gelAll(): MutableList<RecipeModel> {
        val recipeList: MutableList<RecipeModel> = ArrayList<RecipeModel>()
        val query = "SELECT * FROM ${BookMarkDB.TABLE}"

        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(query, null)

        with (cursor) {
            while (moveToNext()) {
//                val recipe = getString(getColumnIndexOrThrow(BaseColumns._ID))
                val recipe = RecipeModel(
                    cursor.getString(3),
                    Integer.valueOf(cursor.getString(0)),
                    cursor.getString(2),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(1)
                )
                recipeList.add(recipe)
            }
        }
        return recipeList
    }

    fun getById(id:Int):RecipeModel{
        val query = "SELECT * FROM ${BookMarkDB.TABLE} WHERE id = ${id}"

        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(query, null)

        cursor.moveToFirst();
        return RecipeModel(
            cursor.getString(3),
            Integer.valueOf(cursor.getString(0)),
            cursor.getString(2),
            cursor.getString(4),
            cursor.getString(5),
            cursor.getString(1)
        )
    }

    fun delete(id:Int){
        val db = dbHelper.writableDatabase
        val selection = "${BookMarkDB.ID_RECIPE} LIKE ${id}"
        val selectionArgs = arrayOf("id")
        val deteleRaw = db.delete(BookMarkDB.TABLE, selection,selectionArgs)
    }

//    fun update(){}
}