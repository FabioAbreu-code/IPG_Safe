package pt.ipg.ipg_safe

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaNaoInfetados(db: SQLiteDatabase)  {
    private val db: SQLiteDatabase = db


    fun cria() {
        db.execSQL("CREATE TABLE ${TabelaDadosPessoais.NOME_TABELA} (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,${TabelaDadosPessoais.NOME} TEXT NOT NULL, $CAMPO_ID_DADOS_PESSOAIS INTEGER NOT NULL, FOREIGN KEY($CAMPO_ID_DADOS_PESSOAIS) REFERENCES ${TabelaDadosPessoais.NOME} )")
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
        return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }
    companion object{
        const val NOME_TABELA = "Nao_Infetados"
        const val CAMPO_ID_DADOS_PESSOAIS= "Id_Dados_Pessoais"
    }
}