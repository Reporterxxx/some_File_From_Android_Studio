package com.example.worldwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var vText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vText = findViewById<TextView>(R.id.act1_text) //задаем интерактив, обращаясь к "generic-функции" для чего используем тип (класс нашего UI объекта) и в качестве параметра имя нашего объекта (R.id.<object_name>)
        vText.setTextColor(0xFFFF0000.toInt()) //можем задать цвет текста, отображаемого на экране
        vText.setOnClickListener {
            Log.e("tag", "НАЖАТА КНОПКА") //e - сообщение типа ошибки в Logcat, подсвечиваемое красным цветом, наиболее удобное для обнаружения
            val i = Intent(this, SecondActivity::class.java) //базовый класс Intent, используемый всегда при взаимодействии с объектами
            i.putExtra("tag1", vText.text) //помещаем данные из первого окна в intent (Hello World! - Привет, Мир!)
            //startActivity(i) //запуск второго окна
            startActivityForResult(i, 0)
        }
        Log.v("tag", "Запущен onCreate")  //всего есть три вида логирования e, v - вербальный тип логирования в Logcat, d - тип логирования, высвечиваемый в Debug
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null)                       //проверка пришли ли нам новые данные
        {
            val str = data.getStringExtra("tag2")
            vText.text = str
        }
    }

    override fun onStart() { //"callback" во время запуска экрана
        super.onStart()      // нужно только в 1% случаев, когда на экране пользователя несколько экранов не активны
    }

    override fun onResume() { //"callback" во время запуска экрана и работы приложения
        super.onResume()      //основная активность приложения происходит здесь
    }

    override fun onPause() { //как только пользователь выйдет из приложения система выдаст "onPause"
        super.onPause()      //здесь нужно остановить все что было вызвано в "onResume"
    }

    override fun onStop() { //callback симметричный "onStart", поскольку все самое важное
        super.onStop()      //останавливают в "onPause"
    }

    override fun onDestroy() { //здесь приложение оканчательно завершает работу, то есть удаляют
        super.onDestroy()      //экземпляр класса "Activity". Здесь можно удалить кэшированные данные
    }
}