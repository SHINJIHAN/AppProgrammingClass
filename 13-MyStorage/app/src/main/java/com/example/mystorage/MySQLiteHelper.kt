package com.example.mystorage

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLiteHelper(context: Context) : SQLiteOpenHelper(context,"mydb", null, 1) {
    // 테이블(스키마) 생성하기
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "age INTEGER)"
        db?.execSQL(sql)  // SQL 구문 실행
    }
    // 스키마 변경하기
    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS user")  // 테이블 삭제
        onCreate(db)
    }
    // user 테이블에 레코드 하나 추가하기
    fun insertUser(name: String, age: Int) {
        val db = writableDatabase  // 기록하기 위해 DB 연결
        val values = ContentValues().apply {
            put("name", name)
            put("age", age)
        }
        db.insert("user", null, values)
    }
    // user 테이블의 모든 레코드들을 가져오기
    fun getAllUsers() : List<Pair<String, Int>> { // <이름, 나이> 쌍으로 리스트 생성해서 반환
        val list = mutableListOf<Pair<String, Int>>()
        val db = readableDatabase   // 읽기용으로 db 연결
        // user 테이블의 모든 레코드 검색하기
        val cursor = db.rawQuery("SELECT name, age FROM user", null)
        cursor.use { // 검색된 레코드를 가리키는 포인터
            while (it.moveToNext()) {  // 커서가 가리키는 레코드가 있으면
                val name = it.getString(0)
                val age = it.getInt(1)
                list.add(name to age)  // <name, age> 쌍으로 리스트에 추가
            }
        }
        return list
    }
}









