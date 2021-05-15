package pt.ipg.ipg_safe

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaDadosPessoais(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria(){
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_NOME_COMPLETO + " TEXT NOT NULL, " +
                CAMPO_ENDEREÇO_EMAIL+ " TEXT NOT NULL, " +
                CAMPO_NUMERO_TELEMOVEL+ " TEXT NOT NULL, " +
                CAMPO_ID_AGUARDA_RESULTADO + " INTEGER, " +
                CAMPO_ID_RESULTADO + " INTEGER, " +
                " FOREIGN KEY ("+ CAMPO_ID_AGUARDA_RESULTADO +") " +
                " REFERENCES " + TabelaAguardaResultados.NOME_TABELA +
                " FOREIGN KEY ("+ CAMPO_ID_RESULTADO +") " +
                " REFERENCES " + TabelaResultadosPositivos.NOME_TABELA +
                ")"
        )

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
        selection: String,
        selectionArgs: Array<String>,
        groupBy: String,
        having: String,
        orderBy: String
    ): Cursor? {
        return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object{
        const val NOME_TABELA = "dadosPessoais"
        const val CAMPO_ENDEREÇO_EMAIL = "email"
        const val CAMPO_NUMERO_TELEMOVEL = "telemovel"
        const val CAMPO_NOME_COMPLETO = "nome"
        const val CAMPO_ID_AGUARDA_RESULTADO = "id_aguarda_resultado"
        const val CAMPO_ID_RESULTADO = "id_resultado"
    }

}