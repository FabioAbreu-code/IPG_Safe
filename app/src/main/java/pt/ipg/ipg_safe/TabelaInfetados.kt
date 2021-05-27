package pt.ipg.ipg_safe

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaInfetados(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE ${TabelaInfetados.NOME_TABELA} (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${TabelaPessoas.NUM_UTENTE} TEXT NOT NULL, ${TabelaPessoas.NOME} TEXT NOT NULL , ${TabelaPessoas.NUM_TELEMOVEL} TEXT NOT NULL, ${TabelaPessoas.EMAIL} TEXT NOT NULL, ${TabelaPessoas.MORADA} TEXT NOT NULL)")
    }

    fun insert(values: ContentValues): Long {
        return db.insert(NOME_TABELA,null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(NOME_TABELA,whereClause, whereArgs)
    }

    fun query(
            columns: Array<String>,
            selection: String?,
            selectionArgs: Array<String>?,
            groupBy: String?,
            having: String?,
            orderBy: String?
    ): Cursor? {
        return db.query(TabelaRecuperados.NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object{
        const val NOME_TABELA = "Infetados"

    }
}