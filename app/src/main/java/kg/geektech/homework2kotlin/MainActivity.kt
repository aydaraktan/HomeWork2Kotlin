package kg.geektech.homework2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.homework2kotlin.databinding.ActivityMainBinding
import kg.geektech.homework2kotlin.databinding.ActivityMainBinding.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        val urls = mutableListOf("https://yablyk.com/wp-content/uploads/2018/04/shoten-links.jpg","https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_03.jpg","https://bipbap.ru/wp-content/uploads/2017/04/kuukktsk.jpg",
        "https://russianblogs.com/images/103/69f223e82b33c342199241d463664907.png","https://ktonanovenkogo.ru/image/sokrashchenie-ssilok.jpg")

        binding.random.setOnClickListener {
            val random = Random().nextInt(urls.size)
            binding.imageView.load(urls[random])
        }

        val url = binding.editText.text

        binding.submit.setOnClickListener {
            if(url.isBlank()){
                showToast(getString(R.string.url))
            }else{
            urls.add(url.toString())
            binding.editText.text = null}
        }
    }
}
