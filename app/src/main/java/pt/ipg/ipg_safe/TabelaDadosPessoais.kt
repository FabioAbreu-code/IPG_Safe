package pt.ipg.ipg_safe

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaDadosPessoais(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria(){
        db.execSQL("CREATE TABLE $NOME_TABELA (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,$NOME TEXT NOT NULL, $SEXO TEXT NOT NULL, $DATA_NASCIMENTO  TEXT NOT NULL, $NUM_UTENTE INTEGER NOT NULL, $NUM_TELEMOVEL INTEGER NOT NULL, $EMAIL TEXT NOT NULL, $MORADA TEXT NOT NULL)")
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
        const val NOME_TABELA = "Dados_Pessoas"
        const val NOME = "Nome"
        const val SEXO = "Sexo"
        const val DATA_NASCIMENTO = "Data_de_Nascimento"
        const val NUM_UTENTE = "Número_de_Utente"
        const val NUM_TELEMOVEL = "Nome"
        const val EMAIL = "Sexo"
        const val MORADA = "Data_de_Nascimento"
    }

}