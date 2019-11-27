package com.example.dataapi.view.dbhelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.submissionkotlin3.model.Favorite
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context) :
    ManagedSQLiteOpenHelper(ctx, "FavoriteTeam.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(
            Favorite.TABLE_FAVORITE, true,
            Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Favorite.ID_EVENT to TEXT + UNIQUE,
            Favorite.NAMA_EVENT to TEXT,
            Favorite.DATE_EVENT to TEXT,
            Favorite.HOME_EVENT to TEXT,
            Favorite.AWAY_EVENT to TEXT,
            Favorite.SCORE_HOME to TEXT,
            Favorite.SCORE_AWAY to TEXT,
            Favorite.IMG_HOME to TEXT,
            Favorite.IMG_AWAY to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(Favorite.TABLE_FAVORITE, true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)