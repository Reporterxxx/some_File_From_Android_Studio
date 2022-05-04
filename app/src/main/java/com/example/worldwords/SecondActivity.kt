package com.example.worldwords

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity:Activity() { //пока мы не пропишем наш класс в манифесте он не будет доступен для системы
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activivty)

        val vEdit = findViewById<EditText>(R.id.act2_edit)

        findViewById<Button>(R.id.act2_button).setOnClickListener() {
            val newStr = vEdit.text.toString() //новый объект для новой строки из окна ввода
            val i = Intent()                   //создаем хранилище копии
            i.putExtra("tag2", newStr)   //помещаем новый текст
            setResult(0,i)
            finish()
        }

        val str = intent.getStringExtra("tag1")

        vEdit.setText(str)
    }
//чтобы добавить нужно навести курсор на имя класса и нажать Alt + ENTER
}